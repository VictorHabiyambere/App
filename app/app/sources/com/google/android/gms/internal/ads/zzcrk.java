package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcrk implements zzban {
    private zzchd zza;
    private final Executor zzb;
    private final zzcqw zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcqz zzg = new zzcqz();

    public zzcrk(Executor executor, zzcqw zzcqw, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcqw;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcrj(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zzdp(zzbam zzbam) {
        boolean z;
        if (this.zzf) {
            z = false;
        } else {
            z = zzbam.zzj;
        }
        zzcqz zzcqz = this.zzg;
        zzcqz.zza = z;
        zzcqz.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzbam;
        if (this.zze) {
            zzg();
        }
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzchd zzchd) {
        this.zza = zzchd;
    }
}
