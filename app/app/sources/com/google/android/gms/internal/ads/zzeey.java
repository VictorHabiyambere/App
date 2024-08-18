package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbdv;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeey implements zzfkw {
    public final /* synthetic */ zzeez zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzeey(zzeez zzeez, long j) {
        this.zza = zzeez;
        this.zzb = j;
    }

    public final Object zza(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (this.zza.zzf()) {
            return null;
        }
        long j = this.zzb;
        zzbdv.zzaf.zza.C0002zza zzn = zzbdv.zzaf.zza.zzn();
        zzn.zzP(j);
        byte[] zzaV = ((zzbdv.zzaf.zza) zzn.zzbr()).zzaV();
        zzefg.zzf(sQLiteDatabase, false, false);
        zzefg.zzc(sQLiteDatabase, j, zzaV);
        return null;
    }
}
