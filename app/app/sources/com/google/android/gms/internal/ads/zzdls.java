package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdt;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdls extends zzdp {
    private final Object zza = new Object();
    @Nullable
    private final zzdq zzb;
    @Nullable
    private final zzbru zzc;

    public zzdls(@Nullable zzdq zzdq, @Nullable zzbru zzbru) {
        this.zzb = zzdq;
        this.zzc = zzbru;
    }

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        zzbru zzbru = this.zzc;
        if (zzbru != null) {
            return zzbru.zzg();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        zzbru zzbru = this.zzc;
        if (zzbru != null) {
            return zzbru.zzh();
        }
        return 0.0f;
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Nullable
    public final zzdt zzi() throws RemoteException {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return null;
            }
            zzdt zzi = zzdq.zzi();
            return zzi;
        }
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

    public final void zzm(@Nullable zzdt zzdt) throws RemoteException {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                zzdq.zzm(zzdt);
            }
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
