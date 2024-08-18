package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzgv implements zzhb {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzhh zzd;

    protected zzgv(boolean z) {
        this.zza = z;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzie zzie) {
        if (zzie == null) {
            throw null;
        } else if (!this.zzb.contains(zzie)) {
            this.zzb.add(zzie);
            this.zzc++;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzg(int i) {
        zzhh zzhh = this.zzd;
        int i2 = zzgd.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzie) this.zzb.get(i3)).zza(this, zzhh, this.zza, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzh() {
        zzhh zzhh = this.zzd;
        int i = zzgd.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzie) this.zzb.get(i2)).zzb(this, zzhh, this.zza);
        }
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzhh zzhh) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzie) this.zzb.get(i)).zzc(this, zzhh, this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzhh zzhh) {
        this.zzd = zzhh;
        for (int i = 0; i < this.zzc; i++) {
            ((zzie) this.zzb.get(i)).zzd(this, zzhh, this.zza);
        }
    }
}
