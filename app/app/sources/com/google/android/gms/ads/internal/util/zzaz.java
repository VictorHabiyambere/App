package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzarh;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzart;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzase;
import com.google.android.gms.internal.ads.zzasf;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbnm;
import com.google.android.gms.internal.ads.zzftu;
import com.google.android.gms.internal.ads.zzftv;
import java.io.File;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaz extends zzart {
    private final Context zzc;

    private zzaz(Context context, zzars zzars) {
        super(zzars);
        this.zzc = context;
    }

    public static zzarh zzb(Context context) {
        zzarh zzarh = new zzarh(new zzasa(new File(zzftv.zza(zzftu.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzasf((zzase) null, (SSLSocketFactory) null)), 4);
        zzarh.zzd();
        return zzarh;
    }

    public final zzara zza(zzare zzare) throws zzarn {
        if (zzare.zza() == 0) {
            if (Pattern.matches((String) zzba.zzc().zza(zzbep.zzex), zzare.zzk())) {
                Context context = this.zzc;
                zzay.zzb();
                if (zzf.zzt(context, 13400000)) {
                    zzara zza = new zzbnm(this.zzc).zza(zzare);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzare.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzare.zzk())));
                }
            }
        }
        return super.zza(zzare);
    }
}
