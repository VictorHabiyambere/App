package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.compose.animation.core.AnimationKt;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzzy implements zzzu, zzie {
    public static final zzgbc zza = zzgbc.zzq(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final zzgbc zzb = zzgbc.zzq(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final zzgbc zzc;
    public static final zzgbc zzd = zzgbc.zzq(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final zzgbc zze = zzgbc.zzq(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final zzgbc zzf;
    private static zzzy zzg;
    private final zzgbf zzh;
    private final zzzs zzi = new zzzs();
    private final zzer zzj;
    private final zzaan zzk = new zzaan(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private int zzs;

    static {
        Long valueOf = Long.valueOf(AnimationKt.MillisToNanos);
        zzc = zzgbc.zzq(2000000L, 1300000L, valueOf, 860000L, 610000L);
        zzf = zzgbc.zzq(2700000L, 2000000L, 1600000L, 1300000L, valueOf);
    }

    /* synthetic */ zzzy(Context context, Map map, int i, zzer zzer, boolean z, zzzx zzzx) {
        this.zzh = zzgbf.zzc(map);
        this.zzj = zzer;
        if (context != null) {
            zzfs zzb2 = zzfs.zzb(context);
            int zza2 = zzb2.zza();
            this.zzs = zza2;
            this.zzq = zzi(zza2);
            zzb2.zzd(new zzzw(this));
            return;
        }
        this.zzs = 0;
        this.zzq = zzi(0);
    }

    private final long zzi(int i) {
        Long l = (Long) this.zzh.get(Integer.valueOf(i));
        if (l == null) {
            l = (Long) this.zzh.get(0);
        }
        if (l == null) {
            l = Long.valueOf(AnimationKt.MillisToNanos);
        }
        return l.longValue();
    }

    private final void zzj(int i, long j, long j2) {
        long j3;
        int i2;
        if (i == 0) {
            if (j != 0) {
                j3 = j;
            } else if (j2 != this.zzr) {
                j3 = 0;
            } else {
                return;
            }
            i2 = 0;
        } else {
            i2 = i;
            j3 = j;
        }
        this.zzr = j2;
        this.zzi.zzb(i2, j3, j2);
    }

    /* access modifiers changed from: private */
    public final synchronized void zzk(int i) {
        int i2;
        if (this.zzs != i) {
            this.zzs = i;
            if (!(i == 1 || i == 0 || i == 8)) {
                this.zzq = zzi(i);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.zzl > 0) {
                    i2 = (int) (elapsedRealtime - this.zzm);
                } else {
                    i2 = 0;
                }
                zzj(i2, this.zzn, this.zzq);
                this.zzm = elapsedRealtime;
                this.zzn = 0;
                this.zzp = 0;
                this.zzo = 0;
                this.zzk.zzc();
            }
        }
    }

    private static boolean zzl(zzhh zzhh, boolean z) {
        return z && !zzhh.zzb(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01a7, code lost:
        if (r2.equals("SZ") != false) goto L_0x0c0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01b1, code lost:
        if (r2.equals("SY") != false) goto L_0x0b0c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ba, code lost:
        if (r2.equals("SX") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01e0, code lost:
        if (r2.equals("SS") != false) goto L_0x07be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0214, code lost:
        if (r2.equals("SM") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x021e, code lost:
        if (r2.equals("SL") != false) goto L_0x0b52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r2.equals("YT") != false) goto L_0x041d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0236, code lost:
        if (r2.equals("SJ") != false) goto L_0x087a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0240, code lost:
        if (r2.equals("SI") != false) goto L_0x0afc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x024a, code lost:
        if (r2.equals("SH") != false) goto L_0x0bba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0262, code lost:
        if (r2.equals("SE") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x026c, code lost:
        if (r2.equals("SD") != false) goto L_0x0b0c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0276, code lost:
        if (r2.equals("SC") != false) goto L_0x0bba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x027f, code lost:
        if (r2.equals("SB") != false) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0288, code lost:
        return new int[]{4, 2, 4, 3, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r2.equals("YE") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x02f1, code lost:
        if (r2.equals("PY") != false) goto L_0x0ac0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0309, code lost:
        if (r2.equals("PT") != false) goto L_0x0afc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x032f, code lost:
        if (r2.equals("PM") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0363, code lost:
        if (r2.equals(com.google.android.gms.ads.RequestConfiguration.MAX_AD_CONTENT_RATING_PG) != false) goto L_0x0591;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (r2.equals("WS") != false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0389, code lost:
        if (r2.equals("PA") != false) goto L_0x0bd8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03af, code lost:
        if (r2.equals("NU") != false) goto L_0x0bba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (r2.equals("WF") != false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x03b9, code lost:
        if (r2.equals("NR") != false) goto L_0x097c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x03ed, code lost:
        if (r2.equals("NI") != false) goto L_0x098c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r2.equals("VU") != false) goto L_0x0629;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0405, code lost:
        if (r2.equals("NF") != false) goto L_0x087a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x040f, code lost:
        if (r2.equals("NE") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0419, code lost:
        if (r2.equals("NC") != false) goto L_0x041d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x0422, code lost:
        return new int[]{2, 3, 3, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0437, code lost:
        if (r2.equals("MZ") != false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0440, code lost:
        return new int[]{3, 1, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x048d, code lost:
        if (r2.equals("MT") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0497, code lost:
        if (r2.equals("MS") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x04a1, code lost:
        if (r2.equals("MR") != false) goto L_0x09b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x04b9, code lost:
        if (r2.equals("MP") != false) goto L_0x0ac0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x04df, code lost:
        if (r2.equals("MM") != false) goto L_0x05ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x04e9, code lost:
        if (r2.equals("ML") != false) goto L_0x0a17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0501, code lost:
        if (r2.equals("MH") != false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x050a, code lost:
        return new int[]{4, 2, 2, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x0511, code lost:
        if (r2.equals("MG") != false) goto L_0x09f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:343:0x0545, code lost:
        if (r2.equals("MC") != false) goto L_0x07ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x055d, code lost:
        if (r2.equals("LY") != false) goto L_0x0b52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x0567, code lost:
        if (r2.equals("LV") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x058d, code lost:
        if (r2.equals("LS") != false) goto L_0x0591;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x0596, code lost:
        return new int[]{4, 3, 3, 3, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x059d, code lost:
        if (r2.equals("LR") != false) goto L_0x08fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x05a7, code lost:
        if (r2.equals("LK") != false) goto L_0x05ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x05b0, code lost:
        return new int[]{3, 2, 3, 3, 4, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05b7, code lost:
        if (r2.equals("LI") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:389:0x05f9, code lost:
        if (r2.equals("KY") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x0603, code lost:
        if (r2.equals("KW") != false) goto L_0x0734;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x061b, code lost:
        if (r2.equals("KN") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x0625, code lost:
        if (r2.equals("KM") != false) goto L_0x0629;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a0, code lost:
        if (r2.equals("VE") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (r2.equals("ZW") != false) goto L_0x0283;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x062e, code lost:
        return new int[]{4, 3, 3, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x0635, code lost:
        if (r2.equals("KI") != false) goto L_0x097c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a9, code lost:
        if (r2.equals("VC") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0677, code lost:
        if (r2.equals("JO") != false) goto L_0x0b42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:427:0x068f, code lost:
        if (r2.equals("JE") != false) goto L_0x07de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:433:0x06a7, code lost:
        if (r2.equals("IS") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b3, code lost:
        if (r2.equals("VA") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:451:0x06e9, code lost:
        if (r2.equals("IM") != false) goto L_0x07de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:465:0x071c, code lost:
        if (r2.equals("HU") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:467:0x0726, code lost:
        if (r2.equals("HT") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x0730, code lost:
        if (r2.equals("HR") != false) goto L_0x0734;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:471:0x0739, code lost:
        return new int[]{1, 0, 0, 0, 0, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:497:0x0794, code lost:
        if (r2.equals("GQ") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x07ba, code lost:
        if (r2.equals("GM") != false) goto L_0x07be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:509:0x07c3, code lost:
        return new int[]{4, 3, 2, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x07ca, code lost:
        if (r2.equals("GL") != false) goto L_0x07ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:513:0x07d3, code lost:
        return new int[]{1, 2, 2, 0, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x07da, code lost:
        if (r2.equals("GI") != false) goto L_0x07de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:517:0x07e3, code lost:
        return new int[]{0, 2, 0, 1, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:559:0x0876, code lost:
        if (r2.equals("FK") != false) goto L_0x087a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:561:0x087f, code lost:
        return new int[]{3, 2, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:579:0x08be, code lost:
        if (r2.equals("ER") != false) goto L_0x0bba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:581:0x08c8, code lost:
        if (r2.equals("EG") != false) goto L_0x09f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:583:0x08d2, code lost:
        if (r2.equals("EE") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:589:0x08ea, code lost:
        if (r2.equals("DZ") != false) goto L_0x08ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:591:0x08f3, code lost:
        return new int[]{3, 3, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:593:0x08fa, code lost:
        if (r2.equals("DO") != false) goto L_0x08fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:595:0x0903, code lost:
        return new int[]{3, 4, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:597:0x090a, code lost:
        if (r2.equals("DM") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:603:0x0922, code lost:
        if (r2.equals("DJ") != false) goto L_0x0b52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:617:0x0956, code lost:
        if (r2.equals("CX") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:619:0x0960, code lost:
        if (r2.equals("CW") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f5, code lost:
        if (r2.equals("UA") != false) goto L_0x0a27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:625:0x0978, code lost:
        if (r2.equals("CU") != false) goto L_0x097c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:627:0x0981, code lost:
        return new int[]{4, 2, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:629:0x0988, code lost:
        if (r2.equals("CR") != false) goto L_0x098c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:631:0x0991, code lost:
        return new int[]{2, 4, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:641:0x09b4, code lost:
        if (r2.equals("CM") != false) goto L_0x09b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:643:0x09bd, code lost:
        return new int[]{4, 3, 3, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:645:0x09c4, code lost:
        if (r2.equals("CL") != false) goto L_0x09c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:647:0x09cd, code lost:
        return new int[]{0, 1, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:649:0x09d4, code lost:
        if (r2.equals("CK") != false) goto L_0x0a36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:651:0x09dd, code lost:
        if (r2.equals("CI") != false) goto L_0x0bff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:657:0x09f5, code lost:
        if (r2.equals("CG") != false) goto L_0x09f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:659:0x09fe, code lost:
        return new int[]{3, 4, 3, 3, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:665:0x0a13, code lost:
        if (r2.equals("CD") != false) goto L_0x0a17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:667:0x0a1c, code lost:
        return new int[]{3, 3, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:669:0x0a23, code lost:
        if (r2.equals("CA") != false) goto L_0x0a27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:671:0x0a2c, code lost:
        return new int[]{0, 2, 1, 2, 3, 3};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:673:0x0a33, code lost:
        if (r2.equals("BZ") != false) goto L_0x0a36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:675:0x0a3b, code lost:
        return new int[]{2, 2, 2, 1, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:697:0x0a88, code lost:
        if (r2.equals("BQ") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:711:0x0abc, code lost:
        if (r2.equals("BL") != false) goto L_0x0ac0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:713:0x0ac5, code lost:
        return new int[]{1, 2, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:719:0x0ada, code lost:
        if (r2.equals("BI") != false) goto L_0x0ade;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        if (r2.equals("TV") != false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:721:0x0ae3, code lost:
        return new int[]{4, 4, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:727:0x0af8, code lost:
        if (r2.equals("BG") != false) goto L_0x0afc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:729:0x0b01, code lost:
        return new int[]{0, 0, 0, 0, 1, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:731:0x0b08, code lost:
        if (r2.equals("BF") != false) goto L_0x0b0c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:733:0x0b11, code lost:
        return new int[]{4, 3, 4, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:743:0x0b34, code lost:
        if (r2.equals("BB") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:745:0x0b3e, code lost:
        if (r2.equals("BA") != false) goto L_0x0b42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:747:0x0b47, code lost:
        return new int[]{1, 1, 1, 1, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:749:0x0b4e, code lost:
        if (r2.equals("AZ") != false) goto L_0x0b52;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:751:0x0b57, code lost:
        return new int[]{4, 2, 3, 3, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:753:0x0b5e, code lost:
        if (r2.equals("AX") != false) goto L_0x0b62;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:755:0x0b67, code lost:
        return new int[]{0, 2, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:765:0x0b8a, code lost:
        if (r2.equals("AT") != false) goto L_0x0b8e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:767:0x0b93, code lost:
        return new int[]{0, 0, 0, 0, 0, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:777:0x0bb6, code lost:
        if (r2.equals("AQ") != false) goto L_0x0bba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:779:0x0bbf, code lost:
        return new int[]{4, 2, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        if (r2.equals("TR") != false) goto L_0x0b42;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:785:0x0bd4, code lost:
        if (r2.equals("AM") != false) goto L_0x0bd8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:787:0x0bdd, code lost:
        return new int[]{2, 3, 2, 3, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:793:0x0bf2, code lost:
        if (r2.equals("AI") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:795:0x0bfb, code lost:
        if (r2.equals("AG") != false) goto L_0x0bff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:797:0x0c04, code lost:
        return new int[]{2, 4, 3, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:799:0x0c0b, code lost:
        if (r2.equals("AF") != false) goto L_0x0c0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:801:0x0c14, code lost:
        return new int[]{4, 4, 3, 4, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:807:0x0c29, code lost:
        if (r2.equals("AD") != false) goto L_0x0c2b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:809:0x0c30, code lost:
        return new int[]{1, 2, 0, 0, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:811:0x0c36, code lost:
        return new int[]{2, 2, 2, 2, 2, 2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0159, code lost:
        if (r2.equals("TM") != false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0163, code lost:
        if (r2.equals("TL") != false) goto L_0x097c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x016d, code lost:
        if (r2.equals("TJ") != false) goto L_0x08ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0177, code lost:
        if (r2.equals("TH") != false) goto L_0x09c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x018f, code lost:
        if (r2.equals("TD") != false) goto L_0x0b0c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int[] zzm(java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            r1 = 6
            switch(r0) {
                case 2083: goto L_0x0c23;
                case 2084: goto L_0x0c15;
                case 2085: goto L_0x0c05;
                case 2086: goto L_0x0bf5;
                case 2088: goto L_0x0bec;
                case 2091: goto L_0x0bde;
                case 2092: goto L_0x0bce;
                case 2094: goto L_0x0bc0;
                case 2096: goto L_0x0bb0;
                case 2097: goto L_0x0ba2;
                case 2098: goto L_0x0b94;
                case 2099: goto L_0x0b84;
                case 2100: goto L_0x0b76;
                case 2102: goto L_0x0b68;
                case 2103: goto L_0x0b58;
                case 2105: goto L_0x0b48;
                case 2111: goto L_0x0b38;
                case 2112: goto L_0x0b2e;
                case 2114: goto L_0x0b20;
                case 2115: goto L_0x0b12;
                case 2116: goto L_0x0b02;
                case 2117: goto L_0x0af2;
                case 2118: goto L_0x0ae4;
                case 2119: goto L_0x0ad4;
                case 2120: goto L_0x0ac6;
                case 2122: goto L_0x0ab6;
                case 2123: goto L_0x0aa8;
                case 2124: goto L_0x0a9a;
                case 2125: goto L_0x0a8c;
                case 2127: goto L_0x0a82;
                case 2128: goto L_0x0a74;
                case 2129: goto L_0x0a66;
                case 2130: goto L_0x0a58;
                case 2133: goto L_0x0a4a;
                case 2135: goto L_0x0a3c;
                case 2136: goto L_0x0a2d;
                case 2142: goto L_0x0a1d;
                case 2145: goto L_0x0a0d;
                case 2147: goto L_0x09ff;
                case 2148: goto L_0x09ef;
                case 2149: goto L_0x09e1;
                case 2150: goto L_0x09d7;
                case 2152: goto L_0x09ce;
                case 2153: goto L_0x09be;
                case 2154: goto L_0x09ae;
                case 2155: goto L_0x09a0;
                case 2156: goto L_0x0992;
                case 2159: goto L_0x0982;
                case 2162: goto L_0x0972;
                case 2163: goto L_0x0964;
                case 2164: goto L_0x095a;
                case 2165: goto L_0x0950;
                case 2166: goto L_0x0942;
                case 2167: goto L_0x0934;
                case 2177: goto L_0x0926;
                case 2182: goto L_0x091c;
                case 2183: goto L_0x090e;
                case 2185: goto L_0x0904;
                case 2187: goto L_0x08f4;
                case 2198: goto L_0x08e4;
                case 2206: goto L_0x08d6;
                case 2208: goto L_0x08cc;
                case 2210: goto L_0x08c2;
                case 2221: goto L_0x08b8;
                case 2222: goto L_0x08aa;
                case 2223: goto L_0x089c;
                case 2243: goto L_0x088e;
                case 2244: goto L_0x0880;
                case 2245: goto L_0x0870;
                case 2247: goto L_0x0862;
                case 2249: goto L_0x0854;
                case 2252: goto L_0x0846;
                case 2266: goto L_0x0838;
                case 2267: goto L_0x082a;
                case 2269: goto L_0x081c;
                case 2270: goto L_0x080e;
                case 2271: goto L_0x0800;
                case 2272: goto L_0x07f2;
                case 2273: goto L_0x07e4;
                case 2274: goto L_0x07d4;
                case 2277: goto L_0x07c4;
                case 2278: goto L_0x07b4;
                case 2279: goto L_0x07a6;
                case 2281: goto L_0x0798;
                case 2282: goto L_0x078e;
                case 2283: goto L_0x0780;
                case 2285: goto L_0x0772;
                case 2286: goto L_0x0764;
                case 2288: goto L_0x0756;
                case 2290: goto L_0x0748;
                case 2307: goto L_0x073a;
                case 2314: goto L_0x072a;
                case 2316: goto L_0x0720;
                case 2317: goto L_0x0716;
                case 2331: goto L_0x0708;
                case 2332: goto L_0x06fa;
                case 2339: goto L_0x06ec;
                case 2340: goto L_0x06e3;
                case 2341: goto L_0x06d5;
                case 2342: goto L_0x06c7;
                case 2344: goto L_0x06b9;
                case 2345: goto L_0x06ab;
                case 2346: goto L_0x06a1;
                case 2347: goto L_0x0693;
                case 2363: goto L_0x0689;
                case 2371: goto L_0x067b;
                case 2373: goto L_0x0671;
                case 2374: goto L_0x0663;
                case 2394: goto L_0x0655;
                case 2396: goto L_0x0647;
                case 2397: goto L_0x0639;
                case 2398: goto L_0x062f;
                case 2402: goto L_0x061f;
                case 2403: goto L_0x0615;
                case 2407: goto L_0x0607;
                case 2412: goto L_0x05fd;
                case 2414: goto L_0x05f3;
                case 2415: goto L_0x05e5;
                case 2421: goto L_0x05d7;
                case 2422: goto L_0x05c9;
                case 2423: goto L_0x05bb;
                case 2429: goto L_0x05b1;
                case 2431: goto L_0x05a1;
                case 2438: goto L_0x0597;
                case 2439: goto L_0x0587;
                case 2440: goto L_0x0579;
                case 2441: goto L_0x056b;
                case 2442: goto L_0x0561;
                case 2445: goto L_0x0557;
                case 2452: goto L_0x0549;
                case 2454: goto L_0x053f;
                case 2455: goto L_0x0531;
                case 2456: goto L_0x0523;
                case 2457: goto L_0x0515;
                case 2458: goto L_0x050b;
                case 2459: goto L_0x04fb;
                case 2462: goto L_0x04ed;
                case 2463: goto L_0x04e3;
                case 2464: goto L_0x04d9;
                case 2465: goto L_0x04cb;
                case 2466: goto L_0x04bd;
                case 2467: goto L_0x04b3;
                case 2468: goto L_0x04a5;
                case 2469: goto L_0x049b;
                case 2470: goto L_0x0491;
                case 2471: goto L_0x0487;
                case 2472: goto L_0x0479;
                case 2473: goto L_0x046b;
                case 2474: goto L_0x045d;
                case 2475: goto L_0x044f;
                case 2476: goto L_0x0441;
                case 2477: goto L_0x0431;
                case 2483: goto L_0x0423;
                case 2485: goto L_0x0413;
                case 2487: goto L_0x0409;
                case 2488: goto L_0x03ff;
                case 2489: goto L_0x03f1;
                case 2491: goto L_0x03e7;
                case 2494: goto L_0x03d9;
                case 2497: goto L_0x03cb;
                case 2498: goto L_0x03bd;
                case 2500: goto L_0x03b3;
                case 2503: goto L_0x03a9;
                case 2508: goto L_0x039b;
                case 2526: goto L_0x038d;
                case 2545: goto L_0x0383;
                case 2549: goto L_0x0375;
                case 2550: goto L_0x0367;
                case 2551: goto L_0x035d;
                case 2552: goto L_0x034f;
                case 2555: goto L_0x0341;
                case 2556: goto L_0x0333;
                case 2557: goto L_0x0329;
                case 2562: goto L_0x031b;
                case 2563: goto L_0x030d;
                case 2564: goto L_0x0303;
                case 2567: goto L_0x02f5;
                case 2569: goto L_0x02eb;
                case 2576: goto L_0x02dd;
                case 2611: goto L_0x02cf;
                case 2621: goto L_0x02c1;
                case 2625: goto L_0x02b3;
                case 2627: goto L_0x02a5;
                case 2629: goto L_0x0297;
                case 2638: goto L_0x0289;
                case 2639: goto L_0x0279;
                case 2640: goto L_0x0270;
                case 2641: goto L_0x0266;
                case 2642: goto L_0x025c;
                case 2644: goto L_0x024e;
                case 2645: goto L_0x0244;
                case 2646: goto L_0x023a;
                case 2647: goto L_0x0230;
                case 2648: goto L_0x0222;
                case 2649: goto L_0x0218;
                case 2650: goto L_0x020e;
                case 2651: goto L_0x0200;
                case 2652: goto L_0x01f2;
                case 2655: goto L_0x01e4;
                case 2656: goto L_0x01da;
                case 2657: goto L_0x01cc;
                case 2659: goto L_0x01be;
                case 2661: goto L_0x01b4;
                case 2662: goto L_0x01ab;
                case 2663: goto L_0x01a1;
                case 2671: goto L_0x0193;
                case 2672: goto L_0x0189;
                case 2675: goto L_0x017b;
                case 2676: goto L_0x0171;
                case 2678: goto L_0x0167;
                case 2680: goto L_0x015d;
                case 2681: goto L_0x0153;
                case 2682: goto L_0x0145;
                case 2683: goto L_0x0137;
                case 2686: goto L_0x012d;
                case 2688: goto L_0x011f;
                case 2690: goto L_0x0115;
                case 2691: goto L_0x0107;
                case 2694: goto L_0x00f9;
                case 2700: goto L_0x00ef;
                case 2706: goto L_0x00e1;
                case 2718: goto L_0x00d3;
                case 2724: goto L_0x00c5;
                case 2725: goto L_0x00b7;
                case 2731: goto L_0x00ad;
                case 2733: goto L_0x00a3;
                case 2735: goto L_0x009a;
                case 2737: goto L_0x008c;
                case 2739: goto L_0x007e;
                case 2744: goto L_0x0070;
                case 2751: goto L_0x0066;
                case 2767: goto L_0x005c;
                case 2780: goto L_0x0052;
                case 2803: goto L_0x0044;
                case 2828: goto L_0x003a;
                case 2843: goto L_0x0030;
                case 2855: goto L_0x0022;
                case 2867: goto L_0x0014;
                case 2877: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0c31
        L_0x000a:
            java.lang.String r0 = "ZW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0012:
            goto L_0x0283
        L_0x0014:
            java.lang.String r0 = "ZM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 4, 4, 3, 2, 2} // fill-array
            return r2
        L_0x0022:
            java.lang.String r0 = "ZA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 4, 2, 1, 1, 2} // fill-array
            return r2
        L_0x0030:
            java.lang.String r0 = "YT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0038:
            goto L_0x041d
        L_0x003a:
            java.lang.String r0 = "YE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0042:
            goto L_0x0ade
        L_0x0044:
            java.lang.String r0 = "XK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0052:
            java.lang.String r0 = "WS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x005a:
            goto L_0x043b
        L_0x005c:
            java.lang.String r0 = "WF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0064:
            goto L_0x0505
        L_0x0066:
            java.lang.String r0 = "VU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x006e:
            goto L_0x0629
        L_0x0070:
            java.lang.String r0 = "VN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 1, 2, 2, 2} // fill-array
            return r2
        L_0x007e:
            java.lang.String r0 = "VI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 1, 2, 2, 2} // fill-array
            return r2
        L_0x008c:
            java.lang.String r0 = "VG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 1, 1, 2, 4} // fill-array
            return r2
        L_0x009a:
            java.lang.String r0 = "VE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0042
        L_0x00a3:
            java.lang.String r0 = "VC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x00ad:
            java.lang.String r0 = "VA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x00b5:
            goto L_0x0b62
        L_0x00b7:
            java.lang.String r0 = "UZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 3, 4, 3, 2} // fill-array
            return r2
        L_0x00c5:
            java.lang.String r0 = "UY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 1, 2, 1, 2} // fill-array
            return r2
        L_0x00d3:
            java.lang.String r0 = "US"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 4, 1, 3, 1} // fill-array
            return r2
        L_0x00e1:
            java.lang.String r0 = "UG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 3, 2, 3, 4, 2} // fill-array
            return r2
        L_0x00ef:
            java.lang.String r0 = "UA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x00f7:
            goto L_0x0a27
        L_0x00f9:
            java.lang.String r0 = "TZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 2, 1, 3, 2} // fill-array
            return r2
        L_0x0107:
            java.lang.String r0 = "TW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 0, 0, 0, 0} // fill-array
            return r2
        L_0x0115:
            java.lang.String r0 = "TV"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0064
        L_0x011f:
            java.lang.String r0 = "TT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 4, 1, 0, 2, 2} // fill-array
            return r2
        L_0x012d:
            java.lang.String r0 = "TR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0135:
            goto L_0x0b42
        L_0x0137:
            java.lang.String r0 = "TO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 4, 3, 2, 2} // fill-array
            return r2
        L_0x0145:
            java.lang.String r0 = "TN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0153:
            java.lang.String r0 = "TM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0064
        L_0x015d:
            java.lang.String r0 = "TL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0165:
            goto L_0x097c
        L_0x0167:
            java.lang.String r0 = "TJ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x016f:
            goto L_0x08ee
        L_0x0171:
            java.lang.String r0 = "TH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0179:
            goto L_0x09c8
        L_0x017b:
            java.lang.String r0 = "TG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 1, 0, 2, 2} // fill-array
            return r2
        L_0x0189:
            java.lang.String r0 = "TD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0191:
            goto L_0x0b0c
        L_0x0193:
            java.lang.String r0 = "TC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 1, 2, 2, 2} // fill-array
            return r2
        L_0x01a1:
            java.lang.String r0 = "SZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x01a9:
            goto L_0x0c0f
        L_0x01ab:
            java.lang.String r0 = "SY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0191
        L_0x01b4:
            java.lang.String r0 = "SX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x01be:
            java.lang.String r0 = "SV"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 3, 2, 1, 2, 2} // fill-array
            return r2
        L_0x01cc:
            java.lang.String r0 = "ST"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 1, 2, 2, 2} // fill-array
            return r2
        L_0x01da:
            java.lang.String r0 = "SS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x01e2:
            goto L_0x07be
        L_0x01e4:
            java.lang.String r0 = "SR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 4, 4, 1, 2, 2} // fill-array
            return r2
        L_0x01f2:
            java.lang.String r0 = "SO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 3, 4, 4, 2} // fill-array
            return r2
        L_0x0200:
            java.lang.String r0 = "SN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 4, 3, 2, 2, 2} // fill-array
            return r2
        L_0x020e:
            java.lang.String r0 = "SM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x0218:
            java.lang.String r0 = "SL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0220:
            goto L_0x0b52
        L_0x0222:
            java.lang.String r0 = "SK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0230:
            java.lang.String r0 = "SJ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0238:
            goto L_0x087a
        L_0x023a:
            java.lang.String r0 = "SI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0242:
            goto L_0x0afc
        L_0x0244:
            java.lang.String r0 = "SH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x024c:
            goto L_0x0bba
        L_0x024e:
            java.lang.String r0 = "SG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 3, 3, 3, 1, 1} // fill-array
            return r2
        L_0x025c:
            java.lang.String r0 = "SE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0264:
            goto L_0x0b8e
        L_0x0266:
            java.lang.String r0 = "SD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0191
        L_0x0270:
            java.lang.String r0 = "SC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x024c
        L_0x0279:
            java.lang.String r0 = "SB"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0012
        L_0x0283:
            int[] r2 = new int[r1]
            r2 = {4, 2, 4, 3, 2, 2} // fill-array
            return r2
        L_0x0289:
            java.lang.String r0 = "SA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 1, 2, 2, 0} // fill-array
            return r2
        L_0x0297:
            java.lang.String r0 = "RW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 3, 2, 0, 2, 2} // fill-array
            return r2
        L_0x02a5:
            java.lang.String r0 = "RU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 1, 3, 3} // fill-array
            return r2
        L_0x02b3:
            java.lang.String r0 = "RS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 1, 2, 2} // fill-array
            return r2
        L_0x02c1:
            java.lang.String r0 = "RO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 1, 1, 3, 2} // fill-array
            return r2
        L_0x02cf:
            java.lang.String r0 = "RE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 3, 2, 3, 1, 2} // fill-array
            return r2
        L_0x02dd:
            java.lang.String r0 = "QA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 4, 4, 4, 4, 2} // fill-array
            return r2
        L_0x02eb:
            java.lang.String r0 = "PY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x02f3:
            goto L_0x0ac0
        L_0x02f5:
            java.lang.String r0 = "PW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 4, 1, 2, 2} // fill-array
            return r2
        L_0x0303:
            java.lang.String r0 = "PT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0242
        L_0x030d:
            java.lang.String r0 = "PS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 1, 3, 2, 2} // fill-array
            return r2
        L_0x031b:
            java.lang.String r0 = "PR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 0, 2, 1, 2, 0} // fill-array
            return r2
        L_0x0329:
            java.lang.String r0 = "PM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x0333:
            java.lang.String r0 = "PL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 2, 2, 4, 4} // fill-array
            return r2
        L_0x0341:
            java.lang.String r0 = "PK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 3, 3, 3, 2, 2} // fill-array
            return r2
        L_0x034f:
            java.lang.String r0 = "PH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 2, 3, 2, 1} // fill-array
            return r2
        L_0x035d:
            java.lang.String r0 = "PG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0365:
            goto L_0x0591
        L_0x0367:
            java.lang.String r0 = "PF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 3, 1, 2, 2} // fill-array
            return r2
        L_0x0375:
            java.lang.String r0 = "PE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 4, 4, 3, 2} // fill-array
            return r2
        L_0x0383:
            java.lang.String r0 = "PA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x038b:
            goto L_0x0bd8
        L_0x038d:
            java.lang.String r0 = "OM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 3, 1, 2, 4, 2} // fill-array
            return r2
        L_0x039b:
            java.lang.String r0 = "NZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 1, 2, 4, 2} // fill-array
            return r2
        L_0x03a9:
            java.lang.String r0 = "NU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x024c
        L_0x03b3:
            java.lang.String r0 = "NR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0165
        L_0x03bd:
            java.lang.String r0 = "NP"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 4, 3, 2, 2} // fill-array
            return r2
        L_0x03cb:
            java.lang.String r0 = "NO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 3, 0, 0, 2} // fill-array
            return r2
        L_0x03d9:
            java.lang.String r0 = "NL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 4, 3, 0, 4} // fill-array
            return r2
        L_0x03e7:
            java.lang.String r0 = "NI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x03ef:
            goto L_0x098c
        L_0x03f1:
            java.lang.String r0 = "NG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 2, 1, 2, 2} // fill-array
            return r2
        L_0x03ff:
            java.lang.String r0 = "NF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0238
        L_0x0409:
            java.lang.String r0 = "NE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0042
        L_0x0413:
            java.lang.String r0 = "NC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0038
        L_0x041d:
            int[] r2 = new int[r1]
            r2 = {2, 3, 3, 4, 2, 2} // fill-array
            return r2
        L_0x0423:
            java.lang.String r0 = "NA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 3, 2, 2, 2} // fill-array
            return r2
        L_0x0431:
            java.lang.String r0 = "MZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x005a
        L_0x043b:
            int[] r2 = new int[r1]
            r2 = {3, 1, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0441:
            java.lang.String r0 = "MY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 4, 1, 1, 0} // fill-array
            return r2
        L_0x044f:
            java.lang.String r0 = "MX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 4, 4, 4, 3, 2} // fill-array
            return r2
        L_0x045d:
            java.lang.String r0 = "MW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 2, 1, 2, 2} // fill-array
            return r2
        L_0x046b:
            java.lang.String r0 = "MV"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 1, 3, 4, 2} // fill-array
            return r2
        L_0x0479:
            java.lang.String r0 = "MU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 0, 2, 2, 2} // fill-array
            return r2
        L_0x0487:
            java.lang.String r0 = "MT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x0491:
            java.lang.String r0 = "MS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x049b:
            java.lang.String r0 = "MR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x04a3:
            goto L_0x09b8
        L_0x04a5:
            java.lang.String r0 = "MQ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 2, 3, 2, 2} // fill-array
            return r2
        L_0x04b3:
            java.lang.String r0 = "MP"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x02f3
        L_0x04bd:
            java.lang.String r0 = "MO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 4, 4, 3, 1} // fill-array
            return r2
        L_0x04cb:
            java.lang.String r0 = "MN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 0, 2, 2, 2, 2} // fill-array
            return r2
        L_0x04d9:
            java.lang.String r0 = "MM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x04e1:
            goto L_0x05ab
        L_0x04e3:
            java.lang.String r0 = "ML"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x04eb:
            goto L_0x0a17
        L_0x04ed:
            java.lang.String r0 = "MK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 1, 3, 2} // fill-array
            return r2
        L_0x04fb:
            java.lang.String r0 = "MH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0064
        L_0x0505:
            int[] r2 = new int[r1]
            r2 = {4, 2, 2, 4, 2, 2} // fill-array
            return r2
        L_0x050b:
            java.lang.String r0 = "MG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0513:
            goto L_0x09f9
        L_0x0515:
            java.lang.String r0 = "MF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 2, 3, 2, 2} // fill-array
            return r2
        L_0x0523:
            java.lang.String r0 = "ME"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 0, 0, 1, 3, 2} // fill-array
            return r2
        L_0x0531:
            java.lang.String r0 = "MD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 0, 2, 2} // fill-array
            return r2
        L_0x053f:
            java.lang.String r0 = "MC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0547:
            goto L_0x07ce
        L_0x0549:
            java.lang.String r0 = "MA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 3, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0557:
            java.lang.String r0 = "LY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0220
        L_0x0561:
            java.lang.String r0 = "LV"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x056b:
            java.lang.String r0 = "LU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 0, 3, 2, 1, 3} // fill-array
            return r2
        L_0x0579:
            java.lang.String r0 = "LT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 0, 1, 0, 2} // fill-array
            return r2
        L_0x0587:
            java.lang.String r0 = "LS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0365
        L_0x0591:
            int[] r2 = new int[r1]
            r2 = {4, 3, 3, 3, 2, 2} // fill-array
            return r2
        L_0x0597:
            java.lang.String r0 = "LR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x059f:
            goto L_0x08fe
        L_0x05a1:
            java.lang.String r0 = "LK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x04e1
        L_0x05ab:
            int[] r2 = new int[r1]
            r2 = {3, 2, 3, 3, 4, 2} // fill-array
            return r2
        L_0x05b1:
            java.lang.String r0 = "LI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x05bb:
            java.lang.String r0 = "LC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 1, 1, 2, 2} // fill-array
            return r2
        L_0x05c9:
            java.lang.String r0 = "LB"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 1, 2, 2, 2} // fill-array
            return r2
        L_0x05d7:
            java.lang.String r0 = "LA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 1, 3, 2, 2} // fill-array
            return r2
        L_0x05e5:
            java.lang.String r0 = "KZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 2, 2, 3, 2} // fill-array
            return r2
        L_0x05f3:
            java.lang.String r0 = "KY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x05fd:
            java.lang.String r0 = "KW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0605:
            goto L_0x0734
        L_0x0607:
            java.lang.String r0 = "KR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 2, 4, 4, 4} // fill-array
            return r2
        L_0x0615:
            java.lang.String r0 = "KN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x061f:
            java.lang.String r0 = "KM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x006e
        L_0x0629:
            int[] r2 = new int[r1]
            r2 = {4, 3, 3, 2, 2, 2} // fill-array
            return r2
        L_0x062f:
            java.lang.String r0 = "KI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0165
        L_0x0639:
            java.lang.String r0 = "KH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 4, 2, 2, 2} // fill-array
            return r2
        L_0x0647:
            java.lang.String r0 = "KG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 1, 2, 2, 2} // fill-array
            return r2
        L_0x0655:
            java.lang.String r0 = "KE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 1, 1, 1, 2} // fill-array
            return r2
        L_0x0663:
            java.lang.String r0 = "JP"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 3, 2, 3, 4, 2} // fill-array
            return r2
        L_0x0671:
            java.lang.String r0 = "JO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0135
        L_0x067b:
            java.lang.String r0 = "JM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 4, 3, 1, 2, 2} // fill-array
            return r2
        L_0x0689:
            java.lang.String r0 = "JE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0691:
            goto L_0x07de
        L_0x0693:
            java.lang.String r0 = "IT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 1, 2, 1, 2} // fill-array
            return r2
        L_0x06a1:
            java.lang.String r0 = "IS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x06ab:
            java.lang.String r0 = "IR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 2, 3, 3, 4, 3} // fill-array
            return r2
        L_0x06b9:
            java.lang.String r0 = "IQ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 3, 2, 2, 2} // fill-array
            return r2
        L_0x06c7:
            java.lang.String r0 = "IO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 2, 0, 2, 2} // fill-array
            return r2
        L_0x06d5:
            java.lang.String r0 = "IN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 3, 2, 2, 3} // fill-array
            return r2
        L_0x06e3:
            java.lang.String r0 = "IM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0691
        L_0x06ec:
            java.lang.String r0 = "IL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 2, 3, 4, 2} // fill-array
            return r2
        L_0x06fa:
            java.lang.String r0 = "IE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 1, 1, 1, 2} // fill-array
            return r2
        L_0x0708:
            java.lang.String r0 = "ID"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 3, 3, 2, 4} // fill-array
            return r2
        L_0x0716:
            java.lang.String r0 = "HU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x0720:
            java.lang.String r0 = "HT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0042
        L_0x072a:
            java.lang.String r0 = "HR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0605
        L_0x0734:
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 0, 0, 2} // fill-array
            return r2
        L_0x073a:
            java.lang.String r0 = "HK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 0, 1, 1, 0} // fill-array
            return r2
        L_0x0748:
            java.lang.String r0 = "GY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 1, 3, 2, 2} // fill-array
            return r2
        L_0x0756:
            java.lang.String r0 = "GW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 4, 1, 2, 2, 2} // fill-array
            return r2
        L_0x0764:
            java.lang.String r0 = "GU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 4, 3, 3, 2} // fill-array
            return r2
        L_0x0772:
            java.lang.String r0 = "GT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 2, 1, 2, 2} // fill-array
            return r2
        L_0x0780:
            java.lang.String r0 = "GR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 0, 0, 1, 2} // fill-array
            return r2
        L_0x078e:
            java.lang.String r0 = "GQ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0042
        L_0x0798:
            java.lang.String r0 = "GP"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 1, 3, 2, 2} // fill-array
            return r2
        L_0x07a6:
            java.lang.String r0 = "GN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 4, 2, 2, 2} // fill-array
            return r2
        L_0x07b4:
            java.lang.String r0 = "GM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x01e2
        L_0x07be:
            int[] r2 = new int[r1]
            r2 = {4, 3, 2, 4, 2, 2} // fill-array
            return r2
        L_0x07c4:
            java.lang.String r0 = "GL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0547
        L_0x07ce:
            int[] r2 = new int[r1]
            r2 = {1, 2, 2, 0, 2, 2} // fill-array
            return r2
        L_0x07d4:
            java.lang.String r0 = "GI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0691
        L_0x07de:
            int[] r2 = new int[r1]
            r2 = {0, 2, 0, 1, 2, 2} // fill-array
            return r2
        L_0x07e4:
            java.lang.String r0 = "GH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 3, 3, 2, 2, 2} // fill-array
            return r2
        L_0x07f2:
            java.lang.String r0 = "GG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0800:
            java.lang.String r0 = "GF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 3, 3, 2, 2} // fill-array
            return r2
        L_0x080e:
            java.lang.String r0 = "GE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 0, 2, 2, 2} // fill-array
            return r2
        L_0x081c:
            java.lang.String r0 = "GD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 0, 0, 2, 2} // fill-array
            return r2
        L_0x082a:
            java.lang.String r0 = "GB"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 3, 2, 2, 2} // fill-array
            return r2
        L_0x0838:
            java.lang.String r0 = "GA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 0, 0, 2, 2} // fill-array
            return r2
        L_0x0846:
            java.lang.String r0 = "FR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 1, 1, 0, 2} // fill-array
            return r2
        L_0x0854:
            java.lang.String r0 = "FO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 2, 0, 2, 2} // fill-array
            return r2
        L_0x0862:
            java.lang.String r0 = "FM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 2, 4, 0, 2, 2} // fill-array
            return r2
        L_0x0870:
            java.lang.String r0 = "FK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0238
        L_0x087a:
            int[] r2 = new int[r1]
            r2 = {3, 2, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0880:
            java.lang.String r0 = "FJ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 2, 3, 2, 2} // fill-array
            return r2
        L_0x088e:
            java.lang.String r0 = "FI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 0, 1, 0, 2} // fill-array
            return r2
        L_0x089c:
            java.lang.String r0 = "ET"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 3, 4, 4, 4, 2} // fill-array
            return r2
        L_0x08aa:
            java.lang.String r0 = "ES"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 0, 0, 1, 0} // fill-array
            return r2
        L_0x08b8:
            java.lang.String r0 = "ER"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x024c
        L_0x08c2:
            java.lang.String r0 = "EG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0513
        L_0x08cc:
            java.lang.String r0 = "EE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x08d6:
            java.lang.String r0 = "EC"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 3, 2, 1, 2, 2} // fill-array
            return r2
        L_0x08e4:
            java.lang.String r0 = "DZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x016f
        L_0x08ee:
            int[] r2 = new int[r1]
            r2 = {3, 3, 4, 4, 2, 2} // fill-array
            return r2
        L_0x08f4:
            java.lang.String r0 = "DO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x059f
        L_0x08fe:
            int[] r2 = new int[r1]
            r2 = {3, 4, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0904:
            java.lang.String r0 = "DM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x090e:
            java.lang.String r0 = "DK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 2, 0, 0, 2} // fill-array
            return r2
        L_0x091c:
            java.lang.String r0 = "DJ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0220
        L_0x0926:
            java.lang.String r0 = "DE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 4, 2, 2, 1} // fill-array
            return r2
        L_0x0934:
            java.lang.String r0 = "CZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 2, 0, 1, 2} // fill-array
            return r2
        L_0x0942:
            java.lang.String r0 = "CY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 0, 1, 0, 0, 2} // fill-array
            return r2
        L_0x0950:
            java.lang.String r0 = "CX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x095a:
            java.lang.String r0 = "CW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x0964:
            java.lang.String r0 = "CV"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 3, 0, 1, 2, 2} // fill-array
            return r2
        L_0x0972:
            java.lang.String r0 = "CU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0165
        L_0x097c:
            int[] r2 = new int[r1]
            r2 = {4, 2, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0982:
            java.lang.String r0 = "CR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x03ef
        L_0x098c:
            int[] r2 = new int[r1]
            r2 = {2, 4, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0992:
            java.lang.String r0 = "CO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 3, 3, 2, 2, 2} // fill-array
            return r2
        L_0x09a0:
            java.lang.String r0 = "CN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 0, 1, 1, 3, 1} // fill-array
            return r2
        L_0x09ae:
            java.lang.String r0 = "CM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x04a3
        L_0x09b8:
            int[] r2 = new int[r1]
            r2 = {4, 3, 3, 4, 2, 2} // fill-array
            return r2
        L_0x09be:
            java.lang.String r0 = "CL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0179
        L_0x09c8:
            int[] r2 = new int[r1]
            r2 = {0, 1, 2, 2, 2, 2} // fill-array
            return r2
        L_0x09ce:
            java.lang.String r0 = "CK"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x09d6:
            goto L_0x0a36
        L_0x09d7:
            java.lang.String r0 = "CI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x09df:
            goto L_0x0bff
        L_0x09e1:
            java.lang.String r0 = "CH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 1, 0, 0, 0, 2} // fill-array
            return r2
        L_0x09ef:
            java.lang.String r0 = "CG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0513
        L_0x09f9:
            int[] r2 = new int[r1]
            r2 = {3, 4, 3, 3, 2, 2} // fill-array
            return r2
        L_0x09ff:
            java.lang.String r0 = "CF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 2, 4, 2, 2, 2} // fill-array
            return r2
        L_0x0a0d:
            java.lang.String r0 = "CD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x04eb
        L_0x0a17:
            int[] r2 = new int[r1]
            r2 = {3, 3, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0a1d:
            java.lang.String r0 = "CA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00f7
        L_0x0a27:
            int[] r2 = new int[r1]
            r2 = {0, 2, 1, 2, 3, 3} // fill-array
            return r2
        L_0x0a2d:
            java.lang.String r0 = "BZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x09d6
        L_0x0a36:
            int[] r2 = new int[r1]
            r2 = {2, 2, 2, 1, 2, 2} // fill-array
            return r2
        L_0x0a3c:
            java.lang.String r0 = "BY"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 3, 3, 2, 2} // fill-array
            return r2
        L_0x0a4a:
            java.lang.String r0 = "BW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 1, 0, 2, 2} // fill-array
            return r2
        L_0x0a58:
            java.lang.String r0 = "BT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 1, 2, 2, 3, 2} // fill-array
            return r2
        L_0x0a66:
            java.lang.String r0 = "BS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0a74:
            java.lang.String r0 = "BR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 1, 1, 2, 4} // fill-array
            return r2
        L_0x0a82:
            java.lang.String r0 = "BQ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x0a8c:
            java.lang.String r0 = "BO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 2, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0a9a:
            java.lang.String r0 = "BN"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 2, 0, 0, 2, 2} // fill-array
            return r2
        L_0x0aa8:
            java.lang.String r0 = "BM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 2, 0, 0, 2, 2} // fill-array
            return r2
        L_0x0ab6:
            java.lang.String r0 = "BL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x02f3
        L_0x0ac0:
            int[] r2 = new int[r1]
            r2 = {1, 2, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0ac6:
            java.lang.String r0 = "BJ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {4, 4, 2, 3, 2, 2} // fill-array
            return r2
        L_0x0ad4:
            java.lang.String r0 = "BI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0042
        L_0x0ade:
            int[] r2 = new int[r1]
            r2 = {4, 4, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0ae4:
            java.lang.String r0 = "BH"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 3, 1, 3, 4, 2} // fill-array
            return r2
        L_0x0af2:
            java.lang.String r0 = "BG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0242
        L_0x0afc:
            int[] r2 = new int[r1]
            r2 = {0, 0, 0, 0, 1, 2} // fill-array
            return r2
        L_0x0b02:
            java.lang.String r0 = "BF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0191
        L_0x0b0c:
            int[] r2 = new int[r1]
            r2 = {4, 3, 4, 4, 2, 2} // fill-array
            return r2
        L_0x0b12:
            java.lang.String r0 = "BE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 0, 1, 0, 1, 2} // fill-array
            return r2
        L_0x0b20:
            java.lang.String r0 = "BD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 1, 3, 2, 4, 2} // fill-array
            return r2
        L_0x0b2e:
            java.lang.String r0 = "BB"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x0b38:
            java.lang.String r0 = "BA"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0135
        L_0x0b42:
            int[] r2 = new int[r1]
            r2 = {1, 1, 1, 1, 2, 2} // fill-array
            return r2
        L_0x0b48:
            java.lang.String r0 = "AZ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0220
        L_0x0b52:
            int[] r2 = new int[r1]
            r2 = {4, 2, 3, 3, 2, 2} // fill-array
            return r2
        L_0x0b58:
            java.lang.String r0 = "AX"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x00b5
        L_0x0b62:
            int[] r2 = new int[r1]
            r2 = {0, 2, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0b68:
            java.lang.String r0 = "AW"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 3, 4, 2, 2} // fill-array
            return r2
        L_0x0b76:
            java.lang.String r0 = "AU"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {0, 3, 1, 1, 3, 0} // fill-array
            return r2
        L_0x0b84:
            java.lang.String r0 = "AT"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0264
        L_0x0b8e:
            int[] r2 = new int[r1]
            r2 = {0, 0, 0, 0, 0, 2} // fill-array
            return r2
        L_0x0b94:
            java.lang.String r0 = "AS"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 3, 3, 2, 2} // fill-array
            return r2
        L_0x0ba2:
            java.lang.String r0 = "AR"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {2, 2, 2, 2, 1, 2} // fill-array
            return r2
        L_0x0bb0:
            java.lang.String r0 = "AQ"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x024c
        L_0x0bba:
            int[] r2 = new int[r1]
            r2 = {4, 2, 2, 2, 2, 2} // fill-array
            return r2
        L_0x0bc0:
            java.lang.String r0 = "AO"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {3, 4, 4, 3, 2, 2} // fill-array
            return r2
        L_0x0bce:
            java.lang.String r0 = "AM"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x038b
        L_0x0bd8:
            int[] r2 = new int[r1]
            r2 = {2, 3, 2, 3, 2, 2} // fill-array
            return r2
        L_0x0bde:
            java.lang.String r0 = "AL"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 1, 1, 2, 2, 2} // fill-array
            return r2
        L_0x0bec:
            java.lang.String r0 = "AI"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x0c2b
        L_0x0bf5:
            java.lang.String r0 = "AG"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x09df
        L_0x0bff:
            int[] r2 = new int[r1]
            r2 = {2, 4, 3, 4, 2, 2} // fill-array
            return r2
        L_0x0c05:
            java.lang.String r0 = "AF"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            goto L_0x01a9
        L_0x0c0f:
            int[] r2 = new int[r1]
            r2 = {4, 4, 3, 4, 2, 2} // fill-array
            return r2
        L_0x0c15:
            java.lang.String r0 = "AE"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
            int[] r2 = new int[r1]
            r2 = {1, 4, 2, 3, 4, 1} // fill-array
            return r2
        L_0x0c23:
            java.lang.String r0 = "AD"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0008
        L_0x0c2b:
            int[] r2 = new int[r1]
            r2 = {1, 2, 0, 0, 2, 2} // fill-array
            return r2
        L_0x0c31:
            int[] r2 = new int[r1]
            r2 = {2, 2, 2, 2, 2, 2} // fill-array
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzy.zzm(java.lang.String):int[]");
    }

    public final synchronized void zza(zzhb zzhb, zzhh zzhh, boolean z, int i) {
        if (zzl(zzhh, z)) {
            this.zzn += (long) i;
        }
    }

    public final synchronized void zzb(zzhb zzhb, zzhh zzhh, boolean z) {
        boolean z2;
        if (zzl(zzhh, z)) {
            if (this.zzl > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzeq.zzf(z2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (elapsedRealtime - this.zzm);
            this.zzo += (long) i;
            long j = this.zzp;
            long j2 = this.zzn;
            this.zzp = j + j2;
            if (i > 0) {
                this.zzk.zzb((int) Math.sqrt((double) j2), (((float) j2) * 8000.0f) / ((float) i));
                if (this.zzo >= 2000 || this.zzp >= 524288) {
                    this.zzq = (long) this.zzk.zza(0.5f);
                }
                zzj(i, this.zzn, this.zzq);
                this.zzm = elapsedRealtime;
                this.zzn = 0;
            }
            this.zzl--;
        }
    }

    public final void zzc(zzhb zzhb, zzhh zzhh, boolean z) {
    }

    public final synchronized void zzd(zzhb zzhb, zzhh zzhh, boolean z) {
        if (zzl(zzhh, z)) {
            if (this.zzl == 0) {
                this.zzm = SystemClock.elapsedRealtime();
            }
            this.zzl++;
        }
    }

    public final void zzf(zzzt zzzt) {
        this.zzi.zzc(zzzt);
    }

    public static synchronized zzzy zzg(Context context) {
        zzzy zzzy;
        Context context2;
        String str;
        TelephonyManager telephonyManager;
        synchronized (zzzy.class) {
            if (zzg == null) {
                if (context == null) {
                    context2 = null;
                } else {
                    context2 = context.getApplicationContext();
                }
                int i = zzgd.zza;
                if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null)) {
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!TextUtils.isEmpty(networkCountryIso)) {
                        str = zzfxm.zzb(networkCountryIso);
                        int[] zzm2 = zzm(str);
                        HashMap hashMap = new HashMap(8);
                        hashMap.put(0, Long.valueOf(AnimationKt.MillisToNanos));
                        hashMap.put(2, (Long) zza.get(zzm2[0]));
                        hashMap.put(3, (Long) zzb.get(zzm2[1]));
                        hashMap.put(4, (Long) zzc.get(zzm2[2]));
                        hashMap.put(5, (Long) zzd.get(zzm2[3]));
                        hashMap.put(10, (Long) zze.get(zzm2[4]));
                        hashMap.put(9, (Long) zzf.get(zzm2[5]));
                        hashMap.put(7, (Long) zza.get(zzm2[0]));
                        zzg = new zzzy(context2, hashMap, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzer.zza, true, (zzzx) null);
                    }
                }
                str = zzfxm.zzb(Locale.getDefault().getCountry());
                int[] zzm22 = zzm(str);
                HashMap hashMap2 = new HashMap(8);
                hashMap2.put(0, Long.valueOf(AnimationKt.MillisToNanos));
                hashMap2.put(2, (Long) zza.get(zzm22[0]));
                hashMap2.put(3, (Long) zzb.get(zzm22[1]));
                hashMap2.put(4, (Long) zzc.get(zzm22[2]));
                hashMap2.put(5, (Long) zzd.get(zzm22[3]));
                hashMap2.put(10, (Long) zze.get(zzm22[4]));
                hashMap2.put(9, (Long) zzf.get(zzm22[5]));
                hashMap2.put(7, (Long) zza.get(zzm22[0]));
                zzg = new zzzy(context2, hashMap2, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, zzer.zza, true, (zzzx) null);
            }
            zzzy = zzg;
        }
        return zzzy;
    }

    public final void zze(Handler handler, zzzt zzzt) {
        if (zzzt != null) {
            this.zzi.zza(handler, zzzt);
            return;
        }
        throw null;
    }
}
