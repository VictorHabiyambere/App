package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzxr {
    public static final zzxr zza = new zzxr(new zzde[0]);
    @Deprecated
    public static final zzn zzb = new zzxp();
    private static final String zzd = Integer.toString(0, 36);
    public final int zzc;
    private final zzgbc zze;
    private int zzf;

    public zzxr(zzde... zzdeArr) {
        this.zze = zzgbc.zzl(zzdeArr);
        this.zzc = zzdeArr.length;
        int i = 0;
        while (i < this.zze.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zze.size(); i3++) {
                if (((zzde) this.zze.get(i)).equals(this.zze.get(i3))) {
                    zzfk.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzxr zzxr = (zzxr) obj;
        return this.zzc == zzxr.zzc && this.zze.equals(zzxr.zze);
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zze.hashCode();
        this.zzf = hashCode;
        return hashCode;
    }

    public final int zza(zzde zzde) {
        int indexOf = this.zze.indexOf(zzde);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzde zzb(int i) {
        return (zzde) this.zze.get(i);
    }

    public final zzgbc zzc() {
        return zzgbc.zzk(zzgbs.zzb(this.zze, new zzxq()));
    }
}
