package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzb;
import com.google.android.gms.internal.auth.zzc;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public abstract class zza extends zzb implements zzb {
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzc.zzb(parcel);
                zzb((Account) zzc.zza(parcel, Account.CREATOR));
                return true;
            case 2:
                boolean zzf = zzc.zzf(parcel);
                zzc.zzb(parcel);
                zzc(zzf);
                return true;
            default:
                return false;
        }
    }
}
