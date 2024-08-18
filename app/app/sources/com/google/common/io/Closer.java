package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Closer implements Closeable {
    private static final Suppressor SUPPRESSOR;
    private final Deque<Closeable> stack = new ArrayDeque(4);
    final Suppressor suppressor;
    @CheckForNull
    private Throwable thrown;

    interface Suppressor {
        void suppress(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        SuppressingSuppressor suppressingSuppressor = SuppressingSuppressor.tryCreate();
        SUPPRESSOR = suppressingSuppressor == null ? LoggingSuppressor.INSTANCE : suppressingSuppressor;
    }

    public static Closer create() {
        return new Closer(SUPPRESSOR);
    }

    Closer(Suppressor suppressor2) {
        this.suppressor = (Suppressor) Preconditions.checkNotNull(suppressor2);
    }

    @ParametricNullness
    public <C extends Closeable> C register(@ParametricNullness C closeable) {
        if (closeable != null) {
            this.stack.addFirst(closeable);
        }
        return closeable;
    }

    public RuntimeException rethrow(Throwable e) throws IOException {
        Preconditions.checkNotNull(e);
        this.thrown = e;
        Throwables.propagateIfPossible(e, IOException.class);
        throw new RuntimeException(e);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable e, Class<X> declaredType) throws IOException, Exception {
        Preconditions.checkNotNull(e);
        this.thrown = e;
        Throwables.propagateIfPossible(e, IOException.class);
        Throwables.propagateIfPossible(e, declaredType);
        throw new RuntimeException(e);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable e, Class<X1> declaredType1, Class<X2> declaredType2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(e);
        this.thrown = e;
        Throwables.propagateIfPossible(e, IOException.class);
        Throwables.propagateIfPossible(e, declaredType1, declaredType2);
        throw new RuntimeException(e);
    }

    public void close() throws IOException {
        Throwable throwable = this.thrown;
        while (!this.stack.isEmpty()) {
            Closeable closeable = this.stack.removeFirst();
            try {
                closeable.close();
            } catch (Throwable e) {
                if (throwable == null) {
                    throwable = e;
                } else {
                    this.suppressor.suppress(closeable, throwable, e);
                }
            }
        }
        if (this.thrown == null && throwable != null) {
            Throwables.propagateIfPossible(throwable, IOException.class);
            throw new AssertionError(throwable);
        }
    }

    static final class LoggingSuppressor implements Suppressor {
        static final LoggingSuppressor INSTANCE = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed) {
            Closeables.logger.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, suppressed);
        }
    }

    static final class SuppressingSuppressor implements Suppressor {
        private final Method addSuppressed;

        @CheckForNull
        static SuppressingSuppressor tryCreate() {
            try {
                return new SuppressingSuppressor(Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class}));
            } catch (Throwable th) {
                return null;
            }
        }

        private SuppressingSuppressor(Method addSuppressed2) {
            this.addSuppressed = addSuppressed2;
        }

        public void suppress(Closeable closeable, Throwable thrown, Throwable suppressed) {
            if (thrown != suppressed) {
                try {
                    this.addSuppressed.invoke(thrown, new Object[]{suppressed});
                } catch (Throwable th) {
                    LoggingSuppressor.INSTANCE.suppress(closeable, thrown, suppressed);
                }
            }
        }
    }
}
