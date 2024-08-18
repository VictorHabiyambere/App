package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzced {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final long zzn;
    public final long zzo;

    public zzced(String str) {
        String str2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbep.zzI);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbep.zzl);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbep.zzw);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbep.zzh);
        zzbeg zzbeg = zzbep.zzg;
        if (jSONObject != null) {
            try {
                str2 = jSONObject.getString("exo_player_version");
            } catch (JSONException e2) {
            }
            this.zze = str2;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbep.zzi);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbep.zzj);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbep.zzk);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbep.zzm);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbep.zzen);
            zzb(jSONObject, "min_retry_count", zzbep.zzn);
            this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbep.zzq);
            this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbep.zzbS);
            this.zzm = zza(jSONObject, "use_range_http_data_source", zzbep.zzbU);
            this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbep.zzbV);
            this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbep.zzbW);
        }
        str2 = (String) zzba.zzc().zza(zzbeg);
        this.zze = str2;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbep.zzi);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbep.zzj);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbep.zzk);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbep.zzm);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbep.zzen);
        zzb(jSONObject, "min_retry_count", zzbep.zzn);
        this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbep.zzq);
        this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbep.zzbS);
        this.zzm = zza(jSONObject, "use_range_http_data_source", zzbep.zzbU);
        this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbep.zzbV);
        this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbep.zzbW);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbeg zzbeg) {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbeg)).booleanValue();
        if (jSONObject == null) {
            return booleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException e) {
            return booleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbeg zzbeg) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return ((Integer) zzba.zzc().zza(zzbeg)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbeg zzbeg) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException e) {
            }
        }
        return ((Long) zzba.zzc().zza(zzbeg)).longValue();
    }
}
