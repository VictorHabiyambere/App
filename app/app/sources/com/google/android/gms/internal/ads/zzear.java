package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzear extends zzbxm {
    final /* synthetic */ zzeas zza;

    protected zzear(zzeas zzeas) {
        this.zza = zzeas;
    }

    public final void zze(zzbb zzbb) {
        this.zza.zza.zzd(zzbb.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzeas zzeas = this.zza;
        zzeas.zza.zzc(new zzebi(autoCloseInputStream, zzeas.zze));
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxu zzbxu) {
        this.zza.zza.zzc(new zzebi(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbxu));
    }
}
