package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbao implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) zzba.zzc().zza(zzbep.zzbn)).longValue();
    BroadcastReceiver zza;
    final WeakReference zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference zzi;
    private zzbba zzj;
    private final zzcb zzk = new zzcb(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet zzn = new HashSet();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzbao(Context context, View view) {
        View view2;
        this.zzd = context.getApplicationContext();
        this.zzf = (WindowManager) context.getSystemService("window");
        this.zzg = (PowerManager) this.zzd.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzd;
        if (context2 instanceof Application) {
            Application application = (Application) context2;
            this.zze = application;
            this.zzj = new zzbba(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        this.zzp = new Rect();
        this.zzp.right = this.zzf.getDefaultDisplay().getWidth();
        this.zzp.bottom = this.zzf.getDefaultDisplay().getHeight();
        WeakReference weakReference = this.zzb;
        if (weakReference != null) {
            view2 = (View) weakReference.get();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference(view);
        if (view != null) {
            if (view.isAttachedToWindow()) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i) {
        return (int) (((float) i) / this.zzo.density);
    }

    private final void zzi(Activity activity, int i) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            WeakReference weakReference = this.zzb;
            View peekDecorView = window.peekDecorView();
            View view = (View) weakReference.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(int i) {
        WeakReference weakReference;
        boolean z;
        boolean z2;
        View view;
        ArrayList arrayList;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        int i4 = i;
        if (!this.zzn.isEmpty() && (weakReference = this.zzb) != null) {
            View view2 = (View) weakReference.get();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view2 != null) {
                z2 = view2.getGlobalVisibleRect(rect2);
                z = view2.getLocalVisibleRect(rect3);
                view2.getHitRect(rect4);
                try {
                    view2.getLocationOnScreen(iArr);
                    view2.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zzm.zzh("Failure getting view location.", e);
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzeR)).booleanValue()) {
                    rect.left = iArr2[0];
                    rect.top = iArr2[1];
                } else {
                    rect.left = iArr[0];
                    rect.top = iArr[1];
                }
                rect.right = rect.left + view2.getWidth();
                rect.bottom = rect.top + view2.getHeight();
                view = view2;
            } else {
                z2 = false;
                z = false;
                view = null;
            }
            if (!((Boolean) zzba.zzc().zza(zzbep.zzbq)).booleanValue() || view == null) {
                arrayList = Collections.emptyList();
            } else {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                        View view3 = (View) parent;
                        Rect rect5 = new Rect();
                        if (view3.isScrollContainer() && view3.getGlobalVisibleRect(rect5)) {
                            arrayList2.add(zza(rect5));
                        }
                    }
                    arrayList = arrayList2;
                } catch (Exception e2) {
                    zzu.zzo().zzw(e2, "PositionWatcher.getParentScrollViewRects");
                    arrayList = Collections.emptyList();
                }
            }
            if (view != null) {
                i2 = view.getWindowVisibility();
            } else {
                i2 = 8;
            }
            int i5 = this.zzm;
            if (i5 != -1) {
                i2 = i5;
            }
            zzu.zzp();
            long zzw = zzt.zzw(view);
            if (((Boolean) zzba.zzc().zza(zzbep.zzkC)).booleanValue()) {
                if (view2 != null) {
                    PowerManager powerManager = this.zzg;
                    KeyguardManager keyguardManager = this.zzh;
                    zzu.zzp();
                    if (zzt.zzS(view, powerManager, keyguardManager)) {
                        if (!z2) {
                            z3 = false;
                            z2 = false;
                        } else if (z) {
                            if (zzw < ((long) ((Integer) zzba.zzc().zza(zzbep.zzkF)).intValue()) || i2 != 0) {
                                z2 = true;
                                z = true;
                            } else {
                                z3 = true;
                                z2 = true;
                                z = true;
                                i2 = 0;
                            }
                        } else {
                            z2 = true;
                            z3 = false;
                            z = false;
                        }
                    }
                }
                z3 = false;
            } else {
                if (view2 != null) {
                    PowerManager powerManager2 = this.zzg;
                    KeyguardManager keyguardManager2 = this.zzh;
                    zzu.zzp();
                    if (zzt.zzS(view, powerManager2, keyguardManager2)) {
                        if (!z2) {
                            z3 = false;
                            z2 = false;
                        } else if (!z) {
                            z2 = true;
                            z3 = false;
                            z = false;
                        } else if (i2 == 0) {
                            z3 = true;
                            z2 = true;
                            z = true;
                            i2 = 0;
                        } else {
                            z2 = true;
                            z = true;
                        }
                    }
                }
                z3 = false;
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzkH)).booleanValue()) {
                PowerManager powerManager3 = this.zzg;
                KeyguardManager keyguardManager3 = this.zzh;
                zzu.zzp();
                char c = true != zzt.zzS(view, powerManager3, keyguardManager3) ? 0 : '@';
                char c2 = true != z2 ? (char) 0 : 8;
                char c3 = true != z ? (char) 0 : 16;
                char c4 = i2 == 0 ? (char) 128 : 0;
                char c5 = zzw >= ((long) ((Integer) zzba.zzc().zza(zzbep.zzkF)).intValue()) ? ' ' : 0;
                zzu.zzp();
                zzt.zzJ(view, (c5 | (c4 | ((c | c2) | c3))) | z3 ? 1 : 0, (MotionEvent) null);
            }
            if (i4 != 1 || this.zzk.zzb() || z3 != this.zzl) {
                if (z3 || this.zzl) {
                    z4 = true;
                } else {
                    z4 = true;
                    if (i4 == 1) {
                        return;
                    }
                }
                long elapsedRealtime = zzu.zzB().elapsedRealtime();
                boolean isScreenOn = this.zzg.isScreenOn();
                if (view == null || !view.isAttachedToWindow()) {
                    z5 = false;
                } else {
                    z5 = z4;
                }
                if (view != null) {
                    i3 = view.getWindowVisibility();
                } else {
                    i3 = 8;
                }
                zzbam zzbam = new zzbam(elapsedRealtime, isScreenOn, z5, i3, zza(this.zzp), zza(rect), zza(rect2), z2, zza(rect3), z, zzw, zza(rect4), this.zzo.density, z3, arrayList);
                Iterator it = this.zzn.iterator();
                while (it.hasNext()) {
                    ((zzban) it.next()).zzdp(zzbam);
                }
                this.zzl = z3;
            }
        }
    }

    private final void zzk() {
        zzt.zza.post(new zzbak(this));
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzbal(this);
            zzu.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e) {
                zzm.zzh("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e) {
            zzm.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzm.zzh("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zza != null) {
            try {
                zzu.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e3) {
                zzm.zzh("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzu.zzo().zzw(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e5) {
                zzm.zzh("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    /* access modifiers changed from: package-private */
    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzban zzban) {
        this.zzn.add(zzban);
        zzj(3);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzban zzban) {
        this.zzn.remove(zzban);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j) {
        this.zzk.zza(j);
    }
}
