package com.google.android.gms.internal.ads;

import android.text.Layout;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzamy {
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private float zzk;
    private String zzl;
    private int zzm = -1;
    private int zzn = -1;
    private Layout.Alignment zzo;
    private Layout.Alignment zzp;
    private int zzq = -1;
    private zzamr zzr;
    private float zzs = Float.MAX_VALUE;

    public final zzamy zzA(boolean z) {
        this.zzq = z ? 1 : 0;
        return this;
    }

    public final zzamy zzB(zzamr zzamr) {
        this.zzr = zzamr;
        return this;
    }

    public final zzamy zzC(boolean z) {
        this.zzg = z ? 1 : 0;
        return this;
    }

    public final String zzD() {
        return this.zza;
    }

    public final String zzE() {
        return this.zzl;
    }

    public final boolean zzF() {
        return this.zzq == 1;
    }

    public final boolean zzG() {
        return this.zze;
    }

    public final boolean zzH() {
        return this.zzc;
    }

    public final boolean zzI() {
        return this.zzf == 1;
    }

    public final boolean zzJ() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i = this.zzh;
        if (i == -1 && this.zzi == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.zzi == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    public final zzamr zzk() {
        return this.zzr;
    }

    public final zzamy zzl(zzamy zzamy) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzamy != null) {
            if (!this.zzc && zzamy.zzc) {
                zzo(zzamy.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzamy.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzamy.zzi;
            }
            if (this.zza == null && (str = zzamy.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzamy.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzamy.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzamy.zzn;
            }
            if (this.zzo == null && (alignment2 = zzamy.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzamy.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzamy.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzamy.zzj;
                this.zzk = zzamy.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzamy.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzamy.zzs;
            }
            if (!this.zze && zzamy.zze) {
                zzm(zzamy.zzd);
            }
            if (this.zzm == -1 && (i = zzamy.zzm) != -1) {
                this.zzm = i;
            }
        }
        return this;
    }

    public final zzamy zzm(int i) {
        this.zzd = i;
        this.zze = true;
        return this;
    }

    public final zzamy zzn(boolean z) {
        this.zzh = z ? 1 : 0;
        return this;
    }

    public final zzamy zzo(int i) {
        this.zzb = i;
        this.zzc = true;
        return this;
    }

    public final zzamy zzp(String str) {
        this.zza = str;
        return this;
    }

    public final zzamy zzq(float f) {
        this.zzk = f;
        return this;
    }

    public final zzamy zzr(int i) {
        this.zzj = i;
        return this;
    }

    public final zzamy zzs(String str) {
        this.zzl = str;
        return this;
    }

    public final zzamy zzt(boolean z) {
        this.zzi = z ? 1 : 0;
        return this;
    }

    public final zzamy zzu(boolean z) {
        this.zzf = z ? 1 : 0;
        return this;
    }

    public final zzamy zzv(Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzamy zzw(int i) {
        this.zzn = i;
        return this;
    }

    public final zzamy zzx(int i) {
        this.zzm = i;
        return this;
    }

    public final zzamy zzy(float f) {
        this.zzs = f;
        return this;
    }

    public final zzamy zzz(Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }
}
