package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    protected GservicesValue(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    @ResultIgnorabilityUnspecified
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    public static GservicesValue<Float> value(String str, Float f) {
        return new zzd(str, f);
    }

    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }

    public static GservicesValue<Boolean> value(String key, boolean defaultValue) {
        return new zza(key, Boolean.valueOf(defaultValue));
    }

    @ResultIgnorabilityUnspecified
    public final T get() {
        T t;
        long clearCallingIdentity;
        T t2 = this.zzd;
        if (t2 != null) {
            return t2;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        synchronized (zzc) {
        }
        synchronized (zzc) {
        }
        try {
            t = zza(this.zza);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            T zza2 = zza(this.zza);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            t = zza2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return t;
    }

    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    public void override(T value) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = value;
        synchronized (zzc) {
            synchronized (zzc) {
            }
        }
    }

    public void resetOverride() {
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(String str);
}
