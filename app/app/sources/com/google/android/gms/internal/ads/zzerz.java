package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzerz implements zzexw {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final long zze;
    private final zzcwj zzf;
    private final zzfiw zzg;
    private final zzfho zzh;
    private final zzg zzi = zzu.zzo().zzi();
    private final zzdux zzj;
    private final zzcww zzk;

    public zzerz(Context context, String str, String str2, zzcwj zzcwj, zzfiw zzfiw, zzfho zzfho, zzdux zzdux, zzcww zzcww, long j) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzcwj;
        this.zzg = zzfiw;
        this.zzh = zzfho;
        this.zzj = zzdux;
        this.zzk = zzcww;
        this.zze = j;
    }

    public final int zza() {
        return 12;
    }

    public final ListenableFuture zzb() {
        String str;
        Bundle bundle = new Bundle();
        this.zzj.zzb().put("seq_num", this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
            this.zzj.zzc("tsacc", String.valueOf(zzu.zzB().currentTimeMillis() - this.zze));
            zzdux zzdux = this.zzj;
            zzu.zzp();
            if (true != zzt.zzG(this.zza)) {
                str = "1";
            } else {
                str = "0";
            }
            zzdux.zzc("foreground", str);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzfI)).booleanValue()) {
            this.zzf.zzk(this.zzh.zzd);
            bundle.putAll(this.zzg.zzb());
        }
        return zzgft.zzh(new zzery(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfI)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbep.zzfH)).booleanValue()) {
                synchronized (zzb) {
                    this.zzf.zzk(this.zzh.zzd);
                    bundle2.putBundle("quality_signals", this.zzg.zzb());
                }
            } else {
                this.zzf.zzk(this.zzh.zzd);
                bundle2.putBundle("quality_signals", this.zzg.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!this.zzi.zzS()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !this.zzi.zzS());
        if (((Boolean) zzba.zzc().zza(zzbep.zzfJ)).booleanValue()) {
            try {
                zzu.zzp();
                bundle2.putString("_app_id", zzt.zzp(this.zza));
            } catch (RemoteException e) {
                zzu.zzo().zzw(e, "AppStatsSignal_AppId");
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzfK)).booleanValue() && this.zzh.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzk.zzb(this.zzh.zzf));
            bundle3.putInt("pcc", this.zzk.zza(this.zzh.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzjK)).booleanValue() && zzu.zzo().zza() > 0) {
            bundle2.putInt("nrwv", zzu.zzo().zza());
        }
    }
}
