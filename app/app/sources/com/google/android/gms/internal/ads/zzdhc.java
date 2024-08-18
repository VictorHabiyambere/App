package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdhc extends zzdez implements zzban {
    private final Map zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzfgt zzd;

    public zzdhc(Context context, Set set, zzfgt zzfgt) {
        super(set);
        this.zzc = context;
        this.zzd = zzfgt;
    }

    public final synchronized void zza(View view) {
        zzbao zzbao = (zzbao) this.zzb.get(view);
        if (zzbao == null) {
            zzbao zzbao2 = new zzbao(this.zzc, view);
            zzbao2.zzc(this);
            this.zzb.put(view, zzbao2);
            zzbao = zzbao2;
        }
        if (this.zzd.zzY) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzbp)).booleanValue()) {
                zzbao.zzg(((Long) zzba.zzc().zza(zzbep.zzbo)).longValue());
                return;
            }
        }
        zzbao.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            ((zzbao) this.zzb.get(view)).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzdp(zzbam zzbam) {
        zzq(new zzdhb(zzbam));
    }
}
