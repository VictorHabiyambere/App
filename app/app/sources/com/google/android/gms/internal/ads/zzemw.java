package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzemw implements zzdau {
    boolean zza = false;
    final /* synthetic */ zzeho zzb;
    final /* synthetic */ zzccn zzc;
    final /* synthetic */ zzemx zzd;

    zzemw(zzemx zzemx, zzeho zzeho, zzccn zzccn) {
        this.zzb = zzeho;
        this.zzc = zzccn;
        this.zzd = zzemx;
    }

    private final synchronized void zze(zze zze) {
        int i = 1;
        if (true == ((Boolean) zzba.zzc().zza(zzbep.zzfA)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzehp(i, zze));
    }

    public final synchronized void zza(int i) {
        if (!this.zza) {
            this.zza = true;
            zze(new zze(i, zzemx.zze(this.zzb.zza, i), AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
        }
    }

    public final synchronized void zzb(zze zze) {
        if (!this.zza) {
            this.zza = true;
            zze(zze);
        }
    }

    public final synchronized void zzc(int i, String str) {
        if (!this.zza) {
            this.zza = true;
            if (str == null) {
                str = zzemx.zze(this.zzb.zza, i);
            }
            zze(new zze(i, str, AdError.UNDEFINED_DOMAIN, (zze) null, (IBinder) null));
        }
    }

    public final synchronized void zzd() {
        this.zzc.zzc((Object) null);
    }
}
