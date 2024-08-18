package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbpv implements zzbom, zzbpu {
    private final zzbpu zza;
    private final HashSet zzb = new HashSet();

    public zzbpv(zzbpu zzbpu) {
        this.zza = zzbpu;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbol.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzblp) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzblp) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbol.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbol.zzb(this, str, jSONObject);
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbol.zzd(this, str, jSONObject);
    }

    public final void zzq(String str, zzblp zzblp) {
        this.zza.zzq(str, zzblp);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzblp));
    }

    public final void zzr(String str, zzblp zzblp) {
        this.zza.zzr(str, zzblp);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzblp));
    }
}
