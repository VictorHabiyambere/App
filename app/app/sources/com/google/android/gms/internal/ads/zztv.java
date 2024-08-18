package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zztv extends zziw {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private boolean zzD;
    private boolean zzE;
    private long zzF;
    private int zzG;
    private int zzH;
    private ByteBuffer zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    private int zzP;
    private int zzQ;
    private int zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private long zzV;
    private long zzW;
    private boolean zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzix zza;
    private zztu zzaa = zztu.zza;
    private long zzab;
    private boolean zzac;
    private zzsu zzad;
    private zzsu zzae;
    private final zztl zzc;
    private final zztx zzd;
    private final float zze;
    private final zzin zzf = new zzin(0, 0);
    private final zzin zzg = new zzin(0, 0);
    private final zzin zzh = new zzin(2, 0);
    private final zzti zzi = new zzti();
    private final MediaCodec.BufferInfo zzj = new MediaCodec.BufferInfo();
    private final ArrayDeque zzk = new ArrayDeque();
    private final zzsg zzl;
    private zzan zzm;
    private zzan zzn;
    private MediaCrypto zzo;
    private float zzp = 1.0f;
    private zztm zzq;
    private zzan zzr;
    private MediaFormat zzs;
    private boolean zzt;
    private float zzu;
    private ArrayDeque zzv;
    private zztt zzw;
    private zztp zzx;
    private int zzy;
    private boolean zzz;

    public zztv(int i, zztl zztl, zztx zztx, boolean z, float f) {
        super(i);
        this.zzc = zztl;
        this.zzd = zztx;
        this.zze = f;
        this.zzi.zzi(0);
        this.zzi.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzsg();
        this.zzu = -1.0f;
        this.zzy = 0;
        this.zzP = 0;
        this.zzG = -1;
        this.zzH = -1;
        this.zzF = -9223372036854775807L;
        this.zzV = -9223372036854775807L;
        this.zzW = -9223372036854775807L;
        this.zzab = -9223372036854775807L;
        this.zzQ = 0;
        this.zzR = 0;
        this.zza = new zzix();
    }

    protected static boolean zzaL(zzan zzan) {
        return zzan.zzH == 0;
    }

    private final void zzaM() {
        this.zzG = -1;
        this.zzg.zzc = null;
    }

    private final void zzaN() {
        this.zzH = -1;
        this.zzI = null;
    }

    private final void zzaO(zztu zztu) {
        this.zzaa = zztu;
        if (zztu.zzd != -9223372036854775807L) {
            this.zzac = true;
        }
    }

    private final void zzaP() throws zzjh {
        zzsu zzsu = this.zzae;
        if (zzsu != null) {
            this.zzad = zzsu;
            this.zzQ = 0;
            this.zzR = 0;
            return;
        }
        throw null;
    }

    private final boolean zzaQ() throws zzjh {
        if (this.zzS) {
            this.zzQ = 1;
            if (this.zzA) {
                this.zzR = 3;
                return false;
            }
            this.zzR = 2;
        } else {
            zzaP();
        }
        return true;
    }

    private final boolean zzaR() throws zzjh {
        zztm zztm = this.zzq;
        if (zztm == null || this.zzQ == 2 || this.zzX) {
            return false;
        }
        if (this.zzG < 0) {
            int zza2 = zztm.zza();
            this.zzG = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzc = zztm.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzQ == 1) {
            if (!this.zzE) {
                this.zzT = true;
                zztm.zzj(this.zzG, 0, 0, 0, 4);
                zzaM();
            }
            this.zzQ = 2;
            return false;
        } else if (this.zzC) {
            this.zzC = false;
            ByteBuffer byteBuffer = this.zzg.zzc;
            if (byteBuffer != null) {
                byteBuffer.put(zzb);
                zztm.zzj(this.zzG, 0, 38, 0, 0);
                zzaM();
                this.zzS = true;
                return true;
            }
            throw null;
        } else {
            if (this.zzP == 1) {
                int i = 0;
                while (true) {
                    zzan zzan = this.zzr;
                    if (zzan != null) {
                        if (i >= zzan.zzp.size()) {
                            this.zzP = 2;
                            break;
                        }
                        byte[] bArr = (byte[]) this.zzr.zzp.get(i);
                        ByteBuffer byteBuffer2 = this.zzg.zzc;
                        if (byteBuffer2 != null) {
                            byteBuffer2.put(bArr);
                            i++;
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
            }
            ByteBuffer byteBuffer3 = this.zzg.zzc;
            if (byteBuffer3 != null) {
                int position = byteBuffer3.position();
                zzlj zzcX = zzcX();
                try {
                    int zzcV = zzcV(zzcX, this.zzg, 0);
                    if (zzcV == -3) {
                        if (zzQ()) {
                            this.zzW = this.zzV;
                        }
                        return false;
                    } else if (zzcV == -5) {
                        if (this.zzP == 2) {
                            this.zzg.zzb();
                            this.zzP = 1;
                        }
                        zzac(zzcX);
                        return true;
                    } else {
                        zzin zzin = this.zzg;
                        if (zzin.zzf()) {
                            this.zzW = this.zzV;
                            if (this.zzP == 2) {
                                zzin.zzb();
                                this.zzP = 1;
                            }
                            this.zzX = true;
                            if (!this.zzS) {
                                zzao();
                                return false;
                            }
                            try {
                                if (!this.zzE) {
                                    this.zzT = true;
                                    zztm.zzj(this.zzG, 0, 0, 0, 4);
                                    zzaM();
                                }
                                return false;
                            } catch (MediaCodec.CryptoException e) {
                                throw zzi(e, this.zzm, false, zzgd.zzj(e.getErrorCode()));
                            }
                        } else if (this.zzS || zzin.zzg()) {
                            boolean zzk2 = zzin.zzk();
                            if (zzk2) {
                                zzin.zzb.zzb(position);
                            }
                            long j = this.zzg.zze;
                            if (this.zzZ) {
                                if (!this.zzk.isEmpty()) {
                                    zzga zzga = ((zztu) this.zzk.peekLast()).zze;
                                    zzan zzan2 = this.zzm;
                                    if (zzan2 != null) {
                                        zzga.zzd(j, zzan2);
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    zzga zzga2 = this.zzaa.zze;
                                    zzan zzan3 = this.zzm;
                                    if (zzan3 != null) {
                                        zzga2.zzd(j, zzan3);
                                    } else {
                                        throw null;
                                    }
                                }
                                this.zzZ = false;
                            }
                            long max = Math.max(this.zzV, j);
                            this.zzV = max;
                            if (zzQ() || this.zzg.zzh()) {
                                this.zzW = max;
                            }
                            this.zzg.zzj();
                            zzin zzin2 = this.zzg;
                            if (zzin2.zze()) {
                                zzaj(zzin2);
                            }
                            zzaB(this.zzg);
                            zzat(this.zzg);
                            if (zzk2) {
                                try {
                                    zztm.zzk(this.zzG, 0, this.zzg.zzb, j, 0);
                                } catch (MediaCodec.CryptoException e2) {
                                    throw zzi(e2, this.zzm, false, zzgd.zzj(e2.getErrorCode()));
                                }
                            } else {
                                int i2 = this.zzG;
                                ByteBuffer byteBuffer4 = this.zzg.zzc;
                                if (byteBuffer4 != null) {
                                    zztm.zzj(i2, 0, byteBuffer4.limit(), j, 0);
                                } else {
                                    throw null;
                                }
                            }
                            zzaM();
                            this.zzS = true;
                            this.zzP = 0;
                            this.zza.zzc++;
                            return true;
                        } else {
                            zzin.zzb();
                            if (this.zzP == 2) {
                                this.zzP = 1;
                            }
                            return true;
                        }
                    }
                } catch (zzim e3) {
                    zzak(e3);
                    zzaU(0);
                    zzah();
                    return true;
                }
            } else {
                throw null;
            }
        }
    }

    private final boolean zzaS() {
        return this.zzH >= 0;
    }

    private final boolean zzaT(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzan zzan = this.zzn;
        if (zzan == null || !Objects.equals(zzan.zzn, "audio/opus")) {
            return true;
        }
        return !zzaep.zzf(j, j2);
    }

    private final boolean zzaU(int i) throws zzjh {
        zzin zzin = this.zzf;
        zzlj zzcX = zzcX();
        zzin.zzb();
        int zzcV = zzcV(zzcX, this.zzf, i | 4);
        if (zzcV == -5) {
            zzac(zzcX);
            return true;
        } else if (zzcV != -4 || !this.zzf.zzf()) {
            return false;
        } else {
            this.zzX = true;
            zzao();
            return false;
        }
    }

    private final boolean zzaV(zzan zzan) throws zzjh {
        if (!(zzgd.zza < 23 || this.zzq == null || this.zzR == 3 || zzcU() == 0)) {
            float f = this.zzp;
            if (zzan != null) {
                float zzZ2 = zzZ(f, zzan, zzT());
                float f2 = this.zzu;
                if (f2 != zzZ2) {
                    if (zzZ2 == -1.0f) {
                        zzae();
                        return false;
                    } else if (f2 != -1.0f || zzZ2 > this.zze) {
                        Bundle bundle = new Bundle();
                        bundle.putFloat("operating-rate", zzZ2);
                        zztm zztm = this.zzq;
                        if (zztm != null) {
                            zztm.zzp(bundle);
                            this.zzu = zzZ2;
                            return true;
                        }
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        return true;
    }

    private final void zzad() {
        this.zzN = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzM = false;
        this.zzL = false;
        this.zzl.zzb();
    }

    private final void zzae() throws zzjh {
        if (this.zzS) {
            this.zzQ = 1;
            this.zzR = 3;
            return;
        }
        zzaD();
        zzaz();
    }

    private final void zzah() {
        try {
            zztm zztm = this.zzq;
            zzeq.zzb(zztm);
            zztm.zzi();
        } finally {
            zzaE();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0412  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzai(com.google.android.gms.internal.ads.zztp r18, android.media.MediaCrypto r19) throws java.lang.Exception {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            com.google.android.gms.internal.ads.zzan r1 = r8.zzm
            r2 = 0
            if (r1 == 0) goto L_0x0419
            java.lang.String r3 = r0.zza
            int r4 = com.google.android.gms.internal.ads.zzgd.zza
            r5 = 23
            if (r4 >= r5) goto L_0x0014
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x001e
        L_0x0014:
            float r4 = r8.zzp
            com.google.android.gms.internal.ads.zzan[] r7 = r17.zzT()
            float r4 = r8.zzZ(r4, r1, r7)
        L_0x001e:
            float r7 = r8.zze
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0026
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0026:
            r8.zzaC(r1)
            r17.zzh()
            long r9 = android.os.SystemClock.elapsedRealtime()
            com.google.android.gms.internal.ads.zztk r7 = r8.zzaf(r0, r1, r2, r4)
            int r11 = com.google.android.gms.internal.ads.zzgd.zza
            r12 = 31
            if (r11 < r12) goto L_0x0041
            com.google.android.gms.internal.ads.zzpj r11 = r17.zzn()
            com.google.android.gms.internal.ads.zzts.zza(r7, r11)
        L_0x0041:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0414 }
            r11.<init>()     // Catch:{ all -> 0x0414 }
            java.lang.String r12 = "createCodec:"
            r11.append(r12)     // Catch:{ all -> 0x0414 }
            r11.append(r3)     // Catch:{ all -> 0x0414 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0414 }
            android.os.Trace.beginSection(r11)     // Catch:{ all -> 0x0414 }
            com.google.android.gms.internal.ads.zztl r11 = r8.zzc     // Catch:{ all -> 0x0414 }
            com.google.android.gms.internal.ads.zztm r11 = r11.zzd(r7)     // Catch:{ all -> 0x0414 }
            r8.zzq = r11     // Catch:{ all -> 0x0414 }
            android.os.Trace.endSection()
            r17.zzh()
            long r11 = android.os.SystemClock.elapsedRealtime()
            boolean r13 = r0.zze(r1)
            if (r13 != 0) goto L_0x02be
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r15 = "id="
            r13.append(r15)
            java.lang.String r15 = r1.zzb
            r13.append(r15)
            java.lang.String r15 = ", mimeType="
            r13.append(r15)
            java.lang.String r15 = r1.zzn
            r13.append(r15)
            java.lang.String r15 = r1.zzm
            if (r15 == 0) goto L_0x0094
            java.lang.String r15 = ", container="
            r13.append(r15)
            java.lang.String r15 = r1.zzm
            r13.append(r15)
        L_0x0094:
            int r15 = r1.zzj
            r2 = -1
            if (r15 == r2) goto L_0x00a3
            java.lang.String r15 = ", bitrate="
            r13.append(r15)
            int r15 = r1.zzj
            r13.append(r15)
        L_0x00a3:
            java.lang.String r15 = r1.zzk
            if (r15 == 0) goto L_0x00b1
            java.lang.String r15 = ", codecs="
            r13.append(r15)
            java.lang.String r15 = r1.zzk
            r13.append(r15)
        L_0x00b1:
            com.google.android.gms.internal.ads.zzae r15 = r1.zzq
            java.lang.String r5 = ","
            if (r15 == 0) goto L_0x014f
            java.util.LinkedHashSet r15 = new java.util.LinkedHashSet
            r15.<init>()
            r14 = 0
        L_0x00bd:
            com.google.android.gms.internal.ads.zzae r6 = r1.zzq
            int r2 = r6.zzb
            if (r14 >= r2) goto L_0x013f
            com.google.android.gms.internal.ads.zzad r2 = r6.zza(r14)
            java.util.UUID r2 = r2.zza
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzo.zzb
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x00d9
            java.lang.String r2 = "cenc"
            r15.add(r2)
            r16 = r7
            goto L_0x0138
        L_0x00d9:
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x00e9
            java.lang.String r2 = "clearkey"
            r15.add(r2)
            r16 = r7
            goto L_0x0138
        L_0x00e9:
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzo.zze
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x00f9
            java.lang.String r2 = "playready"
            r15.add(r2)
            r16 = r7
            goto L_0x0138
        L_0x00f9:
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0109
            java.lang.String r2 = "widevine"
            r15.add(r2)
            r16 = r7
            goto L_0x0138
        L_0x0109:
            java.util.UUID r6 = com.google.android.gms.internal.ads.zzo.zza
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x0119
            java.lang.String r2 = "universal"
            r15.add(r2)
            r16 = r7
            goto L_0x0138
        L_0x0119:
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r16 = r7
            java.lang.String r7 = "unknown ("
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = ")"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r15.add(r2)
        L_0x0138:
            int r14 = r14 + 1
            r7 = r16
            r2 = -1
            goto L_0x00bd
        L_0x013f:
            r16 = r7
            java.lang.String r2 = ", drm=["
            r13.append(r2)
            com.google.android.gms.internal.ads.zzfxv.zzb(r13, r15, r5)
            r2 = 93
            r13.append(r2)
            goto L_0x0151
        L_0x014f:
            r16 = r7
        L_0x0151:
            int r2 = r1.zzs
            r6 = -1
            if (r2 == r6) goto L_0x016e
            int r2 = r1.zzt
            if (r2 == r6) goto L_0x016e
            java.lang.String r2 = ", res="
            r13.append(r2)
            int r2 = r1.zzs
            r13.append(r2)
            java.lang.String r2 = "x"
            r13.append(r2)
            int r2 = r1.zzt
            r13.append(r2)
        L_0x016e:
            com.google.android.gms.internal.ads.zzt r2 = r1.zzz
            if (r2 == 0) goto L_0x018c
            boolean r6 = r2.zze()
            if (r6 != 0) goto L_0x017e
            boolean r2 = r2.zzf()
            if (r2 == 0) goto L_0x018c
        L_0x017e:
            java.lang.String r2 = ", color="
            r13.append(r2)
            com.google.android.gms.internal.ads.zzt r2 = r1.zzz
            java.lang.String r2 = r2.zzd()
            r13.append(r2)
        L_0x018c:
            float r2 = r1.zzu
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x019e
            java.lang.String r2 = ", fps="
            r13.append(r2)
            float r2 = r1.zzu
            r13.append(r2)
        L_0x019e:
            int r2 = r1.zzA
            r6 = -1
            if (r2 == r6) goto L_0x01ad
            java.lang.String r2 = ", channels="
            r13.append(r2)
            int r2 = r1.zzA
            r13.append(r2)
        L_0x01ad:
            int r2 = r1.zzB
            r6 = -1
            if (r2 == r6) goto L_0x01bc
            java.lang.String r2 = ", sample_rate="
            r13.append(r2)
            int r2 = r1.zzB
            r13.append(r2)
        L_0x01bc:
            java.lang.String r2 = r1.zze
            if (r2 == 0) goto L_0x01ca
            java.lang.String r2 = ", language="
            r13.append(r2)
            java.lang.String r2 = r1.zze
            r13.append(r2)
        L_0x01ca:
            java.util.List r2 = r1.zzd
            boolean r2 = r2.isEmpty()
            java.lang.String r6 = "]"
            if (r2 != 0) goto L_0x01e1
            java.lang.String r2 = ", labels=["
            r13.append(r2)
            java.util.List r2 = r1.zzd
            com.google.android.gms.internal.ads.zzfxv.zzb(r13, r2, r5)
            r13.append(r6)
        L_0x01e1:
            int r2 = r1.zzf
            if (r2 == 0) goto L_0x020a
            java.lang.String r2 = ", selectionFlags=["
            r13.append(r2)
            int r2 = r1.zzf
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r14 = r2 & 1
            if (r14 == 0) goto L_0x01fa
            java.lang.String r14 = "default"
            r7.add(r14)
        L_0x01fa:
            r14 = 2
            r2 = r2 & r14
            if (r2 == 0) goto L_0x0203
            java.lang.String r2 = "forced"
            r7.add(r2)
        L_0x0203:
            com.google.android.gms.internal.ads.zzfxv.zzb(r13, r7, r5)
            r13.append(r6)
        L_0x020a:
            int r2 = r1.zzg
            if (r2 == 0) goto L_0x02a8
            java.lang.String r2 = ", roleFlags=["
            r13.append(r2)
            int r2 = r1.zzg
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r14 = r2 & 1
            if (r14 == 0) goto L_0x0223
            java.lang.String r14 = "main"
            r7.add(r14)
        L_0x0223:
            r14 = r2 & 2
            if (r14 == 0) goto L_0x022c
            java.lang.String r14 = "alt"
            r7.add(r14)
        L_0x022c:
            r14 = r2 & 4
            if (r14 == 0) goto L_0x0235
            java.lang.String r14 = "supplementary"
            r7.add(r14)
        L_0x0235:
            r14 = r2 & 8
            if (r14 == 0) goto L_0x023e
            java.lang.String r14 = "commentary"
            r7.add(r14)
        L_0x023e:
            r14 = r2 & 16
            if (r14 == 0) goto L_0x0247
            java.lang.String r14 = "dub"
            r7.add(r14)
        L_0x0247:
            r14 = r2 & 32
            if (r14 == 0) goto L_0x0250
            java.lang.String r14 = "emergency"
            r7.add(r14)
        L_0x0250:
            r14 = r2 & 64
            if (r14 == 0) goto L_0x0259
            java.lang.String r14 = "caption"
            r7.add(r14)
        L_0x0259:
            r14 = r2 & 128(0x80, float:1.794E-43)
            if (r14 == 0) goto L_0x0262
            java.lang.String r14 = "subtitle"
            r7.add(r14)
        L_0x0262:
            r14 = r2 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x026b
            java.lang.String r14 = "sign"
            r7.add(r14)
        L_0x026b:
            r14 = r2 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0274
            java.lang.String r14 = "describes-video"
            r7.add(r14)
        L_0x0274:
            r14 = r2 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x027d
            java.lang.String r14 = "describes-music"
            r7.add(r14)
        L_0x027d:
            r14 = r2 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0286
            java.lang.String r14 = "enhanced-intelligibility"
            r7.add(r14)
        L_0x0286:
            r14 = r2 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x028f
            java.lang.String r14 = "transcribes-dialog"
            r7.add(r14)
        L_0x028f:
            r14 = r2 & 8192(0x2000, float:1.14794E-41)
            if (r14 == 0) goto L_0x0298
            java.lang.String r14 = "easy-read"
            r7.add(r14)
        L_0x0298:
            r2 = r2 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x02a1
            java.lang.String r2 = "trick-play"
            r7.add(r2)
        L_0x02a1:
            com.google.android.gms.internal.ads.zzfxv.zzb(r13, r7, r5)
            r13.append(r6)
        L_0x02a8:
            java.lang.String r2 = r13.toString()
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r3}
            java.util.Locale r5 = java.util.Locale.US
            java.lang.String r6 = "Format exceeds selected codec's capabilities [%s, %s]"
            java.lang.String r2 = java.lang.String.format(r5, r6, r2)
            java.lang.String r5 = "MediaCodecRenderer"
            com.google.android.gms.internal.ads.zzfk.zzf(r5, r2)
            goto L_0x02c0
        L_0x02be:
            r16 = r7
        L_0x02c0:
            r8.zzx = r0
            r8.zzu = r4
            r8.zzr = r1
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r2 = 25
            r14 = 1
            if (r1 > r2) goto L_0x0301
            java.lang.String r1 = "OMX.Exynos.avc.dec.secure"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0301
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r4 = "SM-T585"
            boolean r1 = r1.startsWith(r4)
            if (r1 != 0) goto L_0x02ff
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r4 = "SM-A510"
            boolean r1 = r1.startsWith(r4)
            if (r1 != 0) goto L_0x02ff
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r4 = "SM-A520"
            boolean r1 = r1.startsWith(r4)
            if (r1 != 0) goto L_0x02ff
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r4 = "SM-J700"
            boolean r1 = r1.startsWith(r4)
            if (r1 == 0) goto L_0x0301
            r1 = 2
            goto L_0x0342
        L_0x02ff:
            r1 = 2
            goto L_0x0342
        L_0x0301:
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r4 = 24
            if (r1 >= r4) goto L_0x0341
            java.lang.String r1 = "OMX.Nvidia.h264.decode"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0317
            java.lang.String r1 = "OMX.Nvidia.h264.decode.secure"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0341
        L_0x0317:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r4 = "flounder"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x033f
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r4 = "flounder_lte"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x033f
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r4 = "grouper"
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x033f
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r4 = "tilapia"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0341
        L_0x033f:
            r1 = r14
            goto L_0x0342
        L_0x0341:
            r1 = 0
        L_0x0342:
            r8.zzy = r1
            com.google.android.gms.internal.ads.zzan r1 = r8.zzr
            if (r1 == 0) goto L_0x0412
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r4 = 29
            if (r1 != r4) goto L_0x0358
            java.lang.String r1 = "c2.android.aac.decoder"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0358
            r1 = r14
            goto L_0x0359
        L_0x0358:
            r1 = 0
        L_0x0359:
            r8.zzz = r1
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r5 = 23
            if (r1 > r5) goto L_0x036d
            java.lang.String r1 = "OMX.google.vorbis.decoder"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x036b
            r1 = 0
            goto L_0x036e
        L_0x036b:
            r1 = r14
            goto L_0x036e
        L_0x036d:
            r1 = 0
        L_0x036e:
            r8.zzA = r1
            int r1 = com.google.android.gms.internal.ads.zzgd.zza
            r5 = 21
            if (r1 != r5) goto L_0x0380
            java.lang.String r1 = "OMX.google.aac.decoder"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0380
            r1 = r14
            goto L_0x0381
        L_0x0380:
            r1 = 0
        L_0x0381:
            r8.zzB = r1
            java.lang.String r1 = r0.zza
            int r5 = com.google.android.gms.internal.ads.zzgd.zza
            if (r5 > r2) goto L_0x0394
            java.lang.String r2 = "OMX.rk.video_decoder.avc"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            goto L_0x0394
        L_0x0392:
            r15 = r14
            goto L_0x03e3
        L_0x0394:
            int r2 = com.google.android.gms.internal.ads.zzgd.zza
            if (r2 > r4) goto L_0x03c8
            java.lang.String r2 = "OMX.broadcom.video_decoder.tunnel"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            java.lang.String r2 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            java.lang.String r2 = "OMX.bcm.vdec.avc.tunnel"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            java.lang.String r2 = "OMX.bcm.vdec.avc.tunnel.secure"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            java.lang.String r2 = "OMX.bcm.vdec.hevc.tunnel"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0392
            java.lang.String r2 = "OMX.bcm.vdec.hevc.tunnel.secure"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0392
        L_0x03c8:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzgd.zzc
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x03e2
            java.lang.String r1 = "AFTS"
            java.lang.String r2 = com.google.android.gms.internal.ads.zzgd.zzd
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x03e2
            boolean r0 = r0.zzf
            if (r0 == 0) goto L_0x03e2
            r15 = r14
            goto L_0x03e3
        L_0x03e2:
            r15 = 0
        L_0x03e3:
            r8.zzE = r15
            com.google.android.gms.internal.ads.zztm r0 = r8.zzq
            if (r0 == 0) goto L_0x040f
            int r0 = r17.zzcU()
            r1 = 2
            if (r0 != r1) goto L_0x03fc
            r17.zzh()
            long r0 = android.os.SystemClock.elapsedRealtime()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r4
            r8.zzF = r0
        L_0x03fc:
            com.google.android.gms.internal.ads.zzix r0 = r8.zza
            int r1 = r0.zza
            int r1 = r1 + r14
            r0.zza = r1
            long r6 = r11 - r9
            r1 = r17
            r2 = r3
            r3 = r16
            r4 = r11
            r1.zzal(r2, r3, r4, r6)
            return
        L_0x040f:
            r0 = 0
            throw r0
        L_0x0412:
            r0 = 0
            throw r0
        L_0x0414:
            r0 = move-exception
            android.os.Trace.endSection()
            throw r0
        L_0x0419:
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zzai(com.google.android.gms.internal.ads.zztp, android.media.MediaCrypto):void");
    }

    /* access modifiers changed from: protected */
    public void zzC() {
        try {
            zzad();
            zzaD();
        } finally {
            this.zzae = null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        if (r5 >= r1) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzF(com.google.android.gms.internal.ads.zzan[] r13, long r14, long r16, com.google.android.gms.internal.ads.zzvo r18) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r12 = this;
            r0 = r12
            com.google.android.gms.internal.ads.zztu r1 = r0.zzaa
            long r1 = r1.zzd
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0020
            com.google.android.gms.internal.ads.zztu r1 = new com.google.android.gms.internal.ads.zztu
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaO(r1)
            return
        L_0x0020:
            java.util.ArrayDeque r1 = r0.zzk
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0055
            long r1 = r0.zzV
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0038
            long r5 = r0.zzab
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0055
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0055
        L_0x0038:
            com.google.android.gms.internal.ads.zztu r1 = new com.google.android.gms.internal.ads.zztu
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.zzaO(r1)
            com.google.android.gms.internal.ads.zztu r1 = r0.zzaa
            long r1 = r1.zzd
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0054
            r12.zzap()
        L_0x0054:
            return
        L_0x0055:
            java.util.ArrayDeque r1 = r0.zzk
            com.google.android.gms.internal.ads.zztu r9 = new com.google.android.gms.internal.ads.zztu
            long r3 = r0.zzV
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zzF(com.google.android.gms.internal.ads.zzan[], long, long, com.google.android.gms.internal.ads.zzvo):void");
    }

    public void zzM(float f, float f2) throws zzjh {
        this.zzp = f2;
        zzaV(this.zzr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: android.media.MediaCodec$BufferInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v20, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v36, resolved type: com.google.android.gms.internal.ads.zzan} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v39, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v40, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v53, resolved type: com.google.android.gms.internal.ads.zzan} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v54, resolved type: com.google.android.gms.internal.ads.zztv} */
    /* JADX WARNING: type inference failed for: r18v0 */
    /* JADX WARNING: type inference failed for: r18v1 */
    /* JADX WARNING: type inference failed for: r18v2 */
    /* JADX WARNING: type inference failed for: r18v3 */
    /* JADX WARNING: type inference failed for: r0v35, types: [java.lang.Throwable, android.media.MediaFormat] */
    /* JADX WARNING: type inference failed for: r0v37 */
    /* JADX WARNING: type inference failed for: r0v48 */
    /* JADX WARNING: type inference failed for: r18v24 */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01a1, code lost:
        r15.zzM = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0301, code lost:
        if (r15.zzn != null) goto L_0x0303;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0363 A[Catch:{ IllegalStateException -> 0x03ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0368 A[Catch:{ IllegalStateException -> 0x03ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0408  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x042d  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x0431  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzV(long r23, long r25) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r22 = this;
            r15 = r22
            r14 = 1
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03fc }
            if (r0 == 0) goto L_0x000b
            r22.zzaq()     // Catch:{ IllegalStateException -> 0x03fc }
            return
        L_0x000b:
            com.google.android.gms.internal.ads.zzan r0 = r15.zzm     // Catch:{ IllegalStateException -> 0x03fc }
            r11 = 2
            if (r0 != 0) goto L_0x0018
            boolean r0 = r15.zzaU(r11)     // Catch:{ IllegalStateException -> 0x03fc }
            if (r0 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            return
        L_0x0018:
            r22.zzaz()     // Catch:{ IllegalStateException -> 0x03fc }
            boolean r0 = r15.zzL     // Catch:{ IllegalStateException -> 0x03fc }
            if (r0 == 0) goto L_0x01d6
            java.lang.String r0 = "bypassRender"
            android.os.Trace.beginSection(r0)     // Catch:{ IllegalStateException -> 0x01d2 }
        L_0x0024:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x01d2 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzeq.zzf(r0)     // Catch:{ IllegalStateException -> 0x01d2 }
            com.google.android.gms.internal.ads.zzti r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x01d2 }
            boolean r1 = r0.zzp()     // Catch:{ IllegalStateException -> 0x01d2 }
            if (r1 == 0) goto L_0x008d
            java.nio.ByteBuffer r7 = r0.zzc     // Catch:{ IllegalStateException -> 0x0088 }
            int r8 = r15.zzH     // Catch:{ IllegalStateException -> 0x0088 }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x0088 }
            long r4 = r0.zze     // Catch:{ IllegalStateException -> 0x0088 }
            long r1 = r22.zzf()     // Catch:{ IllegalStateException -> 0x0088 }
            long r12 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0088 }
            boolean r13 = r15.zzaT(r1, r12)     // Catch:{ IllegalStateException -> 0x0088 }
            com.google.android.gms.internal.ads.zzti r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0088 }
            boolean r0 = r0.zzf()     // Catch:{ IllegalStateException -> 0x0088 }
            com.google.android.gms.internal.ads.zzan r11 = r15.zzn     // Catch:{ IllegalStateException -> 0x0088 }
            if (r11 == 0) goto L_0x0085
            r6 = 0
            r9 = 0
            r1 = r22
            r2 = r23
            r18 = r4
            r4 = r25
            r17 = r11
            r11 = r18
            r14 = r0
            r15 = r17
            boolean r0 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0081 }
            if (r0 == 0) goto L_0x007b
            r15 = r22
            com.google.android.gms.internal.ads.zzti r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0088 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0088 }
            r15.zzaA(r0)     // Catch:{ IllegalStateException -> 0x0088 }
            com.google.android.gms.internal.ads.zzti r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0088 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0088 }
            r0 = 0
            goto L_0x008e
        L_0x007b:
            r15 = r22
            r13 = 0
            r14 = 1
            goto L_0x01c4
        L_0x0081:
            r0 = move-exception
            r15 = r22
            goto L_0x0089
        L_0x0085:
            r0 = 0
            throw r0     // Catch:{ IllegalStateException -> 0x0088 }
        L_0x0088:
            r0 = move-exception
        L_0x0089:
            r1 = r15
            r2 = 1
            goto L_0x03ff
        L_0x008d:
            r0 = 0
        L_0x008e:
            boolean r1 = r15.zzX     // Catch:{ IllegalStateException -> 0x01cd }
            if (r1 == 0) goto L_0x0098
            r14 = 1
            r15.zzY = r14     // Catch:{ IllegalStateException -> 0x03fc }
            r13 = 0
            goto L_0x01c4
        L_0x0098:
            r14 = 1
            boolean r1 = r15.zzM     // Catch:{ IllegalStateException -> 0x01d2 }
            if (r1 == 0) goto L_0x00ac
            com.google.android.gms.internal.ads.zzti r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x01d2 }
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x01d2 }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x01d2 }
            com.google.android.gms.internal.ads.zzeq.zzf(r1)     // Catch:{ IllegalStateException -> 0x01d2 }
            r13 = 0
            r15.zzM = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x00ad
        L_0x00ac:
            r13 = 0
        L_0x00ad:
            boolean r1 = r15.zzN     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x00c5
            com.google.android.gms.internal.ads.zzti r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r1 = r1.zzp()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 != 0) goto L_0x0024
            r22.zzad()     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzN = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            r22.zzaz()     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r1 = r15.zzL     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x01c4
        L_0x00c5:
            boolean r1 = r15.zzX     // Catch:{ IllegalStateException -> 0x03f6 }
            r1 = r1 ^ r14
            com.google.android.gms.internal.ads.zzeq.zzf(r1)     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzlj r1 = r22.zzcX()     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            r2.zzb()     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x00d4:
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            r2.zzb()     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r15.zzcV(r1, r2, r13)     // Catch:{ IllegalStateException -> 0x03f6 }
            switch(r2) {
                case -5: goto L_0x01a4;
                case -4: goto L_0x00e4;
                default: goto L_0x00e2;
            }     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x00e2:
            goto L_0x01a7
        L_0x00e4:
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = r2.zzf()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x00f0
            r15.zzX = r14     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x01a7
        L_0x00f0:
            boolean r2 = r15.zzZ     // Catch:{ IllegalStateException -> 0x03f6 }
            java.lang.String r3 = "audio/opus"
            if (r2 == 0) goto L_0x013c
            com.google.android.gms.internal.ads.zzan r2 = r15.zzm     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x013a
            r15.zzn = r2     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            java.lang.String r2 = r2.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = java.util.Objects.equals(r2, r3)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            java.util.List r2 = r2.zzp     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = r2.isEmpty()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 != 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            java.util.List r2 = r2.zzp     // Catch:{ IllegalStateException -> 0x03f6 }
            java.lang.Object r2 = r2.get(r13)     // Catch:{ IllegalStateException -> 0x03f6 }
            byte[] r2 = (byte[]) r2     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = com.google.android.gms.internal.ads.zzaep.zza(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r4 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r4 == 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzal r4 = r4.zzb()     // Catch:{ IllegalStateException -> 0x03f6 }
            r4.zzF(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r2 = r4.zzad()     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzn = r2     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x0132
        L_0x0130:
            throw r0     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x0132:
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzan(r2, r0)     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzZ = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x013c
        L_0x013a:
            throw r0     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x013c:
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            r2.zzj()     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0178
            java.lang.String r2 = r2.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = java.util.Objects.equals(r2, r3)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzin r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r3 = r2.zze()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r3 == 0) goto L_0x015c
            com.google.android.gms.internal.ads.zzan r3 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            r2.zza = r3     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzaj(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x015c:
            long r2 = r22.zzf()     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzin r4 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            long r5 = r4.zze     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = com.google.android.gms.internal.ads.zzaep.zzf(r2, r5)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0178
            com.google.android.gms.internal.ads.zzsg r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r3 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r3 == 0) goto L_0x0176
            java.util.List r3 = r3.zzp     // Catch:{ IllegalStateException -> 0x03f6 }
            r2.zza(r4, r3)     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x0178
        L_0x0176:
            throw r0     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x0178:
            com.google.android.gms.internal.ads.zzti r2 = r15.zzi     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r3 = r2.zzp()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r3 != 0) goto L_0x0181
            goto L_0x0197
        L_0x0181:
            long r3 = r22.zzf()     // Catch:{ IllegalStateException -> 0x03f6 }
            long r5 = r2.zzm()     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = r15.zzaT(r3, r5)     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzin r5 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            long r5 = r5.zze     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r3 = r15.zzaT(r3, r5)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 != r3) goto L_0x01a1
        L_0x0197:
            com.google.android.gms.internal.ads.zzti r2 = r15.zzi     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzin r3 = r15.zzh     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = r2.zzo(r3)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 != 0) goto L_0x00d4
        L_0x01a1:
            r15.zzM = r14     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x01a7
        L_0x01a4:
            r15.zzac(r1)     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x01a7:
            com.google.android.gms.internal.ads.zzti r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r2 = r1.zzp()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x01b2
            r1.zzj()     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x01b2:
            com.google.android.gms.internal.ads.zzti r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r1 = r1.zzp()     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 != 0) goto L_0x0024
            boolean r1 = r15.zzX     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 != 0) goto L_0x0024
            boolean r1 = r15.zzN     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x01c4
            goto L_0x0024
        L_0x01c4:
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03f6 }
            r18 = r13
            r2 = r14
            r1 = r15
            goto L_0x03eb
        L_0x01cd:
            r0 = move-exception
            r13 = 0
            r14 = 1
            goto L_0x03f7
        L_0x01d2:
            r0 = move-exception
            r13 = 0
            goto L_0x03f7
        L_0x01d6:
            r0 = 0
            r13 = 0
            com.google.android.gms.internal.ads.zztm r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x03d9
            r22.zzh()     // Catch:{ IllegalStateException -> 0x03d4 }
            android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x03d4 }
            java.lang.String r1 = "drainAndFeed"
            android.os.Trace.beginSection(r1)     // Catch:{ IllegalStateException -> 0x03d4 }
        L_0x01e7:
            com.google.android.gms.internal.ads.zztm r6 = r15.zzq     // Catch:{ IllegalStateException -> 0x03d4 }
            if (r6 == 0) goto L_0x03d0
            boolean r1 = r22.zzaS()     // Catch:{ IllegalStateException -> 0x03d4 }
            if (r1 != 0) goto L_0x0313
            boolean r1 = r15.zzB     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0215
            boolean r1 = r15.zzT     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0215
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x0200 }
            int r1 = r6.zzb(r1)     // Catch:{ IllegalStateException -> 0x0200 }
            goto L_0x021b
        L_0x0200:
            r0 = move-exception
            r22.zzao()     // Catch:{ IllegalStateException -> 0x03f6 }
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r0 == 0) goto L_0x0210
            r22.zzaD()     // Catch:{ IllegalStateException -> 0x03f6 }
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x0210:
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x0215:
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r1 = r6.zzb(r1)     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x021b:
            if (r1 >= 0) goto L_0x0269
            r2 = -2
            if (r1 != r2) goto L_0x024a
            r15.zzU = r14     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zztm r1 = r15.zzq     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0248
            android.media.MediaFormat r1 = r1.zzc()     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r15.zzy     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0243
            java.lang.String r2 = "width"
            int r2 = r1.getInteger(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            r3 = 32
            if (r2 != r3) goto L_0x0243
            java.lang.String r2 = "height"
            int r2 = r1.getInteger(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 != r3) goto L_0x0243
            r15.zzD = r14     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x01e7
        L_0x0243:
            r15.zzs = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzt = r14     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x01e7
        L_0x0248:
            throw r0     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x024a:
            boolean r0 = r15.zzE     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r0 != 0) goto L_0x0253
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x0253:
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r0 != 0) goto L_0x0261
            int r0 = r15.zzQ     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r0 != r11) goto L_0x025c
            goto L_0x0261
        L_0x025c:
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x0261:
            r22.zzao()     // Catch:{ IllegalStateException -> 0x03f6 }
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x0269:
            boolean r2 = r15.zzD     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x0274
            r15.zzD = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            r6.zzn(r1, r13)     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x01e7
        L_0x0274:
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r2.size     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 != 0) goto L_0x028a
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r2.flags     // Catch:{ IllegalStateException -> 0x03f6 }
            r2 = r2 & 4
            if (r2 == 0) goto L_0x028a
            r22.zzao()     // Catch:{ IllegalStateException -> 0x03f6 }
            r18 = r13
            r1 = r15
            goto L_0x03bd
        L_0x028a:
            r15.zzH = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            java.nio.ByteBuffer r1 = r6.zzg(r1)     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzI = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            java.nio.ByteBuffer r1 = r15.zzI     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x02ab
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r2.offset     // Catch:{ IllegalStateException -> 0x03f6 }
            r1.position(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            java.nio.ByteBuffer r1 = r15.zzI     // Catch:{ IllegalStateException -> 0x03f6 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r2.offset     // Catch:{ IllegalStateException -> 0x03f6 }
            android.media.MediaCodec$BufferInfo r3 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            int r3 = r3.size     // Catch:{ IllegalStateException -> 0x03f6 }
            int r2 = r2 + r3
            r1.limit(r2)     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x02ab:
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            long r1 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03f6 }
            long r3 = r22.zzf()     // Catch:{ IllegalStateException -> 0x03f6 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x02b9
            r1 = r14
            goto L_0x02ba
        L_0x02b9:
            r1 = r13
        L_0x02ba:
            r15.zzJ = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            long r1 = r15.zzW     // Catch:{ IllegalStateException -> 0x03f6 }
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x02d1
            android.media.MediaCodec$BufferInfo r3 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            long r3 = r3.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03f6 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x02d1
            r1 = r14
            goto L_0x02d2
        L_0x02d1:
            r1 = r13
        L_0x02d2:
            r15.zzK = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03f6 }
            long r1 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zztu r3 = r15.zzaa     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzga r3 = r3.zze     // Catch:{ IllegalStateException -> 0x03f6 }
            java.lang.Object r1 = r3.zzc(r1)     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r1 = (com.google.android.gms.internal.ads.zzan) r1     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 != 0) goto L_0x02f6
            boolean r2 = r15.zzac     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x02f6
            android.media.MediaFormat r2 = r15.zzs     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r2 == 0) goto L_0x02f6
            com.google.android.gms.internal.ads.zztu r1 = r15.zzaa     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzga r1 = r1.zze     // Catch:{ IllegalStateException -> 0x03f6 }
            java.lang.Object r1 = r1.zzb()     // Catch:{ IllegalStateException -> 0x03f6 }
            com.google.android.gms.internal.ads.zzan r1 = (com.google.android.gms.internal.ads.zzan) r1     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x02f6:
            if (r1 == 0) goto L_0x02fb
            r15.zzn = r1     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x0303
        L_0x02fb:
            boolean r1 = r15.zzt     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0313
            com.google.android.gms.internal.ads.zzan r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0313
        L_0x0303:
            com.google.android.gms.internal.ads.zzan r1 = r15.zzn     // Catch:{ IllegalStateException -> 0x03f6 }
            if (r1 == 0) goto L_0x0311
            android.media.MediaFormat r2 = r15.zzs     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzan(r1, r2)     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzt = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            r15.zzac = r13     // Catch:{ IllegalStateException -> 0x03f6 }
            goto L_0x0313
        L_0x0311:
            throw r0     // Catch:{ IllegalStateException -> 0x03f6 }
        L_0x0313:
            boolean r1 = r15.zzB     // Catch:{ IllegalStateException -> 0x03d4 }
            if (r1 == 0) goto L_0x036f
            boolean r1 = r15.zzT     // Catch:{ IllegalStateException -> 0x03d4 }
            if (r1 == 0) goto L_0x036f
            java.nio.ByteBuffer r7 = r15.zzI     // Catch:{ IllegalStateException -> 0x0357 }
            int r8 = r15.zzH     // Catch:{ IllegalStateException -> 0x0357 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x0357 }
            int r9 = r1.flags     // Catch:{ IllegalStateException -> 0x0357 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x0357 }
            long r4 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0357 }
            boolean r12 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0357 }
            boolean r10 = r15.zzK     // Catch:{ IllegalStateException -> 0x0357 }
            com.google.android.gms.internal.ads.zzan r2 = r15.zzn     // Catch:{ IllegalStateException -> 0x0357 }
            if (r2 == 0) goto L_0x0352
            r16 = 1
            r1 = r22
            r17 = r2
            r2 = r23
            r18 = r4
            r4 = r25
            r20 = r10
            r10 = r16
            r21 = r11
            r16 = r12
            r11 = r18
            r18 = r13
            r13 = r16
            r14 = r20
            r15 = r17
            boolean r1 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0355 }
            goto L_0x0399
        L_0x0352:
            r18 = r13
            throw r0     // Catch:{ IllegalStateException -> 0x0355 }
        L_0x0355:
            r0 = move-exception
            goto L_0x035a
        L_0x0357:
            r0 = move-exception
            r18 = r13
        L_0x035a:
            r22.zzao()     // Catch:{ IllegalStateException -> 0x036a }
            r15 = r22
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x03ce }
            if (r0 == 0) goto L_0x0368
            r22.zzaD()     // Catch:{ IllegalStateException -> 0x03ce }
            r1 = r15
            goto L_0x03bd
        L_0x0368:
            r1 = r15
            goto L_0x03bd
        L_0x036a:
            r0 = move-exception
            r15 = r22
            goto L_0x03d7
        L_0x036f:
            r21 = r11
            r18 = r13
            java.nio.ByteBuffer r7 = r15.zzI     // Catch:{ IllegalStateException -> 0x03ce }
            int r8 = r15.zzH     // Catch:{ IllegalStateException -> 0x03ce }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03ce }
            int r9 = r1.flags     // Catch:{ IllegalStateException -> 0x03ce }
            android.media.MediaCodec$BufferInfo r1 = r15.zzj     // Catch:{ IllegalStateException -> 0x03ce }
            long r11 = r1.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03ce }
            boolean r13 = r15.zzJ     // Catch:{ IllegalStateException -> 0x03ce }
            boolean r14 = r15.zzK     // Catch:{ IllegalStateException -> 0x03ce }
            com.google.android.gms.internal.ads.zzan r10 = r15.zzn     // Catch:{ IllegalStateException -> 0x03ce }
            if (r10 == 0) goto L_0x03cc
            r16 = 1
            r1 = r22
            r2 = r23
            r4 = r25
            r17 = r10
            r10 = r16
            r15 = r17
            boolean r1 = r1.zzar(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x03c8 }
        L_0x0399:
            if (r1 == 0) goto L_0x03bb
            r1 = r22
            android.media.MediaCodec$BufferInfo r2 = r1.zzj     // Catch:{ IllegalStateException -> 0x03f3 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x03f3 }
            r1.zzaA(r2)     // Catch:{ IllegalStateException -> 0x03f3 }
            android.media.MediaCodec$BufferInfo r2 = r1.zzj     // Catch:{ IllegalStateException -> 0x03f3 }
            int r2 = r2.flags     // Catch:{ IllegalStateException -> 0x03f3 }
            r2 = r2 & 4
            r22.zzaN()     // Catch:{ IllegalStateException -> 0x03f3 }
            if (r2 == 0) goto L_0x03b3
            r22.zzao()     // Catch:{ IllegalStateException -> 0x03f3 }
            goto L_0x03bd
        L_0x03b3:
            r15 = r1
            r13 = r18
            r11 = r21
            r14 = 1
            goto L_0x01e7
        L_0x03bb:
            r1 = r22
        L_0x03bd:
            boolean r0 = r22.zzaR()     // Catch:{ IllegalStateException -> 0x03f3 }
            if (r0 != 0) goto L_0x03bd
            android.os.Trace.endSection()     // Catch:{ IllegalStateException -> 0x03f3 }
            r2 = 1
            goto L_0x03eb
        L_0x03c8:
            r0 = move-exception
            r1 = r22
            goto L_0x03f4
        L_0x03cc:
            r1 = r15
            throw r0     // Catch:{ IllegalStateException -> 0x03f3 }
        L_0x03ce:
            r0 = move-exception
            goto L_0x03d7
        L_0x03d0:
            r18 = r13
            r1 = r15
            throw r0     // Catch:{ IllegalStateException -> 0x03f3 }
        L_0x03d4:
            r0 = move-exception
            r18 = r13
        L_0x03d7:
            r1 = r15
            goto L_0x03f4
        L_0x03d9:
            r18 = r13
            r1 = r15
            com.google.android.gms.internal.ads.zzix r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03f3 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x03f3 }
            int r3 = r22.zzd(r23)     // Catch:{ IllegalStateException -> 0x03f3 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x03f3 }
            r2 = 1
            r1.zzaU(r2)     // Catch:{ IllegalStateException -> 0x03f1 }
        L_0x03eb:
            com.google.android.gms.internal.ads.zzix r0 = r1.zza     // Catch:{ IllegalStateException -> 0x03f1 }
            r0.zza()     // Catch:{ IllegalStateException -> 0x03f1 }
            return
        L_0x03f1:
            r0 = move-exception
            goto L_0x0401
        L_0x03f3:
            r0 = move-exception
        L_0x03f4:
            r2 = 1
            goto L_0x0401
        L_0x03f6:
            r0 = move-exception
        L_0x03f7:
            r18 = r13
            r2 = r14
            r1 = r15
            goto L_0x0401
        L_0x03fc:
            r0 = move-exception
            r2 = r14
            r1 = r15
        L_0x03ff:
            r18 = 0
        L_0x0401:
            int r3 = com.google.android.gms.internal.ads.zzgd.zza
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x0408
            goto L_0x041d
        L_0x0408:
            java.lang.StackTraceElement[] r4 = r0.getStackTrace()
            int r5 = r4.length
            if (r5 <= 0) goto L_0x0443
            r4 = r4[r18]
            java.lang.String r4 = r4.getClassName()
            java.lang.String r5 = "android.media.MediaCodec"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0443
        L_0x041d:
            r1.zzak(r0)
            if (r3 == 0) goto L_0x042d
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x042d
            r14 = r2
            goto L_0x042f
        L_0x042d:
            r14 = r18
        L_0x042f:
            if (r14 == 0) goto L_0x0434
            r22.zzaD()
        L_0x0434:
            com.google.android.gms.internal.ads.zztp r2 = r1.zzx
            com.google.android.gms.internal.ads.zzto r0 = r1.zzax(r0, r2)
            com.google.android.gms.internal.ads.zzan r2 = r1.zzm
            r3 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zzjh r0 = r1.zzi(r0, r2, r14, r3)
            throw r0
        L_0x0443:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zzV(long, long):void");
    }

    public boolean zzW() {
        return this.zzY;
    }

    public boolean zzX() {
        if (this.zzm == null) {
            return false;
        }
        if (zzS() || zzaS()) {
            return true;
        }
        if (this.zzF == -9223372036854775807L) {
            return false;
        }
        zzh();
        return SystemClock.elapsedRealtime() < this.zzF;
    }

    public final int zzY(zzan zzan) throws zzjh {
        try {
            return zzaa(this.zzd, zzan);
        } catch (zzud e) {
            throw zzi(e, zzan, false, 4002);
        }
    }

    /* access modifiers changed from: protected */
    public float zzZ(float f, zzan zzan, zzan[] zzanArr) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzaA(long j) {
        this.zzab = j;
        while (!this.zzk.isEmpty() && j >= ((zztu) this.zzk.peek()).zzb) {
            zztu zztu = (zztu) this.zzk.poll();
            if (zztu != null) {
                zzaO(zztu);
                zzap();
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaB(zzin zzin) throws zzjh {
    }

    /* access modifiers changed from: protected */
    public void zzaC(zzan zzan) throws zzjh {
    }

    /* access modifiers changed from: protected */
    public final void zzaD() {
        try {
            zztm zztm = this.zzq;
            if (zztm != null) {
                zztm.zzl();
                this.zza.zzb++;
                zztp zztp = this.zzx;
                if (zztp != null) {
                    zzam(zztp.zza);
                } else {
                    throw null;
                }
            }
        } finally {
            this.zzq = null;
            this.zzo = null;
            this.zzad = null;
            zzaF();
        }
    }

    /* access modifiers changed from: protected */
    public void zzaE() {
        zzaM();
        zzaN();
        this.zzF = -9223372036854775807L;
        this.zzT = false;
        this.zzS = false;
        this.zzC = false;
        this.zzD = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzV = -9223372036854775807L;
        this.zzW = -9223372036854775807L;
        this.zzab = -9223372036854775807L;
        this.zzQ = 0;
        this.zzR = 0;
        this.zzP = this.zzO ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public final void zzaF() {
        zzaE();
        this.zzv = null;
        this.zzx = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = false;
        this.zzU = false;
        this.zzu = -1.0f;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        this.zzE = false;
        this.zzO = false;
        this.zzP = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaG() throws zzjh {
        boolean zzaH = zzaH();
        if (zzaH) {
            zzaz();
        }
        return zzaH;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaH() {
        boolean z;
        if (this.zzq == null) {
            return false;
        }
        int i = this.zzR;
        if (i == 3 || ((this.zzz && !this.zzU) || (this.zzA && this.zzT))) {
            zzaD();
            return true;
        }
        if (i == 2) {
            if (zzgd.zza >= 23) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzf(z);
            if (zzgd.zza >= 23) {
                try {
                    zzaP();
                } catch (zzjh e) {
                    zzfk.zzg("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
                    zzaD();
                    return true;
                }
            }
        }
        zzah();
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaI() {
        return this.zzL;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaJ(zzan zzan) {
        return this.zzae == null && zzas(zzan);
    }

    /* access modifiers changed from: protected */
    public boolean zzaK(zztp zztp) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int zzaa(zztx zztx, zzan zzan) throws zzud;

    /* access modifiers changed from: protected */
    public zziy zzab(zztp zztp, zzan zzan, zzan zzan2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009f, code lost:
        if (zzaQ() == false) goto L_0x00c4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zziy zzac(com.google.android.gms.internal.ads.zzlj r12) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r11 = this;
            r0 = 1
            r11.zzZ = r0
            com.google.android.gms.internal.ads.zzan r4 = r12.zza
            r1 = 0
            if (r4 == 0) goto L_0x0101
            java.lang.String r2 = r4.zzn
            r3 = 0
            if (r2 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzsu r12 = r12.zzb
            r11.zzae = r12
            r11.zzm = r4
            boolean r12 = r11.zzL
            if (r12 == 0) goto L_0x001a
            r11.zzN = r0
            return r1
        L_0x001a:
            com.google.android.gms.internal.ads.zztm r12 = r11.zzq
            if (r12 != 0) goto L_0x0024
            r11.zzv = r1
            r11.zzaz()
            return r1
        L_0x0024:
            com.google.android.gms.internal.ads.zztp r2 = r11.zzx
            if (r2 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzan r5 = r11.zzr
            if (r5 == 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzsu r1 = r11.zzad
            com.google.android.gms.internal.ads.zzsu r6 = r11.zzae
            if (r1 != r6) goto L_0x00de
            if (r6 == r1) goto L_0x0036
            r1 = r0
            goto L_0x0037
        L_0x0036:
            r1 = r3
        L_0x0037:
            if (r1 == 0) goto L_0x0043
            int r6 = com.google.android.gms.internal.ads.zzgd.zza
            r7 = 23
            if (r6 < r7) goto L_0x0041
            r6 = r0
            goto L_0x0044
        L_0x0041:
            r6 = r3
            goto L_0x0044
        L_0x0043:
            r6 = r0
        L_0x0044:
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            com.google.android.gms.internal.ads.zziy r6 = r11.zzab(r2, r5, r4)
            int r7 = r6.zzd
            r8 = 3
            r9 = 16
            r10 = 2
            switch(r7) {
                case 0: goto L_0x00b3;
                case 1: goto L_0x008f;
                case 2: goto L_0x005d;
                default: goto L_0x0054;
            }
        L_0x0054:
            boolean r0 = r11.zzaV(r4)
            if (r0 != 0) goto L_0x00b8
            r10 = r9
            goto L_0x00c4
        L_0x005d:
            boolean r7 = r11.zzaV(r4)
            if (r7 != 0) goto L_0x0066
            r10 = r9
            goto L_0x00c4
        L_0x0066:
            r11.zzO = r0
            r11.zzP = r0
            int r7 = r11.zzy
            if (r7 == r10) goto L_0x007f
            if (r7 != r0) goto L_0x007d
            int r7 = r4.zzs
            int r9 = r5.zzs
            if (r7 != r9) goto L_0x007d
            int r7 = r4.zzt
            int r9 = r5.zzt
            if (r7 != r9) goto L_0x007d
            goto L_0x0080
        L_0x007d:
            r0 = r3
            goto L_0x0080
        L_0x007f:
        L_0x0080:
            r11.zzC = r0
            r11.zzr = r4
            if (r1 == 0) goto L_0x008d
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x008d
            goto L_0x00c4
        L_0x008d:
            r10 = r3
            goto L_0x00c4
        L_0x008f:
            boolean r7 = r11.zzaV(r4)
            if (r7 != 0) goto L_0x0097
            r10 = r9
            goto L_0x00c4
        L_0x0097:
            r11.zzr = r4
            if (r1 == 0) goto L_0x00a2
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x00b1
            goto L_0x00c4
        L_0x00a2:
            boolean r1 = r11.zzS
            if (r1 == 0) goto L_0x00b1
            r11.zzQ = r0
            boolean r1 = r11.zzA
            if (r1 == 0) goto L_0x00af
            r11.zzR = r8
            goto L_0x00c4
        L_0x00af:
            r11.zzR = r0
        L_0x00b1:
            r10 = r3
            goto L_0x00c4
        L_0x00b3:
            r11.zzae()
            r10 = r3
            goto L_0x00c4
        L_0x00b8:
            r11.zzr = r4
            if (r1 == 0) goto L_0x00c3
            boolean r0 = r11.zzaQ()
            if (r0 != 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r10 = r3
        L_0x00c4:
            int r0 = r6.zzd
            if (r0 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zztm r0 = r11.zzq
            if (r0 != r12) goto L_0x00d0
            int r12 = r11.zzR
            if (r12 != r8) goto L_0x00dd
        L_0x00d0:
            java.lang.String r2 = r2.zza
            com.google.android.gms.internal.ads.zziy r12 = new com.google.android.gms.internal.ads.zziy
            r0 = 0
            r1 = r12
            r3 = r5
            r5 = r0
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00dd:
            return r6
        L_0x00de:
            r11.zzae()
            java.lang.String r2 = r2.zza
            com.google.android.gms.internal.ads.zziy r12 = new com.google.android.gms.internal.ads.zziy
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r12
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r12
        L_0x00ef:
            throw r1
        L_0x00f1:
            throw r1
        L_0x00f3:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzjh r12 = r11.zzi(r12, r4, r3, r0)
            throw r12
        L_0x0101:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztv.zzac(com.google.android.gms.internal.ads.zzlj):com.google.android.gms.internal.ads.zziy");
    }

    /* access modifiers changed from: protected */
    public abstract zztk zzaf(zztp zztp, zzan zzan, MediaCrypto mediaCrypto, float f);

    /* access modifiers changed from: protected */
    public abstract List zzag(zztx zztx, zzan zzan, boolean z) throws zzud;

    /* access modifiers changed from: protected */
    public void zzaj(zzin zzin) throws zzjh {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzak(Exception exc) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzal(String str, zztk zztk, long j, long j2) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzam(String str) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzan(zzan zzan, MediaFormat mediaFormat) throws zzjh {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzap() {
    }

    /* access modifiers changed from: protected */
    public void zzaq() throws zzjh {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzar(long j, long j2, zztm zztm, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzan zzan) throws zzjh;

    /* access modifiers changed from: protected */
    public boolean zzas(zzan zzan) {
        return false;
    }

    /* access modifiers changed from: protected */
    public int zzat(zzin zzin) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzau() {
        return this.zzaa.zzd;
    }

    /* access modifiers changed from: protected */
    public final long zzav() {
        return this.zzaa.zzc;
    }

    /* access modifiers changed from: protected */
    public final zztm zzaw() {
        return this.zzq;
    }

    /* access modifiers changed from: protected */
    public zzto zzax(Throwable th, zztp zztp) {
        return new zzto(th, zztp);
    }

    /* access modifiers changed from: protected */
    public final zztp zzay() {
        return this.zzx;
    }

    /* access modifiers changed from: protected */
    public final void zzaz() throws zzjh {
        zzan zzan;
        zzan zzan2;
        if (this.zzq == null && !this.zzL && (zzan = this.zzm) != null) {
            if (zzaJ(zzan)) {
                zzad();
                String str = zzan.zzn;
                if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                    this.zzi.zzn(32);
                } else {
                    this.zzi.zzn(1);
                }
                this.zzL = true;
                return;
            }
            this.zzad = this.zzae;
            if (this.zzad != null) {
                zzeq.zzf(true);
                zzsu zzsu = this.zzad;
                boolean z = zzsv.zza;
                zzsu.zza();
            }
            try {
                if (this.zzad != null) {
                    zzeq.zzb(zzan.zzn);
                }
                zzan2 = this.zzm;
                if (zzan2 != null) {
                    if (this.zzv == null) {
                        List zzag = zzag(this.zzd, zzan2, false);
                        zzag.isEmpty();
                        this.zzv = new ArrayDeque();
                        if (!zzag.isEmpty()) {
                            this.zzv.add((zztp) zzag.get(0));
                        }
                        this.zzw = null;
                    }
                    if (!this.zzv.isEmpty()) {
                        ArrayDeque arrayDeque = this.zzv;
                        if (arrayDeque != null) {
                            zztp zztp = (zztp) arrayDeque.peekFirst();
                            while (this.zzq == null) {
                                zztp zztp2 = (zztp) arrayDeque.peekFirst();
                                if (zztp2 == null) {
                                    throw null;
                                } else if (zzaK(zztp2)) {
                                    try {
                                        zzai(zztp2, (MediaCrypto) null);
                                    } catch (Exception e) {
                                        if (zztp2 == zztp) {
                                            zzfk.zzf("MediaCodecRenderer", "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                                            Thread.sleep(50);
                                            zzai(zztp2, (MediaCrypto) null);
                                        } else {
                                            throw e;
                                        }
                                    } catch (Exception e2) {
                                        zzfk.zzg("MediaCodecRenderer", "Failed to initialize decoder: ".concat(zztp2.zza), e2);
                                        arrayDeque.removeFirst();
                                        zztt zztt = new zztt(zzan2, (Throwable) e2, false, zztp2);
                                        zzak(zztt);
                                        zztt zztt2 = this.zzw;
                                        if (zztt2 == null) {
                                            this.zzw = zztt;
                                        } else {
                                            this.zzw = zztt.zza(zztt2, zztt);
                                        }
                                        if (arrayDeque.isEmpty()) {
                                            throw this.zzw;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            }
                            this.zzv = null;
                            return;
                        }
                        throw null;
                    }
                    throw new zztt(zzan2, (Throwable) null, false, -49999);
                }
                throw null;
            } catch (zzud e3) {
                throw new zztt(zzan2, (Throwable) e3, false, -49998);
            } catch (zztt e4) {
                throw zzi(e4, zzan, false, 4001);
            }
        }
    }

    public final int zze() {
        return 8;
    }

    /* access modifiers changed from: protected */
    public void zzw() {
        this.zzm = null;
        zzaO(zztu.zza);
        this.zzk.clear();
        zzaH();
    }

    /* access modifiers changed from: protected */
    public void zzx(boolean z, boolean z2) throws zzjh {
        this.zza = new zzix();
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zzjh {
        this.zzX = false;
        this.zzY = false;
        if (this.zzL) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzM = false;
            this.zzl.zzb();
        } else {
            zzaG();
        }
        zzga zzga = this.zzaa.zze;
        if (zzga.zza() > 0) {
            this.zzZ = true;
        }
        zzga.zze();
        this.zzk.clear();
    }

    private final void zzao() throws zzjh {
        switch (this.zzR) {
            case 1:
                zzah();
                return;
            case 2:
                zzah();
                zzaP();
                return;
            case 3:
                zzaD();
                zzaz();
                return;
            default:
                this.zzY = true;
                zzaq();
                return;
        }
    }
}
