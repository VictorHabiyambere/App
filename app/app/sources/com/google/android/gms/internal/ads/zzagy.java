package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzagy implements zzcc {
    public static final Parcelable.Creator<zzagy> CREATOR = new zzagx();
    public final String zza;
    public final String zzb;

    protected zzagy(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzgd.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzagy zzagy = (zzagy) obj;
        return this.zza.equals(zzagy.zza) && this.zzb.equals(zzagy.zzb);
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + "=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzby r3) {
        /*
            r2 = this;
            java.lang.String r0 = r2.zza
            int r1 = r0.hashCode()
            switch(r1) {
                case 62359119: goto L_0x0033;
                case 79833656: goto L_0x0029;
                case 428414940: goto L_0x001f;
                case 1746739798: goto L_0x0015;
                case 1939198791: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x003d
        L_0x000a:
            java.lang.String r1 = "ARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x003e
        L_0x0015:
            java.lang.String r1 = "ALBUMARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x003e
        L_0x001f:
            java.lang.String r1 = "DESCRIPTION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x003e
        L_0x0029:
            java.lang.String r1 = "TITLE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x003e
        L_0x0033:
            java.lang.String r1 = "ALBUM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x003e
        L_0x003d:
            r0 = -1
        L_0x003e:
            switch(r0) {
                case 0: goto L_0x005a;
                case 1: goto L_0x0054;
                case 2: goto L_0x004e;
                case 3: goto L_0x0048;
                case 4: goto L_0x0042;
                default: goto L_0x0041;
            }
        L_0x0041:
            return
        L_0x0042:
            java.lang.String r0 = r2.zzb
            r3.zzh(r0)
            return
        L_0x0048:
            java.lang.String r0 = r2.zzb
            r3.zzc(r0)
            return
        L_0x004e:
            java.lang.String r0 = r2.zzb
            r3.zzd(r0)
            return
        L_0x0054:
            java.lang.String r0 = r2.zzb
            r3.zze(r0)
            return
        L_0x005a:
            java.lang.String r0 = r2.zzb
            r3.zzq(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagy.zza(com.google.android.gms.internal.ads.zzby):void");
    }

    public zzagy(String str, String str2) {
        this.zza = zzfxm.zzb(str);
        this.zzb = str2;
    }
}
