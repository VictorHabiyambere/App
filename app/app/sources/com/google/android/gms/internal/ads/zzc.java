package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzc {
    static final String zza = Integer.toString(8, 36);
    @Deprecated
    public static final zzn zzb = new zzb();
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    private static final String zzr = Integer.toString(7, 36);
    public final long zzc;
    public final int zzd;
    @Deprecated
    public final Uri[] zze;
    public final zzbu[] zzf;
    public final int[] zzg;
    public final long[] zzh;
    public final long zzi;
    public final boolean zzj;

    public zzc(long j) {
        this(0, -1, -1, new int[0], new zzbu[0], new long[0], 0, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzc zzc2 = (zzc) obj;
        return this.zzd == zzc2.zzd && Arrays.equals(this.zzf, zzc2.zzf) && Arrays.equals(this.zzg, zzc2.zzg) && Arrays.equals(this.zzh, zzc2.zzh);
    }

    public final int hashCode() {
        return ((((((((this.zzd * 31) - 1) * 961) + Arrays.hashCode(this.zzf)) * 31) + Arrays.hashCode(this.zzg)) * 31) + Arrays.hashCode(this.zzh)) * 961;
    }

    public final int zza(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.zzg;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public final zzc zzb(int i) {
        int[] iArr = this.zzg;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzh;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new zzc(0, 0, -1, copyOf, (zzbu[]) Arrays.copyOf(this.zzf, 0), copyOf2, 0, false);
    }

    private zzc(long j, int i, int i2, int[] iArr, zzbu[] zzbuArr, long[] jArr, long j2, boolean z) {
        boolean z2;
        int length = iArr.length;
        int length2 = zzbuArr.length;
        int i3 = 0;
        if (length == length2) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzeq.zzd(z2);
        this.zzc = 0;
        this.zzd = i;
        this.zzg = iArr;
        this.zzf = zzbuArr;
        this.zzh = jArr;
        this.zzi = 0;
        this.zzj = false;
        this.zze = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zze;
            if (i3 < uriArr.length) {
                zzbu zzbu = zzbuArr[i3];
                Uri uri = null;
                if (zzbu != null) {
                    zzbn zzbn = zzbu.zzd;
                    if (zzbn != null) {
                        uri = zzbn.zzb;
                    } else {
                        throw null;
                    }
                }
                uriArr[i3] = uri;
                i3++;
            } else {
                return;
            }
        }
    }
}
