package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbn {
    @Deprecated
    public static final zzn zza = new zzbl();
    private static final String zzl = Integer.toString(0, 36);
    private static final String zzm = Integer.toString(1, 36);
    private static final String zzn = Integer.toString(2, 36);
    private static final String zzo = Integer.toString(3, 36);
    private static final String zzp = Integer.toString(4, 36);
    private static final String zzq = Integer.toString(5, 36);
    private static final String zzr = Integer.toString(6, 36);
    private static final String zzs = Integer.toString(7, 36);
    public final Uri zzb;
    public final String zzc = null;
    public final zzbg zzd = null;
    public final zzav zze = null;
    public final List zzf;
    public final String zzg;
    public final zzgbc zzh;
    @Deprecated
    public final List zzi;
    public final Object zzj;
    public final long zzk;

    /* synthetic */ zzbn(Uri uri, String str, zzbg zzbg, zzav zzav, List list, String str2, zzgbc zzgbc, Object obj, long j, zzbm zzbm) {
        this.zzb = uri;
        int i = zzcg.zza;
        this.zzf = list;
        this.zzg = null;
        this.zzh = zzgbc;
        zzgaz zzgaz = new zzgaz();
        if (zzgbc.size() <= 0) {
            this.zzi = zzgaz.zzi();
            this.zzj = null;
            this.zzk = -9223372036854775807L;
            return;
        }
        zzbs zzbs = (zzbs) zzgbc.get(0);
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbn)) {
            return false;
        }
        zzbn zzbn = (zzbn) obj;
        if (this.zzb.equals(zzbn.zzb)) {
            String str = zzbn.zzc;
            if (zzgd.zzG((Object) null, (Object) null)) {
                zzbg zzbg = zzbn.zzd;
                if (zzgd.zzG((Object) null, (Object) null)) {
                    zzav zzav = zzbn.zze;
                    if (zzgd.zzG((Object) null, (Object) null) && this.zzf.equals(zzbn.zzf)) {
                        String str2 = zzbn.zzg;
                        if (zzgd.zzG((Object) null, (Object) null) && this.zzh.equals(zzbn.zzh)) {
                            Object obj2 = zzbn.zzj;
                            if (zzgd.zzG((Object) null, (Object) null)) {
                                long j = zzbn.zzk;
                                if (zzgd.zzG(-9223372036854775807L, -9223372036854775807L)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) ((((long) (((((this.zzb.hashCode() * 923521) + this.zzf.hashCode()) * 961) + this.zzh.hashCode()) * 31)) * 31) - Long.MAX_VALUE);
    }
}
