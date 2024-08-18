package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class SignRequestParams extends RequestParams {
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new zzk();
    public static final int MAX_DISPLAY_HINT_LENGTH = 80;
    private final Integer zza;
    private final Double zzb;
    private final Uri zzc;
    private final byte[] zzd;
    private final List zze;
    private final ChannelIdValue zzf;
    private final String zzg;
    private final Set zzh;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        Integer zza;
        Double zzb;
        Uri zzc;
        byte[] zzd;
        List zze;
        ChannelIdValue zzf;
        String zzg;

        public SignRequestParams build() {
            return new SignRequestParams(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder setAppId(Uri uri) {
            this.zzc = uri;
            return this;
        }

        public Builder setChannelIdValue(ChannelIdValue channelIdValue) {
            this.zzf = channelIdValue;
            return this;
        }

        public Builder setDefaultSignChallenge(byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        public Builder setDisplayHint(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setRegisteredKeys(List<RegisteredKey> list) {
            this.zze = list;
            return this;
        }

        public Builder setRequestId(Integer num) {
            this.zza = num;
            return this;
        }

        public Builder setTimeoutSeconds(Double d) {
            this.zzb = d;
            return this;
        }
    }

    SignRequestParams(Integer num, Double d, Uri uri, byte[] bArr, List list, ChannelIdValue channelIdValue, String str) {
        boolean z;
        this.zza = num;
        this.zzb = d;
        this.zzc = uri;
        this.zzd = bArr;
        boolean z2 = false;
        Preconditions.checkArgument(list != null && !list.isEmpty(), "registeredKeys must not be null or empty");
        this.zze = list;
        this.zzf = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it.next();
            Preconditions.checkArgument(registeredKey.getAppId() == null ? uri != null : true, "registered key has null appId and no request appId is provided");
            if (registeredKey.getChallengeValue() == null) {
                z = list != null;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "register request has null challenge and no default challenge isprovided");
            if (registeredKey.getAppId() != null) {
                hashSet.add(Uri.parse(registeredKey.getAppId()));
            }
        }
        this.zzh = hashSet;
        if (str == null) {
            z2 = true;
        } else if (str.length() <= 80) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Display Hint cannot be longer than 80 characters");
        this.zzg = str;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) o;
        return Objects.equal(this.zza, signRequestParams.zza) && Objects.equal(this.zzb, signRequestParams.zzb) && Objects.equal(this.zzc, signRequestParams.zzc) && Arrays.equals(this.zzd, signRequestParams.zzd) && this.zze.containsAll(signRequestParams.zze) && signRequestParams.zze.containsAll(this.zze) && Objects.equal(this.zzf, signRequestParams.zzf) && Objects.equal(this.zzg, signRequestParams.zzg);
    }

    public Set<Uri> getAllAppIds() {
        return this.zzh;
    }

    public Uri getAppId() {
        return this.zzc;
    }

    public ChannelIdValue getChannelIdValue() {
        return this.zzf;
    }

    public byte[] getDefaultSignChallenge() {
        return this.zzd;
    }

    public String getDisplayHint() {
        return this.zzg;
    }

    public List<RegisteredKey> getRegisteredKeys() {
        return this.zze;
    }

    public Integer getRequestId() {
        return this.zza;
    }

    public Double getTimeoutSeconds() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzc, this.zzb, this.zze, this.zzf, this.zzg, Integer.valueOf(Arrays.hashCode(this.zzd)));
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeIntegerObject(dest, 2, getRequestId(), false);
        SafeParcelWriter.writeDoubleObject(dest, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeParcelable(dest, 4, getAppId(), flags, false);
        SafeParcelWriter.writeByteArray(dest, 5, getDefaultSignChallenge(), false);
        SafeParcelWriter.writeTypedList(dest, 6, getRegisteredKeys(), false);
        SafeParcelWriter.writeParcelable(dest, 7, getChannelIdValue(), flags, false);
        SafeParcelWriter.writeString(dest, 8, getDisplayHint(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
