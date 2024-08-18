package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaer {
    public final zzaeu zza;
    public final zzaeu zzb;

    public zzaer(zzaeu zzaeu, zzaeu zzaeu2) {
        this.zza = zzaeu;
        this.zzb = zzaeu2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaer zzaer = (zzaer) obj;
        return this.zza.equals(zzaer.zza) && this.zzb.equals(zzaer.zzb);
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        zzaeu zzaeu = this.zza;
        zzaeu zzaeu2 = this.zzb;
        String obj = zzaeu.toString();
        String concat = zzaeu.equals(zzaeu2) ? "" : ", ".concat(this.zzb.toString());
        return "[" + obj + concat + "]";
    }
}
