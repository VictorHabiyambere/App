package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdw {
    private final zzgbc zza;
    private final List zzb = new ArrayList();
    private ByteBuffer[] zzc = new ByteBuffer[0];
    private zzdx zzd = zzdx.zza;
    private zzdx zze = zzdx.zza;
    private boolean zzf = false;

    public zzdw(zzgbc zzgbc) {
        this.zza = zzgbc;
    }

    private final int zzi() {
        return this.zzc.length - 1;
    }

    private final void zzj(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i = 0;
        boolean z = false;
        while (true) {
            if (i <= zzi()) {
                if (!this.zzc[i].hasRemaining()) {
                    zzdz zzdz = (zzdz) this.zzb.get(i);
                    if (!zzdz.zzh()) {
                        if (i > 0) {
                            byteBuffer2 = this.zzc[i - 1];
                        } else {
                            byteBuffer2 = byteBuffer.hasRemaining() ? byteBuffer : zzdz.zza;
                        }
                        zzdz.zze(byteBuffer2);
                        this.zzc[i] = zzdz.zzb();
                        int i2 = ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) > 0 ? 1 : ((((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining())) == 0 ? 0 : -1));
                        boolean z2 = true;
                        if (i2 <= 0 && !this.zzc[i].hasRemaining()) {
                            z2 = false;
                        }
                        z |= z2;
                    } else if (!this.zzc[i].hasRemaining() && i < zzi()) {
                        ((zzdz) this.zzb.get(i + 1)).zzd();
                    }
                }
                i++;
            } else if (z) {
                i = 0;
                z = false;
            } else {
                return;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdw)) {
            return false;
        }
        zzdw zzdw = (zzdw) obj;
        if (this.zza.size() != zzdw.zza.size()) {
            return false;
        }
        for (int i = 0; i < this.zza.size(); i++) {
            if (this.zza.get(i) != zzdw.zza.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final zzdx zza(zzdx zzdx) throws zzdy {
        if (!zzdx.equals(zzdx.zza)) {
            for (int i = 0; i < this.zza.size(); i++) {
                zzdz zzdz = (zzdz) this.zza.get(i);
                zzdx zza2 = zzdz.zza(zzdx);
                if (zzdz.zzg()) {
                    zzeq.zzf(!zza2.equals(zzdx.zza));
                    zzdx = zza2;
                }
            }
            this.zze = zzdx;
            return zzdx;
        }
        throw new zzdy("Unhandled input format:", zzdx);
    }

    public final ByteBuffer zzb() {
        if (!zzh()) {
            return zzdz.zza;
        }
        ByteBuffer byteBuffer = this.zzc[zzi()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        zzj(zzdz.zza);
        return this.zzc[zzi()];
    }

    public final void zzc() {
        this.zzb.clear();
        this.zzd = this.zze;
        this.zzf = false;
        for (int i = 0; i < this.zza.size(); i++) {
            zzdz zzdz = (zzdz) this.zza.get(i);
            zzdz.zzc();
            if (zzdz.zzg()) {
                this.zzb.add(zzdz);
            }
        }
        this.zzc = new ByteBuffer[this.zzb.size()];
        for (int i2 = 0; i2 <= zzi(); i2++) {
            this.zzc[i2] = ((zzdz) this.zzb.get(i2)).zzb();
        }
    }

    public final void zzd() {
        if (zzh() && !this.zzf) {
            this.zzf = true;
            ((zzdz) this.zzb.get(0)).zzd();
        }
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (zzh() && !this.zzf) {
            zzj(byteBuffer);
        }
    }

    public final void zzf() {
        for (int i = 0; i < this.zza.size(); i++) {
            zzdz zzdz = (zzdz) this.zza.get(i);
            zzdz.zzc();
            zzdz.zzf();
        }
        this.zzc = new ByteBuffer[0];
        this.zzd = zzdx.zza;
        this.zze = zzdx.zza;
        this.zzf = false;
    }

    public final boolean zzg() {
        return this.zzf && ((zzdz) this.zzb.get(zzi())).zzh() && !this.zzc[zzi()].hasRemaining();
    }

    public final boolean zzh() {
        return !this.zzb.isEmpty();
    }
}
