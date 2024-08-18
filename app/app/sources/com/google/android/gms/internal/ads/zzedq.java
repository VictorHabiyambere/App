package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzedq extends zzbxc {
    private final Context zza;
    private final zzgge zzb;
    private final zzeei zzc;
    private final zzcoq zzd;
    private final ArrayDeque zze;
    private final zzfmq zzf;
    private final zzbyd zzg;
    private final zzeef zzh;

    public zzedq(Context context, zzgge zzgge, zzbyd zzbyd, zzcoq zzcoq, zzeei zzeei, ArrayDeque arrayDeque, zzeef zzeef, zzfmq zzfmq) {
        zzbep.zza(context);
        this.zza = context;
        this.zzb = zzgge;
        this.zzg = zzbyd;
        this.zzc = zzeei;
        this.zzd = zzcoq;
        this.zze = arrayDeque;
        this.zzh = zzeef;
        this.zzf = zzfmq;
    }

    private final synchronized zzedn zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzedn zzedn = (zzedn) it.next();
            if (zzedn.zzc.equals(str)) {
                it.remove();
                return zzedn;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzflt zzflt, zzbqh zzbqh, zzfmn zzfmn, zzfmc zzfmc) {
        zzbpx zza2 = zzbqh.zza("AFMA_getAdDictionary", zzbqe.zza, new zzedi());
        zzfmm.zze(listenableFuture, zzfmc);
        zzfky zza3 = zzflt.zzb(zzfln.BUILD_URL, listenableFuture).zzf(zza2).zza();
        zzfmm.zzd(zza3, zzfmn, zzfmc);
        return zza3;
    }

    private static ListenableFuture zzm(zzbxu zzbxu, zzflt zzflt, zzeyv zzeyv) {
        zzedc zzedc = new zzedc(zzeyv, zzbxu);
        return zzflt.zzb(zzfln.GMS_SIGNALS, zzgft.zzh(zzbxu.zza)).zzf(zzedc).zze(new zzedd()).zza();
    }

    private final synchronized void zzn(zzedn zzedn) {
        zzo();
        this.zze.addLast(zzedn);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbgr.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbxn zzbxn, zzbxu zzbxu) {
        zzgft.zzr(zzgft.zzn(listenableFuture, new zzedj(this), zzcci.zza), new zzedm(this, zzbxn, zzbxu), zzcci.zzf);
    }

    public final ListenableFuture zzb(zzbxu zzbxu, int i) {
        if (!((Boolean) zzbgr.zza.zze()).booleanValue()) {
            return zzgft.zzg(new Exception("Split request is disabled."));
        }
        zzfjj zzfjj = zzbxu.zzi;
        if (zzfjj == null) {
            return zzgft.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfjj.zzc == 0 || zzfjj.zzd == 0) {
            return zzgft.zzg(new Exception("Caching is disabled."));
        }
        zzbqh zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzeyv zzr = this.zzd.zzr(zzbxu, i);
        zzflt zzc2 = zzr.zzc();
        ListenableFuture zzm = zzm(zzbxu, zzc2, zzr);
        zzfmn zzd2 = zzr.zzd();
        zzfmc zza2 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_BUILDURL);
        ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfln.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new zzedg(this, zzl, zzm, zzbxu, zza2)).zza();
    }

    public final ListenableFuture zzc(zzbxu zzbxu, int i) {
        zzedn zzedn;
        zzfky zzfky;
        zzbqh zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzeyv zzr = this.zzd.zzr(zzbxu, i);
        zzbpx zza2 = zzb2.zza("google.afma.response.normalize", zzedp.zza, zzbqe.zzb);
        if (!((Boolean) zzbgr.zza.zze()).booleanValue()) {
            String str = zzbxu.zzj;
            zzedn = null;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzedn = zzk(zzbxu.zzh);
            if (zzedn == null) {
                zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        zzfmc zza3 = zzedn == null ? zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_BUILDURL) : zzedn.zze;
        zzfmn zzd2 = zzr.zzd();
        zzd2.zze(zzbxu.zza.getStringArrayList("ad_types"));
        zzeeh zzeeh = new zzeeh(zzbxu.zzg, zzd2, zza3);
        zzeee zzeee = new zzeee(this.zza, zzbxu.zzb.afmaVersion, this.zzg, i);
        zzflt zzc2 = zzr.zzc();
        zzfmc zza4 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_PARSERESPONSE);
        if (zzedn == null) {
            ListenableFuture zzm = zzm(zzbxu, zzc2, zzr);
            ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zza3);
            zzfmc zza5 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_REQUEST);
            zzfky zza6 = zzc2.zza(zzfln.HTTP, zzl, zzm).zza(new zzede(zzl, zzbxu, zzm)).zze(zzeeh).zze(new zzfmi(zza5)).zze(zzeee).zza();
            zzfmm.zzb(zza6, zzd2, zza5);
            zzfmm.zze(zza6, zza4);
            zzfky = zzc2.zza(zzfln.PRE_PROCESS, zzm, zzl, zza6).zza(new zzedf(zzbxu, zza6, zzm, zzl)).zzf(zza2).zza();
        } else {
            zzeeg zzeeg = new zzeeg(zzedn.zzb, zzedn.zza);
            zzfmc zza7 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_REQUEST);
            zzfky zza8 = zzc2.zzb(zzfln.HTTP, zzgft.zzh(zzeeg)).zze(zzeeh).zze(new zzfmi(zza7)).zze(zzeee).zza();
            zzfmm.zzb(zza8, zzd2, zza7);
            ListenableFuture zzh2 = zzgft.zzh(zzedn);
            zzfmm.zze(zza8, zza4);
            zzfky = zzc2.zza(zzfln.PRE_PROCESS, zza8, zzh2).zza(new zzedb(zza8, zzh2)).zzf(zza2).zza();
        }
        zzfmm.zzb(zzfky, zzd2, zza4);
        return zzfky;
    }

    public final ListenableFuture zzd(zzbxu zzbxu, int i) {
        zzbqh zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbgw.zza.zze()).booleanValue()) {
            return zzgft.zzg(new Exception("Signal collection disabled."));
        }
        zzeyv zzr = this.zzd.zzr(zzbxu, i);
        zzexz zza2 = zzr.zza();
        zzbpx zza3 = zzb2.zza("google.afma.request.getSignals", zzbqe.zza, zzbqe.zzb);
        zzfmc zza4 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_SCAR_SIGNALS);
        zzfky zza5 = zzr.zzc().zzb(zzfln.GET_SIGNALS, zzgft.zzh(zzbxu.zza)).zze(new zzfmi(zza4)).zzf(new zzedk(zza2, zzbxu)).zzb(zzfln.JS_SIGNALS).zzf(zza3).zza();
        zzfmn zzd2 = zzr.zzd();
        zzd2.zze(zzbxu.zza.getStringArrayList("ad_types"));
        zzd2.zzg(zzbxu.zza.getBundle("extras"));
        zzfmm.zzc(zza5, zzd2, zza4);
        if (((Boolean) zzbgk.zzg.zze()).booleanValue()) {
            zzeei zzeei = this.zzc;
            Objects.requireNonNull(zzeei);
            zza5.addListener(new zzedh(zzeei), this.zzb);
        }
        return zza5;
    }

    public final void zze(zzbxu zzbxu, zzbxn zzbxn) {
        zzp(zzb(zzbxu, Binder.getCallingUid()), zzbxn, zzbxu);
    }

    public final void zzf(zzbxu zzbxu, zzbxn zzbxn) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue() && (bundle = zzbxu.zzm) != null) {
            bundle.putLong(zzdul.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        zzp(zzd(zzbxu, Binder.getCallingUid()), zzbxn, zzbxu);
    }

    public final void zzg(zzbxu zzbxu, zzbxn zzbxn) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue() && (bundle = zzbxu.zzm) != null) {
            bundle.putLong(zzdul.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        ListenableFuture zzc2 = zzc(zzbxu, Binder.getCallingUid());
        zzp(zzc2, zzbxn, zzbxu);
        if (((Boolean) zzbgk.zze.zze()).booleanValue()) {
            zzeei zzeei = this.zzc;
            Objects.requireNonNull(zzeei);
            zzc2.addListener(new zzedh(zzeei), this.zzb);
        }
    }

    public final void zzh(String str, zzbxn zzbxn) {
        zzp(zzi(str), zzbxn, (zzbxu) null);
    }

    public final ListenableFuture zzi(String str) {
        if (!((Boolean) zzbgr.zza.zze()).booleanValue()) {
            return zzgft.zzg(new Exception("Split request is disabled."));
        }
        zzedl zzedl = new zzedl(this);
        if (zzk(str) == null) {
            return zzgft.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzgft.zzh(zzedl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbxu zzbxu, zzfmc zzfmc) throws Exception {
        String zze2 = ((zzbxx) listenableFuture.get()).zze();
        String str = zzbxu.zzh;
        zzn(new zzedn((zzbxx) listenableFuture.get(), (JSONObject) listenableFuture2.get(), str, zze2, zzfmc));
        return new ByteArrayInputStream(zze2.getBytes(zzfxs.zzc));
    }
}
