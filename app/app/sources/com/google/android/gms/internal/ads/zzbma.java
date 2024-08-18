package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbma {
    public static final Intent zza(Uri uri, Context context, zzaxd zzaxd, View view, zzfhs zzfhs) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    public static final Intent zzb(Intent intent, ResolveInfo resolveInfo, Context context, zzaxd zzaxd, View view, zzfhs zzfhs) {
        Intent intent2 = new Intent(intent);
        intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent2;
    }

    public static final ResolveInfo zzc(Intent intent, Context context, zzaxd zzaxd, View view, zzfhs zzfhs) {
        return zzd(intent, new ArrayList(), context, zzaxd, view, zzfhs);
    }

    public static final ResolveInfo zzd(Intent intent, ArrayList arrayList, Context context, zzaxd zzaxd, View view, zzfhs zzfhs) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    if (i < queryIntentActivities.size()) {
                        if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                            resolveInfo = resolveActivity;
                            break;
                        }
                        i++;
                    }
                }
            }
            try {
                arrayList.addAll(queryIntentActivities);
            } catch (Throwable th) {
                th = th;
            }
            return resolveInfo;
        } catch (Throwable th2) {
            th = th2;
            zzu.zzo().zzw(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
            return resolveInfo;
        }
    }
}
