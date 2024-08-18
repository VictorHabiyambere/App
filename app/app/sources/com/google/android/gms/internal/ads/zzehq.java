package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzehq {
    private final List zza = Collections.synchronizedList(new ArrayList());
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final String zzc;
    private zzfgw zzd = null;
    private zzfgt zze = null;
    private zzu zzf = null;

    public zzehq(String str) {
        this.zzc = str;
    }

    private static String zzj(zzfgt zzfgt) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzdA)).booleanValue()) {
            return zzfgt.zzaq;
        }
        return zzfgt.zzx;
    }

    private final synchronized void zzk(zzfgt zzfgt, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Map map = this.zzb;
        String zzj = zzj(zzfgt);
        if (!map.containsKey(zzj)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzfgt.zzw.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzfgt.zzw.getString(next));
                } catch (JSONException e) {
                }
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzgX)).booleanValue()) {
                String str5 = zzfgt.zzG;
                String str6 = zzfgt.zzH;
                str4 = str5;
                str3 = str6;
                str2 = zzfgt.zzI;
                str = zzfgt.zzJ;
            } else {
                str4 = "";
                str3 = "";
                str2 = "";
                str = "";
            }
            zzu zzu = new zzu(zzfgt.zzF, 0, (zze) null, bundle, str4, str3, str2, str);
            try {
                this.zza.add(i, zzu);
            } catch (IndexOutOfBoundsException e2) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e2, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
            }
            this.zzb.put(zzj, zzu);
        }
    }

    private final void zzl(zzfgt zzfgt, long j, zze zze2, boolean z) {
        Map map = this.zzb;
        String zzj = zzj(zzfgt);
        if (map.containsKey(zzj)) {
            if (this.zze == null) {
                this.zze = zzfgt;
            }
            zzu zzu = (zzu) this.zzb.get(zzj);
            zzu.zzb = j;
            zzu.zzc = zze2;
            if (((Boolean) zzba.zzc().zza(zzbep.zzgY)).booleanValue() && z) {
                this.zzf = zzu;
            }
        }
    }

    public final zzu zza() {
        return this.zzf;
    }

    public final zzcze zzb() {
        return new zzcze(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfgt zzfgt) {
        zzk(zzfgt, this.zza.size());
    }

    public final void zze(zzfgt zzfgt) {
        int indexOf = this.zza.indexOf(this.zzb.get(zzj(zzfgt)));
        if (indexOf < 0 || indexOf >= this.zzb.size()) {
            indexOf = this.zza.indexOf(this.zzf);
        }
        if (indexOf >= 0 && indexOf < this.zzb.size()) {
            this.zzf = (zzu) this.zza.get(indexOf);
            while (true) {
                indexOf++;
                if (indexOf < this.zza.size()) {
                    zzu zzu = (zzu) this.zza.get(indexOf);
                    zzu.zzb = 0;
                    zzu.zzc = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzf(zzfgt zzfgt, long j, zze zze2) {
        zzl(zzfgt, j, zze2, false);
    }

    public final void zzg(zzfgt zzfgt, long j, zze zze2) {
        zzl(zzfgt, j, (zze) null, true);
    }

    public final synchronized void zzh(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int indexOf = this.zza.indexOf((zzu) this.zzb.get(str));
            try {
                this.zza.remove(indexOf);
            } catch (IndexOutOfBoundsException e) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzk((zzfgt) it.next(), indexOf);
                indexOf++;
            }
        }
    }

    public final void zzi(zzfgw zzfgw) {
        this.zzd = zzfgw;
    }
}
