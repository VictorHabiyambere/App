package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.work.WorkRequest;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzabj extends zztv implements zzabp {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private zzdv zzA;
    private boolean zzB;
    private boolean zzC;
    private int zzD;
    private zzabn zzE;
    private zzacm zzF;
    private final Context zze;
    private final zzacn zzf;
    private final zzach zzg;
    private final boolean zzh;
    private final zzabq zzi;
    private final zzabo zzj;
    private zzabi zzk;
    private boolean zzl;
    private boolean zzm;
    /* access modifiers changed from: private */
    public Surface zzn;
    private zzfv zzo;
    private zzabm zzp;
    private boolean zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private long zzw;
    private int zzx;
    private long zzy;
    private zzdv zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzabj(Context context, zztl zztl, zztx zztx, long j, boolean z, Handler handler, zzaci zzaci, int i, float f) {
        super(2, zztl, zztx, false, 30.0f);
        this.zze = context.getApplicationContext();
        Handler handler2 = handler;
        zzaci zzaci2 = zzaci;
        this.zzg = new zzach(handler, zzaci);
        zzabc zzc2 = new zzaar(this.zze).zzc();
        if (zzc2.zzc() == null) {
            zzc2.zzs(new zzabq(this.zze, this, 0));
        }
        this.zzf = zzc2;
        zzabq zzc3 = this.zzf.zzc();
        zzeq.zzb(zzc3);
        this.zzi = zzc3;
        this.zzj = new zzabo();
        this.zzh = "NVIDIA".equals(zzgd.zzc);
        this.zzr = 1;
        this.zzz = zzdv.zza;
        this.zzD = 0;
        this.zzA = null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x04c9, code lost:
        if (r13.equals("deb") != false) goto L_0x0791;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:507:0x0799, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static final boolean zzaQ(java.lang.String r17) {
        /*
            java.lang.String r0 = "OMX.google"
            r1 = r17
            boolean r0 = r1.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.ads.zzabj> r2 = com.google.android.gms.internal.ads.zzabj.class
            monitor-enter(r2)
            boolean r0 = zzc     // Catch:{ all -> 0x07b5 }
            if (r0 != 0) goto L_0x07b1
            int r0 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x07b5 }
            r3 = 28
            r4 = 5
            r5 = 6
            r6 = 4
            r7 = 7
            r8 = 2
            r9 = 3
            r10 = -1
            r11 = 1
            if (r0 > r3) goto L_0x0083
            java.lang.String r0 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ all -> 0x07b5 }
            int r12 = r0.hashCode()     // Catch:{ all -> 0x07b5 }
            switch(r12) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0067;
                case -1220066608: goto L_0x005d;
                case -1012436106: goto L_0x0053;
                case -760312546: goto L_0x0049;
                case -64886864: goto L_0x003f;
                case 3415681: goto L_0x0035;
                case 825323514: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r12 = "machuca"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r4
            goto L_0x007c
        L_0x0035:
            java.lang.String r12 = "once"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r5
            goto L_0x007c
        L_0x003f:
            java.lang.String r12 = "magnolia"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r6
            goto L_0x007c
        L_0x0049:
            java.lang.String r12 = "aquaman"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r1
            goto L_0x007c
        L_0x0053:
            java.lang.String r12 = "oneday"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r7
            goto L_0x007c
        L_0x005d:
            java.lang.String r12 = "dangalUHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r8
            goto L_0x007c
        L_0x0067:
            java.lang.String r12 = "dangalFHD"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r9
            goto L_0x007c
        L_0x0071:
            java.lang.String r12 = "dangal"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x002a
            r0 = r11
            goto L_0x007c
        L_0x007b:
            r0 = r10
        L_0x007c:
            switch(r0) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0083
        L_0x0080:
            r1 = r11
            goto L_0x07ad
        L_0x0083:
            int r0 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x07b5 }
            r12 = 27
            if (r0 > r12) goto L_0x0096
            java.lang.String r0 = "HWEML"
            java.lang.String r13 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ all -> 0x07b5 }
            boolean r0 = r0.equals(r13)     // Catch:{ all -> 0x07b5 }
            if (r0 == 0) goto L_0x0096
            r1 = r11
            goto L_0x07ad
        L_0x0096:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzgd.zzd     // Catch:{ all -> 0x07b5 }
            int r13 = r0.hashCode()     // Catch:{ all -> 0x07b5 }
            r14 = 8
            switch(r13) {
                case -349662828: goto L_0x00f3;
                case -321033677: goto L_0x00e9;
                case 2006354: goto L_0x00df;
                case 2006367: goto L_0x00d5;
                case 2006371: goto L_0x00cb;
                case 1785421873: goto L_0x00c1;
                case 1785421876: goto L_0x00b7;
                case 1798172390: goto L_0x00ad;
                case 2119412532: goto L_0x00a3;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            goto L_0x00fd
        L_0x00a3:
            java.lang.String r13 = "AFTEUFF014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r4
            goto L_0x00fe
        L_0x00ad:
            java.lang.String r13 = "AFTSO001"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r14
            goto L_0x00fe
        L_0x00b7:
            java.lang.String r13 = "AFTEU014"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r6
            goto L_0x00fe
        L_0x00c1:
            java.lang.String r13 = "AFTEU011"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r9
            goto L_0x00fe
        L_0x00cb:
            java.lang.String r13 = "AFTR"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r8
            goto L_0x00fe
        L_0x00d5:
            java.lang.String r13 = "AFTN"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r11
            goto L_0x00fe
        L_0x00df:
            java.lang.String r13 = "AFTA"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r1
            goto L_0x00fe
        L_0x00e9:
            java.lang.String r13 = "AFTKMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r7
            goto L_0x00fe
        L_0x00f3:
            java.lang.String r13 = "AFTJMST12"
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x00a1
            r13 = r5
            goto L_0x00fe
        L_0x00fd:
            r13 = r10
        L_0x00fe:
            switch(r13) {
                case 0: goto L_0x0104;
                case 1: goto L_0x0104;
                case 2: goto L_0x0104;
                case 3: goto L_0x0104;
                case 4: goto L_0x0104;
                case 5: goto L_0x0104;
                case 6: goto L_0x0104;
                case 7: goto L_0x0104;
                case 8: goto L_0x0104;
                default: goto L_0x0101;
            }
        L_0x0101:
            int r13 = com.google.android.gms.internal.ads.zzgd.zza     // Catch:{ all -> 0x07b5 }
            goto L_0x0107
        L_0x0104:
            r1 = r11
            goto L_0x07ad
        L_0x0107:
            r15 = 26
            if (r13 > r15) goto L_0x07ac
            java.lang.String r13 = com.google.android.gms.internal.ads.zzgd.zzb     // Catch:{ all -> 0x07b5 }
            int r16 = r13.hashCode()     // Catch:{ all -> 0x07b5 }
            switch(r16) {
                case -2144781245: goto L_0x0785;
                case -2144781185: goto L_0x077a;
                case -2144781160: goto L_0x076f;
                case -2097309513: goto L_0x0764;
                case -2022874474: goto L_0x0759;
                case -1978993182: goto L_0x074e;
                case -1978990237: goto L_0x0743;
                case -1936688988: goto L_0x0738;
                case -1936688066: goto L_0x072d;
                case -1936688065: goto L_0x0721;
                case -1931988508: goto L_0x0715;
                case -1885099851: goto L_0x0709;
                case -1696512866: goto L_0x06fd;
                case -1680025915: goto L_0x06f1;
                case -1615810839: goto L_0x06e5;
                case -1600724499: goto L_0x06d9;
                case -1554255044: goto L_0x06cd;
                case -1481772737: goto L_0x06c1;
                case -1481772730: goto L_0x06b5;
                case -1481772729: goto L_0x06a9;
                case -1320080169: goto L_0x069d;
                case -1217592143: goto L_0x0691;
                case -1180384755: goto L_0x0685;
                case -1139198265: goto L_0x0679;
                case -1052835013: goto L_0x066d;
                case -993250464: goto L_0x0662;
                case -993250458: goto L_0x0657;
                case -965403638: goto L_0x064b;
                case -958336948: goto L_0x063f;
                case -879245230: goto L_0x0633;
                case -842500323: goto L_0x0627;
                case -821392978: goto L_0x061b;
                case -797483286: goto L_0x060f;
                case -794946968: goto L_0x0603;
                case -788334647: goto L_0x05f7;
                case -782144577: goto L_0x05eb;
                case -575125681: goto L_0x05df;
                case -521118391: goto L_0x05d3;
                case -430914369: goto L_0x05c7;
                case -290434366: goto L_0x05bb;
                case -282781963: goto L_0x05af;
                case -277133239: goto L_0x05a3;
                case -173639913: goto L_0x0597;
                case -56598463: goto L_0x058b;
                case 2126: goto L_0x057f;
                case 2564: goto L_0x0573;
                case 2715: goto L_0x0567;
                case 2719: goto L_0x055b;
                case 3091: goto L_0x054f;
                case 3483: goto L_0x0543;
                case 73405: goto L_0x0537;
                case 75537: goto L_0x052b;
                case 75739: goto L_0x051f;
                case 76779: goto L_0x0513;
                case 78669: goto L_0x0507;
                case 79305: goto L_0x04fb;
                case 80618: goto L_0x04ef;
                case 88274: goto L_0x04e3;
                case 98846: goto L_0x04d8;
                case 98848: goto L_0x04cd;
                case 99329: goto L_0x04c3;
                case 101481: goto L_0x04b7;
                case 1513190: goto L_0x04ac;
                case 1514184: goto L_0x04a1;
                case 1514185: goto L_0x0496;
                case 2133089: goto L_0x048a;
                case 2133091: goto L_0x047e;
                case 2133120: goto L_0x0472;
                case 2133151: goto L_0x0466;
                case 2133182: goto L_0x045a;
                case 2133184: goto L_0x044e;
                case 2436959: goto L_0x0442;
                case 2463773: goto L_0x0436;
                case 2464648: goto L_0x042a;
                case 2689555: goto L_0x041e;
                case 3154429: goto L_0x0412;
                case 3284551: goto L_0x0406;
                case 3351335: goto L_0x03fa;
                case 3386211: goto L_0x03ee;
                case 41325051: goto L_0x03e2;
                case 51349633: goto L_0x03d7;
                case 51350594: goto L_0x03cc;
                case 55178625: goto L_0x03c0;
                case 61542055: goto L_0x03b5;
                case 65355429: goto L_0x03a9;
                case 66214468: goto L_0x039d;
                case 66214470: goto L_0x0391;
                case 66214473: goto L_0x0385;
                case 66215429: goto L_0x0379;
                case 66215431: goto L_0x036d;
                case 66215433: goto L_0x0361;
                case 66216390: goto L_0x0355;
                case 76402249: goto L_0x0349;
                case 76404105: goto L_0x033d;
                case 76404911: goto L_0x0331;
                case 80963634: goto L_0x0325;
                case 82882791: goto L_0x0319;
                case 98715550: goto L_0x030d;
                case 101370885: goto L_0x0301;
                case 102844228: goto L_0x02f5;
                case 165221241: goto L_0x02ea;
                case 182191441: goto L_0x02de;
                case 245388979: goto L_0x02d2;
                case 287431619: goto L_0x02c6;
                case 307593612: goto L_0x02ba;
                case 308517133: goto L_0x02ae;
                case 316215098: goto L_0x02a2;
                case 316215116: goto L_0x0296;
                case 316246811: goto L_0x028a;
                case 316246818: goto L_0x027e;
                case 407160593: goto L_0x0272;
                case 507412548: goto L_0x0266;
                case 793982701: goto L_0x025a;
                case 794038622: goto L_0x024e;
                case 794040393: goto L_0x0242;
                case 835649806: goto L_0x0236;
                case 917340916: goto L_0x022a;
                case 958008161: goto L_0x021e;
                case 1060579533: goto L_0x0212;
                case 1150207623: goto L_0x0206;
                case 1176899427: goto L_0x01fa;
                case 1280332038: goto L_0x01ee;
                case 1306947716: goto L_0x01e2;
                case 1349174697: goto L_0x01d6;
                case 1522194893: goto L_0x01ca;
                case 1691543273: goto L_0x01be;
                case 1691544261: goto L_0x01b2;
                case 1709443163: goto L_0x01a6;
                case 1865889110: goto L_0x019a;
                case 1906253259: goto L_0x018e;
                case 1977196784: goto L_0x0182;
                case 2006372676: goto L_0x0176;
                case 2019281702: goto L_0x016a;
                case 2029784656: goto L_0x015e;
                case 2030379515: goto L_0x0152;
                case 2033393791: goto L_0x0146;
                case 2047190025: goto L_0x013a;
                case 2047252157: goto L_0x012e;
                case 2048319463: goto L_0x0122;
                case 2048855701: goto L_0x0116;
                default: goto L_0x0114;
            }
        L_0x0114:
            goto L_0x0790
        L_0x0116:
            java.lang.String r3 = "HWWAS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 66
            goto L_0x0791
        L_0x0122:
            java.lang.String r3 = "HWVNS-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 65
            goto L_0x0791
        L_0x012e:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 33
            goto L_0x0791
        L_0x013a:
            java.lang.String r3 = "ELUGA_Note"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 32
            goto L_0x0791
        L_0x0146:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 14
            goto L_0x0791
        L_0x0152:
            java.lang.String r3 = "HWCAM-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 64
            goto L_0x0791
        L_0x015e:
            java.lang.String r3 = "HWBLN-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 63
            goto L_0x0791
        L_0x016a:
            java.lang.String r3 = "DM-01K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 29
            goto L_0x0791
        L_0x0176:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 19
            goto L_0x0791
        L_0x0182:
            java.lang.String r3 = "Infinix-X572"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 69
            goto L_0x0791
        L_0x018e:
            java.lang.String r3 = "PB2-670M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 100
            goto L_0x0791
        L_0x019a:
            java.lang.String r3 = "santoni"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x0791
        L_0x01a6:
            java.lang.String r3 = "iball8735_9806"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 68
            goto L_0x0791
        L_0x01b2:
            java.lang.String r3 = "CPH1715"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 24
            goto L_0x0791
        L_0x01be:
            java.lang.String r3 = "CPH1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 23
            goto L_0x0791
        L_0x01ca:
            java.lang.String r3 = "woods_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 133(0x85, float:1.86E-43)
            goto L_0x0791
        L_0x01d6:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 61
            goto L_0x0791
        L_0x01e2:
            java.lang.String r3 = "EverStar_S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 35
            goto L_0x0791
        L_0x01ee:
            java.lang.String r3 = "hwALE-H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 62
            goto L_0x0791
        L_0x01fa:
            java.lang.String r3 = "itel_S41"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 71
            goto L_0x0791
        L_0x0206:
            java.lang.String r3 = "LS-5017"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 78
            goto L_0x0791
        L_0x0212:
            java.lang.String r3 = "panell_d"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 96
            goto L_0x0791
        L_0x021e:
            java.lang.String r3 = "j2xlteins"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 72
            goto L_0x0791
        L_0x022a:
            java.lang.String r3 = "A7000plus"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 10
            goto L_0x0791
        L_0x0236:
            java.lang.String r3 = "manning"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 81
            goto L_0x0791
        L_0x0242:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 59
            goto L_0x0791
        L_0x024e:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 58
            goto L_0x0791
        L_0x025a:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 57
            goto L_0x0791
        L_0x0266:
            java.lang.String r3 = "QM16XE_U"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x0791
        L_0x0272:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x0791
        L_0x027e:
            java.lang.String r3 = "TB3-850M"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x0791
        L_0x028a:
            java.lang.String r3 = "TB3-850F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x0791
        L_0x0296:
            java.lang.String r3 = "TB3-730X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x0791
        L_0x02a2:
            java.lang.String r3 = "TB3-730F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x0791
        L_0x02ae:
            java.lang.String r3 = "A7020a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 12
            goto L_0x0791
        L_0x02ba:
            java.lang.String r3 = "A7010a48"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 11
            goto L_0x0791
        L_0x02c6:
            java.lang.String r3 = "griffin"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 60
            goto L_0x0791
        L_0x02d2:
            java.lang.String r3 = "marino_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 82
            goto L_0x0791
        L_0x02de:
            java.lang.String r3 = "CPY83_I00"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 25
            goto L_0x0791
        L_0x02ea:
            java.lang.String r3 = "A2016a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r14
            goto L_0x0791
        L_0x02f5:
            java.lang.String r3 = "le_x6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 77
            goto L_0x0791
        L_0x0301:
            java.lang.String r3 = "l5460"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 76
            goto L_0x0791
        L_0x030d:
            java.lang.String r3 = "i9031"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 67
            goto L_0x0791
        L_0x0319:
            java.lang.String r3 = "X3_HK"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 135(0x87, float:1.89E-43)
            goto L_0x0791
        L_0x0325:
            java.lang.String r3 = "V23GB"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0791
        L_0x0331:
            java.lang.String r3 = "Q4310"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x0791
        L_0x033d:
            java.lang.String r3 = "Q4260"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x0791
        L_0x0349:
            java.lang.String r3 = "PRO7S"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x0791
        L_0x0355:
            java.lang.String r3 = "F3311"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 48
            goto L_0x0791
        L_0x0361:
            java.lang.String r3 = "F3215"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 47
            goto L_0x0791
        L_0x036d:
            java.lang.String r3 = "F3213"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 46
            goto L_0x0791
        L_0x0379:
            java.lang.String r3 = "F3211"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 45
            goto L_0x0791
        L_0x0385:
            java.lang.String r3 = "F3116"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 44
            goto L_0x0791
        L_0x0391:
            java.lang.String r3 = "F3113"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 43
            goto L_0x0791
        L_0x039d:
            java.lang.String r3 = "F3111"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 42
            goto L_0x0791
        L_0x03a9:
            java.lang.String r3 = "E5643"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 30
            goto L_0x0791
        L_0x03b5:
            java.lang.String r3 = "A1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r7
            goto L_0x0791
        L_0x03c0:
            java.lang.String r3 = "Aura_Note_2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 15
            goto L_0x0791
        L_0x03cc:
            java.lang.String r3 = "602LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r6
            goto L_0x0791
        L_0x03d7:
            java.lang.String r3 = "601LV"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r9
            goto L_0x0791
        L_0x03e2:
            java.lang.String r3 = "MEIZU_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 83
            goto L_0x0791
        L_0x03ee:
            java.lang.String r3 = "p212"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 92
            goto L_0x0791
        L_0x03fa:
            java.lang.String r3 = "mido"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 85
            goto L_0x0791
        L_0x0406:
            java.lang.String r3 = "kate"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 75
            goto L_0x0791
        L_0x0412:
            java.lang.String r3 = "fugu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 50
            goto L_0x0791
        L_0x041e:
            java.lang.String r3 = "XE2X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 136(0x88, float:1.9E-43)
            goto L_0x0791
        L_0x042a:
            java.lang.String r3 = "Q427"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x0791
        L_0x0436:
            java.lang.String r3 = "Q350"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x0791
        L_0x0442:
            java.lang.String r3 = "P681"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 93
            goto L_0x0791
        L_0x044e:
            java.lang.String r3 = "F04J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 41
            goto L_0x0791
        L_0x045a:
            java.lang.String r3 = "F04H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 40
            goto L_0x0791
        L_0x0466:
            java.lang.String r3 = "F03H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 39
            goto L_0x0791
        L_0x0472:
            java.lang.String r3 = "F02H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 38
            goto L_0x0791
        L_0x047e:
            java.lang.String r3 = "F01J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 37
            goto L_0x0791
        L_0x048a:
            java.lang.String r3 = "F01H"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 36
            goto L_0x0791
        L_0x0496:
            java.lang.String r3 = "1714"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r8
            goto L_0x0791
        L_0x04a1:
            java.lang.String r3 = "1713"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r11
            goto L_0x0791
        L_0x04ac:
            java.lang.String r3 = "1601"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r1
            goto L_0x0791
        L_0x04b7:
            java.lang.String r3 = "flo"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 49
            goto L_0x0791
        L_0x04c3:
            java.lang.String r4 = "deb"
            boolean r4 = r13.equals(r4)
            if (r4 == 0) goto L_0x0114
            goto L_0x0791
        L_0x04cd:
            java.lang.String r3 = "cv3"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r12
            goto L_0x0791
        L_0x04d8:
            java.lang.String r3 = "cv1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r15
            goto L_0x0791
        L_0x04e3:
            java.lang.String r3 = "Z80"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 139(0x8b, float:1.95E-43)
            goto L_0x0791
        L_0x04ef:
            java.lang.String r3 = "QX1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x0791
        L_0x04fb:
            java.lang.String r3 = "PLE"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x0791
        L_0x0507:
            java.lang.String r3 = "P85"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 94
            goto L_0x0791
        L_0x0513:
            java.lang.String r3 = "MX6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 86
            goto L_0x0791
        L_0x051f:
            java.lang.String r3 = "M5c"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 80
            goto L_0x0791
        L_0x052b:
            java.lang.String r3 = "M04"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 79
            goto L_0x0791
        L_0x0537:
            java.lang.String r3 = "JGZ"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 73
            goto L_0x0791
        L_0x0543:
            java.lang.String r3 = "mh"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 84
            goto L_0x0791
        L_0x054f:
            java.lang.String r3 = "b5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 16
            goto L_0x0791
        L_0x055b:
            java.lang.String r3 = "V5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 129(0x81, float:1.81E-43)
            goto L_0x0791
        L_0x0567:
            java.lang.String r3 = "V1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 127(0x7f, float:1.78E-43)
            goto L_0x0791
        L_0x0573:
            java.lang.String r3 = "Q5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x0791
        L_0x057f:
            java.lang.String r3 = "C1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 20
            goto L_0x0791
        L_0x058b:
            java.lang.String r3 = "woods_fn"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 134(0x86, float:1.88E-43)
            goto L_0x0791
        L_0x0597:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 31
            goto L_0x0791
        L_0x05a3:
            java.lang.String r3 = "Z12_PRO"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 138(0x8a, float:1.93E-43)
            goto L_0x0791
        L_0x05af:
            java.lang.String r3 = "BLACK-1X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 17
            goto L_0x0791
        L_0x05bb:
            java.lang.String r3 = "taido_row"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x0791
        L_0x05c7:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x0791
        L_0x05d3:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 53
            goto L_0x0791
        L_0x05df:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 51
            goto L_0x0791
        L_0x05eb:
            java.lang.String r3 = "OnePlus5T"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 91
            goto L_0x0791
        L_0x05f7:
            java.lang.String r3 = "whyred"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 132(0x84, float:1.85E-43)
            goto L_0x0791
        L_0x0603:
            java.lang.String r3 = "watson"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 131(0x83, float:1.84E-43)
            goto L_0x0791
        L_0x060f:
            java.lang.String r3 = "SVP-DTV15"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x0791
        L_0x061b:
            java.lang.String r3 = "A7000-a"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 9
            goto L_0x0791
        L_0x0627:
            java.lang.String r3 = "nicklaus_f"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 88
            goto L_0x0791
        L_0x0633:
            java.lang.String r3 = "tcl_eu"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 126(0x7e, float:1.77E-43)
            goto L_0x0791
        L_0x063f:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 34
            goto L_0x0791
        L_0x064b:
            java.lang.String r3 = "s905x018"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x0791
        L_0x0657:
            java.lang.String r3 = "A10-70L"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r5
            goto L_0x0791
        L_0x0662:
            java.lang.String r3 = "A10-70F"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = r4
            goto L_0x0791
        L_0x066d:
            java.lang.String r3 = "namath"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 87
            goto L_0x0791
        L_0x0679:
            java.lang.String r3 = "Slate_Pro"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x0791
        L_0x0685:
            java.lang.String r3 = "iris60"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 70
            goto L_0x0791
        L_0x0691:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 18
            goto L_0x0791
        L_0x069d:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 52
            goto L_0x0791
        L_0x06a9:
            java.lang.String r3 = "panell_dt"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 99
            goto L_0x0791
        L_0x06b5:
            java.lang.String r3 = "panell_ds"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 98
            goto L_0x0791
        L_0x06c1:
            java.lang.String r3 = "panell_dl"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 97
            goto L_0x0791
        L_0x06cd:
            java.lang.String r3 = "vernee_M5"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 130(0x82, float:1.82E-43)
            goto L_0x0791
        L_0x06d9:
            java.lang.String r3 = "pacificrim"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 95
            goto L_0x0791
        L_0x06e5:
            java.lang.String r3 = "Phantom6"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x0791
        L_0x06f1:
            java.lang.String r3 = "ComioS1"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 21
            goto L_0x0791
        L_0x06fd:
            java.lang.String r3 = "XT1663"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 137(0x89, float:1.92E-43)
            goto L_0x0791
        L_0x0709:
            java.lang.String r3 = "RAIJIN"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x0791
        L_0x0715:
            java.lang.String r3 = "AquaPowerM"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 13
            goto L_0x0791
        L_0x0721:
            java.lang.String r3 = "PGN611"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x0791
        L_0x072d:
            java.lang.String r3 = "PGN610"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x0791
        L_0x0738:
            java.lang.String r3 = "PGN528"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x0791
        L_0x0743:
            java.lang.String r3 = "NX573J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 90
            goto L_0x0791
        L_0x074e:
            java.lang.String r3 = "NX541J"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 89
            goto L_0x0791
        L_0x0759:
            java.lang.String r3 = "CP8676_I02"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 22
            goto L_0x0791
        L_0x0764:
            java.lang.String r3 = "K50a40"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 74
            goto L_0x0791
        L_0x076f:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 56
            goto L_0x0791
        L_0x077a:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 55
            goto L_0x0791
        L_0x0785:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0114
            r3 = 54
            goto L_0x0791
        L_0x0790:
            r3 = r10
        L_0x0791:
            switch(r3) {
                case 0: goto L_0x0799;
                case 1: goto L_0x0799;
                case 2: goto L_0x0799;
                case 3: goto L_0x0799;
                case 4: goto L_0x0799;
                case 5: goto L_0x0799;
                case 6: goto L_0x0799;
                case 7: goto L_0x0799;
                case 8: goto L_0x0799;
                case 9: goto L_0x0799;
                case 10: goto L_0x0799;
                case 11: goto L_0x0799;
                case 12: goto L_0x0799;
                case 13: goto L_0x0799;
                case 14: goto L_0x0799;
                case 15: goto L_0x0799;
                case 16: goto L_0x0799;
                case 17: goto L_0x0799;
                case 18: goto L_0x0799;
                case 19: goto L_0x0799;
                case 20: goto L_0x0799;
                case 21: goto L_0x0799;
                case 22: goto L_0x0799;
                case 23: goto L_0x0799;
                case 24: goto L_0x0799;
                case 25: goto L_0x0799;
                case 26: goto L_0x0799;
                case 27: goto L_0x0799;
                case 28: goto L_0x0799;
                case 29: goto L_0x0799;
                case 30: goto L_0x0799;
                case 31: goto L_0x0799;
                case 32: goto L_0x0799;
                case 33: goto L_0x0799;
                case 34: goto L_0x0799;
                case 35: goto L_0x0799;
                case 36: goto L_0x0799;
                case 37: goto L_0x0799;
                case 38: goto L_0x0799;
                case 39: goto L_0x0799;
                case 40: goto L_0x0799;
                case 41: goto L_0x0799;
                case 42: goto L_0x0799;
                case 43: goto L_0x0799;
                case 44: goto L_0x0799;
                case 45: goto L_0x0799;
                case 46: goto L_0x0799;
                case 47: goto L_0x0799;
                case 48: goto L_0x0799;
                case 49: goto L_0x0799;
                case 50: goto L_0x0799;
                case 51: goto L_0x0799;
                case 52: goto L_0x0799;
                case 53: goto L_0x0799;
                case 54: goto L_0x0799;
                case 55: goto L_0x0799;
                case 56: goto L_0x0799;
                case 57: goto L_0x0799;
                case 58: goto L_0x0799;
                case 59: goto L_0x0799;
                case 60: goto L_0x0799;
                case 61: goto L_0x0799;
                case 62: goto L_0x0799;
                case 63: goto L_0x0799;
                case 64: goto L_0x0799;
                case 65: goto L_0x0799;
                case 66: goto L_0x0799;
                case 67: goto L_0x0799;
                case 68: goto L_0x0799;
                case 69: goto L_0x0799;
                case 70: goto L_0x0799;
                case 71: goto L_0x0799;
                case 72: goto L_0x0799;
                case 73: goto L_0x0799;
                case 74: goto L_0x0799;
                case 75: goto L_0x0799;
                case 76: goto L_0x0799;
                case 77: goto L_0x0799;
                case 78: goto L_0x0799;
                case 79: goto L_0x0799;
                case 80: goto L_0x0799;
                case 81: goto L_0x0799;
                case 82: goto L_0x0799;
                case 83: goto L_0x0799;
                case 84: goto L_0x0799;
                case 85: goto L_0x0799;
                case 86: goto L_0x0799;
                case 87: goto L_0x0799;
                case 88: goto L_0x0799;
                case 89: goto L_0x0799;
                case 90: goto L_0x0799;
                case 91: goto L_0x0799;
                case 92: goto L_0x0799;
                case 93: goto L_0x0799;
                case 94: goto L_0x0799;
                case 95: goto L_0x0799;
                case 96: goto L_0x0799;
                case 97: goto L_0x0799;
                case 98: goto L_0x0799;
                case 99: goto L_0x0799;
                case 100: goto L_0x0799;
                case 101: goto L_0x0799;
                case 102: goto L_0x0799;
                case 103: goto L_0x0799;
                case 104: goto L_0x0799;
                case 105: goto L_0x0799;
                case 106: goto L_0x0799;
                case 107: goto L_0x0799;
                case 108: goto L_0x0799;
                case 109: goto L_0x0799;
                case 110: goto L_0x0799;
                case 111: goto L_0x0799;
                case 112: goto L_0x0799;
                case 113: goto L_0x0799;
                case 114: goto L_0x0799;
                case 115: goto L_0x0799;
                case 116: goto L_0x0799;
                case 117: goto L_0x0799;
                case 118: goto L_0x0799;
                case 119: goto L_0x0799;
                case 120: goto L_0x0799;
                case 121: goto L_0x0799;
                case 122: goto L_0x0799;
                case 123: goto L_0x0799;
                case 124: goto L_0x0799;
                case 125: goto L_0x0799;
                case 126: goto L_0x0799;
                case 127: goto L_0x0799;
                case 128: goto L_0x0799;
                case 129: goto L_0x0799;
                case 130: goto L_0x0799;
                case 131: goto L_0x0799;
                case 132: goto L_0x0799;
                case 133: goto L_0x0799;
                case 134: goto L_0x0799;
                case 135: goto L_0x0799;
                case 136: goto L_0x0799;
                case 137: goto L_0x0799;
                case 138: goto L_0x0799;
                case 139: goto L_0x0799;
                default: goto L_0x0794;
            }
        L_0x0794:
            int r3 = r0.hashCode()     // Catch:{ all -> 0x07b5 }
            goto L_0x079b
        L_0x0799:
            r1 = r11
            goto L_0x07ad
        L_0x079b:
            switch(r3) {
                case -594534941: goto L_0x079f;
                default: goto L_0x079e;
            }
        L_0x079e:
            goto L_0x07a8
        L_0x079f:
            java.lang.String r3 = "JSN-L21"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x079e
            r10 = r1
        L_0x07a8:
            switch(r10) {
                case 0: goto L_0x0799;
                default: goto L_0x07ab;
            }
        L_0x07ab:
            goto L_0x07ad
        L_0x07ac:
        L_0x07ad:
            zzd = r1     // Catch:{ all -> 0x07b5 }
            zzc = r11     // Catch:{ all -> 0x07b5 }
        L_0x07b1:
            monitor-exit(r2)     // Catch:{ all -> 0x07b5 }
            boolean r0 = zzd
            return r0
        L_0x07b5:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x07b5 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabj.zzaQ(java.lang.String):boolean");
    }

    private static List zzaR(Context context, zztx zztx, zzan zzan, boolean z, boolean z2) throws zzud {
        if (zzan.zzn == null) {
            return zzgbc.zzm();
        }
        if (zzgd.zza >= 26 && "video/dolby-vision".equals(zzan.zzn) && !zzabh.zza(context)) {
            List zzd2 = zzuj.zzd(zztx, zzan, z, z2);
            if (!zzd2.isEmpty()) {
                return zzd2;
            }
        }
        return zzuj.zzf(zztx, zzan, z, z2);
    }

    private final void zzaS() {
        zzdv zzdv = this.zzA;
        if (zzdv != null) {
            this.zzg.zzt(zzdv);
        }
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    public final void zzaT() {
        this.zzg.zzq(this.zzn);
        this.zzq = true;
    }

    private final void zzaU() {
        Surface surface = this.zzn;
        zzabm zzabm = this.zzp;
        if (surface == zzabm) {
            this.zzn = null;
        }
        if (zzabm != null) {
            zzabm.release();
            this.zzp = null;
        }
    }

    private final boolean zzaV(zztp zztp) {
        if (zzgd.zza < 23 || zzaQ(zztp.zza)) {
            return false;
        }
        if (!zztp.zzf) {
            return true;
        }
        if (!zzabm.zzb(this.zze)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        if (r3.equals("video/av01") != false) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d3, code lost:
        return ((r0 * r1) * 3) / r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r11 = ((java.lang.Integer) r11.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzad(com.google.android.gms.internal.ads.zztp r10, com.google.android.gms.internal.ads.zzan r11) {
        /*
            int r0 = r11.zzs
            int r1 = r11.zzt
            r2 = -1
            if (r0 == r2) goto L_0x00d7
            if (r1 != r2) goto L_0x000b
            goto L_0x00d7
        L_0x000b:
            java.lang.String r3 = r11.zzn
            if (r3 == 0) goto L_0x00d4
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            r5 = 2
            r6 = 1
            java.lang.String r7 = "video/avc"
            java.lang.String r8 = "video/hevc"
            if (r4 == 0) goto L_0x0038
            android.util.Pair r11 = com.google.android.gms.internal.ads.zzuj.zza(r11)
            if (r11 == 0) goto L_0x0035
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0033
            if (r11 == r6) goto L_0x0033
            if (r11 != r5) goto L_0x0035
        L_0x0033:
            r3 = r7
            goto L_0x0039
        L_0x0035:
            r3 = r8
            goto L_0x0039
        L_0x0038:
        L_0x0039:
            int r11 = r3.hashCode()
            r4 = 3
            r9 = 4
            switch(r11) {
                case -1664118616: goto L_0x007a;
                case -1662735862: goto L_0x0071;
                case -1662541442: goto L_0x0069;
                case 1187890754: goto L_0x005f;
                case 1331836730: goto L_0x0057;
                case 1599127256: goto L_0x004d;
                case 1599127257: goto L_0x0043;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x0084
        L_0x0043:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0084
            r5 = 6
            goto L_0x0085
        L_0x004d:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0084
            r5 = r4
            goto L_0x0085
        L_0x0057:
            boolean r11 = r3.equals(r7)
            if (r11 == 0) goto L_0x0084
            r5 = 5
            goto L_0x0085
        L_0x005f:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0084
            r5 = r6
            goto L_0x0085
        L_0x0069:
            boolean r11 = r3.equals(r8)
            if (r11 == 0) goto L_0x0084
            r5 = r9
            goto L_0x0085
        L_0x0071:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0084
            goto L_0x0085
        L_0x007a:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0084
            r5 = 0
            goto L_0x0085
        L_0x0084:
            r5 = r2
        L_0x0085:
            switch(r5) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00cf;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00cf;
                case 4: goto L_0x00c5;
                case 5: goto L_0x008c;
                case 6: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x00d7
        L_0x0089:
            r9 = 8
            goto L_0x00d0
        L_0x008c:
            java.lang.String r11 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00d7
            java.lang.String r11 = com.google.android.gms.internal.ads.zzgd.zzc
            java.lang.String r3 = "Amazon"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b8
            java.lang.String r11 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r3 = "KFSOWI"
            boolean r11 = r3.equals(r11)
            if (r11 != 0) goto L_0x00d7
            java.lang.String r11 = com.google.android.gms.internal.ads.zzgd.zzd
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b8
            boolean r10 = r10.zzf
            if (r10 != 0) goto L_0x00d7
        L_0x00b8:
            int r0 = r0 + 15
            int r1 = r1 + 15
            int r0 = r0 / 16
            int r1 = r1 / 16
            int r0 = r0 * r1
            int r0 = r0 * 768
            int r0 = r0 / r9
            return r0
        L_0x00c5:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r10, r0)
            return r10
        L_0x00cf:
        L_0x00d0:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            return r0
        L_0x00d4:
            r10 = 0
            throw r10
        L_0x00d7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabj.zzad(com.google.android.gms.internal.ads.zztp, com.google.android.gms.internal.ads.zzan):int");
    }

    protected static int zzae(zztp zztp, zzan zzan) {
        if (zzan.zzo == -1) {
            return zzad(zztp, zzan);
        }
        int size = zzan.zzp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) zzan.zzp.get(i2)).length;
        }
        return zzan.zzo + i;
    }

    /* access modifiers changed from: protected */
    public final void zzA() {
        if (this.zzF != null) {
            this.zzf.zzn();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzC() {
        try {
            super.zzC();
            this.zzC = false;
            if (this.zzp != null) {
                zzaU();
            }
        } catch (Throwable th) {
            this.zzC = false;
            if (this.zzp != null) {
                zzaU();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzD() {
        this.zzt = 0;
        zzh();
        this.zzs = SystemClock.elapsedRealtime();
        this.zzw = 0;
        this.zzx = 0;
        this.zzi.zzg();
    }

    /* access modifiers changed from: protected */
    public final void zzE() {
        if (this.zzt > 0) {
            zzh();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzt, elapsedRealtime - this.zzs);
            this.zzt = 0;
            this.zzs = elapsedRealtime;
        }
        int i = this.zzx;
        if (i != 0) {
            this.zzg.zzr(this.zzw, i);
            this.zzw = 0;
            this.zzx = 0;
        }
        this.zzi.zzh();
    }

    public final void zzM(float f, float f2) throws zzjh {
        super.zzM(f, f2);
        this.zzi.zzn(f);
        zzacm zzacm = this.zzF;
        if (zzacm != null) {
            zzabc.zzi(((zzaba) zzacm).zza, f);
        }
    }

    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    public final void zzV(long j, long j2) throws zzjh {
        super.zzV(j, j2);
        zzacm zzacm = this.zzF;
        if (zzacm != null) {
            try {
                zzacm.zzh(j, j2);
            } catch (zzacl e) {
                throw zzi(e, e.zza, false, 7001);
            }
        }
    }

    public final boolean zzW() {
        return super.zzW() && this.zzF == null;
    }

    public final boolean zzX() {
        zzabm zzabm;
        boolean z = false;
        if (super.zzX() && this.zzF == null) {
            z = true;
        }
        if (!z || (((zzabm = this.zzp) == null || this.zzn != zzabm) && zzaw() != null)) {
            return this.zzi.zzo(z);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final float zzZ(float f, zzan zzan, zzan[] zzanArr) {
        float f2 = -1.0f;
        for (zzan zzan2 : zzanArr) {
            float f3 = zzan2.zzu;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public final void zzaA(long j) {
        super.zzaA(j);
        this.zzv--;
    }

    /* access modifiers changed from: protected */
    public final void zzaB(zzin zzin) throws zzjh {
        this.zzv++;
        int i = zzgd.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaC(zzan zzan) throws zzjh {
        zzfv zzfv;
        if (this.zzB && !this.zzC) {
            this.zzF = this.zzf.zzd();
            try {
                this.zzF.zzf(zzan, zzh());
                this.zzF.zzi(new zzabg(this), zzggk.zzb());
                zzabn zzabn = this.zzE;
                if (zzabn != null) {
                    ((zzaba) this.zzF).zza.zzj = zzabn;
                }
                this.zzF.zzj(zzau());
                Surface surface = this.zzn;
                if (!(surface == null || (zzfv = this.zzo) == null)) {
                    this.zzf.zzq(surface, zzfv);
                }
            } catch (zzacl e) {
                throw zzi(e, zzan, false, 7000);
            }
        }
        this.zzC = true;
    }

    /* access modifiers changed from: protected */
    public final void zzaE() {
        super.zzaE();
        this.zzv = 0;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaK(zztp zztp) {
        return this.zzn != null || zzaV(zztp);
    }

    /* access modifiers changed from: protected */
    public final void zzaM(zztm zztm, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zztm.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    /* access modifiers changed from: protected */
    public final void zzaN(int i, int i2) {
        zzix zzix = this.zza;
        zzix.zzh += i;
        int i3 = i + i2;
        zzix.zzg += i3;
        this.zzt += i3;
        int i4 = this.zzu + i3;
        this.zzu = i4;
        zzix.zzi = Math.max(i4, zzix.zzi);
    }

    /* access modifiers changed from: protected */
    public final void zzaO(long j) {
        zzix zzix = this.zza;
        zzix.zzk += j;
        zzix.zzl++;
        this.zzw += j;
        this.zzx++;
    }

    /* access modifiers changed from: protected */
    public final boolean zzaP(long j, boolean z) throws zzjh {
        int zzd2 = zzd(j);
        if (zzd2 == 0) {
            return false;
        }
        if (z) {
            zzix zzix = this.zza;
            zzix.zzd += zzd2;
            zzix.zzf += this.zzv;
        } else {
            this.zza.zzj++;
            zzaN(zzd2, this.zzv);
        }
        zzaG();
        zzacm zzacm = this.zzF;
        if (zzacm != null) {
            zzacm.zze();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final int zzaa(zztx zztx, zzan zzan) throws zzud {
        boolean z;
        int i;
        int i2;
        int i3 = 128;
        if (!zzcg.zzh(zzan.zzn)) {
            return 128;
        }
        int i4 = 1;
        int i5 = 0;
        boolean z2 = zzan.zzq != null;
        List zzaR = zzaR(this.zze, zztx, zzan, z2, false);
        if (z2 && zzaR.isEmpty()) {
            zzaR = zzaR(this.zze, zztx, zzan, false, false);
        }
        if (!zzaR.isEmpty()) {
            if (!zzaL(zzan)) {
                i4 = 2;
            } else {
                zztp zztp = (zztp) zzaR.get(0);
                boolean zze2 = zztp.zze(zzan);
                if (!zze2) {
                    int i6 = 1;
                    while (true) {
                        if (i6 >= zzaR.size()) {
                            break;
                        }
                        zztp zztp2 = (zztp) zzaR.get(i6);
                        if (zztp2.zze(zzan)) {
                            zze2 = true;
                            z = false;
                            zztp = zztp2;
                            break;
                        }
                        i6++;
                    }
                }
                z = true;
                int i7 = true != zze2 ? 3 : 4;
                if (true != zztp.zzf(zzan)) {
                    i = 8;
                } else {
                    i = 16;
                }
                if (true != zztp.zzg) {
                    i2 = 0;
                } else {
                    i2 = 64;
                }
                if (true != z) {
                    i3 = 0;
                }
                if (zzgd.zza >= 26 && "video/dolby-vision".equals(zzan.zzn) && !zzabh.zza(this.zze)) {
                    i3 = 256;
                }
                if (zze2) {
                    List zzaR2 = zzaR(this.zze, zztx, zzan, z2, true);
                    if (!zzaR2.isEmpty()) {
                        zztp zztp3 = (zztp) zzuj.zzg(zzaR2, zzan).get(0);
                        if (zztp3.zze(zzan) && zztp3.zzf(zzan)) {
                            i5 = 32;
                        }
                    }
                }
                return i7 | i | i5 | i2 | i3;
            }
        }
        return i4 | 128;
    }

    /* access modifiers changed from: protected */
    public final zziy zzab(zztp zztp, zzan zzan, zzan zzan2) {
        int i;
        int i2;
        zziy zzb2 = zztp.zzb(zzan, zzan2);
        int i3 = zzb2.zze;
        zzabi zzabi = this.zzk;
        if (zzabi != null) {
            if (zzan2.zzs > zzabi.zza || zzan2.zzt > zzabi.zzb) {
                i3 |= 256;
            }
            if (zzae(zztp, zzan2) > zzabi.zzc) {
                i3 |= 64;
            }
            String str = zztp.zza;
            if (i3 != 0) {
                i = i3;
                i2 = 0;
            } else {
                i2 = zzb2.zzd;
                i = 0;
            }
            return new zziy(str, zzan, zzan2, i2, i);
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final zziy zzac(zzlj zzlj) throws zzjh {
        zziy zzac = super.zzac(zzlj);
        zzan zzan = zzlj.zza;
        if (zzan != null) {
            this.zzg.zzf(zzan, zzac);
            return zzac;
        }
        throw null;
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [com.google.android.gms.internal.ads.zzds, java.lang.Throwable, java.lang.Object] */
    /* access modifiers changed from: protected */
    public final zztk zzaf(zztp zztp, zzan zzan, MediaCrypto mediaCrypto, float f) {
        String str;
        Pair zza;
        boolean z;
        int i;
        Point point;
        int i2;
        int i3;
        boolean z2;
        int zzad;
        zztp zztp2 = zztp;
        zzan zzan2 = zzan;
        float f2 = f;
        zzabm zzabm = this.zzp;
        if (!(zzabm == null || zzabm.zza == zztp2.zzf)) {
            zzaU();
        }
        String str2 = zztp2.zzc;
        zzan[] zzT = zzT();
        int i4 = zzan2.zzs;
        int i5 = zzan2.zzt;
        int zzae = zzae(zztp, zzan);
        int length = zzT.length;
        if (length == 1) {
            if (!(zzae == -1 || (zzad = zzad(zztp, zzan)) == -1)) {
                zzae = Math.min((int) (((float) zzae) * 1.5f), zzad);
            }
            str = str2;
        } else {
            boolean z3 = false;
            for (int i6 = 0; i6 < length; i6++) {
                zzan zzan3 = zzT[i6];
                if (zzan2.zzz != null && zzan3.zzz == null) {
                    zzal zzb2 = zzan3.zzb();
                    zzb2.zzA(zzan2.zzz);
                    zzan3 = zzb2.zzad();
                }
                if (zztp2.zzb(zzan2, zzan3).zzd != 0) {
                    int i7 = zzan3.zzs;
                    if (i7 != -1) {
                        z2 = zzan3.zzt == -1;
                    } else {
                        z2 = true;
                    }
                    z3 |= z2;
                    i4 = Math.max(i4, i7);
                    i5 = Math.max(i5, zzan3.zzt);
                    zzae = Math.max(zzae, zzae(zztp2, zzan3));
                }
            }
            if (z3) {
                zzfk.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i4 + "x" + i5);
                int i8 = zzan2.zzt;
                int i9 = zzan2.zzs;
                if (i8 > i9) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i = i8;
                } else {
                    i = i9;
                }
                if (true == z) {
                    i8 = i9;
                }
                int[] iArr = zzb;
                int i10 = 0;
                while (true) {
                    if (i10 >= 9) {
                        str = str2;
                        break;
                    }
                    float f3 = (float) i8;
                    float f4 = (float) i;
                    str = str2;
                    int i11 = iArr[i10];
                    int[] iArr2 = iArr;
                    float f5 = (float) i11;
                    if (i11 <= i) {
                        break;
                    }
                    int i12 = (int) (f5 * (f3 / f4));
                    if (i12 <= i8) {
                        point = null;
                        break;
                    }
                    int i13 = zzgd.zza;
                    if (true != z) {
                        i2 = i11;
                    } else {
                        i2 = i12;
                    }
                    if (true != z) {
                        i11 = i12;
                    }
                    point = zztp2.zza(i2, i11);
                    float f6 = zzan2.zzu;
                    if (point != null) {
                        i3 = i8;
                        if (zztp2.zzg(point.x, point.y, (double) f6)) {
                            break;
                        }
                    } else {
                        i3 = i8;
                    }
                    i10++;
                    float f7 = f;
                    str2 = str;
                    iArr = iArr2;
                    i8 = i3;
                }
                point = null;
                if (point != null) {
                    i4 = Math.max(i4, point.x);
                    i5 = Math.max(i5, point.y);
                    zzal zzb3 = zzan.zzb();
                    zzb3.zzac(i4);
                    zzb3.zzI(i5);
                    zzae = Math.max(zzae, zzad(zztp2, zzb3.zzad()));
                    zzfk.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i4 + "x" + i5);
                }
            } else {
                str = str2;
            }
        }
        this.zzk = new zzabi(i4, i5, zzae);
        zzabi zzabi = this.zzk;
        boolean z4 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzan2.zzs);
        mediaFormat.setInteger("height", zzan2.zzt);
        zzfn.zzb(mediaFormat, zzan2.zzp);
        float f8 = zzan2.zzu;
        if (f8 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f8);
        }
        zzfn.zza(mediaFormat, "rotation-degrees", zzan2.zzv);
        zzt zzt2 = zzan2.zzz;
        if (zzt2 != null) {
            zzfn.zza(mediaFormat, "color-transfer", zzt2.zzf);
            zzfn.zza(mediaFormat, "color-standard", zzt2.zzd);
            zzfn.zza(mediaFormat, "color-range", zzt2.zze);
            byte[] bArr = zzt2.zzg;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzan2.zzn) && (zza = zzuj.zza(zzan)) != null) {
            zzfn.zza(mediaFormat, Scopes.PROFILE, ((Integer) zza.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzabi.zza);
        mediaFormat.setInteger("max-height", zzabi.zzb);
        zzfn.zza(mediaFormat, "max-input-size", zzabi.zzc);
        if (zzgd.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            float f9 = f;
            if (f9 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f9);
            }
        }
        if (z4) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.zzn == null) {
            if (zzaV(zztp)) {
                if (this.zzp == null) {
                    this.zzp = zzabm.zza(this.zze, zztp2.zzf);
                }
                this.zzn = this.zzp;
            } else {
                throw new IllegalStateException();
            }
        }
        zzacm zzacm = this.zzF;
        if (zzacm != null && !zzacm.zzl()) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        if (this.zzF == null) {
            return zztk.zzb(zztp2, mediaFormat, zzan2, this.zzn, (MediaCrypto) null);
        }
        ? r4 = 0;
        zzeq.zzf(false);
        zzeq.zzb(r4);
        r4.zzb();
        throw r4;
    }

    /* access modifiers changed from: protected */
    public final List zzag(zztx zztx, zzan zzan, boolean z) throws zzud {
        return zzuj.zzg(zzaR(this.zze, zztx, zzan, false, false), zzan);
    }

    /* access modifiers changed from: protected */
    public final void zzaj(zzin zzin) throws zzjh {
        if (this.zzm) {
            ByteBuffer byteBuffer = zzin.zzf;
            if (byteBuffer == null) {
                throw null;
            } else if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zztm zzaw = zzaw();
                    if (zzaw != null) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzaw.zzp(bundle);
                        return;
                    }
                    throw null;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzak(Exception exc) {
        zzfk.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str, zztk zztk, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzl = zzaQ(str);
        zztp zzay = zzay();
        if (zzay != null) {
            boolean z = false;
            if (zzgd.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzay.zzb)) {
                MediaCodecInfo.CodecProfileLevel[] zzh2 = zzay.zzh();
                int length = zzh2.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (zzh2[i].profile == 16384) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.zzm = z;
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        this.zzg.zzb(str);
    }

    /* access modifiers changed from: protected */
    public final void zzan(zzan zzan, MediaFormat mediaFormat) {
        boolean z;
        int i;
        int i2;
        zztm zzaw = zzaw();
        if (zzaw != null) {
            zzaw.zzq(this.zzr);
        }
        if (mediaFormat != null) {
            if (!mediaFormat.containsKey("crop-right")) {
                z = false;
            } else if (!mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
            } else {
                i = mediaFormat.getInteger("width");
            }
            if (z) {
                i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
            } else {
                i2 = mediaFormat.getInteger("height");
            }
            float f = zzan.zzw;
            int i3 = zzgd.zza;
            int i4 = zzan.zzv;
            if (i4 == 90 || i4 == 270) {
                f = 1.0f / f;
                int i5 = i2;
                i2 = i;
                i = i5;
            }
            this.zzz = new zzdv(i, i2, 0, f);
            this.zzi.zzl(zzan.zzu);
            zzacm zzacm = this.zzF;
            if (zzacm != null) {
                zzal zzb2 = zzan.zzb();
                zzb2.zzac(i);
                zzb2.zzI(i2);
                zzb2.zzW(0);
                zzb2.zzT(f);
                zzacm.zzg(1, zzb2.zzad());
                return;
            }
            return;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzao(zztm zztm, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zztm.zzm(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzu = 0;
        if (this.zzF == null) {
            zzdv zzdv = this.zzz;
            if (!zzdv.equals(zzdv.zza) && !zzdv.equals(this.zzA)) {
                this.zzA = zzdv;
                this.zzg.zzt(this.zzA);
            }
            if (this.zzi.zzp() && this.zzn != null) {
                zzaT();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzap() {
        this.zzi.zzf();
        this.zzf.zzd().zzj(zzau());
    }

    /* access modifiers changed from: protected */
    public final boolean zzar(long j, long j2, zztm zztm, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzan zzan) throws zzjh {
        long j4;
        zztm zztm2 = zztm;
        int i4 = i;
        boolean z3 = z2;
        if (zztm2 != null) {
            long zzau = j3 - zzau();
            int zza = this.zzi.zza(j3, j, j2, zzav(), z2, this.zzj);
            if (!z) {
                j4 = zzau;
            } else if (z3) {
                j4 = zzau;
            } else {
                zzaM(zztm2, i4, zzau);
                return true;
            }
            if (this.zzn != this.zzp || this.zzF != null) {
                zzacm zzacm = this.zzF;
                if (zzacm != null) {
                    try {
                        zzacm.zzh(j, j2);
                        long zzd2 = this.zzF.zzd(j4, z3);
                        if (zzd2 != -9223372036854775807L) {
                            int i5 = zzgd.zza;
                            zzao(zztm, i, j4, zzd2);
                            return true;
                        }
                    } catch (zzacl e) {
                        zzacl zzacl = e;
                        throw zzi(zzacl, zzacl.zza, false, 7001);
                    }
                } else {
                    switch (zza) {
                        case 0:
                            zzh();
                            long nanoTime = System.nanoTime();
                            int i6 = zzgd.zza;
                            zzao(zztm, i, j4, nanoTime);
                            zzaO(this.zzj.zzc());
                            return true;
                        case 1:
                            zzabo zzabo = this.zzj;
                            long zzd3 = zzabo.zzd();
                            long zzc2 = zzabo.zzc();
                            int i7 = zzgd.zza;
                            if (zzd3 == this.zzy) {
                                zzaM(zztm2, i4, j4);
                            } else {
                                zzao(zztm, i, j4, zzd3);
                            }
                            zzaO(zzc2);
                            this.zzy = zzd3;
                            return true;
                        case 2:
                            Trace.beginSection("dropVideoBuffer");
                            zztm2.zzn(i4, false);
                            Trace.endSection();
                            zzaN(0, 1);
                            zzaO(this.zzj.zzc());
                            return true;
                        case 3:
                            zzaM(zztm2, i4, j4);
                            zzaO(this.zzj.zzc());
                            return true;
                    }
                }
            } else if (this.zzj.zzc() < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                zzaM(zztm2, i4, j4);
                zzaO(this.zzj.zzc());
                return true;
            }
            return false;
        }
        throw null;
    }

    /* access modifiers changed from: protected */
    public final int zzat(zzin zzin) {
        int i = zzgd.zza;
        return 0;
    }

    /* access modifiers changed from: protected */
    public final zzto zzax(Throwable th, zztp zztp) {
        return new zzabf(th, zztp, this.zzn);
    }

    public final void zzs() {
        this.zzi.zzb();
    }

    public final void zzt(int i, Object obj) throws zzjh {
        zzabm zzabm;
        Surface surface;
        switch (i) {
            case 1:
                if (obj instanceof Surface) {
                    zzabm = (Surface) obj;
                } else {
                    zzabm = null;
                }
                if (zzabm == null) {
                    zzabm zzabm2 = this.zzp;
                    if (zzabm2 != null) {
                        zzabm = zzabm2;
                    } else {
                        zztp zzay = zzay();
                        if (zzay != null && zzaV(zzay)) {
                            this.zzp = zzabm.zza(this.zze, zzay.zzf);
                            zzabm = this.zzp;
                        }
                    }
                }
                if (this.zzn != zzabm) {
                    this.zzn = zzabm;
                    this.zzi.zzm(zzabm);
                    this.zzq = false;
                    int zzcU = zzcU();
                    zztm zzaw = zzaw();
                    if (zzaw != null && this.zzF == null) {
                        if (zzgd.zza >= 23) {
                            if (zzabm == null) {
                                zzabm = null;
                            } else if (!this.zzl) {
                                zzaw.zzo(zzabm);
                            }
                        }
                        zzaD();
                        zzaz();
                    }
                    if (zzabm == null || zzabm == this.zzp) {
                        this.zzA = null;
                        if (this.zzF != null) {
                            this.zzf.zzk();
                            return;
                        }
                        return;
                    }
                    zzaS();
                    if (zzcU == 2) {
                        this.zzi.zzc(true);
                    }
                    if (this.zzF != null) {
                        this.zzf.zzq(zzabm, zzfv.zza);
                        return;
                    }
                    return;
                } else if (zzabm != null && zzabm != this.zzp) {
                    zzaS();
                    Surface surface2 = this.zzn;
                    if (surface2 != null && this.zzq) {
                        this.zzg.zzq(surface2);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 4:
                if (obj != null) {
                    int intValue = ((Integer) obj).intValue();
                    this.zzr = intValue;
                    zztm zzaw2 = zzaw();
                    if (zzaw2 != null) {
                        zzaw2.zzq(intValue);
                        return;
                    }
                    return;
                }
                throw null;
            case 5:
                zzabq zzabq = this.zzi;
                if (obj != null) {
                    zzabq.zzj(((Integer) obj).intValue());
                    return;
                }
                throw null;
            case 7:
                if (obj != null) {
                    this.zzE = (zzabn) obj;
                    zzacm zzacm = this.zzF;
                    if (zzacm != null) {
                        ((zzaba) zzacm).zza.zzj = this.zzE;
                        return;
                    }
                    return;
                }
                throw null;
            case 10:
                if (obj != null) {
                    int intValue2 = ((Integer) obj).intValue();
                    if (this.zzD != intValue2) {
                        this.zzD = intValue2;
                        return;
                    }
                    return;
                }
                throw null;
            case 13:
                if (obj != null) {
                    this.zzf.zzr((List) obj);
                    this.zzB = true;
                    return;
                }
                throw null;
            case 14:
                if (obj != null) {
                    this.zzo = (zzfv) obj;
                    if (this.zzF != null) {
                        zzfv zzfv = this.zzo;
                        if (zzfv == null) {
                            throw null;
                        } else if (zzfv.zzb() != 0 && zzfv.zza() != 0 && (surface = this.zzn) != null) {
                            this.zzf.zzq(surface, zzfv);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    throw null;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzw() {
        this.zzA = null;
        this.zzi.zzd();
        this.zzq = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(this.zza);
            this.zzg.zzt(zzdv.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzx(boolean z, boolean z2) throws zzjh {
        super.zzx(z, z2);
        zzm();
        this.zzg.zze(this.zza);
        this.zzi.zze(z2);
    }

    /* access modifiers changed from: protected */
    public final void zzy() {
        this.zzi.zzk(zzh());
    }

    /* access modifiers changed from: protected */
    public final void zzz(long j, boolean z) throws zzjh {
        this.zzf.zzd().zze();
        super.zzz(j, z);
        this.zzi.zzi();
        if (z) {
            this.zzi.zzc(false);
        }
        this.zzu = 0;
    }
}
