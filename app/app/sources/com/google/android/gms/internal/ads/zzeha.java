package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeha implements zzehb {
    static /* synthetic */ zzehg zzc(String str, String str2, String str3, zzehc zzehc, String str4, WebView webView, String str5, String str6, zzehd zzehd) {
        zzfow zza = zzfow.zza("Google", str2);
        zzfov zzp = zzp("javascript");
        zzfoo zzn = zzn(zzehc.toString());
        if (zzp == zzfov.NONE) {
            zzm.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzehc))));
            return null;
        } else {
            zzfov zzp2 = zzp(str4);
            if (zzn == zzfoo.VIDEO && zzp2 == zzfov.NONE) {
                zzm.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            zzfol zzb = zzfol.zzb(zza, webView, str5, "");
            return new zzehg(zzfoj.zza(zzfok.zza(zzn, zzo(zzehd.toString()), zzp, zzp2, true), zzb), zzb);
        }
    }

    static /* synthetic */ zzehg zzd(String str, String str2, String str3, String str4, zzehc zzehc, WebView webView, String str5, String str6, zzehd zzehd) {
        zzfow zza = zzfow.zza(str, str2);
        zzfov zzp = zzp("javascript");
        zzfov zzp2 = zzp(str4);
        zzfoo zzn = zzn(zzehc.toString());
        if (zzp == zzfov.NONE) {
            zzm.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzn == null) {
            zzm.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzehc))));
            return null;
        } else if (zzn == zzfoo.VIDEO && zzp2 == zzfov.NONE) {
            zzm.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            zzfol zzc = zzfol.zzc(zza, webView, str5, "");
            return new zzehg(zzfoj.zza(zzfok.zza(zzn, zzo(zzehd.toString()), zzp, zzp2, true), zzc), zzc);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfoo zzn(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -382745961: goto L_0x001d;
                case 112202875: goto L_0x0013;
                case 714893483: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0027
        L_0x0008:
            java.lang.String r0 = "nativeDisplay"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 1
            goto L_0x0028
        L_0x0013:
            java.lang.String r0 = "video"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 2
            goto L_0x0028
        L_0x001d:
            java.lang.String r0 = "htmlDisplay"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 0
            goto L_0x0028
        L_0x0027:
            r1 = -1
        L_0x0028:
            switch(r1) {
                case 0: goto L_0x0033;
                case 1: goto L_0x0030;
                case 2: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            r1 = 0
            return r1
        L_0x002d:
            com.google.android.gms.internal.ads.zzfoo r1 = com.google.android.gms.internal.ads.zzfoo.VIDEO
            return r1
        L_0x0030:
            com.google.android.gms.internal.ads.zzfoo r1 = com.google.android.gms.internal.ads.zzfoo.NATIVE_DISPLAY
            return r1
        L_0x0033:
            com.google.android.gms.internal.ads.zzfoo r1 = com.google.android.gms.internal.ads.zzfoo.HTML_DISPLAY
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeha.zzn(java.lang.String):com.google.android.gms.internal.ads.zzfoo");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfor zzo(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -1104128070: goto L_0x001d;
                case 1318088141: goto L_0x0013;
                case 1988248512: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0027
        L_0x0008:
            java.lang.String r0 = "onePixel"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 2
            goto L_0x0028
        L_0x0013:
            java.lang.String r0 = "definedByJavascript"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 1
            goto L_0x0028
        L_0x001d:
            java.lang.String r0 = "beginToRender"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0007
            r1 = 0
            goto L_0x0028
        L_0x0027:
            r1 = -1
        L_0x0028:
            switch(r1) {
                case 0: goto L_0x0034;
                case 1: goto L_0x0031;
                case 2: goto L_0x002e;
                default: goto L_0x002b;
            }
        L_0x002b:
            com.google.android.gms.internal.ads.zzfor r1 = com.google.android.gms.internal.ads.zzfor.UNSPECIFIED
            return r1
        L_0x002e:
            com.google.android.gms.internal.ads.zzfor r1 = com.google.android.gms.internal.ads.zzfor.ONE_PIXEL
            return r1
        L_0x0031:
            com.google.android.gms.internal.ads.zzfor r1 = com.google.android.gms.internal.ads.zzfor.DEFINED_BY_JAVASCRIPT
            return r1
        L_0x0034:
            com.google.android.gms.internal.ads.zzfor r1 = com.google.android.gms.internal.ads.zzfor.BEGIN_TO_RENDER
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeha.zzo(java.lang.String):com.google.android.gms.internal.ads.zzfor");
    }

    private static zzfov zzp(String str) {
        if ("native".equals(str)) {
            return zzfov.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfov.JAVASCRIPT;
        }
        return zzfov.NONE;
    }

    private static final Object zzq(zzegz zzegz) {
        try {
            return zzegz.zza();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
        }
    }

    public final zzehg zza(String str, WebView webView, String str2, String str3, String str4, zzehd zzehd, zzehc zzehc, String str5) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue() || !zzfoh.zzb()) {
            return null;
        }
        return (zzehg) zzq(new zzegp("Google", str, "javascript", zzehc, str4, webView, str5, "", zzehd));
    }

    public final zzehg zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzehd zzehd, zzehc zzehc, String str6) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue() || !zzfoh.zzb()) {
            return null;
        }
        return (zzehg) zzq(new zzegs(str5, str, "javascript", str4, zzehc, webView, str6, "", zzehd));
    }

    public final zzfou zze(VersionInfoParcel versionInfoParcel, WebView webView, boolean z) {
        return (zzfou) zzq(new zzegx(versionInfoParcel, webView, true));
    }

    public final String zzf(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue()) {
            return null;
        }
        return (String) zzq(new zzegv());
    }

    public final void zzg(zzfoj zzfoj, View view) {
        zzr(new zzego(zzfoj, view));
    }

    public final void zzh(zzfou zzfou, View view) {
        zzr(new zzegu(zzfou, view));
    }

    public final void zzi(zzfoj zzfoj) {
        zzr(new zzegy(zzfoj));
    }

    public final void zzj(zzfoj zzfoj, View view) {
        zzr(new zzegq(zzfoj, view));
    }

    public final void zzk(zzfoj zzfoj) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue() && zzfoh.zzb()) {
            Objects.requireNonNull(zzfoj);
            zzr(new zzegr(zzfoj));
        }
    }

    public final boolean zzl(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzeZ)).booleanValue()) {
            zzm.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzq(new zzegt(context));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final void zzm(zzfou zzfou, zzchs zzchs) {
        zzr(new zzegw(zzfou, zzchs));
    }
}
