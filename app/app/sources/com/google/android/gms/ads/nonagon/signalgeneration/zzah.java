package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzgfp;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzah implements zzgfp {
    final /* synthetic */ zzbvv zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaj zzc;

    zzah(zzaj zzaj, zzbvv zzbvv, boolean z) {
        this.zza = zzbvv;
        this.zzb = z;
        this.zzc = zzaj;
    }

    public final void zza(Throwable th) {
        try {
            zzbvv zzbvv = this.zza;
            String message = th.getMessage();
            zzbvv.zze("Internal error: " + message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        List<Uri> list = (List) obj;
        try {
            zzaj.zzH(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzs || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzO(uri)) {
                        zzaj zzaj = this.zzc;
                        this.zzc.zzq.zzc(zzaj.zzZ(uri, zzaj.zzA, "1").toString(), (zzfmn) null);
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbep.zzhG)).booleanValue()) {
                            this.zzc.zzq.zzc(uri.toString(), (zzfmn) null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
