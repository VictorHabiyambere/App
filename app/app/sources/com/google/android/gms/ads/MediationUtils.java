package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbep;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class MediationUtils {
    protected static final double MIN_HEIGHT_RATIO = 0.7d;
    protected static final double MIN_WIDTH_RATIO = 0.5d;

    public static AdSize findClosestSize(Context context, AdSize original, List<AdSize> potentials) {
        AdSize adSize = null;
        if (potentials == null || original == null) {
            return null;
        }
        if (!original.zzh() && !original.zzi()) {
            float f = context.getResources().getDisplayMetrics().density;
            original = new AdSize(Math.round(((float) original.getWidthInPixels(context)) / f), Math.round(((float) original.getHeightInPixels(context)) / f));
        }
        for (AdSize next : potentials) {
            if (next != null) {
                int width = original.getWidth();
                int width2 = next.getWidth();
                int height = original.getHeight();
                int height2 = next.getHeight();
                if (((double) width) * MIN_WIDTH_RATIO <= ((double) width2) && width >= width2) {
                    if (original.zzi()) {
                        int zza = original.zza();
                        if (((Integer) zzba.zzc().zza(zzbep.zzhW)).intValue() <= width2) {
                            if (((Integer) zzba.zzc().zza(zzbep.zzhX)).intValue() <= height2) {
                                if (zza < height2) {
                                }
                            }
                        }
                    } else if (original.zzh()) {
                        if (original.zzb() < height2) {
                        }
                    } else if (((double) height) * MIN_HEIGHT_RATIO <= ((double) height2)) {
                        if (height < height2) {
                        }
                    }
                    if (adSize == null || adSize.getWidth() * adSize.getHeight() <= next.getWidth() * next.getHeight()) {
                        adSize = next;
                    }
                }
            }
        }
        return adSize;
    }
}
