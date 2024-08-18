package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzevb implements zzexw {
    private final zzgge zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzevb(zzgge zzgge, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgge;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final int zza() {
        return 22;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeva(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzevc zzc() throws Exception {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgb)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzevc(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        boolean z = null;
        if (((Boolean) zzba.zzc().zza(zzbep.zzgc)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                boolean z2 = true;
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                            z2 = false;
                        }
                        z = Boolean.valueOf(z2);
                    } catch (PackageManager.NameNotFoundException e) {
                    }
                } else {
                    z = true;
                }
                return new zzevc(z);
            }
        }
        return new zzevc((Boolean) null);
    }
}
