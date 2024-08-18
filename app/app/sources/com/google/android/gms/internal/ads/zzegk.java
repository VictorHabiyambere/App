package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.NotificationHandlerActivity;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzegk extends zzbuy {
    final Map zza = new HashMap();
    private final Context zzb;
    private final zzdvc zzc;
    private final zzr zzd;
    private final zzefz zze;
    private String zzf;
    private String zzg;

    public zzegk(Context context, zzefz zzefz, zzr zzr, zzdvc zzdvc) {
        this.zzb = context;
        this.zzc = zzdvc;
        this.zzd = zzr;
        this.zze = zzefz;
    }

    public static void zzc(Context context, zzdvc zzdvc, zzefz zzefz, String str, String str2, Map map) {
        String str3;
        String str4 = true != zzu.zzo().zzA(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY;
        if (zzdvc != null) {
            zzdvb zza2 = zzdvc.zza();
            zza2.zzb("gqi", str);
            zza2.zzb("action", str2);
            zza2.zzb("device_connectivity", str4);
            zza2.zzb("event_timestamp", String.valueOf(zzu.zzB().currentTimeMillis()));
            for (Map.Entry entry : map.entrySet()) {
                zza2.zzb((String) entry.getKey(), (String) entry.getValue());
            }
            str3 = zza2.zze();
        } else {
            str3 = "";
        }
        zzefz.zzd(new zzegb(zzu.zzB().currentTimeMillis(), str, str3, 2));
    }

    public static final PendingIntent zzq(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("offline_notification_action", str);
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str3);
        if (Build.VERSION.SDK_INT < 29 || !str.equals("offline_notification_clicked")) {
            intent.setClassName(context, AdService.CLASS_NAME);
            return zzfvl.zzb(context, 0, intent, zzfvl.zza | 1073741824, 0);
        }
        intent.setClassName(context, NotificationHandlerActivity.CLASS_NAME);
        return zzfvl.zza(context, 0, intent, 201326592);
    }

    private final String zzr() {
        zzefr zzefr = (zzefr) this.zza.get(this.zzf);
        return zzefr == null ? "" : zzefr.zzb();
    }

    private static String zzs(int i, String str) {
        Resources zze2 = zzu.zzo().zze();
        if (zze2 == null) {
            return str;
        }
        return zze2.getString(i);
    }

    private final void zzt(String str, String str2, Map map) {
        zzc(this.zzb, this.zzc, this.zze, str, str2, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzu() {
        /*
            r6 = this;
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r0 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.util.zzbt r0 = com.google.android.gms.ads.internal.util.zzt.zzz(r0)     // Catch:{ RemoteException -> 0x0040 }
            android.content.Context r1 = r6.zzb     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.ads.internal.offline.buffering.zza r2 = new com.google.android.gms.ads.internal.offline.buffering.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x0040 }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x0040 }
            java.util.Map r5 = r6.zza     // Catch:{ RemoteException -> 0x0040 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ RemoteException -> 0x0040 }
            com.google.android.gms.internal.ads.zzefr r5 = (com.google.android.gms.internal.ads.zzefr) r5     // Catch:{ RemoteException -> 0x0040 }
            if (r5 != 0) goto L_0x0022
            java.lang.String r5 = ""
            goto L_0x0026
        L_0x0022:
            java.lang.String r5 = r5.zzc()     // Catch:{ RemoteException -> 0x0040 }
        L_0x0026:
            r2.<init>(r3, r4, r5)     // Catch:{ RemoteException -> 0x0040 }
            boolean r1 = r0.zzg(r1, r2)     // Catch:{ RemoteException -> 0x0040 }
            if (r1 != 0) goto L_0x0048
            android.content.Context r2 = r6.zzb     // Catch:{ RemoteException -> 0x003e }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r3 = r6.zzg     // Catch:{ RemoteException -> 0x003e }
            java.lang.String r4 = r6.zzf     // Catch:{ RemoteException -> 0x003e }
            boolean r1 = r0.zzf(r2, r3, r4)     // Catch:{ RemoteException -> 0x003e }
            goto L_0x0048
        L_0x003e:
            r0 = move-exception
            goto L_0x0042
        L_0x0040:
            r0 = move-exception
            r1 = 0
        L_0x0042:
            java.lang.String r2 = "Failed to schedule offline notification poster."
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
        L_0x0048:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.internal.ads.zzefz r0 = r6.zze
            java.lang.String r1 = r6.zzf
            r0.zzc(r1)
            java.lang.String r0 = r6.zzf
            com.google.android.gms.internal.ads.zzgbf r1 = com.google.android.gms.internal.ads.zzgbf.zzd()
            java.lang.String r2 = "offline_notification_worker_not_scheduled"
            r6.zzt(r0, r2, r1)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegk.zzu():void");
    }

    private final void zzv(Activity activity, zzm zzm) {
        zzu.zzp();
        if (NotificationManagerCompat.from(activity).areNotificationsEnabled()) {
            zzu();
            zzw(activity, zzm);
        } else if (Build.VERSION.SDK_INT < 33) {
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(activity);
            zzK.setTitle(zzs(R.string.notifications_permission_title, "Allow app to send you notifications?")).setPositiveButton(zzs(R.string.notifications_permission_confirm, HttpHeaders.ALLOW), new zzegd(this, activity, zzm)).setNegativeButton(zzs(R.string.notifications_permission_decline, "Don't allow"), new zzege(this, zzm)).setOnCancelListener(new zzegf(this, zzm));
            zzK.create().show();
            zzt(this.zzf, "rtsdi", zzgbf.zzd());
        } else {
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 12345);
            zzt(this.zzf, "asnpdi", zzgbf.zzd());
        }
    }

    private final void zzw(Activity activity, zzm zzm) {
        XmlResourceParser xmlResourceParser;
        AlertDialog alertDialog;
        zzu.zzp();
        AlertDialog.Builder onCancelListener = zzt.zzK(activity).setOnCancelListener(new zzegc(zzm));
        int i = R.layout.offline_ads_dialog;
        Resources zze2 = zzu.zzo().zze();
        Drawable drawable = null;
        if (zze2 == null) {
            xmlResourceParser = null;
        } else {
            xmlResourceParser = zze2.getLayout(i);
        }
        if (xmlResourceParser == null) {
            onCancelListener.setMessage(zzs(R.string.offline_dialog_text, "Thanks for your interest.\nWe will share more once you're back online."));
            alertDialog = onCancelListener.create();
        } else {
            View inflate = activity.getLayoutInflater().inflate(xmlResourceParser, (ViewGroup) null);
            onCancelListener.setView(inflate);
            String zzr = zzr();
            if (!zzr.isEmpty()) {
                TextView textView = (TextView) inflate.findViewById(R.id.offline_dialog_advertiser_name);
                textView.setVisibility(0);
                textView.setText(zzr);
            }
            zzefr zzefr = (zzefr) this.zza.get(this.zzf);
            if (zzefr != null) {
                drawable = zzefr.zza();
            }
            if (drawable != null) {
                ((ImageView) inflate.findViewById(R.id.offline_dialog_image)).setImageDrawable(drawable);
            }
            alertDialog = onCancelListener.create();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
        Timer timer = new Timer();
        timer.schedule(new zzegj(this, alertDialog, timer, zzm), 3000);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzt(this.zzf, "rtsdc", hashMap);
        activity.startActivity(zzu.zzq().zzf(activity));
        zzu();
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final void zze(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            boolean zzA = zzu.zzo().zzA(this.zzb);
            HashMap hashMap = new HashMap();
            char c = 2;
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (true == zzA) {
                    c = 1;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith(ProxyConfig.MATCH_HTTP)));
                try {
                    Intent launchIntentForPackage = this.zzb.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(268435456);
                    this.zzb.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException e) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zzt(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zze.getWritableDatabase();
                if (c == 1) {
                    this.zze.zzg(writableDatabase, this.zzd, stringExtra2);
                } else {
                    zzefz.zzi(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e2) {
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Failed to get writable offline buffering database: ".concat(e2.toString()));
            }
        }
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        int i = 0;
        while (i < strArr.length) {
            if (!strArr[i].equals("android.permission.POST_NOTIFICATIONS")) {
                i++;
            } else {
                zzegm zzegm = (zzegm) ObjectWrapper.unwrap(iObjectWrapper);
                Activity zza2 = zzegm.zza();
                zzm zzb2 = zzegm.zzb();
                HashMap hashMap = new HashMap();
                if (iArr[i] == 0) {
                    hashMap.put("dialog_action", "confirm");
                    zzu();
                    zzw(zza2, zzb2);
                } else {
                    hashMap.put("dialog_action", "dismiss");
                    if (zzb2 != null) {
                        zzb2.zzb();
                    }
                }
                zzt(this.zzf, "asnpdc", hashMap);
                return;
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        zzegm zzegm = (zzegm) ObjectWrapper.unwrap(iObjectWrapper);
        Activity zza2 = zzegm.zza();
        zzm zzb2 = zzegm.zzb();
        this.zzf = zzegm.zzc();
        this.zzg = zzegm.zzd();
        if (!((Boolean) zzba.zzc().zza(zzbep.zziA)).booleanValue()) {
            zzt(this.zzf, "dialog_impression", zzgbf.zzd());
            zzu.zzp();
            AlertDialog.Builder zzK = zzt.zzK(zza2);
            zzK.setTitle(zzs(R.string.offline_opt_in_title, "Open ad when you're back online.")).setMessage(zzs(R.string.offline_opt_in_message, "We'll send you a notification with a link to the advertiser site.")).setPositiveButton(zzs(R.string.offline_opt_in_confirm, "OK"), new zzegg(this, zza2, zzb2)).setNegativeButton(zzs(R.string.offline_opt_in_decline, "No thanks"), new zzegh(this, zzb2)).setOnCancelListener(new zzegi(this, zzb2));
            zzK.create().show();
            return;
        }
        zzv(zza2, zzb2);
    }

    public final void zzh() {
        this.zze.zze(new zzefs(this.zzd));
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        zzj(iObjectWrapper, new zza(str, str2, ""));
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zza zza2) {
        Bitmap bitmap;
        String str;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        String str2 = zza2.zza;
        String str3 = zza2.zzb;
        String str4 = zza2.zzc;
        String zzr = zzr();
        zzu.zzq().zzh(context, "offline_notification_channel", "AdMob Offline Notifications");
        PendingIntent zzq = zzq(context, "offline_notification_clicked", str3, str2);
        PendingIntent zzq2 = zzq(context, "offline_notification_dismissed", str3, str2);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "offline_notification_channel");
        if (!zzr.isEmpty()) {
            builder.setContentTitle(String.format(zzs(R.string.offline_notification_title_with_advertiser, "You are back online! Continue learning about %s"), new Object[]{zzr}));
        } else {
            builder.setContentTitle(zzs(R.string.offline_notification_title, "You are back online! Let's pick up where we left off"));
        }
        builder.setAutoCancel(true).setDeleteIntent(zzq2).setContentIntent(zzq).setSmallIcon(context.getApplicationInfo().icon).setPriority(((Integer) zzba.zzc().zza(zzbep.zziB)).intValue());
        if (!((Boolean) zzba.zzc().zza(zzbep.zziD)).booleanValue() || str4.isEmpty()) {
            bitmap = null;
        } else {
            try {
                bitmap = BitmapFactory.decodeStream(new URL(str4).openConnection().getInputStream());
            } catch (IOException e) {
                bitmap = null;
            }
        }
        if (bitmap != null) {
            try {
                builder.setLargeIcon(bitmap).setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (Resources.NotFoundException e2) {
            }
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        HashMap hashMap = new HashMap();
        try {
            notificationManager.notify(str3, 54321, builder.build());
            str = "offline_notification_impression";
        } catch (IllegalArgumentException e3) {
            hashMap.put("notification_not_shown_reason", e3.getMessage());
            str = "offline_notification_failed";
        }
        zzt(str3, str, hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzt(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzt(this.zzf, "rtsdc", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Activity activity, zzm zzm, DialogInterface dialogInterface, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "confirm");
        zzt(this.zzf, "dialog_click", hashMap);
        zzv(activity, zzm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzm zzm, DialogInterface dialogInterface, int i) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzt(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzm zzm, DialogInterface dialogInterface) {
        this.zze.zzc(this.zzf);
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_action", "dismiss");
        zzt(this.zzf, "dialog_click", hashMap);
        if (zzm != null) {
            zzm.zzb();
        }
    }

    public final void zzp(String str, zzdlt zzdlt) {
        String str2;
        String str3 = "";
        if (!TextUtils.isEmpty(zzdlt.zzx())) {
            str2 = zzdlt.zzx();
        } else {
            str2 = zzdlt.zzB() != null ? zzdlt.zzB() : str3;
        }
        zzbhv zzm = zzdlt.zzm();
        if (zzm != null) {
            try {
                str3 = zzm.zze().toString();
            } catch (RemoteException e) {
            }
        }
        zzbhv zzn = zzdlt.zzn();
        Drawable drawable = null;
        if (zzn != null) {
            try {
                IObjectWrapper zzf2 = zzn.zzf();
                if (zzf2 != null) {
                    drawable = (Drawable) ObjectWrapper.unwrap(zzf2);
                }
            } catch (RemoteException e2) {
            }
        }
        this.zza.put(str, new zzefn(str2, str3, drawable));
    }
}
