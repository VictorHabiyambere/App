package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdqa extends zzbio {
    private final Context zza;
    private final zzdlt zzb;
    private zzdmt zzc;
    /* access modifiers changed from: private */
    public zzdlo zzd;

    public zzdqa(Context context, zzdlt zzdlt, zzdmt zzdmt, zzdlo zzdlo) {
        this.zza = context;
        this.zzb = zzdlt;
        this.zzc = zzdmt;
        this.zzd = zzdlo;
    }

    private final zzbhj zzd(String str) {
        return new zzdpz(this, NativeCustomFormatAd.ASSET_NAME_VIDEO);
    }

    public final zzdq zze() {
        return this.zzb.zzj();
    }

    public final zzbhs zzf() throws RemoteException {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    public final zzbhv zzg(String str) {
        return (zzbhv) this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzi() {
        return this.zzb.zzA();
    }

    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    public final List zzk() {
        try {
            SimpleArrayMap zzh = this.zzb.zzh();
            SimpleArrayMap zzi = this.zzb.zzi();
            String[] strArr = new String[(zzh.size() + zzi.size())];
            int i = 0;
            for (int i2 = 0; i2 < zzh.size(); i2++) {
                strArr[i] = (String) zzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < zzi.size(); i3++) {
                strArr[i] = (String) zzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    public final void zzl() {
        zzdlo zzdlo = this.zzd;
        if (zzdlo != null) {
            zzdlo.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzm() {
        try {
            String zzC = this.zzb.zzC();
            if (Objects.equals(zzC, "Google")) {
                zzm.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(zzC)) {
                zzm.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdlo zzdlo = this.zzd;
                if (zzdlo != null) {
                    zzdlo.zzf(zzC, false);
                }
            }
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    public final void zzn(String str) {
        zzdlo zzdlo = this.zzd;
        if (zzdlo != null) {
            zzdlo.zzF(str);
        }
    }

    public final void zzo() {
        zzdlo zzdlo = this.zzd;
        if (zzdlo != null) {
            zzdlo.zzI();
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdlo zzdlo;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdlo = this.zzd) != null) {
            zzdlo.zzJ((View) unwrap);
        }
    }

    public final boolean zzq() {
        zzdlo zzdlo = this.zzd;
        if ((zzdlo == null || zzdlo.zzW()) && this.zzb.zzr() != null && this.zzb.zzs() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdmt zzdmt;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdmt = this.zzc) == null || !zzdmt.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzq().zzar(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdmt zzdmt;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdmt = this.zzc) == null || !zzdmt.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzs().zzar(zzd(NativeCustomFormatAd.ASSET_NAME_VIDEO));
        return true;
    }

    public final boolean zzt() {
        zzehg zzu = this.zzb.zzu();
        if (zzu != null) {
            zzu.zzA().zzk(zzu.zza());
            if (this.zzb.zzr() == null) {
                return true;
            }
            this.zzb.zzr().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzm.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
