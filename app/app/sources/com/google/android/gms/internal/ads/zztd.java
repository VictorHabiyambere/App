package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zztd extends Handler {
    final /* synthetic */ zztf zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zztd(zztf zztf, Looper looper) {
        super(looper);
        this.zza = zztf;
    }

    public final void handleMessage(Message message) {
        zztf.zza(this.zza, message);
    }
}
