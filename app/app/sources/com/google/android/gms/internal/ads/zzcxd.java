package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzax;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcxd implements zzdcg, zzdhu {
    private zzbxo zza;
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final Context zzc;
    private final zzfmq zzd;
    private final VersionInfoParcel zze;
    private final Executor zzf;
    private boolean zzg = false;
    private boolean zzh = false;

    zzcxd(Context context, zzfmq zzfmq, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzc = context;
        this.zzd = zzfmq;
        this.zze = versionInfoParcel;
        this.zzf = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        zzbdz.zze(this.zzc);
        this.zzh = true;
    }

    public final void zzd() {
        zzbxo zzbxo;
        zzbqh zzbqh;
        if (!this.zzb.getAndSet(true)) {
            int i = 2;
            if (!((Boolean) zzbgk.zzk.zze()).booleanValue()) {
                if (((Boolean) zzbgk.zzl.zze()).booleanValue()) {
                    i = 3;
                } else if (!((Boolean) zzbgk.zzj.zze()).booleanValue()) {
                    i = 1;
                } else {
                    try {
                        String optString = new JSONObject(zzu.zzo().zzi().zzh().zzc()).optString("local_flag_write");
                        if (!TextUtils.equals(optString, "client")) {
                            if (TextUtils.equals(optString, NotificationCompat.CATEGORY_SERVICE)) {
                                i = 3;
                            }
                            i = 1;
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            switch (i - 1) {
                case 1:
                    zzbqh = zzu.zzf().zza(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                    break;
                case 2:
                    zzbqh = zzu.zzf().zzb(this.zzc, VersionInfoParcel.forPackage(), this.zzd);
                    break;
            }
            this.zza = new zzbxq(this.zzc, zzbqh.zza("google.afma.sdkConstants.getSdkConstants", zzbqe.zza, zzbqe.zza), this.zze);
            this.zzg = true;
        }
        if (this.zzg && (zzbxo = this.zza) != null) {
            ListenableFuture zza2 = zzbxo.zza();
            if (!this.zzh && ((Boolean) zzbgc.zzi.zze()).booleanValue()) {
                zza2.addListener(new zzcxc(this), this.zzf);
            }
            zzccl.zza(zza2, "persistFlagsClient");
        }
    }

    public final void zzdn(zzbxu zzbxu) {
        zzd();
    }

    public final void zzdo(zzfhf zzfhf) {
    }

    public final void zze(zzax zzax) {
        zzd();
    }

    public final void zzf(String str) {
        zzd();
    }
}
