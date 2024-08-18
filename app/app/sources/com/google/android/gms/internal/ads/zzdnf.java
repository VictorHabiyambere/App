package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdnf {
    private final zzdsd zza;
    private final zzdqs zzb;
    private final zzcrk zzc;
    private final zzdmb zzd;

    public zzdnf(zzdsd zzdsd, zzdqs zzdqs, zzcrk zzcrk, zzdmb zzdmb) {
        this.zza = zzdsd;
        this.zzb = zzdqs;
        this.zzc = zzcrk;
        this.zzd = zzdmb;
    }

    public final View zza() throws zzchp {
        zzchd zza2 = this.zza.zza(zzq.zzc(), (zzfgt) null, (zzfgw) null);
        View view = (View) zza2;
        view.setVisibility(8);
        zza2.zzag("/sendMessageToSdk", new zzdna(this));
        zza2.zzag("/adMuted", new zzdnb(this));
        this.zzb.zzm(new WeakReference(zza2), "/loadHtml", new zzdnc(this));
        this.zzb.zzm(new WeakReference(zza2), "/showOverlay", new zzdnd(this));
        this.zzb.zzm(new WeakReference(zza2), "/hideOverlay", new zzdne(this));
        return view;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzchd zzchd, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzchd zzchd, Map map) {
        this.zzd.zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzchd zzchd, Map map) {
        zzm.zzi("Showing native ads overlay.");
        zzchd.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzchd zzchd, Map map) {
        zzm.zzi("Hiding native ads overlay.");
        zzchd.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
