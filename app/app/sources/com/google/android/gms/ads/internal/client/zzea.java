package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbb;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbrb;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzea {
    final zzaz zza;
    private final zzbrb zzb;
    private final zzp zzc;
    private final AtomicBoolean zzd;
    /* access modifiers changed from: private */
    public final VideoController zze;
    private zza zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzbu zzj;
    private VideoOptions zzk;
    private String zzl;
    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    public zzea(ViewGroup viewGroup) {
        this(viewGroup, (AttributeSet) null, false, zzp.zza, (zzbu) null, 0);
    }

    private static zzq zzD(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize equals : adSizeArr) {
            if (equals.equals(AdSize.INVALID)) {
                return zzq.zze();
            }
        }
        zzq zzq = new zzq(context, adSizeArr);
        zzq.zzj = zzE(i);
        return zzq;
    }

    private static boolean zzE(int i) {
        return i == 1;
    }

    public final boolean zzA() {
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                return zzbu.zzY();
            }
            return false;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean zzB() {
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                return zzbu.zzZ();
            }
            return false;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final AdSize[] zzC() {
        return this.zzh;
    }

    public final AdListener zza() {
        return this.zzg;
    }

    public final AdSize zzb() {
        zzq zzg2;
        try {
            zzbu zzbu = this.zzj;
            if (!(zzbu == null || (zzg2 = zzbu.zzg()) == null)) {
                return zzb.zzc(zzg2.zze, zzg2.zzb, zzg2.zza);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final OnPaidEventListener zzc() {
        return this.zzp;
    }

    public final ResponseInfo zzd() {
        zzdn zzdn = null;
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzdn = zzbu.zzk();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzdn);
    }

    public final VideoController zzf() {
        return this.zze;
    }

    public final VideoOptions zzg() {
        return this.zzk;
    }

    public final AppEventListener zzh() {
        return this.zzi;
    }

    public final zzdq zzi() {
        zzbu zzbu = this.zzj;
        if (zzbu == null) {
            return null;
        }
        try {
            return zzbu.zzl();
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final String zzj() {
        zzbu zzbu;
        if (this.zzl == null && (zzbu = this.zzj) != null) {
            try {
                this.zzl = zzbu.zzr();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final void zzk() {
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzx();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(IObjectWrapper iObjectWrapper) {
        this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzm(zzdx zzdx) {
        zzbu zzbu;
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzq zzD = zzD(context, this.zzh, this.zzn);
                if ("search_v2".equals(zzD.zza)) {
                    zzbu = (zzbu) new zzal(zzay.zza(), context, zzD, this.zzl).zzd(context, false);
                } else {
                    zzbu = (zzbu) new zzaj(zzay.zza(), context, zzD, this.zzl, this.zzb).zzd(context, false);
                }
                this.zzj = zzbu;
                this.zzj.zzD(new zzg(this.zza));
                zza zza2 = this.zzf;
                if (zza2 != null) {
                    this.zzj.zzC(new zzb(zza2));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzG(new zzbbb(appEventListener));
                }
                if (this.zzk != null) {
                    this.zzj.zzU(new zzfk(this.zzk));
                }
                this.zzj.zzP(new zzfe(this.zzp));
                this.zzj.zzN(this.zzo);
                zzbu zzbu2 = this.zzj;
                if (zzbu2 != null) {
                    try {
                        IObjectWrapper zzn2 = zzbu2.zzn();
                        if (zzn2 != null) {
                            if (((Boolean) zzbgi.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzba.zzc().zza(zzbep.zzlg)).booleanValue()) {
                                    zzf.zza.post(new zzdy(this, zzn2));
                                }
                            }
                            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
                        }
                    } catch (RemoteException e) {
                        zzm.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzbu zzbu3 = this.zzj;
            if (zzbu3 != null) {
                zzbu3.zzab(this.zzc.zza(this.zzm.getContext(), zzdx));
                return;
            }
            throw null;
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzn() {
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzz();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzo() {
        if (!this.zzd.getAndSet(true)) {
            try {
                zzbu zzbu = this.zzj;
                if (zzbu != null) {
                    zzbu.zzA();
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzp() {
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzB();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(zza zza2) {
        zzb zzb2;
        try {
            this.zzf = zza2;
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                if (zza2 != null) {
                    zzb2 = new zzb(zza2);
                } else {
                    zzb2 = null;
                }
                zzbu.zzC(zzb2);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzs(AdSize... adSizeArr) {
        if (this.zzh == null) {
            zzt(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zzt(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzF(zzD(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzu(String str) {
        if (this.zzl == null) {
            this.zzl = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void zzv(AppEventListener appEventListener) {
        zzbbb zzbbb;
        try {
            this.zzi = appEventListener;
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                if (appEventListener != null) {
                    zzbbb = new zzbbb(appEventListener);
                } else {
                    zzbbb = null;
                }
                zzbu.zzG(zzbbb);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzw(boolean z) {
        this.zzo = z;
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzN(z);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzx(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                zzbu.zzP(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzz(zzbu zzbu) {
        try {
            IObjectWrapper zzn2 = zzbu.zzn();
            if (zzn2 == null || ((View) ObjectWrapper.unwrap(zzn2)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzn2));
            this.zzj = zzbu;
            return true;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public zzea(ViewGroup viewGroup, int i) {
        this(viewGroup, (AttributeSet) null, false, zzp.zza, (zzbu) null, i);
    }

    public final void zzy(VideoOptions videoOptions) {
        zzfk zzfk;
        this.zzk = videoOptions;
        try {
            zzbu zzbu = this.zzj;
            if (zzbu != null) {
                if (videoOptions == null) {
                    zzfk = null;
                } else {
                    zzfk = new zzfk(videoOptions);
                }
                zzbu.zzU(zzfk);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzp.zza, (zzbu) null, 0);
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzp.zza, (zzbu) null, i);
    }

    zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzp zzp2, zzbu zzbu, int i) {
        zzq zzq;
        this.zzb = new zzbrb();
        this.zze = new VideoController();
        this.zza = new zzdz(this);
        this.zzm = viewGroup;
        this.zzc = zzp2;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzy zzy = new zzy(context, attributeSet);
                this.zzh = zzy.zzb(z);
                this.zzl = zzy.zza();
                if (viewGroup.isInEditMode()) {
                    zzf zzb2 = zzay.zzb();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzq = zzq.zze();
                    } else {
                        zzq zzq2 = new zzq(context, adSize);
                        zzq2.zzj = zzE(i2);
                        zzq = zzq2;
                    }
                    zzb2.zzn(viewGroup, zzq, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzay.zzb().zzm(viewGroup, new zzq(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
