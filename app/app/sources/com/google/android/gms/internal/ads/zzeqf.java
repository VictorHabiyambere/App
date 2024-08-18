package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeqf implements zzexw {
    private final zzgge zza;
    private final zzgge zzb;
    private final Context zzc;
    private final zzfho zzd;
    private final View zze;

    public zzeqf(zzgge zzgge, zzgge zzgge2, Context context, zzfho zzfho, ViewGroup viewGroup) {
        this.zza = zzgge;
        this.zzb = zzgge2;
        this.zzc = context;
        this.zzd = zzfho;
        this.zze = viewGroup;
    }

    private final List zze() {
        int i;
        ArrayList arrayList = new ArrayList();
        View view = this.zze;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            if (parent instanceof ViewGroup) {
                i = ((ViewGroup) parent).indexOfChild(view);
            } else {
                i = -1;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return arrayList;
    }

    public final int zza() {
        return 3;
    }

    public final ListenableFuture zzb() {
        zzbep.zza(this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbep.zzla)).booleanValue()) {
            return this.zzb.zzb(new zzeqd(this));
        }
        return this.zza.zzb(new zzeqe(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqg zzc() throws Exception {
        return new zzeqg(this.zzc, this.zzd.zze, zze());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqg zzd() throws Exception {
        return new zzeqg(this.zzc, this.zzd.zze, zze());
    }
}
