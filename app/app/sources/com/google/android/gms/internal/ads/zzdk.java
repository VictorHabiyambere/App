package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzdk {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzgbc zzh;
    /* access modifiers changed from: private */
    public final zzgbc zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzgbc zzl;
    /* access modifiers changed from: private */
    public final zzdj zzm;
    /* access modifiers changed from: private */
    public zzgbc zzn;
    /* access modifiers changed from: private */
    public int zzo;
    /* access modifiers changed from: private */
    public final HashMap zzp;
    /* access modifiers changed from: private */
    public final HashSet zzq;

    @Deprecated
    public zzdk() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzgbc.zzm();
        this.zzi = zzgbc.zzm();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzgbc.zzm();
        this.zzm = zzdj.zza;
        this.zzn = zzgbc.zzm();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzdk zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzgd.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzgbc.zzn(locale.toLanguageTag());
            }
        }
        return this;
    }

    public final zzdk zzf(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    protected zzdk(zzdl zzdl) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzdl.zzl;
        this.zzf = zzdl.zzm;
        this.zzg = zzdl.zzn;
        this.zzh = zzdl.zzo;
        this.zzi = zzdl.zzq;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzdl.zzu;
        this.zzm = zzdl.zzv;
        this.zzn = zzdl.zzw;
        this.zzo = zzdl.zzx;
        this.zzq = new HashSet(zzdl.zzE);
        this.zzp = new HashMap(zzdl.zzD);
    }
}
