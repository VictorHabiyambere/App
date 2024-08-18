package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcqp implements zzczl, zzdaz, zzdaf, zza, zzdab, zzdgz {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzfhf zze;
    /* access modifiers changed from: private */
    public final zzfgt zzf;
    /* access modifiers changed from: private */
    public final zzfoa zzg;
    /* access modifiers changed from: private */
    public final zzfia zzh;
    private final zzaxd zzi;
    private final zzbfs zzj;
    private final zzfmn zzk;
    private final WeakReference zzl;
    private final WeakReference zzm;
    private final zzcyn zzn;
    private boolean zzo;
    private final AtomicBoolean zzp = new AtomicBoolean();
    private final zzbfu zzq;

    zzcqp(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfhf zzfhf, zzfgt zzfgt, zzfoa zzfoa, zzfia zzfia, View view, zzchd zzchd, zzaxd zzaxd, zzbfs zzbfs, zzbfu zzbfu, zzfmn zzfmn, zzcyn zzcyn) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfhf;
        this.zzf = zzfgt;
        this.zzg = zzfoa;
        this.zzh = zzfia;
        this.zzi = zzaxd;
        View view2 = view;
        this.zzl = new WeakReference(view);
        zzchd zzchd2 = zzchd;
        this.zzm = new WeakReference(zzchd);
        this.zzj = zzbfs;
        this.zzq = zzbfu;
        this.zzk = zzfmn;
        this.zzn = zzcyn;
    }

    /* access modifiers changed from: private */
    public final List zzu() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzls)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(this.zza)) {
                zzu.zzp();
                Integer zzs = zzt.zzs(this.zza);
                if (zzs != null) {
                    Integer valueOf = Integer.valueOf(Math.min(zzs.intValue(), 20));
                    ArrayList arrayList = new ArrayList();
                    for (String parse : this.zzf.zzd) {
                        arrayList.add(Uri.parse(parse).buildUpon().appendQueryParameter("dspct", Integer.toString(valueOf.intValue())).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        String str;
        int i;
        List list = this.zzf.zzd;
        if (list != null && !list.isEmpty()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzdx)).booleanValue()) {
                str = this.zzi.zzc().zzh(this.zza, (View) this.zzl.get(), (Activity) null);
            } else {
                str = null;
            }
            if ((!((Boolean) zzba.zzc().zza(zzbep.zzao)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbgj.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbgj.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
                    zzchd zzchd = (zzchd) this.zzm.get();
                }
                zzgft.zzr((zzgfk) zzgft.zzo(zzgfk.zzu(zzgft.zzh((Object) null)), ((Long) zzba.zzc().zza(zzbep.zzaW)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcqo(this, str), this.zzb);
                return;
            }
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, false, str, (String) null, zzu()));
        }
    }

    private final void zzw(int i, int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzl.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzv();
        } else {
            this.zzd.schedule(new zzcqm(this, i, i2), (long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzba.zzc().zza(zzbep.zzao)).booleanValue() || !this.zze.zzb.zzb.zzg) && ((Boolean) zzbgj.zzd.zze()).booleanValue()) {
            zzgft.zzr(zzgft.zze(zzgfk.zzu(this.zzj.zza()), Throwable.class, new zzcqj(), zzcci.zzf), new zzcqn(this), this.zzb);
            return;
        }
        zzfia zzfia = this.zzh;
        zzfoa zzfoa = this.zzg;
        zzfhf zzfhf = this.zze;
        zzfgt zzfgt = this.zzf;
        Context context = this.zza;
        List zzc2 = zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzc);
        int i = 1;
        if (true == zzu.zzo().zzA(context)) {
            i = 2;
        }
        zzfia.zzc(zzc2, i);
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzds(zzbyh zzbyh, String str, String str2) {
        zzfoa zzfoa = this.zzg;
        zzfgt zzfgt = this.zzf;
        this.zzh.zza(zzfoa.zze(zzfgt, zzfgt.zzi, zzbyh));
    }

    public final void zze() {
        zzfoa zzfoa = this.zzg;
        zzfhf zzfhf = this.zze;
        zzfgt zzfgt = this.zzf;
        this.zzh.zza(zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzj));
    }

    public final void zzf() {
        zzfoa zzfoa = this.zzg;
        zzfhf zzfhf = this.zze;
        zzfgt zzfgt = this.zzf;
        this.zzh.zza(zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzh));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzb.execute(new zzcql(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(int i, int i2) {
        zzw(i - 1, i2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i, int i2) {
        this.zzb.execute(new zzcqk(this, i, i2));
    }

    public final void zzq(zze zze2) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzbw)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzfoa.zzf(2, zze2.zza, this.zzf.zzp)));
        }
    }

    public final void zzr() {
        if (this.zzp.compareAndSet(false, true)) {
            int intValue = ((Integer) zzba.zzc().zza(zzbep.zzdG)).intValue();
            if (intValue > 0) {
                zzw(intValue, ((Integer) zzba.zzc().zza(zzbep.zzdH)).intValue());
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzdF)).booleanValue()) {
                this.zzc.execute(new zzcqi(this));
            } else {
                zzv();
            }
        }
    }

    public final synchronized void zzs() {
        zzcyn zzcyn;
        if (this.zzo) {
            ArrayList arrayList = new ArrayList(zzu());
            arrayList.addAll(this.zzf.zzg);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzfia zzfia = this.zzh;
            zzfoa zzfoa = this.zzg;
            zzfhf zzfhf = this.zze;
            zzfgt zzfgt = this.zzf;
            zzfia.zza(zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzn));
            if (((Boolean) zzba.zzc().zza(zzbep.zzdC)).booleanValue() && (zzcyn = this.zzn) != null) {
                List zzh2 = zzfoa.zzh(zzfoa.zzg(zzcyn.zzb().zzn, zzcyn.zza().zzg()), this.zzn.zza().zza());
                zzfia zzfia2 = this.zzh;
                zzfoa zzfoa2 = this.zzg;
                zzcyn zzcyn2 = this.zzn;
                zzfia2.zza(zzfoa2.zzc(zzcyn2.zzc(), zzcyn2.zzb(), zzh2));
            }
            zzfia zzfia3 = this.zzh;
            zzfoa zzfoa3 = this.zzg;
            zzfhf zzfhf2 = this.zze;
            zzfgt zzfgt2 = this.zzf;
            zzfia3.zza(zzfoa3.zzc(zzfhf2, zzfgt2, zzfgt2.zzg));
        }
        this.zzo = true;
    }

    public final void zzt() {
        zzfoa zzfoa = this.zzg;
        zzfhf zzfhf = this.zze;
        zzfgt zzfgt = this.zzf;
        this.zzh.zza(zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzav));
    }
}
