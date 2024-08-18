package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvh;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzk {
    /* access modifiers changed from: private */
    public final int zza;
    private final long zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Map zze;
    /* access modifiers changed from: private */
    public final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final zzdvh zzh;
    private Map zzi;

    public zzk(zzdvh zzdvh) {
        this.zzh = zzdvh;
        this.zza = ((Integer) zzba.zzc().zza(zzbep.zzhh)).intValue();
        this.zzb = ((Long) zzba.zzc().zza(zzbep.zzhi)).longValue();
        this.zzc = ((Boolean) zzba.zzc().zza(zzbep.zzhn)).booleanValue();
        this.zzd = ((Boolean) zzba.zzc().zza(zzbep.zzhl)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzj(this));
    }

    private final synchronized void zzg(zzdux zzdux) {
        if (this.zzc) {
            ArrayDeque arrayDeque = this.zzg;
            ArrayDeque clone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.zzf;
            ArrayDeque clone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzcci.zza.execute(new zzi(this, zzdux, clone, clone2));
        }
    }

    private final void zzh(zzdux zzdux, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            this.zzi = new ConcurrentHashMap(zzdux.zzb());
            this.zzi.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzp.zzb(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException e) {
                    pair = new Pair("", "");
                }
                zzj(this.zzi, "e_type", (String) pair.first);
                zzj(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zzf(this.zzi);
        }
    }

    private final synchronized void zzi() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (currentTimeMillis - ((Long) ((Pair) entry.getValue()).first).longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            zzu.zzo().zzw(e, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzj(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final synchronized String zzb(String str, zzdux zzdux) {
        Pair pair = (Pair) this.zze.get(str);
        zzdux.zzb().put("request_id", str);
        if (pair != null) {
            String str2 = (String) pair.second;
            this.zze.remove(str);
            zzdux.zzb().put("mhit", "true");
            return str2;
        }
        zzdux.zzb().put("mhit", "false");
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzdux zzdux) {
        this.zze.put(str, new Pair(Long.valueOf(zzu.zzB().currentTimeMillis()), str2));
        zzi();
        zzg(zzdux);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzdux zzdux, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzh(zzdux, arrayDeque, TypedValues.TransitionType.S_TO);
        zzh(zzdux, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }
}
