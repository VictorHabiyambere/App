package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeob extends zzbtg {
    private final String zza;
    private final zzbte zzb;
    private final zzccn zzc;
    private final JSONObject zzd = new JSONObject();
    private final long zze;
    private boolean zzf = false;

    public zzeob(String str, zzbte zzbte, zzccn zzccn, long j) {
        this.zzc = zzccn;
        this.zza = str;
        this.zzb = zzbte;
        this.zze = j;
        try {
            this.zzd.put("adapter_version", this.zzb.zzf().toString());
            this.zzd.put("sdk_version", this.zzb.zzg().toString());
            this.zzd.put("name", this.zza);
        } catch (RemoteException | NullPointerException | JSONException e) {
        }
    }

    public static synchronized void zzb(String str, zzccn zzccn) {
        synchronized (zzeob.class) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("signal_error", "Adapter failed to instantiate");
                if (((Boolean) zzba.zzc().zza(zzbep.zzbB)).booleanValue()) {
                    jSONObject.put("signal_error_code", 1);
                }
                zzccn.zzc(jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    private final synchronized void zzh(String str, int i) {
        if (!this.zzf) {
            try {
                this.zzd.put("signal_error", str);
                if (((Boolean) zzba.zzc().zza(zzbep.zzbC)).booleanValue()) {
                    this.zzd.put("latency", zzu.zzB().elapsedRealtime() - this.zze);
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzbB)).booleanValue()) {
                    this.zzd.put("signal_error_code", i);
                }
            } catch (JSONException e) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        }
    }

    public final synchronized void zzc() {
        zzh("Signal collection timeout.", 3);
    }

    public final synchronized void zzd() {
        if (!this.zzf) {
            try {
                if (((Boolean) zzba.zzc().zza(zzbep.zzbB)).booleanValue()) {
                    this.zzd.put("signal_error_code", 0);
                }
            } catch (JSONException e) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        }
    }

    public final synchronized void zze(String str) throws RemoteException {
        if (!this.zzf) {
            if (str == null) {
                zzf("Adapter returned null signals");
                return;
            }
            try {
                this.zzd.put("signals", str);
                if (((Boolean) zzba.zzc().zza(zzbep.zzbC)).booleanValue()) {
                    this.zzd.put("latency", zzu.zzB().elapsedRealtime() - this.zze);
                }
                if (((Boolean) zzba.zzc().zza(zzbep.zzbB)).booleanValue()) {
                    this.zzd.put("signal_error_code", 0);
                }
            } catch (JSONException e) {
            }
            this.zzc.zzc(this.zzd);
            this.zzf = true;
        }
    }

    public final synchronized void zzf(String str) throws RemoteException {
        zzh(str, 2);
    }

    public final synchronized void zzg(zze zze2) throws RemoteException {
        zzh(zze2.zzb, 2);
    }
}
