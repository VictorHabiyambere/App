package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
public abstract class AbstractExecutionThreadService implements Service {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AbstractService() {
        /* access modifiers changed from: protected */
        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), (Supplier<String>) new AbstractExecutionThreadService$1$$ExternalSyntheticLambda0(this)).execute(new AbstractExecutionThreadService$1$$ExternalSyntheticLambda1(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStart$0$com-google-common-util-concurrent-AbstractExecutionThreadService$1  reason: not valid java name */
        public /* synthetic */ String m2046lambda$doStart$0$comgooglecommonutilconcurrentAbstractExecutionThreadService$1() {
            return AbstractExecutionThreadService.this.serviceName();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStart$1$com-google-common-util-concurrent-AbstractExecutionThreadService$1  reason: not valid java name */
        public /* synthetic */ void m2047lambda$doStart$1$comgooglecommonutilconcurrentAbstractExecutionThreadService$1() {
            try {
                AbstractExecutionThreadService.this.startUp();
                notifyStarted();
                if (isRunning()) {
                    AbstractExecutionThreadService.this.run();
                }
                AbstractExecutionThreadService.this.shutDown();
                notifyStopped();
            } catch (Throwable t) {
                Platform.restoreInterruptIfIsInterruptedException(t);
                notifyFailed(t);
            }
        }

        /* access modifiers changed from: protected */
        public void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    /* access modifiers changed from: protected */
    public abstract void run() throws Exception;

    protected AbstractExecutionThreadService() {
    }

    /* access modifiers changed from: protected */
    public void startUp() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void shutDown() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void triggerShutdown() {
    }

    /* access modifiers changed from: protected */
    public Executor executor() {
        return new AbstractExecutionThreadService$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$executor$0$com-google-common-util-concurrent-AbstractExecutionThreadService  reason: not valid java name */
    public /* synthetic */ void m2045lambda$executor$0$comgooglecommonutilconcurrentAbstractExecutionThreadService(Runnable command) {
        MoreExecutors.newThread(serviceName(), command).start();
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public final Service.State state() {
        return this.delegate.state();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitRunning(timeout, unit);
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public final void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitTerminated(timeout, unit);
    }

    /* access modifiers changed from: protected */
    public String serviceName() {
        return getClass().getSimpleName();
    }
}
