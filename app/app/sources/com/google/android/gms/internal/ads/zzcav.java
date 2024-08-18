package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzcav {
    static zzcav zza;

    public static synchronized zzcav zzd(Context context) {
        synchronized (zzcav.class) {
            zzcav zzcav = zza;
            if (zzcav != null) {
                return zzcav;
            }
            Context applicationContext = context.getApplicationContext();
            zzbep.zza(applicationContext);
            zzg zzi = zzu.zzo().zzi();
            zzi.zzs(applicationContext);
            zzcan zzcan = new zzcan((zzcam) null);
            zzcan.zzb(applicationContext);
            zzcan.zzc(zzu.zzB());
            zzcan.zza(zzi);
            zzcan.zzd(zzu.zzn());
            zza = zzcan.zze();
            zza.zza().zza();
            zzcaz zzc = zza.zzc();
            if (((Boolean) zzba.zzc().zza(zzbep.zzar)).booleanValue()) {
                zzu.zzp();
                Map zzv = zzt.zzv((String) zzba.zzc().zza(zzbep.zzat));
                for (String zzc2 : zzv.keySet()) {
                    zzc.zzc(zzc2);
                }
                zzc.zzd(new zzcax(zzc, zzv));
            }
            zzcav zzcav2 = zza;
            return zzcav2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract zzcag zza();

    /* access modifiers changed from: package-private */
    public abstract zzcak zzb();

    /* access modifiers changed from: package-private */
    public abstract zzcaz zzc();
}
