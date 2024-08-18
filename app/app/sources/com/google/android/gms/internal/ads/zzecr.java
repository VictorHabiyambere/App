package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzecr {
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    public final zzdce zzb;
    private final zzebz zzc;
    private final zzflt zzd;
    private final zzfho zze;
    private final VersionInfoParcel zzf;
    private final zzfmq zzg;
    private final zzfmn zzh;
    private final Context zzi;
    private final zzgge zzj;

    zzecr(zzdce zzdce, zzebz zzebz, zzflt zzflt, zzfho zzfho, VersionInfoParcel versionInfoParcel, zzfmq zzfmq, zzfmn zzfmn, Context context, zzgge zzgge) {
        this.zzb = zzdce;
        this.zzc = zzebz;
        this.zzd = zzflt;
        this.zze = zzfho;
        this.zzf = versionInfoParcel;
        this.zzg = zzfmq;
        this.zzh = zzfmn;
        this.zzi = context;
        this.zzj = zzgge;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbwz zza(zzbxu zzbxu, zzeec zzeec) {
        zzeec.zzc.put(HttpHeaders.CONTENT_TYPE, zzeec.zze);
        zzeec.zzc.put(HttpHeaders.USER_AGENT, zzu.zzp().zzc(this.zzi, zzbxu.zzb.afmaVersion));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzeec.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbwz(zzeec.zza, zzeec.zzb, bundle, zzeec.zzd, zzeec.zzf, zzbxu.zzd, zzbxu.zzh);
    }

    public final ListenableFuture zzc(zzbxu zzbxu, JSONObject jSONObject, zzbxx zzbxx) {
        this.zzb.zzdn(zzbxu);
        zzflk zzb2 = this.zzd.zzb(zzfln.PROXY, zzgft.zzm(this.zzd.zzb(zzfln.PREPARE_HTTP_REQUEST, zzgft.zzh(new zzeeg(jSONObject, zzbxx))).zze(new zzeeh(zzbxu.zzg, this.zzh, zzfmb.zza(this.zzi, zzfmu.CUI_NAME_ADREQUEST_BUILDURL))).zza(), new zzecn(this, zzbxu), this.zzj));
        zzebz zzebz = this.zzc;
        Objects.requireNonNull(zzebz);
        this.zza = zzb2.zzf(new zzeco(zzebz)).zza();
        ListenableFuture listenableFuture = this.zza;
        ListenableFuture zzn = zzgft.zzn(this.zzd.zzb(zzfln.PRE_PROCESS, listenableFuture).zze(new zzecm(jSONObject, zzbxx)).zzf(zzu.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzedp.zza, zzbqe.zzb)).zza(), new zzecp(this, zzbxu), this.zzj);
        zzgft.zzr(zzn, new zzecq(this), this.zzj);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbxu zzbxu, InputStream inputStream) throws Exception {
        return zzgft.zzh(new zzfhf(new zzfhc(this.zze), zzfhe.zza(new InputStreamReader(inputStream), zzbxu)));
    }
}
