package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzay implements Callable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;

    public /* synthetic */ zzay(TaggingLibraryJsInterface taggingLibraryJsInterface) {
        this.zza = taggingLibraryJsInterface;
    }

    public final Object call() {
        return this.zza.getViewSignals();
    }
}
