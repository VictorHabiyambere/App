package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbtd extends zzbae implements zzbte {
    public zzbtd() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbte zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return queryLocalInterface instanceof zzbte ? (zzbte) queryLocalInterface : new zzbtc(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbth zzbth;
        zzbss zzbss;
        zzbsv zzbsv;
        zzbtb zzbtb;
        zzbsy zzbsy;
        zzbtb zzbtb2;
        zzbss zzbss2;
        zzbsy zzbsy2;
        zzbsp zzbsp;
        Parcel parcel3 = parcel;
        Parcel parcel4 = parcel2;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                Bundle bundle = (Bundle) zzbaf.zza(parcel, Bundle.CREATOR);
                Bundle bundle2 = (Bundle) zzbaf.zza(parcel, Bundle.CREATOR);
                zzq zzq = (zzq) zzbaf.zza(parcel, zzq.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzbth = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    zzbth = queryLocalInterface instanceof zzbth ? (zzbth) queryLocalInterface : new zzbtf(readStrongBinder);
                }
                zzbaf.zzc(parcel);
                zzh(asInterface, readString, bundle, bundle2, zzq, zzbth);
                parcel2.writeNoException();
                return true;
            case 2:
                zzbtt zzf = zzf();
                parcel2.writeNoException();
                zzbaf.zze(parcel2, zzf);
                return true;
            case 3:
                zzbtt zzg = zzg();
                parcel2.writeNoException();
                zzbaf.zze(parcel2, zzg);
                return true;
            case 5:
                zzdq zze = zze();
                parcel2.writeNoException();
                zzbaf.zzf(parcel2, zze);
                return true;
            case 10:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel.createStringArray();
                Bundle[] bundleArr = (Bundle[]) parcel.createTypedArray(Bundle.CREATOR);
                zzbaf.zzc(parcel);
                parcel2.writeNoException();
                return true;
            case 13:
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                zzl zzl = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 == null) {
                    zzbss = null;
                } else {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    zzbss = queryLocalInterface2 instanceof zzbss ? (zzbss) queryLocalInterface2 : new zzbsq(readStrongBinder2);
                }
                zzbrl zzb = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzj(readString2, readString3, zzl, asInterface2, zzbss, zzb, (zzq) zzbaf.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                zzl zzl2 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 == null) {
                    zzbsv = null;
                } else {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    zzbsv = queryLocalInterface3 instanceof zzbsv ? (zzbsv) queryLocalInterface3 : new zzbst(readStrongBinder3);
                }
                zzbrl zzb2 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzl(readString4, readString5, zzl2, asInterface3, zzbsv, zzb2);
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                boolean zzs = zzs(asInterface4);
                parcel2.writeNoException();
                parcel2.writeInt(zzs ? 1 : 0);
                return true;
            case 16:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                zzl zzl3 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 == null) {
                    zzbtb = null;
                } else {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    zzbtb = queryLocalInterface4 instanceof zzbtb ? (zzbtb) queryLocalInterface4 : new zzbsz(readStrongBinder4);
                }
                zzbrl zzb3 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzp(readString6, readString7, zzl3, asInterface5, zzbtb, zzb3);
                parcel2.writeNoException();
                return true;
            case 17:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                boolean zzt = zzt(asInterface6);
                parcel2.writeNoException();
                parcel2.writeInt(zzt ? 1 : 0);
                return true;
            case 18:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                zzl zzl4 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 == null) {
                    zzbsy = null;
                } else {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    zzbsy = queryLocalInterface5 instanceof zzbsy ? (zzbsy) queryLocalInterface5 : new zzbsw(readStrongBinder5);
                }
                zzbrl zzb4 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzm(readString8, readString9, zzl4, asInterface7, zzbsy, zzb4);
                parcel2.writeNoException();
                return true;
            case 19:
                String readString10 = parcel.readString();
                zzbaf.zzc(parcel);
                zzq(readString10);
                parcel2.writeNoException();
                return true;
            case 20:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                zzl zzl5 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 == null) {
                    zzbtb2 = null;
                } else {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    zzbtb2 = queryLocalInterface6 instanceof zzbtb ? (zzbtb) queryLocalInterface6 : new zzbsz(readStrongBinder6);
                }
                zzbrl zzb5 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzo(readString11, readString12, zzl5, asInterface8, zzbtb2, zzb5);
                parcel2.writeNoException();
                return true;
            case 21:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                zzl zzl6 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 == null) {
                    zzbss2 = null;
                } else {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    zzbss2 = queryLocalInterface7 instanceof zzbss ? (zzbss) queryLocalInterface7 : new zzbsq(readStrongBinder7);
                }
                zzbrl zzb6 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzk(readString13, readString14, zzl6, asInterface9, zzbss2, zzb6, (zzq) zzbaf.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 22:
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                zzl zzl7 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 == null) {
                    zzbsy2 = null;
                } else {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    zzbsy2 = queryLocalInterface8 instanceof zzbsy ? (zzbsy) queryLocalInterface8 : new zzbsw(readStrongBinder8);
                }
                zzbrl zzb7 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzn(readString15, readString16, zzl7, asInterface10, zzbsy2, zzb7, (zzbhk) zzbaf.zza(parcel, zzbhk.CREATOR));
                parcel2.writeNoException();
                return true;
            case 23:
                String readString17 = parcel.readString();
                String readString18 = parcel.readString();
                zzl zzl8 = (zzl) zzbaf.zza(parcel, zzl.CREATOR);
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 == null) {
                    zzbsp = null;
                } else {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                    zzbsp = queryLocalInterface9 instanceof zzbsp ? (zzbsp) queryLocalInterface9 : new zzbsn(readStrongBinder9);
                }
                zzbrl zzb8 = zzbrk.zzb(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                zzi(readString17, readString18, zzl8, asInterface11, zzbsp, zzb8);
                parcel2.writeNoException();
                return true;
            case 24:
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbaf.zzc(parcel);
                boolean zzr = zzr(asInterface12);
                parcel2.writeNoException();
                parcel2.writeInt(zzr ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
