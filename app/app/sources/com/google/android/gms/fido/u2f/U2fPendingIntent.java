package com.google.android.gms.fido.u2f;

import android.app.Activity;
import android.content.IntentSender;

@Deprecated
/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
public interface U2fPendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity activity, int i) throws IntentSender.SendIntentException;
}
