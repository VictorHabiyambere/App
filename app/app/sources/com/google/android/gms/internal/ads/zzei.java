package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import androidx.core.view.ViewCompat;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzei {
    private static final String zzA = Integer.toString(7, 36);
    private static final String zzB = Integer.toString(8, 36);
    private static final String zzC = Integer.toString(9, 36);
    private static final String zzD = Integer.toString(10, 36);
    private static final String zzE = Integer.toString(11, 36);
    private static final String zzF = Integer.toString(12, 36);
    private static final String zzG = Integer.toString(13, 36);
    private static final String zzH = Integer.toString(14, 36);
    private static final String zzI = Integer.toString(15, 36);
    private static final String zzJ = Integer.toString(16, 36);
    @Deprecated
    public static final zzei zza;
    @Deprecated
    public static final zzn zzb = new zzee();
    private static final String zzr = Integer.toString(0, 36);
    private static final String zzs = Integer.toString(17, 36);
    private static final String zzt = Integer.toString(1, 36);
    private static final String zzu = Integer.toString(2, 36);
    private static final String zzv = Integer.toString(3, 36);
    private static final String zzw = Integer.toString(18, 36);
    private static final String zzx = Integer.toString(4, 36);
    private static final String zzy = Integer.toString(5, 36);
    private static final String zzz = Integer.toString(6, 36);
    public final CharSequence zzc;
    public final Layout.Alignment zzd;
    public final Layout.Alignment zze;
    public final Bitmap zzf;
    public final float zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final int zzk;
    public final float zzl;
    public final float zzm;
    public final int zzn;
    public final float zzo;
    public final int zzp;
    public final float zzq;

    static {
        zzeg zzeg = new zzeg();
        zzeg.zzl("");
        zza = zzeg.zzp();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r2 = r4.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        r3 = r5.zzf;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r5 == 0) goto L_0x008f
            java.lang.Class r2 = r4.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0013
            goto L_0x008f
        L_0x0013:
            com.google.android.gms.internal.ads.zzei r5 = (com.google.android.gms.internal.ads.zzei) r5
            java.lang.CharSequence r2 = r4.zzc
            java.lang.CharSequence r3 = r5.zzc
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x008e
            android.text.Layout$Alignment r2 = r4.zzd
            android.text.Layout$Alignment r3 = r5.zzd
            if (r2 != r3) goto L_0x008e
            android.text.Layout$Alignment r2 = r4.zze
            android.text.Layout$Alignment r3 = r5.zze
            if (r2 != r3) goto L_0x008e
            android.graphics.Bitmap r2 = r4.zzf
            if (r2 != 0) goto L_0x0034
            android.graphics.Bitmap r2 = r5.zzf
            if (r2 != 0) goto L_0x008e
            goto L_0x003f
        L_0x0034:
            android.graphics.Bitmap r3 = r5.zzf
            if (r3 == 0) goto L_0x008e
            boolean r2 = r2.sameAs(r3)
            if (r2 != 0) goto L_0x003f
            goto L_0x008e
        L_0x003f:
            float r2 = r4.zzg
            float r3 = r5.zzg
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x008e
            int r2 = r4.zzh
            int r3 = r5.zzh
            if (r2 != r3) goto L_0x008e
            int r2 = r4.zzi
            int r3 = r5.zzi
            if (r2 != r3) goto L_0x008e
            float r2 = r4.zzj
            float r3 = r5.zzj
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x008e
            int r2 = r4.zzk
            int r3 = r5.zzk
            if (r2 != r3) goto L_0x008e
            float r2 = r4.zzl
            float r3 = r5.zzl
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x008e
            float r2 = r4.zzm
            float r3 = r5.zzm
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x008e
            int r2 = r4.zzn
            int r3 = r5.zzn
            if (r2 != r3) goto L_0x008e
            float r2 = r4.zzo
            float r3 = r5.zzo
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x008e
            int r2 = r4.zzp
            int r3 = r5.zzp
            if (r2 != r3) goto L_0x008e
            float r2 = r4.zzq
            float r5 = r5.zzq
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x008e
            return r0
        L_0x008e:
            return r1
        L_0x008f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzei.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        CharSequence charSequence = this.zzc;
        return Arrays.hashCode(new Object[]{charSequence, this.zzd, this.zze, this.zzf, Float.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), Float.valueOf(this.zzj), Integer.valueOf(this.zzk), Float.valueOf(this.zzl), Float.valueOf(this.zzm), false, Integer.valueOf(ViewCompat.MEASURED_STATE_MASK), Integer.valueOf(this.zzn), Float.valueOf(this.zzo), Integer.valueOf(this.zzp), Float.valueOf(this.zzq)});
    }

    public final Bundle zza() {
        Bundle bundle = new Bundle();
        CharSequence charSequence = this.zzc;
        if (charSequence != null) {
            bundle.putCharSequence(zzr, charSequence);
            CharSequence charSequence2 = this.zzc;
            if (charSequence2 instanceof Spanned) {
                ArrayList zza2 = zzel.zza((Spanned) charSequence2);
                if (!zza2.isEmpty()) {
                    bundle.putParcelableArrayList(zzs, zza2);
                }
            }
        }
        bundle.putSerializable(zzt, this.zzd);
        bundle.putSerializable(zzu, this.zze);
        bundle.putFloat(zzx, this.zzg);
        bundle.putInt(zzy, this.zzh);
        bundle.putInt(zzz, this.zzi);
        bundle.putFloat(zzA, this.zzj);
        bundle.putInt(zzB, this.zzk);
        bundle.putInt(zzC, this.zzn);
        bundle.putFloat(zzD, this.zzo);
        bundle.putFloat(zzE, this.zzl);
        bundle.putFloat(zzF, this.zzm);
        bundle.putBoolean(zzH, false);
        bundle.putInt(zzG, ViewCompat.MEASURED_STATE_MASK);
        bundle.putInt(zzI, this.zzp);
        bundle.putFloat(zzJ, this.zzq);
        if (this.zzf != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            zzeq.zzf(this.zzf.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream));
            bundle.putByteArray(zzw, byteArrayOutputStream.toByteArray());
        }
        return bundle;
    }

    public final zzeg zzb() {
        return new zzeg(this, (zzef) null);
    }

    /* synthetic */ zzei(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z, int i5, int i6, float f6, zzeh zzeh) {
        boolean z2;
        CharSequence charSequence2 = charSequence;
        Bitmap bitmap2 = bitmap;
        if (charSequence2 != null) {
            if (bitmap2 == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzeq.zzd(z2);
        } else if (bitmap2 == null) {
            throw null;
        }
        if (charSequence2 instanceof Spanned) {
            this.zzc = SpannedString.valueOf(charSequence);
        } else if (charSequence2 != null) {
            this.zzc = charSequence.toString();
        } else {
            this.zzc = null;
        }
        this.zzd = alignment;
        this.zze = alignment2;
        this.zzf = bitmap2;
        this.zzg = f;
        this.zzh = i;
        this.zzi = i2;
        this.zzj = f2;
        this.zzk = i3;
        this.zzl = f4;
        this.zzm = f5;
        this.zzn = i4;
        this.zzo = f3;
        this.zzp = i6;
        this.zzq = f6;
    }
}
