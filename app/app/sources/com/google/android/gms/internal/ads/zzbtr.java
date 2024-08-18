package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbtr extends zzbtd {
    private final RtbAdapter zza;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzb;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzc;
    /* access modifiers changed from: private */
    public MediationAppOpenAd zzd;
    private String zze = "";

    public zzbtr(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(zzl zzl) {
        Bundle bundle;
        Bundle bundle2 = zzl.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        zzm.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzm.zzh("", e);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(zzl zzl) {
        if (zzl.zzf) {
            return true;
        }
        zzay.zzb();
        return zzf.zzs();
    }

    private static final String zzy(String str, zzl zzl) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException e) {
            return zzl.zzu;
        }
    }

    public final zzdq zze() {
        RtbAdapter rtbAdapter = this.zza;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzm.zzh("", th);
            return null;
        }
    }

    public final zzbtt zzf() throws RemoteException {
        return zzbtt.zza(this.zza.getVersionInfo());
    }

    public final zzbtt zzg() throws RemoteException {
        return zzbtt.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0084, code lost:
        r1 = new com.google.android.gms.ads.mediation.MediationConfiguration(r6, r8);
        r6 = new java.util.ArrayList();
        r6.add(r1);
        r10.collectSignals(new com.google.android.gms.ads.mediation.rtb.RtbSignalData((android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5), r6, r7, com.google.android.gms.ads.zzb.zzc(r9.zze, r9.zzb, r9.zza)), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        throw new java.lang.IllegalArgumentException("Internal Error");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r5, java.lang.String r6, android.os.Bundle r7, android.os.Bundle r8, com.google.android.gms.ads.internal.client.zzq r9, com.google.android.gms.internal.ads.zzbth r10) throws android.os.RemoteException {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzbtp r0 = new com.google.android.gms.internal.ads.zzbtp     // Catch:{ all -> 0x00b0 }
            r0.<init>(r4, r10)     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r10 = r4.zza     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.ads.mediation.MediationConfiguration r1 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch:{ all -> 0x00b0 }
            int r2 = r6.hashCode()     // Catch:{ all -> 0x00b0 }
            switch(r2) {
                case -1396342996: goto L_0x004e;
                case -1052618729: goto L_0x0044;
                case -239580146: goto L_0x003a;
                case 604727084: goto L_0x0030;
                case 1167692200: goto L_0x0026;
                case 1778294298: goto L_0x001c;
                case 1911491517: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0059
        L_0x0011:
            java.lang.String r2 = "rewarded_interstitial"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 3
            goto L_0x005a
        L_0x001c:
            java.lang.String r2 = "app_open_ad"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 6
            goto L_0x005a
        L_0x0026:
            java.lang.String r2 = "app_open"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 5
            goto L_0x005a
        L_0x0030:
            java.lang.String r2 = "interstitial"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 1
            goto L_0x005a
        L_0x003a:
            java.lang.String r2 = "rewarded"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 2
            goto L_0x005a
        L_0x0044:
            java.lang.String r2 = "native"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 4
            goto L_0x005a
        L_0x004e:
            java.lang.String r2 = "banner"
            boolean r6 = r6.equals(r2)
            if (r6 == 0) goto L_0x0010
            r6 = 0
            goto L_0x005a
        L_0x0059:
            r6 = -1
        L_0x005a:
            switch(r6) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007f;
                case 2: goto L_0x007c;
                case 3: goto L_0x0079;
                case 4: goto L_0x0076;
                case 5: goto L_0x0073;
                case 6: goto L_0x005e;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x00a8
        L_0x005e:
            com.google.android.gms.internal.ads.zzbeg r6 = com.google.android.gms.internal.ads.zzbep.zzlN     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b0 }
            java.lang.Object r6 = r2.zza(r6)     // Catch:{ all -> 0x00b0 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00b0 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x00a8
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x0073:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x0076:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.NATIVE     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x0079:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x007c:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.REWARDED     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x007f:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.INTERSTITIAL     // Catch:{ all -> 0x00b0 }
            goto L_0x0084
        L_0x0082:
            com.google.android.gms.ads.AdFormat r6 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x00b0 }
        L_0x0084:
            r1.<init>(r6, r8)     // Catch:{ all -> 0x00b0 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x00b0 }
            r6.<init>()     // Catch:{ all -> 0x00b0 }
            r6.add(r1)     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r8 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r5)     // Catch:{ all -> 0x00b0 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ all -> 0x00b0 }
            int r2 = r9.zze     // Catch:{ all -> 0x00b0 }
            int r3 = r9.zzb     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = r9.zza     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.ads.AdSize r9 = com.google.android.gms.ads.zzb.zzc(r2, r3, r9)     // Catch:{ all -> 0x00b0 }
            r8.<init>(r1, r6, r7, r9)     // Catch:{ all -> 0x00b0 }
            r10.collectSignals(r8, r0)     // Catch:{ all -> 0x00b0 }
            return
        L_0x00a8:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = "Internal Error"
            r6.<init>(r7)     // Catch:{ all -> 0x00b0 }
            throw r6     // Catch:{ all -> 0x00b0 }
        L_0x00b0:
            r6 = move-exception
            java.lang.String r7 = "Error generating signals for RTB"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r7, r6)
            java.lang.String r7 = "adapter.collectSignals"
            com.google.android.gms.internal.ads.zzbrc.zza(r5, r6, r7)
            android.os.RemoteException r5 = new android.os.RemoteException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbtr.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.internal.ads.zzbth):void");
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl) throws RemoteException {
        zzn(str, str2, zzl, iObjectWrapper, zzbsy, zzbrl, (zzbhk) null);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsy zzbsy, zzbrl zzbrl, zzbhk zzbhk) throws RemoteException {
        zzl zzl2 = zzl;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzbsy zzbsy2 = zzbsy;
        zzbrl zzbrl2 = zzbrl;
        try {
            zzbtm zzbtm = new zzbtm(this, zzbsy2, zzbrl2);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzw = zzw(str2);
            Bundle zzv = zzv(zzl2);
            boolean zzx = zzx(zzl);
            Location location = zzl2.zzk;
            int i = zzl2.zzg;
            int i2 = zzl2.zzt;
            MediationNativeAdConfiguration mediationNativeAdConfiguration = r7;
            MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw, zzv, zzx, location, i, i2, zzy(str2, zzl), this.zze, zzbhk);
            rtbAdapter.loadRtbNativeAdMapper(mediationNativeAdConfiguration, zzbtm);
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render native ad.", th);
            zzbrc.zza(iObjectWrapper2, th, "adapter.loadRtbNativeAd");
            throw new RemoteException();
        }
    }

    public final void zzq(String str) {
        this.zze = str;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationAppOpenAd mediationAppOpenAd = this.zzd;
        if (mediationAppOpenAd == null) {
            return false;
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzm.zzh("", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.showRtbAppOpenAd");
            return true;
        }
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzm.zzh("", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.showRtbInterstitialAd");
            return true;
        }
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzm.zzh("", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.showRtbRewardedAd");
            return true;
        }
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsp zzbsp, zzbrl zzbrl) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbto(this, zzbsp, zzbrl));
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render app open ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsv zzbsv, zzbrl zzbrl) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbtl(this, zzbsv, zzbrl));
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render interstitial ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbtq(this, zzbtb, zzbrl));
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render rewarded interstitial ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbtb zzbtb, zzbrl zzbrl) throws RemoteException {
        zzl zzl2 = zzl;
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzl2), zzx(zzl), zzl2.zzk, zzl2.zzg, zzl2.zzt, zzy(str2, zzl), this.zze), new zzbtq(this, zzbtb, zzbrl));
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render rewarded ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbtj zzbtj = new zzbtj(this, zzbss, zzbrl);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzw = zzw(str2);
            Bundle zzv = zzv(zzl2);
            boolean zzx = zzx(zzl);
            Location location = zzl2.zzk;
            int i = zzl2.zzg;
            int i2 = zzl2.zzt;
            String zzy = zzy(str2, zzl);
            AdSize zzc2 = zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zze;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw, zzv, zzx, location, i, i2, zzy, zzc2, str3);
            rtbAdapter.loadRtbBannerAd(mediationBannerAdConfiguration, zzbtj);
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render banner ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbss zzbss, zzbrl zzbrl, zzq zzq) throws RemoteException {
        zzl zzl2 = zzl;
        zzq zzq2 = zzq;
        try {
            zzbtk zzbtk = new zzbtk(this, zzbss, zzbrl);
            RtbAdapter rtbAdapter = this.zza;
            Bundle zzw = zzw(str2);
            Bundle zzv = zzv(zzl2);
            boolean zzx = zzx(zzl);
            Location location = zzl2.zzk;
            int i = zzl2.zzg;
            int i2 = zzl2.zzt;
            String zzy = zzy(str2, zzl);
            AdSize zzc2 = zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            String str3 = this.zze;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw, zzv, zzx, location, i, i2, zzy, zzc2, str3);
            rtbAdapter.loadRtbInterscrollerAd(mediationBannerAdConfiguration, zzbtk);
        } catch (Throwable th) {
            zzm.zzh("Adapter failed to render interscroller ad.", th);
            zzbrc.zza(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }
}
