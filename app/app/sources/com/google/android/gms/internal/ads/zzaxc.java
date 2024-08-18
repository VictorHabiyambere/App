package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaxc extends zzaxb {
    protected zzaxc(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzaxc zzt(String str, Context context, boolean z) {
        zzr(context, false);
        return new zzaxc(context, str, false);
    }

    @Deprecated
    public static zzaxc zzu(String str, Context context, boolean z, int i) {
        zzr(context, z);
        return new zzaxc(context, str, z);
    }

    /* access modifiers changed from: protected */
    public final List zzp(zzaye zzaye, Context context, zzatp zzatp, zzatg zzatg) {
        if (zzaye.zzk() == null || !this.zzu) {
            return super.zzp(zzaye, context, zzatp, (zzatg) null);
        }
        int zza = zzaye.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzaye, context, zzatp, (zzatg) null));
        arrayList.add(new zzayw(zzaye, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzatp, zza, 24));
        return arrayList;
    }
}
