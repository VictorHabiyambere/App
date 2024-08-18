package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzavr implements Runnable {
    private zzavr() {
        throw null;
    }

    /* synthetic */ zzavr(zzavq zzavq) {
    }

    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzavs.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzavs.zzb;
        } catch (NoSuchAlgorithmException e) {
            countDownLatch = zzavs.zzb;
        } catch (Throwable th) {
            zzavs.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
