package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzfho;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzp {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfnc zza(android.os.Bundle r1) {
        /*
            java.lang.String r0 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r0 = r1.getBundle(r0)
            if (r0 == 0) goto L_0x0009
            r1 = r0
        L_0x0009:
            java.lang.String r0 = "query_info_type"
            java.lang.String r1 = r1.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x0018
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_UNSPECIFIED
            return r1
        L_0x0018:
            int r0 = r1.hashCode()
            switch(r0) {
                case 1743582862: goto L_0x0072;
                case 1743582863: goto L_0x0068;
                case 1743582864: goto L_0x005e;
                case 1743582865: goto L_0x0054;
                case 1743582866: goto L_0x004a;
                case 1743582867: goto L_0x0040;
                case 1743582868: goto L_0x0036;
                case 1743582869: goto L_0x002c;
                case 1743582870: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x007c
        L_0x0020:
            java.lang.String r0 = "requester_type_8"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 8
            goto L_0x007d
        L_0x002c:
            java.lang.String r0 = "requester_type_7"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 7
            goto L_0x007d
        L_0x0036:
            java.lang.String r0 = "requester_type_6"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 6
            goto L_0x007d
        L_0x0040:
            java.lang.String r0 = "requester_type_5"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 5
            goto L_0x007d
        L_0x004a:
            java.lang.String r0 = "requester_type_4"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 4
            goto L_0x007d
        L_0x0054:
            java.lang.String r0 = "requester_type_3"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 3
            goto L_0x007d
        L_0x005e:
            java.lang.String r0 = "requester_type_2"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 2
            goto L_0x007d
        L_0x0068:
            java.lang.String r0 = "requester_type_1"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 1
            goto L_0x007d
        L_0x0072:
            java.lang.String r0 = "requester_type_0"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x001f
            r1 = 0
            goto L_0x007d
        L_0x007c:
            r1 = -1
        L_0x007d:
            switch(r1) {
                case 0: goto L_0x009b;
                case 1: goto L_0x0098;
                case 2: goto L_0x0095;
                case 3: goto L_0x0092;
                case 4: goto L_0x008f;
                case 5: goto L_0x008c;
                case 6: goto L_0x0089;
                case 7: goto L_0x0086;
                case 8: goto L_0x0083;
                default: goto L_0x0080;
            }
        L_0x0080:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_UNSPECIFIED
            return r1
        L_0x0083:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_GAM_S2S
            return r1
        L_0x0086:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_GUILDER
            return r1
        L_0x0089:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_PAW
            return r1
        L_0x008c:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_UNITY
            return r1
        L_0x008f:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_YAVIN
            return r1
        L_0x0092:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_GOLDENEYE
            return r1
        L_0x0095:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_GBID
            return r1
        L_0x0098:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_INBOUND_MEDIATION
            return r1
        L_0x009b:
            com.google.android.gms.internal.ads.zzfnc r1 = com.google.android.gms.internal.ads.zzfnc.SCAR_REQUEST_TYPE_ADMOB
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzp.zza(android.os.Bundle):com.google.android.gms.internal.ads.zzfnc");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zzb(java.lang.String r1) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L_0x0009
            java.lang.String r1 = "unspecified"
            return r1
        L_0x0009:
            int r0 = r1.hashCode()
            switch(r0) {
                case 1743582862: goto L_0x0062;
                case 1743582863: goto L_0x0058;
                case 1743582864: goto L_0x004e;
                case 1743582865: goto L_0x0044;
                case 1743582866: goto L_0x003a;
                case 1743582867: goto L_0x0030;
                case 1743582868: goto L_0x0026;
                case 1743582869: goto L_0x001c;
                case 1743582870: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x006c
        L_0x0011:
            java.lang.String r0 = "requester_type_8"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 8
            goto L_0x006d
        L_0x001c:
            java.lang.String r0 = "requester_type_7"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 7
            goto L_0x006d
        L_0x0026:
            java.lang.String r0 = "requester_type_6"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 6
            goto L_0x006d
        L_0x0030:
            java.lang.String r0 = "requester_type_5"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 5
            goto L_0x006d
        L_0x003a:
            java.lang.String r0 = "requester_type_4"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 4
            goto L_0x006d
        L_0x0044:
            java.lang.String r0 = "requester_type_3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 3
            goto L_0x006d
        L_0x004e:
            java.lang.String r0 = "requester_type_2"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 2
            goto L_0x006d
        L_0x0058:
            java.lang.String r0 = "requester_type_1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x006d
        L_0x0062:
            java.lang.String r0 = "requester_type_0"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 0
            goto L_0x006d
        L_0x006c:
            r0 = -1
        L_0x006d:
            switch(r0) {
                case 0: goto L_0x0089;
                case 1: goto L_0x0086;
                case 2: goto L_0x0083;
                case 3: goto L_0x0080;
                case 4: goto L_0x007d;
                case 5: goto L_0x007a;
                case 6: goto L_0x0077;
                case 7: goto L_0x0074;
                case 8: goto L_0x0071;
                default: goto L_0x0070;
            }
        L_0x0070:
            return r1
        L_0x0071:
            java.lang.String r1 = "8"
            return r1
        L_0x0074:
            java.lang.String r1 = "7"
            return r1
        L_0x0077:
            java.lang.String r1 = "6"
            return r1
        L_0x007a:
            java.lang.String r1 = "5"
            return r1
        L_0x007d:
            java.lang.String r1 = "4"
            return r1
        L_0x0080:
            java.lang.String r1 = "3"
            return r1
        L_0x0083:
            java.lang.String r1 = "2"
            return r1
        L_0x0086:
            java.lang.String r1 = "1"
            return r1
        L_0x0089:
            java.lang.String r1 = "0"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzp.zzb(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.zzc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zzc(com.google.android.gms.ads.internal.client.zzl r1) {
        /*
            if (r1 == 0) goto L_0x000e
            android.os.Bundle r1 = r1.zzc
            if (r1 != 0) goto L_0x0007
            goto L_0x000e
        L_0x0007:
            java.lang.String r0 = "query_info_type"
            java.lang.String r1 = r1.getString(r0)
            return r1
        L_0x000e:
            java.lang.String r1 = "unspecified"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzp.zzc(com.google.android.gms.ads.internal.client.zzl):java.lang.String");
    }

    public static void zzd(zzdvh zzdvh, zzdux zzdux, String str, Pair... pairArr) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzhj)).booleanValue()) {
            zzcci.zza.execute(new zzo(zzdvh, (zzdux) null, str, pairArr));
        }
    }

    static void zze(zzdvh zzdvh, zzdux zzdux, String str, Pair... pairArr) {
        ConcurrentHashMap zzc = zzdvh.zzc();
        zzg(zzc, "action", str);
        for (Pair pair : pairArr) {
            zzg(zzc, (String) pair.first, (String) pair.second);
        }
        zzdvh.zzf(zzc);
    }

    public static int zzf(zzfho zzfho) {
        if (zzfho.zzr) {
            return 2;
        }
        zzl zzl = zzfho.zzd;
        zzc zzc = zzl.zzs;
        if (zzc == null && zzl.zzx == null) {
            return 1;
        }
        if (zzc == null || zzl.zzx == null) {
            return zzc != null ? 3 : 4;
        }
        return 5;
    }

    private static void zzg(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }
}
