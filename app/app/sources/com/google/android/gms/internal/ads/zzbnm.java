package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbnm implements zzaqx {
    /* access modifiers changed from: private */
    public volatile zzbmz zza;
    private final Context zzb;

    public zzbnm(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbnm zzbnm) {
        if (zzbnm.zza != null) {
            zzbnm.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzara zza(zzare zzare) throws zzarn {
        Parcelable.Creator<zzbna> creator = zzbna.CREATOR;
        Map zzl = zzare.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbna zzbna = new zzbna(zzare.zzk(), strArr, strArr2);
        long elapsedRealtime = zzu.zzB().elapsedRealtime();
        try {
            zzccn zzccn = new zzccn();
            this.zza = new zzbmz(this.zzb, zzu.zzt().zzb(), new zzbnk(this, zzccn), new zzbnl(this, zzccn));
            this.zza.checkAvailabilityAndConnect();
            ListenableFuture zzo = zzgft.zzo(zzgft.zzn(zzccn, new zzbni(this, zzbna), zzcci.zza), (long) ((Integer) zzba.zzc().zza(zzbep.zzey)).intValue(), TimeUnit.MILLISECONDS, zzcci.zzd);
            zzo.addListener(new zzbnj(this), zzcci.zza);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            zzbnc zzbnc = (zzbnc) new zzbxs(parcelFileDescriptor).zza(zzbnc.CREATOR);
            if (zzbnc == null) {
                return null;
            }
            if (!zzbnc.zza) {
                if (zzbnc.zze.length != zzbnc.zzf.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbnc.zze;
                    if (i >= strArr3.length) {
                        return new zzara(zzbnc.zzc, zzbnc.zzd, (Map) hashMap, zzbnc.zzg, zzbnc.zzh);
                    }
                    hashMap.put(strArr3[i], zzbnc.zzf[i]);
                    i++;
                }
            } else {
                throw new zzarn(zzbnc.zzb);
            }
        } catch (InterruptedException | ExecutionException e) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
