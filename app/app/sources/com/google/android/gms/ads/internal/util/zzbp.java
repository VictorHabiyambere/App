package com.google.android.gms.ads.internal.util;

import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzara;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzccn;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbp extends zzare {
    private final zzccn zza;
    private final zzl zzb = new zzl((String) null);

    public zzbp(String str, Map map, zzccn zzccn) {
        super(0, str, new zzbo(zzccn));
        this.zza = zzccn;
        this.zzb.zzd(str, ShareTarget.METHOD_GET, (Map) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzark zzh(zzara zzara) {
        return zzark.zzb(zzara, zzasb.zzb(zzara));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzara zzara = (zzara) obj;
        this.zzb.zzf(zzara.zzc, zzara.zza);
        byte[] bArr = zzara.zzb;
        if (zzl.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzara);
    }
}
