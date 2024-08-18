package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzcsm {
    private final zzcun zza;
    private final View zzb;
    private final zzfgu zzc;
    private final zzchd zzd;

    public zzcsm(View view, zzchd zzchd, zzcun zzcun, zzfgu zzfgu) {
        this.zzb = view;
        this.zzd = zzchd;
        this.zza = zzcun;
        this.zzc = zzfgu;
    }

    public static final zzdha zzf(Context context, VersionInfoParcel versionInfoParcel, zzfgt zzfgt, zzfho zzfho) {
        return new zzdha(new zzcsk(context, versionInfoParcel, zzfgt, zzfho), zzcci.zzf);
    }

    public static final Set zzg(zzcue zzcue) {
        return Collections.singleton(new zzdha(zzcue, zzcci.zzf));
    }

    public static final zzdha zzh(zzcuc zzcuc) {
        return new zzdha(zzcuc, zzcci.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzchd zzb() {
        return this.zzd;
    }

    public final zzcun zzc() {
        return this.zza;
    }

    public zzdax zzd(Set set) {
        return new zzdax(set);
    }

    public final zzfgu zze() {
        return this.zzc;
    }
}
