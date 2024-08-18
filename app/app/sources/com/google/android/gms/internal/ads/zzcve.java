package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcve {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcve(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    static /* bridge */ /* synthetic */ void zzb(zzcve zzcve, List list, zzgfp zzgfp) {
        if (list == null || list.isEmpty()) {
            zzcve.zza.execute(new zzcuz(zzgfp));
            return;
        }
        ListenableFuture zzh = zzgft.zzh((Object) null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzh = zzgft.zzn(zzgft.zzf(zzh, Throwable.class, new zzcva(zzgfp), zzcve.zza), new zzcvb(zzcve, zzgfp, (ListenableFuture) it.next()), zzcve.zza);
        }
        zzgft.zzr(zzh, new zzcvd(zzcve, zzgfp), zzcve.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzgfp zzgfp, ListenableFuture listenableFuture, zzcup zzcup) throws Exception {
        if (zzcup != null) {
            zzgfp.zzb(zzcup);
        }
        return zzgft.zzo(listenableFuture, ((Long) zzbgx.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgfp zzgfp) {
        zzgft.zzr(this.zzc, new zzcvc(this, zzgfp), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
