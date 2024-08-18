package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public class ViewUtils {
    private ViewUtils() {
    }

    public static String getXmlAttributeString(String namespace, String name, Context context, AttributeSet attrs, boolean allowResources, boolean required, String logTag) {
        String str;
        if (attrs == null) {
            str = null;
        } else {
            str = attrs.getAttributeValue(namespace, name);
        }
        if (str != null && str.startsWith("@string/") && allowResources) {
            String substring = str.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                Resources resources = context.getResources();
                resources.getValue(packageName + ":string/" + substring, typedValue, true);
            } catch (Resources.NotFoundException e) {
                Log.w(logTag, "Could not find resource for " + name + ": " + str);
            }
            if (typedValue.string != null) {
                str = typedValue.string.toString();
            } else {
                String obj = typedValue.toString();
                Log.w(logTag, "Resource " + name + " was not a string: " + obj);
            }
        }
        if (required && str == null) {
            Log.w(logTag, "Required XML attribute \"" + name + "\" missing");
        }
        return str;
    }
}
