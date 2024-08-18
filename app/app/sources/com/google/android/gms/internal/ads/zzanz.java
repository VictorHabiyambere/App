package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzanz implements zzapn {
    private final List zza;

    public zzanz() {
        this(0);
    }

    public zzanz(int i, List list) {
        this.zza = list;
    }

    private final zzapd zzb(zzapm zzapm) {
        return new zzapd(zzd(zzapm));
    }

    private final zzapr zzc(zzapm zzapm) {
        return new zzapr(zzd(zzapm));
    }

    private final List zzd(zzapm zzapm) {
        boolean z;
        String str;
        int i;
        List list;
        zzfu zzfu = new zzfu(zzapm.zze);
        List list2 = this.zza;
        while (zzfu.zzb() > 0) {
            int zzm = zzfu.zzm();
            int zzd = zzfu.zzd() + zzfu.zzm();
            if (zzm == 134) {
                list2 = new ArrayList();
                int zzm2 = zzfu.zzm() & 31;
                for (int i2 = 0; i2 < zzm2; i2++) {
                    String zzA = zzfu.zzA(3, zzfxs.zzc);
                    int zzm3 = zzfu.zzm();
                    if ((zzm3 & 128) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i = zzm3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte zzm4 = (byte) zzfu.zzm();
                    zzfu.zzL(1);
                    if (z) {
                        byte b = zzm4 & SignedBytes.MAX_POWER_OF_TWO;
                        int i3 = zzes.zza;
                        list = Collections.singletonList(b != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    zzal zzal = new zzal();
                    zzal.zzX(str);
                    zzal.zzO(zzA);
                    zzal.zzw(i);
                    zzal.zzL(list);
                    list2.add(zzal.zzad());
                }
            }
            zzfu.zzK(zzd);
        }
        return list2;
    }

    public zzanz(int i) {
        this.zza = zzgbc.zzm();
    }

    public final zzapp zza(int i, zzapm zzapm) {
        switch (i) {
            case 2:
            case 128:
                return new zzaot(new zzaoe(zzc(zzapm)));
            case 3:
            case 4:
                return new zzaot(new zzaoq(zzapm.zzb, zzapm.zza()));
            case 15:
                return new zzaot(new zzany(false, zzapm.zzb, zzapm.zza()));
            case 16:
                return new zzaot(new zzaoh(zzc(zzapm)));
            case 17:
                return new zzaot(new zzaop(zzapm.zzb, zzapm.zza()));
            case 21:
                return new zzaot(new zzaoo());
            case 27:
                return new zzaot(new zzaol(zzb(zzapm), false, false));
            case 36:
                return new zzaot(new zzaon(zzb(zzapm)));
            case 89:
                return new zzaot(new zzaob(zzapm.zzd));
            case 129:
            case 135:
                return new zzaot(new zzans(zzapm.zzb, zzapm.zza()));
            case 134:
                return new zzapc(new zzaos("application/x-scte35"));
            case 136:
            case 138:
                return new zzaot(new zzaoa(zzapm.zzb, zzapm.zza(), 4096));
            case 139:
                return new zzaot(new zzaoa(zzapm.zzb, zzapm.zza(), 5408));
            case 172:
                return new zzaot(new zzanv(zzapm.zzb, zzapm.zza()));
            case 257:
                return new zzapc(new zzaos("application/vnd.dvb.ait"));
            default:
                return null;
        }
    }
}
