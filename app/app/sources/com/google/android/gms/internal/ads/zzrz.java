package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.compose.animation.core.AnimationKt;
import androidx.work.PeriodicWorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import kotlin.time.DurationKt;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzrz implements zzqv {
    private static final Object zza = new Object();
    private static ExecutorService zzb;
    private static int zzc;
    private zzrp zzA;
    private zzcl zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    /* access modifiers changed from: private */
    public boolean zzR;
    /* access modifiers changed from: private */
    public boolean zzS;
    private int zzT;
    private zzl zzU;
    private zzpx zzV;
    /* access modifiers changed from: private */
    public long zzW;
    private boolean zzX;
    private boolean zzY;
    private Looper zzZ;
    private long zzaa;
    private long zzab;
    private Handler zzac;
    private final zzrn zzad;
    private final zzrd zzae;
    private final Context zzd;
    private final zzra zze;
    private final zzsj zzf;
    private final zzgbc zzg;
    private final zzgbc zzh;
    private final zzeu zzi;
    private final zzqz zzj;
    private final ArrayDeque zzk;
    private zzrx zzl;
    private final zzrs zzm;
    private final zzrs zzn;
    private final zzrk zzo;
    private zzpj zzp;
    /* access modifiers changed from: private */
    public zzqs zzq;
    private zzrm zzr;
    private zzrm zzs;
    private zzdw zzt;
    /* access modifiers changed from: private */
    public AudioTrack zzu;
    private zzpp zzv;
    private zzpw zzw;
    private zzrr zzx;
    private zzk zzy = zzk.zza;
    private zzrp zzz;

    /* synthetic */ zzrz(zzrl zzrl, zzry zzry) {
        zzpp zzpp;
        this.zzd = zzrl.zza;
        Context context = this.zzd;
        if (context != null) {
            zzk zzk2 = this.zzy;
            zzpp zzpp2 = zzpp.zza;
            int i = zzgd.zza;
            zzpp = zzpp.zzc(context, zzk2, (zzpx) null);
        } else {
            zzpp = zzrl.zzb;
        }
        this.zzv = zzpp;
        this.zzad = zzrl.zze;
        int i2 = zzgd.zza;
        this.zzo = zzrl.zzd;
        zzrd zzf2 = zzrl.zzf;
        if (zzf2 != null) {
            this.zzae = zzf2;
            this.zzi = new zzeu(zzer.zza);
            this.zzi.zze();
            this.zzj = new zzqz(new zzru(this, (zzrt) null));
            this.zze = new zzra();
            this.zzf = new zzsj();
            this.zzg = zzgbc.zzp(new zzed(), this.zze, this.zzf);
            this.zzh = zzgbc.zzn(new zzsi());
            this.zzL = 1.0f;
            this.zzT = 0;
            this.zzU = new zzl(0, 0.0f);
            this.zzA = new zzrp(zzcl.zza, 0, 0, (zzro) null);
            this.zzB = zzcl.zza;
            this.zzC = false;
            this.zzk = new ArrayDeque();
            this.zzm = new zzrs(100);
            this.zzn = new zzrs(100);
            return;
        }
        throw null;
    }

    public static /* synthetic */ void zzG(zzrz zzrz) {
        if (zzrz.zzab >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            ((zzse) zzrz.zzq).zza.zzn = true;
            zzrz.zzab = 0;
        }
    }

    static /* synthetic */ void zzI(AudioTrack audioTrack, zzqs zzqs, Handler handler, zzqp zzqp, zzeu zzeu) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqs != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzrf(zzqs, zzqp));
            }
            zzeu.zze();
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqs != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new zzrf(zzqs, zzqp));
            }
            zzeu.zze();
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public final long zzL() {
        zzrm zzrm = this.zzs;
        return zzrm.zzc == 0 ? this.zzD / ((long) zzrm.zzb) : this.zzE;
    }

    /* access modifiers changed from: private */
    public final long zzM() {
        zzrm zzrm = this.zzs;
        if (zzrm.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = (long) zzrm.zzd;
        int i = zzgd.zza;
        return ((j + j2) - 1) / j2;
    }

    private final AudioTrack zzN(zzrm zzrm) throws zzqr {
        try {
            return zzrm.zza(this.zzy, this.zzT);
        } catch (zzqr e) {
            zzqs zzqs = this.zzq;
            if (zzqs != null) {
                zzqs.zza(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) {
        zzcl zzcl;
        boolean z;
        if (zzaa()) {
            zzrn zzrn = this.zzad;
            zzcl = this.zzB;
            zzrn.zzc(zzcl);
        } else {
            zzcl = zzcl.zza;
        }
        this.zzB = zzcl;
        zzcl zzcl2 = this.zzB;
        if (zzaa()) {
            zzrn zzrn2 = this.zzad;
            z = this.zzC;
            zzrn2.zzd(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzrp(zzcl2, Math.max(0, j), zzgd.zzs(zzM(), this.zzs.zze), (zzro) null));
        zzV();
        zzqs zzqs = this.zzq;
        if (zzqs != null) {
            ((zzse) zzqs).zza.zzc.zzw(this.zzC);
        }
    }

    private final void zzP() {
        if (this.zzs.zzc()) {
            this.zzX = true;
        }
    }

    private final void zzQ() {
        if (this.zzw == null && this.zzd != null) {
            this.zzZ = Looper.myLooper();
            this.zzw = new zzpw(this.zzd, new zzrh(this), this.zzy, this.zzV);
            this.zzv = this.zzw.zzc();
        }
    }

    private final void zzR() {
        if (!this.zzQ) {
            this.zzQ = true;
            this.zzj.zzb(zzM());
            this.zzu.stop();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r0.hasRemaining() == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r2.zzt.zze(r2.zzM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = r2.zzM;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r0 == null) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzS(long r3) throws com.google.android.gms.internal.ads.zzqu {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzdw r0 = r2.zzt
            boolean r0 = r0.zzh()
            if (r0 == 0) goto L_0x0039
        L_0x0008:
            com.google.android.gms.internal.ads.zzdw r0 = r2.zzt
            boolean r0 = r0.zzg()
            if (r0 != 0) goto L_0x0038
        L_0x0010:
            com.google.android.gms.internal.ads.zzdw r0 = r2.zzt
            java.nio.ByteBuffer r0 = r0.zzb()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0026
            r2.zzW(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0010
            goto L_0x0038
        L_0x0026:
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzdw r0 = r2.zzt
            java.nio.ByteBuffer r1 = r2.zzM
            r0.zze(r1)
            goto L_0x0008
        L_0x0038:
            return
        L_0x0039:
            java.nio.ByteBuffer r0 = r2.zzM
            if (r0 != 0) goto L_0x003f
            java.nio.ByteBuffer r0 = com.google.android.gms.internal.ads.zzdz.zza
        L_0x003f:
            r2.zzW(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrz.zzS(long):void");
    }

    private final void zzT(zzcl zzcl) {
        zzrp zzrp = new zzrp(zzcl, -9223372036854775807L, -9223372036854775807L, (zzro) null);
        if (zzY()) {
            this.zzz = zzrp;
        } else {
            this.zzA = zzrp;
        }
    }

    private final void zzU() {
        if (zzY()) {
            int i = zzgd.zza;
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzV() {
        this.zzt = this.zzs.zzi;
        this.zzt.zzc();
    }

    private final void zzW(ByteBuffer byteBuffer, long j) throws zzqu {
        zzqs zzqs;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.zzO;
            boolean z = false;
            if (byteBuffer2 != null) {
                zzeq.zzd(byteBuffer2 == byteBuffer);
            } else {
                this.zzO = byteBuffer;
                int i = zzgd.zza;
            }
            int remaining = byteBuffer.remaining();
            int i2 = zzgd.zza;
            int write = this.zzu.write(byteBuffer, remaining, 1);
            this.zzW = SystemClock.elapsedRealtime();
            if (write < 0) {
                if ((zzgd.zza >= 24 && write == -6) || write == -32) {
                    if (zzM() > 0) {
                        z = true;
                    } else if (zzZ(this.zzu)) {
                        zzP();
                        z = true;
                    }
                }
                zzqu zzqu = new zzqu(write, this.zzs.zza, z);
                zzqs zzqs2 = this.zzq;
                if (zzqs2 != null) {
                    zzqs2.zza(zzqu);
                }
                if (!zzqu.zzb) {
                    this.zzn.zzb(zzqu);
                } else {
                    this.zzv = zzpp.zza;
                    throw zzqu;
                }
            } else {
                this.zzn.zza();
                if (zzZ(this.zzu)) {
                    if (this.zzG > 0) {
                        this.zzY = false;
                    }
                    if (this.zzS && (zzqs = this.zzq) != null && write < remaining) {
                        zzsf zzsf = ((zzse) zzqs).zza;
                        if (zzsf.zzm != null) {
                            zzsf.zzm.zza();
                        }
                    }
                }
                int i3 = this.zzs.zzc;
                if (i3 == 0) {
                    this.zzF += (long) write;
                }
                if (write == remaining) {
                    if (i3 != 0) {
                        if (byteBuffer == this.zzM) {
                            z = true;
                        }
                        zzeq.zzf(z);
                        this.zzG += ((long) this.zzH) * ((long) this.zzN);
                    }
                    this.zzO = null;
                }
            }
        }
    }

    private final boolean zzX() throws zzqu {
        if (!this.zzt.zzh()) {
            ByteBuffer byteBuffer = this.zzO;
            if (byteBuffer == null) {
                return true;
            }
            zzW(byteBuffer, Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzd();
        zzS(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.zzO;
        if (byteBuffer2 != null) {
            return !byteBuffer2.hasRemaining();
        }
        return true;
    }

    private final boolean zzY() {
        return this.zzu != null;
    }

    private static boolean zzZ(AudioTrack audioTrack) {
        return zzgd.zza >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final boolean zzaa() {
        zzrm zzrm = this.zzs;
        if (zzrm.zzc != 0) {
            return false;
        }
        int i = zzrm.zza.zzC;
        return true;
    }

    public final boolean zzA(zzan zzan) {
        return zza(zzan) != 0;
    }

    public final void zzJ(zzpp zzpp) {
        boolean z;
        if (this.zzZ == Looper.myLooper()) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        if (!zzpp.equals(this.zzv)) {
            this.zzv = zzpp;
            zzqs zzqs = this.zzq;
            if (zzqs != null) {
                ((zzse) zzqs).zza.zzB();
            }
        }
    }

    public final int zza(zzan zzan) {
        zzQ();
        if (!"audio/raw".equals(zzan.zzn)) {
            return this.zzv.zzb(zzan, this.zzy) != null ? 2 : 0;
        }
        if (!zzgd.zzK(zzan.zzC)) {
            int i = zzan.zzC;
            zzfk.zzf("DefaultAudioSink", "Invalid PCM encoding: " + i);
            return 0;
        } else if (zzan.zzC != 2) {
            return 1;
        } else {
            return 2;
        }
    }

    public final long zzb(boolean z) {
        long j;
        if (!zzY() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long min = Math.min(this.zzj.zza(z), zzgd.zzs(zzM(), this.zzs.zze));
        while (!this.zzk.isEmpty() && min >= ((zzrp) this.zzk.getFirst()).zzc) {
            this.zzA = (zzrp) this.zzk.remove();
        }
        zzrp zzrp = this.zzA;
        long j2 = min - zzrp.zzc;
        if (zzrp.zza.equals(zzcl.zza)) {
            j = this.zzA.zzb + j2;
        } else if (this.zzk.isEmpty()) {
            j = this.zzad.zza(j2) + this.zzA.zzb;
        } else {
            zzrp zzrp2 = (zzrp) this.zzk.getFirst();
            j = zzrp2.zzb - zzgd.zzp(zzrp2.zzc - min, this.zzA.zza.zzc);
        }
        long zzb2 = this.zzad.zzb();
        long zzs2 = j + zzgd.zzs(zzb2, this.zzs.zze);
        long j3 = this.zzaa;
        if (zzb2 > j3) {
            long zzs3 = zzgd.zzs(zzb2 - j3, this.zzs.zze);
            this.zzaa = zzb2;
            this.zzab += zzs3;
            if (this.zzac == null) {
                this.zzac = new Handler(Looper.myLooper());
            }
            this.zzac.removeCallbacksAndMessages((Object) null);
            this.zzac.postDelayed(new zzrg(this), 100);
        }
        return zzs2;
    }

    public final zzcl zzc() {
        return this.zzB;
    }

    public final zzqa zzd(zzan zzan) {
        if (this.zzX) {
            return zzqa.zza;
        }
        return this.zzae.zza(zzan, this.zzy);
    }

    public final void zze(zzan zzan, int i, int[] iArr) throws zzqq {
        zzdw zzdw;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        int i11;
        zzan zzan2 = zzan;
        zzQ();
        if ("audio/raw".equals(zzan2.zzn)) {
            zzeq.zzd(zzgd.zzK(zzan2.zzC));
            i7 = zzgd.zzm(zzan2.zzC, zzan2.zzA);
            zzgaz zzgaz = new zzgaz();
            int i12 = zzan2.zzC;
            zzgaz.zzh(this.zzg);
            zzgaz.zzg(this.zzad.zze());
            zzdw zzdw2 = new zzdw(zzgaz.zzi());
            if (zzdw2.equals(this.zzt)) {
                zzdw2 = this.zzt;
            }
            this.zzf.zzq(zzan2.zzD, zzan2.zzE);
            this.zze.zzo(iArr);
            try {
                zzdx zza2 = zzdw2.zza(new zzdx(zzan2.zzB, zzan2.zzA, zzan2.zzC));
                i4 = zza2.zzd;
                i3 = zza2.zzb;
                int i13 = zza2.zzc;
                i2 = zzgd.zzh(i13);
                zzdw = zzdw2;
                i5 = zzgd.zzm(i4, i13);
                i6 = 0;
            } catch (zzdy e) {
                throw new zzqq((Throwable) e, zzan2);
            }
        } else {
            zzdw zzdw3 = new zzdw(zzgbc.zzm());
            int i14 = zzan2.zzB;
            zzqa zzqa = zzqa.zza;
            Pair zzb2 = this.zzv.zzb(zzan2, this.zzy);
            if (zzb2 != null) {
                i4 = ((Integer) zzb2.first).intValue();
                zzdw = zzdw3;
                i7 = -1;
                i2 = ((Integer) zzb2.second).intValue();
                i5 = -1;
                i3 = i14;
                i6 = 2;
            } else {
                throw new zzqq("Unable to configure passthrough for: ".concat(String.valueOf(String.valueOf(zzan))), zzan2);
            }
        }
        if (i4 == 0) {
            throw new zzqq("Invalid output encoding (mode=" + i6 + ") for: " + String.valueOf(zzan), zzan2);
        } else if (i2 != 0) {
            int i15 = zzan2.zzj;
            if ("audio/vnd.dts.hd;profile=lbr".equals(zzan2.zzn) && i15 == -1) {
                i15 = 768000;
            }
            int minBufferSize = AudioTrack.getMinBufferSize(i3, i2, i4);
            int i16 = 1;
            if (minBufferSize != -2) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzf(z);
            if (i5 != -1) {
                i16 = i5;
            }
            int i17 = 250000;
            switch (i6) {
                case 0:
                    i10 = Math.max(zzsb.zza(250000, i3, i16), Math.min(minBufferSize * 4, zzsb.zza(750000, i3, i16)));
                    i8 = i6;
                    i9 = i4;
                    break;
                case 1:
                    i10 = zzgea.zzb((((long) zzsb.zzb(i4)) * 50000000) / AnimationKt.MillisToNanos);
                    i8 = i6;
                    i9 = i4;
                    break;
                default:
                    if (i4 == 5) {
                        i17 = 500000;
                    } else if (i4 == 8) {
                        i17 = DurationKt.NANOS_IN_MILLIS;
                        i4 = 8;
                    }
                    if (i15 != -1) {
                        i11 = zzgds.zza(i15, 8, RoundingMode.CEILING);
                    } else {
                        i11 = zzsb.zzb(i4);
                    }
                    i8 = i6;
                    i10 = zzgea.zzb((((long) i17) * ((long) i11)) / AnimationKt.MillisToNanos);
                    i9 = i4;
                    break;
            }
            this.zzX = false;
            zzrm zzrm = new zzrm(zzan, i7, i8, i5, i3, i2, i9, (((Math.max(minBufferSize, (int) ((double) i10)) + i16) - 1) / i16) * i16, zzdw, false, false, false);
            if (zzY()) {
                this.zzr = zzrm;
            } else {
                this.zzs = zzrm;
            }
        } else {
            throw new zzqq("Invalid output channel config (mode=" + i6 + ") for: " + String.valueOf(zzan), zzan);
        }
    }

    public final void zzf() {
        zzrr zzrr;
        if (zzY()) {
            this.zzD = 0;
            this.zzE = 0;
            this.zzF = 0;
            this.zzG = 0;
            this.zzY = false;
            this.zzH = 0;
            this.zzA = new zzrp(this.zzB, 0, 0, (zzro) null);
            this.zzK = 0;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzp();
            zzV();
            if (this.zzj.zzh()) {
                this.zzu.pause();
            }
            if (zzZ(this.zzu)) {
                zzrx zzrx = this.zzl;
                if (zzrx != null) {
                    zzrx.zzb(this.zzu);
                } else {
                    throw null;
                }
            }
            int i = zzgd.zza;
            zzqp zzb2 = this.zzs.zzb();
            zzrm zzrm = this.zzr;
            if (zzrm != null) {
                this.zzs = zzrm;
                this.zzr = null;
            }
            this.zzj.zzc();
            if (zzgd.zza >= 24 && (zzrr = this.zzx) != null) {
                zzrr.zzb();
                this.zzx = null;
            }
            AudioTrack audioTrack = this.zzu;
            zzeu zzeu = this.zzi;
            zzqs zzqs = this.zzq;
            zzeu.zzc();
            Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzgd.zzE("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.execute(new zzre(audioTrack, zzqs, handler, zzb2, zzeu));
            }
            this.zzu = null;
        }
        this.zzn.zza();
        this.zzm.zza();
        this.zzaa = 0;
        this.zzab = 0;
        Handler handler2 = this.zzac;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    public final void zzg() {
        this.zzI = true;
    }

    public final void zzh() {
        this.zzS = false;
        if (!zzY()) {
            return;
        }
        if (this.zzj.zzk() || zzZ(this.zzu)) {
            this.zzu.pause();
        }
    }

    public final void zzi() {
        this.zzS = true;
        if (zzY()) {
            this.zzj.zzf();
            this.zzu.play();
        }
    }

    public final void zzj() throws zzqu {
        if (!this.zzP && zzY() && zzX()) {
            zzR();
            this.zzP = true;
        }
    }

    public final void zzk() {
        zzpw zzpw = this.zzw;
        if (zzpw != null) {
            zzpw.zzi();
        }
    }

    public final void zzl() {
        zzf();
        zzgbc zzgbc = this.zzg;
        int size = zzgbc.size();
        for (int i = 0; i < size; i++) {
            ((zzdz) zzgbc.get(i)).zzf();
        }
        zzgbc zzgbc2 = this.zzh;
        int size2 = zzgbc2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((zzdz) zzgbc2.get(i2)).zzf();
        }
        zzdw zzdw = this.zzt;
        if (zzdw != null) {
            zzdw.zzf();
        }
        this.zzS = false;
        this.zzX = false;
    }

    public final void zzm(zzk zzk2) {
        if (!this.zzy.equals(zzk2)) {
            this.zzy = zzk2;
            zzpw zzpw = this.zzw;
            if (zzpw != null) {
                zzpw.zzg(zzk2);
            }
            zzf();
        }
    }

    public final void zzn(int i) {
        if (this.zzT != i) {
            this.zzT = i;
            zzf();
        }
    }

    public final void zzo(zzl zzl2) {
        if (!this.zzU.equals(zzl2)) {
            if (this.zzu != null) {
                int i = this.zzU.zza;
            }
            this.zzU = zzl2;
        }
    }

    public final void zzp(zzer zzer) {
        this.zzj.zze(zzer);
    }

    public final void zzq(zzqs zzqs) {
        this.zzq = zzqs;
    }

    public final void zzr(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzZ(audioTrack);
        }
    }

    public final void zzs(zzcl zzcl) {
        this.zzB = new zzcl(Math.max(0.1f, Math.min(zzcl.zzc, 8.0f)), Math.max(0.1f, Math.min(zzcl.zzd, 8.0f)));
        zzT(zzcl);
    }

    public final void zzt(zzpj zzpj) {
        this.zzp = zzpj;
    }

    public final void zzv(boolean z) {
        this.zzC = z;
        zzT(this.zzB);
    }

    public final void zzw(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzU();
        }
    }

    public final boolean zzx(ByteBuffer byteBuffer, long j, int i) throws zzqr, zzqu {
        int i2;
        int i3;
        int i4;
        int i5;
        AudioTrack audioTrack;
        boolean z;
        zzpw zzpw;
        zzpj zzpj;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i6 = i;
        ByteBuffer byteBuffer3 = this.zzM;
        zzeq.zzd(byteBuffer3 != null ? byteBuffer2 == byteBuffer3 : true);
        if (this.zzr != null) {
            if (!zzX()) {
                return false;
            }
            zzrm zzrm = this.zzr;
            zzrm zzrm2 = this.zzs;
            if (zzrm2.zzc == zzrm.zzc && zzrm2.zzg == zzrm.zzg && zzrm2.zze == zzrm.zze && zzrm2.zzf == zzrm.zzf && zzrm2.zzd == zzrm.zzd) {
                boolean z2 = zzrm2.zzj;
                boolean z3 = zzrm.zzj;
                boolean z4 = zzrm2.zzk;
                boolean z5 = zzrm.zzk;
                this.zzs = zzrm;
                this.zzr = null;
                AudioTrack audioTrack2 = this.zzu;
                if (audioTrack2 != null && zzZ(audioTrack2)) {
                    boolean z6 = this.zzs.zzk;
                }
            } else {
                zzR();
                if (zzy()) {
                    return false;
                }
                zzf();
            }
            zzO(j2);
        }
        if (!zzY()) {
            try {
                if (!this.zzi.zzd()) {
                    return false;
                }
                zzrm zzrm3 = this.zzs;
                if (zzrm3 != null) {
                    audioTrack = zzN(zzrm3);
                    this.zzu = audioTrack;
                    if (zzZ(this.zzu)) {
                        AudioTrack audioTrack3 = this.zzu;
                        if (this.zzl == null) {
                            this.zzl = new zzrx(this);
                        }
                        this.zzl.zza(audioTrack3);
                        boolean z7 = this.zzs.zzk;
                    }
                    if (zzgd.zza >= 31 && (zzpj = this.zzp) != null) {
                        zzrj.zza(this.zzu, zzpj);
                    }
                    this.zzT = this.zzu.getAudioSessionId();
                    zzqz zzqz = this.zzj;
                    AudioTrack audioTrack4 = this.zzu;
                    zzrm zzrm4 = this.zzs;
                    if (zzrm4.zzc == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzqz.zzd(audioTrack4, z, zzrm4.zzg, zzrm4.zzd, zzrm4.zzh);
                    zzU();
                    int i7 = this.zzU.zza;
                    zzpx zzpx = this.zzV;
                    if (zzpx != null && zzgd.zza >= 23) {
                        zzri.zza(this.zzu, zzpx);
                        zzpw zzpw2 = this.zzw;
                        if (zzpw2 != null) {
                            zzpw2.zzh(this.zzV.zza);
                        }
                    }
                    if (zzgd.zza >= 24 && (zzpw = this.zzw) != null) {
                        this.zzx = new zzrr(this.zzu, zzpw);
                    }
                    this.zzJ = true;
                    zzqs zzqs = this.zzq;
                    if (zzqs != null) {
                        ((zzse) zzqs).zza.zzc.zzc(this.zzs.zzb());
                    }
                } else {
                    throw null;
                }
            } catch (zzqr e) {
                zzqr zzqr = e;
                zzrm zzrm5 = this.zzs;
                if (zzrm5.zzh > 1000000) {
                    zzan zzan = zzrm5.zza;
                    int i8 = zzrm5.zzb;
                    int i9 = zzrm5.zzc;
                    int i10 = zzrm5.zzd;
                    int i11 = zzrm5.zze;
                    int i12 = zzrm5.zzf;
                    int i13 = zzrm5.zzg;
                    zzdw zzdw = zzrm5.zzi;
                    int i14 = i10;
                    boolean z8 = zzrm5.zzj;
                    boolean z9 = zzrm5.zzk;
                    boolean z10 = zzrm5.zzl;
                    zzrm zzrm6 = new zzrm(zzan, i8, i9, i14, i11, i12, i13, DurationKt.NANOS_IN_MILLIS, zzdw, false, false, false);
                    try {
                        audioTrack = zzN(zzrm6);
                        this.zzs = zzrm6;
                    } catch (zzqr e2) {
                        zzqr.addSuppressed(e2);
                        zzP();
                        throw zzqr;
                    }
                }
                zzP();
                throw zzqr;
            } catch (zzqr e3) {
                if (!e3.zzb) {
                    this.zzm.zzb(e3);
                    return false;
                }
                throw e3;
            }
        }
        this.zzm.zza();
        if (this.zzJ) {
            this.zzK = Math.max(0, j2);
            this.zzI = false;
            this.zzJ = false;
            zzO(j2);
            if (this.zzS) {
                zzi();
            }
        }
        if (!this.zzj.zzj(zzM())) {
            return false;
        }
        if (this.zzM == null) {
            zzeq.zzd(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzrm zzrm7 = this.zzs;
            if (zzrm7.zzc != 0 && this.zzH == 0) {
                int i15 = zzrm7.zzg;
                switch (i15) {
                    case 5:
                    case 6:
                    case 18:
                        i2 = zzact.zza(byteBuffer);
                        break;
                    case 7:
                    case 8:
                        int i16 = zzadr.zza;
                        if (byteBuffer2.getInt(0) != -233094848) {
                            if (byteBuffer2.getInt(0) != -398277519) {
                                if (byteBuffer2.getInt(0) != 622876772) {
                                    int position = byteBuffer.position();
                                    switch (byteBuffer2.get(position)) {
                                        case -2:
                                            i4 = ((byteBuffer2.get(position + 5) & 1) << 6) | ((byteBuffer2.get(position + 4) & 252) >> 2);
                                            i3 = 1;
                                            break;
                                        case -1:
                                            i4 = ((byteBuffer2.get(position + 7) & 60) >> 2) | ((byteBuffer2.get(position + 4) & 7) << 4);
                                            i3 = 1;
                                            break;
                                        case 31:
                                            i4 = ((byteBuffer2.get(position + 6) & 60) >> 2) | ((byteBuffer2.get(position + 5) & 7) << 4);
                                            i3 = 1;
                                            break;
                                        default:
                                            i3 = 1;
                                            i4 = ((byteBuffer2.get(position + 5) & 252) >> 2) | ((byteBuffer2.get(position + 4) & 1) << 6);
                                            break;
                                    }
                                    i2 = (i4 + i3) * 32;
                                    break;
                                } else {
                                    i2 = 4096;
                                    break;
                                }
                            } else {
                                i2 = 1024;
                                break;
                            }
                        } else {
                            i2 = 1024;
                            break;
                        }
                    case 9:
                        i2 = zzaeo.zzc(zzgd.zzi(byteBuffer2, byteBuffer.position()));
                        if (i2 == -1) {
                            throw new IllegalArgumentException();
                        }
                        break;
                    case 10:
                        i2 = 1024;
                        break;
                    case 11:
                    case 12:
                        i2 = 2048;
                        break;
                    case 14:
                        int i17 = zzact.zza;
                        int position2 = byteBuffer.position();
                        int limit = byteBuffer.limit() - 10;
                        int i18 = position2;
                        while (true) {
                            if (i18 > limit) {
                                i5 = -1;
                            } else if ((zzgd.zzi(byteBuffer2, i18 + 4) & -2) == -126718022) {
                                i5 = i18 - position2;
                            } else {
                                i18++;
                            }
                        }
                        if (i5 != -1) {
                            i2 = (40 << ((byteBuffer2.get((byteBuffer.position() + i5) + ((byteBuffer2.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                            break;
                        } else {
                            i2 = 0;
                            break;
                        }
                    case 15:
                        i2 = 512;
                        break;
                    case 16:
                        i2 = 1024;
                        break;
                    case 17:
                        int i19 = zzacw.zza;
                        byte[] bArr = new byte[16];
                        int position3 = byteBuffer.position();
                        byteBuffer2.get(bArr);
                        byteBuffer2.position(position3);
                        i2 = zzacw.zza(new zzft(bArr, 16)).zzc;
                        break;
                    case 20:
                        i2 = zzaep.zzb(byteBuffer);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected audio encoding: " + i15);
                }
                this.zzH = i2;
                if (i2 == 0) {
                    return true;
                }
            }
            if (this.zzz != null) {
                if (!zzX()) {
                    return false;
                }
                zzO(j2);
                this.zzz = null;
            }
            long zzs2 = this.zzK + zzgd.zzs(zzL() - this.zzf.zzo(), this.zzs.zza.zzB);
            if (!this.zzI && Math.abs(zzs2 - j2) > 200000) {
                zzqs zzqs2 = this.zzq;
                if (zzqs2 != null) {
                    zzqs2.zza(new zzqt(j2, zzs2));
                }
                this.zzI = true;
            }
            if (this.zzI) {
                if (!zzX()) {
                    return false;
                }
                long j3 = j2 - zzs2;
                this.zzK += j3;
                this.zzI = false;
                zzO(j2);
                zzqs zzqs3 = this.zzq;
                if (!(zzqs3 == null || j3 == 0)) {
                    ((zzse) zzqs3).zza.zzao();
                }
            }
            if (this.zzs.zzc == 0) {
                this.zzD += (long) byteBuffer.remaining();
            } else {
                this.zzE += ((long) this.zzH) * ((long) i6);
            }
            this.zzM = byteBuffer2;
            this.zzN = i6;
        }
        zzS(j2);
        if (!this.zzM.hasRemaining()) {
            this.zzM = null;
            this.zzN = 0;
            return true;
        } else if (!this.zzj.zzi(zzM())) {
            return false;
        } else {
            zzfk.zzf("DefaultAudioSink", "Resetting stalled audio track");
            zzf();
            return true;
        }
    }

    public final boolean zzy() {
        if (zzY()) {
            return (zzgd.zza < 29 || !this.zzu.isOffloadedPlayback() || !this.zzR) && this.zzj.zzg(zzM());
        }
        return false;
    }

    public final boolean zzz() {
        if (!zzY()) {
            return true;
        }
        if (this.zzP) {
            return !zzy();
        }
        return false;
    }

    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        zzpx zzpx;
        if (audioDeviceInfo == null) {
            zzpx = null;
        } else {
            zzpx = new zzpx(audioDeviceInfo);
        }
        this.zzV = zzpx;
        zzpw zzpw = this.zzw;
        if (zzpw != null) {
            zzpw.zzh(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzri.zza(audioTrack, this.zzV);
        }
    }
}
