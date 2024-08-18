package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzct;
import com.google.android.gms.ads.internal.client.zzcv;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzcx;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbuo extends NativeAd {
    private final zzbjs zza;
    private final List zzb = new ArrayList();
    private final zzbun zzc;
    private final NativeAd.AdChoicesInfo zzd;
    private final List zze = new ArrayList();

    public zzbuo(zzbjs zzbjs) {
        zzbun zzbun;
        zzcw zzcw;
        zzbhv zzbhv;
        this.zza = zzbjs;
        zzbul zzbul = null;
        try {
            List zzu = this.zza.zzu();
            if (zzu != null) {
                for (Object next : zzu) {
                    if (next instanceof IBinder) {
                        zzbhv = zzbhu.zzg((IBinder) next);
                    } else {
                        zzbhv = null;
                    }
                    if (zzbhv != null) {
                        this.zzb.add(new zzbun(zzbhv));
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
                        this.zze.add(new zzcx(zzcw));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzm.zzh("", e2);
        }
        try {
            zzbhv zzk = this.zza.zzk();
            if (zzk != null) {
                zzbun = new zzbun(zzk);
            } else {
                zzbun = null;
            }
        } catch (RemoteException e3) {
            zzm.zzh("", e3);
            zzbun = null;
        }
        this.zzc = zzbun;
        try {
            if (this.zza.zzi() != null) {
                zzbul = new zzbul(this.zza.zzi());
            }
        } catch (RemoteException e4) {
            zzm.zzh("", e4);
        }
        this.zzd = zzbul;
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzw();
        } catch (RemoteException e) {
            zzm.zzh("Failed to cancelUnconfirmedClick", e);
        }
    }

    public final void destroy() {
        try {
            this.zza.zzx();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzC();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzd;
    }

    public final String getAdvertiser() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String getBody() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle zzf = this.zza.zzf();
            if (zzf != null) {
                return zzf;
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzj() != null) {
                return new zzep(this.zza.zzj(), (zzbip) null);
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
        return null;
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zze;
    }

    public final String getPrice() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn;
        try {
            zzdn = this.zza.zzg();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            zzdn = null;
        }
        return ResponseInfo.zza(zzdn);
    }

    public final Double getStarRating() {
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

    public final String getStore() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            return this.zza.zzG();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zza.zzH();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }

    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (this.zza.zzH()) {
                if (muteThisAdReason == null) {
                    try {
                        this.zza.zzy((zzcw) null);
                        return;
                    } catch (RemoteException e) {
                        zzm.zzh("", e);
                        return;
                    }
                } else if (muteThisAdReason instanceof zzcx) {
                    this.zza.zzy(((zzcx) muteThisAdReason).zza());
                    return;
                } else {
                    zzm.zzg("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                    return;
                }
            }
        } catch (RemoteException e2) {
            zzm.zzh("", e2);
        }
        zzm.zzg("Ad is not custom mute enabled");
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzA();
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

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zza.zzD(new zzct(muteThisAdListener));
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zza.zzE(new zzfe(onPaidEventListener));
        } catch (RemoteException e) {
            zzm.zzh("Failed to setOnPaidEventListener", e);
        }
    }

    public final void setUnconfirmedClickListener(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zza.zzF(new zzbuw(unconfirmedClickListener));
        } catch (RemoteException e) {
            zzm.zzh("Failed to setUnconfirmedClickListener", e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        try {
            return this.zza.zzm();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }
}
