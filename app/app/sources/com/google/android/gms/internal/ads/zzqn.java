package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzqn {
    private final Handler zza;
    private final zzqo zzb;

    public zzqn(Handler handler, zzqo zzqo) {
        this.zza = zzqo == null ? null : handler;
        this.zzb = zzqo;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqh(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqi(this, exc));
        }
    }

    public final void zzc(zzqp zzqp) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqf(this, zzqp));
        }
    }

    public final void zzd(zzqp zzqp) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqg(this, zzqp));
        }
    }

    public final void zze(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzql(this, str, j, j2));
        }
    }

    public final void zzf(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqm(this, str));
        }
    }

    public final void zzg(zzix zzix) {
        zzix.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqc(this, zzix));
        }
    }

    public final void zzh(zzix zzix) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqb(this, zzix));
        }
    }

    public final void zzi(zzan zzan, zziy zziy) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqj(this, zzan, zziy));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Exception exc) {
        int i = zzgd.zza;
        this.zzb.zza(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Exception exc) {
        int i = zzgd.zza;
        this.zzb.zzh(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzqp zzqp) {
        int i = zzgd.zza;
        this.zzb.zzi(zzqp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzqp zzqp) {
        int i = zzgd.zza;
        this.zzb.zzj(zzqp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzgd.zza;
        this.zzb.zzb(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        int i = zzgd.zza;
        this.zzb.zzc(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzix zzix) {
        zzix.zza();
        int i = zzgd.zza;
        this.zzb.zzd(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(zzix zzix) {
        int i = zzgd.zza;
        this.zzb.zze(zzix);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(zzan zzan, zziy zziy) {
        int i = zzgd.zza;
        this.zzb.zzf(zzan, zziy);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(long j) {
        int i = zzgd.zza;
        this.zzb.zzg(j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(boolean z) {
        int i = zzgd.zza;
        this.zzb.zzn(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzgd.zza;
        this.zzb.zzk(i, j, j2);
    }

    public final void zzv(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqd(this, j));
        }
    }

    public final void zzw(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqk(this, z));
        }
    }

    public final void zzx(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqe(this, i, j, j2));
        }
    }
}
