package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzcn;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfd implements zzblp {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                zzay.zzb();
                i = zzf.zzy(context, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                zzm.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (zze.zzc()) {
            zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i + ".");
        }
        return i;
    }

    private static void zzc(zzcds zzcds, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcds.zzB(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                zzm.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", new Object[]{str, str2}));
                return;
            }
        }
        if (str2 != null) {
            zzcds.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcds.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcds.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcds.zzD(Integer.parseInt(str5));
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int i;
        int i2;
        int i3;
        Map map2 = map;
        zzcee zzcee = (zzcee) obj;
        String str = (String) map2.get("action");
        if (str == null) {
            zzm.zzj("Action missing from video GMSG.");
            return;
        }
        Integer num = null;
        Integer valueOf = map2.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map2.get("playerId"))) : null;
        Integer zzb = zzcee.zzo() != null ? zzcee.zzo().zzb() : null;
        if (valueOf == null || zzb == null || valueOf.equals(zzb) || str.equals("load")) {
            if (zze.zzm(3)) {
                JSONObject jSONObject = new JSONObject(map2);
                jSONObject.remove("google.afma.Notify_dt");
                zzm.zze("Video GMSG: " + str + " " + jSONObject.toString());
            }
            if (str.equals("background")) {
                String str2 = (String) map2.get(TypedValues.Custom.S_COLOR);
                if (TextUtils.isEmpty(str2)) {
                    zzm.zzj("Color parameter missing from background video GMSG.");
                    return;
                }
                try {
                    zzcee.setBackgroundColor(Color.parseColor(str2));
                } catch (IllegalArgumentException e) {
                    zzm.zzj("Invalid color parameter in background video GMSG.");
                }
            } else if (str.equals("playerBackground")) {
                String str3 = (String) map2.get(TypedValues.Custom.S_COLOR);
                if (TextUtils.isEmpty(str3)) {
                    zzm.zzj("Color parameter missing from playerBackground video GMSG.");
                    return;
                }
                try {
                    zzcee.zzB(Color.parseColor(str3));
                } catch (IllegalArgumentException e2) {
                    zzm.zzj("Invalid color parameter in playerBackground video GMSG.");
                }
            } else {
                if (str.equals("decoderProps")) {
                    String str4 = (String) map2.get("mimeTypes");
                    if (str4 == null) {
                        zzm.zzj("No MIME types specified for decoder properties inspection.");
                        HashMap hashMap = new HashMap();
                        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                        hashMap.put("error", "missingMimeTypes");
                        zzcee.zzd("onVideoEvent", hashMap);
                        return;
                    }
                    HashMap hashMap2 = new HashMap();
                    for (String str5 : str4.split(",")) {
                        hashMap2.put(str5, zzcn.zza(str5.trim()));
                    }
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                    hashMap3.put("mimeTypes", hashMap2);
                    zzcee.zzd("onVideoEvent", hashMap3);
                    return;
                }
                zzcdt zzo = zzcee.zzo();
                if (zzo == null) {
                    zzm.zzj("Could not get underlay container for a video GMSG.");
                    return;
                }
                boolean equals = str.equals("new");
                boolean equals2 = str.equals("position");
                if (equals || equals2) {
                    Context context = zzcee.getContext();
                    int zzb2 = zzb(context, map2, "x", 0);
                    int zzb3 = zzb(context, map2, "y", 0);
                    int zzb4 = zzb(context, map2, "w", -1);
                    if (((Boolean) zzba.zzc().zza(zzbep.zzdR)).booleanValue()) {
                        i = zzb4 == -1 ? zzcee.zzh() : Math.min(zzb4, zzcee.zzh());
                    } else {
                        if (zze.zzc()) {
                            zze.zza("Calculate width with original width " + zzb4 + ", videoHost.getVideoBoundingWidth() " + zzcee.zzh() + ", x " + zzb2 + ".");
                        }
                        i = Math.min(zzb4, zzcee.zzh() - zzb2);
                    }
                    int zzb5 = zzb(context, map2, "h", -1);
                    if (((Boolean) zzba.zzc().zza(zzbep.zzdR)).booleanValue()) {
                        i2 = zzb5 == -1 ? zzcee.zzg() : Math.min(zzb5, zzcee.zzg());
                    } else {
                        if (zze.zzc()) {
                            zze.zza("Calculate height with original height " + zzb5 + ", videoHost.getVideoBoundingHeight() " + zzcee.zzg() + ", y " + zzb3 + ".");
                        }
                        i2 = Math.min(zzb5, zzcee.zzg() - zzb3);
                    }
                    try {
                        i3 = Integer.parseInt((String) map2.get("player"));
                    } catch (NumberFormatException e3) {
                        i3 = 0;
                    }
                    boolean parseBoolean = Boolean.parseBoolean((String) map2.get("spherical"));
                    if (!equals || zzo.zza() != null) {
                        zzo.zzc(zzb2, zzb3, i, i2);
                        return;
                    }
                    zzo.zzd(zzb2, zzb3, i, i2, i3, parseBoolean, new zzced((String) map2.get("flags")));
                    zzcds zza2 = zzo.zza();
                    if (zza2 != null) {
                        zzc(zza2, map2);
                        return;
                    }
                    return;
                }
                zzcif zzq = zzcee.zzq();
                if (zzq != null) {
                    if (str.equals("timeupdate")) {
                        String str6 = (String) map2.get("currentTime");
                        if (str6 == null) {
                            zzm.zzj("currentTime parameter missing from timeupdate video GMSG.");
                            return;
                        }
                        try {
                            zzq.zzt(Float.parseFloat(str6));
                            return;
                        } catch (NumberFormatException e4) {
                            zzm.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                            return;
                        }
                    } else if (str.equals("skip")) {
                        zzq.zzu();
                        return;
                    }
                }
                zzcds zza3 = zzo.zza();
                if (zza3 == null) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
                    zzcee.zzd("onVideoEvent", hashMap4);
                } else if (str.equals("click")) {
                    Context context2 = zzcee.getContext();
                    int zzb6 = zzb(context2, map2, "x", 0);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zzb6, (float) zzb(context2, map2, "y", 0), 0);
                    zza3.zzx(obtain);
                    obtain.recycle();
                } else if (str.equals("currentTime")) {
                    String str7 = (String) map2.get("time");
                    if (str7 == null) {
                        zzm.zzj("Time parameter missing from currentTime video GMSG.");
                        return;
                    }
                    try {
                        zza3.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                    } catch (NumberFormatException e5) {
                        zzm.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                    }
                } else if (str.equals("hide")) {
                    zza3.setVisibility(4);
                } else if (str.equals("remove")) {
                    zza3.setVisibility(8);
                } else if (str.equals("load")) {
                    zza3.zzr(valueOf);
                } else if (str.equals("loadControl")) {
                    zzc(zza3, map2);
                } else if (str.equals("muted")) {
                    if (Boolean.parseBoolean((String) map2.get("muted"))) {
                        zza3.zzs();
                    } else {
                        zza3.zzI();
                    }
                } else if (str.equals("pause")) {
                    zza3.zzu();
                } else if (str.equals("play")) {
                    zza3.zzv();
                } else if (str.equals("show")) {
                    zza3.setVisibility(0);
                } else if (str.equals("src")) {
                    String str8 = (String) map2.get("src");
                    if (map2.containsKey("periodicReportIntervalMs")) {
                        try {
                            num = Integer.valueOf(Integer.parseInt((String) map2.get("periodicReportIntervalMs")));
                        } catch (NumberFormatException e6) {
                            zzm.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map2.get("periodicReportIntervalMs"))));
                        }
                    }
                    String[] strArr = {str8};
                    String str9 = (String) map2.get("demuxed");
                    if (str9 != null) {
                        try {
                            JSONArray jSONArray = new JSONArray(str9);
                            String[] strArr2 = new String[jSONArray.length()];
                            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                                strArr2[i4] = jSONArray.getString(i4);
                            }
                            strArr = strArr2;
                        } catch (JSONException e7) {
                            zzm.zzj("Malformed demuxed URL list for playback: ".concat(str9));
                            strArr = new String[]{str8};
                        }
                    }
                    if (num != null) {
                        zzcee.zzA(num.intValue());
                    }
                    zza3.zzE(str8, strArr);
                } else if (str.equals("touchMove")) {
                    Context context3 = zzcee.getContext();
                    zza3.zzH((float) zzb(context3, map2, "dx", 0), (float) zzb(context3, map2, "dy", 0));
                    if (!this.zza) {
                        zzcee.zzu();
                        this.zza = true;
                    }
                } else if (str.equals("volume")) {
                    String str10 = (String) map2.get("volume");
                    if (str10 == null) {
                        zzm.zzj("Level parameter missing from volume video GMSG.");
                        return;
                    }
                    try {
                        zza3.zzG(Float.parseFloat(str10));
                    } catch (NumberFormatException e8) {
                        zzm.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str10));
                    }
                } else if (str.equals("watermark")) {
                    zza3.zzn();
                } else {
                    zzm.zzj("Unknown video action: ".concat(str));
                }
            }
        } else {
            zzm.zzi(String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", new Object[]{valueOf, zzb}));
        }
    }
}
