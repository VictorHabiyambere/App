package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzgfp;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzai implements zzgfp {
    final /* synthetic */ zzaj zza;

    zzai(zzaj zzaj) {
        this.zza = zzaj;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzp.zzd(this.zza.zzp, (zzdux) null, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
        zzm.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (((Boolean) zzba.zzc().zza(zzbep.zzjI)).booleanValue() && !this.zza.zzG.get()) {
            if (this.zza.zzH.getAndIncrement() < ((Integer) zzba.zzc().zza(zzbep.zzjJ)).intValue()) {
                this.zza.zzT();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzax zzax = (zzax) obj;
        zzm.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzba.zzc().zza(zzbep.zzjI)).booleanValue()) {
            zzp.zzd(this.zza.zzp, (zzdux) null, "sgs", new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", "true"), new Pair("sgi_rn", Integer.toString(this.zza.zzH.get())));
            this.zza.zzG.set(true);
        }
    }
}
