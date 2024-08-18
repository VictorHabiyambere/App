package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdv;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzefd extends zzefe {
    private static final SparseArray zzb = new SparseArray();
    private final Context zzc;
    private final zzcyp zzd;
    private final TelephonyManager zze;
    /* access modifiers changed from: private */
    public final zzeev zzf;
    private zzbdv.zzq zzg;

    static {
        zzb.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbdv.zzaf.zzd.CONNECTED);
        zzb.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbdv.zzaf.zzd.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbdv.zzaf.zzd.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbdv.zzaf.zzd.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbdv.zzaf.zzd.DISCONNECTING);
        zzb.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbdv.zzaf.zzd.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbdv.zzaf.zzd.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbdv.zzaf.zzd.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbdv.zzaf.zzd.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbdv.zzaf.zzd.DISCONNECTED);
        zzb.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbdv.zzaf.zzd.SUSPENDED);
        zzb.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbdv.zzaf.zzd.CONNECTING);
        zzb.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbdv.zzaf.zzd.CONNECTING);
    }

    zzefd(Context context, zzcyp zzcyp, zzeev zzeev, zzeer zzeer, zzg zzg2) {
        super(zzeer, zzg2);
        this.zzc = context;
        this.zzd = zzcyp;
        this.zzf = zzeev;
        this.zze = (TelephonyManager) context.getSystemService("phone");
    }

    static /* bridge */ /* synthetic */ zzbdv.zzab zza(zzefd zzefd, Bundle bundle) {
        zzbdv.zzab.zzb zzb2;
        zzbdv.zzab.zza zza = zzbdv.zzab.zza();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            zzefd.zzg = zzbdv.zzq.ENUM_TRUE;
        } else {
            zzefd.zzg = zzbdv.zzq.ENUM_FALSE;
            switch (i) {
                case 0:
                    zza.zzd(zzbdv.zzab.zzc.CELL);
                    break;
                case 1:
                    zza.zzd(zzbdv.zzab.zzc.WIFI);
                    break;
                default:
                    zza.zzd(zzbdv.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzb2 = zzbdv.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzb2 = zzbdv.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzb2 = zzbdv.zzab.zzb.LTE;
                    break;
                default:
                    zzb2 = zzbdv.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zza.zzc(zzb2);
        }
        return (zzbdv.zzab) zza.zzbr();
    }

    static /* bridge */ /* synthetic */ zzbdv.zzaf.zzd zzb(zzefd zzefd, Bundle bundle) {
        return (zzbdv.zzaf.zzd) zzb.get(zzfic.zza(zzfic.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbdv.zzaf.zzd.UNSPECIFIED);
    }

    static /* bridge */ /* synthetic */ byte[] zze(zzefd zzefd, boolean z, ArrayList arrayList, zzbdv.zzab zzab, zzbdv.zzaf.zzd zzd2) {
        zzbdv.zzaf.zza.C0002zza zzn = zzbdv.zzaf.zza.zzn();
        zzn.zzn(arrayList);
        boolean z2 = false;
        zzn.zzD(zzg(Settings.Global.getInt(zzefd.zzc.getContentResolver(), "airplane_mode_on", 0) != 0));
        zzn.zzE(zzu.zzq().zzg(zzefd.zzc, zzefd.zze));
        zzn.zzM(zzefd.zzf.zze());
        zzn.zzL(zzefd.zzf.zzb());
        zzn.zzG(zzefd.zzf.zza());
        zzn.zzH(zzd2);
        zzn.zzJ(zzab);
        zzn.zzK(zzefd.zzg);
        zzn.zzN(zzg(z));
        zzn.zzP(zzefd.zzf.zzd());
        zzn.zzO(zzu.zzB().currentTimeMillis());
        if (Settings.Global.getInt(zzefd.zzc.getContentResolver(), "wifi_on", 0) != 0) {
            z2 = true;
        }
        zzn.zzQ(zzg(z2));
        return ((zzbdv.zzaf.zza) zzn.zzbr()).zzaV();
    }

    private static final zzbdv.zzq zzg(boolean z) {
        return z ? zzbdv.zzq.ENUM_TRUE : zzbdv.zzq.ENUM_FALSE;
    }

    public final void zzd(boolean z) {
        zzgft.zzr(this.zzd.zzb(new Bundle()), new zzefc(this, z), zzcci.zzf);
    }
}
