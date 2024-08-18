package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.android.gms.ads.internal.util.zzbh;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcef {
    private static final boolean zza = (zzay.zze().nextInt(100) < ((Integer) zzba.zzc().zza(zzbep.zzmF)).intValue());
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbfb zze;
    private final zzbfe zzf;
    private final zzbh zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = false;
    private boolean zzm = false;
    private boolean zzn;
    private zzcdk zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr = -1;

    public zzcef(Context context, VersionInfoParcel versionInfoParcel, String str, zzbfe zzbfe, zzbfb zzbfb) {
        zzbf zzbf = new zzbf();
        zzbf zzbf2 = zzbf;
        zzbf2.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbf2.zza("1_5", 1.0d, 5.0d);
        zzbf2.zza("5_10", 5.0d, 10.0d);
        zzbf2.zza("10_20", 10.0d, 20.0d);
        zzbf2.zza("20_30", 20.0d, 30.0d);
        zzbf2.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbf.zzb();
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbfe;
        this.zze = zzbfb;
        String str2 = (String) zzba.zzc().zza(zzbep.zzA);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse frame hash target time number.", e);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcdk zzcdk) {
        zzbew.zza(this.zzf, this.zze, "vpc2");
        this.zzj = true;
        this.zzf.zzd("vpn", zzcdk.zzj());
        this.zzo = zzcdk;
    }

    public final void zzb() {
        if (this.zzj && !this.zzk) {
            zzbew.zza(this.zzf, this.zze, "vfr2");
            this.zzk = true;
        }
    }

    public final void zzc() {
        this.zzn = true;
        if (this.zzk && !this.zzl) {
            zzbew.zza(this.zzf, this.zze, "vfp2");
            this.zzl = true;
        }
    }

    public final void zzd() {
        if (zza && !this.zzp) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzc);
            bundle.putString("player", this.zzo.zzj());
            for (zzbe zzbe : this.zzg.zza()) {
                String valueOf = String.valueOf(zzbe.zza);
                bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbe.zze));
                String valueOf2 = String.valueOf(zzbe.zza);
                bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbe.zzd));
            }
            int i = 0;
            while (true) {
                long[] jArr = this.zzh;
                if (i < jArr.length) {
                    String str = this.zzi[i];
                    if (str != null) {
                        Long valueOf3 = Long.valueOf(jArr[i]);
                        StringBuilder sb = new StringBuilder();
                        sb.append("fh_");
                        sb.append(valueOf3);
                        bundle.putString("fh_".concat(valueOf3.toString()), str);
                    }
                    i++;
                } else {
                    zzu.zzp().zzh(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundle, true);
                    this.zzp = true;
                    return;
                }
            }
        }
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcdk zzcdk) {
        int i = 0;
        if (this.zzl && !this.zzm) {
            if (zze.zzc() && !this.zzm) {
                zze.zza("VideoMetricsMixin first frame");
            }
            zzbew.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long nanoTime = zzu.zzB().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zzb(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzr)));
        }
        this.zzq = this.zzn;
        this.zzr = nanoTime;
        long longValue = ((Long) zzba.zzc().zza(zzbep.zzB)).longValue();
        long zza2 = (long) zzcdk.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(zza2 - this.zzh[i2])) {
                String[] strArr2 = this.zzi;
                int i3 = 8;
                Bitmap bitmap = zzcdk.getBitmap(8, 8);
                long j = 63;
                int i4 = i;
                long j2 = 0;
                while (i4 < i3) {
                    while (i < i3) {
                        int pixel = bitmap.getPixel(i, i4);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j);
                        j--;
                        i++;
                        i3 = 8;
                    }
                    i4++;
                    i = 0;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
            zzcdk zzcdk2 = zzcdk;
            i2++;
            i = 0;
        }
    }
}
