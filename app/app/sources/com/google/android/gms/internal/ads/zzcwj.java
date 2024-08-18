package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbdv;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcwj implements zzdaz, zza, zzdcg, zzdaf, zzczl, zzdes {
    private final Clock zza;
    private final zzcbr zzb;

    public zzcwj(Clock clock, zzcbr zzcbr) {
        this.zza = clock;
        this.zzb = zzcbr;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zza() {
        this.zzb.zze();
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzdn(zzbxu zzbxu) {
    }

    public final void zzdo(zzfhf zzfhf) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final void zzds(zzbyh zzbyh, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    public final void zzh() {
    }

    public final void zzi(zzbdv.zzb zzb2) {
        this.zzb.zzi();
    }

    public final void zzj(zzbdv.zzb zzb2) {
    }

    public final void zzk(zzl zzl) {
        this.zzb.zzj(zzl);
    }

    public final void zzl(boolean z) {
    }

    public final void zzm(zzbdv.zzb zzb2) {
        this.zzb.zzg();
    }

    public final void zzn(boolean z) {
    }

    public final void zzr() {
        this.zzb.zzf();
    }

    public final void zzs() {
        this.zzb.zzh(true);
    }
}
