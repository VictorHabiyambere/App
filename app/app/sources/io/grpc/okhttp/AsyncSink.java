package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class AsyncSink implements Sink {
    /* access modifiers changed from: private */
    public final Buffer buffer = new Buffer();
    private boolean closed = false;
    private boolean controlFramesExceeded;
    private int controlFramesInWrite;
    /* access modifiers changed from: private */
    public boolean flushEnqueued = false;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final int maxQueuedControlFrames;
    /* access modifiers changed from: private */
    public int queuedControlFrames;
    private final SerializingExecutor serializingExecutor;
    /* access modifiers changed from: private */
    @Nullable
    public Sink sink;
    /* access modifiers changed from: private */
    @Nullable
    public Socket socket;
    /* access modifiers changed from: private */
    public final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    /* access modifiers changed from: private */
    public boolean writeEnqueued = false;

    static /* synthetic */ int access$420(AsyncSink x0, int x1) {
        int i = x0.queuedControlFrames - x1;
        x0.queuedControlFrames = i;
        return i;
    }

    static /* synthetic */ int access$908(AsyncSink x0) {
        int i = x0.controlFramesInWrite;
        x0.controlFramesInWrite = i + 1;
        return i;
    }

    private AsyncSink(SerializingExecutor executor, ExceptionHandlingFrameWriter.TransportExceptionHandler exceptionHandler, int maxQueuedControlFrames2) {
        this.serializingExecutor = (SerializingExecutor) Preconditions.checkNotNull(executor, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) Preconditions.checkNotNull(exceptionHandler, "exceptionHandler");
        this.maxQueuedControlFrames = maxQueuedControlFrames2;
    }

    static AsyncSink sink(SerializingExecutor executor, ExceptionHandlingFrameWriter.TransportExceptionHandler exceptionHandler, int maxQueuedControlFrames2) {
        return new AsyncSink(executor, exceptionHandler, maxQueuedControlFrames2);
    }

    /* access modifiers changed from: package-private */
    public void becomeConnected(Sink sink2, Socket socket2) {
        Preconditions.checkState(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) Preconditions.checkNotNull(sink2, "sink");
        this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
    }

    /* access modifiers changed from: package-private */
    public FrameWriter limitControlFramesWriter(FrameWriter delegate) {
        return new LimitControlFramesWriter(delegate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r1 == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r9.socket.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r9.serializingExecutor.execute(new io.grpc.okhttp.AsyncSink.AnonymousClass1(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0067, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0069, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006e, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(okio.Buffer r10, long r11) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "source"
            com.google.common.base.Preconditions.checkNotNull(r10, r0)
            boolean r0 = r9.closed
            if (r0 != 0) goto L_0x0083
            java.lang.String r0 = "AsyncSink.write"
            io.perfmark.TaskCloseable r0 = io.perfmark.PerfMark.traceTask(r0)
            r1 = 0
            java.lang.Object r2 = r9.lock     // Catch:{ all -> 0x0077 }
            monitor-enter(r2)     // Catch:{ all -> 0x0077 }
            okio.Buffer r3 = r9.buffer     // Catch:{ all -> 0x0074 }
            r3.write((okio.Buffer) r10, (long) r11)     // Catch:{ all -> 0x0074 }
            int r3 = r9.queuedControlFrames     // Catch:{ all -> 0x0074 }
            int r4 = r9.controlFramesInWrite     // Catch:{ all -> 0x0074 }
            int r3 = r3 + r4
            r9.queuedControlFrames = r3     // Catch:{ all -> 0x0074 }
            r3 = 0
            r9.controlFramesInWrite = r3     // Catch:{ all -> 0x0074 }
            boolean r3 = r9.controlFramesExceeded     // Catch:{ all -> 0x0074 }
            r4 = 1
            if (r3 != 0) goto L_0x0031
            int r3 = r9.queuedControlFrames     // Catch:{ all -> 0x0074 }
            int r5 = r9.maxQueuedControlFrames     // Catch:{ all -> 0x0074 }
            if (r3 <= r5) goto L_0x0031
            r9.controlFramesExceeded = r4     // Catch:{ all -> 0x0074 }
            r1 = 1
            goto L_0x0048
        L_0x0031:
            boolean r3 = r9.writeEnqueued     // Catch:{ all -> 0x0074 }
            if (r3 != 0) goto L_0x006d
            boolean r3 = r9.flushEnqueued     // Catch:{ all -> 0x0074 }
            if (r3 != 0) goto L_0x006d
            okio.Buffer r3 = r9.buffer     // Catch:{ all -> 0x0074 }
            long r5 = r3.completeSegmentByteCount()     // Catch:{ all -> 0x0074 }
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 > 0) goto L_0x0046
            goto L_0x006d
        L_0x0046:
            r9.writeEnqueued = r4     // Catch:{ all -> 0x0074 }
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x005d
            java.net.Socket r2 = r9.socket     // Catch:{ IOException -> 0x0051 }
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0057
        L_0x0051:
            r2 = move-exception
            io.grpc.okhttp.ExceptionHandlingFrameWriter$TransportExceptionHandler r3 = r9.transportExceptionHandler     // Catch:{ all -> 0x0077 }
            r3.onException(r2)     // Catch:{ all -> 0x0077 }
        L_0x0057:
            if (r0 == 0) goto L_0x005c
            r0.close()
        L_0x005c:
            return
        L_0x005d:
            io.grpc.internal.SerializingExecutor r2 = r9.serializingExecutor     // Catch:{ all -> 0x0077 }
            io.grpc.okhttp.AsyncSink$1 r3 = new io.grpc.okhttp.AsyncSink$1     // Catch:{ all -> 0x0077 }
            r3.<init>()     // Catch:{ all -> 0x0077 }
            r2.execute(r3)     // Catch:{ all -> 0x0077 }
            if (r0 == 0) goto L_0x006c
            r0.close()
        L_0x006c:
            return
        L_0x006d:
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x0073
            r0.close()
        L_0x0073:
            return
        L_0x0074:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            throw r3     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r1 = move-exception
            if (r0 == 0) goto L_0x0082
            r0.close()     // Catch:{ all -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r2 = move-exception
            r1.addSuppressed(r2)
        L_0x0082:
            throw r1
        L_0x0083:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "closed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.AsyncSink.write(okio.Buffer, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r3.serializingExecutor.execute(new io.grpc.okhttp.AsyncSink.AnonymousClass2(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flush() throws java.io.IOException {
        /*
            r3 = this;
            boolean r0 = r3.closed
            if (r0 != 0) goto L_0x003b
            java.lang.String r0 = "AsyncSink.flush"
            io.perfmark.TaskCloseable r0 = io.perfmark.PerfMark.traceTask(r0)
            java.lang.Object r1 = r3.lock     // Catch:{ all -> 0x002f }
            monitor-enter(r1)     // Catch:{ all -> 0x002f }
            boolean r2 = r3.flushEnqueued     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x0018
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0017
            r0.close()
        L_0x0017:
            return
        L_0x0018:
            r2 = 1
            r3.flushEnqueued = r2     // Catch:{ all -> 0x002c }
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            io.grpc.internal.SerializingExecutor r1 = r3.serializingExecutor     // Catch:{ all -> 0x002f }
            io.grpc.okhttp.AsyncSink$2 r2 = new io.grpc.okhttp.AsyncSink$2     // Catch:{ all -> 0x002f }
            r2.<init>()     // Catch:{ all -> 0x002f }
            r1.execute(r2)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002b
            r0.close()
        L_0x002b:
            return
        L_0x002c:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            throw r2     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            if (r0 == 0) goto L_0x003a
            r0.close()     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r2 = move-exception
            r1.addSuppressed(r2)
        L_0x003a:
            throw r1
        L_0x003b:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "closed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.okhttp.AsyncSink.flush():void");
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        if (AsyncSink.this.sink != null && AsyncSink.this.buffer.size() > 0) {
                            AsyncSink.this.sink.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                        }
                    } catch (IOException e) {
                        AsyncSink.this.transportExceptionHandler.onException(e);
                    }
                    AsyncSink.this.buffer.close();
                    try {
                        if (AsyncSink.this.sink != null) {
                            AsyncSink.this.sink.close();
                        }
                    } catch (IOException e2) {
                        AsyncSink.this.transportExceptionHandler.onException(e2);
                    }
                    try {
                        if (AsyncSink.this.socket != null) {
                            AsyncSink.this.socket.close();
                        }
                    } catch (IOException e3) {
                        AsyncSink.this.transportExceptionHandler.onException(e3);
                    }
                }
            });
        }
    }

    private abstract class WriteRunnable implements Runnable {
        public abstract void doRun() throws IOException;

        private WriteRunnable() {
        }

        public final void run() {
            try {
                if (AsyncSink.this.sink != null) {
                    doRun();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e) {
                AsyncSink.this.transportExceptionHandler.onException(e);
            }
        }
    }

    private class LimitControlFramesWriter extends ForwardingFrameWriter {
        public LimitControlFramesWriter(FrameWriter delegate) {
            super(delegate);
        }

        public void ackSettings(Settings peerSettings) throws IOException {
            AsyncSink.access$908(AsyncSink.this);
            super.ackSettings(peerSettings);
        }

        public void rstStream(int streamId, ErrorCode errorCode) throws IOException {
            AsyncSink.access$908(AsyncSink.this);
            super.rstStream(streamId, errorCode);
        }

        public void ping(boolean ack, int payload1, int payload2) throws IOException {
            if (ack) {
                AsyncSink.access$908(AsyncSink.this);
            }
            super.ping(ack, payload1, payload2);
        }
    }
}
