package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcuc implements zzdaz, zzdaf {
    private final Context zza;
    private final zzchd zzb;
    private final zzfgt zzc;
    private final VersionInfoParcel zzd;
    private zzehg zze;
    private boolean zzf;
    private final zzehe zzg;

    public zzcuc(Context context, zzchd zzchd, zzfgt zzfgt, VersionInfoParcel versionInfoParcel, zzehe zzehe) {
        this.zza = context;
        this.zzb = zzchd;
        this.zzc = zzfgt;
        this.zzd = versionInfoParcel;
        this.zzg = zzehe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza() {
        /*
            r12 = this;
            monitor-enter(r12)
            com.google.android.gms.internal.ads.zzfgt r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            goto L_0x00e0
        L_0x0009:
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x0007
            android.content.Context r0 = r12.zza     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehb r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            boolean r0 = r1.zzl(r0)     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x0007
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r12.zzd     // Catch:{ all -> 0x00e2 }
            int r1 = r0.buddyApkVersion     // Catch:{ all -> 0x00e2 }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r2.<init>()     // Catch:{ all -> 0x00e2 }
            r2.append(r1)     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ all -> 0x00e2 }
            r2.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzfgt r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzfhr r0 = r0.zzW     // Catch:{ all -> 0x00e2 }
            java.lang.String r8 = r0.zza()     // Catch:{ all -> 0x00e2 }
            int r0 = r0.zzc()     // Catch:{ all -> 0x00e2 }
            r1 = 1
            if (r0 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzehc r0 = com.google.android.gms.internal.ads.zzehc.VIDEO     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehd r2 = com.google.android.gms.internal.ads.zzehd.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00e2 }
            r10 = r0
            r9 = r2
            goto L_0x005a
        L_0x0049:
            com.google.android.gms.internal.ads.zzfgt r0 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehc r2 = com.google.android.gms.internal.ads.zzehc.HTML_DISPLAY     // Catch:{ all -> 0x00e2 }
            int r0 = r0.zzf     // Catch:{ all -> 0x00e2 }
            if (r0 != r1) goto L_0x0056
            com.google.android.gms.internal.ads.zzehd r0 = com.google.android.gms.internal.ads.zzehd.ONE_PIXEL     // Catch:{ all -> 0x00e2 }
            r9 = r0
            r10 = r2
            goto L_0x005a
        L_0x0056:
            com.google.android.gms.internal.ads.zzehd r0 = com.google.android.gms.internal.ads.zzehd.BEGIN_TO_RENDER     // Catch:{ all -> 0x00e2 }
            r9 = r0
            r10 = r2
        L_0x005a:
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzfgt r2 = r12.zzc     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehb r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00e2 }
            java.lang.String r11 = r2.zzam     // Catch:{ all -> 0x00e2 }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.internal.ads.zzehg r0 = r3.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00e2 }
            r12.zze = r0     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehg r2 = r12.zze     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzfoj r2 = r2.zza()     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzfb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00e2 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00b9
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehb r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            android.webkit.WebView r0 = r0.zzG()     // Catch:{ all -> 0x00e2 }
            r3.zzj(r2, r0)     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            java.util.List r0 = r0.zzV()     // Catch:{ all -> 0x00e2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00e2 }
        L_0x00a5:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00e2 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehb r4 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            r4.zzg(r2, r3)     // Catch:{ all -> 0x00e2 }
            goto L_0x00a5
        L_0x00b9:
            com.google.android.gms.internal.ads.zzehb r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00e2 }
            r3.zzj(r2, r0)     // Catch:{ all -> 0x00e2 }
        L_0x00c2:
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehg r3 = r12.zze     // Catch:{ all -> 0x00e2 }
            r0.zzat(r3)     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzehb r0 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00e2 }
            r0.zzk(r2)     // Catch:{ all -> 0x00e2 }
            r12.zzf = r1     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzchd r0 = r12.zzb     // Catch:{ all -> 0x00e2 }
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00e2 }
            r1.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = "onSdkLoaded"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x00e2 }
            monitor-exit(r12)
            return
        L_0x00e0:
            monitor-exit(r12)
            return
        L_0x00e2:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcuc.zza():void");
    }

    private final boolean zzb() {
        return ((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() && this.zzg.zzd();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzb()     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzehe r0 = r3.zzg     // Catch:{ all -> 0x002f }
            r0.zzb()     // Catch:{ all -> 0x002f }
            monitor-exit(r3)
            return
        L_0x000e:
            boolean r0 = r3.zzf     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0015
            r3.zza()     // Catch:{ all -> 0x002f }
        L_0x0015:
            com.google.android.gms.internal.ads.zzfgt r0 = r3.zzc     // Catch:{ all -> 0x002f }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzehg r0 = r3.zze     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzchd r0 = r3.zzb     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x002f }
            r1.<init>()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcuc.zzr():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzs() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzb()     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzehe r0 = r1.zzg     // Catch:{ all -> 0x0018 }
            r0.zzc()     // Catch:{ all -> 0x0018 }
        L_0x000c:
            monitor-exit(r1)
            return
        L_0x000e:
            boolean r0 = r1.zzf     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0013
            goto L_0x000c
        L_0x0013:
            r1.zza()     // Catch:{ all -> 0x0018 }
            monitor-exit(r1)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcuc.zzs():void");
    }
}
