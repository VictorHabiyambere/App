package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzepc implements AppEventListener, zzdcg, zzdaz, zzczo, zzdaf, zza, zzczl, zzdbw, zzdab, zzdhi {
    final zzdvc zza;
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) zzba.zzc().zza(zzbep.zziR)).intValue());
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);

    public zzepc(zzdvc zzdvc) {
        this.zza = zzdvc;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            for (Pair zzeon : this.zzb) {
                zzfdy.zza(this.zzd, new zzeon(zzeon));
            }
            this.zzb.clear();
            this.zzh.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
            zzfdy.zza(this.zzc, new zzepa());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzh     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0039
            java.util.concurrent.BlockingQueue r0 = r3.zzb     // Catch:{ all -> 0x0045 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0045 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0045 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0045 }
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzdvc r0 = r3.zza     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzdvb r0 = r0.zza()     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "dae_action"
            r0.zzb(r1, r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "dae_name"
            r0.zzb(r1, r4)     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = "dae_data"
            r0.zzb(r4, r5)     // Catch:{ all -> 0x0045 }
            r0.zzf()     // Catch:{ all -> 0x0045 }
        L_0x0037:
            monitor-exit(r3)
            return
        L_0x0039:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzeou r1 = new com.google.android.gms.internal.ads.zzeou     // Catch:{ all -> 0x0045 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzfdy.zza(r0, r1)     // Catch:{ all -> 0x0045 }
            monitor-exit(r3)
            return
        L_0x0045:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepc.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zza() {
        zzfdy.zza(this.zzc, new zzeok());
        zzfdy.zza(this.zzg, new zzeol());
    }

    public final void zzb() {
        zzfdy.zza(this.zzc, new zzeov());
    }

    public final void zzc() {
        zzfdy.zza(this.zzc, new zzeox());
        zzfdy.zza(this.zzg, new zzeoy());
        zzfdy.zza(this.zzg, new zzeoz());
    }

    public final void zzdB(zze zze2) {
        zzfdy.zza(this.zzc, new zzeoo(zze2));
        zzfdy.zza(this.zzc, new zzeop(zze2));
        zzfdy.zza(this.zzf, new zzeoq(zze2));
        this.zzh.set(false);
        this.zzb.clear();
    }

    public final void zzdG() {
        if (((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
            zzfdy.zza(this.zzc, new zzepa());
        }
        zzfdy.zza(this.zzg, new zzeom());
    }

    public final void zzdf() {
        zzfdy.zza(this.zzc, new zzeow());
    }

    public final void zzdn(zzbxu zzbxu) {
    }

    public final void zzdo(zzfhf zzfhf) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    public final void zzds(zzbyh zzbyh, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final synchronized zzbh zzg() {
        return (zzbh) this.zzc.get();
    }

    public final void zzh(zzs zzs) {
        zzfdy.zza(this.zze, new zzepb(zzs));
    }

    public final synchronized zzcb zzi() {
        return (zzcb) this.zzd.get();
    }

    public final void zzj(zzbh zzbh) {
        this.zzc.set(zzbh);
    }

    public final void zzk(zzbk zzbk) {
        this.zzf.set(zzbk);
    }

    public final void zzl(zzdg zzdg) {
        this.zze.set(zzdg);
    }

    public final void zzm(zzcb zzcb) {
        this.zzd.set(zzcb);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(zzci zzci) {
        this.zzg.set(zzci);
    }

    public final void zzq(zze zze2) {
        zzfdy.zza(this.zzg, new zzeot(zze2));
    }

    public final void zzr() {
        zzfdy.zza(this.zzc, new zzeoj());
    }

    public final synchronized void zzs() {
        zzfdy.zza(this.zzc, new zzeor());
        zzfdy.zza(this.zzf, new zzeos());
        this.zzj.set(true);
        zzo();
    }
}
