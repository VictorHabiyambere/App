package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaky extends zzali {
    private zzaeg zza;
    private zzakx zzb;

    zzaky() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfu zzfu) {
        if (!zzd(zzfu.zzM())) {
            return -1;
        }
        int i = (zzfu.zzM()[2] & 255) >> 4;
        if (i != 6) {
            if (i == 7) {
                i = 7;
            }
            int zza2 = zzaec.zza(zzfu, i);
            zzfu.zzK(0);
            return (long) zza2;
        }
        zzfu.zzL(4);
        zzfu.zzw();
        int zza22 = zzaec.zza(zzfu, i);
        zzfu.zzK(0);
        return (long) zza22;
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfu zzfu, long j, zzalf zzalf) {
        byte[] zzM = zzfu.zzM();
        zzaeg zzaeg = this.zza;
        if (zzaeg == null) {
            zzaeg zzaeg2 = new zzaeg(zzM, 17);
            this.zza = zzaeg2;
            zzalf.zza = zzaeg2.zzc(Arrays.copyOfRange(zzM, 9, zzfu.zze()), (zzcd) null);
            return true;
        } else if ((zzM[0] & Byte.MAX_VALUE) == 3) {
            zzaef zzb2 = zzaed.zzb(zzfu);
            zzaeg zzf = zzaeg.zzf(zzb2);
            this.zza = zzf;
            this.zzb = new zzakx(zzf, zzb2);
            return true;
        } else if (!zzd(zzM)) {
            return true;
        } else {
            zzakx zzakx = this.zzb;
            if (zzakx != null) {
                zzakx.zza(j);
                zzalf.zzb = this.zzb;
            }
            if (zzalf.zza != null) {
                return false;
            }
            throw null;
        }
    }
}
