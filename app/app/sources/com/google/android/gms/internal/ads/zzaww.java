package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaww implements zzawz {
    private static zzaww zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzfsx zzd;
    private final zzfte zze;
    private final zzftg zzf;
    private final zzaxy zzg;
    /* access modifiers changed from: private */
    public final zzfre zzh;
    private final Executor zzi;
    private final zzazw zzj;
    private final zzftd zzk;
    private final CountDownLatch zzl;
    private final zzayn zzm;
    private final zzayf zzn;
    private final zzaxw zzo;
    /* access modifiers changed from: private */
    public final Object zzp = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzq;
    private volatile boolean zzr = false;

    zzaww(Context context, zzfre zzfre, zzfsx zzfsx, zzfte zzfte, zzftg zzftg, zzaxy zzaxy, Executor executor, zzfqx zzfqx, zzazw zzazw, zzayn zzayn, zzayf zzayf, zzaxw zzaxw) {
        this.zzc = context;
        this.zzh = zzfre;
        this.zzd = zzfsx;
        this.zze = zzfte;
        this.zzf = zzftg;
        this.zzg = zzaxy;
        this.zzi = executor;
        this.zzj = zzazw;
        this.zzm = zzayn;
        this.zzn = zzayf;
        this.zzo = zzaxw;
        this.zzr = false;
        this.zzl = new CountDownLatch(1);
        this.zzk = new zzawu(this, zzfqx);
    }

    public static synchronized zzaww zza(String str, Context context, boolean z, boolean z2) {
        zzaww zzb2;
        synchronized (zzaww.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzaww zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzaww zzaww;
        zzaxh zzaxh;
        zzayn zzayn;
        zzayf zzayf;
        zzaxw zzaxw;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzaww.class) {
            if (zzb == null) {
                zzfrf zza2 = zzfrg.zza();
                zza2.zza(str);
                zza2.zzc(z);
                zzfrg zzd2 = zza2.zzd();
                zzfre zza3 = zzfre.zza(context2, executor2, z2);
                if (((Boolean) zzba.zzc().zza(zzbep.zzdq)).booleanValue()) {
                    zzaxh = zzaxh.zzc(context);
                } else {
                    zzaxh = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzdr)).booleanValue()) {
                    zzayn = zzayn.zzd(context, executor);
                } else {
                    zzayn = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzcF)).booleanValue()) {
                    zzayf = new zzayf();
                } else {
                    zzayf = null;
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzcH)).booleanValue()) {
                    zzaxw = new zzaxw();
                } else {
                    zzaxw = null;
                }
                zzfrx zze2 = zzfrx.zze(context2, executor2, zza3, zzd2);
                zzaxx zzaxx = new zzaxx(context2);
                zzaxy zzaxy = new zzaxy(zzd2, zze2, new zzayl(context2, zzaxx), zzaxx, zzaxh, zzayn, zzayf, zzaxw);
                zzazw zzb2 = zzfsk.zzb(context2, zza3);
                zzfqx zzfqx = new zzfqx();
                zzb = new zzaww(context, zza3, new zzfsx(context2, zzb2), new zzfte(context2, zzb2, new zzawt(zza3), ((Boolean) zzba.zzc().zza(zzbep.zzco)).booleanValue()), new zzftg(context2, zzaxy, zza3, zzfqx), zzaxy, executor, zzfqx, zzb2, zzayn, zzayf, zzaxw);
                zzb.zzm();
                zzb.zzp();
            }
            zzaww = zzb;
        }
        return zzaww;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L_0x00f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzaww r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzfsw r3 = r12.zzt(r2)
            if (r3 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzbac r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.android.gms.internal.ads.zzbac r3 = r3.zza()
            java.lang.String r3 = r3.zzj()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzhcd -> 0x0122 }
            com.google.android.gms.internal.ads.zzazw r7 = r12.zzj     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfre r11 = r12.zzh     // Catch:{ zzhcd -> 0x0122 }
            r6 = 1
            com.google.android.gms.internal.ads.zzftb r3 = com.google.android.gms.internal.ads.zzfro.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzhcd -> 0x0122 }
            byte[] r4 = r3.zzb     // Catch:{ zzhcd -> 0x0122 }
            if (r4 == 0) goto L_0x0113
            int r5 = r4.length     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x0037
            goto L_0x0113
        L_0x0037:
            r6 = 0
            com.google.android.gms.internal.ads.zzhac r4 = com.google.android.gms.internal.ads.zzhac.zzv(r4, r6, r5)     // Catch:{ NullPointerException -> 0x0105 }
            com.google.android.gms.internal.ads.zzhay r5 = com.google.android.gms.internal.ads.zzhay.zza()     // Catch:{ NullPointerException -> 0x0105 }
            com.google.android.gms.internal.ads.zzazz r4 = com.google.android.gms.internal.ads.zzazz.zzc(r4, r5)     // Catch:{ NullPointerException -> 0x0105 }
            com.google.android.gms.internal.ads.zzbac r5 = r4.zzd()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzhcd -> 0x0122 }
            boolean r5 = r5.isEmpty()     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzbac r5 = r4.zzd()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzhcd -> 0x0122 }
            boolean r5 = r5.isEmpty()     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzhac r5 = r4.zze()     // Catch:{ zzhcd -> 0x0122 }
            byte[] r5 = r5.zzB()     // Catch:{ zzhcd -> 0x0122 }
            int r5 = r5.length     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x006e
            goto L_0x00f8
        L_0x006e:
            com.google.android.gms.internal.ads.zzfsw r5 = r12.zzt(r2)     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x0076
            goto L_0x009e
        L_0x0076:
            com.google.android.gms.internal.ads.zzbac r5 = r5.zza()     // Catch:{ zzhcd -> 0x0122 }
            com.google.android.gms.internal.ads.zzbac r6 = r4.zzd()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzhcd -> 0x0122 }
            boolean r6 = r6.equals(r7)     // Catch:{ zzhcd -> 0x0122 }
            if (r6 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzbac r6 = r4.zzd()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r6 = r6.zzj()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzhcd -> 0x0122 }
            boolean r5 = r6.equals(r5)     // Catch:{ zzhcd -> 0x0122 }
            if (r5 != 0) goto L_0x00f8
        L_0x009e:
            com.google.android.gms.internal.ads.zzftd r5 = r12.zzk     // Catch:{ zzhcd -> 0x0122 }
            int r3 = r3.zzc     // Catch:{ zzhcd -> 0x0122 }
            com.google.android.gms.internal.ads.zzbeg r6 = com.google.android.gms.internal.ads.zzbep.zzcm     // Catch:{ zzhcd -> 0x0122 }
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzhcd -> 0x0122 }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ zzhcd -> 0x0122 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzhcd -> 0x0122 }
            boolean r6 = r6.booleanValue()     // Catch:{ zzhcd -> 0x0122 }
            if (r6 == 0) goto L_0x00c8
            r6 = 3
            if (r3 != r6) goto L_0x00be
            com.google.android.gms.internal.ads.zzfte r3 = r12.zze     // Catch:{ zzhcd -> 0x0122 }
            boolean r3 = r3.zza(r4)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x00ce
        L_0x00be:
            r6 = 4
            if (r3 != r6) goto L_0x00d0
            com.google.android.gms.internal.ads.zzfte r3 = r12.zze     // Catch:{ zzhcd -> 0x0122 }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x00ce
        L_0x00c8:
            com.google.android.gms.internal.ads.zzfsx r3 = r12.zzd     // Catch:{ zzhcd -> 0x0122 }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzhcd -> 0x0122 }
        L_0x00ce:
            if (r3 != 0) goto L_0x00dd
        L_0x00d0:
            com.google.android.gms.internal.ads.zzfre r2 = r12.zzh     // Catch:{ zzhcd -> 0x0122 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhcd -> 0x0122 }
            long r3 = r3 - r0
            r5 = 4009(0xfa9, float:5.618E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x012f
        L_0x00dd:
            com.google.android.gms.internal.ads.zzfsw r3 = r12.zzt(r2)     // Catch:{ zzhcd -> 0x0122 }
            if (r3 == 0) goto L_0x012f
            com.google.android.gms.internal.ads.zzftg r4 = r12.zzf     // Catch:{ zzhcd -> 0x0122 }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzhcd -> 0x0122 }
            if (r3 == 0) goto L_0x00ee
            r12.zzr = r2     // Catch:{ zzhcd -> 0x0122 }
        L_0x00ee:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzhcd -> 0x0122 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x012f
        L_0x00f8:
            com.google.android.gms.internal.ads.zzfre r2 = r12.zzh     // Catch:{ zzhcd -> 0x0122 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhcd -> 0x0122 }
            long r3 = r3 - r0
            r5 = 5010(0x1392, float:7.02E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x012f
        L_0x0105:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfre r2 = r12.zzh     // Catch:{ zzhcd -> 0x0122 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhcd -> 0x0122 }
            long r3 = r3 - r0
            r5 = 2030(0x7ee, float:2.845E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x012f
        L_0x0113:
            com.google.android.gms.internal.ads.zzfre r2 = r12.zzh     // Catch:{ zzhcd -> 0x0122 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhcd -> 0x0122 }
            long r3 = r3 - r0
            r5 = 5009(0x1391, float:7.019E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhcd -> 0x0122 }
            goto L_0x012f
        L_0x0120:
            r0 = move-exception
            goto L_0x0135
        L_0x0122:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfre r3 = r12.zzh     // Catch:{ all -> 0x0120 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0120 }
            long r4 = r4 - r0
            r0 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r0, r4, r2)     // Catch:{ all -> 0x0120 }
        L_0x012f:
            java.util.concurrent.CountDownLatch r12 = r12.zzl
            r12.countDown()
            return
        L_0x0135:
            java.util.concurrent.CountDownLatch r12 = r12.zzl
            r12.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzj(com.google.android.gms.internal.ads.zzaww):void");
    }

    private final void zzs() {
        zzayn zzayn = this.zzm;
        if (zzayn != null) {
            zzayn.zzh();
        }
    }

    private final zzfsw zzt(int i) {
        if (!zzfsk.zza(this.zzj)) {
            return null;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzcm)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcF)).booleanValue()) {
            this.zzn.zzi();
        }
        zzp();
        zzfrh zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map) null);
        return zza3;
    }

    public final String zzg(Context context) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcF)).booleanValue()) {
            this.zzn.zzj();
        }
        zzp();
        zzfrh zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map) null);
        return zzc2;
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcF)).booleanValue()) {
            this.zzn.zzk(context, view);
        }
        zzp();
        zzfrh zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzfrh zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzftf e) {
                this.zzh.zzc(e.zza(), -1, e);
            }
        }
    }

    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (((Boolean) zzba.zzc().zza(zzbep.zzlU)).booleanValue() && (displayMetrics = this.zzc.getResources().getDisplayMetrics()) != null) {
            float f = (float) i;
            float f2 = (float) i2;
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain);
            obtain.recycle();
            MotionEvent obtain2 = MotionEvent.obtain(0, 0, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain2);
            obtain2.recycle();
            MotionEvent obtain3 = MotionEvent.obtain(0, (long) i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain3);
            obtain3.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzm() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002b }
            r2 = 1
            com.google.android.gms.internal.ads.zzfsw r3 = r5.zzt(r2)     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzftg r0 = r5.zzf     // Catch:{ all -> 0x002b }
            boolean r0 = r0.zzc(r3)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x001b
            r5.zzr = r2     // Catch:{ all -> 0x002b }
            java.util.concurrent.CountDownLatch r0 = r5.zzl     // Catch:{ all -> 0x002b }
            r0.countDown()     // Catch:{ all -> 0x002b }
        L_0x001b:
            monitor-exit(r5)
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfre r2 = r5.zzh     // Catch:{ all -> 0x002b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002b }
            long r3 = r3 - r0
            r0 = 4013(0xfad, float:5.623E-42)
            r2.zzd(r0, r3)     // Catch:{ all -> 0x002b }
            monitor-exit(r5)
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzm():void");
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaxw zzaxw = this.zzo;
        if (zzaxw != null) {
            zzaxw.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp() {
        /*
            r5 = this;
            boolean r0 = r5.zzq
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r5.zzp
            monitor-enter(r0)
            boolean r1 = r5.zzq     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r5.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzftg r1 = r5.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfsw r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            com.google.android.gms.internal.ads.zzazw r1 = r5.zzj     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfsk.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r5.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzawv r2 = new com.google.android.gms.internal.ads.zzawv     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaww.zzp():void");
    }

    public final synchronized boolean zzr() {
        return this.zzr;
    }
}
