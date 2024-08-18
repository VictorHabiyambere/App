package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbae;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public abstract class zzbt extends zzbae implements zzbu {
    public zzbt() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbu zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzbu ? (zzbu) queryLocalInterface : new zzbs(iBinder);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: com.google.android.gms.ads.internal.client.zzcf} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v2, types: [com.google.android.gms.ads.internal.client.zzbh] */
    /* JADX WARNING: type inference failed for: r6v7, types: [com.google.android.gms.ads.internal.client.zzcb] */
    /* JADX WARNING: type inference failed for: r6v13, types: [com.google.android.gms.ads.internal.client.zzbe] */
    /* JADX WARNING: type inference failed for: r6v23, types: [com.google.android.gms.ads.internal.client.zzby] */
    /* JADX WARNING: type inference failed for: r6v28, types: [com.google.android.gms.ads.internal.client.zzdg] */
    /* JADX WARNING: type inference failed for: r6v33, types: [com.google.android.gms.ads.internal.client.zzbk] */
    /* JADX WARNING: type inference failed for: r6v38, types: [com.google.android.gms.ads.internal.client.zzci] */
    /* JADX WARNING: type inference failed for: r6v43 */
    /* JADX WARNING: type inference failed for: r6v44 */
    /* JADX WARNING: type inference failed for: r6v45 */
    /* JADX WARNING: type inference failed for: r6v46 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v48 */
    /* JADX WARNING: type inference failed for: r6v49 */
    /* JADX WARNING: type inference failed for: r6v50 */
    /* JADX WARNING: type inference failed for: r6v51 */
    /* JADX WARNING: type inference failed for: r6v52 */
    /* JADX WARNING: type inference failed for: r6v53 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r6v55 */
    /* JADX WARNING: type inference failed for: r6v56 */
    /* JADX WARNING: type inference failed for: r6v57 */
    /* JADX WARNING: type inference failed for: r6v58 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdF(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 0
            switch(r3) {
                case 1: goto L_0x0307;
                case 2: goto L_0x0300;
                case 3: goto L_0x02f3;
                case 4: goto L_0x02dd;
                case 5: goto L_0x02d6;
                case 6: goto L_0x02cf;
                case 7: goto L_0x02ab;
                case 8: goto L_0x0287;
                case 9: goto L_0x027f;
                case 10: goto L_0x027a;
                case 11: goto L_0x0272;
                case 12: goto L_0x0266;
                case 13: goto L_0x0253;
                case 14: goto L_0x0240;
                case 15: goto L_0x0229;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x021d;
                case 19: goto L_0x020a;
                case 20: goto L_0x01e5;
                case 21: goto L_0x01c0;
                case 22: goto L_0x01b1;
                case 23: goto L_0x01a3;
                case 24: goto L_0x0190;
                case 25: goto L_0x0181;
                case 26: goto L_0x0175;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0162;
                case 30: goto L_0x014f;
                case 31: goto L_0x0143;
                case 32: goto L_0x0137;
                case 33: goto L_0x012b;
                case 34: goto L_0x011c;
                case 35: goto L_0x0110;
                case 36: goto L_0x00eb;
                case 37: goto L_0x00df;
                case 38: goto L_0x00d0;
                case 39: goto L_0x00bd;
                case 40: goto L_0x00aa;
                case 41: goto L_0x009e;
                case 42: goto L_0x0079;
                case 43: goto L_0x004c;
                case 44: goto L_0x0039;
                case 45: goto L_0x0014;
                case 46: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r3 = 0
            return r3
        L_0x0006:
            boolean r3 = r2.zzY()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzbaf.zza
            r5.writeInt(r3)
            goto L_0x0311
        L_0x0014:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x001b
            goto L_0x002e
        L_0x001b:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzci
            if (r0 == 0) goto L_0x0029
            com.google.android.gms.ads.internal.client.zzci r6 = (com.google.android.gms.ads.internal.client.zzci) r6
            goto L_0x002e
        L_0x0029:
            com.google.android.gms.ads.internal.client.zzcg r6 = new com.google.android.gms.ads.internal.client.zzcg
            r6.<init>(r3)
        L_0x002e:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzJ(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x0039:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzW(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x004c:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x005b
            goto L_0x006e
        L_0x005b:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r6 = r0.queryLocalInterface(r6)
            boolean r1 = r6 instanceof com.google.android.gms.ads.internal.client.zzbk
            if (r1 == 0) goto L_0x0069
            com.google.android.gms.ads.internal.client.zzbk r6 = (com.google.android.gms.ads.internal.client.zzbk) r6
            goto L_0x006e
        L_0x0069:
            com.google.android.gms.ads.internal.client.zzbi r6 = new com.google.android.gms.ads.internal.client.zzbi
            r6.<init>(r0)
        L_0x006e:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzy(r3, r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x0079:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x0080
            goto L_0x0093
        L_0x0080:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzdg
            if (r0 == 0) goto L_0x008e
            com.google.android.gms.ads.internal.client.zzdg r6 = (com.google.android.gms.ads.internal.client.zzdg) r6
            goto L_0x0093
        L_0x008e:
            com.google.android.gms.ads.internal.client.zzde r6 = new com.google.android.gms.ads.internal.client.zzde
            r6.<init>(r3)
        L_0x0093:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzP(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x009e:
            com.google.android.gms.ads.internal.client.zzdn r3 = r2.zzk()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0311
        L_0x00aa:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbcj r3 = com.google.android.gms.internal.ads.zzbci.zze(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzH(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x00bd:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzw> r3 = com.google.android.gms.ads.internal.client.zzw.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzw r3 = (com.google.android.gms.ads.internal.client.zzw) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzI(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x00d0:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzR(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x00df:
            android.os.Bundle r3 = r2.zzd()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zze(r5, r3)
            goto L_0x0311
        L_0x00eb:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00f2
            goto L_0x0105
        L_0x00f2:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzby
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.ads.internal.client.zzby r6 = (com.google.android.gms.ads.internal.client.zzby) r6
            goto L_0x0105
        L_0x0100:
            com.google.android.gms.ads.internal.client.zzbw r6 = new com.google.android.gms.ads.internal.client.zzbw
            r6.<init>(r3)
        L_0x0105:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzE(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x0110:
            java.lang.String r3 = r2.zzt()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0311
        L_0x011c:
            boolean r3 = com.google.android.gms.internal.ads.zzbaf.zzg(r4)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzL(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x012b:
            com.google.android.gms.ads.internal.client.zzbh r3 = r2.zzi()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0311
        L_0x0137:
            com.google.android.gms.ads.internal.client.zzcb r3 = r2.zzj()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0311
        L_0x0143:
            java.lang.String r3 = r2.zzr()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0311
        L_0x014f:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzdu> r3 = com.google.android.gms.ads.internal.client.zzdu.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzdu r3 = (com.google.android.gms.ads.internal.client.zzdu) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzK(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x0162:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzfk> r3 = com.google.android.gms.ads.internal.client.zzfk.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzfk r3 = (com.google.android.gms.ads.internal.client.zzfk) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzU(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x0175:
            com.google.android.gms.ads.internal.client.zzdq r3 = r2.zzl()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
            goto L_0x0311
        L_0x0181:
            java.lang.String r3 = r4.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzT(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x0190:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbyn r3 = com.google.android.gms.internal.ads.zzbym.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzS(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x01a3:
            boolean r3 = r2.zzZ()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzbaf.zza
            r5.writeInt(r3)
            goto L_0x0311
        L_0x01b1:
            boolean r3 = com.google.android.gms.internal.ads.zzbaf.zzg(r4)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzN(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x01c0:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01c7
            goto L_0x01da
        L_0x01c7:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcf
            if (r0 == 0) goto L_0x01d5
            com.google.android.gms.ads.internal.client.zzcf r6 = (com.google.android.gms.ads.internal.client.zzcf) r6
            goto L_0x01da
        L_0x01d5:
            com.google.android.gms.ads.internal.client.zzcf r6 = new com.google.android.gms.ads.internal.client.zzcf
            r6.<init>(r3)
        L_0x01da:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzac(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x01e5:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x01ec
            goto L_0x01ff
        L_0x01ec:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbe
            if (r0 == 0) goto L_0x01fa
            com.google.android.gms.ads.internal.client.zzbe r6 = (com.google.android.gms.ads.internal.client.zzbe) r6
            goto L_0x01ff
        L_0x01fa:
            com.google.android.gms.ads.internal.client.zzbc r6 = new com.google.android.gms.ads.internal.client.zzbc
            r6.<init>(r3)
        L_0x01ff:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzC(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x020a:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbfk r3 = com.google.android.gms.internal.ads.zzbfj.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzO(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x021d:
            java.lang.String r3 = r2.zzs()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0311
        L_0x0229:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbvs r3 = com.google.android.gms.internal.ads.zzbvr.zzb(r3)
            java.lang.String r6 = r4.readString()
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzQ(r3, r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x0240:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzbvp r3 = com.google.android.gms.internal.ads.zzbvo.zzb(r3)
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzM(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x0253:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzq> r3 = com.google.android.gms.ads.internal.client.zzq.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzq r3 = (com.google.android.gms.ads.internal.client.zzq) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzF(r3)
            r5.writeNoException()
            goto L_0x0311
        L_0x0266:
            com.google.android.gms.ads.internal.client.zzq r3 = r2.zzg()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zze(r5, r3)
            goto L_0x0311
        L_0x0272:
            r2.zzA()
            r5.writeNoException()
            goto L_0x0311
        L_0x027a:
            r5.writeNoException()
            goto L_0x0311
        L_0x027f:
            r2.zzX()
            r5.writeNoException()
            goto L_0x0311
        L_0x0287:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x028e
            goto L_0x02a1
        L_0x028e:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzcb
            if (r0 == 0) goto L_0x029c
            com.google.android.gms.ads.internal.client.zzcb r6 = (com.google.android.gms.ads.internal.client.zzcb) r6
            goto L_0x02a1
        L_0x029c:
            com.google.android.gms.ads.internal.client.zzbz r6 = new com.google.android.gms.ads.internal.client.zzbz
            r6.<init>(r3)
        L_0x02a1:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzG(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x02ab:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x02b2
            goto L_0x02c5
        L_0x02b2:
            java.lang.String r6 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r6 = r3.queryLocalInterface(r6)
            boolean r0 = r6 instanceof com.google.android.gms.ads.internal.client.zzbh
            if (r0 == 0) goto L_0x02c0
            com.google.android.gms.ads.internal.client.zzbh r6 = (com.google.android.gms.ads.internal.client.zzbh) r6
            goto L_0x02c5
        L_0x02c0:
            com.google.android.gms.ads.internal.client.zzbf r6 = new com.google.android.gms.ads.internal.client.zzbf
            r6.<init>(r3)
        L_0x02c5:
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            r2.zzD(r6)
            r5.writeNoException()
            goto L_0x0311
        L_0x02cf:
            r2.zzB()
            r5.writeNoException()
            goto L_0x0311
        L_0x02d6:
            r2.zzz()
            r5.writeNoException()
            goto L_0x0311
        L_0x02dd:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.client.zzl> r3 = com.google.android.gms.ads.internal.client.zzl.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzbaf.zza(r4, r3)
            com.google.android.gms.ads.internal.client.zzl r3 = (com.google.android.gms.ads.internal.client.zzl) r3
            com.google.android.gms.internal.ads.zzbaf.zzc(r4)
            boolean r3 = r2.zzab(r3)
            r5.writeNoException()
            r5.writeInt(r3)
            goto L_0x0311
        L_0x02f3:
            boolean r3 = r2.zzaa()
            r5.writeNoException()
            int r4 = com.google.android.gms.internal.ads.zzbaf.zza
            r5.writeInt(r3)
            goto L_0x0311
        L_0x0300:
            r2.zzx()
            r5.writeNoException()
            goto L_0x0311
        L_0x0307:
            com.google.android.gms.dynamic.IObjectWrapper r3 = r2.zzn()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzbaf.zzf(r5, r3)
        L_0x0311:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzbt.zzdF(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
