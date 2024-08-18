package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvx;
import com.google.android.gms.internal.ads.zzcbg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class MobileAds {
    public static final String ERROR_DOMAIN = "com.google.android.gms.ads";

    private MobileAds() {
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzej.zzf().zzl(context);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzej.zzf().zze();
    }

    private static String getInternalVersion() {
        return zzej.zzf().zzh();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzej.zzf().zzc();
    }

    public static VersionInfo getVersion() {
        zzej.zzf();
        String[] split = TextUtils.split("23.2.0", "\\.");
        if (split.length != 3) {
            return new VersionInfo(0, 0, 0);
        }
        try {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        } catch (NumberFormatException e) {
            return new VersionInfo(0, 0, 0);
        }
    }

    public static void initialize(Context context) {
        zzej.zzf().zzm(context, (String) null, (OnInitializationCompleteListener) null);
    }

    public static void openAdInspector(Context context, OnAdInspectorClosedListener listener) {
        zzej.zzf().zzp(context, listener);
    }

    public static void openDebugMenu(Context context, String adUnitId) {
        zzej.zzf().zzq(context, adUnitId);
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean enabled) {
        return zzej.zzf().zzx(enabled);
    }

    public static CustomTabsSession registerCustomTabsSession(Context context, CustomTabsClient client, String origin, CustomTabsCallback callback) {
        zzej.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzcbg zza = zzbvx.zza(context);
        if (zza == null) {
            zzm.zzg("Internal error, query info generator is null.");
            return null;
        }
        try {
            return (CustomTabsSession) ObjectWrapper.unwrap(zza.zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(client), origin, ObjectWrapper.wrap(callback)));
        } catch (RemoteException | IllegalArgumentException e) {
            zzm.zzh("Unable to register custom tabs session. Error: ", e);
            return null;
        }
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> adapterClass) {
        zzej.zzf().zzr(adapterClass);
    }

    public static void registerWebView(WebView webview) {
        zzej.zzf();
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (webview == null) {
            zzm.zzg("The webview to be registered cannot be null.");
            return;
        }
        zzcbg zza = zzbvx.zza(webview.getContext());
        if (zza == null) {
            zzm.zzg("Internal error, query info generator is null.");
            return;
        }
        try {
            zza.zzj(ObjectWrapper.wrap(webview));
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public static void setAppMuted(boolean muted) {
        zzej.zzf().zzs(muted);
    }

    public static void setAppVolume(float volume) {
        zzej.zzf().zzt(volume);
    }

    private static void setPlugin(String plugin) {
        zzej.zzf().zzu(plugin);
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzej.zzf().zzv(requestConfiguration);
    }

    public static void initialize(Context context, OnInitializationCompleteListener listener) {
        zzej.zzf().zzm(context, (String) null, listener);
    }
}
