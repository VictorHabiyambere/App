package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqy implements zzexv {
    public final zzq zza;
    public final String zzb;
    public final boolean zzc;
    public final String zzd;
    public final float zze;
    public final int zzf;
    public final int zzg;
    public final String zzh;
    public final boolean zzi;

    public zzeqy(zzq zzq, String str, boolean z, String str2, float f, int i, int i2, String str3, boolean z2) {
        Preconditions.checkNotNull(zzq, "the adSize must not be null");
        this.zza = zzq;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = f;
        this.zzf = i;
        this.zzg = i2;
        this.zzh = str3;
        this.zzi = z2;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfic.zzf(bundle, "smart_w", "full", this.zza.zze == -1);
        zzfic.zzf(bundle, "smart_h", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.zza.zzb == -2);
        zzfic.zzg(bundle, "ene", true, this.zza.zzj);
        zzfic.zzf(bundle, "rafmt", "102", this.zza.zzm);
        zzfic.zzf(bundle, "rafmt", "103", this.zza.zzn);
        zzfic.zzf(bundle, "rafmt", "105", this.zza.zzo);
        zzfic.zzg(bundle, "inline_adaptive_slot", true, this.zzi);
        zzfic.zzg(bundle, "interscroller_slot", true, this.zza.zzo);
        zzfic.zzc(bundle, "format", this.zzb);
        zzfic.zzf(bundle, "fluid", "height", this.zzc);
        zzfic.zzf(bundle, "sz", this.zzd, !TextUtils.isEmpty(this.zzd));
        bundle.putFloat("u_sd", this.zze);
        bundle.putInt("sw", this.zzf);
        bundle.putInt("sh", this.zzg);
        zzfic.zzf(bundle, "sc", this.zzh, !TextUtils.isEmpty(this.zzh));
        ArrayList arrayList = new ArrayList();
        zzq[] zzqArr = this.zza.zzg;
        if (zzqArr == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("height", this.zza.zzb);
            bundle2.putInt("width", this.zza.zze);
            bundle2.putBoolean("is_fluid_height", this.zza.zzi);
            arrayList.add(bundle2);
        } else {
            for (zzq zzq : zzqArr) {
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("is_fluid_height", zzq.zzi);
                bundle3.putInt("height", zzq.zzb);
                bundle3.putInt("width", zzq.zze);
                arrayList.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
