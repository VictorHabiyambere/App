package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdlo extends zzcup {
    public static final zzgbc zzc = zzgbc.zzr("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzbap zzA;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final zzdlt zze;
    private final zzdmb zzf;
    private final zzdmt zzg;
    private final zzdly zzh;
    private final zzdme zzi;
    private final zzhkj zzj;
    private final zzhkj zzk;
    private final zzhkj zzl;
    private final zzhkj zzm;
    private final zzhkj zzn;
    /* access modifiers changed from: private */
    public zzdnp zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzcaq zzs;
    private final zzaxd zzt;
    private final VersionInfoParcel zzu;
    private final Context zzv;
    private final zzdlq zzw;
    private final zzepf zzx;
    /* access modifiers changed from: private */
    public final Map zzy = new HashMap();
    private final List zzz = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdlo(zzcuo zzcuo, Executor executor, zzdlt zzdlt, zzdmb zzdmb, zzdmt zzdmt, zzdly zzdly, zzdme zzdme, zzhkj zzhkj, zzhkj zzhkj2, zzhkj zzhkj3, zzhkj zzhkj4, zzhkj zzhkj5, zzcaq zzcaq, zzaxd zzaxd, VersionInfoParcel versionInfoParcel, Context context, zzdlq zzdlq, zzepf zzepf, zzbap zzbap) {
        super(zzcuo);
        this.zzd = executor;
        this.zze = zzdlt;
        this.zzf = zzdmb;
        this.zzg = zzdmt;
        this.zzh = zzdly;
        this.zzi = zzdme;
        this.zzj = zzhkj;
        this.zzk = zzhkj2;
        this.zzl = zzhkj3;
        this.zzm = zzhkj4;
        this.zzn = zzhkj5;
        this.zzs = zzcaq;
        this.zzt = zzaxd;
        this.zzu = versionInfoParcel;
        this.zzv = context;
        this.zzw = zzdlq;
        this.zzx = zzepf;
        this.zzA = zzbap;
    }

    public static boolean zzX(View view) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzkE)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
        }
        zzu.zzp();
        long zzw2 = zzt.zzw(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (zzw2 >= ((long) ((Integer) zzba.zzc().zza(zzbep.zzkF)).intValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0 != null ? (android.widget.ImageView.ScaleType) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0) : com.google.android.gms.internal.ads.zzdmt.zza;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized android.widget.ImageView.ScaleType zzZ() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdnp r0 = r1.zzo     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x000d
            java.lang.String r0 = "Ad should be associated with an ad view before calling getMediaviewScaleType()"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x001e }
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x000d:
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzj()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001b
            java.lang.Object r0 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r0)     // Catch:{ all -> 0x001e }
            android.widget.ImageView$ScaleType r0 = (android.widget.ImageView.ScaleType) r0     // Catch:{ all -> 0x001e }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            android.widget.ImageView$ScaleType r0 = com.google.android.gms.internal.ads.zzdmt.zza     // Catch:{ all -> 0x001e }
            goto L_0x0019
        L_0x001e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlo.zzZ():android.widget.ImageView$ScaleType");
    }

    private final void zzaa(String str, boolean z) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfi)).booleanValue()) {
            ListenableFuture zzw2 = this.zze.zzw();
            if (zzw2 != null) {
                zzgft.zzr(zzw2, new zzdlm(this, "Google", true), this.zzd);
                return;
            }
            return;
        }
        zzf("Google", true);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzZ());
        this.zzq = true;
    }

    /* access modifiers changed from: private */
    public final void zzac(View view, zzehg zzehg) {
        zzchd zzr2 = this.zze.zzr();
        if (this.zzh.zzd() && zzehg != null && zzr2 != null && view != null) {
            zzu.zzA().zzj(zzehg.zza(), view);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        return;
     */
    /* renamed from: zzad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzz(com.google.android.gms.internal.ads.zzdnp r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzp     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0007
            goto L_0x00b5
        L_0x0007:
            r7.zzo = r8     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdmt r0 = r7.zzg     // Catch:{ all -> 0x00b7 }
            r0.zze(r8)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdmb r1 = r7.zzf     // Catch:{ all -> 0x00b7 }
            android.view.View r2 = r8.zzf()     // Catch:{ all -> 0x00b7 }
            java.util.Map r3 = r8.zzm()     // Catch:{ all -> 0x00b7 }
            java.util.Map r4 = r8.zzn()     // Catch:{ all -> 0x00b7 }
            r5 = r8
            r6 = r8
            r1.zzy(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzcD     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzaxd r0 = r7.zzt     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzawz r0 = r0.zzc()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0042
            android.view.View r1 = r8.zzf()     // Catch:{ all -> 0x00b7 }
            r0.zzo(r1)     // Catch:{ all -> 0x00b7 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzbL     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzfgt r0 = r7.zzb     // Catch:{ all -> 0x00b7 }
            boolean r1 = r0.zzal     // Catch:{ all -> 0x00b7 }
            if (r1 != 0) goto L_0x005b
            goto L_0x00a4
        L_0x005b:
            org.json.JSONObject r0 = r0.zzak     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r0 = r0.keys()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a4
        L_0x0063:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdnp r2 = r7.zzo     // Catch:{ all -> 0x00b7 }
            java.util.Map r2 = r2.zzl()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00b7 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x00b7 }
            java.util.Map r3 = r7.zzy     // Catch:{ all -> 0x00b7 }
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b7 }
            r3.put(r1, r4)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0063
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00b7 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0063
            android.content.Context r3 = r7.zzv     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbao r4 = new com.google.android.gms.internal.ads.zzbao     // Catch:{ all -> 0x00b7 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x00b7 }
            java.util.List r2 = r7.zzz     // Catch:{ all -> 0x00b7 }
            r2.add(r4)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdll r2 = new com.google.android.gms.internal.ads.zzdll     // Catch:{ all -> 0x00b7 }
            r2.<init>(r7, r1)     // Catch:{ all -> 0x00b7 }
            r4.zzc(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0063
        L_0x00a4:
            com.google.android.gms.internal.ads.zzbao r0 = r8.zzi()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzbao r8 = r8.zzi()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzcaq r0 = r7.zzs     // Catch:{ all -> 0x00b7 }
            r8.zzc(r0)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r7)
            return
        L_0x00b5:
            monitor-exit(r7)
            return
        L_0x00b7:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlo.zzz(com.google.android.gms.internal.ads.zzdnp):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzA(zzdnp zzdnp) {
        this.zzf.zzz(zzdnp.zzf(), zzdnp.zzl());
        if (zzdnp.zzh() != null) {
            zzdnp.zzh().setClickable(false);
            zzdnp.zzh().removeAllViews();
        }
        if (zzdnp.zzi() != null) {
            zzdnp.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzB(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0007
            goto L_0x0087
        L_0x0007:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzbL     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzfgt r0 = r3.zzb     // Catch:{ all -> 0x008e }
            boolean r0 = r0.zzal     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0044
            java.util.Map r0 = r3.zzy     // Catch:{ all -> 0x008e }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x008e }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x008e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x008e }
            java.util.Map r2 = r3.zzy     // Catch:{ all -> 0x008e }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x008e }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x008e }
            if (r1 != 0) goto L_0x0029
            goto L_0x0087
        L_0x0044:
            if (r7 != 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzbeg r7 = com.google.android.gms.internal.ads.zzbep.zzdS     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008e }
            java.lang.Object r7 = r0.zza(r7)     // Catch:{ all -> 0x008e }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x008e }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x0087
            if (r5 == 0) goto L_0x0087
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x008e }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x008e }
        L_0x0062:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0087
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x008e }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x008e }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x008e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x008e }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            boolean r0 = zzX(r0)     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x0062
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x0087:
            monitor-exit(r3)
            return
        L_0x0089:
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x008e }
            monitor-exit(r3)
            return
        L_0x008e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlo.zzB(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzC(zzcw zzcw) {
        this.zzf.zzj(zzcw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzD(android.view.View r10, android.view.View r11, java.util.Map r12, java.util.Map r13, boolean r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzdmt r0 = r9.zzg     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdnp r1 = r9.zzo     // Catch:{ all -> 0x0035 }
            r0.zzc(r1)     // Catch:{ all -> 0x0035 }
            android.widget.ImageView$ScaleType r8 = r9.zzZ()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdmb r2 = r9.zzf     // Catch:{ all -> 0x0035 }
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.zzk(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0035 }
            boolean r10 = r9.zzr     // Catch:{ all -> 0x0035 }
            if (r10 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzdlt r10 = r9.zze     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzchd r11 = r10.zzs()     // Catch:{ all -> 0x0035 }
            if (r11 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            com.google.android.gms.internal.ads.zzchd r10 = r10.zzs()     // Catch:{ all -> 0x0035 }
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0035 }
            r11.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r12 = "onSdkAdUserInteractionClick"
            r10.zzd(r12, r11)     // Catch:{ all -> 0x0035 }
            monitor-exit(r9)
            return
        L_0x0033:
            monitor-exit(r9)
            return
        L_0x0035:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlo.zzD(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzE(View view, int i) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzlA)).booleanValue()) {
            zzdnp zzdnp = this.zzo;
            if (zzdnp == null) {
                zzm.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                this.zzd.execute(new zzdli(this, view, zzdnp instanceof zzdmn, i));
            }
        }
    }

    public final synchronized void zzF(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzG(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzH() {
        zzdnp zzdnp = this.zzo;
        if (zzdnp == null) {
            zzm.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzd.execute(new zzdlk(this, zzdnp instanceof zzdmn));
        }
    }

    public final synchronized void zzI() {
        if (!this.zzq) {
            this.zzf.zzr();
        }
    }

    public final void zzJ(View view) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzfi)).booleanValue()) {
            zzccn zzp2 = this.zze.zzp();
            if (zzp2 != null) {
                zzgft.zzr(zzp2, new zzdln(this, view), this.zzd);
                return;
            }
            return;
        }
        zzac(view, this.zze.zzu());
    }

    public final synchronized void zzK(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzL(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzM(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzN() {
        this.zzf.zzv();
    }

    public final synchronized void zzO(zzcs zzcs) {
        this.zzf.zzw(zzcs);
    }

    public final synchronized void zzP(zzdg zzdg) {
        this.zzx.zza(zzdg);
    }

    public final synchronized void zzQ(zzbjp zzbjp) {
        this.zzf.zzx(zzbjp);
    }

    public final synchronized void zzR(zzdnp zzdnp) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzbJ)).booleanValue()) {
            zzt.zza.post(new zzdle(this, zzdnp));
        } else {
            zzz(zzdnp);
        }
    }

    public final synchronized void zzS(zzdnp zzdnp) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzbJ)).booleanValue()) {
            zzt.zza.post(new zzdlf(this, zzdnp));
        } else {
            zzA(zzdnp);
        }
    }

    public final boolean zzT() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzU() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzV() {
        return this.zzf.zzB();
    }

    public final boolean zzW() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzY(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzC = this.zzf.zzC(bundle);
        this.zzq = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new zzdlj(this));
        super.zzb();
    }

    public final zzdlq zzc() {
        return this.zzw;
    }

    public final zzehg zzf(String str, boolean z) {
        boolean z2;
        boolean z3;
        String str2;
        zzehc zzehc;
        zzehd zzehd;
        String str3;
        if (!this.zzh.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdlt zzdlt = this.zze;
        zzchd zzr2 = zzdlt.zzr();
        zzchd zzs2 = zzdlt.zzs();
        if (zzr2 == null && zzs2 == null) {
            zzm.zzj("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z4 = false;
        if (zzr2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (zzs2 != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzfg)).booleanValue()) {
            this.zzh.zza();
            int zzc2 = this.zzh.zza().zzc();
            switch (zzc2 - 1) {
                case 0:
                    if (zzs2 != null) {
                        z3 = true;
                        break;
                    } else {
                        zzm.zzj("Omid media type was video but there was no video webview.");
                        return null;
                    }
                case 1:
                    if (zzr2 != null) {
                        z3 = false;
                        z4 = true;
                        break;
                    } else {
                        zzm.zzj("Omid media type was display but there was no display webview.");
                        return null;
                    }
                default:
                    switch (zzc2) {
                        case 1:
                            str3 = "VIDEO";
                            break;
                        case 2:
                            str3 = "DISPLAY";
                            break;
                        default:
                            str3 = "UNKNOWN";
                            break;
                    }
                    zzm.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                    return null;
            }
        } else {
            z4 = z2;
        }
        if (z4) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzr2 = zzs2;
        }
        zzr2.zzG();
        if (!zzu.zzA().zzl(this.zzv)) {
            zzm.zzj("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        VersionInfoParcel versionInfoParcel = this.zzu;
        String str4 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
        if (z3) {
            zzehc = zzehc.VIDEO;
            zzehd = zzehd.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdlt zzdlt2 = this.zze;
            zzehc zzehc2 = zzehc.NATIVE_DISPLAY;
            if (zzdlt2.zzc() == 3) {
                zzehd = zzehd.UNSPECIFIED;
                zzehc = zzehc2;
            } else {
                zzehd = zzehd.ONE_PIXEL;
                zzehc = zzehc2;
            }
        }
        zzehg zzb = zzu.zzA().zzb(str4, zzr2.zzG(), "", "javascript", str2, str, zzehd, zzehc, this.zzb.zzam);
        if (zzb == null) {
            zzm.zzj("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zze.zzW(zzb);
        zzr2.zzat(zzb);
        if (z3) {
            zzu.zzA().zzj(zzb.zza(), zzs2.zzF());
            this.zzr = true;
        }
        if (z) {
            zzu.zzA().zzk(zzb.zza());
            zzr2.zzd("onSdkLoaded", new ArrayMap());
        }
        return zzb;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzZ());
    }

    public final void zzj() {
        this.zzd.execute(new zzdlg(this));
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            zzdmb zzdmb = this.zzf;
            Objects.requireNonNull(zzdmb);
            executor.execute(new zzdlh(zzdmb));
        }
        super.zzj();
    }

    public final synchronized JSONObject zzk(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzZ());
    }

    public final void zzu(View view) {
        zzehg zzu2 = this.zze.zzu();
        if (this.zzh.zzd() && zzu2 != null && view != null) {
            zzu.zzA().zzg(zzu2.zza(), view);
        }
    }

    public final synchronized void zzv() {
        this.zzf.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        this.zzf.zzi();
        this.zze.zzI();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(View view, boolean z, int i) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzy(boolean z) {
        this.zzf.zzo((View) null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), 0);
    }

    public static /* synthetic */ void zzs(zzdlo zzdlo) {
        try {
            zzdlt zzdlt = zzdlo.zze;
            switch (zzdlt.zzc()) {
                case 1:
                    if (zzdlo.zzi.zzb() != null) {
                        zzdlo.zzaa("Google", true);
                        zzdlo.zzi.zzb().zze((zzbim) zzdlo.zzj.zzb());
                        return;
                    }
                    return;
                case 2:
                    if (zzdlo.zzi.zza() != null) {
                        zzdlo.zzaa("Google", true);
                        zzdlo.zzi.zza().zze((zzbik) zzdlo.zzk.zzb());
                        return;
                    }
                    return;
                case 3:
                    if (zzdlo.zzi.zzd(zzdlt.zzA()) != null) {
                        if (zzdlo.zze.zzs() != null) {
                            zzdlo.zzf("Google", true);
                        }
                        zzdlo.zzi.zzd(zzdlo.zze.zzA()).zze((zzbip) zzdlo.zzn.zzb());
                        return;
                    }
                    return;
                case 6:
                    if (zzdlo.zzi.zzf() != null) {
                        zzdlo.zzaa("Google", true);
                        zzdlo.zzi.zzf().zze((zzbjs) zzdlo.zzl.zzb());
                        return;
                    }
                    return;
                case 7:
                    zzdme zzdme = zzdlo.zzi;
                    if (zzdme.zzg() != null) {
                        zzdme.zzg().zzg((zzboc) zzdlo.zzm.zzb());
                        return;
                    }
                    return;
                default:
                    zzm.zzg("Wrong native template id!");
                    return;
            }
        } catch (RemoteException e) {
            zzm.zzh("RemoteException when notifyAdLoad is called", e);
        }
        zzm.zzh("RemoteException when notifyAdLoad is called", e);
    }
}
