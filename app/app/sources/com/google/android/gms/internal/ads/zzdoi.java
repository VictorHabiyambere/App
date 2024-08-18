package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdoi implements Callable {
    public final /* synthetic */ zzdoj zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;
    public final /* synthetic */ ListenableFuture zze;
    public final /* synthetic */ ListenableFuture zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ ListenableFuture zzh;
    public final /* synthetic */ ListenableFuture zzi;
    public final /* synthetic */ ListenableFuture zzj;
    public final /* synthetic */ ListenableFuture zzk;

    public /* synthetic */ zzdoi(zzdoj zzdoj, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9) {
        this.zza = zzdoj;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
        this.zze = listenableFuture4;
        this.zzf = listenableFuture5;
        this.zzg = jSONObject;
        this.zzh = listenableFuture6;
        this.zzi = listenableFuture7;
        this.zzj = listenableFuture8;
        this.zzk = listenableFuture9;
    }

    public final Object call() {
        zzdlt zzdlt = (zzdlt) this.zzb.get();
        zzdlt.zzP((List) this.zzc.get());
        zzdlt.zzM((zzbhv) this.zzd.get());
        zzdlt.zzQ((zzbhv) this.zze.get());
        zzdlt.zzJ((zzbho) this.zzf.get());
        JSONObject jSONObject = this.zzg;
        zzdlt.zzS(zzdow.zzj(jSONObject));
        zzdlt.zzL(zzdow.zzi(jSONObject));
        zzchd zzchd = (zzchd) this.zzh.get();
        if (zzchd != null) {
            zzdlt.zzad(zzchd);
            zzdlt.zzac(zzchd.zzF());
            zzdlt.zzab(zzchd.zzq());
        }
        zzchd zzchd2 = (zzchd) this.zzi.get();
        if (zzchd2 != null) {
            zzdlt.zzO(zzchd2);
            zzdlt.zzae(zzchd2.zzF());
        }
        ListenableFuture listenableFuture = this.zzj;
        if (((Boolean) zzba.zzc().zza(zzbep.zzfi)).booleanValue()) {
            zzdlt.zzU(listenableFuture);
            zzdlt.zzX(new zzccn());
        } else {
            zzchd zzchd3 = (zzchd) listenableFuture.get();
            if (zzchd3 != null) {
                zzdlt.zzT(zzchd3);
            }
        }
        for (zzdpa zzdpa : (List) this.zzk.get()) {
            switch (zzdpa.zza) {
                case 1:
                    zzdlt.zzZ(zzdpa.zzb, zzdpa.zzc);
                    break;
                default:
                    zzdlt.zzN(zzdpa.zzb, zzdpa.zzd);
                    break;
            }
        }
        return zzdlt;
    }
}
