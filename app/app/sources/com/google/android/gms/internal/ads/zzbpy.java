package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbpy {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbqh zzc;
    private zzbqh zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbqh zza(Context context, VersionInfoParcel versionInfoParcel, zzfmq zzfmq) {
        zzbqh zzbqh;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbqh(zzc(context), versionInfoParcel, (String) zzba.zzc().zza(zzbep.zza), zzfmq);
            }
            zzbqh = this.zzc;
        }
        return zzbqh;
    }

    public final zzbqh zzb(Context context, VersionInfoParcel versionInfoParcel, zzfmq zzfmq) {
        zzbqh zzbqh;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbqh(zzc(context), versionInfoParcel, (String) zzbgu.zzb.zze(), zzfmq);
            }
            zzbqh = this.zzd;
        }
        return zzbqh;
    }
}
