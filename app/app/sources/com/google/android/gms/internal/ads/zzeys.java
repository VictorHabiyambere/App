package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeys implements zzexw {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzcbp zzg;

    zzeys(zzcbp zzcbp, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzcbp;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    public final int zza() {
        return 40;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzaV)).booleanValue()) {
            return zzgft.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzgft.zze((zzgfk) zzgft.zzo(zzgft.zzm(zzgfk.zzu(this.zzg.zza(this.zza, this.zzd)), new zzeyq(this), this.zzc), ((Long) zzba.zzc().zza(zzbep.zzaW)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzeyr(this), this.zzc);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0068, code lost:
        com.google.android.gms.ads.internal.zzu.zzo().zzw(r0, "AdIdInfoSignalSource.getPaidV1");
        r0 = new com.google.android.gms.internal.ads.zzfvd();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcZ)).booleanValue() == false) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzda)).booleanValue() != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = com.google.android.gms.internal.ads.zzfvg.zzj(r7.zza).zzi((java.lang.String) java.util.Objects.requireNonNull(((com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) java.util.Objects.requireNonNull(r8)).getId()), r7.zza.getPackageName(), ((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzdg)).longValue(), r7.zzf);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeyt zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfvd r0 = new com.google.android.gms.internal.ads.zzfvd
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzcZ
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0031
        L_0x001b:
            boolean r1 = r7.zze
            if (r1 == 0) goto L_0x0064
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzda
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0064
        L_0x0031:
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzfvg r1 = com.google.android.gms.internal.ads.zzfvg.zzj(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = java.util.Objects.requireNonNull(r8)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r0 = (com.google.android.gms.ads.identifier.AdvertisingIdClient.Info) r0     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.String r0 = r0.getId()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = java.util.Objects.requireNonNull(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            android.content.Context r0 = r7.zza     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.String r3 = r0.getPackageName()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzdg     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Object r0 = r4.zza(r0)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            long r4 = r0.longValue()     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            boolean r6 = r7.zzf     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
            com.google.android.gms.internal.ads.zzfvd r0 = r1.zzi(r2, r3, r4, r6)     // Catch:{ IOException -> 0x0067, IllegalArgumentException -> 0x0065 }
        L_0x0064:
            goto L_0x0076
        L_0x0065:
            r0 = move-exception
            goto L_0x0068
        L_0x0067:
            r0 = move-exception
        L_0x0068:
            com.google.android.gms.internal.ads.zzcby r1 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r2 = "AdIdInfoSignalSource.getPaidV1"
            r1.zzw(r0, r2)
            com.google.android.gms.internal.ads.zzfvd r0 = new com.google.android.gms.internal.ads.zzfvd
            r0.<init>()
        L_0x0076:
            com.google.android.gms.internal.ads.zzeyt r1 = new com.google.android.gms.internal.ads.zzeyt
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeys.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzeyt");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeyt zzd(Throwable th) {
        String str;
        zzay.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        if (contentResolver == null) {
            str = null;
        } else {
            str = Settings.Secure.getString(contentResolver, "android_id");
        }
        return new zzeyt((AdvertisingIdClient.Info) null, str, new zzfvd());
    }
}
