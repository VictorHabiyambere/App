package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbn {
    private static zbn zbd = null;
    final Storage zba;
    GoogleSignInAccount zbb = this.zba.getSavedDefaultGoogleSignInAccount();
    GoogleSignInOptions zbc = this.zba.getSavedDefaultGoogleSignInOptions();

    private zbn(Context context) {
        this.zba = Storage.getInstance(context);
    }

    public static synchronized zbn zbc(Context context) {
        zbn zbf;
        synchronized (zbn.class) {
            zbf = zbf(context.getApplicationContext());
        }
        return zbf;
    }

    private static synchronized zbn zbf(Context context) {
        zbn zbn;
        synchronized (zbn.class) {
            zbn = zbd;
            if (zbn == null) {
                zbn = new zbn(context);
                zbd = zbn;
            }
        }
        return zbn;
    }

    public final synchronized GoogleSignInAccount zba() {
        return this.zbb;
    }

    public final synchronized GoogleSignInOptions zbb() {
        return this.zbc;
    }

    public final synchronized void zbd() {
        this.zba.clear();
        this.zbb = null;
        this.zbc = null;
    }

    public final synchronized void zbe(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zba.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zbb = googleSignInAccount;
        this.zbc = googleSignInOptions;
    }
}
