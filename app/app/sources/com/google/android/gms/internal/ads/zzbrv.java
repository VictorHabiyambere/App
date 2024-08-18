package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbrv extends zzdp {
    private final Object zza = new Object();
    private volatile zzdt zzb;

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzg() throws RemoteException {
        throw new RemoteException();
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final zzdt zzi() throws RemoteException {
        zzdt zzdt;
        synchronized (this.zza) {
            zzdt = this.zzb;
        }
        return zzdt;
    }

    public final void zzj(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm(zzdt zzdt) throws RemoteException {
        synchronized (this.zza) {
            this.zzb = zzdt;
        }
    }

    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
