package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzach {
    private final Handler zza;
    private final zzaci zzb;

    public zzach(Handler handler, zzaci zzaci) {
        this.zza = zzaci == null ? null : handler;
        this.zzb = zzaci;
    }

    public final void zza(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabx(this, str, j, j2));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzacg(this, str));
        }
    }

    public final void zzc(zzix zzix) {
        zzix.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzacf(this, zzix));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabz(this, i, j));
        }
    }

    public final void zze(zzix zzix) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzacd(this, zzix));
        }
    }

    public final void zzf(zzan zzan, zziy zziy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzace(this, zzan, zziy));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzgd.zza;
        this.zzb.zzp(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        int i = zzgd.zza;
        this.zzb.zzq(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzix zzix) {
        zzix.zza();
        int i = zzgd.zza;
        this.zzb.zzr(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzgd.zza;
        this.zzb.zzl(i, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzix zzix) {
        int i = zzgd.zza;
        this.zzb.zzs(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzan zzan, zziy zziy) {
        int i = zzgd.zza;
        this.zzb.zzu(zzan, zziy);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzgd.zza;
        this.zzb.zzm(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzgd.zza;
        this.zzb.zzt(j, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        int i = zzgd.zza;
        this.zzb.zzo(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzdv zzdv) {
        int i = zzgd.zza;
        this.zzb.zzv(zzdv);
    }

    public final void zzq(Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaca(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzacb(this, j, i));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzacc(this, exc));
        }
    }

    public final void zzt(zzdv zzdv) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaby(this, zzdv));
        }
    }
}
