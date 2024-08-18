package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzpw {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Handler zzb = new Handler(zzgd.zzy(), (Handler.Callback) null);
    private final zzps zzc;
    private final BroadcastReceiver zzd;
    private final zzpt zze;
    private zzpp zzf;
    /* access modifiers changed from: private */
    public zzpx zzg;
    /* access modifiers changed from: private */
    public zzk zzh;
    private boolean zzi;
    private final zzrh zzj;

    zzpw(Context context, zzrh zzrh, zzk zzk, zzpx zzpx) {
        zzps zzps;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzj = zzrh;
        this.zzh = zzk;
        this.zzg = zzpx;
        zzpt zzpt = null;
        if (zzgd.zza >= 23) {
            zzps = new zzps(this, (zzpr) null);
        } else {
            zzps = null;
        }
        this.zzc = zzps;
        this.zzd = new zzpv(this, (zzpu) null);
        Uri zza2 = zzpp.zza();
        this.zze = zza2 != null ? new zzpt(this, this.zzb, applicationContext.getContentResolver(), zza2) : zzpt;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzpp zzpp) {
        if (this.zzi && !zzpp.equals(this.zzf)) {
            this.zzf = zzpp;
            this.zzj.zza.zzJ(zzpp);
        }
    }

    public final zzpp zzc() {
        zzps zzps;
        Intent intent = null;
        if (this.zzi) {
            zzpp zzpp = this.zzf;
            if (zzpp != null) {
                return zzpp;
            }
            throw null;
        }
        this.zzi = true;
        zzpt zzpt = this.zze;
        if (zzpt != null) {
            zzpt.zza();
        }
        if (zzgd.zza >= 23 && (zzps = this.zzc) != null) {
            zzpq.zza(this.zza, zzps, this.zzb);
        }
        if (this.zzd != null) {
            intent = this.zza.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.zzb);
        }
        this.zzf = zzpp.zzd(this.zza, intent, this.zzh, this.zzg);
        return this.zzf;
    }

    public final void zzg(zzk zzk) {
        this.zzh = zzk;
        zzj(zzpp.zzc(this.zza, zzk, this.zzg));
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfo audioDeviceInfo2;
        zzpx zzpx = this.zzg;
        zzpx zzpx2 = null;
        if (zzpx == null) {
            audioDeviceInfo2 = null;
        } else {
            audioDeviceInfo2 = zzpx.zza;
        }
        if (!zzgd.zzG(audioDeviceInfo, audioDeviceInfo2)) {
            if (audioDeviceInfo != null) {
                zzpx2 = new zzpx(audioDeviceInfo);
            }
            this.zzg = zzpx2;
            zzj(zzpp.zzc(this.zza, this.zzh, this.zzg));
        }
    }

    public final void zzi() {
        zzps zzps;
        if (this.zzi) {
            this.zzf = null;
            if (zzgd.zza >= 23 && (zzps = this.zzc) != null) {
                zzpq.zzb(this.zza, zzps);
            }
            BroadcastReceiver broadcastReceiver = this.zzd;
            if (broadcastReceiver != null) {
                this.zza.unregisterReceiver(broadcastReceiver);
            }
            zzpt zzpt = this.zze;
            if (zzpt != null) {
                zzpt.zzb();
            }
            this.zzi = false;
        }
    }
}
