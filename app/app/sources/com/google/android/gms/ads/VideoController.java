package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzfj;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzdq zzb;
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public final zzdq zza() {
        zzdq zzdq;
        synchronized (this.zza) {
            zzdq = this.zzb;
        }
        return zzdq;
    }

    public final void zzb(zzdq zzdq) {
        synchronized (this.zza) {
            this.zzb = zzdq;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return 0;
            }
            try {
                int zzh = zzdq.zzh();
                return zzh;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return false;
            }
            try {
                boolean zzo = zzdq.zzo();
                return zzo;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return false;
            }
            try {
                boolean zzp = zzdq.zzp();
                return zzp;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return true;
            }
            try {
                boolean zzq = zzdq.zzq();
                return zzq;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean mute) {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                try {
                    zzdq.zzj(mute);
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                try {
                    zzdq.zzk();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                try {
                    zzdq.zzl();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                try {
                    zzdq.zzn();
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks callbacks) {
        zzfj zzfj;
        synchronized (this.zza) {
            this.zzc = callbacks;
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                if (callbacks == null) {
                    zzfj = null;
                } else {
                    try {
                        zzfj = new zzfj(callbacks);
                    } catch (RemoteException e) {
                        zzm.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                        return;
                    }
                }
                zzdq.zzm(zzfj);
            }
        }
    }
}
