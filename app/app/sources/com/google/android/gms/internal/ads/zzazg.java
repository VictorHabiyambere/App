package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazg extends zzazs {
    public zzazg(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2) {
        super(zzaye, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzatp, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxk zzaxk = new zzaxk((String) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(((Boolean) zzba.zzc().zza(zzbep.zzcI)).booleanValue())}));
        synchronized (this.zze) {
            this.zze.zzk(zzaxk.zza);
            this.zze.zzH(zzaxk.zzb);
        }
    }
}
