package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzady {
    public static int zza(zzadv zzadv, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int zzb = zzadv.zzb(bArr, i + i3, i2 - i3);
            if (zzb == -1) {
                break;
            }
            i3 += zzb;
        }
        return i3;
    }

    @Pure
    public static void zzb(boolean z, String str) throws zzch {
        if (!z) {
            throw zzch.zza(str, (Throwable) null);
        }
    }

    public static boolean zzc(zzadv zzadv, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzadv.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzadv zzadv, byte[] bArr, int i, int i2) throws IOException {
        try {
            ((zzadi) zzadv).zzn(bArr, i, i2, false);
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    public static boolean zze(zzadv zzadv, int i) throws IOException {
        try {
            ((zzadi) zzadv).zzo(i, false);
            return true;
        } catch (EOFException e) {
            return false;
        }
    }
}
