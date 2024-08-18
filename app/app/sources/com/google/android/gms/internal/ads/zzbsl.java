package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbsl implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbhk zzg;
    private final List zzh = new ArrayList();
    private final boolean zzi;
    private final Map zzj = new HashMap();
    private final String zzk;

    public zzbsl(Date date, int i, Set set, Location location, boolean z, int i2, zzbhk zzbhk, List list, boolean z2, int i3, String str) {
        this.zza = date;
        this.zzb = i;
        this.zzc = set;
        this.zze = location;
        this.zzd = z;
        this.zzf = i2;
        this.zzg = zzbhk;
        this.zzi = z2;
        this.zzk = str;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzj.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzj.put(split[1], false);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzej.zzf().zza();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002f, code lost:
        r0.setReturnUrlsForImageAssets(r1.zzb);
        r0.setImageOrientation(r1.zzc);
        r0.setRequestMultipleImages(r1.zzd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return r0.build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r2 = r1.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r2 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r0.setVideoOptions(new com.google.android.gms.ads.VideoOptions(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r0.setAdChoicesPlacement(r1.zze);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.ads.formats.NativeAdOptions getNativeAdOptions() {
        /*
            r4 = this;
            com.google.android.gms.ads.formats.NativeAdOptions$Builder r0 = new com.google.android.gms.ads.formats.NativeAdOptions$Builder
            r0.<init>()
            com.google.android.gms.internal.ads.zzbhk r1 = r4.zzg
            if (r1 != 0) goto L_0x000e
            com.google.android.gms.ads.formats.NativeAdOptions r0 = r0.build()
            goto L_0x0042
        L_0x000e:
            int r2 = r1.zza
            switch(r2) {
                case 2: goto L_0x002a;
                case 3: goto L_0x001e;
                case 4: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x002f
        L_0x0014:
            boolean r2 = r1.zzg
            r0.setRequestCustomMuteThisAd(r2)
            int r2 = r1.zzh
            r0.setMediaAspectRatio(r2)
        L_0x001e:
            com.google.android.gms.ads.internal.client.zzfk r2 = r1.zzf
            if (r2 == 0) goto L_0x002a
            com.google.android.gms.ads.VideoOptions r3 = new com.google.android.gms.ads.VideoOptions
            r3.<init>(r2)
            r0.setVideoOptions(r3)
        L_0x002a:
            int r2 = r1.zze
            r0.setAdChoicesPlacement(r2)
        L_0x002f:
            boolean r2 = r1.zzb
            r0.setReturnUrlsForImageAssets(r2)
            int r2 = r1.zzc
            r0.setImageOrientation(r2)
            boolean r1 = r1.zzd
            r0.setRequestMultipleImages(r1)
            com.google.android.gms.ads.formats.NativeAdOptions r0 = r0.build()
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbsl.getNativeAdOptions():com.google.android.gms.ads.formats.NativeAdOptions");
    }

    public final NativeAdOptions getNativeAdRequestOptions() {
        return zzbhk.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return zzej.zzf().zzw();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final Map zza() {
        return this.zzj;
    }

    public final boolean zzb() {
        return this.zzh.contains("3");
    }
}
