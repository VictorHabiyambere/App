package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.Bundle;
import android.os.ext.SdkExtensions;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import javax.annotation.Nullable;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzesd implements zzexv {
    @Nullable
    private final Integer zza;

    private zzesd(@Nullable Integer num) {
        this.zza = num;
    }

    static /* bridge */ /* synthetic */ zzesd zzb(VersionInfoParcel versionInfoParcel) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzka)).booleanValue()) {
            return new zzesd((Integer) null);
        }
        zzu.zzp();
        int i = 0;
        try {
            if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzkd)).booleanValue()) {
                    if (versionInfoParcel.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbep.zzkc)).intValue() && Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(31) >= 9) {
                        i = SdkExtensions.getExtensionVersion(31);
                    }
                }
                return new zzesd(Integer.valueOf(i));
            }
            i = SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS);
            return new zzesd(Integer.valueOf(i));
        } catch (Exception e) {
            zzu.zzo().zzw(e, "AdUtil.getAdServicesExtensionVersion");
        }
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Integer num = this.zza;
        Bundle bundle = (Bundle) obj;
        if (num != null) {
            bundle.putInt("aos", num.intValue());
        }
    }
}
