package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbep;
import com.google.android.gms.internal.ads.zzfgt;
import com.google.android.gms.internal.ads.zzfxr;
import com.google.android.gms.internal.ads.zzfyt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzbz {
    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzj = zzj(view);
        return new Point(((int) motionEvent.getRawX()) - zzj[0], ((int) motionEvent.getRawY()) - zzj[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) zzba.zzc().zza(zzbep.zzie)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("x", zzay.zzb().zzb(context, point2.x));
                    jSONObject3.put("y", zzay.zzb().zzb(context, point2.y));
                    jSONObject3.put("start_x", zzay.zzb().zzb(context, point.x));
                    jSONObject3.put("start_y", zzay.zzb().zzb(context, point.y));
                    jSONObject = jSONObject3;
                } catch (JSONException e) {
                    zzm.zzh("Error occurred while putting signals into JSON object.", e);
                }
                jSONObject2.put("click_point", jSONObject);
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                zzm.zzh("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
            zzm.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
    }

    public static JSONObject zzd(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        String str;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        boolean z;
        Context context2 = context;
        Map map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject3 = new JSONObject();
        if (map == null) {
            return jSONObject3;
        }
        if (view == null) {
            return jSONObject3;
        }
        int[] zzj = zzj(view);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] zzj2 = zzj(view2);
                JSONObject jSONObject4 = new JSONObject();
                JSONObject jSONObject5 = new JSONObject();
                Iterator it2 = it;
                try {
                    JSONObject jSONObject6 = jSONObject3;
                    try {
                        jSONObject5.put("width", zzay.zzb().zzb(context2, view2.getMeasuredWidth()));
                        jSONObject5.put("height", zzay.zzb().zzb(context2, view2.getMeasuredHeight()));
                        jSONObject5.put("x", zzay.zzb().zzb(context2, zzj2[0] - zzj[0]));
                        jSONObject5.put("y", zzay.zzb().zzb(context2, zzj2[1] - zzj[1]));
                        jSONObject5.put(str4, str3);
                        jSONObject4.put(TypedValues.AttributesType.S_FRAME, jSONObject5);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject2 = zzk(context2, rect);
                        } else {
                            jSONObject2 = new JSONObject();
                            jSONObject2.put("width", 0);
                            jSONObject2.put("height", 0);
                            jSONObject2.put("x", zzay.zzb().zzb(context2, zzj2[0] - zzj[0]));
                            jSONObject2.put("y", zzay.zzb().zzb(context2, zzj2[1] - zzj[1]));
                            jSONObject2.put(str4, str3);
                        }
                        jSONObject4.put("visible_bounds", jSONObject2);
                        if (((String) entry.getKey()).equals("3010")) {
                            if (((Boolean) zzba.zzc().zza(zzbep.zzhZ)).booleanValue()) {
                                jSONObject4.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                            }
                            if (((Boolean) zzba.zzc().zza(zzbep.zzia)).booleanValue()) {
                                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                jSONObject4.put("view_width_layout_type", zzl(layoutParams.width) - 1);
                                jSONObject4.put("view_height_layout_type", zzl(layoutParams.height) - 1);
                            }
                            if (((Boolean) zzba.zzc().zza(zzbep.zzib)).booleanValue()) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(Integer.valueOf(view2.getId()));
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    arrayList.add(Integer.valueOf(((View) parent).getId()));
                                }
                                jSONObject4.put("view_path", TextUtils.join(DomExceptionUtils.SEPARATOR, arrayList));
                            }
                            if (scaleType != null) {
                                jSONObject4.put("mediaview_scale_type", scaleType.ordinal());
                            }
                        }
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject4.put("text_color", textView.getCurrentTextColor());
                            str2 = str3;
                            str = str4;
                            try {
                                jSONObject4.put("font_size", (double) textView.getTextSize());
                                jSONObject4.put("text", textView.getText());
                            } catch (JSONException e) {
                                jSONObject = jSONObject6;
                                zzm.zzj("Unable to get asset views information");
                                it = it2;
                                jSONObject3 = jSONObject;
                                str3 = str2;
                                str4 = str;
                            }
                        } else {
                            str2 = str3;
                            str = str4;
                        }
                        if (map3 == null || !map3.containsKey(entry.getKey()) || !view2.isClickable()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        jSONObject4.put("is_clickable", z);
                        jSONObject = jSONObject6;
                        try {
                            jSONObject.put((String) entry.getKey(), jSONObject4);
                            it = it2;
                            jSONObject3 = jSONObject;
                            str3 = str2;
                            str4 = str;
                        } catch (JSONException e2) {
                            zzm.zzj("Unable to get asset views information");
                            it = it2;
                            jSONObject3 = jSONObject;
                            str3 = str2;
                            str4 = str;
                        }
                    } catch (JSONException e3) {
                        str2 = str3;
                        str = str4;
                        jSONObject = jSONObject6;
                        zzm.zzj("Unable to get asset views information");
                        it = it2;
                        jSONObject3 = jSONObject;
                        str3 = str2;
                        str4 = str;
                    }
                } catch (JSONException e4) {
                    str2 = str3;
                    str = str4;
                    jSONObject = jSONObject3;
                    zzm.zzj("Unable to get asset views information");
                    it = it2;
                    jSONObject3 = jSONObject;
                    str3 = str2;
                    str4 = str;
                }
            } else {
                String str5 = str3;
                String str6 = str4;
                JSONObject jSONObject7 = jSONObject3;
                Iterator it3 = it;
                str3 = str5;
            }
        }
        return jSONObject3;
    }

    public static JSONObject zze(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                zzu.zzp();
                jSONObject.put("can_show_on_lock_screen", zzt.zzn(view));
                zzu.zzp();
                jSONObject.put("is_keyguard_locked", zzt.zzD(context));
            } catch (JSONException e) {
                zzm.zzj("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject zzf(View view) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                boolean z = false;
                if (((Boolean) zzba.zzc().zza(zzbep.zzhY)).booleanValue()) {
                    zzu.zzp();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    if (parent != null) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                } else {
                    zzu.zzp();
                    ViewParent parent2 = view.getParent();
                    while (parent2 != null && !(parent2 instanceof AdapterView)) {
                        parent2 = parent2.getParent();
                    }
                    if (parent2 == null) {
                        i = -1;
                    } else {
                        i = ((AdapterView) parent2).getPositionForView(view);
                    }
                    if (i != -1) {
                        z = true;
                    }
                    jSONObject.put("contained_in_scroll_view", z);
                }
            } catch (Exception e) {
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x015f A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016c A[Catch:{ JSONException -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0172 A[Catch:{ JSONException -> 0x0176 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject zzg(android.content.Context r16, android.view.View r17) {
        /*
            r0 = r16
            r1 = r17
            java.lang.String r2 = "window"
            java.lang.String r3 = "relative_to"
            java.lang.String r4 = "y"
            java.lang.String r5 = "x"
            java.lang.String r6 = "height"
            java.lang.String r7 = "width"
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            if (r1 != 0) goto L_0x0019
            goto L_0x01b1
        L_0x0019:
            r9 = 2
            r10 = 1
            r11 = 0
            int[] r12 = zzj(r17)     // Catch:{ Exception -> 0x00fe }
            int[] r13 = new int[r9]     // Catch:{ Exception -> 0x00fe }
            int r14 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fe }
            r13[r11] = r14     // Catch:{ Exception -> 0x00fe }
            int r14 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fe }
            r13[r10] = r14     // Catch:{ Exception -> 0x00fe }
            android.view.ViewParent r14 = r17.getParent()     // Catch:{ Exception -> 0x00fe }
        L_0x0032:
            boolean r15 = r14 instanceof android.view.ViewGroup     // Catch:{ Exception -> 0x00fe }
            if (r15 == 0) goto L_0x0059
            r15 = r14
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getMeasuredWidth()     // Catch:{ Exception -> 0x00fe }
            r10 = r13[r11]     // Catch:{ Exception -> 0x00fe }
            int r9 = java.lang.Math.min(r9, r10)     // Catch:{ Exception -> 0x00fe }
            r13[r11] = r9     // Catch:{ Exception -> 0x00fe }
            int r9 = r15.getMeasuredHeight()     // Catch:{ Exception -> 0x00fe }
            r10 = 1
            r15 = r13[r10]     // Catch:{ Exception -> 0x00fe }
            int r9 = java.lang.Math.min(r9, r15)     // Catch:{ Exception -> 0x00fe }
            r13[r10] = r9     // Catch:{ Exception -> 0x00fe }
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00fe }
            r9 = 2
            r10 = 1
            goto L_0x0032
        L_0x0059:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fe }
            r9.<init>()     // Catch:{ Exception -> 0x00fe }
            int r10 = r17.getMeasuredWidth()     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fe }
            r9.put(r7, r10)     // Catch:{ Exception -> 0x00fe }
            int r10 = r17.getMeasuredHeight()     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fe }
            r9.put(r6, r10)     // Catch:{ Exception -> 0x00fe }
            r10 = r12[r11]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r10 = r14.zzb(r0, r10)     // Catch:{ Exception -> 0x00fe }
            r9.put(r5, r10)     // Catch:{ Exception -> 0x00fe }
            r10 = 1
            r14 = r12[r10]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r10 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r10 = r10.zzb(r0, r14)     // Catch:{ Exception -> 0x00fe }
            r9.put(r4, r10)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r10 = "maximum_visible_width"
            r14 = r13[r11]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r15 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r14 = r15.zzb(r0, r14)     // Catch:{ Exception -> 0x00fe }
            r9.put(r10, r14)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r10 = "maximum_visible_height"
            r14 = 1
            r13 = r13[r14]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r14 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r13 = r14.zzb(r0, r13)     // Catch:{ Exception -> 0x00fe }
            r9.put(r10, r13)     // Catch:{ Exception -> 0x00fe }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fe }
            java.lang.String r10 = "frame"
            r8.put(r10, r9)     // Catch:{ Exception -> 0x00fe }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ Exception -> 0x00fe }
            r9.<init>()     // Catch:{ Exception -> 0x00fe }
            boolean r10 = r1.getGlobalVisibleRect(r9)     // Catch:{ Exception -> 0x00fe }
            if (r10 == 0) goto L_0x00ce
            org.json.JSONObject r0 = zzk(r0, r9)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00f8
        L_0x00ce:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x00fe }
            r9.<init>()     // Catch:{ Exception -> 0x00fe }
            r9.put(r7, r11)     // Catch:{ Exception -> 0x00fe }
            r9.put(r6, r11)     // Catch:{ Exception -> 0x00fe }
            r6 = r12[r11]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r7 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r6 = r7.zzb(r0, r6)     // Catch:{ Exception -> 0x00fe }
            r9.put(r5, r6)     // Catch:{ Exception -> 0x00fe }
            r5 = 1
            r6 = r12[r5]     // Catch:{ Exception -> 0x00fe }
            com.google.android.gms.ads.internal.util.client.zzf r5 = com.google.android.gms.ads.internal.client.zzay.zzb()     // Catch:{ Exception -> 0x00fe }
            int r0 = r5.zzb(r0, r6)     // Catch:{ Exception -> 0x00fe }
            r9.put(r4, r0)     // Catch:{ Exception -> 0x00fe }
            r9.put(r3, r2)     // Catch:{ Exception -> 0x00fe }
            r0 = r9
        L_0x00f8:
            java.lang.String r2 = "visible_bounds"
            r8.put(r2, r0)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0104
        L_0x00fe:
            r0 = move-exception
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r0)
        L_0x0104:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzgu
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r10 = -1
            if (r0 == 0) goto L_0x017c
            android.view.ViewParent r0 = r17.getParent()
            if (r0 == 0) goto L_0x013f
            java.lang.Class r2 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            java.lang.String r3 = "getTemplateTypeName"
            java.lang.Class[] r4 = new java.lang.Class[r11]     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            java.lang.Object r0 = r2.invoke(r0, r3)     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x013d, SecurityException -> 0x0136, IllegalAccessException -> 0x0134, InvocationTargetException -> 0x0132 }
            goto L_0x0142
        L_0x0132:
            r0 = move-exception
            goto L_0x0137
        L_0x0134:
            r0 = move-exception
            goto L_0x0137
        L_0x0136:
            r0 = move-exception
        L_0x0137:
            java.lang.String r2 = "Cannot access method getTemplateTypeName: "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            goto L_0x0140
        L_0x013d:
            r0 = move-exception
            goto L_0x0140
        L_0x013f:
        L_0x0140:
            java.lang.String r0 = ""
        L_0x0142:
            int r2 = r0.hashCode()     // Catch:{ JSONException -> 0x0176 }
            switch(r2) {
                case -2066603854: goto L_0x0155;
                case 2019754500: goto L_0x014a;
                default: goto L_0x0149;
            }
        L_0x0149:
            goto L_0x015f
        L_0x014a:
            java.lang.String r2 = "medium_template"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0149
            r0 = 1
            goto L_0x0160
        L_0x0155:
            java.lang.String r2 = "small_template"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0149
            r0 = r11
            goto L_0x0160
        L_0x015f:
            r0 = r10
        L_0x0160:
            java.lang.String r2 = "native_template_type"
            switch(r0) {
                case 0: goto L_0x016c;
                case 1: goto L_0x0166;
                default: goto L_0x0165;
            }
        L_0x0165:
            goto L_0x0172
        L_0x0166:
            r3 = 2
            r8.put(r2, r3)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x017c
        L_0x016c:
            r3 = 1
            r8.put(r2, r3)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x017c
        L_0x0172:
            r8.put(r2, r11)     // Catch:{ JSONException -> 0x0176 }
            goto L_0x017c
        L_0x0176:
            r0 = move-exception
            java.lang.String r2 = "Could not log native template signal to JSON"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
        L_0x017c:
            com.google.android.gms.internal.ads.zzbeg r0 = com.google.android.gms.internal.ads.zzbep.zzia
            com.google.android.gms.internal.ads.zzben r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r2.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01b1
            android.view.ViewGroup$LayoutParams r0 = r17.getLayoutParams()     // Catch:{ Exception -> 0x01ab }
            java.lang.String r1 = "view_width_layout_type"
            int r2 = r0.width     // Catch:{ Exception -> 0x01ab }
            int r2 = zzl(r2)     // Catch:{ Exception -> 0x01ab }
            int r2 = r2 + r10
            r8.put(r1, r2)     // Catch:{ Exception -> 0x01ab }
            java.lang.String r1 = "view_height_layout_type"
            int r0 = r0.height     // Catch:{ Exception -> 0x01ab }
            int r0 = zzl(r0)     // Catch:{ Exception -> 0x01ab }
            int r0 = r0 + r10
            r8.put(r1, r0)     // Catch:{ Exception -> 0x01ab }
            goto L_0x01b1
        L_0x01ab:
            r0 = move-exception
            java.lang.String r0 = "Unable to get native ad view layout types"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
        L_0x01b1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbz.zzg(android.content.Context, android.view.View):org.json.JSONObject");
    }

    public static boolean zzh(Context context, zzfgt zzfgt) {
        if (!zzfgt.zzO) {
            return false;
        }
        if (((Boolean) zzba.zzc().zza(zzbep.zzic)).booleanValue()) {
            return ((Boolean) zzba.zzc().zza(zzbep.zzif)).booleanValue();
        }
        String str = (String) zzba.zzc().zza(zzbep.zzid);
        if (str.isEmpty() || context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (String equals : zzfyt.zzc(zzfxr.zzc(';')).zzd(str)) {
            if (equals.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzi(int i) {
        if (!((Boolean) zzba.zzc().zza(zzbep.zzdv)).booleanValue()) {
            return true;
        }
        return ((Boolean) zzba.zzc().zza(zzbep.zzdw)).booleanValue() || i <= 15299999;
    }

    public static int[] zzj(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzk(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzay.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", zzay.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put("x", zzay.zzb().zzb(context, rect.left));
        jSONObject.put("y", zzay.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int zzl(int i) {
        switch (i) {
            case -2:
                return 4;
            case -1:
                return 3;
            default:
                return 2;
        }
    }
}
