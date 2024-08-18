package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzdw {
    /* access modifiers changed from: private */
    public final HashSet zza = new HashSet();
    /* access modifiers changed from: private */
    public final Bundle zzb = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap zzc = new HashMap();
    /* access modifiers changed from: private */
    public final HashSet zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Bundle zze = new Bundle();
    /* access modifiers changed from: private */
    public final HashSet zzf = new HashSet();
    /* access modifiers changed from: private */
    public String zzg;
    /* access modifiers changed from: private */
    public final List zzh = new ArrayList();
    /* access modifiers changed from: private */
    public String zzi;
    /* access modifiers changed from: private */
    public String zzj;
    /* access modifiers changed from: private */
    public int zzk = -1;
    /* access modifiers changed from: private */
    public boolean zzl;
    /* access modifiers changed from: private */
    public String zzm;
    /* access modifiers changed from: private */
    public int zzn = 60000;

    public final void zzA(String str) {
        this.zzi = str;
    }

    public final void zzB(String str) {
        this.zzj = str;
    }

    @Deprecated
    public final void zzC(boolean z) {
        this.zzk = z ? 1 : 0;
    }

    public final void zzn(String str) {
        this.zzf.add(str);
    }

    public final void zzo(Class cls, Bundle bundle) {
        if (this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzb.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        Bundle bundle2 = this.zzb.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        Preconditions.checkNotNull(bundle2);
        bundle2.putBundle(cls.getName(), bundle);
    }

    public final void zzp(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzq(String str) {
        this.zza.add(str);
    }

    public final void zzr(Class cls, Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zzs(NetworkExtras networkExtras) {
        this.zzc.put(networkExtras.getClass(), networkExtras);
    }

    public final void zzt(String str) {
        this.zzd.add(str);
    }

    public final void zzu(String str) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void zzv(String str) {
        this.zzm = str;
    }

    public final void zzw(String str) {
        this.zzg = str;
    }

    public final void zzx(int i) {
        this.zzn = i;
    }

    @Deprecated
    public final void zzy(boolean z) {
        this.zzl = z;
    }

    public final void zzz(List list) {
        this.zzh.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                zzm.zzj("neighboring content URL should not be null or empty");
            } else {
                this.zzh.add(str);
            }
        }
    }
}
