package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzbdv;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdts implements zzdcg, zzdaz, zzczo, zzdaf, zza, zzdes {
    private final zzbdm zza;
    private boolean zzb = false;

    public zzdts(zzbdm zzbdm, @Nullable zzfeo zzfeo) {
        this.zza = zzbdm;
        zzbdm.zzb(zzbdo.AD_REQUEST);
        if (zzfeo != null) {
            zzbdm.zzb(zzbdo.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzb(zzbdo.AD_FIRST_CLICK);
            this.zzb = true;
            return;
        }
        this.zza.zzb(zzbdo.AD_SUBSEQUENT_CLICK);
    }

    public final void zzdB(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zza.zzb(zzbdo.AD_FAILED_TO_LOAD);
                return;
        }
    }

    public final void zzdn(zzbxu zzbxu) {
    }

    public final void zzdo(zzfhf zzfhf) {
        this.zza.zzc(new zzdto(zzfhf));
    }

    public final void zzh() {
        this.zza.zzb(zzbdo.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzi(zzbdv.zzb zzb2) {
        this.zza.zzc(new zzdtr(zzb2));
        this.zza.zzb(zzbdo.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzj(zzbdv.zzb zzb2) {
        this.zza.zzc(new zzdtp(zzb2));
        this.zza.zzb(zzbdo.REQUEST_SAVED_TO_CACHE);
    }

    public final void zzl(boolean z) {
        zzbdo zzbdo;
        if (z) {
            zzbdo = zzbdo.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            zzbdo = zzbdo.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        this.zza.zzb(zzbdo);
    }

    public final void zzm(zzbdv.zzb zzb2) {
        this.zza.zzc(new zzdtq(zzb2));
        this.zza.zzb(zzbdo.REQUEST_PREFETCH_INTERCEPTED);
    }

    public final void zzn(boolean z) {
        zzbdo zzbdo;
        if (z) {
            zzbdo = zzbdo.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            zzbdo = zzbdo.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        this.zza.zzb(zzbdo);
    }

    public final synchronized void zzr() {
        this.zza.zzb(zzbdo.AD_IMPRESSION);
    }

    public final void zzs() {
        this.zza.zzb(zzbdo.AD_LOADED);
    }
}
