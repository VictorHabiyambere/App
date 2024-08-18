package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdv;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbdm {
    private final zzbdu zza;
    private final zzbdv.zzt.zza zzb;
    private final boolean zzc;

    private zzbdm() {
        this.zzb = zzbdv.zzt.zzj();
        this.zzc = false;
        this.zza = new zzbdu();
    }

    public static zzbdm zza() {
        return new zzbdm();
    }

    private final synchronized String zzd(zzbdo zzbdo) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzb.zzah(), Long.valueOf(zzu.zzB().elapsedRealtime()), Integer.valueOf(zzbdo.zza()), Base64.encodeToString(((zzbdv.zzt) this.zzb.zzbr()).zzaV(), 3)});
    }

    private final synchronized void zze(zzbdo zzbdo) {
        FileOutputStream fileOutputStream;
        String str;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(zzftv.zza(zzftu.zza(), externalStorageDirectory, "clearcut_events.txt")), true);
                try {
                    fileOutputStream.write(zzd(zzbdo).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        str = "Could not close Clearcut output stream.";
                        zze.zza(str);
                    }
                } catch (IOException e2) {
                    zze.zza("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        str = "Could not close Clearcut output stream.";
                    }
                }
            } catch (FileNotFoundException e4) {
                zze.zza("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zze.zza("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized void zzf(zzbdo zzbdo) {
        zzbdv.zzt.zza zza2 = this.zzb;
        zza2.zzq();
        zza2.zzj(zzt.zzd());
        zzbdt zzbdt = new zzbdt(this.zza, ((zzbdv.zzt) this.zzb.zzbr()).zzaV(), (zzbds) null);
        zzbdt.zza(zzbdo.zza());
        zzbdt.zzc();
        zze.zza("Logging Event with event code : ".concat(String.valueOf(Integer.toString(zzbdo.zza(), 10))));
    }

    public final synchronized void zzb(zzbdo zzbdo) {
        if (this.zzc) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzeU)).booleanValue()) {
                zze(zzbdo);
            } else {
                zzf(zzbdo);
            }
        }
    }

    public final synchronized void zzc(zzbdl zzbdl) {
        if (this.zzc) {
            try {
                zzbdl.zza(this.zzb);
            } catch (NullPointerException e) {
                zzu.zzo().zzw(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    public zzbdm(zzbdu zzbdu) {
        this.zzb = zzbdv.zzt.zzj();
        this.zza = zzbdu;
        this.zzc = ((Boolean) zzba.zzc().zza(zzbep.zzeT)).booleanValue();
    }
}
