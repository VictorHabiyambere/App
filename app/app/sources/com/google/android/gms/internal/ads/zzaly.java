package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzaly implements zzafa {
    private final zzafa zza;
    private final zzalt zzb;
    private final zzalm zzc = new zzalm();
    private final zzfu zzd = new zzfu();
    private int zze = 0;
    private int zzf = 0;
    private byte[] zzg = zzgd.zzf;
    private zzalv zzh;
    private zzan zzi;

    public zzaly(zzafa zzafa, zzalt zzalt) {
        this.zza = zzafa;
        this.zzb = zzalt;
    }

    private final void zzb(int i) {
        byte[] bArr;
        int length = this.zzg.length;
        int i2 = this.zzf;
        if (length - i2 < i) {
            int i3 = i2 - this.zze;
            int max = Math.max(i3 + i3, i + i3);
            byte[] bArr2 = this.zzg;
            if (max <= bArr2.length) {
                bArr = bArr2;
            } else {
                bArr = new byte[max];
            }
            System.arraycopy(bArr2, this.zze, bArr, 0, i3);
            this.zze = 0;
            this.zzf = i3;
            this.zzg = bArr;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(long j, int i, zzaln zzaln) {
        long j2;
        boolean z;
        zzeq.zzb(this.zzi);
        zzgbc<zzei> zzgbc = zzaln.zza;
        long j3 = zzaln.zzc;
        ArrayList arrayList = new ArrayList(zzgbc.size());
        for (zzei zza2 : zzgbc) {
            arrayList.add(zza2.zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j3);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        zzfu zzfu = this.zzd;
        int length = marshall.length;
        zzfu.zzI(marshall, length);
        this.zza.zzq(this.zzd, length);
        long j4 = zzaln.zzb;
        if (j4 == -9223372036854775807L) {
            if (this.zzi.zzr == Long.MAX_VALUE) {
                z = true;
            } else {
                z = false;
            }
            zzeq.zzf(z);
            j2 = j;
        } else {
            long j5 = this.zzi.zzr;
            j2 = j5 == Long.MAX_VALUE ? j + j4 : j4 + j5;
        }
        this.zza.zzs(j2, i, length, 0, (zzaez) null);
    }

    public final /* synthetic */ int zzf(zzu zzu, int i, boolean z) {
        return zzaey.zza(this, zzu, i, z);
    }

    public final int zzg(zzu zzu, int i, boolean z, int i2) throws IOException {
        if (this.zzh == null) {
            return this.zza.zzg(zzu, i, z, 0);
        }
        zzb(i);
        int zza2 = zzu.zza(this.zzg, this.zzf, i);
        if (zza2 != -1) {
            this.zzf += zza2;
            return zza2;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final void zzl(zzan zzan) {
        String str = zzan.zzn;
        zzalv zzalv = null;
        if (str != null) {
            zzeq.zzd(zzcg.zzb(str) == 3);
            if (!zzan.equals(this.zzi)) {
                this.zzi = zzan;
                if (this.zzb.zzc(zzan)) {
                    zzalv = this.zzb.zzb(zzan);
                }
                this.zzh = zzalv;
            }
            if (this.zzh == null) {
                this.zza.zzl(zzan);
                return;
            }
            zzafa zzafa = this.zza;
            zzal zzb2 = zzan.zzb();
            zzb2.zzX("application/x-media3-cues");
            zzb2.zzz(zzan.zzn);
            zzb2.zzab(Long.MAX_VALUE);
            zzb2.zzD(this.zzb.zza(zzan));
            zzafa.zzl(zzb2.zzad());
            return;
        }
        throw null;
    }

    public final /* synthetic */ void zzq(zzfu zzfu, int i) {
        zzaey.zzb(this, zzfu, i);
    }

    public final void zzr(zzfu zzfu, int i, int i2) {
        if (this.zzh == null) {
            this.zza.zzr(zzfu, i, i2);
            return;
        }
        zzb(i);
        zzfu.zzG(this.zzg, this.zzf, i);
        this.zzf += i;
    }

    public final void zzs(long j, int i, int i2, int i3, zzaez zzaez) {
        boolean z;
        if (this.zzh == null) {
            this.zza.zzs(j, i, i2, i3, zzaez);
            return;
        }
        if (zzaez == null) {
            z = true;
        } else {
            z = false;
        }
        zzeq.zze(z, "DRM on subtitles is not supported");
        int i4 = (this.zzf - i3) - i2;
        this.zzh.zza(this.zzg, i4, i2, zzalu.zza(), new zzalx(this, j, i));
        int i5 = i4 + i2;
        this.zze = i5;
        if (i5 == this.zzf) {
            this.zze = 0;
            this.zzf = 0;
        }
    }
}
