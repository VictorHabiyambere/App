package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import com.google.android.gms.common.util.Base64Utils;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final /* synthetic */ class zzh implements zzk {
    public final /* synthetic */ byte[] zza;

    public /* synthetic */ zzh(byte[] bArr) {
        this.zza = bArr;
    }

    public final void zza(JsonWriter jsonWriter) {
        int i = zzl.zza;
        jsonWriter.name("params").beginObject();
        byte[] bArr = this.zza;
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(encode);
        } else {
            String zzf = zzf.zzf(encode);
            if (zzf != null) {
                jsonWriter.name("bodydigest").value(zzf);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }
}
