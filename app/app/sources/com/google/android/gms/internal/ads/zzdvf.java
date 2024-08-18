package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdvf implements zzflu {
    private final Map zza = new HashMap();
    private final zzdux zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzdvf(zzdux zzdux, Set set, Clock clock) {
        this.zzb = zzdux;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdve zzdve = (zzdve) it.next();
            this.zzd.put(zzdve.zzc, zzdve);
        }
        this.zzc = clock;
    }

    private final void zze(zzfln zzfln, boolean z) {
        String str;
        zzfln zzb2 = ((zzdve) this.zzd.get(zzfln)).zzb;
        if (this.zza.containsKey(zzb2)) {
            if (true != z) {
                str = "f.";
            } else {
                str = "s.";
            }
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue();
            zzdux zzdux = this.zzb;
            Map map = this.zzd;
            zzdux.zzb().put("label.".concat(((zzdve) map.get(zzfln)).zza), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    public final void zzd(zzfln zzfln, String str) {
        if (this.zza.containsKey(zzfln)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfln)).longValue();
            zzdux zzdux = this.zzb;
            String valueOf = String.valueOf(str);
            zzdux.zzb().put("task.".concat(valueOf), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfln)) {
            zze(zzfln, true);
        }
    }

    public final void zzdC(zzfln zzfln, String str) {
    }

    public final void zzdD(zzfln zzfln, String str, Throwable th) {
        if (this.zza.containsKey(zzfln)) {
            Clock clock = this.zzc;
            Map map = this.zza;
            zzdux zzdux = this.zzb;
            String valueOf = String.valueOf(str);
            zzdux.zzb().put("task.".concat(valueOf), "f.".concat(String.valueOf(Long.toString(clock.elapsedRealtime() - ((Long) map.get(zzfln)).longValue()))));
        }
        if (this.zzd.containsKey(zzfln)) {
            zze(zzfln, false);
        }
    }

    public final void zzdE(zzfln zzfln, String str) {
        this.zza.put(zzfln, Long.valueOf(this.zzc.elapsedRealtime()));
    }
}
