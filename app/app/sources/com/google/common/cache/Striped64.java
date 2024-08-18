package com.google.common.cache;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
abstract class Striped64 extends Number {
    static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    static final Random rng = new Random();
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    volatile transient long base;
    volatile transient int busy;
    @CheckForNull
    volatile transient Cell[] cells;

    /* access modifiers changed from: package-private */
    public abstract long fn(long j, long j2);

    static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        Cell(long x) {
            this.value = x;
        }

        /* access modifiers changed from: package-private */
        public final boolean cas(long cmp, long val) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, cmp, val);
        }

        static {
            try {
                UNSAFE = Striped64.getUnsafe();
                valueOffset = UNSAFE.objectFieldOffset(Cell.class.getDeclaredField(AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    static {
        try {
            UNSAFE = getUnsafe();
            Class<Striped64> cls = Striped64.class;
            baseOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("base"));
            busyOffset = UNSAFE.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    /* access modifiers changed from: package-private */
    public final boolean casBase(long cmp, long val) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, cmp, val);
    }

    /* access modifiers changed from: package-private */
    public final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void retryUpdate(long x, @CheckForNull int[] hc, boolean wasUncontended) {
        int[] hc2;
        int r;
        boolean wasUncontended2;
        boolean wasUncontended3;
        boolean wasUncontended4;
        long j = x;
        int i = 0;
        if (hc == null) {
            int i2 = 1;
            int[] iArr = new int[1];
            hc2 = iArr;
            threadHashCode.set(iArr);
            int r2 = rng.nextInt();
            if (r2 != 0) {
                i2 = r2;
            }
            hc2[i] = i2;
            r = i2;
        } else {
            r = hc[i];
            hc2 = hc;
        }
        int h = r;
        boolean collide = false;
        boolean wasUncontended5 = wasUncontended;
        while (true) {
            Cell[] cellArr = this.cells;
            Cell[] as = cellArr;
            if (cellArr != null) {
                int length = as.length;
                int n = length;
                if (length > 0) {
                    Cell cell = as[(n - 1) & h];
                    Cell a = cell;
                    if (cell == null) {
                        if (this.busy == 0) {
                            Cell r3 = new Cell(j);
                            if (this.busy == 0 && casBusy()) {
                                boolean created = false;
                                try {
                                    Cell[] cellArr2 = this.cells;
                                    Cell[] rs = cellArr2;
                                    if (cellArr2 != null) {
                                        int length2 = rs.length;
                                        int m = length2;
                                        if (length2 > 0) {
                                            int i3 = (m - 1) & h;
                                            int j2 = i3;
                                            if (rs[i3] == null) {
                                                rs[j2] = r3;
                                                created = true;
                                            }
                                        }
                                    }
                                    if (created) {
                                        boolean z = wasUncontended5;
                                        return;
                                    }
                                } finally {
                                    this.busy = i;
                                }
                            }
                        }
                        collide = false;
                    } else if (!wasUncontended5) {
                        wasUncontended5 = true;
                    } else {
                        long v = a.value;
                        boolean wasUncontended6 = wasUncontended5;
                        if (!a.cas(v, fn(v, j))) {
                            if (n >= NCPU || this.cells != as) {
                                collide = false;
                                wasUncontended5 = wasUncontended6;
                            } else if (!collide) {
                                collide = true;
                                wasUncontended5 = wasUncontended6;
                            } else if (this.busy != 0 || !casBusy()) {
                                wasUncontended5 = wasUncontended6;
                            } else {
                                try {
                                    if (this.cells == as) {
                                        Cell[] rs2 = new Cell[(n << 1)];
                                        for (int i4 = 0; i4 < n; i4++) {
                                            rs2[i4] = as[i4];
                                        }
                                        this.cells = rs2;
                                    }
                                    i = 0;
                                    this.busy = i;
                                    collide = false;
                                    wasUncontended5 = wasUncontended6;
                                } catch (Throwable th) {
                                    this.busy = 0;
                                    throw th;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    int h2 = (h << 13) ^ h;
                    int h3 = h2 ^ (h2 >>> 17);
                    int h4 = h3 ^ (h3 << 5);
                    hc2[0] = h4;
                    h = h4;
                    wasUncontended3 = wasUncontended5;
                    wasUncontended2 = false;
                    i = wasUncontended2;
                    wasUncontended5 = wasUncontended3;
                } else {
                    wasUncontended4 = wasUncontended5;
                }
            } else {
                wasUncontended4 = wasUncontended5;
            }
            if (this.busy == 0 && this.cells == as && casBusy()) {
                boolean init = false;
                try {
                    if (this.cells == as) {
                        Cell[] rs3 = new Cell[2];
                        rs3[h & 1] = new Cell(j);
                        this.cells = rs3;
                        init = true;
                    }
                    if (!init) {
                        wasUncontended2 = false;
                    } else {
                        return;
                    }
                } finally {
                    this.busy = 0;
                }
            } else {
                wasUncontended2 = false;
                long v2 = this.base;
                if (casBase(v2, fn(v2, j))) {
                    return;
                }
            }
            wasUncontended3 = wasUncontended4;
            i = wasUncontended2;
            wasUncontended5 = wasUncontended3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void internalReset(long initialValue) {
        Cell[] as = this.cells;
        this.base = initialValue;
        if (as != null) {
            for (Cell a : as) {
                if (a != null) {
                    a.value = initialValue;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException e) {
            try {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                    public Unsafe run() throws Exception {
                        Class<Unsafe> k = Unsafe.class;
                        for (Field f : k.getDeclaredFields()) {
                            f.setAccessible(true);
                            Object x = f.get((Object) null);
                            if (k.isInstance(x)) {
                                return k.cast(x);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
    }
}
