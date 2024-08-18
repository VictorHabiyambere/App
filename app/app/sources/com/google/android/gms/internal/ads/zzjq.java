package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzjq {
    final Context zza;
    zzer zzb;
    zzfyw zzc;
    zzfyw zzd;
    zzfyw zze;
    zzfyw zzf;
    zzfyw zzg;
    zzfxu zzh;
    Looper zzi;
    zzk zzj;
    int zzk;
    boolean zzl;
    zzmr zzm;
    long zzn;
    long zzo;
    boolean zzp;
    boolean zzq;
    String zzr;
    zzja zzs;

    static /* synthetic */ zzvn zza(Context context) {
        return new zzvb(context, new zzadn());
    }

    public zzjq(Context context, zzcgn zzcgn) {
        Context context2 = context;
        zzjj zzjj = new zzjj(zzcgn);
        zzjk zzjk = new zzjk(context2);
        zzjl zzjl = new zzjl(context2);
        zzjm zzjm = new zzjm();
        zzjn zzjn = new zzjn(context2);
        zzjo zzjo = new zzjo();
        if (context2 != null) {
            this.zza = context2;
            this.zzc = zzjj;
            this.zzd = zzjk;
            this.zze = zzjl;
            this.zzf = zzjm;
            this.zzg = zzjn;
            this.zzh = zzjo;
            this.zzi = zzgd.zzy();
            this.zzj = zzk.zza;
            this.zzk = 1;
            this.zzl = true;
            this.zzm = zzmr.zze;
            this.zzs = new zzja(0.97f, 1.03f, 1000, 1.0E-7f, zzgd.zzr(20), zzgd.zzr(500), 0.999f, (zziz) null);
            this.zzb = zzer.zza;
            this.zzn = 500;
            this.zzo = 2000;
            this.zzp = true;
            this.zzr = "";
            return;
        }
        throw null;
    }
}
