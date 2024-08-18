package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbud extends zzbuj {
    static final Set zza = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private String zzb = "top-right";
    private boolean zzc = true;
    private int zzd = 0;
    private int zze = 0;
    private int zzf = -1;
    private int zzg = 0;
    private int zzh = 0;
    private int zzi = -1;
    private final Object zzj = new Object();
    private final zzchd zzk;
    private final Activity zzl;
    private zzcix zzm;
    private ImageView zzn;
    private LinearLayout zzo;
    private final zzbuk zzp;
    private PopupWindow zzq;
    private RelativeLayout zzr;
    private ViewGroup zzs;

    public zzbud(zzchd zzchd, zzbuk zzbuk) {
        super(zzchd, "resize");
        this.zzk = zzchd;
        this.zzl = zzchd.zzi();
        this.zzp = zzbuk;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzm */
    public final void zzc(boolean z) {
        this.zzq.dismiss();
        this.zzr.removeView((View) this.zzk);
        ViewGroup viewGroup = this.zzs;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzn);
            this.zzs.addView((View) this.zzk);
            this.zzk.zzaj(this.zzm);
        }
        if (z) {
            zzl("default");
            zzbuk zzbuk = this.zzp;
            if (zzbuk != null) {
                zzbuk.zzb();
            }
        }
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzo = null;
    }

    public final void zza(boolean z) {
        synchronized (this.zzj) {
            if (this.zzq != null) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzkP)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzc(z);
                } else {
                    zzcci.zze.zza(new zzbub(this, z));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01ed, code lost:
        if (r8 < r4[0]) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01f2, code lost:
        if ((r8 + 50) <= r4[1]) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f5, code lost:
        r15 = new int[]{r1.zzd + r1.zzg, r1.zze + r1.zzh};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01ae, code lost:
        r8 = ((r8 + r1.zzh) + r9) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01d9, code lost:
        r8 = r8 + r1.zzh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e6, code lost:
        if (r3 < 0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e9, code lost:
        if ((r3 + 50) > r6) goto L_0x024e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0250 A[Catch:{ RuntimeException -> 0x041c }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0257 A[Catch:{ RuntimeException -> 0x041c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.util.Map r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.Object r2 = r1.zzj
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzchd r3 = r1.zzk     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzcix r3 = r3.zzO()     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzchd r3 = r1.zzk     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzcix r3 = r3.zzO()     // Catch:{ all -> 0x046e }
            boolean r3 = r3.zzi()     // Catch:{ all -> 0x046e }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzchd r3 = r1.zzk     // Catch:{ all -> 0x046e }
            boolean r3 = r3.zzaF()     // Catch:{ all -> 0x046e }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x046e }
            int r3 = com.google.android.gms.ads.internal.util.zzt.zzO(r3)     // Catch:{ all -> 0x046e }
            r1.zzi = r3     // Catch:{ all -> 0x046e }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x046e }
            int r3 = com.google.android.gms.ads.internal.util.zzt.zzO(r3)     // Catch:{ all -> 0x046e }
            r1.zzf = r3     // Catch:{ all -> 0x046e }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x046e }
            int r3 = com.google.android.gms.ads.internal.util.zzt.zzO(r3)     // Catch:{ all -> 0x046e }
            r1.zzg = r3     // Catch:{ all -> 0x046e }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x046e }
            int r3 = com.google.android.gms.ads.internal.util.zzt.zzO(r3)     // Catch:{ all -> 0x046e }
            r1.zzh = r3     // Catch:{ all -> 0x046e }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x046e }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x046e }
            r1.zzc = r3     // Catch:{ all -> 0x046e }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x046e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x046e }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x00eb
            r1.zzb = r0     // Catch:{ all -> 0x046e }
        L_0x00eb:
            int r0 = r1.zzi     // Catch:{ all -> 0x046e }
            if (r0 < 0) goto L_0x0467
            int r0 = r1.zzf     // Catch:{ all -> 0x046e }
            if (r0 < 0) goto L_0x0467
            android.app.Activity r0 = r1.zzl     // Catch:{ all -> 0x046e }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x046e }
            if (r0 == 0) goto L_0x0460
            android.view.View r3 = r0.getDecorView()     // Catch:{ all -> 0x046e }
            if (r3 != 0) goto L_0x0103
            goto L_0x0460
        L_0x0103:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x046e }
            int[] r3 = com.google.android.gms.ads.internal.util.zzt.zzV(r3)     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x046e }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzR(r4)     // Catch:{ all -> 0x046e }
            r5 = 0
            r6 = r3[r5]     // Catch:{ all -> 0x046e }
            r7 = 1
            r3 = r3[r7]     // Catch:{ all -> 0x046e }
            int r8 = r1.zzi     // Catch:{ all -> 0x046e }
            r11 = 3
            r12 = 2
            r13 = -1
            r14 = 50
            r15 = 0
            if (r8 < r14) goto L_0x0249
            if (r8 <= r6) goto L_0x0129
            goto L_0x0249
        L_0x0129:
            int r9 = r1.zzf     // Catch:{ all -> 0x046e }
            if (r9 < r14) goto L_0x0243
            if (r9 <= r3) goto L_0x0131
            goto L_0x0243
        L_0x0131:
            if (r9 != r3) goto L_0x013c
            if (r8 != r6) goto L_0x013c
            java.lang.String r3 = "Cannot resize to a full-screen ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)     // Catch:{ all -> 0x046e }
            goto L_0x024e
        L_0x013c:
            boolean r3 = r1.zzc     // Catch:{ all -> 0x046e }
            if (r3 == 0) goto L_0x0204
            java.lang.String r3 = r1.zzb     // Catch:{ all -> 0x046e }
            int r16 = r3.hashCode()     // Catch:{ all -> 0x046e }
            switch(r16) {
                case -1364013995: goto L_0x017c;
                case -1012429441: goto L_0x0172;
                case -655373719: goto L_0x0168;
                case 1163912186: goto L_0x015e;
                case 1288627767: goto L_0x0154;
                case 1755462605: goto L_0x014a;
                default: goto L_0x0149;
            }
        L_0x0149:
            goto L_0x0186
        L_0x014a:
            java.lang.String r10 = "top-center"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = r7
            goto L_0x0187
        L_0x0154:
            java.lang.String r10 = "bottom-center"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = 4
            goto L_0x0187
        L_0x015e:
            java.lang.String r10 = "bottom-right"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = 5
            goto L_0x0187
        L_0x0168:
            java.lang.String r10 = "bottom-left"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = r11
            goto L_0x0187
        L_0x0172:
            java.lang.String r10 = "top-left"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = r5
            goto L_0x0187
        L_0x017c:
            java.lang.String r10 = "center"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0149
            r3 = r12
            goto L_0x0187
        L_0x0186:
            r3 = r13
        L_0x0187:
            switch(r3) {
                case 0: goto L_0x01d2;
                case 1: goto L_0x01c6;
                case 2: goto L_0x01b3;
                case 3: goto L_0x01a6;
                case 4: goto L_0x0198;
                case 5: goto L_0x018d;
                default: goto L_0x018a;
            }
        L_0x018a:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            goto L_0x01dd
        L_0x018d:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r10 = r1.zzg     // Catch:{ all -> 0x046e }
            int r3 = r3 + r10
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            goto L_0x01a3
        L_0x0198:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r10 = r1.zzg     // Catch:{ all -> 0x046e }
            int r8 = r8 >> r7
            int r3 = r3 + r10
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
        L_0x01a3:
            int r10 = r1.zzh     // Catch:{ all -> 0x046e }
            goto L_0x01ae
        L_0x01a6:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r8 = r1.zzg     // Catch:{ all -> 0x046e }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            goto L_0x01a3
        L_0x01ae:
            int r8 = r8 + r10
            int r8 = r8 + r9
            int r8 = r8 + -50
            goto L_0x01e6
        L_0x01b3:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r10 = r1.zzg     // Catch:{ all -> 0x046e }
            int r8 = r8 >> r7
            int r3 = r3 + r10
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            int r10 = r1.zzh     // Catch:{ all -> 0x046e }
            int r8 = r8 + r10
            int r9 = r9 >> r7
            int r8 = r8 + r9
            int r8 = r8 + -25
            goto L_0x01e6
        L_0x01c6:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r9 = r1.zzg     // Catch:{ all -> 0x046e }
            int r8 = r8 >> r7
            int r3 = r3 + r9
            int r3 = r3 + r8
            int r3 = r3 + -25
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            goto L_0x01d9
        L_0x01d2:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r8 = r1.zzg     // Catch:{ all -> 0x046e }
            int r3 = r3 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
        L_0x01d9:
            int r9 = r1.zzh     // Catch:{ all -> 0x046e }
            int r8 = r8 + r9
            goto L_0x01e6
        L_0x01dd:
            int r9 = r1.zzg     // Catch:{ all -> 0x046e }
            int r3 = r3 + r9
            int r3 = r3 + r8
            int r3 = r3 + -50
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            goto L_0x01d9
        L_0x01e6:
            if (r3 < 0) goto L_0x024e
            int r3 = r3 + r14
            if (r3 > r6) goto L_0x024e
            r3 = r4[r5]     // Catch:{ all -> 0x046e }
            if (r8 < r3) goto L_0x024e
            int r8 = r8 + r14
            r3 = r4[r7]     // Catch:{ all -> 0x046e }
            if (r8 <= r3) goto L_0x01f5
            goto L_0x024e
        L_0x01f5:
            int r3 = r1.zzd     // Catch:{ all -> 0x046e }
            int r4 = r1.zzg     // Catch:{ all -> 0x046e }
            int r3 = r3 + r4
            int r4 = r1.zze     // Catch:{ all -> 0x046e }
            int r6 = r1.zzh     // Catch:{ all -> 0x046e }
            int r4 = r4 + r6
            int[] r15 = new int[]{r3, r4}     // Catch:{ all -> 0x046e }
            goto L_0x024e
        L_0x0204:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x046e }
            int[] r3 = com.google.android.gms.ads.internal.util.zzt.zzV(r3)     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x046e }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzR(r4)     // Catch:{ all -> 0x046e }
            r3 = r3[r5]     // Catch:{ all -> 0x046e }
            int r6 = r1.zzd     // Catch:{ all -> 0x046e }
            int r8 = r1.zzg     // Catch:{ all -> 0x046e }
            int r6 = r6 + r8
            int r8 = r1.zze     // Catch:{ all -> 0x046e }
            int r9 = r1.zzh     // Catch:{ all -> 0x046e }
            int r8 = r8 + r9
            if (r6 >= 0) goto L_0x0226
            r6 = r5
            goto L_0x022e
        L_0x0226:
            int r9 = r1.zzi     // Catch:{ all -> 0x046e }
            int r10 = r6 + r9
            if (r10 <= r3) goto L_0x022e
            int r6 = r3 - r9
        L_0x022e:
            r3 = r4[r5]     // Catch:{ all -> 0x046e }
            if (r8 >= r3) goto L_0x0234
            r8 = r3
            goto L_0x023e
        L_0x0234:
            int r3 = r1.zzf     // Catch:{ all -> 0x046e }
            int r9 = r8 + r3
            r4 = r4[r7]     // Catch:{ all -> 0x046e }
            if (r9 <= r4) goto L_0x023e
            int r8 = r4 - r3
        L_0x023e:
            int[] r15 = new int[]{r6, r8}     // Catch:{ all -> 0x046e }
            goto L_0x024e
        L_0x0243:
            java.lang.String r3 = "Height is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)     // Catch:{ all -> 0x046e }
            goto L_0x024e
        L_0x0249:
            java.lang.String r3 = "Width is too small or too large."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)     // Catch:{ all -> 0x046e }
        L_0x024e:
            if (r15 != 0) goto L_0x0257
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0257:
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x046e }
            android.app.Activity r3 = r1.zzl     // Catch:{ all -> 0x046e }
            int r4 = r1.zzi     // Catch:{ all -> 0x046e }
            int r3 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r3, r4)     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x046e }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x046e }
            int r6 = r1.zzf     // Catch:{ all -> 0x046e }
            int r4 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r4, r6)     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzk     // Catch:{ all -> 0x046e }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x046e }
            android.view.ViewParent r6 = r6.getParent()     // Catch:{ all -> 0x046e }
            if (r6 == 0) goto L_0x0459
            boolean r8 = r6 instanceof android.view.ViewGroup     // Catch:{ all -> 0x046e }
            if (r8 == 0) goto L_0x0459
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r8 = r1.zzk     // Catch:{ all -> 0x046e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x046e }
            r6.removeView(r8)     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r8 = r1.zzq     // Catch:{ all -> 0x046e }
            if (r8 != 0) goto L_0x02c3
            r1.zzs = r6     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzk     // Catch:{ all -> 0x046e }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x046e }
            r8.setDrawingCacheEnabled(r7)     // Catch:{ all -> 0x046e }
            r8 = r6
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x046e }
            android.graphics.Bitmap r8 = r8.getDrawingCache()     // Catch:{ all -> 0x046e }
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8)     // Catch:{ all -> 0x046e }
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x046e }
            r6.setDrawingCacheEnabled(r5)     // Catch:{ all -> 0x046e }
            android.widget.ImageView r6 = new android.widget.ImageView     // Catch:{ all -> 0x046e }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x046e }
            r6.<init>(r9)     // Catch:{ all -> 0x046e }
            r1.zzn = r6     // Catch:{ all -> 0x046e }
            android.widget.ImageView r6 = r1.zzn     // Catch:{ all -> 0x046e }
            r6.setImageBitmap(r8)     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r6 = r1.zzk     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzcix r6 = r6.zzO()     // Catch:{ all -> 0x046e }
            r1.zzm = r6     // Catch:{ all -> 0x046e }
            android.view.ViewGroup r6 = r1.zzs     // Catch:{ all -> 0x046e }
            android.widget.ImageView r8 = r1.zzn     // Catch:{ all -> 0x046e }
            r6.addView(r8)     // Catch:{ all -> 0x046e }
            goto L_0x02c6
        L_0x02c3:
            r8.dismiss()     // Catch:{ all -> 0x046e }
        L_0x02c6:
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout     // Catch:{ all -> 0x046e }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x046e }
            r6.<init>(r8)     // Catch:{ all -> 0x046e }
            r1.zzr = r6     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x046e }
            r6.setBackgroundColor(r5)     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x046e }
            android.view.ViewGroup$LayoutParams r8 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x046e }
            r8.<init>(r3, r4)     // Catch:{ all -> 0x046e }
            r6.setLayoutParams(r8)     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r8 = new android.widget.PopupWindow     // Catch:{ all -> 0x046e }
            r8.<init>(r6, r3, r4, r5)     // Catch:{ all -> 0x046e }
            r1.zzq = r8     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x046e }
            r6.setOutsideTouchable(r5)     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x046e }
            r6.setTouchable(r7)     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ all -> 0x046e }
            boolean r8 = r1.zzc     // Catch:{ all -> 0x046e }
            r8 = r8 ^ r7
            r6.setClippingEnabled(r8)     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r6 = r1.zzr     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r8 = r1.zzk     // Catch:{ all -> 0x046e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ all -> 0x046e }
            r6.addView(r8, r13, r13)     // Catch:{ all -> 0x046e }
            android.widget.LinearLayout r6 = new android.widget.LinearLayout     // Catch:{ all -> 0x046e }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x046e }
            r6.<init>(r8)     // Catch:{ all -> 0x046e }
            r1.zzo = r6     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x046e }
            android.app.Activity r8 = r1.zzl     // Catch:{ all -> 0x046e }
            int r8 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r8, r14)     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ all -> 0x046e }
            android.app.Activity r9 = r1.zzl     // Catch:{ all -> 0x046e }
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r14)     // Catch:{ all -> 0x046e }
            r6.<init>(r8, r9)     // Catch:{ all -> 0x046e }
            java.lang.String r8 = r1.zzb     // Catch:{ all -> 0x046e }
            int r9 = r8.hashCode()     // Catch:{ all -> 0x046e }
            switch(r9) {
                case -1364013995: goto L_0x0361;
                case -1012429441: goto L_0x0357;
                case -655373719: goto L_0x034d;
                case 1163912186: goto L_0x0343;
                case 1288627767: goto L_0x0339;
                case 1755462605: goto L_0x032f;
                default: goto L_0x032e;
            }
        L_0x032e:
            goto L_0x036b
        L_0x032f:
            java.lang.String r9 = "top-center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = r7
            goto L_0x036c
        L_0x0339:
            java.lang.String r9 = "bottom-center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = 4
            goto L_0x036c
        L_0x0343:
            java.lang.String r9 = "bottom-right"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = 5
            goto L_0x036c
        L_0x034d:
            java.lang.String r9 = "bottom-left"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = r11
            goto L_0x036c
        L_0x0357:
            java.lang.String r9 = "top-left"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = r5
            goto L_0x036c
        L_0x0361:
            java.lang.String r9 = "center"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x032e
            r9 = r12
            goto L_0x036c
        L_0x036b:
            r9 = r13
        L_0x036c:
            r8 = 11
            r10 = 14
            r11 = 9
            r12 = 12
            r13 = 10
            switch(r9) {
                case 0: goto L_0x03a4;
                case 1: goto L_0x039c;
                case 2: goto L_0x0395;
                case 3: goto L_0x038d;
                case 4: goto L_0x0385;
                case 5: goto L_0x037d;
                default: goto L_0x0379;
            }
        L_0x0379:
            r6.addRule(r13)     // Catch:{ all -> 0x046e }
            goto L_0x03ac
        L_0x037d:
            r6.addRule(r12)     // Catch:{ all -> 0x046e }
            r6.addRule(r8)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x0385:
            r6.addRule(r12)     // Catch:{ all -> 0x046e }
            r6.addRule(r10)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x038d:
            r6.addRule(r12)     // Catch:{ all -> 0x046e }
            r6.addRule(r11)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x0395:
            r8 = 13
            r6.addRule(r8)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x039c:
            r6.addRule(r13)     // Catch:{ all -> 0x046e }
            r6.addRule(r10)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x03a4:
            r6.addRule(r13)     // Catch:{ all -> 0x046e }
            r6.addRule(r11)     // Catch:{ all -> 0x046e }
            goto L_0x03af
        L_0x03ac:
            r6.addRule(r8)     // Catch:{ all -> 0x046e }
        L_0x03af:
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzbuc r9 = new com.google.android.gms.internal.ads.zzbuc     // Catch:{ all -> 0x046e }
            r9.<init>(r1)     // Catch:{ all -> 0x046e }
            r8.setOnClickListener(r9)     // Catch:{ all -> 0x046e }
            android.widget.LinearLayout r8 = r1.zzo     // Catch:{ all -> 0x046e }
            java.lang.String r9 = "Close button"
            r8.setContentDescription(r9)     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r8 = r1.zzr     // Catch:{ all -> 0x046e }
            android.widget.LinearLayout r9 = r1.zzo     // Catch:{ all -> 0x046e }
            r8.addView(r9, r6)     // Catch:{ all -> 0x046e }
            android.widget.PopupWindow r6 = r1.zzq     // Catch:{ RuntimeException -> 0x041c }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x041c }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x041c }
            android.app.Activity r8 = r1.zzl     // Catch:{ RuntimeException -> 0x041c }
            r9 = r15[r5]     // Catch:{ RuntimeException -> 0x041c }
            int r8 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r8, r9)     // Catch:{ RuntimeException -> 0x041c }
            com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ RuntimeException -> 0x041c }
            android.app.Activity r9 = r1.zzl     // Catch:{ RuntimeException -> 0x041c }
            r10 = r15[r7]     // Catch:{ RuntimeException -> 0x041c }
            int r9 = com.google.android.gms.ads.internal.util.client.zzf.zzy(r9, r10)     // Catch:{ RuntimeException -> 0x041c }
            r6.showAtLocation(r0, r5, r8, r9)     // Catch:{ RuntimeException -> 0x041c }
            r0 = r15[r5]     // Catch:{ all -> 0x046e }
            r6 = r15[r7]     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzbuk r8 = r1.zzp     // Catch:{ all -> 0x046e }
            if (r8 == 0) goto L_0x03f5
            int r9 = r1.zzi     // Catch:{ all -> 0x046e }
            int r10 = r1.zzf     // Catch:{ all -> 0x046e }
            r8.zza(r0, r6, r9, r10)     // Catch:{ all -> 0x046e }
        L_0x03f5:
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzk     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzcix r3 = com.google.android.gms.internal.ads.zzcix.zzb(r3, r4)     // Catch:{ all -> 0x046e }
            r0.zzaj(r3)     // Catch:{ all -> 0x046e }
            r0 = r15[r5]     // Catch:{ all -> 0x046e }
            r3 = r15[r7]     // Catch:{ all -> 0x046e }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x046e }
            android.app.Activity r4 = r1.zzl     // Catch:{ all -> 0x046e }
            int[] r4 = com.google.android.gms.ads.internal.util.zzt.zzR(r4)     // Catch:{ all -> 0x046e }
            r4 = r4[r5]     // Catch:{ all -> 0x046e }
            int r3 = r3 - r4
            int r4 = r1.zzi     // Catch:{ all -> 0x046e }
            int r5 = r1.zzf     // Catch:{ all -> 0x046e }
            r1.zzk(r0, r3, r4, r5)     // Catch:{ all -> 0x046e }
            java.lang.String r0 = "resized"
            r1.zzl(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x041c:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x046e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x046e }
            r3.<init>()     // Catch:{ all -> 0x046e }
            java.lang.String r4 = "Cannot show popup window: "
            r3.append(r4)     // Catch:{ all -> 0x046e }
            r3.append(r0)     // Catch:{ all -> 0x046e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x046e }
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            android.widget.RelativeLayout r0 = r1.zzr     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r3 = r1.zzk     // Catch:{ all -> 0x046e }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x046e }
            r0.removeView(r3)     // Catch:{ all -> 0x046e }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x046e }
            if (r0 == 0) goto L_0x0457
            android.widget.ImageView r3 = r1.zzn     // Catch:{ all -> 0x046e }
            r0.removeView(r3)     // Catch:{ all -> 0x046e }
            android.view.ViewGroup r0 = r1.zzs     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r3 = r1.zzk     // Catch:{ all -> 0x046e }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x046e }
            r0.addView(r3)     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzchd r0 = r1.zzk     // Catch:{ all -> 0x046e }
            com.google.android.gms.internal.ads.zzcix r3 = r1.zzm     // Catch:{ all -> 0x046e }
            r0.zzaj(r3)     // Catch:{ all -> 0x046e }
        L_0x0457:
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0459:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0460:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x0467:
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzh(r0)     // Catch:{ all -> 0x046e }
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            return
        L_0x046e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x046e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbud.zzb(java.util.Map):void");
    }

    public final void zzd(int i, int i2, boolean z) {
        synchronized (this.zzj) {
            this.zzd = i;
            this.zze = i2;
        }
    }

    public final void zze(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean zzf() {
        boolean z;
        synchronized (this.zzj) {
            z = this.zzq != null;
        }
        return z;
    }
}
