package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzefu implements zzfkw {
    public final /* synthetic */ zzefz zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzefu(zzefz zzefz, zzr zzr, String str) {
        this.zza = zzefz;
        this.zzb = zzr;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
