package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeja implements zzehl {
    private final Context zza;
    private final zzdjh zzb;
    private final Executor zzc;
    private final zzfgs zzd;

    public zzeja(Context context, Executor executor, zzdjh zzdjh, zzfgs zzfgs) {
        this.zza = context;
        this.zzb = zzdjh;
        this.zzc = executor;
        this.zzd = zzfgs;
    }

    private static String zzd(zzfgt zzfgt) {
        try {
            return zzfgt.zzw.getString("tab_url");
        } catch (Exception e) {
            return null;
        }
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        Uri uri;
        String zzd2 = zzd(zzfgt);
        if (zzd2 != null) {
            uri = Uri.parse(zzd2);
        } else {
            uri = null;
        }
        return zzgft.zzn(zzgft.zzh((Object) null), new zzeiy(this, uri, zzfhf, zzfgt), this.zzc);
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbfm.zzg(context) && !TextUtils.isEmpty(zzd(zzfgt));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Uri uri, zzfhf zzfhf, zzfgt zzfgt, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzy) null);
            zzccn zzccn = new zzccn();
            zzdih zze = this.zzb.zze(new zzcvf(zzfhf, zzfgt, (String) null), new zzdik(new zzeiz(zzccn), (zzchd) null));
            zzccn.zzc(new AdOverlayInfoParcel(zzc2, (zza) null, zze.zza(), (zzaa) null, new VersionInfoParcel(0, 0, false), (zzchd) null, (zzdhi) null));
            this.zzd.zza();
            return zzgft.zzh(zze.zzg());
        } catch (Throwable th) {
            zzm.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
