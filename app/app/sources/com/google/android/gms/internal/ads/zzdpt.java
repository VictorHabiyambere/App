package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdpt extends zzbob implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbhh {
    private View zza;
    private zzdq zzb;
    private zzdlo zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdpt(zzdlo zzdlo, zzdlt zzdlt) {
        this.zza = zzdlt.zzf();
        this.zzb = zzdlt.zzj();
        this.zzc = zzdlo;
        if (zzdlt.zzs() != null) {
            zzdlt.zzs().zzap(this);
        }
    }

    private final void zzg() {
        View view;
        zzdlo zzdlo = this.zzc;
        if (zzdlo != null && (view = this.zza) != null) {
            zzdlo.zzB(view, Collections.emptyMap(), Collections.emptyMap(), zzdlo.zzX(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbof zzbof, int i) {
        try {
            zzbof.zze(i);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbhs zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdlo zzdlo = this.zzc;
        if (zzdlo == null || zzdlo.zzc() == null) {
            return null;
        }
        return zzdlo.zzc().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdlo zzdlo = this.zzc;
        if (zzdlo != null) {
            zzdlo.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdps(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbof zzbof) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzm.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbof, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            if (view == null) {
                str = "can not get video view.";
            } else {
                str = "can not get video controller.";
            }
            zzm.zzg("Instream internal error: ".concat(str));
            zzi(zzbof, 0);
        } else if (this.zze) {
            zzm.zzg("Instream ad should not be used again.");
            zzi(zzbof, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzu.zzx();
            zzccv.zza(this.zza, this);
            zzu.zzx();
            zzccv.zzb(this.zza, this);
            zzg();
            try {
                zzbof.zzf();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
