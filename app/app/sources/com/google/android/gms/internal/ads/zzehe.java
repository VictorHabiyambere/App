package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzehe {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzfgt zzc;
    private final zzchd zzd;
    private zzfou zze;

    zzehe(Context context, VersionInfoParcel versionInfoParcel, zzfgt zzfgt, zzchd zzchd) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfgt;
        this.zzd = zzchd;
    }

    public final synchronized void zza(View view) {
        zzfou zzfou = this.zze;
        if (zzfou != null) {
            zzu.zzA().zzh(zzfou, view);
        }
    }

    public final synchronized void zzb() {
        zzchd zzchd;
        if (!(this.zze == null || (zzchd = this.zzd) == null)) {
            zzchd.zzd("onSdkImpression", zzgbf.zzd());
        }
    }

    public final synchronized void zzc() {
        zzchd zzchd;
        zzfou zzfou = this.zze;
        if (!(zzfou == null || (zzchd = this.zzd) == null)) {
            for (View zzh : zzchd.zzV()) {
                zzu.zzA().zzh(zzfou, zzh);
            }
            this.zzd.zzd("onSdkLoaded", zzgbf.zzd());
        }
    }

    public final synchronized boolean zzd() {
        return this.zze != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0082, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzfgt r5 = r4.zzc     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.zzU     // Catch:{ all -> 0x0083 }
            r0 = 0
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzeZ     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0083 }
            java.lang.Object r5 = r1.zza(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzfc     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0083 }
            java.lang.Object r5 = r1.zza(r5)     // Catch:{ all -> 0x0083 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzchd r5 = r4.zzd     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x0031
            goto L_0x0081
        L_0x0031:
            com.google.android.gms.internal.ads.zzfou r5 = r4.zze     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x003c
            java.lang.String r5 = "Omid javascript session service already started for ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x003c:
            android.content.Context r5 = r4.zza     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzehb r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x0083 }
            boolean r5 = r1.zzl(r5)     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x004f
            java.lang.String r5 = "Unable to initialize omid."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x004f:
            com.google.android.gms.internal.ads.zzfgt r5 = r4.zzc     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzfhr r5 = r5.zzW     // Catch:{ all -> 0x0083 }
            boolean r5 = r5.zzb()     // Catch:{ all -> 0x0083 }
            if (r5 == 0) goto L_0x0081
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r4.zzb     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzchd r1 = r4.zzd     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzehb r2 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x0083 }
            android.webkit.WebView r1 = r1.zzG()     // Catch:{ all -> 0x0083 }
            r3 = 1
            com.google.android.gms.internal.ads.zzfou r5 = r2.zze(r5, r1, r3)     // Catch:{ all -> 0x0083 }
            if (r5 != 0) goto L_0x0073
            java.lang.String r5 = "Unable to create javascript session service."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r0
        L_0x0073:
            java.lang.String r0 = "Created omid javascript session service."
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r0)     // Catch:{ all -> 0x0083 }
            r4.zze = r5     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzchd r5 = r4.zzd     // Catch:{ all -> 0x0083 }
            r5.zzas(r4)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)
            return r3
        L_0x0081:
            monitor-exit(r4)
            return r0
        L_0x0083:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehe.zze(boolean):boolean");
    }

    public final synchronized void zzf(zzchs zzchs) {
        zzfou zzfou = this.zze;
        if (!(zzfou == null || this.zzd == null)) {
            zzu.zzA().zzm(zzfou, zzchs);
            this.zze = null;
            this.zzd.zzas((zzehe) null);
        }
    }
}
