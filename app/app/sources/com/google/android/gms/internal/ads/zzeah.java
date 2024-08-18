package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeah implements zzebg {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdzi zzb;
    private final zzgge zzc;
    private final zzfho zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzeev zzf;
    private final zzfmn zzg;
    private final Context zzh;

    zzeah(Context context, zzfho zzfho, zzdzi zzdzi, zzgge zzgge, ScheduledExecutorService scheduledExecutorService, zzeev zzeev, zzfmn zzfmn) {
        this.zzh = context;
        this.zzd = zzfho;
        this.zzb = zzdzi;
        this.zzc = zzgge;
        this.zze = scheduledExecutorService;
        this.zzf = zzeev;
        this.zzg = zzfmn;
    }

    public final ListenableFuture zzb(zzbxu zzbxu) {
        Context context = this.zzh;
        ListenableFuture zzc2 = this.zzb.zzc(zzbxu);
        zzfmc zza2 = zzfmb.zza(context, zzfmu.CUI_NAME_ADREQUEST_PARSERESPONSE);
        zzfmm.zze(zzc2, zza2);
        ListenableFuture zzn = zzgft.zzn(zzc2, new zzeae(this), this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbep.zzfD)).booleanValue()) {
            zzbeg zzbeg = zzbep.zzfF;
            Class<TimeoutException> cls = TimeoutException.class;
            zzn = zzgft.zzf(zzgft.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbeg)).intValue(), TimeUnit.SECONDS, this.zze), cls, new zzeaf(), zzcci.zzf);
        }
        zzfmm.zzb(zzn, this.zzg, zza2);
        zzgft.zzr(zzn, new zzeag(this), zzcci.zzf);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzebi zzebi) throws Exception {
        return zzgft.zzh(new zzfhf(new zzfhc(this.zzd), zzfhe.zza(new InputStreamReader(zzebi.zzb()), zzebi.zza())));
    }
}
