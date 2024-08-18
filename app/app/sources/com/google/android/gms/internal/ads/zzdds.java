package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdds implements AppEventListener, OnAdMetadataChangedListener, zzczl, zza, zzdbw, zzdaf, zzdbk, zzp, zzdab, zzdhi {
    private final zzddq zza = new zzddq(this, (zzddp) null);
    /* access modifiers changed from: private */
    @Nullable
    public zzepc zzb;
    /* access modifiers changed from: private */
    @Nullable
    public zzepg zzc;
    /* access modifiers changed from: private */
    @Nullable
    public zzfcr zzd;
    /* access modifiers changed from: private */
    @Nullable
    public zzffw zze;

    private static void zzn(Object obj, zzddr zzddr) {
        if (obj != null) {
            zzddr.zza(obj);
        }
    }

    public final void onAdClicked() {
        zzn(this.zzb, new zzdci());
        zzn(this.zzc, new zzdcj());
    }

    public final void onAdMetadataChanged() {
        zzn(this.zze, new zzdco());
    }

    public final void onAppEvent(String str, String str2) {
        zzn(this.zzb, new zzdcu(str, str2));
    }

    public final void zza() {
        zzn(this.zzb, new zzddn());
        zzn(this.zze, new zzddo());
    }

    public final void zzb() {
        zzn(this.zzb, new zzddg());
        zzn(this.zze, new zzddh());
    }

    public final void zzc() {
        zzn(this.zzb, new zzdcp());
        zzn(this.zze, new zzdcq());
    }

    public final void zzdG() {
        zzn(this.zzb, new zzddd());
        zzn(this.zzc, new zzddi());
        zzn(this.zze, new zzddj());
        zzn(this.zzd, new zzddk());
    }

    public final void zzdH() {
        zzn(this.zzd, new zzddb());
    }

    public final void zzdf() {
        zzn(this.zzb, new zzdcv());
    }

    public final void zzdk() {
        zzn(this.zzd, new zzdcn());
    }

    public final void zzdq() {
        zzn(this.zzd, new zzdda());
    }

    public final void zzdr() {
        zzn(this.zzd, new zzdcw());
    }

    public final void zzds(zzbyh zzbyh, String str, String str2) {
        zzn(this.zzb, new zzdcr(zzbyh, str, str2));
        zzn(this.zze, new zzdct(zzbyh, str, str2));
    }

    public final void zzdt() {
        zzn(this.zzd, new zzddc());
    }

    public final void zzdu(int i) {
        zzn(this.zzd, new zzdde(i));
    }

    public final void zze() {
        zzn(this.zzb, new zzdch());
        zzn(this.zze, new zzdcs());
    }

    public final void zzf() {
        zzn(this.zzb, new zzdck());
        zzn(this.zze, new zzdcl());
    }

    public final void zzg() {
        zzn(this.zzd, new zzddf());
    }

    public final void zzh(zzs zzs) {
        zzn(this.zzb, new zzdcx(zzs));
        zzn(this.zze, new zzdcy(zzs));
        zzn(this.zzd, new zzdcz(zzs));
    }

    public final zzddq zzi() {
        return this.zza;
    }

    public final void zzq(zze zze2) {
        zzn(this.zze, new zzddl(zze2));
        zzn(this.zzb, new zzddm(zze2));
    }

    public final void zzr() {
        zzn(this.zzb, new zzdcm());
    }
}
