package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbsk extends zzbrt {
    private final NativeAdMapper zza;

    public zzbsk(NativeAdMapper nativeAdMapper) {
        this.zza = nativeAdMapper;
    }

    public final boolean zzA() {
        return this.zza.getOverrideClickHandling();
    }

    public final boolean zzB() {
        return this.zza.getOverrideImpressionRecording();
    }

    public final double zze() {
        if (this.zza.getStarRating() != null) {
            return this.zza.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final float zzf() {
        return this.zza.getMediaContentAspectRatio();
    }

    public final float zzg() {
        return this.zza.getCurrentTime();
    }

    public final float zzh() {
        return this.zza.getDuration();
    }

    public final Bundle zzi() {
        return this.zza.getExtras();
    }

    public final zzdq zzj() {
        return null;
    }

    public final zzbho zzk() {
        return null;
    }

    public final zzbhv zzl() {
        NativeAd.Image icon = this.zza.getIcon();
        if (icon != null) {
            return new zzbhi(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.zzb(), icon.zza());
        }
        return null;
    }

    public final IObjectWrapper zzm() {
        View adChoicesContent = this.zza.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    public final IObjectWrapper zzn() {
        View zza2 = this.zza.zza();
        if (zza2 == null) {
            return null;
        }
        return ObjectWrapper.wrap(zza2);
    }

    public final IObjectWrapper zzo() {
        return null;
    }

    public final String zzp() {
        return this.zza.getAdvertiser();
    }

    public final String zzq() {
        return this.zza.getBody();
    }

    public final String zzr() {
        return this.zza.getCallToAction();
    }

    public final String zzs() {
        return this.zza.getHeadline();
    }

    public final String zzt() {
        return this.zza.getPrice();
    }

    public final String zzu() {
        return this.zza.getStore();
    }

    public final List zzv() {
        List<NativeAd.Image> images = this.zza.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image next : images) {
                arrayList.add(new zzbhi(next.getDrawable(), next.getUri(), next.getScale(), next.zzb(), next.zza()));
            }
        }
        return arrayList;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zza.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzx() {
        this.zza.recordImpression();
    }

    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        this.zza.trackViews(view, (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final void zzz(IObjectWrapper iObjectWrapper) {
        this.zza.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
