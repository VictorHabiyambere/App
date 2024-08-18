package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbju;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbwl;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzbzm;
import com.google.android.gms.internal.ads.zzcbg;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzaw {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzeq zzc;
    /* access modifiers changed from: private */
    public final zzbju zzd;
    private final zzbzm zze;
    /* access modifiers changed from: private */
    public final zzbvd zzf;
    /* access modifiers changed from: private */
    public final zzbjv zzg;
    /* access modifiers changed from: private */
    public zzbwl zzh;

    public zzaw(zzk zzk, zzi zzi, zzeq zzeq, zzbju zzbju, zzbzm zzbzm, zzbvd zzbvd, zzbjv zzbjv) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzeq;
        this.zzd = zzbju;
        this.zze = zzbzm;
        this.zzf = zzbvd;
        this.zzg = zzbjv;
    }

    static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbrf zzbrf) {
        return (zzbq) new zzao(this, context, str, zzbrf).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzq, String str, zzbrf zzbrf) {
        return (zzbu) new zzak(this, context, zzq, str, zzbrf).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzq, String str, zzbrf zzbrf) {
        return (zzbu) new zzam(this, context, zzq, str, zzbrf).zzd(context, false);
    }

    public final zzdj zzf(Context context, zzbrf zzbrf) {
        return (zzdj) new zzac(this, context, zzbrf).zzd(context, false);
    }

    public final zzbhz zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbhz) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbif zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbif) new zzau(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbmr zzl(Context context, zzbrf zzbrf, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbmr) new zzai(this, context, zzbrf, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbuz zzm(Context context, zzbrf zzbrf) {
        return (zzbuz) new zzag(this, context, zzbrf).zzd(context, false);
    }

    public final zzbvg zzo(Activity activity) {
        zzaa zzaa = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzm.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbvg) zzaa.zzd(activity, z);
    }

    public final zzbza zzq(Context context, String str, zzbrf zzbrf) {
        return (zzbza) new zzav(this, context, str, zzbrf).zzd(context, false);
    }

    public final zzcbg zzr(Context context, zzbrf zzbrf) {
        return (zzcbg) new zzae(this, context, zzbrf).zzd(context, false);
    }
}
