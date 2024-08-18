package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzbrf;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbyk;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcjd;
import com.google.android.gms.internal.ads.zzdmn;
import com.google.android.gms.internal.ads.zzdmp;
import com.google.android.gms.internal.ads.zzdwl;
import com.google.android.gms.internal.ads.zzeof;
import com.google.android.gms.internal.ads.zzfbt;
import com.google.android.gms.internal.ads.zzfbu;
import com.google.android.gms.internal.ads.zzfdh;
import com.google.android.gms.internal.ads.zzfey;
import com.google.android.gms.internal.ads.zzfgm;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class ClientApi extends zzcd {
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeof(zzcjd.zzb(context, zzbrf, i), context, str);
    }

    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbt zzt = zzcjd.zzb(context, zzbrf, i).zzt();
        zzt.zza(str);
        zzt.zzb(context);
        zzfbu zzc = zzt.zzc();
        if (i >= ((Integer) zzba.zzc().zza(zzbep.zzfp)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfdh zzu = zzcjd.zzb(context, zzbrf, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzq);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfey zzv = zzcjd.zzb(context, zzbrf, i).zzv();
        zzv.zzc(context);
        zzv.zza(zzq);
        zzv.zzb(str);
        return zzv.zzd().zza();
    }

    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzq, String str, int i) {
        return new zzt((Context) ObjectWrapper.unwrap(iObjectWrapper), zzq, str, new VersionInfoParcel(241806000, i, true, false));
    }

    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) {
        return zzcjd.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), (zzbrf) null, i).zzc();
    }

    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbrf zzbrf, int i) {
        return zzcjd.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrf, i).zzm();
    }

    public final zzbhz zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdmp((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 241806000);
    }

    public final zzbif zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdmn((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbmr zzk(IObjectWrapper iObjectWrapper, zzbrf zzbrf, int i, zzbmo zzbmo) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdwl zzk = zzcjd.zzb(context, zzbrf, i).zzk();
        zzk.zzb(context);
        zzk.zza(zzbmo);
        return zzk.zzc().zzd();
    }

    public final zzbuz zzl(IObjectWrapper iObjectWrapper, zzbrf zzbrf, int i) {
        return zzcjd.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrf, i).zzn();
    }

    public final zzbvg zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzu(activity);
        }
        switch (zza.zzk) {
            case 1:
                return new zzt(activity);
            case 2:
                return new zzaf(activity);
            case 3:
                return new zzag(activity);
            case 4:
                return new zzz(activity, zza);
            case 5:
                return new zzad(activity);
            default:
                return new zzu(activity);
        }
    }

    public final zzbyk zzn(IObjectWrapper iObjectWrapper, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfgm zzw = zzcjd.zzb(context, zzbrf, i).zzw();
        zzw.zzb(context);
        return zzw.zzc().zzb();
    }

    public final zzbza zzo(IObjectWrapper iObjectWrapper, String str, zzbrf zzbrf, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfgm zzw = zzcjd.zzb(context, zzbrf, i).zzw();
        zzw.zzb(context);
        zzw.zza(str);
        return zzw.zzc().zza();
    }

    public final zzcbg zzp(IObjectWrapper iObjectWrapper, zzbrf zzbrf, int i) {
        return zzcjd.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbrf, i).zzq();
    }
}
