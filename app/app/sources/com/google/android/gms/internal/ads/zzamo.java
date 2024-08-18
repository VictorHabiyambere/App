package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamo {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzamo(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzamo zzb(String str, zzamm zzamm) {
        float f;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        String trim;
        String str2 = str;
        zzamm zzamm2 = zzamm;
        zzeq.zzd(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        int length = split.length;
        int i2 = zzamm2.zzk;
        if (length != i2) {
            zzfk.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", new Object[]{Integer.valueOf(i2), Integer.valueOf(length), str2}));
            return null;
        }
        try {
            String trim2 = split[zzamm2.zza].trim();
            int i3 = zzamm2.zzb;
            int zzd2 = i3 != -1 ? zzd(split[i3].trim()) : -1;
            int i4 = zzamm2.zzc;
            Integer zzc2 = i4 != -1 ? zzc(split[i4].trim()) : null;
            int i5 = zzamm2.zzd;
            Integer zzc3 = i5 != -1 ? zzc(split[i5].trim()) : null;
            int i6 = zzamm2.zze;
            if (i6 != -1) {
                String trim3 = split[i6].trim();
                try {
                    f = Float.parseFloat(trim3);
                } catch (NumberFormatException e) {
                    zzfk.zzg("SsaStyle", "Failed to parse font size: '" + trim3 + "'", e);
                    f = -3.4028235E38f;
                }
            } else {
                f = -3.4028235E38f;
            }
            int i7 = zzamm2.zzf;
            if (i7 == -1 || !zze(split[i7].trim())) {
                z = false;
            } else {
                z = true;
            }
            int i8 = zzamm2.zzg;
            if (i8 == -1 || !zze(split[i8].trim())) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i9 = zzamm2.zzh;
            if (i9 == -1 || !zze(split[i9].trim())) {
                z3 = false;
            } else {
                z3 = true;
            }
            int i10 = zzamm2.zzi;
            if (i10 == -1 || !zze(split[i10].trim())) {
                z4 = false;
            } else {
                z4 = true;
            }
            int i11 = zzamm2.zzj;
            if (i11 != -1) {
                trim = split[i11].trim();
                try {
                    i = Integer.parseInt(trim.trim());
                    switch (i) {
                        case 1:
                        case 3:
                            break;
                    }
                } catch (NumberFormatException e2) {
                }
            }
            i = -1;
            return new zzamo(trim2, zzd2, zzc2, zzc3, f, z, z2, z3, z4, i);
        } catch (RuntimeException e3) {
            zzfk.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str2 + "'", e3);
            return null;
        }
        zzfk.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(trim)));
        i = -1;
        return new zzamo(trim2, zzd2, zzc2, zzc3, f, z, z2, z3, z4, i);
    }

    public static Integer zzc(String str) {
        long j;
        boolean z;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            if (j <= 4294967295L) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzd(z);
            int zzb2 = zzgea.zzb(((j >> 24) & 255) ^ 255);
            int zzb3 = zzgea.zzb((j >> 16) & 255);
            return Integer.valueOf(Color.argb(zzb2, zzgea.zzb(j & 255), zzgea.zzb((j >> 8) & 255), zzb3));
        } catch (IllegalArgumentException e) {
            zzfk.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return parseInt;
            }
        } catch (NumberFormatException e) {
        }
        zzfk.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
        return -1;
    }

    private static boolean zze(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e) {
            zzfk.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
