package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzaua implements zzhbs {
    FUNCTION_UNSPECIFIED(0),
    FUNCTION_METHOD_EXCHANGEIMPLEMENTATIONS(1),
    FUNCTION_METHOD_SETIMPLEMENTATIONS(2),
    FUNCTION_CLASS_ADDMETHOD(3),
    FUNCTION_CLASS_REPLACEMETHOD(4);
    
    private static final zzhbt zzf = null;
    private final int zzh;

    static {
        zzf = new zzaty();
    }

    private zzaua(int i) {
        this.zzh = i;
    }

    public static zzaua zzb(int i) {
        switch (i) {
            case 0:
                return FUNCTION_UNSPECIFIED;
            case 1:
                return FUNCTION_METHOD_EXCHANGEIMPLEMENTATIONS;
            case 2:
                return FUNCTION_METHOD_SETIMPLEMENTATIONS;
            case 3:
                return FUNCTION_CLASS_ADDMETHOD;
            case 4:
                return FUNCTION_CLASS_REPLACEMETHOD;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzh);
    }

    public final int zza() {
        return this.zzh;
    }
}
