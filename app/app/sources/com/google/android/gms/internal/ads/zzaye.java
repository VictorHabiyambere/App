package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaye {
    private static final String zzd = zzaye.class.getSimpleName();
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzaxj zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzaus zzm;
    private Future zzn;
    private zzawy zzo;
    private final Map zzp;
    private boolean zzq;
    private zzaxx zzr;

    private zzaye(Context context) {
        boolean z = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzq = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z;
        this.zza = applicationContext != null ? applicationContext : context;
        this.zzp = new HashMap();
        if (this.zzr == null) {
            this.zzr = new zzaxx(this.zza);
        }
    }

    public static zzaye zzg(Context context, String str, String str2, boolean z) {
        zzaxj zzaxj;
        File cacheDir;
        File file;
        zzaye zzaye = new zzaye(context);
        try {
            zzaye.zze = Executors.newCachedThreadPool(new zzaya());
            zzaye.zzj = z;
            if (z) {
                zzaye.zzk = zzaye.zze.submit(new zzayb(zzaye));
            }
            zzaye.zze.execute(new zzayd(zzaye));
            try {
                GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
                zzaye.zzb = instance.getApkVersion(zzaye.zza) > 0;
                zzaye.zzc = instance.isGooglePlayServicesAvailable(zzaye.zza) == 0;
            } catch (Throwable th) {
            }
            zzaye.zzo(0, true);
            if (zzayh.zzc()) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzdm)).booleanValue()) {
                    throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
                }
            }
            zzaye.zzg = new zzaxj((SecureRandom) null);
            try {
                zzaxj = zzaye.zzg;
                byte[] zzb2 = zzavo.zzb("M2RhhRYJhjrQUa7n9jg23IBcTQvCkUFLA/9ZbQYvHFo=", false);
                if (zzb2.length == 32) {
                    byte[] bArr = new byte[16];
                    ByteBuffer.wrap(zzb2, 4, 16).get(bArr);
                    for (int i = 0; i < 16; i++) {
                        bArr[i] = (byte) (bArr[i] ^ 68);
                    }
                    zzaye.zzh = bArr;
                    try {
                        cacheDir = zzaye.zza.getCacheDir();
                        if (cacheDir == null) {
                            cacheDir = zzaye.zza.getDir("dex", 0);
                            if (cacheDir == null) {
                                throw new zzaxu();
                            }
                        }
                        file = new File(String.format("%s/%s.jar", new Object[]{cacheDir, "1708042440713"}));
                        if (!file.exists()) {
                            byte[] zzb3 = zzaye.zzg.zzb(zzaye.zzh, "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");
                            file.createNewFile();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            if (Build.VERSION.SDK_INT >= 33) {
                                file.setReadOnly();
                            }
                            fileOutputStream.write(zzb3, 0, zzb3.length);
                            fileOutputStream.close();
                        }
                        zzaye.zzx(cacheDir, "1708042440713");
                        zzaye.zzf = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), (String) null, zzaye.zza.getClassLoader());
                        zzy(file);
                        zzaye.zzw(cacheDir, "1708042440713");
                        zzz(String.format("%s/%s.dex", new Object[]{cacheDir, "1708042440713"}));
                        zzaye.zzo = new zzawy(zzaye);
                        zzaye.zzq = true;
                        return zzaye;
                    } catch (SecurityException e) {
                        throw new zzaxu(e);
                    } catch (FileNotFoundException e2) {
                        throw new zzaxu(e2);
                    } catch (IOException e3) {
                        throw new zzaxu(e3);
                    } catch (zzaxi e4) {
                        throw new zzaxu(e4);
                    } catch (NullPointerException e5) {
                        throw new zzaxu(e5);
                    } catch (Throwable th2) {
                        zzy(file);
                        zzaye.zzw(cacheDir, "1708042440713");
                        zzz(String.format("%s/%s.dex", new Object[]{cacheDir, "1708042440713"}));
                        throw th2;
                    }
                } else {
                    throw new zzaxi(zzaxj);
                }
            } catch (IllegalArgumentException e6) {
                throw new zzaxi(zzaxj, e6);
            } catch (zzaxi e7) {
                throw new zzaxu(e7);
            }
        } catch (zzaxu e8) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzi = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0 A[SYNTHETIC, Splitter:B:38:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e7 A[SYNTHETIC, Splitter:B:42:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f8 A[SYNTHETIC, Splitter:B:50:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ff A[SYNTHETIC, Splitter:B:54:0x00ff] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw(java.io.File r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r10 = "test"
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "1708042440713"
            java.lang.Object[] r2 = new java.lang.Object[]{r9, r1}
            java.lang.String r3 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x001b
            goto L_0x0107
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r9 = new java.lang.Object[]{r9, r1}
            java.lang.String r3 = "%s/%s.dex"
            java.lang.String r9 = java.lang.String.format(r3, r9)
            r2.<init>(r9)
            boolean r9 = r2.exists()
            if (r9 == 0) goto L_0x0107
            long r3 = r2.length()
            r5 = 0
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 <= 0) goto L_0x0107
            int r9 = (int) r3
            byte[] r9 = new byte[r9]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00f4, NoSuchAlgorithmException -> 0x00f2, zzaxi -> 0x00f0, all -> 0x00db }
            r4.<init>(r2)     // Catch:{ IOException -> 0x00f4, NoSuchAlgorithmException -> 0x00f2, zzaxi -> 0x00f0, all -> 0x00db }
            int r5 = r4.read(r9)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            if (r5 > 0) goto L_0x0052
            r4.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x004e
        L_0x004d:
            r9 = move-exception
        L_0x004e:
            zzy(r2)
            return
        L_0x0052:
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r5.print(r10)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r5.print(r10)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r5.print(r10)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzauv r10 = com.google.android.gms.internal.ads.zzauw.zza()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzhac r6 = com.google.android.gms.internal.ads.zzhac.zzb     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            int r6 = r5.length     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r7 = 0
            com.google.android.gms.internal.ads.zzhac r5 = com.google.android.gms.internal.ads.zzhac.zzv(r5, r7, r6)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r10.zzc(r5)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            byte[] r1 = r1.getBytes()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            int r5 = r1.length     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzhac r1 = com.google.android.gms.internal.ads.zzhac.zzv(r1, r7, r5)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r10.zzd(r1)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzaxj r1 = r8.zzg     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            byte[] r5 = r8.zzh     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            java.lang.String r9 = r1.zza(r5, r9)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            byte[] r9 = r9.getBytes()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            int r1 = r9.length     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzhac r1 = com.google.android.gms.internal.ads.zzhac.zzv(r9, r7, r1)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r10.zza(r1)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            byte[] r9 = com.google.android.gms.internal.ads.zzavs.zzf(r9)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            int r1 = r9.length     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzhac r9 = com.google.android.gms.internal.ads.zzhac.zzv(r9, r7, r1)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r10.zzb(r9)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r0.createNewFile()     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            r9.<init>(r0)     // Catch:{ IOException -> 0x00d7, NoSuchAlgorithmException -> 0x00d5, zzaxi -> 0x00d3, all -> 0x00ce }
            com.google.android.gms.internal.ads.zzhbo r10 = r10.zzbr()     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzauw r10 = (com.google.android.gms.internal.ads.zzauw) r10     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            byte[] r10 = r10.zzaV()     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            int r0 = r10.length     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            r9.write(r10, r7, r0)     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            r9.close()     // Catch:{ IOException -> 0x00cc, NoSuchAlgorithmException -> 0x00ca, zzaxi -> 0x00c8, all -> 0x00c6 }
            r4.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c0
        L_0x00bf:
            r10 = move-exception
        L_0x00c0:
            r9.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x004e
        L_0x00c4:
            r9 = move-exception
            goto L_0x004e
        L_0x00c6:
            r10 = move-exception
            goto L_0x00d1
        L_0x00c8:
            r10 = move-exception
            goto L_0x00d9
        L_0x00ca:
            r10 = move-exception
            goto L_0x00d9
        L_0x00cc:
            r10 = move-exception
            goto L_0x00d9
        L_0x00ce:
            r9 = move-exception
            r10 = r9
            r9 = r3
        L_0x00d1:
            r3 = r4
            goto L_0x00de
        L_0x00d3:
            r9 = move-exception
            goto L_0x00d8
        L_0x00d5:
            r9 = move-exception
            goto L_0x00d8
        L_0x00d7:
            r9 = move-exception
        L_0x00d8:
            r9 = r3
        L_0x00d9:
            r3 = r4
            goto L_0x00f6
        L_0x00db:
            r9 = move-exception
            r10 = r9
            r9 = r3
        L_0x00de:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00e5
        L_0x00e4:
            r0 = move-exception
        L_0x00e5:
            if (r9 == 0) goto L_0x00ec
            r9.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ec
        L_0x00eb:
            r9 = move-exception
        L_0x00ec:
            zzy(r2)
            throw r10
        L_0x00f0:
            r9 = move-exception
            goto L_0x00f5
        L_0x00f2:
            r9 = move-exception
            goto L_0x00f5
        L_0x00f4:
            r9 = move-exception
        L_0x00f5:
            r9 = r3
        L_0x00f6:
            if (r3 == 0) goto L_0x00fd
            r3.close()     // Catch:{ IOException -> 0x00fc }
            goto L_0x00fd
        L_0x00fc:
            r10 = move-exception
        L_0x00fd:
            if (r9 == 0) goto L_0x004e
            r9.close()     // Catch:{ IOException -> 0x0104 }
            goto L_0x004e
        L_0x0104:
            r9 = move-exception
            goto L_0x004e
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaye.zzw(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fd A[SYNTHETIC, Splitter:B:61:0x00fd] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104 A[SYNTHETIC, Splitter:B:65:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0112 A[SYNTHETIC, Splitter:B:72:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119 A[SYNTHETIC, Splitter:B:76:0x0119] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzx(java.io.File r8, java.lang.String r9) {
        /*
            r7 = this;
            java.io.File r9 = new java.io.File
            java.lang.String r0 = "1708042440713"
            java.lang.Object[] r1 = new java.lang.Object[]{r8, r0}
            java.lang.String r2 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r9.<init>(r1)
            boolean r1 = r9.exists()
            r2 = 0
            if (r1 != 0) goto L_0x0019
            return r2
        L_0x0019:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r8 = new java.lang.Object[]{r8, r0}
            java.lang.String r3 = "%s/%s.dex"
            java.lang.String r8 = java.lang.String.format(r3, r8)
            r1.<init>(r8)
            boolean r8 = r1.exists()
            if (r8 != 0) goto L_0x011e
            r8 = 0
            long r3 = r9.length()     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            r5 = 0
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x003d
            zzy(r9)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            return r2
        L_0x003d:
            int r3 = (int) r3     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            r4.<init>(r9)     // Catch:{ IOException -> 0x010e, NoSuchAlgorithmException -> 0x010c, zzaxi -> 0x010a, all -> 0x00f9 }
            int r5 = r4.read(r3)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            if (r5 > 0) goto L_0x005b
            java.lang.String r0 = zzd     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            zzy(r9)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r4.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r8 = move-exception
        L_0x005a:
            return r2
        L_0x005b:
            com.google.android.gms.internal.ads.zzhay r5 = com.google.android.gms.internal.ads.zzhay.zza()     // Catch:{ NullPointerException -> 0x00e6 }
            com.google.android.gms.internal.ads.zzauw r3 = com.google.android.gms.internal.ads.zzauw.zzd(r3, r5)     // Catch:{ NullPointerException -> 0x00e6 }
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            com.google.android.gms.internal.ads.zzhac r6 = r3.zzh()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r6 = r6.zzB()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            boolean r0 = r0.equals(r5)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            if (r0 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzhac r0 = r3.zzf()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r0 = r0.zzB()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            com.google.android.gms.internal.ads.zzhac r5 = r3.zze()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r5 = r5.zzB()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r5 = com.google.android.gms.internal.ads.zzavs.zzf(r5)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            boolean r0 = java.util.Arrays.equals(r0, r5)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            if (r0 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzhac r0 = r3.zzg()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r0 = r0.zzB()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            java.lang.String r5 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            boolean r0 = java.util.Arrays.equals(r0, r5)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            if (r0 != 0) goto L_0x00a5
            goto L_0x00dd
        L_0x00a5:
            com.google.android.gms.internal.ads.zzaxj r9 = r7.zzg     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r0 = r7.zzh     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            com.google.android.gms.internal.ads.zzhac r3 = r3.zze()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r3 = r3.zzB()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r5.<init>(r3)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            byte[] r9 = r9.zzb(r0, r5)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r1.createNewFile()     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            int r8 = r9.length     // Catch:{ IOException -> 0x00da, NoSuchAlgorithmException -> 0x00d8, zzaxi -> 0x00d6, all -> 0x00d2 }
            r0.write(r9, r2, r8)     // Catch:{ IOException -> 0x00da, NoSuchAlgorithmException -> 0x00d8, zzaxi -> 0x00d6, all -> 0x00d2 }
            r4.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00cb
        L_0x00ca:
            r8 = move-exception
        L_0x00cb:
            r0.close()     // Catch:{ IOException -> 0x00cf }
            goto L_0x00d0
        L_0x00cf:
            r8 = move-exception
        L_0x00d0:
            r8 = 1
            return r8
        L_0x00d2:
            r8 = move-exception
            r9 = r8
            r8 = r4
            goto L_0x00fb
        L_0x00d6:
            r8 = move-exception
            goto L_0x00db
        L_0x00d8:
            r8 = move-exception
            goto L_0x00db
        L_0x00da:
            r8 = move-exception
        L_0x00db:
            r8 = r4
            goto L_0x0110
        L_0x00dd:
            zzy(r9)     // Catch:{ IOException -> 0x00f5, NoSuchAlgorithmException -> 0x00f3, zzaxi -> 0x00f1, all -> 0x00ed }
            r4.close()     // Catch:{ IOException -> 0x00e4 }
            goto L_0x00e5
        L_0x00e4:
            r8 = move-exception
        L_0x00e5:
            return r2
        L_0x00e6:
            r8 = move-exception
            r4.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ec
        L_0x00eb:
            r8 = move-exception
        L_0x00ec:
            return r2
        L_0x00ed:
            r9 = move-exception
            r0 = r8
            r8 = r4
            goto L_0x00fb
        L_0x00f1:
            r9 = move-exception
            goto L_0x00f6
        L_0x00f3:
            r9 = move-exception
            goto L_0x00f6
        L_0x00f5:
            r9 = move-exception
        L_0x00f6:
            r0 = r8
            r8 = r4
            goto L_0x0110
        L_0x00f9:
            r9 = move-exception
            r0 = r8
        L_0x00fb:
            if (r8 == 0) goto L_0x0102
            r8.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0102
        L_0x0101:
            r8 = move-exception
        L_0x0102:
            if (r0 == 0) goto L_0x0109
            r0.close()     // Catch:{ IOException -> 0x0108 }
            goto L_0x0109
        L_0x0108:
            r8 = move-exception
        L_0x0109:
            throw r9
        L_0x010a:
            r9 = move-exception
            goto L_0x010f
        L_0x010c:
            r9 = move-exception
            goto L_0x010f
        L_0x010e:
            r9 = move-exception
        L_0x010f:
            r0 = r8
        L_0x0110:
            if (r8 == 0) goto L_0x0117
            r8.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0117
        L_0x0116:
            r8 = move-exception
        L_0x0117:
            if (r0 == 0) goto L_0x011e
            r0.close()     // Catch:{ IOException -> 0x011d }
            goto L_0x011e
        L_0x011d:
            r8 = move-exception
        L_0x011e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaye.zzx(java.io.File, java.lang.String):boolean");
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
        } else {
            file.delete();
        }
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzawy.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzaus zzc() {
        return this.zzm;
    }

    public final zzawy zzd() {
        return this.zzo;
    }

    public final zzaxj zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final zzaxx zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        Future future;
        if (!this.zzj) {
            return null;
        }
        if (this.zzi == null && (future = this.zzk) != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException e) {
            } catch (TimeoutException e2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzazr zzazr = (zzazr) this.zzp.get(new Pair(str, str2));
        if (zzazr == null) {
            return null;
        }
        return zzazr.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzayc(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzp.containsKey(pair)) {
            return false;
        }
        this.zzp.put(pair, new zzazr(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
