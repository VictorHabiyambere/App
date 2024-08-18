package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbby implements Comparator {
    public zzbby(zzbbz zzbbz) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbbn zzbbn = (zzbbn) obj;
        zzbbn zzbbn2 = (zzbbn) obj2;
        if (zzbbn.zzd() < zzbbn2.zzd()) {
            return -1;
        }
        if (zzbbn.zzd() > zzbbn2.zzd()) {
            return 1;
        }
        if (zzbbn.zzb() < zzbbn2.zzb()) {
            return -1;
        }
        if (zzbbn.zzb() > zzbbn2.zzb()) {
            return 1;
        }
        float zza = (zzbbn.zza() - zzbbn.zzd()) * (zzbbn.zzc() - zzbbn.zzb());
        float zza2 = (zzbbn2.zza() - zzbbn2.zzd()) * (zzbbn2.zzc() - zzbbn2.zzb());
        if (zza > zza2) {
            return -1;
        }
        if (zza < zza2) {
            return 1;
        }
        return 0;
    }
}
