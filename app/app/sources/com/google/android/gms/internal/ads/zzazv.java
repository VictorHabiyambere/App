package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzazv implements zzhbt {
    zzazv() {
    }

    public final /* synthetic */ zzhbs zza(int i) {
        zzazw zzazw = zzazw.UNSUPPORTED;
        switch (i) {
            case 0:
                return zzazw.UNSUPPORTED;
            case 2:
                return zzazw.ARM7;
            case 4:
                return zzazw.X86;
            case 5:
                return zzazw.ARM64;
            case 6:
                return zzazw.X86_64;
            case 7:
                return zzazw.RISCV64;
            case 999:
                return zzazw.UNKNOWN;
            default:
                return null;
        }
    }
}
