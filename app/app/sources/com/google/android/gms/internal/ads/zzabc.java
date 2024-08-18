package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzabc implements zzacn, zzdt, zzabv {
    /* access modifiers changed from: private */
    public static final Executor zza = new zzaao();
    private final Context zzb;
    private final zzaba zzc = new zzaba(this, this.zzb);
    private final zzcu zzd;
    private final CopyOnWriteArraySet zze;
    private zzer zzf;
    private zzabq zzg;
    private zzabw zzh;
    private zzan zzi;
    /* access modifiers changed from: private */
    public zzabn zzj;
    private zzfb zzk;
    private zzcv zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private float zzp;

    /* synthetic */ zzabc(zzaar zzaar, zzabb zzabb) {
        this.zzb = zzaar.zza;
        zzcu zzb2 = zzaar.zzc;
        zzeq.zzb(zzb2);
        this.zzd = zzb2;
        this.zze = new CopyOnWriteArraySet();
        this.zzo = 0;
        this.zzp = 1.0f;
        this.zze.add(this.zzc);
    }

    static /* bridge */ /* synthetic */ zzds zzb(zzabc zzabc, zzan zzan, zzer zzer) {
        boolean z = true;
        zzeq.zzf(zzabc.zzo == 0);
        if (zzabc.zzh == null || zzabc.zzg == null) {
            z = false;
        }
        zzeq.zzf(z);
        zzabc.zzf = zzer;
        Looper myLooper = Looper.myLooper();
        zzeq.zzb(myLooper);
        zzabc.zzk = zzer.zzb(myLooper, (Handler.Callback) null);
        zzt zzu = zzu(zzan.zzz);
        if (zzu.zzf == 7 && zzgd.zza < 34) {
            zzr zzc2 = zzu.zzc();
            zzc2.zzd(6);
            zzu = zzc2.zzg();
        }
        zzt zzt = zzu;
        try {
            zzcu zzcu = zzabc.zzd;
            Context context = zzabc.zzb;
            zzw zzw = zzw.zza;
            zzfb zzfb = zzabc.zzk;
            Objects.requireNonNull(zzfb);
            zzabc.zzl = zzcu.zza(context, zzt, zzw, zzabc, new zzaap(zzfb), zzgbc.zzm(), 0);
            Pair pair = zzabc.zzm;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                zzfv zzfv = (zzfv) zzabc.zzm.second;
                zzfv.zzb();
                zzfv.zza();
            }
            throw null;
        } catch (zzdq e) {
            throw new zzacl(e, zzan);
        }
    }

    public static /* synthetic */ void zzf(zzabc zzabc) {
        int i = zzabc.zzn - 1;
        zzabc.zzn = i;
        if (i <= 0) {
            if (i >= 0) {
                zzabw zzabw = zzabc.zzh;
                zzeq.zzb(zzabw);
                zzabw.zza();
                return;
            }
            throw new IllegalStateException(String.valueOf(i));
        }
    }

    static /* bridge */ /* synthetic */ void zzg(zzabc zzabc) {
        if (zzabc.zzv()) {
            zzabc.zzn++;
            zzabw zzabw = zzabc.zzh;
            zzeq.zzb(zzabw);
            zzabw.zza();
            zzfb zzfb = zzabc.zzk;
            zzeq.zzb(zzfb);
            zzfb.zzh(new zzaaq(zzabc));
        }
    }

    static /* bridge */ /* synthetic */ void zzh(zzabc zzabc, long j, long j2) {
        zzabw zzabw = zzabc.zzh;
        zzeq.zzb(zzabw);
        zzabw.zzb(j, j2);
    }

    static /* bridge */ /* synthetic */ void zzi(zzabc zzabc, float f) {
        zzabc.zzp = f;
        zzabw zzabw = zzabc.zzh;
        if (zzabw != null) {
            zzabw.zzd(f);
        }
    }

    static /* bridge */ /* synthetic */ boolean zzt(zzabc zzabc, long j) {
        if (zzabc.zzn != 0) {
            return false;
        }
        zzabw zzabw = zzabc.zzh;
        zzeq.zzb(zzabw);
        return zzabw.zze(j);
    }

    /* access modifiers changed from: private */
    public static zzt zzu(zzt zzt) {
        return (zzt == null || !zzt.zzf()) ? zzt.zza : zzt;
    }

    private final boolean zzv() {
        return this.zzo == 1;
    }

    public final zzabq zzc() {
        return this.zzg;
    }

    public final zzacm zzd() {
        return this.zzc;
    }

    public final void zzk() {
        zzfv.zza.zzb();
        zzfv.zza.zza();
        this.zzm = null;
    }

    public final void zzl() {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            ((zzaas) it.next()).zzb(this);
        }
        zzeq.zzb((Object) null);
        throw null;
    }

    public final void zzm(zzdv zzdv) {
        zzal zzal = new zzal();
        zzal.zzac(zzdv.zzc);
        zzal.zzI(zzdv.zzd);
        zzal.zzX("video/raw");
        this.zzi = zzal.zzad();
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            ((zzaas) it.next()).zzc(this, zzdv);
        }
    }

    public final void zzn() {
        if (this.zzo != 2) {
            zzfb zzfb = this.zzk;
            if (zzfb != null) {
                zzfb.zze((Object) null);
            }
            this.zzm = null;
            this.zzo = 2;
        }
    }

    public final void zzo(long j, long j2) throws zzjh {
        if (this.zzn == 0) {
            zzabw zzabw = this.zzh;
            zzeq.zzb(zzabw);
            zzabw.zzc(j, j2);
        }
    }

    public final void zzp(long j, long j2, long j3, boolean z) {
        zzan zzan;
        if (z && this.zzm != null) {
            Iterator it = this.zze.iterator();
            while (it.hasNext()) {
                ((zzaas) it.next()).zza(this);
            }
        }
        if (this.zzj != null) {
            zzan zzan2 = this.zzi;
            if (zzan2 == null) {
                zzan = new zzal().zzad();
            } else {
                zzan = zzan2;
            }
            zzeq.zzb(this.zzf);
            this.zzj.zza(j2 - j3, System.nanoTime(), zzan, (MediaFormat) null);
        }
        zzeq.zzb((Object) null);
        throw null;
    }

    public final void zzq(Surface surface, zzfv zzfv) {
        Pair pair = this.zzm;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((zzfv) this.zzm.second).equals(zzfv)) {
            this.zzm = Pair.create(surface, zzfv);
            zzfv.zzb();
            zzfv.zza();
        }
    }

    public final void zzr(List list) {
        this.zzc.zzk(list);
    }

    public final void zzs(zzabq zzabq) {
        zzeq.zzf(!zzv());
        this.zzg = zzabq;
        this.zzh = new zzabw(this, zzabq);
        this.zzh.zzd(this.zzp);
    }
}
