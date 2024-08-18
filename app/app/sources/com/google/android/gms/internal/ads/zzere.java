package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzere implements zzexw {
    private final zzgge zza;
    private final zzdst zzb;
    private final zzdxf zzc;
    private final zzerg zzd;

    public zzere(zzgge zzgge, zzdst zzdst, zzdxf zzdxf, zzerg zzerg) {
        this.zza = zzgge;
        this.zzb = zzdst;
        this.zzc = zzdxf;
        this.zzd = zzerg;
    }

    public final int zza() {
        return 1;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlH)).booleanValue() || this.zzd.zza() == null) {
            if (!zzfyv.zzd((String) zzba.zzc().zza(zzbep.zzbs))) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzlH)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                    this.zzd.zzc(true);
                    return this.zza.zzb(new zzerd(this));
                }
            }
            return zzgft.zzh(new zzerf(new Bundle()));
        }
        zzerf zza2 = this.zzd.zza();
        if (zza2 != null) {
            return zzgft.zzh(zza2);
        }
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzerf zzc() throws Exception {
        List<String> asList = Arrays.asList(((String) zzba.zzc().zza(zzbep.zzbs)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzfim zzc2 = this.zzb.zzc(str, new JSONObject());
                zzc2.zzC();
                boolean zzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) zzba.zzc().zza(zzbep.zzlH)).booleanValue() || zzt) {
                    try {
                        zzbtt zzf = zzc2.zzf();
                        if (zzf != null) {
                            bundle2.putString("sdk_version", zzf.toString());
                        }
                    } catch (zzfhv e) {
                    }
                }
                try {
                    zzbtt zze = zzc2.zze();
                    if (zze != null) {
                        bundle2.putString("adapter_version", zze.toString());
                    }
                } catch (zzfhv e2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfhv e3) {
            }
        }
        zzerf zzerf = new zzerf(bundle);
        if (((Boolean) zzba.zzc().zza(zzbep.zzlH)).booleanValue()) {
            this.zzd.zzb(zzerf);
        }
        return zzerf;
    }
}
