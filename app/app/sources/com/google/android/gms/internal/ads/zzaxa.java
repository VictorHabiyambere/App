package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzaxa implements zzawz {
    protected static volatile zzaye zza = null;
    protected MotionEvent zzb;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected boolean zzp = false;
    protected DisplayMetrics zzq;
    protected zzaxw zzr;
    private double zzs;
    private double zzt;
    private boolean zzu = false;

    protected zzaxa(Context context) {
        try {
            zzavs.zze();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) zzba.zzc().zza(zzbep.zzcH)).booleanValue()) {
                this.zzr = new zzaxw();
            }
        } catch (Throwable th) {
        }
    }

    private final void zzj() {
        this.zzh = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzj = 0;
        if (!this.zzc.isEmpty()) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        } else {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzb = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b4 A[SYNTHETIC, Splitter:B:50:0x00b4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzm(android.content.Context r20, java.lang.String r21, int r22, android.view.View r23, android.app.Activity r24, byte[] r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            r3 = r23
            r4 = r24
            long r5 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.ads.zzbeg r7 = com.google.android.gms.internal.ads.zzbep.zzcz
            com.google.android.gms.internal.ads.zzben r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r8.zza(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 0
            if (r7 == 0) goto L_0x0030
            com.google.android.gms.internal.ads.zzaye r9 = zza
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzaye r9 = zza
            com.google.android.gms.internal.ads.zzawy r9 = r9.zzd()
            goto L_0x002d
        L_0x002c:
            r9 = r8
        L_0x002d:
            java.lang.String r10 = "be"
            goto L_0x0032
        L_0x0030:
            r9 = r8
            r10 = r9
        L_0x0032:
            r14 = 1
            r15 = 2
            r13 = 3
            if (r2 != r13) goto L_0x004d
            com.google.android.gms.internal.ads.zzatp r8 = r1.zzb(r0, r3, r4)     // Catch:{ Exception -> 0x0048 }
            r1.zzu = r14     // Catch:{ Exception -> 0x0041 }
            r0 = 1002(0x3ea, float:1.404E-42)
            r12 = r0
            goto L_0x0061
        L_0x0041:
            r0 = move-exception
            r17 = r0
            r1 = r13
            r18 = r14
            goto L_0x0087
        L_0x0048:
            r0 = move-exception
            r1 = r13
            r18 = r14
            goto L_0x0085
        L_0x004d:
            if (r2 != r15) goto L_0x0058
            com.google.android.gms.internal.ads.zzatp r0 = r1.zzd(r0, r3, r4)     // Catch:{ Exception -> 0x0048 }
            r3 = 1008(0x3f0, float:1.413E-42)
            r8 = r0
            r12 = r3
            goto L_0x0061
        L_0x0058:
            com.google.android.gms.internal.ads.zzatp r0 = r1.zzc(r0, r8)     // Catch:{ Exception -> 0x0048 }
            r3 = 1000(0x3e8, float:1.401E-42)
            r8 = r0
            r12 = r3
        L_0x0061:
            if (r7 == 0) goto L_0x0082
            if (r9 == 0) goto L_0x0082
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x007b }
            long r3 = r3 - r5
            r0 = -1
            r17 = 0
            r11 = r9
            r1 = r13
            r13 = r0
            r18 = r14
            r14 = r3
            r16 = r10
            r11.zzc(r12, r13, r14, r16, r17)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0083
        L_0x0079:
            r0 = move-exception
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            r1 = r13
            r18 = r14
        L_0x007f:
            r17 = r0
            goto L_0x0087
        L_0x0082:
            r1 = r13
        L_0x0083:
            r3 = 2
            goto L_0x00ae
        L_0x0085:
            r17 = r0
        L_0x0087:
            if (r7 == 0) goto L_0x00ad
            if (r9 == 0) goto L_0x00ad
            if (r2 != r1) goto L_0x0092
            r0 = 1003(0x3eb, float:1.406E-42)
            r12 = r0
            r3 = 2
            goto L_0x009e
        L_0x0092:
            r3 = 2
            if (r2 != r3) goto L_0x0099
            r0 = 1009(0x3f1, float:1.414E-42)
            r12 = r0
            goto L_0x009e
        L_0x0099:
            r0 = 1001(0x3e9, float:1.403E-42)
            r12 = r0
            r2 = r18
        L_0x009e:
            long r13 = java.lang.System.currentTimeMillis()
            long r14 = r13 - r5
            r13 = -1
            r11 = r9
            r16 = r10
            r11.zzc(r12, r13, r14, r16, r17)
            goto L_0x00ae
        L_0x00ad:
            r3 = 2
        L_0x00ae:
            long r4 = java.lang.System.currentTimeMillis()
            if (r8 == 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzhbo r0 = r8.zzbr()     // Catch:{ Exception -> 0x00fc }
            com.google.android.gms.internal.ads.zzaus r0 = (com.google.android.gms.internal.ads.zzaus) r0     // Catch:{ Exception -> 0x00fc }
            int r0 = r0.zzaY()     // Catch:{ Exception -> 0x00fc }
            if (r0 != 0) goto L_0x00c1
            goto L_0x00f5
        L_0x00c1:
            com.google.android.gms.internal.ads.zzhbo r0 = r8.zzbr()     // Catch:{ Exception -> 0x00fc }
            com.google.android.gms.internal.ads.zzaus r0 = (com.google.android.gms.internal.ads.zzaus) r0     // Catch:{ Exception -> 0x00fc }
            int r6 = com.google.android.gms.internal.ads.zzavs.zzc     // Catch:{ Exception -> 0x00fc }
            byte[] r0 = r0.zzaV()     // Catch:{ Exception -> 0x00fc }
            r6 = r21
            java.lang.String r0 = com.google.android.gms.internal.ads.zzavs.zzb(r0, r6)     // Catch:{ Exception -> 0x00fc }
            if (r7 == 0) goto L_0x00f4
            if (r9 == 0) goto L_0x00f4
            if (r2 != r1) goto L_0x00dd
            r6 = 1006(0x3ee, float:1.41E-42)
            r12 = r6
            goto L_0x00e5
        L_0x00dd:
            if (r2 != r3) goto L_0x00e2
            r6 = 1010(0x3f2, float:1.415E-42)
            goto L_0x00e4
        L_0x00e2:
            r6 = 1004(0x3ec, float:1.407E-42)
        L_0x00e4:
            r12 = r6
        L_0x00e5:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fc }
            long r14 = r13 - r4
            r13 = -1
            r17 = 0
            r11 = r9
            r16 = r10
            r11.zzc(r12, r13, r14, r16, r17)     // Catch:{ Exception -> 0x00fc }
        L_0x00f4:
            goto L_0x0126
        L_0x00f5:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x00fc }
            goto L_0x0126
        L_0x00fc:
            r0 = move-exception
            r17 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r7 == 0) goto L_0x0125
            if (r9 == 0) goto L_0x0125
            if (r2 != r1) goto L_0x010e
            r1 = 1007(0x3ef, float:1.411E-42)
            r12 = r1
            goto L_0x0116
        L_0x010e:
            if (r2 != r3) goto L_0x0113
            r1 = 1011(0x3f3, float:1.417E-42)
            goto L_0x0115
        L_0x0113:
            r1 = 1005(0x3ed, float:1.408E-42)
        L_0x0115:
            r12 = r1
        L_0x0116:
            long r1 = java.lang.System.currentTimeMillis()
            long r14 = r1 - r4
            r13 = -1
            r11 = r9
            r16 = r10
            r11.zzc(r12, r13, r14, r16, r17)
            goto L_0x0126
        L_0x0125:
        L_0x0126:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxa.zzm(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzaxu;

    /* access modifiers changed from: protected */
    public abstract zzatp zzb(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzatp zzc(Context context, zzatg zzatg);

    /* access modifiers changed from: protected */
    public abstract zzatp zzd(Context context, View view, Activity activity);

    public final String zze(Context context, String str, View view) {
        return zzm(context, str, 3, view, (Activity) null, (byte[]) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzm(context, str, 3, view, activity, (byte[]) null);
    }

    public final String zzg(Context context) {
        if (!zzayh.zzc()) {
            return zzm(context, (String) null, 1, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public final String zzh(Context context, View view, Activity activity) {
        return zzm(context, (String) null, 2, view, activity, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public abstract zzayg zzi(MotionEvent motionEvent) throws zzaxu;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(android.view.MotionEvent r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = r10.zzu     // Catch:{ all -> 0x00f8 }
            if (r0 == 0) goto L_0x000b
            r10.zzj()     // Catch:{ all -> 0x00f8 }
            r0 = 0
            r10.zzu = r0     // Catch:{ all -> 0x00f8 }
        L_0x000b:
            int r0 = r11.getAction()     // Catch:{ all -> 0x00f8 }
            switch(r0) {
                case 0: goto L_0x0036;
                case 1: goto L_0x0013;
                case 2: goto L_0x0013;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x00f8 }
        L_0x0012:
            goto L_0x0048
        L_0x0013:
            float r0 = r11.getRawX()     // Catch:{ all -> 0x00f8 }
            double r0 = (double) r0     // Catch:{ all -> 0x00f8 }
            float r2 = r11.getRawY()     // Catch:{ all -> 0x00f8 }
            double r2 = (double) r2     // Catch:{ all -> 0x00f8 }
            double r4 = r10.zzs     // Catch:{ all -> 0x00f8 }
            double r4 = r0 - r4
            double r6 = r10.zzt     // Catch:{ all -> 0x00f8 }
            double r6 = r2 - r6
            double r8 = r10.zzk     // Catch:{ all -> 0x00f8 }
            double r4 = r4 * r4
            double r6 = r6 * r6
            double r4 = r4 + r6
            double r4 = java.lang.Math.sqrt(r4)     // Catch:{ all -> 0x00f8 }
            double r8 = r8 + r4
            r10.zzk = r8     // Catch:{ all -> 0x00f8 }
            r10.zzs = r0     // Catch:{ all -> 0x00f8 }
            r10.zzt = r2     // Catch:{ all -> 0x00f8 }
            goto L_0x0048
        L_0x0036:
            r0 = 0
            r10.zzk = r0     // Catch:{ all -> 0x00f8 }
            float r0 = r11.getRawX()     // Catch:{ all -> 0x00f8 }
            double r0 = (double) r0     // Catch:{ all -> 0x00f8 }
            r10.zzs = r0     // Catch:{ all -> 0x00f8 }
            float r0 = r11.getRawY()     // Catch:{ all -> 0x00f8 }
            double r0 = (double) r0     // Catch:{ all -> 0x00f8 }
            r10.zzt = r0     // Catch:{ all -> 0x00f8 }
        L_0x0048:
            int r0 = r11.getAction()     // Catch:{ all -> 0x00f8 }
            r1 = 1
            r2 = 1
            switch(r0) {
                case 0: goto L_0x00d7;
                case 1: goto L_0x00a1;
                case 2: goto L_0x005b;
                case 3: goto L_0x0054;
                default: goto L_0x0052;
            }     // Catch:{ all -> 0x00f8 }
        L_0x0052:
            goto L_0x00f4
        L_0x0054:
            long r4 = r10.zzg     // Catch:{ all -> 0x00f8 }
            long r4 = r4 + r2
            r10.zzg = r4     // Catch:{ all -> 0x00f8 }
            goto L_0x00f4
        L_0x005b:
            long r2 = r10.zze     // Catch:{ all -> 0x00f8 }
            int r0 = r11.getHistorySize()     // Catch:{ all -> 0x00f8 }
            int r0 = r0 + r1
            long r4 = (long) r0     // Catch:{ all -> 0x00f8 }
            long r2 = r2 + r4
            r10.zze = r2     // Catch:{ all -> 0x00f8 }
            com.google.android.gms.internal.ads.zzayg r11 = r10.zzi(r11)     // Catch:{ zzaxu -> 0x009f }
            java.lang.Long r0 = r11.zzd     // Catch:{ zzaxu -> 0x009f }
            if (r0 == 0) goto L_0x0082
            java.lang.Long r2 = r11.zzg     // Catch:{ zzaxu -> 0x009f }
            if (r2 == 0) goto L_0x0082
            long r2 = r10.zzi     // Catch:{ zzaxu -> 0x009f }
            long r4 = r0.longValue()     // Catch:{ zzaxu -> 0x009f }
            java.lang.Long r0 = r11.zzg     // Catch:{ zzaxu -> 0x009f }
            long r6 = r0.longValue()     // Catch:{ zzaxu -> 0x009f }
            long r4 = r4 + r6
            long r2 = r2 + r4
            r10.zzi = r2     // Catch:{ zzaxu -> 0x009f }
        L_0x0082:
            android.util.DisplayMetrics r0 = r10.zzq     // Catch:{ zzaxu -> 0x009f }
            if (r0 == 0) goto L_0x00f4
            java.lang.Long r0 = r11.zze     // Catch:{ zzaxu -> 0x009f }
            if (r0 == 0) goto L_0x00f4
            java.lang.Long r2 = r11.zzh     // Catch:{ zzaxu -> 0x009f }
            if (r2 == 0) goto L_0x00f4
            long r2 = r10.zzj     // Catch:{ zzaxu -> 0x009f }
            long r4 = r0.longValue()     // Catch:{ zzaxu -> 0x009f }
            java.lang.Long r11 = r11.zzh     // Catch:{ zzaxu -> 0x009f }
            long r6 = r11.longValue()     // Catch:{ zzaxu -> 0x009f }
            long r4 = r4 + r6
            long r2 = r2 + r4
            r10.zzj = r2     // Catch:{ zzaxu -> 0x009f }
            goto L_0x00f4
        L_0x009f:
            r11 = move-exception
            goto L_0x00f4
        L_0x00a1:
            android.view.MotionEvent r11 = android.view.MotionEvent.obtain(r11)     // Catch:{ all -> 0x00f8 }
            r10.zzb = r11     // Catch:{ all -> 0x00f8 }
            java.util.LinkedList r11 = r10.zzc     // Catch:{ all -> 0x00f8 }
            android.view.MotionEvent r0 = r10.zzb     // Catch:{ all -> 0x00f8 }
            r11.add(r0)     // Catch:{ all -> 0x00f8 }
            java.util.LinkedList r11 = r10.zzc     // Catch:{ all -> 0x00f8 }
            int r11 = r11.size()     // Catch:{ all -> 0x00f8 }
            r0 = 6
            if (r11 <= r0) goto L_0x00c2
            java.util.LinkedList r11 = r10.zzc     // Catch:{ all -> 0x00f8 }
            java.lang.Object r11 = r11.remove()     // Catch:{ all -> 0x00f8 }
            android.view.MotionEvent r11 = (android.view.MotionEvent) r11     // Catch:{ all -> 0x00f8 }
            r11.recycle()     // Catch:{ all -> 0x00f8 }
        L_0x00c2:
            long r4 = r10.zzf     // Catch:{ all -> 0x00f8 }
            long r4 = r4 + r2
            r10.zzf = r4     // Catch:{ all -> 0x00f8 }
            java.lang.Throwable r11 = new java.lang.Throwable     // Catch:{ zzaxu -> 0x009f }
            r11.<init>()     // Catch:{ zzaxu -> 0x009f }
            java.lang.StackTraceElement[] r11 = r11.getStackTrace()     // Catch:{ zzaxu -> 0x009f }
            long r2 = r10.zza(r11)     // Catch:{ zzaxu -> 0x009f }
            r10.zzh = r2     // Catch:{ zzaxu -> 0x009f }
            goto L_0x00f4
        L_0x00d7:
            float r0 = r11.getX()     // Catch:{ all -> 0x00f8 }
            r10.zzl = r0     // Catch:{ all -> 0x00f8 }
            float r0 = r11.getY()     // Catch:{ all -> 0x00f8 }
            r10.zzm = r0     // Catch:{ all -> 0x00f8 }
            float r0 = r11.getRawX()     // Catch:{ all -> 0x00f8 }
            r10.zzn = r0     // Catch:{ all -> 0x00f8 }
            float r11 = r11.getRawY()     // Catch:{ all -> 0x00f8 }
            r10.zzo = r11     // Catch:{ all -> 0x00f8 }
            long r4 = r10.zzd     // Catch:{ all -> 0x00f8 }
            long r4 = r4 + r2
            r10.zzd = r4     // Catch:{ all -> 0x00f8 }
        L_0x00f4:
            r10.zzp = r1     // Catch:{ all -> 0x00f8 }
            monitor-exit(r10)
            return
        L_0x00f8:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxa.zzk(android.view.MotionEvent):void");
    }

    public final synchronized void zzl(int i, int i2, int i3) {
        synchronized (this) {
            if (this.zzb != null) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzcx)).booleanValue()) {
                    zzj();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                this.zzb = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * displayMetrics.density, ((float) i2) * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        }
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaxw zzaxw;
        if (((Boolean) zzba.zzc().zza(zzbep.zzcH)).booleanValue() && (zzaxw = this.zzr) != null) {
            zzaxw.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public void zzo(View view) {
    }
}
