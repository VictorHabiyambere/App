package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.zzfh;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public abstract class zzeku implements zzehl {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzfgt zzfgt2 = zzfgt;
        String optString = zzfgt2.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfho zzfho = zzfhf.zza.zza;
        zzfhm zzfhm = new zzfhm();
        zzfhm.zzq(zzfho);
        zzfhm.zzt(optString);
        Bundle zzd = zzd(zzfho.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzfgt2.zzw.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzfgt2.zzw.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzfgt2.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzfgt2.zzE.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzl zzl = zzfho.zzd;
        int i = zzl.zzd;
        List list = zzl.zze;
        boolean z = zzl.zzf;
        int i2 = zzl.zzg;
        boolean z2 = zzl.zzh;
        String str = zzl.zzi;
        zzfh zzfh = zzl.zzj;
        String str2 = zzl.zzx;
        int i3 = zzl.zza;
        Location location = zzl.zzk;
        int i4 = zzl.zzy;
        zzfhm.zzH(new zzl(i3, zzl.zzb, zzd2, i, list, z, i2, z2, str, zzfh, location, zzl.zzl, zzd, zzl.zzn, zzl.zzo, zzl.zzp, zzl.zzq, zzl.zzr, zzl.zzs, zzl.zzt, zzl.zzu, zzl.zzv, zzl.zzw, str2, i4, zzl.zzz));
        zzfho zzJ = zzfhm.zzJ();
        Bundle bundle = new Bundle();
        zzfhf zzfhf2 = zzfhf;
        zzfgw zzfgw = zzfhf2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzfgw.zza));
        bundle2.putInt("refresh_interval", zzfgw.zzc);
        bundle2.putString("gws_query_id", zzfgw.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        zzfho zzfho2 = zzfhf2.zza.zza;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", zzfho2.zzf);
        zzfgt zzfgt3 = zzfgt;
        bundle3.putString("allocation_id", zzfgt3.zzx);
        bundle3.putString("ad_source_name", zzfgt3.zzG);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzfgt3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzfgt3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzfgt3.zzq));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzfgt3.zzn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzfgt3.zzh));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzfgt3.zzi));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzfgt3.zzj));
        bundle3.putString("transaction_id", zzfgt3.zzk);
        bundle3.putString("valid_from_timestamp", zzfgt3.zzl);
        bundle3.putBoolean("is_closable_area_disabled", zzfgt3.zzQ);
        bundle3.putString("recursive_server_response_data", zzfgt3.zzap);
        if (zzfgt3.zzm != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzfgt3.zzm.zzb);
            bundle4.putString("rb_type", zzfgt3.zzm.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzJ, bundle, zzfgt3, zzfhf2);
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        return !TextUtils.isEmpty(zzfgt.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    /* access modifiers changed from: protected */
    public abstract ListenableFuture zzc(zzfho zzfho, Bundle bundle, zzfgt zzfgt, zzfhf zzfhf);
}
