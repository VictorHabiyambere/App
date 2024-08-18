package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzm {
    private Bundle zza = new Bundle();
    private List zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List zzj = new ArrayList();
    private int zzk = 60000;
    private final int zzl = RequestConfiguration.PublisherPrivacyPersonalizationState.DEFAULT.getValue();
    private long zzm = 0;

    public final zzl zza() {
        Bundle bundle = this.zze;
        Bundle bundle2 = this.zza;
        Bundle bundle3 = this.zzf;
        return new zzl(8, -1, bundle2, -1, this.zzb, this.zzc, this.zzd, false, (String) null, (zzfh) null, (Location) null, (String) null, bundle, bundle3, this.zzg, (String) null, (String) null, false, (zzc) null, this.zzh, this.zzi, this.zzj, this.zzk, (String) null, this.zzl, this.zzm);
    }

    public final zzm zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzm zzc(int i) {
        this.zzk = i;
        return this;
    }

    public final zzm zzd(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzm zze(List list) {
        this.zzb = list;
        return this;
    }

    public final zzm zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final zzm zzg(long j) {
        this.zzm = j;
        return this;
    }

    public final zzm zzh(int i) {
        this.zzd = i;
        return this;
    }

    public final zzm zzi(int i) {
        this.zzh = i;
        return this;
    }
}
