package com.google.android.gms.fido.u2f.api.messagebased;

import com.google.android.gms.fido.u2f.api.messagebased.RequestType;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public enum ResponseType {
    REGISTER("u2f_register_response"),
    SIGN("u2f_sign_response");
    
    private final String zzb;

    private ResponseType(String str) {
        this.zzb = str;
    }

    public static ResponseType getResponseTypeForRequestType(RequestType requestType) throws RequestType.UnsupportedRequestTypeException {
        if (requestType != null) {
            switch (requestType.ordinal()) {
                case 0:
                    return REGISTER;
                case 1:
                    return SIGN;
                default:
                    throw new RequestType.UnsupportedRequestTypeException(requestType.toString());
            }
        } else {
            throw new RequestType.UnsupportedRequestTypeException((String) null);
        }
    }

    public String toString() {
        return this.zzb;
    }
}
