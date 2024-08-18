package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxf {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzccn zze = new zzccn();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdst zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdvm zzl;
    private final VersionInfoParcel zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzdgh zzo;
    /* access modifiers changed from: private */
    public final zzfmq zzp;
    private boolean zzq = true;

    public zzdxf(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdst zzdst, ScheduledExecutorService scheduledExecutorService, zzdvm zzdvm, VersionInfoParcel versionInfoParcel, zzdgh zzdgh, zzfmq zzfmq) {
        this.zzh = zzdst;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdvm;
        this.zzm = versionInfoParcel;
        this.zzo = zzdgh;
        this.zzp = zzfmq;
        this.zzd = zzu.zzB().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(zzdxf zzdxf, String str) {
        JSONArray jSONArray;
        zzdxf zzdxf2 = zzdxf;
        zzfmc zza2 = zzfmb.zza(zzdxf2.zzf, zzfmu.CUI_NAME_SDKINIT_ADAPTERINIT);
        zza2.zzj();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzfmc zza3 = zzfmb.zza(zzdxf2.zzf, zzfmu.CUI_NAME_SDKINIT_ADAPTERINIT);
                zza3.zzj();
                zza3.zze(next);
                Object obj = new Object();
                zzccn zzccn = new zzccn();
                ListenableFuture zzo2 = zzgft.zzo(zzccn, ((Long) zzba.zzc().zza(zzbep.zzbP)).longValue(), TimeUnit.SECONDS, zzdxf2.zzk);
                zzdxf2.zzl.zzc(next);
                zzdxf2.zzo.zzc(next);
                long elapsedRealtime = zzu.zzB().elapsedRealtime();
                zzdww zzdww = r1;
                Iterator<String> it = keys;
                ListenableFuture listenableFuture = zzo2;
                String str2 = next;
                zzdww zzdww2 = new zzdww(zzdxf, obj, zzccn, next, elapsedRealtime, zza3);
                listenableFuture.addListener(zzdww, zzdxf2.zzi);
                arrayList.add(listenableFuture);
                zzdxe zzdxe = new zzdxe(zzdxf, obj, str2, elapsedRealtime, zza3, zzccn);
                String str3 = str2;
                JSONObject optJSONObject = jSONObject.optJSONObject(str3);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray2 = optJSONObject.getJSONArray("data");
                        int i = 0;
                        while (i < jSONArray2.length()) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray2 = jSONArray2;
                                }
                                jSONArray = jSONArray2;
                            } else {
                                jSONArray = jSONArray2;
                            }
                            arrayList2.add(new zzbnx(optString, bundle));
                            i++;
                            jSONArray2 = jSONArray;
                        }
                    } catch (JSONException e) {
                    }
                }
                zzdxf2.zzv(str3, false, "", 0);
                try {
                    zzdxf2.zzj.execute(new zzdxa(zzdxf, str3, zzdxe, zzdxf2.zzh.zzc(str3, new JSONObject()), arrayList2));
                    keys = it;
                } catch (zzfhv e2) {
                    try {
                        zzdxe.zze("Failed to create Adapter.");
                        keys = it;
                    } catch (RemoteException e3) {
                        zzm.zzh("", e3);
                        keys = it;
                    }
                }
            }
            zzgft.zza(arrayList).zza(new zzdwx(zzdxf2, zza2), zzdxf2.zzi);
        } catch (JSONException e4) {
            zze.zzb("Malformed CLD response", e4);
            zzdxf2.zzo.zza("MalformedJson");
            zzdxf2.zzl.zza("MalformedJson");
            zzdxf2.zze.zzd(e4);
            zzu.zzo().zzw(e4, "AdapterInitializer.updateAdapterStatus");
            zzfmq zzfmq = zzdxf2.zzp;
            zza2.zzi(e4);
            zza2.zzh(false);
            zzfmq.zzb(zza2.zzn());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc2 = zzu.zzo().zzi().zzh().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzgft.zzh(zzc2);
        }
        zzccn zzccn = new zzccn();
        zzu.zzo().zzi().zzr(new zzdwy(this, zzccn));
        return zzccn;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbnn(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzfmc zzfmc) throws Exception {
        this.zze.zzc(true);
        zzfmc.zzh(true);
        this.zzp.zzb(zzfmc.zzn());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbnn zzbnn = (zzbnn) this.zzn.get(str);
            arrayList.add(new zzbnn(str, zzbnn.zzb, zzbnn.zzc, zzbnn.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
                this.zze.zzd(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str, zzbnr zzbnr, zzfim zzfim, List list) {
        try {
            if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                zzbnr.zzf();
                return;
            }
            Context context = (Context) this.zzg.get();
            if (context == null) {
                context = this.zzf;
            }
            zzfim.zzi(context, zzbnr, list);
        } catch (zzfhv e) {
            try {
                zzbnr.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
        } catch (RemoteException e3) {
            throw new zzfzb(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzccn zzccn) {
        this.zzi.execute(new zzdwv(this, zzccn));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzccn zzccn, String str, long j, zzfmc zzfmc) {
        synchronized (obj) {
            if (!zzccn.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfmq zzfmq = this.zzp;
                zzfmc.zzc("Timeout");
                zzfmc.zzh(false);
                zzfmq.zzb(zzfmc.zzn());
                zzccn.zzc(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbgq.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbep.zzbO)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.addListener(new zzdxb(this), this.zzi);
                            this.zza = true;
                            ListenableFuture zzu = zzu();
                            this.zzk.schedule(new zzdwu(this), ((Long) zzba.zzc().zza(zzbep.zzbQ)).longValue(), TimeUnit.SECONDS);
                            zzgft.zzr(zzu, new zzdxd(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(false);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzbnu zzbnu) {
        this.zze.addListener(new zzdwz(this, zzbnu), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
