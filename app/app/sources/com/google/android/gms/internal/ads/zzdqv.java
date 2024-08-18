package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqv extends zzdqf implements zzdhi {
    private zzdhi zza;

    public final synchronized void zzdG() {
        zzdhi zzdhi = this.zza;
        if (zzdhi != null) {
            zzdhi.zzdG();
        }
    }

    public final synchronized void zzdf() {
        zzdhi zzdhi = this.zza;
        if (zzdhi != null) {
            zzdhi.zzdf();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzi(zza zza2, zzbkf zzbkf, zzp zzp, zzbkh zzbkh, zzaa zzaa, zzdhi zzdhi) {
        super.zzh(zza2, zzbkf, zzp, zzbkh, zzaa);
        this.zza = zzdhi;
    }
}
