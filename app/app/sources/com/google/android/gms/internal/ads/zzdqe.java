package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqe implements zzblp {
    private final zzbiz zza;
    private final zzdqs zzb;
    private final zzhkj zzc;

    public zzdqe(zzdme zzdme, zzdlt zzdlt, zzdqs zzdqs, zzhkj zzhkj) {
        this.zza = zzdme.zzc(zzdlt.zzA());
        this.zzb = zzdqs;
        this.zzc = zzhkj;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbip) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zzm.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzl("/nativeAdCustomClick", this);
        }
    }
}
