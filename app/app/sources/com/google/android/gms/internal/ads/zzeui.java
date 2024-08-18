package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzeui implements zzexw {
    private final Context zza;
    private final zzgge zzb;

    zzeui(Context context, zzgge zzgge) {
        this.zza = context;
        this.zzb = zzgge;
    }

    public final int zza() {
        return 18;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeuf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeuh zzc() throws Exception {
        String str;
        Bundle bundle;
        zzu.zzp();
        String str2 = "";
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgl)).booleanValue()) {
            str = str2;
        } else {
            str = this.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzgn)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzu.zzp();
        Context context = this.zza;
        if (!((Boolean) zzba.zzc().zza(zzbep.zzgm)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str3 = strArr[i];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzeuh(str, str2, bundle, (zzeug) null);
    }
}
