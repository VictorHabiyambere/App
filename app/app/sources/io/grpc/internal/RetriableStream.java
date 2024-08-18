package io.grpc.internal;

import androidx.core.app.NotificationManagerCompat;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.ClientStreamTracer;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.SynchronizationContext;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

abstract class RetriableStream<ReqT> implements ClientStream {
    /* access modifiers changed from: private */
    public static final Status CANCELLED_BECAUSE_COMMITTED = Status.CANCELLED.withDescription("Stream thrown away because RetriableStream committed");
    static final Metadata.Key<String> GRPC_PREVIOUS_RPC_ATTEMPTS = Metadata.Key.of("grpc-previous-rpc-attempts", Metadata.ASCII_STRING_MARSHALLER);
    static final Metadata.Key<String> GRPC_RETRY_PUSHBACK_MS = Metadata.Key.of("grpc-retry-pushback-ms", Metadata.ASCII_STRING_MARSHALLER);
    /* access modifiers changed from: private */
    public static Random random = new Random();
    /* access modifiers changed from: private */
    public final Executor callExecutor;
    private Status cancellationStatus;
    /* access modifiers changed from: private */
    public final long channelBufferLimit;
    /* access modifiers changed from: private */
    public final ChannelBufferMeter channelBufferUsed;
    /* access modifiers changed from: private */
    public final InsightBuilder closedSubstreamsInsight = new InsightBuilder();
    private final Metadata headers;
    /* access modifiers changed from: private */
    @Nullable
    public final HedgingPolicy hedgingPolicy;
    /* access modifiers changed from: private */
    public final AtomicInteger inFlightSubStreams = new AtomicInteger();
    /* access modifiers changed from: private */
    public boolean isClosed;
    /* access modifiers changed from: private */
    public final boolean isHedging;
    /* access modifiers changed from: private */
    public final Executor listenerSerializeExecutor = new SynchronizationContext(new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread t, Throwable e) {
            throw Status.fromThrowable(e).withDescription("Uncaught exception in the SynchronizationContext. Re-thrown.").asRuntimeException();
        }
    });
    /* access modifiers changed from: private */
    public final AtomicInteger localOnlyTransparentRetries = new AtomicInteger();
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public ClientStreamListener masterListener;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, ?> method;
    /* access modifiers changed from: private */
    public long nextBackoffIntervalNanos;
    /* access modifiers changed from: private */
    public final AtomicBoolean noMoreTransparentRetry = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final long perRpcBufferLimit;
    /* access modifiers changed from: private */
    public long perRpcBufferUsed;
    /* access modifiers changed from: private */
    @Nullable
    public final RetryPolicy retryPolicy;
    /* access modifiers changed from: private */
    public SavedCloseMasterListenerReason savedCloseMasterListenerReason;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService scheduledExecutorService;
    /* access modifiers changed from: private */
    public FutureCanceller scheduledHedging;
    /* access modifiers changed from: private */
    public FutureCanceller scheduledRetry;
    /* access modifiers changed from: private */
    public volatile State state = new State(new ArrayList(8), Collections.emptyList(), (Collection<Substream>) null, (Substream) null, false, false, false, 0);
    /* access modifiers changed from: private */
    @Nullable
    public final Throttle throttle;

    private interface BufferEntry {
        void runWith(Substream substream);
    }

    /* access modifiers changed from: package-private */
    public abstract ClientStream newSubstream(Metadata metadata, ClientStreamTracer.Factory factory, int i, boolean z);

    /* access modifiers changed from: package-private */
    public abstract void postCommit();

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    @Nullable
    public abstract Status prestart();

    RetriableStream(MethodDescriptor<ReqT, ?> method2, Metadata headers2, ChannelBufferMeter channelBufferUsed2, long perRpcBufferLimit2, long channelBufferLimit2, Executor callExecutor2, ScheduledExecutorService scheduledExecutorService2, @Nullable RetryPolicy retryPolicy2, @Nullable HedgingPolicy hedgingPolicy2, @Nullable Throttle throttle2) {
        RetryPolicy retryPolicy3 = retryPolicy2;
        HedgingPolicy hedgingPolicy3 = hedgingPolicy2;
        this.method = method2;
        this.channelBufferUsed = channelBufferUsed2;
        this.perRpcBufferLimit = perRpcBufferLimit2;
        this.channelBufferLimit = channelBufferLimit2;
        this.callExecutor = callExecutor2;
        this.scheduledExecutorService = scheduledExecutorService2;
        this.headers = headers2;
        this.retryPolicy = retryPolicy3;
        if (retryPolicy3 != null) {
            this.nextBackoffIntervalNanos = retryPolicy3.initialBackoffNanos;
        }
        this.hedgingPolicy = hedgingPolicy3;
        boolean z = false;
        Preconditions.checkArgument(retryPolicy3 == null || hedgingPolicy3 == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.isHedging = hedgingPolicy3 != null ? true : z;
        this.throttle = throttle2;
    }

    /* access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public Runnable commit(Substream winningSubstream) {
        Future<?> retryFuture;
        Future<?> hedgingFuture;
        synchronized (this.lock) {
            if (this.state.winningSubstream != null) {
                return null;
            }
            final Collection<Substream> savedDrainedSubstreams = this.state.drainedSubstreams;
            this.state = this.state.committed(winningSubstream);
            this.channelBufferUsed.addAndGet(-this.perRpcBufferUsed);
            if (this.scheduledRetry != null) {
                retryFuture = this.scheduledRetry.markCancelled();
                this.scheduledRetry = null;
            } else {
                retryFuture = null;
            }
            if (this.scheduledHedging != null) {
                Future<?> hedgingFuture2 = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
                hedgingFuture = hedgingFuture2;
            } else {
                hedgingFuture = null;
            }
            final Substream substream = winningSubstream;
            final Future<?> future = retryFuture;
            final Future<?> future2 = hedgingFuture;
            AnonymousClass1CommitTask r3 = new Runnable() {
                public void run() {
                    for (Substream substream : savedDrainedSubstreams) {
                        if (substream != substream) {
                            substream.stream.cancel(RetriableStream.CANCELLED_BECAUSE_COMMITTED);
                        }
                    }
                    if (future != null) {
                        future.cancel(false);
                    }
                    if (future2 != null) {
                        future2.cancel(false);
                    }
                    RetriableStream.this.postCommit();
                }
            };
            return r3;
        }
    }

    /* access modifiers changed from: private */
    public void commitAndRun(Substream winningSubstream) {
        Runnable postCommitTask = commit(winningSubstream);
        if (postCommitTask != null) {
            postCommitTask.run();
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public Substream createSubstream(int previousAttemptCount, boolean isTransparentRetry) {
        int inFlight;
        do {
            inFlight = this.inFlightSubStreams.get();
            if (inFlight < 0) {
                return null;
            }
        } while (!this.inFlightSubStreams.compareAndSet(inFlight, inFlight + 1));
        Substream sub = new Substream(previousAttemptCount);
        final ClientStreamTracer bufferSizeTracer = new BufferSizeTracer(sub);
        sub.stream = newSubstream(updateHeaders(this.headers, previousAttemptCount), new ClientStreamTracer.Factory() {
            public ClientStreamTracer newClientStreamTracer(ClientStreamTracer.StreamInfo info, Metadata headers) {
                return bufferSizeTracer;
            }
        }, previousAttemptCount, isTransparentRetry);
        return sub;
    }

    /* access modifiers changed from: package-private */
    public final Metadata updateHeaders(Metadata originalHeaders, int previousAttemptCount) {
        Metadata newHeaders = new Metadata();
        newHeaders.merge(originalHeaders);
        if (previousAttemptCount > 0) {
            newHeaders.put(GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(previousAttemptCount));
        }
        return newHeaders;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008c, code lost:
        r5 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0094, code lost:
        if (r5.hasNext() == false) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0096, code lost:
        r7 = r5.next();
        r7.runWith(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a1, code lost:
        if ((r7 instanceof io.grpc.internal.RetriableStream.StartEntry) == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a3, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a4, code lost:
        r6 = r10.state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a8, code lost:
        if (r6.winningSubstream == null) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ac, code lost:
        if (r6.winningSubstream == r11) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b1, code lost:
        if (r6.cancelled == false) goto L_0x0090;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drain(io.grpc.internal.RetriableStream.Substream r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            java.lang.Object r5 = r10.lock
            monitor-enter(r5)
            io.grpc.internal.RetriableStream$State r6 = r10.state     // Catch:{ all -> 0x00b7 }
            io.grpc.internal.RetriableStream$Substream r7 = r6.winningSubstream     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x0015
            io.grpc.internal.RetriableStream$Substream r7 = r6.winningSubstream     // Catch:{ all -> 0x00b7 }
            if (r7 == r11) goto L_0x0015
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            goto L_0x0038
        L_0x0015:
            boolean r7 = r6.cancelled     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x001b
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            goto L_0x0038
        L_0x001b:
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r7 = r6.buffer     // Catch:{ all -> 0x00b7 }
            int r7 = r7.size()     // Catch:{ all -> 0x00b7 }
            if (r0 != r7) goto L_0x005d
            io.grpc.internal.RetriableStream$State r7 = r6.substreamDrained(r11)     // Catch:{ all -> 0x00b7 }
            r10.state = r7     // Catch:{ all -> 0x00b7 }
            boolean r7 = r10.isReady()     // Catch:{ all -> 0x00b7 }
            if (r7 != 0) goto L_0x0031
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            return
        L_0x0031:
            io.grpc.internal.RetriableStream$3 r7 = new io.grpc.internal.RetriableStream$3     // Catch:{ all -> 0x00b7 }
            r7.<init>()     // Catch:{ all -> 0x00b7 }
            r4 = r7
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
        L_0x0038:
            if (r4 == 0) goto L_0x0040
            java.util.concurrent.Executor r5 = r10.listenerSerializeExecutor
            r5.execute(r4)
            return
        L_0x0040:
            if (r3 != 0) goto L_0x004c
            io.grpc.internal.ClientStream r5 = r11.stream
            io.grpc.internal.RetriableStream$Sublistener r6 = new io.grpc.internal.RetriableStream$Sublistener
            r6.<init>(r11)
            r5.start(r6)
        L_0x004c:
            io.grpc.internal.ClientStream r5 = r11.stream
            io.grpc.internal.RetriableStream$State r6 = r10.state
            io.grpc.internal.RetriableStream$Substream r6 = r6.winningSubstream
            if (r6 != r11) goto L_0x0057
            io.grpc.Status r6 = r10.cancellationStatus
            goto L_0x0059
        L_0x0057:
            io.grpc.Status r6 = CANCELLED_BECAUSE_COMMITTED
        L_0x0059:
            r5.cancel(r6)
            return
        L_0x005d:
            boolean r7 = r11.closed     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x0063
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            return
        L_0x0063:
            int r7 = r0 + r1
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r8 = r6.buffer     // Catch:{ all -> 0x00b7 }
            int r8 = r8.size()     // Catch:{ all -> 0x00b7 }
            int r7 = java.lang.Math.min(r7, r8)     // Catch:{ all -> 0x00b7 }
            if (r2 != 0) goto L_0x007e
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00b7 }
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r9 = r6.buffer     // Catch:{ all -> 0x00b7 }
            java.util.List r9 = r9.subList(r0, r7)     // Catch:{ all -> 0x00b7 }
            r8.<init>(r9)     // Catch:{ all -> 0x00b7 }
            r2 = r8
            goto L_0x008a
        L_0x007e:
            r2.clear()     // Catch:{ all -> 0x00b7 }
            java.util.List<io.grpc.internal.RetriableStream$BufferEntry> r8 = r6.buffer     // Catch:{ all -> 0x00b7 }
            java.util.List r8 = r8.subList(r0, r7)     // Catch:{ all -> 0x00b7 }
            r2.addAll(r8)     // Catch:{ all -> 0x00b7 }
        L_0x008a:
            r0 = r7
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r5 = r2.iterator()
        L_0x0090:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00b5
            java.lang.Object r7 = r5.next()
            io.grpc.internal.RetriableStream$BufferEntry r7 = (io.grpc.internal.RetriableStream.BufferEntry) r7
            r7.runWith(r11)
            boolean r8 = r7 instanceof io.grpc.internal.RetriableStream.StartEntry
            if (r8 == 0) goto L_0x00a4
            r3 = 1
        L_0x00a4:
            io.grpc.internal.RetriableStream$State r6 = r10.state
            io.grpc.internal.RetriableStream$Substream r8 = r6.winningSubstream
            if (r8 == 0) goto L_0x00af
            io.grpc.internal.RetriableStream$Substream r8 = r6.winningSubstream
            if (r8 == r11) goto L_0x00af
            goto L_0x00b5
        L_0x00af:
            boolean r8 = r6.cancelled
            if (r8 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            goto L_0x0090
        L_0x00b5:
            goto L_0x0006
        L_0x00b7:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00b7 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.drain(io.grpc.internal.RetriableStream$Substream):void");
    }

    class StartEntry implements BufferEntry {
        StartEntry() {
        }

        public void runWith(Substream substream) {
            substream.stream.start(new Sublistener(substream));
        }
    }

    public final void start(ClientStreamListener listener) {
        this.masterListener = listener;
        Status shutdownStatus = prestart();
        if (shutdownStatus != null) {
            cancel(shutdownStatus);
            return;
        }
        synchronized (this.lock) {
            this.state.buffer.add(new StartEntry());
        }
        Substream substream = createSubstream(0, false);
        if (substream != null) {
            if (this.isHedging) {
                FutureCanceller scheduledHedgingRef = null;
                synchronized (this.lock) {
                    this.state = this.state.addActiveHedge(substream);
                    if (hasPotentialHedging(this.state) && (this.throttle == null || this.throttle.isAboveThreshold())) {
                        FutureCanceller futureCanceller = new FutureCanceller(this.lock);
                        scheduledHedgingRef = futureCanceller;
                        this.scheduledHedging = futureCanceller;
                    }
                }
                if (scheduledHedgingRef != null) {
                    scheduledHedgingRef.setFuture(this.scheduledExecutorService.schedule(new HedgingRunnable(scheduledHedgingRef), this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                }
            }
            drain(substream);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r1 == null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r1.cancel(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r3.setFuture(r7.scheduledExecutorService.schedule(new io.grpc.internal.RetriableStream.HedgingRunnable(r7, r3), (long) r8.intValue(), java.util.concurrent.TimeUnit.MILLISECONDS));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pushbackHedging(@javax.annotation.Nullable java.lang.Integer r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            int r0 = r8.intValue()
            if (r0 >= 0) goto L_0x000d
            r7.freezeHedging()
            return
        L_0x000d:
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            io.grpc.internal.RetriableStream$FutureCanceller r1 = r7.scheduledHedging     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0016
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x0016:
            io.grpc.internal.RetriableStream$FutureCanceller r1 = r7.scheduledHedging     // Catch:{ all -> 0x0043 }
            java.util.concurrent.Future r1 = r1.markCancelled()     // Catch:{ all -> 0x0043 }
            io.grpc.internal.RetriableStream$FutureCanceller r2 = new io.grpc.internal.RetriableStream$FutureCanceller     // Catch:{ all -> 0x0043 }
            java.lang.Object r3 = r7.lock     // Catch:{ all -> 0x0043 }
            r2.<init>(r3)     // Catch:{ all -> 0x0043 }
            r3 = r2
            r7.scheduledHedging = r2     // Catch:{ all -> 0x0043 }
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x002d
            r0 = 0
            r1.cancel(r0)
        L_0x002d:
            java.util.concurrent.ScheduledExecutorService r0 = r7.scheduledExecutorService
            io.grpc.internal.RetriableStream$HedgingRunnable r2 = new io.grpc.internal.RetriableStream$HedgingRunnable
            r2.<init>(r3)
            int r4 = r8.intValue()
            long r4 = (long) r4
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r0 = r0.schedule(r2, r4, r6)
            r3.setFuture(r0)
            return
        L_0x0043:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.pushbackHedging(java.lang.Integer):void");
    }

    private final class HedgingRunnable implements Runnable {
        final FutureCanceller scheduledHedgingRef;

        HedgingRunnable(FutureCanceller scheduledHedging) {
            this.scheduledHedgingRef = scheduledHedging;
        }

        public void run() {
            final Substream newSubstream = RetriableStream.this.createSubstream(RetriableStream.this.state.hedgingAttemptCount, false);
            if (newSubstream != null) {
                RetriableStream.this.callExecutor.execute(new Runnable() {
                    public void run() {
                        boolean cancelled = false;
                        FutureCanceller future = null;
                        synchronized (RetriableStream.this.lock) {
                            if (HedgingRunnable.this.scheduledHedgingRef.isCancelled()) {
                                cancelled = true;
                            } else {
                                State unused = RetriableStream.this.state = RetriableStream.this.state.addActiveHedge(newSubstream);
                                if (!RetriableStream.this.hasPotentialHedging(RetriableStream.this.state) || (RetriableStream.this.throttle != null && !RetriableStream.this.throttle.isAboveThreshold())) {
                                    State unused2 = RetriableStream.this.state = RetriableStream.this.state.freezeHedging();
                                    FutureCanceller unused3 = RetriableStream.this.scheduledHedging = null;
                                } else {
                                    RetriableStream retriableStream = RetriableStream.this;
                                    FutureCanceller futureCanceller = new FutureCanceller(RetriableStream.this.lock);
                                    future = futureCanceller;
                                    FutureCanceller unused4 = retriableStream.scheduledHedging = futureCanceller;
                                }
                            }
                        }
                        if (cancelled) {
                            newSubstream.stream.start(new Sublistener(newSubstream));
                            newSubstream.stream.cancel(Status.CANCELLED.withDescription("Unneeded hedging"));
                            return;
                        }
                        if (future != null) {
                            future.setFuture(RetriableStream.this.scheduledExecutorService.schedule(new HedgingRunnable(future), RetriableStream.this.hedgingPolicy.hedgingDelayNanos, TimeUnit.NANOSECONDS));
                        }
                        RetriableStream.this.drain(newSubstream);
                    }
                });
            }
        }
    }

    public final void cancel(Status reason) {
        Substream noopSubstream = new Substream(0);
        noopSubstream.stream = new NoopClientStream();
        Runnable runnable = commit(noopSubstream);
        if (runnable != null) {
            synchronized (this.lock) {
                this.state = this.state.substreamDrained(noopSubstream);
            }
            runnable.run();
            safeCloseMasterListener(reason, ClientStreamListener.RpcProgress.PROCESSED, new Metadata());
            return;
        }
        Substream winningSubstreamToCancel = null;
        synchronized (this.lock) {
            if (this.state.drainedSubstreams.contains(this.state.winningSubstream)) {
                winningSubstreamToCancel = this.state.winningSubstream;
            } else {
                this.cancellationStatus = reason;
            }
            this.state = this.state.cancelled();
        }
        if (winningSubstreamToCancel != null) {
            winningSubstreamToCancel.stream.cancel(reason);
        }
    }

    private void delayOrExecute(BufferEntry bufferEntry) {
        Collection<Substream> savedDrainedSubstreams;
        synchronized (this.lock) {
            if (!this.state.passThrough) {
                this.state.buffer.add(bufferEntry);
            }
            savedDrainedSubstreams = this.state.drainedSubstreams;
        }
        for (Substream substream : savedDrainedSubstreams) {
            bufferEntry.runWith(substream);
        }
    }

    public final void writeMessage(InputStream message) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    /* access modifiers changed from: package-private */
    public final void sendMessage(final ReqT message) {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.writeMessage(this.method.streamRequest(message));
        } else {
            delayOrExecute(new BufferEntry() {
                public void runWith(Substream substream) {
                    substream.stream.writeMessage(RetriableStream.this.method.streamRequest(message));
                    substream.stream.flush();
                }
            });
        }
    }

    public final void request(final int numMessages) {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.request(numMessages);
        } else {
            delayOrExecute(new BufferEntry() {
                public void runWith(Substream substream) {
                    substream.stream.request(numMessages);
                }
            });
        }
    }

    public final void flush() {
        State savedState = this.state;
        if (savedState.passThrough) {
            savedState.winningSubstream.stream.flush();
        } else {
            delayOrExecute(new BufferEntry() {
                public void runWith(Substream substream) {
                    substream.stream.flush();
                }
            });
        }
    }

    public final boolean isReady() {
        for (Substream substream : this.state.drainedSubstreams) {
            if (substream.stream.isReady()) {
                return true;
            }
        }
        return false;
    }

    public void optimizeForDirectExecutor() {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.optimizeForDirectExecutor();
            }
        });
    }

    public final void setCompressor(final Compressor compressor) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setCompressor(compressor);
            }
        });
    }

    public final void setFullStreamDecompression(final boolean fullStreamDecompression) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setFullStreamDecompression(fullStreamDecompression);
            }
        });
    }

    public final void setMessageCompression(final boolean enable) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setMessageCompression(enable);
            }
        });
    }

    public final void halfClose() {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.halfClose();
            }
        });
    }

    public final void setAuthority(final String authority) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setAuthority(authority);
            }
        });
    }

    public final void setDecompressorRegistry(final DecompressorRegistry decompressorRegistry) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setDecompressorRegistry(decompressorRegistry);
            }
        });
    }

    public final void setMaxInboundMessageSize(final int maxSize) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setMaxInboundMessageSize(maxSize);
            }
        });
    }

    public final void setMaxOutboundMessageSize(final int maxSize) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setMaxOutboundMessageSize(maxSize);
            }
        });
    }

    public final void setDeadline(final Deadline deadline) {
        delayOrExecute(new BufferEntry() {
            public void runWith(Substream substream) {
                substream.stream.setDeadline(deadline);
            }
        });
    }

    public final Attributes getAttributes() {
        if (this.state.winningSubstream != null) {
            return this.state.winningSubstream.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    public void appendTimeoutInsight(InsightBuilder insight) {
        State currentState;
        synchronized (this.lock) {
            insight.appendKeyValue("closed", this.closedSubstreamsInsight);
            currentState = this.state;
        }
        if (currentState.winningSubstream != null) {
            InsightBuilder substreamInsight = new InsightBuilder();
            currentState.winningSubstream.stream.appendTimeoutInsight(substreamInsight);
            insight.appendKeyValue("committed", substreamInsight);
            return;
        }
        InsightBuilder openSubstreamsInsight = new InsightBuilder();
        for (Substream sub : currentState.drainedSubstreams) {
            InsightBuilder substreamInsight2 = new InsightBuilder();
            sub.stream.appendTimeoutInsight(substreamInsight2);
            openSubstreamsInsight.append(substreamInsight2);
        }
        insight.appendKeyValue("open", openSubstreamsInsight);
    }

    static void setRandom(Random random2) {
        random = random2;
    }

    /* access modifiers changed from: private */
    public boolean hasPotentialHedging(State state2) {
        return state2.winningSubstream == null && state2.hedgingAttemptCount < this.hedgingPolicy.maxAttempts && !state2.hedgingFrozen;
    }

    /* access modifiers changed from: private */
    public void freezeHedging() {
        Future<?> futureToBeCancelled = null;
        synchronized (this.lock) {
            if (this.scheduledHedging != null) {
                futureToBeCancelled = this.scheduledHedging.markCancelled();
                this.scheduledHedging = null;
            }
            this.state = this.state.freezeHedging();
        }
        if (futureToBeCancelled != null) {
            futureToBeCancelled.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public void safeCloseMasterListener(final Status status, final ClientStreamListener.RpcProgress progress, final Metadata metadata) {
        this.savedCloseMasterListenerReason = new SavedCloseMasterListenerReason(status, progress, metadata);
        if (this.inFlightSubStreams.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.listenerSerializeExecutor.execute(new Runnable() {
                public void run() {
                    boolean unused = RetriableStream.this.isClosed = true;
                    RetriableStream.this.masterListener.closed(status, progress, metadata);
                }
            });
        }
    }

    private static final class SavedCloseMasterListenerReason {
        /* access modifiers changed from: private */
        public final Metadata metadata;
        /* access modifiers changed from: private */
        public final ClientStreamListener.RpcProgress progress;
        /* access modifiers changed from: private */
        public final Status status;

        SavedCloseMasterListenerReason(Status status2, ClientStreamListener.RpcProgress progress2, Metadata metadata2) {
            this.status = status2;
            this.progress = progress2;
            this.metadata = metadata2;
        }
    }

    private final class Sublistener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final Substream substream;

        static {
            Class<RetriableStream> cls = RetriableStream.class;
        }

        Sublistener(Substream substream2) {
            this.substream = substream2;
        }

        public void headersRead(final Metadata headers) {
            if (this.substream.previousAttemptCount > 0) {
                headers.discardAll(RetriableStream.GRPC_PREVIOUS_RPC_ATTEMPTS);
                headers.put(RetriableStream.GRPC_PREVIOUS_RPC_ATTEMPTS, String.valueOf(this.substream.previousAttemptCount));
            }
            RetriableStream.this.commitAndRun(this.substream);
            if (RetriableStream.this.state.winningSubstream == this.substream) {
                if (RetriableStream.this.throttle != null) {
                    RetriableStream.this.throttle.onSuccess();
                }
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() {
                    public void run() {
                        RetriableStream.this.masterListener.headersRead(headers);
                    }
                });
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0139, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void closed(io.grpc.Status r9, io.grpc.internal.ClientStreamListener.RpcProgress r10, io.grpc.Metadata r11) {
            /*
                r8 = this;
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream$State r2 = r2.state     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream$Substream r3 = r8.substream     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream$State r2 = r2.substreamClosed(r3)     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream.State unused = r1.state = r2     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.InsightBuilder r1 = r1.closedSubstreamsInsight     // Catch:{ all -> 0x01e3 }
                io.grpc.Status$Code r2 = r9.getCode()     // Catch:{ all -> 0x01e3 }
                r1.append(r2)     // Catch:{ all -> 0x01e3 }
                monitor-exit(r0)     // Catch:{ all -> 0x01e3 }
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.inFlightSubStreams
                int r0 = r0.decrementAndGet()
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r0 != r1) goto L_0x0051
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$SavedCloseMasterListenerReason r0 = r0.savedCloseMasterListenerReason
                if (r0 == 0) goto L_0x004b
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.Executor r0 = r0.listenerSerializeExecutor
                io.grpc.internal.RetriableStream$Sublistener$2 r1 = new io.grpc.internal.RetriableStream$Sublistener$2
                r1.<init>()
                r0.execute(r1)
                return
            L_0x004b:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0051:
                io.grpc.internal.RetriableStream$Substream r0 = r8.substream
                boolean r0 = r0.bufferLimitExceeded
                if (r0 == 0) goto L_0x0070
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                r0.commitAndRun(r1)
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = r0.state
                io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                if (r0 != r1) goto L_0x006f
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                r0.safeCloseMasterListener(r9, r10, r11)
            L_0x006f:
                return
            L_0x0070:
                io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.MISCARRIED
                if (r10 != r0) goto L_0x00ab
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.localOnlyTransparentRetries
                int r0 = r0.incrementAndGet()
                r1 = 1000(0x3e8, float:1.401E-42)
                if (r0 <= r1) goto L_0x00ab
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                r0.commitAndRun(r1)
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = r0.state
                io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                if (r0 != r1) goto L_0x00aa
                io.grpc.Status r0 = io.grpc.Status.INTERNAL
                java.lang.String r1 = "Too many transparent retries. Might be a bug in gRPC"
                io.grpc.Status r0 = r0.withDescription(r1)
                io.grpc.StatusRuntimeException r1 = r9.asRuntimeException()
                io.grpc.Status r0 = r0.withCause(r1)
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                r1.safeCloseMasterListener(r0, r10, r11)
            L_0x00aa:
                return
            L_0x00ab:
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = r0.state
                io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
                if (r0 != 0) goto L_0x01ca
                io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.MISCARRIED
                r1 = 1
                if (r10 == r0) goto L_0x0189
                io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.REFUSED
                r2 = 0
                if (r10 != r0) goto L_0x00cd
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.noMoreTransparentRetry
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x00cd
                goto L_0x0189
            L_0x00cd:
                io.grpc.internal.ClientStreamListener$RpcProgress r0 = io.grpc.internal.ClientStreamListener.RpcProgress.DROPPED
                if (r10 != r0) goto L_0x00e0
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                boolean r0 = r0.isHedging
                if (r0 == 0) goto L_0x01ca
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                r0.freezeHedging()
                goto L_0x01ca
            L_0x00e0:
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.noMoreTransparentRetry
                r0.set(r1)
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                boolean r0 = r0.isHedging
                if (r0 == 0) goto L_0x0140
                io.grpc.internal.RetriableStream$HedgingPlan r0 = r8.makeHedgingDecision(r9, r11)
                boolean r1 = r0.isHedgeable
                if (r1 == 0) goto L_0x0100
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.lang.Integer r2 = r0.hedgingPushbackMillis
                r1.pushbackHedging(r2)
            L_0x0100:
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.lang.Object r3 = r1.lock
                monitor-enter(r3)
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream$State r2 = r2.state     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream$Substream r4 = r8.substream     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream$State r2 = r2.removeActiveHedge(r4)     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream.State unused = r1.state = r2     // Catch:{ all -> 0x013d }
                boolean r1 = r0.isHedgeable     // Catch:{ all -> 0x013d }
                if (r1 == 0) goto L_0x013a
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream$State r2 = r2.state     // Catch:{ all -> 0x013d }
                boolean r1 = r1.hasPotentialHedging(r2)     // Catch:{ all -> 0x013d }
                if (r1 != 0) goto L_0x0138
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x013d }
                io.grpc.internal.RetriableStream$State r1 = r1.state     // Catch:{ all -> 0x013d }
                java.util.Collection<io.grpc.internal.RetriableStream$Substream> r1 = r1.activeHedges     // Catch:{ all -> 0x013d }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x013d }
                if (r1 != 0) goto L_0x013a
            L_0x0138:
                monitor-exit(r3)     // Catch:{ all -> 0x013d }
                return
            L_0x013a:
                monitor-exit(r3)     // Catch:{ all -> 0x013d }
                goto L_0x01ca
            L_0x013d:
                r1 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x013d }
                throw r1
            L_0x0140:
                io.grpc.internal.RetriableStream$RetryPlan r0 = r8.makeRetryDecision(r9, r11)
                boolean r3 = r0.shouldRetry
                if (r3 == 0) goto L_0x01ca
                io.grpc.internal.RetriableStream r3 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$Substream r4 = r8.substream
                int r4 = r4.previousAttemptCount
                int r4 = r4 + r1
                io.grpc.internal.RetriableStream$Substream r1 = r3.createSubstream(r4, r2)
                if (r1 != 0) goto L_0x0156
                return
            L_0x0156:
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this
                java.lang.Object r2 = r2.lock
                monitor-enter(r2)
                io.grpc.internal.RetriableStream r3 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0186 }
                io.grpc.internal.RetriableStream$FutureCanceller r4 = new io.grpc.internal.RetriableStream$FutureCanceller     // Catch:{ all -> 0x0186 }
                io.grpc.internal.RetriableStream r5 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0186 }
                java.lang.Object r5 = r5.lock     // Catch:{ all -> 0x0186 }
                r4.<init>(r5)     // Catch:{ all -> 0x0186 }
                r5 = r4
                io.grpc.internal.RetriableStream.FutureCanceller unused = r3.scheduledRetry = r4     // Catch:{ all -> 0x0186 }
                monitor-exit(r2)     // Catch:{ all -> 0x0186 }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.ScheduledExecutorService r2 = r2.scheduledExecutorService
                io.grpc.internal.RetriableStream$Sublistener$1RetryBackoffRunnable r3 = new io.grpc.internal.RetriableStream$Sublistener$1RetryBackoffRunnable
                r3.<init>(r1)
                long r6 = r0.backoffNanos
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                java.util.concurrent.ScheduledFuture r2 = r2.schedule(r3, r6, r4)
                r5.setFuture(r2)
                return
            L_0x0186:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0186 }
                throw r3
            L_0x0189:
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$Substream r2 = r8.substream
                int r2 = r2.previousAttemptCount
                io.grpc.internal.RetriableStream$Substream r0 = r0.createSubstream(r2, r1)
                if (r0 != 0) goto L_0x0196
                return
            L_0x0196:
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                boolean r1 = r1.isHedging
                if (r1 == 0) goto L_0x01bb
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x01b8 }
                io.grpc.internal.RetriableStream r3 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x01b8 }
                io.grpc.internal.RetriableStream$State r3 = r3.state     // Catch:{ all -> 0x01b8 }
                io.grpc.internal.RetriableStream$Substream r4 = r8.substream     // Catch:{ all -> 0x01b8 }
                io.grpc.internal.RetriableStream$State r3 = r3.replaceActiveHedge(r4, r0)     // Catch:{ all -> 0x01b8 }
                io.grpc.internal.RetriableStream.State unused = r2.state = r3     // Catch:{ all -> 0x01b8 }
                monitor-exit(r1)     // Catch:{ all -> 0x01b8 }
                goto L_0x01bb
            L_0x01b8:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01b8 }
                throw r2
            L_0x01bb:
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.util.concurrent.Executor r1 = r1.callExecutor
                io.grpc.internal.RetriableStream$Sublistener$3 r2 = new io.grpc.internal.RetriableStream$Sublistener$3
                r2.<init>(r0)
                r1.execute(r2)
                return
            L_0x01ca:
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                r0.commitAndRun(r1)
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = r0.state
                io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
                io.grpc.internal.RetriableStream$Substream r1 = r8.substream
                if (r0 != r1) goto L_0x01e2
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                r0.safeCloseMasterListener(r9, r10, r11)
            L_0x01e2:
                return
            L_0x01e3:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x01e3 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.Sublistener.closed(io.grpc.Status, io.grpc.internal.ClientStreamListener$RpcProgress, io.grpc.Metadata):void");
        }

        private RetryPlan makeRetryDecision(Status status, Metadata trailer) {
            if (RetriableStream.this.retryPolicy == null) {
                return new RetryPlan(false, 0);
            }
            boolean shouldRetry = false;
            long backoffNanos = 0;
            boolean isRetryableStatusCode = RetriableStream.this.retryPolicy.retryableStatusCodes.contains(status.getCode());
            Integer pushbackMillis = getPushbackMills(trailer);
            boolean isThrottled = false;
            if (RetriableStream.this.throttle != null && (isRetryableStatusCode || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            }
            if (RetriableStream.this.retryPolicy.maxAttempts > this.substream.previousAttemptCount + 1 && !isThrottled) {
                if (pushbackMillis == null) {
                    if (isRetryableStatusCode) {
                        shouldRetry = true;
                        backoffNanos = (long) (((double) RetriableStream.this.nextBackoffIntervalNanos) * RetriableStream.random.nextDouble());
                        long unused = RetriableStream.this.nextBackoffIntervalNanos = Math.min((long) (((double) RetriableStream.this.nextBackoffIntervalNanos) * RetriableStream.this.retryPolicy.backoffMultiplier), RetriableStream.this.retryPolicy.maxBackoffNanos);
                    }
                } else if (pushbackMillis.intValue() >= 0) {
                    shouldRetry = true;
                    backoffNanos = TimeUnit.MILLISECONDS.toNanos((long) pushbackMillis.intValue());
                    long unused2 = RetriableStream.this.nextBackoffIntervalNanos = RetriableStream.this.retryPolicy.initialBackoffNanos;
                }
            }
            return new RetryPlan(shouldRetry, backoffNanos);
        }

        private HedgingPlan makeHedgingDecision(Status status, Metadata trailer) {
            Integer pushbackMillis = getPushbackMills(trailer);
            boolean z = true;
            boolean isFatal = !RetriableStream.this.hedgingPolicy.nonFatalStatusCodes.contains(status.getCode());
            boolean isThrottled = false;
            if (RetriableStream.this.throttle != null && (!isFatal || (pushbackMillis != null && pushbackMillis.intValue() < 0))) {
                isThrottled = !RetriableStream.this.throttle.onQualifiedFailureThenCheckIsAboveThreshold();
            }
            if (!isFatal && !isThrottled && !status.isOk() && pushbackMillis != null && pushbackMillis.intValue() > 0) {
                pushbackMillis = 0;
            }
            if (isFatal || isThrottled) {
                z = false;
            }
            return new HedgingPlan(z, pushbackMillis);
        }

        @Nullable
        private Integer getPushbackMills(Metadata trailer) {
            String pushbackStr = (String) trailer.get(RetriableStream.GRPC_RETRY_PUSHBACK_MS);
            if (pushbackStr == null) {
                return null;
            }
            try {
                return Integer.valueOf(pushbackStr);
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            State savedState = RetriableStream.this.state;
            Preconditions.checkState(savedState.winningSubstream != null, "Headers should be received prior to messages.");
            if (savedState.winningSubstream != this.substream) {
                GrpcUtil.closeQuietly(producer);
            } else {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() {
                    public void run() {
                        RetriableStream.this.masterListener.messagesAvailable(producer);
                    }
                });
            }
        }

        public void onReady() {
            if (RetriableStream.this.isReady()) {
                RetriableStream.this.listenerSerializeExecutor.execute(new Runnable() {
                    public void run() {
                        if (!RetriableStream.this.isClosed) {
                            RetriableStream.this.masterListener.onReady();
                        }
                    }
                });
            }
        }
    }

    private static final class State {
        final Collection<Substream> activeHedges;
        @Nullable
        final List<BufferEntry> buffer;
        final boolean cancelled;
        final Collection<Substream> drainedSubstreams;
        final int hedgingAttemptCount;
        final boolean hedgingFrozen;
        final boolean passThrough;
        @Nullable
        final Substream winningSubstream;

        State(@Nullable List<BufferEntry> buffer2, Collection<Substream> drainedSubstreams2, Collection<Substream> activeHedges2, @Nullable Substream winningSubstream2, boolean cancelled2, boolean passThrough2, boolean hedgingFrozen2, int hedgingAttemptCount2) {
            this.buffer = buffer2;
            this.drainedSubstreams = (Collection) Preconditions.checkNotNull(drainedSubstreams2, "drainedSubstreams");
            this.winningSubstream = winningSubstream2;
            this.activeHedges = activeHedges2;
            this.cancelled = cancelled2;
            this.passThrough = passThrough2;
            this.hedgingFrozen = hedgingFrozen2;
            this.hedgingAttemptCount = hedgingAttemptCount2;
            boolean z = false;
            Preconditions.checkState(!passThrough2 || buffer2 == null, "passThrough should imply buffer is null");
            Preconditions.checkState(!passThrough2 || winningSubstream2 != null, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!passThrough2 || (drainedSubstreams2.size() == 1 && drainedSubstreams2.contains(winningSubstream2)) || (drainedSubstreams2.size() == 0 && winningSubstream2.closed), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((!cancelled2 || winningSubstream2 != null) ? true : z, "cancelled should imply committed");
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State cancelled() {
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, true, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State substreamDrained(Substream substream) {
            Collection<Substream> drainedSubstreams2;
            List<BufferEntry> buffer2;
            boolean z = true;
            Preconditions.checkState(!this.passThrough, "Already passThrough");
            if (substream.closed) {
                drainedSubstreams2 = this.drainedSubstreams;
            } else if (this.drainedSubstreams.isEmpty()) {
                drainedSubstreams2 = Collections.singletonList(substream);
            } else {
                ArrayList arrayList = new ArrayList(this.drainedSubstreams);
                arrayList.add(substream);
                drainedSubstreams2 = Collections.unmodifiableCollection(arrayList);
            }
            boolean passThrough2 = this.winningSubstream != null;
            List<BufferEntry> buffer3 = this.buffer;
            if (passThrough2) {
                if (this.winningSubstream != substream) {
                    z = false;
                }
                Preconditions.checkState(z, "Another RPC attempt has already committed");
                buffer2 = null;
            } else {
                buffer2 = buffer3;
            }
            return new State(buffer2, drainedSubstreams2, this.activeHedges, this.winningSubstream, this.cancelled, passThrough2, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State substreamClosed(Substream substream) {
            substream.closed = true;
            if (!this.drainedSubstreams.contains(substream)) {
                return this;
            }
            Collection<Substream> drainedSubstreams2 = new ArrayList<>(this.drainedSubstreams);
            drainedSubstreams2.remove(substream);
            return new State(this.buffer, Collections.unmodifiableCollection(drainedSubstreams2), this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State committed(Substream winningSubstream2) {
            Collection<Substream> drainedSubstreams2;
            Preconditions.checkState(this.winningSubstream == null, "Already committed");
            boolean passThrough2 = false;
            List<BufferEntry> buffer2 = this.buffer;
            if (this.drainedSubstreams.contains(winningSubstream2)) {
                passThrough2 = true;
                buffer2 = null;
                drainedSubstreams2 = Collections.singleton(winningSubstream2);
            } else {
                drainedSubstreams2 = Collections.emptyList();
            }
            return new State(buffer2, drainedSubstreams2, this.activeHedges, winningSubstream2, this.cancelled, passThrough2, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State freezeHedging() {
            if (this.hedgingFrozen) {
                return this;
            }
            return new State(this.buffer, this.drainedSubstreams, this.activeHedges, this.winningSubstream, this.cancelled, this.passThrough, true, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State addActiveHedge(Substream substream) {
            Collection<Substream> activeHedges2;
            Preconditions.checkState(!this.hedgingFrozen, "hedging frozen");
            Preconditions.checkState(this.winningSubstream == null, "already committed");
            if (this.activeHedges == null) {
                activeHedges2 = Collections.singleton(substream);
            } else {
                Collection<Substream> activeHedges3 = new ArrayList<>(this.activeHedges);
                activeHedges3.add(substream);
                activeHedges2 = Collections.unmodifiableCollection(activeHedges3);
            }
            return new State(this.buffer, this.drainedSubstreams, activeHedges2, this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, 1 + this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State removeActiveHedge(Substream substream) {
            Collection<Substream> activeHedges2 = new ArrayList<>(this.activeHedges);
            activeHedges2.remove(substream);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(activeHedges2), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }

        /* access modifiers changed from: package-private */
        @CheckReturnValue
        public State replaceActiveHedge(Substream oldOne, Substream newOne) {
            Collection<Substream> activeHedges2 = new ArrayList<>(this.activeHedges);
            activeHedges2.remove(oldOne);
            activeHedges2.add(newOne);
            return new State(this.buffer, this.drainedSubstreams, Collections.unmodifiableCollection(activeHedges2), this.winningSubstream, this.cancelled, this.passThrough, this.hedgingFrozen, this.hedgingAttemptCount);
        }
    }

    private static final class Substream {
        boolean bufferLimitExceeded;
        boolean closed;
        final int previousAttemptCount;
        ClientStream stream;

        Substream(int previousAttemptCount2) {
            this.previousAttemptCount = previousAttemptCount2;
        }
    }

    class BufferSizeTracer extends ClientStreamTracer {
        long bufferNeeded;
        private final Substream substream;

        BufferSizeTracer(Substream substream2) {
            this.substream = substream2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
            r0.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void outboundWireSize(long r9) {
            /*
                r8 = this;
                io.grpc.internal.RetriableStream r0 = io.grpc.internal.RetriableStream.this
                io.grpc.internal.RetriableStream$State r0 = r0.state
                io.grpc.internal.RetriableStream$Substream r0 = r0.winningSubstream
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                r0 = 0
                io.grpc.internal.RetriableStream r1 = io.grpc.internal.RetriableStream.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream$State r2 = r2.state     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream$Substream r2 = r2.winningSubstream     // Catch:{ all -> 0x0089 }
                if (r2 != 0) goto L_0x0087
                io.grpc.internal.RetriableStream$Substream r2 = r8.substream     // Catch:{ all -> 0x0089 }
                boolean r2 = r2.closed     // Catch:{ all -> 0x0089 }
                if (r2 == 0) goto L_0x0024
                goto L_0x0087
            L_0x0024:
                long r2 = r8.bufferNeeded     // Catch:{ all -> 0x0089 }
                long r2 = r2 + r9
                r8.bufferNeeded = r2     // Catch:{ all -> 0x0089 }
                long r2 = r8.bufferNeeded     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream r4 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                long r4 = r4.perRpcBufferUsed     // Catch:{ all -> 0x0089 }
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L_0x0037
                monitor-exit(r1)     // Catch:{ all -> 0x0089 }
                return
            L_0x0037:
                long r2 = r8.bufferNeeded     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream r4 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                long r4 = r4.perRpcBufferLimit     // Catch:{ all -> 0x0089 }
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r3 = 1
                if (r2 <= 0) goto L_0x0049
                io.grpc.internal.RetriableStream$Substream r2 = r8.substream     // Catch:{ all -> 0x0089 }
                r2.bufferLimitExceeded = r3     // Catch:{ all -> 0x0089 }
                goto L_0x0071
            L_0x0049:
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream$ChannelBufferMeter r2 = r2.channelBufferUsed     // Catch:{ all -> 0x0089 }
                long r4 = r8.bufferNeeded     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream r6 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                long r6 = r6.perRpcBufferUsed     // Catch:{ all -> 0x0089 }
                long r4 = r4 - r6
                long r4 = r2.addAndGet(r4)     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                long r6 = r8.bufferNeeded     // Catch:{ all -> 0x0089 }
                long unused = r2.perRpcBufferUsed = r6     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                long r6 = r2.channelBufferLimit     // Catch:{ all -> 0x0089 }
                int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r2 <= 0) goto L_0x0071
                io.grpc.internal.RetriableStream$Substream r2 = r8.substream     // Catch:{ all -> 0x0089 }
                r2.bufferLimitExceeded = r3     // Catch:{ all -> 0x0089 }
            L_0x0071:
                io.grpc.internal.RetriableStream$Substream r2 = r8.substream     // Catch:{ all -> 0x0089 }
                boolean r2 = r2.bufferLimitExceeded     // Catch:{ all -> 0x0089 }
                if (r2 == 0) goto L_0x0080
                io.grpc.internal.RetriableStream r2 = io.grpc.internal.RetriableStream.this     // Catch:{ all -> 0x0089 }
                io.grpc.internal.RetriableStream$Substream r3 = r8.substream     // Catch:{ all -> 0x0089 }
                java.lang.Runnable r2 = r2.commit(r3)     // Catch:{ all -> 0x0089 }
                r0 = r2
            L_0x0080:
                monitor-exit(r1)     // Catch:{ all -> 0x0089 }
                if (r0 == 0) goto L_0x0086
                r0.run()
            L_0x0086:
                return
            L_0x0087:
                monitor-exit(r1)     // Catch:{ all -> 0x0089 }
                return
            L_0x0089:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0089 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.RetriableStream.BufferSizeTracer.outboundWireSize(long):void");
        }
    }

    static final class ChannelBufferMeter {
        private final AtomicLong bufferUsed = new AtomicLong();

        ChannelBufferMeter() {
        }

        /* access modifiers changed from: package-private */
        public long addAndGet(long newBytesUsed) {
            return this.bufferUsed.addAndGet(newBytesUsed);
        }
    }

    static final class Throttle {
        private static final int THREE_DECIMAL_PLACES_SCALE_UP = 1000;
        final int maxTokens;
        final int threshold;
        final AtomicInteger tokenCount = new AtomicInteger();
        final int tokenRatio;

        Throttle(float maxTokens2, float tokenRatio2) {
            this.tokenRatio = (int) (tokenRatio2 * 1000.0f);
            this.maxTokens = (int) (1000.0f * maxTokens2);
            this.threshold = this.maxTokens / 2;
            this.tokenCount.set(this.maxTokens);
        }

        /* access modifiers changed from: package-private */
        public boolean isAboveThreshold() {
            return this.tokenCount.get() > this.threshold;
        }

        /* access modifiers changed from: package-private */
        public boolean onQualifiedFailureThenCheckIsAboveThreshold() {
            int currentCount;
            int decremented;
            do {
                currentCount = this.tokenCount.get();
                if (currentCount == 0) {
                    return false;
                }
                decremented = currentCount + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
            } while (!this.tokenCount.compareAndSet(currentCount, Math.max(decremented, 0)));
            if (decremented > this.threshold) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void onSuccess() {
            int currentCount;
            do {
                currentCount = this.tokenCount.get();
                if (currentCount == this.maxTokens || this.tokenCount.compareAndSet(currentCount, Math.min(this.tokenRatio + currentCount, this.maxTokens))) {
                }
                currentCount = this.tokenCount.get();
                return;
            } while (this.tokenCount.compareAndSet(currentCount, Math.min(this.tokenRatio + currentCount, this.maxTokens)));
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Throttle)) {
                return false;
            }
            Throttle that = (Throttle) o;
            if (this.maxTokens == that.maxTokens && this.tokenRatio == that.tokenRatio) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.maxTokens), Integer.valueOf(this.tokenRatio));
        }
    }

    private static final class RetryPlan {
        final long backoffNanos;
        final boolean shouldRetry;

        RetryPlan(boolean shouldRetry2, long backoffNanos2) {
            this.shouldRetry = shouldRetry2;
            this.backoffNanos = backoffNanos2;
        }
    }

    private static final class HedgingPlan {
        @Nullable
        final Integer hedgingPushbackMillis;
        final boolean isHedgeable;

        public HedgingPlan(boolean isHedgeable2, @Nullable Integer hedgingPushbackMillis2) {
            this.isHedgeable = isHedgeable2;
            this.hedgingPushbackMillis = hedgingPushbackMillis2;
        }
    }

    private static final class FutureCanceller {
        boolean cancelled;
        Future<?> future;
        final Object lock;

        FutureCanceller(Object lock2) {
            this.lock = lock2;
        }

        /* access modifiers changed from: package-private */
        public void setFuture(Future<?> future2) {
            synchronized (this.lock) {
                if (!this.cancelled) {
                    this.future = future2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public Future<?> markCancelled() {
            this.cancelled = true;
            return this.future;
        }

        /* access modifiers changed from: package-private */
        public boolean isCancelled() {
            return this.cancelled;
        }
    }
}
