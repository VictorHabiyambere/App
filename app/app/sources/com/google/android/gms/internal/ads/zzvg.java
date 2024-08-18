package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzvg implements zzvm, zzvl {
    public final zzvo zza;
    private final long zzb;
    private zzvq zzc;
    private zzvm zzd;
    private zzvl zze;
    private long zzf = -9223372036854775807L;
    private final zzzv zzg;

    public zzvg(zzvo zzvo, zzzv zzzv, long j) {
        this.zza = zzvo;
        this.zzg = zzzv;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    public final long zza(long j, zzmr zzmr) {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zza(j, zzmr);
    }

    public final long zzb() {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zzb();
    }

    public final long zzc() {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zzc();
    }

    public final long zzd() {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zzd();
    }

    public final long zze(long j) {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zze(j);
    }

    public final long zzf(zzzg[] zzzgArr, boolean[] zArr, zzxf[] zzxfArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zzf(zzzgArr, zArr, zzxfArr, zArr2, j3);
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxh zzxh) {
        zzvm zzvm = (zzvm) zzxh;
        zzvl zzvl = this.zze;
        int i = zzgd.zza;
        zzvl.zzg(this);
    }

    public final zzxr zzh() {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        return zzvm.zzh();
    }

    public final void zzi(zzvm zzvm) {
        zzvl zzvl = this.zze;
        int i = zzgd.zza;
        zzvl.zzi(this);
    }

    public final void zzj(long j, boolean z) {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        zzvm.zzj(j, false);
    }

    public final void zzk() throws IOException {
        try {
            zzvm zzvm = this.zzd;
            if (zzvm != null) {
                zzvm.zzk();
                return;
            }
            zzvq zzvq = this.zzc;
            if (zzvq != null) {
                zzvq.zzz();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public final void zzl(zzvl zzvl, long j) {
        this.zze = zzvl;
        zzvm zzvm = this.zzd;
        if (zzvm != null) {
            zzvm.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j) {
        zzvm zzvm = this.zzd;
        int i = zzgd.zza;
        zzvm.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(zzlo zzlo) {
        zzvm zzvm = this.zzd;
        return zzvm != null && zzvm.zzo(zzlo);
    }

    public final boolean zzp() {
        zzvm zzvm = this.zzd;
        return zzvm != null && zzvm.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzvo zzvo) {
        long zzv = zzv(this.zzb);
        zzvq zzvq = this.zzc;
        if (zzvq != null) {
            this.zzd = zzvq.zzI(zzvo, this.zzg, zzv);
            if (this.zze != null) {
                this.zzd.zzl(this, zzv);
                return;
            }
            return;
        }
        throw null;
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzvq zzvq) {
        zzeq.zzf(this.zzc == null);
        this.zzc = zzvq;
    }

    public final void zzt() {
        zzvm zzvm = this.zzd;
        if (zzvm != null) {
            zzvq zzvq = this.zzc;
            if (zzvq != null) {
                zzvq.zzG(zzvm);
                return;
            }
            throw null;
        }
    }
}
