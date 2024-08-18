package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcnt extends zzcn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdst zzc;
    private final zzehn zzd;
    private final zzeny zze;
    private final zzdxf zzf;
    private final zzcau zzg;
    private final zzdsy zzh;
    private final zzdya zzi;
    private final zzbhd zzj;
    private final zzfmq zzk;
    private final zzfik zzl;
    private final zzcxd zzm;
    private final zzdvc zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(zzu.zzB().elapsedRealtime());

    zzcnt(Context context, VersionInfoParcel versionInfoParcel, zzdst zzdst, zzehn zzehn, zzeny zzeny, zzdxf zzdxf, zzcau zzcau, zzdsy zzdsy, zzdya zzdya, zzbhd zzbhd, zzfmq zzfmq, zzfik zzfik, zzcxd zzcxd, zzdvc zzdvc) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdst;
        this.zzd = zzehn;
        this.zze = zzeny;
        this.zzf = zzdxf;
        this.zzg = zzcau;
        this.zzh = zzdsy;
        this.zzi = zzdya;
        this.zzj = zzbhd;
        this.zzk = zzfmq;
        this.zzl = zzfik;
        this.zzm = zzcxd;
        this.zzn = zzdvc;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (zzu.zzo().zzi().zzR()) {
            String zzl2 = zzu.zzo().zzi().zzl();
            if (!zzu.zzs().zzj(this.zza, zzl2, this.zzb.afmaVersion)) {
                zzu.zzo().zzi().zzC(false);
                zzu.zzo().zzi().zzB("");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze2 = zzu.zzo().zzi().zzh().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzm.zzk("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbqz zzbqz : zze2.values()) {
                    for (zzbqy zzbqy : zzbqz.zza) {
                        String str = zzbqy.zzk;
                        for (String str2 : zzbqy.zzc) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((List) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzeho zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfim zzfim = (zzfim) zza2.zzb;
                            if (!zzfim.zzC() && zzfim.zzB()) {
                                zzfim.zzj(this.zza, (zzeji) zza2.zzc, (List) entry.getValue());
                                zzm.zze("Initialized rewarded video mediation adapter " + str3);
                            }
                        }
                    } catch (zzfhv e) {
                        zzm.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzfit.zzb(this.zza, true);
    }

    public final synchronized float zze() {
        return zzu.zzr().zza();
    }

    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    public final void zzi() {
        this.zzf.zzl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzo     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbep.zza(r0)     // Catch:{ all -> 0x00a9 }
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r1 = r3.zzb     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzcby r2 = com.google.android.gms.ads.internal.zzu.zzo()     // Catch:{ all -> 0x00a9 }
            r2.zzu(r0, r1)     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzcxd r0 = r3.zzm     // Catch:{ all -> 0x00a9 }
            r0.zzd()     // Catch:{ all -> 0x00a9 }
            android.content.Context r0 = r3.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbcu r1 = com.google.android.gms.ads.internal.zzu.zzc()     // Catch:{ all -> 0x00a9 }
            r1.zzi(r0)     // Catch:{ all -> 0x00a9 }
            r0 = 1
            r3.zzo = r0     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzdxf r0 = r3.zzf     // Catch:{ all -> 0x00a9 }
            r0.zzr()     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzeny r0 = r3.zze     // Catch:{ all -> 0x00a9 }
            r0.zze()     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzdY     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzdsy r0 = r3.zzh     // Catch:{ all -> 0x00a9 }
            r0.zzc()     // Catch:{ all -> 0x00a9 }
        L_0x004e:
            com.google.android.gms.internal.ads.zzdya r0 = r3.zzi     // Catch:{ all -> 0x00a9 }
            r0.zzg()     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzjj     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x006f
            com.google.android.gms.internal.ads.zzgge r0 = com.google.android.gms.internal.ads.zzcci.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzcno r1 = new com.google.android.gms.internal.ads.zzcno     // Catch:{ all -> 0x00a9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00a9 }
            r0.execute(r1)     // Catch:{ all -> 0x00a9 }
        L_0x006f:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzkT     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzgge r0 = com.google.android.gms.internal.ads.zzcci.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzcnq r1 = new com.google.android.gms.internal.ads.zzcnq     // Catch:{ all -> 0x00a9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00a9 }
            r0.execute(r1)     // Catch:{ all -> 0x00a9 }
        L_0x008b:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzcO     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzgge r0 = com.google.android.gms.internal.ads.zzcci.zza     // Catch:{ all -> 0x00a9 }
            com.google.android.gms.internal.ads.zzcnp r1 = new com.google.android.gms.internal.ads.zzcnp     // Catch:{ all -> 0x00a9 }
            r1.<init>(r3)     // Catch:{ all -> 0x00a9 }
            r0.execute(r1)     // Catch:{ all -> 0x00a9 }
        L_0x00a7:
            monitor-exit(r3)
            return
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnt.zzk():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(java.lang.String r12, com.google.android.gms.dynamic.IObjectWrapper r13) {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza
            com.google.android.gms.internal.ads.zzbep.zza(r0)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzec
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ RemoteException -> 0x0021 }
            android.content.Context r0 = r11.zza     // Catch:{ RemoteException -> 0x0021 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzt.zzp(r0)     // Catch:{ RemoteException -> 0x0021 }
            goto L_0x002d
        L_0x0021:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcby r1 = com.google.android.gms.ads.internal.zzu.zzo()
            java.lang.String r2 = "NonagonMobileAdsSettingManager_AppId"
            r1.zzw(r0, r2)
        L_0x002b:
            java.lang.String r0 = ""
        L_0x002d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r2 != r1) goto L_0x0036
            r6 = r12
            goto L_0x0037
        L_0x0036:
            r6 = r0
        L_0x0037:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x003e
            goto L_0x0095
        L_0x003e:
            com.google.android.gms.internal.ads.zzbeg r12 = com.google.android.gms.internal.ads.zzbep.zzdW
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r12 = r0.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzaR
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r12 = r12 | r0
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzaR
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007e
            java.lang.Object r12 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)
            java.lang.Runnable r12 = (java.lang.Runnable) r12
            com.google.android.gms.internal.ads.zzcnr r13 = new com.google.android.gms.internal.ads.zzcnr
            r13.<init>(r11, r12)
            r7 = r13
            goto L_0x0081
        L_0x007e:
            r13 = 0
            r2 = r12
            r7 = r13
        L_0x0081:
            if (r2 == 0) goto L_0x0095
            android.content.Context r4 = r11.zza
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r11.zzb
            com.google.android.gms.internal.ads.zzfmq r8 = r11.zzk
            com.google.android.gms.internal.ads.zzdvc r9 = r11.zzn
            java.lang.Long r10 = r11.zzp
            com.google.android.gms.ads.internal.zzf r3 = com.google.android.gms.ads.internal.zzu.zza()
            r3.zza(r4, r5, r6, r7, r8, r9, r10)
            return
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnt.zzl(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void zzm(zzda zzda) throws RemoteException {
        this.zzi.zzh(zzda, zzdxz.API);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzm.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzm.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzau zzau = new zzau(context);
        zzau.zzn(str);
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzr();
    }

    public final void zzo(zzbrf zzbrf) throws RemoteException {
        this.zzl.zzf(zzbrf);
    }

    public final synchronized void zzp(boolean z) {
        zzu.zzr().zzc(z);
    }

    public final synchronized void zzq(float f) {
        zzu.zzr().zzd(f);
    }

    public final synchronized void zzr(String str) {
        zzbep.zza(this.zza);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzdW)).booleanValue()) {
                zzu.zza().zza(this.zza, this.zzb, str, (Runnable) null, this.zzk, (zzdvc) null, (Long) null);
            }
        }
    }

    public final void zzs(zzbnu zzbnu) throws RemoteException {
        this.zzf.zzs(zzbnu);
    }

    public final void zzt(String str) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzju)).booleanValue()) {
            zzu.zzo().zzz(str);
        }
    }

    public final void zzu(zzff zzff) throws RemoteException {
        this.zzg.zzn(this.zza, zzff);
    }

    public final synchronized boolean zzv() {
        return zzu.zzr().zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbwo());
    }

    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfvh.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }
}
