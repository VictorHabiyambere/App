package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzeit implements zzgfa {
    public final /* synthetic */ zzeiw zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzfgt zzc;

    public /* synthetic */ zzeit(zzeiw zzeiw, View view, zzfgt zzfgt) {
        this.zza = zzeiw;
        this.zzb = view;
        this.zzc = zzfgt;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
