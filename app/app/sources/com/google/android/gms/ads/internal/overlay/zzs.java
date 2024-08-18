package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbep;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzs extends FrameLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public final ImageButton zza;
    private final zzae zzb;

    public zzs(Context context, zzr zzr, zzae zzae) {
        super(context);
        zzq zzq;
        this.zzb = zzae;
        setOnClickListener(this);
        this.zza = new ImageButton(context);
        zzc();
        this.zza.setBackgroundColor(0);
        this.zza.setOnClickListener(this);
        ImageButton imageButton = this.zza;
        zzay.zzb();
        int zzy = zzf.zzy(context, zzr.zza);
        zzay.zzb();
        int zzy2 = zzf.zzy(context, 0);
        zzay.zzb();
        int zzy3 = zzf.zzy(context, zzr.zzb);
        zzay.zzb();
        imageButton.setPadding(zzy, zzy2, zzy3, zzf.zzy(context, zzr.zzc));
        this.zza.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zza;
        zzay.zzb();
        int zzy4 = zzf.zzy(context, zzr.zzd + zzr.zza + zzr.zzb);
        zzay.zzb();
        addView(imageButton2, new FrameLayout.LayoutParams(zzy4, zzf.zzy(context, zzr.zzd + zzr.zzc), 17));
        long longValue = ((Long) zzba.zzc().zza(zzbep.zzbd)).longValue();
        if (longValue > 0) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzbe)).booleanValue()) {
                zzq = new zzq(this);
            } else {
                zzq = null;
            }
            this.zza.setAlpha(0.0f);
            this.zza.animate().alpha(1.0f).setDuration(longValue).setListener(zzq);
        }
    }

    private final void zzc() {
        String str = (String) zzba.zzc().zza(zzbep.zzbc);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(17301527);
            return;
        }
        Resources zze = zzu.zzo().zze();
        if (zze != null) {
            Drawable drawable = null;
            try {
                if ("white".equals(str)) {
                    drawable = zze.getDrawable(R.drawable.admob_close_button_white_circle_black_cross);
                } else if ("black".equals(str)) {
                    drawable = zze.getDrawable(R.drawable.admob_close_button_black_circle_white_cross);
                }
            } catch (Resources.NotFoundException e) {
                zzm.zze("Close button resource not found, falling back to default.");
            }
            if (drawable == null) {
                this.zza.setImageResource(17301527);
                return;
            }
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
            return;
        }
        this.zza.setImageResource(17301527);
    }

    public final void onClick(View view) {
        zzae zzae = this.zzb;
        if (zzae != null) {
            zzae.zzj();
        }
    }

    public final void zzb(boolean z) {
        if (z) {
            this.zza.setVisibility(8);
            if (((Long) zzba.zzc().zza(zzbep.zzbd)).longValue() > 0) {
                this.zza.animate().cancel();
                this.zza.clearAnimation();
                return;
            }
            return;
        }
        this.zza.setVisibility(0);
    }
}
