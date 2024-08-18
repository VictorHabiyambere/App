package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcag implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private String zzd = "-1";
    private int zze = -1;

    zzcag(Context context, zzg zzg) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
    }

    private final void zzb() {
        this.zzc.zzI(true);
        zzad.zzc(this.zza);
    }

    private final void zzc(String str, int i) {
        Context context;
        boolean z = false;
        if (((Boolean) zzba.zzc().zza(zzbep.zzax)).booleanValue()) {
            if (i == 0 || str.isEmpty()) {
                z = true;
            } else if (str.charAt(0) != '1' && !str.equals("-1")) {
                z = true;
            }
        } else if (str.isEmpty() || str.charAt(0) != '1') {
            z = true;
        }
        this.zzc.zzI(z);
        if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "IABTCF_PurposeConsents"
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzaz     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b3 }
            java.lang.Object r1 = r2.zza(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00b3 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = "-1"
            r3 = -1
            java.lang.String r4 = "gad_has_consent_for_cookies"
            if (r1 == 0) goto L_0x0055
            boolean r0 = java.util.Objects.equals(r8, r4)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0034
            int r7 = r7.getInt(r4, r3)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.ads.internal.util.zzg r8 = r6.zzc     // Catch:{ all -> 0x00b3 }
            int r8 = r8.zzb()     // Catch:{ all -> 0x00b3 }
            if (r7 == r8) goto L_0x002e
            r6.zzb()     // Catch:{ all -> 0x00b3 }
        L_0x002e:
            com.google.android.gms.ads.internal.util.zzg r8 = r6.zzc     // Catch:{ all -> 0x00b3 }
            r8.zzF(r7)     // Catch:{ all -> 0x00b3 }
            return
        L_0x0034:
            java.lang.String r0 = "IABTCF_TCString"
            boolean r0 = java.util.Objects.equals(r8, r0)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x00b2
            java.lang.String r7 = r7.getString(r8, r2)     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.ads.internal.util.zzg r8 = r6.zzc     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = r8.zzp()     // Catch:{ all -> 0x00b3 }
            boolean r8 = java.util.Objects.equals(r7, r8)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x004f
            r6.zzb()     // Catch:{ all -> 0x00b3 }
        L_0x004f:
            com.google.android.gms.ads.internal.util.zzg r8 = r6.zzc     // Catch:{ all -> 0x00b3 }
            r8.zzO(r7)     // Catch:{ all -> 0x00b3 }
            return
        L_0x0055:
            java.lang.String r1 = r7.getString(r0, r2)     // Catch:{ all -> 0x00b3 }
            int r7 = r7.getInt(r4, r3)     // Catch:{ all -> 0x00b3 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00b3 }
            int r5 = r8.hashCode()     // Catch:{ all -> 0x00b3 }
            switch(r5) {
                case -2004976699: goto L_0x0073;
                case -527267622: goto L_0x006a;
                default: goto L_0x0069;
            }
        L_0x0069:
            goto L_0x007b
        L_0x006a:
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L_0x0069
            r8 = 1
            goto L_0x007c
        L_0x0073:
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0069
            r8 = 0
            goto L_0x007c
        L_0x007b:
            r8 = r3
        L_0x007c:
            switch(r8) {
                case 0: goto L_0x009e;
                case 1: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x00b2
        L_0x0080:
            com.google.android.gms.internal.ads.zzbeg r8 = com.google.android.gms.internal.ads.zzbep.zzax     // Catch:{ all -> 0x00b3 }
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b3 }
            java.lang.Object r8 = r0.zza(r8)     // Catch:{ all -> 0x00b3 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00b3 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00b3 }
            if (r8 == 0) goto L_0x00b2
            if (r7 == r3) goto L_0x00b2
            int r8 = r6.zze     // Catch:{ all -> 0x00b3 }
            if (r8 == r7) goto L_0x00b2
            r6.zze = r7     // Catch:{ all -> 0x00b3 }
            r6.zzc(r1, r7)     // Catch:{ all -> 0x00b3 }
            return
        L_0x009e:
            boolean r8 = r1.equals(r2)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x00b2
            java.lang.String r8 = r6.zzd     // Catch:{ all -> 0x00b3 }
            boolean r8 = r8.equals(r1)     // Catch:{ all -> 0x00b3 }
            if (r8 != 0) goto L_0x00b2
            r6.zzd = r1     // Catch:{ all -> 0x00b3 }
            r6.zzc(r1, r7)     // Catch:{ all -> 0x00b3 }
            return
        L_0x00b2:
            return
        L_0x00b3:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzcby r8 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r0 = "AdMobPlusIdlessListener.onSharedPreferenceChanged"
            r8.zzw(r7, r0)
            java.lang.String r8 = "onSharedPreferenceChanged, errorMessage = "
            com.google.android.gms.ads.internal.util.zze.zzb(r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcag.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (((Boolean) zzba.zzc().zza(zzbep.zzaz)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
        } else {
            onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
        }
    }
}
