package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeea extends zzbxg {
    private final Context zza;
    private final zzezl zzb;
    private final zzezj zzc;
    private final zzeei zzd;
    private final zzgge zze;
    private final zzeef zzf;
    private final zzbyd zzg;

    zzeea(Context context, zzezl zzezl, zzezj zzezj, zzeef zzeef, zzeei zzeei, zzgge zzgge, zzbyd zzbyd) {
        this.zza = context;
        this.zzb = zzezl;
        this.zzc = zzezj;
        this.zzf = zzeef;
        this.zzd = zzeei;
        this.zze = zzgge;
        this.zzg = zzbyd;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbxk zzbxk) {
        zzgft.zzr(zzgft.zzn(zzgfk.zzu(listenableFuture), new zzedx(this), zzcci.zza), new zzedz(this, zzbxk), zzcci.zzf);
    }

    public final ListenableFuture zzb(zzbwz zzbwz, int i) {
        ListenableFuture listenableFuture;
        HashMap hashMap = new HashMap();
        Bundle bundle = zzbwz.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    hashMap.put(str, string);
                }
            }
        }
        zzeec zzeec = new zzeec(zzbwz.zza, zzbwz.zzb, hashMap, zzbwz.zzd, "", zzbwz.zze);
        zzezj zzezj = this.zzc;
        zzezj.zza(new zzfar(zzbwz));
        boolean z = zzeec.zzf;
        zzezk zzb2 = zzezj.zzb();
        if (z) {
            String str2 = zzbwz.zza;
            String str3 = (String) zzbgr.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                String host = Uri.parse(str2).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it = zzfyt.zzc(zzfxr.zzc(';')).zzd(str3).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (host.endsWith((String) it.next())) {
                                listenableFuture = zzgft.zzm(zzb2.zza().zza(new JSONObject(), new Bundle()), new zzeds(zzeec), this.zze);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        listenableFuture = zzgft.zzh(zzeec);
        zzflt zzb3 = zzb2.zzb();
        return zzgft.zzn(zzb3.zzb(zzfln.HTTP, listenableFuture).zze(new zzeee(this.zza, "", this.zzg, i)).zza(), new zzedt(), this.zze);
    }

    public final void zze(zzbwz zzbwz, zzbxk zzbxk) {
        zzc(zzb(zzbwz, Binder.getCallingUid()), zzbxk);
    }

    public final void zzf(zzbwv zzbwv, zzbxk zzbxk) {
        zzeza zzeza = new zzeza(zzbwv, Binder.getCallingUid());
        zzezl zzezl = this.zzb;
        zzezl.zza(zzeza);
        zzezm zzb2 = zzezl.zzb();
        zzflt zzb3 = zzb2.zzb();
        zzfky zza2 = zzb3.zzb(zzfln.GMS_SIGNALS, zzgft.zzi()).zzf(new zzedw(zzb2)).zze(new zzedv()).zzf(new zzedu()).zza();
        zzc(zza2, zzbxk);
        if (((Boolean) zzbgk.zzf.zze()).booleanValue()) {
            zzeei zzeei = this.zzd;
            Objects.requireNonNull(zzeei);
            zza2.addListener(new zzedy(zzeei), this.zze);
        }
    }
}
