package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzadm {
    private final zzadl zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzadm(zzadl zzadl) {
        this.zza = zzadl;
    }

    public final zzadu zza(Object... objArr) {
        Constructor constructor;
        synchronized (this.zzb) {
            if (this.zzb.get()) {
                constructor = null;
            } else {
                try {
                    constructor = this.zza.zza();
                } catch (ClassNotFoundException e) {
                    this.zzb.set(true);
                    constructor = null;
                } catch (Exception e2) {
                    throw new RuntimeException("Error instantiating extension", e2);
                }
            }
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (zzadu) constructor.newInstance(objArr);
        } catch (Exception e3) {
            throw new IllegalStateException("Unexpected error creating extractor", e3);
        }
    }
}
