package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpc {
    final /* synthetic */ zzpd zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzvo zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzpc(zzpd zzpd, String str, int i, zzvo zzvo) {
        this.zza = zzpd;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzvo == null ? -1 : zzvo.zzd;
        if (zzvo != null && zzvo.zzb()) {
            this.zze = zzvo;
        }
    }

    public final void zzg(int i, zzvo zzvo) {
        if (this.zzd == -1 && i == this.zzc && zzvo != null) {
            zzpd zzpd = this.zza;
            long j = zzvo.zzd;
            if (j >= zzpd.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzvo zzvo) {
        if (zzvo == null) {
            return i == this.zzc;
        }
        zzvo zzvo2 = this.zze;
        return zzvo2 == null ? !zzvo.zzb() && zzvo.zzd == this.zzd : zzvo.zzd == zzvo2.zzd && zzvo.zzb == zzvo2.zzb && zzvo.zzc == zzvo2.zzc;
    }

    public final boolean zzk(zzmy zzmy) {
        zzvo zzvo = zzmy.zzd;
        if (zzvo == null) {
            return this.zzc != zzmy.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zzvo.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzdc zzdc = zzmy.zzb;
        int zza2 = zzdc.zza(zzvo.zza);
        int zza3 = zzdc.zza(this.zze.zza);
        zzvo zzvo2 = zzmy.zzd;
        if (zzvo2.zzd < this.zze.zzd || zza2 < zza3) {
            return false;
        }
        if (zza2 > zza3) {
            return true;
        }
        if (zzvo2.zzb()) {
            zzvo zzvo3 = zzmy.zzd;
            int i = zzvo3.zzb;
            int i2 = zzvo3.zzc;
            zzvo zzvo4 = this.zze;
            int i3 = zzvo4.zzb;
            if (i > i3) {
                return true;
            }
            if (i == i3) {
                return i2 > zzvo4.zzc;
            }
            return false;
        }
        int i4 = zzmy.zzd.zze;
        return i4 == -1 || i4 > this.zze.zzb;
    }

    public final boolean zzl(zzdc zzdc, zzdc zzdc2) {
        int i = this.zzc;
        if (i < zzdc.zzc()) {
            zzdc.zze(i, this.zza.zzc, 0);
            int i2 = this.zza.zzc.zzp;
            while (true) {
                if (i2 > this.zza.zzc.zzq) {
                    i = -1;
                    break;
                }
                int zza2 = zzdc2.zza(zzdc.zzf(i2));
                if (zza2 != -1) {
                    i = zzdc2.zzd(zza2, this.zza.zzd, false).zzd;
                    break;
                }
                i2++;
            }
        } else if (i >= zzdc2.zzc()) {
            i = -1;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzvo zzvo = this.zze;
        if (zzvo != null && zzdc2.zza(zzvo.zza) == -1) {
            return false;
        }
        return true;
    }
}
