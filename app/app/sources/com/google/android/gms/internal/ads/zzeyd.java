package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeyd implements zzexw {
    private final zzgge zza;
    private final Context zzb;

    public zzeyd(zzgge zzgge, Context context) {
        this.zza = zzgge;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    public final int zza() {
        return 38;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeyc(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeyb zzc() throws java.lang.Exception {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "com.google.unity.ads.UNITY_VERSION"
            android.content.Context r0 = r1.zzb
            android.content.pm.PackageManager r3 = r0.getPackageManager()
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r4 = "geo:0,0?q=donuts"
            android.content.pm.ResolveInfo r4 = zzd(r3, r4)
            java.lang.String r5 = "http://www.google.com"
            android.content.pm.ResolveInfo r5 = zzd(r3, r5)
            java.lang.String r9 = r0.getCountry()
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.client.zzay.zzb()
            boolean r10 = com.google.android.gms.ads.internal.util.client.zzf.zzs()
            android.content.Context r6 = r1.zzb
            boolean r11 = com.google.android.gms.common.util.DeviceProperties.isLatchsky(r6)
            boolean r12 = com.google.android.gms.common.util.DeviceProperties.isSidewinder(r6)
            java.lang.String r13 = r0.getLanguage()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            android.os.LocaleList r0 = android.os.LocaleList.getDefault()
            r6 = 0
            r7 = r6
        L_0x0041:
            int r8 = r0.size()
            if (r7 >= r8) goto L_0x0055
            java.util.Locale r8 = r0.get(r7)
            java.lang.String r8 = r8.getLanguage()
            r14.add(r8)
            int r7 = r7 + 1
            goto L_0x0041
        L_0x0055:
            android.content.Context r0 = r1.zzb
            java.lang.String r7 = "market://details?id=com.google.android.gms.ads"
            android.content.pm.ResolveInfo r7 = zzd(r3, r7)
            java.lang.String r8 = "."
            if (r7 != 0) goto L_0x0063
            r15 = 0
            goto L_0x008f
        L_0x0063:
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            if (r7 != 0) goto L_0x0069
            r15 = 0
            goto L_0x008f
        L_0x0069:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x008d }
            java.lang.String r15 = r7.packageName     // Catch:{ NameNotFoundException -> 0x008d }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r15, r6)     // Catch:{ NameNotFoundException -> 0x008d }
            if (r0 == 0) goto L_0x008e
            int r0 = r0.versionCode     // Catch:{ NameNotFoundException -> 0x008d }
            java.lang.String r7 = r7.packageName     // Catch:{ NameNotFoundException -> 0x008d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x008d }
            r15.<init>()     // Catch:{ NameNotFoundException -> 0x008d }
            r15.append(r0)     // Catch:{ NameNotFoundException -> 0x008d }
            r15.append(r8)     // Catch:{ NameNotFoundException -> 0x008d }
            r15.append(r7)     // Catch:{ NameNotFoundException -> 0x008d }
            java.lang.String r0 = r15.toString()     // Catch:{ NameNotFoundException -> 0x008d }
            r15 = r0
            goto L_0x008f
        L_0x008d:
            r0 = move-exception
        L_0x008e:
            r15 = 0
        L_0x008f:
            android.content.Context r0 = r1.zzb
            r7 = 128(0x80, float:1.794E-43)
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r6 = "com.android.vending"
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r6, r7)     // Catch:{ Exception -> 0x00bb }
            if (r0 == 0) goto L_0x00b8
            int r6 = r0.versionCode     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = r0.packageName     // Catch:{ Exception -> 0x00bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bb }
            r7.<init>()     // Catch:{ Exception -> 0x00bb }
            r7.append(r6)     // Catch:{ Exception -> 0x00bb }
            r7.append(r8)     // Catch:{ Exception -> 0x00bb }
            r7.append(r0)     // Catch:{ Exception -> 0x00bb }
            java.lang.String r0 = r7.toString()     // Catch:{ Exception -> 0x00bb }
            r20 = r0
            goto L_0x00be
        L_0x00b8:
            r20 = 0
            goto L_0x00be
        L_0x00bb:
            r0 = move-exception
            r20 = 0
        L_0x00be:
            android.content.Context r0 = r1.zzb
            java.lang.String r21 = android.os.Build.FINGERPRINT
            if (r3 != 0) goto L_0x00c6
            r3 = 0
            goto L_0x0113
        L_0x00c6:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r7 = "http://www.example.com"
            android.net.Uri r7 = android.net.Uri.parse(r7)
            java.lang.String r8 = "android.intent.action.VIEW"
            r6.<init>(r8, r7)
            r7 = 0
            android.content.pm.ResolveInfo r8 = r3.resolveActivity(r6, r7)
            r7 = 65536(0x10000, float:9.18355E-41)
            java.util.List r3 = r3.queryIntentActivities(r6, r7)
            if (r3 == 0) goto L_0x0112
            if (r8 == 0) goto L_0x0112
            r6 = 0
        L_0x00e3:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0112
            java.lang.Object r7 = r3.get(r6)
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            r19 = r3
            android.content.pm.ActivityInfo r3 = r8.activityInfo
            java.lang.String r3 = r3.name
            android.content.pm.ActivityInfo r7 = r7.activityInfo
            java.lang.String r7 = r7.name
            boolean r3 = r3.equals(r7)
            if (r3 == 0) goto L_0x010d
            android.content.pm.ActivityInfo r3 = r8.activityInfo
            java.lang.String r3 = r3.packageName
            java.lang.String r0 = com.google.android.gms.internal.ads.zzhlh.zza(r0)
            boolean r0 = r3.equals(r0)
            r3 = r0
            goto L_0x0113
        L_0x010d:
            int r6 = r6 + 1
            r3 = r19
            goto L_0x00e3
        L_0x0112:
            r3 = 0
        L_0x0113:
            com.google.android.gms.ads.internal.zzu.zzp()
            android.os.StatFs r0 = new android.os.StatFs
            java.io.File r6 = android.os.Environment.getDataDirectory()
            java.lang.String r6 = r6.getAbsolutePath()
            r0.<init>(r6)
            long r6 = r0.getAvailableBytes()
            r22 = 1024(0x400, double:5.06E-321)
            long r22 = r6 / r22
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlq
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r6.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r6 = 1
            if (r0 == 0) goto L_0x014c
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r0 = r1.zzb
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzB(r0)
            if (r0 == 0) goto L_0x014c
            r25 = r6
            goto L_0x014e
        L_0x014c:
            r25 = 0
        L_0x014e:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlu
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r7.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0184
            android.content.Context r0 = r1.zzb
            com.google.android.gms.common.wrappers.PackageManagerWrapper r7 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0181 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x0181 }
            r8 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo(r0, r8)     // Catch:{ NameNotFoundException -> 0x0181 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ NameNotFoundException -> 0x0181 }
            if (r0 == 0) goto L_0x017f
            boolean r7 = r0.containsKey(r2)     // Catch:{ NameNotFoundException -> 0x0181 }
            if (r7 == 0) goto L_0x017f
            java.lang.String r0 = r0.getString(r2)     // Catch:{ NameNotFoundException -> 0x0181 }
            goto L_0x0186
        L_0x017f:
            r0 = 0
            goto L_0x0186
        L_0x0181:
            r0 = move-exception
            r0 = 0
            goto L_0x0186
        L_0x0184:
            java.lang.String r0 = ""
        L_0x0186:
            if (r5 == 0) goto L_0x018a
            r8 = r6
            goto L_0x018b
        L_0x018a:
            r8 = 0
        L_0x018b:
            if (r4 == 0) goto L_0x018f
            r7 = r6
            goto L_0x0190
        L_0x018f:
            r7 = 0
        L_0x0190:
            com.google.android.gms.internal.ads.zzeyb r2 = new com.google.android.gms.internal.ads.zzeyb
            r6 = r2
            java.lang.String r19 = android.os.Build.MODEL
            int r24 = android.os.Build.VERSION.SDK_INT
            r16 = r20
            r17 = r21
            r18 = r3
            r20 = r22
            r22 = r25
            r23 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, r23, r24)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyd.zzc():com.google.android.gms.internal.ads.zzeyb");
    }
}
