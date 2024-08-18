package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbgt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.2.0 */
abstract class zzax {
    private static final zzce zza;

    static {
        zzce zzce = null;
        try {
            Object newInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzm.zzj("ClientApi class is not an instance of IBinder.");
            } else {
                IBinder iBinder = (IBinder) newInstance;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzce = queryLocalInterface instanceof zzce ? (zzce) queryLocalInterface : new zzcc(iBinder);
                }
            }
        } catch (Exception e) {
            zzm.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzce;
    }

    zzax() {
    }

    private final Object zze() {
        zzce zzce = zza;
        if (zzce != null) {
            try {
                return zzb(zzce);
            } catch (RemoteException e) {
                zzm.zzk("Cannot invoke local loader using ClientApi class.", e);
                return null;
            }
        } else {
            zzm.zzj("ClientApi class cannot be loaded.");
            return null;
        }
    }

    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e) {
            zzm.zzk("Cannot invoke remote loader.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza();

    /* access modifiers changed from: protected */
    public abstract Object zzb(zzce zzce) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        Object obj;
        boolean z5 = false;
        if (!z) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            zzay.zzb();
            if (!zzf.zzt(context, 12451000)) {
                zzm.zze("Google Play Services is not available.");
                z2 = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z3 = false;
        } else {
            z3 = true;
        }
        boolean z6 = !z3;
        zzbep.zza(context);
        if (((Boolean) zzbgf.zza.zze()).booleanValue()) {
            z4 = false;
        } else if (((Boolean) zzbgf.zzb.zze()).booleanValue()) {
            z4 = true;
            z5 = true;
        } else {
            z5 = z2 | z6;
            z4 = false;
        }
        if (z5) {
            obj = zze();
            if (obj == null && !z4) {
                obj = zzf();
            }
        } else {
            Object zzf = zzf();
            if (zzf == null) {
                if (zzay.zze().nextInt(((Long) zzbgt.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
                }
            }
            obj = zzf == null ? zze() : zzf;
        }
        return obj == null ? zza() : obj;
    }
}
