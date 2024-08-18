package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcdt {
    private final Context zza;
    private final zzcee zzb;
    private final ViewGroup zzc;
    private zzcds zzd;

    public zzcdt(Context context, ViewGroup viewGroup, zzchd zzchd) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzchd;
        this.zzd = null;
    }

    public final zzcds zza() {
        return this.zzd;
    }

    public final Integer zzb() {
        zzcds zzcds = this.zzd;
        if (zzcds != null) {
            return zzcds.zzl();
        }
        return null;
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcds zzcds = this.zzd;
        if (zzcds != null) {
            zzcds.zzF(i, i2, i3, i4);
        }
    }

    public final void zzd(int i, int i2, int i3, int i4, int i5, boolean z, zzced zzced) {
        if (this.zzd == null) {
            zzbew.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
            Context context = this.zza;
            zzcee zzcee = this.zzb;
            this.zzd = new zzcds(context, zzcee, i5, z, zzcee.zzm().zza(), zzced);
            this.zzc.addView(this.zzd, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            this.zzd.zzF(i, i2, i3, i4);
            this.zzb.zzz(false);
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcds zzcds = this.zzd;
        if (zzcds != null) {
            zzcds.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcds zzcds = this.zzd;
        if (zzcds != null) {
            zzcds.zzu();
        }
    }

    public final void zzg(int i) {
        zzcds zzcds = this.zzd;
        if (zzcds != null) {
            zzcds.zzC(i);
        }
    }
}
