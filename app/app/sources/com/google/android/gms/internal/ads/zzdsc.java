package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsc {
    private final zzczj zza;
    private final zzdhg zzb;
    /* access modifiers changed from: private */
    public final zzdas zzc;
    private final zzdbf zzd;
    private final zzdbr zze;
    private final zzdef zzf;
    private final Executor zzg;
    private final zzdhc zzh;
    private final zzcra zzi;
    private final zzb zzj;
    private final zzcaf zzk;
    private final zzaxd zzl;
    /* access modifiers changed from: private */
    public final zzddw zzm;
    private final zzefz zzn;
    private final zzfoe zzo;
    private final zzdvc zzp;
    private final zzcqd zzq;
    private final zzdsi zzr;

    public zzdsc(zzczj zzczj, zzdas zzdas, zzdbf zzdbf, zzdbr zzdbr, zzdef zzdef, Executor executor, zzdhc zzdhc, zzcra zzcra, zzb zzb2, zzcaf zzcaf, zzaxd zzaxd, zzddw zzddw, zzefz zzefz, zzfoe zzfoe, zzdvc zzdvc, zzdhg zzdhg, zzcqd zzcqd, zzdsi zzdsi) {
        this.zza = zzczj;
        this.zzc = zzdas;
        this.zzd = zzdbf;
        this.zze = zzdbr;
        this.zzf = zzdef;
        this.zzg = executor;
        this.zzh = zzdhc;
        this.zzi = zzcra;
        this.zzj = zzb2;
        this.zzk = zzcaf;
        this.zzl = zzaxd;
        this.zzm = zzddw;
        this.zzn = zzefz;
        this.zzo = zzfoe;
        this.zzp = zzdvc;
        this.zzb = zzdhg;
        this.zzq = zzcqd;
        this.zzr = zzdsi;
    }

    public static final ListenableFuture zzj(zzchd zzchd, String str, String str2) {
        zzccn zzccn = new zzccn();
        zzchd.zzN().zzB(new zzdrt(zzccn));
        zzchd.zzae(str, str2, (String) null);
        return zzccn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzchd zzchd, zzchd zzchd2, Map map) {
        this.zzi.zzh(zzchd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzka)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public final void zzi(zzchd zzchd, boolean z, zzbls zzbls) {
        zzawz zzc2;
        zzchd zzchd2 = zzchd;
        zzciv zzN = zzchd.zzN();
        zzdru zzdru = r4;
        zzdru zzdru2 = new zzdru(this);
        zzdrv zzdrv = r4;
        zzdrv zzdrv2 = new zzdrv(this);
        zzdrw zzdrw = r4;
        zzdrw zzdrw2 = new zzdrw(this);
        zzdsb zzdsb = r4;
        zzdsb zzdsb2 = new zzdsb(this);
        zzcaf zzcaf = this.zzk;
        zzefz zzefz = this.zzn;
        zzfoe zzfoe = this.zzo;
        zzdbf zzdbf = this.zzd;
        zzdvc zzdvc = this.zzp;
        zzN.zzR(zzdru, zzdbf, this.zze, zzdrv, zzdrw, z, zzbls, this.zzj, zzdsb, zzcaf, zzefz, zzfoe, zzdvc, (zzbmj) null, this.zzb, (zzbmi) null, (zzbmc) null, (zzblq) null, this.zzq);
        zzchd zzchd3 = zzchd;
        zzchd3.setOnTouchListener(new zzdrx(this));
        zzchd3.setOnClickListener(new zzdry(this));
        if (((Boolean) zzba.zzc().zza(zzbep.zzcD)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzo((View) zzchd3);
        }
        this.zzh.zzo(zzchd3, this.zzg);
        this.zzh.zzo(new zzdrz(zzchd3), this.zzg);
        this.zzh.zza((View) zzchd3);
        zzchd3.zzag("/trackActiveViewUnit", new zzdsa(this, zzchd3));
        this.zzi.zzi(zzchd3);
    }
}
