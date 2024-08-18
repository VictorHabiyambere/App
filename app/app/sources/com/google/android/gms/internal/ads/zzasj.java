package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public class zzasj extends zzare {
    private final Object zza = new Object();
    private final zzarj zzb;

    public zzasj(int i, String str, zzarj zzarj, zzari zzari) {
        super(i, str, zzari);
        this.zzb = zzarj;
    }

    /* access modifiers changed from: protected */
    public final zzark zzh(zzara zzara) {
        String str;
        try {
            byte[] bArr = zzara.zzb;
            Map map = zzara.zzc;
            String str2 = "ISO-8859-1";
            if (map != null) {
                String str3 = (String) map.get(HttpHeaders.CONTENT_TYPE);
                if (str3 != null) {
                    String[] split = str3.split(";", 0);
                    int i = 1;
                    while (true) {
                        if (i >= split.length) {
                            break;
                        }
                        String[] split2 = split[i].trim().split("=", 0);
                        if (split2.length == 2 && split2[0].equals("charset")) {
                            str2 = split2[1];
                            break;
                        }
                        i++;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException e) {
            str = new String(zzara.zzb);
        }
        return zzark.zzb(str, zzasb.zzb(zzara));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzz */
    public void zzo(String str) {
        zzarj zzarj;
        synchronized (this.zza) {
            zzarj = this.zzb;
        }
        zzarj.zza(str);
    }
}
