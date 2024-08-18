package io.grpc.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalConfigSelector;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ManagedChannelServiceConfig;
import io.grpc.internal.StreamListener;
import io.perfmark.Link;
import io.perfmark.PerfMark;
import io.perfmark.Tag;
import io.perfmark.TaskCloseable;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
    private static final double NANO_TO_SECS = (((double) TimeUnit.SECONDS.toNanos(1)) * 1.0d);
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    /* access modifiers changed from: private */
    public final Executor callExecutor;
    private final boolean callExecutorIsDirect;
    private CallOptions callOptions;
    private boolean cancelCalled;
    /* access modifiers changed from: private */
    public volatile boolean cancelListenersShouldBeRemoved;
    private final ClientCallImpl<ReqT, RespT>.ContextCancellationListener cancellationListener = new ContextCancellationListener();
    /* access modifiers changed from: private */
    public final CallTracer channelCallsTracer;
    private final ClientStreamProvider clientStreamProvider;
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();
    /* access modifiers changed from: private */
    public final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, RespT> method;
    /* access modifiers changed from: private */
    public ClientStream stream;
    /* access modifiers changed from: private */
    public final Tag tag;
    private final boolean unaryRequest;

    interface ClientStreamProvider {
        ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    ClientCallImpl(MethodDescriptor<ReqT, RespT> method2, Executor executor, CallOptions callOptions2, ClientStreamProvider clientStreamProvider2, ScheduledExecutorService deadlineCancellationExecutor2, CallTracer channelCallsTracer2, @Nullable InternalConfigSelector configSelector) {
        this.method = method2;
        this.tag = PerfMark.createTag(method2.getFullMethodName(), (long) System.identityHashCode(this));
        boolean z = true;
        if (executor == MoreExecutors.directExecutor()) {
            this.callExecutor = new SerializeReentrantCallsDirectExecutor();
            this.callExecutorIsDirect = true;
        } else {
            this.callExecutor = new SerializingExecutor(executor);
            this.callExecutorIsDirect = false;
        }
        this.channelCallsTracer = channelCallsTracer2;
        this.context = Context.current();
        if (!(method2.getType() == MethodDescriptor.MethodType.UNARY || method2.getType() == MethodDescriptor.MethodType.SERVER_STREAMING)) {
            z = false;
        }
        this.unaryRequest = z;
        this.callOptions = callOptions2;
        this.clientStreamProvider = clientStreamProvider2;
        this.deadlineCancellationExecutor = deadlineCancellationExecutor2;
        PerfMark.event("ClientCall.<init>", this.tag);
    }

    private final class ContextCancellationListener implements Context.CancellationListener {
        private ContextCancellationListener() {
        }

        public void cancelled(Context context) {
            ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
        }
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean fullStreamDecompression2) {
        this.fullStreamDecompression = fullStreamDecompression2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry2) {
        this.decompressorRegistry = decompressorRegistry2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry2) {
        this.compressorRegistry = compressorRegistry2;
        return this;
    }

    static void prepareHeaders(Metadata headers, DecompressorRegistry decompressorRegistry2, Compressor compressor, boolean fullStreamDecompression2) {
        headers.discardAll(GrpcUtil.CONTENT_LENGTH_KEY);
        headers.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            headers.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        headers.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] advertisedEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry2);
        if (advertisedEncodings.length != 0) {
            headers.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, advertisedEncodings);
        }
        headers.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        headers.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (fullStreamDecompression2) {
            headers.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    public void start(ClientCall.Listener<RespT> observer, Metadata headers) {
        TaskCloseable ignore = PerfMark.traceTask("ClientCall.start");
        try {
            PerfMark.attachTag(this.tag);
            startInternal(observer, headers);
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

    private void startInternal(ClientCall.Listener<RespT> observer, Metadata headers) {
        Compressor compressor;
        boolean deadlineExceeded = true;
        Preconditions.checkState(this.stream == null, "Already started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkNotNull(observer, "observer");
        Preconditions.checkNotNull(headers, "headers");
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            final ClientCall.Listener<RespT> finalObserver = observer;
            this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    ClientCallImpl.this.closeObserver(finalObserver, Contexts.statusFromCancelled(ClientCallImpl.this.context), new Metadata());
                }
            });
            return;
        }
        applyMethodConfig();
        final String compressorName = this.callOptions.getCompressor();
        if (compressorName != null) {
            compressor = this.compressorRegistry.lookupCompressor(compressorName);
            if (compressor == null) {
                this.stream = NoopClientStream.INSTANCE;
                final ClientCall.Listener<RespT> finalObserver2 = observer;
                this.callExecutor.execute(new ContextRunnable() {
                    public void runInContext() {
                        ClientCallImpl.this.closeObserver(finalObserver2, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", new Object[]{compressorName})), new Metadata());
                    }
                });
                return;
            }
        } else {
            compressor = Codec.Identity.NONE;
        }
        prepareHeaders(headers, this.decompressorRegistry, compressor, this.fullStreamDecompression);
        Deadline effectiveDeadline = effectiveDeadline();
        if (effectiveDeadline == null || !effectiveDeadline.isExpired()) {
            deadlineExceeded = false;
        }
        if (!deadlineExceeded) {
            logIfContextNarrowedTimeout(effectiveDeadline, this.context.getDeadline(), this.callOptions.getDeadline());
            this.stream = this.clientStreamProvider.newStream(this.method, this.callOptions, headers, this.context);
        } else {
            this.stream = new FailingClientStream(Status.DEADLINE_EXCEEDED.withDescription(String.format("ClientCall started after %s deadline was exceeded .9%f seconds ago", new Object[]{isFirstMin(this.callOptions.getDeadline(), this.context.getDeadline()) ? "CallOptions" : "Context", Double.valueOf(((double) effectiveDeadline.timeRemaining(TimeUnit.NANOSECONDS)) / NANO_TO_SECS)})), GrpcUtil.getClientStreamTracers(this.callOptions, headers, 0, false));
        }
        if (this.callExecutorIsDirect) {
            this.stream.optimizeForDirectExecutor();
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        if (this.callOptions.getMaxInboundMessageSize() != null) {
            this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue());
        }
        if (this.callOptions.getMaxOutboundMessageSize() != null) {
            this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue());
        }
        if (effectiveDeadline != null) {
            this.stream.setDeadline(effectiveDeadline);
        }
        this.stream.setCompressor(compressor);
        if (this.fullStreamDecompression) {
            this.stream.setFullStreamDecompression(this.fullStreamDecompression);
        }
        this.stream.setDecompressorRegistry(this.decompressorRegistry);
        this.channelCallsTracer.reportCallStarted();
        this.stream.start(new ClientStreamListenerImpl(observer));
        this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
        if (!(effectiveDeadline == null || effectiveDeadline.equals(this.context.getDeadline()) || this.deadlineCancellationExecutor == null)) {
            this.deadlineCancellationFuture = startDeadlineTimer(effectiveDeadline);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    private void applyMethodConfig() {
        ManagedChannelServiceConfig.MethodInfo info = (ManagedChannelServiceConfig.MethodInfo) this.callOptions.getOption(ManagedChannelServiceConfig.MethodInfo.KEY);
        if (info != null) {
            if (info.timeoutNanos != null) {
                Deadline newDeadline = Deadline.after(info.timeoutNanos.longValue(), TimeUnit.NANOSECONDS);
                Deadline existingDeadline = this.callOptions.getDeadline();
                if (existingDeadline == null || newDeadline.compareTo(existingDeadline) < 0) {
                    this.callOptions = this.callOptions.withDeadline(newDeadline);
                }
            }
            if (info.waitForReady != null) {
                this.callOptions = info.waitForReady.booleanValue() ? this.callOptions.withWaitForReady() : this.callOptions.withoutWaitForReady();
            }
            if (info.maxInboundMessageSize != null) {
                Integer existingLimit = this.callOptions.getMaxInboundMessageSize();
                if (existingLimit != null) {
                    this.callOptions = this.callOptions.withMaxInboundMessageSize(Math.min(existingLimit.intValue(), info.maxInboundMessageSize.intValue()));
                } else {
                    this.callOptions = this.callOptions.withMaxInboundMessageSize(info.maxInboundMessageSize.intValue());
                }
            }
            if (info.maxOutboundMessageSize != null) {
                Integer existingLimit2 = this.callOptions.getMaxOutboundMessageSize();
                if (existingLimit2 != null) {
                    this.callOptions = this.callOptions.withMaxOutboundMessageSize(Math.min(existingLimit2.intValue(), info.maxOutboundMessageSize.intValue()));
                } else {
                    this.callOptions = this.callOptions.withMaxOutboundMessageSize(info.maxOutboundMessageSize.intValue());
                }
            }
        }
    }

    private static void logIfContextNarrowedTimeout(Deadline effectiveDeadline, @Nullable Deadline outerCallDeadline, @Nullable Deadline callDeadline) {
        if (log.isLoggable(Level.FINE) && effectiveDeadline != null && effectiveDeadline.equals(outerCallDeadline)) {
            StringBuilder builder = new StringBuilder(String.format(Locale.US, "Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(Math.max(0, effectiveDeadline.timeRemaining(TimeUnit.NANOSECONDS)))}));
            if (callDeadline == null) {
                builder.append(" Explicit call timeout was not set.");
            } else {
                builder.append(String.format(Locale.US, " Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(callDeadline.timeRemaining(TimeUnit.NANOSECONDS))}));
            }
            log.fine(builder.toString());
        }
    }

    /* access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> f = this.deadlineCancellationFuture;
        if (f != null) {
            f.cancel(false);
        }
    }

    private class DeadlineTimer implements Runnable {
        private final long remainingNanos;

        DeadlineTimer(long remainingNanos2) {
            this.remainingNanos = remainingNanos2;
        }

        public void run() {
            InsightBuilder insight = new InsightBuilder();
            ClientCallImpl.this.stream.appendTimeoutInsight(insight);
            long seconds = Math.abs(this.remainingNanos) / TimeUnit.SECONDS.toNanos(1);
            long nanos = Math.abs(this.remainingNanos) % TimeUnit.SECONDS.toNanos(1);
            StringBuilder buf = new StringBuilder();
            buf.append("deadline exceeded after ");
            if (this.remainingNanos < 0) {
                buf.append('-');
            }
            buf.append(seconds);
            buf.append(String.format(Locale.US, ".%09d", new Object[]{Long.valueOf(nanos)}));
            buf.append("s. ");
            buf.append(insight);
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(buf.toString()));
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        long remainingNanos = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(remainingNanos)), remainingNanos, TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline0, @Nullable Deadline deadline1) {
        if (deadline0 == null) {
            return deadline1;
        }
        if (deadline1 == null) {
            return deadline0;
        }
        return deadline0.minimum(deadline1);
    }

    private static boolean isFirstMin(@Nullable Deadline deadline0, @Nullable Deadline deadline1) {
        if (deadline0 == null) {
            return false;
        }
        if (deadline1 == null) {
            return true;
        }
        return deadline0.isBefore(deadline1);
    }

    public void request(int numMessages) {
        TaskCloseable ignore = PerfMark.traceTask("ClientCall.request");
        try {
            PerfMark.attachTag(this.tag);
            boolean z = true;
            Preconditions.checkState(this.stream != null, "Not started");
            if (numMessages < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "Number requested must be non-negative");
            this.stream.request(numMessages);
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

    public void cancel(@Nullable String message, @Nullable Throwable cause) {
        TaskCloseable ignore = PerfMark.traceTask("ClientCall.cancel");
        try {
            PerfMark.attachTag(this.tag);
            cancelInternal(message, cause);
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

    private void cancelInternal(@Nullable String message, @Nullable Throwable cause) {
        Status status;
        if (message == null && cause == null) {
            cause = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", cause);
        }
        if (!this.cancelCalled) {
            this.cancelCalled = true;
            try {
                if (this.stream != null) {
                    Status status2 = Status.CANCELLED;
                    if (message != null) {
                        status = status2.withDescription(message);
                    } else {
                        status = status2.withDescription("Call cancelled without message");
                    }
                    if (cause != null) {
                        status = status.withCause(cause);
                    }
                    this.stream.cancel(status);
                }
            } finally {
                removeContextListenerAndCancelDeadlineFuture();
            }
        }
    }

    public void halfClose() {
        TaskCloseable ignore = PerfMark.traceTask("ClientCall.halfClose");
        try {
            PerfMark.attachTag(this.tag);
            halfCloseInternal();
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

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    public void sendMessage(ReqT message) {
        TaskCloseable ignore = PerfMark.traceTask("ClientCall.sendMessage");
        try {
            PerfMark.attachTag(this.tag);
            sendMessageInternal(message);
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

    private void sendMessageInternal(ReqT message) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                ((RetriableStream) this.stream).sendMessage(message);
            } else {
                this.stream.writeMessage(this.method.streamRequest(message));
            }
            if (!this.unaryRequest) {
                this.stream.flush();
            }
        } catch (RuntimeException e) {
            this.stream.cancel(Status.CANCELLED.withCause(e).withDescription("Failed to stream message"));
        } catch (Error e2) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e2;
        }
    }

    public void setMessageCompression(boolean enabled) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(enabled);
    }

    public boolean isReady() {
        if (this.halfCloseCalled) {
            return false;
        }
        return this.stream.isReady();
    }

    public Attributes getAttributes() {
        if (this.stream != null) {
            return this.stream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    /* access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> observer, Status status, Metadata trailers) {
        observer.onClose(status, trailers);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("method", (Object) this.method).toString();
    }

    private class ClientStreamListenerImpl implements ClientStreamListener {
        /* access modifiers changed from: private */
        public Status exceptionStatus;
        /* access modifiers changed from: private */
        public final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> observer2) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(observer2, "observer");
        }

        /* access modifiers changed from: private */
        public void exceptionThrown(Status status) {
            this.exceptionStatus = status;
            ClientCallImpl.this.stream.cancel(status);
        }

        public void headersRead(final Metadata headers) {
            TaskCloseable ignore = PerfMark.traceTask("ClientStreamListener.headersRead");
            try {
                PerfMark.attachTag(ClientCallImpl.this.tag);
                final Link link = PerfMark.linkOut();
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                    public void runInContext() {
                        TaskCloseable ignore = PerfMark.traceTask("ClientCall$Listener.headersRead");
                        try {
                            PerfMark.attachTag(ClientCallImpl.this.tag);
                            PerfMark.linkIn(link);
                            runInternal();
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

                    private void runInternal() {
                        if (ClientStreamListenerImpl.this.exceptionStatus == null) {
                            try {
                                ClientStreamListenerImpl.this.observer.onHeaders(headers);
                            } catch (Throwable t) {
                                ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to read headers"));
                            }
                        }
                    }
                });
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

        public void messagesAvailable(final StreamListener.MessageProducer producer) {
            TaskCloseable ignore = PerfMark.traceTask("ClientStreamListener.messagesAvailable");
            try {
                PerfMark.attachTag(ClientCallImpl.this.tag);
                final Link link = PerfMark.linkOut();
                ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                    public void runInContext() {
                        TaskCloseable ignore = PerfMark.traceTask("ClientCall$Listener.messagesAvailable");
                        try {
                            PerfMark.attachTag(ClientCallImpl.this.tag);
                            PerfMark.linkIn(link);
                            runInternal();
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

                    private void runInternal() {
                        InputStream message;
                        if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                            GrpcUtil.closeQuietly(producer);
                            return;
                        }
                        while (true) {
                            try {
                                InputStream next = producer.next();
                                message = next;
                                if (next != null) {
                                    ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(message));
                                    message.close();
                                } else {
                                    return;
                                }
                            } catch (Throwable t) {
                                GrpcUtil.closeQuietly(producer);
                                ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to read message."));
                                return;
                            }
                        }
                    }
                });
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

        public void closed(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            TaskCloseable ignore = PerfMark.traceTask("ClientStreamListener.closed");
            try {
                PerfMark.attachTag(ClientCallImpl.this.tag);
                closedInternal(status, rpcProgress, trailers);
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

        private void closedInternal(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata trailers) {
            Deadline deadline = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && deadline != null && deadline.isExpired()) {
                InsightBuilder insight = new InsightBuilder();
                ClientCallImpl.this.stream.appendTimeoutInsight(insight);
                status = Status.DEADLINE_EXCEEDED.augmentDescription("ClientCall was cancelled at or after deadline. " + insight);
                trailers = new Metadata();
            }
            final Status savedStatus = status;
            final Metadata savedTrailers = trailers;
            final Link link = PerfMark.linkOut();
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    TaskCloseable ignore = PerfMark.traceTask("ClientCall$Listener.onClose");
                    try {
                        PerfMark.attachTag(ClientCallImpl.this.tag);
                        PerfMark.linkIn(link);
                        runInternal();
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

                private void runInternal() {
                    Status status = savedStatus;
                    Metadata trailers = savedTrailers;
                    if (ClientStreamListenerImpl.this.exceptionStatus != null) {
                        status = ClientStreamListenerImpl.this.exceptionStatus;
                        trailers = new Metadata();
                    }
                    boolean unused = ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
                    try {
                        ClientCallImpl.this.closeObserver(ClientStreamListenerImpl.this.observer, status, trailers);
                    } finally {
                        ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                        ClientCallImpl.this.channelCallsTracer.reportCallEnded(status.isOk());
                    }
                }
            });
        }

        public void onReady() {
            if (!ClientCallImpl.this.method.getType().clientSendsOneMessage()) {
                TaskCloseable ignore = PerfMark.traceTask("ClientStreamListener.onReady");
                try {
                    PerfMark.attachTag(ClientCallImpl.this.tag);
                    final Link link = PerfMark.linkOut();
                    ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                        public void runInContext() {
                            TaskCloseable ignore = PerfMark.traceTask("ClientCall$Listener.onReady");
                            try {
                                PerfMark.attachTag(ClientCallImpl.this.tag);
                                PerfMark.linkIn(link);
                                runInternal();
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

                        private void runInternal() {
                            if (ClientStreamListenerImpl.this.exceptionStatus == null) {
                                try {
                                    ClientStreamListenerImpl.this.observer.onReady();
                                } catch (Throwable t) {
                                    ClientStreamListenerImpl.this.exceptionThrown(Status.CANCELLED.withCause(t).withDescription("Failed to call onReady."));
                                }
                            }
                        }
                    });
                    if (ignore != null) {
                        ignore.close();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                return;
            }
            throw th;
        }
    }
}
