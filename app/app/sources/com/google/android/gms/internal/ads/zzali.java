package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
abstract class zzali {
    private final zzalb zza = new zzalb();
    private zzafa zzb;
    private zzadx zzc;
    private zzald zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzalf zzj = new zzalf();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    /* access modifiers changed from: protected */
    public abstract long zza(zzfu zzfu);

    /* access modifiers changed from: protected */
    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzalf();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzfu zzfu, long j, zzalf zzalf) throws IOException;

    /* access modifiers changed from: package-private */
    public final int zze(zzadv zzadv, zzaeq zzaeq) throws IOException {
        boolean z;
        zzadv zzadv2 = zzadv;
        zzeq.zzb(this.zzb);
        int i = zzgd.zza;
        switch (this.zzh) {
            case 0:
                break;
            case 1:
                ((zzadi) zzadv2).zzo((int) this.zzf, false);
                this.zzh = 2;
                return 0;
            case 2:
                long zzd2 = this.zzd.zzd(zzadv2);
                if (zzd2 >= 0) {
                    zzaeq.zza = zzd2;
                    return 1;
                }
                if (zzd2 < -1) {
                    zzi(-(zzd2 + 2));
                }
                if (!this.zzl) {
                    zzaet zze2 = this.zzd.zze();
                    zzeq.zzb(zze2);
                    this.zzc.zzO(zze2);
                    this.zzl = true;
                }
                if (this.zzk > 0 || this.zza.zze(zzadv2)) {
                    this.zzk = 0;
                    zzfu zza2 = this.zza.zza();
                    long zza3 = zza(zza2);
                    if (zza3 >= 0) {
                        long j = this.zzg;
                        if (j + zza3 >= this.zze) {
                            long zzf2 = zzf(j);
                            zzaey.zzb(this.zzb, zza2, zza2.zze());
                            this.zzb.zzs(zzf2, 1, zza2.zze(), 0, (zzaez) null);
                            this.zze = -1;
                        }
                    }
                    this.zzg += zza3;
                    return 0;
                }
                this.zzh = 3;
                return -1;
            default:
                return -1;
        }
        while (this.zza.zze(zzadv2)) {
            long zzf3 = zzadv.zzf();
            long j2 = this.zzf;
            this.zzk = zzf3 - j2;
            if (zzc(this.zza.zza(), j2, this.zzj)) {
                this.zzf = zzadv.zzf();
            } else {
                zzan zzan = this.zzj.zza;
                this.zzi = zzan.zzB;
                if (!this.zzm) {
                    this.zzb.zzl(zzan);
                    this.zzm = true;
                }
                zzald zzald = this.zzj.zzb;
                if (zzald != null) {
                    this.zzd = zzald;
                } else if (zzadv.zzd() == -1) {
                    this.zzd = new zzalh((zzalg) null);
                } else {
                    zzalc zzb2 = this.zza.zzb();
                    if ((zzb2.zza & 4) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.zzd = new zzakw(this, this.zzf, zzadv.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, z);
                }
                this.zzh = 2;
                this.zza.zzd();
                return 0;
            }
        }
        this.zzh = 3;
        return -1;
    }

    /* access modifiers changed from: protected */
    public final long zzf(long j) {
        return (j * AnimationKt.MillisToNanos) / ((long) this.zzi);
    }

    /* access modifiers changed from: protected */
    public final long zzg(long j) {
        return (((long) this.zzi) * j) / AnimationKt.MillisToNanos;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzadx zzadx, zzafa zzafa) {
        this.zzc = zzadx;
        this.zzb = zzafa;
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzi(long j) {
        this.zzg = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzald zzald = this.zzd;
            int i = zzgd.zza;
            zzald.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
