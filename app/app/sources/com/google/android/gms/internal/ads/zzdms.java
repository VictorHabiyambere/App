package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzdms implements zzbhj {
    final /* synthetic */ zzdnp zza;
    final /* synthetic */ ViewGroup zzb;

    zzdms(zzdnp zzdnp, ViewGroup viewGroup) {
        this.zza = zzdnp;
        this.zzb = viewGroup;
    }

    public final JSONObject zza() {
        return this.zza.zzo();
    }

    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    public final void zzc() {
        zzgbc zzgbc = zzdmp.zza;
        Map zzm = this.zza.zzm();
        if (zzm != null) {
            int size = zzgbc.size();
            int i = 0;
            while (i < size) {
                Object obj = zzm.get((String) zzgbc.get(i));
                i++;
                if (obj != null) {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }
}
