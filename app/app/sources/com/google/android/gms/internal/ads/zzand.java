package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzand {
    private String zza = "";
    private String zzb = "";
    private Set zzc = Collections.emptySet();
    private String zzd = "";
    private String zze = null;
    private int zzf;
    private boolean zzg = false;
    private int zzh;
    private boolean zzi = false;
    private int zzj = -1;
    private int zzk = -1;
    private int zzl = -1;
    private int zzm = -1;
    private float zzn;
    private int zzo = -1;
    private boolean zzp = false;

    private static int zzA(int i, String str, String str2, int i2) {
        if (str.isEmpty() || i == -1) {
            return i;
        }
        if (str.equals(str2)) {
            return i + i2;
        }
        return -1;
    }

    public final float zza() {
        return this.zzn;
    }

    public final int zzb() {
        if (this.zzi) {
            return this.zzh;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public final int zzc() {
        if (this.zzg) {
            return this.zzf;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public final int zzd() {
        return this.zzm;
    }

    public final int zze() {
        return this.zzo;
    }

    public final int zzf(String str, String str2, Set set, String str3) {
        if (!this.zza.isEmpty() || !this.zzb.isEmpty() || !this.zzc.isEmpty() || !this.zzd.isEmpty()) {
            int zzA = zzA(zzA(zzA(0, this.zza, str, 1073741824), this.zzb, str2, 2), this.zzd, str3, 4);
            if (zzA == -1 || !set.containsAll(this.zzc)) {
                return 0;
            }
            return zzA + (this.zzc.size() * 4);
        } else if (TextUtils.isEmpty(str2)) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int zzg() {
        int i = this.zzk;
        if (i == -1 && this.zzl == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = i == 1 ? 1 : 0;
        if (this.zzl == 1) {
            i2 = 2;
        }
        return i3 | i2;
    }

    public final zzand zzh(int i) {
        this.zzh = i;
        this.zzi = true;
        return this;
    }

    public final zzand zzi(boolean z) {
        this.zzk = 1;
        return this;
    }

    public final zzand zzj(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzand zzk(int i) {
        this.zzf = i;
        this.zzg = true;
        return this;
    }

    public final zzand zzl(String str) {
        this.zze = zzfxm.zza(str);
        return this;
    }

    public final zzand zzm(float f) {
        this.zzn = f;
        return this;
    }

    public final zzand zzn(int i) {
        this.zzm = i;
        return this;
    }

    public final zzand zzo(boolean z) {
        this.zzl = 1;
        return this;
    }

    public final zzand zzp(int i) {
        this.zzo = i;
        return this;
    }

    public final zzand zzq(boolean z) {
        this.zzj = 1;
        return this;
    }

    public final String zzr() {
        return this.zze;
    }

    public final void zzs(String[] strArr) {
        this.zzc = new HashSet(Arrays.asList(strArr));
    }

    public final void zzt(String str) {
        this.zza = str;
    }

    public final void zzu(String str) {
        this.zzb = str;
    }

    public final void zzv(String str) {
        this.zzd = str;
    }

    public final boolean zzw() {
        return this.zzp;
    }

    public final boolean zzx() {
        return this.zzi;
    }

    public final boolean zzy() {
        return this.zzg;
    }

    public final boolean zzz() {
        return this.zzj == 1;
    }
}
