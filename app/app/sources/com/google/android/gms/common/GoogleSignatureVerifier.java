package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@CheckReturnValue
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    @Nullable
    private static volatile Set zzb;
    private final Context zzc;
    private volatile String zzd;

    public GoogleSignatureVerifier(Context context) {
        this.zzc = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zza == null) {
                zzn.zze(context);
                zza = new GoogleSignatureVerifier(context);
            }
        }
        return zza;
    }

    @Nullable
    static final zzj zza(PackageInfo packageInfo, zzj... zzjArr) {
        if (packageInfo.signatures != null) {
            if (packageInfo.signatures.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zzjArr.length; i++) {
                if (zzjArr[i].equals(zzk)) {
                    return zzjArr[i];
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzb(android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x002c
            if (r4 == 0) goto L_0x002a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x002c
        L_0x001a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L_0x0020
            r5 = r1
            goto L_0x0029
        L_0x0020:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x0028
            r5 = r0
            goto L_0x0029
        L_0x0028:
            r5 = r1
        L_0x0029:
            goto L_0x002d
        L_0x002a:
            r2 = 0
            goto L_0x002e
        L_0x002c:
        L_0x002d:
            r2 = r4
        L_0x002e:
            if (r4 == 0) goto L_0x004c
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L_0x004c
            if (r5 == 0) goto L_0x003d
            com.google.android.gms.common.zzj[] r4 = com.google.android.gms.common.zzm.zza
            com.google.android.gms.common.zzj r4 = zza(r2, r4)
            goto L_0x0049
        L_0x003d:
            com.google.android.gms.common.zzj[] r4 = new com.google.android.gms.common.zzj[r0]
            com.google.android.gms.common.zzj[] r5 = com.google.android.gms.common.zzm.zza
            r5 = r5[r1]
            r4[r1] = r5
            com.google.android.gms.common.zzj r4 = zza(r2, r4)
        L_0x0049:
            if (r4 == 0) goto L_0x004c
            return r0
        L_0x004c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzb(android.content.pm.PackageInfo, boolean):boolean");
    }

    private final zzx zzc(@Nullable String str, boolean z, boolean z2) {
        zzx zzx;
        if (str == null) {
            return zzx.zzc("null pkg");
        }
        if (str.equals(this.zzd)) {
            return zzx.zzb();
        }
        if (zzn.zzg()) {
            zzx = zzn.zzb(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.zzc.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc);
                if (packageInfo == null) {
                    zzx = zzx.zzc("null pkg");
                } else if (packageInfo.signatures == null || packageInfo.signatures.length != 1) {
                    zzx = zzx.zzc("single cert required");
                } else {
                    zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
                    String str2 = packageInfo.packageName;
                    zzx zza2 = zzn.zza(str2, zzk, honorsDebugCertificates, false);
                    zzx = (!zza2.zza || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || !zzn.zza(str2, zzk, false, true).zza) ? zza2 : zzx.zzc("debuggable release cert app rejected");
                }
            } catch (PackageManager.NameNotFoundException e) {
                return zzx.zzd("no pkg ".concat(str), e);
            }
        }
        if (zzx.zza) {
            this.zzd = str;
        }
        return zzx;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zzb(packageInfo, false)) {
            return true;
        }
        if (zzb(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzc)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isPackageGoogleSigned(@Nullable String callingPackage) {
        zzx zzc2 = zzc(callingPackage, false, false);
        zzc2.zze();
        return zzc2.zza;
    }

    public boolean isUidGoogleSigned(int uid) {
        zzx zzx;
        int length;
        String[] packagesForUid = this.zzc.getPackageManager().getPackagesForUid(uid);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzx = null;
            int i = 0;
            while (true) {
                if (i >= length) {
                    Preconditions.checkNotNull(zzx);
                    break;
                }
                zzx = zzc(packagesForUid[i], false, false);
                if (zzx.zza) {
                    break;
                }
                i++;
            }
        } else {
            zzx = zzx.zzc("no pkgs");
        }
        zzx.zze();
        return zzx.zza;
    }
}
