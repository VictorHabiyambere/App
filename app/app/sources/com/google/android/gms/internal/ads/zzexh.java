package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzexh implements zzexw {
    private final zzcau zza;
    private final zzgge zzb;
    private final Context zzc;

    public zzexh(zzcau zzcau, zzgge zzgge, Context context) {
        this.zza = zzcau;
        this.zzb = zzgge;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzexg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzexi zzc() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        if (!this.zza.zzp(this.zzc)) {
            return new zzexi((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzd = this.zza.zzd(this.zzc);
        String str5 = zzd == null ? "" : zzd;
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str = "";
        } else {
            str = zzb2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str2 = "";
        } else {
            str2 = zza2;
        }
        Long l = null;
        if (true != this.zza.zzp(this.zzc)) {
            str3 = null;
        } else {
            str3 = "fa";
        }
        if ("TIME_OUT".equals(str)) {
            l = (Long) zzba.zzc().zza(zzbep.zzag);
        }
        Long l2 = l;
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        return new zzexi(str5, str, str2, str4, l2);
    }
}
