package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public interface zzchd extends zza, zzdhi, zzcgu, zzbok, zzcig, zzcik, zzbox, zzban, zzcin, zzm, zzciq, zzcir, zzcee, zzcis {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzC(zzcif zzcif);

    zzfgt zzD();

    Context zzE();

    View zzF();

    WebView zzG();

    WebViewClient zzH();

    zzaxd zzI();

    zzbca zzJ();

    zzbhj zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    zzciv zzN();

    zzcix zzO();

    zzehe zzP();

    zzehg zzQ();

    zzfgw zzR();

    zzfhs zzS();

    ListenableFuture zzT();

    String zzU();

    List zzV();

    void zzW(zzfgt zzfgt, zzfgw zzfgw);

    void zzX();

    void zzY();

    void zzZ(int i);

    void zzaA(String str, Predicate predicate);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD(boolean z, int i);

    boolean zzaE();

    boolean zzaF();

    boolean zzaG();

    boolean zzaH();

    void zzaa();

    void zzab();

    void zzac(boolean z);

    void zzad();

    void zzae(String str, String str2, String str3);

    void zzaf();

    void zzag(String str, zzblp zzblp);

    void zzah();

    void zzai(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzaj(zzcix zzcix);

    void zzak(zzbca zzbca);

    void zzal(boolean z);

    void zzam();

    void zzan(Context context);

    void zzao(boolean z);

    void zzap(zzbhh zzbhh);

    void zzaq(boolean z);

    void zzar(zzbhj zzbhj);

    void zzas(zzehe zzehe);

    void zzat(zzehg zzehg);

    void zzau(int i);

    void zzav(boolean z);

    void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzax(boolean z);

    void zzay(boolean z);

    void zzaz(String str, zzblp zzblp);

    Activity zzi();

    com.google.android.gms.ads.internal.zza zzj();

    zzbfc zzm();

    VersionInfoParcel zzn();

    zzcif zzq();

    void zzt(String str, zzcfp zzcfp);
}
