package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.firebase.firestore.util.ExponentialBackoff;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbgx {
    public static final zzbfv zza = zzbfv.zzb("gads:ad_loader:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbfv zzb = zzbfv.zzb("gads:rendering:timeout_ms", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
    public static final zzbfv zzc = zzbfv.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
}
