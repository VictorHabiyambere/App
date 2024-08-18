package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzats implements zzhbs {
    DEBUGGER_STATE_UNSPECIFIED(0),
    DEBUGGER_STATE_NOT_INSTALLED(1),
    DEBUGGER_STATE_INSTALLED(2),
    DEBUGGER_STATE_ACTIVE(3),
    DEBUGGER_STATE_ENVVAR(4),
    DEBUGGER_STATE_MACHPORT(5),
    DEBUGGER_STATE_ENVVAR_MACHPORT(6);
    
    private static final zzhbt zzh = null;
    private final int zzj;

    static {
        zzh = new zzatq();
    }

    private zzats(int i) {
        this.zzj = i;
    }

    public static zzats zzb(int i) {
        switch (i) {
            case 0:
                return DEBUGGER_STATE_UNSPECIFIED;
            case 1:
                return DEBUGGER_STATE_NOT_INSTALLED;
            case 2:
                return DEBUGGER_STATE_INSTALLED;
            case 3:
                return DEBUGGER_STATE_ACTIVE;
            case 4:
                return DEBUGGER_STATE_ENVVAR;
            case 5:
                return DEBUGGER_STATE_MACHPORT;
            case 6:
                return DEBUGGER_STATE_ENVVAR_MACHPORT;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzj);
    }

    public final int zza() {
        return this.zzj;
    }
}
