package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzfuv;
import com.google.android.gms.internal.ads.zzfxr;
import com.google.android.gms.internal.ads.zzfyt;
import com.google.android.gms.internal.ads.zzgft;
import com.google.android.gms.internal.ads.zzhlh;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzt {
    public static final zzfuv zza = new zzf(Looper.getMainLooper());
    private final AtomicReference zzb = new AtomicReference((Object) null);
    private final AtomicReference zzc = new AtomicReference((Object) null);
    private final AtomicReference zzd = new AtomicReference(new Bundle());
    private final AtomicBoolean zze = new AtomicBoolean();
    /* access modifiers changed from: private */
    public boolean zzf = true;
    private final Object zzg = new Object();
    private String zzh;
    private volatile String zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private final Executor zzl = Executors.newSingleThreadExecutor();

    public static final boolean zzA(Context context, String str) {
        Context zza2 = zzbyf.zza(context);
        return Wrappers.packageManager(zza2).checkPermission(str, zza2.getPackageName()) == 0;
    }

    public static final boolean zzB(Context context) {
        try {
            return DeviceProperties.isBstar(context);
        } catch (NoSuchMethodError e) {
            return false;
        }
    }

    public static final boolean zzC(String str) {
        if (!zzl.zzk()) {
            return false;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeV)).booleanValue()) {
            return false;
        }
        String str2 = (String) zzba.zzc().zza(zzbep.zzeX);
        if (!str2.isEmpty()) {
            for (String equals : str2.split(";")) {
                if (equals.equals(str)) {
                    return false;
                }
            }
        }
        String str3 = (String) zzba.zzc().zza(zzbep.zzeW);
        if (str3.isEmpty()) {
            return true;
        }
        for (String equals2 : str3.split(";")) {
            if (equals2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean zzD(Context context) {
        KeyguardManager zzX;
        if (context == null || (zzX = zzX(context)) == null || !zzX.isKeyguardLocked()) {
            return false;
        }
        return true;
    }

    public static final boolean zzE(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi");
            return false;
        } catch (ClassNotFoundException e) {
            return true;
        } catch (Throwable th) {
            zzm.zzh("Error loading class.", th);
            zzu.zzo().zzw(th, "AdUtil.isLiteSdk");
            return false;
        }
    }

    public static final boolean zzF() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public static final boolean zzG(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager != null) {
                if (keyguardManager != null) {
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses == null) {
                        return false;
                    }
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (Process.myPid() == next.pid) {
                            if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                                return true;
                            }
                            PowerManager powerManager = (PowerManager) context.getSystemService("power");
                            if (powerManager == null) {
                                return true;
                            }
                            if (powerManager.isScreenOn()) {
                                return false;
                            }
                            return true;
                        }
                    }
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static final boolean zzH(Context context) {
        try {
            Bundle zzY = zzY(context);
            String string = zzY.getString("com.google.android.gms.ads.INTEGRATION_MANAGER");
            if (!TextUtils.isEmpty(zzZ(zzY)) || TextUtils.isEmpty(string)) {
                return false;
            }
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    public static final boolean zzI(Context context) {
        Window window;
        if (!(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, (Point) null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        if (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[Catch:{ Exception -> 0x00fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095 A[Catch:{ Exception -> 0x00fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void zzJ(android.view.View r22, int r23, android.view.MotionEvent r24) {
        /*
            r0 = r22
            r1 = 2
            int[] r2 = new int[r1]
            android.graphics.Rect r3 = new android.graphics.Rect
            r3.<init>()
            android.content.Context r4 = r22.getContext()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r6 = r4.getPackageName()     // Catch:{ Exception -> 0x00fc }
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdsg     // Catch:{ Exception -> 0x00fc }
            r5 = 0
            if (r4 == 0) goto L_0x001d
            com.google.android.gms.internal.ads.zzdsg r0 = (com.google.android.gms.internal.ads.zzdsg) r0     // Catch:{ Exception -> 0x00fc }
            android.view.View r0 = r0.getChildAt(r5)     // Catch:{ Exception -> 0x00fc }
        L_0x001d:
            boolean r4 = r0 instanceof com.google.android.gms.ads.formats.zzj     // Catch:{ Exception -> 0x00fc }
            r7 = 1
            if (r4 != 0) goto L_0x002b
            boolean r4 = r0 instanceof com.google.android.gms.ads.nativead.NativeAdView     // Catch:{ Exception -> 0x00fc }
            if (r4 == 0) goto L_0x0027
            goto L_0x002b
        L_0x0027:
            java.lang.String r4 = "UNKNOWN"
            r8 = r5
            goto L_0x002e
        L_0x002b:
            java.lang.String r4 = "NATIVE"
            r8 = r7
        L_0x002e:
            boolean r9 = r0.getLocalVisibleRect(r3)     // Catch:{ Exception -> 0x00fc }
            if (r9 == 0) goto L_0x003d
            int r9 = r3.width()     // Catch:{ Exception -> 0x00fc }
            int r3 = r3.height()     // Catch:{ Exception -> 0x00fc }
            goto L_0x003f
        L_0x003d:
            r3 = r5
            r9 = r3
        L_0x003f:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ Exception -> 0x00fc }
            long r10 = zzw(r0)     // Catch:{ Exception -> 0x00fc }
            r0.getLocationOnScreen(r2)     // Catch:{ Exception -> 0x00fc }
            r5 = r2[r5]     // Catch:{ Exception -> 0x00fc }
            r2 = r2[r7]     // Catch:{ Exception -> 0x00fc }
            boolean r7 = r0 instanceof com.google.android.gms.internal.ads.zzcig     // Catch:{ Exception -> 0x00fc }
            java.lang.String r12 = "none"
            if (r7 == 0) goto L_0x007b
            r7 = r0
            com.google.android.gms.internal.ads.zzcig r7 = (com.google.android.gms.internal.ads.zzcig) r7     // Catch:{ Exception -> 0x00fc }
            com.google.android.gms.internal.ads.zzfgw r7 = r7.zzR()     // Catch:{ Exception -> 0x00fc }
            if (r7 == 0) goto L_0x007b
            java.lang.String r7 = r7.zzb     // Catch:{ Exception -> 0x00fc }
            int r13 = r0.hashCode()     // Catch:{ Exception -> 0x00fc }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fc }
            r14.<init>()     // Catch:{ Exception -> 0x00fc }
            r14.append(r7)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r15 = ":"
            r14.append(r15)     // Catch:{ Exception -> 0x00fc }
            r14.append(r13)     // Catch:{ Exception -> 0x00fc }
            java.lang.String r13 = r14.toString()     // Catch:{ Exception -> 0x00fc }
            r0.setContentDescription(r13)     // Catch:{ Exception -> 0x00fc }
            r13 = r7
            goto L_0x007d
        L_0x007b:
            r13 = r12
        L_0x007d:
            boolean r7 = r0 instanceof com.google.android.gms.internal.ads.zzcgu     // Catch:{ Exception -> 0x00fc }
            if (r7 == 0) goto L_0x0095
            r7 = r0
            com.google.android.gms.internal.ads.zzcgu r7 = (com.google.android.gms.internal.ads.zzcgu) r7     // Catch:{ Exception -> 0x00fc }
            com.google.android.gms.internal.ads.zzfgt r7 = r7.zzD()     // Catch:{ Exception -> 0x00fc }
            if (r7 == 0) goto L_0x0095
            int r4 = r7.zzb     // Catch:{ Exception -> 0x00fc }
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfgt.zza(r4)     // Catch:{ Exception -> 0x00fc }
            int r8 = r7.zzf     // Catch:{ Exception -> 0x00fc }
            java.lang.String r7 = r7.zzF     // Catch:{ Exception -> 0x00fc }
            goto L_0x0097
        L_0x0095:
            r7 = r12
        L_0x0097:
            java.util.Locale r15 = java.util.Locale.US     // Catch:{ Exception -> 0x00fc }
            java.lang.String r14 = "<Ad hashCode=%d, package=%s, adNetCls=%s, gwsQueryId=%s, format=%s, impType=%d, class=%s, x=%d, y=%d, width=%d, height=%d, vWidth=%d, vHeight=%d, alpha=%d, state=%s>"
            int r12 = r0.hashCode()     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r16 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00fc }
            java.lang.Class r8 = r0.getClass()     // Catch:{ Exception -> 0x00fc }
            java.lang.String r17 = r8.getName()     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00fc }
            int r5 = r0.getWidth()     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r19 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00fc }
            int r0 = r0.getHeight()     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r20 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00fc }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00fc }
            java.lang.Long r21 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x00fc }
            r5 = r23
            java.lang.String r1 = java.lang.Integer.toString(r5, r1)     // Catch:{ Exception -> 0x00fc }
            r5 = r12
            r8 = r13
            r9 = r4
            r10 = r16
            r11 = r17
            r12 = r18
            r13 = r2
            r2 = r14
            r14 = r19
            r4 = r15
            r15 = r0
            r16 = r20
            r17 = r3
            r18 = r21
            r19 = r1
            java.lang.Object[] r0 = new java.lang.Object[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19}     // Catch:{ Exception -> 0x00fc }
            java.lang.String r0 = java.lang.String.format(r4, r2, r0)     // Catch:{ Exception -> 0x00fc }
            com.google.android.gms.ads.internal.util.client.zzm.zzi(r0)     // Catch:{ Exception -> 0x00fc }
            return
        L_0x00fc:
            r0 = move-exception
            java.lang.String r1 = "Failure getting view location."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzJ(android.view.View, int, android.view.MotionEvent):void");
    }

    public static final AlertDialog.Builder zzK(Context context) {
        zzu.zzq();
        return new AlertDialog.Builder(context, 16974374);
    }

    public static final void zzL(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        for (String zzca : arrayList) {
            new zzca(context, str, zzca).zzb();
        }
    }

    public static final void zzM(Context context, Throwable th) {
        if (context != null) {
            try {
                if (((Boolean) zzbgt.zzb.zze()).booleanValue()) {
                    CrashUtils.addDynamiteErrorToDropBox(context, th);
                }
            } catch (IllegalStateException e) {
            }
        }
    }

    public static final String zzN(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        char[] cArr = new char[2048];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read == -1) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    public static final int zzO(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            zzm.zzj("Could not parse value:".concat(e.toString()));
            return 0;
        }
    }

    public static final Map zzP(Uri uri) {
        if (uri == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String next : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, uri.getQueryParameter(next));
            }
        }
        return hashMap;
    }

    public static final int[] zzQ(Activity activity) {
        View findViewById;
        Window window = activity.getWindow();
        if (window == null || (findViewById = window.findViewById(16908290)) == null) {
            return zzu();
        }
        return new int[]{findViewById.getWidth(), findViewById.getHeight()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int[] zzR(android.app.Activity r5) {
        /*
            android.view.Window r0 = r5.getWindow()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0021
            r3 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r3)
            if (r0 == 0) goto L_0x0021
            r3 = 2
            int[] r3 = new int[r3]
            int r4 = r0.getTop()
            r3[r2] = r4
            int r0 = r0.getBottom()
            r3[r1] = r0
            goto L_0x0025
        L_0x0021:
            int[] r3 = zzu()
        L_0x0025:
            com.google.android.gms.ads.internal.util.client.zzf r0 = com.google.android.gms.ads.internal.client.zzay.zzb()
            r2 = r3[r2]
            int r0 = r0.zzb(r5, r2)
            com.google.android.gms.ads.internal.util.client.zzf r2 = com.google.android.gms.ads.internal.client.zzay.zzb()
            r1 = r3[r1]
            int r5 = r2.zzb(r5, r1)
            int[] r5 = new int[]{r0, r5}
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzR(android.app.Activity):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzS(android.view.View r5, android.os.PowerManager r6, android.app.KeyguardManager r7) {
        /*
            com.google.android.gms.ads.internal.util.zzt r0 = com.google.android.gms.ads.internal.zzu.zzp()
            boolean r0 = r0.zzf
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001d
            if (r7 != 0) goto L_0x000e
            r7 = r1
            goto L_0x001e
        L_0x000e:
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L_0x001d
            boolean r7 = zzn(r5)
            if (r7 == 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r7 = r2
            goto L_0x001e
        L_0x001d:
            r7 = r1
        L_0x001e:
            long r3 = zzw(r5)
            int r0 = r5.getVisibility()
            if (r0 != 0) goto L_0x0089
            boolean r0 = r5.isShown()
            if (r0 == 0) goto L_0x0089
            if (r6 == 0) goto L_0x0036
            boolean r6 = r6.isScreenOn()
            if (r6 == 0) goto L_0x0089
        L_0x0036:
            if (r7 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzbeg r6 = com.google.android.gms.internal.ads.zzbep.zzbm
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r6 = r7.zza(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0060
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            boolean r6 = r5.getLocalVisibleRect(r6)
            if (r6 != 0) goto L_0x0060
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            boolean r5 = r5.getGlobalVisibleRect(r6)
            if (r5 == 0) goto L_0x0089
        L_0x0060:
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzkD
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzkF
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            long r5 = (long) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            return r1
        L_0x0089:
            r1 = r2
        L_0x008a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzt.zzS(android.view.View, android.os.PowerManager, android.app.KeyguardManager):boolean");
    }

    public static final void zzT(Context context, Intent intent) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzkX)).booleanValue()) {
            try {
                zzab(context, intent);
            } catch (SecurityException e) {
                zzm.zzk("", e);
                zzu.zzo().zzw(e, "AdUtil.startActivityWithUnknownContext");
            }
        } else {
            zzab(context, intent);
        }
    }

    public static final void zzU(Context context, Uri uri) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Bundle bundle = new Bundle();
            intent.putExtras(bundle);
            zzo(context, intent);
            bundle.putString("com.android.browser.application_id", context.getPackageName());
            context.startActivity(intent);
            String uri2 = uri.toString();
            zzm.zze("Opening " + uri2 + " in a new browser.");
        } catch (ActivityNotFoundException e) {
            zzm.zzh("No browser is found.", e);
        }
    }

    public static final int[] zzV(Activity activity) {
        int[] zzQ = zzQ(activity);
        return new int[]{zzay.zzb().zzb(activity, zzQ[0]), zzay.zzb().zzb(activity, zzQ[1])};
    }

    public static final boolean zzW(View view, Context context) {
        PowerManager powerManager;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            powerManager = (PowerManager) applicationContext.getSystemService("power");
        } else {
            powerManager = null;
        }
        return zzS(view, powerManager, zzX(context));
    }

    private static KeyguardManager zzX(Context context) {
        Object systemService = context.getSystemService("keyguard");
        if (systemService == null || !(systemService instanceof KeyguardManager)) {
            return null;
        }
        return (KeyguardManager) systemService;
    }

    private static Bundle zzY(Context context) throws RemoteException {
        try {
            return Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            zze.zzb("Error getting metadata", e);
            return null;
        }
    }

    private static String zzZ(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (string.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$") || string.matches("^/\\d+~.+$")) {
            return string;
        }
        return "";
    }

    public static int zza(int i) {
        if (i >= 5000) {
            return i;
        }
        if (i <= 0) {
            return 60000;
        }
        zzm.zzj("HTTP timeout too low: " + i + " milliseconds. Reverting to default timeout: 60000 milliseconds.");
        return 60000;
    }

    private static boolean zzaa(String str, AtomicReference atomicReference, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern pattern = (Pattern) atomicReference.get();
            if (pattern != null) {
                if (str2.equals(pattern.pattern())) {
                    return pattern.matcher(str).matches();
                }
            }
            pattern = Pattern.compile(str2);
            atomicReference.set(pattern);
            return pattern.matcher(str).matches();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    private static final void zzab(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (Throwable th) {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    private static final String zzac(Context context, String str) {
        String str2;
        String str3;
        if (str == null) {
            return zzq();
        }
        try {
            zzck zza2 = zzck.zza();
            if (TextUtils.isEmpty(zza2.zza)) {
                if (ClientLibraryUtils.isPackageSide()) {
                    str3 = (String) zzch.zza(context, new zzci(context));
                } else {
                    str3 = (String) zzch.zza(context, new zzcj(GooglePlayServicesUtilLight.getRemoteContext(context), context));
                }
                zza2.zza = str3;
            }
            str2 = zza2.zza;
        } catch (Exception e) {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = WebSettings.getDefaultUserAgent(context);
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = zzq();
        }
        String str4 = str2 + " (Mobile; " + str;
        try {
            if (Wrappers.packageManager(context).isCallerInstantApp()) {
                str4 = str4 + ";aia";
            }
        } catch (Exception e2) {
            zzu.zzo().zzw(e2, "AdUtil.getUserAgent");
        }
        return str4.concat(")");
    }

    public static List zzd() {
        zzbeg zzbeg = zzbep.zza;
        List<String> zzb2 = zzba.zza().zzb();
        ArrayList arrayList = new ArrayList();
        for (String zzd2 : zzb2) {
            for (String valueOf : zzfyt.zzc(zzfxr.zzc(',')).zzd(zzd2)) {
                try {
                    arrayList.add(Long.valueOf(valueOf));
                } catch (NumberFormatException e) {
                    zze.zza("Experiment ID is not a number");
                }
            }
        }
        return arrayList;
    }

    public static final boolean zzn(View view) {
        Activity activity;
        View rootView = view.getRootView();
        WindowManager.LayoutParams layoutParams = null;
        if (rootView == null) {
            activity = null;
        } else {
            Context context = rootView.getContext();
            activity = context instanceof Activity ? (Activity) context : null;
        }
        if (activity == null) {
            return false;
        }
        Window window = activity.getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams == null || (layoutParams.flags & 524288) == 0) {
            return false;
        }
        return true;
    }

    public static final void zzo(Context context, Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras() != null ? intent.getExtras() : new Bundle();
            extras.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            extras.putString("com.android.browser.application_id", context.getPackageName());
            intent.putExtras(extras);
        }
    }

    public static final String zzp(Context context) throws RemoteException {
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        return zzZ(zzY(context));
    }

    static final String zzq() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Mozilla/5.0 (Linux; U; Android");
        if (Build.VERSION.RELEASE != null) {
            sb.append(" ");
            sb.append(Build.VERSION.RELEASE);
        }
        sb.append("; ");
        sb.append(Locale.getDefault());
        if (Build.DEVICE != null) {
            sb.append("; ");
            sb.append(Build.DEVICE);
            if (Build.DISPLAY != null) {
                sb.append(" Build/");
                sb.append(Build.DISPLAY);
            }
        }
        sb.append(") AppleWebKit/533 Version/4.0 Safari/533");
        return sb.toString();
    }

    public static final String zzr() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return str2;
        }
        return str + " " + str2;
    }

    public static final Integer zzs(Context context) {
        Object systemService = context.getSystemService("display");
        if (systemService instanceof DisplayManager) {
            return Integer.valueOf(((DisplayManager) systemService).getDisplays().length);
        }
        return null;
    }

    public static final DisplayMetrics zzt(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    protected static final int[] zzu() {
        return new int[]{0, 0};
    }

    public static final Map zzv(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                HashSet hashSet = new HashSet();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (optString != null) {
                            hashSet.add(optString);
                        }
                    }
                    hashMap.put(next, hashSet);
                }
            }
            return hashMap;
        } catch (JSONException e) {
            zzu.zzo().zzw(e, "AdUtil.getMapOfFileNamesToKeysFromJsonString");
            return hashMap;
        }
    }

    public static final long zzw(View view) {
        float f;
        int i;
        float f2 = Float.MAX_VALUE;
        Object obj = view;
        do {
            f = 0.0f;
            if (!(obj instanceof View)) {
                break;
            }
            View view2 = (View) obj;
            f2 = Math.min(f2, view2.getAlpha());
            i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            obj = view2.getParent();
        } while (i > 0);
        if (f2 >= 0.0f) {
            f = f2;
        }
        return (long) Math.round(f * 100.0f);
    }

    public static final WebResourceResponse zzx(Context context, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put(HttpHeaders.USER_AGENT, zzu.zzp().zzc(context, str));
            hashMap.put(HttpHeaders.CACHE_CONTROL, "max-stale=3600");
            String str3 = (String) new zzbq(context).zzb(0, str2, hashMap, (byte[]) null).get(60, TimeUnit.SECONDS);
            if (str3 != null) {
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
            }
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            zzm.zzk("Could not fetch MRAID JS.", e);
        }
        return null;
    }

    public static final String zzy() {
        Resources zze2 = zzu.zzo().zze();
        return zze2 != null ? zze2.getString(R.string.s7) : "Test Ad";
    }

    public static final zzbt zzz(Context context) {
        try {
            Object newInstance = context.getClassLoader().loadClass("com.google.android.gms.ads.internal.util.WorkManagerUtil").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzm.zzg("Instantiated WorkManagerUtil not instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
            return queryLocalInterface instanceof zzbt ? (zzbt) queryLocalInterface : new zzbr(iBinder);
        } catch (Exception e) {
            zzu.zzo().zzw(e, "Failed to instantiate WorkManagerUtil");
            return null;
        }
    }

    public final ListenableFuture zzb(Uri uri) {
        return zzgft.zzj(new zzn(uri), this.zzl);
    }

    public final String zzc(Context context, String str) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlk)).booleanValue()) {
            synchronized (this.zzg) {
                String str2 = this.zzh;
                if (str2 != null) {
                    return str2;
                }
                this.zzh = zzac(context, str);
                String str3 = this.zzh;
                return str3;
            }
        } else if (this.zzi != null) {
            return this.zzi;
        } else {
            this.zzi = zzac(context, str);
            return this.zzi;
        }
    }

    public final void zzf(Context context, String str, boolean z, HttpURLConnection httpURLConnection, boolean z2, int i) {
        int zza2 = zza(i);
        zzm.zzi("HTTP timeout: " + zza2 + " milliseconds.");
        httpURLConnection.setConnectTimeout(zza2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(zza2);
        if (TextUtils.isEmpty(httpURLConnection.getRequestProperty(HttpHeaders.USER_AGENT))) {
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, zzc(context, str));
        }
        httpURLConnection.setUseCaches(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Context context, String str, SharedPreferences sharedPreferences, String str2) {
        this.zzd.set(zzad.zzb(context, str));
    }

    public final void zzh(Context context, String str, String str2, Bundle bundle, boolean z) {
        zzu.zzp();
        bundle.putString("device", zzr());
        zzbeg zzbeg = zzbep.zza;
        bundle.putString("eids", TextUtils.join(",", zzba.zza().zza()));
        if (bundle.isEmpty()) {
            zzm.zze("Empty or null bundle.");
        } else {
            String str3 = (String) zzba.zzc().zza(zzbep.zzkA);
            if (!this.zze.getAndSet(true)) {
                this.zzd.set(zzad.zza(context, str3, new zzm(this, context, str3)));
            }
            bundle.putAll((Bundle) this.zzd.get());
        }
        zzay.zzb();
        zzf.zzx(context, str, "gmob-apps", bundle, true, new zzl(context, str));
    }

    public final boolean zzi(String str) {
        zzbeg zzbeg = zzbep.zzab;
        return zzaa(str, this.zzb, (String) zzba.zzc().zza(zzbeg));
    }

    public final boolean zzj(String str) {
        zzbeg zzbeg = zzbep.zzac;
        return zzaa(str, this.zzc, (String) zzba.zzc().zza(zzbeg));
    }

    public final boolean zzk(Context context) {
        if (this.zzk) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.ads.intent.DEBUG_LOGGING_ENABLEMENT_CHANGED");
        zzbep.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzkW)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzq(this, (zzp) null), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzq(this, (zzp) null), intentFilter, 4);
        }
        this.zzk = true;
        return true;
    }

    public final boolean zzl(Context context) {
        if (this.zzj) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        zzbep.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzkW)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.getApplicationContext().registerReceiver(new zzs(this, (zzr) null), intentFilter);
        } else {
            context.getApplicationContext().registerReceiver(new zzs(this, (zzr) null), intentFilter, 4);
        }
        this.zzj = true;
        return true;
    }

    public final int zzm(Context context, Uri uri) {
        int i;
        if (context == null) {
            zze.zza("Trying to open chrome custom tab on a null context");
            return 3;
        }
        if (!(context instanceof Activity)) {
            zze.zza("Chrome Custom Tabs can only work with Activity context.");
            i = 2;
        } else {
            i = 0;
        }
        if (true == ((Boolean) zzba.zzc().zza(zzbep.zzeC)).equals(zzba.zzc().zza(zzbep.zzeD))) {
            i = 9;
        }
        if (i != 0) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return i;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzeC)).booleanValue()) {
            zzbfm zzbfm = new zzbfm();
            zzbfm.zze(new zzo(this, zzbfm, context, uri));
            zzbfm.zzb((Activity) context);
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeD)).booleanValue()) {
            return 5;
        }
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setPackage(zzhlh.zza(context));
        build.launchUrl(context, uri);
        return 5;
    }
}
