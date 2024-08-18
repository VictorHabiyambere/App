package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdvm {
    private final zzg zza;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final String zze;
    private final zzdvh zzf;

    public zzdvm(String str, zzdvh zzdvh) {
        this.zze = str;
        this.zzf = zzdvh;
        this.zza = zzu.zzo().zzi();
    }

    private final Map zzg() {
        String str;
        Map zza2 = this.zzf.zza();
        zza2.put("tms", Long.toString(zzu.zzB().elapsedRealtime(), 10));
        if (this.zza.zzS()) {
            str = "";
        } else {
            str = this.zze;
        }
        zza2.put("tid", str);
        return zza2;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "aaia");
            zzg.put("aair", "MalformedJson");
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_finished");
            zzg.put("ancn", str);
            zzg.put("rqe", str2);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_started");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue()) {
            Map zzg = zzg();
            zzg.put("action", "adapter_init_finished");
            zzg.put("ancn", str);
            this.zzb.add(zzg);
        }
    }

    public final synchronized void zze() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue() && !this.zzd) {
            Map zzg = zzg();
            zzg.put("action", "init_finished");
            this.zzb.add(zzg);
            for (Map zzf2 : this.zzb) {
                this.zzf.zzf(zzf2);
            }
            this.zzd = true;
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzca)).booleanValue() && !this.zzc) {
            Map zzg = zzg();
            zzg.put("action", "init_started");
            this.zzb.add(zzg);
            this.zzc = true;
        }
    }
}
