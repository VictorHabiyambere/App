package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaok {
    private final zzafa zza;
    private final SparseArray zzb = new SparseArray();
    private final SparseArray zzc = new SparseArray();
    private final zzgs zzd = new zzgs(this.zze, 0, 0);
    private final byte[] zze = new byte[128];
    private int zzf;
    private long zzg;
    private long zzh;
    private final zzaoj zzi = new zzaoj((zzaoi) null);
    private final zzaoj zzj = new zzaoj((zzaoi) null);
    private boolean zzk = false;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;

    public zzaok(zzafa zzafa, boolean z, boolean z2) {
        this.zza = zzafa;
    }

    public final void zza(zzgp zzgp) {
        this.zzc.append(zzgp.zza, zzgp);
    }

    public final void zzb(zzgq zzgq) {
        this.zzb.append(zzgq.zzd, zzgq);
    }

    public final void zzc() {
        this.zzk = false;
    }

    public final void zzd(long j, int i, long j2, boolean z) {
        this.zzf = i;
        this.zzh = j2;
        this.zzg = j;
        this.zzo = z;
    }

    public final boolean zze(long j, int i, boolean z) {
        boolean z2 = false;
        if (this.zzf == 9) {
            if (z && this.zzk) {
                long j2 = this.zzg;
                int i2 = i + ((int) (j - j2));
                long j3 = this.zzm;
                if (j3 != -9223372036854775807L) {
                    this.zza.zzs(j3, this.zzn ? 1 : 0, (int) (j2 - this.zzl), i2, (zzaez) null);
                }
            }
            this.zzl = this.zzg;
            this.zzm = this.zzh;
            this.zzn = false;
            this.zzk = true;
        }
        boolean z3 = this.zzo;
        boolean z4 = this.zzn;
        int i3 = this.zzf;
        if (i3 == 5 || (z3 && i3 == 1)) {
            z2 = true;
        }
        boolean z5 = z4 | z2;
        this.zzn = z5;
        return z5;
    }
}
