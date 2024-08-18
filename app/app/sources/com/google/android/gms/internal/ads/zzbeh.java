package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbeh {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbeg zza2 : this.zzb) {
            String str = (String) zzba.zzc().zza(zza2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbeq.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbeg zza3 : this.zzc) {
            String str = (String) zzba.zzc().zza(zza3);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbeq.zzb());
        return zza2;
    }

    public final void zzc(zzbeg zzbeg) {
        this.zzb.add(zzbeg);
    }

    public final void zzd(zzbeg zzbeg) {
        this.zza.add(zzbeg);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbeg zzbeg : this.zza) {
            if (zzbeg.zze() == 1) {
                zzbeg.zzd(editor, zzbeg.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzm.zzg("Flag Json is null.");
        }
    }
}
