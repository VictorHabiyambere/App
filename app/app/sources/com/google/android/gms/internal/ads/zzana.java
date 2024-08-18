package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzana implements zzalv {
    private final zzfu zza = new zzfu();
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final float zzf;
    private final int zzg;

    public zzana(List list) {
        String str = "sans-serif";
        boolean z = false;
        if (list.size() == 1 && (((byte[]) list.get(0)).length == 48 || ((byte[]) list.get(0)).length == 53)) {
            byte[] bArr = (byte[]) list.get(0);
            this.zzc = bArr[24];
            this.zzd = ((bArr[26] & 255) << Ascii.CAN) | ((bArr[27] & 255) << Ascii.DLE) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.zze = true == "Serif".equals(zzgd.zzB(bArr, 43, bArr.length + -43)) ? "serif" : str;
            int i = bArr[25] * Ascii.DC4;
            this.zzg = i;
            z = (bArr[0] & 32) != 0 ? true : z;
            this.zzb = z;
            if (z) {
                this.zzf = Math.max(0.0f, Math.min(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i), 0.95f));
            } else {
                this.zzf = 0.85f;
            }
        } else {
            this.zzc = 0;
            this.zzd = -1;
            this.zze = str;
            this.zzb = false;
            this.zzf = 0.85f;
            this.zzg = -1;
        }
    }

    private static void zzb(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void zzc(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            int i7 = i & 1;
            int i8 = i & 2;
            boolean z = true;
            if (i7 != 0) {
                if (i8 != 0) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                    z = false;
                }
            } else if (i8 != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            } else {
                z = false;
            }
            if ((i & 4) != 0) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            } else if (i7 == 0 && !z) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    public final void zza(byte[] bArr, int i, int i2, zzalu zzalu, zzev zzev) {
        boolean z;
        String str;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6 = i;
        zzev zzev2 = zzev;
        this.zza.zzI(bArr, i6 + i2);
        this.zza.zzK(i6);
        zzfu zzfu = this.zza;
        boolean z3 = true;
        boolean z4 = false;
        int i7 = 2;
        if (zzfu.zzb() >= 2) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zzd(z);
        int zzq = zzfu.zzq();
        if (zzq == 0) {
            str = "";
        } else {
            int zzd2 = zzfu.zzd();
            Charset zzB = zzfu.zzB();
            int zzd3 = zzfu.zzd() - zzd2;
            if (zzB == null) {
                zzB = zzfxs.zzc;
            }
            str = zzfu.zzA(zzq - zzd3, zzB);
        }
        if (str.isEmpty()) {
            zzev2.zza(new zzaln(zzgbc.zzm(), -9223372036854775807L, -9223372036854775807L));
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        zzc(spannableStringBuilder2, this.zzc, 0, 0, spannableStringBuilder.length(), 16711680);
        zzb(spannableStringBuilder2, this.zzd, -1, 0, spannableStringBuilder.length(), 16711680);
        String str2 = this.zze;
        int length = spannableStringBuilder.length();
        if (str2 != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str2), 0, length, 16711713);
        }
        float f = this.zzf;
        while (true) {
            zzfu zzfu2 = this.zza;
            if (zzfu2.zzb() >= 8) {
                int zzd4 = zzfu2.zzd();
                int zzg2 = zzfu2.zzg();
                int zzg3 = this.zza.zzg();
                if (zzg3 == 1937013100) {
                    zzeq.zzd(this.zza.zzb() >= i7 ? z3 : z4);
                    int zzq2 = this.zza.zzq();
                    int i8 = z4;
                    while (i8 < zzq2) {
                        zzfu zzfu3 = this.zza;
                        zzeq.zzd(zzfu3.zzb() >= 12 ? z3 : z4);
                        int zzq3 = zzfu3.zzq();
                        int zzq4 = zzfu3.zzq();
                        zzfu3.zzL(i7);
                        int zzm = zzfu3.zzm();
                        zzfu3.zzL(z3 ? 1 : 0);
                        int zzg4 = zzfu3.zzg();
                        if (zzq4 > spannableStringBuilder.length()) {
                            int length2 = spannableStringBuilder.length();
                            StringBuilder sb = new StringBuilder();
                            i4 = zzq2;
                            sb.append("Truncating styl end (");
                            sb.append(zzq4);
                            sb.append(") to cueText.length() (");
                            sb.append(length2);
                            sb.append(").");
                            zzfk.zzf("Tx3gParser", sb.toString());
                            i5 = spannableStringBuilder.length();
                        } else {
                            i4 = zzq2;
                            i5 = zzq4;
                        }
                        if (zzq3 >= i5) {
                            zzfk.zzf("Tx3gParser", "Ignoring styl with start (" + zzq3 + ") >= end (" + i5 + ").");
                        } else {
                            SpannableStringBuilder spannableStringBuilder3 = spannableStringBuilder;
                            int i9 = zzq3;
                            int i10 = i5;
                            zzc(spannableStringBuilder3, zzm, this.zzc, i9, i10, 0);
                            zzb(spannableStringBuilder3, zzg4, this.zzd, i9, i10, 0);
                        }
                        i8++;
                        zzq2 = i4;
                        z3 = true;
                        z4 = false;
                        i7 = 2;
                    }
                    i3 = 2;
                } else if (zzg3 != 1952608120 || !this.zzb) {
                    i3 = 2;
                } else {
                    i3 = 2;
                    if (this.zza.zzb() >= 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzeq.zzd(z2);
                    f = Math.max(0.0f, Math.min(((float) this.zza.zzq()) / ((float) this.zzg), 0.95f));
                }
                this.zza.zzK(zzd4 + zzg2);
                i7 = i3;
                z3 = true;
                z4 = false;
            } else {
                zzeg zzeg = new zzeg();
                zzeg.zzl(spannableStringBuilder);
                zzeg.zze(f, 0);
                zzeg.zzf(0);
                zzev2.zza(new zzaln(zzgbc.zzn(zzeg.zzp()), -9223372036854775807L, -9223372036854775807L));
                return;
            }
        }
    }
}
