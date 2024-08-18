package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public abstract class BrowserRequestOptions extends RequestOptions {
    public abstract byte[] getClientDataHash();

    public abstract Uri getOrigin();
}
