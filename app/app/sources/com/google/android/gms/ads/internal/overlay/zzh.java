package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzau;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzh extends RelativeLayout {
    final zzau zza;
    boolean zzb;

    public zzh(Context context, String str, String str2, String str3) {
        super(context);
        this.zza = new zzau(context, str);
        this.zza.zzo(str2);
        this.zza.zzn(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
