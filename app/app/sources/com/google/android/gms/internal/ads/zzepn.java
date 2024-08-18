package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzepn {
    private final zzeps zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public zzdn zzc;

    public zzepn(zzeps zzeps, String str) {
        this.zza = zzeps;
        this.zzb = str;
    }

    public final synchronized String zza() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return str;
    }

    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return str;
    }

    public final synchronized void zzd(zzl zzl, int i) throws RemoteException {
        this.zzc = null;
        zzept zzept = new zzept(i);
        zzepm zzepm = new zzepm(this);
        this.zza.zzb(zzl, this.zzb, zzept, zzepm);
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
