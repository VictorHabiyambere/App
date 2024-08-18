package com.google.android.gms.auth;

import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class CookieUtil {
    private CookieUtil() {
    }

    public static String getCookieUrl(String domain, Boolean isSecure) {
        Preconditions.checkNotEmpty(domain);
        String str = true != zza(isSecure) ? ProxyConfig.MATCH_HTTP : ProxyConfig.MATCH_HTTPS;
        return str + "://" + domain;
    }

    public static String getCookieValue(String name, String value, String domain, String path, Boolean isHttpOnly, Boolean isSecure, Long maxAge) {
        if (name == null) {
            name = "";
        }
        StringBuilder sb = new StringBuilder(name);
        sb.append('=');
        if (!TextUtils.isEmpty(value)) {
            sb.append(value);
        }
        if (zza(isHttpOnly)) {
            sb.append(";HttpOnly");
        }
        if (zza(isSecure)) {
            sb.append(";Secure");
        }
        if (!TextUtils.isEmpty(domain)) {
            sb.append(";Domain=");
            sb.append(domain);
        }
        if (!TextUtils.isEmpty(path)) {
            sb.append(";Path=");
            sb.append(path);
        }
        if (maxAge != null && maxAge.longValue() > 0) {
            sb.append(";Max-Age=");
            sb.append(maxAge);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb.append(";Priority=null");
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            sb.append(";SameSite=null");
        }
        if (zza((Boolean) null)) {
            sb.append(";SameParty");
        }
        return sb.toString();
    }

    private static boolean zza(Boolean bool) {
        return bool != null && bool.booleanValue();
    }
}
