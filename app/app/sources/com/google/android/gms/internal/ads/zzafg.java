package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzafg {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzcd zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzgd.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzfk.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(String.valueOf(str)));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzagw.zzb(new zzfu(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzfk.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzaio(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzcd((List) arrayList);
    }

    public static zzafd zzc(zzfu zzfu, boolean z, boolean z2) throws zzch {
        if (z) {
            zzd(3, zzfu, false);
        }
        String zzA = zzfu.zzA((int) zzfu.zzs(), zzfxs.zzc);
        int length = zzA.length();
        long zzs = zzfu.zzs();
        String[] strArr = new String[((int) zzs)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < zzs; i2++) {
            String zzA2 = zzfu.zzA((int) zzfu.zzs(), zzfxs.zzc);
            strArr[i2] = zzA2;
            i = i + 4 + zzA2.length();
        }
        if (!z2 || (zzfu.zzm() & 1) != 0) {
            return new zzafd(zzA, strArr, i + 1);
        }
        throw zzch.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i, zzfu zzfu, boolean z) throws zzch {
        if (zzfu.zzb() < 7) {
            if (z) {
                return false;
            }
            int zzb = zzfu.zzb();
            throw zzch.zza("too short header: " + zzb, (Throwable) null);
        } else if (zzfu.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzch.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), (Throwable) null);
        } else if (zzfu.zzm() == 118 && zzfu.zzm() == 111 && zzfu.zzm() == 114 && zzfu.zzm() == 98 && zzfu.zzm() == 105 && zzfu.zzm() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw zzch.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
