package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zziw implements zzmn, zzmp {
    private final Object zza = new Object();
    private final int zzb;
    private final zzlj zzc;
    private zzmq zzd;
    private int zze;
    private zzpj zzf;
    private zzer zzg;
    private int zzh;
    private zzxf zzi;
    private zzan[] zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private zzdc zzp;
    private zzmo zzq;

    public zziw(int i) {
        this.zzb = i;
        this.zzc = new zzlj();
        this.zzm = Long.MIN_VALUE;
        this.zzp = zzdc.zza;
    }

    private final void zzZ(long j, boolean z) throws zzjh {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    /* access modifiers changed from: protected */
    public void zzA() {
    }

    /* access modifiers changed from: protected */
    public final void zzB() {
        zzmo zzmo;
        synchronized (this.zza) {
            zzmo = this.zzq;
        }
        if (zzmo != null) {
            zzmo.zza(this);
        }
    }

    /* access modifiers changed from: protected */
    public void zzC() {
    }

    /* access modifiers changed from: protected */
    public void zzD() throws zzjh {
    }

    /* access modifiers changed from: protected */
    public void zzE() {
    }

    /* access modifiers changed from: protected */
    public void zzF(zzan[] zzanArr, long j, long j2, zzvo zzvo) throws zzjh {
        throw null;
    }

    public final void zzG() {
        boolean z;
        if (this.zzh == 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        zzA();
    }

    public final void zzH(zzan[] zzanArr, zzxf zzxf, long j, long j2, zzvo zzvo) throws zzjh {
        zzeq.zzf(!this.zzn);
        this.zzi = zzxf;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzanArr;
        this.zzk = j2;
        zzF(zzanArr, j, j2, zzvo);
    }

    public final void zzI() {
        boolean z;
        if (this.zzh == 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        zzlj zzlj = this.zzc;
        zzlj.zzb = null;
        zzlj.zza = null;
        zzC();
    }

    public final void zzJ(long j) throws zzjh {
        zzZ(j, false);
    }

    public final void zzK() {
        this.zzn = true;
    }

    public final void zzL(zzmo zzmo) {
        synchronized (this.zza) {
            this.zzq = zzmo;
        }
    }

    public /* synthetic */ void zzM(float f, float f2) {
    }

    public final void zzN(zzdc zzdc) {
        if (!zzgd.zzG(this.zzp, zzdc)) {
            this.zzp = zzdc;
        }
    }

    public final void zzO() throws zzjh {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzeq.zzf(z);
        this.zzh = 2;
        zzD();
    }

    public final void zzP() {
        boolean z;
        if (this.zzh == 2) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzf(z);
        this.zzh = 1;
        zzE();
    }

    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    public final boolean zzR() {
        return this.zzn;
    }

    /* access modifiers changed from: protected */
    public final zzan[] zzT() {
        zzan[] zzanArr = this.zzj;
        if (zzanArr != null) {
            return zzanArr;
        }
        throw null;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzcU() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final int zzcV(zzlj zzlj, zzin zzin, int i) {
        zzxf zzxf = this.zzi;
        if (zzxf != null) {
            int zza2 = zzxf.zza(zzlj, zzin, i);
            if (zza2 == -4) {
                if (zzin.zzf()) {
                    this.zzm = Long.MIN_VALUE;
                    return this.zzn ? -4 : -3;
                }
                long j = zzin.zze + this.zzk;
                zzin.zze = j;
                this.zzm = Math.max(this.zzm, j);
            } else if (zza2 == -5) {
                zzan zzan = zzlj.zza;
                if (zzan != null) {
                    long j2 = zzan.zzr;
                    if (j2 != Long.MAX_VALUE) {
                        zzal zzb2 = zzan.zzb();
                        zzb2.zzab(j2 + this.zzk);
                        zzlj.zza = zzb2.zzad();
                        return -5;
                    }
                } else {
                    throw null;
                }
            }
            return zza2;
        }
        throw null;
    }

    public final long zzcW() {
        return this.zzm;
    }

    /* access modifiers changed from: protected */
    public final zzlj zzcX() {
        zzlj zzlj = this.zzc;
        zzlj.zzb = null;
        zzlj.zza = null;
        return zzlj;
    }

    public int zze() throws zzjh {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzf() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final zzer zzh() {
        zzer zzer = this.zzg;
        if (zzer != null) {
            return zzer;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzjh zzi(Throwable th, zzan zzan, boolean z, int i) {
        int i2;
        if (zzan == null || this.zzo) {
            i2 = 4;
        } else {
            this.zzo = true;
            try {
                int zzY = zzY(zzan) & 7;
                this.zzo = false;
                i2 = zzY;
            } catch (zzjh e) {
                this.zzo = false;
                i2 = 4;
            } catch (Throwable th2) {
                this.zzo = false;
                throw th2;
            }
        }
        return zzjh.zzb(th, zzU(), this.zze, zzan, i2, z, i);
    }

    public zzlp zzk() {
        return null;
    }

    public final zzmp zzl() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final zzmq zzm() {
        zzmq zzmq = this.zzd;
        if (zzmq != null) {
            return zzmq;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zzpj zzn() {
        zzpj zzpj = this.zzf;
        if (zzpj != null) {
            return zzpj;
        }
        throw null;
    }

    public final zzxf zzo() {
        return this.zzi;
    }

    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    public final void zzq() {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzeq.zzf(z);
        zzlj zzlj = this.zzc;
        zzlj.zzb = null;
        zzlj.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    public final void zzr(zzmq zzmq, zzan[] zzanArr, zzxf zzxf, long j, boolean z, boolean z2, long j2, long j3, zzvo zzvo) throws zzjh {
        boolean z3;
        boolean z4 = z;
        if (this.zzh == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzeq.zzf(z3);
        this.zzd = zzmq;
        this.zzh = 1;
        zzx(z4, z2);
        zzH(zzanArr, zzxf, j2, j3, zzvo);
        zzZ(j2, z4);
    }

    public /* synthetic */ void zzs() {
    }

    public void zzt(int i, Object obj) throws zzjh {
    }

    public final void zzu(int i, zzpj zzpj, zzer zzer) {
        this.zze = i;
        this.zzf = zzpj;
        this.zzg = zzer;
        zzy();
    }

    /* access modifiers changed from: protected */
    public void zzw() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzx(boolean z, boolean z2) throws zzjh {
    }

    /* access modifiers changed from: protected */
    public void zzy() {
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zzjh {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzxf zzxf = this.zzi;
        if (zzxf != null) {
            return zzxf.zze();
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final int zzd(long j) {
        zzxf zzxf = this.zzi;
        if (zzxf != null) {
            return zzxf.zzb(j - this.zzk);
        }
        throw null;
    }

    public final void zzv() throws IOException {
        zzxf zzxf = this.zzi;
        if (zzxf != null) {
            zzxf.zzd();
            return;
        }
        throw null;
    }
}
