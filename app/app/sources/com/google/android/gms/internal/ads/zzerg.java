package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzerg {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzerf zzb;

    /* access modifiers changed from: package-private */
    public final zzerf zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzerf zzerf) {
        this.zzb = zzerf;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
