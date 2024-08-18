package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzenj implements zzehl {
    private final zzbfk zza;
    private final zzgge zzb;
    private final zzflt zzc;
    /* access modifiers changed from: private */
    public final zzens zzd;

    public zzenj(zzflt zzflt, zzgge zzgge, zzbfk zzbfk, zzens zzens) {
        this.zzc = zzflt;
        this.zzb = zzgge;
        this.zza = zzbfk;
        this.zzd = zzens;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzccn zzccn = new zzccn();
        zzeno zzeno = new zzeno();
        zzeno.zzd(new zzeni(this, zzccn, zzfhf, zzfgt, zzeno));
        zzfgy zzfgy = zzfgt.zzt;
        zzbff zzbff = new zzbff(zzeno, zzfgy.zzb, zzfgy.zza);
        zzfln zzfln = zzfln.CUSTOM_RENDER_SYN;
        return zzfld.zzd(new zzenh(this, zzbff), this.zzb, zzfln, this.zzc).zzb(zzfln.CUSTOM_RENDER_ACK).zzd(zzccn).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzfhf r1, com.google.android.gms.internal.ads.zzfgt r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbfk r1 = r0.zza
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenj.zzb(com.google.android.gms.internal.ads.zzfhf, com.google.android.gms.internal.ads.zzfgt):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbff zzbff) throws Exception {
        this.zza.zze(zzbff);
    }
}
