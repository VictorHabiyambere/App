package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgd;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzfmc;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzgfp;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaf implements zzgfp {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzcbk zzb;
    final /* synthetic */ zzcbd zzc;
    final /* synthetic */ zzfmc zzd;
    final /* synthetic */ zzaj zze;

    zzaf(zzaj zzaj, ListenableFuture listenableFuture, zzcbk zzcbk, zzcbd zzcbd, zzfmc zzfmc) {
        this.zza = listenableFuture;
        this.zzb = zzcbk;
        this.zzc = zzcbd;
        this.zzd = zzfmc;
        this.zze = zzaj;
    }

    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) zzba.zzc().zza(zzbep.zzhP)).booleanValue()) {
            zzu.zzo().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            zzu.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfmn zzr = zzaj.zzr(this.zza, this.zzb);
        if (((Boolean) zzbgd.zze.zze()).booleanValue() && zzr != null) {
            zzfmc zzfmc = this.zzd;
            zzfmc.zzi(th);
            zzfmc.zzh(false);
            zzr.zza(zzfmc);
            zzr.zzi();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzax zzax = (zzax) obj;
        zzfmn zzr = zzaj.zzr(this.zza, this.zzb);
        this.zze.zzG.set(true);
        if (!((Boolean) zzba.zzc().zza(zzbep.zzhK)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzm.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (((Boolean) zzbgd.zze.zze()).booleanValue() && zzr != null) {
                zzfmc zzfmc = this.zzd;
                zzfmc.zzc("QueryInfo generation has been disabled.");
                zzfmc.zzh(false);
                zzr.zza(zzfmc);
                zzr.zzi();
                return;
            }
            return;
        }
        if (zzax == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                this.zzd.zzh(true);
                if (!((Boolean) zzbgd.zze.zze()).booleanValue() || zzr == null) {
                    return;
                }
            } catch (RemoteException e2) {
                zzfmc zzfmc2 = this.zzd;
                zzfmc2.zzi(e2);
                zzfmc2.zzh(false);
                zzm.zzh("", e2);
                zzu.zzo().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbgd.zze.zze()).booleanValue() || zzr == null) {
                    return;
                }
            } catch (Throwable th) {
                if (((Boolean) zzbgd.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzi();
                }
                throw th;
            }
        } else {
            try {
                if (TextUtils.isEmpty(new JSONObject(zzax.zzb).optString("request_id", ""))) {
                    zzm.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzfmc zzfmc3 = this.zzd;
                    zzfmc3.zzc("Request ID empty");
                    zzfmc3.zzh(false);
                    if (!((Boolean) zzbgd.zze.zze()).booleanValue() || zzr == null) {
                        return;
                    }
                } else {
                    Bundle bundle = zzax.zzd;
                    zzaj zzaj = this.zze;
                    if (zzaj.zzu && bundle != null && bundle.getInt(zzaj.zzw, -1) == -1) {
                        zzaj zzaj2 = this.zze;
                        bundle.putInt(zzaj2.zzw, zzaj2.zzx.get());
                    }
                    zzaj zzaj3 = this.zze;
                    if (zzaj3.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(zzaj3.zzv))) {
                        if (TextUtils.isEmpty(this.zze.zzz)) {
                            zzaj zzaj4 = this.zze;
                            zzt zzp = zzu.zzp();
                            zzaj zzaj5 = this.zze;
                            zzaj4.zzz = zzp.zzc(zzaj5.zzg, zzaj5.zzy.afmaVersion);
                        }
                        zzaj zzaj6 = this.zze;
                        bundle.putString(zzaj6.zzv, zzaj6.zzz);
                    }
                    this.zzc.zzc(zzax.zza, zzax.zzb, bundle);
                    this.zzd.zzh(true);
                    if (!((Boolean) zzbgd.zze.zze()).booleanValue() || zzr == null) {
                        return;
                    }
                }
            } catch (JSONException e3) {
                zzm.zzj("Failed to create JSON object from the request string.");
                zzcbd zzcbd = this.zzc;
                String obj2 = e3.toString();
                zzcbd.zzb("Internal error for request JSON: " + obj2);
                zzfmc zzfmc4 = this.zzd;
                zzfmc4.zzi(e3);
                zzfmc4.zzh(false);
                zzu.zzo().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbgd.zze.zze()).booleanValue() || zzr == null) {
                    return;
                }
            }
        }
        zzr.zza(this.zzd);
        zzr.zzi();
    }
}
