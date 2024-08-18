package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzajp {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzfu zzf;
    private final zzfu zzg;
    private int zzh;
    private int zzi;

    public zzajp(zzfu zzfu, zzfu zzfu2, boolean z) throws zzch {
        this.zzg = zzfu;
        this.zzf = zzfu2;
        this.zze = z;
        zzfu2.zzK(12);
        this.zza = zzfu2.zzp();
        zzfu.zzK(12);
        this.zzi = zzfu.zzp();
        zzady.zzb(zzfu.zzg() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzv();
        } else {
            j = this.zzf.zzu();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzp();
            this.zzg.zzL(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzp();
            }
            this.zzh = i2;
        }
        return true;
    }
}
