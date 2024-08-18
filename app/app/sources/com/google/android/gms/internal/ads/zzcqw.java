package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.database.core.ServerValues;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcqw implements zzbqa {
    private final Context zza;
    private final zzbaj zzb;
    private final PowerManager zzc;

    public zzcqw(Context context, zzbaj zzbaj) {
        this.zza = context;
        this.zzb = zzbaj;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcqz zzcqz) throws JSONException {
        JSONObject jSONObject;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzbam zzbam = zzcqz.zzf;
        if (zzbam == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z = zzbam.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put(ServerValues.NAME_OP_TIMESTAMP, zzcqz.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false);
            boolean z2 = zzcqz.zzc;
            put.put("isStopped", false).put("isPaused", zzcqz.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzu.zzr().zze()).put("appVolume", (double) zzu.zzr().zza()).put("deviceVolume", (double) zzac.zzb(this.zza.getApplicationContext()));
            if (((Boolean) zzba.zzc().zza(zzbep.zzfQ)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService("audio");
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzbam.zzb).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzbam.zzc.top).put("bottom", zzbam.zzc.bottom).put("left", zzbam.zzc.left).put("right", zzbam.zzc.right)).put("adBox", new JSONObject().put("top", zzbam.zzd.top).put("bottom", zzbam.zzd.bottom).put("left", zzbam.zzd.left).put("right", zzbam.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzbam.zze.top).put("bottom", zzbam.zze.bottom).put("left", zzbam.zze.left).put("right", zzbam.zze.right)).put("globalVisibleBoxVisible", zzbam.zzf).put("localVisibleBox", new JSONObject().put("top", zzbam.zzg.top).put("bottom", zzbam.zzg.bottom).put("left", zzbam.zzg.left).put("right", zzbam.zzg.right)).put("localVisibleBoxVisible", zzbam.zzh).put("hitBox", new JSONObject().put("top", zzbam.zzi.top).put("bottom", zzbam.zzi.bottom).put("left", zzbam.zzi.left).put("right", zzbam.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcqz.zza);
            if (((Boolean) zzba.zzc().zza(zzbep.zzbq)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzbam.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcqz.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
