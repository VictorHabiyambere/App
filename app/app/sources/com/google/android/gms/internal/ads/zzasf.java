package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzasf extends zzars {
    public zzasf() {
        throw null;
    }

    public zzasf(zzase zzase, SSLSocketFactory sSLSocketFactory) {
    }

    static List zza(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String zzaqw : (List) entry.getValue()) {
                    arrayList.add(new zzaqw((String) entry.getKey(), zzaqw));
                }
            }
        }
        return arrayList;
    }
}
