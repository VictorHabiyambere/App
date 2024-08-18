package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanm implements zzalv {
    private final zzfu zza = new zzfu();
    private final zzanc zzb = new zzanc();

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        this.zza.zzI(bArr, i2 + i);
        this.zza.zzK(i);
        ArrayList arrayList = new ArrayList();
        try {
            zzfu zzfu = this.zza;
            int zzd = zzfu.zzd();
            String zzy = zzfu.zzy(zzfxs.zzc);
            if (zzy == null || !zzy.startsWith("WEBVTT")) {
                zzfu.zzK(zzd);
                throw zzch.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzfu.zzy(zzfxs.zzc))), (Throwable) null);
            }
            do {
            } while (!TextUtils.isEmpty(this.zza.zzy(zzfxs.zzc)));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzfu zzfu2 = this.zza;
                char c = 65535;
                int i3 = 0;
                while (c == 65535) {
                    i3 = zzfu2.zzd();
                    String zzy2 = zzfu2.zzy(zzfxs.zzc);
                    if (zzy2 == null) {
                        c = 0;
                    } else if ("STYLE".equals(zzy2)) {
                        c = 2;
                    } else {
                        c = zzy2.startsWith("NOTE") ? (char) 1 : 3;
                    }
                }
                zzfu2.zzK(i3);
                if (c == 0) {
                    zzalp.zza(new zzanp(arrayList2), zzalu, zzev);
                    return;
                } else if (c == 1) {
                    do {
                    } while (!TextUtils.isEmpty(this.zza.zzy(zzfxs.zzc)));
                } else if (c != 2) {
                    zzane zzc = zzanl.zzc(this.zza, arrayList);
                    if (zzc != null) {
                        arrayList2.add(zzc);
                    }
                } else if (arrayList2.isEmpty()) {
                    this.zza.zzy(zzfxs.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                } else {
                    throw new IllegalArgumentException("A style block was found after the first cue.");
                }
            }
        } catch (zzch e) {
            throw new IllegalArgumentException(e);
        }
    }
}
