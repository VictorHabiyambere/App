package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final /* synthetic */ class zzewt implements Runnable {
    public final /* synthetic */ zzewx zza;
    public final /* synthetic */ zzbte zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzeob zze;
    public final /* synthetic */ zzccn zzf;

    public /* synthetic */ zzewt(zzewx zzewx, zzbte zzbte, Bundle bundle, List list, zzeob zzeob, zzccn zzccn) {
        this.zza = zzewx;
        this.zzb = zzbte;
        this.zzc = bundle;
        this.zzd = list;
        this.zze = zzeob;
        this.zzf = zzccn;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
