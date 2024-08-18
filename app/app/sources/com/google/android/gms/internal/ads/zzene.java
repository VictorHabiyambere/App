package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzene implements zzehl {
    private final Context zza;
    private final zzctg zzb;
    private final zzbfk zzc;
    private final zzgge zzd;
    private final zzflt zze;

    public zzene(Context context, zzctg zzctg, zzflt zzflt, zzgge zzgge, zzbfk zzbfk) {
        this.zza = context;
        this.zzb = zzctg;
        this.zze = zzflt;
        this.zzd = zzgge;
        this.zzc = zzbfk;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzenc zzenc = new zzenc(this, new View(this.zza), (zzchd) null, new zzena(), (zzfgu) zzfgt.zzv.get(0));
        zzcsg zza2 = this.zzb.zza(new zzcvf(zzfhf, zzfgt, (String) null), zzenc);
        zzend zzl = zza2.zzl();
        zzfgy zzfgy = zzfgt.zzt;
        zzbff zzbff = new zzbff(zzl, zzfgy.zzb, zzfgy.zza);
        zzfln zzfln = zzfln.CUSTOM_RENDER_SYN;
        return zzfld.zzd(new zzenb(this, zzbff), this.zzd, zzfln, this.zze).zzb(zzfln.CUSTOM_RENDER_ACK).zzd(zzgft.zzh(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfhf r1, com.google.android.gms.internal.ads.zzfgt r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbfk r1 = r0.zzc
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzfgy r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzene.zzb(com.google.android.gms.internal.ads.zzfhf, com.google.android.gms.internal.ads.zzfgt):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbff zzbff) throws Exception {
        this.zzc.zze(zzbff);
    }
}
