package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdmt {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final zzg zzb;
    private final zzfho zzc;
    private final zzdly zzd;
    private final zzdlt zze;
    private final zzdnf zzf;
    private final zzdnn zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbhk zzj;
    private final zzdlq zzk;

    public zzdmt(zzg zzg2, zzfho zzfho, zzdly zzdly, zzdlt zzdlt, zzdnf zzdnf, zzdnn zzdnn, Executor executor, Executor executor2, zzdlq zzdlq) {
        this.zzb = zzg2;
        this.zzc = zzfho;
        this.zzj = zzfho.zzi;
        this.zzd = zzdly;
        this.zze = zzdlt;
        this.zzf = zzdnf;
        this.zzg = zzdnn;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdlq;
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        FrameLayout.LayoutParams layoutParams;
        View zzf2 = z ? this.zze.zzf() : this.zze.zzg();
        if (zzf2 == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzf2.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzf2.getParent()).removeView(zzf2);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzdQ)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        viewGroup.addView(zzf2, layoutParams);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ViewGroup viewGroup) {
        boolean z;
        zzdlt zzdlt = this.zze;
        if (zzdlt.zzf() != null) {
            if (viewGroup != null) {
                z = true;
            } else {
                z = false;
            }
            if (zzdlt.zzc() == 2 || zzdlt.zzc() == 1) {
                this.zzb.zzK(this.zzc.zzf, String.valueOf(zzdlt.zzc()), z);
            } else if (zzdlt.zzc() == 6) {
                this.zzb.zzK(this.zzc.zzf, "2", z);
                this.zzb.zzK(this.zzc.zzf, "1", z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzb(com.google.android.gms.internal.ads.zzdnp r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzdly r0 = r9.zzd
            boolean r0 = r0.zzf()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0016
            com.google.android.gms.internal.ads.zzdly r0 = r9.zzd
            boolean r0 = r0.zze()
            if (r0 == 0) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r6 = r3
            goto L_0x0036
        L_0x0016:
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r5 = "1098"
            r4[r1] = r5
            java.lang.String r5 = "3011"
            r4[r2] = r5
            r5 = r1
        L_0x0022:
            if (r5 >= r0) goto L_0x0014
            r6 = r4[r5]
            android.view.View r6 = r10.zzg(r6)
            if (r6 == 0) goto L_0x0033
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x0033
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            goto L_0x0036
        L_0x0033:
            int r5 = r5 + 1
            goto L_0x0022
        L_0x0036:
            android.view.View r0 = r10.zzf()
            android.content.Context r0 = r0.getContext()
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r5)
            com.google.android.gms.internal.ads.zzdlt r5 = r9.zze
            android.view.View r7 = r5.zze()
            if (r7 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzbhk r0 = r9.zzj
            android.view.View r5 = r5.zze()
            if (r0 != 0) goto L_0x0055
            goto L_0x0091
        L_0x0055:
            if (r6 != 0) goto L_0x0061
            int r0 = r0.zze
            zzh(r4, r0)
            r5.setLayoutParams(r4)
            r6 = r3
            goto L_0x0091
        L_0x0061:
            goto L_0x0091
        L_0x0062:
            com.google.android.gms.internal.ads.zzbho r7 = r5.zzl()
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzbhf
            if (r7 != 0) goto L_0x006c
            r5 = r3
            goto L_0x0091
        L_0x006c:
            com.google.android.gms.internal.ads.zzbho r5 = r5.zzl()
            com.google.android.gms.internal.ads.zzbhf r5 = (com.google.android.gms.internal.ads.zzbhf) r5
            if (r6 != 0) goto L_0x007c
            int r6 = r5.zzc()
            zzh(r4, r6)
            r6 = r3
        L_0x007c:
            com.google.android.gms.internal.ads.zzbhg r7 = new com.google.android.gms.internal.ads.zzbhg
            r7.<init>(r0, r5, r4)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzdO
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r4.zza(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7.setContentDescription(r0)
            r5 = r7
        L_0x0091:
            r0 = -1
            if (r5 != 0) goto L_0x0095
            goto L_0x00d7
        L_0x0095:
            android.view.ViewParent r4 = r5.getParent()
            boolean r4 = r4 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x00a6
            android.view.ViewParent r4 = r5.getParent()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r4.removeView(r5)
        L_0x00a6:
            if (r6 == 0) goto L_0x00af
            r6.removeAllViews()
            r6.addView(r5)
            goto L_0x00d0
        L_0x00af:
            com.google.android.gms.ads.formats.zza r4 = new com.google.android.gms.ads.formats.zza
            android.view.View r6 = r10.zzf()
            android.content.Context r6 = r6.getContext()
            r4.<init>(r6)
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r6.<init>(r0, r0)
            r4.setLayoutParams(r6)
            r4.addView(r5)
            android.widget.FrameLayout r6 = r10.zzh()
            if (r6 == 0) goto L_0x00d0
            r6.addView(r4)
        L_0x00d0:
            java.lang.String r4 = r10.zzk()
            r10.zzq(r4, r5, r2)
        L_0x00d7:
            com.google.android.gms.internal.ads.zzgbc r4 = com.google.android.gms.internal.ads.zzdmp.zza
            int r5 = r4.size()
            r6 = r1
        L_0x00de:
            if (r6 >= r5) goto L_0x00f3
            java.lang.Object r7 = r4.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            android.view.View r7 = r10.zzg(r7)
            boolean r8 = r7 instanceof android.view.ViewGroup
            int r6 = r6 + 1
            if (r8 == 0) goto L_0x00de
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L_0x00f4
        L_0x00f3:
            r7 = r3
        L_0x00f4:
            java.util.concurrent.Executor r4 = r9.zzi
            com.google.android.gms.internal.ads.zzdmq r5 = new com.google.android.gms.internal.ads.zzdmq
            r5.<init>(r9, r7)
            r4.execute(r5)
            if (r7 != 0) goto L_0x0102
            goto L_0x01b4
        L_0x0102:
            boolean r2 = r9.zzi(r7, r2)
            if (r2 == 0) goto L_0x011d
            com.google.android.gms.internal.ads.zzdlt r0 = r9.zze
            com.google.android.gms.internal.ads.zzchd r1 = r0.zzs()
            if (r1 == 0) goto L_0x01b4
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzs()
            com.google.android.gms.internal.ads.zzdms r1 = new com.google.android.gms.internal.ads.zzdms
            r1.<init>(r10, r7)
            r0.zzar(r1)
            return
        L_0x011d:
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzjZ
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x014a
            boolean r1 = r9.zzi(r7, r1)
            if (r1 == 0) goto L_0x014a
            com.google.android.gms.internal.ads.zzdlt r0 = r9.zze
            com.google.android.gms.internal.ads.zzchd r1 = r0.zzq()
            if (r1 == 0) goto L_0x01b4
            com.google.android.gms.internal.ads.zzchd r0 = r0.zzq()
            com.google.android.gms.internal.ads.zzdms r1 = new com.google.android.gms.internal.ads.zzdms
            r1.<init>(r10, r7)
            r0.zzar(r1)
            return
        L_0x014a:
            r7.removeAllViews()
            android.view.View r1 = r10.zzf()
            if (r1 == 0) goto L_0x0158
            android.content.Context r3 = r1.getContext()
            goto L_0x0159
        L_0x0158:
        L_0x0159:
            if (r3 == 0) goto L_0x01b4
            com.google.android.gms.internal.ads.zzdlq r1 = r9.zzk
            com.google.android.gms.internal.ads.zzbhs r1 = r1.zza()
            if (r1 == 0) goto L_0x01b4
            com.google.android.gms.dynamic.IObjectWrapper r1 = r1.zzi()     // Catch:{ RemoteException -> 0x01ad }
            if (r1 == 0) goto L_0x01b4
            java.lang.Object r1 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r1)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            if (r1 == 0) goto L_0x01b4
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r3)
            r2.setImageDrawable(r1)
            com.google.android.gms.dynamic.IObjectWrapper r10 = r10.zzj()
            if (r10 == 0) goto L_0x019c
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzgr
            com.google.android.gms.internal.ads.zzben r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0192
            goto L_0x019c
        L_0x0192:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r10)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            r2.setScaleType(r10)
            goto L_0x01a1
        L_0x019c:
            android.widget.ImageView$ScaleType r10 = zza
            r2.setScaleType(r10)
        L_0x01a1:
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r0, r0)
            r2.setLayoutParams(r10)
            r7.addView(r2)
            return
        L_0x01ad:
            r10 = move-exception
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)
            return
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmt.zzb(com.google.android.gms.internal.ads.zzdnp):void");
    }

    public final void zzc(zzdnp zzdnp) {
        if (zzdnp != null && this.zzf != null && zzdnp.zzh() != null && this.zzd.zzg()) {
            try {
                zzdnp.zzh().addView(this.zzf.zza());
            } catch (zzchp e) {
                zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzdnp zzdnp) {
        if (zzdnp != null) {
            Context context = zzdnp.zzf().getContext();
            if (!zzbz.zzh(context, this.zzd.zza)) {
                return;
            }
            if (!(context instanceof Activity)) {
                zzm.zze("Activity context is needed for policy validator.");
            } else if (this.zzg != null && zzdnp.zzh() != null) {
                try {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    windowManager.addView(this.zzg.zza(zzdnp.zzh(), windowManager), zzbz.zzb());
                } catch (zzchp e) {
                    zze.zzb("web view can not be obtained", e);
                }
            }
        }
    }

    public final void zze(zzdnp zzdnp) {
        this.zzh.execute(new zzdmr(this, zzdnp));
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        switch (i) {
            case 0:
                layoutParams.addRule(10);
                layoutParams.addRule(9);
                return;
            case 2:
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                return;
            case 3:
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                return;
            default:
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                return;
        }
    }
}
