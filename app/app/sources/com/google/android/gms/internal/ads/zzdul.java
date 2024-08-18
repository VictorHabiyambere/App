package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public enum zzdul {
    PUBLIC_API_CALL("api-call"),
    DYNAMITE_ENTER("dynamite-enter"),
    CLIENT_SIGNALS_START("client-signals-start"),
    CLIENT_SIGNALS_END("client-signals-end"),
    SERVICE_CONNECTED("service-connected"),
    GMS_SIGNALS_START("gms-signals-start"),
    GMS_SIGNALS_END("gms-signals-end"),
    GET_SIGNALS_SDKCORE_START("get-signals-sdkcore-start"),
    GET_SIGNALS_SDKCORE_END("get-signals-sdkcore-end"),
    GET_AD_DICTIONARY_SDKCORE_START("get-ad-dictionary-sdkcore-start"),
    GET_AD_DICTIONARY_SDKCORE_END("get-ad-dictionary-sdkcore-end"),
    HTTP_RESPONSE_READY("http-response-ready"),
    SERVER_RESPONSE_PARSE_START("server-response-parse-start"),
    PUBLIC_API_CALLBACK("public-api-callback");
    
    private final String zzp;

    private zzdul(String str) {
        this.zzp = str;
    }

    public final String zza() {
        return this.zzp;
    }
}
