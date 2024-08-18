package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcby {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb = new zzj();
    private final zzccc zzc = new zzccc(zzay.zzd(), this.zzb);
    private boolean zzd = false;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public VersionInfoParcel zzf;
    private String zzg;
    /* access modifiers changed from: private */
    public zzbeu zzh = null;
    private Boolean zzi = null;
    private final AtomicInteger zzj = new AtomicInteger(0);
    private final AtomicInteger zzk = new AtomicInteger(0);
    private final zzcbx zzl = new zzcbx((zzcbw) null);
    private final Object zzm = new Object();
    private ListenableFuture zzn;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzo = new AtomicBoolean();

    public final boolean zzA(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzix)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    public final Context zzd() {
        return this.zze;
    }

    public final Resources zze() {
        if (this.zzf.isClientJar) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzba.zzc().zza(zzbep.zzkQ)).booleanValue()) {
                return zzq.zza(this.zze).getResources();
            }
            zzq.zza(this.zze).getResources();
            return null;
        } catch (zzp e) {
            zzm.zzk("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final zzbeu zzg() {
        zzbeu zzbeu;
        synchronized (this.zza) {
            zzbeu = this.zzh;
        }
        return zzbeu;
    }

    public final zzccc zzh() {
        return this.zzc;
    }

    public final zzg zzi() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final ListenableFuture zzk() {
        if (this.zze != null) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzcJ)).booleanValue()) {
                synchronized (this.zzm) {
                    ListenableFuture listenableFuture = this.zzn;
                    if (listenableFuture != null) {
                        return listenableFuture;
                    }
                    ListenableFuture zzb2 = zzcci.zza.zzb(new zzcbt(this));
                    this.zzn = zzb2;
                    return zzb2;
                }
            }
        }
        return zzgft.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzo() throws Exception {
        Context zza2 = zzbyf.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    public final void zzu(Context context, VersionInfoParcel versionInfoParcel) {
        zzbeu zzbeu;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = versionInfoParcel;
                zzu.zzb().zzc(this.zzc);
                this.zzb.zzs(this.zze);
                zzbwj.zzb(this.zze, this.zzf);
                zzu.zze();
                if (!((Boolean) zzba.zzc().zza(zzbep.zzbY)).booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbeu = null;
                } else {
                    zzbeu = new zzbeu();
                }
                this.zzh = zzbeu;
                if (this.zzh != null) {
                    zzccl.zza(new zzcbu(this).zzb(), "AppState.registerCsiReporter");
                }
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) zzba.zzc().zza(zzbep.zzix)).booleanValue()) {
                        try {
                            ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzcbv(this));
                        } catch (RuntimeException e) {
                            zzm.zzk("Failed to register network callback", e);
                            this.zzo.set(true);
                        }
                    }
                }
                this.zzd = true;
                zzk();
            }
        }
        zzu.zzp().zzc(context, versionInfoParcel.afmaVersion);
    }

    public final void zzv(Throwable th, String str) {
        zzbwj.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbgt.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbwj.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzx(Throwable th, String str) {
        zzbwj.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzy(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzz(String str) {
        this.zzg = str;
    }
}
