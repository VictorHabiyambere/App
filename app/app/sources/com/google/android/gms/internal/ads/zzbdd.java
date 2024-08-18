package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbdd implements Runnable {
    public final /* synthetic */ zzbdg zza;
    public final /* synthetic */ zzbcx zzb;
    public final /* synthetic */ zzbcy zzc;
    public final /* synthetic */ zzccn zzd;

    public /* synthetic */ zzbdd(zzbdg zzbdg, zzbcx zzbcx, zzbcy zzbcy, zzccn zzccn) {
        this.zza = zzbdg;
        this.zzb = zzbcx;
        this.zzc = zzbcy;
        this.zzd = zzccn;
    }

    public final void run() {
        zzbcv zzbcv;
        zzbdg zzbdg = this.zza;
        zzbcx zzbcx = this.zzb;
        zzccn zzccn = this.zzd;
        try {
            zzbda zzq = zzbcx.zzq();
            boolean zzp = zzbcx.zzp();
            zzbcy zzbcy = this.zzc;
            if (zzp) {
                zzbcv = zzq.zzg(zzbcy);
            } else {
                zzbcv = zzq.zzf(zzbcy);
            }
            if (!zzbcv.zze()) {
                zzccn.zzd(new RuntimeException("No entry contents."));
                zzbdi.zze(zzbdg.zzc);
                return;
            }
            zzbdf zzbdf = new zzbdf(zzbdg, zzbcv.zzc(), 1);
            int read = zzbdf.read();
            if (read != -1) {
                zzbdf.unread(read);
                zzccn.zzc(zzbdk.zzb(zzbdf, zzbcv.zzd(), zzbcv.zzg(), zzbcv.zza(), zzbcv.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzm.zzh("Unable to obtain a cache service instance.", e);
            zzccn.zzd(e);
            zzbdi.zze(zzbdg.zzc);
        }
    }
}
