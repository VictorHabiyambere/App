package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbpp implements zzccp {
    final /* synthetic */ zzbpn zza;

    zzbpp(zzbps zzbps, zzbpn zzbpn) {
        this.zza = zzbpn;
    }

    public final void zza() {
        zze.zza("Rejecting reference for JS Engine.");
        if (((Boolean) zzba.zzc().zza(zzbep.zzhO)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
