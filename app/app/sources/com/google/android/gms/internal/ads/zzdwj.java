package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzdwj extends zzbmq {
    private final zzdwm zza;
    private final zzdwh zzb;
    private final Map zzc = new HashMap();

    zzdwj(zzdwm zzdwm, zzdwh zzdwh) {
        this.zza = zzdwm;
        this.zzb = zzdwh;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.ads.internal.client.zzl zzc(java.util.Map r33) {
        /*
            com.google.android.gms.ads.internal.client.zzm r1 = new com.google.android.gms.ads.internal.client.zzm
            r1.<init>()
            java.lang.String r0 = "ad_request"
            r2 = r33
            java.lang.Object r0 = r2.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0016
            com.google.android.gms.ads.internal.client.zzl r0 = r1.zza()
            return r0
        L_0x0016:
            java.lang.String r0 = android.net.Uri.decode(r0)
            android.util.JsonReader r2 = new android.util.JsonReader
            java.io.StringReader r3 = new java.io.StringReader
            r3.<init>(r0)
            r2.<init>(r3)
            r2.beginObject()     // Catch:{ IOException -> 0x0111 }
        L_0x0027:
            boolean r0 = r2.hasNext()     // Catch:{ IOException -> 0x0111 }
            if (r0 == 0) goto L_0x010d
            java.lang.String r0 = r2.nextName()     // Catch:{ IOException -> 0x0111 }
            int r3 = r0.hashCode()     // Catch:{ IOException -> 0x0111 }
            r4 = 1
            r5 = 0
            switch(r3) {
                case -1289032093: goto L_0x0078;
                case -839117230: goto L_0x006e;
                case -733436947: goto L_0x0064;
                case -99890337: goto L_0x005a;
                case 523149226: goto L_0x0050;
                case 597632527: goto L_0x0046;
                case 1411582723: goto L_0x003b;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0082
        L_0x003b:
            java.lang.String r3 = "tagForChildDirectedTreatment"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = 3
            goto L_0x0083
        L_0x0046:
            java.lang.String r3 = "maxAdContentRating"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = 5
            goto L_0x0083
        L_0x0050:
            java.lang.String r3 = "keywords"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = r4
            goto L_0x0083
        L_0x005a:
            java.lang.String r3 = "httpTimeoutMillis"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = 6
            goto L_0x0083
        L_0x0064:
            java.lang.String r3 = "tagForUnderAgeOfConsent"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = 4
            goto L_0x0083
        L_0x006e:
            java.lang.String r3 = "isTestDevice"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = 2
            goto L_0x0083
        L_0x0078:
            java.lang.String r3 = "extras"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x003a
            r0 = r5
            goto L_0x0083
        L_0x0082:
            r0 = -1
        L_0x0083:
            switch(r0) {
                case 0: goto L_0x00eb;
                case 1: goto L_0x00cd;
                case 2: goto L_0x00c4;
                case 3: goto L_0x00b3;
                case 4: goto L_0x00a2;
                case 5: goto L_0x0092;
                case 6: goto L_0x008a;
                default: goto L_0x0086;
            }
        L_0x0086:
            r2.skipValue()     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x008a:
            int r0 = r2.nextInt()     // Catch:{ IOException -> 0x0111 }
            r1.zzc(r0)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x0092:
            java.lang.String r0 = r2.nextString()     // Catch:{ IOException -> 0x0111 }
            java.util.List r3 = com.google.android.gms.ads.RequestConfiguration.zza     // Catch:{ IOException -> 0x0111 }
            boolean r3 = r3.contains(r0)     // Catch:{ IOException -> 0x0111 }
            if (r3 == 0) goto L_0x0027
            r1.zzf(r0)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00a2:
            boolean r0 = r2.nextBoolean()     // Catch:{ IOException -> 0x0111 }
            if (r0 == 0) goto L_0x00ad
            r1.zzi(r4)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00ad:
            r1.zzi(r5)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00b3:
            boolean r0 = r2.nextBoolean()     // Catch:{ IOException -> 0x0111 }
            if (r0 == 0) goto L_0x00be
            r1.zzh(r4)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00be:
            r1.zzh(r5)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00c4:
            boolean r0 = r2.nextBoolean()     // Catch:{ IOException -> 0x0111 }
            r1.zzd(r0)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00cd:
            r2.beginArray()     // Catch:{ IOException -> 0x0111 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x0111 }
            r0.<init>()     // Catch:{ IOException -> 0x0111 }
        L_0x00d5:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x0111 }
            if (r3 == 0) goto L_0x00e3
            java.lang.String r3 = r2.nextString()     // Catch:{ IOException -> 0x0111 }
            r0.add(r3)     // Catch:{ IOException -> 0x0111 }
            goto L_0x00d5
        L_0x00e3:
            r2.endArray()     // Catch:{ IOException -> 0x0111 }
            r1.zze(r0)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x00eb:
            r2.beginObject()     // Catch:{ IOException -> 0x0111 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ IOException -> 0x0111 }
            r0.<init>()     // Catch:{ IOException -> 0x0111 }
        L_0x00f3:
            boolean r3 = r2.hasNext()     // Catch:{ IOException -> 0x0111 }
            if (r3 == 0) goto L_0x0105
            java.lang.String r3 = r2.nextName()     // Catch:{ IOException -> 0x0111 }
            java.lang.String r4 = r2.nextString()     // Catch:{ IOException -> 0x0111 }
            r0.putString(r3, r4)     // Catch:{ IOException -> 0x0111 }
            goto L_0x00f3
        L_0x0105:
            r2.endObject()     // Catch:{ IOException -> 0x0111 }
            r1.zzb(r0)     // Catch:{ IOException -> 0x0111 }
            goto L_0x0027
        L_0x010d:
            r2.endObject()     // Catch:{ IOException -> 0x0111 }
            goto L_0x0117
        L_0x0111:
            r0 = move-exception
            java.lang.String r0 = "Ad Request json was malformed, parsing ended early."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)
        L_0x0117:
            com.google.android.gms.ads.internal.client.zzl r0 = r1.zza()
            android.os.Bundle r1 = r0.zzm
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 != 0) goto L_0x012e
            android.os.Bundle r1 = r0.zzc
            android.os.Bundle r3 = r0.zzm
            r3.putBundle(r2, r1)
            r8 = r1
            goto L_0x012f
        L_0x012e:
            r8 = r1
        L_0x012f:
            int r5 = r0.zza
            long r6 = r0.zzb
            int r9 = r0.zzd
            java.util.List r10 = r0.zze
            boolean r11 = r0.zzf
            int r12 = r0.zzg
            boolean r13 = r0.zzh
            java.lang.String r14 = r0.zzi
            com.google.android.gms.ads.internal.client.zzfh r15 = r0.zzj
            android.location.Location r1 = r0.zzk
            r16 = r1
            java.lang.String r1 = r0.zzl
            r17 = r1
            android.os.Bundle r1 = r0.zzm
            r18 = r1
            android.os.Bundle r1 = r0.zzn
            r19 = r1
            java.util.List r1 = r0.zzo
            r20 = r1
            java.lang.String r1 = r0.zzp
            r21 = r1
            java.lang.String r1 = r0.zzq
            r22 = r1
            boolean r1 = r0.zzr
            r23 = r1
            com.google.android.gms.ads.internal.client.zzc r1 = r0.zzs
            r24 = r1
            int r1 = r0.zzt
            r25 = r1
            java.lang.String r1 = r0.zzu
            r26 = r1
            java.util.List r1 = r0.zzv
            r27 = r1
            int r1 = r0.zzw
            r28 = r1
            java.lang.String r1 = r0.zzx
            r29 = r1
            int r1 = r0.zzy
            r30 = r1
            long r0 = r0.zzz
            r31 = r0
            com.google.android.gms.ads.internal.client.zzl r0 = new com.google.android.gms.ads.internal.client.zzl
            r4 = r0
            r4.<init>(r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwj.zzc(java.util.Map):com.google.android.gms.ads.internal.client.zzl");
    }

    public final void zze() {
        this.zzc.clear();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ce, code lost:
        if (r0.equals("create_interstitial_ad") != false) goto L_0x00f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(java.lang.String r12) throws android.os.RemoteException {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzjU
            com.google.android.gms.internal.ads.zzben r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r0 = java.lang.String.valueOf(r12)
            java.lang.String r1 = "Received H5 gmsg: "
            java.lang.String r0 = r1.concat(r0)
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            android.net.Uri r12 = android.net.Uri.parse(r12)
            com.google.android.gms.ads.internal.zzu.zzp()
            java.util.Map r12 = com.google.android.gms.ads.internal.util.zzt.zzP(r12)
            java.lang.String r0 = "action"
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x003f
            java.lang.String r12 = "H5 gmsg did not contain an action"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r12)
            return
        L_0x003f:
            int r1 = r0.hashCode()
            r2 = 0
            r3 = 1
            r4 = -1
            switch(r1) {
                case 579053441: goto L_0x0055;
                case 871091088: goto L_0x004a;
                default: goto L_0x0049;
            }
        L_0x0049:
            goto L_0x005f
        L_0x004a:
            java.lang.String r1 = "initialize"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0049
            r1 = r2
            goto L_0x0060
        L_0x0055:
            java.lang.String r1 = "dispose_all"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0049
            r1 = r3
            goto L_0x0060
        L_0x005f:
            r1 = r4
        L_0x0060:
            switch(r1) {
                case 0: goto L_0x008c;
                case 1: goto L_0x006c;
                default: goto L_0x0063;
            }
        L_0x0063:
            java.lang.String r1 = "obj_id"
            java.lang.Object r1 = r12.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0097
        L_0x006c:
            java.util.Map r12 = r11.zzc
            java.util.Collection r12 = r12.values()
            java.util.Iterator r12 = r12.iterator()
        L_0x0076:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r12.next()
            com.google.android.gms.internal.ads.zzdwc r0 = (com.google.android.gms.internal.ads.zzdwc) r0
            r0.zza()
            goto L_0x0076
        L_0x0086:
            java.util.Map r12 = r11.zzc
            r12.clear()
            return
        L_0x008c:
            java.util.Map r12 = r11.zzc
            r12.clear()
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zza()
            return
        L_0x0097:
            java.lang.Object r5 = java.util.Objects.requireNonNull(r1)     // Catch:{ NumberFormatException -> 0x02c0, NullPointerException -> 0x02be }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x02c0, NullPointerException -> 0x02be }
            long r5 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x02c0, NullPointerException -> 0x02be }
            int r1 = r0.hashCode()
            switch(r1) {
                case -1790951212: goto L_0x00e5;
                case -1266374734: goto L_0x00db;
                case -257098725: goto L_0x00d1;
                case 393881811: goto L_0x00c8;
                case 585513149: goto L_0x00be;
                case 1671767583: goto L_0x00b4;
                case 2109237041: goto L_0x00a9;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            goto L_0x00ef
        L_0x00a9:
            java.lang.String r1 = "create_rewarded_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = 3
            goto L_0x00f0
        L_0x00b4:
            java.lang.String r1 = "dispose"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = 6
            goto L_0x00f0
        L_0x00be:
            java.lang.String r1 = "load_interstitial_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = r3
            goto L_0x00f0
        L_0x00c8:
            java.lang.String r1 = "create_interstitial_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            goto L_0x00f0
        L_0x00d1:
            java.lang.String r1 = "load_rewarded_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = 4
            goto L_0x00f0
        L_0x00db:
            java.lang.String r1 = "show_rewarded_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = 5
            goto L_0x00f0
        L_0x00e5:
            java.lang.String r1 = "show_interstitial_ad"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00a8
            r2 = 2
            goto L_0x00f0
        L_0x00ef:
            r2 = r4
        L_0x00f0:
            java.lang.String r1 = "Could not create H5 ad, missing ad unit id"
            java.lang.String r3 = " with ad unit "
            java.lang.String r4 = "Could not create H5 ad, object ID already exists"
            java.lang.String r7 = "ad_unit"
            java.lang.String r8 = "Could not show H5 ad, object ID does not exist"
            java.lang.String r9 = "Could not load H5 ad, object ID does not exist"
            java.lang.String r10 = "Could not create H5 ad, too many existing objects"
            switch(r2) {
                case 0: goto L_0x0239;
                case 1: goto L_0x021a;
                case 2: goto L_0x01ff;
                case 3: goto L_0x017a;
                case 4: goto L_0x015b;
                case 5: goto L_0x0140;
                case 6: goto L_0x010f;
                default: goto L_0x0101;
            }
        L_0x0101:
            java.lang.String r12 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "H5 gmsg contained invalid action: "
            java.lang.String r12 = r0.concat(r12)
            com.google.android.gms.ads.internal.util.client.zzm.zze(r12)
            return
        L_0x010f:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdwc r12 = (com.google.android.gms.internal.ads.zzdwc) r12
            if (r12 != 0) goto L_0x0123
            java.lang.String r12 = "Could not dispose H5 ad, object ID does not exist"
            com.google.android.gms.ads.internal.util.client.zzm.zze(r12)
            return
        L_0x0123:
            r12.zza()
            java.util.Map r12 = r11.zzc
            r12.remove(r0)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Disposed H5 ad #"
            r12.append(r0)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x0140:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdwc r12 = (com.google.android.gms.internal.ads.zzdwc) r12
            if (r12 != 0) goto L_0x0157
            com.google.android.gms.ads.internal.util.client.zzm.zze(r8)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzq(r5)
            return
        L_0x0157:
            r12.zzc()
            return
        L_0x015b:
            java.util.Map r0 = r11.zzc
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzdwc r0 = (com.google.android.gms.internal.ads.zzdwc) r0
            if (r0 != 0) goto L_0x0172
            com.google.android.gms.ads.internal.util.client.zzm.zze(r9)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzq(r5)
            return
        L_0x0172:
            com.google.android.gms.ads.internal.client.zzl r12 = zzc(r12)
            r0.zzb(r12)
            return
        L_0x017a:
            java.util.Map r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzjV
            com.google.android.gms.internal.ads.zzben r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r8.zza(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r0 < r2) goto L_0x019b
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x019b:
            java.util.Map r0 = r11.zzc
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x01b0
            com.google.android.gms.ads.internal.util.client.zzm.zze(r4)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x01b0:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x01c6
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r1)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x01c6:
            com.google.android.gms.internal.ads.zzdwm r0 = r11.zza
            com.google.android.gms.internal.ads.zzdwd r0 = r0.zzb()
            r0.zzb(r5)
            r0.zza(r12)
            com.google.android.gms.internal.ads.zzdwe r0 = r0.zzc()
            com.google.android.gms.internal.ads.zzdws r0 = r0.zzb()
            java.util.Map r1 = r11.zzc
            r1.put(r2, r0)
            com.google.android.gms.internal.ads.zzdwh r0 = r11.zzb
            r0.zzh(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Created H5 rewarded #"
            r0.append(r1)
            r0.append(r5)
            r0.append(r3)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x01ff:
            java.util.Map r12 = r11.zzc
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            java.lang.Object r12 = r12.get(r0)
            com.google.android.gms.internal.ads.zzdwc r12 = (com.google.android.gms.internal.ads.zzdwc) r12
            if (r12 != 0) goto L_0x0216
            com.google.android.gms.ads.internal.util.client.zzm.zze(r8)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzf(r5)
            return
        L_0x0216:
            r12.zzc()
            return
        L_0x021a:
            java.util.Map r0 = r11.zzc
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.ads.zzdwc r0 = (com.google.android.gms.internal.ads.zzdwc) r0
            if (r0 != 0) goto L_0x0231
            com.google.android.gms.ads.internal.util.client.zzm.zze(r9)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzf(r5)
            return
        L_0x0231:
            com.google.android.gms.ads.internal.client.zzl r12 = zzc(r12)
            r0.zzb(r12)
            return
        L_0x0239:
            java.util.Map r0 = r11.zzc
            int r0 = r0.size()
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzjV
            com.google.android.gms.internal.ads.zzben r8 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r8.zza(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r0 < r2) goto L_0x025a
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x025a:
            java.util.Map r0 = r11.zzc
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            boolean r0 = r0.containsKey(r2)
            if (r0 == 0) goto L_0x026f
            com.google.android.gms.ads.internal.util.client.zzm.zze(r4)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x026f:
            java.lang.Object r12 = r12.get(r7)
            java.lang.String r12 = (java.lang.String) r12
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0285
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r1)
            com.google.android.gms.internal.ads.zzdwh r12 = r11.zzb
            r12.zzi(r5)
            return
        L_0x0285:
            com.google.android.gms.internal.ads.zzdwm r0 = r11.zza
            com.google.android.gms.internal.ads.zzdwd r0 = r0.zzb()
            r0.zzb(r5)
            r0.zza(r12)
            com.google.android.gms.internal.ads.zzdwe r0 = r0.zzc()
            com.google.android.gms.internal.ads.zzdwo r0 = r0.zza()
            java.util.Map r1 = r11.zzc
            r1.put(r2, r0)
            com.google.android.gms.internal.ads.zzdwh r0 = r11.zzb
            r0.zzh(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Created H5 interstitial #"
            r0.append(r1)
            r0.append(r5)
            r0.append(r3)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.google.android.gms.ads.internal.util.zze.zza(r12)
            return
        L_0x02be:
            r12 = move-exception
            goto L_0x02c1
        L_0x02c0:
            r12 = move-exception
        L_0x02c1:
            java.lang.String r12 = java.lang.String.valueOf(r1)
            java.lang.String r0 = "H5 gmsg did not contain a valid object id: "
            java.lang.String r12 = r0.concat(r12)
            com.google.android.gms.ads.internal.util.client.zzm.zze(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwj.zzf(java.lang.String):void");
    }
}
