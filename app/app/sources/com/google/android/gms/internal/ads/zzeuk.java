package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeuk implements Callable {
    public final /* synthetic */ zzeul zza;

    public /* synthetic */ zzeuk(zzeul zzeul) {
        this.zza = zzeul;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzu.zzp();
        zzbbm zzg = zzu.zzo().zzi().zzg();
        Bundle bundle = null;
        if (zzg != null && (!zzu.zzo().zzi().zzP() || !zzu.zzo().zzi().zzQ())) {
            if (zzg.zzh()) {
                zzg.zzg();
            }
            zzbbc zza2 = zzg.zza();
            if (zza2 != null) {
                str2 = zza2.zzd();
                str = zza2.zze();
                str3 = zza2.zzf();
                if (str2 != null) {
                    zzu.zzo().zzi().zzx(str2);
                }
                if (str3 != null) {
                    zzu.zzo().zzi().zzz(str3);
                }
            } else {
                str2 = zzu.zzo().zzi().zzj();
                str3 = zzu.zzo().zzi().zzk();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzu.zzo().zzi().zzQ()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzu.zzo().zzi().zzP()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzeum(bundle);
    }
}
