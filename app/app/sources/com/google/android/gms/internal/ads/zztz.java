package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zztz implements zzui {
    public final int zza(Object obj) {
        int i = zzuj.zza;
        String str = ((zztp) obj).zza;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (zzgd.zza < 26) {
            return str.equals("OMX.MTK.AUDIO.DECODER.RAW") ? -1 : 0;
        }
        return 0;
    }
}
