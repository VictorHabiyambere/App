package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzazd extends zzazs {
    private final zzaxh zzi;
    private final long zzj;
    private final long zzk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzazd(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, zzaxh zzaxh, long j, long j2) {
        super(zzaye, "gAg/p/cQzJRjYz9LhE8cRk72DVV1Cpozf/TbzvACqLcTgM3sRjMEb3DCmwYhMmhP", "avDZD6/xoSbFYvWCy23XLncB75oD5DxKdrTKFY2O0hY=", zzatp, i, 11);
        this.zzi = zzaxh;
        this.zzj = j;
        this.zzk = j2;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzaxh zzaxh = this.zzi;
        if (zzaxh != null) {
            zzaxf zzaxf = new zzaxf((String) this.zzf.invoke((Object) null, new Object[]{zzaxh.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)}));
            synchronized (this.zze) {
                this.zze.zzE(zzaxf.zza.longValue());
                if (zzaxf.zzb.longValue() >= 0) {
                    this.zze.zzW(zzaxf.zzb.longValue());
                }
                if (zzaxf.zzc.longValue() >= 0) {
                    this.zze.zzg(zzaxf.zzc.longValue());
                }
            }
        }
    }
}
