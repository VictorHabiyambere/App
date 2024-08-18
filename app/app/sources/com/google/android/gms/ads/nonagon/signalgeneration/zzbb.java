package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzbb implements Runnable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ QueryInfoGenerationCallback zzc;

    public /* synthetic */ zzbb(TaggingLibraryJsInterface taggingLibraryJsInterface, Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zza = taggingLibraryJsInterface;
        this.zzb = bundle;
        this.zzc = queryInfoGenerationCallback;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc);
    }
}
