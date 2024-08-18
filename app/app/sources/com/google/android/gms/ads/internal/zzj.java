package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxc;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzfre;
import com.google.android.gms.internal.ads.zzfsk;
import com.google.android.gms.internal.ads.zzfte;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzj implements Runnable, zzawz {
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfre zzi;
    private Context zzj;
    private final Context zzk;
    private VersionInfoParcel zzl;
    private final VersionInfoParcel zzm;
    private final boolean zzn;
    private int zzo;

    public zzj(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = versionInfoParcel;
        this.zzm = versionInfoParcel;
        this.zzh = Executors.newCachedThreadPool();
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbep.zzcr)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfre.zza(context, this.zzh, booleanValue);
        this.zzf = ((Boolean) zzba.zzc().zza(zzbep.zzcn)).booleanValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbep.zzcs)).booleanValue();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcq)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdu)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzdn)).booleanValue()) {
            zzcci.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (zzf.zzv()) {
            zzcci.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzawz zzm() {
        if (zzi() == 2) {
            return (zzawz) this.zze.get();
        }
        return (zzawz) this.zzd.get();
    }

    private final void zzp() {
        List list = this.zzc;
        zzawz zzm2 = zzm();
        if (!list.isEmpty() && zzm2 != null) {
            for (Object[] objArr : this.zzc) {
                int length = objArr.length;
                if (length == 1) {
                    zzm2.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzm2.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzq(boolean z) {
        this.zzd.set(zzaxc.zzu(this.zzl.afmaVersion, zzr(this.zzj), z, this.zzo));
    }

    private static final Context zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            if (((Boolean) zzba.zzc().zza(zzbep.zzdu)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z2 = this.zzl.isClientJar;
            z = false;
            if (!((Boolean) zzba.zzc().zza(zzbep.zzaX)).booleanValue() && z2) {
                z = true;
            }
            if (zzi() == 1) {
                zzq(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzh(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzaww zza2 = zzaww.zza(this.zzl.afmaVersion, zzr(this.zzj), z, this.zzn);
                this.zze.set(zza2);
                if (this.zzg && !zza2.zzr()) {
                    this.zzo = 1;
                    zzq(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzq(z);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzaww.zza(this.zzm.afmaVersion, zzr(this.zzk), z, this.zzn).zzp();
        } catch (NullPointerException e) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        Context context = this.zzj;
        zzi zzi2 = new zzi(this);
        zzfre zzfre = this.zzi;
        return new zzfte(this.zzj, zzfsk.zzb(context, zzfre), zzi2, ((Boolean) zzba.zzc().zza(zzbep.zzco)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            zzm.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzawz zzm2 = zzm();
        if (((Boolean) zzba.zzc().zza(zzbep.zzkH)).booleanValue()) {
            zzu.zzp();
            zzt.zzJ(view, 4, (MotionEvent) null);
        }
        if (zzm2 == null) {
            return "";
        }
        zzp();
        return zzm2.zzf(zzr(context), str, view, activity);
    }

    public final String zzg(Context context) {
        zzawz zzm2;
        if (!zzd() || (zzm2 = zzm()) == null) {
            return "";
        }
        zzp();
        return zzm2.zzg(zzr(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzkG)).booleanValue()) {
            zzawz zzm2 = zzm();
            if (((Boolean) zzba.zzc().zza(zzbep.zzkH)).booleanValue()) {
                zzu.zzp();
                zzt.zzJ(view, 2, (MotionEvent) null);
            }
            if (zzm2 != null) {
                return zzm2.zzh(context, view, activity);
            }
            return "";
        } else if (!zzd()) {
            return "";
        } else {
            zzawz zzm3 = zzm();
            if (((Boolean) zzba.zzc().zza(zzbep.zzkH)).booleanValue()) {
                zzu.zzp();
                zzt.zzJ(view, 2, (MotionEvent) null);
            }
            return zzm3 != null ? zzm3.zzh(context, view, activity) : "";
        }
    }

    /* access modifiers changed from: protected */
    public final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final int zzj() {
        return this.zzo;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzawz zzm2 = zzm();
        if (zzm2 != null) {
            zzp();
            zzm2.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i, int i2, int i3) {
        zzawz zzm2 = zzm();
        if (zzm2 != null) {
            zzp();
            zzm2.zzl(i, i2, i3);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawz zzm2;
        if (zzd() && (zzm2 = zzm()) != null) {
            zzm2.zzn(stackTraceElementArr);
        }
    }

    public final void zzo(View view) {
        zzawz zzm2 = zzm();
        if (zzm2 != null) {
            zzm2.zzo(view);
        }
    }
}
