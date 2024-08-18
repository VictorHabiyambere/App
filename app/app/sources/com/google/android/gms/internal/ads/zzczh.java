package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzczh implements zzhkp {
    private final zzczg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;

    public zzczh(zzczg zzczg, zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzczg;
        this.zzb = zzhlg;
        this.zzc = zzhlg2;
        this.zzd = zzhlg3;
        this.zze = zzhlg4;
    }

    public final /* synthetic */ Object zzb() {
        String str;
        Context context = (Context) this.zzb.zzb();
        VersionInfoParcel zza2 = ((zzcjv) this.zzc).zza();
        zzfgt zza3 = ((zzcvg) this.zzd).zza();
        zzcab zzcab = new zzcab();
        zzcac zzcac = zza3.zzB;
        if (zzcac == null) {
            return null;
        }
        zzfgy zzfgy = zza3.zzt;
        if (zzfgy == null) {
            str = null;
        } else {
            str = zzfgy.zzb;
        }
        return new zzcaa(context, zza2, zzcac, str, zzcab);
    }
}
