package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbsj extends zzbrk {
    private final Adapter zza;
    private final zzbys zzb;

    zzbsj(Adapter adapter, zzbys zzbys) {
        this.zza = adapter;
        this.zzb = zzbys;
    }

    public final void zze() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzi(int i, String str) throws RemoteException {
    }

    public final void zzj(int i) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbip zzbip, String str) throws RemoteException {
    }

    public final void zzs(zzbyt zzbyt) throws RemoteException {
    }

    public final void zzt(zzbyx zzbyx) throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzm(ObjectWrapper.wrap(this.zza), new zzbyt(zzbyx.zzf(), zzbyx.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzbys zzbys = this.zzb;
        if (zzbys != null) {
            zzbys.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
