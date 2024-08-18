package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzcc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbpt {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    /* access modifiers changed from: private */
    public final zzfmq zze;
    private final zzbd zzf;
    private final zzbd zzg;
    /* access modifiers changed from: private */
    public zzbps zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbpt(Context context, VersionInfoParcel versionInfoParcel, String str, zzbd zzbd, zzbd zzbd2, zzfmq zzfmq) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfmq;
        this.zzf = zzbd;
        this.zzg = zzbd2;
    }

    public final zzbpn zzb(zzaxd zzaxd) {
        zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("getEngine: Lock acquired");
            zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                zze.zza("refreshIfDestroyed: Lock acquired");
                zzbps zzbps = this.zzh;
                if (zzbps != null && this.zzi == 0) {
                    zzbps.zzj(new zzboz(this), new zzbpa());
                }
            }
            zze.zza("refreshIfDestroyed: Lock released");
            zzbps zzbps2 = this.zzh;
            if (zzbps2 != null) {
                if (zzbps2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        zze.zza("getEngine (NO_UPDATE): Lock released");
                        zzbpn zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzi = 2;
                        zzd((zzaxd) null);
                        zze.zza("getEngine (PENDING_UPDATE): Lock released");
                        zzbpn zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zze.zza("getEngine (UPDATING): Lock released");
                        zzbpn zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            this.zzh = zzd((zzaxd) null);
            zze.zza("getEngine (NULL or REJECTED): Lock released");
            zzbpn zza5 = this.zzh.zza();
            return zza5;
        }
    }

    /* access modifiers changed from: protected */
    public final zzbps zzd(zzaxd zzaxd) {
        zzfmc zza2 = zzfmb.zza(this.zzb, zzfmu.CUI_NAME_SDKINIT_SDKCORE);
        zza2.zzj();
        zzbps zzbps = new zzbps(this.zzg);
        zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        zzcci.zze.execute(new zzbpd(this, (zzaxd) null, zzbps));
        zze.zza("loadNewJavascriptEngine: Promise created");
        zzbps.zzj(new zzbpi(this, zzbps, zza2), new zzbpj(this, zzbps, zza2));
        return zzbps;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzbps zzbps, zzboo zzboo, ArrayList arrayList, long j) {
        zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbps.zze() != -1) {
                if (zzbps.zze() != 1) {
                    if (((Boolean) zzba.zzc().zza(zzbep.zzhO)).booleanValue()) {
                        zzbps.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbps.zzg();
                    }
                    zzgge zzgge = zzcci.zze;
                    Objects.requireNonNull(zzboo);
                    zzgge.execute(new zzbpb(zzboo));
                    String valueOf = String.valueOf(zzba.zzc().zza(zzbep.zzc));
                    int zze2 = zzbps.zze();
                    int i = this.zzi;
                    String valueOf2 = String.valueOf(arrayList.get(0));
                    long currentTimeMillis = zzu.zzB().currentTimeMillis() - j;
                    zze.zza("Could not receive /jsLoaded in " + valueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zze2 + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + valueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + currentTimeMillis + " ms. Rejecting.");
                    zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzaxd zzaxd, zzbps zzbps) {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbow zzbow = new zzbow(this.zzb, this.zzd, (zzaxd) null, (zza) null);
            zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbow.zzk(new zzbpc(this, arrayList, currentTimeMillis, zzbps, zzbow));
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbow.zzq("/jsLoaded", new zzbpe(this, currentTimeMillis, zzbps, zzbow));
            zzcc zzcc = new zzcc();
            zzbpf zzbpf = new zzbpf(this, (zzaxd) null, zzbow, zzcc);
            zzcc.zzb(zzbpf);
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbow.zzq("/requestReload", zzbpf);
            zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbow.zzh(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbow.zzf(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbow.zzg(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            zzt.zza.postDelayed(new zzbph(this, zzbps, zzbow, arrayList, currentTimeMillis), (long) ((Integer) zzba.zzc().zza(zzbep.zzd)).intValue());
        } catch (Throwable th) {
            zzm.zzh("Error creating webview.", th);
            if (((Boolean) zzba.zzc().zza(zzbep.zzhO)).booleanValue()) {
                zzbps.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            zzu.zzo().zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbps.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzboo zzboo) {
        if (zzboo.zzi()) {
            this.zzi = 1;
        }
    }
}
