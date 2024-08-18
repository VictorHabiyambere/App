package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframer;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.io.Closeable;
import java.io.InputStream;

public abstract class AbstractStream implements Stream {
    /* access modifiers changed from: protected */
    public abstract Framer framer();

    /* access modifiers changed from: protected */
    public abstract TransportState transportState();

    public void optimizeForDirectExecutor() {
        transportState().optimizeForDirectExecutor();
    }

    public final void setMessageCompression(boolean enable) {
        framer().setMessageCompression(enable);
    }

    public final void request(int numMessages) {
        transportState().requestMessagesFromDeframer(numMessages);
    }

    public final void writeMessage(InputStream message) {
        Preconditions.checkNotNull(message, "message");
        try {
            if (!framer().isClosed()) {
                framer().writePayload(message);
            }
        } finally {
            GrpcUtil.closeQuietly((Closeable) message);
        }
    }

    public final void flush() {
        if (!framer().isClosed()) {
            framer().flush();
        }
    }

    /* access modifiers changed from: protected */
    public final void endOfMessages() {
        framer().close();
    }

    public final void setCompressor(Compressor compressor) {
        framer().setCompressor((Compressor) Preconditions.checkNotNull(compressor, "compressor"));
    }

    public boolean isReady() {
        return transportState().isReady();
    }

    /* access modifiers changed from: protected */
    public final void onSendingBytes(int numBytes) {
        transportState().onSendingBytes(numBytes);
    }

    public static abstract class TransportState implements ApplicationThreadDeframer.TransportExecutor, MessageDeframer.Listener {
        public static final int DEFAULT_ONREADY_THRESHOLD = 32768;
        private boolean allocated;
        private boolean deallocated;
        /* access modifiers changed from: private */
        public Deframer deframer;
        private int numSentBytesQueued;
        private final Object onReadyLock = new Object();
        private final MessageDeframer rawDeframer;
        private final StatsTraceContext statsTraceCtx;
        private final TransportTracer transportTracer;

        /* access modifiers changed from: protected */
        public abstract StreamListener listener();

        protected TransportState(int maxMessageSize, StatsTraceContext statsTraceCtx2, TransportTracer transportTracer2) {
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceCtx2, "statsTraceCtx");
            this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer2, "transportTracer");
            this.rawDeframer = new MessageDeframer(this, Codec.Identity.NONE, maxMessageSize, statsTraceCtx2, transportTracer2);
            this.deframer = this.rawDeframer;
        }

        /* access modifiers changed from: package-private */
        public final void optimizeForDirectExecutor() {
            this.rawDeframer.setListener(this);
            this.deframer = this.rawDeframer;
        }

        /* access modifiers changed from: protected */
        public void setFullStreamDecompressor(GzipInflatingBuffer fullStreamDecompressor) {
            this.rawDeframer.setFullStreamDecompressor(fullStreamDecompressor);
            this.deframer = new ApplicationThreadDeframer(this, this, this.rawDeframer);
        }

        /* access modifiers changed from: package-private */
        public final void setMaxInboundMessageSize(int maxSize) {
            this.deframer.setMaxInboundMessageSize(maxSize);
        }

        public void messagesAvailable(StreamListener.MessageProducer producer) {
            listener().messagesAvailable(producer);
        }

        /* access modifiers changed from: protected */
        public final void closeDeframer(boolean stopDelivery) {
            if (stopDelivery) {
                this.deframer.close();
            } else {
                this.deframer.closeWhenComplete();
            }
        }

        /* access modifiers changed from: protected */
        public final void deframe(ReadableBuffer frame) {
            try {
                this.deframer.deframe(frame);
            } catch (Throwable t) {
                deframeFailed(t);
            }
        }

        /* access modifiers changed from: private */
        public void requestMessagesFromDeframer(final int numMessages) {
            if (this.deframer instanceof ThreadOptimizedDeframer) {
                TaskCloseable ignore = PerfMark.traceTask("AbstractStream.request");
                try {
                    this.deframer.request(numMessages);
                    if (ignore != null) {
                        ignore.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                final Link link = PerfMark.linkOut();
                runOnTransportThread(new Runnable() {
                    public void run() {
                        TaskCloseable ignore;
                        try {
                            ignore = PerfMark.traceTask("AbstractStream.request");
                            PerfMark.linkIn(link);
                            TransportState.this.deframer.request(numMessages);
                            if (ignore != null) {
                                ignore.close();
                                return;
                            }
                            return;
                        } catch (Throwable t) {
                            TransportState.this.deframeFailed(t);
                            return;
                        }
                        throw th;
                    }
                });
                return;
            }
            throw th;
        }

        public final void requestMessagesFromDeframerForTesting(int numMessages) {
            requestMessagesFromDeframer(numMessages);
        }

        public final StatsTraceContext getStatsTraceContext() {
            return this.statsTraceCtx;
        }

        /* access modifiers changed from: protected */
        public final void setDecompressor(Decompressor decompressor) {
            this.deframer.setDecompressor(decompressor);
        }

        /* access modifiers changed from: private */
        public boolean isReady() {
            boolean z;
            synchronized (this.onReadyLock) {
                z = this.allocated && this.numSentBytesQueued < 32768 && !this.deallocated;
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public void onStreamAllocated() {
            boolean z = false;
            Preconditions.checkState(listener() != null);
            synchronized (this.onReadyLock) {
                if (!this.allocated) {
                    z = true;
                }
                Preconditions.checkState(z, "Already allocated");
                this.allocated = true;
            }
            notifyIfReady();
        }

        /* access modifiers changed from: protected */
        public final void onStreamDeallocated() {
            synchronized (this.onReadyLock) {
                this.deallocated = true;
            }
        }

        /* access modifiers changed from: private */
        public void onSendingBytes(int numBytes) {
            synchronized (this.onReadyLock) {
                this.numSentBytesQueued += numBytes;
            }
        }

        public final void onSentBytes(int numBytes) {
            boolean doNotify;
            synchronized (this.onReadyLock) {
                Preconditions.checkState(this.allocated, "onStreamAllocated was not called, but it seems the stream is active");
                boolean z = true;
                boolean belowThresholdBefore = this.numSentBytesQueued < 32768;
                this.numSentBytesQueued -= numBytes;
                boolean belowThresholdAfter = this.numSentBytesQueued < 32768;
                if (belowThresholdBefore || !belowThresholdAfter) {
                    z = false;
                }
                doNotify = z;
            }
            if (doNotify) {
                notifyIfReady();
            }
        }

        /* access modifiers changed from: protected */
        public TransportTracer getTransportTracer() {
            return this.transportTracer;
        }

        private void notifyIfReady() {
            boolean doNotify;
            synchronized (this.onReadyLock) {
                doNotify = isReady();
            }
            if (doNotify) {
                listener().onReady();
            }
        }
    }
}
