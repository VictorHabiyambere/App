package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzks implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzaci, zzqo, zzxu, zzun, zziu, zziq {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzkw zza;

    /* synthetic */ zzks(zzkw zzkw, zzkr zzkr) {
        this.zza = zzkw;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkw.zzP(this.zza, surfaceTexture);
        this.zza.zzaf(i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzai((Object) null);
        this.zza.zzaf(0, 0);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzaf(i, i2);
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzaf(i2, i3);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaf(0, 0);
    }

    public final void zza(Exception exc) {
        this.zza.zzr.zzv(exc);
    }

    public final void zzb(String str, long j, long j2) {
        this.zza.zzr.zzw(str, j, j2);
    }

    public final void zzc(String str) {
        this.zza.zzr.zzx(str);
    }

    public final void zzd(zzix zzix) {
        this.zza.zzr.zzy(zzix);
        this.zza.zzL = null;
        this.zza.zzR = null;
    }

    public final void zze(zzix zzix) {
        this.zza.zzR = zzix;
        this.zza.zzr.zzz(zzix);
    }

    public final void zzf(zzan zzan, zziy zziy) {
        this.zza.zzL = zzan;
        this.zza.zzr.zzA(zzan, zziy);
    }

    public final void zzg(long j) {
        this.zza.zzr.zzB(j);
    }

    public final void zzh(Exception exc) {
        this.zza.zzr.zzC(exc);
    }

    public final void zzi(zzqp zzqp) {
        this.zza.zzr.zzD(zzqp);
    }

    public final void zzj(zzqp zzqp) {
        this.zza.zzr.zzE(zzqp);
    }

    public final void zzk(int i, long j, long j2) {
        this.zza.zzr.zzF(i, j, j2);
    }

    public final void zzl(int i, long j) {
        this.zza.zzr.zzG(i, j);
    }

    public final void zzm(Object obj, long j) {
        this.zza.zzr.zzH(obj, j);
        zzkw zzkw = this.zza;
        if (zzkw.zzM == obj) {
            zzfh zzD = zzkw.zzl;
            zzD.zzd(26, new zzkq());
            zzD.zzc();
        }
    }

    public final void zzn(boolean z) {
        zzkw zzkw = this.zza;
        if (zzkw.zzV != z) {
            zzkw.zzV = z;
            zzfh zzD = this.zza.zzl;
            zzD.zzd(23, new zzko(z));
            zzD.zzc();
        }
    }

    public final void zzo(Exception exc) {
        this.zza.zzr.zzI(exc);
    }

    public final void zzp(String str, long j, long j2) {
        this.zza.zzr.zzJ(str, j, j2);
    }

    public final void zzq(String str) {
        this.zza.zzr.zzK(str);
    }

    public final void zzr(zzix zzix) {
        this.zza.zzr.zzL(zzix);
        this.zza.zzK = null;
        this.zza.zzQ = null;
    }

    public final void zzs(zzix zzix) {
        this.zza.zzQ = zzix;
        this.zza.zzr.zzM(zzix);
    }

    public final void zzt(long j, int i) {
        this.zza.zzr.zzN(j, i);
    }

    public final void zzu(zzan zzan, zziy zziy) {
        this.zza.zzK = zzan;
        this.zza.zzr.zzO(zzan, zziy);
    }

    public final void zzv(zzdv zzdv) {
        this.zza.zzaa = zzdv;
        zzfh zzD = this.zza.zzl;
        zzD.zzd(25, new zzkp(zzdv));
        zzD.zzc();
    }
}
