package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzaxd;
import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzfhs;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzgge;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class TaggingLibraryJsInterface {
    private final Context zza;
    /* access modifiers changed from: private */
    public final WebView zzb;
    private final zzaxd zzc;
    private final zzfhs zzd;
    private final int zze;
    private final zzdvh zzf;
    private final boolean zzg;
    /* access modifiers changed from: private */
    public final zzgge zzh = zzcci.zze;
    private final zzfoe zzi;
    private final zze zzj;

    TaggingLibraryJsInterface(WebView webView, zzaxd zzaxd, zzdvh zzdvh, zzfoe zzfoe, zzfhs zzfhs, zze zze2) {
        this.zzb = webView;
        this.zza = webView.getContext();
        this.zzc = zzaxd;
        this.zzf = zzdvh;
        zzbep.zza(this.zza);
        this.zze = ((Integer) zzba.zzc().zza(zzbep.zzjC)).intValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbep.zzjD)).booleanValue();
        this.zzi = zzfoe;
        this.zzd = zzfhs;
        this.zzj = zze2;
    }

    @JavascriptInterface
    public String getClickSignals(String clickString) {
        try {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String zze2 = this.zzc.zzc().zze(this.zza, clickString, this.zzb);
            if (this.zzg) {
                long currentTimeMillis2 = zzu.zzB().currentTimeMillis() - currentTimeMillis;
                zzp.zzd(this.zzf, (zzdux) null, "csg", new Pair("clat", String.valueOf(currentTimeMillis2)));
            }
            return zze2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting click signals. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getClickSignalsWithTimeout(String clickString, int timeoutMs) {
        if (timeoutMs <= 0) {
            zzm.zzg("Invalid timeout for getting click signals. Timeout=" + timeoutMs);
            return "";
        }
        int min = Math.min(timeoutMs, this.zze);
        try {
            return (String) zzcci.zza.zzb(new zzba(this, clickString)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting click signals with timeout. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public String getQueryInfo() {
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        zzbe zzbe = new zzbe(this, uuid);
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            this.zzj.zzg(this.zzb, zzbe);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbep.zzjF)).booleanValue()) {
                this.zzh.execute(new zzbb(this, bundle, zzbe));
            } else {
                QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), zzbe);
            }
        }
        return uuid;
    }

    @JavascriptInterface
    public String getViewSignals() {
        try {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String zzh2 = this.zzc.zzc().zzh(this.zza, this.zzb, (Activity) null);
            if (this.zzg) {
                long currentTimeMillis2 = zzu.zzB().currentTimeMillis() - currentTimeMillis;
                zzp.zzd(this.zzf, (zzdux) null, "vsg", new Pair("vlat", String.valueOf(currentTimeMillis2)));
            }
            return zzh2;
        } catch (RuntimeException e) {
            zzm.zzh("Exception getting view signals. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    @JavascriptInterface
    public String getViewSignalsWithTimeout(int timeoutMs) {
        if (timeoutMs <= 0) {
            zzm.zzg("Invalid timeout for getting view signals. Timeout=" + timeoutMs);
            return "";
        }
        int min = Math.min(timeoutMs, this.zze);
        try {
            return (String) zzcci.zza.zzb(new zzay(this)).get((long) min, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzh("Exception getting view signals with timeout. ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            if (e instanceof TimeoutException) {
                return "17";
            }
            return "";
        }
    }

    @JavascriptInterface
    public void recordClick(String clickUrl) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzjH)).booleanValue() && !TextUtils.isEmpty(clickUrl)) {
            zzcci.zza.execute(new zzaz(this, clickUrl));
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 20 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r20.zzc.zzd(android.view.MotionEvent.obtain(0, (long) r3, r10, (float) r1, (float) r2, r13, 1.0f, 0, 1.0f, 1.0f, 0, 0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0033, code lost:
        r10 = r0;
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void reportTouchEvent(java.lang.String r21) {
        /*
            r20 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            r1 = r21
            r0.<init>(r1)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            java.lang.String r1 = "x"
            int r1 = r0.getInt(r1)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            java.lang.String r2 = "y"
            int r2 = r0.getInt(r2)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            java.lang.String r3 = "duration_ms"
            int r3 = r0.getInt(r3)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            java.lang.String r4 = "force"
            double r4 = r0.getDouble(r4)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            float r13 = (float) r4     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            java.lang.String r4 = "type"
            int r0 = r0.getInt(r4)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            switch(r0) {
                case 0: goto L_0x0032;
                case 1: goto L_0x0030;
                case 2: goto L_0x002e;
                case 3: goto L_0x002c;
                default: goto L_0x0029;
            }     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
        L_0x0029:
            r0 = -1
            r10 = r0
            goto L_0x0034
        L_0x002c:
            r0 = 3
            goto L_0x0033
        L_0x002e:
            r0 = 2
            goto L_0x0033
        L_0x0030:
            r0 = 1
            goto L_0x0033
        L_0x0032:
            r0 = 0
        L_0x0033:
            r10 = r0
        L_0x0034:
            long r8 = (long) r3     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            float r11 = (float) r1     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            float r12 = (float) r2     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            r6 = 0
            r14 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
            r16 = 1065353216(0x3f800000, float:1.0)
            r17 = 1065353216(0x3f800000, float:1.0)
            r18 = 0
            r19 = 0
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r6, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ RuntimeException -> 0x0056, JSONException -> 0x0054 }
            r1 = r20
            com.google.android.gms.internal.ads.zzaxd r2 = r1.zzc     // Catch:{ RuntimeException -> 0x0052, JSONException -> 0x0050 }
            r2.zzd(r0)     // Catch:{ RuntimeException -> 0x0052, JSONException -> 0x0050 }
            return
        L_0x0050:
            r0 = move-exception
            goto L_0x0059
        L_0x0052:
            r0 = move-exception
            goto L_0x0059
        L_0x0054:
            r0 = move-exception
            goto L_0x0057
        L_0x0056:
            r0 = move-exception
        L_0x0057:
            r1 = r20
        L_0x0059:
            java.lang.String r2 = "Failed to parse the touch string. "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            com.google.android.gms.internal.ads.zzcby r2 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r3 = "TaggingLibraryJsInterface.reportTouchEvent"
            r2.zzw(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface.reportTouchEvent(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        boolean z;
        CookieManager zza2 = zzu.zzq().zza(this.zza);
        if (zza2 != null) {
            z = zza2.acceptThirdPartyCookies(this.zzb);
        } else {
            z = false;
        }
        bundle.putBoolean("accept_3p_cookie", z);
        QueryInfo.generate(this.zza, AdFormat.BANNER, ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build(), queryInfoGenerationCallback);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str) {
        zzfhs zzfhs;
        Uri parse = Uri.parse(str);
        try {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzlW)).booleanValue() || (zzfhs = this.zzd) == null) {
                parse = this.zzc.zza(parse, this.zza, this.zzb, (Activity) null);
            } else {
                parse = zzfhs.zza(parse, this.zza, this.zzb, (Activity) null);
            }
        } catch (zzaxe e) {
            zzm.zzf("Failed to append the click signal to URL: ", e);
            zzu.zzo().zzw(e, "TaggingLibraryJsInterface.recordClick");
        }
        this.zzi.zzc(parse.toString(), (zzfmn) null);
    }
}
