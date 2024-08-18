package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzaix {
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public byte[] zzN;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public zzafb zzT;
    public boolean zzU;
    public boolean zzV = true;
    public zzafa zzW;
    public int zzX;
    /* access modifiers changed from: private */
    public int zzY;
    /* access modifiers changed from: private */
    public String zzZ = "eng";
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzaez zzi;
    public byte[] zzj;
    public zzae zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = 0;
    public int zzr = -1;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public byte[] zzv = null;
    public int zzw = -1;
    public boolean zzx = false;
    public int zzy = -1;
    public int zzz = -1;

    protected zzaix() {
    }

    static /* synthetic */ void zzd(zzaix zzaix) {
        if (zzaix.zzW == null) {
            throw null;
        }
    }

    private static Pair zzf(zzfu zzfu) throws zzch {
        try {
            zzfu.zzL(16);
            long zzs2 = zzfu.zzs();
            if (zzs2 == 1482049860) {
                return new Pair("video/divx", (Object) null);
            }
            if (zzs2 == 859189832) {
                return new Pair("video/3gpp", (Object) null);
            }
            if (zzs2 == 826496599) {
                int zzd2 = zzfu.zzd() + 20;
                byte[] zzM2 = zzfu.zzM();
                while (true) {
                    int length = zzM2.length;
                    if (zzd2 < length - 4) {
                        int i = zzd2 + 1;
                        if (zzM2[zzd2] == 0 && zzM2[i] == 0 && zzM2[zzd2 + 2] == 1 && zzM2[zzd2 + 3] == 15) {
                            return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(zzM2, zzd2, length)));
                        }
                        zzd2 = i;
                    } else {
                        throw zzch.zza("Failed to find FourCC VC1 initialization data", (Throwable) null);
                    }
                }
            } else {
                zzfk.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", (Object) null);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzch.zza("Error parsing FourCC private data", (Throwable) null);
        }
    }

    private static List zzg(byte[] bArr) throws zzch {
        byte b;
        byte b2;
        try {
            if (bArr[0] == 2) {
                int i = 0;
                int i2 = 1;
                while (true) {
                    byte b3 = bArr[i2];
                    i2++;
                    b = b3 & 255;
                    if (b != 255) {
                        break;
                    }
                    i += 255;
                }
                int i3 = i + b;
                int i4 = 0;
                while (true) {
                    byte b4 = bArr[i2];
                    i2++;
                    b2 = b4 & 255;
                    if (b2 != 255) {
                        break;
                    }
                    i4 += 255;
                }
                int i5 = i4 + b2;
                if (bArr[i2] == 1) {
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i2, bArr2, 0, i3);
                    int i6 = i2 + i3;
                    if (bArr[i6] == 3) {
                        int i7 = i6 + i5;
                        if (bArr[i7] == 5) {
                            int length = bArr.length - i7;
                            byte[] bArr3 = new byte[length];
                            System.arraycopy(bArr, i7, bArr3, 0, length);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw zzch.zza("Error parsing vorbis codec private", (Throwable) null);
                    }
                    throw zzch.zza("Error parsing vorbis codec private", (Throwable) null);
                }
                throw zzch.zza("Error parsing vorbis codec private", (Throwable) null);
            }
            throw zzch.zza("Error parsing vorbis codec private", (Throwable) null);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzch.zza("Error parsing vorbis codec private", (Throwable) null);
        }
    }

    private static boolean zzh(zzfu zzfu) throws zzch {
        try {
            int zzk2 = zzfu.zzk();
            if (zzk2 == 1) {
                return true;
            }
            if (zzk2 != 65534) {
                return false;
            }
            zzfu.zzK(24);
            return zzfu.zzt() == zzaiy.zzf.getMostSignificantBits() && zzfu.zzt() == zzaiy.zzf.getLeastSignificantBits();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzch.zza("Error parsing MS/ACM codec private", (Throwable) null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzch {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzch.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: java.lang.String} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01d7, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01f8, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01f9, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0201, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02f1, code lost:
        r1 = -1;
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02f9, code lost:
        r10 = -1;
        r1 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02fc, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x039e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03f5, code lost:
        r1 = -1;
        r10 = -1;
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03ff, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0402, code lost:
        if (r0.zzN == null) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0404, code lost:
        r4 = com.google.android.gms.internal.ads.zzado.zza(new com.google.android.gms.internal.ads.zzfu(r0.zzN));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x040f, code lost:
        if (r4 == null) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0411, code lost:
        r3 = r4.zza;
        r17 = "video/dolby-vision";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0415, code lost:
        r4 = r17;
        r5 = r0.zzV;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x041b, code lost:
        if (true == r0.zzU) goto L_0x041f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x041d, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x041f, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0420, code lost:
        r5 = r5 | r7;
        r7 = new com.google.android.gms.internal.ads.zzal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x042a, code lost:
        if (com.google.android.gms.internal.ads.zzcg.zzg(r4) == false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x042c, code lost:
        r7.zzy(r0.zzO);
        r7.zzY(r0.zzQ);
        r7.zzR(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x043f, code lost:
        if (com.google.android.gms.internal.ads.zzcg.zzh(r4) == false) goto L_0x05e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0443, code lost:
        if (r0.zzq != 0) goto L_0x0455;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0445, code lost:
        r6 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0447, code lost:
        if (r6 != -1) goto L_0x044b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0449, code lost:
        r6 = r0.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x044b, code lost:
        r0.zzo = r6;
        r6 = r0.zzp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x044f, code lost:
        if (r6 != -1) goto L_0x0453;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0451, code lost:
        r6 = r0.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0453, code lost:
        r0.zzp = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0455, code lost:
        r6 = r0.zzo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0459, code lost:
        if (r6 == -1) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x045b, code lost:
        r9 = r0.zzp;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x045d, code lost:
        if (r9 == -1) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x045f, code lost:
        r9 = ((float) (r0.zzm * r6)) / ((float) (r0.zzl * r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0469, code lost:
        r9 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x046c, code lost:
        if (r0.zzx == false) goto L_0x054f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0472, code lost:
        if (r0.zzD == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0478, code lost:
        if (r0.zzE == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x047e, code lost:
        if (r0.zzF == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0484, code lost:
        if (r0.zzG == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x048a, code lost:
        if (r0.zzH == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0490, code lost:
        if (r0.zzI == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0496, code lost:
        if (r0.zzJ == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x049c, code lost:
        if (r0.zzK == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x04a2, code lost:
        if (r0.zzL == -1.0f) goto L_0x0528;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x04a8, code lost:
        if (r0.zzM != -1.0f) goto L_0x04ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x04aa, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x04ad, code lost:
        r6 = new byte[25];
        r8 = java.nio.ByteBuffer.wrap(r6).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        r8.put((byte) 0);
        r8.putShort((short) ((int) ((r0.zzD * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzE * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzF * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzG * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzH * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzI * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzJ * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) ((r0.zzK * 50000.0f) + 0.5f)));
        r8.putShort((short) ((int) (r0.zzL + 0.5f)));
        r8.putShort((short) ((int) (r0.zzM + 0.5f)));
        r8.putShort((short) r0.zzB);
        r8.putShort((short) r0.zzC);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0528, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0529, code lost:
        r8 = new com.google.android.gms.internal.ads.zzr();
        r8.zzc(r0.zzy);
        r8.zzb(r0.zzA);
        r8.zzd(r0.zzz);
        r8.zze(r6);
        r8.zzf(r0.zzn);
        r8.zza(r0.zzn);
        r6 = r8.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x054f, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0552, code lost:
        if (r0.zza == null) goto L_0x0572;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x055e, code lost:
        if (com.google.android.gms.internal.ads.zzaiy.zzg.containsKey(r0.zza) == false) goto L_0x0572;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0560, code lost:
        r13 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzaiy.zzg.get(r0.zza)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0574, code lost:
        if (r0.zzr != 0) goto L_0x05c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x057d, code lost:
        if (java.lang.Float.compare(r0.zzs, 0.0f) != 0) goto L_0x05c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0585, code lost:
        if (java.lang.Float.compare(r0.zzt, 0.0f) != 0) goto L_0x05c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x058d, code lost:
        if (java.lang.Float.compare(r0.zzu, 0.0f) != 0) goto L_0x0590;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0598, code lost:
        if (java.lang.Float.compare(r0.zzu, 90.0f) != 0) goto L_0x059d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x059a, code lost:
        r11 = 90;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05a5, code lost:
        if (java.lang.Float.compare(r0.zzu, -180.0f) == 0) goto L_0x05c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05af, code lost:
        if (java.lang.Float.compare(r0.zzu, 180.0f) != 0) goto L_0x05b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05b1, code lost:
        r11 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x05bc, code lost:
        if (java.lang.Float.compare(r0.zzu, -90.0f) != 0) goto L_0x05c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05be, code lost:
        r11 = 270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05c1, code lost:
        r11 = 180;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x05c4, code lost:
        r11 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x05c5, code lost:
        r7.zzac(r0.zzl);
        r7.zzI(r0.zzm);
        r7.zzT(r9);
        r7.zzW(r11);
        r7.zzU(r0.zzv);
        r7.zzaa(r0.zzw);
        r7.zzA(r6);
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x05e9, code lost:
        if ("application/x-subrip".equals(r4) != false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x05ef, code lost:
        if ("text/x-ssa".equals(r4) != false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x05f7, code lost:
        if ("text/vtt".equals(r4) != false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x05ff, code lost:
        if ("application/vobsub".equals(r4) != false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0607, code lost:
        if ("application/pgs".equals(r4) != false) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x060f, code lost:
        if ("application/dvbsubs".equals(r4) == false) goto L_0x0612;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x061a, code lost:
        throw com.google.android.gms.internal.ads.zzch.zza("Unexpected MIME type.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x061b, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x061e, code lost:
        if (r0.zza == null) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x062a, code lost:
        if (com.google.android.gms.internal.ads.zzaiy.zzg.containsKey(r0.zza) != false) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x062c, code lost:
        r7.zzM(r0.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0631, code lost:
        r7.zzJ(r21);
        r7.zzX(r4);
        r7.zzP(r1);
        r7.zzO(r0.zzZ);
        r7.zzZ(r5);
        r7.zzL(r2);
        r7.zzz(r3);
        r7.zzE(r0.zzk);
        r1 = r7.zzad();
        r0.zzW = r20.zzw(r0.zzc, r6);
        r0.zzW.zzl(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0662, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(com.google.android.gms.internal.ads.zzadx r20, int r21) throws com.google.android.gms.internal.ads.zzch {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = r0.zzb
            int r2 = r1.hashCode()
            r3 = 24
            r5 = 16
            r6 = 1
            r8 = 32
            r9 = 8
            r10 = 4
            r11 = 0
            r12 = 3
            r13 = -1
            switch(r2) {
                case -2095576542: goto L_0x0188;
                case -2095575984: goto L_0x017e;
                case -1985379776: goto L_0x0173;
                case -1784763192: goto L_0x0168;
                case -1730367663: goto L_0x015d;
                case -1482641358: goto L_0x0152;
                case -1482641357: goto L_0x0147;
                case -1373388978: goto L_0x013c;
                case -933872740: goto L_0x0132;
                case -538363189: goto L_0x0127;
                case -538363109: goto L_0x011c;
                case -425012669: goto L_0x0110;
                case -356037306: goto L_0x0104;
                case 62923557: goto L_0x00f8;
                case 62923603: goto L_0x00ed;
                case 62927045: goto L_0x00e1;
                case 82318131: goto L_0x00d6;
                case 82338133: goto L_0x00cb;
                case 82338134: goto L_0x00c0;
                case 99146302: goto L_0x00b4;
                case 444813526: goto L_0x00a8;
                case 542569478: goto L_0x009c;
                case 635596514: goto L_0x0090;
                case 725948237: goto L_0x0084;
                case 725957860: goto L_0x0079;
                case 738597099: goto L_0x006d;
                case 855502857: goto L_0x0062;
                case 1045209816: goto L_0x0056;
                case 1422270023: goto L_0x004a;
                case 1809237540: goto L_0x003f;
                case 1950749482: goto L_0x0033;
                case 1950789798: goto L_0x0027;
                case 1951062397: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            goto L_0x0193
        L_0x001a:
            java.lang.String r2 = "A_OPUS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 12
            goto L_0x0194
        L_0x0027:
            java.lang.String r2 = "A_FLAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 22
            goto L_0x0194
        L_0x0033:
            java.lang.String r2 = "A_EAC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 17
            goto L_0x0194
        L_0x003f:
            java.lang.String r2 = "V_MPEG2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r12
            goto L_0x0194
        L_0x004a:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 27
            goto L_0x0194
        L_0x0056:
            java.lang.String r2 = "S_TEXT/WEBVTT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 29
            goto L_0x0194
        L_0x0062:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r9
            goto L_0x0194
        L_0x006d:
            java.lang.String r2 = "S_TEXT/ASS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 28
            goto L_0x0194
        L_0x0079:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r3
            goto L_0x0194
        L_0x0084:
            java.lang.String r2 = "A_PCM/INT/BIG"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 25
            goto L_0x0194
        L_0x0090:
            java.lang.String r2 = "A_PCM/FLOAT/IEEE"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 26
            goto L_0x0194
        L_0x009c:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 20
            goto L_0x0194
        L_0x00a8:
            java.lang.String r2 = "V_THEORA"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 10
            goto L_0x0194
        L_0x00b4:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 31
            goto L_0x0194
        L_0x00c0:
            java.lang.String r2 = "V_VP9"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r6
            goto L_0x0194
        L_0x00cb:
            java.lang.String r2 = "V_VP8"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r11
            goto L_0x0194
        L_0x00d6:
            java.lang.String r2 = "V_AV1"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 2
            goto L_0x0194
        L_0x00e1:
            java.lang.String r2 = "A_DTS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 19
            goto L_0x0194
        L_0x00ed:
            java.lang.String r2 = "A_AC3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r5
            goto L_0x0194
        L_0x00f8:
            java.lang.String r2 = "A_AAC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 13
            goto L_0x0194
        L_0x0104:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 21
            goto L_0x0194
        L_0x0110:
            java.lang.String r2 = "S_VOBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 30
            goto L_0x0194
        L_0x011c:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 7
            goto L_0x0194
        L_0x0127:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 5
            goto L_0x0194
        L_0x0132:
            java.lang.String r2 = "S_DVBSUB"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r8
            goto L_0x0194
        L_0x013c:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 9
            goto L_0x0194
        L_0x0147:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 15
            goto L_0x0194
        L_0x0152:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 14
            goto L_0x0194
        L_0x015d:
            java.lang.String r2 = "A_VORBIS"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 11
            goto L_0x0194
        L_0x0168:
            java.lang.String r2 = "A_TRUEHD"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 18
            goto L_0x0194
        L_0x0173:
            java.lang.String r2 = "A_MS/ACM"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 23
            goto L_0x0194
        L_0x017e:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = r10
            goto L_0x0194
        L_0x0188:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0018
            r2 = 6
            goto L_0x0194
        L_0x0193:
            r2 = r13
        L_0x0194:
            java.lang.String r14 = "text/x-ssa"
            java.lang.String r15 = "application/x-subrip"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "audio/raw"
            java.lang.String r18 = "audio/x-unknown"
            java.lang.String r7 = "MatroskaExtractor"
            java.lang.String r4 = ". Setting mimeType to audio/x-unknown"
            switch(r2) {
                case 0: goto L_0x03fa;
                case 1: goto L_0x03f3;
                case 2: goto L_0x03f0;
                case 3: goto L_0x03ed;
                case 4: goto L_0x03dd;
                case 5: goto L_0x03dd;
                case 6: goto L_0x03dd;
                case 7: goto L_0x03bf;
                case 8: goto L_0x03a1;
                case 9: goto L_0x0381;
                case 10: goto L_0x037b;
                case 11: goto L_0x0367;
                case 12: goto L_0x0320;
                case 13: goto L_0x0300;
                case 14: goto L_0x02f7;
                case 15: goto L_0x02f4;
                case 16: goto L_0x02ef;
                case 17: goto L_0x02ec;
                case 18: goto L_0x02e2;
                case 19: goto L_0x02df;
                case 20: goto L_0x02df;
                case 21: goto L_0x02dc;
                case 22: goto L_0x02cb;
                case 23: goto L_0x0281;
                case 24: goto L_0x0256;
                case 25: goto L_0x0224;
                case 26: goto L_0x01fc;
                case 27: goto L_0x01f4;
                case 28: goto L_0x01df;
                case 29: goto L_0x01da;
                case 30: goto L_0x01c9;
                case 31: goto L_0x01c3;
                case 32: goto L_0x01ae;
                default: goto L_0x01a5;
            }
        L_0x01a5:
            java.lang.String r1 = "Unrecognized codec identifier."
            r2 = 0
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zza(r1, r2)
            throw r1
        L_0x01ae:
            byte[] r2 = new byte[r10]
            byte[] r1 = r0.zzi(r1)
            java.lang.System.arraycopy(r1, r11, r2, r11, r10)
            com.google.android.gms.internal.ads.zzgbc r1 = com.google.android.gms.internal.ads.zzgbc.zzn(r2)
            java.lang.String r17 = "application/dvbsubs"
            r2 = r1
            r1 = r13
            r10 = r1
            r3 = 0
            goto L_0x0400
        L_0x01c3:
            java.lang.String r17 = "application/pgs"
            r1 = r13
            r10 = r1
            r2 = 0
            goto L_0x01d7
        L_0x01c9:
            byte[] r1 = r0.zzi(r1)
            com.google.android.gms.internal.ads.zzgbc r1 = com.google.android.gms.internal.ads.zzgbc.zzn(r1)
            java.lang.String r17 = "application/vobsub"
            r2 = r1
            r1 = r13
            r10 = r1
        L_0x01d7:
            r3 = 0
            goto L_0x0400
        L_0x01da:
            java.lang.String r17 = "text/vtt"
            r1 = r13
            r10 = r1
            goto L_0x01f8
        L_0x01df:
            byte[] r1 = com.google.android.gms.internal.ads.zzaiy.zzc
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            com.google.android.gms.internal.ads.zzgbc r1 = com.google.android.gms.internal.ads.zzgbc.zzo(r1, r2)
            r2 = r1
            r1 = r13
            r10 = r1
            r17 = r14
            goto L_0x01f9
        L_0x01f4:
            r1 = r13
            r10 = r1
            r17 = r15
        L_0x01f8:
            r2 = 0
        L_0x01f9:
            r3 = 0
            goto L_0x0400
        L_0x01fc:
            int r1 = r0.zzP
            if (r1 != r8) goto L_0x0205
            r1 = r13
        L_0x0201:
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x0205:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported floating point PCM bit depth: "
            r2.append(r3)
            r2.append(r1)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r1)
            r1 = r13
            r10 = r1
            r17 = r18
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x0224:
            int r1 = r0.zzP
            if (r1 != r9) goto L_0x022b
            r10 = r12
        L_0x0229:
            r1 = r13
            goto L_0x01f8
        L_0x022b:
            if (r1 != r5) goto L_0x0230
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0229
        L_0x0230:
            if (r1 != r3) goto L_0x0235
            r10 = 1342177280(0x50000000, float:8.5899346E9)
            goto L_0x0229
        L_0x0235:
            if (r1 != r8) goto L_0x023a
            r10 = 1610612736(0x60000000, float:3.6893488E19)
            goto L_0x0229
        L_0x023a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported big endian PCM bit depth: "
            r2.append(r3)
            r2.append(r1)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r1)
            r1 = r13
            r10 = r1
            r17 = r18
            goto L_0x0201
        L_0x0256:
            int r1 = r0.zzP
            int r10 = com.google.android.gms.internal.ads.zzgd.zzl(r1)
            if (r10 != 0) goto L_0x027c
            int r1 = r0.zzP
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported little endian PCM bit depth: "
            r2.append(r3)
            r2.append(r1)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r1)
            r1 = r13
            r10 = r1
            r17 = r18
            goto L_0x027d
        L_0x027c:
            r1 = r13
        L_0x027d:
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x0281:
            com.google.android.gms.internal.ads.zzfu r1 = new com.google.android.gms.internal.ads.zzfu
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.<init>((byte[]) r2)
            boolean r1 = zzh(r1)
            if (r1 == 0) goto L_0x02bd
            int r1 = r0.zzP
            int r10 = com.google.android.gms.internal.ads.zzgd.zzl(r1)
            if (r10 != 0) goto L_0x02b8
            int r1 = r0.zzP
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unsupported PCM bit depth: "
            r2.append(r3)
            r2.append(r1)
            r2.append(r4)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r1)
            r1 = r13
            r10 = r1
            r17 = r18
            goto L_0x02b9
        L_0x02b8:
            r1 = r13
        L_0x02b9:
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x02bd:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            com.google.android.gms.internal.ads.zzfk.zzf(r7, r1)
            r1 = r13
            r10 = r1
            r17 = r18
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x02cb:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r17 = "audio/flac"
            r2 = r1
            r1 = r13
            r10 = r1
            r3 = 0
            goto L_0x0400
        L_0x02dc:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x02f1
        L_0x02df:
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x02f1
        L_0x02e2:
            com.google.android.gms.internal.ads.zzafb r1 = new com.google.android.gms.internal.ads.zzafb
            r1.<init>()
            r0.zzT = r1
            java.lang.String r17 = "audio/true-hd"
            goto L_0x02f1
        L_0x02ec:
            java.lang.String r17 = "audio/eac3"
            goto L_0x02f1
        L_0x02ef:
            java.lang.String r17 = "audio/ac3"
        L_0x02f1:
            r1 = r13
            r10 = r1
            goto L_0x02fc
        L_0x02f4:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x02f9
        L_0x02f7:
            java.lang.String r17 = "audio/mpeg-L2"
        L_0x02f9:
            r10 = r13
            r1 = r16
        L_0x02fc:
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x0300:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = java.util.Collections.singletonList(r1)
            byte[] r2 = r0.zzj
            com.google.android.gms.internal.ads.zzacp r2 = com.google.android.gms.internal.ads.zzacq.zza(r2)
            int r3 = r2.zza
            r0.zzQ = r3
            int r3 = r2.zzb
            r0.zzO = r3
            java.lang.String r2 = r2.zzc
            java.lang.String r17 = "audio/mp4a-latm"
            r3 = r2
            r10 = r13
            r2 = r1
            r1 = r10
            goto L_0x0400
        L_0x0320:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r12)
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r9)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzR
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r9)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzS
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            r16 = 5760(0x1680, float:8.071E-42)
            java.lang.String r17 = "audio/opus"
            r2 = r1
            r10 = r13
            r1 = r16
            r3 = 0
            goto L_0x0400
        L_0x0367:
            byte[] r1 = r0.zzi(r1)
            java.util.List r1 = zzg(r1)
            r16 = 8192(0x2000, float:1.14794E-41)
            java.lang.String r17 = "audio/vorbis"
            r2 = r1
            r10 = r13
            r1 = r16
            r3 = 0
            goto L_0x0400
        L_0x037b:
            java.lang.String r17 = "video/x-unknown"
            r1 = r13
            r10 = r1
            r2 = 0
            goto L_0x039e
        L_0x0381:
            com.google.android.gms.internal.ads.zzfu r1 = new com.google.android.gms.internal.ads.zzfu
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.<init>((byte[]) r2)
            android.util.Pair r1 = zzf(r1)
            java.lang.Object r2 = r1.first
            r17 = r2
            java.lang.String r17 = (java.lang.String) r17
            java.lang.Object r1 = r1.second
            java.util.List r1 = (java.util.List) r1
            r2 = r1
            r1 = r13
            r10 = r1
        L_0x039e:
            r3 = 0
            goto L_0x0400
        L_0x03a1:
            com.google.android.gms.internal.ads.zzfu r1 = new com.google.android.gms.internal.ads.zzfu
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzaek r1 = com.google.android.gms.internal.ads.zzaek.zza(r1)
            java.util.List r2 = r1.zza
            int r3 = r1.zzb
            r0.zzX = r3
            java.lang.String r1 = r1.zzi
            java.lang.String r17 = "video/hevc"
            r3 = r1
            r1 = r13
            r10 = r1
            goto L_0x0400
        L_0x03bf:
            com.google.android.gms.internal.ads.zzfu r1 = new com.google.android.gms.internal.ads.zzfu
            java.lang.String r2 = r0.zzb
            byte[] r2 = r0.zzi(r2)
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzacx r1 = com.google.android.gms.internal.ads.zzacx.zza(r1)
            java.util.List r2 = r1.zza
            int r3 = r1.zzb
            r0.zzX = r3
            java.lang.String r1 = r1.zzk
            java.lang.String r17 = "video/avc"
            r3 = r1
            r1 = r13
            r10 = r1
            goto L_0x0400
        L_0x03dd:
            byte[] r1 = r0.zzj
            if (r1 != 0) goto L_0x03e3
            r1 = 0
            goto L_0x03e7
        L_0x03e3:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x03e7:
            java.lang.String r17 = "video/mp4v-es"
            r2 = r1
            r1 = r13
            r10 = r1
            goto L_0x03ff
        L_0x03ed:
            java.lang.String r17 = "video/mpeg2"
            goto L_0x03f5
        L_0x03f0:
            java.lang.String r17 = "video/av01"
            goto L_0x03f5
        L_0x03f3:
            java.lang.String r17 = "video/x-vnd.on2.vp9"
        L_0x03f5:
            r1 = r13
            r10 = r1
            r2 = 0
            r3 = 0
            goto L_0x0400
        L_0x03fa:
            java.lang.String r17 = "video/x-vnd.on2.vp8"
            r1 = r13
            r10 = r1
            r2 = 0
        L_0x03ff:
            r3 = 0
        L_0x0400:
            byte[] r4 = r0.zzN
            if (r4 == 0) goto L_0x0415
            com.google.android.gms.internal.ads.zzfu r4 = new com.google.android.gms.internal.ads.zzfu
            byte[] r5 = r0.zzN
            r4.<init>((byte[]) r5)
            com.google.android.gms.internal.ads.zzado r4 = com.google.android.gms.internal.ads.zzado.zza(r4)
            if (r4 == 0) goto L_0x0415
            java.lang.String r3 = r4.zza
            java.lang.String r17 = "video/dolby-vision"
        L_0x0415:
            r4 = r17
            boolean r5 = r0.zzV
            boolean r7 = r0.zzU
            if (r6 == r7) goto L_0x041f
            r7 = r11
            goto L_0x0420
        L_0x041f:
            r7 = 2
        L_0x0420:
            r5 = r5 | r7
            com.google.android.gms.internal.ads.zzal r7 = new com.google.android.gms.internal.ads.zzal
            r7.<init>()
            boolean r8 = com.google.android.gms.internal.ads.zzcg.zzg(r4)
            if (r8 == 0) goto L_0x043b
            int r8 = r0.zzO
            r7.zzy(r8)
            int r8 = r0.zzQ
            r7.zzY(r8)
            r7.zzR(r10)
            goto L_0x061c
        L_0x043b:
            boolean r6 = com.google.android.gms.internal.ads.zzcg.zzh(r4)
            if (r6 == 0) goto L_0x05e4
            int r6 = r0.zzq
            if (r6 != 0) goto L_0x0455
            int r6 = r0.zzo
            if (r6 != r13) goto L_0x044b
            int r6 = r0.zzl
        L_0x044b:
            r0.zzo = r6
            int r6 = r0.zzp
            if (r6 != r13) goto L_0x0453
            int r6 = r0.zzm
        L_0x0453:
            r0.zzp = r6
        L_0x0455:
            int r6 = r0.zzo
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r6 == r13) goto L_0x0469
            int r9 = r0.zzp
            if (r9 == r13) goto L_0x0469
            int r10 = r0.zzm
            int r10 = r10 * r6
            int r6 = r0.zzl
            int r6 = r6 * r9
            float r9 = (float) r10
            float r6 = (float) r6
            float r9 = r9 / r6
            goto L_0x046a
        L_0x0469:
            r9 = r8
        L_0x046a:
            boolean r6 = r0.zzx
            if (r6 == 0) goto L_0x054f
            float r6 = r0.zzD
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzE
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzF
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzG
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzH
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzI
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzJ
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzK
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzL
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0528
            float r6 = r0.zzM
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x04ad
            r6 = 0
            goto L_0x0529
        L_0x04ad:
            r6 = 25
            byte[] r6 = new byte[r6]
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.wrap(r6)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN
            java.nio.ByteBuffer r8 = r8.order(r10)
            r8.put(r11)
            float r10 = r0.zzD
            r12 = 1195593728(0x47435000, float:50000.0)
            float r10 = r10 * r12
            r14 = 1056964608(0x3f000000, float:0.5)
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzE
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzF
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzG
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzH
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzI
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzJ
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzK
            float r10 = r10 * r12
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzL
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            float r10 = r0.zzM
            float r10 = r10 + r14
            int r10 = (int) r10
            short r10 = (short) r10
            r8.putShort(r10)
            int r10 = r0.zzB
            short r10 = (short) r10
            r8.putShort(r10)
            int r10 = r0.zzC
            short r10 = (short) r10
            r8.putShort(r10)
            goto L_0x0529
        L_0x0528:
            r6 = 0
        L_0x0529:
            com.google.android.gms.internal.ads.zzr r8 = new com.google.android.gms.internal.ads.zzr
            r8.<init>()
            int r10 = r0.zzy
            r8.zzc(r10)
            int r10 = r0.zzA
            r8.zzb(r10)
            int r10 = r0.zzz
            r8.zzd(r10)
            r8.zze(r6)
            int r6 = r0.zzn
            r8.zzf(r6)
            int r6 = r0.zzn
            r8.zza(r6)
            com.google.android.gms.internal.ads.zzt r6 = r8.zzg()
            goto L_0x0550
        L_0x054f:
            r6 = 0
        L_0x0550:
            java.lang.String r8 = r0.zza
            if (r8 == 0) goto L_0x0571
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaiy.zzg
            java.lang.String r10 = r0.zza
            boolean r8 = r8.containsKey(r10)
            if (r8 == 0) goto L_0x0571
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaiy.zzg
            java.lang.String r10 = r0.zza
            java.lang.Object r8 = r8.get(r10)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r13 = r8.intValue()
            goto L_0x0572
        L_0x0571:
        L_0x0572:
            int r8 = r0.zzr
            if (r8 != 0) goto L_0x05c4
            float r8 = r0.zzs
            r10 = 0
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x05c4
            float r8 = r0.zzt
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x05c4
            float r8 = r0.zzu
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x0590
            goto L_0x05c5
        L_0x0590:
            float r8 = r0.zzu
            r10 = 1119092736(0x42b40000, float:90.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x059d
            r11 = 90
            goto L_0x05c5
        L_0x059d:
            float r8 = r0.zzu
            r10 = -1020002304(0xffffffffc3340000, float:-180.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 == 0) goto L_0x05c1
            float r8 = r0.zzu
            r10 = 1127481344(0x43340000, float:180.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x05b4
            r11 = 180(0xb4, float:2.52E-43)
            goto L_0x05c5
        L_0x05b4:
            float r8 = r0.zzu
            r10 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r8 = java.lang.Float.compare(r8, r10)
            if (r8 != 0) goto L_0x05c4
            r11 = 270(0x10e, float:3.78E-43)
            goto L_0x05c5
        L_0x05c1:
            r11 = 180(0xb4, float:2.52E-43)
            goto L_0x05c5
        L_0x05c4:
            r11 = r13
        L_0x05c5:
            int r8 = r0.zzl
            r7.zzac(r8)
            int r8 = r0.zzm
            r7.zzI(r8)
            r7.zzT(r9)
            r7.zzW(r11)
            byte[] r8 = r0.zzv
            r7.zzU(r8)
            int r8 = r0.zzw
            r7.zzaa(r8)
            r7.zzA(r6)
            r6 = 2
            goto L_0x061c
        L_0x05e4:
            boolean r6 = r15.equals(r4)
            if (r6 != 0) goto L_0x061b
            boolean r6 = r14.equals(r4)
            if (r6 != 0) goto L_0x061b
            java.lang.String r6 = "text/vtt"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x061b
            java.lang.String r6 = "application/vobsub"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x061b
            java.lang.String r6 = "application/pgs"
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L_0x061b
            java.lang.String r6 = "application/dvbsubs"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0612
            goto L_0x061b
        L_0x0612:
            java.lang.String r1 = "Unexpected MIME type."
            r2 = 0
            com.google.android.gms.internal.ads.zzch r1 = com.google.android.gms.internal.ads.zzch.zza(r1, r2)
            throw r1
        L_0x061b:
            r6 = r12
        L_0x061c:
            java.lang.String r8 = r0.zza
            if (r8 == 0) goto L_0x0631
            java.util.Map r8 = com.google.android.gms.internal.ads.zzaiy.zzg
            java.lang.String r9 = r0.zza
            boolean r8 = r8.containsKey(r9)
            if (r8 != 0) goto L_0x0631
            java.lang.String r8 = r0.zza
            r7.zzM(r8)
        L_0x0631:
            r8 = r21
            r7.zzJ(r8)
            r7.zzX(r4)
            r7.zzP(r1)
            java.lang.String r1 = r0.zzZ
            r7.zzO(r1)
            r7.zzZ(r5)
            r7.zzL(r2)
            r7.zzz(r3)
            com.google.android.gms.internal.ads.zzae r1 = r0.zzk
            r7.zzE(r1)
            com.google.android.gms.internal.ads.zzan r1 = r7.zzad()
            int r2 = r0.zzc
            r3 = r20
            com.google.android.gms.internal.ads.zzafa r2 = r3.zzw(r2, r6)
            r0.zzW = r2
            com.google.android.gms.internal.ads.zzafa r2 = r0.zzW
            r2.zzl(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaix.zze(com.google.android.gms.internal.ads.zzadx, int):void");
    }
}
