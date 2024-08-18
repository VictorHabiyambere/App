package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzxn implements zzvm, zzvl {
    private final zzvm zza;
    private final long zzb;
    private zzvl zzc;

    public zzxn(zzvm zzvm, long j) {
        this.zza = zzvm;
        this.zzb = j;
    }

    public final long zza(long j, zzmr zzmr) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmr) + j2;
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzb2 + this.zzb;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return zzc2 + this.zzb;
    }

    public final long zzd() {
        long zzd = this.zza.zzd();
        if (zzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzd + this.zzb;
    }

    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    public final long zzf(zzzg[] zzzgArr, boolean[] zArr, zzxf[] zzxfArr, boolean[] zArr2, long j) {
        zzxf[] zzxfArr2 = zzxfArr;
        zzxf[] zzxfArr3 = new zzxf[zzxfArr2.length];
        int i = 0;
        while (true) {
            zzxf zzxf = null;
            if (i >= zzxfArr2.length) {
                break;
            }
            zzxm zzxm = (zzxm) zzxfArr2[i];
            if (zzxm != null) {
                zzxf = zzxm.zzc();
            }
            zzxfArr3[i] = zzxf;
            i++;
        }
        long zzf = this.zza.zzf(zzzgArr, zArr, zzxfArr3, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzxfArr2.length; i2++) {
            zzxf zzxf2 = zzxfArr3[i2];
            if (zzxf2 == null) {
                zzxfArr2[i2] = null;
            } else {
                zzxf zzxf3 = zzxfArr2[i2];
                if (zzxf3 == null || ((zzxm) zzxf3).zzc() != zzxf2) {
                    zzxfArr2[i2] = new zzxm(zzxf2, this.zzb);
                }
            }
        }
        return zzf + this.zzb;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxh zzxh) {
        zzvm zzvm = (zzvm) zzxh;
        zzvl zzvl = this.zzc;
        if (zzvl != null) {
            zzvl.zzg(this);
            return;
        }
        throw null;
    }

    public final zzxr zzh() {
        return this.zza.zzh();
    }

    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    public final void zzl(zzvl zzvl, long j) {
        this.zzc = zzvl;
        this.zza.zzl(this, j - this.zzb);
    }

    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzvm zzn() {
        return this.zza;
    }

    public final boolean zzo(zzlo zzlo) {
        long j = zzlo.zza;
        long j2 = this.zzb;
        zzlm zza2 = zzlo.zza();
        zza2.zze(j - j2);
        return this.zza.zzo(zza2.zzg());
    }

    public final boolean zzp() {
        return this.zza.zzp();
    }

    public final void zzi(zzvm zzvm) {
        zzvl zzvl = this.zzc;
        if (zzvl != null) {
            zzvl.zzi(this);
            return;
        }
        throw null;
    }
}
