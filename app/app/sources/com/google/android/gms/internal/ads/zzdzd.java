package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzdzd extends Exception {
    private final int zza;

    public zzdzd(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdzd(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdzd(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
