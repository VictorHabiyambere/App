package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdxe extends zzbnq {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfmc zzd;
    final /* synthetic */ zzccn zze;
    final /* synthetic */ zzdxf zzf;

    zzdxe(zzdxf zzdxf, Object obj, String str, long j, zzfmc zzfmc, zzccn zzccn) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfmc;
        this.zze = zzccn;
        this.zzf = zzdxf;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzfmq zze2 = this.zzf.zzp;
            zzfmc zzfmc = this.zzd;
            zzfmc.zzc(str);
            zzfmc.zzh(false);
            zze2.zzb(zzfmc.zzn());
            this.zze.zzc(false);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfmq zze2 = this.zzf.zzp;
            zzfmc zzfmc = this.zzd;
            zzfmc.zzh(true);
            zze2.zzb(zzfmc.zzn());
            this.zze.zzc(true);
        }
    }
}
