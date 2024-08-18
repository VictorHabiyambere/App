package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcbz {
    long zza = -1;
    long zzb = -1;
    int zzc = -1;
    int zzd = -1;
    long zze = 0;
    final String zzf;
    int zzg = 0;
    int zzh = 0;
    int zzi = 0;
    private final Object zzj = new Object();
    private final zzg zzk;

    public zzcbz(String str, zzg zzg2) {
        this.zzf = str;
        this.zzk = zzg2;
    }

    private final void zzi() {
        if (((Boolean) zzbgr.zza.zze()).booleanValue()) {
            synchronized (this.zzj) {
                this.zzc--;
                this.zzd--;
            }
        }
    }

    public final int zza() {
        int i;
        synchronized (this.zzj) {
            i = this.zzi;
        }
        return i;
    }

    public final Bundle zzb(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzj) {
            bundle = new Bundle();
            if (!this.zzk.zzS()) {
                bundle.putString("session_id", this.zzf);
            }
            bundle.putLong("basets", this.zzb);
            bundle.putLong("currts", this.zza);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzc);
            bundle.putInt("preqs_in_session", this.zzd);
            bundle.putLong("time_in_session", this.zze);
            bundle.putInt("pclick", this.zzg);
            bundle.putInt("pimp", this.zzh);
            Context zza2 = zzbyf.zza(context);
            int identifier = zza2.getResources().getIdentifier("Theme.Translucent", "style", "android");
            boolean z = false;
            if (identifier == 0) {
                zzm.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            } else {
                try {
                    if (identifier == zza2.getPackageManager().getActivityInfo(new ComponentName(zza2.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                        z = true;
                    } else {
                        zzm.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    zzm.zzj("Fail to fetch AdActivity theme");
                    zzm.zzi("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                }
            }
            bundle.putBoolean("support_transparent_background", z);
            bundle.putInt("consent_form_action_identifier", zza());
        }
        return bundle;
    }

    public final void zzc() {
        synchronized (this.zzj) {
            this.zzg++;
        }
    }

    public final void zzd() {
        synchronized (this.zzj) {
            this.zzh++;
        }
    }

    public final void zze() {
        zzi();
    }

    public final void zzf() {
        zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(com.google.android.gms.ads.internal.client.zzl r10, long r11) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zzj
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzg r1 = r9.zzk     // Catch:{ all -> 0x0085 }
            long r1 = r1.zzd()     // Catch:{ all -> 0x0085 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x0085 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0085 }
            long r5 = r9.zzb     // Catch:{ all -> 0x0085 }
            r7 = -1
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0040
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzaU     // Catch:{ all -> 0x0085 }
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0085 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ all -> 0x0085 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0085 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0085 }
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0033
            r1 = -1
            r9.zzd = r1     // Catch:{ all -> 0x0085 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzg r1 = r9.zzk     // Catch:{ all -> 0x0085 }
            int r1 = r1.zzc()     // Catch:{ all -> 0x0085 }
            r9.zzd = r1     // Catch:{ all -> 0x0085 }
        L_0x003b:
            r9.zzb = r11     // Catch:{ all -> 0x0085 }
            r9.zza = r11     // Catch:{ all -> 0x0085 }
            goto L_0x0042
        L_0x0040:
            r9.zza = r11     // Catch:{ all -> 0x0085 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzbeg r11 = com.google.android.gms.internal.ads.zzbep.zzdB     // Catch:{ all -> 0x0085 }
            com.google.android.gms.internal.ads.zzben r12 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0085 }
            java.lang.Object r11 = r12.zza(r11)     // Catch:{ all -> 0x0085 }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0085 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0085 }
            r12 = 1
            if (r11 != 0) goto L_0x0064
            android.os.Bundle r10 = r10.zzc     // Catch:{ all -> 0x0085 }
            if (r10 == 0) goto L_0x0064
            java.lang.String r11 = "gw"
            r1 = 2
            int r10 = r10.getInt(r11, r1)     // Catch:{ all -> 0x0085 }
            if (r10 != r12) goto L_0x0064
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            return
        L_0x0064:
            int r10 = r9.zzc     // Catch:{ all -> 0x0085 }
            int r10 = r10 + r12
            r9.zzc = r10     // Catch:{ all -> 0x0085 }
            int r10 = r9.zzd     // Catch:{ all -> 0x0085 }
            int r10 = r10 + r12
            r9.zzd = r10     // Catch:{ all -> 0x0085 }
            if (r10 != 0) goto L_0x007a
            r10 = 0
            r9.zze = r10     // Catch:{ all -> 0x0085 }
            com.google.android.gms.ads.internal.util.zzg r10 = r9.zzk     // Catch:{ all -> 0x0085 }
            r10.zzE(r3)     // Catch:{ all -> 0x0085 }
            goto L_0x0083
        L_0x007a:
            com.google.android.gms.ads.internal.util.zzg r10 = r9.zzk     // Catch:{ all -> 0x0085 }
            long r10 = r10.zze()     // Catch:{ all -> 0x0085 }
            long r3 = r3 - r10
            r9.zze = r3     // Catch:{ all -> 0x0085 }
        L_0x0083:
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            return
        L_0x0085:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0085 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbz.zzg(com.google.android.gms.ads.internal.client.zzl, long):void");
    }

    public final void zzh() {
        synchronized (this.zzj) {
            this.zzi++;
        }
    }
}
