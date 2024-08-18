package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzhkp;
import com.google.android.gms.internal.ads.zzhlg;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class CsiParamDefaults_Factory implements zzhkp<CsiParamDefaults> {
    private final zzhlg zza;
    private final zzhlg zzb;

    public CsiParamDefaults_Factory(zzhlg<Context> zzhlg, zzhlg<VersionInfoParcel> zzhlg2) {
        this.zza = zzhlg;
        this.zzb = zzhlg2;
    }

    public static CsiParamDefaults_Factory create(zzhlg<Context> zzhlg, zzhlg<VersionInfoParcel> zzhlg2) {
        return new CsiParamDefaults_Factory(zzhlg, zzhlg2);
    }

    public static CsiParamDefaults newInstance(Context context, VersionInfoParcel versionInfo) {
        return new CsiParamDefaults(context, versionInfo);
    }

    /* renamed from: get */
    public CsiParamDefaults zzb() {
        return newInstance((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
