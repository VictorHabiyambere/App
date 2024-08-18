package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdfa {
    /* access modifiers changed from: private */
    public final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzfeh zzo;

    public final zzdfa zza(zza zza2, Executor executor) {
        this.zzc.add(new zzdha(zza2, executor));
        return this;
    }

    public final zzdfa zzb(zzczo zzczo, Executor executor) {
        this.zzi.add(new zzdha(zzczo, executor));
        return this;
    }

    public final zzdfa zzc(zzdab zzdab, Executor executor) {
        this.zzl.add(new zzdha(zzdab, executor));
        return this;
    }

    public final zzdfa zzd(zzdaf zzdaf, Executor executor) {
        this.zzf.add(new zzdha(zzdaf, executor));
        return this;
    }

    public final zzdfa zze(zzczl zzczl, Executor executor) {
        this.zze.add(new zzdha(zzczl, executor));
        return this;
    }

    public final zzdfa zzf(zzdaz zzdaz, Executor executor) {
        this.zzh.add(new zzdha(zzdaz, executor));
        return this;
    }

    public final zzdfa zzg(zzdbk zzdbk, Executor executor) {
        this.zzg.add(new zzdha(zzdbk, executor));
        return this;
    }

    public final zzdfa zzh(zzp zzp, Executor executor) {
        this.zzn.add(new zzdha(zzp, executor));
        return this;
    }

    public final zzdfa zzi(zzdbw zzdbw, Executor executor) {
        this.zzm.add(new zzdha(zzdbw, executor));
        return this;
    }

    public final zzdfa zzj(zzdcg zzdcg, Executor executor) {
        this.zzb.add(new zzdha(zzdcg, executor));
        return this;
    }

    public final zzdfa zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdha(appEventListener, executor));
        return this;
    }

    public final zzdfa zzl(zzdhi zzdhi, Executor executor) {
        this.zzd.add(new zzdha(zzdhi, executor));
        return this;
    }

    public final zzdfa zzm(zzfeh zzfeh) {
        this.zzo = zzfeh;
        return this;
    }

    public final zzdfc zzn() {
        return new zzdfc(this, (zzdfb) null);
    }
}
