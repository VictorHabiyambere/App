package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzchv extends FrameLayout implements zzchd {
    private final zzchd zza;
    private final zzcdt zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzchv(zzchd zzchd) {
        super(zzchd.getContext());
        this.zza = zzchd;
        this.zzb = new zzcdt(zzchd.zzE(), this, this);
        addView((View) this.zza);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        zzehe zzP;
        zzehg zzQ = zzQ();
        if (zzQ != null) {
            zzt.zza.post(new zzcht(zzQ));
            zzchd zzchd = this.zza;
            zzfuv zzfuv = zzt.zza;
            Objects.requireNonNull(zzchd);
            zzfuv.postDelayed(new zzchr(zzchd), (long) ((Integer) zzba.zzc().zza(zzbep.zzfa)).intValue());
            return;
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() || (zzP = zzP()) == null) {
            this.zza.destroy();
        } else {
            zzt.zza.post(new zzchu(this, zzP));
        }
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    public final void zzC(zzcif zzcif) {
        this.zza.zzC(zzcif);
    }

    public final zzfgt zzD() {
        return this.zza.zzD();
    }

    public final Context zzE() {
        return this.zza.zzE();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    public final zzaxd zzI() {
        return this.zza.zzI();
    }

    public final zzbca zzJ() {
        return this.zza.zzJ();
    }

    public final zzbhj zzK() {
        return this.zza.zzK();
    }

    public final zzm zzL() {
        return this.zza.zzL();
    }

    public final zzm zzM() {
        return this.zza.zzM();
    }

    public final zzciv zzN() {
        return ((zzcic) this.zza).zzaO();
    }

    public final zzcix zzO() {
        return this.zza.zzO();
    }

    public final zzehe zzP() {
        return this.zza.zzP();
    }

    public final zzehg zzQ() {
        return this.zza.zzQ();
    }

    public final zzfgw zzR() {
        return this.zza.zzR();
    }

    public final zzfhs zzS() {
        return this.zza.zzS();
    }

    public final ListenableFuture zzT() {
        return this.zza.zzT();
    }

    public final String zzU() {
        return this.zza.zzU();
    }

    public final List zzV() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.zza) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    public final void zzW(zzfgt zzfgt, zzfgw zzfgw) {
        this.zza.zzW(zzfgt, zzfgw);
    }

    public final void zzX() {
        this.zzb.zze();
        this.zza.zzX();
    }

    public final void zzY() {
        this.zza.zzY();
    }

    public final void zzZ(int i) {
        this.zza.zzZ(i);
    }

    public final void zza(String str) {
        ((zzcic) this.zza).zzaT(str);
    }

    public final void zzaA(String str, Predicate predicate) {
        this.zza.zzaA(str, predicate);
    }

    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final boolean zzaD(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzaM)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaD(z, i);
        return true;
    }

    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    public final boolean zzaF() {
        return this.zza.zzaF();
    }

    public final boolean zzaG() {
        return this.zzc.get();
    }

    public final boolean zzaH() {
        return this.zza.zzaH();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaI(boolean z) {
        zzchd zzchd = this.zza;
        zzfuv zzfuv = zzt.zza;
        Objects.requireNonNull(zzchd);
        zzfuv.post(new zzchr(zzchd));
    }

    public final void zzaJ(zzc zzc2, boolean z, boolean z2) {
        this.zza.zzaJ(zzc2, z, z2);
    }

    public final void zzaK(String str, String str2, int i) {
        this.zza.zzaK(str, str2, 14);
    }

    public final void zzaL(boolean z, int i, boolean z2) {
        this.zza.zzaL(z, i, z2);
    }

    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaM(z, i, str, str2, z2);
    }

    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaN(z, i, str, z2, z3);
    }

    public final void zzaa() {
        this.zza.zzaa();
    }

    public final void zzab() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzu.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(zzu.zzr().zza()));
        zzcic zzcic = (zzcic) this.zza;
        hashMap.put("device_volume", String.valueOf(zzac.zzb(zzcic.getContext())));
        zzcic.zzd("volume", hashMap);
    }

    public final void zzac(boolean z) {
        this.zza.zzac(z);
    }

    public final void zzad() {
        this.zza.zzad();
    }

    public final void zzae(String str, String str2, String str3) {
        this.zza.zzae(str, str2, (String) null);
    }

    public final void zzaf() {
        this.zza.zzaf();
    }

    public final void zzag(String str, zzblp zzblp) {
        this.zza.zzag(str, zzblp);
    }

    public final void zzah() {
        zzehg zzQ;
        zzehe zzP;
        TextView textView = new TextView(getContext());
        zzu.zzp();
        textView.setText(zzt.zzy());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzfc)).booleanValue() || (zzP = zzP()) == null) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzfb)).booleanValue() && (zzQ = zzQ()) != null && zzQ.zzb()) {
                zzu.zzA().zzg(zzQ.zza(), textView);
                return;
            }
            return;
        }
        zzP.zza(textView);
    }

    public final void zzai(zzm zzm) {
        this.zza.zzai(zzm);
    }

    public final void zzaj(zzcix zzcix) {
        this.zza.zzaj(zzcix);
    }

    public final void zzak(zzbca zzbca) {
        this.zza.zzak(zzbca);
    }

    public final void zzal(boolean z) {
        this.zza.zzal(z);
    }

    public final void zzam() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzan(Context context) {
        this.zza.zzan(context);
    }

    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    public final void zzap(zzbhh zzbhh) {
        this.zza.zzap(zzbhh);
    }

    public final void zzaq(boolean z) {
        this.zza.zzaq(z);
    }

    public final void zzar(zzbhj zzbhj) {
        this.zza.zzar(zzbhj);
    }

    public final void zzas(zzehe zzehe) {
        this.zza.zzas(zzehe);
    }

    public final void zzat(zzehg zzehg) {
        this.zza.zzat(zzehg);
    }

    public final void zzau(int i) {
        this.zza.zzau(i);
    }

    public final void zzav(boolean z) {
        this.zza.zzav(true);
    }

    public final void zzaw(zzm zzm) {
        this.zza.zzaw(zzm);
    }

    public final void zzax(boolean z) {
        this.zza.zzax(z);
    }

    public final void zzay(boolean z) {
        this.zza.zzay(z);
    }

    public final void zzaz(String str, zzblp zzblp) {
        this.zza.zzaz(str, zzblp);
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    public final void zzdG() {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.zzdG();
        }
    }

    public final void zzdf() {
        zzchd zzchd = this.zza;
        if (zzchd != null) {
            zzchd.zzdf();
        }
    }

    public final void zzdg() {
        this.zza.zzdg();
    }

    public final void zzdh() {
        this.zza.zzdh();
    }

    public final String zzdi() {
        return this.zza.zzdi();
    }

    public final void zzdp(zzbam zzbam) {
        this.zza.zzdp(zzbam);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzdR)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzh() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzdR)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zza.zzi();
    }

    public final zza zzj() {
        return this.zza.zzj();
    }

    public final zzbfb zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        ((zzcic) this.zza).zzb(str, jSONObject.toString());
    }

    public final zzbfc zzm() {
        return this.zza.zzm();
    }

    public final VersionInfoParcel zzn() {
        return this.zza.zzn();
    }

    public final zzcdt zzo() {
        return this.zzb;
    }

    public final zzcfp zzp(String str) {
        return this.zza.zzp(str);
    }

    public final zzcif zzq() {
        return this.zza.zzq();
    }

    public final String zzr() {
        return this.zza.zzr();
    }

    public final void zzt(String str, zzcfp zzcfp) {
        this.zza.zzt(str, zzcfp);
    }

    public final void zzu() {
        this.zza.zzu();
    }

    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(int i) {
    }

    public final void zzy(int i) {
    }

    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}
