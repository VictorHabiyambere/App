package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaxy implements zzfth {
    private final zzfrg zza;
    private final zzfrx zzb;
    private final zzayl zzc;
    private final zzaxx zzd;
    private final zzaxh zze;
    private final zzayn zzf;
    private final zzayf zzg;
    private final zzaxw zzh;

    zzaxy(zzfrg zzfrg, zzfrx zzfrx, zzayl zzayl, zzaxx zzaxx, zzaxh zzaxh, zzayn zzayn, zzayf zzayf, zzaxw zzaxw) {
        this.zza = zzfrg;
        this.zzb = zzfrx;
        this.zzc = zzayl;
        this.zzd = zzaxx;
        this.zze = zzaxh;
        this.zzf = zzayn;
        this.zzg = zzayf;
        this.zzh = zzaxw;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzfrg zzfrg = this.zza;
        zzaus zzb2 = this.zzb.zzb();
        hashMap.put("v", zzfrg.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzi());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzayf zzayf = this.zzg;
        if (zzayf != null) {
            hashMap.put("tcq", Long.valueOf(zzayf.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        zzayl zzayl = this.zzc;
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(zzayl.zza()));
        return zze2;
    }

    public final Map zzb() {
        zzfrg zzfrg = this.zza;
        zzfrx zzfrx = this.zzb;
        Map zze2 = zze();
        zzaus zza2 = zzfrx.zza();
        zze2.put("gai", Boolean.valueOf(zzfrg.zzd()));
        zze2.put("did", zza2.zzh());
        zze2.put("dst", Integer.valueOf(zza2.zzc().zza()));
        zze2.put("doo", Boolean.valueOf(zza2.zzaq()));
        zzaxh zzaxh = this.zze;
        if (zzaxh != null) {
            zze2.put("nt", Long.valueOf(zzaxh.zza()));
        }
        zzayn zzayn = this.zzf;
        if (zzayn != null) {
            zze2.put("vs", Long.valueOf(zzayn.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        zzaxw zzaxw = this.zzh;
        Map zze2 = zze();
        if (zzaxw != null) {
            zze2.put("vst", zzaxw.zza());
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
