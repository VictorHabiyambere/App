package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzdqf implements zza, zzbkf, zzp, zzbkh, zzaa {
    private zza zza;
    private zzbkf zzb;
    private zzp zzc;
    private zzbkh zzd;
    private zzaa zze;

    public final synchronized void onAdClicked() {
        zza zza2 = this.zza;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        zzbkf zzbkf = this.zzb;
        if (zzbkf != null) {
            zzbkf.zza(str, bundle);
        }
    }

    public final synchronized void zzb(String str, String str2) {
        zzbkh zzbkh = this.zzd;
        if (zzbkh != null) {
            zzbkh.zzb(str, str2);
        }
    }

    public final synchronized void zzdH() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdH();
        }
    }

    public final synchronized void zzdk() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdk();
        }
    }

    public final synchronized void zzdq() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdq();
        }
    }

    public final synchronized void zzdr() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdr();
        }
    }

    public final synchronized void zzdt() {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdt();
        }
    }

    public final synchronized void zzdu(int i) {
        zzp zzp = this.zzc;
        if (zzp != null) {
            zzp.zzdu(i);
        }
    }

    public final synchronized void zzg() {
        zzaa zzaa = this.zze;
        if (zzaa != null) {
            zzaa.zzg();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzh(zza zza2, zzbkf zzbkf, zzp zzp, zzbkh zzbkh, zzaa zzaa) {
        this.zza = zza2;
        this.zzb = zzbkf;
        this.zzc = zzp;
        this.zzd = zzbkh;
        this.zze = zzaa;
    }
}
