package com.google.android.gms.ads.internal.client;

import android.content.Context;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbrb;
import com.google.android.gms.internal.ads.zzbrf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public class LiteSdkInfo extends zzck {
    public LiteSdkInfo(Context context) {
    }

    public zzbrf getAdapterCreator() {
        return new zzbrb();
    }

    public zzen getLiteSdkVersion() {
        return new zzen(ModuleDescriptor.MODULE_VERSION, 241806000, "23.2.0");
    }
}
