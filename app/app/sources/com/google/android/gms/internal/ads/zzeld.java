package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzeld implements zzgfp {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfgw zzb;
    final /* synthetic */ zzfgt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfoa zze;
    final /* synthetic */ zzfhf zzf;
    final /* synthetic */ zzelf zzg;

    zzeld(zzelf zzelf, long j, zzfgw zzfgw, zzfgt zzfgt, String str, zzfoa zzfoa, zzfhf zzfhf) {
        this.zza = j;
        this.zzb = zzfgw;
        this.zzc = zzfgt;
        this.zzd = str;
        this.zze = zzfoa;
        this.zzf = zzfhf;
        this.zzg = zzelf;
    }

    public final void zza(Throwable th) {
        Integer num;
        int i;
        zze zze2;
        zze zzb2;
        Throwable th2 = th;
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        if (th2 instanceof TimeoutException) {
            i = 2;
            num = null;
        } else if (th2 instanceof zzekn) {
            i = 3;
            num = null;
        } else {
            if (th2 instanceof CancellationException) {
                i = 4;
            } else if (th2 instanceof zzfhv) {
                i = 5;
            } else {
                int i2 = 6;
                if (th2 instanceof zzdzd) {
                    if (zzfiq.zza(th).zza == 3) {
                        i2 = 1;
                    }
                    if (((Boolean) zzba.zzc().zza(zzbep.zzbD)).booleanValue() && (th2 instanceof zzehp) && (zzb2 = ((zzehp) th2).zzb()) != null) {
                        num = Integer.valueOf(zzb2.zza);
                        i = i2;
                    }
                }
                num = null;
                i = i2;
            }
            num = null;
        }
        synchronized (this.zzg) {
            zzelf zzelf = this.zzg;
            if (zzelf.zze) {
                zzelf.zzb.zza(this.zzb, this.zzc, i, th2 instanceof zzehp ? (zzehp) th2 : null, elapsedRealtime);
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zziu)).booleanValue()) {
                zzfoe zzd2 = this.zzg.zzc;
                zzfoa zzfoa = this.zze;
                zzfhf zzfhf = this.zzf;
                zzfgt zzfgt = this.zzc;
                zzd2.zzd(zzfoa.zzc(zzfhf, zzfgt, zzfgt.zzo));
            }
            zzelf zzelf2 = this.zzg;
            if (!zzelf2.zzg) {
                LinkedHashMap zzh = zzelf2.zzd;
                zzfgt zzfgt2 = this.zzc;
                int i3 = i;
                zzele zzele = r6;
                zzele zzele2 = new zzele(this.zzd, zzfgt2.zzag, i3, elapsedRealtime, num);
                zzh.put(zzfgt2, zzele);
                zze zza2 = zzfiq.zza(th);
                int i4 = zza2.zza;
                if ((i4 == 3 || i4 == 0) && (zze2 = zza2.zzd) != null && !zze2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                    zza2 = zzfiq.zza(new zzehp(13, zza2.zzd));
                }
                this.zzg.zzf.zzf(this.zzc, elapsedRealtime, zza2);
            }
        }
    }

    public final void zzb(Object obj) {
        long elapsedRealtime = this.zzg.zza.elapsedRealtime() - this.zza;
        synchronized (this.zzg) {
            zzelf zzelf = this.zzg;
            if (zzelf.zze) {
                zzelf.zzb.zza(this.zzb, this.zzc, 0, (zzehp) null, elapsedRealtime);
            }
            zzelf zzelf2 = this.zzg;
            if (!zzelf2.zzg) {
                if (zzelf2.zzq(this.zzc)) {
                    ((zzele) this.zzg.zzd.get(this.zzc)).zzd = elapsedRealtime;
                } else {
                    LinkedHashMap zzh = this.zzg.zzd;
                    zzfgt zzfgt = this.zzc;
                    zzh.put(zzfgt, new zzele(this.zzd, zzfgt.zzag, 0, elapsedRealtime, (Integer) null));
                }
                this.zzg.zzf.zzg(this.zzc, elapsedRealtime, (zze) null);
            }
        }
    }
}
