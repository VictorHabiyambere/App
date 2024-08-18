package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdlt {
    private int zza;
    private zzdq zzb;
    private zzbho zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzel zzg;
    private Bundle zzh;
    private zzchd zzi;
    private zzchd zzj;
    private zzchd zzk;
    private zzehg zzl;
    private ListenableFuture zzm;
    private zzccn zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbhv zzs;
    private zzbhv zzt;
    private String zzu;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private float zzx;
    private String zzy;

    public static zzdlt zzag(zzbrq zzbrq) {
        try {
            zzdls zzak = zzak(zzbrq.zzg(), (zzbru) null);
            zzbho zzh2 = zzbrq.zzh();
            String zzo2 = zzbrq.zzo();
            List zzr2 = zzbrq.zzr();
            String zzm2 = zzbrq.zzm();
            Bundle zzf2 = zzbrq.zzf();
            String zzn2 = zzbrq.zzn();
            IObjectWrapper zzl2 = zzbrq.zzl();
            String zzq2 = zzbrq.zzq();
            String zzp2 = zzbrq.zzp();
            double zze2 = zzbrq.zze();
            zzbhv zzi2 = zzbrq.zzi();
            zzdlt zzdlt = new zzdlt();
            zzdlt.zza = 2;
            zzdlt.zzb = zzak;
            zzdlt.zzc = zzh2;
            zzdlt.zzd = (View) zzam(zzbrq.zzj());
            zzdlt.zzZ("headline", zzo2);
            zzdlt.zze = zzr2;
            zzdlt.zzZ("body", zzm2);
            zzdlt.zzh = zzf2;
            zzdlt.zzZ("call_to_action", zzn2);
            zzdlt.zzo = (View) zzam(zzbrq.zzk());
            zzdlt.zzq = zzl2;
            zzdlt.zzZ("store", zzq2);
            zzdlt.zzZ("price", zzp2);
            zzdlt.zzr = zze2;
            zzdlt.zzs = zzi2;
            return zzdlt;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdlt zzah(zzbrr zzbrr) {
        try {
            zzdls zzak = zzak(zzbrr.zzf(), (zzbru) null);
            zzbho zzg2 = zzbrr.zzg();
            String zzo2 = zzbrr.zzo();
            List zzp2 = zzbrr.zzp();
            String zzm2 = zzbrr.zzm();
            Bundle zze2 = zzbrr.zze();
            String zzn2 = zzbrr.zzn();
            IObjectWrapper zzk2 = zzbrr.zzk();
            String zzl2 = zzbrr.zzl();
            zzbhv zzh2 = zzbrr.zzh();
            zzdlt zzdlt = new zzdlt();
            zzdlt.zza = 1;
            zzdlt.zzb = zzak;
            zzdlt.zzc = zzg2;
            zzdlt.zzd = (View) zzam(zzbrr.zzi());
            zzdlt.zzZ("headline", zzo2);
            zzdlt.zze = zzp2;
            zzdlt.zzZ("body", zzm2);
            zzdlt.zzh = zze2;
            zzdlt.zzZ("call_to_action", zzn2);
            zzdlt.zzo = (View) zzam(zzbrr.zzj());
            zzdlt.zzq = zzk2;
            zzdlt.zzZ("advertiser", zzl2);
            zzdlt.zzt = zzh2;
            return zzdlt;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdlt zzai(zzbrq zzbrq) {
        try {
            return zzal(zzak(zzbrq.zzg(), (zzbru) null), zzbrq.zzh(), (View) zzam(zzbrq.zzj()), zzbrq.zzo(), zzbrq.zzr(), zzbrq.zzm(), zzbrq.zzf(), zzbrq.zzn(), (View) zzam(zzbrq.zzk()), zzbrq.zzl(), zzbrq.zzq(), zzbrq.zzp(), zzbrq.zze(), zzbrq.zzi(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdlt zzaj(zzbrr zzbrr) {
        try {
            return zzal(zzak(zzbrr.zzf(), (zzbru) null), zzbrr.zzg(), (View) zzam(zzbrr.zzi()), zzbrr.zzo(), zzbrr.zzp(), zzbrr.zzm(), zzbrr.zze(), zzbrr.zzn(), (View) zzam(zzbrr.zzj()), zzbrr.zzk(), (String) null, (String) null, -1.0d, zzbrr.zzh(), zzbrr.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdls zzak(zzdq zzdq, zzbru zzbru) {
        if (zzdq == null) {
            return null;
        }
        return new zzdls(zzdq, zzbru);
    }

    private static zzdlt zzal(zzdq zzdq, zzbho zzbho, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbhv zzbhv, String str6, float f) {
        zzdlt zzdlt = new zzdlt();
        zzdlt.zza = 6;
        zzdlt.zzb = zzdq;
        zzdlt.zzc = zzbho;
        zzdlt.zzd = view;
        String str7 = str;
        zzdlt.zzZ("headline", str);
        zzdlt.zze = list;
        String str8 = str2;
        zzdlt.zzZ("body", str2);
        zzdlt.zzh = bundle;
        String str9 = str3;
        zzdlt.zzZ("call_to_action", str3);
        zzdlt.zzo = view2;
        zzdlt.zzq = iObjectWrapper;
        String str10 = str4;
        zzdlt.zzZ("store", str4);
        String str11 = str5;
        zzdlt.zzZ("price", str5);
        zzdlt.zzr = d;
        zzdlt.zzs = zzbhv;
        zzdlt.zzZ("advertiser", str6);
        zzdlt.zzR(f);
        return zzdlt;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdlt zzt(zzbru zzbru) {
        try {
            return zzal(zzak(zzbru.zzj(), zzbru), zzbru.zzk(), (View) zzam(zzbru.zzm()), zzbru.zzs(), zzbru.zzv(), zzbru.zzq(), zzbru.zzi(), zzbru.zzr(), (View) zzam(zzbru.zzn()), zzbru.zzo(), zzbru.zzu(), zzbru.zzt(), zzbru.zze(), zzbru.zzl(), zzbru.zzp(), zzbru.zzf());
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzchd zzchd = this.zzi;
        if (zzchd != null) {
            zzchd.destroy();
            this.zzi = null;
        }
        zzchd zzchd2 = this.zzj;
        if (zzchd2 != null) {
            zzchd2.destroy();
            this.zzj = null;
        }
        zzchd zzchd3 = this.zzk;
        if (zzchd3 != null) {
            zzchd3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzccn zzccn = this.zzn;
        if (zzccn != null) {
            zzccn.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbho zzbho) {
        this.zzc = zzbho;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(zzel zzel) {
        this.zzg = zzel;
    }

    public final synchronized void zzM(zzbhv zzbhv) {
        this.zzs = zzbhv;
    }

    public final synchronized void zzN(String str, zzbhi zzbhi) {
        if (zzbhi == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbhi);
        }
    }

    public final synchronized void zzO(zzchd zzchd) {
        this.zzj = zzchd;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbhv zzbhv) {
        this.zzt = zzbhv;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzchd zzchd) {
        this.zzk = zzchd;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzehg zzehg) {
        this.zzl = zzehg;
    }

    public final synchronized void zzX(zzccn zzccn) {
        this.zzn = zzccn;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(zzdq zzdq) {
        this.zzb = zzdq;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzchd zzchd) {
        this.zzi = zzchd;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized zzdq zzj() {
        return this.zzb;
    }

    public final synchronized zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbho zzl() {
        return this.zzc;
    }

    public final zzbhv zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbhu.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbhv zzn() {
        return this.zzs;
    }

    public final synchronized zzbhv zzo() {
        return this.zzt;
    }

    public final synchronized zzccn zzp() {
        return this.zzn;
    }

    public final synchronized zzchd zzq() {
        return this.zzj;
    }

    public final synchronized zzchd zzr() {
        return this.zzk;
    }

    public final synchronized zzchd zzs() {
        return this.zzi;
    }

    public final synchronized zzehg zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
