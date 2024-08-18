package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhh {
    public static final /* synthetic */ int zzh = 0;
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map zzd;
    public final long zze;
    public final long zzf;
    public final int zzg;

    static {
        zzbv.zzb("media3.datasource");
    }

    private zzhh(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj) {
        boolean z;
        boolean z2 = false;
        if (j2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        zzeq.zzd(z);
        if (j3 > 0) {
            z2 = true;
        } else if (j3 == -1) {
            j3 = -1;
            z2 = true;
        }
        zzeq.zzd(z2);
        if (uri != null) {
            this.zza = uri;
            this.zzb = 1;
            this.zzc = null;
            this.zzd = Collections.unmodifiableMap(new HashMap(map));
            this.zze = j2;
            this.zzf = j3;
            this.zzg = i2;
            return;
        }
        throw null;
    }

    /* synthetic */ zzhh(Uri uri, long j, int i, byte[] bArr, Map map, long j2, long j3, String str, int i2, Object obj, zzhg zzhg) {
        this(uri, 0, 1, (byte[]) null, map, j2, j3, (String) null, i2, (Object) null);
    }

    @Deprecated
    public zzhh(Uri uri, long j, long j2, String str) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j, j2, (String) null, 0, (Object) null);
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "DataSpec[" + ShareTarget.METHOD_GET + " " + obj + ", " + this.zze + ", " + this.zzf + ", null, " + this.zzg + "]";
    }

    public final zzhf zza() {
        return new zzhf(this, (zzhe) null);
    }

    public final boolean zzb(int i) {
        return (this.zzg & i) == i;
    }
}
