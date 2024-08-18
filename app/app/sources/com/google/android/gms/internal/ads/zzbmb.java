package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzr;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbmb implements zzblp {
    private final zzb zza;
    private final zzdvc zzb;
    private final zzr zzc;
    private final zzbud zzd;
    private final zzefz zze;
    private final zzcqd zzf;
    private zzy zzg = null;
    private final zzgge zzh = zzcci.zzf;

    public zzbmb(zzb zzb2, zzbud zzbud, zzefz zzefz, zzdvc zzdvc, zzcqd zzcqd) {
        this.zza = zzb2;
        this.zzd = zzbud;
        this.zze = zzefz;
        this.zzb = zzdvc;
        this.zzc = new zzr((String) null);
        this.zzf = zzcqd;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzaxd zzaxd, Uri uri, View view, Activity activity, zzfhs zzfhs) {
        if (zzaxd == null) {
            return uri;
        }
        try {
            if (((Boolean) zzba.zzc().zza(zzbep.zzlW)).booleanValue() && zzfhs != null) {
                return zzaxd.zze(uri) ? zzfhs.zza(uri, context, view, activity) : uri;
            }
            if (zzaxd.zze(uri)) {
                return zzaxd.zza(uri, context, view, activity);
            }
            return uri;
        } catch (zzaxe e) {
            return uri;
        } catch (Exception e2) {
            zzu.zzo().zzw(e2, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            return uri;
        }
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            zzm.zzh("Error adding click uptime parameter to url: ".concat(String.valueOf(uri.toString())), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* access modifiers changed from: private */
    public final void zzh(String str, zza zza2, Map map, String str2) {
        String str3;
        boolean z;
        Intent intent;
        HashMap hashMap;
        Object obj;
        Object obj2;
        boolean z2;
        String str4;
        zza zza3 = zza2;
        Map map2 = map;
        String str5 = str2;
        zzchd zzchd = (zzchd) zza3;
        zzfgt zzD = zzchd.zzD();
        zzfgw zzR = zzchd.zzR();
        boolean z3 = false;
        if (zzD == null || zzR == null) {
            str3 = "";
            z = false;
        } else {
            String str6 = zzR.zzb;
            z = zzD.zzaj;
            str3 = str6;
        }
        boolean z4 = !((Boolean) zzba.zzc().zza(zzbep.zzkK)).booleanValue() || !map2.containsKey("sc") || !((String) map2.get("sc")).equals("0");
        boolean z5 = ((Boolean) zzba.zzc().zza(zzbep.zzmH)).booleanValue() && map2.containsKey("ig_cl") && ((String) map2.get("ig_cl")).equals("true");
        if ("expand".equalsIgnoreCase(str5)) {
            if (zzchd.zzaF()) {
                zzm.zzj("Cannot expand WebView that is already expanded.");
                return;
            }
            zzk(false);
            ((zzcin) zza3).zzaL(zzf(map), zzb(map), z4);
        } else if ("webapp".equalsIgnoreCase(str5)) {
            zzk(false);
            if (((Boolean) zzba.zzc().zza(zzbep.zzlR)).booleanValue() && Objects.equals(map2.get("is_allowed_for_lock_screen"), "1")) {
                z3 = true;
            }
            if (str != null) {
                ((zzcin) zza3).zzaN(zzf(map), zzb(map), str, z4, z3);
            } else {
                ((zzcin) zza3).zzaM(zzf(map), zzb(map), (String) map2.get("html"), (String) map2.get("baseurl"), z4);
            }
        } else if ("chrome_custom_tab".equalsIgnoreCase(str5)) {
            zzchd.getContext();
            if (((Boolean) zzba.zzc().zza(zzbep.zzeB)).booleanValue()) {
                if (((Boolean) zzba.zzc().zza(zzbep.zzeF)).booleanValue()) {
                    zze.zza("User opt out chrome custom tab.");
                } else {
                    z3 = true;
                }
            }
            boolean zzg2 = zzbfm.zzg(zzchd.getContext());
            if (z3) {
                if (!zzg2) {
                    zzm(4);
                } else {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        zzm.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri zzd2 = zzd(zzc(zzchd.getContext(), zzchd.zzI(), Uri.parse(str), zzchd.zzF(), zzchd.zzi(), zzchd.zzS()));
                    if (!z || this.zze == null || !zzl(zza3, zzchd.getContext(), zzd2.toString(), str3)) {
                        this.zzg = new zzbly(this);
                        ((zzcin) zza3).zzaJ(new zzc((String) null, zzd2.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (Intent) null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z4, z5);
                        return;
                    }
                    return;
                }
            }
            map2.put("use_first_package", "true");
            map2.put("use_running_process", "true");
            zzj(zza2, map, z, str3, z4, z5);
        } else if ("app".equalsIgnoreCase(str5) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
            zzj(zza2, map, z, str3, z4, z5);
        } else if ("open_app".equalsIgnoreCase(str5)) {
            if (((Boolean) zzba.zzc().zza(zzbep.zzio)).booleanValue()) {
                zzk(true);
                String str7 = (String) map2.get("p");
                if (str7 == null) {
                    zzm.zzj("Package name missing from open app action.");
                } else if (!z || this.zze == null || !zzl(zza3, zzchd.getContext(), str7, str3)) {
                    PackageManager packageManager = zzchd.getContext().getPackageManager();
                    if (packageManager == null) {
                        zzm.zzj("Cannot get package manager from open app action.");
                        return;
                    }
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str7);
                    if (launchIntentForPackage != null) {
                        ((zzcin) zza3).zzaJ(new zzc(launchIntentForPackage, this.zzg), z4, z5);
                    }
                }
            }
        } else {
            zzk(true);
            String str8 = (String) map2.get("intent_url");
            if (!TextUtils.isEmpty(str8)) {
                try {
                    intent = Intent.parseUri(str8, 0);
                } catch (URISyntaxException e) {
                    zzm.zzh("Error parsing the url: ".concat(String.valueOf(str8)), e);
                    intent = null;
                }
            } else {
                intent = null;
            }
            if (!(intent == null || intent.getData() == null)) {
                Uri data = intent.getData();
                if (!Uri.EMPTY.equals(data)) {
                    Uri zzd3 = zzd(zzc(zzchd.getContext(), zzchd.zzI(), data, zzchd.zzF(), zzchd.zzi(), zzchd.zzS()));
                    if (!TextUtils.isEmpty(intent.getType())) {
                        if (((Boolean) zzba.zzc().zza(zzbep.zzip)).booleanValue()) {
                            intent.setDataAndType(zzd3, intent.getType());
                        }
                    }
                    intent.setData(zzd3);
                }
            }
            boolean z6 = ((Boolean) zzba.zzc().zza(zzbep.zziG)).booleanValue() && "intent_async".equalsIgnoreCase(str5) && map2.containsKey("event_id");
            HashMap hashMap2 = new HashMap();
            if (z6) {
                zzblz zzblz = r1;
                hashMap = hashMap2;
                obj = "p";
                obj2 = "event_id";
                zzblz zzblz2 = new zzblz(this, z4, zza2, hashMap, map);
                this.zzg = zzblz;
                z2 = false;
            } else {
                hashMap = hashMap2;
                obj2 = "event_id";
                obj = "p";
                z2 = z4;
            }
            if (intent == null) {
                HashMap hashMap3 = hashMap;
                if (!TextUtils.isEmpty(str)) {
                    str4 = zzd(zzc(zzchd.getContext(), zzchd.zzI(), Uri.parse(str), zzchd.zzF(), zzchd.zzi(), zzchd.zzS())).toString();
                } else {
                    str4 = str;
                }
                if (!z || this.zze == null || !zzl(zza3, zzchd.getContext(), str4, str3)) {
                    ((zzcin) zza3).zzaJ(new zzc((String) map2.get("i"), str4, (String) map2.get("m"), (String) map2.get(obj), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzg), z2, z5);
                } else if (z6) {
                    hashMap3.put((String) map2.get(obj2), true);
                    ((zzbok) zza3).zzd("openIntentAsync", hashMap3);
                }
            } else if (!z || this.zze == null || !zzl(zza3, zzchd.getContext(), intent.getData().toString(), str3)) {
                ((zzcin) zza3).zzaJ(new zzc(intent, this.zzg), z2, z5);
            } else if (z6) {
                HashMap hashMap4 = hashMap;
                hashMap4.put((String) map2.get(obj2), true);
                ((zzbok) zza3).zzd("openIntentAsync", hashMap4);
            }
        }
    }

    private final void zzi(Context context, String str, String str2) {
        this.zze.zzc(str);
        zzdvc zzdvc = this.zzb;
        if (zzdvc != null) {
            zzegk.zzc(context, zzdvc, this.zze, str, "dialog_not_shown", zzgbf.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x010c, code lost:
        if (com.google.android.gms.internal.ads.zzbma.zzc(r2, r11, r12, r13, r14) == null) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x015a, code lost:
        r21 = r6;
        r10 = r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzj(com.google.android.gms.ads.internal.client.zza r20, java.util.Map r21, boolean r22, java.lang.String r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            r3 = 1
            r1.zzk(r3)
            r4 = r0
            com.google.android.gms.internal.ads.zzchd r4 = (com.google.android.gms.internal.ads.zzchd) r4
            android.content.Context r11 = r4.getContext()
            com.google.android.gms.internal.ads.zzaxd r12 = r4.zzI()
            android.view.View r13 = r4.zzF()
            com.google.android.gms.internal.ads.zzfhs r14 = r4.zzS()
            java.lang.String r5 = "activity"
            java.lang.Object r5 = r11.getSystemService(r5)
            r15 = r5
            android.app.ActivityManager r15 = (android.app.ActivityManager) r15
            java.lang.String r5 = "u"
            java.lang.Object r5 = r2.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            r16 = 0
            if (r6 == 0) goto L_0x003a
            r2 = r16
            goto L_0x017d
        L_0x003a:
            android.net.Uri r7 = android.net.Uri.parse(r5)
            r9 = 0
            r5 = r11
            r6 = r12
            r8 = r13
            r10 = r14
            android.net.Uri r5 = zzc(r5, r6, r7, r8, r9, r10)
            android.net.Uri r5 = zzd(r5)
            java.lang.String r6 = "use_first_package"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r17 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_running_process"
            java.lang.Object r6 = r2.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            boolean r18 = java.lang.Boolean.parseBoolean(r6)
            java.lang.String r6 = "use_custom_tabs"
            java.lang.Object r2 = r2.get(r6)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r10 = 0
            if (r2 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zzez
            com.google.android.gms.internal.ads.zzben r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r6.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0085
            goto L_0x0088
        L_0x0085:
            r3 = r10
            goto L_0x0088
        L_0x0087:
        L_0x0088:
            java.lang.String r2 = r5.getScheme()
            java.lang.String r6 = "http"
            boolean r2 = r6.equalsIgnoreCase(r2)
            java.lang.String r7 = "https"
            if (r2 == 0) goto L_0x00a5
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r7)
            android.net.Uri r16 = r2.build()
            r2 = r16
            goto L_0x00bf
        L_0x00a5:
            java.lang.String r2 = r5.getScheme()
            boolean r2 = r7.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x00bc
            android.net.Uri$Builder r2 = r5.buildUpon()
            android.net.Uri$Builder r2 = r2.scheme(r6)
            android.net.Uri r16 = r2.build()
            goto L_0x00bd
        L_0x00bc:
        L_0x00bd:
            r2 = r16
        L_0x00bf:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.content.Intent r8 = com.google.android.gms.internal.ads.zzbma.zza(r5, r11, r12, r13, r14)
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzbma.zza(r2, r11, r12, r13, r14)
            if (r3 == 0) goto L_0x00da
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r8)
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzt.zzo(r11, r2)
        L_0x00da:
            r5 = r8
            r6 = r9
            r7 = r11
            r3 = r8
            r8 = r12
            r21 = r9
            r9 = r13
            r0 = r10
            r10 = r14
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzbma.zzd(r5, r6, r7, r8, r9, r10)
            if (r6 == 0) goto L_0x00f7
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbma.zzb(r5, r6, r7, r8, r9, r10)
            r2 = r16
            goto L_0x017d
        L_0x00f7:
            if (r2 == 0) goto L_0x010e
            android.content.pm.ResolveInfo r6 = com.google.android.gms.internal.ads.zzbma.zzc(r2, r11, r12, r13, r14)
            if (r6 == 0) goto L_0x010e
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r2 = com.google.android.gms.internal.ads.zzbma.zzb(r5, r6, r7, r8, r9, r10)
            android.content.pm.ResolveInfo r5 = com.google.android.gms.internal.ads.zzbma.zzc(r2, r11, r12, r13, r14)
            if (r5 != 0) goto L_0x017d
        L_0x010e:
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L_0x0116
            goto L_0x017c
        L_0x0116:
            if (r18 == 0) goto L_0x0164
            if (r15 == 0) goto L_0x0164
            java.util.List r2 = r15.getRunningAppProcesses()
            if (r2 == 0) goto L_0x0161
            int r5 = r21.size()
            r10 = r0
        L_0x0125:
            if (r10 >= r5) goto L_0x015e
            r6 = r21
            java.lang.Object r7 = r6.get(r10)
            android.content.pm.ResolveInfo r7 = (android.content.pm.ResolveInfo) r7
            java.util.Iterator r8 = r2.iterator()
        L_0x0133:
            boolean r9 = r8.hasNext()
            int r15 = r10 + 1
            if (r9 == 0) goto L_0x015a
            java.lang.Object r9 = r8.next()
            android.app.ActivityManager$RunningAppProcessInfo r9 = (android.app.ActivityManager.RunningAppProcessInfo) r9
            java.lang.String r9 = r9.processName
            android.content.pm.ActivityInfo r15 = r7.activityInfo
            java.lang.String r15 = r15.packageName
            boolean r9 = r9.equals(r15)
            if (r9 == 0) goto L_0x0133
            r5 = r3
            r6 = r7
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbma.zzb(r5, r6, r7, r8, r9, r10)
            r2 = r16
            goto L_0x017d
        L_0x015a:
            r21 = r6
            r10 = r15
            goto L_0x0125
        L_0x015e:
            r6 = r21
            goto L_0x0166
        L_0x0161:
            r6 = r21
            goto L_0x0166
        L_0x0164:
            r6 = r21
        L_0x0166:
            if (r17 == 0) goto L_0x017b
            java.lang.Object r0 = r6.get(r0)
            r6 = r0
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            r5 = r3
            r7 = r11
            r8 = r12
            r9 = r13
            r10 = r14
            android.content.Intent r16 = com.google.android.gms.internal.ads.zzbma.zzb(r5, r6, r7, r8, r9, r10)
            r2 = r16
            goto L_0x017d
        L_0x017b:
        L_0x017c:
            r2 = r3
        L_0x017d:
            if (r22 == 0) goto L_0x019d
            com.google.android.gms.internal.ads.zzefz r0 = r1.zze
            if (r0 == 0) goto L_0x019d
            if (r2 == 0) goto L_0x019d
            android.content.Context r0 = r4.getContext()
            android.net.Uri r3 = r2.getData()
            java.lang.String r3 = r3.toString()
            r4 = r20
            r5 = r23
            boolean r0 = r1.zzl(r4, r0, r3, r5)
            if (r0 != 0) goto L_0x019c
            goto L_0x019f
        L_0x019c:
            return
        L_0x019d:
            r4 = r20
        L_0x019f:
            r0 = r4
            com.google.android.gms.internal.ads.zzcin r0 = (com.google.android.gms.internal.ads.zzcin) r0     // Catch:{ ActivityNotFoundException -> 0x01b1 }
            com.google.android.gms.ads.internal.overlay.zzc r3 = new com.google.android.gms.ads.internal.overlay.zzc     // Catch:{ ActivityNotFoundException -> 0x01b1 }
            com.google.android.gms.ads.internal.overlay.zzy r4 = r1.zzg     // Catch:{ ActivityNotFoundException -> 0x01b1 }
            r3.<init>(r2, r4)     // Catch:{ ActivityNotFoundException -> 0x01b1 }
            r2 = r24
            r4 = r25
            r0.zzaJ(r3, r2, r4)     // Catch:{ ActivityNotFoundException -> 0x01b1 }
            return
        L_0x01b1:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmb.zzj(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzk(boolean z) {
        zzbud zzbud = this.zzd;
        if (zzbud != null) {
            zzbud.zza(z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
        if (r2 != false) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza r9, android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzdvc r1 = r8.zzb
            if (r1 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzefz r2 = r8.zze
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r4 = "offline_open"
            r0 = r10
            r3 = r12
            com.google.android.gms.internal.ads.zzegk.zzc(r0, r1, r2, r3, r4, r5)
        L_0x0012:
            com.google.android.gms.internal.ads.zzcby r0 = com.google.android.gms.ads.internal.zzu.zzo()
            boolean r0 = r0.zzA(r10)
            r1 = 0
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzefz r9 = r8.zze
            com.google.android.gms.ads.internal.util.client.zzr r10 = r8.zzc
            r9.zzh(r10, r12)
            return r1
        L_0x0025:
            com.google.android.gms.ads.internal.zzu.zzp()
            com.google.android.gms.ads.internal.util.zzbt r0 = com.google.android.gms.ads.internal.util.zzt.zzz(r10)
            com.google.android.gms.ads.internal.zzu.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r2 = r2.areNotificationsEnabled()
            com.google.android.gms.ads.internal.util.zzab r3 = com.google.android.gms.ads.internal.zzu.zzq()
            java.lang.String r4 = "offline_notification_channel"
            boolean r3 = r3.zzi(r10, r4)
            r4 = r9
            com.google.android.gms.internal.ads.zzchd r4 = (com.google.android.gms.internal.ads.zzchd) r4
            com.google.android.gms.internal.ads.zzcix r5 = r4.zzO()
            boolean r5 = r5.zzi()
            r6 = 1
            if (r5 == 0) goto L_0x0057
            android.app.Activity r5 = r4.zzi()
            if (r5 != 0) goto L_0x0057
            r5 = r6
            goto L_0x0058
        L_0x0057:
            r5 = r1
        L_0x0058:
            if (r2 != 0) goto L_0x0099
            com.google.android.gms.ads.internal.zzu.zzp()
            androidx.core.app.NotificationManagerCompat r2 = androidx.core.app.NotificationManagerCompat.from(r10)
            boolean r2 = r2.areNotificationsEnabled()
            if (r2 == 0) goto L_0x0068
            goto L_0x0092
        L_0x0068:
            int r2 = android.os.Build.VERSION.SDK_INT
            r7 = 33
            if (r2 >= r7) goto L_0x007f
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zziz
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            goto L_0x008f
        L_0x007f:
            com.google.android.gms.internal.ads.zzbeg r2 = com.google.android.gms.internal.ads.zzbep.zziy
            com.google.android.gms.internal.ads.zzben r7 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r7.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
        L_0x008f:
            if (r2 == 0) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            java.lang.String r9 = "notifications_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x0099:
            if (r3 == 0) goto L_0x00a1
            java.lang.String r9 = "notification_channel_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00a1:
            if (r0 != 0) goto L_0x00a9
            java.lang.String r9 = "work_manager_unavailable"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00a9:
            if (r5 == 0) goto L_0x00b1
            java.lang.String r9 = "ad_no_activity"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00b1:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zziw
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x00c9
            java.lang.String r9 = "notification_flow_disabled"
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00c9:
            com.google.android.gms.ads.internal.overlay.zzm r0 = r4.zzL()
            if (r0 == 0) goto L_0x00ff
            android.app.Activity r0 = r4.zzi()
            if (r0 == 0) goto L_0x00ff
            com.google.android.gms.internal.ads.zzegl r0 = com.google.android.gms.internal.ads.zzegm.zze()
            android.app.Activity r2 = r4.zzi()
            r0.zza(r2)
            r2 = 0
            r0.zzb(r2)
            r0.zzc(r12)
            r0.zzd(r11)
            com.google.android.gms.internal.ads.zzegm r11 = r0.zze()
            com.google.android.gms.ads.internal.overlay.zzm r0 = r4.zzL()     // Catch:{ Exception -> 0x00f6 }
            r0.zzf(r11)     // Catch:{ Exception -> 0x00f6 }
            goto L_0x0107
        L_0x00f6:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            r8.zzi(r10, r12, r9)
            return r1
        L_0x00ff:
            r10 = r9
            com.google.android.gms.internal.ads.zzcin r10 = (com.google.android.gms.internal.ads.zzcin) r10
            r0 = 14
            r10.zzaK(r12, r11, r0)
        L_0x0107:
            r9.onAdClicked()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmb.zzl(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzm(int i) {
        String str;
        zzdvc zzdvc = this.zzb;
        if (zzdvc != null) {
            zzdvb zza2 = zzdvc.zza();
            zza2.zzb("action", "cct_action");
            switch (i) {
                case 2:
                    str = "CONTEXT_NOT_AN_ACTIVITY";
                    break;
                case 3:
                    str = "CONTEXT_NULL";
                    break;
                case 4:
                    str = "CCT_NOT_SUPPORTED";
                    break;
                case 5:
                    str = "CCT_READY_TO_OPEN";
                    break;
                case 6:
                    str = "ACTIVITY_NOT_FOUND";
                    break;
                case 7:
                    str = "EMPTY_URL";
                    break;
                case 8:
                    str = "UNKNOWN";
                    break;
                default:
                    str = "WRONG_EXP_SETUP";
                    break;
            }
            zza2.zzb("cct_open_status", str);
            zza2.zzf();
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        ListenableFuture listenableFuture;
        zza zza2 = (zza) obj;
        String str = (String) map.get("u");
        Map hashMap = new HashMap();
        zzchd zzchd = (zzchd) zza2;
        if (zzchd.zzD() != null) {
            hashMap = zzchd.zzD().zzax;
        }
        String zzc2 = zzcaw.zzc(str, zzchd.getContext(), true, hashMap);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            zzm.zzj("Action missing from an open GMSG.");
            return;
        }
        zzb zzb2 = this.zza;
        if (zzb2 == null || zzb2.zzc()) {
            if (!((Boolean) zzba.zzc().zza(zzbep.zzka)).booleanValue() || this.zzf == null || !zzcqd.zzj(zzc2)) {
                listenableFuture = zzgft.zzh(zzc2);
            } else {
                listenableFuture = this.zzf.zzb(zzc2, zzay.zze());
            }
            zzgft.zzr(listenableFuture, new zzblx(this, map, zza2, str2), this.zzh);
            return;
        }
        this.zza.zzb(zzc2);
    }
}
