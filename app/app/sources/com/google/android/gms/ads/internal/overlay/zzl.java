package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzl extends zzb {
    final /* synthetic */ zzm zza;

    /* synthetic */ zzl(zzm zzm, zzk zzk) {
        this.zza = zzm;
    }

    public final void zza() {
        BitmapDrawable bitmapDrawable;
        Bitmap zza2 = zzu.zzu().zza(Integer.valueOf(this.zza.zzc.zzo.zzf));
        if (zza2 != null) {
            zzu.zzp();
            zzm zzm = this.zza;
            zzk zzk = zzm.zzc.zzo;
            boolean z = zzk.zzd;
            float f = zzk.zze;
            Activity activity = zzm.zzb;
            if (!z || f <= 0.0f || f > 25.0f) {
                bitmapDrawable = new BitmapDrawable(activity.getResources(), zza2);
            } else {
                try {
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(zza2, zza2.getWidth(), zza2.getHeight(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                    RenderScript create = RenderScript.create(activity);
                    ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                    Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                    Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                    create2.setRadius(f);
                    create2.setInput(createFromBitmap);
                    create2.forEach(createFromBitmap2);
                    createFromBitmap2.copyTo(createBitmap);
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), createBitmap);
                } catch (RuntimeException e) {
                    bitmapDrawable = new BitmapDrawable(activity.getResources(), zza2);
                }
            }
            zzt.zza.post(new zzj(this, bitmapDrawable));
        }
    }
}
