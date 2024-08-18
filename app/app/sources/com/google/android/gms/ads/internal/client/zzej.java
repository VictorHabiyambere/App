package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbnn;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzfyv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzej {
    private static zzej zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    public final ArrayList zzc = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public boolean zze = false;
    private final Object zzf = new Object();
    private zzco zzg;
    /* access modifiers changed from: private */
    public OnAdInspectorClosedListener zzh = null;
    private RequestConfiguration zzi = new RequestConfiguration.Builder().build();

    private zzej() {
    }

    private final void zzA(Context context) {
        if (this.zzg == null) {
            this.zzg = (zzco) new zzaq(zzay.zza(), context).zzd(context, false);
        }
    }

    private final void zzB(RequestConfiguration requestConfiguration) {
        try {
            this.zzg.zzu(new zzff(requestConfiguration));
        } catch (RemoteException e) {
            zzm.zzh("Unable to set request configuration parcel.", e);
        }
    }

    public static zzej zzf() {
        zzej zzej;
        synchronized (zzej.class) {
            if (zza == null) {
                zza = new zzej();
            }
            zzej = zza;
        }
        return zzej;
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzy(List list) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbnn zzbnn = (zzbnn) it.next();
            hashMap.put(zzbnn.zza, new zzbnv(zzbnn.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbnn.zzd, zzbnn.zzc));
        }
        return new zzbnw(hashMap);
    }

    private final void zzz(Context context, String str) {
        try {
            zzbqx.zza().zzb(context, (String) null);
            this.zzg.zzk();
            this.zzg.zzl((String) null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzm.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    public final RequestConfiguration zzc() {
        return this.zzi;
    }

    public final InitializationStatus zze() {
        boolean z;
        InitializationStatus zzy;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                zzy = zzy(this.zzg.zzg());
            } catch (RemoteException e) {
                zzm.zzg("Unable to get Initialization status.");
                return new zzeb(this);
            }
        }
        return zzy;
    }

    public final String zzh() {
        boolean z;
        String zzc2;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzc2 = zzfyv.zzc(this.zzg.zzf());
            } catch (RemoteException e) {
                zzm.zzh("Unable to get internal version.", e);
                return "";
            }
        }
        return zzc2;
    }

    public final void zzl(Context context) {
        synchronized (this.zzf) {
            zzA(context);
            try {
                this.zzg.zzi();
            } catch (RemoteException e) {
                zzm.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r3 == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002c, code lost:
        r4 = r2.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        zzA(r3);
        r2.zzg.zzs(new com.google.android.gms.ads.internal.client.zzei(r2, (com.google.android.gms.ads.internal.client.zzeh) null));
        r2.zzg.zzo(new com.google.android.gms.internal.ads.zzbrb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (r2.zzi.getTagForChildDirectedTreatment() != -1) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0056, code lost:
        if (r2.zzi.getTagForUnderAgeOfConsent() == -1) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        zzB(r2.zzi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzk("MobileAdsSettingManager initialization failed", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d7, code lost:
        throw new java.lang.IllegalArgumentException("Context cannot be null.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm(android.content.Context r3, java.lang.String r4, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r5) {
        /*
            r2 = this;
            java.lang.Object r4 = r2.zzb
            monitor-enter(r4)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x0010
            if (r5 == 0) goto L_0x000e
            java.util.ArrayList r3 = r2.zzc     // Catch:{ all -> 0x00d8 }
            r3.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x000e:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x0010:
            boolean r0 = r2.zze     // Catch:{ all -> 0x00d8 }
            if (r0 == 0) goto L_0x001f
            if (r5 == 0) goto L_0x001d
            com.google.android.gms.ads.initialization.InitializationStatus r3 = r2.zze()     // Catch:{ all -> 0x00d8 }
            r5.onInitializationComplete(r3)     // Catch:{ all -> 0x00d8 }
        L_0x001d:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            return
        L_0x001f:
            r0 = 1
            r2.zzd = r0     // Catch:{ all -> 0x00d8 }
            if (r5 == 0) goto L_0x0029
            java.util.ArrayList r0 = r2.zzc     // Catch:{ all -> 0x00d8 }
            r0.add(r5)     // Catch:{ all -> 0x00d8 }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            if (r3 == 0) goto L_0x00d0
            java.lang.Object r4 = r2.zzf
            monitor-enter(r4)
            r5 = 0
            r2.zzA(r3)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzco r0 = r2.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzei r1 = new com.google.android.gms.ads.internal.client.zzei     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>(r2, r5)     // Catch:{ RemoteException -> 0x0060 }
            r0.zzs(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.internal.client.zzco r0 = r2.zzg     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.internal.ads.zzbrb r1 = new com.google.android.gms.internal.ads.zzbrb     // Catch:{ RemoteException -> 0x0060 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0060 }
            r0.zzo(r1)     // Catch:{ RemoteException -> 0x0060 }
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x0060 }
            r1 = -1
            if (r0 != r1) goto L_0x0058
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            int r0 = r0.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x0060 }
            if (r0 == r1) goto L_0x0066
        L_0x0058:
            com.google.android.gms.ads.RequestConfiguration r0 = r2.zzi     // Catch:{ RemoteException -> 0x0060 }
            r2.zzB(r0)     // Catch:{ RemoteException -> 0x0060 }
            goto L_0x0066
        L_0x005e:
            r3 = move-exception
            goto L_0x00ce
        L_0x0060:
            r0 = move-exception
            java.lang.String r1 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r1, r0)     // Catch:{ all -> 0x005e }
        L_0x0066:
            com.google.android.gms.internal.ads.zzbep.zza(r3)     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzbfv r0 = com.google.android.gms.internal.ads.zzbgi.zza     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlf     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0099
            java.lang.String r0 = "Initializing on bg thread"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x005e }
            java.util.concurrent.ThreadPoolExecutor r0 = com.google.android.gms.ads.internal.util.client.zzb.zza     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzec r1 = new com.google.android.gms.ads.internal.client.zzec     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x0099:
            com.google.android.gms.internal.ads.zzbfv r0 = com.google.android.gms.internal.ads.zzbgi.zzb     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzlf     // Catch:{ all -> 0x005e }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x005e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x00c4
            java.util.concurrent.ExecutorService r0 = com.google.android.gms.ads.internal.util.client.zzb.zzb     // Catch:{ all -> 0x005e }
            com.google.android.gms.ads.internal.client.zzed r1 = new com.google.android.gms.ads.internal.client.zzed     // Catch:{ all -> 0x005e }
            r1.<init>(r2, r3, r5)     // Catch:{ all -> 0x005e }
            r0.execute(r1)     // Catch:{ all -> 0x005e }
            goto L_0x00cc
        L_0x00c4:
            java.lang.String r0 = "Initializing on calling thread"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x005e }
            r2.zzz(r3, r5)     // Catch:{ all -> 0x005e }
        L_0x00cc:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            return
        L_0x00ce:
            monitor-exit(r4)     // Catch:{ all -> 0x005e }
            throw r3
        L_0x00d0:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Context cannot be null."
            r3.<init>(r4)
            throw r3
        L_0x00d8:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00d8 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzej.zzm(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, (String) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, (String) null);
        }
    }

    public final void zzp(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzf) {
            zzA(context);
            this.zzh = onAdInspectorClosedListener;
            try {
                this.zzg.zzm(new zzeg((zzef) null));
            } catch (RemoteException e) {
                zzm.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzq(Context context, String str) {
        boolean z;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzg.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzm.zzh("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzr(Class cls) {
        synchronized (this.zzf) {
            try {
                this.zzg.zzh(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzm.zzh("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void zzs(boolean z) {
        boolean z2;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzg.zzp(z);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzt(float f) {
        boolean z;
        boolean z2 = true;
        if (f < 0.0f || f > 1.0f) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzf) {
            if (this.zzg == null) {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzg.zzq(f);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set app volume.", e);
            }
        }
    }

    public final void zzu(String str) {
        boolean z;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzg.zzt(str);
            } catch (RemoteException e) {
                zzm.zzh("Unable to set plugin.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzv(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.zzf
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzi     // Catch:{ all -> 0x0030 }
            r4.zzi = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.ads.internal.client.zzco r2 = r4.zzg     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zzB(r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzej.zzv(com.google.android.gms.ads.RequestConfiguration):void");
    }

    public final boolean zzx(boolean z) {
        boolean z2;
        String str;
        synchronized (this.zzf) {
            if (this.zzg != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            try {
                this.zzg.zzj(z);
            } catch (RemoteException e) {
                if (z) {
                    str = "enable";
                } else {
                    str = "disable";
                }
                zzm.zzh("Unable to " + str + " the publisher first-party ID.", e);
                return false;
            }
        }
        return true;
    }

    public final float zza() {
        float f;
        synchronized (this.zzf) {
            zzco zzco = this.zzg;
            f = 1.0f;
            if (zzco == null) {
                return 1.0f;
            }
            try {
                f = zzco.zze();
            } catch (RemoteException e) {
                zzm.zzh("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final boolean zzw() {
        boolean z;
        synchronized (this.zzf) {
            zzco zzco = this.zzg;
            z = false;
            if (zzco == null) {
                return false;
            }
            try {
                z = zzco.zzv();
            } catch (RemoteException e) {
                zzm.zzh("Unable to get app mute state.", e);
            }
        }
        return z;
    }
}
