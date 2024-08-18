package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdnu implements zzdmb {
    private final zzbru zza;
    private final zzdad zzb;
    private final zzczj zzc;
    private final zzdhg zzd;
    private final Context zze;
    private final zzfgt zzf;
    private final VersionInfoParcel zzg;
    private final zzfho zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbrq zzl;
    private final zzbrr zzm;

    public zzdnu(zzbrq zzbrq, zzbrr zzbrr, zzbru zzbru, zzdad zzdad, zzczj zzczj, zzdhg zzdhg, Context context, zzfgt zzfgt, VersionInfoParcel versionInfoParcel, zzfho zzfho) {
        this.zzl = zzbrq;
        this.zzm = zzbrr;
        this.zza = zzbru;
        this.zzb = zzdad;
        this.zzc = zzczj;
        this.zzd = zzdhg;
        this.zze = context;
        this.zzf = zzfgt;
        this.zzg = versionInfoParcel;
        this.zzh = zzfho;
    }

    private final void zzb(View view) {
        try {
            zzbru zzbru = this.zza;
            if (zzbru == null || zzbru.zzA()) {
                zzbrq zzbrq = this.zzl;
                if (zzbrq == null || zzbrq.zzx()) {
                    zzbrr zzbrr = this.zzm;
                    if (zzbrr != null && !zzbrr.zzv()) {
                        this.zzm.zzq(ObjectWrapper.wrap(view));
                        this.zzc.onAdClicked();
                        if (((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
                            this.zzd.zzdG();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
                    this.zzd.zzdG();
                    return;
                }
                return;
            }
            this.zza.zzw(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) zzba.zzc().zza(zzbep.zzkM)).booleanValue()) {
                this.zzd.zzdG();
            }
        } catch (RemoteException e) {
            zzm.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            synchronized (map) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        hashMap.put((String) entry.getKey(), view);
                    }
                }
            }
        }
        return hashMap;
    }

    public final boolean zzA() {
        return true;
    }

    public final boolean zzB() {
        return this.zzf.zzM;
    }

    public final boolean zzC(Bundle bundle) {
        return false;
    }

    public final int zza() {
        return 0;
    }

    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    public final void zzg() {
        throw null;
    }

    public final void zzh() {
    }

    public final void zzi() {
    }

    public final void zzj(zzcw zzcw) {
        zzm.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (!this.zzj || !this.zzf.zzM) {
            zzb(view);
        }
    }

    public final void zzl(String str) {
    }

    public final void zzm(Bundle bundle) {
    }

    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            zzm.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzf.zzM) {
            zzm.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzb(view2);
        }
    }

    public final void zzp() {
    }

    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = zzu.zzs().zzn(this.zze, this.zzg.afmaVersion, this.zzf.zzD.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbru zzbru = this.zza;
                if (zzbru == null || zzbru.zzB()) {
                    zzbrq zzbrq = this.zzl;
                    if (zzbrq == null || zzbrq.zzy()) {
                        zzbrr zzbrr = this.zzm;
                        if (zzbrr != null && !zzbrr.zzw()) {
                            this.zzm.zzr();
                            this.zzb.zza();
                            return;
                        }
                        return;
                    }
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                this.zza.zzx();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            zzm.zzk("Failed to call recordImpression", e);
        }
    }

    public final void zzr() {
    }

    public final void zzs(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zzt(Bundle bundle) {
    }

    public final void zzu(View view) {
    }

    public final void zzv() {
        this.zzj = true;
    }

    public final void zzw(zzcs zzcs) {
        zzm.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzx(zzbjp zzbjp) {
    }

    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Map map3;
        Map map4;
        IObjectWrapper iObjectWrapper;
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzak;
            boolean z = true;
            if (((Boolean) zzba.zzc().zza(zzbep.zzby)).booleanValue()) {
                if (jSONObject.length() != 0) {
                    if (map == null) {
                        map3 = new HashMap();
                    } else {
                        map3 = map;
                    }
                    if (map2 == null) {
                        map4 = new HashMap();
                    } else {
                        map4 = map2;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(map3);
                    hashMap.putAll(map4);
                    Iterator<String> keys = jSONObject.keys();
                    loop0:
                    while (true) {
                        if (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray = jSONObject.optJSONArray(next);
                            if (optJSONArray != null) {
                                WeakReference weakReference = (WeakReference) hashMap.get(next);
                                if (weakReference == null) {
                                    z = false;
                                    break;
                                }
                                Object obj = weakReference.get();
                                if (obj == null) {
                                    z = false;
                                    break;
                                }
                                Class<?> cls = obj.getClass();
                                if (((Boolean) zzba.zzc().zza(zzbep.zzbz)).booleanValue() && next.equals("3010")) {
                                    zzbru zzbru = this.zza;
                                    Object obj2 = null;
                                    if (zzbru != null) {
                                        try {
                                            iObjectWrapper = zzbru.zzn();
                                        } catch (RemoteException e) {
                                        }
                                    } else {
                                        zzbrq zzbrq = this.zzl;
                                        if (zzbrq != null) {
                                            iObjectWrapper = zzbrq.zzk();
                                        } else {
                                            zzbrr zzbrr = this.zzm;
                                            iObjectWrapper = zzbrr != null ? zzbrr.zzj() : null;
                                        }
                                    }
                                    if (iObjectWrapper != null) {
                                        try {
                                            obj2 = ObjectWrapper.unwrap(iObjectWrapper);
                                        } catch (IllegalArgumentException e2) {
                                        }
                                    }
                                    if (obj2 == null) {
                                        z = false;
                                        break;
                                    }
                                    cls = obj2.getClass();
                                }
                                try {
                                    ArrayList<String> arrayList = new ArrayList<>();
                                    zzbw.zzc(optJSONArray, arrayList);
                                    zzu.zzp();
                                    ClassLoader classLoader = this.zze.getClassLoader();
                                    for (String cls2 : arrayList) {
                                        try {
                                            if (Class.forName(cls2, false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        } catch (Throwable th) {
                                        }
                                    }
                                    z = false;
                                    break loop0;
                                } catch (JSONException e3) {
                                }
                            }
                        }
                    }
                }
            }
            this.zzk = z;
            HashMap zzc2 = zzc(map);
            HashMap zzc3 = zzc(map2);
            zzbru zzbru2 = this.zza;
            if (zzbru2 != null) {
                zzbru2.zzy(wrap, ObjectWrapper.wrap(zzc2), ObjectWrapper.wrap(zzc3));
                return;
            }
            zzbrq zzbrq2 = this.zzl;
            if (zzbrq2 != null) {
                zzbrq2.zzv(wrap, ObjectWrapper.wrap(zzc2), ObjectWrapper.wrap(zzc3));
                this.zzl.zzu(wrap);
                return;
            }
            zzbrr zzbrr2 = this.zzm;
            if (zzbrr2 != null) {
                zzbrr2.zzt(wrap, ObjectWrapper.wrap(zzc2), ObjectWrapper.wrap(zzc3));
                this.zzm.zzs(wrap);
            }
        } catch (RemoteException e4) {
            zzm.zzk("Failed to call trackView", e4);
        }
    }

    public final void zzz(View view, Map map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbru zzbru = this.zza;
            if (zzbru != null) {
                zzbru.zzz(wrap);
                return;
            }
            zzbrq zzbrq = this.zzl;
            if (zzbrq != null) {
                zzbrq.zzw(wrap);
                return;
            }
            zzbrr zzbrr = this.zzm;
            if (zzbrr != null) {
                zzbrr.zzu(wrap);
            }
        } catch (RemoteException e) {
            zzm.zzk("Failed to call untrackView", e);
        }
    }
}
