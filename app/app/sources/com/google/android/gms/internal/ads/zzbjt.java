package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzcx;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbjt extends UnifiedNativeAd {
    private final zzbjs zza;
    private final List zzb = new ArrayList();
    private final zzbhw zzc;
    private final VideoController zzd = new VideoController();
    private final NativeAd.AdChoicesInfo zze;
    private final List zzf = new ArrayList();

    public zzbjt(zzbjs zzbjs) {
        zzbhw zzbhw;
        zzcw zzcw;
        zzbhv zzbhv;
        this.zza = zzbjs;
        zzbhp zzbhp = null;
        try {
            List zzu = this.zza.zzu();
            if (zzu != null) {
                for (Object next : zzu) {
                    if (next instanceof IBinder) {
                        IBinder iBinder = (IBinder) next;
                        if (iBinder == null) {
                            zzbhv = null;
                        } else {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                            zzbhv = queryLocalInterface instanceof zzbhv ? (zzbhv) queryLocalInterface : new zzbht(iBinder);
                        }
                    } else {
                        zzbhv = null;
                    }
                    if (zzbhv != null) {
                        this.zzb.add(new zzbhw(zzbhv));
                    }
                }
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
        try {
            List zzv = this.zza.zzv();
            if (zzv != null) {
                for (Object next2 : zzv) {
                    if (next2 instanceof IBinder) {
                        zzcw = zzcv.zzb((IBinder) next2);
                    } else {
                        zzcw = null;
                    }
                    if (zzcw != null) {
                        this.zzf.add(new zzcx(zzcw));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzm.zzh("", e2);
        }
        try {
            zzbhv zzk = this.zza.zzk();
            if (zzk != null) {
                zzbhw = new zzbhw(zzk);
            } else {
                zzbhw = null;
            }
        } catch (RemoteException e3) {
            zzm.zzh("", e3);
            zzbhw = null;
        }
        this.zzc = zzbhw;
        try {
            if (this.zza.zzi() != null) {
                zzbhp = new zzbhp(this.zza.zzi());
            }
        } catch (RemoteException e4) {
            zzm.zzh("", e4);
        }
        this.zze = zzbhp;
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzI(bundle);
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzB(bundle);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final VideoController zza() {
        try {
            if (this.zza.zzh() != null) {
                this.zzd.zzb(this.zza.zzh());
            }
        } catch (RemoteException e) {
            zzm.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzd;
    }

    public final NativeAd.Image zzb() {
        return this.zzc;
    }

    public final Double zzc() {
        try {
            double zze2 = this.zza.zze();
            if (zze2 == -1.0d) {
                return null;
            }
            return Double.valueOf(zze2);
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final Object zzd() {
        try {
            IObjectWrapper zzl = this.zza.zzl();
            if (zzl != null) {
                return ObjectWrapper.unwrap(zzl);
            }
            return null;
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zze() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zzf() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zzg() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zzh() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zzi() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String zzj() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final List zzk() {
        return this.zzb;
    }
}
