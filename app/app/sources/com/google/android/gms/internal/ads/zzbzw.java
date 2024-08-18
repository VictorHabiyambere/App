package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbzw implements Runnable {
    public final /* synthetic */ zzcaa zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzbzw(zzcaa zzcaa, Bitmap bitmap) {
        this.zza = zzcaa;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
