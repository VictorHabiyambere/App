package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zztf implements zztn {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf = new AtomicReference();
    private final zzeu zzg;
    private boolean zzh;

    public zztf(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzeu zzeu = new zzeu(zzer.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzeu;
    }

    static /* bridge */ /* synthetic */ void zza(zztf zztf, Message message) {
        zzte zzte;
        zzte zzte2 = null;
        switch (message.what) {
            case 0:
                zzte = (zzte) message.obj;
                int i = zzte.zza;
                int i2 = zzte.zzb;
                try {
                    zztf.zzc.queueInputBuffer(i, 0, zzte.zzc, zzte.zze, zzte.zzf);
                    break;
                } catch (RuntimeException e) {
                    zztc.zza(zztf.zzf, (Object) null, e);
                    break;
                }
            case 1:
                zzte = (zzte) message.obj;
                int i3 = zzte.zza;
                int i4 = zzte.zzb;
                MediaCodec.CryptoInfo cryptoInfo = zzte.zzd;
                long j = zzte.zze;
                int i5 = zzte.zzf;
                try {
                    synchronized (zzb) {
                        zztf.zzc.queueSecureInputBuffer(i3, 0, cryptoInfo, j, i5);
                    }
                    break;
                } catch (RuntimeException e2) {
                    zztc.zza(zztf.zzf, (Object) null, e2);
                    break;
                }
            case 2:
                zztf.zzg.zze();
                break;
            case 3:
                try {
                    zztf.zzc.setParameters((Bundle) message.obj);
                    break;
                } catch (RuntimeException e3) {
                    zztc.zza(zztf.zzf, (Object) null, e3);
                    break;
                }
            default:
                zztc.zza(zztf.zzf, (Object) null, new IllegalStateException(String.valueOf(message.what)));
                break;
        }
        zzte2 = zzte;
        if (zzte2 != null) {
            synchronized (zza) {
                zza.add(zzte2);
            }
        }
    }

    private static zzte zzi() {
        synchronized (zza) {
            if (zza.isEmpty()) {
                zzte zzte = new zzte();
                return zzte;
            }
            zzte zzte2 = (zzte) zza.removeFirst();
            return zzte2;
        }
    }

    private static byte[] zzj(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private static int[] zzk(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                    this.zzg.zzc();
                    Handler handler2 = this.zze;
                    if (handler2 != null) {
                        handler2.obtainMessage(2).sendToTarget();
                        this.zzg.zza();
                        return;
                    }
                    throw null;
                }
                throw null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet((Object) null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final void zzd(int i, int i2, int i3, long j, int i4) {
        zzc();
        zzte zzi = zzi();
        zzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        int i5 = zzgd.zza;
        handler.obtainMessage(0, zzi).sendToTarget();
    }

    public final void zze(int i, int i2, zzik zzik, long j, int i3) {
        zzc();
        zzte zzi = zzi();
        zzi.zza(i, 0, 0, j, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzi.zzd;
        cryptoInfo.numSubSamples = zzik.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzik.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzik.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] zzj = zzj(zzik.zzb, cryptoInfo.key);
        if (zzj != null) {
            cryptoInfo.key = zzj;
            byte[] zzj2 = zzj(zzik.zza, cryptoInfo.iv);
            if (zzj2 != null) {
                cryptoInfo.iv = zzj2;
                cryptoInfo.mode = zzik.zzc;
                if (zzgd.zza >= 24) {
                    cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzik.zzg, zzik.zzh));
                }
                this.zze.obtainMessage(1, zzi).sendToTarget();
                return;
            }
            throw null;
        }
        throw null;
    }

    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        int i = zzgd.zza;
        handler.obtainMessage(3, bundle).sendToTarget();
    }

    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    public final void zzh() {
        if (!this.zzh) {
            this.zzd.start();
            this.zze = new zztd(this, this.zzd.getLooper());
            this.zzh = true;
        }
    }
}
