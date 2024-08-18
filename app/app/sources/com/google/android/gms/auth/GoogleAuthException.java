package com.google.android.gms.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class GoogleAuthException extends Exception {
    public GoogleAuthException() {
    }

    public GoogleAuthException(String err) {
        super(err);
    }

    public GoogleAuthException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public GoogleAuthException(Throwable throwable) {
        super(throwable);
    }
}
