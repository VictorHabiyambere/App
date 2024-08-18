package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbd;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbqh {
    static final zzbd zza = new zzbqf();
    static final zzbd zzb = new zzbqg();
    private final zzbpt zzc;

    public zzbqh(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzfmq zzfmq) {
        this.zzc = new zzbpt(context, versionInfoParcel, str, zza, zzb, zzfmq);
    }

    public final zzbpx zza(String str, zzbqa zzbqa, zzbpz zzbpz) {
        return new zzbql(this.zzc, str, zzbqa, zzbpz);
    }

    public final zzbqq zzb() {
        return new zzbqq(this.zzc);
    }
}
