package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzchd;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzi {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzi(zzchd zzchd) throws zzg {
        this.zzb = zzchd.getLayoutParams();
        ViewParent parent = zzchd.getParent();
        this.zzd = zzchd.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        this.zzc = (ViewGroup) parent;
        this.zza = this.zzc.indexOfChild(zzchd.zzF());
        this.zzc.removeView(zzchd.zzF());
        zzchd.zzaq(true);
    }
}
