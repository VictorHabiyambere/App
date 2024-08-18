package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcga extends zzgv implements zzhz {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzc = new AtomicReference();
    private final SSLSocketFactory zzd = new zzcfz(this);
    private final int zze;
    private final int zzf;
    private final String zzg;
    private final zzhy zzh;
    private zzhh zzi;
    private HttpURLConnection zzj;
    private InputStream zzk;
    private boolean zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    /* access modifiers changed from: private */
    public int zzr;
    private final Set zzs = new HashSet();

    zzcga(String str, zzie zzie, int i, int i2, int i3) {
        super(true);
        zzeq.zzc(str);
        this.zzg = str;
        this.zzh = new zzhy();
        this.zze = i;
        this.zzf = i2;
        this.zzr = i3;
        if (zzie != null) {
            zzf(zzie);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzm.zzh("Unexpected error while disconnecting", e);
            }
            this.zzj = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0255 A[Catch:{ IOException -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0286 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b9 A[Catch:{ IOException -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e3 A[Catch:{ IOException -> 0x02a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0247  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzb(com.google.android.gms.internal.ads.zzhh r21) throws com.google.android.gms.internal.ads.zzhv {
        /*
            r20 = this;
            r1 = r20
            r7 = r21
            java.lang.String r2 = "Unable to connect to "
            r1.zzi = r7
            r3 = 0
            r1.zzq = r3
            r1.zzp = r3
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x02a5 }
            android.net.Uri r5 = r7.zza     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x02a5 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x02a5 }
            byte[] r5 = r7.zzc     // Catch:{ IOException -> 0x02a5 }
            long r5 = r7.zze     // Catch:{ IOException -> 0x02a5 }
            long r8 = r7.zzf     // Catch:{ IOException -> 0x02a5 }
            r10 = 1
            boolean r11 = r7.zzb(r10)     // Catch:{ IOException -> 0x02a5 }
            r13 = 0
        L_0x0025:
            int r14 = r13 + 1
            r15 = 20
            if (r13 > r15) goto L_0x028e
            java.net.URLConnection r13 = r0.openConnection()     // Catch:{ IOException -> 0x02a5 }
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x02a5 }
            boolean r15 = r13 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ IOException -> 0x02a5 }
            if (r15 == 0) goto L_0x003d
            r15 = r13
            javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15     // Catch:{ IOException -> 0x02a5 }
            javax.net.ssl.SSLSocketFactory r10 = r1.zzd     // Catch:{ IOException -> 0x02a5 }
            r15.setSSLSocketFactory(r10)     // Catch:{ IOException -> 0x02a5 }
        L_0x003d:
            int r10 = r1.zze     // Catch:{ IOException -> 0x02a5 }
            r13.setConnectTimeout(r10)     // Catch:{ IOException -> 0x02a5 }
            int r10 = r1.zzf     // Catch:{ IOException -> 0x02a5 }
            r13.setReadTimeout(r10)     // Catch:{ IOException -> 0x02a5 }
            com.google.android.gms.internal.ads.zzhy r10 = r1.zzh     // Catch:{ IOException -> 0x02a5 }
            java.util.Map r10 = r10.zza()     // Catch:{ IOException -> 0x02a5 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ IOException -> 0x02a5 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IOException -> 0x02a5 }
        L_0x0055:
            boolean r15 = r10.hasNext()     // Catch:{ IOException -> 0x02a5 }
            if (r15 == 0) goto L_0x0073
            java.lang.Object r15 = r10.next()     // Catch:{ IOException -> 0x02a5 }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ IOException -> 0x02a5 }
            java.lang.Object r16 = r15.getKey()     // Catch:{ IOException -> 0x02a5 }
            r12 = r16
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x02a5 }
            java.lang.Object r15 = r15.getValue()     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ IOException -> 0x02a5 }
            r13.setRequestProperty(r12, r15)     // Catch:{ IOException -> 0x02a5 }
            goto L_0x0055
        L_0x0073:
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r18 = -1
            if (r10 != 0) goto L_0x007e
            int r10 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r10 == 0) goto L_0x00b0
            goto L_0x007f
        L_0x007e:
            r3 = r5
        L_0x007f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02a5 }
            r10.<init>()     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r12 = "bytes="
            r10.append(r12)     // Catch:{ IOException -> 0x02a5 }
            r10.append(r3)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r12 = "-"
            r10.append(r12)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x02a5 }
            int r12 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r12 == 0) goto L_0x00ab
            long r3 = r3 + r8
            long r3 = r3 + r18
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02a5 }
            r12.<init>()     // Catch:{ IOException -> 0x02a5 }
            r12.append(r10)     // Catch:{ IOException -> 0x02a5 }
            r12.append(r3)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r10 = r12.toString()     // Catch:{ IOException -> 0x02a5 }
        L_0x00ab:
            java.lang.String r3 = "Range"
            r13.setRequestProperty(r3, r10)     // Catch:{ IOException -> 0x02a5 }
        L_0x00b0:
            java.lang.String r3 = "User-Agent"
            java.lang.String r4 = r1.zzg     // Catch:{ IOException -> 0x02a5 }
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02a5 }
            if (r11 != 0) goto L_0x00c0
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r13.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x02a5 }
        L_0x00c0:
            r3 = 0
            r13.setInstanceFollowRedirects(r3)     // Catch:{ IOException -> 0x02a5 }
            r13.setDoOutput(r3)     // Catch:{ IOException -> 0x02a5 }
            r13.connect()     // Catch:{ IOException -> 0x02a5 }
            int r4 = r13.getResponseCode()     // Catch:{ IOException -> 0x02a5 }
            r10 = 300(0x12c, float:4.2E-43)
            if (r4 == r10) goto L_0x0247
            r10 = 301(0x12d, float:4.22E-43)
            if (r4 == r10) goto L_0x0247
            r10 = 302(0x12e, float:4.23E-43)
            if (r4 == r10) goto L_0x0247
            r10 = 303(0x12f, float:4.25E-43)
            if (r4 == r10) goto L_0x0247
            r10 = 307(0x133, float:4.3E-43)
            if (r4 == r10) goto L_0x0247
            r10 = 308(0x134, float:4.32E-43)
            if (r4 != r10) goto L_0x00ec
            r4 = 1
            r16 = 0
            goto L_0x024a
        L_0x00ec:
            r1.zzj = r13     // Catch:{ IOException -> 0x02a5 }
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x0227 }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x0227 }
            r1.zzm = r0     // Catch:{ IOException -> 0x0227 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 < r2) goto L_0x01ff
            r3 = 299(0x12b, float:4.19E-43)
            if (r0 <= r3) goto L_0x0100
            goto L_0x01ff
        L_0x0100:
            if (r0 != r2) goto L_0x010d
            long r2 = r7.zze
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x010f
            r2 = 0
            goto L_0x010f
        L_0x010d:
            r2 = 0
        L_0x010f:
            r1.zzn = r2
            r2 = 1
            boolean r0 = r7.zzb(r2)
            if (r0 != 0) goto L_0x01dd
            long r2 = r7.zzf
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x0122
            r1.zzo = r2
            goto L_0x01e1
        L_0x0122:
            java.net.HttpURLConnection r2 = r1.zzj
            java.lang.String r0 = "Content-Length"
            java.lang.String r3 = r2.getHeaderField(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "]"
            if (r0 != 0) goto L_0x0152
            long r5 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x0137 }
            goto L_0x0154
        L_0x0137:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Unexpected Content-Length ["
            r0.append(r5)
            r0.append(r3)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            r5 = r18
            goto L_0x0154
        L_0x0152:
            r5 = r18
        L_0x0154:
            java.lang.String r0 = "Content-Range"
            java.lang.String r2 = r2.getHeaderField(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x01cf
            java.util.regex.Pattern r0 = zzb
            java.util.regex.Matcher r0 = r0.matcher(r2)
            boolean r8 = r0.find()
            if (r8 == 0) goto L_0x01cf
            r8 = 2
            java.lang.String r8 = r0.group(r8)     // Catch:{ NumberFormatException -> 0x01b6 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x01b6 }
            r10 = 1
            java.lang.String r0 = r0.group(r10)     // Catch:{ NumberFormatException -> 0x01b6 }
            long r10 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x01b6 }
            long r8 = r8 - r10
            r16 = 0
            int r0 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            r10 = 1
            long r8 = r8 + r10
            if (r0 >= 0) goto L_0x018b
            r5 = r8
            goto L_0x01b5
        L_0x018b:
            int r0 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x01b4
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01b6 }
            r0.<init>()     // Catch:{ NumberFormatException -> 0x01b6 }
            java.lang.String r10 = "Inconsistent headers ["
            r0.append(r10)     // Catch:{ NumberFormatException -> 0x01b6 }
            r0.append(r3)     // Catch:{ NumberFormatException -> 0x01b6 }
            java.lang.String r3 = "] ["
            r0.append(r3)     // Catch:{ NumberFormatException -> 0x01b6 }
            r0.append(r2)     // Catch:{ NumberFormatException -> 0x01b6 }
            r0.append(r4)     // Catch:{ NumberFormatException -> 0x01b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x01b6 }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)     // Catch:{ NumberFormatException -> 0x01b6 }
            long r2 = java.lang.Math.max(r5, r8)     // Catch:{ NumberFormatException -> 0x01b6 }
            r5 = r2
            goto L_0x01b5
        L_0x01b4:
        L_0x01b5:
            goto L_0x01d0
        L_0x01b6:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Unexpected Content-Range ["
            r0.append(r3)
            r0.append(r2)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r0)
            goto L_0x01d0
        L_0x01cf:
        L_0x01d0:
            int r0 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r0 == 0) goto L_0x01d8
            long r2 = r1.zzn
            long r18 = r5 - r2
        L_0x01d8:
            r2 = r18
            r1.zzo = r2
            goto L_0x01e1
        L_0x01dd:
            long r2 = r7.zzf
            r1.zzo = r2
        L_0x01e1:
            java.net.HttpURLConnection r0 = r1.zzj     // Catch:{ IOException -> 0x01f2 }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x01f2 }
            r1.zzk = r0     // Catch:{ IOException -> 0x01f2 }
            r2 = 1
            r1.zzl = r2
            r20.zzj(r21)
            long r2 = r1.zzo
            return r2
        L_0x01f2:
            r0 = move-exception
            r20.zzn()
            com.google.android.gms.internal.ads.zzhv r2 = new com.google.android.gms.internal.ads.zzhv
            r3 = 2000(0x7d0, float:2.803E-42)
            r4 = 1
            r2.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zzhh) r7, (int) r3, (int) r4)
            throw r2
        L_0x01ff:
            java.net.HttpURLConnection r0 = r1.zzj
            java.util.Map r6 = r0.getHeaderFields()
            r20.zzn()
            com.google.android.gms.internal.ads.zzhx r0 = new com.google.android.gms.internal.ads.zzhx
            int r3 = r1.zzm
            byte[] r8 = com.google.android.gms.internal.ads.zzgd.zzf
            r4 = 0
            r5 = 0
            r2 = r0
            r7 = r21
            r2.<init>(r3, r4, r5, r6, r7, r8)
            int r2 = r1.zzm
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 != r3) goto L_0x0226
            com.google.android.gms.internal.ads.zzhc r2 = new com.google.android.gms.internal.ads.zzhc
            r3 = 2008(0x7d8, float:2.814E-42)
            r2.<init>(r3)
            r0.initCause(r2)
        L_0x0226:
            throw r0
        L_0x0227:
            r0 = move-exception
            r4 = r0
            r20.zzn()
            com.google.android.gms.internal.ads.zzhv r0 = new com.google.android.gms.internal.ads.zzhv
            android.net.Uri r3 = r7.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r8 = 1
            r2 = r0
            r5 = r21
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            throw r0
        L_0x0247:
            r4 = 1
            r16 = 0
        L_0x024a:
            java.lang.String r10 = "Location"
            java.lang.String r10 = r13.getHeaderField(r10)     // Catch:{ IOException -> 0x02a5 }
            r13.disconnect()     // Catch:{ IOException -> 0x02a5 }
            if (r10 == 0) goto L_0x0286
            java.net.URL r12 = new java.net.URL     // Catch:{ IOException -> 0x02a5 }
            r12.<init>(r0, r10)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r0 = r12.getProtocol()     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r10 = "https"
            boolean r10 = r10.equals(r0)     // Catch:{ IOException -> 0x02a5 }
            if (r10 != 0) goto L_0x027f
            java.lang.String r10 = "http"
            boolean r10 = r10.equals(r0)     // Catch:{ IOException -> 0x02a5 }
            if (r10 == 0) goto L_0x026f
            goto L_0x027f
        L_0x026f:
            java.net.ProtocolException r3 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r4 = "Unsupported protocol redirect: "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x02a5 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x02a5 }
            throw r3     // Catch:{ IOException -> 0x02a5 }
        L_0x027f:
            r10 = r4
            r0 = r12
            r13 = r14
            r3 = r16
            goto L_0x0025
        L_0x0286:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r3 = "Null location redirect"
            r0.<init>(r3)     // Catch:{ IOException -> 0x02a5 }
            throw r0     // Catch:{ IOException -> 0x02a5 }
        L_0x028e:
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x02a5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x02a5 }
            r3.<init>()     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r4 = "Too many redirects: "
            r3.append(r4)     // Catch:{ IOException -> 0x02a5 }
            r3.append(r14)     // Catch:{ IOException -> 0x02a5 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x02a5 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x02a5 }
            throw r0     // Catch:{ IOException -> 0x02a5 }
        L_0x02a5:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.internal.ads.zzhv r0 = new com.google.android.gms.internal.ads.zzhv
            android.net.Uri r3 = r7.zza
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r3 = r2.concat(r3)
            r6 = 2000(0x7d0, float:2.803E-42)
            r8 = 1
            r2 = r0
            r5 = r21
            r7 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcga.zzb(com.google.android.gms.internal.ads.zzhh):long");
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzhv {
        try {
            if (this.zzk != null) {
                int i = zzgd.zza;
                this.zzk.close();
            }
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
        } catch (IOException e) {
            throw new zzhv(e, this.zzi, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 3);
        } catch (Throwable th) {
            this.zzk = null;
            zzn();
            if (this.zzl) {
                this.zzl = false;
                zzh();
            }
            this.zzs.clear();
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzj;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final void zzm(int i) {
        this.zzr = i;
        for (Socket socket : this.zzs) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzr);
                } catch (SocketException e) {
                    zzm.zzk("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzhv {
        try {
            if (this.zzp != this.zzn) {
                byte[] bArr2 = (byte[]) zzc.getAndSet((Object) null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzp;
                    long j2 = this.zzn;
                    if (j == j2) {
                        zzc.set(bArr2);
                        break;
                    }
                    int read = this.zzk.read(bArr2, 0, (int) Math.min(j2 - j, (long) bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzp += (long) read;
                        zzg(read);
                    } else {
                        throw new EOFException();
                    }
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzo;
            if (j3 != -1) {
                long j4 = j3 - this.zzq;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j4);
            }
            int read2 = this.zzk.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzq += (long) read2;
                zzg(read2);
                return read2;
            } else if (this.zzo == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzhv(e, this.zzi, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 2);
        }
    }
}
