package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcfc extends zzasn {
    static final zzcfc zzb = new zzcfc();

    zzcfc() {
    }

    public final zzasr zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzast();
        }
        if ("mvhd".equals(str)) {
            return new zzasu();
        }
        return new zzasv(str);
    }
}
