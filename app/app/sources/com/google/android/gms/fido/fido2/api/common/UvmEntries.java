package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.fido.zzap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public class UvmEntries extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();
    private final List zza;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static final class Builder {
        private final List zza = new ArrayList();

        public Builder addAll(List<UvmEntry> uvmEntryList) {
            boolean z;
            if (this.zza.size() + uvmEntryList.size() <= 3) {
                z = true;
            } else {
                z = false;
            }
            zzap.zzc(z);
            this.zza.addAll(uvmEntryList);
            return this;
        }

        public Builder addUvmEntry(UvmEntry uvmEntry) {
            if (this.zza.size() < 3) {
                this.zza.add(uvmEntry);
                return this;
            }
            throw new IllegalStateException();
        }

        public UvmEntries build() {
            return new UvmEntries(this.zza);
        }
    }

    UvmEntries(List list) {
        this.zza = list;
    }

    public boolean equals(Object obj) {
        List list;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        List list2 = this.zza;
        if ((list2 != null || uvmEntries.zza != null) && (list2 == null || (list = uvmEntries.zza) == null || !list2.containsAll(list) || !uvmEntries.zza.containsAll(this.zza))) {
            return false;
        }
        return true;
    }

    public List<UvmEntry> getUvmEntryList() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(new HashSet(this.zza));
    }

    public void writeToParcel(Parcel dest, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeTypedList(dest, 1, getUvmEntryList(), false);
        SafeParcelWriter.finishObjectHeader(dest, beginObjectHeader);
    }

    public final JSONArray zza() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (this.zza != null) {
                for (int i = 0; i < this.zza.size(); i++) {
                    UvmEntry uvmEntry = (UvmEntry) this.zza.get(i);
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(uvmEntry.getMatcherProtectionType());
                    jSONArray2.put(uvmEntry.getKeyProtectionType());
                    jSONArray2.put(uvmEntry.getMatcherProtectionType());
                    jSONArray.put(i, jSONArray2);
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            throw new RuntimeException("Error encoding UvmEntries to JSON object", e);
        }
    }
}
