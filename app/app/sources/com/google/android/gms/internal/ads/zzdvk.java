package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzdvk {
    protected final String zza = ((String) zzbge.zzb.zze());
    protected final Map zzb = new HashMap();
    protected final Context zzc;
    protected final Executor zzd;
    protected final zzr zze;
    protected final boolean zzf;
    private final CsiUrlBuilder zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final AtomicBoolean zzj = new AtomicBoolean();
    private final AtomicReference zzk = new AtomicReference(new Bundle());

    protected zzdvk(Executor executor, zzr zzr, CsiUrlBuilder csiUrlBuilder, Context context) {
        this.zzd = executor;
        this.zze = zzr;
        this.zzf = ((Boolean) zzba.zzc().zza(zzbep.zzbY)).booleanValue();
        this.zzg = csiUrlBuilder;
        this.zzh = ((Boolean) zzba.zzc().zza(zzbep.zzcb)).booleanValue();
        this.zzi = ((Boolean) zzba.zzc().zza(zzbep.zzhk)).booleanValue();
        this.zzc = context;
    }

    private final void zza(Map map, boolean z) {
        if (!map.isEmpty()) {
            if (map == null || map.isEmpty()) {
                zzm.zze("Empty or null paramMap.");
            } else {
                if (!this.zzj.getAndSet(true)) {
                    String str = (String) zzba.zzc().zza(zzbep.zzkz);
                    this.zzk.set(zzad.zza(this.zzc, str, new zzdvj(this, str)));
                }
                Bundle bundle = (Bundle) this.zzk.get();
                for (String str2 : bundle.keySet()) {
                    map.put(str2, String.valueOf(bundle.get(str2)));
                }
            }
            String generateUrl = this.zzg.generateUrl(map);
            zze.zza(generateUrl);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("scar"));
            if (!this.zzf) {
                return;
            }
            if (z && !this.zzh) {
                return;
            }
            if (!parseBoolean || this.zzi) {
                this.zzd.execute(new zzdvi(this, generateUrl));
                return;
            }
            return;
        }
        zzm.zze("Empty paramMap.");
    }

    /* access modifiers changed from: protected */
    public final String zzb(Map map) {
        return this.zzg.generateUrl(map);
    }

    public final ConcurrentHashMap zzc() {
        return new ConcurrentHashMap(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzk.set(zzad.zzb(this.zzc, str));
    }

    public final void zze(Map map) {
        zza(map, true);
    }

    public final void zzf(Map map) {
        zza(map, false);
    }
}
