package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

@ElementTypesAreNonnullByDefault
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = new DoNothingRunnable();
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = new DoNothingRunnable();

    /* access modifiers changed from: package-private */
    public abstract void afterRanInterruptiblyFailure(Throwable th);

    /* access modifiers changed from: package-private */
    public abstract void afterRanInterruptiblySuccess(@ParametricNullness T t);

    /* access modifiers changed from: package-private */
    public abstract boolean isDone();

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T runInterruptibly() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String toPendingString();

    InterruptibleTask() {
    }

    static {
        Class<LockSupport> cls = LockSupport.class;
    }

    private static final class DoNothingRunnable implements Runnable {
        private DoNothingRunnable() {
        }

        public void run() {
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        if (compareAndSet((Object) null, currentThread)) {
            boolean run = !isDone();
            T result = null;
            Throwable error = null;
            if (run) {
                try {
                    result = runInterruptibly();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        waitForInterrupt(currentThread);
                    }
                    if (run) {
                        if (0 == 0) {
                            afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(null));
                        } else {
                            afterRanInterruptiblyFailure((Throwable) null);
                        }
                    }
                    throw th;
                }
            }
            if (!compareAndSet(currentThread, DONE)) {
                waitForInterrupt(currentThread);
            }
            if (run) {
                if (0 == 0) {
                    afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(result));
                    return;
                }
                afterRanInterruptiblyFailure(error);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Runnable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void waitForInterrupt(java.lang.Thread r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            java.lang.Object r2 = r5.get()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r3 = 0
        L_0x0009:
            boolean r4 = r2 instanceof com.google.common.util.concurrent.InterruptibleTask.Blocker
            if (r4 != 0) goto L_0x0018
            java.lang.Runnable r4 = PARKED
            if (r2 != r4) goto L_0x0012
            goto L_0x0018
        L_0x0012:
            if (r0 == 0) goto L_0x0017
            r6.interrupt()
        L_0x0017:
            return
        L_0x0018:
            boolean r4 = r2 instanceof com.google.common.util.concurrent.InterruptibleTask.Blocker
            if (r4 == 0) goto L_0x001f
            r3 = r2
            com.google.common.util.concurrent.InterruptibleTask$Blocker r3 = (com.google.common.util.concurrent.InterruptibleTask.Blocker) r3
        L_0x001f:
            int r1 = r1 + 1
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r1 <= r4) goto L_0x0042
            java.lang.Runnable r4 = PARKED
            if (r2 == r4) goto L_0x0031
            java.lang.Runnable r4 = PARKED
            boolean r4 = r5.compareAndSet(r2, r4)
            if (r4 == 0) goto L_0x0045
        L_0x0031:
            boolean r4 = java.lang.Thread.interrupted()
            if (r4 != 0) goto L_0x003c
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r4 = 0
            goto L_0x003d
        L_0x003c:
            r4 = 1
        L_0x003d:
            r0 = r4
            java.util.concurrent.locks.LockSupport.park(r3)
            goto L_0x0045
        L_0x0042:
            java.lang.Thread.yield()
        L_0x0045:
            java.lang.Object r4 = r5.get()
            r2 = r4
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.InterruptibleTask.waitForInterrupt(java.lang.Thread):void");
    }

    /* access modifiers changed from: package-private */
    public final void interruptTask() {
        Runnable currentRunner = (Runnable) get();
        if (currentRunner instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.setOwner(Thread.currentThread());
            if (compareAndSet(currentRunner, blocker)) {
                try {
                    ((Thread) currentRunner).interrupt();
                } finally {
                    if (((Runnable) getAndSet(DONE)) == PARKED) {
                        LockSupport.unpark((Thread) currentRunner);
                    }
                }
            }
        }
    }

    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        private Blocker(InterruptibleTask<?> task2) {
            this.task = task2;
        }

        public void run() {
        }

        /* access modifiers changed from: private */
        public void setOwner(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        /* access modifiers changed from: package-private */
        public Thread getOwner() {
            return super.getExclusiveOwnerThread();
        }

        public String toString() {
            return this.task.toString();
        }
    }

    public final String toString() {
        String result;
        Runnable state = (Runnable) get();
        if (state == DONE) {
            result = "running=[DONE]";
        } else if (state instanceof Blocker) {
            result = "running=[INTERRUPTED]";
        } else if (state instanceof Thread) {
            result = "running=[RUNNING ON " + ((Thread) state).getName() + "]";
        } else {
            result = "running=[NOT STARTED YET]";
        }
        return result + ", " + toPendingString();
    }
}
