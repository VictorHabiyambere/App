package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzrm {
    public final zzan zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdw zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzrm(zzan zzan, int i, int i2, int i3, int i4, int i5, int i6, int i7, zzdw zzdw, boolean z, boolean z2, boolean z3) {
        this.zza = zzan;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzdw;
    }

    public final AudioTrack zza(zzk zzk2, int i) throws zzqr {
        AudioTrack audioTrack;
        boolean z;
        try {
            if (zzgd.zza >= 29) {
                AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzk2.zza().zza).setAudioFormat(zzgd.zzw(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i);
                if (this.zzc == 1) {
                    z = true;
                } else {
                    z = false;
                }
                audioTrack = sessionId.setOffloadedPlayback(z).build();
            } else {
                audioTrack = new AudioTrack(zzk2.zza().zza, zzgd.zzw(this.zze, this.zzf, this.zzg), this.zzh, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new zzqr(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            throw new zzqr(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e2);
        }
    }

    public final zzqp zzb() {
        boolean z = this.zzc == 1;
        return new zzqp(this.zzg, this.zze, this.zzf, false, z, this.zzh);
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
