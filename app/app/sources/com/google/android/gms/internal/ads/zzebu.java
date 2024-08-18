package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzebu {
    private final zzgge zza;
    private final zzeay zzb;
    private final zzhkj zzc;
    private final zzfmq zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;

    public zzebu(zzgge zzgge, zzeay zzeay, zzhkj zzhkj, zzfmq zzfmq, Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgge;
        this.zzb = zzeay;
        this.zzc = zzhkj;
        this.zzd = zzfmq;
        this.zze = context;
        this.zzf = versionInfoParcel;
    }

    private final ListenableFuture zzh(zzbxu zzbxu, zzebt zzebt, zzebt zzebt2, zzgfa zzgfa) {
        ListenableFuture listenableFuture;
        String str = zzbxu.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgft.zzg(new zzebh(1));
        } else {
            listenableFuture = zzgft.zzf(zzebt.zza(zzbxu), ExecutionException.class, new zzebs(), this.zza);
        }
        return zzgft.zzf(zzgft.zzn(zzgft.zzn(zzgfk.zzu(listenableFuture), new zzebq(), this.zza), zzgfa, this.zza), zzebh.class, new zzebr(this, zzebt2, zzbxu, zzgfa), this.zza);
    }

    public final ListenableFuture zza(zzbxu zzbxu) {
        zzebn zzebn = new zzebn(zzbxu);
        zzeay zzeay = this.zzb;
        Objects.requireNonNull(zzeay);
        return zzh(zzbxu, new zzebo(zzeay), new zzebp(this), zzebn);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return zzgft.zzn(zzgfk.zzu(zzgft.zzh(jSONObject)), zzu.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbqe.zza, new zzebj()), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzebt zzebt, zzbxu zzbxu, zzgfa zzgfa, zzebh zzebh) throws Exception {
        return zzgft.zzn(zzebt.zza(zzbxu), zzgfa, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbxu zzbxu) {
        return ((zzedq) this.zzc.zzb()).zzb(zzbxu, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzbxu zzbxu) {
        return this.zzb.zzd(zzbxu.zzh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzbxu zzbxu) {
        return ((zzedq) this.zzc.zzb()).zzi(zzbxu.zzh);
    }

    public final ListenableFuture zzg(zzbxu zzbxu) {
        return zzh(zzbxu, new zzebl(this), new zzebm(this), new zzebk());
    }
}
