package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbxu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzax {
    public final String zza;
    public String zzb;
    public zzbxu zzc;
    public Bundle zzd = new Bundle();
    private long zze = -1;
    private long zzf = -1;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzax(android.util.JsonReader r5, com.google.android.gms.internal.ads.zzbxu r6) throws java.io.IOException {
        /*
            r4 = this;
            r4.<init>()
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            r4.zzd = r0
            r0 = -1
            r4.zze = r0
            r4.zzf = r0
            r4.zzc = r6
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r5.beginObject()
            java.lang.String r0 = ""
            r1 = r0
        L_0x001d:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0093
            java.lang.String r2 = r5.nextName()
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x002a:
            int r3 = r2.hashCode()
            switch(r3) {
                case -1573145462: goto L_0x0050;
                case -995427962: goto L_0x0046;
                case -271442291: goto L_0x003c;
                case 1725551537: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x005a
        L_0x0032:
            java.lang.String r3 = "end_time"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005a
            r2 = 3
            goto L_0x005b
        L_0x003c:
            java.lang.String r3 = "signal_dictionary"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x0046:
            java.lang.String r3 = "params"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005a
            r2 = 0
            goto L_0x005b
        L_0x0050:
            java.lang.String r3 = "start_time"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x005a
            r2 = 2
            goto L_0x005b
        L_0x005a:
            r2 = -1
        L_0x005b:
            switch(r2) {
                case 0: goto L_0x008e;
                case 1: goto L_0x0070;
                case 2: goto L_0x0069;
                case 3: goto L_0x0062;
                default: goto L_0x005e;
            }
        L_0x005e:
            r5.skipValue()
            goto L_0x001d
        L_0x0062:
            long r2 = r5.nextLong()
            r4.zzf = r2
            goto L_0x001d
        L_0x0069:
            long r2 = r5.nextLong()
            r4.zze = r2
            goto L_0x001d
        L_0x0070:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r5.beginObject()
        L_0x0078:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = r5.nextName()
            java.lang.String r3 = r5.nextString()
            r6.put(r2, r3)
            goto L_0x0078
        L_0x008a:
            r5.endObject()
            goto L_0x001d
        L_0x008e:
            java.lang.String r1 = r5.nextString()
            goto L_0x001d
        L_0x0093:
            r4.zza = r1
            r5.endObject()
            java.util.Set r5 = r6.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x00a0:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00ca
            java.lang.Object r6 = r5.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r0 = r6.getKey()
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r0 = r6.getValue()
            if (r0 == 0) goto L_0x00a0
            android.os.Bundle r0 = r4.zzd
            java.lang.Object r1 = r6.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            r0.putString(r1, r6)
            goto L_0x00a0
        L_0x00ca:
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzcd
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzbxu r5 = r4.zzc
            if (r5 == 0) goto L_0x00fe
            android.os.Bundle r5 = r5.zzm
            if (r5 == 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzdul r6 = com.google.android.gms.internal.ads.zzdul.GET_SIGNALS_SDKCORE_START
            java.lang.String r6 = r6.zza()
            long r0 = r4.zze
            r5.putLong(r6, r0)
            com.google.android.gms.internal.ads.zzbxu r5 = r4.zzc
            android.os.Bundle r5 = r5.zzm
            com.google.android.gms.internal.ads.zzdul r6 = com.google.android.gms.internal.ads.zzdul.GET_SIGNALS_SDKCORE_END
            java.lang.String r6 = r6.zza()
            long r0 = r4.zzf
            r5.putLong(r6, r0)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzax.<init>(android.util.JsonReader, com.google.android.gms.internal.ads.zzbxu):void");
    }
}
