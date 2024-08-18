package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzefm {
    private final zzbdm zza;
    private final Context zzb;
    private final zzeer zzc;
    private final VersionInfoParcel zzd;

    public zzefm(Context context, VersionInfoParcel versionInfoParcel, zzbdm zzbdm, zzeer zzeer) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbdm;
        this.zzc = zzeer;
    }

    public final void zzb(boolean z) {
        try {
            this.zzc.zza(new zzefj(this, z));
        } catch (Exception e) {
            zzm.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(zzbdv.zzaf.zza.zzx(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzhcd e) {
                    zzm.zzg("Unable to deserialize proto from offline signals database:");
                    zzm.zzg(e.getMessage());
                }
            }
            query.close();
            Context context = this.zzb;
            zzbdv.zzaf.zzc zzi = zzbdv.zzaf.zzi();
            zzi.zzv(context.getPackageName());
            zzi.zzy(Build.MODEL);
            zzi.zzA(zzefg.zza(sQLiteDatabase2, 0));
            zzi.zzh(arrayList);
            zzi.zzE(zzefg.zza(sQLiteDatabase2, 1));
            zzi.zzx(zzefg.zza(sQLiteDatabase2, 3));
            zzi.zzF(zzu.zzB().currentTimeMillis());
            zzi.zzB(zzefg.zzb(sQLiteDatabase2, 2));
            zzbdv.zzaf zzaf = (zzbdv.zzaf) zzi.zzbr();
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbdv.zzaf.zza zza2 = (zzbdv.zzaf.zza) arrayList.get(i2);
                if (zza2.zzk() == zzbdv.zzq.ENUM_TRUE && zza2.zze() > j) {
                    j = zza2.zze();
                }
            }
            if (j != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, Long.valueOf(j));
                sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            }
            this.zza.zzc(new zzefk(zzaf));
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbdv.zzar.zza zzd2 = zzbdv.zzar.zzd();
            zzd2.zzg(versionInfoParcel.buddyApkVersion);
            zzd2.zzi(this.zzd.clientJarVersion);
            if (true != this.zzd.isClientJar) {
                i = 2;
            }
            zzd2.zzh(i);
            this.zza.zzc(new zzefl((zzbdv.zzar) zzd2.zzbr()));
            this.zza.zzb(zzbdo.OFFLINE_UPLOAD);
            zzefg.zze(sQLiteDatabase);
        }
        return null;
    }
}
