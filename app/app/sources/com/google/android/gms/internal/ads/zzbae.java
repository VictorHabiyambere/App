package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-base@@23.2.0 */
public class zzbae extends Binder implements IInterface {
    protected zzbae(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        if (code <= 16777215) {
            data.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(code, data, reply, flags)) {
            return true;
        }
        return zzdF(code, data, reply, flags);
    }

    /* access modifiers changed from: protected */
    public boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
    }
}
