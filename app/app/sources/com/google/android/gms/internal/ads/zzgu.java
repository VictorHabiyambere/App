package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzgu extends zzgv {
    private final AssetManager zza;
    private Uri zzb;
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzgu(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzgt {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zzd;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzgt(e, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
            }
        }
        InputStream inputStream = this.zzc;
        int i3 = zzgd.zza;
        int read = inputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zzd;
        if (j2 != -1) {
            this.zzd = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    public final long zzb(zzhh zzhh) throws zzgt {
        int i;
        try {
            this.zzb = zzhh.zza;
            String path = this.zzb.getPath();
            if (path != null) {
                if (path.startsWith("/android_asset/")) {
                    path = path.substring(15);
                } else if (path.startsWith(DomExceptionUtils.SEPARATOR)) {
                    path = path.substring(1);
                }
                zzi(zzhh);
                this.zzc = this.zza.open(path, 1);
                if (this.zzc.skip(zzhh.zze) >= zzhh.zze) {
                    long j = zzhh.zzf;
                    if (j != -1) {
                        this.zzd = j;
                    } else {
                        long available = (long) this.zzc.available();
                        this.zzd = available;
                        if (available == 2147483647L) {
                            this.zzd = -1;
                        }
                    }
                    this.zze = true;
                    zzj(zzhh);
                    return this.zzd;
                }
                throw new zzgt((Throwable) null, 2008);
            }
            throw null;
        } catch (zzgt e) {
            throw e;
        } catch (IOException e2) {
            if (true != (e2 instanceof FileNotFoundException)) {
                i = CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
            } else {
                i = 2005;
            }
            throw new zzgt(e2, i);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzgt {
        this.zzb = null;
        try {
            InputStream inputStream = this.zzc;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzgt(e, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
        } catch (Throwable th) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th;
        }
    }
}
