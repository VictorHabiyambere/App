package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzayq extends zzazs {
    public zzayq(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2) {
        super(zzaye, "d7YRusR2mxxBt1bBYjK2gXVvJl/MfqFw2IiZZVeFOFqksQBErGXLOKgf56kYtWpK", "q4VBjxb/Ij/RcUKEcmQK+TpC64QFNLpq6sfIawaWN1g=", zzatp, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavc zzavc;
        this.zze.zzf(zzavc.ENUM_FAILURE);
        try {
            boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
            zzatp zzatp = this.zze;
            if (booleanValue) {
                zzavc = zzavc.ENUM_TRUE;
            } else {
                zzavc = zzavc.ENUM_FALSE;
            }
            zzatp.zzf(zzavc);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
