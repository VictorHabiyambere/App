package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzare implements Comparable {
    /* access modifiers changed from: private */
    public final zzarp zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzari zzf;
    private Integer zzg;
    private zzarh zzh;
    private boolean zzi;
    private zzaqn zzj;
    private zzard zzk;
    private final zzaqs zzl;

    public zzare(int i, String str, zzari zzari) {
        zzarp zzarp;
        Uri parse;
        String host;
        if (zzarp.zza) {
            zzarp = new zzarp();
        } else {
            zzarp = null;
        }
        this.zza = zzarp;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzari;
        this.zzl = new zzaqs();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzare) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        Integer num = this.zzg;
        return "[ ] " + this.zzc + " " + "0x".concat(valueOf) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzaqn zzd() {
        return this.zzj;
    }

    public final zzare zze(zzaqn zzaqn) {
        this.zzj = zzaqn;
        return this;
    }

    public final zzare zzf(zzarh zzarh) {
        this.zzh = zzarh;
        return this;
    }

    public final zzare zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract zzark zzh(zzara zzara);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        String num = Integer.toString(1);
        return num + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaqm {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzarp.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzarn zzarn) {
        zzari zzari;
        synchronized (this.zze) {
            zzari = this.zzf;
        }
        zzari.zza(zzarn);
    }

    /* access modifiers changed from: protected */
    public abstract void zzo(Object obj);

    /* access modifiers changed from: package-private */
    public final void zzp(String str) {
        zzarh zzarh = this.zzh;
        if (zzarh != null) {
            zzarh.zzb(this);
        }
        if (zzarp.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzarc(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzr() {
        zzard zzard;
        synchronized (this.zze) {
            zzard = this.zzk;
        }
        if (zzard != null) {
            zzard.zza(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzs(zzark zzark) {
        zzard zzard;
        synchronized (this.zze) {
            zzard = this.zzk;
        }
        if (zzard != null) {
            zzard.zzb(this, zzark);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzt(int i) {
        zzarh zzarh = this.zzh;
        if (zzarh != null) {
            zzarh.zzc(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu(zzard zzard) {
        synchronized (this.zze) {
            this.zzk = zzard;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaqm {
        return null;
    }

    public final zzaqs zzy() {
        return this.zzl;
    }
}
