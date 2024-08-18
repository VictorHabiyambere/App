package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbbm extends Thread {
    private boolean zza = false;
    private boolean zzb = false;
    private final Object zzc;
    private final zzbbd zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzbbm() {
        zzbbd zzbbd = new zzbbd();
        this.zzd = zzbbd;
        this.zzc = new Object();
        this.zzf = ((Long) zzbgb.zzd.zze()).intValue();
        this.zzg = ((Long) zzbgb.zza.zze()).intValue();
        this.zzh = ((Long) zzbgb.zze.zze()).intValue();
        this.zzi = ((Long) zzbgb.zzc.zze()).intValue();
        this.zzj = ((Integer) zzba.zzc().zza(zzbep.zzR)).intValue();
        this.zzk = ((Integer) zzba.zzc().zza(zzbep.zzS)).intValue();
        this.zzl = ((Integer) zzba.zzc().zza(zzbep.zzT)).intValue();
        this.zze = ((Long) zzbgb.zzf.zze()).intValue();
        this.zzm = (String) zzba.zzc().zza(zzbep.zzV);
        this.zzn = ((Boolean) zzba.zzc().zza(zzbep.zzW)).booleanValue();
        this.zzo = ((Boolean) zzba.zzc().zza(zzbep.zzX)).booleanValue();
        this.zzp = ((Boolean) zzba.zzc().zza(zzbep.zzY)).booleanValue();
        setName("ContentFetchTask");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public final void run() {
        /*
            r6 = this;
        L_0x0001:
            com.google.android.gms.internal.ads.zzbbh r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ all -> 0x00aa }
            android.content.Context r0 = r0.zzb()     // Catch:{ all -> 0x00aa }
            if (r0 != 0) goto L_0x000d
            goto L_0x00b4
        L_0x000d:
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch:{ all -> 0x00aa }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ all -> 0x00aa }
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x00b4
            if (r2 == 0) goto L_0x00b4
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00aa }
            if (r1 == 0) goto L_0x00b4
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00aa }
        L_0x002b:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x00b4
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00aa }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00aa }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x00aa }
            int r5 = r3.pid     // Catch:{ all -> 0x00aa }
            if (r4 != r5) goto L_0x002b
            int r1 = r3.importance     // Catch:{ all -> 0x00aa }
            r3 = 100
            if (r1 != r3) goto L_0x00b4
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x00b4
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00aa }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00b4
            com.google.android.gms.internal.ads.zzbbh r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            android.app.Activity r0 = r0.zza()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            if (r0 != 0) goto L_0x006e
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            goto L_0x00bc
        L_0x006e:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x008f
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x0090 }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x0090 }
            if (r2 == 0) goto L_0x008f
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x0090 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x0090 }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r2)     // Catch:{ Exception -> 0x0090 }
            goto L_0x009f
        L_0x008f:
            goto L_0x009f
        L_0x0090:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcby r2 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zzw(r0, r3)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
        L_0x009f:
            if (r1 == 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzbbi r0 = new com.google.android.gms.internal.ads.zzbbi     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            r0.<init>(r6, r1)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            goto L_0x00bc
        L_0x00aa:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcby r1 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            java.lang.String r2 = "ContentFetchTask.isInForeground"
            r1.zzw(r0, r2)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
        L_0x00b4:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
        L_0x00bc:
            int r0 = r6.zze     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d5, Exception -> 0x00c5 }
            goto L_0x00db
        L_0x00c5:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
            java.lang.String r1 = "ContentFetchTask.run"
            com.google.android.gms.internal.ads.zzcby r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
            goto L_0x00db
        L_0x00d5:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
        L_0x00db:
            java.lang.Object r0 = r6.zzc
            monitor-enter(r0)
        L_0x00de:
            boolean r1 = r6.zzb     // Catch:{ all -> 0x00f2 }
            if (r1 == 0) goto L_0x00ef
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r1)     // Catch:{ InterruptedException -> 0x00ed }
            java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x00ed }
            r1.wait()     // Catch:{ InterruptedException -> 0x00ed }
            goto L_0x00de
        L_0x00ed:
            r1 = move-exception
            goto L_0x00de
        L_0x00ef:
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            goto L_0x0001
        L_0x00f2:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00f2 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbm.run():void");
    }

    public final zzbbc zza() {
        return this.zzd.zza(this.zzp);
    }

    /* access modifiers changed from: package-private */
    public final zzbbl zzb(View view, zzbbc zzbbc) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzbbc.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                    return new zzbbl(this, 1, 0);
                }
            } else if ((view instanceof WebView) && !(view instanceof zzchd)) {
                WebView webView = (WebView) view;
                if (PlatformVersion.isAtLeastKitKat()) {
                    zzbbc.zzh();
                    webView.post(new zzbbk(this, zzbbc, webView, globalVisibleRect));
                    return new zzbbl(this, 0, 1);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    zzbbl zzb2 = zzb(viewGroup.getChildAt(i3), zzbbc);
                    i += zzb2.zza;
                    i2 += zzb2.zzb;
                }
                return new zzbbl(this, i, i2);
            }
        }
        return new zzbbl(this, 0, 0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r11 == 0) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(android.view.View r11) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzbbc r9 = new com.google.android.gms.internal.ads.zzbbc     // Catch:{ Exception -> 0x007e }
            int r1 = r10.zzf     // Catch:{ Exception -> 0x007e }
            int r2 = r10.zzg     // Catch:{ Exception -> 0x007e }
            int r3 = r10.zzh     // Catch:{ Exception -> 0x007e }
            int r4 = r10.zzi     // Catch:{ Exception -> 0x007e }
            int r5 = r10.zzj     // Catch:{ Exception -> 0x007e }
            int r6 = r10.zzk     // Catch:{ Exception -> 0x007e }
            int r7 = r10.zzl     // Catch:{ Exception -> 0x007e }
            boolean r8 = r10.zzo     // Catch:{ Exception -> 0x007e }
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzbbh r0 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ Exception -> 0x007e }
            android.content.Context r0 = r0.zzb()     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0052
            java.lang.String r1 = r10.zzm     // Catch:{ Exception -> 0x007e }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x007e }
            if (r1 != 0) goto L_0x0052
            android.content.res.Resources r1 = r0.getResources()     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzU     // Catch:{ Exception -> 0x007e }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x007e }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ Exception -> 0x007e }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = "id"
            java.lang.String r0 = r0.getPackageName()     // Catch:{ Exception -> 0x007e }
            int r0 = r1.getIdentifier(r2, r3, r0)     // Catch:{ Exception -> 0x007e }
            java.lang.Object r0 = r11.getTag(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0052
            java.lang.String r1 = r10.zzm     // Catch:{ Exception -> 0x007e }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0077
        L_0x0052:
            com.google.android.gms.internal.ads.zzbbl r11 = r10.zzb(r11, r9)     // Catch:{ Exception -> 0x007e }
            r9.zzm()     // Catch:{ Exception -> 0x007e }
            int r0 = r11.zza     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0061
            int r0 = r11.zzb     // Catch:{ Exception -> 0x007e }
            if (r0 == 0) goto L_0x0077
        L_0x0061:
            int r11 = r11.zzb     // Catch:{ Exception -> 0x007e }
            if (r11 != 0) goto L_0x006c
            int r11 = r9.zzc()     // Catch:{ Exception -> 0x007e }
            if (r11 == 0) goto L_0x0077
            goto L_0x006e
        L_0x006c:
            if (r11 != 0) goto L_0x0078
        L_0x006e:
            com.google.android.gms.internal.ads.zzbbd r11 = r10.zzd     // Catch:{ Exception -> 0x007e }
            boolean r11 = r11.zzd(r9)     // Catch:{ Exception -> 0x007e }
            if (r11 != 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            return
        L_0x0078:
            com.google.android.gms.internal.ads.zzbbd r11 = r10.zzd     // Catch:{ Exception -> 0x007e }
            r11.zzb(r9)     // Catch:{ Exception -> 0x007e }
            return
        L_0x007e:
            r11 = move-exception
            java.lang.String r0 = "Exception in fetchContentOnUIThread"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r11)
            com.google.android.gms.internal.ads.zzcby r0 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r1 = "ContentFetchTask.fetchContent"
            r0.zzw(r11, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbm.zzc(android.view.View):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzbbc zzbbc, WebView webView, String str, boolean z) {
        zzbbc.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzbbc.zzl(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    zzbbc.zzl(title + "\n" + optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzbbc.zzo()) {
                this.zzd.zzc(zzbbc);
            }
        } catch (JSONException e) {
            zzm.zze("Json string may be malformed.");
        } catch (Throwable th) {
            zzm.zzf("Failed to get webview content.", th);
            zzu.zzo().zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzm.zze("Content hash thread already started, quitting...");
                return;
            }
            this.zza = true;
            start();
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzm.zze("ContentFetchThread: paused, pause = " + true);
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzm.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
