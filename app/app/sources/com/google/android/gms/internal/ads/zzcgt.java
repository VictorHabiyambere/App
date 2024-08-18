package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzcgt extends zzgv implements zzhz {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhy zzf = new zzhy();
    private zzhh zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcgt(String str, zzie zzie, int i, int i2, long j, long j2) {
        super(true);
        zzeq.zzc(str);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzi = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
        if (zzie != null) {
            zzf(zzie);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e) {
                zzm.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzh = null;
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzhv {
        int i3 = i2;
        if (i3 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            long j2 = this.zzn;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzo + j2;
            long j4 = (long) i3;
            long j5 = this.zzs;
            long j6 = this.zzq;
            long j7 = j6 + 1;
            if (j3 + j4 + j5 > j7) {
                long j8 = this.zzp;
                if (j6 < j8) {
                    long min = Math.min(j8, Math.max(((this.zzr + j7) - j5) - 1, -1 + j7 + j4));
                    long j9 = j7;
                    long j10 = min;
                    zzk(j9, min, 2);
                    this.zzq = j10;
                    j6 = j10;
                }
            }
            int read = this.zzj.read(bArr, i, (int) Math.min(j4, ((j6 + 1) - this.zzo) - this.zzn));
            if (read != -1) {
                this.zzn += (long) read;
                zzg(read);
                return read;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new zzhv(e, this.zzg, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 2);
        }
    }

    public final long zzb(zzhh zzhh) throws zzhv {
        long j;
        this.zzg = zzhh;
        this.zzn = 0;
        long j2 = zzhh.zze;
        long j3 = zzhh.zzf;
        if (j3 == -1) {
            j = this.zzr;
        } else {
            j = Math.min(this.zzr, j3);
        }
        this.zzo = j2;
        this.zzh = zzk(j2, (j + j2) - 1, 1);
        String headerField = this.zzh.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long parseLong = Long.parseLong(matcher.group(2));
                    long parseLong2 = Long.parseLong(matcher.group(3));
                    long j4 = zzhh.zzf;
                    if (j4 != -1) {
                        this.zzm = j4;
                        this.zzp = Math.max(parseLong, (this.zzo + j4) - 1);
                    } else {
                        this.zzm = parseLong2 - this.zzo;
                        this.zzp = parseLong2 - 1;
                    }
                    this.zzq = parseLong;
                    this.zzk = true;
                    zzj(zzhh);
                    return this.zzm;
                } catch (NumberFormatException e) {
                    zzm.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzcgr(headerField, zzhh);
    }

    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final void zzd() throws zzhv {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                inputStream.close();
            }
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
        } catch (IOException e) {
            throw new zzhv(e, this.zzg, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 3);
        } catch (Throwable th) {
            this.zzj = null;
            zzl();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            throw th;
        }
    }

    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzk(long j, long j2, int i) throws zzhv {
        String uri = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zze);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String uri2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcgs(this.zzl, headerFields, this.zzg, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzl();
                    throw new zzhv(e, this.zzg, (int) CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, i);
                }
            } catch (IOException e2) {
                zzl();
                String valueOf = String.valueOf(uri2);
                zzhh zzhh = this.zzg;
                throw new zzhv("Unable to connect to ".concat(valueOf), e2, zzhh, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, i);
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            String valueOf2 = String.valueOf(uri);
            throw new zzhv("Unable to connect to ".concat(valueOf2), iOException, this.zzg, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, i);
        }
    }
}
