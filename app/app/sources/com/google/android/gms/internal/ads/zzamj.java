package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzamj implements zzalv {
    private final zzfu zza = new zzfu();
    private final zzfu zzb = new zzfu();
    private final zzami zzc = new zzami();
    private Inflater zzd;

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        zzfu zzfu = this.zza;
        if (zzfu.zzb() > 0 && zzfu.zzf() == 120) {
            if (this.zzd == null) {
                this.zzd = new Inflater();
            }
            if (zzgd.zzI(zzfu, this.zzb, this.zzd)) {
                zzfu zzfu2 = this.zzb;
                zzfu.zzI(zzfu2.zzM(), zzfu2.zze());
            }
        }
        this.zzc.zze();
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfu zzfu3 = this.zza;
            if (zzfu3.zzb() >= 3) {
                zzami zzami = this.zzc;
                int zze = zzfu3.zze();
                int zzm = zzfu3.zzm();
                int zzq = zzfu3.zzq();
                int zzd2 = zzfu3.zzd() + zzq;
                zzei zzei = null;
                if (zzd2 > zze) {
                    zzfu3.zzK(zze);
                } else {
                    switch (zzm) {
                        case 20:
                            zzami.zzd(zzami, zzfu3, zzq);
                            break;
                        case 21:
                            zzami.zzb(zzami, zzfu3, zzq);
                            break;
                        case 22:
                            zzami.zzc(zzami, zzfu3, zzq);
                            break;
                        case 128:
                            zzei zza2 = zzami.zza();
                            zzami.zze();
                            zzei = zza2;
                            break;
                    }
                    zzfu3.zzK(zzd2);
                }
                if (zzei != null) {
                    arrayList.add(zzei);
                }
            } else {
                zzev.zza(new zzaln(arrayList, -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
