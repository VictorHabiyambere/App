package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcjg {
    private final VersionInfoParcel zza;
    private final Context zzb;
    private final long zzc;
    private final WeakReference zzd;

    /* synthetic */ zzcjg(zzcje zzcje, zzcjf zzcjf) {
        this.zza = zzcje.zza;
        this.zzb = zzcje.zzb;
        this.zzd = zzcje.zzd;
        this.zzc = zzcje.zzc;
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zzb() {
        return this.zzb;
    }

    public final zzj zzc() {
        return new zzj(this.zzb, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final zzbhd zzd() {
        return new zzbhd(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final VersionInfoParcel zze() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzf() {
        return zzu.zzp().zzc(this.zzb, this.zza.afmaVersion);
    }

    /* access modifiers changed from: package-private */
    public final WeakReference zzg() {
        return this.zzd;
    }
}
