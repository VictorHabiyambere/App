package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.database.core.ServerValues;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdkq implements zzdmb {
    private long zzA = 0;
    private long zzB = 0;
    private zzcs zzC;
    private final Context zza;
    private final zzdme zzb;
    private final JSONObject zzc;
    private final zzdqs zzd;
    private final zzdlt zze;
    private final zzaxd zzf;
    /* access modifiers changed from: private */
    public final zzdad zzg;
    /* access modifiers changed from: private */
    public final zzczj zzh;
    /* access modifiers changed from: private */
    public final zzdhg zzi;
    private final zzfgt zzj;
    private final VersionInfoParcel zzk;
    private final zzfho zzl;
    private final zzcra zzm;
    private final zzdmx zzn;
    private final Clock zzo;
    private final zzdhc zzp;
    private final zzfoe zzq;
    private final zzdsi zzr;
    private final zzfmn zzs;
    private final zzegk zzt;
    private boolean zzu = false;
    private boolean zzv;
    private boolean zzw = false;
    private boolean zzx = false;
    private Point zzy = new Point();
    private Point zzz = new Point();

    public zzdkq(Context context, zzdme zzdme, JSONObject jSONObject, zzdqs zzdqs, zzdlt zzdlt, zzaxd zzaxd, zzdad zzdad, zzczj zzczj, zzdhg zzdhg, zzfgt zzfgt, VersionInfoParcel versionInfoParcel, zzfho zzfho, zzcra zzcra, zzdmx zzdmx, Clock clock, zzdhc zzdhc, zzfoe zzfoe, zzfmn zzfmn, zzegk zzegk, zzdsi zzdsi) {
        this.zza = context;
        this.zzb = zzdme;
        this.zzc = jSONObject;
        this.zzd = zzdqs;
        this.zze = zzdlt;
        this.zzf = zzaxd;
        this.zzg = zzdad;
        this.zzh = zzczj;
        this.zzi = zzdhg;
        this.zzj = zzfgt;
        this.zzk = versionInfoParcel;
        this.zzl = zzfho;
        this.zzm = zzcra;
        this.zzn = zzdmx;
        this.zzo = clock;
        this.zzp = zzdhc;
        this.zzq = zzfoe;
        this.zzs = zzfmn;
        this.zzt = zzegk;
        this.zzr = zzdsi;
    }

    private final String zzD(View view) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdx)).booleanValue()) {
            return null;
        }
        try {
            return this.zzf.zzc().zzh(this.zza, view, (Activity) null);
        } catch (Exception e) {
            zzm.zzg("Exception getting data.");
            return null;
        }
    }

    private final String zzE(View view, Map map) {
        if (!(map == null || view == null)) {
            for (Map.Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        switch (this.zze.zzc()) {
            case 1:
                return "1099";
            case 2:
                return "2099";
            case 6:
                return "3099";
            default:
                return null;
        }
    }

    private final boolean zzF(String str) {
        JSONObject optJSONObject = this.zzc.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null || !optJSONObject.optBoolean(str, false)) {
            return false;
        }
        return true;
    }

    private final boolean zzG() {
        return this.zzc.optBoolean("allow_custom_click_gesture", false);
    }

    private final boolean zzH(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzc);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzba.zzc().zza(zzbep.zzdx)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            Context context = this.zza;
            JSONObject jSONObject7 = new JSONObject();
            zzu.zzp();
            DisplayMetrics zzt2 = zzt.zzt((WindowManager) context.getSystemService("window"));
            try {
                jSONObject7.put("width", zzay.zzb().zzb(context, zzt2.widthPixels));
                jSONObject7.put("height", zzay.zzb().zzb(context, zzt2.heightPixels));
            } catch (JSONException e) {
                jSONObject7 = null;
            }
            jSONObject6.put("screen", jSONObject7);
            if (((Boolean) zzba.zzc().zza(zzbep.zziE)).booleanValue()) {
                this.zzd.zzl("/clickRecorded", new zzdkn(this, (zzdkm) null));
            } else {
                this.zzd.zzl("/logScionEvent", new zzdkl(this, (zzdkk) null));
            }
            this.zzd.zzl("/nativeImpression", new zzdkp(this, (zzdko) null));
            zzccl.zza(this.zzd.zzg("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzu) {
                return true;
            }
            this.zzu = zzu.zzs().zzn(this.zza, this.zzk.afmaVersion, this.zzj.zzD.toString(), this.zzl.zzf);
            return true;
        } catch (JSONException e2) {
            zzm.zzh("Unable to create impression JSON.", e2);
            return false;
        }
    }

    public final boolean zzA() {
        if (zza() == 0) {
            return true;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue()) {
            return true;
        }
        return this.zzl.zzi.zzj;
    }

    public final boolean zzB() {
        return zzG();
    }

    public final boolean zzC(Bundle bundle) {
        String str;
        if (!zzF("impression_reporting")) {
            zzm.zzg("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        JSONObject zzk2 = zzay.zzb().zzk(bundle, (JSONObject) null);
        if (((Boolean) zzba.zzc().zza(zzbep.zzlv)).booleanValue()) {
            str = zzD((View) null);
        } else {
            str = null;
        }
        return zzH((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, zzk2, false);
    }

    public final int zza() {
        if (this.zzl.zzi == null) {
            return 0;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue()) {
            return 0;
        }
        return this.zzl.zzi.zzi;
    }

    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        JSONObject zzd2 = zzbz.zzd(context, map, map2, view, scaleType);
        JSONObject zzg2 = zzbz.zzg(context, view);
        JSONObject zzf2 = zzbz.zzf(view);
        JSONObject zze2 = zzbz.zze(context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zzd2);
            jSONObject.put("ad_view_signal", zzg2);
            jSONObject.put("scroll_view_signal", zzf2);
            jSONObject.put("lock_screen_signal", zze2);
            return jSONObject;
        } catch (JSONException e) {
            zzm.zzh("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        JSONObject zze2 = zze(view, map, map2, scaleType);
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.zzx && zzG()) {
                jSONObject.put("custom_click_gesture_eligible", true);
            }
            if (zze2 != null) {
                jSONObject.put("nas", zze2);
            }
        } catch (JSONException e) {
            zzm.zzh("Unable to create native click meta data JSON.", e);
        }
        return jSONObject;
    }

    public final void zzg() {
        try {
            zzcs zzcs = this.zzC;
            if (zzcs != null) {
                zzcs.zze();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzh() {
        if (this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzn.zzb();
        }
    }

    public final void zzi() {
        this.zzd.zzi();
    }

    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        View view3 = view2;
        Map map3 = map;
        Context context = this.zza;
        JSONObject zzd2 = zzbz.zzd(context, map3, map2, view2, scaleType);
        JSONObject zzg2 = zzbz.zzg(context, view2);
        JSONObject zzf2 = zzbz.zzf(view2);
        JSONObject zze2 = zzbz.zze(context, view2);
        View view4 = view;
        String zzE = zzE(view, map3);
        zzn(true == ((Boolean) zzba.zzc().zza(zzbep.zzdE)).booleanValue() ? view3 : view4, zzg2, zzd2, zzf2, zze2, zzE, zzbz.zzc(zzE, context, this.zzz, this.zzy), (JSONObject) null, z, false);
    }

    public final void zzl(String str) {
        zzn((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzm(Bundle bundle) {
        String str;
        if (bundle == null) {
            zzm.zze("Click data is null. No click is reported.");
        } else if (!zzF("click_reporting")) {
            zzm.zzg("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            if (bundle2 != null) {
                str = bundle2.getString("asset_id");
            } else {
                str = null;
            }
            zzn((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, zzay.zzb().zzk(bundle, (JSONObject) null), false, false);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String str2;
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzc);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzb.zzc(this.zze.zzA()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zze.zzc());
            jSONObject8.put("view_aware_api_used", z);
            zzbhk zzbhk = this.zzl.zzi;
            jSONObject8.put("custom_mute_requested", zzbhk != null && zzbhk.zzg);
            jSONObject8.put("custom_mute_enabled", !this.zze.zzH().isEmpty() && this.zze.zzk() != null);
            if (this.zzn.zza() != null && this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put(ServerValues.NAME_OP_TIMESTAMP, this.zzo.currentTimeMillis());
            if (this.zzx && zzG()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzb.zzc(this.zze.zzA()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            String str3 = null;
            try {
                JSONObject optJSONObject = this.zzc.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                str2 = this.zzf.zzc().zze(this.zza, optJSONObject.optString("click_string"), view);
            } catch (Exception e) {
                zzm.zzh("Exception obtaining click signals", e);
                str2 = null;
            }
            jSONObject8.put("click_signals", str2);
            if (((Boolean) zzba.zzc().zza(zzbep.zzeE)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zziI)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zziJ)).booleanValue() && PlatformVersion.isAtLeastR()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzo.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzA);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzB);
            jSONObject7.put("touch_signal", jSONObject9);
            if (this.zzj.zzaj) {
                JSONObject jSONObject10 = (JSONObject) this.zzc.get("tracking_urls_and_actions");
                if (jSONObject10 != null) {
                    str3 = jSONObject10.getString("gws_query_id");
                }
                if (str3 != null) {
                    this.zzt.zzp(str3, this.zze);
                }
            }
            zzccl.zza(this.zzd.zzg("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzm.zzh("Unable to create click JSON.", e2);
        }
    }

    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        JSONObject jSONObject;
        View view3 = view2;
        Map map3 = map;
        boolean z2 = false;
        if (this.zzc.optBoolean("allow_sdk_custom_click_gesture", false)) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue()) {
                z2 = true;
            }
        }
        if (!z2) {
            if (!this.zzx) {
                zzm.zze("Custom click reporting failed. enableCustomClickGesture is not set.");
                return;
            } else if (!zzG()) {
                zzm.zze("Custom click reporting failed. Ad unit id not in the allow list.");
                return;
            }
        }
        JSONObject zzd2 = zzbz.zzd(this.zza, map3, map2, view3, scaleType);
        JSONObject zzg2 = zzbz.zzg(this.zza, view3);
        JSONObject zzf2 = zzbz.zzf(view2);
        JSONObject zze2 = zzbz.zze(this.zza, view3);
        String zzE = zzE(view, map3);
        JSONObject zzc2 = zzbz.zzc(zzE, this.zza, this.zzz, this.zzy);
        if (z2) {
            try {
                JSONObject jSONObject2 = this.zzc;
                Point point = this.zzz;
                Point point2 = this.zzy;
                try {
                    jSONObject = new JSONObject();
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        JSONObject jSONObject4 = new JSONObject();
                        if (point != null) {
                            jSONObject3.put("x", point.x);
                            jSONObject3.put("y", point.y);
                        }
                        if (point2 != null) {
                            jSONObject4.put("x", point2.x);
                            jSONObject4.put("y", point2.y);
                        }
                        jSONObject.put("start_point", jSONObject3);
                        jSONObject.put("end_point", jSONObject4);
                        jSONObject.put("duration_ms", i);
                    } catch (Exception e) {
                        e = e;
                        zzm.zzh("Error occurred while grabbing custom click gesture signals.", e);
                        jSONObject2.put("custom_click_gesture_signal", jSONObject);
                        zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                    zzm.zzh("Error occurred while grabbing custom click gesture signals.", e);
                    jSONObject2.put("custom_click_gesture_signal", jSONObject);
                    zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
                }
                jSONObject2.put("custom_click_gesture_signal", jSONObject);
            } catch (JSONException e3) {
                zzm.zzh("Error occurred while adding CustomClickGestureSignals to adJson.", e3);
                zzu.zzo().zzw(e3, "FirstPartyNativeAdCore.performCustomClickGesture");
            }
        }
        zzn(view2, zzg2, zzd2, zzf2, zze2, zzE, zzc2, (JSONObject) null, z, true);
    }

    public final void zzp() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzc);
            zzccl.zza(this.zzd.zzg("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzm.zzh("", e);
        }
    }

    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        Context context = this.zza;
        zzH(zzbz.zzg(context, view), zzbz.zzd(context, map, map2, view, scaleType), zzbz.zzf(view), zzbz.zze(context, view), zzD(view), (JSONObject) null, zzbz.zzh(context, this.zzj));
    }

    public final void zzr() {
        zzH((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzs(View view, MotionEvent motionEvent, View view2) {
        this.zzy = zzbz.zza(motionEvent, view2);
        long currentTimeMillis = this.zzo.currentTimeMillis();
        this.zzB = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
            this.zzA = currentTimeMillis;
            this.zzz = this.zzy;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzy.x, (float) this.zzy.y);
        this.zzf.zzd(obtain);
        obtain.recycle();
    }

    public final void zzt(Bundle bundle) {
        if (bundle == null) {
            zzm.zze("Touch event data is null. No touch event is reported.");
        } else if (!zzF("touch_reporting")) {
            zzm.zzg("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzf.zzc().zzl((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final void zzu(View view) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzm.zzj("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzdmx zzdmx = this.zzn;
        if (view != null) {
            view.setOnClickListener(zzdmx);
            view.setClickable(true);
            zzdmx.zzc = new WeakReference(view);
        }
    }

    public final void zzv() {
        this.zzx = true;
    }

    public final void zzw(zzcs zzcs) {
        this.zzC = zzcs;
    }

    public final void zzx(zzbjp zzbjp) {
        if (!this.zzc.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzm.zzj("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzn.zzc(zzbjp);
        }
    }

    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (!this.zzv) {
            this.zzp.zza(view);
            this.zzv = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzm.zzi(this);
        boolean zzi2 = zzbz.zzi(this.zzk.clientJarVersion);
        if (map != null) {
            for (Map.Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzi2) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzi2) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zzz(View view, Map map) {
        this.zzy = new Point();
        this.zzz = new Point();
        if (view != null) {
            this.zzp.zzb(view);
        }
        this.zzv = false;
    }

    public final void zzj(zzcw zzcw) {
        try {
            if (!this.zzw) {
                if (zzcw == null) {
                    zzdlt zzdlt = this.zze;
                    if (zzdlt.zzk() != null) {
                        this.zzw = true;
                        this.zzq.zzc(zzdlt.zzk().zzf(), this.zzs);
                        zzg();
                        return;
                    }
                }
                this.zzw = true;
                this.zzq.zzc(zzcw.zzf(), this.zzs);
                zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
