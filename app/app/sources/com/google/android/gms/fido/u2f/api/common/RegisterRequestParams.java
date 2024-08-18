package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class RegisterRequestParams extends RequestParams {
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new zzh();
    public static final int MAX_DISPLAY_HINT_LENGTH = 80;
    private final Integer zza;
    private final Double zzb;
    private final Uri zzc;
    private final List zzd;
    private final List zze;
    private final ChannelIdValue zzf;
    private final String zzg;
    private Set zzh;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        Integer zza;
        Double zzb;
        Uri zzc;
        List zzd;
        List zze;
        ChannelIdValue zzf;
        String zzg;

        public RegisterRequestParams build() {
            return new RegisterRequestParams(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public Builder setAppId(Uri uri) {
            this.zzc = uri;
            return this;
        }

        public Builder setChannelIdValue(ChannelIdValue channelIdValue) {
            this.zzf = channelIdValue;
            return this;
        }

        public Builder setDisplayHint(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setRegisterRequests(List<RegisterRequest> list) {
            this.zzd = list;
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

    RegisterRequestParams(Integer num, Double d, Uri uri, List list, List list2, ChannelIdValue channelIdValue, String str) {
        boolean z;
        boolean z2;
        this.zza = num;
        this.zzb = d;
        this.zzc = uri;
        boolean z3 = false;
        Preconditions.checkArgument(list != null && !list.isEmpty(), "empty list of register requests is provided");
        this.zzd = list;
        this.zze = list2;
        this.zzf = channelIdValue;
        Uri uri2 = this.zzc;
        List<RegisterRequest> list3 = this.zzd;
        List<RegisteredKey> list4 = this.zze;
        HashSet hashSet = new HashSet();
        if (uri2 != null) {
            hashSet.add(uri2);
        }
        for (RegisterRequest registerRequest : list3) {
            if (uri2 == null) {
                z2 = registerRequest.getAppId() != null;
            } else {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "register request has null appId and no request appId is provided");
            if (registerRequest.getAppId() != null) {
                hashSet.add(Uri.parse(registerRequest.getAppId()));
            }
        }
        for (RegisteredKey registeredKey : list4) {
            if (uri2 == null) {
                z = registeredKey.getAppId() != null;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z, "registered key has null appId and no request appId is provided");
            if (registeredKey.getAppId() != null) {
                hashSet.add(Uri.parse(registeredKey.getAppId()));
            }
        }
        this.zzh = hashSet;
        if (str == null) {
            z3 = true;
        } else if (str.length() <= 80) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Display Hint cannot be longer than 80 characters");
        this.zzg = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        r1 = r4.zze;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r3 = r5.zze;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0005
            return r0
        L_0x0005:
            boolean r1 = r5 instanceof com.google.android.gms.fido.u2f.api.common.RegisterRequestParams
            r2 = 0
            if (r1 != 0) goto L_0x000b
            return r2
        L_0x000b:
            com.google.android.gms.fido.u2f.api.common.RegisterRequestParams r5 = (com.google.android.gms.fido.u2f.api.common.RegisterRequestParams) r5
            java.lang.Integer r1 = r4.zza
            java.lang.Integer r3 = r5.zza
            boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
            if (r1 == 0) goto L_0x0068
            java.lang.Double r1 = r4.zzb
            java.lang.Double r3 = r5.zzb
            boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
            if (r1 == 0) goto L_0x0068
            android.net.Uri r1 = r4.zzc
            android.net.Uri r3 = r5.zzc
            boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
            if (r1 == 0) goto L_0x0068
            java.util.List r1 = r4.zzd
            java.util.List r3 = r5.zzd
            boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
            if (r1 == 0) goto L_0x0068
            java.util.List r1 = r4.zze
            if (r1 != 0) goto L_0x003d
            java.util.List r3 = r5.zze
            if (r3 == 0) goto L_0x0053
        L_0x003d:
            if (r1 == 0) goto L_0x0068
            java.util.List r3 = r5.zze
            if (r3 == 0) goto L_0x0068
            boolean r1 = r1.containsAll(r3)
            if (r1 == 0) goto L_0x0068
            java.util.List r1 = r5.zze
            java.util.List r3 = r4.zze
            boolean r1 = r1.containsAll(r3)
            if (r1 == 0) goto L_0x0068
        L_0x0053:
            com.google.android.gms.fido.u2f.api.common.ChannelIdValue r1 = r4.zzf
            com.google.android.gms.fido.u2f.api.common.ChannelIdValue r3 = r5.zzf
            boolean r1 = com.google.android.gms.common.internal.Objects.equal(r1, r3)
            if (r1 == 0) goto L_0x0068
            java.lang.String r1 = r4.zzg
            java.lang.String r5 = r5.zzg
            boolean r5 = com.google.android.gms.common.internal.Objects.equal(r1, r5)
            if (r5 == 0) goto L_0x0068
            return r0
        L_0x0068:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fido.u2f.api.common.RegisterRequestParams.equals(java.lang.Object):boolean");
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

    public String getDisplayHint() {
        return this.zzg;
    }

    public List<RegisterRequest> getRegisterRequests() {
        return this.zzd;
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
        return Objects.hashCode(this.zza, this.zzc, this.zzb, this.zzd, this.zze, this.zzf, this.zzg);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeIntegerObject(dest, 2, getRequestId(), false);
        SafeParcelWriter.writeDoubleObject(dest, 3, getTimeoutSeconds(), false);
        SafeParcelWriter.writeParcelable(dest, 4, getAppId(), flags, false);
        SafeParcelWriter.writeTypedList(dest, 5, getRegisterRequests(), false);
        SafeParcelWriter.writeTypedList(dest, 6, getRegisteredKeys(), false);
        SafeParcelWriter.writeParcelable(dest, 7, getChannelIdValue(), flags, false);
        SafeParcelWriter.writeString(dest, 8, getDisplayHint(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }
}
