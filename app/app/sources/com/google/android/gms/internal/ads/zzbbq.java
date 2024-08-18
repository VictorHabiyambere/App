package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbbq {
    ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    public final String toString() {
        String str;
        try {
            this.zzb.close();
        } catch (IOException e) {
            zzm.zzh("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zza.close();
            str = this.zza.toString();
        } catch (IOException e2) {
            zzm.zzh("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } catch (Throwable th) {
            this.zza = null;
            this.zzb = null;
            throw th;
        }
        this.zza = null;
        this.zzb = null;
        return str;
    }
}
