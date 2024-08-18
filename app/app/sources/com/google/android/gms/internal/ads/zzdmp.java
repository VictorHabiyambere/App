package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdmp extends zzbhy implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdnp {
    public static final zzgbc zza = zzgbc.zzp("2011", "1009", "3010");
    private final String zzb;
    private Map zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzgge zzf;
    private View zzg;
    private final int zzh;
    private zzdlo zzi;
    private zzbao zzj;
    private IObjectWrapper zzk = null;
    private zzbhs zzl;
    private boolean zzm;
    private boolean zzn = false;
    private GestureDetector zzo;

    public zzdmp(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 241806000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        zzu.zzx();
        zzccv.zza(frameLayout, this);
        zzu.zzx();
        zzccv.zzb(frameLayout, this);
        this.zzf = zzcci.zze;
        this.zzj = new zzbao(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e) {
                    zzm.zzk("Encountered invalid base64 watermark.", e);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    private final synchronized void zzu() {
        this.zzf.execute(new zzdmo(this));
    }

    private final synchronized void zzv() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue() && this.zzi.zza() != 0) {
            this.zzo = new GestureDetector(this.zzd.getContext(), new zzdmv(this.zzi, this));
        }
    }

    public final synchronized void onClick(View view) {
        zzdlo zzdlo = this.zzi;
        if (zzdlo != null && zzdlo.zzU()) {
            this.zzi.zzv();
            this.zzi.zzD(view, this.zzd, zzl(), zzm(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdlo zzdlo = this.zzi;
        if (zzdlo != null) {
            FrameLayout frameLayout = this.zzd;
            zzdlo.zzB(frameLayout, zzl(), zzm(), zzdlo.zzX(frameLayout));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdlo zzdlo = this.zzi;
        if (zzdlo != null) {
            FrameLayout frameLayout = this.zzd;
            zzdlo.zzB(frameLayout, zzl(), zzm(), zzdlo.zzX(frameLayout));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdlo zzdlo = this.zzi;
        if (zzdlo != null) {
            zzdlo.zzK(view, motionEvent, this.zzd);
            if (!(!((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue() || this.zzo == null || this.zzi.zza() == 0)) {
                this.zzo.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    public final synchronized IObjectWrapper zzb(String str) {
        return ObjectWrapper.wrap(zzg(str));
    }

    public final synchronized void zzc() {
        if (!this.zzn) {
            zzdlo zzdlo = this.zzi;
            if (zzdlo != null) {
                zzdlo.zzS(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzdv(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzdw(IObjectWrapper iObjectWrapper) {
        this.zzi.zzM((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzdx(zzbhs zzbhs) {
        if (!this.zzn) {
            this.zzm = true;
            this.zzl = zzbhs;
            zzdlo zzdlo = this.zzi;
            if (zzdlo != null) {
                zzdlo.zzc().zzb(zzbhs);
            }
        }
    }

    public final synchronized void zzdy(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final synchronized void zzdz(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzdlo)) {
                zzm.zzj("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzdlo zzdlo = this.zzi;
            if (zzdlo != null) {
                zzdlo.zzS(this);
            }
            zzu();
            this.zzi = (zzdlo) unwrap;
            this.zzi.zzR(this);
            this.zzi.zzJ(this.zzd);
            this.zzi.zzu(this.zze);
            if (this.zzm) {
                this.zzi.zzc().zzb(this.zzl);
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzdT)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzg())) {
                zzt(this.zzi.zzg());
            }
            zzv();
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    public final synchronized View zzg(String str) {
        WeakReference weakReference;
        if (this.zzn || (weakReference = (WeakReference) this.zzc.get(str)) == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final FrameLayout zzh() {
        return this.zze;
    }

    public final zzbao zzi() {
        return this.zzj;
    }

    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    public final synchronized String zzk() {
        return this.zzb;
    }

    public final synchronized Map zzl() {
        return this.zzc;
    }

    public final synchronized Map zzm() {
        return this.zzc;
    }

    public final synchronized Map zzn() {
        return null;
    }

    public final synchronized JSONObject zzo() {
        zzdlo zzdlo = this.zzi;
        if (zzdlo == null) {
            return null;
        }
        return zzdlo.zzi(this.zzd, zzl(), zzm());
    }

    public final synchronized JSONObject zzp() {
        zzdlo zzdlo = this.zzi;
        if (zzdlo == null) {
            return null;
        }
        return zzdlo.zzk(this.zzd, zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x0006
            goto L_0x000d
        L_0x0006:
            if (r3 != 0) goto L_0x000f
            java.util.Map r3 = r1.zzc     // Catch:{ all -> 0x003e }
            r3.remove(r2)     // Catch:{ all -> 0x003e }
        L_0x000d:
            monitor-exit(r1)
            return
        L_0x000f:
            java.util.Map r4 = r1.zzc     // Catch:{ all -> 0x003e }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x003e }
            r0.<init>(r3)     // Catch:{ all -> 0x003e }
            r4.put(r2, r0)     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x000d
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x000d
            int r2 = r1.zzh     // Catch:{ all -> 0x003e }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbz.zzi(r2)     // Catch:{ all -> 0x003e }
            if (r2 == 0) goto L_0x0034
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x003e }
        L_0x0034:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x003e }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x003e }
            monitor-exit(r1)
            return
        L_0x003e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmp.zzq(java.lang.String, android.view.View, boolean):void");
    }

    public final FrameLayout zzr() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs() {
        if (this.zzg == null) {
            this.zzg = new View(this.zzd.getContext());
            this.zzg.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
