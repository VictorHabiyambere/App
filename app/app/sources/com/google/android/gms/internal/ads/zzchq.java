package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzchq {
    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.internal.ads.zzchd, java.lang.Object] */
    public static final zzchd zza(Context context, zzcix zzcix, String str, boolean z, boolean z2, zzaxd zzaxd, zzbfs zzbfs, VersionInfoParcel versionInfoParcel, zzbfe zzbfe, zzm zzm, zza zza, zzbdm zzbdm, zzfgt zzfgt, zzfgw zzfgw, zzegk zzegk, zzfhs zzfhs) throws zzchp {
        StrictMode.ThreadPolicy threadPolicy;
        zzbep.zza(context);
        try {
            zzchm zzchm = new zzchm(context, zzcix, str, z, z2, zzaxd, zzbfs, versionInfoParcel, (zzbfe) null, zzm, zza, zzbdm, zzfgt, zzfgw, zzfhs, zzegk);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzchm.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzchp("Webview initialization failed.", th);
        }
    }
}
