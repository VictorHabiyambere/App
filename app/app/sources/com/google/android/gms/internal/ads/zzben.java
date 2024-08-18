package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzben implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzber.zza(new zzbek(sharedPreferences)));
            } catch (JSONException e) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zza(zzbeg zzbeg) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null) {
                    if (this.zzj) {
                    }
                }
                Object zzm = zzbeg.zzm();
                return zzm;
            }
        }
        if (zzbeg.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbeg.zzm();
            }
            return zzbeg.zzb(bundle);
        } else if (zzbeg.zze() != 1 || !this.zzh.has(zzbeg.zzn())) {
            return zzber.zza(new zzbel(this, zzbeg));
        } else {
            return zzbeg.zza(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzbeg zzbeg) {
        return zzbeg.zzc(this.zze);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011f, code lost:
        if (new org.json.JSONObject((java.lang.String) com.google.android.gms.internal.ads.zzber.zza(new com.google.android.gms.internal.ads.zzbej(r3))).optBoolean("local_flags_enabled") != false) goto L_0x0121;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ all -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[Catch:{ all -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068 A[Catch:{ all -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009d A[Catch:{ all -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00aa A[SYNTHETIC, Splitter:B:45:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0127 A[SYNTHETIC, Splitter:B:73:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0130 A[SYNTHETIC, Splitter:B:77:0x0130] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Context r11) {
        /*
            r10 = this;
            boolean r0 = r10.zzd
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r10.zzb
            monitor-enter(r0)
            boolean r1 = r10.zzd     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            return
        L_0x000e:
            boolean r1 = r10.zza     // Catch:{ all -> 0x0167 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r10.zza = r2     // Catch:{ all -> 0x0167 }
        L_0x0015:
            java.lang.String r1 = r11.getPackageName()     // Catch:{ all -> 0x0167 }
            java.lang.String r3 = "com.google.android.gms"
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch:{ all -> 0x0167 }
            r10.zzi = r1     // Catch:{ all -> 0x0167 }
            android.content.Context r1 = r11.getApplicationContext()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x002b
            android.content.Context r11 = r11.getApplicationContext()     // Catch:{ all -> 0x0167 }
        L_0x002b:
            r10.zzg = r11     // Catch:{ all -> 0x0167 }
            android.content.Context r11 = r10.zzg     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r11 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r11)     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            android.content.Context r1 = r10.zzg     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r11 = r11.getApplicationInfo(r1, r3)     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            android.os.Bundle r11 = r11.metaData     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            r10.zzf = r11     // Catch:{ NameNotFoundException -> 0x0046, NullPointerException -> 0x0044 }
            goto L_0x0047
        L_0x0044:
            r11 = move-exception
            goto L_0x0047
        L_0x0046:
            r11 = move-exception
        L_0x0047:
            r11 = 0
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x015e }
            android.content.Context r3 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r1)     // Catch:{ all -> 0x015e }
            if (r3 != 0) goto L_0x0059
            if (r1 == 0) goto L_0x0059
            android.content.Context r3 = r1.getApplicationContext()     // Catch:{ all -> 0x015e }
            if (r3 == 0) goto L_0x005b
            goto L_0x005a
        L_0x0059:
        L_0x005a:
            r1 = r3
        L_0x005b:
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x015e }
            android.content.SharedPreferences r3 = com.google.android.gms.internal.ads.zzbei.zza(r1)     // Catch:{ all -> 0x015e }
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            if (r3 == 0) goto L_0x0070
            com.google.android.gms.internal.ads.zzbem r4 = new com.google.android.gms.internal.ads.zzbem     // Catch:{ all -> 0x015e }
            r4.<init>(r10, r3)     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzbhb.zzc(r4)     // Catch:{ all -> 0x015e }
        L_0x0070:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x015e }
            r4 = 0
            if (r3 != 0) goto L_0x00aa
            com.google.android.gms.internal.ads.zzbfv r3 = com.google.android.gms.internal.ads.zzbgc.zzd     // Catch:{ all -> 0x015e }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x015e }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x015e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x015e }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00aa
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x015e }
            int r3 = com.google.android.gms.internal.ads.zzbdz.zza(r3)     // Catch:{ all -> 0x015e }
            long r6 = (long) r3     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzbfv r3 = com.google.android.gms.internal.ads.zzbgc.zzd     // Catch:{ all -> 0x015e }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x015e }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x015e }
            long r8 = r3.longValue()     // Catch:{ all -> 0x015e }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x00aa
            r10.zzj = r2     // Catch:{ all -> 0x015e }
            r10.zzd = r2     // Catch:{ all -> 0x015e }
            r10.zza = r11     // Catch:{ all -> 0x0167 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0167 }
            r11.open()     // Catch:{ all -> 0x0167 }
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            return
        L_0x00aa:
            boolean r3 = r10.zzi     // Catch:{ all -> 0x015e }
            if (r3 != 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzbfv r3 = com.google.android.gms.internal.ads.zzbgc.zzf     // Catch:{ all -> 0x015e }
            java.lang.Object r3 = r3.zze()     // Catch:{ all -> 0x015e }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x015e }
            long r6 = r3.longValue()     // Catch:{ all -> 0x015e }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e2
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x015e }
            int r3 = com.google.android.gms.internal.ads.zzbdz.zzb(r3)     // Catch:{ all -> 0x015e }
            long r3 = (long) r3     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzbfv r5 = com.google.android.gms.internal.ads.zzbgc.zzf     // Catch:{ all -> 0x015e }
            java.lang.Object r5 = r5.zze()     // Catch:{ all -> 0x015e }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x015e }
            long r5 = r5.longValue()     // Catch:{ all -> 0x015e }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x00e2
            r10.zzj = r2     // Catch:{ all -> 0x015e }
            r10.zzd = r2     // Catch:{ all -> 0x015e }
            r10.zza = r11     // Catch:{ all -> 0x0167 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0167 }
            r11.open()     // Catch:{ all -> 0x0167 }
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            return
        L_0x00e2:
            android.content.Context r3 = r10.zzg     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzbfv r4 = com.google.android.gms.internal.ads.zzbgk.zzh     // Catch:{ all -> 0x015e }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x015e }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x015e }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x015e }
            if (r4 == 0) goto L_0x00f3
            goto L_0x0121
        L_0x00f3:
            com.google.android.gms.internal.ads.zzbfv r4 = com.google.android.gms.internal.ads.zzbgk.zzi     // Catch:{ all -> 0x015e }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x015e }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x015e }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x015e }
            if (r4 == 0) goto L_0x0125
            java.lang.String r4 = "admob"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r11)     // Catch:{ all -> 0x015e }
            if (r3 == 0) goto L_0x0125
            com.google.android.gms.internal.ads.zzbej r4 = new com.google.android.gms.internal.ads.zzbej     // Catch:{ all -> 0x015e }
            r4.<init>(r3)     // Catch:{ all -> 0x015e }
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzber.zza(r4)     // Catch:{ all -> 0x015e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x015e }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0124 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0124 }
            java.lang.String r3 = "local_flags_enabled"
            boolean r3 = r4.optBoolean(r3)     // Catch:{ JSONException -> 0x0124 }
            if (r3 == 0) goto L_0x0125
        L_0x0121:
            android.content.Context r1 = r10.zzg     // Catch:{ all -> 0x015e }
            goto L_0x0125
        L_0x0124:
            r3 = move-exception
        L_0x0125:
            if (r1 != 0) goto L_0x0130
            r10.zza = r11     // Catch:{ all -> 0x0167 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0167 }
            r11.open()     // Catch:{ all -> 0x0167 }
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            return
        L_0x0130:
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x015e }
            android.content.SharedPreferences r1 = com.google.android.gms.internal.ads.zzbei.zza(r1)     // Catch:{ all -> 0x015e }
            r10.zze = r1     // Catch:{ all -> 0x015e }
            com.google.android.gms.internal.ads.zzbfv r1 = com.google.android.gms.internal.ads.zzbgk.zza     // Catch:{ all -> 0x015e }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x015e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x015e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x015e }
            if (r1 != 0) goto L_0x014e
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x015e }
            if (r1 == 0) goto L_0x014e
            r1.registerOnSharedPreferenceChangeListener(r10)     // Catch:{ all -> 0x015e }
        L_0x014e:
            android.content.SharedPreferences r1 = r10.zze     // Catch:{ all -> 0x015e }
            r10.zzg(r1)     // Catch:{ all -> 0x015e }
            r10.zzd = r2     // Catch:{ all -> 0x015e }
            r10.zza = r11     // Catch:{ all -> 0x0167 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0167 }
            r11.open()     // Catch:{ all -> 0x0167 }
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            return
        L_0x015e:
            r1 = move-exception
            r10.zza = r11     // Catch:{ all -> 0x0167 }
            android.os.ConditionVariable r11 = r10.zzc     // Catch:{ all -> 0x0167 }
            r11.open()     // Catch:{ all -> 0x0167 }
            throw r1     // Catch:{ all -> 0x0167 }
        L_0x0167:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0167 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzben.zzd(android.content.Context):void");
    }

    public final boolean zze() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return this.zzi;
    }

    public final Object zzb(zzbeg zzbeg) {
        if (this.zzd || this.zza) {
            return zza(zzbeg);
        }
        return zzbeg.zzm();
    }
}
