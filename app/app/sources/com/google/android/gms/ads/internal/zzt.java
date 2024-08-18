package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.client.zzay;
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
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxd;
import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzbfk;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbyn;
import com.google.android.gms.internal.ads.zzcci;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzt extends zzbt {
    /* access modifiers changed from: private */
    public final VersionInfoParcel zza;
    private final zzq zzb;
    /* access modifiers changed from: private */
    public final Future zzc = zzcci.zza.zzb(new zzp(this));
    /* access modifiers changed from: private */
    public final Context zzd;
    private final zzs zze;
    /* access modifiers changed from: private */
    public WebView zzf = new WebView(this.zzd);
    /* access modifiers changed from: private */
    public zzbh zzg;
    /* access modifiers changed from: private */
    public zzaxd zzh;
    private AsyncTask zzi;

    public zzt(Context context, zzq zzq, String str, VersionInfoParcel versionInfoParcel) {
        this.zzd = context;
        this.zza = versionInfoParcel;
        this.zzb = zzq;
        this.zze = new zzs(context, str);
        zzV(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzn(this));
        this.zzf.setOnTouchListener(new zzo(this));
    }

    static /* bridge */ /* synthetic */ String zzo(zzt zzt, String str) {
        if (zzt.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzt.zzh.zza(parse, zzt.zzd, (View) null, (Activity) null);
        } catch (zzaxe e) {
            zzm.zzk("Unable to process ad data", e);
        }
        return parse.toString();
    }

    static /* bridge */ /* synthetic */ void zzw(zzt zzt, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzt.zzd.startActivity(intent);
    }

    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbe zzbe) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(zzbh zzbh) throws RemoteException {
        this.zzg = zzbh;
    }

    public final void zzE(zzby zzby) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzF(zzq zzq) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzG(zzcb zzcb) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzbcj zzbcj) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzw zzw) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(zzci zzci) {
    }

    public final void zzK(zzdu zzdu) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzL(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzM(zzbvp zzbvp) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzN(boolean z) throws RemoteException {
    }

    public final void zzO(zzbfk zzbfk) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzP(zzdg zzdg) {
    }

    public final void zzQ(zzbvs zzbvs, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzS(zzbyn zzbyn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzT(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzU(zzfk zzfk) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final void zzV(int i) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa() throws RemoteException {
        return false;
    }

    public final boolean zzab(zzl zzl) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzl, this.zza);
        this.zzi = new zzr(this, (zzq) null).execute(new Void[0]);
        return true;
    }

    public final void zzac(zzcf zzcf) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzay.zzb();
            return zzf.zzy(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    public final zzq zzg() throws RemoteException {
        return this.zzb;
    }

    public final zzbh zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final zzcb zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzdn zzk() {
        return null;
    }

    public final zzdq zzl() {
        return null;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final String zzp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath((String) zzbfx.zzd.zze());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zze.zzd());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        builder.appendQueryParameter("mappver", this.zze.zza());
        Map zze2 = this.zze.zze();
        for (String str : zze2.keySet()) {
            builder.appendQueryParameter(str, (String) zze2.get(str));
        }
        Uri build = builder.build();
        zzaxd zzaxd = this.zzh;
        if (zzaxd != null) {
            try {
                build = zzaxd.zzb(build, this.zzd);
            } catch (zzaxe e) {
                zzm.zzk("Unable to process ad data", e);
            }
        }
        String zzq = zzq();
        String encodedQuery = build.getEncodedQuery();
        return zzq + "#" + encodedQuery;
    }

    /* access modifiers changed from: package-private */
    public final String zzq() {
        String zzb2 = this.zze.zzb();
        if (true == TextUtils.isEmpty(zzb2)) {
            zzb2 = "www.google.com";
        }
        return "https://" + zzb2 + ((String) zzbfx.zzd.zze());
    }

    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final String zzs() throws RemoteException {
        return null;
    }

    public final String zzt() throws RemoteException {
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(false);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
