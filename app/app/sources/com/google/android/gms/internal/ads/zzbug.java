package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.net.HttpHeaders;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbug extends zzbuj {
    private final Map zza;
    /* access modifiers changed from: private */
    public final Context zzb;

    public zzbug(zzchd zzchd, Map map) {
        super(zzchd, "storePicture");
        this.zza = map;
        this.zzb = zzchd.zzi();
    }

    public final void zzb() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.zzb == null) {
            zzh("Activity context is not available");
            return;
        }
        zzu.zzp();
        if (!new zzbdx(this.zzb).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str5 = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str5)) {
            zzh("Image url cannot be empty.");
        } else if (URLUtil.isValidUrl(str5)) {
            String lastPathSegment = Uri.parse(str5).getLastPathSegment();
            zzu.zzp();
            if (!TextUtils.isEmpty(lastPathSegment) && lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
                Resources zze = zzu.zzo().zze();
                zzu.zzp();
                AlertDialog.Builder zzK = zzt.zzK(this.zzb);
                if (zze != null) {
                    str = zze.getString(R.string.s1);
                } else {
                    str = "Save image";
                }
                zzK.setTitle(str);
                if (zze != null) {
                    str2 = zze.getString(R.string.s2);
                } else {
                    str2 = "Allow Ad to store image in Picture gallery?";
                }
                zzK.setMessage(str2);
                if (zze != null) {
                    str3 = zze.getString(R.string.s3);
                } else {
                    str3 = HttpHeaders.ACCEPT;
                }
                zzK.setPositiveButton(str3, new zzbue(this, str5, lastPathSegment));
                if (zze != null) {
                    str4 = zze.getString(R.string.s4);
                } else {
                    str4 = "Decline";
                }
                zzK.setNegativeButton(str4, new zzbuf(this));
                zzK.create().show();
                return;
            }
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
        } else {
            zzh("Invalid image url: ".concat(String.valueOf(str5)));
        }
    }
}
