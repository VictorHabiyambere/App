package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzfy implements zzfa {
    private Message zza;
    private zzfz zzb;

    private zzfy() {
        throw null;
    }

    /* synthetic */ zzfy(zzfx zzfx) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzfz.zzl(this);
    }

    public final zzfy zzb(Message message, zzfz zzfz) {
        this.zza = message;
        this.zzb = zzfz;
        return this;
    }

    public final void zza() {
        Message message = this.zza;
        if (message != null) {
            message.sendToTarget();
            zzd();
            return;
        }
        throw null;
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        if (message != null) {
            boolean sendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
            zzd();
            return sendMessageAtFrontOfQueue;
        }
        throw null;
    }
}
