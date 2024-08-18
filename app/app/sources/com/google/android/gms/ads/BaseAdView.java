package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgi;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class BaseAdView extends ViewGroup {
    @NotOnlyInitialized
    protected final zzea zza;

    protected BaseAdView(Context context, int adViewType) {
        super(context);
        this.zza = new zzea(this, adViewType);
    }

    public void destroy() {
        zzbep.zza(getContext());
        if (((Boolean) zzbgi.zze.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzld)).booleanValue()) {
                zzb.zzb.execute(new zzd(this));
                return;
            }
        }
        this.zza.zzk();
    }

    public AdListener getAdListener() {
        return this.zza.zza();
    }

    public AdSize getAdSize() {
        return this.zza.zzb();
    }

    public String getAdUnitId() {
        return this.zza.zzj();
    }

    public OnPaidEventListener getOnPaidEventListener() {
        return this.zza.zzc();
    }

    public ResponseInfo getResponseInfo() {
        return this.zza.zzd();
    }

    public boolean isCollapsible() {
        return this.zza.zzA();
    }

    public boolean isLoading() {
        return this.zza.zzB();
    }

    public void loadAd(AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbep.zza(getContext());
        if (((Boolean) zzbgi.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlg)).booleanValue()) {
                zzb.zzb.execute(new zzf(this, adRequest));
                return;
            }
        }
        this.zza.zzm(adRequest.zza);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int left, int top, int right, int bottom) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i = ((right - left) - measuredWidth) / 2;
            int i2 = ((bottom - top) - measuredHeight) / 2;
            childAt.layout(i, i2, measuredWidth + i, measuredHeight + i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        AdSize adSize;
        int i2 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzm.zzh("Unable to retrieve ad size.", e);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i = adSize.getHeightInPixels(context);
                i2 = widthInPixels;
            } else {
                i = 0;
            }
        } else {
            measureChild(childAt, widthMeasureSpec, heightMeasureSpec);
            i2 = childAt.getMeasuredWidth();
            i = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i2, getSuggestedMinimumWidth()), widthMeasureSpec), View.resolveSize(Math.max(i, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    public void pause() {
        zzbep.zza(getContext());
        if (((Boolean) zzbgi.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzle)).booleanValue()) {
                zzb.zzb.execute(new zze(this));
                return;
            }
        }
        this.zza.zzn();
    }

    public void resume() {
        zzbep.zza(getContext());
        if (((Boolean) zzbgi.zzh.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlc)).booleanValue()) {
                zzb.zzb.execute(new zzc(this));
                return;
            }
        }
        this.zza.zzp();
    }

    public void setAdListener(AdListener adListener) {
        this.zza.zzr(adListener);
        if (adListener == null) {
            this.zza.zzq((zza) null);
            return;
        }
        if (adListener instanceof zza) {
            this.zza.zzq((zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zza.zzv((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zza.zzs(adSize);
    }

    public void setAdUnitId(String adUnitId) {
        this.zza.zzu(adUnitId);
    }

    public void setOnPaidEventListener(OnPaidEventListener listener) {
        this.zza.zzx(listener);
    }

    protected BaseAdView(Context context, AttributeSet attrs, int adViewType) {
        super(context, attrs);
        this.zza = new zzea(this, attrs, false, adViewType);
    }

    protected BaseAdView(Context context, AttributeSet attrs, int defStyle, int adViewType) {
        super(context, attrs, defStyle);
        this.zza = new zzea(this, attrs, false, adViewType);
    }

    protected BaseAdView(Context context, AttributeSet attrs, int defStyle, int adViewType, boolean allowMultipleAdSizes) {
        super(context, attrs, defStyle);
        this.zza = new zzea(this, attrs, allowMultipleAdSizes, adViewType);
    }

    protected BaseAdView(Context context, AttributeSet attrs, boolean allowMultipleAdSizes) {
        super(context, attrs);
        this.zza = new zzea(this, attrs, allowMultipleAdSizes);
    }
}
