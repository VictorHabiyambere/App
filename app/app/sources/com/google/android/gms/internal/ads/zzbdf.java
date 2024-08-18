package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbdf extends PushbackInputStream {
    final /* synthetic */ zzbdg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbdf(zzbdg zzbdg, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbdg;
    }

    public final synchronized void close() throws IOException {
        zzbdi.zze(this.zza.zzc);
        super.close();
    }
}
