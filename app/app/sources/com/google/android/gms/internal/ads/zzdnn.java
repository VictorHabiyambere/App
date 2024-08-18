package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdnn {
    private final zzdsd zza;
    private final zzdqs zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdnn(zzdsd zzdsd, zzdqs zzdqs) {
        this.zza = zzdsd;
        this.zzb = zzdqs;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        zzay.zzb();
        return zzf.zzy(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzchp {
        zzchd zza2 = this.zza.zza(zzq.zzc(), (zzfgt) null, (zzfgw) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzag("/sendMessageToSdk", new zzdnh(this));
        zza2.zzag("/hideValidatorOverlay", new zzdni(this, windowManager, view));
        zza2.zzag("/open", new zzbmb((zzb) null, (zzbud) null, (zzefz) null, (zzdvc) null, (zzcqd) null));
        this.zzb.zzm(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdnj(this, view, windowManager));
        this.zzb.zzm(new WeakReference(zza2), "/showValidatorOverlay", new zzdnk());
        return view2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzchd zzchd, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzchd zzchd, Map map) {
        zzm.zze("Hide native ad policy validator overlay.");
        zzchd.zzF().setVisibility(8);
        if (zzchd.zzF().getWindowToken() != null) {
            windowManager.removeView(zzchd.zzF());
        }
        zzchd.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzchd zzchd, Map map) {
        int i;
        zzchd.zzN().zzB(new zzdnm(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzba.zzc().zza(zzbep.zzig)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzba.zzc().zza(zzbep.zzih)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzchd.zzaj(zzcix.zzb(zzf, zzf2));
            try {
                zzchd.zzG().getSettings().setUseWideViewPort(((Boolean) zzba.zzc().zza(zzbep.zzii)).booleanValue());
                zzchd.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzba.zzc().zza(zzbep.zzij)).booleanValue());
            } catch (NullPointerException e) {
            }
            WindowManager.LayoutParams zzb2 = zzbz.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzchd.zzF(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || "2".equals(str)) {
                    i = rect.bottom - zzf4;
                } else {
                    i = rect.top - zzf4;
                }
                this.zzc = new zzdnl(view, zzchd, str, zzb2, i, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzchd.loadUrl(str2);
            }
        }
    }
}
