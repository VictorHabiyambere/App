package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.zzn;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzn();
    public final int zza;
    @Deprecated
    public final long zzb;
    public final Bundle zzc;
    @Deprecated
    public final int zzd;
    public final List zze;
    public final boolean zzf;
    public final int zzg;
    public final boolean zzh;
    public final String zzi;
    public final zzfh zzj;
    public final Location zzk;
    public final String zzl;
    public final Bundle zzm;
    public final Bundle zzn;
    public final List zzo;
    public final String zzp;
    public final String zzq;
    @Deprecated
    public final boolean zzr;
    public final zzc zzs;
    public final int zzt;
    public final String zzu;
    public final List zzv;
    public final int zzw;
    public final String zzx;
    public final int zzy;
    public final long zzz;

    public zzl(int i, long j, Bundle bundle, int i2, List list, boolean z, int i3, boolean z2, String str, zzfh zzfh, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3, zzc zzc2, int i4, String str5, List list3, int i5, String str6, int i6, long j2) {
        Bundle bundle4;
        Bundle bundle5;
        List list4;
        this.zza = i;
        this.zzb = j;
        if (bundle == null) {
            bundle4 = new Bundle();
        } else {
            bundle4 = bundle;
        }
        this.zzc = bundle4;
        this.zzd = i2;
        this.zze = list;
        this.zzf = z;
        this.zzg = i3;
        this.zzh = z2;
        this.zzi = str;
        this.zzj = zzfh;
        this.zzk = location;
        this.zzl = str2;
        if (bundle2 == null) {
            bundle5 = new Bundle();
        } else {
            bundle5 = bundle2;
        }
        this.zzm = bundle5;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = str3;
        this.zzq = str4;
        this.zzr = z3;
        this.zzs = zzc2;
        this.zzt = i4;
        this.zzu = str5;
        if (list3 == null) {
            list4 = new ArrayList();
        } else {
            list4 = list3;
        }
        this.zzv = list4;
        this.zzw = i5;
        this.zzx = str6;
        this.zzy = i6;
        this.zzz = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl2 = (zzl) obj;
        if (this.zza != zzl2.zza || this.zzb != zzl2.zzb || !zzn.zza(this.zzc, zzl2.zzc) || this.zzd != zzl2.zzd || !Objects.equal(this.zze, zzl2.zze) || this.zzf != zzl2.zzf || this.zzg != zzl2.zzg || this.zzh != zzl2.zzh || !Objects.equal(this.zzi, zzl2.zzi) || !Objects.equal(this.zzj, zzl2.zzj) || !Objects.equal(this.zzk, zzl2.zzk) || !Objects.equal(this.zzl, zzl2.zzl) || !zzn.zza(this.zzm, zzl2.zzm) || !zzn.zza(this.zzn, zzl2.zzn) || !Objects.equal(this.zzo, zzl2.zzo) || !Objects.equal(this.zzp, zzl2.zzp) || !Objects.equal(this.zzq, zzl2.zzq) || this.zzr != zzl2.zzr || this.zzt != zzl2.zzt || !Objects.equal(this.zzu, zzl2.zzu) || !Objects.equal(this.zzv, zzl2.zzv) || this.zzw != zzl2.zzw || !Objects.equal(this.zzx, zzl2.zzx) || this.zzy != zzl2.zzy || this.zzz != zzl2.zzz) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, Boolean.valueOf(this.zzf), Integer.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Boolean.valueOf(this.zzr), Integer.valueOf(this.zzt), this.zzu, this.zzv, Integer.valueOf(this.zzw), this.zzx, Integer.valueOf(this.zzy), Long.valueOf(this.zzz));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzr);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzs, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzt);
        SafeParcelWriter.writeString(parcel, 21, this.zzu, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzv, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzw);
        SafeParcelWriter.writeString(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeInt(parcel, 25, this.zzy);
        SafeParcelWriter.writeLong(parcel, 26, this.zzz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
