package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcrn {
    private final zzdvc zza;
    private final zzfhf zzb;

    zzcrn(zzdvc zzdvc, zzfhf zzfhf) {
        this.zza = zzdvc;
        this.zzb = zzfhf;
    }

    public final void zza(long j, int i) {
        String str;
        zzdvb zza2 = this.zza.zza();
        zza2.zzd(this.zzb.zzb.zzb);
        zza2.zzb("action", "ad_closed");
        zza2.zzb("show_time", String.valueOf(j));
        zza2.zzb("ad_format", "app_open_ad");
        switch (i - 1) {
            case 0:
                str = "h";
                break;
            case 1:
                str = "bb";
                break;
            case 2:
                str = "cc";
                break;
            case 3:
                str = "cb";
                break;
            case 4:
                str = "ac";
                break;
            default:
                str = "u";
                break;
        }
        zza2.zzb("acr", str);
        zza2.zzf();
    }
}
