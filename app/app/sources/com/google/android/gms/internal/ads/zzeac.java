package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeac {
    private final ScheduledExecutorService zza;
    private final zzgge zzb;
    private final zzgge zzc;
    private final zzeau zzd;
    private final zzhkj zze;

    public zzeac(ScheduledExecutorService scheduledExecutorService, zzgge zzgge, zzgge zzgge2, zzeau zzeau, zzhkj zzhkj) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgge;
        this.zzc = zzgge2;
        this.zzd = zzeau;
        this.zze = zzhkj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzebi zza(zzbxu zzbxu) throws Exception {
        return (zzebi) this.zzd.zza(zzbxu).get((long) ((Integer) zzba.zzc().zza(zzbep.zzfF)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbxu zzbxu, int i, Throwable th) throws Exception {
        return zzgft.zzn(((zzedq) this.zze.zzb()).zzd(zzbxu, i), new zzdzz(zzbxu), this.zzb);
    }

    public final ListenableFuture zzc(zzbxu zzbxu) {
        ListenableFuture listenableFuture;
        String str = zzbxu.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgft.zzg(new zzebh(1));
        } else {
            if (((Boolean) zzba.zzc().zza(zzbep.zzhH)).booleanValue()) {
                listenableFuture = this.zzc.zzb(new zzeaa(this, zzbxu));
            } else {
                listenableFuture = this.zzd.zza(zzbxu);
            }
        }
        int callingUid = Binder.getCallingUid();
        zzgfk zzu = zzgfk.zzu(listenableFuture);
        zzbeg zzbeg = zzbep.zzfF;
        return zzgft.zzf((zzgfk) zzgft.zzo(zzu, (long) ((Integer) zzba.zzc().zza(zzbeg)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzeab(this, zzbxu, callingUid), this.zzb);
    }
}
