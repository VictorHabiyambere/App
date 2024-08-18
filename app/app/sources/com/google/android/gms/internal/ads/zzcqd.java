package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcqd {
    zzbwl zza;
    zzbwl zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    private final zzg zzd;
    private final zzehh zze;
    private final zzdsi zzf;
    /* access modifiers changed from: private */
    public final zzgge zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcqd(Context context, zzg zzg2, zzehh zzehh, zzdsi zzdsi, zzgge zzgge, zzgge zzgge2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzg2;
        this.zze = zzehh;
        this.zzf = zzdsi;
        this.zzg = zzgge;
        this.zzh = zzgge2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) zzba.zzc().zza(zzbep.zzkh));
    }

    private final ListenableFuture zzk(String str, @Nullable InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) zzba.zzc().zza(zzbep.zzkh)) || this.zzd.zzS()) {
                return zzgft.zzh(str);
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            long nextInt = (long) random.nextInt(Integer.MAX_VALUE);
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzki), String.valueOf(nextInt));
            if (inputEvent != null) {
                return zzgft.zzf(zzgft.zzn(zzgfk.zzu(this.zze.zza()), new zzcpx(this, buildUpon, str, inputEvent), this.zzh), Throwable.class, new zzcpy(this, buildUpon), this.zzg);
            }
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzkj), "11");
            return zzgft.zzh(buildUpon.toString());
        } catch (Exception e) {
            return zzgft.zzg(e);
        }
    }

    public final ListenableFuture zzb(String str, Random random) {
        if (TextUtils.isEmpty(str)) {
            return zzgft.zzh(str);
        }
        return zzgft.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzcpu(this, str), this.zzg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Throwable th) throws Exception {
        this.zzg.zza(new zzcpw(this, th));
        return zzgft.zzh(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() == 1) {
            Uri.Builder buildUpon = builder.build().buildUpon();
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzkk), "1");
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzkj), "12");
            if (str.contains((CharSequence) zzba.zzc().zza(zzbep.zzkl))) {
                buildUpon.authority((String) zzba.zzc().zza(zzbep.zzkm));
            }
            return zzgft.zzn(zzgfk.zzu(this.zze.zzb(buildUpon.build(), inputEvent)), new zzcpz(builder), this.zzh);
        }
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzkj), "10");
        return zzgft.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Uri.Builder builder, Throwable th) throws Exception {
        this.zzg.zza(new zzcpv(this, th));
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbep.zzkj), "9");
        return zzgft.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzko)).booleanValue()) {
            this.zzb = zzbwj.zzc(this.zzc);
            this.zzb.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
            return;
        }
        this.zza = zzbwj.zza(this.zzc);
        this.zza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzko)).booleanValue()) {
            this.zzb = zzbwj.zzc(this.zzc);
            this.zzb.zzh(th, "AttributionReporting");
            return;
        }
        this.zza = zzbwj.zza(this.zzc);
        this.zza.zzh(th, "AttributionReportingSampled");
    }

    public final void zzi(String str, zzfoe zzfoe, Random random) {
        if (!TextUtils.isEmpty(str)) {
            ListenableFuture zzk = zzk(str, this.zzf.zza(), random);
            zzbeg zzbeg = zzbep.zzkn;
            zzgft.zzr(zzgft.zzo(zzk, (long) ((Integer) zzba.zzc().zza(zzbeg)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcqc(this, zzfoe, str), this.zzg);
        }
    }
}
