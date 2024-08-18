package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzabk extends HandlerThread implements Handler.Callback {
    private zzex zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzabm zze;

    public zzabk() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final boolean handleMessage(Message message) {
        boolean z;
        switch (message.what) {
            case 1:
                try {
                    int i = message.arg1;
                    zzex zzex = this.zza;
                    if (zzex != null) {
                        zzex.zzb(i);
                        SurfaceTexture zza2 = this.zza.zza();
                        if (i != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.zze = new zzabm(this, zza2, z, (zzabl) null);
                        synchronized (this) {
                            notify();
                        }
                        break;
                    } else {
                        throw null;
                    }
                } catch (RuntimeException e) {
                    zzfk.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                    this.zzd = e;
                    synchronized (this) {
                        notify();
                        break;
                    }
                } catch (zzey e2) {
                    zzfk.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.zzd = new IllegalStateException(e2);
                    synchronized (this) {
                        notify();
                        break;
                    }
                } catch (Error e3) {
                    try {
                        zzfk.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                        this.zzc = e3;
                        synchronized (this) {
                            notify();
                            break;
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
            case 2:
                try {
                    zzex zzex2 = this.zza;
                    if (zzex2 != null) {
                        zzex2.zzc();
                        quit();
                        return true;
                    }
                    throw null;
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
        }
        return true;
    }

    public final zzabm zza(int i) {
        boolean z;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzex(this.zzb, (zzew) null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzabm zzabm = this.zze;
                if (zzabm != null) {
                    return zzabm;
                }
                throw null;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        if (handler != null) {
            handler.sendEmptyMessage(2);
            return;
        }
        throw null;
    }
}
