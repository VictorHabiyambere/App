package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzwr implements zzvm, zzadx, zzaaa, zzaaf, zzxd {
    /* access modifiers changed from: private */
    public static final Map zzb;
    /* access modifiers changed from: private */
    public static final zzan zzc;
    /* access modifiers changed from: private */
    public long zzA;
    private boolean zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private int zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private boolean zzJ;
    private int zzK;
    private boolean zzL;
    private boolean zzM;
    private final zzzz zzN;
    private final zzzv zzO;
    private final Uri zzd;
    private final zzhb zze;
    private final zzst zzf;
    private final zzvx zzg;
    private final zzso zzh;
    private final zzwn zzi;
    /* access modifiers changed from: private */
    public final long zzj;
    private final zzaai zzk = new zzaai("ProgressiveMediaPeriod");
    private final zzwg zzl;
    private final zzeu zzm;
    private final Runnable zzn;
    /* access modifiers changed from: private */
    public final Runnable zzo;
    /* access modifiers changed from: private */
    public final Handler zzp;
    private final boolean zzq;
    private zzvl zzr;
    /* access modifiers changed from: private */
    public zzaha zzs;
    private zzxe[] zzt;
    private zzwp[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzwq zzy;
    private zzaet zzz;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(hashMap);
        zzal zzal = new zzal();
        zzal.zzK("icy");
        zzal.zzX("application/x-icy");
        zzc = zzal.zzad();
    }

    public zzwr(Uri uri, zzhb zzhb, zzwg zzwg, zzst zzst, zzso zzso, zzzz zzzz, zzvx zzvx, zzwn zzwn, zzzv zzzv, String str, int i, long j) {
        boolean z;
        this.zzd = uri;
        this.zze = zzhb;
        this.zzf = zzst;
        this.zzh = zzso;
        this.zzN = zzzz;
        this.zzg = zzvx;
        this.zzi = zzwn;
        this.zzO = zzzv;
        this.zzj = (long) i;
        this.zzl = zzwg;
        this.zzA = j;
        if (j != -9223372036854775807L) {
            z = true;
        } else {
            z = false;
        }
        this.zzq = z;
        this.zzm = new zzeu(zzer.zza);
        this.zzn = new zzwi(this);
        this.zzo = new zzwj(this);
        this.zzp = zzgd.zzx((Handler.Callback) null);
        this.zzu = new zzwp[0];
        this.zzt = new zzxe[0];
        this.zzI = -9223372036854775807L;
        this.zzC = 1;
    }

    private final int zzQ() {
        int i = 0;
        for (zzxe zzd2 : this.zzt) {
            i += zzd2.zzd();
        }
        return i;
    }

    /* access modifiers changed from: private */
    public final long zzR(boolean z) {
        int i = 0;
        long j = Long.MIN_VALUE;
        while (true) {
            zzxe[] zzxeArr = this.zzt;
            if (i >= zzxeArr.length) {
                return j;
            }
            if (!z) {
                zzwq zzwq = this.zzy;
                if (zzwq == null) {
                    throw null;
                } else if (!zzwq.zzc[i]) {
                    i++;
                }
            }
            j = Math.max(j, zzxeArr[i].zzh());
            i++;
        }
    }

    private final zzafa zzS(zzwp zzwp) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzwp.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        zzxe zzxe = new zzxe(this.zzO, this.zzf, this.zzh);
        zzxe.zzu(this);
        int i2 = length + 1;
        zzwp[] zzwpArr = (zzwp[]) Arrays.copyOf(this.zzu, i2);
        zzwpArr[length] = zzwp;
        int i3 = zzgd.zza;
        this.zzu = zzwpArr;
        zzxe[] zzxeArr = (zzxe[]) Arrays.copyOf(this.zzt, i2);
        zzxeArr[length] = zzxe;
        this.zzt = zzxeArr;
        return zzxe;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzT() {
        zzeq.zzf(this.zzw);
        if (this.zzy == null) {
            throw null;
        } else if (this.zzz == null) {
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzU() {
        boolean z;
        int i;
        zzcd zzcd;
        if (!this.zzM && !this.zzw && this.zzv && this.zzz != null) {
            zzxe[] zzxeArr = this.zzt;
            int length = zzxeArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (zzxeArr[i2].zzi() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            this.zzm.zzc();
            int length2 = this.zzt.length;
            zzde[] zzdeArr = new zzde[length2];
            boolean[] zArr = new boolean[length2];
            int i3 = 0;
            while (i3 < length2) {
                zzan zzi2 = this.zzt[i3].zzi();
                if (zzi2 != null) {
                    String str = zzi2.zzn;
                    boolean zzg2 = zzcg.zzg(str);
                    if (!zzg2) {
                        z = zzcg.zzh(str);
                    } else {
                        z = true;
                    }
                    zArr[i3] = z;
                    this.zzx = z | this.zzx;
                    zzaha zzaha = this.zzs;
                    if (zzaha != null) {
                        if (zzg2 || this.zzu[i3].zzb) {
                            zzcd zzcd2 = zzi2.zzl;
                            if (zzcd2 == null) {
                                zzcd = new zzcd(-9223372036854775807L, zzaha);
                            } else {
                                zzcd = zzcd2.zzc(zzaha);
                            }
                            zzal zzb2 = zzi2.zzb();
                            zzb2.zzQ(zzcd);
                            zzi2 = zzb2.zzad();
                        }
                        if (zzg2 && zzi2.zzh == -1 && zzi2.zzi == -1 && (i = zzaha.zza) != -1) {
                            zzal zzb3 = zzi2.zzb();
                            zzb3.zzx(i);
                            zzi2 = zzb3.zzad();
                        }
                    }
                    zzdeArr[i3] = new zzde(Integer.toString(i3), zzi2.zzc(this.zzf.zza(zzi2)));
                    i3++;
                } else {
                    throw null;
                }
            }
            this.zzy = new zzwq(new zzxr(zzdeArr), zArr);
            this.zzw = true;
            zzvl zzvl = this.zzr;
            if (zzvl != null) {
                zzvl.zzi(this);
                return;
            }
            throw null;
        }
    }

    private final void zzV(int i) {
        zzT();
        zzwq zzwq = this.zzy;
        boolean[] zArr = zzwq.zzd;
        if (!zArr[i]) {
            zzan zzb2 = zzwq.zza.zzb(i).zzb(0);
            this.zzg.zzc(new zzvk(1, zzcg.zzb(zzb2.zzn), zzb2, 0, (Object) null, zzgd.zzu(this.zzH), -9223372036854775807L));
            zArr[i] = true;
        }
    }

    private final void zzW(int i) {
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (this.zzJ && zArr[i] && !this.zzt[i].zzx(false)) {
            this.zzI = 0;
            this.zzJ = false;
            this.zzE = true;
            this.zzH = 0;
            this.zzK = 0;
            for (zzxe zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            zzvl zzvl = this.zzr;
            if (zzvl != null) {
                zzvl.zzg(this);
                return;
            }
            throw null;
        }
    }

    private final void zzX() {
        zzwm zzwm = new zzwm(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzw) {
            zzeq.zzf(zzY());
            long j = this.zzA;
            if (j == -9223372036854775807L || this.zzI <= j) {
                zzaet zzaet = this.zzz;
                if (zzaet != null) {
                    zzwm.zzf(zzwm, zzaet.zzg(this.zzI).zza.zzc, this.zzI);
                    for (zzxe zzt2 : this.zzt) {
                        zzt2.zzt(this.zzI);
                    }
                    this.zzI = -9223372036854775807L;
                } else {
                    throw null;
                }
            } else {
                this.zzL = true;
                this.zzI = -9223372036854775807L;
                return;
            }
        }
        this.zzK = zzQ();
        long zza = this.zzk.zza(zzwm, this, zzzz.zza(this.zzC));
        zzhh zzd2 = zzwm.zzl;
        this.zzg.zzg(new zzvf(zzwm.zzb, zzd2, zzd2.zza, Collections.emptyMap(), zza, 0, 0), new zzvk(1, -1, (zzan) null, 0, (Object) null, zzgd.zzu(zzwm.zzk), zzgd.zzu(this.zzA)));
    }

    private final boolean zzY() {
        return this.zzI != -9223372036854775807L;
    }

    private final boolean zzZ() {
        return this.zzE || zzY();
    }

    public final void zzD() {
        this.zzv = true;
        this.zzp.post(this.zzn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzF() {
        this.zzG = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzH() throws IOException {
        this.zzk.zzi(zzzz.zza(this.zzC));
    }

    /* access modifiers changed from: package-private */
    public final void zzI(int i) throws IOException {
        this.zzt[i].zzm();
        zzH();
    }

    public final /* bridge */ /* synthetic */ void zzJ(zzaae zzaae, long j, long j2, boolean z) {
        zzwm zzwm = (zzwm) zzaae;
        zzid zze2 = zzwm.zzd;
        zzvf zzvf = new zzvf(zzwm.zzb, zzwm.zzl, zze2.zzh(), zze2.zzi(), j, j2, zze2.zzg());
        long unused = zzwm.zzb;
        long zzc2 = zzwm.zzk;
        long j3 = this.zzA;
        long zzu2 = zzgd.zzu(zzc2);
        long zzu3 = zzgd.zzu(j3);
        zzvk zzvk = r5;
        zzvk zzvk2 = new zzvk(1, -1, (zzan) null, 0, (Object) null, zzu2, zzu3);
        this.zzg.zzd(zzvf, zzvk);
        if (!z) {
            for (zzxe zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
            if (this.zzF > 0) {
                zzvl zzvl = this.zzr;
                if (zzvl != null) {
                    zzvl.zzg(this);
                    return;
                }
                throw null;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzK(zzaae zzaae, long j, long j2) {
        zzaet zzaet;
        if (this.zzA == -9223372036854775807L && (zzaet = this.zzz) != null) {
            boolean zzh2 = zzaet.zzh();
            long zzR = zzR(true);
            long j3 = zzR == Long.MIN_VALUE ? 0 : zzR + 10000;
            this.zzA = j3;
            this.zzi.zza(j3, zzh2, this.zzB);
        }
        zzwm zzwm = (zzwm) zzaae;
        zzid zze2 = zzwm.zzd;
        long zzb2 = zzwm.zzb;
        zzhh zzd2 = zzwm.zzl;
        Uri zzh3 = zze2.zzh();
        Map zzi2 = zze2.zzi();
        long zzg2 = zze2.zzg();
        zzvf zzvf = r4;
        zzvf zzvf2 = new zzvf(zzb2, zzd2, zzh3, zzi2, j, j2, zzg2);
        long unused = zzwm.zzb;
        this.zzg.zze(zzvf, new zzvk(1, -1, (zzan) null, 0, (Object) null, zzgd.zzu(zzwm.zzk), zzgd.zzu(this.zzA)));
        this.zzL = true;
        zzvl zzvl = this.zzr;
        if (zzvl != null) {
            zzvl.zzg(this);
            return;
        }
        throw null;
    }

    public final void zzL() {
        for (zzxe zzo2 : this.zzt) {
            zzo2.zzo();
        }
        this.zzl.zze();
    }

    public final void zzM(zzan zzan) {
        this.zzp.post(this.zzn);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzxe zzn2 : this.zzt) {
                zzn2.zzn();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages((Object) null);
        this.zzr = null;
        this.zzM = true;
    }

    public final void zzO(zzaet zzaet) {
        this.zzp.post(new zzwk(this, zzaet));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(int i) {
        return !zzZ() && this.zzt[i].zzx(this.zzL);
    }

    public final long zza(long j, zzmr zzmr) {
        boolean z;
        long j2 = j;
        zzmr zzmr2 = zzmr;
        zzT();
        if (!this.zzz.zzh()) {
            return 0;
        }
        zzaer zzg2 = this.zzz.zzg(j2);
        zzaeu zzaeu = zzg2.zza;
        zzaeu zzaeu2 = zzg2.zzb;
        long j3 = zzmr2.zzf;
        if (j3 == 0) {
            if (zzmr2.zzg == 0) {
                return j2;
            }
            j3 = 0;
        }
        long j4 = zzaeu.zzb;
        int i = zzgd.zza;
        long j5 = j2 - j3;
        long j6 = zzmr2.zzg;
        long j7 = j2 + j6;
        long j8 = j2 ^ j7;
        long j9 = j6 ^ j7;
        if (((j2 ^ j3) & (j2 ^ j5)) < 0) {
            j5 = Long.MIN_VALUE;
        }
        if ((j8 & j9) < 0) {
            j7 = Long.MAX_VALUE;
        }
        boolean z2 = true;
        if (j5 > j4 || j4 > j7) {
            z = false;
        } else {
            z = true;
        }
        long j10 = zzaeu2.zzb;
        if (j5 > j10 || j10 > j7) {
            z2 = false;
        }
        if (z && z2) {
            if (Math.abs(j4 - j2) > Math.abs(j10 - j2)) {
                return j10;
            }
        } else if (!z) {
            return z2 ? j10 : j5;
        }
        return j4;
    }

    public final long zzb() {
        long j;
        zzT();
        if (this.zzL || this.zzF == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzI;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            j = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzwq zzwq = this.zzy;
                if (zzwq.zzb[i] && zzwq.zzc[i] && !this.zzt[i].zzw()) {
                    j = Math.min(j, this.zzt[i].zzh());
                }
            }
        } else {
            j = Long.MAX_VALUE;
        }
        if (j == Long.MAX_VALUE) {
            j = zzR(false);
        }
        return j == Long.MIN_VALUE ? this.zzH : j;
    }

    public final long zzc() {
        return zzb();
    }

    public final long zzd() {
        if (!this.zzE) {
            return -9223372036854775807L;
        }
        if (!this.zzL && zzQ() <= this.zzK) {
            return -9223372036854775807L;
        }
        this.zzE = false;
        return this.zzH;
    }

    public final long zze(long j) {
        boolean z;
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (true != this.zzz.zzh()) {
            j = 0;
        }
        this.zzE = false;
        this.zzH = j;
        if (zzY()) {
            this.zzI = j;
            return j;
        }
        if (this.zzC != 7) {
            int length = this.zzt.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                zzxe zzxe = this.zzt[i];
                if (this.zzq) {
                    z = zzxe.zzy(zzxe.zza());
                } else {
                    z = zzxe.zzz(j, false);
                }
                if (!z && (zArr[i] || !this.zzx)) {
                    break;
                }
                i++;
            }
        }
        this.zzJ = false;
        this.zzI = j;
        this.zzL = false;
        zzaai zzaai = this.zzk;
        if (zzaai.zzl()) {
            for (zzxe zzk2 : this.zzt) {
                zzk2.zzk();
            }
            this.zzk.zzg();
        } else {
            zzaai.zzh();
            for (zzxe zzp2 : this.zzt) {
                zzp2.zzp(false);
            }
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzzg[] r8, boolean[] r9, com.google.android.gms.internal.ads.zzxf[] r10, boolean[] r11, long r12) {
        /*
            r7 = this;
            r7.zzT()
            com.google.android.gms.internal.ads.zzwq r0 = r7.zzy
            com.google.android.gms.internal.ads.zzxr r1 = r0.zza
            boolean[] r0 = r0.zzc
            int r2 = r7.zzF
            r3 = 0
            r4 = r3
        L_0x000d:
            int r5 = r8.length
            if (r4 >= r5) goto L_0x0035
            r5 = r10[r4]
            if (r5 == 0) goto L_0x0032
            r6 = r8[r4]
            if (r6 == 0) goto L_0x001c
            boolean r6 = r9[r4]
            if (r6 != 0) goto L_0x0032
        L_0x001c:
            com.google.android.gms.internal.ads.zzwo r5 = (com.google.android.gms.internal.ads.zzwo) r5
            int r5 = r5.zzb
            boolean r6 = r0[r5]
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            int r6 = r7.zzF
            int r6 = r6 + -1
            r7.zzF = r6
            r0[r5] = r3
            r5 = 0
            r10[r4] = r5
        L_0x0032:
            int r4 = r4 + 1
            goto L_0x000d
        L_0x0035:
            boolean r9 = r7.zzq
            r4 = 1
            if (r9 != 0) goto L_0x004d
            boolean r9 = r7.zzD
            if (r9 == 0) goto L_0x0042
            if (r2 != 0) goto L_0x004d
            r9 = r4
            goto L_0x004e
        L_0x0042:
            r5 = 0
            int r9 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x004a
            r9 = r4
            goto L_0x004e
        L_0x004a:
            r9 = r3
            r12 = r5
            goto L_0x004e
        L_0x004d:
            r9 = r3
        L_0x004e:
            r2 = r3
        L_0x004f:
            int r5 = r8.length
            if (r2 >= r5) goto L_0x00a8
            r5 = r10[r2]
            if (r5 != 0) goto L_0x00a5
            r5 = r8[r2]
            if (r5 == 0) goto L_0x00a5
            int r6 = r5.zzc()
            if (r6 != r4) goto L_0x0062
            r6 = r4
            goto L_0x0063
        L_0x0062:
            r6 = r3
        L_0x0063:
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            int r6 = r5.zza(r3)
            if (r6 != 0) goto L_0x006e
            r6 = r4
            goto L_0x006f
        L_0x006e:
            r6 = r3
        L_0x006f:
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            com.google.android.gms.internal.ads.zzde r5 = r5.zze()
            int r5 = r1.zza(r5)
            boolean r6 = r0[r5]
            r6 = r6 ^ r4
            com.google.android.gms.internal.ads.zzeq.zzf(r6)
            int r6 = r7.zzF
            int r6 = r6 + r4
            r7.zzF = r6
            r0[r5] = r4
            com.google.android.gms.internal.ads.zzwo r6 = new com.google.android.gms.internal.ads.zzwo
            r6.<init>(r7, r5)
            r10[r2] = r6
            r11[r2] = r4
            if (r9 != 0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzxe[] r9 = r7.zzt
            r9 = r9[r5]
            int r5 = r9.zzb()
            if (r5 == 0) goto L_0x00a4
            boolean r9 = r9.zzz(r12, r4)
            if (r9 != 0) goto L_0x00a4
            r9 = r4
            goto L_0x00a5
        L_0x00a4:
            r9 = r3
        L_0x00a5:
            int r2 = r2 + 1
            goto L_0x004f
        L_0x00a8:
            int r8 = r7.zzF
            if (r8 != 0) goto L_0x00da
            r7.zzJ = r3
            r7.zzE = r3
            com.google.android.gms.internal.ads.zzaai r8 = r7.zzk
            boolean r8 = r8.zzl()
            if (r8 == 0) goto L_0x00cb
            com.google.android.gms.internal.ads.zzxe[] r8 = r7.zzt
            int r9 = r8.length
        L_0x00bb:
            if (r3 >= r9) goto L_0x00c5
            r10 = r8[r3]
            r10.zzk()
            int r3 = r3 + 1
            goto L_0x00bb
        L_0x00c5:
            com.google.android.gms.internal.ads.zzaai r8 = r7.zzk
            r8.zzg()
            goto L_0x00ed
        L_0x00cb:
            com.google.android.gms.internal.ads.zzxe[] r8 = r7.zzt
            int r9 = r8.length
            r10 = r3
        L_0x00cf:
            if (r10 >= r9) goto L_0x00d9
            r11 = r8[r10]
            r11.zzp(r3)
            int r10 = r10 + 1
            goto L_0x00cf
        L_0x00d9:
            goto L_0x00ed
        L_0x00da:
            if (r9 == 0) goto L_0x00ec
            long r12 = r7.zze(r12)
        L_0x00e0:
            int r8 = r10.length
            if (r3 >= r8) goto L_0x00ec
            r8 = r10[r3]
            if (r8 == 0) goto L_0x00e9
            r11[r3] = r4
        L_0x00e9:
            int r3 = r3 + 1
            goto L_0x00e0
        L_0x00ec:
        L_0x00ed:
            r7.zzD = r4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwr.zzf(com.google.android.gms.internal.ads.zzzg[], boolean[], com.google.android.gms.internal.ads.zzxf[], boolean[], long):long");
    }

    /* access modifiers changed from: package-private */
    public final int zzg(int i, zzlj zzlj, zzin zzin, int i2) {
        if (zzZ()) {
            return -3;
        }
        zzV(i);
        int zze2 = this.zzt[i].zze(zzlj, zzin, i2, this.zzL);
        if (zze2 == -3) {
            zzW(i);
        }
        return zze2;
    }

    public final zzxr zzh() {
        zzT();
        return this.zzy.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzi(int i, long j) {
        if (zzZ()) {
            return 0;
        }
        zzV(i);
        zzxe zzxe = this.zzt[i];
        int zzc2 = zzxe.zzc(j, this.zzL);
        zzxe.zzv(zzc2);
        if (zzc2 != 0) {
            return zzc2;
        }
        zzW(i);
        return 0;
    }

    public final void zzj(long j, boolean z) {
        if (!this.zzq) {
            zzT();
            if (!zzY()) {
                boolean[] zArr = this.zzy.zzc;
                int length = this.zzt.length;
                for (int i = 0; i < length; i++) {
                    this.zzt[i].zzj(j, false, zArr[i]);
                }
            }
        }
    }

    public final void zzk() throws IOException {
        zzH();
        if (this.zzL && !this.zzw) {
            throw zzch.zza("Loading finished before preparation is complete.", (Throwable) null);
        }
    }

    public final void zzl(zzvl zzvl, long j) {
        this.zzr = zzvl;
        this.zzm.zze();
        zzX();
    }

    public final void zzm(long j) {
    }

    public final boolean zzo(zzlo zzlo) {
        if (this.zzL) {
            return false;
        }
        zzaai zzaai = this.zzk;
        if (zzaai.zzk() || this.zzJ) {
            return false;
        }
        if (this.zzw && this.zzF == 0) {
            return false;
        }
        boolean zze2 = this.zzm.zze();
        if (zzaai.zzl()) {
            return zze2;
        }
        zzX();
        return true;
    }

    public final boolean zzp() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    public final /* bridge */ /* synthetic */ zzaac zzu(zzaae zzaae, long j, long j2, IOException iOException, int i) {
        long j3;
        zzaac zzaac;
        boolean z;
        zzaet zzaet;
        IOException iOException2 = iOException;
        zzwm zzwm = (zzwm) zzaae;
        zzid zze2 = zzwm.zzd;
        long zzb2 = zzwm.zzb;
        zzhh zzd2 = zzwm.zzl;
        Uri zzh2 = zze2.zzh();
        Map zzi2 = zze2.zzi();
        long zzg2 = zze2.zzg();
        zzvf zzvf = r4;
        zzvf zzvf2 = new zzvf(zzb2, zzd2, zzh2, zzi2, j, j2, zzg2);
        long unused = zzwm.zzk;
        int i2 = zzgd.zza;
        if (!(iOException2 instanceof zzch) && !(iOException2 instanceof FileNotFoundException) && !(iOException2 instanceof zzhu) && !(iOException2 instanceof zzaah)) {
            Throwable th = iOException2;
            while (true) {
                if (th != null) {
                    if ((th instanceof zzhc) && ((zzhc) th).zza == 2008) {
                        j3 = -9223372036854775807L;
                        break;
                    }
                    th = th.getCause();
                } else {
                    j3 = (long) Math.min((i - 1) * 1000, 5000);
                    break;
                }
            }
        } else {
            j3 = -9223372036854775807L;
        }
        if (j3 == -9223372036854775807L) {
            zzaac = zzaai.zzd;
        } else {
            int zzQ = zzQ();
            if (zzQ > this.zzK) {
                z = true;
            } else {
                z = false;
            }
            if (this.zzG || !((zzaet = this.zzz) == null || zzaet.zza() == -9223372036854775807L)) {
                this.zzK = zzQ;
            } else {
                boolean z2 = this.zzw;
                if (!z2 || zzZ()) {
                    this.zzE = z2;
                    this.zzH = 0;
                    this.zzK = 0;
                    for (zzxe zzp2 : this.zzt) {
                        zzp2.zzp(false);
                    }
                    zzwm.zzf(zzwm, 0, 0);
                } else {
                    this.zzJ = true;
                    zzaac = zzaai.zzc;
                }
            }
            zzaac = zzaai.zzb(z, j3);
        }
        boolean z3 = !zzaac.zzc();
        this.zzg.zzf(zzvf, new zzvk(1, -1, (zzan) null, 0, (Object) null, zzgd.zzu(zzwm.zzk), zzgd.zzu(this.zzA)), iOException2, z3);
        if (z3) {
            long unused2 = zzwm.zzb;
        }
        return zzaac;
    }

    /* access modifiers changed from: package-private */
    public final zzafa zzv() {
        return zzS(new zzwp(0, true));
    }

    public final zzafa zzw(int i, int i2) {
        return zzS(new zzwp(i, false));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzE() {
        if (!this.zzM) {
            zzvl zzvl = this.zzr;
            if (zzvl != null) {
                zzvl.zzg(this);
                return;
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(zzaet zzaet) {
        zzaet zzaet2;
        if (this.zzs == null) {
            zzaet2 = zzaet;
        } else {
            zzaet2 = new zzaes(-9223372036854775807L, 0);
        }
        this.zzz = zzaet2;
        if (zzaet.zza() == -9223372036854775807L && this.zzA != -9223372036854775807L) {
            this.zzz = new zzwl(this, this.zzz);
        }
        this.zzA = this.zzz.zza();
        boolean z = false;
        int i = 1;
        if (!this.zzG && zzaet.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzB = z;
        if (true == z) {
            i = 7;
        }
        this.zzC = i;
        this.zzi.zza(this.zzA, zzaet.zzh(), this.zzB);
        if (!this.zzw) {
            zzU();
        }
    }
}
