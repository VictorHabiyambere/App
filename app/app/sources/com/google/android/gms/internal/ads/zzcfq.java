package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfq implements zzblp {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException e) {
            zzm.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfp zzcfp;
        zzcfh zzcfh;
        Map map2 = map;
        zzcee zzcee = (zzcee) obj;
        if (zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map2);
            jSONObject.remove("google.afma.Notify_dt");
            zzm.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcfi zzy = zzu.zzy();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get("src");
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzced zzced = new zzced((String) map2.get("flags"));
            boolean z = zzced.zzl;
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map2.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException e) {
                        zzm.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (z) {
                    Iterator it = zzy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzcfh = null;
                            break;
                        }
                        zzcfh zzcfh2 = (zzcfh) it.next();
                        if (zzcfh2.zza == zzcee && str.equals(zzcfh2.zze())) {
                            zzcfh = zzcfh2;
                            break;
                        }
                    }
                } else {
                    zzcfh = zzy.zza(zzcee);
                }
                if (zzcfh != null) {
                    zzm.zzj("Precache task is already running.");
                    return;
                } else if (zzcee.zzj() == null) {
                    zzm.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzcee.zzA(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzcee.zzy(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzcee.zzx(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzcfb zzcfb = zzcee.zzj().zzb;
                    if (intValue > 0) {
                        int i2 = zzced.zzh;
                        int zzu = zzcdv.zzu();
                        if (zzu < i2) {
                            zzcfp = new zzcfy(zzcee, zzced);
                        } else if (zzu < zzced.zzb) {
                            zzcfp = new zzcfv(zzcee, zzced);
                        } else {
                            zzcfp = new zzcft(zzcee);
                        }
                    } else {
                        zzcfp = new zzcfs(zzcee);
                    }
                    new zzcfh(zzcee, zzcfp, str, strArr).zzb();
                }
            } else {
                zzcfh zza = zzy.zza(zzcee);
                if (zza != null) {
                    zzcfp = zza.zzb;
                } else {
                    zzm.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzcfp.zzs(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzcfp.zzr(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzcfp.zzp(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzcfp.zzq(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzcee)) {
            zzm.zzj("Precache abort but no precache task running.");
        }
    }
}
