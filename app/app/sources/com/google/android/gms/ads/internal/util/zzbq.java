package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzarh;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzccn;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbq {
    @Deprecated
    public static final zzbl zza = new zzbi();
    private static zzarh zzb;
    private static final Object zzc = new Object();

    public zzbq(Context context) {
        zzarh zzarh;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbep.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzba.zzc().zza(zzbep.zzew)).booleanValue()) {
                        zzarh = zzaz.zzb(context);
                        zzb = zzarh;
                    }
                }
                zzarh = zzasl.zza(context, (zzars) null);
                zzb = zzarh;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzccn zzccn = new zzccn();
        zzb.zza(new zzbp(str, (Map) null, zzccn));
        return zzccn;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        String str2 = str;
        zzbn zzbn = new zzbn((zzbm) null);
        zzbj zzbj = new zzbj(this, str2, zzbn);
        zzl zzl = new zzl((String) null);
        zzbk zzbk = new zzbk(this, i, str, zzbn, zzbj, bArr, map, zzl);
        if (zzl.zzk()) {
            try {
                zzl.zzd(str2, ShareTarget.METHOD_GET, zzbk.zzl(), zzbk.zzx());
            } catch (zzaqm e) {
                zzm.zzj(e.getMessage());
            }
        }
        zzb.zza(zzbk);
        return zzbn;
    }
}
