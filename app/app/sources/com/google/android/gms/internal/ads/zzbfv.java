package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class zzbfv {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbfv(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbfv zza(String str, double d) {
        return new zzbfv(str, Double.valueOf(d), 3);
    }

    public static zzbfv zzb(String str, long j) {
        return new zzbfv(str, Long.valueOf(j), 2);
    }

    public static zzbfv zzc(String str, String str2) {
        return new zzbfv(str, str2, 4);
    }

    public static zzbfv zzd(String str, boolean z) {
        return new zzbfv(str, Boolean.valueOf(z), 1);
    }

    public final Object zze() {
        zzbgz zza2 = zzbhb.zza();
        if (zza2 == null) {
            if (zzbhb.zzb() != null) {
                zzbhb.zzb().zza();
            }
            return this.zzb;
        }
        switch (this.zzc - 1) {
            case 0:
                return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
            case 1:
                return zza2.zzc(this.zza, ((Long) this.zzb).longValue());
            case 2:
                return zza2.zzb(this.zza, ((Double) this.zzb).doubleValue());
            default:
                return zza2.zzd(this.zza, (String) this.zzb);
        }
    }
}
