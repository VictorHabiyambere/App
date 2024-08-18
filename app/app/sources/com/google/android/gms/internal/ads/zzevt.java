package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzevt implements zzexw {
    private final zzgge zza;
    private final zzfho zzb;
    private final PackageInfo zzc;
    private final zzg zzd;

    public zzevt(zzgge zzgge, zzfho zzfho, PackageInfo packageInfo, zzg zzg) {
        this.zza = zzgge;
        this.zzb = zzfho;
        this.zzc = packageInfo;
        this.zzd = zzg;
    }

    public static /* synthetic */ zzevu zzc(zzevt zzevt) {
        ArrayList arrayList = zzevt.zzb.zzg;
        if (arrayList == null) {
            return new zzevq();
        }
        return arrayList.isEmpty() ? new zzevr() : new zzevs(zzevt, arrayList);
    }

    public final int zza() {
        return 26;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzevp(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011f, code lost:
        r2 = "l";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzd(java.util.ArrayList r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r8.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r8.putStringArrayList(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            java.util.ArrayList r7 = r7.zzh
            java.lang.String r0 = "native_custom_templates"
            r8.putStringArrayList(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r7 = r7.zza
            java.lang.String r0 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 1
            if (r7 <= r1) goto L_0x0049
            java.lang.String r7 = "enable_native_media_orientation"
            r8.putBoolean(r7, r5)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r7 = r7.zzh
            switch(r7) {
                case 1: goto L_0x003c;
                case 2: goto L_0x003a;
                case 3: goto L_0x0038;
                case 4: goto L_0x0035;
                default: goto L_0x0033;
            }
        L_0x0033:
            r7 = r4
            goto L_0x003d
        L_0x0035:
            java.lang.String r7 = "square"
            goto L_0x003d
        L_0x0038:
            r7 = r2
            goto L_0x003d
        L_0x003a:
            r7 = r0
            goto L_0x003d
        L_0x003c:
            r7 = r3
        L_0x003d:
            boolean r1 = r4.equals(r7)
            if (r1 != 0) goto L_0x0049
            java.lang.String r1 = "native_media_orientation"
            r8.putString(r1, r7)
        L_0x0049:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r7 = r7.zzc
            switch(r7) {
                case 0: goto L_0x0057;
                case 1: goto L_0x0055;
                case 2: goto L_0x0054;
                default: goto L_0x0052;
            }
        L_0x0052:
            r0 = r4
            goto L_0x0058
        L_0x0054:
            goto L_0x0058
        L_0x0055:
            r0 = r2
            goto L_0x0058
        L_0x0057:
            r0 = r3
        L_0x0058:
            boolean r7 = r4.equals(r0)
            if (r7 != 0) goto L_0x0064
            java.lang.String r7 = "native_image_orientation"
            r8.putString(r7, r0)
        L_0x0064:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            boolean r7 = r7.zzd
            java.lang.String r0 = "native_multiple_images"
            r8.putBoolean(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            boolean r7 = r7.zzg
            java.lang.String r0 = "use_custom_mute"
            r8.putBoolean(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r0 = r7.zzi
            if (r0 == 0) goto L_0x0094
            boolean r7 = r7.zzj
            java.lang.String r0 = "sccg_tap"
            r8.putBoolean(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r7 = r7.zzi
            java.lang.String r0 = "sccg_dir"
            r8.putInt(r0, r7)
        L_0x0094:
            android.content.pm.PackageInfo r7 = r6.zzc
            if (r7 != 0) goto L_0x009a
            r7 = 0
            goto L_0x009c
        L_0x009a:
            int r7 = r7.versionCode
        L_0x009c:
            com.google.android.gms.ads.internal.util.zzg r0 = r6.zzd
            int r0 = r0.zza()
            if (r7 <= r0) goto L_0x00ae
            com.google.android.gms.ads.internal.util.zzg r0 = r6.zzd
            r0.zzt()
            com.google.android.gms.ads.internal.util.zzg r0 = r6.zzd
            r0.zzw(r7)
        L_0x00ae:
            com.google.android.gms.ads.internal.util.zzg r7 = r6.zzd
            org.json.JSONObject r7 = r7.zzq()
            r0 = 0
            if (r7 == 0) goto L_0x00c6
            com.google.android.gms.internal.ads.zzfho r1 = r6.zzb
            java.lang.String r1 = r1.zzf
            org.json.JSONArray r7 = r7.optJSONArray(r1)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r0 = r7.toString()
            goto L_0x00c7
        L_0x00c6:
        L_0x00c7:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L_0x00d2
            java.lang.String r7 = "native_advanced_settings"
            r8.putString(r7, r0)
        L_0x00d2:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            int r7 = r7.zzk
            if (r7 <= r5) goto L_0x00dd
            java.lang.String r0 = "max_num_ads"
            r8.putInt(r0, r7)
        L_0x00dd:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbnz r7 = r7.zzb
            if (r7 == 0) goto L_0x0134
            java.lang.String r0 = r7.zzc
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0127
            int r0 = r7.zza
            r1 = 2
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r0 < r1) goto L_0x00fe
            int r7 = r7.zzd
            switch(r7) {
                case 2: goto L_0x00fc;
                case 3: goto L_0x00fb;
                default: goto L_0x00f9;
            }
        L_0x00f9:
            r2 = r3
            goto L_0x0120
        L_0x00fb:
            goto L_0x0120
        L_0x00fc:
            r2 = r3
            goto L_0x0120
        L_0x00fe:
            int r7 = r7.zzb
            switch(r7) {
                case 1: goto L_0x011e;
                case 2: goto L_0x011d;
                default: goto L_0x0103;
            }
        L_0x0103:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Instream ad video aspect ratio "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = " is wrong."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r7)
            goto L_0x011f
        L_0x011d:
            goto L_0x0120
        L_0x011e:
        L_0x011f:
            r2 = r3
        L_0x0120:
            java.lang.String r7 = "ia_var"
            r8.putString(r7, r2)
            goto L_0x012e
        L_0x0127:
            java.lang.String r7 = r7.zzc
            java.lang.String r0 = "ad_tag"
            r8.putString(r0, r7)
        L_0x012e:
            java.lang.String r7 = "instr"
            r8.putBoolean(r7, r5)
        L_0x0134:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbjm r7 = r7.zza()
            if (r7 == 0) goto L_0x0141
            java.lang.String r7 = "has_delayed_banner_listener"
            r8.putBoolean(r7, r5)
        L_0x0141:
            com.google.android.gms.internal.ads.zzbeg r7 = com.google.android.gms.internal.ads.zzbep.zzlO
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r7 = r0.zza(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x01a2
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            com.google.android.gms.ads.internal.client.zzfk r7 = r7.zzf
            if (r7 == 0) goto L_0x018c
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            com.google.android.gms.internal.ads.zzfho r0 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r0 = r0.zzi
            com.google.android.gms.ads.internal.client.zzfk r0 = r0.zzf
            boolean r0 = r0.zza
            java.lang.String r1 = "startMuted"
            r7.putBoolean(r1, r0)
            com.google.android.gms.internal.ads.zzfho r0 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r0 = r0.zzi
            com.google.android.gms.ads.internal.client.zzfk r0 = r0.zzf
            boolean r0 = r0.zzc
            java.lang.String r1 = "clickToExpandRequested"
            r7.putBoolean(r1, r0)
            com.google.android.gms.internal.ads.zzfho r0 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r0 = r0.zzi
            com.google.android.gms.ads.internal.client.zzfk r0 = r0.zzf
            boolean r0 = r0.zzb
            java.lang.String r1 = "customControlsRequested"
            r7.putBoolean(r1, r0)
            java.lang.String r0 = "video"
            r8.putBundle(r0, r7)
        L_0x018c:
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            boolean r7 = r7.zzb
            java.lang.String r0 = "disable_image_loading"
            r8.putBoolean(r0, r7)
            com.google.android.gms.internal.ads.zzfho r7 = r6.zzb
            com.google.android.gms.internal.ads.zzbhk r7 = r7.zzi
            int r7 = r7.zze
            java.lang.String r0 = "preferred_ad_choices_position"
            r8.putInt(r0, r7)
        L_0x01a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevt.zzd(java.util.ArrayList, android.os.Bundle):void");
    }
}
