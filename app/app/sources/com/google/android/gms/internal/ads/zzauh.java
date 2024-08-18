package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzauh implements zzhbs {
    TRIGGER_UNSPECIFIED(0),
    NO_TRIGGER(1),
    ON_BACK_PRESSED(2),
    HANDLE_ON_BACK_PRESSED(3),
    ON_KEY_DOWN(4),
    ON_BACK_INVOKED(5),
    ON_CREATE(6),
    ON_START(7),
    ON_RESUME(8),
    ON_RESTART(9),
    ON_PAUSE(10),
    ON_STOP(11),
    ON_DESTROY(12),
    ERROR_EMPTY_STACK_TRACE(13);
    
    private static final zzhbt zzo = null;
    private final int zzq;

    static {
        zzo = new zzauf();
    }

    private zzauh(int i) {
        this.zzq = i;
    }

    public static zzauh zzb(int i) {
        switch (i) {
            case 0:
                return TRIGGER_UNSPECIFIED;
            case 1:
                return NO_TRIGGER;
            case 2:
                return ON_BACK_PRESSED;
            case 3:
                return HANDLE_ON_BACK_PRESSED;
            case 4:
                return ON_KEY_DOWN;
            case 5:
                return ON_BACK_INVOKED;
            case 6:
                return ON_CREATE;
            case 7:
                return ON_START;
            case 8:
                return ON_RESUME;
            case 9:
                return ON_RESTART;
            case 10:
                return ON_PAUSE;
            case 11:
                return ON_STOP;
            case 12:
                return ON_DESTROY;
            case 13:
                return ERROR_EMPTY_STACK_TRACE;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzq);
    }

    public final int zza() {
        return this.zzq;
    }
}
