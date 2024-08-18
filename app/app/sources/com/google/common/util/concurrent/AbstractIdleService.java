package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {
    private final Service delegate = new DelegateService();
    /* access modifiers changed from: private */
    public final Supplier<String> threadNameSupplier = new ThreadNameSupplier();

    /* access modifiers changed from: protected */
    public abstract void shutDown() throws Exception;

    /* access modifiers changed from: protected */
    public abstract void startUp() throws Exception;

    private final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        public String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    private final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* access modifiers changed from: protected */
        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService$DelegateService$$ExternalSyntheticLambda1(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStart$0$com-google-common-util-concurrent-AbstractIdleService$DelegateService  reason: not valid java name */
        public /* synthetic */ void m2049lambda$doStart$0$comgooglecommonutilconcurrentAbstractIdleService$DelegateService() {
            try {
                AbstractIdleService.this.startUp();
                notifyStarted();
            } catch (Throwable t) {
                Platform.restoreInterruptIfIsInterruptedException(t);
                notifyFailed(t);
            }
        }

        /* access modifiers changed from: protected */
        public final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService$DelegateService$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStop$1$com-google-common-util-concurrent-AbstractIdleService$DelegateService  reason: not valid java name */
        public /* synthetic */ void m2050lambda$doStop$1$comgooglecommonutilconcurrentAbstractIdleService$DelegateService() {
            try {
                AbstractIdleService.this.shutDown();
                notifyStopped();
            } catch (Throwable t) {
                Platform.restoreInterruptIfIsInterruptedException(t);
                notifyFailed(t);
            }
        }

        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    protected AbstractIdleService() {
    }

    /* access modifiers changed from: protected */
    public Executor executor() {
        return new AbstractIdleService$$ExternalSyntheticLambda0(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$executor$0$com-google-common-util-concurrent-AbstractIdleService  reason: not valid java name */
    public /* synthetic */ void m2048lambda$executor$0$comgooglecommonutilconcurrentAbstractIdleService(Runnable command) {
        MoreExecutors.newThread(this.threadNameSupplier.get(), command).start();
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
