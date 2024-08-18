package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzays extends zzazs {
    private static final zzazt zzi = new zzazt();
    private final Context zzj;

    public zzays(zzaye zzaye, String str, String str2, zzatp zzatp, int i, int i2, Context context, zzatg zzatg) {
        super(zzaye, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzatp, i, 27);
        this.zzj = context;
    }

    private final String zzc() {
        try {
            if (this.zzb.zzl() != null) {
                this.zzb.zzl().get();
            }
            zzaus zzc = this.zzb.zzc();
            if (zzc == null || !zzc.zzar()) {
                return null;
            }
            return zzc.zzi();
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavp zzavp;
        zzatl zzatl;
        String str;
        Boolean bool;
        AtomicReference zza = zzi.zza(this.zzj.getPackageName());
        synchronized (zza) {
            zzavp zzavp2 = (zzavp) zza.get();
            if (zzavp2 == null || zzayh.zzd(zzavp2.zza) || zzavp2.zza.equals("E") || zzavp2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                boolean z = false;
                if (!zzayh.zzd((String) null)) {
                    zzatl = zzatl.ENUM_SIGNAL_SOURCE_CALLER_PROVIDED;
                } else {
                    if (!zzayh.zzd((String) null)) {
                        bool = false;
                    } else {
                        bool = false;
                    }
                    bool.booleanValue();
                    zzatl = zzatl.ENUM_SIGNAL_SOURCE_ADSHIELD;
                }
                if (zzatl == zzatl.ENUM_SIGNAL_SOURCE_ADSHIELD) {
                    z = true;
                }
                Boolean valueOf = Boolean.valueOf(z);
                Boolean bool2 = (Boolean) zzba.zzc().zza(zzbep.zzcu);
                if (((Boolean) zzba.zzc().zza(zzbep.zzct)).booleanValue()) {
                    str = zzb();
                } else {
                    str = null;
                }
                if (bool2.booleanValue() && this.zzb.zzp() && zzayh.zzd(str)) {
                    str = zzc();
                }
                zzavp zzavp3 = new zzavp((String) this.zzf.invoke((Object) null, new Object[]{this.zzj, valueOf, str}));
                if (zzayh.zzd(zzavp3.zza) || zzavp3.zza.equals("E")) {
                    switch (zzatl.ordinal()) {
                        case 3:
                            String zzc = zzc();
                            if (!zzayh.zzd(zzc)) {
                                zzavp3.zza = zzc;
                                break;
                            }
                            break;
                        case 4:
                            throw null;
                    }
                }
                zza.set(zzavp3);
            }
            zzavp = (zzavp) zza.get();
        }
        synchronized (this.zze) {
            if (zzavp != null) {
                this.zze.zzz(zzavp.zza);
                this.zze.zzae(zzavp.zzb);
                this.zze.zzag(zzavp.zzc);
                this.zze.zzj(zzavp.zzd);
                this.zze.zzy(zzavp.zze);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zzb() {
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byte[] zzf = zzayh.zzf((String) zzba.zzc().zza(zzbep.zzcv));
            ArrayList arrayList = new ArrayList();
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(instance.generateCertificate(new ByteArrayInputStream(zzayh.zzf((String) zzba.zzc().zza(zzbep.zzcw)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zzb.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            zzggm zze = zzggm.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new zzazu(zze));
            return (String) zze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | CertificateEncodingException | ExecutionException e) {
            return null;
        } catch (CertificateException e2) {
            return null;
        } catch (NoClassDefFoundError e3) {
            return null;
        }
    }
}
