package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaar {
    /* access modifiers changed from: private */
    public final Context zza;
    private zzdr zzb;
    /* access modifiers changed from: private */
    public zzcu zzc;
    private boolean zzd;

    public zzaar(Context context) {
        this.zza = context.getApplicationContext();
    }

    public final zzabc zzc() {
        zzeq.zzf(!this.zzd);
        if (this.zzc == null) {
            if (this.zzb == null) {
                this.zzb = new zzaav((zzaau) null);
            }
            this.zzc = new zzaaw(this.zzb);
        }
        zzabc zzabc = new zzabc(this, (zzabb) null);
        this.zzd = true;
        return zzabc;
    }
}
