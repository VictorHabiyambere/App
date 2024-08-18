package com.google.android.gms.tflite.gpu.support;

import android.content.Context;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.internal.tflite_gpu.zzd;
import com.google.android.gms.internal.tflite_gpu.zze;
import com.google.android.gms.internal.tflite_gpu.zzg;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-tflite-gpu@@16.1.0 */
public class TfLiteGpu {
    private TfLiteGpu() {
    }

    public static TfLiteGpuClient getClient(Context context) {
        return new TfLiteGpuClient();
    }

    public static Task<Boolean> isGpuDelegateAvailable(Context context) {
        return zzd.zza(ModuleInstall.getClient(context), zze.zzb, zzg.zza());
    }
}
