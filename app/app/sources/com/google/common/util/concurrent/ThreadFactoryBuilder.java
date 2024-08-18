package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ThreadFactoryBuilder {
    @CheckForNull
    private ThreadFactory backingThreadFactory = null;
    @CheckForNull
    private Boolean daemon = null;
    @CheckForNull
    private String nameFormat = null;
    @CheckForNull
    private Integer priority = null;
    @CheckForNull
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;

    public ThreadFactoryBuilder setNameFormat(String nameFormat2) {
        String format = format(nameFormat2, 0);
        this.nameFormat = nameFormat2;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean daemon2) {
        this.daemon = Boolean.valueOf(daemon2);
        return this;
    }

    public ThreadFactoryBuilder setPriority(int priority2) {
        boolean z = false;
        Preconditions.checkArgument(priority2 >= 1, "Thread priority (%s) must be >= %s", priority2, 1);
        if (priority2 <= 10) {
            z = true;
        }
        Preconditions.checkArgument(z, "Thread priority (%s) must be <= %s", priority2, 10);
        this.priority = Integer.valueOf(priority2);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler2);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory backingThreadFactory2) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(backingThreadFactory2);
        return this;
    }

    public ThreadFactory build() {
        return doBuild(this);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder builder) {
        final ThreadFactory backingThreadFactory2;
        String nameFormat2 = builder.nameFormat;
        Boolean daemon2 = builder.daemon;
        Integer priority2 = builder.priority;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = builder.uncaughtExceptionHandler;
        if (builder.backingThreadFactory != null) {
            backingThreadFactory2 = builder.backingThreadFactory;
        } else {
            backingThreadFactory2 = Executors.defaultThreadFactory();
        }
        final AtomicLong count = nameFormat2 != null ? new AtomicLong(0) : null;
        final String str = nameFormat2;
        final Boolean bool = daemon2;
        final Integer num = priority2;
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = uncaughtExceptionHandler2;
        return new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = backingThreadFactory2.newThread(runnable);
                Objects.requireNonNull(thread);
                if (str != null) {
                    thread.setName(ThreadFactoryBuilder.format(str, Long.valueOf(((AtomicLong) Objects.requireNonNull(count)).getAndIncrement())));
                }
                if (bool != null) {
                    thread.setDaemon(bool.booleanValue());
                }
                if (num != null) {
                    thread.setPriority(num.intValue());
                }
                if (uncaughtExceptionHandler3 != null) {
                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler3);
                }
                return thread;
            }
        };
    }

    /* access modifiers changed from: private */
    public static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
