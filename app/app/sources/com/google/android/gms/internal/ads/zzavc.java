package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzavc implements zzhbs {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);
    
    private static final zzhbt zze = null;
    private final int zzg;

    static {
        zze = new zzava();
    }

    private zzavc(int i) {
        this.zzg = i;
    }

    public static zzavc zzb(int i) {
        switch (i) {
            case 0:
                return ENUM_FALSE;
            case 1:
                return ENUM_TRUE;
            case 2:
                return ENUM_FAILURE;
            case 1000:
                return ENUM_UNKNOWN;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzg);
    }

    public final int zza() {
        return this.zzg;
    }
}
