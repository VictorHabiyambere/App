package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbfe {
    private final List zza = new LinkedList();
    private final Map zzb = new LinkedHashMap();
    private final Object zzc = new Object();

    public zzbfe(boolean z, String str, String str2) {
        this.zzb.put("action", "make_wv");
        this.zzb.put("ad_format", str2);
    }

    public static final zzbfb zzf() {
        return new zzbfb(zzu.zzB().elapsedRealtime(), (String) null, (zzbfb) null);
    }

    public final zzbfd zza() {
        zzbfd zzbfd;
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbep.zzbR)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbfb zzbfb : this.zza) {
                long zza2 = zzbfb.zza();
                String zzc2 = zzbfb.zzc();
                zzbfb zzb2 = zzbfb.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzu.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzu.zzB().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzbfd = new zzbfd(sb.toString(), str);
        }
        return zzbfd;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzu.zzo().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbfe zzbfe) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbeu zzg;
        if (!TextUtils.isEmpty(str2) && (zzg = zzu.zzo().zzg()) != null) {
            synchronized (this.zzc) {
                zzbfa zza2 = zzg.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbfb zzbfb, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbfb(j, strArr[0], zzbfb));
        }
        return true;
    }
}
