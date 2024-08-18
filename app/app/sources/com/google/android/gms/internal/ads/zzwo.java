package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwo implements zzxf {
    final /* synthetic */ zzwr zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzwo(zzwr zzwr, int i) {
        this.zza = zzwr;
        this.zzb = i;
    }

    public final int zza(zzlj zzlj, zzin zzin, int i) {
        return this.zza.zzg(this.zzb, zzlj, zzin, i);
    }

    public final int zzb(long j) {
        return this.zza.zzi(this.zzb, j);
    }

    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
