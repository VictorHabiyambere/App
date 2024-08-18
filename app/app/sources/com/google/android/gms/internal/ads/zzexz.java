package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzexz {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfmn zzd;
    private final zzdvc zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzexz(Context context, Executor executor, Set set, zzfmn zzfmn, zzdvc zzdvc) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfmn;
        this.zze = zzdvc;
    }

    public final ListenableFuture zza(Object obj, Bundle bundle) {
        zzfmc zza2 = zzfmb.zza(this.zza, zzfmu.CUI_NAME_ADREQUEST_SIGNALS);
        zza2.zzj();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) zzba.zzc().zza(zzbep.zzlM)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) zzba.zzc().zza(zzbep.zzlM)).split(","));
        }
        this.zzf = zzu.zzB().elapsedRealtime();
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue() && bundle != null) {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdul.CLIENT_SIGNALS_START.zza(), currentTimeMillis);
            } else {
                bundle.putLong(zzdul.GMS_SIGNALS_START.zza(), currentTimeMillis);
            }
        }
        for (zzexw zzexw : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzexw.zza()))) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzge)).booleanValue() || zzexw.zza() != 44) {
                    long elapsedRealtime = zzu.zzB().elapsedRealtime();
                    ListenableFuture zzb2 = zzexw.zzb();
                    zzb2.addListener(new zzexx(this, elapsedRealtime, zzexw, bundle2), zzcci.zzf);
                    arrayList.add(zzb2);
                }
            }
        }
        ListenableFuture zza3 = zzgft.zzb(arrayList).zza(new zzexy(arrayList, obj, bundle, bundle2), this.zzc);
        if (zzfmq.zza()) {
            zzfmm.zzb(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    public final void zzb(long j, zzexw zzexw, Bundle bundle) {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbgm.zza.zze()).booleanValue()) {
            zze.zza("Signal runtime (ms) : " + zzfyv.zzc(zzexw.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzce)).booleanValue()) {
                synchronized (this) {
                    bundle.putLong("sig" + zzexw.zza(), elapsedRealtime);
                }
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzcb)).booleanValue()) {
            zzdvb zza2 = this.zze.zza();
            zza2.zzb("action", "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzexw.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) zzba.zzc().zza(zzbep.zzcc)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza2.zzb("seq_num", zzu.zzo().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(zzu.zzB().elapsedRealtime() - this.zzf);
                        if (zzexw.zza() <= 39 || zzexw.zza() >= 52) {
                            zza2.zzb("lat_clsg", valueOf);
                        } else {
                            zza2.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza2.zzg();
        }
    }
}
