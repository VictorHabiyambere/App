package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeeh implements zzfkw {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfmc zzc;
    private final zzfmn zzd;

    public zzeeh(String str, zzfmn zzfmn, zzfmc zzfmc) {
        this.zzb = str;
        this.zzd = zzfmn;
        this.zzc = zzfmc;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdzd zzdzd;
        String str;
        zzeeg zzeeg = (zzeeg) obj;
        int optInt = zzeeg.zza.optInt("http_timeout_millis", 60000);
        zzbxx zza2 = zzeeg.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzeeg.zzb.zzj() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzaP)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, this.zzb);
                }
            }
            if (zzeeg.zzb.zzk()) {
                zzeei.zza(hashMap, zzeeg.zza);
            }
            if (zzeeg.zzb != null && !TextUtils.isEmpty(zzeeg.zzb.zzf())) {
                str2 = zzeeg.zzb.zzf();
            }
            zzfmn zzfmn = this.zzd;
            zzfmc zzfmc = this.zzc;
            zzfmc.zzh(true);
            zzfmn.zza(zzfmc);
            return new zzeec(zzeeg.zzb.zzg(), optInt, hashMap, str2.getBytes(zzfxs.zzc), "", zzeeg.zzb.zzk());
        }
        if (zza2.zza() == 1) {
            if (zza2.zzh() != null) {
                str2 = TextUtils.join(", ", zza2.zzh());
                zzm.zzg(str2);
            }
            zzdzd = new zzdzd(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdzd = new zzdzd(1);
        }
        zzfmn zzfmn2 = this.zzd;
        zzfmc zzfmc2 = this.zzc;
        zzfmc2.zzi(zzdzd);
        zzfmc2.zzh(false);
        zzfmn2.zza(zzfmc2);
        throw zzdzd;
    }
}
