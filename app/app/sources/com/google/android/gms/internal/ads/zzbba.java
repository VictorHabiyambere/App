package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzbba implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzbba(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzbas(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzbay(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzbav(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzbau(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzbax(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzbat(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzbaw(this, activity));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzbaz zzbaz) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzbaz.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
            zzm.zzh("Error while dispatching lifecycle callback.", e);
        }
    }
}
