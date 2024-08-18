package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqp implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzchq zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzdvc zzd;
    /* access modifiers changed from: private */
    public final zzefz zze;
    /* access modifiers changed from: private */
    public final Executor zzf;
    /* access modifiers changed from: private */
    public final zzaxd zzg;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzh;
    /* access modifiers changed from: private */
    public final zzfoe zzi;
    /* access modifiers changed from: private */
    public final zzegk zzj;
    /* access modifiers changed from: private */
    public final zzfhs zzk;

    public zzdqp(Context context, Executor executor, zzaxd zzaxd, VersionInfoParcel versionInfoParcel, zza zza2, zzchq zzchq, zzefz zzefz, zzfoe zzfoe, zzdvc zzdvc, zzegk zzegk, zzfhs zzfhs) {
        this.zzc = context;
        this.zzf = executor;
        this.zzg = zzaxd;
        this.zzh = versionInfoParcel;
        this.zza = zza2;
        this.zzb = zzchq;
        this.zze = zzefz;
        this.zzi = zzfoe;
        this.zzd = zzdvc;
        this.zzj = zzegk;
        this.zzk = zzfhs;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdqs zzdqs = new zzdqs(this);
        zzdqs.zzk();
        return zzdqs;
    }
}
