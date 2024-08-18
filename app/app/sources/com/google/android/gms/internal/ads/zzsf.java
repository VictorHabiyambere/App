package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzsf extends zztv implements zzlp {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzqn zzc;
    private final zzqv zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private zzan zzh;
    private zzan zzi;
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    /* access modifiers changed from: private */
    public zzmm zzm;
    /* access modifiers changed from: private */
    public boolean zzn;

    public zzsf(Context context, zztl zztl, zztx zztx, boolean z, Handler handler, zzqo zzqo, zzqv zzqv) {
        super(1, zztl, zztx, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzqv;
        this.zzc = new zzqn(handler, zzqo);
        zzqv.zzq(new zzse(this, (zzsd) null));
    }

    private final int zzaM(zztp zztp, zzan zzan) {
        if (!"OMX.google.raw.decoder".equals(zztp.zza) || zzgd.zza >= 24 || (zzgd.zza == 23 && zzgd.zzN(this.zzb))) {
            return zzan.zzo;
        }
        return -1;
    }

    private static List zzaN(zztx zztx, zzan zzan, boolean z, zzqv zzqv) throws zzud {
        zztp zzb2;
        if (zzan.zzn == null) {
            return zzgbc.zzm();
        }
        if (!zzqv.zzA(zzan) || (zzb2 = zzuj.zzb()) == null) {
            return zzuj.zzf(zztx, zzan, false, false);
        }
        return zzgbc.zzn(zzb2);
    }

    private final void zzaO() {
        long zzb2 = this.zzd.zzb(zzW());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzk) {
                zzb2 = Math.max(this.zzj, zzb2);
            }
            this.zzj = zzb2;
            this.zzk = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        this.zzd.zzk();
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        this.zzn = false;
        try {
            super.zzC();
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
        } catch (Throwable th) {
            if (this.zzl) {
                this.zzl = false;
                this.zzd.zzl();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzd.zzi();
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        zzaO();
        this.zzd.zzh();
    }

    public final String zzU() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzW() {
        return super.zzW() && this.zzd.zzz();
    }

    public final boolean zzX() {
        return this.zzd.zzy() || super.zzX();
    }

    /* access modifiers changed from: protected */
    public final float zzZ(float f, zzan zzan, zzan[] zzanArr) {
        int i = -1;
        for (zzan zzan2 : zzanArr) {
            int i2 = zzan2.zzB;
            if (i2 != -1) {
                i = Math.max(i, i2);
            }
        }
        if (i == -1) {
            return -1.0f;
        }
        return ((float) i) * f;
    }

    public final long zza() {
        if (zzcU() == 2) {
            zzaO();
        }
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzaa(com.google.android.gms.internal.ads.zztx r10, com.google.android.gms.internal.ads.zzan r11) throws com.google.android.gms.internal.ads.zzud {
        /*
            r9 = this;
            java.lang.String r0 = r11.zzn
            boolean r0 = com.google.android.gms.internal.ads.zzcg.zzg(r0)
            r1 = 128(0x80, float:1.794E-43)
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
            int r0 = r11.zzH
            boolean r2 = zzaL(r11)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zztp r0 = com.google.android.gms.internal.ads.zzuj.zzb()
            if (r0 == 0) goto L_0x0047
        L_0x001f:
            com.google.android.gms.internal.ads.zzqv r0 = r9.zzd
            com.google.android.gms.internal.ads.zzqa r0 = r0.zzd(r11)
            boolean r5 = r0.zzb
            if (r5 != 0) goto L_0x002b
            r5 = r3
            goto L_0x003b
        L_0x002b:
            boolean r5 = r0.zzc
            if (r4 == r5) goto L_0x0033
            r5 = 512(0x200, float:7.175E-43)
            goto L_0x0035
        L_0x0033:
            r5 = 1536(0x600, float:2.152E-42)
        L_0x0035:
            boolean r0 = r0.zzd
            if (r0 == 0) goto L_0x003b
            r5 = r5 | 2048(0x800, float:2.87E-42)
        L_0x003b:
            com.google.android.gms.internal.ads.zzqv r0 = r9.zzd
            boolean r0 = r0.zzA(r11)
            if (r0 != 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            r10 = r5 | 172(0xac, float:2.41E-43)
            return r10
        L_0x0047:
            r5 = r3
        L_0x0048:
            java.lang.String r0 = r11.zzn
            java.lang.String r6 = "audio/raw"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzqv r0 = r9.zzd
            boolean r0 = r0.zzA(r11)
            if (r0 != 0) goto L_0x005b
            goto L_0x007d
        L_0x005b:
            com.google.android.gms.internal.ads.zzqv r0 = r9.zzd
            int r6 = r11.zzA
            int r7 = r11.zzB
            r8 = 2
            com.google.android.gms.internal.ads.zzan r6 = com.google.android.gms.internal.ads.zzgd.zzz(r8, r6, r7)
            boolean r0 = r0.zzA(r6)
            if (r0 != 0) goto L_0x006d
            goto L_0x007d
        L_0x006d:
            com.google.android.gms.internal.ads.zzqv r0 = r9.zzd
            java.util.List r10 = zzaN(r10, r11, r3, r0)
            boolean r0 = r10.isEmpty()
            if (r0 == 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            if (r2 != 0) goto L_0x0080
            r4 = r8
        L_0x007d:
            r10 = r4 | 128(0x80, float:1.794E-43)
            return r10
        L_0x0080:
            java.lang.Object r0 = r10.get(r3)
            com.google.android.gms.internal.ads.zztp r0 = (com.google.android.gms.internal.ads.zztp) r0
            boolean r2 = r0.zze(r11)
            if (r2 != 0) goto L_0x00a6
            r6 = r4
        L_0x008d:
            int r7 = r10.size()
            if (r6 >= r7) goto L_0x00a6
            java.lang.Object r7 = r10.get(r6)
            com.google.android.gms.internal.ads.zztp r7 = (com.google.android.gms.internal.ads.zztp) r7
            boolean r8 = r7.zze(r11)
            if (r8 == 0) goto L_0x00a3
            r10 = r3
            r2 = r4
            r0 = r7
            goto L_0x00a7
        L_0x00a3:
            int r6 = r6 + 1
            goto L_0x008d
        L_0x00a6:
            r10 = r4
        L_0x00a7:
            if (r4 == r2) goto L_0x00ab
            r6 = 3
            goto L_0x00ac
        L_0x00ab:
            r6 = 4
        L_0x00ac:
            r7 = 8
            if (r2 == 0) goto L_0x00b9
            boolean r11 = r0.zzf(r11)
            if (r11 == 0) goto L_0x00b9
            r7 = 16
            goto L_0x00ba
        L_0x00b9:
        L_0x00ba:
            boolean r11 = r0.zzg
            if (r4 == r11) goto L_0x00c1
            r11 = r3
            goto L_0x00c3
        L_0x00c1:
            r11 = 64
        L_0x00c3:
            if (r4 == r10) goto L_0x00c6
            r1 = r3
        L_0x00c6:
            r10 = r6 | r7
            r10 = r10 | 32
            r10 = r10 | r11
            r10 = r10 | r1
            r10 = r10 | r5
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzaa(com.google.android.gms.internal.ads.zztx, com.google.android.gms.internal.ads.zzan):int");
    }

    /* access modifiers changed from: protected */
    public final zziy zzab(zztp zztp, zzan zzan, zzan zzan2) {
        int i;
        int i2;
        zziy zzb2 = zztp.zzb(zzan, zzan2);
        int i3 = zzb2.zze;
        if (zzaJ(zzan2)) {
            i3 |= 32768;
        }
        if (zzaM(zztp, zzan2) > this.zze) {
            i3 |= 64;
        }
        String str = zztp.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zzb2.zzd;
            i = 0;
        }
        return new zziy(str, zzan, zzan2, i2, i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zztk zzaf(com.google.android.gms.internal.ads.zztp r8, com.google.android.gms.internal.ads.zzan r9, android.media.MediaCrypto r10, float r11) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzan[] r10 = r7.zzT()
            int r0 = r10.length
            int r1 = r7.zzaM(r8, r9)
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            r4 = r2
        L_0x000f:
            if (r4 >= r0) goto L_0x0026
            r5 = r10[r4]
            com.google.android.gms.internal.ads.zziy r6 = r8.zzb(r9, r5)
            int r6 = r6.zzd
            if (r6 == 0) goto L_0x0023
            int r5 = r7.zzaM(r8, r5)
            int r1 = java.lang.Math.max(r1, r5)
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0026:
            r7.zze = r1
            java.lang.String r10 = r8.zza
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
            r1 = 24
            if (r0 >= r1) goto L_0x0064
            java.lang.String r0 = "OMX.SEC.aac.dec"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0064
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzc
            java.lang.String r0 = "samsung"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0064
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r0 = "zeroflte"
            boolean r10 = r10.startsWith(r0)
            if (r10 != 0) goto L_0x0062
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r0 = "herolte"
            boolean r10 = r10.startsWith(r0)
            if (r10 != 0) goto L_0x0062
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzb
            java.lang.String r0 = "heroqlte"
            boolean r10 = r10.startsWith(r0)
            if (r10 == 0) goto L_0x0064
            r10 = r3
            goto L_0x0065
        L_0x0062:
            r10 = r3
            goto L_0x0065
        L_0x0064:
            r10 = r2
        L_0x0065:
            r7.zzf = r10
            java.lang.String r10 = r8.zza
            java.lang.String r0 = "OMX.google.opus.decoder"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x008d
            java.lang.String r0 = "c2.android.opus.decoder"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x008d
            java.lang.String r0 = "OMX.google.vorbis.decoder"
            boolean r0 = r10.equals(r0)
            if (r0 != 0) goto L_0x008d
            java.lang.String r0 = "c2.android.vorbis.decoder"
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x008b
            r10 = r3
            goto L_0x008e
        L_0x008b:
            r10 = r2
            goto L_0x008e
        L_0x008d:
            r10 = r3
        L_0x008e:
            r7.zzg = r10
            java.lang.String r10 = r8.zzc
            int r0 = r7.zze
            android.media.MediaFormat r4 = new android.media.MediaFormat
            r4.<init>()
            java.lang.String r5 = "mime"
            r4.setString(r5, r10)
            int r10 = r9.zzA
            java.lang.String r5 = "channel-count"
            r4.setInteger(r5, r10)
            int r10 = r9.zzB
            java.lang.String r5 = "sample-rate"
            r4.setInteger(r5, r10)
            java.util.List r10 = r9.zzp
            com.google.android.gms.internal.ads.zzfn.zzb(r4, r10)
            java.lang.String r10 = "max-input-size"
            com.google.android.gms.internal.ads.zzfn.zza(r4, r10, r0)
            int r10 = com.google.android.gms.internal.ads.zzgd.zza
            r0 = 23
            if (r10 < r0) goto L_0x00e5
            java.lang.String r10 = "priority"
            r4.setInteger(r10, r2)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r10 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x00e5
            int r10 = com.google.android.gms.internal.ads.zzgd.zza
            if (r10 != r0) goto L_0x00df
            java.lang.String r10 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r0 = "ZTE B2017G"
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L_0x00e5
            java.lang.String r10 = "AXON 7 mini"
            java.lang.String r0 = com.google.android.gms.internal.ads.zzgd.zzd
            boolean r10 = r10.equals(r0)
            if (r10 != 0) goto L_0x00e5
        L_0x00df:
            java.lang.String r10 = "operating-rate"
            r4.setFloat(r10, r11)
        L_0x00e5:
            int r10 = com.google.android.gms.internal.ads.zzgd.zza
            r11 = 28
            if (r10 > r11) goto L_0x00fa
            java.lang.String r10 = r9.zzn
            java.lang.String r11 = "audio/ac4"
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x00fa
            java.lang.String r10 = "ac4-is-sync"
            r4.setInteger(r10, r3)
        L_0x00fa:
            int r10 = com.google.android.gms.internal.ads.zzgd.zza
            if (r10 < r1) goto L_0x0115
            com.google.android.gms.internal.ads.zzqv r10 = r7.zzd
            int r11 = r9.zzA
            int r0 = r9.zzB
            r1 = 4
            com.google.android.gms.internal.ads.zzan r11 = com.google.android.gms.internal.ads.zzgd.zzz(r1, r11, r0)
            int r10 = r10.zza(r11)
            r11 = 2
            if (r10 != r11) goto L_0x0115
            java.lang.String r10 = "pcm-encoding"
            r4.setInteger(r10, r1)
        L_0x0115:
            int r10 = com.google.android.gms.internal.ads.zzgd.zza
            r11 = 32
            if (r10 < r11) goto L_0x0122
            java.lang.String r10 = "max-output-channel-count"
            r11 = 99
            r4.setInteger(r10, r11)
        L_0x0122:
            java.lang.String r10 = r8.zzb
            java.lang.String r11 = "audio/raw"
            boolean r10 = r11.equals(r10)
            r0 = 0
            if (r10 == 0) goto L_0x0137
            java.lang.String r10 = r9.zzn
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x0137
            r10 = r9
            goto L_0x0138
        L_0x0137:
            r10 = r0
        L_0x0138:
            r7.zzi = r10
            com.google.android.gms.internal.ads.zztk r8 = com.google.android.gms.internal.ads.zztk.zza(r8, r4, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzaf(com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzan, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zztk");
    }

    /* access modifiers changed from: protected */
    public final List zzag(zztx zztx, zzan zzan, boolean z) throws zzud {
        return zzuj.zzg(zzaN(zztx, zzan, false, this.zzd), zzan);
    }

    /* access modifiers changed from: protected */
    public final void zzaj(zzin zzin) {
        zzan zzan;
        if (zzgd.zza >= 29 && (zzan = zzin.zza) != null && Objects.equals(zzan.zzn, "audio/opus") && zzaI()) {
            ByteBuffer byteBuffer = zzin.zzf;
            if (byteBuffer != null) {
                zzan zzan2 = zzin.zza;
                if (zzan2 == null) {
                    throw null;
                } else if (byteBuffer.remaining() == 8) {
                    this.zzd.zzr(zzan2.zzD, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / 1000000000));
                }
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzak(Exception exc) {
        zzfk.zzd("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str, zztk zztk, long j, long j2) {
        this.zzc.zze(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        this.zzc.zzf(str);
    }

    /* access modifiers changed from: protected */
    public final void zzao() {
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        this.zzd.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzaq() throws zzjh {
        int i;
        try {
            this.zzd.zzj();
        } catch (zzqu e) {
            if (true != zzaI()) {
                i = 5002;
            } else {
                i = 5003;
            }
            throw zzi(e, e.zzc, e.zzb, i);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzas(zzan zzan) {
        zzm();
        return this.zzd.zzA(zzan);
    }

    public final zzcl zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzcl zzcl) {
        this.zzd.zzs(zzcl);
    }

    public final boolean zzj() {
        boolean z = this.zzn;
        this.zzn = false;
        return z;
    }

    public final zzlp zzk() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzl = true;
        this.zzh = null;
        try {
            this.zzd.zzf();
            try {
                super.zzw();
                this.zzc.zzg(this.zza);
            } catch (Throwable th) {
                th = th;
                this.zzc.zzg(this.zza);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            this.zzc.zzg(this.zza);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx(boolean z, boolean z2) throws zzjh {
        super.zzx(z, z2);
        this.zzc.zzh(this.zza);
        zzm();
        this.zzd.zzt(zzn());
        this.zzd.zzp(zzh());
    }

    /* access modifiers changed from: protected */
    public final void zzz(long j, boolean z) throws zzjh {
        super.zzz(j, z);
        this.zzd.zzf();
        this.zzj = j;
        this.zzn = false;
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    public final zziy zzac(zzlj zzlj) throws zzjh {
        zzan zzan = zzlj.zza;
        if (zzan != null) {
            this.zzh = zzan;
            zziy zzac = super.zzac(zzlj);
            this.zzc.zzi(zzan, zzac);
            return zzac;
        }
        throw null;
    }

    public final void zzt(int i, Object obj) throws zzjh {
        switch (i) {
            case 2:
                zzqv zzqv = this.zzd;
                if (obj != null) {
                    zzqv.zzw(((Float) obj).floatValue());
                    return;
                }
                throw null;
            case 3:
                zzk zzk2 = (zzk) obj;
                zzqv zzqv2 = this.zzd;
                if (zzk2 != null) {
                    zzqv2.zzm(zzk2);
                    return;
                }
                throw null;
            case 6:
                zzl zzl2 = (zzl) obj;
                zzqv zzqv3 = this.zzd;
                if (zzl2 != null) {
                    zzqv3.zzo(zzl2);
                    return;
                }
                throw null;
            case 9:
                zzqv zzqv4 = this.zzd;
                if (obj != null) {
                    zzqv4.zzv(((Boolean) obj).booleanValue());
                    return;
                }
                throw null;
            case 10:
                zzqv zzqv5 = this.zzd;
                if (obj != null) {
                    zzqv5.zzn(((Integer) obj).intValue());
                    return;
                }
                throw null;
            case 11:
                this.zzm = (zzmm) obj;
                return;
            case 12:
                if (zzgd.zza >= 23) {
                    zzsc.zza(this.zzd, obj);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzar(long j, long j2, zztm zztm, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzan zzan) throws zzjh {
        if (byteBuffer == null) {
            throw null;
        } else if (this.zzi == null || (i2 & 2) == 0) {
            if (z) {
                if (zztm != null) {
                    zztm.zzn(i, false);
                }
                this.zza.zzf += i3;
                this.zzd.zzg();
                return true;
            }
            try {
                if (!this.zzd.zzx(byteBuffer, j3, i3)) {
                    return false;
                }
                if (zztm != null) {
                    zztm.zzn(i, false);
                }
                this.zza.zze += i3;
                return true;
            } catch (zzqr e) {
                zzan zzan2 = this.zzh;
                if (zzaI()) {
                    zzm();
                }
                throw zzi(e, zzan2, e.zzb, 5001);
            } catch (zzqu e2) {
                if (zzaI()) {
                    zzm();
                }
                throw zzi(e2, zzan, e2.zzb, 5002);
            }
        } else if (zztm != null) {
            zztm.zzn(i, false);
            return true;
        } else {
            throw null;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0107, code lost:
        r1 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzan(com.google.android.gms.internal.ads.zzan r10, android.media.MediaFormat r11) throws com.google.android.gms.internal.ads.zzjh {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzan r0 = r9.zzi
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x000a
            r10 = r0
            goto L_0x0109
        L_0x000a:
            com.google.android.gms.internal.ads.zztm r0 = r9.zzaw()
            if (r0 != 0) goto L_0x0012
            goto L_0x0109
        L_0x0012:
            if (r11 == 0) goto L_0x0131
            java.lang.String r0 = r10.zzn
            java.lang.String r4 = "audio/raw"
            boolean r0 = r4.equals(r0)
            r5 = 2
            if (r0 == 0) goto L_0x0022
            int r0 = r10.zzC
            goto L_0x0048
        L_0x0022:
            int r0 = com.google.android.gms.internal.ads.zzgd.zza
            r6 = 24
            if (r0 < r6) goto L_0x0035
            java.lang.String r0 = "pcm-encoding"
            boolean r6 = r11.containsKey(r0)
            if (r6 == 0) goto L_0x0035
            int r0 = r11.getInteger(r0)
            goto L_0x0048
        L_0x0035:
            java.lang.String r0 = "v-bits-per-sample"
            boolean r6 = r11.containsKey(r0)
            if (r6 == 0) goto L_0x0047
            int r0 = r11.getInteger(r0)
            int r0 = com.google.android.gms.internal.ads.zzgd.zzl(r0)
            goto L_0x0048
        L_0x0047:
            r0 = r5
        L_0x0048:
            com.google.android.gms.internal.ads.zzal r6 = new com.google.android.gms.internal.ads.zzal
            r6.<init>()
            r6.zzX(r4)
            r6.zzR(r0)
            int r0 = r10.zzD
            r6.zzF(r0)
            int r0 = r10.zzE
            r6.zzG(r0)
            com.google.android.gms.internal.ads.zzcd r0 = r10.zzl
            r6.zzQ(r0)
            java.lang.String r0 = r10.zzb
            r6.zzK(r0)
            java.lang.String r0 = r10.zzc
            r6.zzM(r0)
            java.util.List r0 = r10.zzd
            r6.zzN(r0)
            java.lang.String r0 = r10.zze
            r6.zzO(r0)
            int r0 = r10.zzf
            r6.zzZ(r0)
            int r0 = r10.zzg
            r6.zzV(r0)
            java.lang.String r0 = "channel-count"
            int r0 = r11.getInteger(r0)
            r6.zzy(r0)
            java.lang.String r0 = "sample-rate"
            int r11 = r11.getInteger(r0)
            r6.zzY(r11)
            com.google.android.gms.internal.ads.zzan r11 = r6.zzad()
            boolean r0 = r9.zzf
            r4 = 6
            if (r0 == 0) goto L_0x00af
            int r0 = r11.zzA
            if (r0 != r4) goto L_0x00af
            int r0 = r10.zzA
            if (r0 >= r4) goto L_0x00af
            int[] r1 = new int[r0]
            r0 = r3
        L_0x00a6:
            int r4 = r10.zzA
            if (r0 >= r4) goto L_0x0108
            r1[r0] = r0
            int r0 = r0 + 1
            goto L_0x00a6
        L_0x00af:
            boolean r10 = r9.zzg
            if (r10 == 0) goto L_0x0108
            int r10 = r11.zzA
            r0 = 7
            r6 = 5
            r7 = 4
            r8 = 3
            switch(r10) {
                case 3: goto L_0x00ff;
                case 4: goto L_0x00bc;
                case 5: goto L_0x00f2;
                case 6: goto L_0x00e3;
                case 7: goto L_0x00d2;
                case 8: goto L_0x00bd;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            goto L_0x0108
        L_0x00bd:
            r10 = 8
            int[] r10 = new int[r10]
            r10[r3] = r3
            r10[r2] = r5
            r10[r5] = r2
            r10[r8] = r0
            r10[r7] = r6
            r10[r6] = r4
            r10[r4] = r8
            r10[r0] = r7
            goto L_0x0107
        L_0x00d2:
            int[] r10 = new int[r0]
            r10[r3] = r3
            r10[r2] = r5
            r10[r5] = r2
            r10[r8] = r4
            r10[r7] = r6
            r10[r6] = r8
            r10[r4] = r7
            goto L_0x0107
        L_0x00e3:
            int[] r10 = new int[r4]
            r10[r3] = r3
            r10[r2] = r5
            r10[r5] = r2
            r10[r8] = r6
            r10[r7] = r8
            r10[r6] = r7
            goto L_0x0107
        L_0x00f2:
            int[] r10 = new int[r6]
            r10[r3] = r3
            r10[r2] = r5
            r10[r5] = r2
            r10[r8] = r8
            r10[r7] = r7
            goto L_0x0107
        L_0x00ff:
            int[] r10 = new int[r8]
            r10[r3] = r3
            r10[r2] = r5
            r10[r5] = r2
        L_0x0107:
            r1 = r10
        L_0x0108:
            r10 = r11
        L_0x0109:
            int r11 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ zzqq -> 0x0127 }
            r0 = 29
            if (r11 < r0) goto L_0x0121
            boolean r11 = r9.zzaI()     // Catch:{ zzqq -> 0x0127 }
            if (r11 == 0) goto L_0x0118
            r9.zzm()     // Catch:{ zzqq -> 0x0127 }
        L_0x0118:
            int r11 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ zzqq -> 0x0127 }
            if (r11 < r0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r2 = r3
        L_0x011e:
            com.google.android.gms.internal.ads.zzeq.zzf(r2)     // Catch:{ zzqq -> 0x0127 }
        L_0x0121:
            com.google.android.gms.internal.ads.zzqv r11 = r9.zzd     // Catch:{ zzqq -> 0x0127 }
            r11.zze(r10, r3, r1)     // Catch:{ zzqq -> 0x0127 }
            return
        L_0x0127:
            r10 = move-exception
            com.google.android.gms.internal.ads.zzan r11 = r10.zza
            r0 = 5001(0x1389, float:7.008E-42)
            com.google.android.gms.internal.ads.zzjh r10 = r9.zzi(r10, r11, r3, r0)
            throw r10
        L_0x0131:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsf.zzan(com.google.android.gms.internal.ads.zzan, android.media.MediaFormat):void");
    }
}
