package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzbne extends zzbae implements zzbnf {
    public zzbne() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzbaf.zzc(parcel);
        zzb((ParcelFileDescriptor) zzbaf.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
