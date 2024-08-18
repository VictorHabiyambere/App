package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractServerStream;
import io.grpc.internal.StatsTraceContext;
import io.grpc.internal.TransportTracer;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.OkHttpServerTransport;
import io.grpc.okhttp.OutboundFlowController;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.util.List;
import okio.Buffer;

class OkHttpServerStream extends AbstractServerStream {
    private final Attributes attributes;
    private final String authority;
    private final Sink sink = new Sink();
    /* access modifiers changed from: private */
    public final TransportState state;
    /* access modifiers changed from: private */
    public final TransportTracer transportTracer;

    public OkHttpServerStream(TransportState state2, Attributes transportAttrs, String authority2, StatsTraceContext statsTraceCtx, TransportTracer transportTracer2) {
        super(new OkHttpWritableBufferAllocator(), statsTraceCtx);
        this.state = (TransportState) Preconditions.checkNotNull(state2, "state");
        this.attributes = (Attributes) Preconditions.checkNotNull(transportAttrs, "transportAttrs");
        this.authority = authority2;
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer2, "transportTracer");
    }

    /* access modifiers changed from: protected */
    public TransportState transportState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public Sink abstractServerStreamSink() {
        return this.sink;
    }

    public int streamId() {
        return this.state.streamId;
    }

    public String getAuthority() {
        return this.authority;
    }

    public Attributes getAttributes() {
        return this.attributes;
    }

    class Sink implements AbstractServerStream.Sink {
        Sink() {
        }

        public void writeHeaders(Metadata metadata) {
            TaskCloseable ignore = PerfMark.traceTask("OkHttpServerStream$Sink.writeHeaders");
            try {
                List<Header> responseHeaders = Headers.createResponseHeaders(metadata);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendHeaders(responseHeaders);
                }
                if (ignore != null) {
                    ignore.close();
                }
            } catch (Throwable th) {
                if (ignore != null) {
                    try {
                        ignore.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public void writeFrame(WritableBuffer frame, boolean flush, int numMessages) {
            TaskCloseable ignore = PerfMark.traceTask("OkHttpServerStream$Sink.writeFrame");
            try {
                Buffer buffer = ((OkHttpWritableBuffer) frame).buffer();
                int size = (int) buffer.size();
                if (size > 0) {
                    OkHttpServerStream.this.onSendingBytes(size);
                }
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendBuffer(buffer, flush);
                    OkHttpServerStream.this.transportTracer.reportMessageSent(numMessages);
                }
                if (ignore != null) {
                    ignore.close();
                }
            } catch (Throwable th) {
                if (ignore != null) {
                    try {
                        ignore.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public void writeTrailers(Metadata trailers, boolean headersSent, Status status) {
            TaskCloseable ignore = PerfMark.traceTask("OkHttpServerStream$Sink.writeTrailers");
            try {
                List<Header> responseTrailers = Headers.createResponseTrailers(trailers, headersSent);
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.sendTrailers(responseTrailers);
                }
                if (ignore != null) {
                    ignore.close();
                }
            } catch (Throwable th) {
                if (ignore != null) {
                    try {
                        ignore.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        public void cancel(Status reason) {
            TaskCloseable ignore = PerfMark.traceTask("OkHttpServerStream$Sink.cancel");
            try {
                synchronized (OkHttpServerStream.this.state.lock) {
                    OkHttpServerStream.this.state.cancel(ErrorCode.CANCEL, reason);
                }
                if (ignore != null) {
                    ignore.close();
                }
            } catch (Throwable th) {
                if (ignore != null) {
                    try {
                        ignore.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    static class TransportState extends AbstractServerStream.TransportState implements OutboundFlowController.Stream, OkHttpServerTransport.StreamState {
        private boolean cancelSent = false;
        private final ExceptionHandlingFrameWriter frameWriter;
        private final int initialWindowSize;
        /* access modifiers changed from: private */
        public final Object lock;
        private final OutboundFlowController outboundFlow;
        private final OutboundFlowController.StreamState outboundFlowState;
        private int processedWindow;
        private boolean receivedEndOfStream;
        /* access modifiers changed from: private */
        public final int streamId;
        private final Tag tag;
        private final OkHttpServerTransport transport;
        private int window;

        public TransportState(OkHttpServerTransport transport2, int streamId2, int maxMessageSize, StatsTraceContext statsTraceCtx, Object lock2, ExceptionHandlingFrameWriter frameWriter2, OutboundFlowController outboundFlow2, int initialWindowSize2, TransportTracer transportTracer, String methodName) {
            super(maxMessageSize, statsTraceCtx, transportTracer);
            this.transport = (OkHttpServerTransport) Preconditions.checkNotNull(transport2, NotificationCompat.CATEGORY_TRANSPORT);
            this.streamId = streamId2;
            this.lock = Preconditions.checkNotNull(lock2, "lock");
            this.frameWriter = frameWriter2;
            this.outboundFlow = outboundFlow2;
            this.window = initialWindowSize2;
            this.processedWindow = initialWindowSize2;
            this.initialWindowSize = initialWindowSize2;
            this.tag = PerfMark.createTag(methodName);
            this.outboundFlowState = outboundFlow2.createState(this, streamId2);
        }

        public void deframeFailed(Throwable cause) {
            cancel(ErrorCode.INTERNAL_ERROR, Status.fromThrowable(cause));
        }

        public void bytesRead(int processedBytes) {
            this.processedWindow -= processedBytes;
            if (((float) this.processedWindow) <= ((float) this.initialWindowSize) * 0.5f) {
                int delta = this.initialWindowSize - this.processedWindow;
                this.window += delta;
                this.processedWindow += delta;
                this.frameWriter.windowUpdate(this.streamId, (long) delta);
                this.frameWriter.flush();
            }
        }

        public void runOnTransportThread(Runnable r) {
            synchronized (this.lock) {
                r.run();
            }
        }

        public void inboundDataReceived(Buffer frame, int windowConsumed, boolean endOfStream) {
            synchronized (this.lock) {
                PerfMark.event("OkHttpServerTransport$FrameHandler.data", this.tag);
                if (endOfStream) {
                    this.receivedEndOfStream = true;
                }
                this.window -= windowConsumed;
                super.inboundDataReceived(new OkHttpReadableBuffer(frame), endOfStream);
            }
        }

        public void inboundRstReceived(Status status) {
            PerfMark.event("OkHttpServerTransport$FrameHandler.rstStream", this.tag);
            transportReportStatus(status);
        }

        public boolean hasReceivedEndOfStream() {
            boolean z;
            synchronized (this.lock) {
                z = this.receivedEndOfStream;
            }
            return z;
        }

        public int inboundWindowAvailable() {
            int i;
            synchronized (this.lock) {
                i = this.window;
            }
            return i;
        }

        /* access modifiers changed from: private */
        public void sendBuffer(Buffer buffer, boolean flush) {
            if (!this.cancelSent) {
                this.outboundFlow.data(false, this.outboundFlowState, buffer, flush);
            }
        }

        /* access modifiers changed from: private */
        public void sendHeaders(List<Header> responseHeaders) {
            this.frameWriter.synReply(false, this.streamId, responseHeaders);
            this.frameWriter.flush();
        }

        /* access modifiers changed from: private */
        public void sendTrailers(List<Header> responseTrailers) {
            this.outboundFlow.notifyWhenNoPendingData(this.outboundFlowState, new OkHttpServerStream$TransportState$$ExternalSyntheticLambda0(this, responseTrailers));
        }

        /* access modifiers changed from: private */
        /* renamed from: sendTrailersAfterFlowControlled */
        public void m290lambda$sendTrailers$0$iogrpcokhttpOkHttpServerStream$TransportState(List<Header> responseTrailers) {
            synchronized (this.lock) {
                this.frameWriter.synReply(true, this.streamId, responseTrailers);
                if (!this.receivedEndOfStream) {
                    this.frameWriter.rstStream(this.streamId, ErrorCode.NO_ERROR);
                }
                this.transport.streamClosed(this.streamId, true);
                complete();
            }
        }

        /* access modifiers changed from: private */
        public void cancel(ErrorCode http2Error, Status reason) {
            if (!this.cancelSent) {
                this.cancelSent = true;
                this.frameWriter.rstStream(this.streamId, http2Error);
                transportReportStatus(reason);
                this.transport.streamClosed(this.streamId, true);
            }
        }

        public OutboundFlowController.StreamState getOutboundFlowState() {
            return this.outboundFlowState;
        }
    }
}
