package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzxe implements zzafa {
    private boolean zzA = true;
    private boolean zzB;
    private zzsu zzC;
    private final zzwy zza;
    private final zzxa zzb = new zzxa();
    private final zzxl zzc = new zzxl(new zzwz());
    private final zzst zzd;
    private final zzso zze;
    private zzxd zzf;
    private zzan zzg;
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private int[] zzk = new int[1000];
    private int[] zzl = new int[1000];
    private long[] zzm = new long[1000];
    private zzaez[] zzn = new zzaez[1000];
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzv;
    private boolean zzw = true;
    private boolean zzx = true;
    private zzan zzy;
    private zzan zzz;

    protected zzxe(zzzv zzzv, zzst zzst, zzso zzso) {
        this.zzd = zzst;
        this.zze = zzso;
        this.zza = new zzwy(zzzv);
    }

    private final int zzA(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.zzm[i] > j ? 1 : (this.zzm[i] == j ? 0 : -1));
            if (i5 > 0) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                i3 = i4;
                if (i5 == 0) {
                    break;
                }
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzB(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzC(com.google.android.gms.internal.ads.zzlj r7, com.google.android.gms.internal.ads.zzin r8, boolean r9, boolean r10, com.google.android.gms.internal.ads.zzxa r11) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            r8.zzd = r0     // Catch:{ all -> 0x008f }
            boolean r0 = r6.zzK()     // Catch:{ all -> 0x008f }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x002f
            if (r10 != 0) goto L_0x0025
            boolean r10 = r6.zzv     // Catch:{ all -> 0x008f }
            if (r10 == 0) goto L_0x0014
            goto L_0x0025
        L_0x0014:
            com.google.android.gms.internal.ads.zzan r8 = r6.zzz     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x0023
            if (r9 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzan r9 = r6.zzg     // Catch:{ all -> 0x008f }
            if (r8 == r9) goto L_0x0023
        L_0x001e:
            r6.zzH(r8, r7)     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r1
        L_0x0023:
            monitor-exit(r6)
            return r2
        L_0x0025:
            r7 = 4
            r8.zzc(r7)     // Catch:{ all -> 0x008f }
            r9 = -9223372036854775808
            r8.zze = r9     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r3
        L_0x002f:
            com.google.android.gms.internal.ads.zzxl r0 = r6.zzc     // Catch:{ all -> 0x008f }
            int r4 = r6.zzp     // Catch:{ all -> 0x008f }
            int r5 = r6.zzr     // Catch:{ all -> 0x008f }
            int r4 = r4 + r5
            java.lang.Object r0 = r0.zza(r4)     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzxc r0 = (com.google.android.gms.internal.ads.zzxc) r0     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzan r0 = r0.zza     // Catch:{ all -> 0x008f }
            if (r9 != 0) goto L_0x008a
            com.google.android.gms.internal.ads.zzan r9 = r6.zzg     // Catch:{ all -> 0x008f }
            if (r0 == r9) goto L_0x0045
            goto L_0x008a
        L_0x0045:
            int r7 = r6.zzr     // Catch:{ all -> 0x008f }
            int r7 = r6.zzB(r7)     // Catch:{ all -> 0x008f }
            boolean r9 = r6.zzL(r7)     // Catch:{ all -> 0x008f }
            if (r9 != 0) goto L_0x0056
            r7 = 1
            r8.zzd = r7     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r2
        L_0x0056:
            int[] r9 = r6.zzl     // Catch:{ all -> 0x008f }
            r9 = r9[r7]     // Catch:{ all -> 0x008f }
            r8.zzc(r9)     // Catch:{ all -> 0x008f }
            int r9 = r6.zzr     // Catch:{ all -> 0x008f }
            int r0 = r6.zzo     // Catch:{ all -> 0x008f }
            int r0 = r0 + -1
            if (r9 != r0) goto L_0x0070
            if (r10 != 0) goto L_0x006b
            boolean r9 = r6.zzv     // Catch:{ all -> 0x008f }
            if (r9 == 0) goto L_0x0070
        L_0x006b:
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            r8.zza(r9)     // Catch:{ all -> 0x008f }
        L_0x0070:
            long[] r9 = r6.zzm     // Catch:{ all -> 0x008f }
            r0 = r9[r7]     // Catch:{ all -> 0x008f }
            r8.zze = r0     // Catch:{ all -> 0x008f }
            int[] r8 = r6.zzk     // Catch:{ all -> 0x008f }
            r8 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zza = r8     // Catch:{ all -> 0x008f }
            long[] r8 = r6.zzj     // Catch:{ all -> 0x008f }
            r9 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zzb = r9     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzaez[] r8 = r6.zzn     // Catch:{ all -> 0x008f }
            r7 = r8[r7]     // Catch:{ all -> 0x008f }
            r11.zzc = r7     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r3
        L_0x008a:
            r6.zzH(r0, r7)     // Catch:{ all -> 0x008f }
            monitor-exit(r6)
            return r1
        L_0x008f:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzC(com.google.android.gms.internal.ads.zzlj, com.google.android.gms.internal.ads.zzin, boolean, boolean, com.google.android.gms.internal.ads.zzxa):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzD(long r8, boolean r10, boolean r11) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r10 = r7.zzo     // Catch:{ all -> 0x002d }
            if (r10 == 0) goto L_0x0029
            long[] r0 = r7.zzm     // Catch:{ all -> 0x002d }
            int r2 = r7.zzq     // Catch:{ all -> 0x002d }
            r3 = r0[r2]     // Catch:{ all -> 0x002d }
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            if (r11 == 0) goto L_0x0018
            int r11 = r7.zzr     // Catch:{ all -> 0x002d }
            if (r11 == r10) goto L_0x0018
            int r10 = r11 + 1
        L_0x0018:
            r3 = r10
            r6 = 0
            r1 = r7
            r4 = r8
            int r8 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x002d }
            r9 = -1
            if (r8 == r9) goto L_0x0029
            long r8 = r7.zzF(r8)     // Catch:{ all -> 0x002d }
            monitor-exit(r7)
            return r8
        L_0x0029:
            monitor-exit(r7)
            r8 = -1
            return r8
        L_0x002d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzD(long, boolean, boolean):long");
    }

    private final synchronized long zzE() {
        int i = this.zzo;
        if (i == 0) {
            return -1;
        }
        return zzF(i);
    }

    private final synchronized void zzG(long j, int i, long j2, int i2, zzaez zzaez) {
        int i3 = this.zzo;
        if (i3 > 0) {
            int zzB2 = zzB(i3 - 1);
            zzeq.zzd(this.zzj[zzB2] + ((long) this.zzk[zzB2]) <= j2);
        }
        this.zzv = (536870912 & i) != 0;
        this.zzu = Math.max(this.zzu, j);
        int zzB3 = zzB(this.zzo);
        this.zzm[zzB3] = j;
        this.zzj[zzB3] = j2;
        this.zzk[zzB3] = i2;
        this.zzl[zzB3] = i;
        this.zzn[zzB3] = zzaez;
        this.zzi[zzB3] = 0;
        if (this.zzc.zzf() || !((zzxc) this.zzc.zzb()).zza.equals(this.zzz)) {
            zzan zzan = this.zzz;
            if (zzan != null) {
                this.zzc.zzc(this.zzp + this.zzo, new zzxc(zzan, zzss.zza, (zzxb) null));
            } else {
                throw null;
            }
        }
        int i4 = this.zzo + 1;
        this.zzo = i4;
        int i5 = this.zzh;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzaez[] zzaezArr = new zzaez[i6];
            int i7 = this.zzq;
            int i8 = i5 - i7;
            System.arraycopy(this.zzj, i7, jArr2, 0, i8);
            System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
            System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
            System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzq, zzaezArr, 0, i8);
            System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
            int i9 = this.zzq;
            System.arraycopy(this.zzj, 0, jArr2, i8, i9);
            System.arraycopy(this.zzm, 0, jArr3, i8, i9);
            System.arraycopy(this.zzl, 0, iArr, i8, i9);
            System.arraycopy(this.zzk, 0, iArr2, i8, i9);
            System.arraycopy(this.zzn, 0, zzaezArr, i8, i9);
            System.arraycopy(this.zzi, 0, jArr, i8, i9);
            this.zzj = jArr2;
            this.zzm = jArr3;
            this.zzl = iArr;
            this.zzk = iArr2;
            this.zzn = zzaezArr;
            this.zzi = jArr;
            this.zzq = 0;
            this.zzh = i6;
        }
    }

    private final void zzH(zzan zzan, zzlj zzlj) {
        zzae zzae;
        zzan zzan2 = this.zzg;
        zzsu zzsu = null;
        if (zzan2 == null) {
            zzae = null;
        } else {
            zzae = zzan2.zzq;
        }
        this.zzg = zzan;
        zzae zzae2 = zzan.zzq;
        zzlj.zza = zzan.zzc(this.zzd.zza(zzan));
        zzlj.zzb = this.zzC;
        if (zzan2 == null || !zzgd.zzG(zzae, zzae2)) {
            if (zzan.zzq != null) {
                zzsu = new zzsu(new zzsm(new zzsw(1), 6001));
            }
            this.zzC = zzsu;
            zzlj.zzb = this.zzC;
        }
    }

    private final void zzI() {
        if (this.zzC != null) {
            this.zzC = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzJ() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzK() {
        return this.zzr != this.zzo;
    }

    private final boolean zzL(int i) {
        if (this.zzC != null) {
            return (this.zzl[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzM(zzan zzan) {
        this.zzx = false;
        if (zzgd.zzG(zzan, this.zzz)) {
            return false;
        }
        if (this.zzc.zzf() || !((zzxc) this.zzc.zzb()).zza.equals(zzan)) {
            this.zzz = zzan;
        } else {
            this.zzz = ((zzxc) this.zzc.zzb()).zza;
        }
        boolean z = this.zzA;
        zzan zzan2 = this.zzz;
        this.zzA = z & zzcg.zzf(zzan2.zzn, zzan2.zzk);
        this.zzB = false;
        return true;
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r9 != -1) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzc(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzr     // Catch:{ all -> 0x0038 }
            int r2 = r8.zzB(r0)     // Catch:{ all -> 0x0038 }
            boolean r1 = r8.zzK()     // Catch:{ all -> 0x0038 }
            r7 = 0
            if (r1 == 0) goto L_0x0036
            long[] r1 = r8.zzm     // Catch:{ all -> 0x0038 }
            r3 = r1[r2]     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0017
            goto L_0x0036
        L_0x0017:
            long r3 = r8.zzu     // Catch:{ all -> 0x0038 }
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0025
            if (r11 != 0) goto L_0x0020
            goto L_0x0025
        L_0x0020:
            int r9 = r8.zzo     // Catch:{ all -> 0x0038 }
            int r9 = r9 - r0
            monitor-exit(r8)
            return r9
        L_0x0025:
            int r11 = r8.zzo     // Catch:{ all -> 0x0038 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0038 }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0035
            return r7
        L_0x0035:
            return r9
        L_0x0036:
            monitor-exit(r8)
            return r7
        L_0x0038:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzc(long, boolean):int");
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r9 != 0) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zze(com.google.android.gms.internal.ads.zzlj r9, com.google.android.gms.internal.ads.zzin r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r5 = r1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r5 = r0
        L_0x0009:
            com.google.android.gms.internal.ads.zzxa r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzC(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L_0x0040
            boolean r9 = r10.zzf()
            if (r9 != 0) goto L_0x003e
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L_0x0035
            if (r9 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzwy r9 = r8.zza
            com.google.android.gms.internal.ads.zzxa r11 = r8.zzb
            r9.zzd(r10, r11)
            r9 = r12
            goto L_0x0041
        L_0x002d:
            com.google.android.gms.internal.ads.zzwy r9 = r8.zza
            com.google.android.gms.internal.ads.zzxa r11 = r8.zzb
            r9.zze(r10, r11)
            goto L_0x0038
        L_0x0035:
            if (r9 == 0) goto L_0x0038
            goto L_0x003e
        L_0x0038:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L_0x003e:
            r9 = r12
            goto L_0x0041
        L_0x0040:
        L_0x0041:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zze(com.google.android.gms.internal.ads.zzlj, com.google.android.gms.internal.ads.zzin, int, boolean):int");
    }

    public final /* synthetic */ int zzf(zzu zzu2, int i, boolean z) {
        return zzaey.zza(this, zzu2, i, z);
    }

    public final int zzg(zzu zzu2, int i, boolean z, int i2) throws IOException {
        return this.zza.zza(zzu2, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzan zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzz;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzD(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzE());
    }

    public final void zzl(zzan zzan) {
        this.zzy = zzan;
        boolean zzM = zzM(zzan);
        zzxd zzxd = this.zzf;
        if (zzxd != null && zzM) {
            zzxd.zzM(zzan);
        }
    }

    public final void zzm() throws IOException {
        zzsu zzsu = this.zzC;
        if (zzsu != null) {
            throw zzsu.zza();
        }
    }

    public final void zzn() {
        zzk();
        zzI();
    }

    public final void zzo() {
        zzp(true);
        zzI();
    }

    public final void zzp(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzz = null;
            this.zzx = true;
            this.zzA = true;
        }
    }

    public final /* synthetic */ void zzq(zzfu zzfu, int i) {
        zzaey.zzb(this, zzfu, i);
    }

    public final void zzr(zzfu zzfu, int i, int i2) {
        this.zza.zzh(zzfu, i);
    }

    public final void zzs(long j, int i, int i2, int i3, zzaez zzaez) {
        if (this.zzw) {
            if ((i & 1) != 0) {
                this.zzw = false;
            } else {
                return;
            }
        }
        if (this.zzA) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzB) {
                    zzfk.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(String.valueOf(this.zzz))));
                    this.zzB = true;
                }
                i |= 1;
            }
        }
        zzG(j, i, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzaez);
    }

    public final void zzt(long j) {
        this.zzs = j;
    }

    public final void zzu(zzxd zzxd) {
        this.zzf = zzxd;
    }

    public final synchronized void zzv(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzeq.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzw() {
        return this.zzv;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzx(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzK()     // Catch:{ all -> 0x003d }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzv     // Catch:{ all -> 0x003d }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzan r4 = r3.zzz     // Catch:{ all -> 0x003d }
            r0 = 0
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzan r2 = r3.zzg     // Catch:{ all -> 0x003d }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = r0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzxl r4 = r3.zzc     // Catch:{ all -> 0x003d }
            int r0 = r3.zzp     // Catch:{ all -> 0x003d }
            int r2 = r3.zzr     // Catch:{ all -> 0x003d }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzxc r4 = (com.google.android.gms.internal.ads.zzxc) r4     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzan r4 = r4.zza     // Catch:{ all -> 0x003d }
            com.google.android.gms.internal.ads.zzan r0 = r3.zzg     // Catch:{ all -> 0x003d }
            if (r4 == r0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            int r4 = r3.zzr     // Catch:{ all -> 0x003d }
            int r4 = r3.zzB(r4)     // Catch:{ all -> 0x003d }
            boolean r4 = r3.zzL(r4)     // Catch:{ all -> 0x003d }
            monitor-exit(r3)
            return r4
        L_0x003d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzx(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzy(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.zzJ()     // Catch:{ all -> 0x001b }
            int r0 = r3.zzp     // Catch:{ all -> 0x001b }
            if (r4 < r0) goto L_0x0018
            int r1 = r3.zzo     // Catch:{ all -> 0x001b }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            r1 = -9223372036854775808
            r3.zzs = r1     // Catch:{ all -> 0x001b }
            int r4 = r4 - r0
            r3.zzr = r4     // Catch:{ all -> 0x001b }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzy(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzz(long r11, boolean r13) {
        /*
            r10 = this;
            monitor-enter(r10)
            r10.zzJ()     // Catch:{ all -> 0x0060 }
            int r0 = r10.zzr     // Catch:{ all -> 0x0060 }
            int r2 = r10.zzB(r0)     // Catch:{ all -> 0x0060 }
            boolean r1 = r10.zzK()     // Catch:{ all -> 0x0060 }
            r7 = 0
            if (r1 == 0) goto L_0x005e
            long[] r1 = r10.zzm     // Catch:{ all -> 0x0060 }
            r3 = r1[r2]     // Catch:{ all -> 0x0060 }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x005e
            long r3 = r10.zzu     // Catch:{ all -> 0x0060 }
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            r8 = 1
            if (r1 <= 0) goto L_0x0023
            if (r13 == 0) goto L_0x005e
            r13 = r8
        L_0x0023:
            boolean r1 = r10.zzA     // Catch:{ all -> 0x0060 }
            r9 = -1
            if (r1 == 0) goto L_0x0047
            int r1 = r10.zzo     // Catch:{ all -> 0x0060 }
            int r1 = r1 - r0
            r0 = r7
        L_0x002c:
            if (r0 >= r1) goto L_0x0042
            long[] r3 = r10.zzm     // Catch:{ all -> 0x0060 }
            r4 = r3[r2]     // Catch:{ all -> 0x0060 }
            int r3 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r3 >= 0) goto L_0x0040
            int r2 = r2 + 1
            int r3 = r10.zzh     // Catch:{ all -> 0x0060 }
            if (r2 != r3) goto L_0x003d
            r2 = r7
        L_0x003d:
            int r0 = r0 + 1
            goto L_0x002c
        L_0x0040:
            r1 = r0
            goto L_0x0052
        L_0x0042:
            if (r13 == 0) goto L_0x0045
            goto L_0x0052
        L_0x0045:
            r1 = r9
            goto L_0x0052
        L_0x0047:
            int r13 = r10.zzo     // Catch:{ all -> 0x0060 }
            int r3 = r13 - r0
            r6 = 1
            r1 = r10
            r4 = r11
            int r1 = r1.zzA(r2, r3, r4, r6)     // Catch:{ all -> 0x0060 }
        L_0x0052:
            if (r1 != r9) goto L_0x0055
            goto L_0x005e
        L_0x0055:
            r10.zzs = r11     // Catch:{ all -> 0x0060 }
            int r11 = r10.zzr     // Catch:{ all -> 0x0060 }
            int r11 = r11 + r1
            r10.zzr = r11     // Catch:{ all -> 0x0060 }
            monitor-exit(r10)
            return r8
        L_0x005e:
            monitor-exit(r10)
            return r7
        L_0x0060:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxe.zzz(long, boolean):boolean");
    }

    private final long zzF(int i) {
        long j = this.zzt;
        long j2 = Long.MIN_VALUE;
        if (i != 0) {
            int zzB2 = zzB(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                j2 = Math.max(j2, this.zzm[zzB2]);
                if ((this.zzl[zzB2] & 1) != 0) {
                    break;
                }
                zzB2--;
                if (zzB2 == -1) {
                    zzB2 = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, j2);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        int i8 = i7 - 1;
        return this.zzj[i8] + ((long) this.zzk[i8]);
    }
}
