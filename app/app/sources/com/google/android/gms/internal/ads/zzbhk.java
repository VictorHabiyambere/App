package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class zzbhk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbhk> CREATOR = new zzbhl();
    public final int zza;
    public final boolean zzb;
    public final int zzc;
    public final boolean zzd;
    public final int zze;
    public final zzfk zzf;
    public final boolean zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final int zzk;

    public zzbhk(int i, boolean z, int i2, boolean z2, int i3, zzfk zzfk, boolean z3, int i4, int i5, boolean z4, int i6) {
        this.zza = i;
        this.zzb = z;
        this.zzc = i2;
        this.zzd = z2;
        this.zze = i3;
        this.zzf = zzfk;
        this.zzg = z3;
        this.zzh = i4;
        this.zzj = z4;
        this.zzi = i5;
        this.zzk = i6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        r1 = r4.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        if (r1 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        r0.setVideoOptions(new com.google.android.gms.ads.VideoOptions(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        r0.setAdChoicesPlacement(r4.zze);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r0.setReturnUrlsForImageAssets(r4.zzb);
        r0.setRequestMultipleImages(r4.zzd);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        return r0.build();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.nativead.NativeAdOptions zza(com.google.android.gms.internal.ads.zzbhk r4) {
        /*
            com.google.android.gms.ads.nativead.NativeAdOptions$Builder r0 = new com.google.android.gms.ads.nativead.NativeAdOptions$Builder
            r0.<init>()
            if (r4 != 0) goto L_0x000c
            com.google.android.gms.ads.nativead.NativeAdOptions r4 = r0.build()
            return r4
        L_0x000c:
            int r1 = r4.zza
            switch(r1) {
                case 2: goto L_0x0040;
                case 3: goto L_0x0034;
                case 4: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0045
        L_0x0012:
            boolean r1 = r4.zzg
            r0.setRequestCustomMuteThisAd(r1)
            int r1 = r4.zzh
            r0.setMediaAspectRatio(r1)
            int r1 = r4.zzi
            boolean r2 = r4.zzj
            r0.enableCustomClickGestureDirection(r1, r2)
            int r1 = r4.zzk
            r2 = 1
            if (r1 != 0) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            r3 = 2
            if (r1 != r3) goto L_0x002e
            r2 = 3
            goto L_0x0031
        L_0x002e:
            if (r1 != r2) goto L_0x0031
            r2 = r3
        L_0x0031:
            r0.zzi(r2)
        L_0x0034:
            com.google.android.gms.ads.internal.client.zzfk r1 = r4.zzf
            if (r1 == 0) goto L_0x0040
            com.google.android.gms.ads.VideoOptions r2 = new com.google.android.gms.ads.VideoOptions
            r2.<init>(r1)
            r0.setVideoOptions(r2)
        L_0x0040:
            int r1 = r4.zze
            r0.setAdChoicesPlacement(r1)
        L_0x0045:
            boolean r1 = r4.zzb
            r0.setReturnUrlsForImageAssets(r1)
            boolean r4 = r4.zzd
            r0.setRequestMultipleImages(r4)
            com.google.android.gms.ads.nativead.NativeAdOptions r4 = r0.build()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhk.zza(com.google.android.gms.internal.ads.zzbhk):com.google.android.gms.ads.nativead.NativeAdOptions");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbhk(com.google.android.gms.ads.formats.NativeAdOptions r13) {
        /*
            r12 = this;
            boolean r2 = r13.shouldReturnUrlsForImageAssets()
            int r3 = r13.getImageOrientation()
            boolean r4 = r13.shouldRequestMultipleImages()
            int r5 = r13.getAdChoicesPlacement()
            com.google.android.gms.ads.VideoOptions r0 = r13.getVideoOptions()
            if (r0 == 0) goto L_0x0021
            com.google.android.gms.ads.internal.client.zzfk r0 = new com.google.android.gms.ads.internal.client.zzfk
            com.google.android.gms.ads.VideoOptions r1 = r13.getVideoOptions()
            r0.<init>(r1)
            r6 = r0
            goto L_0x0023
        L_0x0021:
            r0 = 0
            r6 = r0
        L_0x0023:
            boolean r7 = r13.zza()
            int r8 = r13.getMediaAspectRatio()
            r1 = 4
            r9 = 0
            r10 = 0
            r11 = 0
            r0 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhk.<init>(com.google.android.gms.ads.formats.NativeAdOptions):void");
    }
}
