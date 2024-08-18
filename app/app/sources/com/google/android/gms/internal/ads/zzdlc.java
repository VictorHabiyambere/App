package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdlc extends zzbhr {
    private final zzdlt zza;
    private IObjectWrapper zzb;

    public zzdlc(zzdlt zzdlt) {
        this.zza = zzdlt;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float zze() throws RemoteException {
        float f;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgv)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e) {
                zzm.zzh("Remote exception getting video controller aspect ratio.", e);
                return 0.0f;
            }
        } else {
            IObjectWrapper iObjectWrapper = this.zzb;
            if (iObjectWrapper != null) {
                return zzb(iObjectWrapper);
            }
            zzbhv zzm = this.zza.zzm();
            if (zzm == null) {
                return 0.0f;
            }
            if (zzm.zzd() == -1 || zzm.zzc() == -1) {
                f = 0.0f;
            } else {
                f = ((float) zzm.zzd()) / ((float) zzm.zzc());
            }
            if (f == 0.0f) {
                return zzb(zzm.zzf());
            }
            return f;
        }
    }

    public final float zzf() throws RemoteException {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    public final zzdq zzh() throws RemoteException {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue()) {
            return null;
        }
        return this.zza.zzj();
    }

    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzbhv zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        return zzm.zzf();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final boolean zzk() throws RemoteException {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue()) {
            return false;
        }
        return this.zza.zzaf();
    }

    public final boolean zzl() throws RemoteException {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue() && this.zza.zzj() != null) {
            return true;
        }
        return false;
    }

    public final void zzm(zzbjd zzbjd) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzgw)).booleanValue() && (this.zza.zzj() instanceof zzcif)) {
            ((zzcif) this.zza.zzj()).zzv(zzbjd);
        }
    }
}
