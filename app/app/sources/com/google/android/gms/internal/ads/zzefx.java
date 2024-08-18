package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzefx implements zzfkw {
    public final /* synthetic */ zzefz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzefx(zzefz zzefz, String str) {
        this.zza = zzefz;
        this.zzb = str;
    }

    public final Object zza(Object obj) {
        zzefz.zzi((SQLiteDatabase) obj, this.zzb);
        return null;
    }
}
