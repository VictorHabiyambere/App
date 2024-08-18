package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzjd implements zzlk {
    private final zzzv zzb;
    private final long zzc = zzgd.zzr(50000);
    private final long zzd = zzgd.zzr(50000);
    private final long zze = zzgd.zzr(2500);
    private final long zzf = zzgd.zzr(5000);
    private final long zzg = zzgd.zzr(0);
    private final HashMap zzh = new HashMap();
    private long zzi = -1;

    public zzjd() {
        zzzv zzzv = new zzzv(true, 65536);
        zzk(2500, 0, "bufferForPlaybackMs", "0");
        zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzk(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzzv;
    }

    private static void zzk(int i, int i2, String str, String str2) {
        zzeq.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzl(zzpj zzpj) {
        if (this.zzh.remove(zzpj) != null) {
            zzm();
        }
    }

    private final void zzm() {
        if (this.zzh.isEmpty()) {
            this.zzb.zze();
        } else {
            this.zzb.zzf(zza());
        }
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        int i = 0;
        for (zzjc zzjc : this.zzh.values()) {
            i += zzjc.zzb;
        }
        return i;
    }

    public final long zzb(zzpj zzpj) {
        return this.zzg;
    }

    public final void zzc(zzpj zzpj) {
        long id = Thread.currentThread().getId();
        long j = this.zzi;
        boolean z = true;
        if (!(j == -1 || j == id)) {
            z = false;
        }
        zzeq.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzi = id;
        if (!this.zzh.containsKey(zzpj)) {
            this.zzh.put(zzpj, new zzjc((zzjb) null));
        }
        zzjc zzjc = (zzjc) this.zzh.get(zzpj);
        if (zzjc != null) {
            zzjc.zzb = 13107200;
            zzjc.zza = false;
            return;
        }
        throw null;
    }

    public final void zzd(zzpj zzpj) {
        zzl(zzpj);
        if (this.zzh.isEmpty()) {
            this.zzi = -1;
        }
    }

    public final void zze(zzpj zzpj) {
        zzl(zzpj);
    }

    public final void zzf(zzpj zzpj, zzdc zzdc, zzvo zzvo, zzmn[] zzmnArr, zzxr zzxr, zzzg[] zzzgArr) {
        zzjc zzjc = (zzjc) this.zzh.get(zzpj);
        if (zzjc != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int length = zzmnArr.length;
                int i3 = 13107200;
                if (i < 2) {
                    if (zzzgArr[i] != null) {
                        switch (zzmnArr[i].zzb()) {
                            case 1:
                                break;
                            default:
                                i3 = 131072000;
                                break;
                        }
                        i2 += i3;
                    }
                    i++;
                } else {
                    zzjc.zzb = Math.max(13107200, i2);
                    zzm();
                    return;
                }
            }
        } else {
            throw null;
        }
    }

    public final boolean zzg(zzpj zzpj) {
        return false;
    }

    public final boolean zzh(zzpj zzpj, zzdc zzdc, zzvo zzvo, long j, long j2, float f) {
        zzjc zzjc = (zzjc) this.zzh.get(zzpj);
        if (zzjc != null) {
            int zza = this.zzb.zza();
            int zza2 = zza();
            long j3 = this.zzc;
            if (f > 1.0f) {
                j3 = Math.min(zzgd.zzp(j3, f), this.zzd);
            }
            boolean z = false;
            if (j2 < Math.max(j3, 500000)) {
                if (zza < zza2) {
                    z = true;
                }
                zzjc.zza = z;
                if (!z && j2 < 500000) {
                    zzfk.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
                }
            } else if (j2 >= this.zzd || zza >= zza2) {
                zzjc.zza = false;
            }
            return zzjc.zza;
        }
        throw null;
    }

    public final boolean zzi(zzpj zzpj, zzdc zzdc, zzvo zzvo, long j, float f, boolean z, long j2) {
        long j3;
        long zzq = zzgd.zzq(j, f);
        if (z) {
            j3 = this.zzf;
        } else {
            j3 = this.zze;
        }
        if (j2 != -9223372036854775807L) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || zzq >= j3 || this.zzb.zza() >= zza();
    }

    public final zzzv zzj() {
        return this.zzb;
    }
}
