package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzul implements zztm {
    private final MediaCodec zza;

    /* synthetic */ zzul(MediaCodec mediaCodec, zzuk zzuk) {
        this.zza = mediaCodec;
        int i = zzgd.zza;
    }

    public final int zza() {
        return this.zza.dequeueInputBuffer(0);
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3) {
                int i = zzgd.zza;
                dequeueOutputBuffer = -3;
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public final MediaFormat zzc() {
        return this.zza.getOutputFormat();
    }

    public final ByteBuffer zzf(int i) {
        int i2 = zzgd.zza;
        return this.zza.getInputBuffer(i);
    }

    public final ByteBuffer zzg(int i) {
        int i2 = zzgd.zza;
        return this.zza.getOutputBuffer(i);
    }

    public final void zzi() {
        this.zza.flush();
    }

    public final void zzj(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zzk(int i, int i2, zzik zzik, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzik.zza(), j, 0);
    }

    public final void zzl() {
        this.zza.release();
    }

    public final void zzm(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    public final void zzn(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzq(int i) {
        this.zza.setVideoScalingMode(i);
    }
}
