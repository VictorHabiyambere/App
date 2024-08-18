package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewm implements zzexv {
    private zzfvd zza;
    private zzfvd zzb;
    private boolean zzc;
    private boolean zzd;
    private final boolean zze = false;
    private final boolean zzf;

    public zzewm(zzfvd zzfvd, zzfvd zzfvd2, boolean z, boolean z2, boolean z3) {
        this.zza = zzfvd;
        this.zzb = zzfvd2;
        this.zzc = z;
        this.zzd = z2;
        this.zzf = z3;
    }

    public zzewm(boolean z) {
        this.zzf = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        if (r5.zza.zzc() == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r1.putString("paidv1_id_android", r5.zza.zzb());
        r1.putLong("paidv1_creation_time_android", r5.zza.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006c, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcT)).booleanValue() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcV)).booleanValue() != false) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        if (r5.zzb.zzc() == false) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
        r1.putString("paidv2_id_android", r5.zzb.zzb());
        r1.putLong("paidv2_creation_time_android", r5.zzb.zza());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a2, code lost:
        r1.putBoolean("paidv2_pub_option_android", r5.zzc);
        r1.putBoolean("paidv2_user_option_android", r5.zzd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcS)).booleanValue() == false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbep.zzcU)).booleanValue() != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzj(java.lang.Object r6) {
        /*
            r5 = this;
            android.os.Bundle r6 = (android.os.Bundle) r6
            boolean r0 = r5.zze
            if (r0 == 0) goto L_0x0008
            goto L_0x00ba
        L_0x0008:
            java.lang.String r0 = "pii"
            android.os.Bundle r1 = com.google.android.gms.internal.ads.zzfic.zza(r6, r0)
            boolean r2 = r5.zzf
            if (r2 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzcS
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x003a
        L_0x0024:
            boolean r2 = r5.zzf
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzcU
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0058
        L_0x003a:
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zza
            boolean r2 = r2.zzc()
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zza
            java.lang.String r2 = r2.zzb()
            java.lang.String r3 = "paidv1_id_android"
            r1.putString(r3, r2)
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zza
            long r2 = r2.zza()
            java.lang.String r4 = "paidv1_creation_time_android"
            r1.putLong(r4, r2)
        L_0x0058:
            boolean r2 = r5.zzf
            if (r2 != 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzcT
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0084
        L_0x006e:
            boolean r2 = r5.zzf
            if (r2 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzcV
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00b0
        L_0x0084:
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zzb
            boolean r2 = r2.zzc()
            if (r2 == 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zzb
            java.lang.String r2 = r2.zzb()
            java.lang.String r3 = "paidv2_id_android"
            r1.putString(r3, r2)
            com.google.android.gms.internal.ads.zzfvd r2 = r5.zzb
            long r2 = r2.zza()
            java.lang.String r4 = "paidv2_creation_time_android"
            r1.putLong(r4, r2)
        L_0x00a2:
            boolean r2 = r5.zzc
            java.lang.String r3 = "paidv2_pub_option_android"
            r1.putBoolean(r3, r2)
            boolean r2 = r5.zzd
            java.lang.String r3 = "paidv2_user_option_android"
            r1.putBoolean(r3, r2)
        L_0x00b0:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x00ba
            r6.putBundle(r0, r1)
            return
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewm.zzj(java.lang.Object):void");
    }
}
