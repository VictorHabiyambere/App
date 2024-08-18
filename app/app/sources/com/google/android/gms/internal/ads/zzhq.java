package com.google.android.gms.internal.ads;

import android.system.ErrnoException;
import android.system.OsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzhq {
    /* access modifiers changed from: private */
    public static boolean zzb(Throwable e) {
        return (e instanceof ErrnoException) && ((ErrnoException) e).errno == OsConstants.EACCES;
    }
}
