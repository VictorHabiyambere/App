package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeiq implements zzehr {
    private final Context zza;
    private final zzctg zzb;
    private final Executor zzc;

    public zzeiq(Context context, zzctg zzctg, Executor executor) {
        this.zza = context;
        this.zzb = zzctg;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzfhf r7, com.google.android.gms.internal.ads.zzfgt r8, com.google.android.gms.internal.ads.zzeho r9) throws com.google.android.gms.internal.ads.zzfhv, com.google.android.gms.internal.ads.zzelj {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzhU
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0078
            boolean r0 = r8.zzah
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfim r0 = (com.google.android.gms.internal.ads.zzfim) r0
            com.google.android.gms.internal.ads.zzbro r0 = r0.zzc()
            if (r0 == 0) goto L_0x0068
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0061 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0061 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0061 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0061 }
            if (r2 == 0) goto L_0x0054
            if (r0 == 0) goto L_0x0053
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgft.zzh(r1)
            com.google.android.gms.internal.ads.zzeio r3 = new com.google.android.gms.internal.ads.zzeio
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzgge r2 = com.google.android.gms.internal.ads.zzcci.zze
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgft.zzn(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x0080
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzfhv r8 = new com.google.android.gms.internal.ads.zzfhv
            r8.<init>(r7)
            throw r8
        L_0x0053:
            goto L_0x0080
        L_0x0054:
            com.google.android.gms.internal.ads.zzfhv r7 = new com.google.android.gms.internal.ads.zzfhv
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0061:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzfhv r8 = new com.google.android.gms.internal.ads.zzfhv
            r8.<init>(r7)
            throw r8
        L_0x0068:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r7)
            com.google.android.gms.internal.ads.zzfhv r8 = new com.google.android.gms.internal.ads.zzfhv
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0078:
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfim r0 = (com.google.android.gms.internal.ads.zzfim) r0
            android.view.View r2 = r0.zza()
        L_0x0080:
            com.google.android.gms.internal.ads.zzctg r0 = r6.zzb
            java.lang.String r3 = r9.zza
            com.google.android.gms.internal.ads.zzcvf r4 = new com.google.android.gms.internal.ads.zzcvf
            r4.<init>(r7, r8, r3)
            java.lang.Object r7 = r9.zzb
            com.google.android.gms.internal.ads.zzcsm r3 = new com.google.android.gms.internal.ads.zzcsm
            com.google.android.gms.internal.ads.zzfim r7 = (com.google.android.gms.internal.ads.zzfim) r7
            java.util.Objects.requireNonNull(r7)
            com.google.android.gms.internal.ads.zzeip r5 = new com.google.android.gms.internal.ads.zzeip
            r5.<init>(r7)
            java.util.List r7 = r8.zzv
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzfgu r7 = (com.google.android.gms.internal.ads.zzfgu) r7
            r3.<init>(r2, r1, r5, r7)
            com.google.android.gms.internal.ads.zzcsg r7 = r0.zza(r4, r3)
            com.google.android.gms.internal.ads.zzdhc r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzdak r8 = r7.zzd()
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzcpt r1 = new com.google.android.gms.internal.ads.zzcpt
            com.google.android.gms.internal.ads.zzfim r0 = (com.google.android.gms.internal.ads.zzfim) r0
            r1.<init>(r0)
            java.util.concurrent.Executor r0 = r6.zzc
            r8.zzo(r1, r0)
            com.google.android.gms.internal.ads.zzdav r8 = r9.zzc
            com.google.android.gms.internal.ads.zzejh r8 = (com.google.android.gms.internal.ads.zzejh) r8
            com.google.android.gms.internal.ads.zzemz r9 = r7.zzk()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcsf r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiq.zza(com.google.android.gms.internal.ads.zzfhf, com.google.android.gms.internal.ads.zzfgt, com.google.android.gms.internal.ads.zzeho):java.lang.Object");
    }

    public final void zzb(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws zzfhv {
        zzq zzq;
        zzq zzq2 = zzfhf.zza.zza.zze;
        if (zzq2.zzn) {
            zzq = new zzq(this.zza, zzb.zzd(zzq2.zze, zzq2.zzb));
        } else {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() || !zzfgt.zzah) {
                zzq = zzfhu.zza(this.zza, zzfgt.zzv);
            } else {
                zzq = new zzq(this.zza, zzb.zze(zzq2.zze, zzq2.zzb));
            }
        }
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhU)).booleanValue() || !zzfgt.zzah) {
            Object obj = zzeho.zzb;
            Context context = this.zza;
            zzfho zzfho = zzfhf.zza.zza;
            ((zzfim) obj).zzm(context, zzq, zzfho.zzd, zzfgt.zzw.toString(), zzbw.zzm(zzfgt.zzt), (zzbrl) zzeho.zzc);
            return;
        }
        Object obj2 = zzeho.zzb;
        Context context2 = this.zza;
        zzfho zzfho2 = zzfhf.zza.zza;
        ((zzfim) obj2).zzn(context2, zzq, zzfho2.zzd, zzfgt.zzw.toString(), zzbw.zzm(zzfgt.zzt), (zzbrl) zzeho.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzfgt zzfgt, Object obj) throws Exception {
        return zzgft.zzh(zzcub.zza(this.zza, view, zzfgt));
    }
}
