package com.google.android.gms.fido.u2f.api.messagebased;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum RequestType {
    REGISTER("u2f_register_request"),
    SIGN("u2f_sign_request");
    
    private final String zzb;

    /* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
    public static class UnsupportedRequestTypeException extends Exception {
        public UnsupportedRequestTypeException(String value) {
            super("Unsupported request type ".concat(String.valueOf(value)));
        }
    }

    private RequestType(String str) {
        this.zzb = str;
    }

    public static RequestType fromString(String value) throws UnsupportedRequestTypeException {
        for (RequestType requestType : values()) {
            if (value.equals(requestType.zzb)) {
                return requestType;
            }
        }
        throw new UnsupportedRequestTypeException(value);
    }

    public String toString() {
        return this.zzb;
    }
}
