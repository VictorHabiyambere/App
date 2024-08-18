package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzatc implements zzhbs {
    UNKNOWN(0),
    ENABLED(1),
    DISABLED(2);
    
    private static final zzhbt zzd = null;
    private final int zzf;

    static {
        zzd = new zzata();
    }

    private zzatc(int i) {
        this.zzf = i;
    }

    public static zzatc zzb(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return ENABLED;
            case 2:
                return DISABLED;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzf);
    }

    public final int zza() {
        return this.zzf;
    }
}
