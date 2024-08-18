package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcze extends zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzehq zzh;
    private final Bundle zzi;

    public zzcze(zzfgt zzfgt, String str, zzehq zzehq, zzfgw zzfgw, String str2) {
        String str3;
        String str4;
        String str5 = null;
        if (zzfgt == null) {
            str3 = null;
        } else {
            str3 = zzfgt.zzac;
        }
        this.zzb = str3;
        this.zzc = str2;
        if (zzfgw == null) {
            str4 = null;
        } else {
            str4 = zzfgw.zzb;
        }
        this.zzd = str4;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str5 = zzfgt.zzw.getString("class_name");
            } catch (JSONException e) {
            }
        }
        this.zza = str5 != null ? str5 : str;
        this.zze = zzehq.zzc();
        this.zzh = zzehq;
        this.zzf = zzu.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgZ)).booleanValue() || zzfgw == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfgw.zzj;
        }
        this.zzg = (!((Boolean) zzba.zzc().zza(zzbep.zzjl)).booleanValue() || zzfgw == null || TextUtils.isEmpty(zzfgw.zzh)) ? "" : zzfgw.zzh;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final com.google.android.gms.ads.internal.client.zzu zzf() {
        zzehq zzehq = this.zzh;
        if (zzehq != null) {
            return zzehq.zza();
        }
        return null;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        return this.zzb;
    }

    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
