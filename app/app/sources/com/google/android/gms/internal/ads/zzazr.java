package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazr {
    protected static final String zza = zzazr.class.getSimpleName();
    private final zzaye zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzazr(zzaye zzaye, String str, String str2, Class... clsArr) {
        this.zzb = zzaye;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        this.zzb.zzk().submit(new zzazq(this));
    }

    static /* bridge */ /* synthetic */ void zzb(zzazr zzazr) {
        try {
            zzaye zzaye = zzazr.zzb;
            Class loadClass = zzaye.zzi().loadClass(zzazr.zzc(zzaye.zzu(), zzazr.zzc));
            if (loadClass != null) {
                zzazr.zze = loadClass.getMethod(zzazr.zzc(zzazr.zzb.zzu(), zzazr.zzd), zzazr.zzf);
                Method method = zzazr.zze;
            }
        } catch (zzaxi | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException e) {
        } catch (Throwable th) {
            zzazr.zzg.countDown();
            throw th;
        }
        zzazr.zzg.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzaxi, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
