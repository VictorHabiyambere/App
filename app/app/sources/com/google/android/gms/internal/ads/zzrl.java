package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzrl {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzpp zzb;
    private boolean zzc;
    /* access modifiers changed from: private */
    public final zzrk zzd;
    /* access modifiers changed from: private */
    public zzrn zze;
    /* access modifiers changed from: private */
    public zzrd zzf;

    @Deprecated
    public zzrl() {
        this.zza = null;
        this.zzb = zzpp.zza;
        this.zzd = zzrk.zza;
    }

    public final zzrz zzd() {
        zzeq.zzf(!this.zzc);
        this.zzc = true;
        if (this.zze == null) {
            this.zze = new zzrn(new zzdz[0]);
        }
        if (this.zzf == null) {
            this.zzf = new zzrd(this.zza);
        }
        return new zzrz(this, (zzry) null);
    }

    public zzrl(Context context) {
        this.zza = context;
        this.zzb = zzpp.zza;
        this.zzd = zzrk.zza;
    }
}
