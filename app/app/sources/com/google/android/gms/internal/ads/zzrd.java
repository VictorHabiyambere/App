package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzrd {
    private final Context zza;
    private Boolean zzb;

    public zzrd() {
        this.zza = null;
    }

    public zzrd(Context context) {
        this.zza = context;
    }

    public final zzqa zza(zzan zzan, zzk zzk) {
        boolean z;
        if (zzan == null) {
            throw null;
        } else if (zzk == null) {
            throw null;
        } else if (zzgd.zza < 29 || zzan.zzB == -1) {
            return zzqa.zza;
        } else {
            Context context = this.zza;
            Boolean bool = this.zzb;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                boolean z2 = false;
                if (context != null) {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                    if (audioManager != null) {
                        String parameters = audioManager.getParameters("offloadVariableRateSupported");
                        if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                            z2 = true;
                        }
                        this.zzb = Boolean.valueOf(z2);
                    } else {
                        this.zzb = false;
                    }
                } else {
                    this.zzb = false;
                }
                z = this.zzb.booleanValue();
            }
            String str = zzan.zzn;
            if (str != null) {
                int zza2 = zzcg.zza(str, zzan.zzk);
                if (zza2 == 0 || zzgd.zza < zzgd.zzg(zza2)) {
                    return zzqa.zza;
                }
                int zzh = zzgd.zzh(zzan.zzA);
                if (zzh == 0) {
                    return zzqa.zza;
                }
                try {
                    AudioFormat zzw = zzgd.zzw(zzan.zzB, zzh, zza2);
                    if (zzgd.zza >= 31) {
                        return zzrc.zza(zzw, zzk.zza().zza, z);
                    }
                    return zzrb.zza(zzw, zzk.zza().zza, z);
                } catch (IllegalArgumentException e) {
                    return zzqa.zza;
                }
            } else {
                throw null;
            }
        }
    }
}
