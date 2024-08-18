package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    final int zza;
    final long zzb;
    final String zzc;
    final int zzd;
    final int zze;
    final String zzf;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = (String) Preconditions.checkNotNull(str);
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str2;
    }

    public boolean equals(Object that) {
        if (!(that instanceof AccountChangeEvent)) {
            return false;
        }
        if (that == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) that;
        return this.zza == accountChangeEvent.zza && this.zzb == accountChangeEvent.zzb && Objects.equal(this.zzc, accountChangeEvent.zzc) && this.zzd == accountChangeEvent.zzd && this.zze == accountChangeEvent.zze && Objects.equal(this.zzf, accountChangeEvent.zzf);
    }

    public String getAccountName() {
        return this.zzc;
    }

    public String getChangeData() {
        return this.zzf;
    }

    public int getChangeType() {
        return this.zzd;
    }

    public int getEventIndex() {
        return this.zze;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf);
    }

    public String toString() {
        String str;
        switch (this.zzd) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        String str2 = this.zzc;
        String str3 = this.zzf;
        int i = this.zze;
        return "AccountChangeEvent {accountName = " + str2 + ", changeType = " + str + ", changeData = " + str3 + ", eventIndex = " + i + "}";
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeInt(dest, 1, this.zza);
        SafeParcelWriter.writeLong(dest, 2, this.zzb);
        SafeParcelWriter.writeString(dest, 3, this.zzc, false);
        SafeParcelWriter.writeInt(dest, 4, this.zzd);
        SafeParcelWriter.writeInt(dest, 5, this.zze);
        SafeParcelWriter.writeString(dest, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public AccountChangeEvent(long id, String accountName, int changeType, int eventIndex, String changeData) {
        this.zza = 1;
        this.zzb = id;
        this.zzc = (String) Preconditions.checkNotNull(accountName);
        this.zzd = changeType;
        this.zze = eventIndex;
        this.zzf = changeData;
    }
}
