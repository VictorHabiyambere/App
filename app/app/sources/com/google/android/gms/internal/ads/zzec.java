package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzec implements zzdz {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdx zze = zzdx.zza;
    private zzdx zzf;
    private zzdx zzg;
    private zzdx zzh;
    private boolean zzi;
    private zzeb zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzec() {
        zzdx zzdx = zzdx.zza;
        this.zzf = zzdx;
        this.zzg = zzdx;
        this.zzh = zzdx;
        this.zzk = zza;
        this.zzl = this.zzk.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    public final zzdx zza(zzdx zzdx) throws zzdy {
        if (zzdx.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzdx.zzb;
            }
            this.zze = zzdx;
            this.zzf = new zzdx(i, zzdx.zzc, 2);
            this.zzi = true;
            return this.zzf;
        }
        throw new zzdy("Unhandled input format:", zzdx);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzeb zzeb = this.zzj;
        if (zzeb != null && (zza = zzeb.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                this.zzk = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzl = this.zzk.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzeb.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzdx zzdx = this.zzg;
                this.zzj = new zzeb(zzdx.zzb, zzdx.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzeb zzeb = this.zzj;
                if (zzeb != null) {
                    zzeb.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzeb zzeb = this.zzj;
        if (zzeb != null) {
            zzeb.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzeb zzeb = this.zzj;
            if (zzeb != null) {
                ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
                int remaining = byteBuffer.remaining();
                this.zzn += (long) remaining;
                zzeb.zzf(asShortBuffer);
                byteBuffer.position(byteBuffer.position() + remaining);
                return;
            }
            throw null;
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzdx.zza;
        zzdx zzdx = zzdx.zza;
        this.zzf = zzdx;
        this.zzg = zzdx;
        this.zzh = zzdx;
        this.zzk = zza;
        this.zzl = this.zzk.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f) {
            return true;
        }
        if (this.zzf.zzb == this.zze.zzb) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzeb zzeb = this.zzj;
        if (zzeb != null) {
            return zzeb.zza() == 0;
        }
        return true;
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (((double) this.zzc) * ((double) j));
        }
        long j3 = this.zzn;
        zzeb zzeb = this.zzj;
        if (zzeb != null) {
            long zzb2 = j3 - ((long) zzeb.zzb());
            int i = this.zzh.zzb;
            int i2 = this.zzg.zzb;
            if (i == i2) {
                return zzgd.zzt(j, zzb2, j2, RoundingMode.FLOOR);
            }
            return zzgd.zzt(j, zzb2 * ((long) i), j2 * ((long) i2), RoundingMode.FLOOR);
        }
        throw null;
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
