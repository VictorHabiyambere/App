package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzdx {
    private final String zza;
    private final List zzb;
    private final Set zzc;
    private final Bundle zzd;
    private final Map zze;
    private final String zzf;
    private final String zzg;
    @NotOnlyInitialized
    private final SearchAdRequest zzh;
    private final int zzi;
    private final Set zzj;
    private final Bundle zzk;
    private final Set zzl;
    private final boolean zzm;
    private final String zzn;
    private final int zzo;
    private final long zzp = System.currentTimeMillis();

    public zzdx(zzdw zzdw, SearchAdRequest searchAdRequest) {
        this.zza = zzdw.zzg;
        this.zzb = zzdw.zzh;
        this.zzc = Collections.unmodifiableSet(zzdw.zza);
        this.zzd = zzdw.zzb;
        this.zze = Collections.unmodifiableMap(zzdw.zzc);
        this.zzf = zzdw.zzi;
        this.zzg = zzdw.zzj;
        this.zzh = searchAdRequest;
        this.zzi = zzdw.zzk;
        this.zzj = Collections.unmodifiableSet(zzdw.zzd);
        this.zzk = zzdw.zze;
        this.zzl = Collections.unmodifiableSet(zzdw.zzf);
        this.zzm = zzdw.zzl;
        this.zzn = zzdw.zzm;
        this.zzo = zzdw.zzn;
    }

    public final int zza() {
        return this.zzo;
    }

    public final int zzb() {
        return this.zzi;
    }

    public final long zzc() {
        return this.zzp;
    }

    public final Bundle zzd(Class cls) {
        Bundle bundle = this.zzd.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle zze() {
        return this.zzk;
    }

    public final Bundle zzf(Class cls) {
        return this.zzd.getBundle(cls.getName());
    }

    public final Bundle zzg() {
        return this.zzd;
    }

    @Deprecated
    public final NetworkExtras zzh(Class cls) {
        return (NetworkExtras) this.zze.get(cls);
    }

    public final SearchAdRequest zzi() {
        return this.zzh;
    }

    public final String zzj() {
        return this.zzn;
    }

    public final String zzk() {
        return this.zza;
    }

    public final String zzl() {
        return this.zzf;
    }

    public final String zzm() {
        return this.zzg;
    }

    public final List zzn() {
        return new ArrayList(this.zzb);
    }

    public final Set zzo() {
        return this.zzl;
    }

    public final Set zzp() {
        return this.zzc;
    }

    @Deprecated
    public final boolean zzq() {
        return this.zzm;
    }

    public final boolean zzr(Context context) {
        RequestConfiguration zzc2 = zzej.zzf().zzc();
        zzay.zzb();
        Set set = this.zzj;
        String zzz = zzf.zzz(context);
        return set.contains(zzz) || zzc2.getTestDeviceIds().contains(zzz);
    }
}
