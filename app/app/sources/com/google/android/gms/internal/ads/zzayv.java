package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzayv extends zzazs {
    private final long zzi;

    public zzayv(zzaye zzaye, String str, String str2, zzatp zzatp, long j, int i, int i2) {
        super(zzaye, "Rx5KxmHu63h8QT7T4cYR2mu7F4LQnYkocG/Azb9HP8ZHyjUHnRxxCuB99BIp3kbl", "3fysZeGzwX+hqd2f4+qtlSho+oF+DeFl9kzKrTFOSWo=", zzatp, i, 25);
        this.zzi = j;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzv(longValue);
            long j = this.zzi;
            if (j != 0) {
                this.zze.zzZ(longValue - j);
                this.zze.zzab(this.zzi);
            }
        }
    }
}
