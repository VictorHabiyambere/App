package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzarj;
import com.google.android.gms.internal.ads.zzasj;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbk extends zzasj {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzl zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbk(zzbq zzbq, int i, String str, zzarj zzarj, zzari zzari, byte[] bArr, Map map, zzl zzl) {
        super(i, str, zzarj, zzari);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzl;
    }

    public final Map zzl() throws zzaqm {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzaqm {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
