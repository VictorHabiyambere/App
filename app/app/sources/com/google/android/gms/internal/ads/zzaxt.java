package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaxt implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzaxt(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzaxl(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzaxr(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzaxo(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzaxn(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzaxq(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzaxm(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzaxp(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzaxs zzaxs) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzaxs.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
        }
    }
}
