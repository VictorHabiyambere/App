package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbdv;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdtc implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;

    public zzdtc(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        int i;
        Context zza2 = ((zzcjj) this.zza).zza();
        String zza3 = ((zzdzv) this.zzb).zzb();
        VersionInfoParcel zza4 = ((zzcjv) this.zzc).zza();
        zzbdv.zza.C0000zza zza5 = (zzbdv.zza.C0000zza) this.zzd.zzb();
        String str = (String) this.zze.zzb();
        zzbdm zzbdm = new zzbdm(new zzbdu(zza2));
        zzbdv.zzar.zza zzd2 = zzbdv.zzar.zzd();
        zzd2.zzg(zza4.buddyApkVersion);
        zzd2.zzi(zza4.clientJarVersion);
        if (true != zza4.isClientJar) {
            i = 2;
        } else {
            i = 0;
        }
        zzd2.zzh(i);
        zzbdm.zzc(new zzdtb(zza5, zza3, (zzbdv.zzar) zzd2.zzbr(), str));
        return zzbdm;
    }
}
