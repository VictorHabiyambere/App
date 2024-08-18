package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxv {
    private final zzdxf zza;
    private final zzdsq zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    zzdxv(zzdxf zzdxf, zzdsq zzdsq) {
        this.zza = zzdxf;
        this.zzb = zzdsq;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.util.List r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzc
            monitor-enter(r0)
            boolean r1 = r12.zze     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x0009:
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x008b }
        L_0x000d:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x008b }
            r2 = 1
            if (r1 == 0) goto L_0x0087
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbnn r1 = (com.google.android.gms.internal.ads.zzbnn) r1     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzjq     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x008b }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x008b }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzdsq r3 = r12.zzb     // Catch:{ all -> 0x008b }
            java.lang.String r4 = r1.zza     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzdsp r3 = r3.zza(r4)     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x0040
            com.google.android.gms.internal.ads.zzbtt r3 = r3.zzc     // Catch:{ all -> 0x008b }
            if (r3 != 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008b }
            goto L_0x0046
        L_0x0040:
            java.lang.String r3 = ""
            r6 = r3
            goto L_0x0047
        L_0x0044:
            java.lang.String r3 = ""
        L_0x0046:
            r6 = r3
        L_0x0047:
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzjr     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x008b }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x008b }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x008b }
            r4 = 0
            if (r3 == 0) goto L_0x006c
            com.google.android.gms.internal.ads.zzdsq r3 = r12.zzb     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r1.zza     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzdsp r3 = r3.zza(r5)     // Catch:{ all -> 0x008b }
            if (r3 != 0) goto L_0x0066
            r11 = r4
            goto L_0x006d
        L_0x0066:
            boolean r3 = r3.zzd     // Catch:{ all -> 0x008b }
            if (r3 == 0) goto L_0x006c
            r11 = r2
            goto L_0x006d
        L_0x006c:
            r11 = r4
        L_0x006d:
            java.util.List r2 = r12.zzd     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzdxu r3 = new com.google.android.gms.internal.ads.zzdxu     // Catch:{ all -> 0x008b }
            java.lang.String r5 = r1.zza     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzdsq r4 = r12.zzb     // Catch:{ all -> 0x008b }
            java.lang.String r7 = r4.zzb(r5)     // Catch:{ all -> 0x008b }
            boolean r8 = r1.zzb     // Catch:{ all -> 0x008b }
            java.lang.String r9 = r1.zzd     // Catch:{ all -> 0x008b }
            int r10 = r1.zzc     // Catch:{ all -> 0x008b }
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x008b }
            r2.add(r3)     // Catch:{ all -> 0x008b }
            goto L_0x000d
        L_0x0087:
            r12.zze = r2     // Catch:{ all -> 0x008b }
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x008b:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxv.zzd(java.util.List):void");
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                }
            }
            for (zzdxu zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdxt(this));
    }
}
