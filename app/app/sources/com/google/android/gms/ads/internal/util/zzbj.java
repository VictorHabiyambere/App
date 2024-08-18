package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzarn;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbj implements zzari {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbn zzb;

    zzbj(zzbq zzbq, String str, zzbn zzbn) {
        this.zza = str;
        this.zzb = zzbn;
    }

    public final void zza(zzarn zzarn) {
        String zzarn2 = zzarn.toString();
        zzm.zzj("Failed to load URL: " + this.zza + "\n" + zzarn2);
        this.zzb.zza((Object) null);
    }
}
