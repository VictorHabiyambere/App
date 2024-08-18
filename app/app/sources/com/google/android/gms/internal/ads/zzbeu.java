package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbeu {
    final BlockingQueue zza = new ArrayBlockingQueue(100);
    final LinkedHashMap zzb = new LinkedHashMap();
    final Map zzc = new HashMap();
    String zzd;
    Context zze;
    String zzf;
    private final HashSet zzg = new HashSet(Arrays.asList(new String[]{"noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"}));
    private AtomicBoolean zzh;
    private File zzi;

    public static /* synthetic */ void zzc(zzbeu zzbeu) {
        while (true) {
            try {
                zzbfe zzbfe = (zzbfe) zzbeu.zza.take();
                zzbfd zza2 = zzbfe.zza();
                if (!TextUtils.isEmpty(zza2.zzb())) {
                    zzbeu.zzg(zzbeu.zzb(zzbeu.zzb, zzbfe.zzb()), zza2);
                }
            } catch (InterruptedException e) {
                zzm.zzk("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7 A[SYNTHETIC, Splitter:B:38:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b1 A[SYNTHETIC, Splitter:B:45:0x00b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzg(java.util.Map r5, com.google.android.gms.internal.ads.zzbfd r6) {
        /*
            r4 = this;
            java.lang.String r0 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            java.lang.String r1 = r4.zzd
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0014:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r5.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r1.appendQueryParameter(r3, r2)
            goto L_0x0014
        L_0x0030:
            android.net.Uri r5 = r1.build()
            java.lang.String r5 = r5.toString()
            if (r6 == 0) goto L_0x006f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r5 = r6.zzb()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0055
            java.lang.String r5 = "&it="
            r1.append(r5)
            java.lang.String r5 = r6.zzb()
            r1.append(r5)
        L_0x0055:
            java.lang.String r5 = r6.zza()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x006b
            java.lang.String r5 = "&blat="
            r1.append(r5)
            java.lang.String r5 = r6.zza()
            r1.append(r5)
        L_0x006b:
            java.lang.String r5 = r1.toString()
        L_0x006f:
            java.util.concurrent.atomic.AtomicBoolean r6 = r4.zzh
            boolean r6 = r6.get()
            if (r6 == 0) goto L_0x00c1
            java.io.File r6 = r4.zzi
            if (r6 == 0) goto L_0x00ba
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x009f, all -> 0x009d }
            r3 = 1
            r2.<init>(r6, r3)     // Catch:{ IOException -> 0x009f, all -> 0x009d }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x009a, all -> 0x0097 }
            r2.write(r5)     // Catch:{ IOException -> 0x009a, all -> 0x0097 }
            r5 = 10
            r2.write(r5)     // Catch:{ IOException -> 0x009a, all -> 0x0097 }
            r2.close()     // Catch:{ IOException -> 0x0092 }
            return
        L_0x0092:
            r5 = move-exception
        L_0x0093:
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r0, r5)
            return
        L_0x0097:
            r5 = move-exception
            r1 = r2
            goto L_0x00af
        L_0x009a:
            r5 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x009d:
            r5 = move-exception
            goto L_0x00af
        L_0x009f:
            r5 = move-exception
        L_0x00a0:
            java.lang.String r6 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r6, r5)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00ad
            r1.close()     // Catch:{ IOException -> 0x00ab }
            return
        L_0x00ab:
            r5 = move-exception
            goto L_0x0093
        L_0x00ad:
            return
        L_0x00ae:
            r5 = move-exception
        L_0x00af:
            if (r1 == 0) goto L_0x00b9
            r1.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r6 = move-exception
            com.google.android.gms.ads.internal.util.client.zzm.zzk(r0, r6)
        L_0x00b9:
            throw r5
        L_0x00ba:
            java.lang.String r5 = "CsiReporter: File doesn't exist. Cannot write CSI data to file."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r5)
            return
        L_0x00c1:
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r6 = r4.zze
            java.lang.String r0 = r4.zzf
            com.google.android.gms.ads.internal.util.zzt.zzL(r6, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbeu.zzg(java.util.Map, com.google.android.gms.internal.ads.zzbfd):void");
    }

    public final zzbfa zza(String str) {
        zzbfa zzbfa = (zzbfa) this.zzc.get(str);
        return zzbfa != null ? zzbfa : zzbfa.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzb(Map map, Map map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zza(str).zza(str2, (String) entry.getValue()));
        }
        return linkedHashMap;
    }

    public final void zzd(Context context, String str, String str2, Map map) {
        File externalStorageDirectory;
        this.zze = context;
        this.zzf = str;
        this.zzd = str2;
        this.zzh = new AtomicBoolean(false);
        this.zzh.set(((Boolean) zzbgf.zzc.zze()).booleanValue());
        if (this.zzh.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzi = new File(zzftv.zza(zzftu.zza(), externalStorageDirectory, "sdk_csi_data.txt"));
        }
        for (Map.Entry entry : map.entrySet()) {
            this.zzb.put((String) entry.getKey(), (String) entry.getValue());
        }
        zzcci.zza.execute(new zzbet(this));
        this.zzc.put("action", zzbfa.zzb);
        this.zzc.put("ad_format", zzbfa.zzb);
        this.zzc.put("e", zzbfa.zzc);
    }

    public final void zze(String str) {
        if (!this.zzg.contains(str)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("sdkVersion", this.zzf);
            linkedHashMap.put("ue", str);
            zzg(zzb(this.zzb, linkedHashMap), (zzbfd) null);
        }
    }

    public final boolean zzf(zzbfe zzbfe) {
        return this.zza.offer(zzbfe);
    }
}
