package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzqz {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzer zzI;
    private final zzqy zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private zzqx zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqz(zzqy zzqy) {
        this.zza = zzqy;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException e) {
        }
        this.zzb = new long[10];
        this.zzI = zzer.zza;
    }

    private final long zzl() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i = 2;
        if (this.zzx != -9223372036854775807L) {
            AudioTrack audioTrack = this.zzc;
            if (audioTrack == null) {
                throw null;
            } else if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            } else {
                return Math.min(this.zzA, this.zzz + zzgd.zzo(zzgd.zzp(zzgd.zzr(elapsedRealtime) - this.zzx, this.zzi), this.zzf));
            }
        } else {
            if (elapsedRealtime - this.zzr >= 5) {
                AudioTrack audioTrack2 = this.zzc;
                if (audioTrack2 != null) {
                    int playState = audioTrack2.getPlayState();
                    if (playState != 1) {
                        long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
                        long j = 0;
                        if (this.zzg) {
                            if (playState != 2) {
                                i = playState;
                            } else if (playbackHeadPosition == 0) {
                                this.zzu = this.zzs;
                            }
                            playbackHeadPosition += this.zzu;
                            playState = i;
                        }
                        if (zzgd.zza <= 29) {
                            if (playbackHeadPosition != 0) {
                                j = playbackHeadPosition;
                            } else if (this.zzs > 0 && playState == 3) {
                                if (this.zzy == -9223372036854775807L) {
                                    this.zzy = elapsedRealtime;
                                }
                            }
                            this.zzy = -9223372036854775807L;
                            playbackHeadPosition = j;
                        }
                        if (this.zzs > playbackHeadPosition) {
                            this.zzt++;
                        }
                        this.zzs = playbackHeadPosition;
                    }
                    this.zzr = elapsedRealtime;
                } else {
                    throw null;
                }
            }
            return this.zzs + this.zzH + (this.zzt << 32);
        }
    }

    private final long zzm() {
        return zzgd.zzs(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzj = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0255  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(boolean r24) {
        /*
            r23 = this;
            r1 = r23
            android.media.AudioTrack r0 = r1.zzc
            if (r0 == 0) goto L_0x0258
            int r0 = r0.getPlayState()
            r3 = 3
            r4 = 1
            r5 = 0
            r7 = 1000(0x3e8, double:4.94E-321)
            if (r0 != r3) goto L_0x019b
            long r9 = java.lang.System.nanoTime()
            long r9 = r9 / r7
            long r11 = r1.zzl
            long r11 = r9 - r11
            r13 = 30000(0x7530, double:1.4822E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            long r11 = r23.zzm()
            int r0 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x002b
            goto L_0x019b
        L_0x002b:
            long[] r0 = r1.zzb
            int r13 = r1.zzv
            float r14 = r1.zzi
            long r11 = com.google.android.gms.internal.ads.zzgd.zzq(r11, r14)
            long r11 = r11 - r9
            r0[r13] = r11
            int r0 = r1.zzv
            int r0 = r0 + r4
            r11 = 10
            int r0 = r0 % r11
            r1.zzv = r0
            int r0 = r1.zzw
            if (r0 >= r11) goto L_0x0047
            int r0 = r0 + r4
            r1.zzw = r0
        L_0x0047:
            r1.zzl = r9
            r1.zzk = r5
            r0 = 0
        L_0x004c:
            int r11 = r1.zzw
            if (r0 >= r11) goto L_0x0063
            long r12 = r1.zzk
            long[] r14 = r1.zzb
            long r4 = (long) r11
            r16 = r14[r0]
            long r16 = r16 / r4
            long r12 = r12 + r16
            r1.zzk = r12
            int r0 = r0 + 1
            r4 = 1
            r5 = 0
            goto L_0x004c
        L_0x0063:
            boolean r0 = r1.zzg
            if (r0 != 0) goto L_0x019b
            com.google.android.gms.internal.ads.zzqx r0 = r1.zze
            if (r0 == 0) goto L_0x0198
            boolean r4 = r0.zzg(r9)
            java.lang.String r5 = "DefaultAudioSink"
            r11 = 5000000(0x4c4b40, double:2.470328E-317)
            if (r4 != 0) goto L_0x0078
            goto L_0x0133
        L_0x0078:
            long r13 = r0.zzb()
            long r7 = r0.zza()
            long r2 = r23.zzm()
            long r18 = r13 - r9
            long r18 = java.lang.Math.abs(r18)
            int r18 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1))
            java.lang.String r4 = ", "
            if (r18 <= 0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzqy r6 = r1.zza
            com.google.android.gms.internal.ads.zzru r6 = (com.google.android.gms.internal.ads.zzru) r6
            com.google.android.gms.internal.ads.zzrz r6 = r6.zza
            long r11 = r6.zzL()
            r22 = r0
            long r0 = r6.zzM()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r15 = "Spurious audio timestamp (system clock mismatch): "
            r6.append(r15)
            r6.append(r7)
            r6.append(r4)
            r6.append(r13)
            r6.append(r4)
            r6.append(r9)
            r6.append(r4)
            r6.append(r2)
            r6.append(r4)
            r6.append(r11)
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r5, r0)
            r22.zzd()
            goto L_0x0133
        L_0x00d6:
            r22 = r0
            r1 = r23
            int r0 = r1.zzf
            long r11 = com.google.android.gms.internal.ads.zzgd.zzs(r7, r0)
            long r11 = r11 - r2
            long r11 = java.lang.Math.abs(r11)
            r20 = 5000000(0x4c4b40, double:2.470328E-317)
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x0130
            com.google.android.gms.internal.ads.zzqy r0 = r1.zza
            com.google.android.gms.internal.ads.zzru r0 = (com.google.android.gms.internal.ads.zzru) r0
            com.google.android.gms.internal.ads.zzrz r0 = r0.zza
            long r11 = r0.zzL()
            long r0 = r0.zzM()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r15 = "Spurious audio timestamp (frame position mismatch): "
            r6.append(r15)
            r6.append(r7)
            r6.append(r4)
            r6.append(r13)
            r6.append(r4)
            r6.append(r9)
            r6.append(r4)
            r6.append(r2)
            r6.append(r4)
            r6.append(r11)
            r6.append(r4)
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r5, r0)
            r22.zzd()
            goto L_0x0133
        L_0x0130:
            r22.zzc()
        L_0x0133:
            r1 = r23
            boolean r0 = r1.zzp
            if (r0 == 0) goto L_0x019b
            java.lang.reflect.Method r0 = r1.zzm
            if (r0 == 0) goto L_0x019b
            long r2 = r1.zzq
            long r2 = r9 - r2
            r6 = 500000(0x7a120, double:2.47033E-318)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x019b
            android.media.AudioTrack r2 = r1.zzc     // Catch:{ Exception -> 0x0191 }
            if (r2 == 0) goto L_0x018c
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0191 }
            java.lang.Object r0 = r0.invoke(r2, r3)     // Catch:{ Exception -> 0x0191 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ Exception -> 0x0191 }
            int r2 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ Exception -> 0x0191 }
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0191 }
            long r2 = (long) r0     // Catch:{ Exception -> 0x0191 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r6
            long r6 = r1.zzh     // Catch:{ Exception -> 0x0191 }
            long r2 = r2 - r6
            r1.zzn = r2     // Catch:{ Exception -> 0x0191 }
            r6 = 0
            long r2 = java.lang.Math.max(r2, r6)     // Catch:{ Exception -> 0x0191 }
            r1.zzn = r2     // Catch:{ Exception -> 0x0191 }
            r6 = 5000000(0x4c4b40, double:2.470328E-317)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0195
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0191 }
            r0.<init>()     // Catch:{ Exception -> 0x0191 }
            java.lang.String r4 = "Ignoring impossibly large audio latency: "
            r0.append(r4)     // Catch:{ Exception -> 0x0191 }
            r0.append(r2)     // Catch:{ Exception -> 0x0191 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0191 }
            com.google.android.gms.internal.ads.zzfk.zzf(r5, r0)     // Catch:{ Exception -> 0x0191 }
            r2 = 0
            r1.zzn = r2     // Catch:{ Exception -> 0x0191 }
            goto L_0x0195
        L_0x018c:
            r2 = 0
            throw r2     // Catch:{ Exception -> 0x018f }
        L_0x018f:
            r0 = move-exception
            goto L_0x0193
        L_0x0191:
            r0 = move-exception
            r2 = 0
        L_0x0193:
            r1.zzm = r2
        L_0x0195:
            r1.zzq = r9
            goto L_0x019b
        L_0x0198:
            r2 = 0
            throw r2
        L_0x019b:
            long r2 = java.lang.System.nanoTime()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r5
            com.google.android.gms.internal.ads.zzqx r0 = r1.zze
            if (r0 == 0) goto L_0x0255
            boolean r4 = r0.zzf()
            if (r4 == 0) goto L_0x01c4
            long r5 = r0.zza()
            int r7 = r1.zzf
            long r5 = com.google.android.gms.internal.ads.zzgd.zzs(r5, r7)
            long r7 = r0.zzb()
            long r7 = r2 - r7
            float r0 = r1.zzi
            long r7 = com.google.android.gms.internal.ads.zzgd.zzp(r7, r0)
            long r5 = r5 + r7
            goto L_0x01e3
        L_0x01c4:
            int r0 = r1.zzw
            if (r0 != 0) goto L_0x01cd
            long r5 = r23.zzm()
            goto L_0x01d6
        L_0x01cd:
            long r5 = r1.zzk
            long r5 = r5 + r2
            float r0 = r1.zzi
            long r5 = com.google.android.gms.internal.ads.zzgd.zzp(r5, r0)
        L_0x01d6:
            if (r24 != 0) goto L_0x01e2
            long r7 = r1.zzn
            long r5 = r5 - r7
            r7 = 0
            long r5 = java.lang.Math.max(r7, r5)
            goto L_0x01e3
        L_0x01e2:
        L_0x01e3:
            boolean r0 = r1.zzD
            if (r0 == r4) goto L_0x01ef
            long r7 = r1.zzC
            r1.zzF = r7
            long r7 = r1.zzB
            r1.zzE = r7
        L_0x01ef:
            long r7 = r1.zzF
            long r7 = r2 - r7
            r9 = 1000000(0xf4240, double:4.940656E-318)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x020e
            long r11 = r1.zzE
            float r0 = r1.zzi
            long r13 = com.google.android.gms.internal.ads.zzgd.zzp(r7, r0)
            long r11 = r11 + r13
            r13 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r13
            long r7 = r7 / r9
            long r5 = r5 * r7
            long r7 = r13 - r7
            long r7 = r7 * r11
            long r5 = r5 + r7
            long r5 = r5 / r13
            goto L_0x020f
        L_0x020e:
        L_0x020f:
            boolean r0 = r1.zzj
            if (r0 != 0) goto L_0x024e
            long r7 = r1.zzB
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x024e
            r9 = 1
            r1.zzj = r9
            long r7 = r5 - r7
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
            float r0 = r1.zzi
            long r7 = com.google.android.gms.internal.ads.zzgd.zzu(r7)
            long r7 = com.google.android.gms.internal.ads.zzgd.zzq(r7, r0)
            long r7 = com.google.android.gms.internal.ads.zzgd.zzu(r7)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r7
            com.google.android.gms.internal.ads.zzqy r0 = r1.zza
            com.google.android.gms.internal.ads.zzru r0 = (com.google.android.gms.internal.ads.zzru) r0
            com.google.android.gms.internal.ads.zzrz r0 = r0.zza
            com.google.android.gms.internal.ads.zzqs r7 = r0.zzq
            if (r7 == 0) goto L_0x024e
            com.google.android.gms.internal.ads.zzqs r0 = r0.zzq
            com.google.android.gms.internal.ads.zzse r0 = (com.google.android.gms.internal.ads.zzse) r0
            com.google.android.gms.internal.ads.zzsf r0 = r0.zza
            com.google.android.gms.internal.ads.zzqn r0 = r0.zzc
            r0.zzv(r9)
        L_0x024e:
            r1.zzC = r2
            r1.zzB = r5
            r1.zzD = r4
            return r5
        L_0x0255:
            r2 = 0
            throw r2
        L_0x0258:
            r2 = 0
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqz.zza(boolean):long");
    }

    public final void zzb(long j) {
        this.zzz = zzl();
        this.zzx = zzgd.zzr(SystemClock.elapsedRealtime());
        this.zzA = j;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r7
            com.google.android.gms.internal.ads.zzqx r0 = new com.google.android.gms.internal.ads.zzqx
            r0.<init>(r3)
            r2.zze = r0
            int r3 = r3.getSampleRate()
            r2.zzf = r3
            r3 = 0
            if (r4 == 0) goto L_0x0024
            int r4 = com.google.android.gms.internal.ads.zzgd.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0024
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0023
            r4 = 6
            if (r5 != r4) goto L_0x0024
            r5 = r4
            goto L_0x0025
        L_0x0023:
            goto L_0x0025
        L_0x0024:
            r0 = r3
        L_0x0025:
            r2.zzg = r0
            boolean r4 = com.google.android.gms.internal.ads.zzgd.zzK(r5)
            r2.zzp = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003d
            int r7 = r7 / r6
            long r4 = (long) r7
            int r6 = r2.zzf
            long r4 = com.google.android.gms.internal.ads.zzgd.zzs(r4, r6)
            goto L_0x003e
        L_0x003d:
            r4 = r0
        L_0x003e:
            r2.zzh = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzG = r3
            r2.zzH = r4
            r2.zzu = r4
            r2.zzo = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzq = r4
            r2.zzn = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqz.zzd(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final void zze(zzer zzer) {
        this.zzI = zzer;
    }

    public final void zzf() {
        if (this.zzx != -9223372036854775807L) {
            this.zzx = zzgd.zzr(SystemClock.elapsedRealtime());
        }
        zzqx zzqx = this.zze;
        if (zzqx != null) {
            zzqx.zze();
            return;
        }
        throw null;
    }

    public final boolean zzg(long j) {
        if (j > zzgd.zzo(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            if (audioTrack == null) {
                throw null;
            } else if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack == null) {
            throw null;
        } else if (audioTrack.getPlayState() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean zzi(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        if (audioTrack != null) {
            int playState = audioTrack.getPlayState();
            if (this.zzg) {
                if (playState == 2) {
                    this.zzo = false;
                    return false;
                } else if (playState == 1) {
                    if (zzl() == 0) {
                        return false;
                    }
                    playState = 1;
                }
            }
            boolean z = this.zzo;
            boolean zzg2 = zzg(j);
            this.zzo = zzg2;
            if (z && !zzg2 && playState != 1) {
                zzqy zzqy = this.zza;
                int i = this.zzd;
                long zzu2 = zzgd.zzu(this.zzh);
                zzru zzru = (zzru) zzqy;
                zzrz zzrz = zzru.zza;
                if (zzrz.zzq != null) {
                    ((zzse) zzru.zza.zzq).zza.zzc.zzx(i, zzu2, SystemClock.elapsedRealtime() - zzrz.zzW);
                }
            }
            return true;
        }
        throw null;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx == -9223372036854775807L) {
            zzqx zzqx = this.zze;
            if (zzqx != null) {
                zzqx.zze();
                return true;
            }
            throw null;
        }
        this.zzz = zzl();
        return false;
    }
}
