package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzfc implements Handler.Callback {
    public final /* synthetic */ zzfh zza;

    public /* synthetic */ zzfc(zzfh zzfh) {
        this.zza = zzfh;
    }

    public final boolean handleMessage(Message message) {
        zzfh.zzg(this.zza, message);
        return true;
    }
}
