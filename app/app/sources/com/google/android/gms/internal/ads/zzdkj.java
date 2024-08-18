package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdkj implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;
    private final zzhlg zze;
    private final zzhlg zzf;

    public zzdkj(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4, zzhlg zzhlg5, zzhlg zzhlg6) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
        this.zze = zzhlg5;
        this.zzf = zzhlg6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcyt zza2 = ((zzczd) this.zzb).zza();
        zzdfc zza3 = ((zzdfw) this.zzc).zza();
        zzdjy zza4 = ((zzdka) this.zzd).zza();
        zzdca zza5 = ((zzcse) this.zze).zzb();
        zzelf zzelf = (zzelf) this.zzf.zzb();
        zzctf zze2 = ((zzcjd) this.zza.zzb()).zze();
        zze2.zzi(zza2.zzj());
        zze2.zzf(zza3);
        zze2.zzd(zza4);
        zze2.zze(new zzenl((zzbfk) null));
        zze2.zzg(new zzcuh(zza5, (zzdeh) null));
        zze2.zzc(new zzcsc((ViewGroup) null));
        if (((Boolean) zzba.zzc().zza(zzbep.zzdD)).booleanValue()) {
            zze2.zzj(zzelo.zzb(zzelf));
        }
        zzcus zzc2 = zze2.zzk().zzc();
        zzhkx.zzb(zzc2);
        return zzc2;
    }
}
