package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzapj implements zzapb {
    final /* synthetic */ zzapk zza;
    private final zzft zzb = new zzft(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzapj(zzapk zzapk, int i) {
        this.zza = zzapk;
        this.zze = i;
    }

    public final void zza(zzfu zzfu) {
        zzgb zzgb;
        zzgb zzgb2;
        zzgb zzgb3;
        int i;
        zzfu zzfu2 = zzfu;
        if (zzfu.zzm() == 2) {
            zzgb zzgb4 = (zzgb) this.zza.zzb.get(0);
            if ((zzfu.zzm() & 128) != 0) {
                zzfu2.zzL(1);
                int zzq = zzfu.zzq();
                int i2 = 3;
                zzfu2.zzL(3);
                zzfu2.zzF(this.zzb, 2);
                this.zzb.zzm(3);
                int i3 = 13;
                this.zza.zzr = this.zzb.zzd(13);
                zzfu2.zzF(this.zzb, 2);
                int i4 = 4;
                this.zzb.zzm(4);
                int i5 = 12;
                zzfu2.zzL(this.zzb.zzd(12));
                this.zzc.clear();
                this.zzd.clear();
                int zzb2 = zzfu.zzb();
                while (zzb2 > 0) {
                    int i6 = 5;
                    zzfu2.zzF(this.zzb, 5);
                    zzft zzft = this.zzb;
                    zzft zzft2 = this.zzb;
                    int zzd2 = zzft.zzd(8);
                    zzft2.zzm(i2);
                    int zzd3 = this.zzb.zzd(i3);
                    this.zzb.zzm(i4);
                    int zzd4 = this.zzb.zzd(i5);
                    int zzd5 = zzfu.zzd();
                    int i7 = zzd5 + zzd4;
                    int i8 = 0;
                    String str = null;
                    ArrayList arrayList = null;
                    int i9 = -1;
                    while (true) {
                        if (zzfu.zzd() >= i7) {
                            zzgb2 = zzgb4;
                            break;
                        }
                        int zzm = zzfu.zzm();
                        int zzd6 = zzfu.zzd() + zzfu.zzm();
                        if (zzd6 > i7) {
                            zzgb2 = zzgb4;
                            break;
                        }
                        if (zzm == i6) {
                            long zzu = zzfu.zzu();
                            if (zzu == 1094921523) {
                                zzgb3 = zzgb4;
                                i9 = 129;
                            } else if (zzu != 1161904947) {
                                if (zzu == 1094921524) {
                                    zzgb3 = zzgb4;
                                    i9 = 172;
                                } else if (zzu == 1212503619) {
                                    zzgb3 = zzgb4;
                                    i9 = 36;
                                } else {
                                    zzgb3 = zzgb4;
                                }
                            }
                            zzfu2.zzL(zzd6 - zzfu.zzd());
                            zzgb4 = zzgb3;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        } else {
                            if (zzm == 106) {
                                zzgb3 = zzgb4;
                                i9 = 129;
                            } else if (zzm != 122) {
                                if (zzm == 127) {
                                    int zzm2 = zzfu.zzm();
                                    if (zzm2 == 21) {
                                        zzgb3 = zzgb4;
                                        i9 = 172;
                                    } else if (zzm2 == 14) {
                                        i = 136;
                                    } else if (zzm2 == 33) {
                                        i = 139;
                                    } else {
                                        zzgb3 = zzgb4;
                                    }
                                } else if (zzm == 123) {
                                    i = 138;
                                } else if (zzm == 10) {
                                    String trim = zzfu2.zzA(i2, zzfxs.zzc).trim();
                                    i8 = zzfu.zzm();
                                    zzgb3 = zzgb4;
                                    str = trim;
                                } else if (zzm == 89) {
                                    ArrayList arrayList2 = new ArrayList();
                                    while (zzfu.zzd() < zzd6) {
                                        String trim2 = zzfu2.zzA(i2, zzfxs.zzc).trim();
                                        int zzm3 = zzfu.zzm();
                                        zzgb zzgb5 = zzgb4;
                                        byte[] bArr = new byte[i4];
                                        zzfu2.zzG(bArr, 0, i4);
                                        arrayList2.add(new zzapl(trim2, zzm3, bArr));
                                        zzgb4 = zzgb5;
                                        i2 = 3;
                                        i4 = 4;
                                    }
                                    zzgb3 = zzgb4;
                                    arrayList = arrayList2;
                                    i9 = 89;
                                } else {
                                    zzgb3 = zzgb4;
                                    if (zzm == 111) {
                                        i9 = 257;
                                    }
                                }
                                zzgb3 = zzgb4;
                                i9 = i;
                            }
                            zzfu2.zzL(zzd6 - zzfu.zzd());
                            zzgb4 = zzgb3;
                            i2 = 3;
                            i4 = 4;
                            i6 = 5;
                        }
                        zzgb3 = zzgb4;
                        i9 = 135;
                        zzfu2.zzL(zzd6 - zzfu.zzd());
                        zzgb4 = zzgb3;
                        i2 = 3;
                        i4 = 4;
                        i6 = 5;
                    }
                    zzfu2.zzK(i7);
                    zzapm zzapm = new zzapm(i9, str, i8, arrayList, Arrays.copyOfRange(zzfu.zzM(), zzd5, i7));
                    if (zzd2 == 6 || zzd2 == 5) {
                        zzd2 = zzapm.zza;
                    }
                    zzb2 -= zzd4 + 5;
                    if (!this.zza.zzh.get(zzd3)) {
                        zzapp zza2 = this.zza.zze.zza(zzd2, zzapm);
                        this.zzd.put(zzd3, zzd3);
                        this.zzc.put(zzd3, zza2);
                    }
                    zzgb4 = zzgb2;
                    i2 = 3;
                    i4 = 4;
                    i5 = 12;
                    i3 = 13;
                }
                zzgb zzgb6 = zzgb4;
                int size = this.zzd.size();
                int i10 = 0;
                while (i10 < size) {
                    SparseIntArray sparseIntArray = this.zzd;
                    SparseIntArray sparseIntArray2 = this.zzd;
                    zzapk zzapk = this.zza;
                    int keyAt = sparseIntArray.keyAt(i10);
                    int valueAt = sparseIntArray2.valueAt(i10);
                    zzapk.zzh.put(keyAt, true);
                    this.zza.zzi.put(valueAt, true);
                    zzapp zzapp = (zzapp) this.zzc.valueAt(i10);
                    if (zzapp != null) {
                        zzadx zzj = this.zza.zzl;
                        zzapo zzapo = new zzapo(zzq, keyAt, 8192);
                        zzgb = zzgb6;
                        zzapp.zzb(zzgb, zzj, zzapo);
                        this.zza.zzg.put(valueAt, zzapp);
                    } else {
                        zzgb = zzgb6;
                    }
                    i10++;
                    zzgb6 = zzgb;
                }
                this.zza.zzg.remove(this.zze);
                this.zza.zzm = 0;
                zzapk zzapk2 = this.zza;
                if (zzapk2.zzm == 0) {
                    zzapk2.zzl.zzD();
                    this.zza.zzn = true;
                }
            }
        }
    }

    public final void zzb(zzgb zzgb, zzadx zzadx, zzapo zzapo) {
    }
}
