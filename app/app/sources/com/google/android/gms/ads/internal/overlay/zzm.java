package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbuj;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzbvf;
import com.google.android.gms.internal.ads.zzchd;
import com.google.android.gms.internal.ads.zzegl;
import com.google.android.gms.internal.ads.zzegm;
import com.google.android.gms.internal.ads.zzehe;
import com.google.android.gms.internal.ads.zzehg;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzm extends zzbvf implements zzae {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzchd zzd;
    zzi zze;
    zzs zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzh zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;
    private Toolbar zzw;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    private final void zzJ(View view) {
        zzehg zzQ;
        zzehe zzP;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() || (zzP = this.zzd.zzP()) == null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzfb)).booleanValue() && (zzQ = this.zzd.zzQ()) != null && zzQ.zzb()) {
                zzu.zzA().zzg(zzQ.zza(), view);
                return;
            }
            return;
        }
        zzP.zza(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzaG)).booleanValue() != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzaF)).booleanValue() != false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.zzo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzK(android.content.res.Configuration r6) {
        /*
            r5 = this;
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r5.zzc
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.zzk r0 = r0.zzo
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            android.app.Activity r3 = r5.zzb
            com.google.android.gms.ads.internal.util.zzab r4 = com.google.android.gms.ads.internal.zzu.zzq()
            boolean r6 = r4.zzd(r3, r6)
            boolean r3 = r5.zzk
            if (r3 == 0) goto L_0x0033
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzaG
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0048
        L_0x0033:
            if (r6 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzbeg r6 = com.google.android.gms.internal.ads.zzbep.zzaF
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r0.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r1 = r2
            goto L_0x0059
        L_0x004a:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r5.zzc
            if (r6 == 0) goto L_0x0058
            com.google.android.gms.ads.internal.zzk r6 = r6.zzo
            if (r6 == 0) goto L_0x0058
            boolean r6 = r6.zzg
            if (r6 == 0) goto L_0x0058
            r2 = r1
            goto L_0x0059
        L_0x0058:
        L_0x0059:
            android.app.Activity r6 = r5.zzb
            android.view.Window r6 = r6.getWindow()
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzbf
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r3.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0085
            android.view.View r6 = r6.getDecorView()
            if (r1 == 0) goto L_0x007f
            if (r2 == 0) goto L_0x007c
            r0 = 5894(0x1706, float:8.259E-42)
            goto L_0x0081
        L_0x007c:
            r0 = 5380(0x1504, float:7.539E-42)
            goto L_0x0081
        L_0x007f:
            r0 = 256(0x100, float:3.59E-43)
        L_0x0081:
            r6.setSystemUiVisibility(r0)
            return
        L_0x0085:
            r0 = 1024(0x400, float:1.435E-42)
            r3 = 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x009d
            r6.addFlags(r0)
            r6.clearFlags(r3)
            if (r2 == 0) goto L_0x009c
            android.view.View r6 = r6.getDecorView()
            r0 = 4098(0x1002, float:5.743E-42)
            r6.setSystemUiVisibility(r0)
        L_0x009c:
            return
        L_0x009d:
            r6.addFlags(r3)
            r6.clearFlags(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzK(android.content.res.Configuration):void");
    }

    private static final void zzL(zzehg zzehg, View view) {
        if (zzehg != null && view != null) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzfb)).booleanValue() || !zzehg.zzb()) {
                zzu.zzA().zzj(zzehg.zza(), view);
            }
        }
    }

    public final void zzA(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zza(zzbep.zzgh)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zza(zzbep.zzgi)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zza(zzbep.zzgj)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzba.zzc().zza(zzbep.zzgk)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzu.zzo().zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzh = new FrameLayout(this.zzb);
        this.zzh.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0282  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8 A[SYNTHETIC, Splitter:B:38:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0273  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzD(boolean r27) throws com.google.android.gms.ads.internal.overlay.zzg {
        /*
            r26 = this;
            r1 = r26
            boolean r0 = r1.zzs
            r2 = 1
            if (r0 != 0) goto L_0x000c
            android.app.Activity r0 = r1.zzb
            r0.requestWindowFeature(r2)
        L_0x000c:
            android.app.Activity r0 = r1.zzb
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x02b1
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzc
            com.google.android.gms.internal.ads.zzchd r3 = r3.zzd
            r4 = 0
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzciv r3 = r3.zzN()
            goto L_0x0021
        L_0x0020:
            r3 = r4
        L_0x0021:
            r5 = 0
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.zzP()
            if (r3 == 0) goto L_0x002c
            r3 = r2
            goto L_0x002d
        L_0x002c:
            r3 = r5
        L_0x002d:
            r1.zzm = r5
            if (r3 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzc
            int r6 = r6.zzj
            r7 = 6
            if (r6 != r7) goto L_0x004c
            android.app.Activity r6 = r1.zzb
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 != r2) goto L_0x0048
            r6 = r2
            goto L_0x0049
        L_0x0048:
            r6 = r5
        L_0x0049:
            r1.zzm = r6
            goto L_0x0065
        L_0x004c:
            r7 = 7
            if (r6 != r7) goto L_0x0064
            android.app.Activity r6 = r1.zzb
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 != r7) goto L_0x0060
            r6 = r2
            goto L_0x0061
        L_0x0060:
            r6 = r5
        L_0x0061:
            r1.zzm = r6
            goto L_0x0065
        L_0x0064:
            r6 = r5
        L_0x0065:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Delay onShow to next orientation change: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zze(r6)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzc
            int r6 = r6.zzj
            r1.zzA(r6)
            r6 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r6, r6)
            java.lang.String r0 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)
            boolean r0 = r1.zzk
            if (r0 != 0) goto L_0x0096
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            r6 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setBackgroundColor(r6)
            goto L_0x009d
        L_0x0096:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            int r6 = zza
            r0.setBackgroundColor(r6)
        L_0x009d:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.ads.internal.overlay.zzh r6 = r1.zzl
            r0.setContentView(r6)
            r1.zzs = r2
            if (r27 == 0) goto L_0x0175
            com.google.android.gms.ads.internal.zzu.zzz()     // Catch:{ Exception -> 0x0167 }
            android.app.Activity r6 = r1.zzb     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzcix r0 = r0.zzO()     // Catch:{ Exception -> 0x0167 }
            r7 = r0
            goto L_0x00ba
        L_0x00b9:
            r7 = r4
        L_0x00ba:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00c6
            java.lang.String r0 = r0.zzU()     // Catch:{ Exception -> 0x0167 }
            r8 = r0
            goto L_0x00c7
        L_0x00c6:
            r8 = r4
        L_0x00c7:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r0.zzm     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd     // Catch:{ Exception -> 0x0167 }
            if (r0 == 0) goto L_0x00d6
            com.google.android.gms.ads.internal.zza r0 = r0.zzj()     // Catch:{ Exception -> 0x0167 }
            r16 = r0
            goto L_0x00d8
        L_0x00d6:
            r16 = r4
        L_0x00d8:
            com.google.android.gms.internal.ads.zzbdm r17 = com.google.android.gms.internal.ads.zzbdm.zza()     // Catch:{ Exception -> 0x0167 }
            r9 = 1
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r10 = r3
            com.google.android.gms.internal.ads.zzchd r0 = com.google.android.gms.internal.ads.zzchq.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0167 }
            r1.zzd = r0     // Catch:{ Exception -> 0x0167 }
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            com.google.android.gms.internal.ads.zzciv r6 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzbkf r8 = r0.zzp
            com.google.android.gms.internal.ads.zzbkh r10 = r0.zze
            com.google.android.gms.ads.internal.overlay.zzaa r11 = r0.zzi
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd
            if (r0 == 0) goto L_0x010d
            com.google.android.gms.internal.ads.zzciv r0 = r0.zzN()
            com.google.android.gms.ads.internal.zzb r4 = r0.zzd()
            r14 = r4
            goto L_0x010e
        L_0x010d:
            r14 = r4
        L_0x010e:
            r7 = 0
            r9 = 0
            r12 = 1
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r6.zzR(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            com.google.android.gms.internal.ads.zzciv r0 = r0.zzN()
            com.google.android.gms.ads.internal.overlay.zze r4 = new com.google.android.gms.ads.internal.overlay.zze
            r4.<init>(r1)
            r0.zzB(r4)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r4 = r0.zzl
            if (r4 == 0) goto L_0x0145
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            r0.loadUrl(r4)
            goto L_0x0155
        L_0x0145:
            java.lang.String r8 = r0.zzh
            if (r8 == 0) goto L_0x015f
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzd
            java.lang.String r7 = r0.zzf
            java.lang.String r10 = "UTF-8"
            r11 = 0
            java.lang.String r9 = "text/html"
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
        L_0x0155:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd
            if (r0 == 0) goto L_0x0182
            r0.zzaw(r1)
            goto L_0x0182
        L_0x015f:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r0.<init>(r2)
            throw r0
        L_0x0167:
            r0 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = "Could not obtain webview for the overlay."
            r2.<init>(r3, r0)
            throw r2
        L_0x0175:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd
            r1.zzd = r0
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            android.app.Activity r4 = r1.zzb
            r0.zzan(r4)
        L_0x0182:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            if (r0 == 0) goto L_0x0195
            android.webkit.CookieManager r0 = android.webkit.CookieManager.getInstance()
            com.google.android.gms.internal.ads.zzchd r4 = r1.zzd
            android.webkit.WebView r4 = r4.zzG()
            r0.setAcceptThirdPartyCookies(r4, r5)
        L_0x0195:
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            r0.zzai(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzd
            if (r0 == 0) goto L_0x01a9
            com.google.android.gms.internal.ads.zzehg r0 = r0.zzQ()
            com.google.android.gms.ads.internal.overlay.zzh r4 = r1.zzl
            zzL(r0, r4)
        L_0x01a9:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            r4 = 5
            if (r0 == r4) goto L_0x0264
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01c7
            boolean r6 = r0 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x01c7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzd
            android.view.View r6 = r6.zzF()
            r0.removeView(r6)
        L_0x01c7:
            boolean r0 = r1.zzk
            if (r0 == 0) goto L_0x01d0
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            r0.zzam()
        L_0x01d0:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            boolean r0 = r0.zzw
            r6 = -1
            if (r0 == 0) goto L_0x0259
            android.app.Activity r0 = r1.zzb
            android.widget.Toolbar r7 = new android.widget.Toolbar
            r7.<init>(r0)
            r1.zzw = r7
            android.widget.Toolbar r0 = r1.zzw
            int r7 = android.view.View.generateViewId()
            r0.setId(r7)
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            android.view.View r0 = r0.zzF()
            int r7 = android.view.View.generateViewId()
            r0.setId(r7)
            android.widget.Toolbar r0 = r1.zzw
            r7 = -12303292(0xffffffffff444444, float:-2.6088314E38)
            r0.setBackgroundColor(r7)
            android.widget.Toolbar r0 = r1.zzw
            r0.setVisibility(r5)
            com.google.android.gms.internal.ads.zzcby r0 = com.google.android.gms.ads.internal.zzu.zzo()
            android.content.res.Resources r0 = r0.zze()
            int r7 = com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_cross
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r7)
            android.widget.Toolbar r7 = r1.zzw
            r7.setNavigationIcon(r0)
            android.widget.Toolbar r0 = r1.zzw
            android.view.View$OnClickListener r7 = r1.zzp
            r0.setNavigationOnClickListener(r7)
            android.widget.Toolbar r0 = r1.zzw
            r0.setTitleMarginStart(r5)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r0.<init>(r6, r5)
            r7 = 10
            r0.addRule(r7)
            com.google.android.gms.ads.internal.overlay.zzh r7 = r1.zzl
            android.widget.Toolbar r8 = r1.zzw
            r7.addView(r8, r0)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r0.<init>(r6, r5)
            android.widget.Toolbar r5 = r1.zzw
            int r5 = r5.getId()
            r6 = 3
            r0.addRule(r6, r5)
            r5 = 12
            r0.addRule(r5)
            com.google.android.gms.ads.internal.overlay.zzh r5 = r1.zzl
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzd
            android.view.View r6 = r6.zzF()
            r5.addView(r6, r0)
            android.widget.Toolbar r0 = r1.zzw
            r1.zzJ(r0)
            goto L_0x0264
        L_0x0259:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzl
            com.google.android.gms.internal.ads.zzchd r5 = r1.zzd
            android.view.View r5 = r5.zzF()
            r0.addView(r5, r6, r6)
        L_0x0264:
            if (r27 != 0) goto L_0x026d
            boolean r0 = r1.zzm
            if (r0 != 0) goto L_0x026d
            r26.zze()
        L_0x026d:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            int r0 = r0.zzk
            if (r0 == r4) goto L_0x0282
            r1.zzw(r3)
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzd
            boolean r0 = r0.zzaB()
            if (r0 == 0) goto L_0x0281
            r1.zzy(r3, r2)
        L_0x0281:
            return
        L_0x0282:
            android.app.Activity r0 = r1.zzb
            com.google.android.gms.internal.ads.zzegl r2 = com.google.android.gms.internal.ads.zzegm.zze()
            r2.zza(r0)
            r2.zzb(r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzq
            r2.zzc(r0)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzc
            java.lang.String r0 = r0.zzr
            r2.zzd(r0)
            com.google.android.gms.internal.ads.zzegm r0 = r2.zze()
            r1.zzf(r0)     // Catch:{ zzg -> 0x02a6, RemoteException -> 0x02a4 }
            return
        L_0x02a4:
            r0 = move-exception
            goto L_0x02a7
        L_0x02a6:
            r0 = move-exception
        L_0x02a7:
            com.google.android.gms.ads.internal.overlay.zzg r2 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r3 = r0.getMessage()
            r2.<init>(r3, r0)
            throw r2
        L_0x02b1:
            com.google.android.gms.ads.internal.overlay.zzg r0 = new com.google.android.gms.ads.internal.overlay.zzg
            java.lang.String r2 = "Invalid activity, no window available."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzD(boolean):void");
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzr = true;
            if (this.zzq != null) {
                zzt.zza.removeCallbacks(this.zzq);
                zzt.zza.post(this.zzq);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzp zzp2;
        if (this.zzb.isFinishing() && !this.zzt) {
            this.zzt = true;
            zzchd zzchd = this.zzd;
            if (zzchd != null) {
                zzchd.zzZ(this.zzn - 1);
                synchronized (this.zzo) {
                    if (!this.zzr && this.zzd.zzaC()) {
                        if (((Boolean) zzba.zzc().zza(zzbep.zzeN)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzp2 = adOverlayInfoParcel.zzc) != null) {
                            zzp2.zzdq();
                        }
                        this.zzq = new zzd(this);
                        zzt.zza.postDelayed(this.zzq, ((Long) zzba.zzc().zza(zzbep.zzaY)).longValue());
                        return;
                    }
                }
            }
            zzc();
        }
    }

    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue() || !this.zzd.canGoBack()) {
            boolean zzaH = this.zzd.zzaH();
            if (!zzaH) {
                this.zzd.zzd("onbackblocked", Collections.emptyMap());
            }
            return zzaH;
        }
        this.zzd.goBack();
        return false;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzk == 5) {
            this.zzb.overridePendingTransition(0, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        zzchd zzchd;
        zzp zzp2;
        if (!this.zzu) {
            this.zzu = true;
            zzchd zzchd2 = this.zzd;
            if (zzchd2 != null) {
                this.zzl.removeView(zzchd2.zzF());
                zzi zzi2 = this.zze;
                if (zzi2 != null) {
                    this.zzd.zzan(zzi2.zzd);
                    this.zzd.zzaq(false);
                    if (((Boolean) zzba.zzc().zza(zzbep.zzmE)).booleanValue() && this.zzd.getParent() != null) {
                        ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzF());
                    }
                    ViewGroup viewGroup = this.zze.zzc;
                    View zzF = this.zzd.zzF();
                    zzi zzi3 = this.zze;
                    viewGroup.addView(zzF, zzi3.zza, zzi3.zzb);
                    this.zze = null;
                } else if (this.zzb.getApplicationContext() != null) {
                    this.zzd.zzan(this.zzb.getApplicationContext());
                }
                this.zzd = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
                zzp2.zzdu(this.zzn);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
            if (adOverlayInfoParcel2 != null && (zzchd = adOverlayInfoParcel2.zzd) != null) {
                zzL(zzchd.zzQ(), this.zzc.zzd.zzF());
            }
        }
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    /* access modifiers changed from: protected */
    public final void zze() {
        this.zzd.zzaa();
    }

    public final void zzf(zzegm zzegm) throws zzg, RemoteException {
        zzbuz zzbuz;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbuz = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbuz.zzg(ObjectWrapper.wrap(zzegm));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzh(int i, int i2, Intent intent) {
    }

    public final void zzi() {
        this.zzn = 1;
    }

    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzK((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0094 A[Catch:{ zzg -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ea A[Catch:{ zzg -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ed A[Catch:{ zzg -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2 A[Catch:{ zzg -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f7 A[Catch:{ zzg -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104 A[Catch:{ zzg -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzl(android.os.Bundle r8) {
        /*
            r7 = this;
            boolean r0 = r7.zzs
            r1 = 1
            if (r0 != 0) goto L_0x000a
            android.app.Activity r0 = r7.zzb
            r0.requestWindowFeature(r1)
        L_0x000a:
            r0 = 0
            if (r8 == 0) goto L_0x0017
            java.lang.String r2 = "com.google.android.gms.ads.internal.overlay.hasResumed"
            boolean r2 = r8.getBoolean(r2, r0)
            if (r2 == 0) goto L_0x0017
            r2 = r1
            goto L_0x0018
        L_0x0017:
            r2 = r0
        L_0x0018:
            r7.zzj = r2
            r2 = 4
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel.zza(r3)     // Catch:{ zzg -> 0x0117 }
            r7.zzc = r3     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            if (r3 == 0) goto L_0x010f
            boolean r3 = r3.zzw     // Catch:{ zzg -> 0x0117 }
            if (r3 == 0) goto L_0x0046
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ zzg -> 0x0117 }
            r4 = 28
            if (r3 < r4) goto L_0x003b
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            r3.setShowWhenLocked(r1)     // Catch:{ zzg -> 0x0117 }
            goto L_0x0046
        L_0x003b:
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            android.view.Window r3 = r3.getWindow()     // Catch:{ zzg -> 0x0117 }
            r4 = 524288(0x80000, float:7.34684E-40)
            r3.addFlags(r4)     // Catch:{ zzg -> 0x0117 }
        L_0x0046:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r3.zzm     // Catch:{ zzg -> 0x0117 }
            int r3 = r3.clientJarVersion     // Catch:{ zzg -> 0x0117 }
            r4 = 7500000(0x7270e0, float:1.0509738E-38)
            if (r3 <= r4) goto L_0x0053
            r7.zzn = r2     // Catch:{ zzg -> 0x0117 }
        L_0x0053:
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0117 }
            if (r3 == 0) goto L_0x0069
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            android.content.Intent r3 = r3.getIntent()     // Catch:{ zzg -> 0x0117 }
            java.lang.String r4 = "shouldCallOnOverlayOpened"
            boolean r3 = r3.getBooleanExtra(r4, r1)     // Catch:{ zzg -> 0x0117 }
            r7.zzv = r3     // Catch:{ zzg -> 0x0117 }
        L_0x0069:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.zzk r4 = r3.zzo     // Catch:{ zzg -> 0x0117 }
            r5 = 5
            if (r4 == 0) goto L_0x0077
            boolean r6 = r4.zza     // Catch:{ zzg -> 0x0117 }
            r7.zzk = r6     // Catch:{ zzg -> 0x0117 }
            if (r6 == 0) goto L_0x0092
            goto L_0x007d
        L_0x0077:
            int r6 = r3.zzk     // Catch:{ zzg -> 0x0117 }
            if (r6 != r5) goto L_0x0090
            r7.zzk = r1     // Catch:{ zzg -> 0x0117 }
        L_0x007d:
            int r3 = r3.zzk     // Catch:{ zzg -> 0x0117 }
            if (r3 == r5) goto L_0x0092
            int r3 = r4.zzf     // Catch:{ zzg -> 0x0117 }
            r4 = -1
            if (r3 == r4) goto L_0x0092
            com.google.android.gms.ads.internal.overlay.zzl r3 = new com.google.android.gms.ads.internal.overlay.zzl     // Catch:{ zzg -> 0x0117 }
            r4 = 0
            r3.<init>(r7, r4)     // Catch:{ zzg -> 0x0117 }
            r3.zzb()     // Catch:{ zzg -> 0x0117 }
            goto L_0x0092
        L_0x0090:
            r7.zzk = r0     // Catch:{ zzg -> 0x0117 }
        L_0x0092:
            if (r8 != 0) goto L_0x00c0
            boolean r8 = r7.zzv     // Catch:{ zzg -> 0x0117 }
            if (r8 == 0) goto L_0x00aa
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.internal.ads.zzczy r8 = r8.zzt     // Catch:{ zzg -> 0x0117 }
            if (r8 == 0) goto L_0x00a1
            r8.zze()     // Catch:{ zzg -> 0x0117 }
        L_0x00a1:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.zzp r8 = r8.zzc     // Catch:{ zzg -> 0x0117 }
            if (r8 == 0) goto L_0x00aa
            r8.zzdr()     // Catch:{ zzg -> 0x0117 }
        L_0x00aa:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            int r3 = r8.zzk     // Catch:{ zzg -> 0x0117 }
            if (r3 == r1) goto L_0x00c0
            com.google.android.gms.ads.internal.client.zza r8 = r8.zzb     // Catch:{ zzg -> 0x0117 }
            if (r8 == 0) goto L_0x00b7
            r8.onAdClicked()     // Catch:{ zzg -> 0x0117 }
        L_0x00b7:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.internal.ads.zzdhi r8 = r8.zzu     // Catch:{ zzg -> 0x0117 }
            if (r8 == 0) goto L_0x00c0
            r8.zzdG()     // Catch:{ zzg -> 0x0117 }
        L_0x00c0:
            com.google.android.gms.ads.internal.overlay.zzh r8 = new com.google.android.gms.ads.internal.overlay.zzh     // Catch:{ zzg -> 0x0117 }
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r4 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            java.lang.String r5 = r4.zzn     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r6 = r4.zzm     // Catch:{ zzg -> 0x0117 }
            java.lang.String r6 = r6.afmaVersion     // Catch:{ zzg -> 0x0117 }
            java.lang.String r4 = r4.zzs     // Catch:{ zzg -> 0x0117 }
            r8.<init>(r3, r5, r6, r4)     // Catch:{ zzg -> 0x0117 }
            r7.zzl = r8     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.zzh r8 = r7.zzl     // Catch:{ zzg -> 0x0117 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r8.setId(r3)     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.util.zzab r8 = com.google.android.gms.ads.internal.zzu.zzq()     // Catch:{ zzg -> 0x0117 }
            android.app.Activity r3 = r7.zzb     // Catch:{ zzg -> 0x0117 }
            r8.zzk(r3)     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r8 = r7.zzc     // Catch:{ zzg -> 0x0117 }
            int r3 = r8.zzk     // Catch:{ zzg -> 0x0117 }
            switch(r3) {
                case 1: goto L_0x0104;
                case 2: goto L_0x00f7;
                case 3: goto L_0x00f2;
                case 4: goto L_0x00ea;
                case 5: goto L_0x00ed;
                default: goto L_0x00ea;
            }     // Catch:{ zzg -> 0x0117 }
        L_0x00ea:
            com.google.android.gms.ads.internal.overlay.zzg r8 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0117 }
            goto L_0x0109
        L_0x00ed:
            r7.zzD(r0)     // Catch:{ zzg -> 0x0117 }
            return
        L_0x00f2:
            r7.zzD(r1)     // Catch:{ zzg -> 0x0117 }
            return
        L_0x00f7:
            com.google.android.gms.ads.internal.overlay.zzi r1 = new com.google.android.gms.ads.internal.overlay.zzi     // Catch:{ zzg -> 0x0117 }
            com.google.android.gms.internal.ads.zzchd r8 = r8.zzd     // Catch:{ zzg -> 0x0117 }
            r1.<init>(r8)     // Catch:{ zzg -> 0x0117 }
            r7.zze = r1     // Catch:{ zzg -> 0x0117 }
            r7.zzD(r0)     // Catch:{ zzg -> 0x0117 }
            return
        L_0x0104:
            r7.zzD(r0)     // Catch:{ zzg -> 0x0117 }
            return
        L_0x0109:
            java.lang.String r0 = "Could not determine ad overlay type."
            r8.<init>(r0)     // Catch:{ zzg -> 0x0117 }
            throw r8     // Catch:{ zzg -> 0x0117 }
        L_0x010f:
            com.google.android.gms.ads.internal.overlay.zzg r8 = new com.google.android.gms.ads.internal.overlay.zzg     // Catch:{ zzg -> 0x0117 }
            java.lang.String r0 = "Could not get info for ad overlay."
            r8.<init>(r0)     // Catch:{ zzg -> 0x0117 }
            throw r8     // Catch:{ zzg -> 0x0117 }
        L_0x0117:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r8)
            r7.zzn = r2
            android.app.Activity r8 = r7.zzb
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzm.zzl(android.os.Bundle):void");
    }

    public final void zzm() {
        zzchd zzchd = this.zzd;
        if (zzchd != null) {
            try {
                this.zzl.removeView(zzchd.zzF());
            } catch (NullPointerException e) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    public final void zzo() {
        zzp zzp2;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzdk();
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeP)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzp(int i, String[] strArr, int[] iArr) {
        zzm zzm2;
        if (i == 12345) {
            Activity activity = this.zzb;
            zzegl zze2 = zzegm.zze();
            zze2.zza(activity);
            if (this.zzc.zzk == 5) {
                zzm2 = this;
            } else {
                zzm2 = null;
            }
            zze2.zzb(zzm2);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zze2.zze()));
            } catch (RemoteException e) {
            }
        }
    }

    public final void zzq() {
    }

    public final void zzr() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (!(adOverlayInfoParcel == null || (zzp2 = adOverlayInfoParcel.zzc) == null)) {
            zzp2.zzdH();
        }
        zzK(this.zzb.getResources().getConfiguration());
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeP)).booleanValue()) {
            zzchd zzchd = this.zzd;
            if (zzchd == null || zzchd.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzt() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzeP)).booleanValue()) {
            zzchd zzchd = this.zzd;
            if (zzchd == null || zzchd.zzaE()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    public final void zzu() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzeP)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    public final void zzv() {
        zzp zzp2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzp2 = adOverlayInfoParcel.zzc) != null) {
            zzp2.zzdt();
        }
    }

    public final void zzw(boolean z) {
        int i;
        int i2;
        if (!this.zzc.zzw) {
            int intValue = ((Integer) zzba.zzc().zza(zzbep.zzeS)).intValue();
            int i3 = 0;
            boolean z2 = !((Boolean) zzba.zzc().zza(zzbep.zzbb)).booleanValue() ? z : true;
            zzr zzr2 = new zzr();
            zzr2.zzd = 50;
            if (true != z2) {
                i = 0;
            } else {
                i = intValue;
            }
            zzr2.zza = i;
            if (true != z2) {
                i3 = intValue;
            }
            zzr2.zzb = i3;
            zzr2.zzc = intValue;
            this.zzf = new zzs(this.zzb, zzr2, this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            if (true != z2) {
                i2 = 9;
            } else {
                i2 = 11;
            }
            layoutParams.addRule(i2);
            zzy(z, this.zzc.zzg);
            this.zzl.addView(this.zzf, layoutParams);
            zzJ(this.zzf);
        }
    }

    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzk zzk2;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        zzk zzk3;
        boolean z5 = true;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzaZ)).booleanValue() || (adOverlayInfoParcel2 = this.zzc) == null || (zzk3 = adOverlayInfoParcel2.zzo) == null || !zzk3.zzh) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzba)).booleanValue() || (adOverlayInfoParcel = this.zzc) == null || (zzk2 = adOverlayInfoParcel.zzo) == null || !zzk2.zzi) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z && z2 && z3 && !z4) {
            new zzbuj(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzs zzs2 = this.zzf;
        if (zzs2 != null) {
            if (!z4 && (!z2 || z3)) {
                z5 = false;
            }
            zzs2.zzb(z5);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
