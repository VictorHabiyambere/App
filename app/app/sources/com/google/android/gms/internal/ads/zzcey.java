package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcey implements zzhb {
    private final Context zza;
    private final zzhb zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze = ((Boolean) zzba.zzc().zza(zzbep.zzbR)).booleanValue();
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbcy zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private final AtomicLong zzl = new AtomicLong(-1);
    private zzhh zzm;

    public zzcey(Context context, zzhb zzhb, String str, int i, zzie zzie, zzcex zzcex) {
        this.zza = context;
        this.zzb = zzhb;
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzer)).booleanValue() && !this.zzj) {
            return true;
        }
        return ((Boolean) zzba.zzc().zza(zzbep.zzes)).booleanValue() && !this.zzk;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzg) {
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                return inputStream.read(bArr, i, i2);
            }
            return this.zzb.zza(bArr, i, i2);
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    public final long zzb(zzhh zzhh) throws IOException {
        Long l;
        if (!this.zzg) {
            this.zzg = true;
            this.zzh = zzhh.zza;
            this.zzm = zzhh;
            this.zzi = zzbcy.zza(zzhh.zza);
            zzbcv zzbcv = null;
            if (!((Boolean) zzba.zzc().zza(zzbep.zzeo)).booleanValue()) {
                if (this.zzi != null) {
                    this.zzi.zzh = zzhh.zze;
                    this.zzi.zzi = zzfyv.zzc(this.zzc);
                    this.zzi.zzj = this.zzd;
                    zzbcv = zzu.zzc().zzb(this.zzi);
                }
                if (zzbcv != null && zzbcv.zze()) {
                    this.zzj = zzbcv.zzg();
                    this.zzk = zzbcv.zzf();
                    if (!zzg()) {
                        this.zzf = zzbcv.zzc();
                        return -1;
                    }
                }
            } else if (this.zzi != null) {
                this.zzi.zzh = zzhh.zze;
                this.zzi.zzi = zzfyv.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                if (this.zzi.zzg) {
                    l = (Long) zzba.zzc().zza(zzbep.zzeq);
                } else {
                    l = (Long) zzba.zzc().zza(zzbep.zzep);
                }
                long longValue = l.longValue();
                zzu.zzB().elapsedRealtime();
                zzu.zzd();
                Future zza2 = zzbdj.zza(this.zza, this.zzi);
                try {
                    zzbdk zzbdk = (zzbdk) zza2.get(longValue, TimeUnit.MILLISECONDS);
                    zzbdk.zzd();
                    this.zzj = zzbdk.zzf();
                    this.zzk = zzbdk.zze();
                    zzbdk.zza();
                    if (!zzg()) {
                        this.zzf = zzbdk.zzc();
                    }
                } catch (ExecutionException e) {
                    zza2.cancel(false);
                } catch (TimeoutException e2) {
                    zza2.cancel(false);
                } catch (InterruptedException e3) {
                    zza2.cancel(false);
                    Thread.currentThread().interrupt();
                } catch (Throwable th) {
                }
                zzu.zzB().elapsedRealtime();
                throw null;
            }
            if (this.zzi != null) {
                zzhf zza3 = zzhh.zza();
                zza3.zzd(Uri.parse(this.zzi.zza));
                this.zzm = zza3.zze();
            }
            return this.zzb.zzb(this.zzm);
        }
        throw new IOException("Attempt to open an already open CacheDataSource.");
    }

    public final Uri zzc() {
        return this.zzh;
    }

    public final void zzd() throws IOException {
        if (this.zzg) {
            this.zzg = false;
            this.zzh = null;
            InputStream inputStream = this.zzf;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzf = null;
                return;
            }
            this.zzb.zzd();
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzie zzie) {
    }
}
