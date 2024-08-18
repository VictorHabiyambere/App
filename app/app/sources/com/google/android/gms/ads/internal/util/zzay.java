package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzdxz;
import com.google.android.gms.internal.ads.zzdya;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzay {
    protected String zza = "";
    private final Object zzb = new Object();
    private String zzc = "";
    private String zzd = "";
    private boolean zze = false;
    private boolean zzf = false;
    private zzdya zzg;

    protected static final String zzo(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.USER_AGENT, zzu.zzp().zzc(context, str2));
        ListenableFuture zzb2 = new zzbq(context).zzb(0, str, hashMap, (byte[]) null);
        try {
            return (String) zzb2.get((long) ((Integer) zzba.zzc().zza(zzbep.zzeL)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            zzm.zzh("Timeout while retrieving a response from: ".concat(String.valueOf(str)), e);
            zzb2.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            zzm.zzh("Interrupted while retrieving a response from: ".concat(String.valueOf(str)), e2);
            zzb2.cancel(true);
            return null;
        } catch (Exception e3) {
            zzm.zzh("Error retrieving a response from: ".concat(String.valueOf(str)), e3);
            return null;
        }
    }

    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                zzu.zzp();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException e) {
                    zzm.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(this.zzc)) {
                    zzu.zzp();
                    this.zzc = UUID.randomUUID().toString();
                    zzu.zzp();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e2) {
                        zzm.zzh("Error writing to file in internal storage.", e2);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final zzdya zza() {
        return this.zzg;
    }

    public final String zzb() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzdya zzdya;
        if (((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue() && (zzdya = this.zzg) != null) {
            zzdya.zzh(new zzav(this, context), zzdxz.DEBUG_MENU);
        }
    }

    public final void zzd(Context context, String str, String str2) {
        zzu.zzp();
        zzt.zzU(context, zzp(context, (String) zzba.zzc().zza(zzbep.zzeH), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzp(context, (String) zzba.zzc().zza(zzbep.zzeK), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzu.zzp();
        zzt.zzL(context, str, buildUpon.build().toString());
    }

    public final void zzf(boolean z) {
        synchronized (this.zzb) {
            this.zzf = z;
            if (((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue()) {
                zzu.zzo().zzi().zzC(z);
                zzdya zzdya = this.zzg;
                if (zzdya != null) {
                    zzdya.zzl(z);
                }
            }
        }
    }

    public final void zzg(zzdya zzdya) {
        this.zzg = zzdya;
    }

    public final void zzh(boolean z) {
        synchronized (this.zzb) {
            this.zze = z;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzi(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzm.zzi("Can not create dialog without Activity Context");
        } else {
            zzt.zza.post(new zzax(this, context, str, z, z2));
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String zzo = zzo(context, zzp(context, (String) zzba.zzc().zza(zzbep.zzeJ), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            zzm.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzo.trim()).optString("debug_mode"));
            zzf(equals);
            if (((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue()) {
                zzg zzi = zzu.zzo().zzi();
                if (true != equals) {
                    str = "";
                }
                zzi.zzB(str);
            }
            return equals;
        } catch (JSONException e) {
            zzm.zzk("Fail to get debug mode response json.", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(Context context, String str, String str2) {
        boolean z;
        String zzo = zzo(context, zzp(context, (String) zzba.zzc().zza(zzbep.zzeI), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            zzm.zze("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzo.trim());
            String optString = jSONObject.optString("gct");
            this.zza = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            if (((Boolean) zzba.zzc().zza(zzbep.zzjj)).booleanValue()) {
                if (!"0".equals(this.zza)) {
                    z = "2".equals(this.zza);
                } else {
                    z = true;
                }
                zzf(z);
                zzg zzi = zzu.zzo().zzi();
                if (!z) {
                    str = "";
                }
                zzi.zzB(str);
            }
            synchronized (this.zzb) {
                this.zzd = optString;
            }
            return true;
        } catch (JSONException e) {
            zzm.zzk("Fail to get in app preview response json.", e);
            return false;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzf;
        }
        return z;
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zze;
        }
        return z;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        zzm.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }
}
