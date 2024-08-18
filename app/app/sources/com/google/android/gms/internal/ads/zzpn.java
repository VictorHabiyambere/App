package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpn {
    public static final zzpn zza;
    public final int zzb;
    public final int zzc;
    private final zzgbh zzd;

    static {
        zzpn zzpn;
        if (zzgd.zza >= 33) {
            zzgbg zzgbg = new zzgbg();
            for (int i = 1; i <= 10; i++) {
                zzgbg.zzf(Integer.valueOf(zzgd.zzh(i)));
            }
            zzpn = new zzpn(2, (Set) zzgbg.zzi());
        } else {
            zzpn = new zzpn(2, 10);
        }
        zza = zzpn;
    }

    public zzpn(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzpn(int i, Set set) {
        this.zzb = i;
        this.zzd = zzgbh.zzl(set);
        zzgdi zze = this.zzd.iterator();
        int i2 = 0;
        while (zze.hasNext()) {
            i2 = Math.max(i2, Integer.bitCount(((Integer) zze.next()).intValue()));
        }
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpn)) {
            return false;
        }
        zzpn zzpn = (zzpn) obj;
        return this.zzb == zzpn.zzb && this.zzc == zzpn.zzc && zzgd.zzG(this.zzd, zzpn.zzd);
    }

    public final int hashCode() {
        zzgbh zzgbh = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzgbh == null ? 0 : zzgbh.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + valueOf + "]";
    }

    public final int zza(int i, zzk zzk) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzgd.zza >= 29) {
            return zzpl.zza(this.zzb, i, zzk);
        }
        Integer num = (Integer) zzpp.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        if (num != null) {
            return num.intValue();
        }
        throw null;
    }

    public final boolean zzb(int i) {
        if (this.zzd == null) {
            return i <= this.zzc;
        }
        int zzh = zzgd.zzh(i);
        if (zzh == 0) {
            return false;
        }
        return this.zzd.contains(Integer.valueOf(zzh));
    }
}
