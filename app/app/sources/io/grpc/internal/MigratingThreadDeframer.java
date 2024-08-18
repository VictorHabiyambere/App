package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Decompressor;
import io.grpc.internal.ApplicationThreadDeframerListener;
import io.grpc.internal.MessageDeframer;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.TaskCloseable;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;

final class MigratingThreadDeframer implements ThreadOptimizedDeframer {
    /* access modifiers changed from: private */
    public final ApplicationThreadDeframerListener appListener;
    /* access modifiers changed from: private */
    public final MessageDeframer deframer;
    /* access modifiers changed from: private */
    public boolean deframerOnTransportThread;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public final DeframeMessageProducer messageProducer = new DeframeMessageProducer();
    /* access modifiers changed from: private */
    public boolean messageProducerEnqueued;
    /* access modifiers changed from: private */
    public final MigratingDeframerListener migratingListener;
    /* access modifiers changed from: private */
    public final Queue<Op> opQueue = new ArrayDeque();
    /* access modifiers changed from: private */
    public final ApplicationThreadDeframerListener.TransportExecutor transportExecutor;
    /* access modifiers changed from: private */
    public final MessageDeframer.Listener transportListener;

    private interface Op {
        void run(boolean z);
    }

    public MigratingThreadDeframer(MessageDeframer.Listener listener, ApplicationThreadDeframerListener.TransportExecutor transportExecutor2, MessageDeframer deframer2) {
        this.transportListener = new SquelchLateMessagesAvailableDeframerListener((MessageDeframer.Listener) Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
        this.transportExecutor = (ApplicationThreadDeframerListener.TransportExecutor) Preconditions.checkNotNull(transportExecutor2, "transportExecutor");
        this.appListener = new ApplicationThreadDeframerListener(this.transportListener, transportExecutor2);
        this.migratingListener = new MigratingDeframerListener(this.appListener);
        deframer2.setListener(this.migratingListener);
        this.deframer = deframer2;
    }

    public void setMaxInboundMessageSize(int messageSize) {
        this.deframer.setMaxInboundMessageSize(messageSize);
    }

    public void setDecompressor(Decompressor decompressor) {
        this.deframer.setDecompressor(decompressor);
    }

    public void setFullStreamDecompressor(GzipInflatingBuffer fullStreamDecompressor) {
        this.deframer.setFullStreamDecompressor(fullStreamDecompressor);
    }

    private boolean runWhereAppropriate(Op op) {
        return runWhereAppropriate(op, true);
    }

    private boolean runWhereAppropriate(Op op, boolean currentThreadIsTransportThread) {
        boolean deframerOnTransportThreadCopy;
        boolean alreadyEnqueued;
        synchronized (this.lock) {
            deframerOnTransportThreadCopy = this.deframerOnTransportThread;
            alreadyEnqueued = this.messageProducerEnqueued;
            if (!deframerOnTransportThreadCopy) {
                this.opQueue.offer(op);
                this.messageProducerEnqueued = true;
            }
        }
        if (deframerOnTransportThreadCopy) {
            op.run(true);
            return true;
        } else if (alreadyEnqueued) {
            return false;
        } else {
            if (currentThreadIsTransportThread) {
                TaskCloseable ignore = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
                try {
                    this.transportListener.messagesAvailable(this.messageProducer);
                    if (ignore == null) {
                        return false;
                    }
                    ignore.close();
                    return false;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                final Link link = PerfMark.linkOut();
                this.transportExecutor.runOnTransportThread(new Runnable() {
                    public void run() {
                        TaskCloseable ignore = PerfMark.traceTask("MigratingThreadDeframer.messageAvailable");
                        try {
                            PerfMark.linkIn(link);
                            MigratingThreadDeframer.this.transportListener.messagesAvailable(MigratingThreadDeframer.this.messageProducer);
                            if (ignore != null) {
                                ignore.close();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                });
                return false;
            }
        }
        throw th;
    }

    public void request(final int numMessages) {
        runWhereAppropriate(new Op() {
            public void run(boolean isDeframerOnTransportThread) {
                TaskCloseable ignore;
                if (isDeframerOnTransportThread) {
                    final Link link = PerfMark.linkOut();
                    MigratingThreadDeframer.this.transportExecutor.runOnTransportThread(new Runnable() {
                        public void run() {
                            TaskCloseable ignore = PerfMark.traceTask("MigratingThreadDeframer.request");
                            try {
                                PerfMark.linkIn(link);
                                MigratingThreadDeframer.this.requestFromTransportThread(numMessages);
                                if (ignore != null) {
                                    ignore.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                            throw th;
                        }
                    });
                    return;
                }
                try {
                    ignore = PerfMark.traceTask("MigratingThreadDeframer.request");
                    MigratingThreadDeframer.this.deframer.request(numMessages);
                    if (ignore != null) {
                        ignore.close();
                        return;
                    }
                    return;
                } catch (Throwable t) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(t);
                    MigratingThreadDeframer.this.deframer.close();
                    return;
                }
                throw th;
            }
        }, false);
    }

    /* access modifiers changed from: private */
    public void requestFromTransportThread(final int numMessages) {
        runWhereAppropriate(new Op() {
            public void run(boolean isDeframerOnTransportThread) {
                if (!isDeframerOnTransportThread) {
                    MigratingThreadDeframer.this.request(numMessages);
                    return;
                }
                try {
                    MigratingThreadDeframer.this.deframer.request(numMessages);
                } catch (Throwable t) {
                    MigratingThreadDeframer.this.appListener.deframeFailed(t);
                    MigratingThreadDeframer.this.deframer.close();
                }
                if (!MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                    synchronized (MigratingThreadDeframer.this.lock) {
                        PerfMark.event("MigratingThreadDeframer.deframerOnApplicationThread");
                        MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.appListener);
                        boolean unused = MigratingThreadDeframer.this.deframerOnTransportThread = false;
                    }
                }
            }
        });
    }

    public void deframe(final ReadableBuffer data) {
        runWhereAppropriate(new Object() {
            public void run(boolean isDeframerOnTransportThread) {
                TaskCloseable ignore = PerfMark.traceTask("MigratingThreadDeframer.deframe");
                if (isDeframerOnTransportThread) {
                    try {
                        MigratingThreadDeframer.this.deframer.deframe(data);
                        if (ignore != null) {
                            ignore.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else {
                    try {
                        MigratingThreadDeframer.this.deframer.deframe(data);
                    } catch (Throwable t) {
                        MigratingThreadDeframer.this.appListener.deframeFailed(t);
                        MigratingThreadDeframer.this.deframer.close();
                    }
                    if (ignore != null) {
                        ignore.close();
                        return;
                    }
                    return;
                }
                throw th;
            }

            public void close() {
                data.close();
            }
        });
    }

    public void closeWhenComplete() {
        runWhereAppropriate(new Op() {
            public void run(boolean isDeframerOnTransportThread) {
                MigratingThreadDeframer.this.deframer.closeWhenComplete();
            }
        });
    }

    public void close() {
        if (!runWhereAppropriate(new Op() {
            public void run(boolean isDeframerOnTransportThread) {
                MigratingThreadDeframer.this.deframer.close();
            }
        })) {
            this.deframer.stopDelivery();
        }
    }

    class DeframeMessageProducer implements StreamListener.MessageProducer, Closeable {
        DeframeMessageProducer() {
        }

        public InputStream next() {
            Op op;
            while (true) {
                InputStream is = MigratingThreadDeframer.this.appListener.messageReadQueuePoll();
                if (is != null) {
                    return is;
                }
                synchronized (MigratingThreadDeframer.this.lock) {
                    op = (Op) MigratingThreadDeframer.this.opQueue.poll();
                    if (op == null) {
                        if (MigratingThreadDeframer.this.deframer.hasPendingDeliveries()) {
                            PerfMark.event("MigratingThreadDeframer.deframerOnTransportThread");
                            MigratingThreadDeframer.this.migratingListener.setDelegate(MigratingThreadDeframer.this.transportListener);
                            boolean unused = MigratingThreadDeframer.this.deframerOnTransportThread = true;
                        }
                        boolean unused2 = MigratingThreadDeframer.this.messageProducerEnqueued = false;
                        return null;
                    }
                }
                op.run(false);
            }
            while (true) {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x001c A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() {
            /*
                r4 = this;
            L_0x0001:
                io.grpc.internal.MigratingThreadDeframer r0 = io.grpc.internal.MigratingThreadDeframer.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
            L_0x0008:
                io.grpc.internal.MigratingThreadDeframer r1 = io.grpc.internal.MigratingThreadDeframer.this     // Catch:{ all -> 0x002c }
                java.util.Queue r1 = r1.opQueue     // Catch:{ all -> 0x002c }
                java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x002c }
                io.grpc.internal.MigratingThreadDeframer$Op r1 = (io.grpc.internal.MigratingThreadDeframer.Op) r1     // Catch:{ all -> 0x002c }
                if (r1 == 0) goto L_0x001a
                boolean r2 = r1 instanceof java.io.Closeable     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x0008
            L_0x001a:
                if (r1 != 0) goto L_0x0024
                io.grpc.internal.MigratingThreadDeframer r2 = io.grpc.internal.MigratingThreadDeframer.this     // Catch:{ all -> 0x002c }
                r3 = 0
                boolean unused = r2.messageProducerEnqueued = r3     // Catch:{ all -> 0x002c }
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return
            L_0x0024:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                r0 = r1
                java.io.Closeable r0 = (java.io.Closeable) r0
                io.grpc.internal.GrpcUtil.closeQuietly((java.io.Closeable) r0)
                goto L_0x0001
            L_0x002c:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.MigratingThreadDeframer.DeframeMessageProducer.close():void");
        }
    }

    static class MigratingDeframerListener extends ForwardingDeframerListener {
        private MessageDeframer.Listener delegate;

        public MigratingDeframerListener(MessageDeframer.Listener delegate2) {
            setDelegate(delegate2);
        }

        /* access modifiers changed from: protected */
        public MessageDeframer.Listener delegate() {
            return this.delegate;
        }

        public void setDelegate(MessageDeframer.Listener delegate2) {
            this.delegate = (MessageDeframer.Listener) Preconditions.checkNotNull(delegate2, "delegate");
        }
    }
}
