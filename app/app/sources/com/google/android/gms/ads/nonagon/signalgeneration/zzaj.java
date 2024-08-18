package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaxd;
import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbwe;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzcjd;
import com.google.android.gms.internal.ads.zzdqs;
import com.google.android.gms.internal.ads.zzdul;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzfhs;
import com.google.android.gms.internal.ads.zzfin;
import com.google.android.gms.internal.ads.zzfmb;
import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfmu;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfyv;
import com.google.android.gms.internal.ads.zzgfk;
import com.google.android.gms.internal.ads.zzgft;
import com.google.android.gms.internal.ads.zzgge;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaj extends zzcbf {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final String zzA;
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean zzG = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicInteger zzH = new AtomicInteger(0);
    private final zzbfq zzI;
    private final zze zzJ;
    private final zzcjd zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzaxd zzh;
    private final zzfhs zzi;
    private final zzfin zzj;
    private final zzgge zzk;
    private final ScheduledExecutorService zzl;
    private zzbwe zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    /* access modifiers changed from: private */
    public final zzdvh zzp;
    /* access modifiers changed from: private */
    public final zzfoe zzq;
    /* access modifiers changed from: private */
    public final boolean zzr;
    /* access modifiers changed from: private */
    public final boolean zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final String zzv;
    /* access modifiers changed from: private */
    public final String zzw;
    /* access modifiers changed from: private */
    public final AtomicInteger zzx = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzy;
    /* access modifiers changed from: private */
    public String zzz;

    public zzaj(zzcjd zzcjd, Context context, zzaxd zzaxd, zzfin zzfin, zzgge zzgge, ScheduledExecutorService scheduledExecutorService, zzdvh zzdvh, zzfoe zzfoe, VersionInfoParcel versionInfoParcel, zzbfq zzbfq, zzfhs zzfhs, zze zze2) {
        List list;
        this.zzf = zzcjd;
        this.zzg = context;
        this.zzh = zzaxd;
        this.zzi = zzfhs;
        this.zzj = zzfin;
        this.zzk = zzgge;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdvh;
        this.zzq = zzfoe;
        this.zzy = versionInfoParcel;
        this.zzI = zzbfq;
        this.zzr = ((Boolean) zzba.zzc().zza(zzbep.zzhu)).booleanValue();
        this.zzs = ((Boolean) zzba.zzc().zza(zzbep.zzht)).booleanValue();
        this.zzt = ((Boolean) zzba.zzc().zza(zzbep.zzhw)).booleanValue();
        this.zzu = ((Boolean) zzba.zzc().zza(zzbep.zzhy)).booleanValue();
        this.zzv = (String) zzba.zzc().zza(zzbep.zzhx);
        this.zzw = (String) zzba.zzc().zza(zzbep.zzhz);
        this.zzA = (String) zzba.zzc().zza(zzbep.zzhA);
        this.zzJ = zze2;
        if (((Boolean) zzba.zzc().zza(zzbep.zzhB)).booleanValue()) {
            this.zzB = zzaa((String) zzba.zzc().zza(zzbep.zzhC));
            this.zzC = zzaa((String) zzba.zzc().zza(zzbep.zzhD));
            this.zzD = zzaa((String) zzba.zzc().zza(zzbep.zzhE));
            list = zzaa((String) zzba.zzc().zza(zzbep.zzhF));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            list = zzd;
        }
        this.zzE = list;
    }

    static /* bridge */ /* synthetic */ void zzH(zzaj zzaj, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaj.zzO((Uri) it.next())) {
                zzaj.zzx.getAndIncrement();
                return;
            }
        }
    }

    static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzZ(uri, "nas", str) : uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (r10.equals("NATIVE") != false) goto L_0x0084;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzr zzR(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12, android.os.Bundle r13) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfhm r0 = new com.google.android.gms.internal.ads.zzfhm
            r0.<init>()
            java.lang.String r1 = "REWARDED"
            boolean r2 = r1.equals(r10)
            r3 = 3
            r4 = 2
            java.lang.String r5 = "REWARDED_INTERSTITIAL"
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzfgz r2 = r0.zzp()
            r2.zza(r4)
            goto L_0x0027
        L_0x0019:
            boolean r2 = r5.equals(r10)
            if (r2 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzfgz r2 = r0.zzp()
            r2.zza(r3)
        L_0x0027:
            com.google.android.gms.internal.ads.zzcjd r2 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzq r2 = r2.zzp()
            com.google.android.gms.internal.ads.zzcyt r6 = new com.google.android.gms.internal.ads.zzcyt
            r6.<init>()
            r6.zze(r8)
            if (r9 != 0) goto L_0x0039
            java.lang.String r9 = "adUnitId"
        L_0x0039:
            r0.zzt(r9)
            if (r12 != 0) goto L_0x0047
            com.google.android.gms.ads.internal.client.zzm r9 = new com.google.android.gms.ads.internal.client.zzm
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzl r12 = r9.zza()
        L_0x0047:
            r0.zzH(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00a4
            int r11 = r10.hashCode()
            switch(r11) {
                case -1999289321: goto L_0x007a;
                case -428325382: goto L_0x0070;
                case 543046670: goto L_0x0068;
                case 1854800829: goto L_0x0060;
                case 1951953708: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0083
        L_0x0055:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0054
            r3 = 0
            goto L_0x0084
        L_0x0060:
            boolean r11 = r10.equals(r5)
            if (r11 == 0) goto L_0x0054
            r3 = r4
            goto L_0x0084
        L_0x0068:
            boolean r11 = r10.equals(r1)
            if (r11 == 0) goto L_0x0054
            r3 = r9
            goto L_0x0084
        L_0x0070:
            java.lang.String r11 = "APP_OPEN_AD"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0054
            r3 = 4
            goto L_0x0084
        L_0x007a:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0054
            goto L_0x0084
        L_0x0083:
            r3 = -1
        L_0x0084:
            switch(r3) {
                case 0: goto L_0x009c;
                case 1: goto L_0x0097;
                case 2: goto L_0x0097;
                case 3: goto L_0x0092;
                case 4: goto L_0x008d;
                default: goto L_0x0087;
            }
        L_0x0087:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00a5
        L_0x008d:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzb()
            goto L_0x00a5
        L_0x0092:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzc()
            goto L_0x00a5
        L_0x0097:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzd()
            goto L_0x00a5
        L_0x009c:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
            goto L_0x00a5
        L_0x00a4:
        L_0x00a5:
            r0.zzs(r11)
            r0.zzz(r9)
            r0.zzA(r13)
            com.google.android.gms.internal.ads.zzfho r8 = r0.zzJ()
            r6.zzi(r8)
            com.google.android.gms.internal.ads.zzcyv r8 = r6.zzj()
            r2.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzam r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzam
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzao r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzao
            r10 = 0
            r9.<init>(r8, r10)
            r2.zzb(r9)
            com.google.android.gms.internal.ads.zzdfa r8 = new com.google.android.gms.internal.ads.zzdfa
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzr r8 = r2.zzc()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaj.zzR(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzr");
    }

    private final ListenableFuture zzS(String str) {
        zzdqs[] zzdqsArr = new zzdqs[1];
        ListenableFuture zzn2 = zzgft.zzn(this.zzj.zza(), new zzu(this, zzdqsArr, str), this.zzk);
        zzn2.addListener(new zzv(this, zzdqsArr), this.zzk);
        return zzgft.zze(zzgft.zzm((zzgfk) zzgft.zzo(zzgfk.zzu(zzn2), (long) ((Integer) zzba.zzc().zza(zzbep.zzhL)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzab(), this.zzk), Exception.class, new zzac(), this.zzk);
    }

    /* access modifiers changed from: private */
    public final void zzT() {
        ListenableFuture listenableFuture;
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzlb)).booleanValue()) {
            listenableFuture = zzgft.zzk(new zzs(this), zzcci.zza);
        } else {
            listenableFuture = zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
        }
        zzgft.zzr(listenableFuture, new zzai(this), this.zzf.zzB());
    }

    private final void zzU() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzjB)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzjE)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbep.zzjI)).booleanValue() || !this.zzF.getAndSet(true)) {
                    zzT();
                }
            }
        }
    }

    private final void zzV(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv, boolean z) {
        ListenableFuture listenableFuture;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhK)).booleanValue()) {
            zzm.zzj("The updating URL feature is not enabled.");
            try {
                zzbvv.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (zzO((Uri) it.next())) {
                    i++;
                }
            }
            if (i > 1) {
                zzm.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzO(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    listenableFuture = zzgft.zzh(uri);
                } else {
                    listenableFuture = this.zzk.zzb(new zzw(this, uri, iObjectWrapper));
                    if (zzY()) {
                        listenableFuture = zzgft.zzn(listenableFuture, new zzx(this), this.zzk);
                    } else {
                        zzm.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(listenableFuture);
            }
            zzgft.zzr(zzgft.zzd(arrayList), new zzah(this, zzbvv, z), this.zzf.zzB());
        }
    }

    private final void zzW(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv, boolean z) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhK)).booleanValue()) {
            try {
                zzbvv.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            ListenableFuture zzb2 = this.zzk.zzb(new zzad(this, list, iObjectWrapper));
            if (zzY()) {
                zzb2 = zzgft.zzn(zzb2, new zzae(this), this.zzk);
            } else {
                zzm.zzi("Asset view map is empty.");
            }
            zzgft.zzr(zzb2, new zzag(this, zzbvv, z), this.zzf.zzB());
        }
    }

    private static boolean zzX(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host == null || path == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (path.contains((String) it.next())) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    if (host.endsWith((String) it2.next())) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzY() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzbwe r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaj.zzY():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + "=" + str2 + "&" + uri2.substring(i));
    }

    private static final List zzaa(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfyv.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfmn zzr(ListenableFuture listenableFuture, zzcbk zzcbk) {
        String str;
        if (!zzfmq.zza() || !((Boolean) zzbgd.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfmn zza2 = ((zzr) zzgft.zzp(listenableFuture)).zza();
            zza2.zze(new ArrayList(Collections.singletonList(zzcbk.zzb)));
            zzl zzl2 = zzcbk.zzd;
            if (zzl2 == null) {
                str = "";
            } else {
                str = zzl2.zzp;
            }
            zza2.zzb(str);
            zza2.zzg(zzcbk.zzd.zzm);
            return zza2;
        } catch (ExecutionException e) {
            zzu.zzo().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzP(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzh2 = this.zzh.zzc() != null ? this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzh2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzP(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzZ(uri, "ms", zzh2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(zzdqs[] zzdqsArr) {
        zzdqs zzdqs = zzdqsArr[0];
        if (zzdqs != null) {
            this.zzj.zzb(zzgft.zzh(zzdqs));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(Uri uri) {
        return zzX(uri, this.zzB, this.zzC);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(Uri uri) {
        return zzX(uri, this.zzD, this.zzE);
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzjL)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzI.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        if (((Boolean) zzbgp.zza.zze()).booleanValue()) {
            this.zzJ.zzb();
        }
        return ObjectWrapper.wrap(this.zzI.zzb());
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzcbk zzcbk, zzcbd zzcbd) {
        ListenableFuture listenableFuture;
        ListenableFuture listenableFuture2;
        Bundle bundle = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbep.zzcd)).booleanValue()) {
            bundle.putLong(zzdul.PUBLIC_API_CALL.zza(), zzcbk.zzd.zzz);
            bundle.putLong(zzdul.DYNAMITE_ENTER.zza(), zzu.zzB().currentTimeMillis());
        }
        this.zzg = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfmc zza2 = zzfmb.zza(this.zzg, zzfmu.CUI_NAME_SCAR_SIGNALS);
        zza2.zzj();
        if ("UNKNOWN".equals(zzcbk.zzb)) {
            List arrayList = new ArrayList();
            if (!((String) zzba.zzc().zza(zzbep.zzhJ)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzba.zzc().zza(zzbep.zzhJ)).split(","));
            }
            if (arrayList.contains(zzp.zzc(zzcbk.zzd))) {
                ListenableFuture zzg2 = zzgft.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture2 = zzg2;
                listenableFuture = zzgft.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                zzgft.zzr(listenableFuture, new zzaf(this, listenableFuture2, zzcbk, zzcbd, zza2), this.zzf.zzB());
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzlb)).booleanValue()) {
            ListenableFuture zzb2 = zzcci.zza.zzb(new zzz(this, zzcbk, bundle));
            listenableFuture2 = zzb2;
            listenableFuture = zzgft.zzn(zzb2, new zzaa(), zzcci.zza);
        } else {
            zzr zzR = zzR(this.zzg, zzcbk.zza, zzcbk.zzb, zzcbk.zzc, zzcbk.zzd, bundle);
            ListenableFuture zzh2 = zzgft.zzh(zzR);
            listenableFuture = zzR.zzb();
            listenableFuture2 = zzh2;
        }
        zzgft.zzr(listenableFuture, new zzaf(this, listenableFuture2, zzcbk, zzcbd, zza2), this.zzf.zzB());
    }

    public final void zzg(zzbwe zzbwe) {
        this.zzm = zzbwe;
        this.zzj.zzc(1);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) {
        zzV(list, iObjectWrapper, zzbvv, true);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) {
        zzW(list, iObjectWrapper, zzbvv, true);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzjA)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzhI)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzm.zzg("The webView cannot be null.");
                return;
            }
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ), "gmaSdk");
            if (((Boolean) zzba.zzc().zza(zzbep.zzjK)).booleanValue()) {
                zzu.zzo().zzs();
            }
            if (((Boolean) zzba.zzc().zza(zzbep.zzhI)).booleanValue()) {
                zzU();
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzba.zzc().zza(zzbep.zzhK)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbwe zzbwe = this.zzm;
            if (zzbwe == null) {
                view = null;
            } else {
                view = zzbwe.zza;
            }
            this.zzn = zzbz.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzn.x, (float) this.zzn.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) {
        zzV(list, iObjectWrapper, zzbvv, false);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbvv zzbvv) {
        zzW(list, iObjectWrapper, zzbvv, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzfhs zzfhs;
        try {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzlW)).booleanValue() || (zzfhs = this.zzi) == null) {
                uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            } else {
                uri = zzfhs.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            }
        } catch (zzaxe e) {
            zzm.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzr zzq(zzcbk zzcbk, Bundle bundle) throws Exception {
        return zzR(this.zzg, zzcbk.zza, zzcbk.zzb, zzcbk.zzc, zzcbk.zzd, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzu() throws Exception {
        return zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzv(zzdqs[] zzdqsArr, String str, zzdqs zzdqs) throws Exception {
        zzdqsArr[0] = zzdqs;
        Context context = this.zzg;
        zzbwe zzbwe = this.zzm;
        Map map = zzbwe.zzb;
        JSONObject zzd2 = zzbz.zzd(context, map, map, zzbwe.zza, (ImageView.ScaleType) null);
        JSONObject zzg2 = zzbz.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbz.zzf(this.zzm.zza);
        JSONObject zze2 = zzbz.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbz.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdqs.zzg(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzw(ArrayList arrayList) throws Exception {
        return zzgft.zzm(zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzt(this, arrayList), this.zzk);
    }
}
