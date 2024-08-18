package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbif;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class NativeAdViewHolder {
    public static final WeakHashMap zza = new WeakHashMap();
    @NotOnlyInitialized
    private zzbif zzb;
    private WeakReference zzc;

    public NativeAdViewHolder(View containerView, Map<String, View> clickableAssetViews, Map<String, View> nonclickableAssetViews) {
        Preconditions.checkNotNull(containerView, "ContainerView must not be null");
        if (containerView instanceof NativeAdView) {
            zzm.zzg("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zza.get(containerView) != null) {
            zzm.zzg("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zza.put(containerView, this);
            this.zzc = new WeakReference(containerView);
            this.zzb = zzay.zza().zzi(containerView, zza(clickableAssetViews), zza(nonclickableAssetViews));
        }
    }

    private static final HashMap zza(Map map) {
        if (map == null) {
            return new HashMap();
        }
        return new HashMap(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzb.zzb(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzm.zzh("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(NativeAd ad) {
        View view;
        ? zza2 = ad.zza();
        WeakReference weakReference = this.zzc;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            zzm.zzj("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zza.containsKey(view)) {
            zza.put(view, this);
        }
        zzbif zzbif = this.zzb;
        if (zzbif != null) {
            try {
                zzbif.zzc(zza2);
            } catch (RemoteException e) {
                zzm.zzh("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public void unregisterNativeAd() {
        View view;
        zzbif zzbif = this.zzb;
        if (zzbif != null) {
            try {
                zzbif.zzd();
            } catch (RemoteException e) {
                zzm.zzh("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference weakReference = this.zzc;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            zza.remove(view);
        }
    }
}
