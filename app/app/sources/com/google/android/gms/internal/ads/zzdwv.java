package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdwv implements Runnable {
    public final /* synthetic */ zzdxf zza;
    public final /* synthetic */ zzccn zzb;

    public /* synthetic */ zzdwv(zzdxf zzdxf, zzccn zzccn) {
        this.zza = zzdxf;
        this.zzb = zzccn;
    }

    public final void run() {
        String zzc = zzu.zzo().zzi().zzh().zzc();
        boolean isEmpty = TextUtils.isEmpty(zzc);
        zzccn zzccn = this.zzb;
        if (!isEmpty) {
            zzccn.zzc(zzc);
        } else {
            zzccn.zzd(new Exception());
        }
    }
}
