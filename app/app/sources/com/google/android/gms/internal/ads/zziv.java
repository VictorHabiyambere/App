package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zziv {
    private final AudioManager zza;
    private final zzit zzb;
    private zziu zzc;
    private int zzd;
    private float zze = 1.0f;

    public zziv(Context context, Handler handler, zziu zziu) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            this.zza = audioManager;
            this.zzc = zziu;
            this.zzb = new zzit(this, handler);
            this.zzd = 0;
            return;
        }
        throw null;
    }

    static /* bridge */ /* synthetic */ void zzc(zziv zziv, int i) {
        switch (i) {
            case -3:
            case -2:
                if (i != -2) {
                    zziv.zzg(3);
                    return;
                }
                zziv.zzf(0);
                zziv.zzg(2);
                return;
            case -1:
                zziv.zzf(-1);
                zziv.zze();
                return;
            case 1:
                zziv.zzg(1);
                zziv.zzf(1);
                return;
            default:
                zzfk.zzf("AudioFocusManager", "Unknown focus change type: " + i);
                return;
        }
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzgd.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i) {
        zziu zziu = this.zzc;
        if (zziu != null) {
            zzks zzks = (zzks) zziu;
            boolean zzv = zzks.zza.zzv();
            zzks.zza.zzak(zzv, i, zzkw.zzX(zzv, i));
        }
    }

    private final void zzg(int i) {
        if (this.zzd != i) {
            this.zzd = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.zze != f) {
                this.zze = f;
                zziu zziu = this.zzc;
                if (zziu != null) {
                    ((zzks) zziu).zza.zzah();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
