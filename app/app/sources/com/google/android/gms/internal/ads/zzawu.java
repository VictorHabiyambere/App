package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzawu implements zzftd {
    final /* synthetic */ zzfqx zza;

    zzawu(zzaww zzaww, zzfqx zzfqx) {
        this.zza = zzfqx;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException e) {
            return false;
        }
    }
}
