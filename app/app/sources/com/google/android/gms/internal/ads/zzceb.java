package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzceb extends zzfvc {
    private final SensorManager zzb;
    private final Object zzc = new Object();
    private final Display zzd;
    private final float[] zze = new float[9];
    private final float[] zzf = new float[9];
    private float[] zzg;
    private Handler zzh;
    private zzcea zzi;

    zzceb(Context context) {
        super("OrientationMonitor", "ads");
        this.zzb = (SensorManager) context.getSystemService("sensor");
        this.zzd = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final void zza(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzc) {
                if (this.zzg == null) {
                    this.zzg = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zze, fArr);
            switch (this.zzd.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.zze, 2, 129, this.zzf);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.zze, 129, 130, this.zzf);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.zze, 130, 1, this.zzf);
                    break;
                default:
                    System.arraycopy(this.zze, 0, this.zzf, 0, 9);
                    break;
            }
            float[] fArr2 = this.zzf;
            float f = fArr2[1];
            fArr2[1] = fArr2[3];
            fArr2[3] = f;
            float f2 = fArr2[2];
            fArr2[2] = fArr2[6];
            fArr2[6] = f2;
            float f3 = fArr2[5];
            fArr2[5] = fArr2[7];
            fArr2[7] = f3;
            synchronized (this.zzc) {
                System.arraycopy(this.zzf, 0, this.zzg, 0, 9);
            }
            zzcea zzcea = this.zzi;
            if (zzcea != null) {
                zzcea.zza();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzcea zzcea) {
        this.zzi = zzcea;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zzh == null) {
            Sensor defaultSensor = this.zzb.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzm.zzg("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.zzh = new zzfuv(handlerThread.getLooper());
            if (!this.zzb.registerListener(this, defaultSensor, 0, this.zzh)) {
                zzm.zzg("SensorManager.registerListener failed.");
                zzd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        if (this.zzh != null) {
            this.zzb.unregisterListener(this);
            this.zzh.post(new zzcdz(this));
            this.zzh = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(float[] fArr) {
        synchronized (this.zzc) {
            float[] fArr2 = this.zzg;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, 9);
            return true;
        }
    }
}
