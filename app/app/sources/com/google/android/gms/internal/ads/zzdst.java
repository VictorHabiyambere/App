package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdst {
    private final zzfik zza;
    private final zzdsq zzb;

    zzdst(zzfik zzfik, zzdsq zzdsq) {
        this.zza = zzfik;
        this.zzb = zzdsq;
    }

    /* access modifiers changed from: package-private */
    public final zzbrf zza() throws RemoteException {
        zzbrf zzb2 = this.zza.zzb();
        if (zzb2 != null) {
            return zzb2;
        }
        zzm.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbte zzb(String str) throws RemoteException {
        zzbte zzc = zza().zzc(str);
        this.zzb.zzd(str, zzc);
        return zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(r6) != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzfim zzc(java.lang.String r6, org.json.JSONObject r7) throws com.google.android.gms.internal.ads.zzfhv {
        /*
            r5 = this;
            java.lang.String r0 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            com.google.android.gms.internal.ads.zzfim r1 = new com.google.android.gms.internal.ads.zzfim     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzbsg r7 = new com.google.android.gms.internal.ads.zzbsg     // Catch:{ all -> 0x0071 }
            com.google.ads.mediation.admob.AdMobAdapter r0 = new com.google.ads.mediation.admob.AdMobAdapter     // Catch:{ all -> 0x0071 }
            r0.<init>()     // Catch:{ all -> 0x0071 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0068
        L_0x0017:
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobCustomTabsAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbsg r7 = new com.google.android.gms.internal.ads.zzbsg     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzbtx r0 = new com.google.android.gms.internal.ads.zzbtx     // Catch:{ all -> 0x0071 }
            r0.<init>()     // Catch:{ all -> 0x0071 }
            r7.<init>((com.google.android.gms.ads.mediation.MediationAdapter) r0)     // Catch:{ all -> 0x0071 }
            goto L_0x0068
        L_0x002a:
            com.google.android.gms.internal.ads.zzbrf r2 = r5.zza()     // Catch:{ all -> 0x0071 }
            boolean r3 = r0.equals(r6)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            if (r3 != 0) goto L_0x003c
            boolean r3 = r4.equals(r6)     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0064
        L_0x003c:
            java.lang.String r3 = "class_name"
            java.lang.String r7 = r7.getString(r3)     // Catch:{ JSONException -> 0x005e }
            boolean r3 = r2.zze(r7)     // Catch:{ JSONException -> 0x005e }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzbri r7 = r2.zzb(r0)     // Catch:{ JSONException -> 0x005e }
            goto L_0x0068
        L_0x004d:
            boolean r0 = r2.zzd(r7)     // Catch:{ JSONException -> 0x005e }
            if (r0 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzbri r7 = r2.zzb(r7)     // Catch:{ JSONException -> 0x005e }
            goto L_0x0068
        L_0x0058:
            com.google.android.gms.internal.ads.zzbri r7 = r2.zzb(r4)     // Catch:{ JSONException -> 0x005e }
            goto L_0x0068
        L_0x005e:
            r7 = move-exception
            java.lang.String r0 = "Invalid custom event."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r0, r7)     // Catch:{ all -> 0x0071 }
        L_0x0064:
            com.google.android.gms.internal.ads.zzbri r7 = r2.zzb(r6)     // Catch:{ all -> 0x0071 }
        L_0x0068:
            r1.<init>(r7)     // Catch:{ all -> 0x0071 }
            com.google.android.gms.internal.ads.zzdsq r7 = r5.zzb
            r7.zzc(r6, r1)
            return r1
        L_0x0071:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzjr
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzdsq r0 = r5.zzb
            r1 = 0
            r0.zzc(r6, r1)
        L_0x008a:
            com.google.android.gms.internal.ads.zzfhv r6 = new com.google.android.gms.internal.ads.zzfhv
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdst.zzc(java.lang.String, org.json.JSONObject):com.google.android.gms.internal.ads.zzfim");
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
