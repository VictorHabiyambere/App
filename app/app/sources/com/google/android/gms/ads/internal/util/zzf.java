package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzfuv;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzf extends zzfuv {
    public zzf(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzu.zzo().zzw(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            zzu.zzp();
            zzt.zzM(zzu.zzo().zzd(), th);
            throw th;
        }
    }
}
