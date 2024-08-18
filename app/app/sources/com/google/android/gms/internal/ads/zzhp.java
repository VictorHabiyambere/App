package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzhp extends zzgv implements zzhz {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhy zzf;
    private final zzhy zzg;
    private zzhh zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzhp() {
        this((String) null, 8000, 8000, false, (zzhy) null, (zzfyh) null, false);
    }

    /* synthetic */ zzhp(String str, int i, int i2, boolean z, zzhy zzhy, zzfyh zzfyh, boolean z2, zzho zzho) {
        this(str, i, i2, z, zzhy, (zzfyh) null, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.HttpURLConnection zzk(java.net.URL r3, int r4, byte[] r5, long r6, long r8, boolean r10, boolean r11, java.util.Map r12) throws java.io.IOException {
        /*
            r2 = this;
            java.net.URLConnection r3 = r3.openConnection()
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3
            int r4 = r2.zzc
            r3.setConnectTimeout(r4)
            int r4 = r2.zzd
            r3.setReadTimeout(r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            com.google.android.gms.internal.ads.zzhy r5 = r2.zzf
            if (r5 == 0) goto L_0x0020
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
        L_0x0020:
            com.google.android.gms.internal.ads.zzhy r5 = r2.zzg
            java.util.Map r5 = r5.zza()
            r4.putAll(r5)
            r4.putAll(r12)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0034:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0050
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r12 = r5.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            r3.setRequestProperty(r12, r5)
            goto L_0x0034
        L_0x0050:
            r4 = 0
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r0 = -1
            if (r12 != 0) goto L_0x0060
            int r6 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r6 != 0) goto L_0x005e
            r4 = 0
            goto L_0x0080
        L_0x005e:
            r6 = r4
            goto L_0x0061
        L_0x0060:
        L_0x0061:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "bytes="
            r4.append(r5)
            r4.append(r6)
            java.lang.String r5 = "-"
            r4.append(r5)
            int r5 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r5 == 0) goto L_0x007c
            long r6 = r6 + r8
            long r6 = r6 + r0
            r4.append(r6)
        L_0x007c:
            java.lang.String r4 = r4.toString()
        L_0x0080:
            if (r4 == 0) goto L_0x0087
            java.lang.String r5 = "Range"
            r3.setRequestProperty(r5, r4)
        L_0x0087:
            java.lang.String r4 = r2.zze
            if (r4 == 0) goto L_0x0090
            java.lang.String r5 = "User-Agent"
            r3.setRequestProperty(r5, r4)
        L_0x0090:
            r4 = 1
            if (r4 == r10) goto L_0x0096
            java.lang.String r4 = "identity"
            goto L_0x0098
        L_0x0096:
            java.lang.String r4 = "gzip"
        L_0x0098:
            java.lang.String r5 = "Accept-Encoding"
            r3.setRequestProperty(r5, r4)
            r3.setInstanceFollowRedirects(r11)
            r4 = 0
            r3.setDoOutput(r4)
            int r4 = com.google.android.gms.internal.ads.zzhh.zzh
            java.lang.String r4 = "GET"
            r3.setRequestMethod(r4)
            r3.connect()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhp.zzk(java.net.URL, int, byte[], long, long, boolean, boolean, java.util.Map):java.net.HttpURLConnection");
    }

    private final URL zzl(URL url, String str, zzhh zzhh) throws zzhv {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!ProxyConfig.MATCH_HTTPS.equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                    throw new zzhv("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzhh, 2001, 1);
                } else if (this.zzb || protocol.equals(url.getProtocol())) {
                    return url2;
                } else {
                    String protocol2 = url.getProtocol();
                    throw new zzhv("Disallowed cross-protocol redirect (" + protocol2 + " to " + protocol + ")", zzhh, 2001, 1);
                }
            } catch (MalformedURLException e) {
                throw new zzhv((IOException) e, zzhh, 2001, 1);
            }
        } else {
            throw new zzhv("Null location redirect", zzhh, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzfk.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzhv {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            if (j != -1) {
                long j2 = j - this.zzn;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j2);
            }
            InputStream inputStream = this.zzj;
            int i3 = zzgd.zza;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.zzn += (long) read;
            zzg(read);
            return read;
        } catch (IOException e) {
            zzhh zzhh = this.zzh;
            int i4 = zzgd.zza;
            throw zzhv.zza(e, zzhh, 2);
        }
    }

    public final long zzb(zzhh zzhh) throws zzhv {
        int i;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str;
        byte[] bArr;
        byte[] bArr2;
        long j;
        zzhh zzhh2 = zzhh;
        this.zzh = zzhh2;
        this.zzn = 0;
        this.zzm = 0;
        zzi(zzhh);
        try {
            URL url = new URL(zzhh2.zza.toString());
            int i2 = zzhh2.zzb;
            byte[] bArr3 = zzhh2.zzc;
            long j2 = zzhh2.zze;
            long j3 = zzhh2.zzf;
            boolean zzb2 = zzhh2.zzb(1);
            if (!this.zzb) {
                try {
                    httpURLConnection = zzk(url, 1, (byte[]) null, j2, j3, zzb2, true, zzhh2.zzd);
                } catch (IOException e) {
                    e = e;
                    i = 1;
                    zzm();
                    throw zzhv.zza(e, zzhh2, i);
                }
            } else {
                URL url2 = url;
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    if (i3 <= 20) {
                        int i5 = i4;
                        long j4 = j3;
                        long j5 = j2;
                        URL url3 = url2;
                        HttpURLConnection zzk2 = zzk(url2, 1, (byte[]) null, j2, j3, zzb2, false, zzhh2.zzd);
                        int responseCode = zzk2.getResponseCode();
                        String headerField = zzk2.getHeaderField(HttpHeaders.LOCATION);
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307) {
                            if (responseCode != 308) {
                                httpURLConnection = zzk2;
                                break;
                            }
                            i = 1;
                        } else {
                            i = 1;
                        }
                        try {
                            zzk2.disconnect();
                            url2 = zzl(url3, headerField, zzhh2);
                            i3 = i5;
                            j3 = j4;
                            j2 = j5;
                        } catch (IOException e2) {
                            e = e2;
                            zzm();
                            throw zzhv.zza(e, zzhh2, i);
                        }
                    } else {
                        throw new zzhv((IOException) new NoRouteToHostException("Too many redirects: " + i4), zzhh2, 2001, 1);
                    }
                }
            }
            this.zzi = httpURLConnection;
            HttpURLConnection httpURLConnection2 = this.zzi;
            this.zzl = httpURLConnection2.getResponseCode();
            String responseMessage = httpURLConnection2.getResponseMessage();
            int i6 = this.zzl;
            long j6 = -1;
            if (i6 < 200) {
                z = true;
            } else if (i6 > 299) {
                z = true;
            } else {
                httpURLConnection2.getContentType();
                if (this.zzl == 200) {
                    j = zzhh2.zze;
                    if (j == 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                boolean equalsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                if (!equalsIgnoreCase) {
                    long j7 = zzhh2.zzf;
                    if (j7 != -1) {
                        this.zzm = j7;
                    } else {
                        long zza = zzia.zza(httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        if (zza != -1) {
                            j6 = zza - j;
                        }
                        this.zzm = j6;
                    }
                } else {
                    this.zzm = zzhh2.zzf;
                }
                try {
                    this.zzj = httpURLConnection2.getInputStream();
                    if (equalsIgnoreCase) {
                        this.zzj = new GZIPInputStream(this.zzj);
                    }
                    this.zzk = true;
                    zzj(zzhh);
                    if (j != 0) {
                        try {
                            byte[] bArr4 = new byte[4096];
                            while (j > 0) {
                                int min = (int) Math.min(j, 4096);
                                InputStream inputStream = this.zzj;
                                int i7 = zzgd.zza;
                                int read = inputStream.read(bArr4, 0, min);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzhv((IOException) new InterruptedIOException(), zzhh2, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 1);
                                } else if (read != -1) {
                                    j -= (long) read;
                                    zzg(read);
                                } else {
                                    throw new zzhv(zzhh2, 2008, 1);
                                }
                            }
                        } catch (IOException e3) {
                            zzm();
                            if (e3 instanceof zzhv) {
                                throw ((zzhv) e3);
                            }
                            throw new zzhv(e3, zzhh2, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 1);
                        }
                    }
                    return this.zzm;
                } catch (IOException e4) {
                    zzm();
                    throw new zzhv(e4, zzhh2, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 1);
                }
            }
            Map headerFields = httpURLConnection2.getHeaderFields();
            if (this.zzl == 416) {
                str = responseMessage;
                if (zzhh2.zze == zzia.zzb(httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                    this.zzk = z;
                    zzj(zzhh);
                    long j8 = zzhh2.zzf;
                    if (j8 != -1) {
                        return j8;
                    }
                    return 0;
                }
            } else {
                str = responseMessage;
            }
            InputStream errorStream = httpURLConnection2.getErrorStream();
            if (errorStream != null) {
                try {
                    bArr2 = zzgdm.zzb(errorStream);
                } catch (IOException e5) {
                    bArr = zzgd.zzf;
                }
            } else {
                bArr2 = zzgd.zzf;
            }
            bArr = bArr2;
            zzm();
            throw new zzhx(this.zzl, str, this.zzl == 416 ? new zzhc(2008) : null, headerFields, zzhh, bArr);
        } catch (IOException e6) {
            e = e6;
            i = 1;
            zzm();
            throw zzhv.zza(e, zzhh2, i);
        }
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzhv {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                if (this.zzi != null) {
                    int i = zzgd.zza;
                }
                inputStream.close();
            }
            this.zzj = null;
            zzm();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (IOException e) {
            zzhh zzhh = this.zzh;
            int i2 = zzgd.zza;
            throw new zzhv(e, zzhh, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzm();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzgbf.zzd() : new zzhn(httpURLConnection.getHeaderFields());
    }

    private zzhp(String str, int i, int i2, boolean z, zzhy zzhy, zzfyh zzfyh, boolean z2) {
        super(true);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzb = z;
        this.zzf = zzhy;
        this.zzg = new zzhy();
    }
}
