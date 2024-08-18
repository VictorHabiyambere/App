package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbdv;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdju implements zzczl, zzdgn {
    private final zzcaq zza;
    private final Context zzb;
    private final zzcau zzc;
    private final View zzd;
    private String zze;
    private final zzbdv.zza.C0000zza zzf;

    public zzdju(zzcaq zzcaq, Context context, zzcau zzcau, View view, zzbdv.zza.C0000zza zza2) {
        this.zza = zzcaq;
        this.zzb = context;
        this.zzc = zzcau;
        this.zzd = view;
        this.zzf = zza2;
    }

    public final void zza() {
        this.zza.zzb(false);
    }

    public final void zzb() {
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbyh zzbyh, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzcau zzcau = this.zzc;
                Context context = this.zzb;
                zzcau.zzl(context, zzcau.zza(context), this.zza.zza(), zzbyh.zzc(), zzbyh.zzb());
            } catch (RemoteException e) {
                zzm.zzk("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzk() {
    }

    public final void zzl() {
        if (this.zzf != zzbdv.zza.C0000zza.APP_OPEN) {
            this.zze = this.zzc.zzc(this.zzb);
            this.zze = String.valueOf(this.zze).concat(this.zzf == zzbdv.zza.C0000zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
        }
    }
}
