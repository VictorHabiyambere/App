package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzale extends zzali {
    private static final byte[] zza = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final byte[] zzb = {79, 112, 117, 115, 84, 97, 103, 115};
    private boolean zzc;

    zzale() {
    }

    public static boolean zzd(zzfu zzfu) {
        return zzk(zzfu, zza);
    }

    private static boolean zzk(zzfu zzfu, byte[] bArr) {
        if (zzfu.zzb() < 8) {
            return false;
        }
        int zzd = zzfu.zzd();
        byte[] bArr2 = new byte[8];
        zzfu.zzG(bArr2, 0, 8);
        zzfu.zzK(zzd);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public final long zza(zzfu zzfu) {
        return zzg(zzaep.zzd(zzfu.zzM()));
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zzc = false;
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean zzc(zzfu zzfu, long j, zzalf zzalf) throws zzch {
        if (zzk(zzfu, zza)) {
            byte[] copyOf = Arrays.copyOf(zzfu.zzM(), zzfu.zze());
            byte b = copyOf[9] & 255;
            List zze = zzaep.zze(copyOf);
            if (zzalf.zza == null) {
                zzal zzal = new zzal();
                zzal.zzX("audio/opus");
                zzal.zzy(b);
                zzal.zzY(48000);
                zzal.zzL(zze);
                zzalf.zza = zzal.zzad();
                return true;
            }
        } else if (zzk(zzfu, zzb)) {
            zzeq.zzb(zzalf.zza);
            if (!this.zzc) {
                this.zzc = true;
                zzfu.zzL(8);
                zzcd zzb2 = zzafg.zzb(zzgbc.zzl(zzafg.zzc(zzfu, false, false).zzb));
                if (zzb2 != null) {
                    zzal zzb3 = zzalf.zza.zzb();
                    zzb3.zzQ(zzb2.zzd(zzalf.zza.zzl));
                    zzalf.zza = zzb3.zzad();
                    return true;
                }
            }
        } else {
            zzeq.zzb(zzalf.zza);
            return false;
        }
        return true;
    }
}
