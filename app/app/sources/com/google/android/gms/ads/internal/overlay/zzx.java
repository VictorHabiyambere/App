package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzchd;
import com.google.android.gms.internal.ads.zzfwd;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.android.gms.internal.ads.zzfwf;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzfwp;
import com.google.android.gms.internal.ads.zzfwr;
import com.google.android.gms.internal.ads.zzfws;
import com.google.android.gms.internal.ads.zzfwt;
import com.google.android.gms.internal.ads.zzfwu;
import com.google.android.gms.internal.ads.zzfxj;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzx {
    private String zza = null;
    private String zzb = null;
    private zzchd zzc = null;
    private zzfwf zzd = null;
    private boolean zze = false;
    private zzfws zzf;

    private final zzfwu zzl() {
        zzfwt zzc2 = zzfwu.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlx)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzw(this);
        }
    }

    public final synchronized void zza(zzchd zzchd, Context context) {
        this.zzc = zzchd;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzfwf zzfwf;
        if (!this.zze || (zzfwf = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfwf.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzc() {
        zzfwf zzfwf;
        if (!this.zze || (zzfwf = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfwd zzc2 = zzfwe.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlx)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzfwf.zzb(zzc2.zzc(), this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str, Map map) {
        zzcci.zze.execute(new zzv(this, str, map));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put("action", str2);
            zze("onError", hashMap);
        }
    }

    public final void zzg() {
        zzfwf zzfwf;
        if (!this.zze || (zzfwf = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfwf.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Map map) {
        zzchd zzchd = this.zzc;
        if (zzchd != null) {
            zzchd.zzd(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzfwr zzfwr) {
        if (!TextUtils.isEmpty(zzfwr.zzb())) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzlx)).booleanValue()) {
                this.zza = zzfwr.zzb();
            }
        }
        switch (zzfwr.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put("error", String.valueOf(zzfwr.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzchd zzchd, zzfwp zzfwp) {
        if (zzchd == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzchd;
        if (this.zze || zzk(zzchd.getContext())) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlx)).booleanValue()) {
                this.zzb = zzfwp.zzh();
            }
            zzm();
            zzfwf zzfwf = this.zzd;
            if (zzfwf != null) {
                zzfwf.zzd(zzfwp, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfxj.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfwg.zza(context);
        } catch (NullPointerException e) {
            zze.zza("Error connecting LMD Overlay service");
            zzu.zzo().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
