package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeay extends zzeas {
    private String zzg;
    private int zzh = 1;

    zzeay(Context context) {
        this.zzf = new zzbwr(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzebh(1));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zze(this.zze, new zzear(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzear(this));
                    } else {
                        this.zza.zzd(new zzebh(1));
                    }
                } catch (RemoteException e) {
                    this.zza.zzd(new zzebh(1));
                } catch (IllegalArgumentException e2) {
                    this.zza.zzd(new zzebh(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzebh(1));
                }
            }
        }
    }

    public final ListenableFuture zza(zzbxu zzbxu) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                ListenableFuture zzg2 = zzgft.zzg(new zzebh(2));
                return zzg2;
            } else if (this.zzc) {
                zzccn zzccn = this.zza;
                return zzccn;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbxu;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzeaw(this), zzcci.zzf);
                zzccn zzccn2 = this.zza;
                return zzccn2;
            }
        }
    }

    public final ListenableFuture zzd(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                ListenableFuture zzg2 = zzgft.zzg(new zzebh(2));
                return zzg2;
            } else if (this.zzc) {
                zzccn zzccn = this.zza;
                return zzccn;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzeax(this), zzcci.zzf);
                zzccn zzccn2 = this.zza;
                return zzccn2;
            }
        }
    }
}
