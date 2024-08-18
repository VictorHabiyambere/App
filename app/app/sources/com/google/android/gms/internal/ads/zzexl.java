package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzexl implements zzexw {
    private final zzgge zza;
    private final Context zzb;
    private final VersionInfoParcel zzc;
    private final String zzd;

    zzexl(zzgge zzgge, Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zza = zzgge;
        this.zzb = context;
        this.zzc = versionInfoParcel;
        this.zzd = str;
    }

    public final int zza() {
        return 35;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzexk(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexm zzc() throws Exception {
        int i;
        boolean isCallerInstantApp = Wrappers.packageManager(this.zzb).isCallerInstantApp();
        zzu.zzp();
        boolean zzE = zzt.zzE(this.zzb);
        String str = this.zzc.afmaVersion;
        zzu.zzp();
        boolean zzF = zzt.zzF();
        zzu.zzp();
        ApplicationInfo applicationInfo = this.zzb.getApplicationInfo();
        if (applicationInfo == null) {
            i = 0;
        } else {
            i = applicationInfo.targetSdkVersion;
        }
        Context context = this.zzb;
        return new zzexm(isCallerInstantApp, zzE, str, zzF, i, DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID), DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID), this.zzd);
    }
}
