package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzehh {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    zzehh(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        try {
            this.zza = MeasurementManagerFutures.from(this.zzb);
            MeasurementManagerFutures measurementManagerFutures = this.zza;
            if (measurementManagerFutures == null) {
                return zzgft.zzg(new IllegalStateException("MeasurementManagerFutures is null"));
            }
            return measurementManagerFutures.getMeasurementApiStatusAsync();
        } catch (Exception e) {
            return zzgft.zzg(e);
        }
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        try {
            return ((MeasurementManagerFutures) Objects.requireNonNull(this.zza)).registerSourceAsync(uri, inputEvent);
        } catch (Exception e) {
            return zzgft.zzg(e);
        }
    }
}
