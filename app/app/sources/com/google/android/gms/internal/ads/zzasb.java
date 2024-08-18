package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzasb {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzarq.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzarq.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static zzaqn zzb(zzara zzara) {
        long j;
        long j2;
        long j3;
        boolean z;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        zzara zzara2 = zzara;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzara2.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        if (str != null) {
            j = zza(str);
        } else {
            j = 0;
        }
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j3 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j3 = 0;
            j2 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        if (str3 != null) {
            j4 = zza(str3);
        } else {
            j4 = 0;
        }
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        if (str4 != null) {
            j5 = zza(str4);
        } else {
            j5 = 0;
        }
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            long j9 = currentTimeMillis + (j2 * 1000);
            if (z) {
                j8 = j9;
            } else {
                j8 = (j3 * 1000) + j9;
            }
            j6 = j8;
            j7 = j9;
        } else {
            j6 = 0;
            if (j <= 0 || j4 < j) {
                j7 = 0;
            } else {
                j7 = (j4 - j) + currentTimeMillis;
                j6 = j7;
            }
        }
        zzaqn zzaqn = new zzaqn();
        zzaqn.zza = zzara2.zzb;
        zzaqn.zzb = str5;
        zzaqn.zzf = j7;
        zzaqn.zze = j6;
        zzaqn.zzc = j;
        zzaqn.zzd = j5;
        zzaqn.zzg = map;
        zzaqn.zzh = zzara2.zzd;
        return zzaqn;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
