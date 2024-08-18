package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzfiq;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzn extends WebViewClient {
    final /* synthetic */ zzt zza;

    zzn(zzt zzt) {
        this.zza = zzt;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        zzt zzt = this.zza;
        if (zzt.zzg != null) {
            try {
                zzt.zzg.zzf(zzfiq.zzd(1, (String) null, (zze) null));
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        zzt zzt2 = this.zza;
        if (zzt2.zzg != null) {
            try {
                zzt2.zzg.zze(0);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zza.zzq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            zzt zzt = this.zza;
            if (zzt.zzg != null) {
                try {
                    zzt.zzg.zzf(zzfiq.zzd(3, (String) null, (zze) null));
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
            zzt zzt2 = this.zza;
            if (zzt2.zzg != null) {
                try {
                    zzt2.zzg.zze(3);
                } catch (RemoteException e2) {
                    zzm.zzl("#007 Could not call remote method.", e2);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            zzt zzt3 = this.zza;
            if (zzt3.zzg != null) {
                try {
                    zzt3.zzg.zzf(zzfiq.zzd(1, (String) null, (zze) null));
                } catch (RemoteException e3) {
                    zzm.zzl("#007 Could not call remote method.", e3);
                }
            }
            zzt zzt4 = this.zza;
            if (zzt4.zzg != null) {
                try {
                    zzt4.zzg.zze(0);
                } catch (RemoteException e4) {
                    zzm.zzl("#007 Could not call remote method.", e4);
                }
            }
            this.zza.zzV(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            zzt zzt5 = this.zza;
            if (zzt5.zzg != null) {
                try {
                    zzt5.zzg.zzi();
                } catch (RemoteException e5) {
                    zzm.zzl("#007 Could not call remote method.", e5);
                }
            }
            this.zza.zzV(this.zza.zzb(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            zzt zzt6 = this.zza;
            if (zzt6.zzg != null) {
                try {
                    zzt6.zzg.zzc();
                    this.zza.zzg.zzh();
                } catch (RemoteException e6) {
                    zzm.zzl("#007 Could not call remote method.", e6);
                }
            }
            zzt.zzw(this.zza, zzt.zzo(this.zza, str));
            return true;
        }
    }
}
