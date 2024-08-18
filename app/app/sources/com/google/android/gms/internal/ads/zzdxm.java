package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdxm extends zzfvc {
    @Nullable
    private final SensorManager zzb;
    @Nullable
    private final Sensor zzc;
    private float zzd = 0.0f;
    private Float zze = Float.valueOf(0.0f);
    private long zzf = zzu.zzB().currentTimeMillis();
    private int zzg = 0;
    private boolean zzh = false;
    private boolean zzi = false;
    @Nullable
    private zzdxl zzj = null;
    private boolean zzk = false;

    zzdxm(Context context) {
        super("FlickDetector", "ads");
        this.zzb = (SensorManager) context.getSystemService("sensor");
        SensorManager sensorManager = this.zzb;
        if (sensorManager != null) {
            this.zzc = sensorManager.getDefaultSensor(4);
        } else {
            this.zzc = null;
        }
    }

    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) zzba.zzc().zza(zzbep.zzjd)).booleanValue()) {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (this.zzf + ((long) ((Integer) zzba.zzc().zza(zzbep.zzjf)).intValue()) < currentTimeMillis) {
                this.zzg = 0;
                this.zzf = currentTimeMillis;
                this.zzh = false;
                this.zzi = false;
                this.zzd = this.zze.floatValue();
            }
            this.zze = Float.valueOf(this.zze.floatValue() + (sensorEvent.values[1] * 4.0f));
            if (this.zze.floatValue() > this.zzd + ((Float) zzba.zzc().zza(zzbep.zzje)).floatValue()) {
                this.zzd = this.zze.floatValue();
                this.zzi = true;
            } else {
                if (this.zze.floatValue() < this.zzd - ((Float) zzba.zzc().zza(zzbep.zzje)).floatValue()) {
                    this.zzd = this.zze.floatValue();
                    this.zzh = true;
                }
            }
            if (this.zze.isInfinite()) {
                this.zze = Float.valueOf(0.0f);
                this.zzd = 0.0f;
            }
            if (this.zzh && this.zzi) {
                zze.zza("Flick detected.");
                this.zzf = currentTimeMillis;
                int i = this.zzg + 1;
                this.zzg = i;
                this.zzh = false;
                this.zzi = false;
                zzdxl zzdxl = this.zzj;
                if (zzdxl != null) {
                    if (i == ((Integer) zzba.zzc().zza(zzbep.zzjg)).intValue()) {
                        zzdya zzdya = (zzdya) zzdxl;
                        zzdya.zzh(new zzdxy(zzdya), zzdxz.GESTURE);
                    }
                }
            }
        }
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (!(!this.zzk || (sensorManager = this.zzb) == null || (sensor = this.zzc) == null)) {
                sensorManager.unregisterListener(this, sensor);
                this.zzk = false;
                zze.zza("Stopped listening for flick gestures.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r3.zzb == null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r3.zzc != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Flick detection failed to initialize. Failed to obtain gyroscope.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzjd     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x003e }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x003e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            return
        L_0x0015:
            boolean r0 = r3.zzk     // Catch:{ all -> 0x003e }
            if (r0 != 0) goto L_0x002d
            android.hardware.SensorManager r0 = r3.zzb     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x002d
            android.hardware.Sensor r1 = r3.zzc     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x002d
            r2 = 2
            r0.registerListener(r3, r1, r2)     // Catch:{ all -> 0x003e }
            r0 = 1
            r3.zzk = r0     // Catch:{ all -> 0x003e }
            java.lang.String r0 = "Listening for flick gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x003e }
        L_0x002d:
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            android.hardware.SensorManager r0 = r3.zzb
            if (r0 == 0) goto L_0x0038
            android.hardware.Sensor r0 = r3.zzc
            if (r0 != 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            return
        L_0x0038:
            java.lang.String r0 = "Flick detection failed to initialize. Failed to obtain gyroscope."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        L_0x003e:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxm.zzc():void");
    }

    public final void zzd(zzdxl zzdxl) {
        this.zzj = zzdxl;
    }
}
