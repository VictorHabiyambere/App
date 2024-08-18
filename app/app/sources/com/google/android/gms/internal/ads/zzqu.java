package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzqu extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzan zzc;

    public zzqu(int i, zzan zzan, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzan;
    }
}
