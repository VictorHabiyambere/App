package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzemz extends zzbrk {
    private final zzczj zza;
    private final zzdhg zzb;
    private final zzdad zzc;
    private final zzdas zzd;
    private final zzdax zze;
    private final zzdef zzf;
    private final zzdbr zzg;
    private final zzdid zzh;
    private final zzdeb zzi;
    private final zzczy zzj;

    public zzemz(zzczj zzczj, zzdhg zzdhg, zzdad zzdad, zzdas zzdas, zzdax zzdax, zzdef zzdef, zzdbr zzdbr, zzdid zzdid, zzdeb zzdeb, zzczy zzczy) {
        this.zza = zzczj;
        this.zzb = zzdhg;
        this.zzc = zzdad;
        this.zzd = zzdas;
        this.zze = zzdax;
        this.zzf = zzdef;
        this.zzg = zzdbr;
        this.zzh = zzdid;
        this.zzi = zzdeb;
        this.zzj = zzczy;
    }

    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdG();
    }

    public final void zzf() {
        this.zzg.zzdu(4);
    }

    public final void zzg(int i) {
    }

    public final void zzh(zze zze2) {
    }

    public final void zzi(int i, String str) {
    }

    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new zze(i, "", AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public final void zzk(zze zze2) {
        this.zzj.zza(zzfiq.zzc(8, zze2));
    }

    public final void zzl(String str) {
        zzk(new zze(0, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    public final void zzn() {
        this.zzd.zzb();
    }

    public final void zzo() {
        this.zze.zzs();
    }

    public final void zzp() {
        this.zzg.zzdr();
        this.zzi.zza();
    }

    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    public final void zzr(zzbip zzbip, String str) {
    }

    public void zzs(zzbyt zzbyt) {
    }

    public void zzt(zzbyx zzbyx) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() {
        this.zzh.zza();
    }

    public final void zzw() {
        this.zzh.zzb();
    }

    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }
}
