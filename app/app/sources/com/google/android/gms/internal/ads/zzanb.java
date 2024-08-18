package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanb implements zzalv {
    private final zzfu zza = new zzfu();

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        zzei zzei;
        boolean z;
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfu zzfu = this.zza;
            if (zzfu.zzb() > 0) {
                zzeq.zze(zzfu.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
                zzfu zzfu2 = this.zza;
                int zzg = zzfu2.zzg() - 8;
                if (zzfu2.zzg() == 1987343459) {
                    zzfu zzfu3 = this.zza;
                    CharSequence charSequence = null;
                    zzeg zzeg = null;
                    while (zzg > 0) {
                        if (zzg >= 8) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zzeq.zze(z, "Incomplete vtt cue box header found.");
                        int zzg2 = zzfu3.zzg();
                        int zzg3 = zzfu3.zzg();
                        int i3 = zzg - 8;
                        int i4 = zzg2 - 8;
                        String zzB = zzgd.zzB(zzfu3.zzM(), zzfu3.zzd(), i4);
                        zzfu3.zzL(i4);
                        if (zzg3 == 1937011815) {
                            zzeg = zzanl.zzb(zzB);
                        } else if (zzg3 == 1885436268) {
                            charSequence = zzanl.zza((String) null, zzB.trim(), Collections.emptyList());
                        }
                        zzg = i3 - i4;
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (zzeg != null) {
                        zzeg.zzl(charSequence);
                        zzei = zzeg.zzp();
                    } else {
                        zzank zzank = new zzank();
                        zzank.zzc = charSequence;
                        zzei = zzank.zza().zzp();
                    }
                    arrayList.add(zzei);
                } else {
                    this.zza.zzL(zzg);
                }
            } else {
                zzev.zza(new zzaln(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
