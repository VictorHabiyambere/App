package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdwa implements AppEventListener, zzdcg, zza, zzczl, zzdaf, zzdag, zzdaz, zzczo, zzflu {
    private final List zza;
    private final zzdvo zzb;
    private long zzc;

    public zzdwa(zzdvo zzdvo, zzcjd zzcjd) {
        this.zzb = zzdvo;
        this.zza = Collections.singletonList(zzcjd);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(String.valueOf(cls.getSimpleName())), str, objArr);
    }

    public final void onAdClicked() {
        zzg(zza.class, "onAdClicked", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void zza() {
        zzg(zzczl.class, "onAdClosed", new Object[0]);
    }

    public final void zzb() {
        zzg(zzczl.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzc() {
        zzg(zzczl.class, "onAdOpened", new Object[0]);
    }

    public final void zzd(zzfln zzfln, String str) {
        zzg(zzflm.class, "onTaskSucceeded", str);
    }

    public final void zzdB(zze zze) {
        zzg(zzczo.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzdC(zzfln zzfln, String str) {
        zzg(zzflm.class, "onTaskCreated", str);
    }

    public final void zzdD(zzfln zzfln, String str, Throwable th) {
        zzg(zzflm.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzdE(zzfln zzfln, String str) {
        zzg(zzflm.class, "onTaskStarted", str);
    }

    public final void zzdj(Context context) {
        zzg(zzdag.class, "onDestroy", context);
    }

    public final void zzdl(Context context) {
        zzg(zzdag.class, "onPause", context);
    }

    public final void zzdm(Context context) {
        zzg(zzdag.class, "onResume", context);
    }

    public final void zzdn(zzbxu zzbxu) {
        this.zzc = zzu.zzB().elapsedRealtime();
        zzg(zzdcg.class, "onAdRequest", new Object[0]);
    }

    public final void zzdo(zzfhf zzfhf) {
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbyh zzbyh, String str, String str2) {
        zzg(zzczl.class, "onRewarded", zzbyh, str, str2);
    }

    public final void zze() {
        zzg(zzczl.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzf() {
        zzg(zzczl.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzr() {
        zzg(zzdaf.class, "onAdImpression", new Object[0]);
    }

    public final void zzs() {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zzg(zzdaz.class, "onAdLoaded", new Object[0]);
    }
}
