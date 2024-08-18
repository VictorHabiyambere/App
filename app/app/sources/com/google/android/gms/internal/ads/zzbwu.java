package com.google.android.gms.internal.ads;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbwu extends BaseGmsClient {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbwu(android.content.Context r9, android.os.Looper r10, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks r11, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener r12) {
        /*
            r8 = this;
            android.content.Context r0 = r9.getApplicationContext()
            if (r0 == 0) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r9
        L_0x0009:
            r4 = 8
            r7 = 0
            r1 = r8
            r3 = r10
            r5 = r11
            r6 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwu.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks, com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener):void");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsService");
        return queryLocalInterface instanceof zzbxh ? (zzbxh) queryLocalInterface : new zzbxf(iBinder);
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdsService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.ADS";
    }

    public final zzbxh zzp() throws DeadObjectException {
        return (zzbxh) super.getService();
    }
}
