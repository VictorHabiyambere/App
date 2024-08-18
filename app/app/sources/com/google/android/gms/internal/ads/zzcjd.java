package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzcf;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzaj;
import com.google.android.gms.ads.nonagon.signalgeneration.zzk;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzcjd implements zzcoq {
    @Nullable
    private static zzcjd zza;

    private static synchronized zzcjd zzD(Context context, @Nullable zzbrf zzbrf, int i, boolean z, int i2, zzcki zzcki) {
        synchronized (zzcjd.class) {
            zzcjd zzcjd = zza;
            if (zzcjd != null) {
                return zzcjd;
            }
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            zzbep.zza(context);
            if (((Boolean) zzbgc.zze.zze()).booleanValue()) {
                zzbdz.zzd(context);
            }
            zzfik zzd = zzfik.zzd(context);
            VersionInfoParcel zzc = zzd.zzc(241806000, false, i2);
            zzd.zzf(zzbrf);
            zzclw zzclw = new zzclw((zzclv) null);
            zzcje zzcje = new zzcje();
            zzcje.zzf(zzc);
            zzcje.zze(context);
            zzcje.zzd(currentTimeMillis);
            zzclw.zzb(new zzcjg(zzcje, (zzcjf) null));
            zzclw.zzc(new zzcnj(zzcki));
            zzcjd zza2 = zzclw.zza();
            zzu.zzo().zzu(context, zzc);
            zzu.zzc().zzi(context);
            zzu.zzp().zzl(context);
            zzu.zzp().zzk(context);
            zzd.zza(context);
            zzu.zzb().zzd(context);
            zzu.zzv().zzb(context);
            zza2.zza().zzc();
            zzcav.zzd(context);
            if (((Boolean) zzba.zzc().zza(zzbep.zzgs)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzaw)).booleanValue()) {
                    new zzefm(context, zzc, new zzbdm(new zzbdu(context)), new zzeer(new zzeen(context), zza2.zzA())).zzb(zzu.zzo().zzi().zzS());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcjd zzb(Context context, @Nullable zzbrf zzbrf, int i) {
        return zzD(context, zzbrf, 241806000, false, i, new zzcki());
    }

    public abstract zzgge zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract zzcf zza();

    public abstract zzcnt zzc();

    public abstract zzcrs zzd();

    public abstract zzctf zze();

    public abstract zzdca zzf();

    public abstract zzdjg zzg();

    public abstract zzdkc zzh();

    public abstract zzdrl zzi();

    public abstract zzdvc zzj();

    public abstract zzdwl zzk();

    public abstract zzdya zzl();

    public abstract zzdyx zzm();

    public abstract zzegk zzn();

    public abstract zzk zzo();

    public abstract zzq zzp();

    public abstract zzaj zzq();

    public final zzeyv zzr(zzbxu zzbxu, int i) {
        return zzs(new zzfay(zzbxu, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzeyv zzs(zzfay zzfay);

    public abstract zzfbt zzt();

    public abstract zzfdh zzu();

    public abstract zzfey zzv();

    public abstract zzfgm zzw();

    public abstract zzfid zzx();

    public abstract zzfin zzy();

    public abstract zzfmq zzz();
}
