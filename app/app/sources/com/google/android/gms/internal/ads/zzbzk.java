package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbzk implements RewardItem {
    private final zzbyx zza;

    public zzbzk(zzbyx zzbyx) {
        this.zza = zzbyx;
    }

    public final int getAmount() {
        zzbyx zzbyx = this.zza;
        if (zzbyx == null) {
            return 0;
        }
        try {
            return zzbyx.zze();
        } catch (RemoteException e) {
            zzm.zzk("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzbyx zzbyx = this.zza;
        if (zzbyx == null) {
            return null;
        }
        try {
            return zzbyx.zzf();
        } catch (RemoteException e) {
            zzm.zzk("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
