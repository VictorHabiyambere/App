package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcyv {
    private final Context zza;
    private final zzfho zzb;
    private final Bundle zzc;
    private final zzfhg zzd;
    private final zzcyn zze;
    private final zzehq zzf;

    /* synthetic */ zzcyv(zzcyt zzcyt, zzcyu zzcyu) {
        this.zza = zzcyt.zza;
        this.zzb = zzcyt.zzb;
        this.zzc = zzcyt.zzc;
        this.zzd = zzcyt.zzd;
        this.zze = zzcyt.zze;
        this.zzf = zzcyt.zzf;
    }

    /* access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzcyn zzc() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzcyt zzd() {
        zzcyt zzcyt = new zzcyt();
        zzcyt.zze(this.zza);
        zzcyt.zzi(this.zzb);
        zzcyt.zzf(this.zzc);
        zzcyt.zzg(this.zze);
        zzcyt.zzd(this.zzf);
        return zzcyt;
    }

    /* access modifiers changed from: package-private */
    public final zzehq zze(String str) {
        zzehq zzehq = this.zzf;
        return zzehq != null ? zzehq : new zzehq(str);
    }

    /* access modifiers changed from: package-private */
    public final zzfhg zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfho zzg() {
        return this.zzb;
    }
}
