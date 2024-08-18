package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzefq extends zzegm {
    private final Activity zza;
    private final zzm zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzefq(Activity activity, zzm zzm, String str, String str2, zzefp zzefp) {
        this.zza = activity;
        this.zzb = zzm;
        this.zzc = str;
        this.zzd = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1 = r4.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r1 = r4.zzd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.ads.zzegm
            r2 = 0
            if (r1 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzegm r5 = (com.google.android.gms.internal.ads.zzegm) r5
            android.app.Activity r1 = r4.zza
            android.app.Activity r3 = r5.zza()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005a
            com.google.android.gms.ads.internal.overlay.zzm r1 = r4.zzb
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.ads.internal.overlay.zzm r1 = r5.zzb()
            if (r1 != 0) goto L_0x005a
        L_0x0021:
            goto L_0x002d
        L_0x0022:
            com.google.android.gms.ads.internal.overlay.zzm r3 = r5.zzb()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005a
            goto L_0x0021
        L_0x002d:
            java.lang.String r1 = r4.zzc
            if (r1 != 0) goto L_0x0038
            java.lang.String r1 = r5.zzc()
            if (r1 != 0) goto L_0x005a
        L_0x0037:
            goto L_0x0043
        L_0x0038:
            java.lang.String r3 = r5.zzc()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005a
            goto L_0x0037
        L_0x0043:
            java.lang.String r1 = r4.zzd
            if (r1 != 0) goto L_0x004e
            java.lang.String r5 = r5.zzd()
            if (r5 != 0) goto L_0x0058
            goto L_0x0059
        L_0x004e:
            java.lang.String r5 = r5.zzd()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0059
        L_0x0058:
            goto L_0x005a
        L_0x0059:
            return r0
        L_0x005a:
            return r2
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefq.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzm zzm = this.zzb;
        int i3 = 0;
        if (zzm == null) {
            i = 0;
        } else {
            i = zzm.hashCode();
        }
        int i4 = ((hashCode * 1000003) ^ i) * 1000003;
        String str = this.zzc;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i5 = (i4 ^ i2) * 1000003;
        String str2 = this.zzd;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i5 ^ i3;
    }

    public final String toString() {
        zzm zzm = this.zzb;
        String obj = this.zza.toString();
        String valueOf = String.valueOf(zzm);
        return "OfflineUtilsParams{activity=" + obj + ", adOverlay=" + valueOf + ", gwsQueryId=" + this.zzc + ", uri=" + this.zzd + "}";
    }

    public final Activity zza() {
        return this.zza;
    }

    public final zzm zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
