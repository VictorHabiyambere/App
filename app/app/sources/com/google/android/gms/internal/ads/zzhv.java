package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzhv extends zzhc {
    public final zzhh zzb;
    public final int zzc;

    public zzhv(zzhh zzhh, int i, int i2) {
        super(zzb(2008, 1));
        this.zzb = zzhh;
        this.zzc = 1;
    }

    public static zzhv zza(IOException iOException, zzhh zzhh, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = PointerIconCompat.TYPE_WAIT;
        } else {
            i2 = (message == null || !zzfxm.zza(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        if (i2 == 2007) {
            return new zzhu(iOException, zzhh);
        }
        return new zzhv(iOException, zzhh, i2, i);
    }

    private static int zzb(int i, int i2) {
        if (i != 2000) {
            return i;
        }
        if (i2 != 1) {
            return CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE;
        }
        return 2001;
    }

    public zzhv(IOException iOException, zzhh zzhh, int i, int i2) {
        super((Throwable) iOException, zzb(i, i2));
        this.zzb = zzhh;
        this.zzc = i2;
    }

    public zzhv(String str, zzhh zzhh, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = zzhh;
        this.zzc = i2;
    }

    public zzhv(String str, IOException iOException, zzhh zzhh, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = zzhh;
        this.zzc = i2;
    }
}
