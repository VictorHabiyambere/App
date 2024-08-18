package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzww extends zzuo implements zzwn {
    private final zzha zza;
    private final zzst zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = -9223372036854775807L;
    private boolean zzf;
    private boolean zzg;
    private zzie zzh;
    private zzbu zzi;
    private final zzwt zzj;
    private final zzzz zzk;

    /* synthetic */ zzww(zzbu zzbu, zzha zzha, zzwt zzwt, zzst zzst, zzzz zzzz, int i, zzwv zzwv) {
        this.zzi = zzbu;
        this.zza = zzha;
        this.zzj = zzwt;
        this.zzb = zzst;
        this.zzk = zzzz;
        this.zzc = i;
    }

    private final void zzw() {
        zzbk zzbk;
        zzdc zzdc;
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzbu zzJ = zzJ();
        if (z2) {
            zzbk = zzJ.zzf;
        } else {
            zzbk = null;
        }
        zzxj zzxj = r1;
        zzxj zzxj2 = new zzxj(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j, 0, 0, z, false, false, (Object) null, zzJ, zzbk);
        if (this.zzd) {
            zzdc = new zzws(this, zzxj);
        } else {
            zzdc = zzxj;
        }
        zzo(zzdc);
    }

    public final void zzG(zzvm zzvm) {
        ((zzwr) zzvm).zzN();
    }

    public final zzvm zzI(zzvo zzvo, zzzv zzzv, long j) {
        zzhb zza2 = this.zza.zza();
        zzie zzie = this.zzh;
        if (zzie != null) {
            zza2.zzf(zzie);
        }
        zzbn zzbn = zzJ().zzd;
        if (zzbn != null) {
            zzwt zzwt = this.zzj;
            zzb();
            return new zzwr(zzbn.zzb, zza2, new zzuq(zzwt.zza), this.zzb, zzc(zzvo), this.zzk, zze(zzvo), this, zzzv, (String) null, this.zzc, zzgd.zzr(-9223372036854775807L));
        }
        throw null;
    }

    public final synchronized zzbu zzJ() {
        return this.zzi;
    }

    public final void zza(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.zze;
        }
        if (this.zzd || this.zze != j || this.zzf != z || this.zzg != z2) {
            this.zze = j;
            this.zzf = z;
            this.zzg = z2;
            this.zzd = false;
            zzw();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzie zzie) {
        this.zzh = zzie;
        if (Looper.myLooper() != null) {
            zzb();
            zzw();
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
    }

    public final synchronized void zzt(zzbu zzbu) {
        this.zzi = zzbu;
    }

    public final void zzz() {
    }
}
