package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzael {
    private final zzfu zza = new zzfu(10);

    public final zzcd zza(zzadv zzadv, zzaho zzaho) throws IOException {
        zzcd zzcd = null;
        int i = 0;
        while (true) {
            try {
                ((zzadi) zzadv).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int zzl = this.zza.zzl();
                int i2 = zzl + 10;
                if (zzcd == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzadi) zzadv).zzm(bArr, 10, zzl, false);
                    zzcd = zzahq.zza(bArr, i2, zzaho, new zzagr());
                } else {
                    ((zzadi) zzadv).zzl(zzl, false);
                }
                i += i2;
            } catch (EOFException e) {
            }
        }
        zzadv.zzj();
        ((zzadi) zzadv).zzl(i, false);
        return zzcd;
    }
}
