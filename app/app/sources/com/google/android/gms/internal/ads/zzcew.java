package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcew extends zzcdk implements TextureView.SurfaceTextureListener, zzcdu {
    private final zzcee zzc;
    private final zzcef zzd;
    private final zzced zze;
    private zzcdj zzf;
    private Surface zzg;
    private zzcdv zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl = 1;
    private zzcec zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzcew(Context context, zzcef zzcef, zzcee zzcee, boolean z, boolean z2, zzced zzced) {
        super(context);
        this.zzc = zzcee;
        this.zzd = zzcef;
        this.zzn = z;
        this.zze = zzced;
        setSurfaceTextureListener(this);
        this.zzd.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        return str + DomExceptionUtils.SEPARATOR + canonicalName + ":" + message;
    }

    private final void zzU() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzQ(true);
        }
    }

    private final void zzV() {
        if (!this.zzo) {
            this.zzo = true;
            zzt.zza.post(new zzcev(this));
            zzn();
            this.zzd.zzb();
            if (this.zzp) {
                zzp();
            }
        }
    }

    private final void zzW(boolean z, Integer num) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null && !z) {
            zzcdv.zzP(num);
        } else if (this.zzi != null && this.zzg != null) {
            if (z) {
                if (zzad()) {
                    zzcdv.zzU();
                    zzY();
                } else {
                    zzm.zzj("No valid ExoPlayerAdapter exists when switch source.");
                    return;
                }
            }
            if (this.zzi.startsWith("cache:")) {
                zzcfp zzp2 = this.zzc.zzp(this.zzi);
                if (zzp2 instanceof zzcfy) {
                    this.zzh = ((zzcfy) zzp2).zza();
                    this.zzh.zzP(num);
                    if (!this.zzh.zzV()) {
                        zzm.zzj("Precached video player has been released.");
                        return;
                    }
                } else if (zzp2 instanceof zzcfv) {
                    zzcfv zzcfv = (zzcfv) zzp2;
                    String zzF = zzF();
                    ByteBuffer zzk2 = zzcfv.zzk();
                    boolean zzl2 = zzcfv.zzl();
                    String zzi2 = zzcfv.zzi();
                    if (zzi2 == null) {
                        zzm.zzj("Stream cache URL is null.");
                        return;
                    }
                    this.zzh = zzE(num);
                    this.zzh.zzG(new Uri[]{Uri.parse(zzi2)}, zzF, zzk2, zzl2);
                } else {
                    zzm.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
            } else {
                this.zzh = zzE(num);
                String zzF2 = zzF();
                Uri[] uriArr = new Uri[this.zzj.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzj;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzh.zzF(uriArr, zzF2);
            }
            this.zzh.zzL(this);
            zzZ(this.zzg, false);
            if (this.zzh.zzV()) {
                int zzt = this.zzh.zzt();
                this.zzl = zzt;
                if (zzt == 3) {
                    zzV();
                }
            }
        }
    }

    private final void zzX() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ((Surface) null, true);
            zzcdv zzcdv = this.zzh;
            if (zzcdv != null) {
                zzcdv.zzL((zzcdu) null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            try {
                zzcdv.zzS(surface, z);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set surface before player is initialized.");
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzs != f) {
            this.zzs = f;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcdv zzcdv = this.zzh;
        return zzcdv != null && zzcdv.zzV() && !this.zzk;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzs;
        if (f != 0.0f && this.zzm == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcec zzcec = this.zzm;
        if (zzcec != null) {
            zzcec.zzc(measuredWidth, measuredHeight);
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzn) {
            this.zzm = new zzcec(getContext());
            this.zzm.zzd(surfaceTexture, i, i2);
            this.zzm.start();
            SurfaceTexture zzb = this.zzm.zzb();
            if (zzb != null) {
                surfaceTexture = zzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        this.zzg = new Surface(surfaceTexture);
        if (this.zzh == null) {
            zzW(false, (Integer) null);
        } else {
            zzZ(this.zzg, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i, i2);
        } else {
            zzaa();
        }
        zzt.zza.post(new zzces(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcec zzcec = this.zzm;
        if (zzcec != null) {
            zzcec.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ((Surface) null, true);
        }
        zzt.zza.post(new zzceo(this));
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzcec zzcec = this.zzm;
        if (zzcec != null) {
            zzcec.zzc(i, i2);
        }
        zzt.zza.post(new zzcen(this, i, i2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        zze.zza("AdExoPlayerView3 window visibility changed to " + i);
        zzt.zza.post(new zzcem(this, i));
        super.onWindowVisibilityChanged(i);
    }

    public final void zzA(int i) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzN(i);
        }
    }

    public final void zzB(int i) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzR(i);
        }
    }

    public final void zzD(int i, int i2) {
        this.zzq = i;
        this.zzr = i2;
        zzaa();
    }

    /* access modifiers changed from: package-private */
    public final zzcdv zzE(Integer num) {
        zzced zzced = this.zze;
        zzcee zzcee = this.zzc;
        zzcgq zzcgq = new zzcgq(zzcee.getContext(), zzced, zzcee, num);
        zzm.zzi("ExoPlayerAdapter initialized.");
        return zzcgq;
    }

    /* access modifiers changed from: package-private */
    public final String zzF() {
        zzcee zzcee = this.zzc;
        return zzu.zzp().zzc(zzcee.getContext(), zzcee.zzn().afmaVersion);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzG(String str) {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzb("ExoPlayerAdapter error", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzH() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzI() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzK(String str) {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzc("ExoPlayerAdapter exception", str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzL() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzM() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzN() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzi();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzO(int i, int i2) {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzj(i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzP() {
        float zza = this.zzb.zza();
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            try {
                zzcdv.zzT(zza, false);
            } catch (IOException e) {
                zzm.zzk("", e);
            }
        } else {
            zzm.zzj("Trying to set volume before player is initialized.");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(int i) {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.onWindowVisibilityChanged(i);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzR() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzS() {
        zzcdj zzcdj = this.zzf;
        if (zzcdj != null) {
            zzcdj.zze();
        }
    }

    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    public final int zzb() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            return zzcdv.zzr();
        }
        return -1;
    }

    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    public final int zzd() {
        return this.zzr;
    }

    public final int zze() {
        return this.zzq;
    }

    public final long zzf() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            return zzcdv.zzx();
        }
        return -1;
    }

    public final long zzg() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            return zzcdv.zzA();
        }
        return -1;
    }

    public final long zzh() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            return zzcdv.zzB();
        }
        return -1;
    }

    public final void zzi(boolean z, long j) {
        if (this.zzc != null) {
            zzcci.zze.execute(new zzcep(this, z, j));
        }
    }

    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    public final void zzk(String str, Exception exc) {
        String zzT = zzT(str, exc);
        zzm.zzj("ExoPlayerAdapter error: ".concat(zzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        zzt.zza.post(new zzcet(this, zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    public final void zzl(String str, Exception exc) {
        String zzT = zzT("onLoadException", exc);
        zzm.zzj("ExoPlayerAdapter exception: ".concat(zzT));
        zzu.zzo().zzv(exc, "AdExoPlayerView.onException");
        zzt.zza.post(new zzceq(this, zzT));
    }

    public final void zzm(int i) {
        if (this.zzl != i) {
            this.zzl = i;
            switch (i) {
                case 3:
                    zzV();
                    return;
                case 4:
                    if (this.zze.zza) {
                        zzX();
                    }
                    this.zzd.zze();
                    this.zzb.zzc();
                    zzt.zza.post(new zzceu(this));
                    return;
                default:
                    return;
            }
        }
    }

    public final void zzn() {
        zzt.zza.post(new zzcel(this));
    }

    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            zzt.zza.post(new zzcer(this));
        }
    }

    public final void zzp() {
        if (zzac()) {
            if (this.zze.zza) {
                zzU();
            }
            this.zzh.zzO(true);
            this.zzd.zzc();
            this.zzb.zzb();
            this.zza.zzb();
            zzt.zza.post(new zzcek(this));
            return;
        }
        this.zzp = true;
    }

    public final void zzq(int i) {
        if (zzac()) {
            this.zzh.zzI((long) i);
        }
    }

    public final void zzr(zzcdj zzcdj) {
        this.zzf = zzcdj;
    }

    public final void zzs(String str) {
        if (str != null) {
            zzC(str, (String[]) null, (Integer) null);
        }
    }

    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    public final void zzu(float f, float f2) {
        zzcec zzcec = this.zzm;
        if (zzcec != null) {
            zzcec.zzf(f, f2);
        }
    }

    public final void zzv() {
        zzt.zza.post(new zzcej(this));
    }

    public final Integer zzw() {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            return zzcdv.zzC();
        }
        return null;
    }

    public final void zzx(int i) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzJ(i);
        }
    }

    public final void zzy(int i) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzK(i);
        }
    }

    public final void zzz(int i) {
        zzcdv zzcdv = this.zzh;
        if (zzcdv != null) {
            zzcdv.zzM(i);
        }
    }

    public final void zzC(String str, String[] strArr, Integer num) {
        if (str != null) {
            boolean z = true;
            if (strArr == null) {
                this.zzj = new String[]{str};
            } else {
                this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            String str2 = this.zzi;
            if (!this.zze.zzl || str2 == null || str.equals(str2) || this.zzl != 4) {
                z = false;
            }
            this.zzi = str;
            zzW(z, num);
        }
    }
}
