package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzely extends zzemz {
    private final zzdhr zza;

    public zzely(zzczj zzczj, zzdhg zzdhg, zzdad zzdad, zzdas zzdas, zzdax zzdax, zzczy zzczy, zzdef zzdef, zzdid zzdid, zzdbr zzdbr, zzdhr zzdhr, zzdeb zzdeb) {
        super(zzczj, zzdhg, zzdad, zzdas, zzdax, zzdef, zzdbr, zzdid, zzdeb, zzczy);
        this.zza = zzdhr;
    }

    public final void zzs(zzbyt zzbyt) {
        this.zza.zza(zzbyt);
    }

    public final void zzt(zzbyx zzbyx) throws RemoteException {
        this.zza.zza(new zzbyt(zzbyx.zzf(), zzbyx.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
