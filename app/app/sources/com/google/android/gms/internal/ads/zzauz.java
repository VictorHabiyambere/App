package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzauz implements zzhbs {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5);
    
    private static final zzhbt zzg = null;
    private final int zzi;

    static {
        zzg = new zzaux();
    }

    private zzauz(int i) {
        this.zzi = i;
    }

    public static zzauz zzb(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_ENCRYPTION_METHOD;
            case 1:
                return BITSLICER;
            case 2:
                return TINK_HYBRID;
            case 3:
                return UNENCRYPTED;
            case 4:
                return DG;
            case 5:
                return DG_XTEA;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzi);
    }

    public final int zza() {
        return this.zzi;
    }
}
