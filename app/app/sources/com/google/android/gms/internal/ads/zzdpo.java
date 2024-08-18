package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdpo {
    private final zzfho zza;
    private final Executor zzb;
    private final zzdsd zzc;
    private final zzdqy zzd;
    private final Context zze;
    private final zzdvc zzf;
    private final zzfoe zzg;
    private final zzefz zzh;

    public zzdpo(zzfho zzfho, Executor executor, zzdsd zzdsd, Context context, zzdvc zzdvc, zzfoe zzfoe, zzefz zzefz, zzdqy zzdqy) {
        this.zza = zzfho;
        this.zzb = executor;
        this.zzc = zzdsd;
        this.zze = context;
        this.zzf = zzdvc;
        this.zzg = zzfoe;
        this.zzh = zzefz;
        this.zzd = zzdqy;
    }

    private final void zzh(zzchd zzchd) {
        zzj(zzchd);
        zzchd.zzag("/video", zzblo.zzl);
        zzchd.zzag("/videoMeta", zzblo.zzm);
        zzchd.zzag("/precache", new zzcfq());
        zzchd.zzag("/delayPageLoaded", zzblo.zzp);
        zzchd.zzag("/instrument", zzblo.zzn);
        zzchd.zzag("/log", zzblo.zzg);
        zzchd.zzag("/click", new zzbkn((zzdhi) null, (zzcqd) null));
        if (this.zza.zzb != null) {
            zzchd.zzN().zzE(true);
            zzchd.zzag("/open", new zzbmb((zzb) null, (zzbud) null, (zzefz) null, (zzdvc) null, (zzcqd) null));
        } else {
            zzchd.zzN().zzE(false);
        }
        if (zzu.zzn().zzp(zzchd.getContext())) {
            Map hashMap = new HashMap();
            if (zzchd.zzD() != null) {
                hashMap = zzchd.zzD().zzax;
            }
            zzchd.zzag("/logScionEvent", new zzblv(zzchd.getContext(), hashMap));
        }
    }

    private final void zzi(zzchd zzchd, zzccm zzccm) {
        if (!(this.zza.zza == null || zzchd.zzq() == null)) {
            zzchd.zzq().zzs(this.zza.zza);
        }
        zzccm.zzb();
    }

    private static final void zzj(zzchd zzchd) {
        zzchd.zzag("/videoClicked", zzblo.zzh);
        zzchd.zzN().zzG(true);
        zzchd.zzag("/getNativeAdViewSignals", zzblo.zzs);
        zzchd.zzag("/getNativeClickMeta", zzblo.zzt);
    }

    public final ListenableFuture zza(JSONObject jSONObject) {
        return zzgft.zzn(zzgft.zzn(zzgft.zzh((Object) null), new zzdpf(this), this.zzb), new zzdpe(this, jSONObject), this.zzb);
    }

    public final ListenableFuture zzb(String str, String str2, zzfgt zzfgt, zzfgw zzfgw, zzq zzq) {
        return zzgft.zzn(zzgft.zzh((Object) null), new zzdpd(this, zzq, zzfgt, zzfgw, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, zzchd zzchd) throws Exception {
        zzccm zza2 = zzccm.zza(zzchd);
        if (this.zza.zzb != null) {
            zzchd.zzaj(zzcix.zzd());
        } else {
            zzchd.zzaj(zzcix.zze());
        }
        zzchd.zzN().zzB(new zzdpg(this, zzchd, zza2));
        zzchd.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzq zzq, zzfgt zzfgt, zzfgw zzfgw, String str, String str2, Object obj) throws Exception {
        zzchd zza2 = this.zzc.zza(zzq, zzfgt, zzfgw);
        zzccm zza3 = zzccm.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzaj(zzcix.zzd());
        } else {
            zzdqv zzb2 = this.zzd.zzb();
            zzdqv zzdqv = zzb2;
            zzciv zzN = zza2.zzN();
            zzb zzb3 = r11;
            zzb zzb4 = new zzb(this.zze, (zzcaf) null, (zzbwx) null);
            zzN.zzR(zzb2, zzdqv, zzb2, zzb2, zzb2, false, (zzbls) null, zzb3, (zzbuk) null, (zzcaf) null, this.zzh, this.zzg, this.zzf, (zzbmj) null, zzb2, (zzbmi) null, (zzbmc) null, (zzblq) null, (zzcqd) null);
            zzj(zza2);
        }
        zza2.zzN().zzB(new zzdph(this, zza2, zza3));
        zza2.zzae(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzchd zza2 = this.zzc.zza(zzq.zzc(), (zzfgt) null, (zzfgw) null);
        zzccm zza3 = zzccm.zza(zza2);
        zzh(zza2);
        zza2.zzN().zzH(new zzdpi(zza3));
        zza2.loadUrl((String) zzba.zzc().zza(zzbep.zzdM));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzchd zzchd, zzccm zzccm, boolean z, int i, String str, String str2) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdU)).booleanValue()) {
            zzi(zzchd, zzccm);
        } else if (z) {
            zzi(zzchd, zzccm);
        } else {
            zzccm.zzd(new zzelj(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzchd zzchd, zzccm zzccm, boolean z, int i, String str, String str2) {
        if (z) {
            if (!(this.zza.zza == null || zzchd.zzq() == null)) {
                zzchd.zzq().zzs(this.zza.zza);
            }
            zzccm.zzb();
            return;
        }
        zzccm.zzd(new zzelj(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
