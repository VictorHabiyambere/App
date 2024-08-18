package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzenu {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdst zzb;

    public zzenu(zzdst zzdst) {
        this.zzb = zzdst;
    }

    @CheckForNull
    public final zzbte zza(String str) {
        if (this.zza.containsKey(str)) {
            return (zzbte) this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e) {
            zze.zzb("Couldn't create RTB adapter : ", e);
        }
    }
}
