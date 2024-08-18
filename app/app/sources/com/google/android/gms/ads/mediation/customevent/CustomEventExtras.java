package com.google.android.gms.ads.mediation.customevent;

import java.util.HashMap;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class CustomEventExtras {
    private final HashMap zza = new HashMap();

    public Object getExtra(String label) {
        return this.zza.get(label);
    }

    public void setExtra(String label, Object value) {
        this.zza.put(label, value);
    }
}
