package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaej {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = zzgd.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzcd zzcd) {
        for (int i = 0; i < zzcd.zza(); i++) {
            zzcc zzb2 = zzcd.zzb(i);
            if (zzb2 instanceof zzahk) {
                zzahk zzahk = (zzahk) zzb2;
                if ("iTunSMPB".equals(zzahk.zzb) && zzc(zzahk.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzaht) {
                zzaht zzaht = (zzaht) zzb2;
                if ("com.apple.iTunes".equals(zzaht.zza) && "iTunSMPB".equals(zzaht.zzb) && zzc(zzaht.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
