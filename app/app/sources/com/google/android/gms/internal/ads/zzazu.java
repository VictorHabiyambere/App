package com.google.android.gms.internal.ads;

import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzazu implements PackageManager.OnChecksumsReadyListener {
    public final /* synthetic */ zzggm zza;

    public /* synthetic */ zzazu(zzggm zzggm) {
        this.zza = zzggm;
    }

    public final void onChecksumsReady(List list) {
        zzggm zzggm = this.zza;
        if (list == null) {
            zzggm.zzc((Object) null);
            return;
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ApkChecksum apkChecksum = (ApkChecksum) list.get(i);
                if (apkChecksum.getType() == 8) {
                    zzggm.zzc(zzayh.zzb(apkChecksum.getValue()));
                    return;
                }
            }
            zzggm.zzc((Object) null);
        } catch (Throwable th) {
            zzggm.zzc((Object) null);
        }
    }
}
