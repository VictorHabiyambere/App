package io.grpc;

import io.grpc.PersistentHashArrayMappedTrie;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Context {
    static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    public static final Context ROOT = new Context();
    static final Logger log = Logger.getLogger(Context.class.getName());
    final CancellableContext cancellableAncestor;
    final int generation;
    final PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries;

    @interface CanIgnoreReturnValue {
    }

    public interface CancellationListener {
        void cancelled(Context context);
    }

    @interface CheckReturnValue {
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    private static final class LazyStorage {
        static final Storage storage;

        private LazyStorage() {
        }

        static {
            AtomicReference<Throwable> deferredStorageFailure = new AtomicReference<>();
            storage = createStorage(deferredStorageFailure);
            Throwable failure = deferredStorageFailure.get();
            if (failure != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", failure);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> deferredStorageFailure) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                deferredStorageFailure.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static <T> Key<T> key(String debugString) {
        return new Key<>(debugString);
    }

    public static <T> Key<T> keyWithDefault(String debugString, T defaultValue) {
        return new Key<>(debugString, defaultValue);
    }

    public static Context current() {
        Context current = storage().current();
        if (current == null) {
            return ROOT;
        }
        return current;
    }

    private Context(PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries2, int generation2) {
        this.cancellableAncestor = null;
        this.keyValueEntries = keyValueEntries2;
        this.generation = generation2;
        validateGeneration(generation2);
    }

    private Context(Context parent, PersistentHashArrayMappedTrie.Node<Key<?>, Object> keyValueEntries2) {
        this.cancellableAncestor = cancellableAncestor(parent);
        this.keyValueEntries = keyValueEntries2;
        this.generation = parent.generation + 1;
        validateGeneration(this.generation);
    }

    private Context() {
        this.cancellableAncestor = null;
        this.keyValueEntries = null;
        this.generation = 0;
        validateGeneration(this.generation);
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadlineAfter(long duration, TimeUnit unit, ScheduledExecutorService scheduler) {
        return withDeadline(Deadline.after(duration, unit), scheduler);
    }

    public CancellableContext withDeadline(Deadline newDeadline, ScheduledExecutorService scheduler) {
        checkNotNull(newDeadline, "deadline");
        checkNotNull(scheduler, "scheduler");
        Deadline existingDeadline = getDeadline();
        boolean scheduleDeadlineCancellation = true;
        if (existingDeadline != null && existingDeadline.compareTo(newDeadline) <= 0) {
            newDeadline = existingDeadline;
            scheduleDeadlineCancellation = false;
        }
        CancellableContext newCtx = new CancellableContext(newDeadline);
        if (scheduleDeadlineCancellation) {
            newCtx.setUpDeadlineCancellation(newDeadline, scheduler);
        }
        return newCtx;
    }

    public <V> Context withValue(Key<V> k1, V v1) {
        return new Context(this, PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1));
    }

    public <V1, V2> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2) {
        return new Context(this, PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1), k2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2, Key<V3> k3, V3 v3) {
        return new Context(this, PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1), k2, v2), k3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> k1, V1 v1, Key<V2> k2, V2 v2, Key<V3> k3, V3 v3, Key<V4> k4, V4 v4) {
        return new Context(this, PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(PersistentHashArrayMappedTrie.put(this.keyValueEntries, k1, v1), k2, v2), k3, v3), k4, v4));
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    public Context attach() {
        Context prev = storage().doAttach(this);
        if (prev == null) {
            return ROOT;
        }
        return prev;
    }

    public void detach(Context toAttach) {
        checkNotNull(toAttach, "toAttach");
        storage().detach(this, toAttach);
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrent() {
        return current() == this;
    }

    public boolean isCancelled() {
        if (this.cancellableAncestor == null) {
            return false;
        }
        return this.cancellableAncestor.isCancelled();
    }

    public Throwable cancellationCause() {
        if (this.cancellableAncestor == null) {
            return null;
        }
        return this.cancellableAncestor.cancellationCause();
    }

    public Deadline getDeadline() {
        if (this.cancellableAncestor == null) {
            return null;
        }
        return this.cancellableAncestor.getDeadline();
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        if (this.cancellableAncestor != null) {
            this.cancellableAncestor.addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
        }
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (this.cancellableAncestor != null) {
            this.cancellableAncestor.removeListenerInternal(cancellationListener, this);
        }
    }

    /* access modifiers changed from: package-private */
    public int listenerCount() {
        if (this.cancellableAncestor == null) {
            return 0;
        }
        return this.cancellableAncestor.listenerCount();
    }

    public void run(Runnable r) {
        Context previous = attach();
        try {
            r.run();
        } finally {
            detach(previous);
        }
    }

    public <V> V call(Callable<V> c) throws Exception {
        Context previous = attach();
        try {
            return c.call();
        } finally {
            detach(previous);
        }
    }

    public Runnable wrap(final Runnable r) {
        return new Runnable() {
            public void run() {
                Context previous = Context.this.attach();
                try {
                    r.run();
                } finally {
                    Context.this.detach(previous);
                }
            }
        };
    }

    public <C> Callable<C> wrap(final Callable<C> c) {
        return new Callable<C>() {
            public C call() throws Exception {
                Context previous = Context.this.attach();
                try {
                    return c.call();
                } finally {
                    Context.this.detach(previous);
                }
            }
        };
    }

    public Executor fixedContextExecutor(final Executor e) {
        return new Executor() {
            public void execute(Runnable r) {
                e.execute(Context.this.wrap(r));
            }
        };
    }

    public static Executor currentContextExecutor(final Executor e) {
        return new Executor() {
            public void execute(Runnable r) {
                e.execute(Context.current().wrap(r));
            }
        };
    }

    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ArrayList<ExecutableListener> listeners;
        private CancellationListener parentListener;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        private CancellableContext(Context parent) {
            super(parent.keyValueEntries);
            this.deadline = parent.getDeadline();
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        private CancellableContext(Context parent, Deadline deadline2) {
            super(parent.keyValueEntries);
            this.deadline = deadline2;
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        /* access modifiers changed from: private */
        public void setUpDeadlineCancellation(Deadline deadline2, ScheduledExecutorService scheduler) {
            if (!deadline2.isExpired()) {
                synchronized (this) {
                    this.pendingDeadline = deadline2.runOnExpiration(new Runnable() {
                        public void run() {
                            try {
                                CancellableContext.this.cancel(new TimeoutException("context timed out"));
                            } catch (Throwable t) {
                                Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", t);
                            }
                        }
                    }, scheduler);
                }
                return;
            }
            cancel(new TimeoutException("context timed out"));
        }

        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        public void detach(Context toAttach) {
            this.uncancellableSurrogate.detach(toAttach);
        }

        public void addListener(CancellationListener cancellationListener, Executor executor) {
            checkNotNull(cancellationListener, "cancellationListener");
            checkNotNull(executor, "executor");
            addListenerInternal(new ExecutableListener(executor, cancellationListener, this));
        }

        /* access modifiers changed from: private */
        public void addListenerInternal(ExecutableListener executableListener) {
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else if (this.listeners == null) {
                    this.listeners = new ArrayList<>();
                    this.listeners.add(executableListener);
                    if (this.cancellableAncestor != null) {
                        this.parentListener = new CancellationListener() {
                            public void cancelled(Context context) {
                                CancellableContext.this.cancel(context.cancellationCause());
                            }
                        };
                        this.cancellableAncestor.addListenerInternal(new ExecutableListener(DirectExecutor.INSTANCE, this.parentListener, this));
                    }
                } else {
                    this.listeners.add(executableListener);
                }
            }
        }

        public void removeListener(CancellationListener cancellationListener) {
            removeListenerInternal(cancellationListener, this);
        }

        /* access modifiers changed from: private */
        public void removeListenerInternal(CancellationListener cancellationListener, Context context) {
            synchronized (this) {
                if (this.listeners != null) {
                    int i = this.listeners.size() - 1;
                    while (true) {
                        if (i < 0) {
                            break;
                        }
                        ExecutableListener executableListener = this.listeners.get(i);
                        if (executableListener.listener == cancellationListener && executableListener.context == context) {
                            this.listeners.remove(i);
                            break;
                        }
                        i--;
                    }
                    if (this.listeners.isEmpty()) {
                        if (this.cancellableAncestor != null) {
                            this.cancellableAncestor.removeListener(this.parentListener);
                        }
                        this.parentListener = null;
                        this.listeners = null;
                    }
                }
            }
        }

        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        public boolean cancel(Throwable cause) {
            boolean triggeredCancel = false;
            ScheduledFuture<?> localPendingDeadline = null;
            synchronized (this) {
                if (!this.cancelled) {
                    this.cancelled = true;
                    if (this.pendingDeadline != null) {
                        localPendingDeadline = this.pendingDeadline;
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = cause;
                    triggeredCancel = true;
                }
            }
            if (localPendingDeadline != null) {
                localPendingDeadline.cancel(false);
            }
            if (triggeredCancel) {
                notifyAndClearListeners();
            }
            return triggeredCancel;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            if (r1.hasNext() == false) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
            r3 = r1.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            if (io.grpc.Context.ExecutableListener.access$600(r3) != r5) goto L_0x0015;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            r3.deliver();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
            r1 = r2.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
            if (r1.hasNext() == false) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
            r3 = r1.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
            if (io.grpc.Context.ExecutableListener.access$600(r3) == r5) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
            r3.deliver();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0047, code lost:
            if (r5.cancellableAncestor == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
            r5.cancellableAncestor.removeListener(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
            r1 = r2.iterator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void notifyAndClearListeners() {
            /*
                r5 = this;
                monitor-enter(r5)
                java.util.ArrayList<io.grpc.Context$ExecutableListener> r0 = r5.listeners     // Catch:{ all -> 0x004f }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                return
            L_0x0007:
                io.grpc.Context$CancellationListener r0 = r5.parentListener     // Catch:{ all -> 0x004f }
                r1 = 0
                r5.parentListener = r1     // Catch:{ all -> 0x004f }
                java.util.ArrayList<io.grpc.Context$ExecutableListener> r2 = r5.listeners     // Catch:{ all -> 0x004f }
                r5.listeners = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                java.util.Iterator r1 = r2.iterator()
            L_0x0015:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x002b
                java.lang.Object r3 = r1.next()
                io.grpc.Context$ExecutableListener r3 = (io.grpc.Context.ExecutableListener) r3
                io.grpc.Context r4 = r3.context
                if (r4 != r5) goto L_0x002a
                r3.deliver()
            L_0x002a:
                goto L_0x0015
            L_0x002b:
                java.util.Iterator r1 = r2.iterator()
            L_0x002f:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0045
                java.lang.Object r3 = r1.next()
                io.grpc.Context$ExecutableListener r3 = (io.grpc.Context.ExecutableListener) r3
                io.grpc.Context r4 = r3.context
                if (r4 == r5) goto L_0x0044
                r3.deliver()
            L_0x0044:
                goto L_0x002f
            L_0x0045:
                io.grpc.Context$CancellableContext r1 = r5.cancellableAncestor
                if (r1 == 0) goto L_0x004e
                io.grpc.Context$CancellableContext r1 = r5.cancellableAncestor
                r1.removeListener(r0)
            L_0x004e:
                return
            L_0x004f:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x004f }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.notifyAndClearListeners():void");
        }

        /* access modifiers changed from: package-private */
        public int listenerCount() {
            int size;
            synchronized (this) {
                size = this.listeners == null ? 0 : this.listeners.size();
            }
            return size;
        }

        public void detachAndCancel(Context toAttach, Throwable cause) {
            try {
                detach(toAttach);
            } finally {
                cancel(cause);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
            if (io.grpc.Context.super.isCancelled() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            cancel(io.grpc.Context.super.cancellationCause());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isCancelled() {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.cancelled     // Catch:{ all -> 0x0019 }
                r1 = 1
                if (r0 == 0) goto L_0x0008
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                return r1
            L_0x0008:
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                boolean r0 = io.grpc.Context.super.isCancelled()
                if (r0 == 0) goto L_0x0017
                java.lang.Throwable r0 = io.grpc.Context.super.cancellationCause()
                r2.cancel(r0)
                return r1
            L_0x0017:
                r0 = 0
                return r0
            L_0x0019:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.isCancelled():boolean");
        }

        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        public Deadline getDeadline() {
            return this.deadline;
        }

        public void close() {
            cancel((Throwable) null);
        }
    }

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String name2) {
            this(name2, (Object) null);
        }

        Key(String name2, T defaultValue2) {
            this.name = (String) Context.checkNotNull(name2, "name");
            this.defaultValue = defaultValue2;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T value = PersistentHashArrayMappedTrie.get(context.keyValueEntries, this);
            return value == null ? this.defaultValue : value;
        }

        public String toString() {
            return this.name;
        }
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        @Deprecated
        public void attach(Context toAttach) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public Context doAttach(Context toAttach) {
            Context current = current();
            attach(toAttach);
            return current;
        }
    }

    private static final class ExecutableListener implements Runnable {
        /* access modifiers changed from: private */
        public final Context context;
        private final Executor executor;
        final CancellationListener listener;

        ExecutableListener(Executor executor2, CancellationListener listener2, Context context2) {
            this.executor = executor2;
            this.listener = listener2;
            this.context = context2;
        }

        /* access modifiers changed from: package-private */
        public void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable t) {
                Context.log.log(Level.INFO, "Exception notifying context listener", t);
            }
        }

        public void run() {
            this.listener.cancelled(this.context);
        }
    }

    static <T> T checkNotNull(T reference, Object errorMessage) {
        if (reference != null) {
            return reference;
        }
        throw new NullPointerException(String.valueOf(errorMessage));
    }

    private enum DirectExecutor implements Executor {
        INSTANCE;

        public void execute(Runnable command) {
            command.run();
        }

        public String toString() {
            return "Context.DirectExecutor";
        }
    }

    static CancellableContext cancellableAncestor(Context parent) {
        if (parent instanceof CancellableContext) {
            return (CancellableContext) parent;
        }
        return parent.cancellableAncestor;
    }

    private static void validateGeneration(int generation2) {
        if (generation2 == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", new Exception());
        }
    }
}
