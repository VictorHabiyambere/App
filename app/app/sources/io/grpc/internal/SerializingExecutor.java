package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class SerializingExecutor implements Executor, Runnable {
    private static final int RUNNING = -1;
    private static final int STOPPED = 0;
    private static final AtomicHelper atomicHelper = getAtomicHelper();
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private Executor executor;
    private final Queue<Runnable> runQueue = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public volatile int runState = 0;

    private static AtomicHelper getAtomicHelper() {
        try {
            return new FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater.newUpdater(SerializingExecutor.class, "runState"));
        } catch (Throwable t) {
            log.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", t);
            return new SynchronizedAtomicHelper();
        }
    }

    public SerializingExecutor(Executor executor2) {
        Preconditions.checkNotNull(executor2, "'executor' must not be null.");
        this.executor = executor2;
    }

    public void setExecutor(Executor executor2) {
        Preconditions.checkNotNull(executor2, "'executor' must not be null.");
        this.executor = executor2;
    }

    public void execute(Runnable r) {
        this.runQueue.add((Runnable) Preconditions.checkNotNull(r, "'r' must not be null."));
        schedule(r);
    }

    private void schedule(@Nullable Runnable removable) {
        if (atomicHelper.runStateCompareAndSet(this, 0, -1)) {
            boolean success = false;
            try {
                this.executor.execute(this);
                success = true;
            } finally {
                if (!success) {
                    if (removable != null) {
                        this.runQueue.remove(removable);
                    }
                    atomicHelper.runStateSet(this, 0);
                }
            }
        }
    }

    public void run() {
        Runnable r;
        try {
            Executor oldExecutor = this.executor;
            while (oldExecutor == this.executor) {
                Runnable poll = this.runQueue.poll();
                r = poll;
                if (poll == null) {
                    break;
                }
                r.run();
            }
            atomicHelper.runStateSet(this, 0);
            if (!this.runQueue.isEmpty()) {
                schedule((Runnable) null);
            }
        } catch (RuntimeException e) {
            log.log(Level.SEVERE, "Exception while executing runnable " + r, e);
        } catch (Throwable th) {
            atomicHelper.runStateSet(this, 0);
            throw th;
        }
    }

    private static abstract class AtomicHelper {
        public abstract boolean runStateCompareAndSet(SerializingExecutor serializingExecutor, int i, int i2);

        public abstract void runStateSet(SerializingExecutor serializingExecutor, int i);

        private AtomicHelper() {
        }
    }

    private static final class FieldUpdaterAtomicHelper extends AtomicHelper {
        private final AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater;

        private FieldUpdaterAtomicHelper(AtomicIntegerFieldUpdater<SerializingExecutor> runStateUpdater2) {
            super();
            this.runStateUpdater = runStateUpdater2;
        }

        public boolean runStateCompareAndSet(SerializingExecutor obj, int expect, int update) {
            return this.runStateUpdater.compareAndSet(obj, expect, update);
        }

        public void runStateSet(SerializingExecutor obj, int newValue) {
            this.runStateUpdater.set(obj, newValue);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        public boolean runStateCompareAndSet(SerializingExecutor obj, int expect, int update) {
            synchronized (obj) {
                if (obj.runState != expect) {
                    return false;
                }
                int unused = obj.runState = update;
                return true;
            }
        }

        public void runStateSet(SerializingExecutor obj, int newValue) {
            synchronized (obj) {
                int unused = obj.runState = newValue;
            }
        }
    }
}
