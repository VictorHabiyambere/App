package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzbuq extends zzbiy {
    final /* synthetic */ zzbut zza;

    /* synthetic */ zzbuq(zzbut zzbut, zzbup zzbup) {
        this.zza = zzbut;
    }

    public final void zze(zzbip zzbip, String str) {
        zzbut zzbut = this.zza;
        if (zzbut.zzb != null) {
            zzbut.zzb.onCustomClick(zzbut.zzf(zzbip), str);
        }
    }
}
