package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdwh {
    private final zzbmo zza;

    zzdwh(zzbmo zzbmo) {
        this.zza = zzbmo;
    }

    private final void zzs(zzdwg zzdwg) throws RemoteException {
        String zza2 = zzdwg.zza(zzdwg);
        zzm.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdwg("initialize", (zzdwf) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdClicked";
        this.zza.zzb(zzdwg.zza(zzdwg));
    }

    public final void zzc(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdClosed";
        zzs(zzdwg);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdFailedToLoad";
        zzdwg.zzd = Integer.valueOf(i);
        zzs(zzdwg);
    }

    public final void zze(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdLoaded";
        zzs(zzdwg);
    }

    public final void zzf(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdwg);
    }

    public final void zzg(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("interstitial", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdOpened";
        zzs(zzdwg);
    }

    public final void zzh(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("creation", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "nativeObjectCreated";
        zzs(zzdwg);
    }

    public final void zzi(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("creation", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "nativeObjectNotCreated";
        zzs(zzdwg);
    }

    public final void zzj(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdClicked";
        zzs(zzdwg);
    }

    public final void zzk(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onRewardedAdClosed";
        zzs(zzdwg);
    }

    public final void zzl(long j, zzbyx zzbyx) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onUserEarnedReward";
        zzdwg.zze = zzbyx.zzf();
        zzdwg.zzf = Integer.valueOf(zzbyx.zze());
        zzs(zzdwg);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onRewardedAdFailedToLoad";
        zzdwg.zzd = Integer.valueOf(i);
        zzs(zzdwg);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onRewardedAdFailedToShow";
        zzdwg.zzd = Integer.valueOf(i);
        zzs(zzdwg);
    }

    public final void zzo(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onAdImpression";
        zzs(zzdwg);
    }

    public final void zzp(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onRewardedAdLoaded";
        zzs(zzdwg);
    }

    public final void zzq(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdwg);
    }

    public final void zzr(long j) throws RemoteException {
        zzdwg zzdwg = new zzdwg("rewarded", (zzdwf) null);
        zzdwg.zza = Long.valueOf(j);
        zzdwg.zzc = "onRewardedAdOpened";
        zzs(zzdwg);
    }
}
