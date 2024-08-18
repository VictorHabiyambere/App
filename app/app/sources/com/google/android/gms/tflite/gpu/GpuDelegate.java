package com.google.android.gms.tflite.gpu;

import org.tensorflow.lite.Delegate;
import org.tensorflow.lite.gpu.GpuDelegateFactory;

/* compiled from: com.google.android.gms:play-services-tflite-gpu@@16.1.0 */
public class GpuDelegate implements Delegate {
    private long zza;

    static {
        System.loadLibrary("tensorflowlite_jni_gms_client");
    }

    public GpuDelegate() {
        this(new GpuDelegateFactory.Options());
    }

    private static native long createDelegate(boolean z, boolean z2, int i, String str, String str2);

    private static native void deleteDelegate(long j);

    public final void close() {
        long j = this.zza;
        if (j != 0) {
            deleteDelegate(j);
            this.zza = 0;
        }
    }

    public final long getNativeHandle() {
        return this.zza;
    }

    public GpuDelegate(GpuDelegateFactory.Options options) {
        this.zza = createDelegate(options.isPrecisionLossAllowed(), options.areQuantizedModelsAllowed(), options.getInferencePreference(), options.getSerializationDir(), options.getModelToken());
    }
}
