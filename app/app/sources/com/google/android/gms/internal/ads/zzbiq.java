package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbiq {
    private final zzbip zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();

    public zzbiq(zzbip zzbip) {
        Context context;
        this.zza = zzbip;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbip.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzm.zzh("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzs(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
        }
        this.zzb = mediaView;
    }

    public final zzbip zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }
}
