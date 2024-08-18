package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzcrz extends zzcup {
    private final zzchd zzc;
    private final int zzd;
    private final Context zze;
    private final zzcrn zzf;
    private final zzdjp zzg;
    private final zzdgm zzh;
    private final zzczy zzi;
    private final boolean zzj;
    private final zzccc zzk;
    private boolean zzl = false;

    zzcrz(zzcuo zzcuo, Context context, zzchd zzchd, int i, zzcrn zzcrn, zzdjp zzdjp, zzdgm zzdgm, zzczy zzczy, zzccc zzccc) {
        super(zzcuo);
        this.zzc = zzchd;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcrn;
        this.zzg = zzdjp;
        this.zzh = zzdgm;
        this.zzi = zzczy;
        this.zzj = ((Boolean) zzba.zzc().zza(zzbep.zzfs)).booleanValue();
        this.zzk = zzccc;
    }

    public final int zza() {
        return this.zzd;
    }

    public final void zzb() {
        super.zzb();
        zzchd zzchd = this.zzc;
        if (zzchd != null) {
            zzchd.destroy();
        }
    }

    public final void zzc(zzbca zzbca) {
        zzchd zzchd = this.zzc;
        if (zzchd != null) {
            zzchd.zzak(zzbca);
        }
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [android.content.Context] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.app.Activity r3, com.google.android.gms.internal.ads.zzbcn r4, boolean r5) throws android.os.RemoteException {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0004
            android.content.Context r3 = r2.zze
        L_0x0004:
            boolean r4 = r2.zzj
            if (r4 == 0) goto L_0x000d
            com.google.android.gms.internal.ads.zzdgm r4 = r2.zzh
            r4.zzb()
        L_0x000d:
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzaC
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0061
            com.google.android.gms.ads.internal.zzu.zzp()
            boolean r4 = com.google.android.gms.ads.internal.util.zzt.zzG(r3)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzczy r4 = r2.zzi
            r4.zzb()
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzaD
            com.google.android.gms.internal.ads.zzben r5 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r5.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzfrp r4 = new com.google.android.gms.internal.ads.zzfrp
            android.content.Context r3 = r3.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbx r5 = com.google.android.gms.ads.internal.zzu.zzt()
            android.os.Looper r5 = r5.zzb()
            r4.<init>(r3, r5)
            com.google.android.gms.internal.ads.zzfhf r3 = r2.zza
            com.google.android.gms.internal.ads.zzfhe r3 = r3.zzb
            com.google.android.gms.internal.ads.zzfgw r3 = r3.zzb
            java.lang.String r3 = r3.zzb
            r4.zza(r3)
            return
        L_0x0061:
            com.google.android.gms.internal.ads.zzbeg r4 = com.google.android.gms.internal.ads.zzbep.zzlQ
            com.google.android.gms.internal.ads.zzben r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r4 = r0.zza(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            r0 = 0
            if (r4 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzchd r4 = r2.zzc
            if (r4 == 0) goto L_0x00a1
            com.google.android.gms.internal.ads.zzfgt r4 = r4.zzD()
            if (r4 == 0) goto L_0x00a1
            boolean r1 = r4.zzas
            if (r1 == 0) goto L_0x00a1
            int r4 = r4.zzat
            com.google.android.gms.internal.ads.zzccc r1 = r2.zzk
            int r1 = r1.zzb()
            if (r4 != r1) goto L_0x008d
            goto L_0x00a1
        L_0x008d:
            java.lang.String r3 = "The app open consent form has been shown."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r3)
            com.google.android.gms.internal.ads.zzczy r3 = r2.zzi
            r4 = 12
            java.lang.String r5 = "The consent form has already been shown."
            com.google.android.gms.ads.internal.client.zze r4 = com.google.android.gms.internal.ads.zzfiq.zzd(r4, r5, r0)
            r3.zza(r4)
            return
        L_0x00a1:
            boolean r4 = r2.zzl
            if (r4 == 0) goto L_0x00b5
            java.lang.String r4 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r4)
            com.google.android.gms.internal.ads.zzczy r4 = r2.zzi
            r1 = 10
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfiq.zzd(r1, r0, r0)
            r4.zza(r0)
        L_0x00b5:
            boolean r4 = r2.zzl
            if (r4 != 0) goto L_0x00d4
            com.google.android.gms.internal.ads.zzdjp r4 = r2.zzg     // Catch:{ zzdjo -> 0x00cd }
            com.google.android.gms.internal.ads.zzczy r0 = r2.zzi     // Catch:{ zzdjo -> 0x00cd }
            r4.zza(r5, r3, r0)     // Catch:{ zzdjo -> 0x00cd }
            boolean r3 = r2.zzj     // Catch:{ zzdjo -> 0x00cd }
            if (r3 == 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzdgm r3 = r2.zzh     // Catch:{ zzdjo -> 0x00cd }
            r3.zza()     // Catch:{ zzdjo -> 0x00cd }
        L_0x00c9:
            r3 = 1
            r2.zzl = r3
            return
        L_0x00cd:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzczy r4 = r2.zzi
            r4.zzc(r3)
            return
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcrz.zzd(android.app.Activity, com.google.android.gms.internal.ads.zzbcn, boolean):void");
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
