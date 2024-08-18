package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzpt extends ContentObserver {
    final /* synthetic */ zzpw zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzpt(zzpw zzpw, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.zza = zzpw;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    public final void onChange(boolean z) {
        zzpw zzpw = this.zza;
        this.zza.zzj(zzpp.zzc(zzpw.zza, zzpw.zzh, zzpw.zzg));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
