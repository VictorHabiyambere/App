package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzemx implements zzehl {
    private final zzehn zza;
    private final zzehr zzb;
    private final zzflt zzc;
    private final zzgge zzd;

    public zzemx(zzflt zzflt, zzgge zzgge, zzehn zzehn, zzehr zzehr) {
        this.zzc = zzflt;
        this.zzd = zzgge;
        this.zzb = zzehr;
        this.zza = zzehn;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    public final ListenableFuture zza(zzfhf zzfhf, zzfgt zzfgt) {
        zzeho zzeho;
        Iterator it = zzfgt.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzeho = null;
                break;
            }
            try {
                zzeho = this.zza.zza((String) it.next(), zzfgt.zzw);
                break;
            } catch (zzfhv e) {
            }
        }
        if (zzeho == null) {
            return zzgft.zzg(new zzekn("Unable to instantiate mediation adapter class."));
        }
        zzccn zzccn = new zzccn();
        zzeho.zzc.zza(new zzemw(this, zzeho, zzccn));
        if (zzfgt.zzN) {
            Bundle bundle = zzfhf.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzflt zzflt = this.zzc;
        return zzfld.zzd(new zzemu(this, zzfhf, zzfgt, zzeho), this.zzd, zzfln.ADAPTER_LOAD_AD_SYN, zzflt).zzb(zzfln.ADAPTER_LOAD_AD_ACK).zzd(zzccn).zzb(zzfln.ADAPTER_WRAP_ADAPTER).zze(new zzemv(this, zzfhf, zzfgt, zzeho)).zza();
    }

    public final boolean zzb(zzfhf zzfhf, zzfgt zzfgt) {
        return !zzfgt.zzu.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho, Void voidR) throws Exception {
        return this.zzb.zza(zzfhf, zzfgt, zzeho);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzfhf zzfhf, zzfgt zzfgt, zzeho zzeho) throws Exception {
        this.zzb.zzb(zzfhf, zzfgt, zzeho);
    }
}
