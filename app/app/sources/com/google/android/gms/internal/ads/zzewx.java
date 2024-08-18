package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzp;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzewx implements zzexw {
    final String zza;
    private final zzgge zzb;
    private final ScheduledExecutorService zzc;
    private final zzeny zzd;
    private final Context zze;
    private final zzfho zzf;
    private final zzenu zzg;
    private final zzdst zzh;
    private final zzdxh zzi;

    zzewx(zzgge zzgge, ScheduledExecutorService scheduledExecutorService, String str, zzeny zzeny, Context context, zzfho zzfho, zzenu zzenu, zzdst zzdst, zzdxh zzdxh) {
        this.zzb = zzgge;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzeny;
        this.zze = context;
        this.zzf = zzfho;
        this.zzg = zzenu;
        this.zzh = zzdst;
        this.zzi = zzdxh;
    }

    public static /* synthetic */ ListenableFuture zzc(zzewx zzewx) {
        String str;
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbep.zzkR)).booleanValue()) {
            str = zzewx.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzewx.zzf.zzf;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzbE)).booleanValue()) {
            bundle = zzewx.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        if (!((Boolean) zzba.zzc().zza(zzbep.zzbN)).booleanValue()) {
            for (Map.Entry entry : ((zzgbf) zzewx.zzd.zzb(zzewx.zza, str)).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzewx.zzg(str2, (List) entry.getValue(), zzewx.zzf(str2), true, true));
            }
            zzewx.zzi(arrayList, zzewx.zzd.zzc());
        } else {
            zzewx.zzi(arrayList, zzewx.zzd.zza(zzewx.zza, str));
        }
        return zzgft.zzb(arrayList).zza(new zzews(arrayList, bundle), zzewx.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgfk zzg(String str, List list, Bundle bundle, boolean z, boolean z2) {
        zzgfk zzu = zzgfk.zzu(zzgft.zzk(new zzewu(this, str, list, bundle, z, z2), this.zzb));
        if (!((Boolean) zzba.zzc().zza(zzbep.zzbA)).booleanValue()) {
            zzu = (zzgfk) zzgft.zzo(zzu, ((Long) zzba.zzc().zza(zzbep.zzbt)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgfk) zzgft.zze(zzu, Throwable.class, new zzewv(str), this.zzb);
    }

    private final void zzh(zzbte zzbte, Bundle bundle, List list, zzeob zzeob) throws RemoteException {
        zzbte zzbte2 = zzbte;
        zzbte2.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeob);
    }

    private final void zzi(List list, Map map) {
        for (Map.Entry value : map.entrySet()) {
            zzeoc zzeoc = (zzeoc) value.getValue();
            String str = zzeoc.zza;
            list.add(zzg(str, Collections.singletonList(zzeoc.zze), zzf(str), zzeoc.zzb, zzeoc.zzc));
        }
    }

    public final int zza() {
        return 32;
    }

    public final ListenableFuture zzb() {
        zzfho zzfho = this.zzf;
        if (zzfho.zzr) {
            if (!Arrays.asList(((String) zzba.zzc().zza(zzbep.zzbG)).split(",")).contains(zzp.zzb(zzp.zzc(zzfho.zzd)))) {
                return zzgft.zzh(new zzewy(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgft.zzk(new zzewr(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r9, java.util.List r10, android.os.Bundle r11, boolean r12, boolean r13) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzccn r7 = new com.google.android.gms.internal.ads.zzccn
            r7.<init>()
            r0 = 0
            if (r13 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzbeg r13 = com.google.android.gms.internal.ads.zzbep.zzbF
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r1.zza(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzenu r13 = r8.zzg
            r13.zzb(r9)
            com.google.android.gms.internal.ads.zzenu r13 = r8.zzg
            com.google.android.gms.internal.ads.zzbte r13 = r13.zza(r9)
            goto L_0x0034
        L_0x0026:
            com.google.android.gms.internal.ads.zzdst r13 = r8.zzh     // Catch:{ RemoteException -> 0x002d }
            com.google.android.gms.internal.ads.zzbte r13 = r13.zzb(r9)     // Catch:{ RemoteException -> 0x002d }
            goto L_0x0034
        L_0x002d:
            r13 = move-exception
            java.lang.String r1 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r13)
            r13 = r0
        L_0x0034:
            if (r13 != 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzbeg r10 = com.google.android.gms.internal.ads.zzbep.zzbv
            com.google.android.gms.internal.ads.zzben r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r11.zza(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzeob.zzb(r9, r7)
            goto L_0x00be
        L_0x004d:
            throw r0
        L_0x004f:
            com.google.android.gms.internal.ads.zzeob r6 = new com.google.android.gms.internal.ads.zzeob
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r4 = r0.elapsedRealtime()
            r0 = r6
            r1 = r9
            r2 = r13
            r3 = r7
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbeg r9 = com.google.android.gms.internal.ads.zzbep.zzbA
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r0.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0091
            java.util.concurrent.ScheduledExecutorService r9 = r8.zzc
            java.util.Objects.requireNonNull(r6)
            com.google.android.gms.internal.ads.zzeww r0 = new com.google.android.gms.internal.ads.zzeww
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzbeg r1 = com.google.android.gms.internal.ads.zzbep.zzbt
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.schedule(r0, r1, r3)
        L_0x0091:
            if (r12 == 0) goto L_0x00bb
            com.google.android.gms.internal.ads.zzbeg r9 = com.google.android.gms.internal.ads.zzbep.zzbH
            com.google.android.gms.internal.ads.zzben r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r12.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzgge r9 = r8.zzb
            com.google.android.gms.internal.ads.zzewt r12 = new com.google.android.gms.internal.ads.zzewt
            r0 = r12
            r1 = r8
            r2 = r13
            r3 = r11
            r4 = r10
            r5 = r6
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zza(r12)
            goto L_0x00be
        L_0x00b7:
            r8.zzh(r13, r11, r10, r6)
            goto L_0x00be
        L_0x00bb:
            r6.zzd()
        L_0x00be:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewx.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbte zzbte, Bundle bundle, List list, zzeob zzeob, zzccn zzccn) {
        try {
            zzh(zzbte, bundle, list, zzeob);
        } catch (RemoteException e) {
            zzccn.zzd(e);
        }
    }
}
