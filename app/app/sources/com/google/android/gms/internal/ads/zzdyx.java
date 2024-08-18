package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzdi;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdyx extends zzdi {
    final Map zza = new HashMap();
    private final Context zzb;
    private final WeakReference zzc;
    /* access modifiers changed from: private */
    public final zzdyl zzd;
    private final zzgge zze;
    private final zzdyy zzf;
    private zzdya zzg;

    zzdyx(Context context, WeakReference weakReference, zzdyl zzdyl, zzdyy zzdyy, zzgge zzgge) {
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdyl;
        this.zze = zzgge;
        this.zzf = zzdyy;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    private static AdRequest zzk() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        return ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build();
    }

    /* access modifiers changed from: private */
    public static String zzl(Object obj) {
        ResponseInfo responseInfo;
        zzdn zzc2;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else if (!(obj instanceof NativeAd)) {
            return "";
        } else {
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzc2 = responseInfo.zzc()) == null) {
            return "";
        }
        try {
            return zzc2.zzh();
        } catch (RemoteException e) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzm(String str, String str2) {
        try {
            zzgft.zzr(this.zzg.zzb(str), new zzdyv(this, str2), this.zze);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk(str2);
        }
    }

    private final synchronized void zzn(String str, String str2) {
        try {
            zzgft.zzr(this.zzg.zzb(str), new zzdyw(this, str2), this.zze);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk(str2);
        }
    }

    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context != null && viewGroup != null) {
            Object obj = this.zza.get(str);
            if (obj != null) {
                this.zza.remove(str);
            }
            if (obj instanceof AdView) {
                zzdyy.zza(context, viewGroup, (AdView) obj);
            } else if (obj instanceof NativeAd) {
                zzdyy.zzb(context, viewGroup, (NativeAd) obj);
            }
        }
    }

    public final void zzf(zzdya zzdya) {
        this.zzg = zzdya;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzg(String str, Object obj, String str2) {
        this.zza.put(str, obj);
        zzm(zzl(obj), str2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = r5.hashCode()     // Catch:{ all -> 0x00dc }
            r1 = 1
            switch(r0) {
                case -1999289321: goto L_0x003c;
                case -1372958932: goto L_0x0032;
                case -428325382: goto L_0x0028;
                case 543046670: goto L_0x001e;
                case 1854800829: goto L_0x0014;
                case 1951953708: goto L_0x000a;
                default: goto L_0x0009;
            }     // Catch:{ all -> 0x00dc }
        L_0x0009:
            goto L_0x0046
        L_0x000a:
            java.lang.String r0 = "BANNER"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = r1
            goto L_0x0047
        L_0x0014:
            java.lang.String r0 = "REWARDED_INTERSTITIAL"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = 5
            goto L_0x0047
        L_0x001e:
            java.lang.String r0 = "REWARDED"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = 4
            goto L_0x0047
        L_0x0028:
            java.lang.String r0 = "APP_OPEN_AD"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = 0
            goto L_0x0047
        L_0x0032:
            java.lang.String r0 = "INTERSTITIAL"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = 2
            goto L_0x0047
        L_0x003c:
            java.lang.String r0 = "NATIVE"
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x0009
            r5 = 3
            goto L_0x0047
        L_0x0046:
            r5 = -1
        L_0x0047:
            switch(r5) {
                case 0: goto L_0x00ca;
                case 1: goto L_0x00a8;
                case 2: goto L_0x0096;
                case 3: goto L_0x0070;
                case 4: goto L_0x005e;
                case 5: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            monitor-exit(r3)
            return
        L_0x004c:
            android.content.Context r5 = r3.zzj()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdyt r1 = new com.google.android.gms.internal.ads.zzdyt     // Catch:{ all -> 0x00dc }
            r1.<init>(r3, r4, r6)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd.load((android.content.Context) r5, (java.lang.String) r4, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback) r1)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x005e:
            android.content.Context r5 = r3.zzj()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdys r1 = new com.google.android.gms.internal.ads.zzdys     // Catch:{ all -> 0x00dc }
            r1.<init>(r3, r4, r6)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.rewarded.RewardedAd.load((android.content.Context) r5, (java.lang.String) r4, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewarded.RewardedAdLoadCallback) r1)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x0070:
            com.google.android.gms.ads.AdLoader$Builder r5 = new com.google.android.gms.ads.AdLoader$Builder     // Catch:{ all -> 0x00dc }
            android.content.Context r0 = r3.zzj()     // Catch:{ all -> 0x00dc }
            r5.<init>(r0, r4)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdym r0 = new com.google.android.gms.internal.ads.zzdym     // Catch:{ all -> 0x00dc }
            r0.<init>(r3, r4, r6)     // Catch:{ all -> 0x00dc }
            r5.forNativeAd(r0)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdyu r4 = new com.google.android.gms.internal.ads.zzdyu     // Catch:{ all -> 0x00dc }
            r4.<init>(r3, r6)     // Catch:{ all -> 0x00dc }
            r5.withAdListener(r4)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdLoader r4 = r5.build()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r5 = zzk()     // Catch:{ all -> 0x00dc }
            r4.loadAd((com.google.android.gms.ads.AdRequest) r5)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x0096:
            android.content.Context r5 = r3.zzj()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdyr r1 = new com.google.android.gms.internal.ads.zzdyr     // Catch:{ all -> 0x00dc }
            r1.<init>(r3, r4, r6)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.interstitial.InterstitialAd.load(r5, r4, r0, r1)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x00a8:
            com.google.android.gms.ads.AdView r5 = new com.google.android.gms.ads.AdView     // Catch:{ all -> 0x00dc }
            android.content.Context r0 = r3.zzj()     // Catch:{ all -> 0x00dc }
            r5.<init>(r0)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdSize r0 = com.google.android.gms.ads.AdSize.BANNER     // Catch:{ all -> 0x00dc }
            r5.setAdSize(r0)     // Catch:{ all -> 0x00dc }
            r5.setAdUnitId(r4)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdyq r0 = new com.google.android.gms.internal.ads.zzdyq     // Catch:{ all -> 0x00dc }
            r0.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x00dc }
            r5.setAdListener(r0)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r4 = zzk()     // Catch:{ all -> 0x00dc }
            r5.loadAd(r4)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x00ca:
            android.content.Context r5 = r3.zzj()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.internal.ads.zzdyp r2 = new com.google.android.gms.internal.ads.zzdyp     // Catch:{ all -> 0x00dc }
            r2.<init>(r3, r4, r6)     // Catch:{ all -> 0x00dc }
            com.google.android.gms.ads.appopen.AppOpenAd.load((android.content.Context) r5, (java.lang.String) r4, (com.google.android.gms.ads.AdRequest) r0, (int) r1, (com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback) r2)     // Catch:{ all -> 0x00dc }
            monitor-exit(r3)
            return
        L_0x00dc:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyx.zzh(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ad, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzdyl r0 = r4.zzd     // Catch:{ all -> 0x00ae }
            android.app.Activity r0 = r0.zzg()     // Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x000b
            goto L_0x00ac
        L_0x000b:
            java.util.Map r1 = r4.zza     // Catch:{ all -> 0x00ae }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00ac
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzjt     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ae }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ all -> 0x00ae }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00ae }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.appopen.AppOpenAd     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ all -> 0x00ae }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ all -> 0x00ae }
            if (r2 == 0) goto L_0x003a
        L_0x0035:
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x00ae }
            r2.remove(r5)     // Catch:{ all -> 0x00ae }
        L_0x003a:
            java.lang.String r2 = zzl(r1)     // Catch:{ all -> 0x00ae }
            r4.zzn(r2, r6)     // Catch:{ all -> 0x00ae }
            boolean r6 = r1 instanceof com.google.android.gms.ads.appopen.AppOpenAd     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.ads.appopen.AppOpenAd r1 = (com.google.android.gms.ads.appopen.AppOpenAd) r1     // Catch:{ all -> 0x00ae }
            r1.show(r0)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)
            return
        L_0x004c:
            boolean r6 = r1 instanceof com.google.android.gms.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x0057
            com.google.android.gms.ads.interstitial.InterstitialAd r1 = (com.google.android.gms.ads.interstitial.InterstitialAd) r1     // Catch:{ all -> 0x00ae }
            r1.show(r0)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)
            return
        L_0x0057:
            boolean r6 = r1 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x0067
            com.google.android.gms.ads.rewarded.RewardedAd r1 = (com.google.android.gms.ads.rewarded.RewardedAd) r1     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ads.zzdyn r5 = new com.google.android.gms.internal.ads.zzdyn     // Catch:{ all -> 0x00ae }
            r5.<init>()     // Catch:{ all -> 0x00ae }
            r1.show(r0, r5)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)
            return
        L_0x0067:
            boolean r6 = r1 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x0077
            com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd r1 = (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd) r1     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ads.zzdyo r5 = new com.google.android.gms.internal.ads.zzdyo     // Catch:{ all -> 0x00ae }
            r5.<init>()     // Catch:{ all -> 0x00ae }
            r1.show(r0, r5)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)
            return
        L_0x0077:
            com.google.android.gms.internal.ads.zzbeg r6 = com.google.android.gms.internal.ads.zzbep.zzjt     // Catch:{ all -> 0x00ae }
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ae }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ all -> 0x00ae }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00ae }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x00ac
            boolean r6 = r1 instanceof com.google.android.gms.ads.AdView     // Catch:{ all -> 0x00ae }
            if (r6 != 0) goto L_0x0091
            boolean r6 = r1 instanceof com.google.android.gms.ads.nativead.NativeAd     // Catch:{ all -> 0x00ae }
            if (r6 == 0) goto L_0x00ac
        L_0x0091:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00ae }
            r6.<init>()     // Catch:{ all -> 0x00ae }
            android.content.Context r0 = r4.zzj()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "com.google.android.gms.ads.OutOfContextTestingActivity"
            r6.setClassName(r0, r1)     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "adUnit"
            r6.putExtra(r1, r5)     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x00ae }
            com.google.android.gms.ads.internal.util.zzt.zzT(r0, r6)     // Catch:{ all -> 0x00ae }
            monitor-exit(r4)
            return
        L_0x00ac:
            monitor-exit(r4)
            return
        L_0x00ae:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyx.zzi(java.lang.String, java.lang.String):void");
    }
}
