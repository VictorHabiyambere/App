package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeg {
    private CharSequence zza;
    private Bitmap zzb;
    private Layout.Alignment zzc;
    private Layout.Alignment zzd;
    private float zze;
    private int zzf;
    private int zzg;
    private float zzh;
    private int zzi;
    private int zzj;
    private float zzk;
    private float zzl;
    private float zzm;
    private int zzn;
    private float zzo;

    public zzeg() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = -3.4028235E38f;
        this.zzf = Integer.MIN_VALUE;
        this.zzg = Integer.MIN_VALUE;
        this.zzh = -3.4028235E38f;
        this.zzi = Integer.MIN_VALUE;
        this.zzj = Integer.MIN_VALUE;
        this.zzk = -3.4028235E38f;
        this.zzl = -3.4028235E38f;
        this.zzm = -3.4028235E38f;
        this.zzn = Integer.MIN_VALUE;
    }

    /* synthetic */ zzeg(zzei zzei, zzef zzef) {
        this.zza = zzei.zzc;
        this.zzb = zzei.zzf;
        this.zzc = zzei.zzd;
        this.zzd = zzei.zze;
        this.zze = zzei.zzg;
        this.zzf = zzei.zzh;
        this.zzg = zzei.zzi;
        this.zzh = zzei.zzj;
        this.zzi = zzei.zzk;
        this.zzj = zzei.zzn;
        this.zzk = zzei.zzo;
        this.zzl = zzei.zzl;
        this.zzm = zzei.zzm;
        this.zzn = zzei.zzp;
        this.zzo = zzei.zzq;
    }

    @Pure
    public final int zza() {
        return this.zzg;
    }

    @Pure
    public final int zzb() {
        return this.zzi;
    }

    public final zzeg zzc(Bitmap bitmap) {
        this.zzb = bitmap;
        return this;
    }

    public final zzeg zzd(float f) {
        this.zzm = f;
        return this;
    }

    public final zzeg zze(float f, int i) {
        this.zze = f;
        this.zzf = i;
        return this;
    }

    public final zzeg zzf(int i) {
        this.zzg = i;
        return this;
    }

    public final zzeg zzg(Layout.Alignment alignment) {
        this.zzd = alignment;
        return this;
    }

    public final zzeg zzh(float f) {
        this.zzh = f;
        return this;
    }

    public final zzeg zzi(int i) {
        this.zzi = i;
        return this;
    }

    public final zzeg zzj(float f) {
        this.zzo = f;
        return this;
    }

    public final zzeg zzk(float f) {
        this.zzl = f;
        return this;
    }

    public final zzeg zzl(CharSequence charSequence) {
        this.zza = charSequence;
        return this;
    }

    public final zzeg zzm(Layout.Alignment alignment) {
        this.zzc = alignment;
        return this;
    }

    public final zzeg zzn(float f, int i) {
        this.zzk = f;
        this.zzj = i;
        return this;
    }

    public final zzeg zzo(int i) {
        this.zzn = i;
        return this;
    }

    public final zzei zzp() {
        return new zzei(this.zza, this.zzc, this.zzd, this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, false, ViewCompat.MEASURED_STATE_MASK, this.zzn, this.zzo, (zzeh) null);
    }

    @Pure
    public final CharSequence zzq() {
        return this.zza;
    }
}
