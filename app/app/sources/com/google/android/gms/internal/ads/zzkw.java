package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzkw extends zzm implements zzjr {
    public static final /* synthetic */ int zzd = 0;
    private final zzmw zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzmr zzG;
    private zzcp zzH;
    private zzca zzI;
    private zzca zzJ;
    /* access modifiers changed from: private */
    public zzan zzK;
    /* access modifiers changed from: private */
    public zzan zzL;
    /* access modifiers changed from: private */
    public Object zzM;
    private Surface zzN;
    private int zzO;
    private zzfv zzP;
    /* access modifiers changed from: private */
    public zzix zzQ;
    /* access modifiers changed from: private */
    public zzix zzR;
    private int zzS;
    private zzk zzT;
    private float zzU;
    /* access modifiers changed from: private */
    public boolean zzV;
    private zzek zzW;
    private boolean zzX;
    private boolean zzY;
    private zzaa zzZ;
    /* access modifiers changed from: private */
    public zzdv zzaa;
    private zzca zzab;
    private zzmg zzac;
    private int zzad;
    private long zzae;
    private final zzjs zzaf;
    private zzxi zzag;
    final zzzn zzb;
    final zzcp zzc;
    private final zzeu zze = new zzeu(zzer.zza);
    private final Context zzf;
    private final zzct zzg;
    private final zzmn[] zzh;
    private final zzzm zzi;
    private final zzfb zzj;
    private final zzlh zzk;
    /* access modifiers changed from: private */
    public final zzfh zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzcz zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzvn zzq;
    /* access modifiers changed from: private */
    public final zzmx zzr;
    private final Looper zzs;
    private final zzzu zzt;
    private final zzer zzu;
    private final zzks zzv;
    private final zzku zzw;
    private final zzir zzx;
    private final zziv zzy;
    private final zzmv zzz;

    static {
        zzbv.zzb("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r2v6, types: [com.google.android.gms.internal.ads.zzmx, java.lang.Object] */
    public zzkw(zzjq zzjq, zzct zzct) {
        zzpj zzpj;
        zzjq zzjq2 = zzjq;
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzgd.zze;
            zzfk.zze("ExoPlayerImpl", "Init " + hexString + " [AndroidXMedia3/1.4.0-alpha01] [" + str + "]");
            this.zzf = zzjq2.zza.getApplicationContext();
            this.zzr = zzjq2.zzh.apply(zzjq2.zzb);
            this.zzT = zzjq2.zzj;
            this.zzO = zzjq2.zzk;
            this.zzV = false;
            this.zzB = zzjq2.zzo;
            this.zzv = new zzks(this, (zzkr) null);
            this.zzw = new zzku((zzkt) null);
            Handler handler = new Handler(zzjq2.zzi);
            zzcgn zzcgn = ((zzjj) zzjq2.zzc).zza;
            zzks zzks = this.zzv;
            this.zzh = zzcgn.zza(handler, zzks, zzks, zzks, zzks);
            int length = this.zzh.length;
            this.zzi = (zzzm) zzjq2.zze.zza();
            this.zzq = zzjq.zza(((zzjk) zzjq2.zzd).zza);
            this.zzt = zzzy.zzg(((zzjn) zzjq2.zzg).zza);
            this.zzp = zzjq2.zzl;
            this.zzG = zzjq2.zzm;
            this.zzs = zzjq2.zzi;
            this.zzu = zzjq2.zzb;
            this.zzg = zzct;
            this.zzl = new zzfh(this.zzs, this.zzu, new zzkm(this));
            this.zzm = new CopyOnWriteArraySet();
            this.zzo = new ArrayList();
            this.zzag = new zzxi(0);
            int length2 = this.zzh.length;
            this.zzb = new zzzn(new zzmq[2], new zzzg[2], zzdp.zza, (Object) null);
            this.zzn = new zzcz();
            zzcn zzcn = new zzcn();
            zzcn.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            this.zzi.zzn();
            zzcn.zzd(29, true);
            zzcn.zzd(23, false);
            zzcn.zzd(25, false);
            zzcn.zzd(33, false);
            zzcn.zzd(26, false);
            zzcn.zzd(34, false);
            this.zzc = zzcn.zze();
            zzcn zzcn2 = new zzcn();
            zzcn2.zzb(this.zzc);
            zzcn2.zza(4);
            zzcn2.zza(10);
            this.zzH = zzcn2.zze();
            this.zzj = this.zzu.zzb(this.zzs, (Handler.Callback) null);
            this.zzaf = new zzjs(this);
            this.zzac = zzmg.zzg(this.zzb);
            this.zzr.zzR(this.zzg, this.zzs);
            if (zzgd.zza < 31) {
                zzpj = new zzpj(zzjq2.zzr);
            } else {
                zzpj = zzkn.zza(this.zzf, this, zzjq2.zzp, zzjq2.zzr);
            }
            Handler handler2 = handler;
            this.zzk = new zzlh(this.zzh, this.zzi, this.zzb, (zzlk) zzjq2.zzf.zza(), this.zzt, 0, false, this.zzr, this.zzG, zzjq2.zzs, zzjq2.zzn, false, this.zzs, this.zzu, this.zzaf, zzpj, (Looper) null);
            this.zzU = 1.0f;
            this.zzI = zzca.zza;
            zzca zzca = zzca.zza;
            this.zzJ = zzca;
            this.zzab = zzca;
            int i = -1;
            this.zzad = -1;
            AudioManager audioManager = (AudioManager) this.zzf.getSystemService("audio");
            if (audioManager != null) {
                i = audioManager.generateAudioSessionId();
            }
            this.zzS = i;
            this.zzW = zzek.zza;
            this.zzX = true;
            zzmx zzmx = this.zzr;
            zzfh zzfh = this.zzl;
            if (zzmx != null) {
                zzfh.zzb(zzmx);
                this.zzt.zze(new Handler(this.zzs), this.zzr);
                this.zzm.add(this.zzv);
                Handler handler3 = handler2;
                this.zzx = new zzir(zzjq2.zza, handler3, this.zzv);
                this.zzy = new zziv(zzjq2.zza, handler3, this.zzv);
                zzgd.zzG((Object) null, (Object) null);
                this.zzz = new zzmv(zzjq2.zza);
                this.zzA = new zzmw(zzjq2.zza);
                this.zzZ = new zzy(0).zza();
                this.zzaa = zzdv.zza;
                this.zzP = zzfv.zza;
                this.zzi.zzk(this.zzT);
                zzag(1, 10, Integer.valueOf(this.zzS));
                zzag(2, 10, Integer.valueOf(this.zzS));
                zzag(1, 3, this.zzT);
                zzag(2, 4, Integer.valueOf(this.zzO));
                zzag(2, 5, 0);
                zzag(1, 9, Boolean.valueOf(this.zzV));
                zzag(2, 7, this.zzw);
                zzag(6, 8, this.zzw);
                return;
            }
            throw null;
        } finally {
            this.zze.zze();
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzkw zzkw, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkw.zzai(surface);
        zzkw.zzN = surface;
    }

    private final int zzW(zzmg zzmg) {
        if (zzmg.zza.zzo()) {
            return this.zzad;
        }
        return zzmg.zza.zzn(zzmg.zzb.zza, this.zzn).zzd;
    }

    /* access modifiers changed from: private */
    public static int zzX(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long zzY(zzmg zzmg) {
        if (!zzmg.zzb.zzb()) {
            return zzgd.zzu(zzZ(zzmg));
        }
        zzmg.zza.zzn(zzmg.zzb.zza, this.zzn);
        if (zzmg.zzc == -9223372036854775807L) {
            long j = zzmg.zza.zze(zzW(zzmg), this.zza, 0).zzn;
            return zzgd.zzu(0);
        }
        int i = zzgd.zza;
        return zzgd.zzu(0) + zzgd.zzu(zzmg.zzc);
    }

    private final long zzZ(zzmg zzmg) {
        if (zzmg.zza.zzo()) {
            return zzgd.zzr(this.zzae);
        }
        boolean z = zzmg.zzo;
        long j = zzmg.zzr;
        if (zzmg.zzb.zzb()) {
            return j;
        }
        zzab(zzmg.zza, zzmg.zzb, j);
        return j;
    }

    private static long zzaa(zzmg zzmg) {
        zzdb zzdb = new zzdb();
        zzcz zzcz = new zzcz();
        zzmg.zza.zzn(zzmg.zzb.zza, zzcz);
        long j = zzmg.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzmg.zza.zze(zzcz.zzd, zzdb, 0).zzn;
        return 0;
    }

    private final long zzab(zzdc zzdc, zzvo zzvo, long j) {
        zzdc.zzn(zzvo.zza, this.zzn);
        return j;
    }

    private final Pair zzac(zzdc zzdc, int i, long j) {
        int i2;
        if (zzdc.zzo()) {
            this.zzad = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzae = j;
            return null;
        }
        if (i == -1 || i >= zzdc.zzc()) {
            int zzg2 = zzdc.zzg(false);
            long j2 = zzdc.zze(zzg2, this.zza, 0).zzn;
            j = zzgd.zzu(0);
            i2 = zzg2;
        } else {
            i2 = i;
        }
        return zzdc.zzl(this.zza, this.zzn, i2, zzgd.zzr(j));
    }

    private final zzmg zzad(zzmg zzmg, zzdc zzdc, Pair pair) {
        boolean z;
        long j;
        zzvo zzvo;
        zzxr zzxr;
        zzzn zzzn;
        zzgbc zzgbc;
        long j2;
        zzdc zzdc2 = zzdc;
        Pair pair2 = pair;
        if (!zzdc.zzo()) {
            z = pair2 != null;
        } else {
            z = true;
        }
        zzeq.zzd(z);
        zzdc zzdc3 = zzmg.zza;
        long zzY2 = zzY(zzmg);
        zzmg zzf2 = zzmg.zzf(zzdc);
        if (zzdc.zzo()) {
            zzvo zzh2 = zzmg.zzh();
            long zzr2 = zzgd.zzr(this.zzae);
            zzmg zza = zzf2.zzb(zzh2, zzr2, zzr2, zzr2, 0, zzxr.zza, this.zzb, zzgbc.zzm()).zza(zzh2);
            zza.zzp = zza.zzr;
            return zza;
        }
        Object obj = zzf2.zzb.zza;
        int i = zzgd.zza;
        boolean z2 = !obj.equals(pair2.first);
        zzvo zzvo2 = z2 ? new zzvo(pair2.first, -1) : zzf2.zzb;
        long longValue = ((Long) pair2.second).longValue();
        long zzr3 = zzgd.zzr(zzY2);
        if (!zzdc3.zzo()) {
            zzdc3.zzn(obj, this.zzn);
        }
        if (!z2) {
            int i2 = (longValue > zzr3 ? 1 : (longValue == zzr3 ? 0 : -1));
            if (i2 < 0) {
                j = longValue;
                zzvo = zzvo2;
            } else if (i2 == 0) {
                int zza2 = zzdc2.zza(zzf2.zzk.zza);
                if (zza2 != -1 && zzdc2.zzd(zza2, this.zzn, false).zzd == zzdc2.zzn(zzvo2.zza, this.zzn).zzd) {
                    return zzf2;
                }
                zzdc2.zzn(zzvo2.zza, this.zzn);
                if (zzvo2.zzb()) {
                    j2 = this.zzn.zzh(zzvo2.zzb, zzvo2.zzc);
                } else {
                    j2 = this.zzn.zze;
                }
                zzmg zza3 = zzf2.zzb(zzvo2, zzf2.zzr, zzf2.zzr, zzf2.zzd, j2 - zzf2.zzr, zzf2.zzh, zzf2.zzi, zzf2.zzj).zza(zzvo2);
                zza3.zzp = j2;
                return zza3;
            } else {
                zzvo zzvo3 = zzvo2;
                zzeq.zzf(!zzvo3.zzb());
                long max = Math.max(0, zzf2.zzq - (longValue - zzr3));
                long j3 = zzf2.zzp;
                if (zzf2.zzk.equals(zzf2.zzb)) {
                    j3 = longValue + max;
                }
                zzmg zzb2 = zzf2.zzb(zzvo3, longValue, longValue, longValue, max, zzf2.zzh, zzf2.zzi, zzf2.zzj);
                zzb2.zzp = j3;
                return zzb2;
            }
        } else {
            j = longValue;
            zzvo = zzvo2;
        }
        zzeq.zzf(!zzvo.zzb());
        if (z2) {
            zzxr = zzxr.zza;
        } else {
            zzxr = zzf2.zzh;
        }
        if (z2) {
            zzzn = this.zzb;
        } else {
            zzzn = zzf2.zzi;
        }
        if (z2) {
            zzgbc = zzgbc.zzm();
        } else {
            zzgbc = zzf2.zzj;
        }
        zzmg zza4 = zzf2.zzb(zzvo, j, j, j, 0, zzxr, zzzn, zzgbc).zza(zzvo);
        zza4.zzp = j;
        return zza4;
    }

    private final zzmj zzae(zzmi zzmi) {
        int zzW2 = zzW(this.zzac);
        zzdc zzdc = this.zzac.zza;
        if (zzW2 == -1) {
            zzW2 = 0;
        }
        zzer zzer = this.zzu;
        zzlh zzlh = this.zzk;
        return new zzmj(zzlh, zzmi, zzdc, zzW2, zzer, zzlh.zzb());
    }

    /* access modifiers changed from: private */
    public final void zzaf(int i, int i2) {
        if (i != this.zzP.zzb() || i2 != this.zzP.zza()) {
            this.zzP = new zzfv(i, i2);
            zzfh zzfh = this.zzl;
            zzfh.zzd(24, new zzkj(i, i2));
            zzfh.zzc();
            zzag(2, 14, new zzfv(i, i2));
        }
    }

    private final void zzag(int i, int i2, Object obj) {
        zzmn[] zzmnArr = this.zzh;
        int length = zzmnArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzmn zzmn = zzmnArr[i3];
            if (zzmn.zzb() == i) {
                zzmj zzae2 = zzae(zzmn);
                zzae2.zzf(i2);
                zzae2.zze(obj);
                zzae2.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzah() {
        zzag(1, 2, Float.valueOf(this.zzU * this.zzy.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzai(Object obj) {
        ArrayList<zzmj> arrayList = new ArrayList<>();
        zzmn[] zzmnArr = this.zzh;
        int length = zzmnArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            zzmn zzmn = zzmnArr[i];
            if (zzmn.zzb() == 2) {
                zzmj zzae2 = zzae(zzmn);
                zzae2.zzf(1);
                zzae2.zze(obj);
                zzae2.zzd();
                arrayList.add(zzae2);
            }
        }
        Object obj2 = this.zzM;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (zzmj zzi2 : arrayList) {
                    zzi2.zzi(this.zzB);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException e2) {
                z = true;
            }
            Object obj3 = this.zzM;
            Surface surface = this.zzN;
            if (obj3 == surface) {
                surface.release();
                this.zzN = null;
            }
        }
        this.zzM = obj;
        if (z) {
            zzaj(zzjh.zzd(new zzli(3), PointerIconCompat.TYPE_HELP));
        }
    }

    private final void zzaj(zzjh zzjh) {
        zzmg zzmg;
        zzmg zzmg2 = this.zzac;
        zzmg zza = zzmg2.zza(zzmg2.zzb);
        zza.zzp = zza.zzr;
        zza.zzq = 0;
        zzmg zze2 = zza.zze(1);
        if (zzjh != null) {
            zzmg = zze2.zzd(zzjh);
        } else {
            zzmg = zze2;
        }
        this.zzC++;
        this.zzk.zzo();
        zzal(zzmg, 0, 1, false, 5, -9223372036854775807L, -1, false);
    }

    /* access modifiers changed from: private */
    public final void zzak(boolean z, int i, int i2) {
        boolean z2;
        int i3 = 0;
        if (!z || i == -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 && i != 1) {
            i3 = 1;
        }
        zzmg zzmg = this.zzac;
        if (zzmg.zzl != z2 || zzmg.zzm != i3) {
            this.zzC++;
            boolean z3 = zzmg.zzo;
            zzmg zzc2 = zzmg.zzc(z2, i3);
            this.zzk.zzn(z2, i3);
            zzal(zzc2, 0, i2, false, 5, -9223372036854775807L, -1, false);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzal(com.google.android.gms.internal.ads.zzmg r44, int r45, int r46, boolean r47, int r48, long r49, int r51, boolean r52) {
        /*
            r43 = this;
            r0 = r43
            r1 = r44
            r2 = r48
            com.google.android.gms.internal.ads.zzmg r3 = r0.zzac
            r0.zzac = r1
            com.google.android.gms.internal.ads.zzdc r4 = r3.zza
            com.google.android.gms.internal.ads.zzdc r5 = r1.zza
            boolean r4 = r4.equals(r5)
            r5 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r5)
            r4 = r4 ^ r5
            com.google.android.gms.internal.ads.zzdc r7 = r3.zza
            com.google.android.gms.internal.ads.zzdc r8 = r1.zza
            boolean r9 = r8.zzo()
            r11 = 3
            r12 = -1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)
            r14 = 0
            r10 = 0
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r10)
            if (r9 == 0) goto L_0x003e
            boolean r9 = r7.zzo()
            if (r9 == 0) goto L_0x003e
            android.util.Pair r6 = new android.util.Pair
            r6.<init>(r12, r13)
            r7 = r47
            goto L_0x00dd
        L_0x003e:
            boolean r9 = r8.zzo()
            boolean r10 = r7.zzo()
            if (r9 == r10) goto L_0x0056
            android.util.Pair r7 = new android.util.Pair
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)
            r7.<init>(r6, r8)
            r6 = r7
            r7 = r47
            goto L_0x00dd
        L_0x0056:
            com.google.android.gms.internal.ads.zzvo r9 = r3.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzcz r10 = r0.zzn
            com.google.android.gms.internal.ads.zzcz r9 = r7.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzdb r10 = r0.zza
            com.google.android.gms.internal.ads.zzdb r7 = r7.zze(r9, r10, r14)
            java.lang.Object r7 = r7.zzc
            com.google.android.gms.internal.ads.zzvo r9 = r1.zzb
            java.lang.Object r9 = r9.zza
            com.google.android.gms.internal.ads.zzcz r10 = r0.zzn
            com.google.android.gms.internal.ads.zzcz r9 = r8.zzn(r9, r10)
            int r9 = r9.zzd
            com.google.android.gms.internal.ads.zzdb r10 = r0.zza
            com.google.android.gms.internal.ads.zzdb r8 = r8.zze(r9, r10, r14)
            java.lang.Object r8 = r8.zzc
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x00ac
            if (r47 == 0) goto L_0x008f
            if (r2 != 0) goto L_0x008c
            r7 = r5
            r8 = r7
            r2 = 0
            goto L_0x009b
        L_0x008c:
            r7 = r5
            r8 = r7
            goto L_0x0091
        L_0x008f:
            r7 = 0
            r8 = 0
        L_0x0091:
            if (r7 == 0) goto L_0x0098
            if (r2 != r5) goto L_0x0098
            r7 = r8
            r8 = 2
            goto L_0x009b
        L_0x0098:
            if (r4 == 0) goto L_0x00a6
            r8 = r11
        L_0x009b:
            android.util.Pair r9 = new android.util.Pair
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.<init>(r6, r8)
            r6 = r9
            goto L_0x00dd
        L_0x00a6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00ac:
            if (r47 == 0) goto L_0x00d0
            if (r2 != 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzvo r2 = r3.zzb
            long r7 = r2.zzd
            com.google.android.gms.internal.ads.zzvo r2 = r1.zzb
            long r9 = r2.zzd
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ca
            android.util.Pair r2 = new android.util.Pair
            r7 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            r2.<init>(r6, r8)
            r6 = r2
            r7 = r5
            r2 = 0
            goto L_0x00dd
        L_0x00ca:
            r2 = r5
            r6 = 0
            goto L_0x00d2
        L_0x00cd:
            r6 = r2
            r2 = r5
            goto L_0x00d2
        L_0x00d0:
            r6 = r2
            r2 = 0
        L_0x00d2:
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r12, r13)
            r42 = r7
            r7 = r2
            r2 = r6
            r6 = r42
        L_0x00dd:
            java.lang.Object r8 = r6.first
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            java.lang.Object r6 = r6.second
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r8 == 0) goto L_0x0116
            com.google.android.gms.internal.ads.zzdc r10 = r1.zza
            boolean r10 = r10.zzo()
            if (r10 != 0) goto L_0x0110
            com.google.android.gms.internal.ads.zzdc r10 = r1.zza
            com.google.android.gms.internal.ads.zzvo r12 = r1.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzcz r13 = r0.zzn
            com.google.android.gms.internal.ads.zzcz r10 = r10.zzn(r12, r13)
            int r10 = r10.zzd
            com.google.android.gms.internal.ads.zzdc r12 = r1.zza
            com.google.android.gms.internal.ads.zzdb r13 = r0.zza
            com.google.android.gms.internal.ads.zzdb r10 = r12.zze(r10, r13, r14)
            com.google.android.gms.internal.ads.zzbu r10 = r10.zze
            goto L_0x0111
        L_0x0110:
            r10 = 0
        L_0x0111:
            com.google.android.gms.internal.ads.zzca r12 = com.google.android.gms.internal.ads.zzca.zza
            r0.zzab = r12
            goto L_0x0117
        L_0x0116:
            r10 = 0
        L_0x0117:
            if (r8 != 0) goto L_0x0123
            java.util.List r12 = r3.zzj
            java.util.List r13 = r1.zzj
            boolean r12 = r12.equals(r13)
            if (r12 != 0) goto L_0x0158
        L_0x0123:
            com.google.android.gms.internal.ads.zzca r12 = r0.zzab
            com.google.android.gms.internal.ads.zzby r12 = r12.zza()
            java.util.List r13 = r1.zzj
            r9 = 0
        L_0x012c:
            int r11 = r13.size()
            if (r9 >= r11) goto L_0x0152
            java.lang.Object r11 = r13.get(r9)
            com.google.android.gms.internal.ads.zzcd r11 = (com.google.android.gms.internal.ads.zzcd) r11
            r5 = 0
        L_0x0139:
            int r14 = r11.zza()
            if (r5 >= r14) goto L_0x014b
            com.google.android.gms.internal.ads.zzcc r14 = r11.zzb(r5)
            r14.zza(r12)
            int r5 = r5 + 1
            r14 = 0
            goto L_0x0139
        L_0x014b:
            int r9 = r9 + 1
            r5 = 1
            r11 = 3
            r14 = 0
            goto L_0x012c
        L_0x0152:
            com.google.android.gms.internal.ads.zzca r5 = r12.zzu()
            r0.zzab = r5
        L_0x0158:
            com.google.android.gms.internal.ads.zzdc r5 = r43.zzn()
            boolean r9 = r5.zzo()
            if (r9 == 0) goto L_0x0165
            com.google.android.gms.internal.ads.zzca r5 = r0.zzab
            goto L_0x0182
        L_0x0165:
            int r9 = r43.zzd()
            com.google.android.gms.internal.ads.zzdb r11 = r0.zza
            r12 = 0
            com.google.android.gms.internal.ads.zzdb r5 = r5.zze(r9, r11, r12)
            com.google.android.gms.internal.ads.zzbu r5 = r5.zze
            com.google.android.gms.internal.ads.zzca r9 = r0.zzab
            com.google.android.gms.internal.ads.zzby r9 = r9.zza()
            com.google.android.gms.internal.ads.zzca r5 = r5.zzg
            r9.zzb(r5)
            com.google.android.gms.internal.ads.zzca r5 = r9.zzu()
        L_0x0182:
            com.google.android.gms.internal.ads.zzca r9 = r0.zzI
            boolean r9 = r5.equals(r9)
            r11 = 1
            r9 = r9 ^ r11
            r0.zzI = r5
            boolean r5 = r3.zzl
            boolean r11 = r1.zzl
            if (r5 == r11) goto L_0x0194
            r5 = 1
            goto L_0x0195
        L_0x0194:
            r5 = 0
        L_0x0195:
            int r11 = r3.zze
            int r12 = r1.zze
            if (r11 == r12) goto L_0x019d
            r11 = 1
            goto L_0x019e
        L_0x019d:
            r11 = 0
        L_0x019e:
            if (r11 != 0) goto L_0x01a2
            if (r5 == 0) goto L_0x01a5
        L_0x01a2:
            r43.zzam()
        L_0x01a5:
            boolean r12 = r3.zzg
            boolean r13 = r1.zzg
            if (r12 == r13) goto L_0x01ad
            r12 = 1
            goto L_0x01ae
        L_0x01ad:
            r12 = 0
        L_0x01ae:
            if (r4 == 0) goto L_0x01bd
            com.google.android.gms.internal.ads.zzfh r4 = r0.zzl
            com.google.android.gms.internal.ads.zzju r13 = new com.google.android.gms.internal.ads.zzju
            r14 = r45
            r13.<init>(r1, r14)
            r14 = 0
            r4.zzd(r14, r13)
        L_0x01bd:
            if (r7 == 0) goto L_0x02ec
            com.google.android.gms.internal.ads.zzcz r7 = new com.google.android.gms.internal.ads.zzcz
            r7.<init>()
            com.google.android.gms.internal.ads.zzdc r13 = r3.zza
            boolean r13 = r13.zzo()
            if (r13 != 0) goto L_0x01fe
            com.google.android.gms.internal.ads.zzvo r13 = r3.zzb
            java.lang.Object r13 = r13.zza
            com.google.android.gms.internal.ads.zzdc r14 = r3.zza
            r14.zzn(r13, r7)
            int r14 = r7.zzd
            com.google.android.gms.internal.ads.zzdc r15 = r3.zza
            int r15 = r15.zza(r13)
            com.google.android.gms.internal.ads.zzdc r4 = r3.zza
            r48 = r13
            com.google.android.gms.internal.ads.zzdb r13 = r0.zza
            r18 = r11
            r19 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzdb r4 = r4.zze(r14, r13, r11)
            java.lang.Object r4 = r4.zzc
            com.google.android.gms.internal.ads.zzdb r11 = r0.zza
            com.google.android.gms.internal.ads.zzbu r11 = r11.zze
            r24 = r48
            r21 = r4
            r23 = r11
            r22 = r14
            r25 = r15
            goto L_0x020c
        L_0x01fe:
            r18 = r11
            r19 = r12
            r22 = r51
            r21 = 0
            r23 = 0
            r24 = 0
            r25 = -1
        L_0x020c:
            if (r2 != 0) goto L_0x0237
            com.google.android.gms.internal.ads.zzvo r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x0225
            com.google.android.gms.internal.ads.zzvo r4 = r3.zzb
            int r11 = r4.zzb
            int r4 = r4.zzc
            long r11 = r7.zzh(r11, r4)
            long r13 = zzaa(r3)
            goto L_0x0249
        L_0x0225:
            com.google.android.gms.internal.ads.zzvo r4 = r3.zzb
            int r4 = r4.zze
            r11 = -1
            if (r4 == r11) goto L_0x0233
            com.google.android.gms.internal.ads.zzmg r4 = r0.zzac
            long r11 = zzaa(r4)
            goto L_0x0235
        L_0x0233:
            long r11 = r7.zze
        L_0x0235:
            r13 = r11
            goto L_0x0249
        L_0x0237:
            com.google.android.gms.internal.ads.zzvo r4 = r3.zzb
            boolean r4 = r4.zzb()
            if (r4 == 0) goto L_0x0246
            long r11 = r3.zzr
            long r13 = zzaa(r3)
            goto L_0x0249
        L_0x0246:
            long r11 = r3.zzr
            r13 = r11
        L_0x0249:
            com.google.android.gms.internal.ads.zzcs r4 = new com.google.android.gms.internal.ads.zzcs
            int r7 = com.google.android.gms.internal.ads.zzgd.zza
            com.google.android.gms.internal.ads.zzvo r7 = r3.zzb
            int r15 = r7.zzb
            int r7 = r7.zzc
            long r26 = com.google.android.gms.internal.ads.zzgd.zzu(r11)
            long r28 = com.google.android.gms.internal.ads.zzgd.zzu(r13)
            r20 = r4
            r30 = r15
            r31 = r7
            r20.<init>(r21, r22, r23, r24, r25, r26, r28, r30, r31)
            int r7 = r43.zzd()
            com.google.android.gms.internal.ads.zzmg r11 = r0.zzac
            com.google.android.gms.internal.ads.zzdc r11 = r11.zza
            boolean r11 = r11.zzo()
            if (r11 != 0) goto L_0x02a5
            com.google.android.gms.internal.ads.zzmg r11 = r0.zzac
            com.google.android.gms.internal.ads.zzvo r12 = r11.zzb
            java.lang.Object r12 = r12.zza
            com.google.android.gms.internal.ads.zzdc r11 = r11.zza
            com.google.android.gms.internal.ads.zzcz r13 = r0.zzn
            r11.zzn(r12, r13)
            com.google.android.gms.internal.ads.zzmg r11 = r0.zzac
            com.google.android.gms.internal.ads.zzdc r11 = r11.zza
            int r11 = r11.zza(r12)
            com.google.android.gms.internal.ads.zzmg r13 = r0.zzac
            com.google.android.gms.internal.ads.zzdc r13 = r13.zza
            com.google.android.gms.internal.ads.zzdb r14 = r0.zza
            r47 = r11
            r15 = r12
            r11 = 0
            com.google.android.gms.internal.ads.zzdb r13 = r13.zze(r7, r14, r11)
            java.lang.Object r11 = r13.zzc
            com.google.android.gms.internal.ads.zzdb r12 = r0.zza
            com.google.android.gms.internal.ads.zzbu r12 = r12.zze
            r35 = r47
            r31 = r11
            r33 = r12
            r34 = r15
            goto L_0x02ad
        L_0x02a5:
            r31 = 0
            r33 = 0
            r34 = 0
            r35 = -1
        L_0x02ad:
            long r36 = com.google.android.gms.internal.ads.zzgd.zzu(r49)
            com.google.android.gms.internal.ads.zzcs r11 = new com.google.android.gms.internal.ads.zzcs
            com.google.android.gms.internal.ads.zzmg r12 = r0.zzac
            com.google.android.gms.internal.ads.zzvo r12 = r12.zzb
            boolean r12 = r12.zzb()
            if (r12 == 0) goto L_0x02ca
            com.google.android.gms.internal.ads.zzmg r12 = r0.zzac
            long r12 = zzaa(r12)
            long r12 = com.google.android.gms.internal.ads.zzgd.zzu(r12)
            r38 = r12
            goto L_0x02cc
        L_0x02ca:
            r38 = r36
        L_0x02cc:
            com.google.android.gms.internal.ads.zzmg r12 = r0.zzac
            com.google.android.gms.internal.ads.zzvo r12 = r12.zzb
            int r13 = r12.zzb
            int r12 = r12.zzc
            r30 = r11
            r32 = r7
            r40 = r13
            r41 = r12
            r30.<init>(r31, r32, r33, r34, r35, r36, r38, r40, r41)
            com.google.android.gms.internal.ads.zzfh r7 = r0.zzl
            com.google.android.gms.internal.ads.zzjz r12 = new com.google.android.gms.internal.ads.zzjz
            r12.<init>(r2, r4, r11)
            r2 = 11
            r7.zzd(r2, r12)
            goto L_0x02f0
        L_0x02ec:
            r18 = r11
            r19 = r12
        L_0x02f0:
            if (r8 == 0) goto L_0x02fe
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzkb r4 = new com.google.android.gms.internal.ads.zzkb
            r4.<init>(r10, r6)
            r6 = 1
            r2.zzd(r6, r4)
            goto L_0x02ff
        L_0x02fe:
            r6 = 1
        L_0x02ff:
            com.google.android.gms.internal.ads.zzjh r2 = r3.zzf
            com.google.android.gms.internal.ads.zzjh r4 = r1.zzf
            r7 = 10
            if (r2 == r4) goto L_0x031f
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzkc r4 = new com.google.android.gms.internal.ads.zzkc
            r4.<init>(r1)
            r2.zzd(r7, r4)
            com.google.android.gms.internal.ads.zzjh r2 = r1.zzf
            if (r2 == 0) goto L_0x031f
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzkd r4 = new com.google.android.gms.internal.ads.zzkd
            r4.<init>(r1)
            r2.zzd(r7, r4)
        L_0x031f:
            com.google.android.gms.internal.ads.zzzn r2 = r3.zzi
            com.google.android.gms.internal.ads.zzzn r4 = r1.zzi
            if (r2 == r4) goto L_0x0337
            com.google.android.gms.internal.ads.zzzm r2 = r0.zzi
            java.lang.Object r4 = r4.zze
            r2.zzq(r4)
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzke r4 = new com.google.android.gms.internal.ads.zzke
            r4.<init>(r1)
            r8 = 2
            r2.zzd(r8, r4)
        L_0x0337:
            if (r9 == 0) goto L_0x0347
            com.google.android.gms.internal.ads.zzca r2 = r0.zzI
            com.google.android.gms.internal.ads.zzfh r4 = r0.zzl
            com.google.android.gms.internal.ads.zzkf r8 = new com.google.android.gms.internal.ads.zzkf
            r8.<init>(r2)
            r2 = 14
            r4.zzd(r2, r8)
        L_0x0347:
            if (r19 == 0) goto L_0x0354
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzkg r4 = new com.google.android.gms.internal.ads.zzkg
            r4.<init>(r1)
            r8 = 3
            r2.zzd(r8, r4)
        L_0x0354:
            if (r18 != 0) goto L_0x0358
            if (r5 == 0) goto L_0x0363
        L_0x0358:
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzkh r4 = new com.google.android.gms.internal.ads.zzkh
            r4.<init>(r1)
            r8 = -1
            r2.zzd(r8, r4)
        L_0x0363:
            r2 = 4
            if (r18 == 0) goto L_0x0370
            com.google.android.gms.internal.ads.zzfh r4 = r0.zzl
            com.google.android.gms.internal.ads.zzki r8 = new com.google.android.gms.internal.ads.zzki
            r8.<init>(r1)
            r4.zzd(r2, r8)
        L_0x0370:
            r4 = 5
            if (r5 == 0) goto L_0x037f
            com.google.android.gms.internal.ads.zzfh r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjv r8 = new com.google.android.gms.internal.ads.zzjv
            r9 = r46
            r8.<init>(r1, r9)
            r5.zzd(r4, r8)
        L_0x037f:
            int r5 = r3.zzm
            int r8 = r1.zzm
            r9 = 6
            if (r5 == r8) goto L_0x0390
            com.google.android.gms.internal.ads.zzfh r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjw r8 = new com.google.android.gms.internal.ads.zzjw
            r8.<init>(r1)
            r5.zzd(r9, r8)
        L_0x0390:
            boolean r5 = r3.zzi()
            boolean r8 = r44.zzi()
            r10 = 7
            if (r5 == r8) goto L_0x03a5
            com.google.android.gms.internal.ads.zzfh r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjx r8 = new com.google.android.gms.internal.ads.zzjx
            r8.<init>(r1)
            r5.zzd(r10, r8)
        L_0x03a5:
            com.google.android.gms.internal.ads.zzcl r5 = r3.zzn
            com.google.android.gms.internal.ads.zzcl r8 = r1.zzn
            boolean r5 = r5.equals(r8)
            r8 = 12
            if (r5 != 0) goto L_0x03bb
            com.google.android.gms.internal.ads.zzfh r5 = r0.zzl
            com.google.android.gms.internal.ads.zzjy r11 = new com.google.android.gms.internal.ads.zzjy
            r11.<init>(r1)
            r5.zzd(r8, r11)
        L_0x03bb:
            com.google.android.gms.internal.ads.zzcp r5 = r0.zzH
            com.google.android.gms.internal.ads.zzct r11 = r0.zzg
            com.google.android.gms.internal.ads.zzcp r12 = r0.zzc
            int r13 = com.google.android.gms.internal.ads.zzgd.zza
            boolean r13 = r11.zzx()
            r14 = r11
            com.google.android.gms.internal.ads.zzm r14 = (com.google.android.gms.internal.ads.zzm) r14
            com.google.android.gms.internal.ads.zzdc r15 = r14.zzn()
            boolean r17 = r15.zzo()
            if (r17 != 0) goto L_0x03e6
            int r6 = r14.zzd()
            com.google.android.gms.internal.ads.zzdb r8 = r14.zza
            r9 = 0
            com.google.android.gms.internal.ads.zzdb r6 = r15.zze(r6, r8, r9)
            boolean r6 = r6.zzi
            if (r6 == 0) goto L_0x03e6
            r6 = 1
            goto L_0x03e7
        L_0x03e6:
            r6 = 0
        L_0x03e7:
            com.google.android.gms.internal.ads.zzdc r8 = r14.zzn()
            boolean r9 = r8.zzo()
            if (r9 == 0) goto L_0x03f4
            r8 = 0
            goto L_0x040a
        L_0x03f4:
            int r9 = r14.zzd()
            r14.zzh()
            r14.zzw()
            r10 = 0
            int r8 = r8.zzk(r9, r10, r10)
            r9 = -1
            if (r8 == r9) goto L_0x0409
            r8 = 1
            goto L_0x040a
        L_0x0409:
            r8 = 0
        L_0x040a:
            com.google.android.gms.internal.ads.zzdc r9 = r14.zzn()
            boolean r10 = r9.zzo()
            if (r10 == 0) goto L_0x0419
            r15 = 0
            r16 = 0
            goto L_0x0431
        L_0x0419:
            int r10 = r14.zzd()
            r14.zzh()
            r14.zzw()
            r15 = 0
            int r9 = r9.zzj(r10, r15, r15)
            r10 = -1
            if (r9 == r10) goto L_0x042f
            r16 = 1
            goto L_0x0431
        L_0x042f:
            r16 = r15
        L_0x0431:
            com.google.android.gms.internal.ads.zzdc r9 = r14.zzn()
            boolean r10 = r9.zzo()
            if (r10 != 0) goto L_0x0452
            int r10 = r14.zzd()
            com.google.android.gms.internal.ads.zzdb r15 = r14.zza
            r50 = r8
            r7 = 0
            com.google.android.gms.internal.ads.zzdb r9 = r9.zze(r10, r15, r7)
            boolean r7 = r9.zzb()
            if (r7 == 0) goto L_0x0454
            r7 = 1
            goto L_0x0455
        L_0x0452:
            r50 = r8
        L_0x0454:
            r7 = 0
        L_0x0455:
            com.google.android.gms.internal.ads.zzdc r8 = r14.zzn()
            boolean r9 = r8.zzo()
            if (r9 != 0) goto L_0x0472
            int r9 = r14.zzd()
            com.google.android.gms.internal.ads.zzdb r10 = r14.zza
            r14 = 0
            com.google.android.gms.internal.ads.zzdb r8 = r8.zze(r9, r10, r14)
            boolean r8 = r8.zzj
            if (r8 == 0) goto L_0x0472
            r8 = 1
            goto L_0x0473
        L_0x0472:
            r8 = 0
        L_0x0473:
            com.google.android.gms.internal.ads.zzdc r9 = r11.zzn()
            boolean r9 = r9.zzo()
            com.google.android.gms.internal.ads.zzcn r10 = new com.google.android.gms.internal.ads.zzcn
            r10.<init>()
            r10.zzb(r12)
            r11 = r13 ^ 1
            r10.zzd(r2, r11)
            if (r6 == 0) goto L_0x048e
            if (r13 != 0) goto L_0x048e
            r2 = 1
            goto L_0x048f
        L_0x048e:
            r2 = 0
        L_0x048f:
            r10.zzd(r4, r2)
            if (r50 == 0) goto L_0x0499
            if (r13 != 0) goto L_0x0499
            r2 = 1
            goto L_0x049a
        L_0x0499:
            r2 = 0
        L_0x049a:
            r4 = 6
            r10.zzd(r4, r2)
            if (r9 != 0) goto L_0x04ab
            if (r50 != 0) goto L_0x04a7
            if (r7 == 0) goto L_0x04a7
            if (r6 == 0) goto L_0x04ab
        L_0x04a7:
            if (r13 != 0) goto L_0x04ab
            r2 = 1
            goto L_0x04ac
        L_0x04ab:
            r2 = 0
        L_0x04ac:
            r4 = 7
            r10.zzd(r4, r2)
            if (r16 == 0) goto L_0x04b7
            if (r13 != 0) goto L_0x04b7
            r2 = 1
            goto L_0x04b8
        L_0x04b7:
            r2 = 0
        L_0x04b8:
            r4 = 8
            r10.zzd(r4, r2)
            if (r9 != 0) goto L_0x04ca
            if (r16 != 0) goto L_0x04c6
            if (r7 == 0) goto L_0x04ca
            if (r8 == 0) goto L_0x04ca
        L_0x04c6:
            if (r13 != 0) goto L_0x04ca
            r7 = 1
            goto L_0x04cb
        L_0x04ca:
            r7 = 0
        L_0x04cb:
            r2 = 9
            r10.zzd(r2, r7)
            r2 = 10
            r10.zzd(r2, r11)
            if (r6 == 0) goto L_0x04dc
            if (r13 != 0) goto L_0x04dc
            r7 = 1
            goto L_0x04dd
        L_0x04dc:
            r7 = 0
        L_0x04dd:
            r2 = 11
            r10.zzd(r2, r7)
            if (r6 == 0) goto L_0x04e9
            if (r13 != 0) goto L_0x04e9
            r2 = 1
            goto L_0x04ea
        L_0x04e9:
            r2 = 0
        L_0x04ea:
            r4 = 12
            r10.zzd(r4, r2)
            com.google.android.gms.internal.ads.zzcp r2 = r10.zze()
            r0.zzH = r2
            com.google.android.gms.internal.ads.zzcp r2 = r0.zzH
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x050a
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            com.google.android.gms.internal.ads.zzjt r4 = new com.google.android.gms.internal.ads.zzjt
            r4.<init>(r0)
            r5 = 13
            r2.zzd(r5, r4)
        L_0x050a:
            com.google.android.gms.internal.ads.zzfh r2 = r0.zzl
            r2.zzc()
            boolean r2 = r3.zzo
            boolean r1 = r1.zzo
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkw.zzal(com.google.android.gms.internal.ads.zzmg, int, int, boolean, int, long, int, boolean):void");
    }

    private final void zzam() {
        switch (zzf()) {
            case 2:
            case 3:
                zzan();
                boolean z = this.zzac.zzo;
                zzv();
                zzv();
                return;
            default:
                return;
        }
    }

    private final void zzan() {
        IllegalStateException illegalStateException;
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String format = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", new Object[]{Thread.currentThread().getName(), this.zzs.getThread().getName()});
            if (!this.zzX) {
                if (this.zzY) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzfk.zzg("ExoPlayerImpl", format, illegalStateException);
                this.zzY = true;
                return;
            }
            throw new IllegalStateException(format);
        }
    }

    public final void zzA(zzna zzna) {
        zzan();
        this.zzr.zzQ(zzna);
    }

    public final void zzB(zzvq zzvq) {
        boolean z;
        zzan();
        List singletonList = Collections.singletonList(zzvq);
        zzan();
        zzan();
        zzW(this.zzac);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i = size - 1; i >= 0; i--) {
                this.zzo.remove(i);
            }
            this.zzag = this.zzag.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            zzmd zzmd = new zzmd((zzvq) singletonList.get(i2), this.zzp);
            arrayList.add(zzmd);
            this.zzo.add(i2, new zzkv(zzmd.zzb, zzmd.zza));
        }
        this.zzag = this.zzag.zzg(0, arrayList.size());
        zzml zzml = new zzml(this.zzo, this.zzag);
        if (zzml.zzo() || zzml.zzc() >= 0) {
            int zzg2 = zzml.zzg(false);
            zzmg zzad2 = zzad(this.zzac, zzml, zzac(zzml, zzg2, -9223372036854775807L));
            int i3 = zzad2.zze;
            if (!(zzg2 == -1 || i3 == 1)) {
                i3 = 4;
                if (!zzml.zzo() && zzg2 < zzml.zzc()) {
                    i3 = 2;
                }
            }
            zzmg zze2 = zzad2.zze(i3);
            this.zzk.zzq(arrayList, zzg2, zzgd.zzr(-9223372036854775807L), this.zzag);
            if (this.zzac.zzb.zza.equals(zze2.zzb.zza) || this.zzac.zza.zzo()) {
                z = false;
            } else {
                z = true;
            }
            zzal(zze2, 0, 1, z, 4, zzZ(zze2), -1, false);
            return;
        }
        throw new zzar(zzml, -1, -9223372036854775807L);
    }

    public final zzjh zzE() {
        zzan();
        return this.zzac.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS(zzlf zzlf) {
        long j;
        boolean z;
        boolean z2;
        int i = this.zzC - zzlf.zzb;
        this.zzC = i;
        boolean z3 = true;
        if (zzlf.zzc) {
            this.zzD = zzlf.zzd;
            this.zzE = true;
        }
        if (zzlf.zze) {
            this.zzF = zzlf.zzf;
        }
        if (i == 0) {
            zzdc zzdc = zzlf.zza.zza;
            if (!this.zzac.zza.zzo() && zzdc.zzo()) {
                this.zzad = -1;
                this.zzae = 0;
            }
            if (!zzdc.zzo()) {
                List zzw2 = ((zzml) zzdc).zzw();
                if (zzw2.size() == this.zzo.size()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zzeq.zzf(z2);
                for (int i2 = 0; i2 < zzw2.size(); i2++) {
                    ((zzkv) this.zzo.get(i2)).zzc((zzdc) zzw2.get(i2));
                }
            }
            if (this.zzE) {
                if (zzlf.zza.zzb.equals(this.zzac.zzb) && zzlf.zza.zzd == this.zzac.zzr) {
                    z3 = false;
                }
                if (z3) {
                    if (zzdc.zzo() || zzlf.zza.zzb.zzb()) {
                        j = zzlf.zza.zzd;
                    } else {
                        zzmg zzmg = zzlf.zza;
                        zzvo zzvo = zzmg.zzb;
                        j = zzmg.zzd;
                        zzab(zzdc, zzvo, j);
                    }
                    z = z3;
                } else {
                    j = -9223372036854775807L;
                    z = z3;
                }
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.zzE = false;
            zzal(zzlf.zza, 1, this.zzF, z, this.zzD, j, -1, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzT(zzlf zzlf) {
        this.zzj.zzh(new zzkl(this, zzlf));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzU(zzcq zzcq) {
        zzcq.zza(this.zzH);
    }

    public final void zza(int i, long j, int i2, boolean z) {
        zzan();
        if (i != -1) {
            zzeq.zzd(i >= 0);
            zzdc zzdc = this.zzac.zza;
            if (zzdc.zzo() || i < zzdc.zzc()) {
                this.zzr.zzu();
                this.zzC++;
                if (zzx()) {
                    zzfk.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                    zzlf zzlf = new zzlf(this.zzac);
                    zzlf.zza(1);
                    this.zzaf.zza.zzT(zzlf);
                    return;
                }
                zzmg zzmg = this.zzac;
                int i3 = zzmg.zze;
                if (i3 == 3 || (i3 == 4 && !zzdc.zzo())) {
                    zzmg = this.zzac.zze(2);
                }
                int zzd2 = zzd();
                zzmg zzad2 = zzad(zzmg, zzdc, zzac(zzdc, i, j));
                this.zzk.zzl(zzdc, i, zzgd.zzr(j));
                zzal(zzad2, 0, 1, true, 1, zzZ(zzad2), zzd2, false);
            }
        }
    }

    public final int zzb() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzb;
        }
        return -1;
    }

    public final int zzc() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzc;
        }
        return -1;
    }

    public final int zzd() {
        zzan();
        int zzW2 = zzW(this.zzac);
        if (zzW2 == -1) {
            return 0;
        }
        return zzW2;
    }

    public final int zze() {
        zzan();
        if (this.zzac.zza.zzo()) {
            return 0;
        }
        zzmg zzmg = this.zzac;
        return zzmg.zza.zza(zzmg.zzb.zza);
    }

    public final int zzf() {
        zzan();
        return this.zzac.zze;
    }

    public final int zzg() {
        zzan();
        return this.zzac.zzm;
    }

    public final int zzh() {
        zzan();
        return 0;
    }

    public final long zzi() {
        zzan();
        if (zzx()) {
            zzmg zzmg = this.zzac;
            if (zzmg.zzk.equals(zzmg.zzb)) {
                return zzgd.zzu(this.zzac.zzp);
            }
            return zzl();
        }
        zzan();
        if (this.zzac.zza.zzo()) {
            return this.zzae;
        }
        zzmg zzmg2 = this.zzac;
        long j = 0;
        if (zzmg2.zzk.zzd != zzmg2.zzb.zzd) {
            return zzgd.zzu(zzmg2.zza.zze(zzd(), this.zza, 0).zzo);
        }
        long j2 = zzmg2.zzp;
        if (this.zzac.zzk.zzb()) {
            zzmg zzmg3 = this.zzac;
            zzmg3.zza.zzn(zzmg3.zzk.zza, this.zzn).zzi(this.zzac.zzk.zzb);
        } else {
            j = j2;
        }
        zzmg zzmg4 = this.zzac;
        zzab(zzmg4.zza, zzmg4.zzk, j);
        return zzgd.zzu(j);
    }

    public final long zzj() {
        zzan();
        return zzY(this.zzac);
    }

    public final long zzk() {
        zzan();
        return zzgd.zzu(zzZ(this.zzac));
    }

    public final long zzl() {
        zzan();
        if (!zzx()) {
            zzdc zzn2 = zzn();
            if (zzn2.zzo()) {
                return -9223372036854775807L;
            }
            return zzgd.zzu(zzn2.zze(zzd(), this.zza, 0).zzo);
        }
        zzmg zzmg = this.zzac;
        zzvo zzvo = zzmg.zzb;
        zzmg.zza.zzn(zzvo.zza, this.zzn);
        return zzgd.zzu(this.zzn.zzh(zzvo.zzb, zzvo.zzc));
    }

    public final long zzm() {
        zzan();
        return zzgd.zzu(this.zzac.zzq);
    }

    public final zzdc zzn() {
        zzan();
        return this.zzac.zza;
    }

    public final zzdp zzo() {
        zzan();
        return this.zzac.zzi.zzd;
    }

    public final void zzp() {
        zzan();
        zziv zziv = this.zzy;
        boolean zzv2 = zzv();
        int i = 2;
        int zzb2 = zziv.zzb(zzv2, 2);
        zzak(zzv2, zzb2, zzX(zzv2, zzb2));
        zzmg zzmg = this.zzac;
        if (zzmg.zze == 1) {
            zzmg zzd2 = zzmg.zzd((zzjh) null);
            if (true == zzd2.zza.zzo()) {
                i = 4;
            }
            zzmg zze2 = zzd2.zze(i);
            this.zzC++;
            this.zzk.zzk();
            zzal(zze2, 1, 1, false, 5, -9223372036854775807L, -1, false);
        }
    }

    public final void zzq() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzgd.zze;
        String zza = zzbv.zza();
        zzfk.zze("ExoPlayerImpl", "Release " + hexString + " [AndroidXMedia3/1.4.0-alpha01] [" + str + "] [" + zza + "]");
        zzan();
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzfh zzfh = this.zzl;
            zzfh.zzd(10, new zzkk());
            zzfh.zzc();
        }
        this.zzl.zze();
        this.zzj.zze((Object) null);
        this.zzt.zzf(this.zzr);
        boolean z = this.zzac.zzo;
        this.zzac = this.zzac.zze(1);
        zzmg zzmg = this.zzac;
        this.zzac = zzmg.zza(zzmg.zzb);
        zzmg zzmg2 = this.zzac;
        zzmg2.zzp = zzmg2.zzr;
        this.zzac.zzq = 0;
        this.zzr.zzP();
        this.zzi.zzj();
        Surface surface = this.zzN;
        if (surface != null) {
            surface.release();
            this.zzN = null;
        }
        this.zzW = zzek.zza;
    }

    public final void zzr(boolean z) {
        zzan();
        int zzb2 = this.zzy.zzb(z, zzf());
        zzak(z, zzb2, zzX(z, zzb2));
    }

    public final void zzs(Surface surface) {
        int i;
        zzan();
        zzai(surface);
        if (surface == null) {
            i = 0;
        } else {
            i = -1;
        }
        zzaf(i, i);
    }

    public final void zzt(float f) {
        zzan();
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzU != max) {
            this.zzU = max;
            zzah();
            zzfh zzfh = this.zzl;
            zzfh.zzd(22, new zzka(max));
            zzfh.zzc();
        }
    }

    public final void zzu() {
        zzan();
        this.zzy.zzb(zzv(), 1);
        zzaj((zzjh) null);
        this.zzW = new zzek(zzgbc.zzm(), this.zzac.zzr);
    }

    public final boolean zzv() {
        zzan();
        return this.zzac.zzl;
    }

    public final boolean zzw() {
        zzan();
        return false;
    }

    public final boolean zzx() {
        zzan();
        return this.zzac.zzb.zzb();
    }

    public final int zzy() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    public final void zzz(zzna zzna) {
        this.zzr.zzt(zzna);
    }
}
