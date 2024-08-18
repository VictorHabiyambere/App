package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewl implements zzexw {
    private final Context zza;
    private final zzgge zzb;
    private final zzfho zzc;
    private final VersionInfoParcel zzd;

    zzewl(Context context, zzgge zzgge, zzfho zzfho, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgge;
        this.zzc = zzfho;
        this.zzd = versionInfoParcel;
    }

    public final int zza() {
        return 53;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzewk(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcU)).booleanValue() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r1 = com.google.android.gms.internal.ads.zzfvg.zzj(r0).zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzdg)).longValue(), com.google.android.gms.ads.internal.zzu.zzo().zzi().zzS());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bb, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcT)).booleanValue() == false) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cf, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcV)).booleanValue() != false) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d1, code lost:
        r0 = com.google.android.gms.internal.ads.zzfvh.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00e9, code lost:
        if (r8.zzd.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzdc)).intValue()) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00eb, code lost:
        r2 = r0.zzh(((java.lang.Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzdh)).longValue(), com.google.android.gms.ads.internal.zzu.zzo().zzi().zzS());
        r3 = r0.zzo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0111, code lost:
        r6 = r0.zzp();
        r4 = r2;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcS)).booleanValue() == false) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzewm zzc() throws java.lang.Exception {
        /*
            r8 = this;
            android.content.Context r0 = r8.zza     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfho r1 = r8.zzc     // Catch:{ IOException -> 0x0124 }
            boolean r7 = r1.zzb()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfvd r1 = new com.google.android.gms.internal.ads.zzfvd     // Catch:{ IOException -> 0x0124 }
            r1.<init>()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfvd r2 = new com.google.android.gms.internal.ads.zzfvd     // Catch:{ IOException -> 0x0124 }
            r2.<init>()     // Catch:{ IOException -> 0x0124 }
            r3 = 1
            if (r7 == 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzcW     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x002e
            com.google.android.gms.internal.ads.zzewm r0 = new com.google.android.gms.internal.ads.zzewm     // Catch:{ IOException -> 0x0124 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0124 }
            goto L_0x0123
        L_0x002e:
            if (r7 != 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzcS     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x0056
        L_0x0042:
            if (r7 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzcU     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x007a
        L_0x0056:
            com.google.android.gms.internal.ads.zzfvg r1 = com.google.android.gms.internal.ads.zzfvg.zzj(r0)     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzdg     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IOException -> 0x0124 }
            long r4 = r4.longValue()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzcby r6 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.zzg r6 = r6.zzi()     // Catch:{ IOException -> 0x0124 }
            boolean r6 = r6.zzS()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfvd r1 = r1.zzh(r4, r6)     // Catch:{ IOException -> 0x0124 }
        L_0x007a:
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzdd     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x00a9
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r8.zzd     // Catch:{ IOException -> 0x0124 }
            int r4 = r4.clientJarVersion     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzdc     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ IOException -> 0x0124 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0124 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 >= r5) goto L_0x00a9
            com.google.android.gms.internal.ads.zzfvh r4 = com.google.android.gms.internal.ads.zzfvh.zzi(r0)     // Catch:{ IOException -> 0x0124 }
            r4.zzj()     // Catch:{ IOException -> 0x0124 }
        L_0x00a9:
            if (r7 != 0) goto L_0x00bd
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzcT     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 != 0) goto L_0x00d1
        L_0x00bd:
            if (r7 == 0) goto L_0x0119
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzcV     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ IOException -> 0x0124 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.booleanValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 == 0) goto L_0x0119
        L_0x00d1:
            com.google.android.gms.internal.ads.zzfvh r0 = com.google.android.gms.internal.ads.zzfvh.zzi(r0)     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = r8.zzd     // Catch:{ IOException -> 0x0124 }
            int r4 = r4.clientJarVersion     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzdc     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r5 = r6.zza(r5)     // Catch:{ IOException -> 0x0124 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IOException -> 0x0124 }
            int r5 = r5.intValue()     // Catch:{ IOException -> 0x0124 }
            if (r4 < r5) goto L_0x0110
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzdh     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ IOException -> 0x0124 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ IOException -> 0x0124 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ IOException -> 0x0124 }
            long r2 = r2.longValue()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzcby r4 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.ads.internal.util.zzg r4 = r4.zzi()     // Catch:{ IOException -> 0x0124 }
            boolean r4 = r4.zzS()     // Catch:{ IOException -> 0x0124 }
            com.google.android.gms.internal.ads.zzfvd r2 = r0.zzh(r2, r4)     // Catch:{ IOException -> 0x0124 }
            boolean r3 = r0.zzo()     // Catch:{ IOException -> 0x0124 }
            goto L_0x0111
        L_0x0110:
        L_0x0111:
            boolean r0 = r0.zzp()     // Catch:{ IOException -> 0x0124 }
            r6 = r0
            r4 = r2
            r5 = r3
            goto L_0x011c
        L_0x0119:
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x011c:
            com.google.android.gms.internal.ads.zzewm r0 = new com.google.android.gms.internal.ads.zzewm     // Catch:{ IOException -> 0x0124 }
            r2 = r0
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x0124 }
        L_0x0123:
            return r0
        L_0x0124:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcby r1 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r2 = "PerAppIdSignal"
            r1.zzw(r0, r2)
            com.google.android.gms.internal.ads.zzfho r0 = r8.zzc
            com.google.android.gms.internal.ads.zzewm r1 = new com.google.android.gms.internal.ads.zzewm
            boolean r0 = r0.zzb()
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewl.zzc():com.google.android.gms.internal.ads.zzewm");
    }
}
