package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdsh {
    private Context zza;
    private PopupWindow zzb;

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r7, android.view.View r8) {
        /*
            r6 = this;
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastKitKat()
            if (r0 == 0) goto L_0x0067
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastLollipop()
            if (r0 == 0) goto L_0x000d
            goto L_0x0067
        L_0x000d:
            boolean r0 = r7 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L_0x001a
            r0 = r7
            android.app.Activity r0 = (android.app.Activity) r0
            android.view.Window r0 = r0.getWindow()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            if (r0 == 0) goto L_0x005c
            android.view.View r2 = r0.getDecorView()
            if (r2 != 0) goto L_0x0025
            r8 = r1
            goto L_0x005d
        L_0x0025:
            r2 = r7
            android.app.Activity r2 = (android.app.Activity) r2
            boolean r2 = r2.isDestroyed()
            if (r2 == 0) goto L_0x0030
            r8 = r1
            goto L_0x005d
        L_0x0030:
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            r2.<init>(r7)
            android.view.ViewGroup$LayoutParams r3 = new android.view.ViewGroup$LayoutParams
            r4 = -1
            r3.<init>(r4, r4)
            r2.setLayoutParams(r3)
            r2.addView(r8, r4, r4)
            android.widget.PopupWindow r8 = new android.widget.PopupWindow
            r3 = 1
            r5 = 0
            r8.<init>(r2, r3, r3, r5)
            r8.setOutsideTouchable(r3)
            r8.setClippingEnabled(r5)
            java.lang.String r2 = "Displaying the 1x1 popup off the screen."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r2)
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x005b }
            r8.showAtLocation(r0, r5, r4, r4)     // Catch:{ Exception -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r8 = move-exception
        L_0x005c:
            r8 = r1
        L_0x005d:
            r6.zzb = r8
            android.widget.PopupWindow r8 = r6.zzb
            if (r8 != 0) goto L_0x0064
            r7 = r1
        L_0x0064:
            r6.zza = r7
            return
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsh.zza(android.content.Context, android.view.View):void");
    }

    public final void zzb() {
        Context context = this.zza;
        if (context != null && this.zzb != null) {
            if ((!(context instanceof Activity) || !((Activity) context).isDestroyed()) && this.zzb.isShowing()) {
                this.zzb.dismiss();
            }
            this.zza = null;
            this.zzb = null;
        }
    }
}
