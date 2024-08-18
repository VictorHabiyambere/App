package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzyl extends zzza implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzys zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzyl(int i, zzde zzde, int i2, zzys zzys, int i3, boolean z, zzfyh zzfyh, int i4) {
        super(i, zzde, i2);
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        int i7;
        boolean z5;
        boolean z6;
        this.zzh = zzys;
        int i8 = 1;
        int i9 = true != zzys.zzR ? 16 : 24;
        boolean z7 = zzys.zzN;
        this.zzg = zzze.zzh(this.zzd.zze);
        this.zzi = zzze.zzo(i3, false);
        int i10 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i10 >= zzys.zzq.size()) {
                i6 = 0;
                i10 = Integer.MAX_VALUE;
                break;
            }
            i6 = zzze.zzc(this.zzd, (String) zzys.zzq.get(i10), false);
            if (i6 > 0) {
                break;
            }
            i10++;
        }
        this.zzk = i10;
        this.zzj = i6;
        int i11 = this.zzd.zzg;
        int i12 = zzys.zzr;
        this.zzl = zzze.zzb(i11, 0);
        zzan zzan = this.zzd;
        int i13 = zzan.zzg;
        if (i13 != 0) {
            z2 = (i13 & 1) != 0;
        } else {
            z2 = true;
        }
        this.zzm = z2;
        if (1 != (zzan.zzf & 1)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.zzp = z3;
        this.zzq = zzan.zzA;
        this.zzr = zzan.zzB;
        this.zzs = zzan.zzj;
        if (zzan.zzj != -1) {
            int i14 = zzys.zzt;
        }
        if (zzan.zzA != -1) {
            int i15 = zzys.zzs;
        }
        if (zzfyh.zza(zzan)) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzf = z4;
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] split = zzgd.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i16 = 0; i16 < split.length; i16++) {
            split[i16] = zzgd.zzD(split[i16]);
        }
        int i17 = 0;
        while (true) {
            if (i17 >= split.length) {
                i7 = 0;
                i17 = Integer.MAX_VALUE;
                break;
            }
            i7 = zzze.zzc(this.zzd, split[i17], false);
            if (i7 > 0) {
                break;
            }
            i17++;
        }
        this.zzn = i17;
        this.zzo = i7;
        int i18 = 0;
        while (true) {
            if (i18 < zzys.zzu.size()) {
                String str = this.zzd.zzn;
                if (str != null && str.equals(zzys.zzu.get(i18))) {
                    i5 = i18;
                    break;
                }
                i18++;
            } else {
                break;
            }
        }
        this.zzt = i5;
        if ((i3 & 384) == 128) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzu = z5;
        if ((i3 & 64) == 64) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.zzv = z6;
        zzys zzys2 = this.zzh;
        if (!zzze.zzo(i3, zzys2.zzT)) {
            i8 = 0;
        } else {
            boolean z8 = this.zzf;
            if (z8 || zzys2.zzM) {
                zzdj zzdj = zzys2.zzv;
                if (zzze.zzo(i3, false) && z8 && this.zzd.zzj != -1) {
                    boolean z9 = zzys2.zzC;
                    boolean z10 = zzys2.zzB;
                    if ((zzys2.zzV || !z) && (i9 & i3) != 0) {
                        i8 = 2;
                    }
                }
            } else {
                i8 = 0;
            }
        }
        this.zze = i8;
    }

    /* renamed from: zza */
    public final int compareTo(zzyl zzyl) {
        zzgcn zzgcn;
        if (!this.zzf || !this.zzi) {
            zzgcn = zzze.zzb.zza();
        } else {
            zzgcn = zzze.zzb;
        }
        zzgar zzd = zzgar.zzk().zze(this.zzi, zzyl.zzi).zzd(Integer.valueOf(this.zzk), Integer.valueOf(zzyl.zzk), zzgcn.zzc().zza()).zzb(this.zzj, zzyl.zzj).zzb(this.zzl, zzyl.zzl).zze(this.zzp, zzyl.zzp).zze(this.zzm, zzyl.zzm).zzd(Integer.valueOf(this.zzn), Integer.valueOf(zzyl.zzn), zzgcn.zzc().zza()).zzb(this.zzo, zzyl.zzo).zze(this.zzf, zzyl.zzf).zzd(Integer.valueOf(this.zzt), Integer.valueOf(zzyl.zzt), zzgcn.zzc().zza());
        boolean z = this.zzh.zzB;
        zzgar zzd2 = zzd.zze(this.zzu, zzyl.zzu).zze(this.zzv, zzyl.zzv).zzd(Integer.valueOf(this.zzq), Integer.valueOf(zzyl.zzq), zzgcn).zzd(Integer.valueOf(this.zzr), Integer.valueOf(zzyl.zzr), zzgcn);
        if (zzgd.zzG(this.zzg, zzyl.zzg)) {
            zzd2 = zzd2.zzd(Integer.valueOf(this.zzs), Integer.valueOf(zzyl.zzs), zzgcn);
        }
        return zzd2.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzza zzza) {
        String str;
        zzyl zzyl = (zzyl) zzza;
        boolean z = this.zzh.zzP;
        zzan zzan = this.zzd;
        int i = zzan.zzA;
        if (i == -1) {
            return false;
        }
        zzan zzan2 = zzyl.zzd;
        if (i != zzan2.zzA || (str = zzan.zzn) == null || !TextUtils.equals(str, zzan2.zzn)) {
            return false;
        }
        zzys zzys = this.zzh;
        boolean z2 = zzys.zzO;
        int i2 = this.zzd.zzB;
        if (i2 == -1 || i2 != zzyl.zzd.zzB) {
            return false;
        }
        boolean z3 = zzys.zzQ;
        return this.zzu == zzyl.zzu && this.zzv == zzyl.zzv;
    }
}
