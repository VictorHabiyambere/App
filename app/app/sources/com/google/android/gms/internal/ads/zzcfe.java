package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcfe implements zzblp {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcee zzcee = (zzcee) obj;
        zzcif zzq = zzcee.zzq();
        if (zzq == null) {
            try {
                zzcif zzcif = new zzcif(zzcee, Float.parseFloat((String) map.get(TypedValues.TransitionType.S_DURATION)), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcee.zzC(zzcif);
                zzq = zzcif;
            } catch (NullPointerException e) {
                e = e;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get(TypedValues.TransitionType.S_DURATION));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        int i = 0;
        if (parseInt >= 0) {
            if (parseInt <= 3) {
                i = parseInt;
            }
        }
        String str = (String) map.get("aspectRatio");
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zze.zzm(3)) {
            zzm.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + i + " , aspectRatio : " + str);
        }
        zzq.zzc(parseFloat2, parseFloat, i, equals, parseFloat3);
    }
}
