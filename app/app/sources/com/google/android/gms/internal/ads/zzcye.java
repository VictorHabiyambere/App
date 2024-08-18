package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzau;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzcye implements zzfxu {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzfho zzc;

    public /* synthetic */ zzcye(Context context, VersionInfoParcel versionInfoParcel, zzfho zzfho) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfho;
    }

    public final Object apply(Object obj) {
        zzfgt zzfgt = (zzfgt) obj;
        zzau zzau = new zzau(this.zza);
        zzau.zzp(zzfgt.zzC);
        zzau.zzq(zzfgt.zzD.toString());
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzn(this.zzc.zzf);
        return zzau;
    }
}
