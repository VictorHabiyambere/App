package io.grpc.internal;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

public class MessageFramer implements Framer {
    private static final byte COMPRESSED = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int NO_MAX_OUTBOUND_MESSAGE_SIZE = -1;
    private static final byte UNCOMPRESSED = 0;
    private WritableBuffer buffer;
    /* access modifiers changed from: private */
    public final WritableBufferAllocator bufferAllocator;
    private boolean closed;
    private Compressor compressor = Codec.Identity.NONE;
    private int currentMessageSeqNo = -1;
    private long currentMessageWireSize;
    private final ByteBuffer headerScratch = ByteBuffer.allocate(5);
    private int maxOutboundMessageSize = -1;
    private boolean messageCompression = true;
    private int messagesBuffered;
    private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter();
    private final Sink sink;
    private final StatsTraceContext statsTraceCtx;

    public interface Sink {
        void deliverFrame(@Nullable WritableBuffer writableBuffer, boolean z, boolean z2, int i);
    }

    public MessageFramer(Sink sink2, WritableBufferAllocator bufferAllocator2, StatsTraceContext statsTraceCtx2) {
        this.sink = (Sink) Preconditions.checkNotNull(sink2, "sink");
        this.bufferAllocator = (WritableBufferAllocator) Preconditions.checkNotNull(bufferAllocator2, "bufferAllocator");
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx2, "statsTraceCtx");
    }

    public MessageFramer setCompressor(Compressor compressor2) {
        this.compressor = (Compressor) Preconditions.checkNotNull(compressor2, "Can't pass an empty compressor");
        return this;
    }

    public MessageFramer setMessageCompression(boolean enable) {
        this.messageCompression = enable;
        return this;
    }

    public void setMaxOutboundMessageSize(int maxSize) {
        Preconditions.checkState(this.maxOutboundMessageSize == -1, "max size already set");
        this.maxOutboundMessageSize = maxSize;
    }

    public void writePayload(InputStream message) {
        int written;
        verifyNotClosed();
        boolean z = true;
        this.messagesBuffered++;
        this.currentMessageSeqNo++;
        this.currentMessageWireSize = 0;
        this.statsTraceCtx.outboundMessage(this.currentMessageSeqNo);
        if (!this.messageCompression || this.compressor == Codec.Identity.NONE) {
            z = false;
        }
        boolean compressed = z;
        try {
            int messageLength = getKnownLength(message);
            if (messageLength == 0 || !compressed) {
                written = writeUncompressed(message, messageLength);
            } else {
                written = writeCompressed(message, messageLength);
            }
            if (messageLength == -1 || written == messageLength) {
                this.statsTraceCtx.outboundUncompressedSize((long) written);
                this.statsTraceCtx.outboundWireSize(this.currentMessageWireSize);
                this.statsTraceCtx.outboundMessageSent(this.currentMessageSeqNo, this.currentMessageWireSize, (long) written);
                return;
            }
            throw Status.INTERNAL.withDescription(String.format("Message length inaccurate %s != %s", new Object[]{Integer.valueOf(written), Integer.valueOf(messageLength)})).asRuntimeException();
        } catch (IOException e) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e).asRuntimeException();
        } catch (RuntimeException e2) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e2).asRuntimeException();
        }
    }

    private int writeUncompressed(InputStream message, int messageLength) throws IOException {
        if (messageLength != -1) {
            this.currentMessageWireSize = (long) messageLength;
            return writeKnownLengthUncompressed(message, messageLength);
        }
        BufferChainOutputStream bufferChain = new BufferChainOutputStream();
        int written = writeToOutputStream(message, bufferChain);
        if (this.maxOutboundMessageSize < 0 || written <= this.maxOutboundMessageSize) {
            writeBufferChain(bufferChain, false);
            return written;
        }
        throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(written), Integer.valueOf(this.maxOutboundMessageSize)})).asRuntimeException();
    }

    /* JADX INFO: finally extract failed */
    private int writeCompressed(InputStream message, int unusedMessageLength) throws IOException {
        BufferChainOutputStream bufferChain = new BufferChainOutputStream();
        OutputStream compressingStream = this.compressor.compress(bufferChain);
        try {
            int written = writeToOutputStream(message, compressingStream);
            compressingStream.close();
            if (this.maxOutboundMessageSize < 0 || written <= this.maxOutboundMessageSize) {
                writeBufferChain(bufferChain, true);
                return written;
            }
            throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(written), Integer.valueOf(this.maxOutboundMessageSize)})).asRuntimeException();
        } catch (Throwable th) {
            compressingStream.close();
            throw th;
        }
    }

    private int getKnownLength(InputStream inputStream) throws IOException {
        if ((inputStream instanceof KnownLength) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private int writeKnownLengthUncompressed(InputStream message, int messageLength) throws IOException {
        if (this.maxOutboundMessageSize < 0 || messageLength <= this.maxOutboundMessageSize) {
            this.headerScratch.clear();
            this.headerScratch.put((byte) 0).putInt(messageLength);
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(this.headerScratch.position() + messageLength);
            }
            writeRaw(this.headerScratch.array(), 0, this.headerScratch.position());
            return writeToOutputStream(message, this.outputStreamAdapter);
        }
        throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "message too large %d > %d", new Object[]{Integer.valueOf(messageLength), Integer.valueOf(this.maxOutboundMessageSize)})).asRuntimeException();
    }

    private void writeBufferChain(BufferChainOutputStream bufferChain, boolean compressed) {
        int messageLength = bufferChain.readableBytes();
        this.headerScratch.clear();
        this.headerScratch.put(compressed).putInt(messageLength);
        WritableBuffer writeableHeader = this.bufferAllocator.allocate(5);
        writeableHeader.write(this.headerScratch.array(), 0, this.headerScratch.position());
        if (messageLength == 0) {
            this.buffer = writeableHeader;
            return;
        }
        this.sink.deliverFrame(writeableHeader, false, false, this.messagesBuffered - 1);
        this.messagesBuffered = 1;
        List<WritableBuffer> bufferList = bufferChain.bufferList;
        for (int i = 0; i < bufferList.size() - 1; i++) {
            this.sink.deliverFrame(bufferList.get(i), false, false, 0);
        }
        this.buffer = bufferList.get(bufferList.size() - 1);
        this.currentMessageWireSize = (long) messageLength;
    }

    private static int writeToOutputStream(InputStream message, OutputStream outputStream) throws IOException {
        if (message instanceof Drainable) {
            return ((Drainable) message).drainTo(outputStream);
        }
        long written = ByteStreams.copy(message, outputStream);
        Preconditions.checkArgument(written <= 2147483647L, "Message size overflow: %s", written);
        return (int) written;
    }

    /* access modifiers changed from: private */
    public void writeRaw(byte[] b, int off, int len) {
        while (len > 0) {
            if (this.buffer != null && this.buffer.writableBytes() == 0) {
                commitToSink(false, false);
            }
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(len);
            }
            int toWrite = Math.min(len, this.buffer.writableBytes());
            this.buffer.write(b, off, toWrite);
            off += toWrite;
            len -= toWrite;
        }
    }

    public void flush() {
        if (this.buffer != null && this.buffer.readableBytes() > 0) {
            commitToSink(false, true);
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void close() {
        if (!isClosed()) {
            this.closed = true;
            if (this.buffer != null && this.buffer.readableBytes() == 0) {
                releaseBuffer();
            }
            commitToSink(true, true);
        }
    }

    public void dispose() {
        this.closed = true;
        releaseBuffer();
    }

    private void releaseBuffer() {
        if (this.buffer != null) {
            this.buffer.release();
            this.buffer = null;
        }
    }

    private void commitToSink(boolean endOfStream, boolean flush) {
        WritableBuffer buf = this.buffer;
        this.buffer = null;
        this.sink.deliverFrame(buf, endOfStream, flush, this.messagesBuffered);
        this.messagesBuffered = 0;
    }

    private void verifyNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private class OutputStreamAdapter extends OutputStream {
        private OutputStreamAdapter() {
        }

        public void write(int b) {
            write(new byte[]{(byte) b}, 0, 1);
        }

        public void write(byte[] b, int off, int len) {
            MessageFramer.this.writeRaw(b, off, len);
        }
    }

    private final class BufferChainOutputStream extends OutputStream {
        /* access modifiers changed from: private */
        public final List<WritableBuffer> bufferList;
        private WritableBuffer current;

        private BufferChainOutputStream() {
            this.bufferList = new ArrayList();
        }

        public void write(int b) throws IOException {
            if (this.current == null || this.current.writableBytes() <= 0) {
                write(new byte[]{(byte) b}, 0, 1);
                return;
            }
            this.current.write((byte) b);
        }

        public void write(byte[] b, int off, int len) {
            if (this.current == null) {
                this.current = MessageFramer.this.bufferAllocator.allocate(len);
                this.bufferList.add(this.current);
            }
            while (len > 0) {
                int canWrite = Math.min(len, this.current.writableBytes());
                if (canWrite == 0) {
                    this.current = MessageFramer.this.bufferAllocator.allocate(Math.max(len, this.current.readableBytes() * 2));
                    this.bufferList.add(this.current);
                } else {
                    this.current.write(b, off, canWrite);
                    off += canWrite;
                    len -= canWrite;
                }
            }
        }

        /* access modifiers changed from: private */
        public int readableBytes() {
            int readable = 0;
            for (WritableBuffer writableBuffer : this.bufferList) {
                readable += writableBuffer.readableBytes();
            }
            return readable;
        }
    }
}
