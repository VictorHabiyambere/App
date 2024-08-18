package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzp {
    public static final zzp zza = new zzp();

    protected zzp() {
    }

    public final zzl zza(Context context, zzdx zzdx) {
        String str;
        zzdx zzdx2 = zzdx;
        String zzk = zzdx.zzk();
        Set zzp = zzdx.zzp();
        List unmodifiableList = !zzp.isEmpty() ? Collections.unmodifiableList(new ArrayList(zzp)) : null;
        boolean zzr = zzdx2.zzr(context);
        Bundle zzf = zzdx2.zzf(AdMobAdapter.class);
        String zzl = zzdx.zzl();
        SearchAdRequest zzi = zzdx.zzi();
        zzfh zzfh = zzi != null ? new zzfh(zzi) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            str = zzf.zzr(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean zzq = zzdx.zzq();
        RequestConfiguration zzc = zzej.zzf().zzc();
        return new zzl(8, -1, zzf, -1, unmodifiableList, zzr, Math.max(zzdx.zzb(), zzc.getTagForChildDirectedTreatment()), false, zzl, zzfh, (Location) null, zzk, zzdx.zzg(), zzdx.zze(), Collections.unmodifiableList(new ArrayList(zzdx.zzo())), zzdx.zzm(), str, zzq, (zzc) null, zzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(new String[]{null, zzc.getMaxAdContentRating()}), new zzo()), zzdx.zzn(), zzdx.zza(), zzdx.zzj(), zzc.getPublisherPrivacyPersonalizationState().getValue(), zzdx.zzc());
    }
}
