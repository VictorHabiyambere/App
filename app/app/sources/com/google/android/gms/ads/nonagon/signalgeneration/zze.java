package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zze {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdvh zzd;
    private final ExecutorService zze;

    zze(Context context, zzdvh zzdvh, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdvh;
        this.zze = executorService;
    }

    private final void zzh(boolean z) {
        Map map = this.zzb;
        Boolean valueOf = Boolean.valueOf(z);
        if (!map.containsKey(valueOf)) {
            this.zzb.put(valueOf, new ArrayList());
            this.zze.submit(new zzc(this, z));
        }
    }

    private final void zzi(zzg zzg, Pair pair, boolean z) {
        zzg.zzd();
        QueryInfo zzb2 = zzg.zzb();
        if (zzb2 != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(zzb2);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzg.zzc());
        }
        zzdvh zzdvh = this.zzd;
        Pair[] pairArr = new Pair[7];
        boolean z2 = false;
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzu.zzB().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        if (zzg.zzb() != null) {
            z2 = true;
        }
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(z2));
        zzp.zzd(zzdvh, (zzdux) null, "sgpcr", pairArr);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007d A[SYNTHETIC, Splitter:B:17:0x007d] */
    /* renamed from: zzj */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzd(boolean r8, boolean r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x0086 }
            r0.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "query_info_type"
            java.lang.String r2 = "requester_type_6"
            r0.putString(r1, r2)     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "accept_3p_cookie"
            r0.putBoolean(r1, r8)     // Catch:{ all -> 0x0086 }
            java.util.Map r1 = r7.zza     // Catch:{ all -> 0x0086 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0086 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzg r1 = (com.google.android.gms.ads.nonagon.signalgeneration.zzg) r1     // Catch:{ all -> 0x0086 }
            r3 = 0
            if (r9 == 0) goto L_0x002c
            if (r1 != 0) goto L_0x0025
            r4 = r3
            goto L_0x002e
        L_0x0025:
            int r9 = r1.zza()     // Catch:{ all -> 0x0086 }
            int r3 = r9 + 1
            goto L_0x002d
        L_0x002c:
        L_0x002d:
            r4 = r3
        L_0x002e:
            java.util.Map r9 = r7.zza     // Catch:{ all -> 0x0086 }
            java.lang.Object r9 = r9.get(r2)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzg r9 = (com.google.android.gms.ads.nonagon.signalgeneration.zzg) r9     // Catch:{ all -> 0x0086 }
            if (r9 != 0) goto L_0x003b
            r9 = 0
            r5 = r9
            goto L_0x0044
        L_0x003b:
            boolean r9 = r9.zzf()     // Catch:{ all -> 0x0086 }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x0086 }
            r5 = r9
        L_0x0044:
            com.google.android.gms.internal.ads.zzdvh r6 = r7.zzd     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzf r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzf     // Catch:{ all -> 0x0086 }
            r1 = r9
            r2 = r7
            r3 = r8
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.AdRequest$Builder r8 = new com.google.android.gms.ads.AdRequest$Builder     // Catch:{ all -> 0x0086 }
            r8.<init>()     // Catch:{ all -> 0x0086 }
            java.lang.Class<com.google.ads.mediation.admob.AdMobAdapter> r1 = com.google.ads.mediation.admob.AdMobAdapter.class
            com.google.android.gms.ads.AbstractAdRequestBuilder r8 = r8.addNetworkExtrasBundle(r1, r0)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.AdRequest$Builder r8 = (com.google.android.gms.ads.AdRequest.Builder) r8     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.AdRequest r8 = r8.build()     // Catch:{ all -> 0x0086 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlb     // Catch:{ all -> 0x0086 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0086 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0086 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x007d
            java.util.concurrent.ExecutorService r0 = r7.zze     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.nonagon.signalgeneration.zzd r1 = new com.google.android.gms.ads.nonagon.signalgeneration.zzd     // Catch:{ all -> 0x0086 }
            r1.<init>(r7, r8, r9)     // Catch:{ all -> 0x0086 }
            r0.submit(r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r7)
            return
        L_0x007d:
            android.content.Context r0 = r7.zzc     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.AdFormat r1 = com.google.android.gms.ads.AdFormat.BANNER     // Catch:{ all -> 0x0086 }
            com.google.android.gms.ads.query.QueryInfo.generate(r0, r1, r8, r9)     // Catch:{ all -> 0x0086 }
            monitor-exit(r7)
            return
        L_0x0086:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zze.zzd(boolean, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(AdRequest adRequest, zzf zzf) throws Exception {
        QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequest, zzf);
        return true;
    }

    public final synchronized void zzb() {
        zzh(true);
        zzh(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z) {
        zzd(z, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj, Pair pair) {
        CookieManager zza2;
        boolean z = false;
        if ((obj instanceof WebView) && (zza2 = zzu.zzq().zza(this.zzc)) != null) {
            z = zza2.acceptThirdPartyCookies((WebView) obj);
        }
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzg zzg = (zzg) map.get(valueOf);
        if (zzg == null || zzg.zze()) {
            List list = (List) this.zzb.get(valueOf);
            if (list == null) {
                list = new ArrayList();
                this.zzb.put(valueOf, list);
            }
            list.add(pair);
            return;
        }
        zzi(zzg, pair, true);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzf(boolean z, zzg zzg) {
        Integer num;
        boolean z2;
        Map map = this.zza;
        Boolean valueOf = Boolean.valueOf(z);
        zzg zzg2 = (zzg) map.get(valueOf);
        if (zzg2 == null || zzg2.zze() || zzg2.zzb() == null || zzg.zzb() != null) {
            this.zza.put(valueOf, zzg);
        }
        if (zzg.zzb() != null) {
            num = (Integer) zzba.zzc().zza(zzbep.zzjS);
        } else {
            num = (Integer) zzba.zzc().zza(zzbep.zzjT);
        }
        int intValue = num.intValue();
        if (zzg.zzb() == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzcci.zzd.schedule(new zzb(this, z, z2), (long) intValue, TimeUnit.SECONDS);
        List<Pair> list = (List) this.zzb.get(valueOf);
        this.zzb.put(valueOf, new ArrayList());
        if (list != null) {
            for (Pair zzi : list) {
                zzi(zzg, zzi, false);
            }
        }
    }

    public final synchronized void zzg(Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzcci.zze.execute(new zza(this, obj, new Pair(queryInfoGenerationCallback, Long.valueOf(zzu.zzB().currentTimeMillis()))));
    }
}
