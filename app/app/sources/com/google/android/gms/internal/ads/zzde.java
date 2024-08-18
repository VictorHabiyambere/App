package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzde {
    @Deprecated
    public static final zzn zza = new zzdd();
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public final int zzb;
    public final String zzc;
    public final int zzd;
    private final zzan[] zzg;
    private int zzh;

    public zzde(String str, zzan... zzanArr) {
        boolean z;
        int length = zzanArr.length;
        int i = 1;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        this.zzc = str;
        this.zzg = zzanArr;
        this.zzb = length;
        int zzb2 = zzcg.zzb(zzanArr[0].zzn);
        this.zzd = zzb2 == -1 ? zzcg.zzb(zzanArr[0].zzm) : zzb2;
        String zzc2 = zzc(this.zzg[0].zze);
        int i2 = this.zzg[0].zzg | 16384;
        while (true) {
            zzan[] zzanArr2 = this.zzg;
            if (i >= zzanArr2.length) {
                return;
            }
            if (!zzc2.equals(zzc(zzanArr2[i].zze))) {
                zzan[] zzanArr3 = this.zzg;
                zzd("languages", zzanArr3[0].zze, zzanArr3[i].zze, i);
                return;
            }
            zzan[] zzanArr4 = this.zzg;
            if (i2 != (zzanArr4[i].zzg | 16384)) {
                zzd("role flags", Integer.toBinaryString(zzanArr4[0].zzg), Integer.toBinaryString(this.zzg[i].zzg), i);
                return;
            }
            i++;
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        zzfk.zzd("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzde zzde = (zzde) obj;
        return this.zzc.equals(zzde.zzc) && Arrays.equals(this.zzg, zzde.zzg);
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        int hashCode = ((this.zzc.hashCode() + 527) * 31) + Arrays.hashCode(this.zzg);
        this.zzh = hashCode;
        return hashCode;
    }

    public final int zza(zzan zzan) {
        int i = 0;
        while (true) {
            zzan[] zzanArr = this.zzg;
            if (i >= zzanArr.length) {
                return -1;
            }
            if (zzan == zzanArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final zzan zzb(int i) {
        return this.zzg[i];
    }
}
