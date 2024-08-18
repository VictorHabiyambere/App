package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqs {
    /* access modifiers changed from: private */
    public final zzdqf zza = new zzdqf();
    private final zza zzb;
    private final zzchq zzc;
    private final Context zzd;
    /* access modifiers changed from: private */
    public final zzdvc zze;
    private final Executor zzf;
    private final zzaxd zzg;
    private final VersionInfoParcel zzh;
    private final zzbmf zzi;
    /* access modifiers changed from: private */
    public final zzefz zzj;
    /* access modifiers changed from: private */
    public final zzfoe zzk;
    private final zzegk zzl;
    private final zzfhs zzm;
    private ListenableFuture zzn;

    zzdqs(zzdqp zzdqp) {
        this.zzd = zzdqp.zzc;
        this.zzf = zzdqp.zzf;
        this.zzg = zzdqp.zzg;
        this.zzh = zzdqp.zzh;
        this.zzb = zzdqp.zza;
        this.zzc = zzdqp.zzb;
        this.zzi = new zzbmf();
        this.zzj = zzdqp.zze;
        this.zzk = zzdqp.zzi;
        this.zze = zzdqp.zzd;
        this.zzl = zzdqp.zzj;
        this.zzm = zzdqp.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzchd zza(zzchd zzchd) {
        zzchd zzchd2 = zzchd;
        zzchd2.zzag("/result", this.zzi);
        zzciv zzN = zzchd.zzN();
        zzb zzb2 = r2;
        zzb zzb3 = new zzb(this.zzd, (zzcaf) null, (zzbwx) null);
        zzdqf zzdqf = this.zza;
        zzN.zzR((com.google.android.gms.ads.internal.client.zza) null, zzdqf, zzdqf, zzdqf, zzdqf, false, (zzbls) null, zzb2, (zzbuk) null, (zzcaf) null, this.zzj, this.zzk, this.zze, (zzbmj) null, (zzdhi) null, (zzbmi) null, (zzbmc) null, (zzblq) null, (zzcqd) null);
        return zzchd2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(String str, JSONObject jSONObject, zzchd zzchd) throws Exception {
        return this.zzi.zzb(zzchd, str, jSONObject);
    }

    public final synchronized ListenableFuture zzg(String str, JSONObject jSONObject) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture == null) {
            return zzgft.zzh((Object) null);
        }
        return zzgft.zzn(listenableFuture, new zzdqg(this, str, jSONObject), this.zzf);
    }

    public final synchronized void zzh(zzfgt zzfgt, zzfgw zzfgw, zzcqd zzcqd) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgft.zzr(listenableFuture, new zzdqm(this, zzfgt, zzfgw, zzcqd), this.zzf);
        }
    }

    public final synchronized void zzi() {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgft.zzr(listenableFuture, new zzdqi(this), this.zzf);
            this.zzn = null;
        }
    }

    public final synchronized void zzj(String str, Map map) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgft.zzr(listenableFuture, new zzdql(this, "sendMessageToNativeJs", map), this.zzf);
        }
    }

    public final synchronized void zzk() {
        zzbeg zzbeg = zzbep.zzdL;
        this.zzn = zzgft.zzm(zzgft.zzk(new zzcho(this.zzd, this.zzg, this.zzh, this.zzb, this.zzl, this.zzm, (String) zzba.zzc().zza(zzbeg)), zzcci.zze), new zzdqh(this), this.zzf);
        zzccl.zza(this.zzn, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzl(String str, zzblp zzblp) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgft.zzr(listenableFuture, new zzdqj(this, str, zzblp), this.zzf);
        }
    }

    public final void zzm(WeakReference weakReference, String str, zzblp zzblp) {
        zzl(str, new zzdqr(this, weakReference, str, zzblp, (zzdqq) null));
    }

    public final synchronized void zzn(String str, zzblp zzblp) {
        ListenableFuture listenableFuture = this.zzn;
        if (listenableFuture != null) {
            zzgft.zzr(listenableFuture, new zzdqk(this, str, zzblp), this.zzf);
        }
    }
}
