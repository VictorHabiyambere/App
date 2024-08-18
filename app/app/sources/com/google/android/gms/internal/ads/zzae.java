package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzae implements Comparator<zzad>, Parcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new zzab();
    public final String zza;
    public final int zzb;
    private final zzad[] zzc;
    private int zzd;

    zzae(Parcel parcel) {
        this.zza = parcel.readString();
        int i = zzgd.zza;
        this.zzc = (zzad[]) parcel.createTypedArray(zzad.CREATOR);
        this.zzb = this.zzc.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzad zzad = (zzad) obj;
        zzad zzad2 = (zzad) obj2;
        if (zzo.zza.equals(zzad.zza)) {
            return !zzo.zza.equals(zzad2.zza) ? 1 : 0;
        }
        return zzad.zza.compareTo(zzad2.zza);
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
        zzae zzae = (zzae) obj;
        return zzgd.zzG(this.zza, zzae.zza) && Arrays.equals(this.zzc, zzae.zzc);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzc, 0);
    }

    public final zzad zza(int i) {
        return this.zzc[i];
    }

    public final zzae zzb(String str) {
        if (zzgd.zzG(this.zza, str)) {
            return this;
        }
        return new zzae(str, false, this.zzc);
    }

    public final int hashCode() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode = (i * 31) + Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzad[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzae(java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzad... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzad[] r3 = (com.google.android.gms.internal.ads.zzad[]) r3
        L_0x000e:
            r0.zzc = r3
            int r1 = r3.length
            r0.zzb = r1
            com.google.android.gms.internal.ads.zzad[] r1 = r0.zzc
            java.util.Arrays.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzae.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzad[]):void");
    }

    public zzae(String str, zzad... zzadArr) {
        this((String) null, true, zzadArr);
    }

    public zzae(List list) {
        this((String) null, false, (zzad[]) list.toArray(new zzad[0]));
    }
}
