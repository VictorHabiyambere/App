package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdoq implements zzcit {
    public final /* synthetic */ zzccm zza;

    public /* synthetic */ zzdoq(zzccm zzccm) {
        this.zza = zzccm;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzccm zzccm = this.zza;
        if (z) {
            zzccm.zzb();
            return;
        }
        zzccm.zzd(new zzelj(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
