package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcgq extends zzcdv implements zzie, zzna {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcgb zzc;
    private final zzze zzd;
    private final zzced zze;
    private final WeakReference zzf;
    private final zzwu zzg;
    private zzjr zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcdu zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private final Object zzq = new Object();
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcgd zzt;
    private final Set zzu = new HashSet();

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0125  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzcgq(android.content.Context r3, com.google.android.gms.internal.ads.zzced r4, com.google.android.gms.internal.ads.zzcee r5, java.lang.Integer r6) {
        /*
            r2 = this;
            r2.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r2.zzq = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r2.zzu = r0
            r2.zzb = r3
            r2.zze = r4
            r2.zzr = r6
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r5)
            r2.zzf = r4
            com.google.android.gms.internal.ads.zzcgb r4 = new com.google.android.gms.internal.ads.zzcgb
            r4.<init>()
            r2.zzc = r4
            com.google.android.gms.internal.ads.zzze r4 = new com.google.android.gms.internal.ads.zzze
            android.content.Context r6 = r2.zzb
            r4.<init>(r6)
            r2.zzd = r4
            boolean r4 = com.google.android.gms.ads.internal.util.zze.zzc()
            if (r4 == 0) goto L_0x0041
            java.lang.String r4 = r2.toString()
            java.lang.String r6 = "SimpleExoPlayerAdapter initialize "
            java.lang.String r4 = r6.concat(r4)
            com.google.android.gms.ads.internal.util.zze.zza(r4)
        L_0x0041:
            java.util.concurrent.atomic.AtomicInteger r4 = zzD()
            r4.incrementAndGet()
            com.google.android.gms.internal.ads.zzms r4 = new com.google.android.gms.internal.ads.zzms
            android.content.Context r6 = r2.zzb
            com.google.android.gms.internal.ads.zzcgn r0 = new com.google.android.gms.internal.ads.zzcgn
            r0.<init>(r2)
            r4.<init>(r6, r0)
            com.google.android.gms.internal.ads.zzze r6 = r2.zzd
            r4.zzb(r6)
            com.google.android.gms.internal.ads.zzcgb r6 = r2.zzc
            r4.zza(r6)
            com.google.android.gms.internal.ads.zzmt r4 = r4.zzc()
            r2.zzh = r4
            com.google.android.gms.internal.ads.zzjr r4 = r2.zzh
            r4.zzz(r2)
            r4 = 0
            r2.zzl = r4
            r0 = 0
            r2.zzn = r0
            r2.zzm = r4
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r2.zzs = r6
            r6 = 0
            r2.zzt = r6
            if (r5 == 0) goto L_0x0083
            java.lang.String r6 = r5.zzr()
            goto L_0x0084
        L_0x0083:
        L_0x0084:
            com.google.android.gms.internal.ads.zzfyb r6 = com.google.android.gms.internal.ads.zzfyb.zzd(r6)
            java.lang.String r0 = ""
            java.lang.Object r6 = r6.zzb(r0)
            java.lang.String r6 = (java.lang.String) r6
            r2.zzo = r6
            if (r5 == 0) goto L_0x0099
            int r6 = r5.zzf()
            goto L_0x009a
        L_0x0099:
            r6 = r4
        L_0x009a:
            r2.zzp = r6
            com.google.android.gms.internal.ads.zzwu r6 = new com.google.android.gms.internal.ads.zzwu
            com.google.android.gms.ads.internal.util.zzt r0 = com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r5.zzn()
            java.lang.String r5 = r5.afmaVersion
            java.lang.String r3 = r0.zzc(r3, r5)
            boolean r5 = r2.zzj
            if (r5 == 0) goto L_0x00cc
            java.nio.ByteBuffer r5 = r2.zzi
            int r5 = r5.limit()
            if (r5 <= 0) goto L_0x00cc
            java.nio.ByteBuffer r3 = r2.zzi
            int r3 = r3.limit()
            byte[] r3 = new byte[r3]
            java.nio.ByteBuffer r4 = r2.zzi
            r4.get(r3)
            com.google.android.gms.internal.ads.zzcgf r4 = new com.google.android.gms.internal.ads.zzcgf
            r4.<init>(r3)
            goto L_0x0143
        L_0x00cc:
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzbZ
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r0.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0 = 1
            if (r5 == 0) goto L_0x00f4
            com.google.android.gms.internal.ads.zzbeg r5 = com.google.android.gms.internal.ads.zzbep.zzbR
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r1.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r4 = r0
            goto L_0x00fd
        L_0x00f4:
            com.google.android.gms.internal.ads.zzced r5 = r2.zze
            boolean r5 = r5.zzj
            if (r5 != 0) goto L_0x00fc
            r4 = r0
            goto L_0x00fd
        L_0x00fc:
        L_0x00fd:
            com.google.android.gms.internal.ads.zzced r5 = r2.zze
            boolean r0 = r5.zzm
            if (r0 == 0) goto L_0x0109
            com.google.android.gms.internal.ads.zzcgh r5 = new com.google.android.gms.internal.ads.zzcgh
            r5.<init>(r2, r3, r4)
            goto L_0x0118
        L_0x0109:
            int r5 = r5.zzi
            if (r5 <= 0) goto L_0x0113
            com.google.android.gms.internal.ads.zzcgi r5 = new com.google.android.gms.internal.ads.zzcgi
            r5.<init>(r2, r3, r4)
            goto L_0x0118
        L_0x0113:
            com.google.android.gms.internal.ads.zzcgj r5 = new com.google.android.gms.internal.ads.zzcgj
            r5.<init>(r2, r3, r4)
        L_0x0118:
            com.google.android.gms.internal.ads.zzced r3 = r2.zze
            boolean r3 = r3.zzj
            if (r3 == 0) goto L_0x0125
            com.google.android.gms.internal.ads.zzcgk r3 = new com.google.android.gms.internal.ads.zzcgk
            r3.<init>(r2, r5)
            r4 = r3
            goto L_0x0126
        L_0x0125:
            r4 = r5
        L_0x0126:
            java.nio.ByteBuffer r3 = r2.zzi
            if (r3 == 0) goto L_0x0143
            int r3 = r3.limit()
            if (r3 <= 0) goto L_0x0143
            java.nio.ByteBuffer r3 = r2.zzi
            int r3 = r3.limit()
            byte[] r3 = new byte[r3]
            java.nio.ByteBuffer r5 = r2.zzi
            r5.get(r3)
            com.google.android.gms.internal.ads.zzcgl r5 = new com.google.android.gms.internal.ads.zzcgl
            r5.<init>(r4, r3)
            r4 = r5
        L_0x0143:
            com.google.android.gms.internal.ads.zzbeg r3 = com.google.android.gms.internal.ads.zzbep.zzo
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r3 = r5.zza(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x015b
            com.google.android.gms.internal.ads.zzcgp r3 = new com.google.android.gms.internal.ads.zzcgp
            r3.<init>()
            goto L_0x0160
        L_0x015b:
            com.google.android.gms.internal.ads.zzcgg r3 = new com.google.android.gms.internal.ads.zzcgg
            r3.<init>()
        L_0x0160:
            com.google.android.gms.internal.ads.zzwt r5 = new com.google.android.gms.internal.ads.zzwt
            r5.<init>(r3)
            r6.<init>(r4, r5)
            r2.zzg = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgq.<init>(android.content.Context, com.google.android.gms.internal.ads.zzced, com.google.android.gms.internal.ads.zzcee, java.lang.Integer):void");
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzD().decrementAndGet();
        if (zze.zzc()) {
            zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    public final long zzA() {
        if (!zzad()) {
            return (long) this.zzl;
        }
        return 0;
    }

    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (!this.zzs.isEmpty()) {
                long j = this.zzn;
                Map zze2 = ((zzhz) this.zzs.remove(0)).zze();
                long j2 = 0;
                if (zze2 != null) {
                    Iterator it = zze2.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry != null) {
                            try {
                                if (!(entry.getKey() == null || !zzfxm.zzc("content-length", (CharSequence) entry.getKey()) || entry.getValue() == null || ((List) entry.getValue()).get(0) == null)) {
                                    j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                    break;
                                }
                            } catch (NumberFormatException e) {
                            }
                        }
                    }
                }
                this.zzn = j + j2;
            }
        }
        return this.zzn;
    }

    public final Integer zzC() {
        return this.zzr;
    }

    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zzH() {
        zzjr zzjr = this.zzh;
        if (zzjr != null) {
            zzjr.zzA(this);
            this.zzh.zzq();
            this.zzh = null;
            zzE().decrementAndGet();
        }
    }

    public final void zzI(long j) {
        zzm zzm2 = (zzm) this.zzh;
        zzm2.zza(zzm2.zzd(), j, 5, false);
    }

    public final void zzJ(int i) {
        this.zzc.zzk(i);
    }

    public final void zzK(int i) {
        this.zzc.zzl(i);
    }

    public final void zzL(zzcdu zzcdu) {
        this.zzk = zzcdu;
    }

    public final void zzM(int i) {
        this.zzc.zzm(i);
    }

    public final void zzN(int i) {
        this.zzc.zzn(i);
    }

    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    public final void zzP(Integer num) {
        this.zzr = num;
    }

    public final void zzQ(boolean z) {
        if (this.zzh != null) {
            int i = 0;
            while (true) {
                this.zzh.zzy();
                if (i < 2) {
                    zzze zzze = this.zzd;
                    zzyq zzc2 = zzze.zzf().zzc();
                    zzc2.zzp(i, !z);
                    zzze.zzl(zzc2);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzR(int i) {
        for (WeakReference weakReference : this.zzu) {
            zzcga zzcga = (zzcga) weakReference.get();
            if (zzcga != null) {
                zzcga.zzm(i);
            }
        }
    }

    public final void zzS(Surface surface, boolean z) {
        zzjr zzjr = this.zzh;
        if (zzjr != null) {
            zzjr.zzs(surface);
        }
    }

    public final void zzT(float f, boolean z) {
        zzjr zzjr = this.zzh;
        if (zzjr != null) {
            zzjr.zzt(f);
        }
    }

    public final void zzU() {
        this.zzh.zzu();
    }

    public final boolean zzV() {
        return this.zzh != null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzhb zzW(String str, boolean z) {
        zzcgq zzcgq = true != z ? null : this;
        zzced zzced = this.zze;
        return new zzcgt(str, zzcgq, zzced.zzd, zzced.zzf, zzced.zzn, zzced.zzo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzhb zzX(String str, boolean z) {
        zzcgq zzcgq;
        if (true != z) {
            zzcgq = null;
        } else {
            zzcgq = this;
        }
        zzced zzced = this.zze;
        zzcga zzcga = new zzcga(str, zzcgq, zzced.zzd, zzced.zzf, zzced.zzi);
        this.zzu.add(new WeakReference(zzcga));
        return zzcga;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzhb zzY(String str, boolean z) {
        zzcgq zzcgq;
        zzhk zzhk = new zzhk();
        zzhk.zzf(str);
        if (true != z) {
            zzcgq = null;
        } else {
            zzcgq = this;
        }
        zzhk.zze(zzcgq);
        zzhk.zzc(this.zze.zzd);
        zzhk.zzd(this.zze.zzf);
        zzhk.zzb(true);
        return zzhk.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzhb zzZ(zzha zzha) {
        zzhb zza2 = zzha.zza();
        zzcgo zzcgo = new zzcgo(this);
        return new zzcgd(this.zzb, zza2, this.zzo, this.zzp, this, zzcgo);
    }

    public final void zza(zzhb zzhb, zzhh zzhh, boolean z, int i) {
        this.zzl += i;
    }

    /* access modifiers changed from: package-private */
    public final zzvq zzaa(Uri uri) {
        zzaw zzaw = new zzaw();
        zzaw.zzb(uri);
        zzbu zzc2 = zzaw.zzc();
        zzwu zzwu = this.zzg;
        zzwu.zza(this.zze.zzg);
        return zzwu.zzb(zzc2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzab(boolean z, long j) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu != null) {
            zzcdu.zzi(z, j);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzmn[] zzac(Handler handler, zzaci zzaci, zzqo zzqo, zzxu zzxu, zzun zzun) {
        zztx zztx = zztx.zza;
        Context context = this.zzb;
        zzsf zzsf = new zzsf(context, new zztj(context), zztx, false, handler, zzqo, new zzrl(context).zzd());
        zztx zztx2 = zztx.zza;
        Context context2 = this.zzb;
        return new zzmn[]{zzsf, new zzabj(context2, new zztj(context2), zztx2, 0, false, handler, zzaci, -1, 30.0f)};
    }

    public final void zzb(zzhb zzhb, zzhh zzhh, boolean z) {
    }

    public final void zzc(zzhb zzhb, zzhh zzhh, boolean z) {
    }

    public final void zzd(zzhb zzhb, zzhh zzhh, boolean z) {
        if (zzhb instanceof zzhz) {
            synchronized (this.zzq) {
                this.zzs.add((zzhz) zzhb);
            }
        } else if (zzhb instanceof zzcgd) {
            this.zzt = (zzcgd) zzhb;
            zzcee zzcee = (zzcee) this.zzf.get();
            if (((Boolean) zzba.zzc().zza(zzbep.zzbR)).booleanValue() && zzcee != null && this.zzt.zzn()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                zzt.zza.post(new zzcgm(zzcee, hashMap));
            }
        }
    }

    public final void zze(zzmy zzmy, zzan zzan, zziy zziy) {
        zzcee zzcee = (zzcee) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbep.zzbR)).booleanValue() && zzcee != null) {
            HashMap hashMap = new HashMap();
            String str = zzan.zzm;
            if (str != null) {
                hashMap.put("audioMime", str);
            }
            String str2 = zzan.zzn;
            if (str2 != null) {
                hashMap.put("audioSampleMime", str2);
            }
            String str3 = zzan.zzk;
            if (str3 != null) {
                hashMap.put("audioCodec", str3);
            }
            zzcee.zzd("onMetadataEvent", hashMap);
        }
    }

    public final /* synthetic */ void zzf(zzmy zzmy, int i, long j, long j2) {
    }

    public final /* synthetic */ void zzg(zzmy zzmy, zzvk zzvk) {
    }

    public final void zzh(zzmy zzmy, int i, long j) {
        this.zzm += i;
    }

    public final /* synthetic */ void zzi(zzct zzct, zzmz zzmz) {
    }

    public final void zzj(zzmy zzmy, zzvf zzvf, zzvk zzvk, IOException iOException, boolean z) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu == null) {
            return;
        }
        if (this.zze.zzk) {
            zzcdu.zzl("onLoadException", iOException);
        } else {
            zzcdu.zzk("onLoadError", iOException);
        }
    }

    public final void zzk(zzmy zzmy, int i) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu != null) {
            zzcdu.zzm(i);
        }
    }

    public final void zzl(zzmy zzmy, zzcj zzcj) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu != null) {
            zzcdu.zzk("onPlayerError", zzcj);
        }
    }

    public final /* synthetic */ void zzm(zzmy zzmy, zzcs zzcs, zzcs zzcs2, int i) {
    }

    public final void zzn(zzmy zzmy, Object obj, long j) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu != null) {
            zzcdu.zzv();
        }
    }

    public final /* synthetic */ void zzo(zzmy zzmy, zzix zzix) {
    }

    public final void zzp(zzmy zzmy, zzan zzan, zziy zziy) {
        zzcee zzcee = (zzcee) this.zzf.get();
        if (((Boolean) zzba.zzc().zza(zzbep.zzbR)).booleanValue() && zzcee != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("frameRate", String.valueOf(zzan.zzu));
            hashMap.put("bitRate", String.valueOf(zzan.zzj));
            int i = zzan.zzs;
            int i2 = zzan.zzt;
            hashMap.put("resolution", i + "x" + i2);
            String str = zzan.zzm;
            if (str != null) {
                hashMap.put("videoMime", str);
            }
            String str2 = zzan.zzn;
            if (str2 != null) {
                hashMap.put("videoSampleMime", str2);
            }
            String str3 = zzan.zzk;
            if (str3 != null) {
                hashMap.put("videoCodec", str3);
            }
            zzcee.zzd("onMetadataEvent", hashMap);
        }
    }

    public final void zzq(zzmy zzmy, zzdv zzdv) {
        zzcdu zzcdu = this.zzk;
        if (zzcdu != null) {
            zzcdu.zzD(zzdv.zzc, zzdv.zzd);
        }
    }

    public final int zzr() {
        return this.zzm;
    }

    public final int zzt() {
        return this.zzh.zzf();
    }

    public final long zzv() {
        return this.zzh.zzi();
    }

    public final long zzw() {
        return (long) this.zzl;
    }

    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min((long) this.zzl, this.zzt.zzk());
        }
        return 0;
    }

    public final long zzy() {
        return this.zzh.zzk();
    }

    public final long zzz() {
        return this.zzh.zzl();
    }

    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzvq zzvq;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzvq = zzaa(uriArr[0]);
            } else {
                zzvq[] zzvqArr = new zzvq[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzvqArr[i] = zzaa(uriArr[i]);
                }
                zzvq = new zzwf(false, false, new zzuz(), zzvqArr);
            }
            this.zzh.zzB(zzvq);
            this.zzh.zzp();
            zzE().incrementAndGet();
        }
    }
}
