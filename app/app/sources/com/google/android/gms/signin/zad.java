package com.google.android.gms.signin;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zad {
    public static final Api.ClientKey zaa = new Api.ClientKey();
    public static final Api.ClientKey zab = new Api.ClientKey();
    public static final Api.AbstractClientBuilder zac = new zaa();
    static final Api.AbstractClientBuilder zad = new zab();
    public static final Scope zae = new Scope(Scopes.PROFILE);
    public static final Scope zaf = new Scope("email");
    public static final Api zag = new Api("SignIn.API", zac, zaa);
    public static final Api zah = new Api("SignIn.INTERNAL_API", zad, zab);
}
