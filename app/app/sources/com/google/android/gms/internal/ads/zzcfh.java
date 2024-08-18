package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfh extends zzb {
    final zzcee zza;
    final zzcfp zzb;
    private final String zzc;
    private final String[] zzd;

    zzcfh(zzcee zzcee, zzcfp zzcfp, String str, String[] strArr) {
        this.zza = zzcee;
        this.zzb = zzcfp;
        this.zzc = str;
        this.zzd = strArr;
        zzu.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            zzt.zza.post(new zzcfg(this));
        }
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzbX)).booleanValue() || !(this.zzb instanceof zzcfy)) {
            return super.zzb();
        }
        return zzcci.zze.zzb(new zzcff(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
