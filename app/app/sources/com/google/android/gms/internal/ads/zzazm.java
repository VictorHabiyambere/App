package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazm extends zzazs {
    private final zzayl zzi;
    private long zzj;

    public zzazm(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, zzayl zzayl) {
        super(zzaye, "1LUIVO6lhWmBJfHw9DMAIriIU/Yodc7yYpCjENKu6ENqSuhgH3MJrJCpj/jKq6Pa", "V8P78mWO+MxnWR283vMX+BSDXEvrm8XlQCYXMpvUe5w=", zzatp, i, 53);
        this.zzi = zzayl;
        if (zzayl != null) {
            this.zzj = zzayl.zza();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzV(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
