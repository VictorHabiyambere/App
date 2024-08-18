package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaai {
    public static final zzaac zza = new zzaac(0, -9223372036854775807L, (zzaab) null);
    public static final zzaac zzb = new zzaac(1, -9223372036854775807L, (zzaab) null);
    public static final zzaac zzc = new zzaac(2, -9223372036854775807L, (zzaab) null);
    public static final zzaac zzd = new zzaac(3, -9223372036854775807L, (zzaab) null);
    /* access modifiers changed from: private */
    public final ExecutorService zze = zzgd.zzE("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    public zzaad zzf;
    /* access modifiers changed from: private */
    public IOException zzg;

    public zzaai(String str) {
    }

    public static zzaac zzb(boolean z, long j) {
        return new zzaac(z ? 1 : 0, j, (zzaab) null);
    }

    public final long zza(zzaae zzaae, zzaaa zzaaa, int i) {
        Looper myLooper = Looper.myLooper();
        zzeq.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzaad(this, myLooper, zzaae, zzaaa, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzaad zzaad = this.zzf;
        zzeq.zzb(zzaad);
        zzaad.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzaad zzaad = this.zzf;
            if (zzaad != null) {
                zzaad.zzb(i);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(zzaaf zzaaf) {
        zzaad zzaad = this.zzf;
        if (zzaad != null) {
            zzaad.zza(true);
        }
        this.zze.execute(new zzaag(zzaaf));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
