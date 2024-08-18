package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
final class zzbem implements zzbgz {
    final /* synthetic */ SharedPreferences zza;

    zzbem(zzben zzben, SharedPreferences sharedPreferences) {
        this.zza = sharedPreferences;
    }

    public final Boolean zza(String str, boolean z) {
        try {
            return Boolean.valueOf(this.zza.getBoolean(str, z));
        } catch (ClassCastException e) {
            return Boolean.valueOf(this.zza.getString(str, String.valueOf(z)));
        }
    }

    public final Double zzb(String str, double d) {
        try {
            return Double.valueOf((double) this.zza.getFloat(str, (float) d));
        } catch (ClassCastException e) {
            return Double.valueOf(this.zza.getString(str, String.valueOf(d)));
        }
    }

    public final Long zzc(String str, long j) {
        try {
            return Long.valueOf(this.zza.getLong(str, j));
        } catch (ClassCastException e) {
            return Long.valueOf((long) this.zza.getInt(str, (int) j));
        }
    }

    public final String zzd(String str, String str2) {
        return this.zza.getString(str, str2);
    }
}
