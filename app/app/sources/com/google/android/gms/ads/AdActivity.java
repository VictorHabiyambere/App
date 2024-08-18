package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbvg zza;

    private final void zza() {
        zzbvg zzbvg = this.zza;
        if (zzbvg != null) {
            try {
                zzbvg.zzx();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void onBackPressed() {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null && !zzbvg.zzH()) {
                return;
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbvg zzbvg2 = this.zza;
            if (zzbvg2 != null) {
                zzbvg2.zzi();
            }
        } catch (RemoteException e2) {
            zzm.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = zzay.zza().zzo(this);
        zzbvg zzbvg = this.zza;
        if (zzbvg != null) {
            try {
                zzbvg.zzl(bundle);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
                finish();
            }
        } else {
            zzm.zzl("#007 Could not call remote method.", (Throwable) null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzm();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzo();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void onRestart() {
        super.onRestart();
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzq();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzr();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        super.onStart();
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzt();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzu();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbvg zzbvg = this.zza;
            if (zzbvg != null) {
                zzbvg.zzv();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
