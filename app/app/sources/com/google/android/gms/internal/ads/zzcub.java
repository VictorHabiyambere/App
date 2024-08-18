package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcub extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcub(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcub zza(Context context, View view, zzfgt zzfgt) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcub zzcub = new zzcub(context);
        if (!(zzfgt.zzv.isEmpty() || (resources = zzcub.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzfgu zzfgu = (zzfgu) zzfgt.zzv.get(0);
            zzcub.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzfgu.zza) * displayMetrics.density), (int) (((float) zzfgu.zzb) * displayMetrics.density)));
        }
        zzcub.zzb = view;
        zzcub.addView(view);
        zzu.zzx();
        zzccv.zzb(zzcub, zzcub);
        zzu.zzx();
        zzccv.zza(zzcub, zzcub);
        JSONObject jSONObject = zzfgt.zzai;
        RelativeLayout relativeLayout = new RelativeLayout(zzcub.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcub.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcub.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcub.addView(relativeLayout);
        return zzcub;
    }

    private final int zzb(double d) {
        zzay.zzb();
        return zzf.zzy(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble("padding", 0.0d));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
