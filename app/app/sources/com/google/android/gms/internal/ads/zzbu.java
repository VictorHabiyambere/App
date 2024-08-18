package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbu {
    public static final zzbu zza = new zzaw().zzc();
    @Deprecated
    public static final zzn zzb = new zzat();
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    public final String zzc;
    public final zzbn zzd;
    @Deprecated
    public final zzbn zze;
    public final zzbk zzf;
    public final zzca zzg;
    public final zzba zzh;
    @Deprecated
    public final zzbc zzi;
    public final zzbq zzj;

    /* synthetic */ zzbu(String str, zzbc zzbc, zzbn zzbn, zzbk zzbk, zzca zzca, zzbq zzbq, zzbt zzbt) {
        this.zzc = str;
        this.zzd = zzbn;
        this.zze = zzbn;
        this.zzf = zzbk;
        this.zzg = zzca;
        this.zzh = zzbc;
        this.zzi = zzbc;
        this.zzj = zzbq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbu)) {
            return false;
        }
        zzbu zzbu = (zzbu) obj;
        return zzgd.zzG(this.zzc, zzbu.zzc) && this.zzh.equals(zzbu.zzh) && zzgd.zzG(this.zzd, zzbu.zzd) && zzgd.zzG(this.zzf, zzbu.zzf) && zzgd.zzG(this.zzg, zzbu.zzg) && zzgd.zzG(this.zzj, zzbu.zzj);
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zzc.hashCode() * 31;
        zzbn zzbn = this.zzd;
        if (zzbn != null) {
            i = zzbn.hashCode();
        } else {
            i = 0;
        }
        return (((((((hashCode + i) * 31) + this.zzf.hashCode()) * 31) + this.zzh.hashCode()) * 31) + this.zzg.hashCode()) * 31;
    }
}
