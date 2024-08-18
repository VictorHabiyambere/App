package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxk {
    private final Context zza;
    private final ApplicationInfo zzb;
    private final int zzc;
    private final int zzd;
    private String zze = "";

    public zzdxk(Context context) {
        this.zza = context;
        this.zzb = context.getApplicationInfo();
        this.zzc = ((Integer) zzba.zzc().zza(zzbep.zzjh)).intValue();
        this.zzd = ((Integer) zzba.zzc().zza(zzbep.zzji)).intValue();
    }

    public final JSONObject zza() throws JSONException {
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            Context context = this.zza;
            String str3 = this.zzb.packageName;
            zzfuv zzfuv = zzt.zza;
            jSONObject.put("name", Wrappers.packageManager(context).getApplicationLabel(str3));
        } catch (PackageManager.NameNotFoundException e) {
        }
        jSONObject.put("packageName", this.zzb.packageName);
        zzu.zzp();
        Drawable drawable = null;
        try {
            str = zzt.zzp(this.zza);
        } catch (RemoteException e2) {
            str = null;
        }
        jSONObject.put("adMobAppId", str);
        if (this.zze.isEmpty()) {
            try {
                drawable = (Drawable) Wrappers.packageManager(this.zza).getApplicationLabelAndIcon(this.zzb.packageName).second;
            } catch (PackageManager.NameNotFoundException e3) {
            }
            if (drawable == null) {
                str2 = "";
            } else {
                drawable.setBounds(0, 0, this.zzc, this.zzd);
                Bitmap createBitmap = Bitmap.createBitmap(this.zzc, this.zzd, Bitmap.Config.ARGB_8888);
                drawable.draw(new Canvas(createBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                str2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            this.zze = str2;
        }
        if (!this.zze.isEmpty()) {
            jSONObject.put("icon", this.zze);
            jSONObject.put("iconWidthPx", this.zzc);
            jSONObject.put("iconHeightPx", this.zzd);
        }
        return jSONObject;
    }
}
