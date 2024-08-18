package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeod extends zzbt {
    private final Context zza;
    private final zzbh zzb;
    private final zzfho zzc;
    private final zzcsf zzd;
    private final ViewGroup zze;
    private final zzdvc zzf;

    public zzeod(Context context, zzbh zzbh, zzfho zzfho, zzcsf zzcsf, zzdvc zzdvc) {
        this.zza = context;
        this.zzb = zzbh;
        this.zzc = zzfho;
        this.zzd = zzcsf;
        this.zzf = zzdvc;
        FrameLayout frameLayout = new FrameLayout(this.zza);
        frameLayout.removeAllViews();
        View zzc2 = this.zzd.zzc();
        zzu.zzp();
        frameLayout.addView(zzc2, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzg().zzc);
        frameLayout.setMinimumWidth(zzg().zzf);
        this.zze = frameLayout;
    }

    public final void zzA() throws RemoteException {
        this.zzd.zzg();
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzc((Context) null);
    }

    public final void zzC(zzbe zzbe) throws RemoteException {
        zzm.zzi("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzD(zzbh zzbh) throws RemoteException {
        zzm.zzi("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzE(zzby zzby) throws RemoteException {
        zzm.zzi("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzF(zzq zzq) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcsf zzcsf = this.zzd;
        if (zzcsf != null) {
            zzcsf.zzh(this.zze, zzq);
        }
    }

    public final void zzG(zzcb zzcb) throws RemoteException {
        zzepc zzepc = this.zzc.zzc;
        if (zzepc != null) {
            zzepc.zzm(zzcb);
        }
    }

    public final void zzH(zzbcj zzbcj) throws RemoteException {
    }

    public final void zzI(zzw zzw) throws RemoteException {
    }

    public final void zzJ(zzci zzci) {
    }

    public final void zzK(zzdu zzdu) throws RemoteException {
    }

    public final void zzL(boolean z) throws RemoteException {
    }

    public final void zzM(zzbvp zzbvp) throws RemoteException {
    }

    public final void zzN(boolean z) throws RemoteException {
        zzm.zzi("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzO(zzbfk zzbfk) throws RemoteException {
        zzm.zzi("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzdg zzdg) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlE)).booleanValue()) {
            zzepc zzepc = this.zzc.zzc;
            if (zzepc != null) {
                try {
                    if (!zzdg.zzf()) {
                        this.zzf.zze();
                    }
                } catch (RemoteException e) {
                    zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
                }
                zzepc.zzl(zzdg);
                return;
            }
            return;
        }
        zzm.zzi("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzQ(zzbvs zzbvs, String str) throws RemoteException {
    }

    public final void zzR(String str) throws RemoteException {
    }

    public final void zzS(zzbyn zzbyn) throws RemoteException {
    }

    public final void zzT(String str) throws RemoteException {
    }

    public final void zzU(zzfk zzfk) throws RemoteException {
        zzm.zzi("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
    }

    public final boolean zzY() throws RemoteException {
        zzcsf zzcsf = this.zzd;
        return zzcsf != null && zzcsf.zzr();
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa() throws RemoteException {
        return false;
    }

    public final boolean zzab(zzl zzl) throws RemoteException {
        zzm.zzi("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzac(zzcf zzcf) throws RemoteException {
        zzm.zzi("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzd() throws RemoteException {
        zzm.zzi("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final zzq zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzfhu.zza(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final zzbh zzi() throws RemoteException {
        return this.zzb;
    }

    public final zzcb zzj() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzdn zzk() {
        return this.zzd.zzl();
    }

    public final zzdq zzl() throws RemoteException {
        return this.zzd.zzd();
    }

    public final IObjectWrapper zzn() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final String zzr() throws RemoteException {
        return this.zzc.zzf;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zzg();
        }
        return null;
    }

    public final String zzt() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zzg();
        }
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzb();
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzb((Context) null);
    }
}
