package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzuw extends zzuo {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzie zzc;

    protected zzuw() {
    }

    /* access modifiers changed from: protected */
    public abstract void zzA(Object obj, zzvq zzvq, zzdc zzdc);

    /* access modifiers changed from: protected */
    public final void zzB(Object obj, zzvq zzvq) {
        zzeq.zzd(!this.zza.containsKey(obj));
        zzut zzut = new zzut(this, obj);
        zzuu zzuu = new zzuu(this, obj);
        this.zza.put(obj, new zzuv(zzvq, zzut, zzuu));
        Handler handler = this.zzb;
        if (handler != null) {
            zzvq.zzh(handler, zzuu);
            Handler handler2 = this.zzb;
            if (handler2 != null) {
                zzvq.zzg(handler2, zzuu);
                zzvq.zzm(zzut, this.zzc, zzb());
                if (!zzu()) {
                    zzvq.zzi(zzut);
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzj() {
        for (zzuv zzuv : this.zza.values()) {
            zzuv.zza.zzi(zzuv.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzl() {
        for (zzuv zzuv : this.zza.values()) {
            zzuv.zza.zzk(zzuv.zzb);
        }
    }

    /* access modifiers changed from: protected */
    public void zzn(zzie zzie) {
        this.zzc = zzie;
        this.zzb = zzgd.zzx((Handler.Callback) null);
    }

    /* access modifiers changed from: protected */
    public void zzq() {
        for (zzuv zzuv : this.zza.values()) {
            zzuv.zza.zzp(zzuv.zzb);
            zzuv.zza.zzs(zzuv.zzc);
            zzuv.zza.zzr(zzuv.zzc);
        }
        this.zza.clear();
    }

    /* access modifiers changed from: protected */
    public int zzw(Object obj, int i) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public long zzx(Object obj, long j, zzvo zzvo) {
        return j;
    }

    /* access modifiers changed from: protected */
    public zzvo zzy(Object obj, zzvo zzvo) {
        throw null;
    }

    public void zzz() throws IOException {
        for (zzuv zzuv : this.zza.values()) {
            zzuv.zza.zzz();
        }
    }
}
