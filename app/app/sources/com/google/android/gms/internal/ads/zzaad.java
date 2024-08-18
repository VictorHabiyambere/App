package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaad extends Handler implements Runnable {
    final /* synthetic */ zzaai zza;
    private final zzaae zzb;
    private final long zzc;
    private zzaaa zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaad(zzaai zzaai, Looper looper, zzaae zzaae, zzaaa zzaaa, int i, long j) {
        super(looper);
        this.zza = zzaai;
        this.zzb = zzaae;
        this.zzd = zzaaa;
        this.zzc = j;
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            if (message.what == 0) {
                zzd();
            } else if (message.what != 3) {
                this.zza.zzf = null;
                long j2 = this.zzc;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - j2;
                zzaaa zzaaa = this.zzd;
                if (zzaaa == null) {
                    throw null;
                } else if (this.zzh) {
                    zzaaa.zzJ(this.zzb, elapsedRealtime, j3, false);
                } else {
                    switch (message.what) {
                        case 1:
                            try {
                                zzaaa.zzK(this.zzb, elapsedRealtime, j3);
                                return;
                            } catch (RuntimeException e) {
                                zzfk.zzd("LoadTask", "Unexpected exception handling load completed", e);
                                this.zza.zzg = new zzaah(e);
                                return;
                            }
                        case 2:
                            this.zze = (IOException) message.obj;
                            int i = this.zzf + 1;
                            this.zzf = i;
                            zzaac zzu = zzaaa.zzu(this.zzb, elapsedRealtime, j3, this.zze, i);
                            if (zzu.zza == 3) {
                                this.zza.zzg = this.zze;
                                return;
                            } else if (zzu.zza != 2) {
                                if (zzu.zza == 1) {
                                    this.zzf = 1;
                                }
                                if (zzu.zzb != -9223372036854775807L) {
                                    j = zzu.zzb;
                                } else {
                                    j = (long) Math.min((this.zzf - 1) * 1000, 5000);
                                }
                                zzc(j);
                                return;
                            } else {
                                return;
                            }
                        default:
                            return;
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                Trace.beginSection("load:" + this.zzb.getClass().getSimpleName());
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzfk.zzd("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new zzaah(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzfk.zzd("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new zzaah(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzfk.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzf = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzaaa zzaaa = this.zzd;
            if (zzaaa != null) {
                zzaaa.zzJ(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
                this.zzd = null;
                return;
            }
            throw null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        boolean z;
        if (this.zza.zzf == null) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        this.zza.zzf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    private final void zzd() {
        this.zze = null;
        zzaai zzaai = this.zza;
        ExecutorService zzd2 = zzaai.zze;
        zzaad zzc2 = zzaai.zzf;
        if (zzc2 != null) {
            zzd2.execute(zzc2);
            return;
        }
        throw null;
    }
}
