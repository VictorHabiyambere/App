package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdvb {
    final /* synthetic */ zzdvc zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdvb(zzdvc zzdvc) {
        this.zza = zzdvc;
    }

    public final zzdvb zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdvb zzc(zzfgt zzfgt) {
        zzb("aai", zzfgt.zzx);
        zzb("request_id", zzfgt.zzao);
        zzb("ad_format", zzfgt.zza(zzfgt.zzb));
        return this;
    }

    public final zzdvb zzd(zzfgw zzfgw) {
        zzb("gqi", zzfgw.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new zzduz(this));
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzdva(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zza.zza.zzf(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }
}
