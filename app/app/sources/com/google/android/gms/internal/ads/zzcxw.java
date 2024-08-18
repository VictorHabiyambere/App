package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzax;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcxw implements zzdcg, zzdhu {
    private final Context zza;
    private final zzfho zzb;
    private final VersionInfoParcel zzc;
    private final zzg zzd;
    private final zzdxf zze;
    private final zzfmq zzf;

    public zzcxw(Context context, zzfho zzfho, VersionInfoParcel versionInfoParcel, zzg zzg, zzdxf zzdxf, zzfmq zzfmq) {
        this.zza = context;
        this.zzb = zzfho;
        this.zzc = versionInfoParcel;
        this.zzd = zzg;
        this.zze = zzdxf;
        this.zzf = zzfmq;
    }

    private final void zzc() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzdW)).booleanValue()) {
            zzg zzg = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzfho zzfho = this.zzb;
            zzfmq zzfmq = this.zzf;
            zzu.zza().zzc(context, versionInfoParcel, zzfho.zzf, zzg.zzh(), zzfmq);
        }
        this.zze.zzr();
    }

    public final void zzdn(zzbxu zzbxu) {
        zzc();
    }

    public final void zzdo(zzfhf zzfhf) {
    }

    public final void zze(zzax zzax) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzdX)).booleanValue()) {
            zzc();
        }
    }

    public final void zzf(String str) {
    }
}
