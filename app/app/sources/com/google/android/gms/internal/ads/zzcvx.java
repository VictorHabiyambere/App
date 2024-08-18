package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcvx {
    private final zzeam zza;
    private final zzfho zzb;
    private final zzflt zzc;
    private final zzcor zzd;
    private final zzelm zze;
    /* access modifiers changed from: private */
    public final zzdeq zzf;
    private zzfhf zzg;
    private final zzebu zzh;
    private final zzcyp zzi;
    private final Executor zzj;
    private final zzebe zzk;
    private final zzehq zzl;
    private final zzeck zzm;
    private final zzecr zzn;

    zzcvx(zzeam zzeam, zzfho zzfho, zzflt zzflt, zzcor zzcor, zzelm zzelm, zzdeq zzdeq, zzfhf zzfhf, zzebu zzebu, zzcyp zzcyp, Executor executor, zzebe zzebe, zzehq zzehq, zzeck zzeck, zzecr zzecr) {
        this.zza = zzeam;
        this.zzb = zzfho;
        this.zzc = zzflt;
        this.zzd = zzcor;
        this.zze = zzelm;
        this.zzf = zzdeq;
        this.zzg = zzfhf;
        this.zzh = zzebu;
        this.zzi = zzcyp;
        this.zzj = executor;
        this.zzk = zzebe;
        this.zzl = zzehq;
        this.zzm = zzeck;
        this.zzn = zzecr;
    }

    public final zze zza(Throwable th) {
        return zzfiq.zzb(th, this.zzl);
    }

    public final zzdeq zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfhf zzd(zzfhf zzfhf) throws Exception {
        this.zzd.zza(zzfhf);
        return zzfhf;
    }

    public final ListenableFuture zze(zzfjj zzfjj) {
        zzfky zza2 = this.zzc.zzb(zzfln.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzcvt(this, zzfjj)).zza();
        zzgft.zzr(zza2, new zzcvv(this), this.zzj);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfjj zzfjj, zzbxu zzbxu) throws Exception {
        zzbxu.zzi = zzfjj;
        return this.zzh.zza(zzbxu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbxu) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbxx) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbxu zzbxu) {
        zzfky zza2 = this.zzc.zzb(zzfln.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbxu)).zza();
        zzgft.zzr(zza2, new zzcvw(this), this.zzj);
        return zza2;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzflk zzf2 = this.zzc.zzb(zzfln.RENDERER, listenableFuture).zze(new zzcvo(this)).zzf(this.zze);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfD)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzba.zzc().zza(zzbep.zzfF)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final ListenableFuture zzj() {
        zzl zzl2 = this.zzb.zzd;
        if (zzl2.zzx == null && zzl2.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzflt zzflt = this.zzc;
        zzeam zzeam = this.zza;
        return zzfld.zzc(zzeam.zza(), zzfln.PRELOADED_LOADER, zzflt).zza();
    }

    public final ListenableFuture zzk(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzflt zzflt = this.zzc;
            return zzfld.zzc(zzgft.zzh(this.zzg), zzfln.SERVER_TRANSACTION, zzflt).zza();
        }
        zzu.zzc().zzj();
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlB)).booleanValue() || ((Boolean) zzbgq.zzc.zze()).booleanValue()) {
            zzflk zzb2 = this.zzc.zzb(zzfln.SERVER_TRANSACTION, listenableFuture);
            zzebe zzebe = this.zzk;
            Objects.requireNonNull(zzebe);
            return zzb2.zzf(new zzcvu(zzebe)).zza();
        }
        zzeck zzeck = this.zzm;
        Objects.requireNonNull(zzeck);
        ListenableFuture zzn2 = zzgft.zzn(listenableFuture, new zzcvp(zzeck), this.zzj);
        zzflk zzb3 = this.zzc.zzb(zzfln.BUILD_URL, zzn2);
        zzebu zzebu = this.zzh;
        Objects.requireNonNull(zzebu);
        zzfky zza2 = zzb3.zzf(new zzcvq(zzebu)).zza();
        return this.zzc.zza(zzfln.SERVER_TRANSACTION, listenableFuture, zzn2, zza2).zza(new zzcvr(this, listenableFuture, zzn2, zza2)).zzf(new zzcvs()).zza();
    }

    public final void zzl(zzfhf zzfhf) {
        this.zzg = zzfhf;
    }
}
