package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzefn extends zzefr {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    zzefn(String str, String str2, Drawable drawable) {
        if (str != null) {
            this.zza = str;
            if (str2 != null) {
                this.zzb = str2;
                this.zzc = drawable;
                return;
            }
            throw new NullPointerException("Null imageUrl");
        }
        throw new NullPointerException("Null advertiserName");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r1 = r4.zzc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.gms.internal.ads.zzefr
            r2 = 0
            if (r1 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzefr r5 = (com.google.android.gms.internal.ads.zzefr) r5
            java.lang.String r1 = r4.zza
            java.lang.String r3 = r5.zzb()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = r4.zzb
            java.lang.String r3 = r5.zzc()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x003a
            android.graphics.drawable.Drawable r1 = r4.zzc
            if (r1 != 0) goto L_0x002e
            android.graphics.drawable.Drawable r5 = r5.zza()
            if (r5 != 0) goto L_0x0038
            goto L_0x0039
        L_0x002e:
            android.graphics.drawable.Drawable r5 = r5.zza()
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x0039
        L_0x0038:
            goto L_0x003a
        L_0x0039:
            return r0
        L_0x003a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefn.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        if (drawable == null) {
            i = 0;
        } else {
            i = drawable.hashCode();
        }
        return (hashCode * 1000003) ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + ", icon=" + valueOf + "}";
    }

    /* access modifiers changed from: package-private */
    public final Drawable zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzb;
    }
}
