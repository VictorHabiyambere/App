package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzdrx implements View.OnTouchListener {
    public final /* synthetic */ zzdsc zza;

    public /* synthetic */ zzdrx(zzdsc zzdsc) {
        this.zza = zzdsc;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
