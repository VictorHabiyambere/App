package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzea implements zzdz {
    protected zzdx zzb;
    protected zzdx zzc;
    private zzdx zzd = zzdx.zza;
    private zzdx zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzea() {
        ByteBuffer byteBuffer = zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzdx zzdx = zzdx.zza;
        this.zze = zzdx;
        this.zzb = zzdx;
        this.zzc = zzdx;
    }

    public final zzdx zza(zzdx zzdx) throws zzdy {
        this.zzd = zzdx;
        this.zze = zzi(zzdx);
        return zzg() ? this.zze : zzdx.zza;
    }

    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    public final void zzc() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    public final void zzf() {
        zzc();
        this.zzf = zza;
        this.zzd = zzdx.zza;
        zzdx zzdx = zzdx.zza;
        this.zze = zzdx;
        this.zzb = zzdx;
        this.zzc = zzdx;
        zzm();
    }

    public boolean zzg() {
        return this.zze != zzdx.zza;
    }

    public boolean zzh() {
        return this.zzh && this.zzg == zza;
    }

    /* access modifiers changed from: protected */
    public zzdx zzi(zzdx zzdx) throws zzdy {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public void zzk() {
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    /* access modifiers changed from: protected */
    public void zzm() {
    }

    /* access modifiers changed from: protected */
    public final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
