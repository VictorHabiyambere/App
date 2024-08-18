package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    /* access modifiers changed from: private */
    public final AbstractService delegate = new ServiceDelegate();

    interface Cancellable {
        void cancel(boolean z);

        boolean isCancelled();
    }

    /* access modifiers changed from: protected */
    public abstract void runOneIteration() throws Exception;

    /* access modifiers changed from: protected */
    public abstract Scheduler scheduler();

    public static abstract class Scheduler {
        /* access modifiers changed from: package-private */
        public abstract Cancellable schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable);

        public static Scheduler newFixedDelaySchedule(long initialDelay, long delay, TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(delay > 0, "delay must be > 0, found %s", delay);
            final long j = initialDelay;
            final long j2 = delay;
            final TimeUnit timeUnit = unit;
            return new Scheduler() {
                public Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                    return new FutureAsCancellable(executor.scheduleWithFixedDelay(task, j, j2, timeUnit));
                }
            };
        }

        public static Scheduler newFixedRateSchedule(long initialDelay, long period, TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(period > 0, "period must be > 0, found %s", period);
            final long j = initialDelay;
            final long j2 = period;
            final TimeUnit timeUnit = unit;
            return new Scheduler() {
                public Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                    return new FutureAsCancellable(executor.scheduleAtFixedRate(task, j, j2, timeUnit));
                }
            };
        }

        private Scheduler() {
        }
    }

    private final class ServiceDelegate extends AbstractService {
        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        /* access modifiers changed from: private */
        public final ReentrantLock lock;
        /* access modifiers changed from: private */
        @CheckForNull
        public volatile Cancellable runningTask;
        private final Runnable task;

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        class Task implements Runnable {
            Task() {
            }

            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (((Cancellable) Objects.requireNonNull(ServiceDelegate.this.runningTask)).isCancelled()) {
                        ServiceDelegate.this.lock.unlock();
                        return;
                    }
                    AbstractScheduledService.this.runOneIteration();
                    ServiceDelegate.this.lock.unlock();
                } catch (Throwable th) {
                    ServiceDelegate.this.lock.unlock();
                    throw th;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda0(this));
            this.executorService.execute(new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda1(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStart$0$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate  reason: not valid java name */
        public /* synthetic */ String m2051lambda$doStart$0$comgooglecommonutilconcurrentAbstractScheduledService$ServiceDelegate() {
            return AbstractScheduledService.this.serviceName() + " " + state();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStart$1$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate  reason: not valid java name */
        public /* synthetic */ void m2052lambda$doStart$1$comgooglecommonutilconcurrentAbstractScheduledService$ServiceDelegate() {
            this.lock.lock();
            try {
                AbstractScheduledService.this.startUp();
                Objects.requireNonNull(this.executorService);
                this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, this.executorService, this.task);
                notifyStarted();
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
            this.lock.unlock();
        }

        /* access modifiers changed from: protected */
        public final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda2(this));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$doStop$2$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate  reason: not valid java name */
        public /* synthetic */ void m2053lambda$doStop$2$comgooglecommonutilconcurrentAbstractScheduledService$ServiceDelegate() {
            try {
                this.lock.lock();
                if (state() != Service.State.STOPPING) {
                    this.lock.unlock();
                    return;
                }
                AbstractScheduledService.this.shutDown();
                this.lock.unlock();
                notifyStopped();
            } catch (Throwable t) {
                Platform.restoreInterruptIfIsInterruptedException(t);
                notifyFailed(t);
            }
        }

        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    /* access modifiers changed from: protected */
    public void startUp() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void shutDown() throws Exception {
    }

    /* access modifiers changed from: protected */
    public ScheduledExecutorService executor() {
        final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
            }
        });
        addListener(new Service.Listener(this) {
            public void terminated(Service.State from) {
                executor.shutdown();
            }

            public void failed(Service.State from, Throwable failure) {
                executor.shutdown();
            }
        }, MoreExecutors.directExecutor());
        return executor;
    }

    /* access modifiers changed from: protected */
    public String serviceName() {
        return getClass().getSimpleName();
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

    private static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        FutureAsCancellable(Future<?> delegate2) {
            this.delegate = delegate2;
        }

        public void cancel(boolean mayInterruptIfRunning) {
            this.delegate.cancel(mayInterruptIfRunning);
        }

        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }

    public static abstract class CustomScheduler extends Scheduler {
        /* access modifiers changed from: protected */
        public abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super();
        }

        private final class ReschedulableCallable implements Callable<Void> {
            @CheckForNull
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            ReschedulableCallable(AbstractService service2, ScheduledExecutorService executor2, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = executor2;
                this.service = service2;
            }

            @CheckForNull
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Cancellable reschedule() {
                Cancellable toReturn;
                try {
                    Schedule schedule = CustomScheduler.this.getNextSchedule();
                    Throwable scheduleFailure = null;
                    this.lock.lock();
                    try {
                        toReturn = initializeOrUpdateCancellationDelegate(schedule);
                    } catch (Error | RuntimeException e) {
                        scheduleFailure = e;
                        toReturn = new FutureAsCancellable(Futures.immediateCancelledFuture());
                    } catch (Throwable th) {
                        this.lock.unlock();
                        throw th;
                    }
                    this.lock.unlock();
                    if (scheduleFailure != null) {
                        this.service.notifyFailed(scheduleFailure);
                    }
                    return toReturn;
                } catch (Throwable t) {
                    Platform.restoreInterruptIfIsInterruptedException(t);
                    this.service.notifyFailed(t);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule schedule) {
                if (this.cancellationDelegate == null) {
                    SupplantableFuture supplantableFuture = new SupplantableFuture(this.lock, submitToExecutor(schedule));
                    this.cancellationDelegate = supplantableFuture;
                    return supplantableFuture;
                }
                if (!this.cancellationDelegate.currentFuture.isCancelled()) {
                    Future unused = this.cancellationDelegate.currentFuture = submitToExecutor(schedule);
                }
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule schedule) {
                return this.executor.schedule(this, schedule.delay, schedule.unit);
            }
        }

        private static final class SupplantableFuture implements Cancellable {
            /* access modifiers changed from: private */
            public Future<Void> currentFuture;
            private final ReentrantLock lock;

            SupplantableFuture(ReentrantLock lock2, Future<Void> currentFuture2) {
                this.lock = lock2;
                this.currentFuture = currentFuture2;
            }

            public void cancel(boolean mayInterruptIfRunning) {
                this.lock.lock();
                try {
                    this.currentFuture.cancel(mayInterruptIfRunning);
                } finally {
                    this.lock.unlock();
                }
            }

            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable runnable) {
            return new ReschedulableCallable(service, executor, runnable).reschedule();
        }

        protected static final class Schedule {
            /* access modifiers changed from: private */
            public final long delay;
            /* access modifiers changed from: private */
            public final TimeUnit unit;

            public Schedule(long delay2, TimeUnit unit2) {
                this.delay = delay2;
                this.unit = (TimeUnit) Preconditions.checkNotNull(unit2);
            }
        }
    }
}
