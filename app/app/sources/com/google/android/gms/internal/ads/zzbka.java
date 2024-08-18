package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.ads.formats.zzg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbka {
    /* access modifiers changed from: private */
    public final zzg zza;
    /* access modifiers changed from: private */
    public final zzf zzb;
    private zzbiq zzc;

    public zzbka(zzg zzg, zzf zzf) {
        this.zza = zzg;
        this.zzb = zzf;
    }

    /* access modifiers changed from: private */
    public final synchronized zzbiq zzf(zzbip zzbip) {
        zzbiq zzbiq;
        zzbiq = this.zzc;
        if (zzbiq == null) {
            zzbiq = new zzbiq(zzbip);
            this.zzc = zzbiq;
        }
        return zzbiq;
    }

    public final zzbiz zzc() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbjx(this, (zzbjw) null);
    }

    public final zzbjc zzd() {
        return new zzbjz(this, (zzbjy) null);
    }
}
