package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcsa extends zzbcf {
    private final zzcrz zza;
    private final zzbu zzb;
    private final zzfcr zzc;
    private boolean zzd = ((Boolean) zzba.zzc().zza(zzbep.zzaH)).booleanValue();
    private final zzdvc zze;

    public zzcsa(zzcrz zzcrz, zzbu zzbu, zzfcr zzfcr, zzdvc zzdvc) {
        this.zza = zzcrz;
        this.zzb = zzbu;
        this.zzc = zzfcr;
        this.zze = zzdvc;
    }

    public final zzbu zze() {
        return this.zzb;
    }

    public final zzdn zzf() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgW)).booleanValue()) {
            return null;
        }
        return this.zza.zzl();
    }

    public final void zzg(boolean z) {
        this.zzd = z;
    }

    public final void zzh(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdg.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdg);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbcn zzbcn) {
        try {
            this.zzc.zzp(zzbcn);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbcn, this.zzd);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
