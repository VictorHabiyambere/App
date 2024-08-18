package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzepz implements zzeps {
    private final zzfhm zza;
    /* access modifiers changed from: private */
    public final zzcjd zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzepp zzd;
    /* access modifiers changed from: private */
    public final zzfmq zze;
    private zzcve zzf;

    public zzepz(zzcjd zzcjd, Context context, zzepp zzepp, zzfhm zzfhm) {
        this.zzb = zzcjd;
        this.zzc = context;
        this.zzd = zzepp;
        this.zza = zzfhm;
        this.zze = zzcjd.zzz();
        zzfhm.zzv(zzepp.zzd());
    }

    public final boolean zza() {
        zzcve zzcve = this.zzf;
        return zzcve != null && zzcve.zzf();
    }

    public final boolean zzb(zzl zzl, String str, zzepq zzepq, zzepr zzepr) throws RemoteException {
        zzfmn zzfmn;
        zzu.zzp();
        if (zzt.zzH(this.zzc) && zzl.zzs == null) {
            zzm.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new zzepu(this));
            return false;
        } else if (str == null) {
            zzm.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new zzepv(this));
            return false;
        } else {
            zzfil.zza(this.zzc, zzl.zzf);
            if (((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue() && zzl.zzf) {
                this.zzb.zzl().zzo(true);
            }
            int i = ((zzept) zzepq).zza;
            Bundle zza2 = zzdun.zza(new Pair(zzdul.PUBLIC_API_CALL.zza(), Long.valueOf(zzl.zzz)), new Pair(zzdul.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzfhm zzfhm = this.zza;
            zzfhm.zzH(zzl);
            zzfhm.zzA(zza2);
            zzfhm.zzC(i);
            Context context = this.zzc;
            zzfho zzJ = zzfhm.zzJ();
            zzfmc zzb2 = zzfmb.zzb(context, zzfmm.zza(zzJ), zzfmw.FORMAT_NATIVE, zzl);
            zzcb zzcb = zzJ.zzn;
            if (zzcb != null) {
                this.zzd.zzd().zzm(zzcb);
            }
            zzdkc zzh = this.zzb.zzh();
            zzcyt zzcyt = new zzcyt();
            zzcyt.zze(this.zzc);
            zzcyt.zzi(zzJ);
            zzh.zzf(zzcyt.zzj());
            zzdfa zzdfa = new zzdfa();
            zzdfa.zzk(this.zzd.zzd(), this.zzb.zzB());
            zzh.zze(zzdfa.zzn());
            zzh.zzd(this.zzd.zzc());
            zzh.zzc(new zzcsc((ViewGroup) null));
            zzdkd zzg = zzh.zzg();
            if (((Boolean) zzbgd.zzc.zze()).booleanValue()) {
                zzfmn zzf2 = zzg.zzf();
                zzf2.zzd(zzfmw.FORMAT_NATIVE);
                zzf2.zzb(zzl.zzp);
                zzf2.zzg(zzl.zzm);
                zzfmn = zzf2;
            } else {
                zzfmn = null;
            }
            this.zzb.zzy().zzc(1);
            zzgge zzgge = zzcci.zza;
            zzhkx.zzb(zzgge);
            ScheduledExecutorService zzC = this.zzb.zzC();
            zzcvx zza3 = zzg.zza();
            this.zzf = new zzcve(zzgge, zzC, zza3.zzi(zza3.zzj()));
            this.zzf.zze(new zzepy(this, zzepr, zzfmn, zzb2, zzg));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfiq.zzd(4, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfiq.zzd(6, (String) null, (zze) null));
    }
}
