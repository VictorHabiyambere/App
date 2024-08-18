package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbow implements zzboo, zzbom {
    private final zzchd zza;

    public zzbow(Context context, VersionInfoParcel versionInfoParcel, zzaxd zzaxd, zza zza2) throws zzchp {
        zzu.zzz();
        this.zza = zzchq.zza(context, zzcix.zza(), "", false, false, (zzaxd) null, (zzbfs) null, versionInfoParcel, (zzbfe) null, (zzm) null, (zza) null, zzbdm.zza(), (zzfgt) null, (zzfgw) null, (zzegk) null, (zzfhs) null);
        ((View) this.zza).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzay.zzb();
        if (zzf.zzv()) {
            zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
            return;
        }
        zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
        if (!zzt.zza.post(runnable)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    public final void zza(String str) {
        zze.zza("invokeJavascript on adWebView from js");
        zzs(new zzbos(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbol.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbol.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbol.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zze.zza("loadHtml on adWebView from html");
        zzs(new zzbot(this, str));
    }

    public final void zzg(String str) {
        zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzboq(this, str));
    }

    public final void zzh(String str) {
        zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzbou(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaE();
    }

    public final zzbpv zzj() {
        return new zzbpv(this);
    }

    public final void zzk(zzbpc zzbpc) {
        zzciv zzN = this.zza.zzN();
        Objects.requireNonNull(zzbpc);
        zzN.zzH(new zzbor(zzbpc));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbol.zzd(this, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final void zzq(String str, zzblp zzblp) {
        this.zza.zzag(str, new zzbov(this, zzblp));
    }

    public final void zzr(String str, zzblp zzblp) {
        this.zza.zzaA(str, new zzbop(zzblp));
    }
}
