package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcif extends zzdp {
    private final zzcee zza;
    private final Object zzb = new Object();
    private final boolean zzc;
    private final boolean zzd;
    private int zze;
    private zzdt zzf;
    private boolean zzg;
    private boolean zzh = true;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbjd zzn;

    public zzcif(zzcee zzcee, float f, boolean z, boolean z2) {
        this.zza = zzcee;
        this.zzi = f;
        this.zzc = z;
        this.zzd = z2;
    }

    private final void zzw(int i, int i2, boolean z, boolean z2) {
        zzcci.zze.execute(new zzcie(this, i, i2, z, z2));
    }

    private final void zzx(String str, Map map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzcci.zze.execute(new zzcid(this, hashMap));
    }

    public final void zzc(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.zzb) {
            z2 = true;
            if (f2 == this.zzi) {
                if (f3 == this.zzk) {
                    z2 = false;
                }
            }
            this.zzi = f2;
            this.zzj = f;
            z3 = this.zzh;
            this.zzh = z;
            i2 = this.zze;
            this.zze = i;
            float f4 = this.zzk;
            this.zzk = f3;
            if (Math.abs(f3 - f4) > 1.0E-4f) {
                this.zza.zzF().invalidate();
            }
        }
        if (z2) {
            try {
                zzbjd zzbjd = this.zzn;
                if (zzbjd != null) {
                    zzbjd.zze();
                }
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        zzw(i2, i, z3, z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        int i3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        zzdt zzdt;
        zzdt zzdt2;
        zzdt zzdt3;
        synchronized (this.zzb) {
            boolean z8 = this.zzg;
            boolean z9 = false;
            if (z8 || i2 != 1) {
                i3 = i2;
                z3 = false;
            } else {
                i2 = 1;
                i3 = 1;
                z3 = true;
            }
            if (i != i2) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4 || i3 != 1) {
                z5 = false;
            } else {
                z5 = true;
                i3 = 1;
            }
            if (!z4 || i3 != 2) {
                z6 = false;
            } else {
                z6 = true;
            }
            if (!z4 || i3 != 3) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (z8) {
                z9 = true;
            } else if (z3) {
                z9 = true;
            }
            this.zzg = z9;
            if (z3) {
                try {
                    zzdt zzdt4 = this.zzf;
                    if (zzdt4 != null) {
                        zzdt4.zzi();
                    }
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
            if (z5 && (zzdt3 = this.zzf) != null) {
                zzdt3.zzh();
            }
            if (z6 && (zzdt2 = this.zzf) != null) {
                zzdt2.zzg();
            }
            if (z7) {
                zzdt zzdt5 = this.zzf;
                if (zzdt5 != null) {
                    zzdt5.zze();
                }
                this.zza.zzw();
            }
            if (!(z == z2 || (zzdt = this.zzf) == null)) {
                zzdt.zzf(z2);
            }
        }
    }

    public final float zze() {
        float f;
        synchronized (this.zzb) {
            f = this.zzk;
        }
        return f;
    }

    public final float zzf() {
        float f;
        synchronized (this.zzb) {
            f = this.zzj;
        }
        return f;
    }

    public final float zzg() {
        float f;
        synchronized (this.zzb) {
            f = this.zzi;
        }
        return f;
    }

    public final int zzh() {
        int i;
        synchronized (this.zzb) {
            i = this.zze;
        }
        return i;
    }

    public final zzdt zzi() throws RemoteException {
        zzdt zzdt;
        synchronized (this.zzb) {
            zzdt = this.zzf;
        }
        return zzdt;
    }

    public final void zzj(boolean z) {
        zzx(true != z ? "unmute" : "mute", (Map) null);
    }

    public final void zzk() {
        zzx("pause", (Map) null);
    }

    public final void zzl() {
        zzx("play", (Map) null);
    }

    public final void zzm(zzdt zzdt) {
        synchronized (this.zzb) {
            this.zzf = zzdt;
        }
    }

    public final void zzn() {
        zzx("stop", (Map) null);
    }

    public final boolean zzo() {
        boolean z;
        Object obj = this.zzb;
        boolean zzp = zzp();
        synchronized (obj) {
            z = false;
            if (!zzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return z;
    }

    public final boolean zzp() {
        boolean z;
        synchronized (this.zzb) {
            z = false;
            if (this.zzc && this.zzl) {
                z = true;
            }
        }
        return z;
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzh;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(zzfk zzfk) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4 = this.zzb;
        boolean z = zzfk.zza;
        boolean z2 = zzfk.zzb;
        boolean z3 = zzfk.zzc;
        synchronized (obj4) {
            this.zzl = z2;
            this.zzm = z3;
        }
        if (true != z) {
            obj = "0";
        } else {
            obj = "1";
        }
        if (true != z2) {
            obj2 = "0";
        } else {
            obj2 = "1";
        }
        if (true != z3) {
            obj3 = "0";
        } else {
            obj3 = "1";
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", obj, "customControlsRequested", obj2, "clickToExpandRequested", obj3));
    }

    public final void zzt(float f) {
        synchronized (this.zzb) {
            this.zzj = f;
        }
    }

    public final void zzu() {
        boolean z;
        int i;
        synchronized (this.zzb) {
            z = this.zzh;
            i = this.zze;
            this.zze = 3;
        }
        zzw(i, 3, z, z);
    }

    public final void zzv(zzbjd zzbjd) {
        synchronized (this.zzb) {
            this.zzn = zzbjd;
        }
    }
}
