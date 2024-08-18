package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzafi implements zzadu {
    public static final zzaea zza = new zzafh();
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    private static final byte[] zzd = "#!AMR\n".getBytes(zzfxs.zzc);
    private static final byte[] zze = "#!AMR-WB\n".getBytes(zzfxs.zzc);
    private static final int zzf = zzc[8];
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzadx zzp;
    private zzafa zzq;
    private zzaet zzr;
    private boolean zzs;

    static {
        int i = zzgd.zza;
    }

    public zzafi() {
        throw null;
    }

    public zzafi(int i) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    private static boolean zzg(zzadv zzadv, byte[] bArr) throws IOException {
        zzadv.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzadi) zzadv).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzadv zzadv) throws IOException {
        if (zzg(zzadv, zzd)) {
            this.zzh = false;
            ((zzadi) zzadv).zzo(zzd.length, false);
            return true;
        } else if (!zzg(zzadv, zze)) {
            return false;
        } else {
            this.zzh = true;
            ((zzadi) zzadv).zzo(zze.length, false);
            return true;
        }
    }

    public final int zzb(zzadv zzadv, zzaeq zzaeq) throws IOException {
        String str;
        int i;
        zzeq.zzb(this.zzq);
        int i2 = zzgd.zza;
        if (zzadv.zzf() != 0 || zzh(zzadv)) {
            if (!this.zzs) {
                this.zzs = true;
                boolean z = this.zzh;
                if (true != z) {
                    str = "audio/3gpp";
                } else {
                    str = "audio/amr-wb";
                }
                if (true != z) {
                    i = 8000;
                } else {
                    i = 16000;
                }
                zzafa zzafa = this.zzq;
                zzal zzal = new zzal();
                zzal.zzX(str);
                zzal.zzP(zzf);
                zzal.zzy(1);
                zzal.zzY(i);
                zzafa.zzl(zzal.zzad());
            }
            int zza2 = zza(zzadv);
            if (this.zzl) {
                return zza2;
            }
            this.zzr = new zzaes(-9223372036854775807L, 0);
            this.zzp.zzO(this.zzr);
            this.zzl = true;
            return zza2;
        }
        throw zzch.zza("Could not find AMR header.", (Throwable) null);
    }

    public final /* synthetic */ List zzc() {
        return zzgbc.zzm();
    }

    public final void zzd(zzadx zzadx) {
        this.zzp = zzadx;
        this.zzq = zzadx.zzw(0, 1);
        zzadx.zzD();
    }

    public final void zze(long j, long j2) {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0;
    }

    public final boolean zzf(zzadv zzadv) throws IOException {
        return zzh(zzadv);
    }

    @RequiresNonNull({"trackOutput"})
    private final int zza(zzadv zzadv) throws IOException {
        int i = this.zzk;
        if (i == 0) {
            try {
                zzadv.zzj();
                ((zzadi) zzadv).zzm(this.zzg, 0, 1, false);
                byte b = this.zzg[0];
                if ((b & 131) <= 0) {
                    boolean z = this.zzh;
                    int i2 = (b >> 3) & 15;
                    if (!z || (i2 >= 10 && i2 <= 13)) {
                        if (!z) {
                            if (i2 >= 12 && i2 <= 14) {
                            }
                        }
                        String str = "WB";
                        if (true != z) {
                            str = "NB";
                        }
                        throw zzch.zza("Illegal AMR " + str + " frame type " + i2, (Throwable) null);
                    }
                    i = z ? zzc[i2] : zzb[i2];
                    this.zzj = i;
                    this.zzk = i;
                    int i3 = this.zzm;
                    if (i3 == -1) {
                        this.zzm = i;
                        i3 = i;
                    }
                    if (i3 == i) {
                        this.zzn++;
                    }
                } else {
                    throw zzch.zza("Invalid padding bits for frame header " + b, (Throwable) null);
                }
            } catch (EOFException e) {
                return -1;
            }
        }
        int zza2 = zzaey.zza(this.zzq, zzadv, i, true);
        if (zza2 == -1) {
            return -1;
        }
        int i4 = this.zzk - zza2;
        this.zzk = i4;
        if (i4 > 0) {
            return 0;
        }
        this.zzq.zzs(this.zzi, 1, this.zzj, 0, (zzaez) null);
        this.zzi += 20000;
        return 0;
    }
}
