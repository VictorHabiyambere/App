package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdyl implements zzp, zzcit {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdya zzc;
    private zzchd zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzda zzh;
    private boolean zzi;

    zzdyl(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzl(zzda zzda) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zziU)).booleanValue()) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzda.zze(zzfiq.zzd(16, (String) null, (zze) null));
            } catch (RemoteException e) {
            }
        } else if (this.zzc == null) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzu.zzo().zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzda.zze(zzfiq.zzd(16, (String) null, (zze) null));
            } catch (RemoteException e2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzu.zzB().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzba.zzc().zza(zzbep.zziX)).intValue())) {
                    return true;
                }
            }
            zzm.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzda.zze(zzfiq.zzd(19, (String) null, (zze) null));
            } catch (RemoteException e3) {
            }
        }
        return false;
        return false;
        return false;
    }

    public final synchronized void zza(boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        zzm.zzj("Ad inspector failed to load.");
        try {
            zzcby zzo = zzu.zzo();
            zzo.zzw(new Exception("Failed to load UI. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            zzda zzda = this.zzh;
            if (zzda != null) {
                zzda.zze(zzfiq.zzd(17, (String) null, (zze) null));
            }
        } catch (RemoteException e) {
            zzu.zzo().zzw(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final synchronized void zzdr() {
        this.zzf = true;
        zzk("");
    }

    public final void zzdt() {
    }

    public final synchronized void zzdu(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            zzda zzda = this.zzh;
            if (zzda != null) {
                try {
                    zzda.zze((zze) null);
                } catch (RemoteException e) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzchd zzchd = this.zzd;
        if (zzchd == null || zzchd.zzaE()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdya zzdya) {
        this.zzc = zzdya;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze2 = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze2.put("redirectUrl", str);
            } catch (JSONException e) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze2.toString());
    }

    public final synchronized void zzj(zzda zzda, zzbmj zzbmj, zzbmc zzbmc, zzblq zzblq) {
        zzda zzda2 = zzda;
        synchronized (this) {
            if (zzl(zzda)) {
                try {
                    zzu.zzz();
                    this.zzd = zzchq.zza(this.zza, zzcix.zza(), "", false, false, (zzaxd) null, (zzbfs) null, this.zzb, (zzbfe) null, (com.google.android.gms.ads.internal.zzm) null, (zza) null, zzbdm.zza(), (zzfgt) null, (zzfgw) null, (zzegk) null, (zzfhs) null);
                    zzciv zzN = this.zzd.zzN();
                    if (zzN == null) {
                        zzm.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzu.zzo().zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                            zzda2.zze(zzfiq.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                        } catch (RemoteException e) {
                            zzu.zzo().zzw(e, "InspectorUi.openInspector 3");
                        }
                    } else {
                        this.zzh = zzda2;
                        zzN.zzR((com.google.android.gms.ads.internal.client.zza) null, (zzbkf) null, (zzp) null, (zzbkh) null, (zzaa) null, false, (zzbls) null, (zzb) null, (zzbuk) null, (zzcaf) null, (zzefz) null, (zzfoe) null, (zzdvc) null, zzbmj, (zzdhi) null, new zzbmi(this.zza), zzbmc, zzblq, (zzcqd) null);
                        zzN.zzB(this);
                        this.zzd.loadUrl((String) zzba.zzc().zza(zzbep.zziV));
                        zzu.zzi();
                        zzn.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzu.zzB().currentTimeMillis();
                    }
                } catch (zzchp e2) {
                    zzm.zzk("Failed to obtain a web view for the ad inspector", e2);
                    try {
                        zzu.zzo().zzw(e2, "InspectorUi.openInspector 0");
                        zzda2.zze(zzfiq.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                    } catch (RemoteException e3) {
                        zzu.zzo().zzw(e3, "InspectorUi.openInspector 1");
                    }
                }
            }
        }
    }

    public final synchronized void zzk(String str) {
        if (this.zze) {
            if (this.zzf) {
                zzcci.zze.execute(new zzdyk(this, str));
            }
        }
    }
}
