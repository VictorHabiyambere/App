package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazh extends zzazs {
    public zzazh(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2) {
        super(zzaye, "0njjbCFUq6vJ1UgnErUI7KEtLgZLN7V9IJ5yZ3QtzXmjMaTjzKInpeDNakYTgh0P", "C8NIMy/t/HZjKrbJt0Xe/Cv+czK1jvEhHHQsIVfXSJE=", zzatp, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zze.zzI(((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue() ? zzavc.ENUM_TRUE : zzavc.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            this.zze.zzI(zzavc.ENUM_FAILURE);
        }
    }
}
