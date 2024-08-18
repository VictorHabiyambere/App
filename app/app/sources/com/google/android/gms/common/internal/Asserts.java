package com.google.android.gms.common.internal;

import android.os.Looper;
import android.util.Log;
import javax.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class Asserts {
    private Asserts() {
        throw new AssertionError("Uninstantiable");
    }

    public static void checkMainThread(String errorMessage) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", "checkMainThread: current thread " + valueOf + " IS NOT the main thread " + valueOf2 + "!");
            throw new IllegalStateException(errorMessage);
        }
    }

    public static void checkNotMainThread(String errorMessage) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            Log.e("Asserts", "checkNotMainThread: current thread " + valueOf + " IS the main thread " + valueOf2 + "!");
            throw new IllegalStateException(errorMessage);
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object reference) {
        if (reference == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void checkNull(@Nullable Object reference) {
        if (reference != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object reference, Object errorMessage) {
        if (reference == null) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkNull(@Nullable Object reference, Object errorMessage) {
        if (reference != null) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkState(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }
}
