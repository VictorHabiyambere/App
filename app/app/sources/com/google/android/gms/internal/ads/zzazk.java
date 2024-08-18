package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazk extends zzazs {
    private final StackTraceElement[] zzi;

    public zzazk(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzaye, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzatp, i, 45);
        this.zzi = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavc zzavc;
        StackTraceElement[] stackTraceElementArr = this.zzi;
        if (stackTraceElementArr != null) {
            zzaxv zzaxv = new zzaxv((String) this.zzf.invoke((Object) null, new Object[]{stackTraceElementArr}));
            synchronized (this.zze) {
                this.zze.zzL(zzaxv.zza.longValue());
                if (zzaxv.zzb.booleanValue()) {
                    zzatp zzatp = this.zze;
                    if (zzaxv.zzc.booleanValue()) {
                        zzavc = zzavc.ENUM_FALSE;
                    } else {
                        zzavc = zzavc.ENUM_TRUE;
                    }
                    zzatp.zzA(zzavc);
                } else {
                    this.zze.zzA(zzavc.ENUM_FAILURE);
                }
            }
        }
    }
}
