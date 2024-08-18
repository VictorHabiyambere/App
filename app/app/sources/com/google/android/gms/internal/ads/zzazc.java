package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazc extends zzazs {
    private final zzaxw zzi;

    public zzazc(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, zzaxw zzaxw) {
        super(zzaye, "QcEEfK1PwFv2Eb+NZQ+4kWKAUUVvycYqoBzmAjBexJV/sKEjaFlajeD5MAZYWXy5", "361aY1ErIwpwsXwpamiiDSCpkl/IcdBM93dd8sW9a/Y=", zzatp, i, 94);
        this.zzi = zzaxw;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zzf.invoke((Object) null, new Object[]{this.zzi.zza()})).intValue();
        synchronized (this.zze) {
            this.zze.zzD(zzauh.zzb(intValue));
        }
    }
}
