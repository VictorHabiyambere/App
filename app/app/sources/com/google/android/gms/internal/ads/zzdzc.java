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
public final class zzdzc extends zzfvc {
    private final Context zzb;
    @Nullable
    private SensorManager zzc;
    private Sensor zzd;
    private long zze;
    private int zzf;
    private zzdzb zzg;
    private boolean zzh;

    zzdzc(Context context) {
        super("ShakeDetector", "ads");
        this.zzb = context;
    }

    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) zzba.zzc().zza(zzbep.zziY)).booleanValue()) {
            float f = sensorEvent.values[0];
            float f2 = f / 9.80665f;
            float f3 = sensorEvent.values[1] / 9.80665f;
            float f4 = sensorEvent.values[2] / 9.80665f;
            if (((float) Math.sqrt((double) ((f2 * f2) + (f3 * f3) + (f4 * f4)))) >= ((Float) zzba.zzc().zza(zzbep.zziZ)).floatValue()) {
                long currentTimeMillis = zzu.zzB().currentTimeMillis();
                if (this.zze + ((long) ((Integer) zzba.zzc().zza(zzbep.zzja)).intValue()) <= currentTimeMillis) {
                    if (this.zze + ((long) ((Integer) zzba.zzc().zza(zzbep.zzjb)).intValue()) < currentTimeMillis) {
                        this.zzf = 0;
                    }
                    zze.zza("Shake detected.");
                    this.zze = currentTimeMillis;
                    int i = this.zzf + 1;
                    this.zzf = i;
                    zzdzb zzdzb = this.zzg;
                    if (zzdzb != null) {
                        if (i == ((Integer) zzba.zzc().zza(zzbep.zzjc)).intValue()) {
                            zzdya zzdya = (zzdya) zzdzb;
                            zzdya.zzh(new zzdxx(zzdya), zzdxz.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            if (this.zzh) {
                SensorManager sensorManager = this.zzc;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzd);
                    zze.zza("Stopped listening for shake gestures.");
                }
                this.zzh = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zziY     // Catch:{ all -> 0x006d }
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x006d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x006d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x006d }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            return
        L_0x0015:
            android.hardware.SensorManager r0 = r6.zzc     // Catch:{ all -> 0x006d }
            r1 = 1
            if (r0 != 0) goto L_0x0038
            android.content.Context r0 = r6.zzb     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "sensor"
            java.lang.Object r0 = r0.getSystemService(r2)     // Catch:{ all -> 0x006d }
            android.hardware.SensorManager r0 = (android.hardware.SensorManager) r0     // Catch:{ all -> 0x006d }
            r6.zzc = r0     // Catch:{ all -> 0x006d }
            android.hardware.SensorManager r0 = r6.zzc     // Catch:{ all -> 0x006d }
            if (r0 != 0) goto L_0x0031
            java.lang.String r0 = "Shake detection failed to initialize. Failed to obtain accelerometer."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ all -> 0x006d }
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            return
        L_0x0031:
            android.hardware.Sensor r0 = r0.getDefaultSensor(r1)     // Catch:{ all -> 0x006d }
            r6.zzd = r0     // Catch:{ all -> 0x006d }
        L_0x0038:
            boolean r0 = r6.zzh     // Catch:{ all -> 0x006d }
            if (r0 != 0) goto L_0x006b
            android.hardware.SensorManager r0 = r6.zzc     // Catch:{ all -> 0x006d }
            if (r0 == 0) goto L_0x006b
            android.hardware.Sensor r2 = r6.zzd     // Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x006b
            r3 = 2
            r0.registerListener(r6, r2, r3)     // Catch:{ all -> 0x006d }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x006d }
            long r2 = r0.currentTimeMillis()     // Catch:{ all -> 0x006d }
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzja     // Catch:{ all -> 0x006d }
            com.google.android.gms.internal.ads.zzben r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x006d }
            java.lang.Object r0 = r4.zza(r0)     // Catch:{ all -> 0x006d }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x006d }
            int r0 = r0.intValue()     // Catch:{ all -> 0x006d }
            long r4 = (long) r0     // Catch:{ all -> 0x006d }
            long r2 = r2 - r4
            r6.zze = r2     // Catch:{ all -> 0x006d }
            r6.zzh = r1     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "Listening for shake gestures."
            com.google.android.gms.ads.internal.util.zze.zza(r0)     // Catch:{ all -> 0x006d }
        L_0x006b:
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            return
        L_0x006d:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x006d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdzc.zzc():void");
    }

    public final void zzd(zzdzb zzdzb) {
        this.zzg = zzdzb;
    }
}
