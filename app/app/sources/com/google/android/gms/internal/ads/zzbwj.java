package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.core.os.EnvironmentCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbwj implements zzbwl {
    public static zzbwl zza = null;
    static zzbwl zzb = null;
    static zzbwl zzc = null;
    static Boolean zzd = null;
    private static final Object zze = new Object();
    private final Object zzf;
    private final Context zzg;
    private final WeakHashMap zzh;
    private final ExecutorService zzi;
    private final VersionInfoParcel zzj;
    private final PackageInfo zzk;
    private final String zzl;
    private final String zzm;
    private final AtomicBoolean zzn;
    private boolean zzo;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected zzbwj(android.content.Context r3, com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.zzf = r0
            java.util.WeakHashMap r0 = new java.util.WeakHashMap
            r0.<init>()
            r2.zzh = r0
            com.google.android.gms.internal.ads.zzfuu.zza()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.unconfigurableExecutorService(r0)
            r2.zzi = r0
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean
            r0.<init>()
            r2.zzn = r0
            android.content.Context r0 = r3.getApplicationContext()
            if (r0 == 0) goto L_0x002f
            android.content.Context r3 = r3.getApplicationContext()
        L_0x002f:
            r2.zzg = r3
            r2.zzj = r4
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzhS
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r4.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r4 = 0
            if (r3 == 0) goto L_0x0065
            android.content.Context r3 = r2.zzg
            android.os.Handler r0 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 == 0) goto L_0x0065
            android.content.pm.ApplicationInfo r0 = r3.getApplicationInfo()
            if (r0 != 0) goto L_0x0054
            r3 = r4
            goto L_0x0066
        L_0x0054:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x0064 }
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()     // Catch:{ NameNotFoundException -> 0x0064 }
            java.lang.String r3 = r3.packageName     // Catch:{ NameNotFoundException -> 0x0064 }
            r1 = 0
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            r3 = move-exception
        L_0x0065:
            r3 = r4
        L_0x0066:
            r2.zzk = r3
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzhQ
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r0.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            java.lang.String r0 = "unknown"
            if (r3 == 0) goto L_0x0085
            java.util.Locale r3 = java.util.Locale.getDefault()
            java.lang.String r3 = r3.getCountry()
            goto L_0x0086
        L_0x0085:
            r3 = r0
        L_0x0086:
            r2.zzl = r3
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzhQ
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r1.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x00b9
            android.content.Context r3 = r2.zzg
            android.os.Handler r0 = com.google.android.gms.ads.internal.util.client.zzf.zza
            if (r3 != 0) goto L_0x00a1
            goto L_0x00ba
        L_0x00a1:
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ NameNotFoundException -> 0x00b7 }
            java.lang.String r0 = "com.android.vending"
            r1 = 128(0x80, float:1.794E-43)
            android.content.pm.PackageInfo r3 = r3.getPackageInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x00b7 }
            if (r3 != 0) goto L_0x00b0
            goto L_0x00ba
        L_0x00b0:
            int r3 = r3.versionCode     // Catch:{ NameNotFoundException -> 0x00b7 }
            java.lang.String r4 = java.lang.Integer.toString(r3)     // Catch:{ NameNotFoundException -> 0x00b7 }
            goto L_0x00ba
        L_0x00b7:
            r3 = move-exception
            goto L_0x00ba
        L_0x00b9:
            r4 = r0
        L_0x00ba:
            r2.zzm = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwj.<init>(android.content.Context, com.google.android.gms.ads.internal.util.client.VersionInfoParcel):void");
    }

    public static zzbwl zza(Context context) {
        synchronized (zze) {
            if (zza == null) {
                if (zzl()) {
                    zza = new zzbwj(context, VersionInfoParcel.forPackage());
                } else {
                    zza = new zzbwk();
                }
            }
        }
        return zza;
    }

    public static zzbwl zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzc == null) {
                boolean z = false;
                if (((Boolean) zzbgc.zzc.zze()).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbep.zzhM)).booleanValue()) {
                        z = true;
                    } else if (((Boolean) zzbgc.zza.zze()).booleanValue()) {
                        z = true;
                    }
                }
                if (zzl()) {
                    zzbwj zzbwj = new zzbwj(context, versionInfoParcel);
                    zzbwj.zzk();
                    zzbwj.zzj();
                    zzc = zzbwj;
                } else if (z) {
                    zzbwj zzbwj2 = new zzbwj(context, versionInfoParcel, true);
                    zzbwj2.zzk();
                    zzbwj2.zzj();
                    zzc = zzbwj2;
                } else {
                    zzc = new zzbwk();
                }
            }
        }
        return zzc;
    }

    public static zzbwl zzc(Context context) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzhN)).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbep.zzhM)).booleanValue()) {
                        zzb = new zzbwj(context, VersionInfoParcel.forPackage());
                    }
                }
                zzb = new zzbwk();
            }
        }
        return zzb;
    }

    public static zzbwl zzd(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (zze) {
            if (zzb == null) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzhN)).booleanValue()) {
                    if (!((Boolean) zzba.zzc().zza(zzbep.zzhM)).booleanValue()) {
                        zzb = new zzbwj(context, versionInfoParcel);
                    }
                }
                zzb = new zzbwk();
            }
        }
        return zzb;
    }

    public static String zze(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String zzf(Throwable th) {
        return zzfyv.zzc(zzf.zzg(zze(th)));
    }

    private final void zzj() {
        Thread.setDefaultUncaughtExceptionHandler(new zzbwh(this, Thread.getDefaultUncaughtExceptionHandler()));
    }

    private final void zzk() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread != null) {
            synchronized (this.zzf) {
                this.zzh.put(thread, true);
            }
            thread.setUncaughtExceptionHandler(new zzbwi(this, thread.getUncaughtExceptionHandler()));
        }
    }

    private static boolean zzl() {
        boolean z;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzmJ)).booleanValue()) {
            if (((Boolean) zzbgt.zze.zze()).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzhM)).booleanValue()) {
                    return true;
                }
            }
            return false;
        }
        synchronized (zze) {
            if (zzd == null) {
                if (zzay.zze().nextInt(100) < ((Integer) zzba.zzc().zza(zzbep.zzmG)).intValue()) {
                    z = true;
                } else {
                    z = false;
                }
                zzd = Boolean.valueOf(z);
            }
        }
        if (zzd.booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzhM)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void zzg(Thread thread, Throwable th) {
        if (th != null) {
            boolean z = false;
            boolean z2 = false;
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    z |= zzf.zzp(stackTraceElement.getClassName());
                    z2 |= getClass().getName().equals(stackTraceElement.getClassName());
                }
            }
            if (z && !z2) {
                if (!this.zzo) {
                    zzh(th, "");
                }
                if (!this.zzn.getAndSet(true) && ((Boolean) zzbgc.zzc.zze()).booleanValue()) {
                    zzbdz.zzc(this.zzg);
                }
            }
        }
    }

    public final void zzh(Throwable th, String str) {
        if (!this.zzo) {
            zzi(th, str, 1.0f);
        }
    }

    public final void zzi(Throwable th, String str, float f) {
        Throwable th2;
        String str2;
        PackageInfo packageInfo;
        ActivityManager.MemoryInfo zzc2;
        Throwable th3;
        float f2 = f;
        if (!this.zzo) {
            Handler handler = zzf.zza;
            boolean z = false;
            if (((Boolean) zzbgt.zzf.zze()).booleanValue()) {
                th2 = th;
            } else {
                LinkedList linkedList = new LinkedList();
                for (Throwable th4 = th; th4 != null; th4 = th4.getCause()) {
                    linkedList.push(th4);
                }
                th2 = null;
                while (!linkedList.isEmpty()) {
                    Throwable th5 = (Throwable) linkedList.pop();
                    StackTraceElement[] stackTrace = th5.getStackTrace();
                    boolean z2 = ((Boolean) zzba.zzc().zza(zzbep.zzcj)).booleanValue() && stackTrace != null && stackTrace.length == 0 && zzf.zzp(th5.getClass().getName());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new StackTraceElement(th5.getClass().getName(), "<filtered>", "<filtered>", 1));
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        if (zzf.zzp(stackTraceElement.getClassName())) {
                            arrayList.add(stackTraceElement);
                            z2 = true;
                        } else {
                            String className = stackTraceElement.getClassName();
                            if (!TextUtils.isEmpty(className) && (className.startsWith("android.") || className.startsWith("java."))) {
                                arrayList.add(stackTraceElement);
                            } else {
                                arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                            }
                        }
                    }
                    if (z2) {
                        if (th2 == null) {
                            th3 = new Throwable(th5.getMessage());
                        } else {
                            th3 = new Throwable(th5.getMessage(), th2);
                        }
                        th2 = th3;
                        th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
                    }
                }
            }
            if (th2 != null) {
                String name = th.getClass().getName();
                String zze2 = zze(th);
                String zzf2 = ((Boolean) zzba.zzc().zza(zzbep.zziP)).booleanValue() ? zzf(th) : "";
                double d = (double) f2;
                int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                double random = Math.random();
                int i2 = i > 0 ? (int) (1.0f / f2) : 1;
                if (random < d) {
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    try {
                        z = Wrappers.packageManager(this.zzg).isCallerInstantApp();
                    } catch (Throwable th6) {
                        zzm.zzh("Error fetching instant app info", th6);
                    }
                    try {
                        str2 = this.zzg.getPackageName();
                    } catch (Throwable th7) {
                        zzm.zzj("Cannot obtain package name, proceeding.");
                        str2 = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Uri.Builder appendQueryParameter = new Uri.Builder().scheme(ProxyConfig.MATCH_HTTPS).path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
                    String str3 = Build.MANUFACTURER;
                    String str4 = Build.MODEL;
                    if (!str4.startsWith(str3)) {
                        str4 = str3 + " " + str4;
                    }
                    Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str4).appendQueryParameter("js", this.zzj.afmaVersion).appendQueryParameter("appid", str2).appendQueryParameter("exceptiontype", name).appendQueryParameter("stacktrace", zze2).appendQueryParameter("eids", TextUtils.join(",", zzba.zza().zza())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "636244245").appendQueryParameter("rc", "dev").appendQueryParameter("sampling_rate", Integer.toString(i2)).appendQueryParameter("pb_tm", String.valueOf(zzbgt.zzc.zze())).appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzg)));
                    String str5 = "0";
                    Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter("lite", true != this.zzj.isLiteSdk ? str5 : "1");
                    if (!TextUtils.isEmpty(zzf2)) {
                        appendQueryParameter3.appendQueryParameter("hash", zzf2);
                    }
                    if (((Boolean) zzba.zzc().zza(zzbep.zzhR)).booleanValue() && (zzc2 = zzf.zzc(this.zzg)) != null) {
                        appendQueryParameter3.appendQueryParameter("available_memory", Long.toString(zzc2.availMem));
                        appendQueryParameter3.appendQueryParameter("total_memory", Long.toString(zzc2.totalMem));
                        if (true == zzc2.lowMemory) {
                            str5 = "1";
                        }
                        appendQueryParameter3.appendQueryParameter("is_low_memory", str5);
                    }
                    if (((Boolean) zzba.zzc().zza(zzbep.zzhQ)).booleanValue()) {
                        if (!TextUtils.isEmpty(this.zzl)) {
                            appendQueryParameter3.appendQueryParameter("countrycode", this.zzl);
                        }
                        if (!TextUtils.isEmpty(this.zzm)) {
                            appendQueryParameter3.appendQueryParameter("psv", this.zzm);
                        }
                        Context context = this.zzg;
                        if (Build.VERSION.SDK_INT >= 26) {
                            packageInfo = WebView.getCurrentWebViewPackage();
                        } else if (context == null) {
                            packageInfo = null;
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.webview", 128);
                            } catch (PackageManager.NameNotFoundException e) {
                                packageInfo = null;
                            }
                        }
                        if (packageInfo != null) {
                            appendQueryParameter3.appendQueryParameter("wvvc", Integer.toString(packageInfo.versionCode));
                            appendQueryParameter3.appendQueryParameter("wvvn", packageInfo.versionName);
                            appendQueryParameter3.appendQueryParameter("wvpn", packageInfo.packageName);
                        }
                    }
                    PackageInfo packageInfo2 = this.zzk;
                    if (packageInfo2 != null) {
                        appendQueryParameter3.appendQueryParameter("appvc", String.valueOf(packageInfo2.versionCode));
                        appendQueryParameter3.appendQueryParameter("appvn", this.zzk.versionName);
                    }
                    arrayList2.add(appendQueryParameter3.toString());
                    for (String zzbwg : arrayList2) {
                        this.zzi.execute(new zzbwg(new zzr((String) null), zzbwg));
                    }
                }
            }
        }
    }

    protected zzbwj(Context context, VersionInfoParcel versionInfoParcel, boolean z) {
        this(context, versionInfoParcel);
        this.zzo = true;
    }
}
