package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzuu implements zzvy, zzsp {
    final /* synthetic */ zzuw zza;
    private final Object zzb;
    private zzvx zzc;
    private zzso zzd;

    public zzuu(zzuw zzuw, Object obj) {
        this.zza = zzuw;
        this.zzc = zzuw.zze((zzvo) null);
        this.zzd = zzuw.zzc((zzvo) null);
        this.zzb = obj;
    }

    private final zzvk zzf(zzvk zzvk, zzvo zzvo) {
        zzuw zzuw = this.zza;
        Object obj = this.zzb;
        long j = zzvk.zzc;
        zzuw.zzx(obj, j, zzvo);
        zzuw zzuw2 = this.zza;
        Object obj2 = this.zzb;
        long j2 = zzvk.zzd;
        zzuw2.zzx(obj2, j2, zzvo);
        return (j == zzvk.zzc && j2 == zzvk.zzd) ? zzvk : new zzvk(1, zzvk.zza, zzvk.zzb, 0, (Object) null, j, j2);
    }

    private final boolean zzg(int i, zzvo zzvo) {
        zzvo zzvo2;
        if (zzvo != null) {
            zzvo2 = this.zza.zzy(this.zzb, zzvo);
            if (zzvo2 == null) {
                return false;
            }
        } else {
            zzvo2 = null;
        }
        this.zza.zzw(this.zzb, 0);
        zzvx zzvx = this.zzc;
        int i2 = zzvx.zza;
        if (!zzgd.zzG(zzvx.zzb, zzvo2)) {
            this.zzc = this.zza.zzf(0, zzvo2);
        }
        zzso zzso = this.zzd;
        int i3 = zzso.zza;
        if (zzgd.zzG(zzso.zzb, zzvo2)) {
            return true;
        }
        this.zzd = this.zza.zzd(0, zzvo2);
        return true;
    }

    public final void zzae(int i, zzvo zzvo, zzvk zzvk) {
        if (zzg(0, zzvo)) {
            this.zzc.zzc(zzf(zzvk, zzvo));
        }
    }

    public final void zzaf(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        if (zzg(0, zzvo)) {
            this.zzc.zzd(zzvf, zzf(zzvk, zzvo));
        }
    }

    public final void zzag(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        if (zzg(0, zzvo)) {
            this.zzc.zze(zzvf, zzf(zzvk, zzvo));
        }
    }

    public final void zzah(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        if (zzg(0, zzvo)) {
            this.zzc.zzf(zzvf, zzf(zzvk, zzvo), iOException, z);
        }
    }

    public final void zzai(int i, zzvo zzvo, zzvf zzvf, zzvk zzvk) {
        if (zzg(0, zzvo)) {
            this.zzc.zzg(zzvf, zzf(zzvk, zzvo));
        }
    }
}
