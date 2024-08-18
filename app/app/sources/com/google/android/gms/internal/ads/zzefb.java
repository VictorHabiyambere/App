package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbdv;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzefb implements zzfkw {
    public final /* synthetic */ zzefc zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzbdv.zzab zzd;
    public final /* synthetic */ zzbdv.zzaf.zzd zze;

    public /* synthetic */ zzefb(zzefc zzefc, boolean z, ArrayList arrayList, zzbdv.zzab zzab, zzbdv.zzaf.zzd zzd2) {
        this.zza = zzefc;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzab;
        this.zze = zzd2;
    }

    public final Object zza(Object obj) {
        zzefc zzefc = this.zza;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzefc.zzb.zzf()) {
            return null;
        }
        zzbdv.zzaf.zzd zzd2 = this.zze;
        zzbdv.zzab zzab = this.zzd;
        ArrayList arrayList = this.zzc;
        boolean z = this.zzb;
        byte[] zze2 = zzefd.zze(zzefc.zzb, z, arrayList, zzab, zzd2);
        zzefg.zzf(sQLiteDatabase, z, true);
        zzefg.zzc(sQLiteDatabase, zzefc.zzb.zzf.zzd(), zze2);
        return null;
    }
}
