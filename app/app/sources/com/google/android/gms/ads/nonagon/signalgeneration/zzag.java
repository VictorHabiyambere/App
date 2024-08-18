package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzgfp;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzag implements zzgfp {
    final /* synthetic */ zzbvv zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaj zzc;

    zzag(zzaj zzaj, zzbvv zzbvv, boolean z) {
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
        ArrayList arrayList = (ArrayList) obj;
        try {
            this.zza.zzf(arrayList);
            if (this.zzc.zzr || this.zzb) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Uri uri = (Uri) it.next();
                    if (this.zzc.zzP(uri)) {
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
