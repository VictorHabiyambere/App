package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcyq;
import com.google.android.gms.internal.ads.zzdhx;
import com.google.android.gms.internal.ads.zzfky;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzgft;
import com.google.android.gms.internal.ads.zzhkp;
import com.google.android.gms.internal.ads.zzhlg;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzat implements zzhkp {
    private final zzhlg zza;
    private final zzhlg zzb;
    private final zzhlg zzc;
    private final zzhlg zzd;

    public zzat(zzhlg zzhlg, zzhlg zzhlg2, zzhlg zzhlg3, zzhlg zzhlg4) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
        this.zzc = zzhlg3;
        this.zzd = zzhlg4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfky zza2 = ((zzflt) this.zza.zzb()).zzb(zzfln.GENERATE_SIGNALS, ((zzcyq) this.zzc).zzb().zzc()).zzf(((zzaw) this.zzb).zzb()).zzi((long) ((Integer) zzba.zzc().zza(zzbep.zzfF)).intValue(), TimeUnit.SECONDS).zza();
        zzgft.zzr(zza2, new zzal((zzdhx) this.zzd.zzb()), zzcci.zza);
        return zza2;
    }
}
