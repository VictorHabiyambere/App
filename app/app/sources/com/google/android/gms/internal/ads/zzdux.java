package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdux {
    private final ConcurrentHashMap zza;
    private final zzccc zzb;
    private final zzfho zzc;
    private final String zzd;
    private final String zze;
    private final zzj zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzdux(Context context, zzdvh zzdvh, zzccc zzccc, zzfho zzfho, String str, String str2, zzj zzj) {
        ActivityManager.MemoryInfo zzc2;
        String str3;
        this.zza = zzdvh.zzc();
        this.zzb = zzccc;
        this.zzc = zzfho;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzj;
        this.zzh = context;
        this.zza.put("ad_format", this.zze.toUpperCase(Locale.ROOT));
        String str4 = "1";
        if (((Boolean) zzba.zzc().zza(zzbep.zzjz)).booleanValue()) {
            ConcurrentHashMap concurrentHashMap = this.zza;
            int zzj2 = this.zzf.zzj();
            int i = zzj2 - 1;
            if (zzj2 != 0) {
                switch (i) {
                    case 0:
                        str3 = str4;
                        break;
                    case 1:
                        str3 = "2";
                        break;
                    default:
                        str3 = "na";
                        break;
                }
                concurrentHashMap.put("asv", str3);
            } else {
                throw null;
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(zzu.zzo().zzb()));
            if (((Boolean) zzba.zzc().zza(zzbep.zzcf)).booleanValue() && (zzc2 = zzf.zzc(this.zzh)) != null) {
                zzc("mem_avl", String.valueOf(zzc2.availMem));
                zzc("mem_tt", String.valueOf(zzc2.totalMem));
                zzc("low_m", true != zzc2.lowMemory ? "0" : str4);
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzhj)).booleanValue()) {
            switch (zzp.zzf(this.zzc) - 1) {
                case 0:
                    this.zza.put("request_id", this.zzd);
                    this.zza.put("scar", "false");
                    return;
                case 1:
                    this.zza.put("request_id", this.zzd);
                    this.zza.put("se", "query_g");
                    break;
                case 2:
                    this.zza.put("se", "r_adinfo");
                    break;
                case 3:
                    this.zza.put("se", "r_adstring");
                    break;
                default:
                    this.zza.put("se", "r_both");
                    break;
            }
            this.zza.put("scar", "true");
            zzc("ragent", this.zzc.zzd.zzp);
            zzc("rtype", zzp.zzb(zzp.zzc(this.zzc.zzd)));
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final void zzd(zzfhf zzfhf) {
        String str;
        if (!zzfhf.zzb.zza.isEmpty()) {
            zzfgt zzfgt = (zzfgt) zzfhf.zzb.zza.get(0);
            zzc("ad_format", zzfgt.zza(zzfgt.zzb));
            if (zzfgt.zzb == 6) {
                ConcurrentHashMap concurrentHashMap = this.zza;
                if (true != this.zzb.zzm()) {
                    str = "0";
                } else {
                    str = "1";
                }
                concurrentHashMap.put("as", str);
            }
        }
        zzc("gqi", zzfhf.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("cnt")) {
                zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
            }
            if (bundle.containsKey("gnt")) {
                zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
            }
        }
    }
}
