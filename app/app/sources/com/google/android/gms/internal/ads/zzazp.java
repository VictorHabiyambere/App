package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazp extends zzazs {
    private final View zzi;

    public zzazp(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, View view) {
        super(zzaye, "fHaUCxrr3fcbpdQPVJw6OSoHeHoizr6wmxmAsnLvDUhuNG2u8ebKX4VPxAoXSx4W", "K/sgHSTVeE1LLZ4HP+m5KF6ND+k7W4ID3M3VTul8bAI=", zzatp, i, 57);
        this.zzi = view;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzba.zzc().zza(zzbep.zzds);
            Boolean bool2 = (Boolean) zzba.zzc().zza(zzbep.zzkU);
            zzayi zzayi = new zzayi((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, this.zzb.zzb().getResources().getDisplayMetrics(), bool, bool2}));
            zzauq zza = zzaur.zza();
            zza.zzb(zzayi.zza.longValue());
            zza.zzd(zzayi.zzb.longValue());
            zza.zze(zzayi.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzayi.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzayi.zzd.longValue());
            }
            this.zze.zzaf((zzaur) zza.zzbr());
        }
    }
}
