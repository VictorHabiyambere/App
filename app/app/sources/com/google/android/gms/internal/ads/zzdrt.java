package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdrt implements zzcit {
    public final /* synthetic */ zzccn zza;

    public /* synthetic */ zzdrt(zzccn zzccn) {
        this.zza = zzccn;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzccn zzccn = this.zza;
        if (z) {
            zzccn.zzc((Object) null);
            return;
        }
        zzccn.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
