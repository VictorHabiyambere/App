package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhj implements zzhb {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzhb zzc;
    private zzhb zzd;
    private zzhb zze;
    private zzhb zzf;
    private zzhb zzg;
    private zzhb zzh;
    private zzhb zzi;
    private zzhb zzj;
    private zzhb zzk;

    public zzhj(Context context, zzhb zzhb) {
        this.zza = context.getApplicationContext();
        this.zzc = zzhb;
    }

    private final zzhb zzg() {
        if (this.zze == null) {
            this.zze = new zzgu(this.zza);
            zzh(this.zze);
        }
        return this.zze;
    }

    private final void zzh(zzhb zzhb) {
        for (int i = 0; i < this.zzb.size(); i++) {
            zzhb.zzf((zzie) this.zzb.get(i));
        }
    }

    private static final void zzi(zzhb zzhb, zzie zzie) {
        if (zzhb != null) {
            zzhb.zzf(zzie);
        }
    }

    public final long zzb(zzhh zzhh) throws IOException {
        zzhb zzhb;
        zzeq.zzf(this.zzk == null);
        String scheme = zzhh.zza.getScheme();
        Uri uri = zzhh.zza;
        int i = zzgd.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || "file".equals(scheme2)) {
            String path = zzhh.zza.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    this.zzd = new zzhs();
                    zzh(this.zzd);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzg();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzg();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                this.zzf = new zzgy(this.zza);
                zzh(this.zzf);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    this.zzg = (zzhb) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    zzh(this.zzg);
                } catch (ClassNotFoundException e) {
                    zzfk.zzf("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating RTMP extension", e2);
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                this.zzh = new zzig(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
                zzh(this.zzh);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                this.zzi = new zzgz();
                zzh(this.zzi);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    this.zzj = new zzic(this.zza);
                    zzh(this.zzj);
                }
                zzhb = this.zzj;
            } else {
                zzhb = this.zzc;
            }
            this.zzk = zzhb;
        }
        return this.zzk.zzb(zzhh);
    }

    public final Uri zzc() {
        zzhb zzhb = this.zzk;
        if (zzhb == null) {
            return null;
        }
        return zzhb.zzc();
    }

    public final void zzd() throws IOException {
        zzhb zzhb = this.zzk;
        if (zzhb != null) {
            try {
                zzhb.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    public final Map zze() {
        zzhb zzhb = this.zzk;
        return zzhb == null ? Collections.emptyMap() : zzhb.zze();
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        zzhb zzhb = this.zzk;
        if (zzhb != null) {
            return zzhb.zza(bArr, i, i2);
        }
        throw null;
    }

    public final void zzf(zzie zzie) {
        if (zzie != null) {
            this.zzc.zzf(zzie);
            this.zzb.add(zzie);
            zzi(this.zzd, zzie);
            zzi(this.zze, zzie);
            zzi(this.zzf, zzie);
            zzi(this.zzg, zzie);
            zzi(this.zzh, zzie);
            zzi(this.zzi, zzie);
            zzi(this.zzj, zzie);
            return;
        }
        throw null;
    }
}
