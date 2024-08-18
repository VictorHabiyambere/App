package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbqq {
    private final zzbpt zza;
    private ListenableFuture zzb;

    zzbqq(zzbpt zzbpt) {
        this.zza = zzbpt;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzccn zzccn = new zzccn();
            this.zzb = zzccn;
            this.zza.zzb((zzaxd) null).zzj(new zzbqn(zzccn), new zzbqo(zzccn));
        }
    }

    public final zzbqt zza(String str, zzbqa zzbqa, zzbpz zzbpz) {
        zzd();
        return new zzbqt(this.zzb, "google.afma.activeView.handleUpdate", zzbqa, zzbpz);
    }

    public final void zzb(String str, zzblp zzblp) {
        zzd();
        this.zzb = zzgft.zzn(this.zzb, new zzbqp(str, zzblp), zzcci.zzf);
    }

    public final void zzc(String str, zzblp zzblp) {
        this.zzb = zzgft.zzm(this.zzb, new zzbqm(str, zzblp), zzcci.zzf);
    }
}
