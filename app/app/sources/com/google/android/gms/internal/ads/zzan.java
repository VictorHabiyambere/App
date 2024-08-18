package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzan {
    private static final zzan zzI = new zzan(new zzal());
    private static final String zzJ = Integer.toString(0, 36);
    private static final String zzK = Integer.toString(1, 36);
    private static final String zzL = Integer.toString(2, 36);
    private static final String zzM = Integer.toString(3, 36);
    private static final String zzN = Integer.toString(4, 36);
    private static final String zzO = Integer.toString(5, 36);
    private static final String zzP = Integer.toString(6, 36);
    private static final String zzQ = Integer.toString(7, 36);
    private static final String zzR = Integer.toString(8, 36);
    private static final String zzS = Integer.toString(9, 36);
    private static final String zzT = Integer.toString(10, 36);
    private static final String zzU = Integer.toString(11, 36);
    private static final String zzV = Integer.toString(12, 36);
    private static final String zzW = Integer.toString(13, 36);
    private static final String zzX = Integer.toString(14, 36);
    private static final String zzY = Integer.toString(15, 36);
    private static final String zzZ = Integer.toString(16, 36);
    @Deprecated
    public static final zzn zza = new zzai();
    private static final String zzaa = Integer.toString(17, 36);
    private static final String zzab = Integer.toString(18, 36);
    private static final String zzac = Integer.toString(19, 36);
    private static final String zzad = Integer.toString(20, 36);
    private static final String zzae = Integer.toString(21, 36);
    private static final String zzaf = Integer.toString(22, 36);
    private static final String zzag = Integer.toString(23, 36);
    private static final String zzah = Integer.toString(24, 36);
    private static final String zzai = Integer.toString(25, 36);
    private static final String zzaj = Integer.toString(26, 36);
    private static final String zzak = Integer.toString(27, 36);
    private static final String zzal = Integer.toString(28, 36);
    private static final String zzam = Integer.toString(29, 36);
    private static final String zzan = Integer.toString(30, 36);
    private static final String zzao = Integer.toString(31, 36);
    private static final String zzap = Integer.toString(32, 36);
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    public final int zzG;
    public final int zzH;
    private int zzaq;
    public final String zzb;
    public final String zzc;
    public final List zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final String zzk;
    public final zzcd zzl;
    public final String zzm;
    public final String zzn;
    public final int zzo;
    public final List zzp;
    public final zzae zzq;
    public final long zzr;
    public final int zzs;
    public final int zzt;
    public final float zzu;
    public final int zzv;
    public final float zzw;
    public final byte[] zzx;
    public final int zzy;
    public final zzt zzz;

    private zzan(zzal zzal2) {
        boolean z;
        String str;
        this.zzb = zzal2.zza;
        this.zze = zzgd.zzD(zzal2.zzd);
        int i = 0;
        if (zzal2.zzc.isEmpty() && zzal2.zzb != null) {
            this.zzd = zzgbc.zzn(new zzas(this.zze, zzal2.zzb));
            this.zzc = zzal2.zzb;
        } else if (zzal2.zzc.isEmpty() || zzal2.zzb != null) {
            if (!zzal2.zzc.isEmpty() || zzal2.zzb != null) {
                z = zzal2.zzc.stream().anyMatch(new zzaj(zzal2));
            } else {
                z = true;
            }
            zzeq.zzf(z);
            this.zzd = zzal2.zzc;
            this.zzc = zzal2.zzb;
        } else {
            this.zzd = zzal2.zzc;
            List zzam2 = zzal2.zzc;
            String str2 = this.zze;
            Iterator it = zzam2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = ((zzas) zzam2.get(0)).zzb;
                    break;
                }
                zzas zzas = (zzas) it.next();
                if (TextUtils.equals(zzas.zza, str2)) {
                    str = zzas.zzb;
                    break;
                }
            }
            this.zzc = str;
        }
        this.zzf = zzal2.zze;
        this.zzg = zzal2.zzf;
        int zzd2 = zzal2.zzg;
        this.zzh = zzd2;
        int zzm2 = zzal2.zzh;
        this.zzi = zzm2;
        this.zzj = zzm2 != -1 ? zzm2 : zzd2;
        this.zzk = zzal2.zzi;
        this.zzl = zzal2.zzj;
        this.zzm = zzal2.zzk;
        this.zzn = zzal2.zzl;
        this.zzo = zzal2.zzm;
        this.zzp = zzal2.zzn == null ? Collections.emptyList() : zzal2.zzn;
        this.zzq = zzal2.zzo;
        this.zzr = zzal2.zzp;
        this.zzs = zzal2.zzq;
        this.zzt = zzal2.zzr;
        this.zzu = zzal2.zzs;
        this.zzv = zzal2.zzt == -1 ? 0 : zzal2.zzt;
        this.zzw = zzal2.zzu == -1.0f ? 1.0f : zzal2.zzu;
        this.zzx = zzal2.zzv;
        this.zzy = zzal2.zzw;
        this.zzz = zzal2.zzx;
        this.zzA = zzal2.zzy;
        this.zzB = zzal2.zzz;
        this.zzC = zzal2.zzA;
        this.zzD = zzal2.zzB == -1 ? 0 : zzal2.zzB;
        this.zzE = zzal2.zzC != -1 ? zzal2.zzC : i;
        this.zzF = zzal2.zzD;
        this.zzG = zzal2.zzE;
        if (zzal2.zzF != 0 || this.zzq == null) {
            this.zzH = zzal2.zzF;
        } else {
            this.zzH = 1;
        }
    }

    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzan zzan2 = (zzan) obj;
        int i2 = this.zzaq;
        if ((i2 == 0 || (i = zzan2.zzaq) == 0 || i2 == i) && this.zzf == zzan2.zzf && this.zzg == zzan2.zzg && this.zzh == zzan2.zzh && this.zzi == zzan2.zzi && this.zzo == zzan2.zzo && this.zzr == zzan2.zzr && this.zzs == zzan2.zzs && this.zzt == zzan2.zzt && this.zzv == zzan2.zzv && this.zzy == zzan2.zzy && this.zzA == zzan2.zzA && this.zzB == zzan2.zzB && this.zzC == zzan2.zzC && this.zzD == zzan2.zzD && this.zzE == zzan2.zzE && this.zzF == zzan2.zzF && this.zzH == zzan2.zzH && Float.compare(this.zzu, zzan2.zzu) == 0 && Float.compare(this.zzw, zzan2.zzw) == 0 && zzgd.zzG(this.zzb, zzan2.zzb) && zzgd.zzG(this.zzc, zzan2.zzc) && this.zzd.equals(zzan2.zzd) && zzgd.zzG(this.zzk, zzan2.zzk) && zzgd.zzG(this.zzm, zzan2.zzm) && zzgd.zzG(this.zzn, zzan2.zzn) && zzgd.zzG(this.zze, zzan2.zze) && Arrays.equals(this.zzx, zzan2.zzx) && zzgd.zzG(this.zzl, zzan2.zzl) && zzgd.zzG(this.zzz, zzan2.zzz) && zzgd.zzG(this.zzq, zzan2.zzq) && zzd(zzan2)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzz);
        return "Format(" + this.zzb + ", " + this.zzc + ", " + this.zzm + ", " + this.zzn + ", " + this.zzk + ", " + this.zzj + ", " + this.zze + ", [" + this.zzs + ", " + this.zzt + ", " + this.zzu + ", " + valueOf + "], [" + this.zzA + ", " + this.zzB + "])";
    }

    public final int zza() {
        int i;
        int i2 = this.zzs;
        if (i2 == -1 || (i = this.zzt) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final zzal zzb() {
        return new zzal(this, (zzak) null);
    }

    public final zzan zzc(int i) {
        zzal zzal2 = new zzal(this, (zzak) null);
        zzal2.zzC(i);
        return new zzan(zzal2);
    }

    public final boolean zzd(zzan zzan2) {
        if (this.zzp.size() != zzan2.zzp.size()) {
            return false;
        }
        for (int i = 0; i < this.zzp.size(); i++) {
            if (!Arrays.equals((byte[]) this.zzp.get(i), (byte[]) zzan2.zzp.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzaq;
        if (i7 != 0) {
            return i7;
        }
        String str = this.zzb;
        int i8 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzc;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int hashCode = ((((i + 527) * 31) + i2) * 31) + this.zzd.hashCode();
        String str3 = this.zze;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i9 = ((((((((((hashCode * 31) + i3) * 31) + this.zzf) * 31) + this.zzg) * 31) + this.zzh) * 31) + this.zzi) * 31;
        String str4 = this.zzk;
        if (str4 == null) {
            i4 = 0;
        } else {
            i4 = str4.hashCode();
        }
        int i10 = (i9 + i4) * 31;
        zzcd zzcd = this.zzl;
        if (zzcd == null) {
            i5 = 0;
        } else {
            i5 = zzcd.hashCode();
        }
        int i11 = (i10 + i5) * 31;
        String str5 = this.zzm;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i12 = (i11 + i6) * 31;
        String str6 = this.zzn;
        if (str6 != null) {
            i8 = str6.hashCode();
        }
        int floatToIntBits = ((((((((((((((((((((((((((((((((((i12 + i8) * 31) + this.zzo) * 31) + ((int) this.zzr)) * 31) + this.zzs) * 31) + this.zzt) * 31) + Float.floatToIntBits(this.zzu)) * 31) + this.zzv) * 31) + Float.floatToIntBits(this.zzw)) * 31) + this.zzy) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) + this.zzF) * 31) - 1) * 31) - 1) * 31) + this.zzH;
        this.zzaq = floatToIntBits;
        return floatToIntBits;
    }
}
