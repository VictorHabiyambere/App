package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzefw implements Runnable {
    public final /* synthetic */ SQLiteDatabase zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzr zzc;

    public /* synthetic */ zzefw(SQLiteDatabase sQLiteDatabase, String str, zzr zzr) {
        this.zza = sQLiteDatabase;
        this.zzb = str;
        this.zzc = zzr;
    }

    public final void run() {
        zzefz.zzf(this.zza, this.zzb, this.zzc);
    }
}
