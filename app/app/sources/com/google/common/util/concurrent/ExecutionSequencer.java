package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    /* access modifiers changed from: private */
    public ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue();
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    private static final class ThreadConfinedTaskQueue {
        @CheckForNull
        Executor nextExecutor;
        @CheckForNull
        Runnable nextTask;
        @CheckForNull
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        final TaskNonReentrantExecutor taskExecutor = new TaskNonReentrantExecutor(executor, this);
        AsyncCallable<T> task = new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                if (!taskExecutor.trySetStarted()) {
                    return Futures.immediateCancelledFuture();
                }
                return callable.call();
            }

            public String toString() {
                return callable.toString();
            }
        };
        SettableFuture create = SettableFuture.create();
        ListenableFuture<Void> oldFuture = this.ref.getAndSet(create);
        TrustedListenableFutureTask<T> taskFuture = TrustedListenableFutureTask.create(task);
        oldFuture.addListener(taskFuture, taskExecutor);
        ListenableFuture<T> outputFuture = Futures.nonCancellationPropagating(taskFuture);
        Runnable listener = new ExecutionSequencer$$ExternalSyntheticLambda0(taskFuture, create, oldFuture, outputFuture, taskExecutor);
        outputFuture.addListener(listener, MoreExecutors.directExecutor());
        taskFuture.addListener(listener, MoreExecutors.directExecutor());
        return outputFuture;
    }

    static /* synthetic */ void lambda$submitAsync$0(TrustedListenableFutureTask taskFuture, SettableFuture newFuture, ListenableFuture oldFuture, ListenableFuture outputFuture, TaskNonReentrantExecutor taskExecutor) {
        if (taskFuture.isDone()) {
            newFuture.setFuture(oldFuture);
        } else if (outputFuture.isCancelled() && taskExecutor.trySetCancelled()) {
            taskFuture.cancel(false);
        }
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        @CheckForNull
        Executor delegate;
        @CheckForNull
        ExecutionSequencer sequencer;
        @CheckForNull
        Thread submitting;
        @CheckForNull
        Runnable task;

        private TaskNonReentrantExecutor(Executor delegate2, ExecutionSequencer sequencer2) {
            super(RunningState.NOT_RUN);
            this.delegate = delegate2;
            this.sequencer = sequencer2;
        }

        public void execute(Runnable task2) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ThreadConfinedTaskQueue submittingTaskQueue = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue;
                if (submittingTaskQueue.thread == this.submitting) {
                    this.sequencer = null;
                    Preconditions.checkState(submittingTaskQueue.nextTask == null);
                    submittingTaskQueue.nextTask = task2;
                    submittingTaskQueue.nextExecutor = (Executor) Objects.requireNonNull(this.delegate);
                    this.delegate = null;
                } else {
                    this.delegate = null;
                    this.task = task2;
                    ((Executor) Objects.requireNonNull(this.delegate)).execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        public void run() {
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.submitting) {
                this.task = null;
                ((Runnable) Objects.requireNonNull(this.task)).run();
                return;
            }
            ThreadConfinedTaskQueue executingTaskQueue = new ThreadConfinedTaskQueue();
            executingTaskQueue.thread = currentThread;
            ThreadConfinedTaskQueue unused = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue = executingTaskQueue;
            this.sequencer = null;
            try {
                this.task = null;
                ((Runnable) Objects.requireNonNull(this.task)).run();
                while (true) {
                    Runnable runnable = executingTaskQueue.nextTask;
                    Runnable queuedTask = runnable;
                    if (runnable == null) {
                        break;
                    }
                    Executor executor = executingTaskQueue.nextExecutor;
                    Executor queuedExecutor = executor;
                    if (executor == null) {
                        break;
                    }
                    executingTaskQueue.nextTask = null;
                    executingTaskQueue.nextExecutor = null;
                    queuedExecutor.execute(queuedTask);
                }
            } finally {
                executingTaskQueue.thread = null;
            }
        }

        /* access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        /* access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }
}
