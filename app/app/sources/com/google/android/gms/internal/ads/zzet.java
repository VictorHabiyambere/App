package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
public final class zzet {
    private static final Pattern zza = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern zzb = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern zzc = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map zzd = new HashMap();

    static {
        zzd.put("aliceblue", -984833);
        zzd.put("antiquewhite", -332841);
        zzd.put("aqua", -16711681);
        zzd.put("aquamarine", -8388652);
        zzd.put("azure", -983041);
        zzd.put("beige", -657956);
        zzd.put("bisque", -6972);
        zzd.put("black", Integer.valueOf(ViewCompat.MEASURED_STATE_MASK));
        zzd.put("blanchedalmond", -5171);
        zzd.put("blue", -16776961);
        zzd.put("blueviolet", -7722014);
        zzd.put("brown", -5952982);
        zzd.put("burlywood", -2180985);
        zzd.put("cadetblue", -10510688);
        zzd.put("chartreuse", -8388864);
        zzd.put("chocolate", -2987746);
        zzd.put("coral", -32944);
        zzd.put("cornflowerblue", -10185235);
        zzd.put("cornsilk", -1828);
        zzd.put("crimson", -2354116);
        zzd.put("cyan", -16711681);
        zzd.put("darkblue", -16777077);
        zzd.put("darkcyan", -16741493);
        zzd.put("darkgoldenrod", -4684277);
        zzd.put("darkgray", -5658199);
        zzd.put("darkgreen", -16751616);
        zzd.put("darkgrey", -5658199);
        zzd.put("darkkhaki", -4343957);
        zzd.put("darkmagenta", -7667573);
        zzd.put("darkolivegreen", -11179217);
        zzd.put("darkorange", -29696);
        zzd.put("darkorchid", -6737204);
        zzd.put("darkred", -7667712);
        zzd.put("darksalmon", -1468806);
        zzd.put("darkseagreen", -7357297);
        zzd.put("darkslateblue", -12042869);
        zzd.put("darkslategray", -13676721);
        zzd.put("darkslategrey", -13676721);
        zzd.put("darkturquoise", -16724271);
        zzd.put("darkviolet", -7077677);
        zzd.put("deeppink", -60269);
        zzd.put("deepskyblue", -16728065);
        zzd.put("dimgray", -9868951);
        zzd.put("dimgrey", -9868951);
        zzd.put("dodgerblue", -14774017);
        zzd.put("firebrick", -5103070);
        zzd.put("floralwhite", -1296);
        zzd.put("forestgreen", -14513374);
        zzd.put("fuchsia", -65281);
        zzd.put("gainsboro", -2302756);
        zzd.put("ghostwhite", -460545);
        zzd.put("gold", -10496);
        zzd.put("goldenrod", -2448096);
        zzd.put("gray", -8355712);
        zzd.put("green", -16744448);
        zzd.put("greenyellow", -5374161);
        zzd.put("grey", -8355712);
        zzd.put("honeydew", -983056);
        zzd.put("hotpink", -38476);
        zzd.put("indianred", -3318692);
        zzd.put("indigo", -11861886);
        zzd.put("ivory", -16);
        zzd.put("khaki", -989556);
        zzd.put("lavender", -1644806);
        zzd.put("lavenderblush", -3851);
        zzd.put("lawngreen", -8586240);
        zzd.put("lemonchiffon", -1331);
        zzd.put("lightblue", -5383962);
        zzd.put("lightcoral", -1015680);
        zzd.put("lightcyan", -2031617);
        zzd.put("lightgoldenrodyellow", -329006);
        zzd.put("lightgray", -2894893);
        zzd.put("lightgreen", -7278960);
        zzd.put("lightgrey", -2894893);
        zzd.put("lightpink", -18751);
        zzd.put("lightsalmon", -24454);
        zzd.put("lightseagreen", -14634326);
        zzd.put("lightskyblue", -7876870);
        zzd.put("lightslategray", -8943463);
        zzd.put("lightslategrey", -8943463);
        zzd.put("lightsteelblue", -5192482);
        zzd.put("lightyellow", -32);
        zzd.put("lime", -16711936);
        zzd.put("limegreen", -13447886);
        zzd.put("linen", -331546);
        zzd.put("magenta", -65281);
        zzd.put("maroon", -8388608);
        zzd.put("mediumaquamarine", -10039894);
        zzd.put("mediumblue", -16777011);
        zzd.put("mediumorchid", -4565549);
        zzd.put("mediumpurple", -7114533);
        zzd.put("mediumseagreen", -12799119);
        zzd.put("mediumslateblue", -8689426);
        zzd.put("mediumspringgreen", -16713062);
        zzd.put("mediumturquoise", -12004916);
        zzd.put("mediumvioletred", -3730043);
        zzd.put("midnightblue", -15132304);
        zzd.put("mintcream", -655366);
        zzd.put("mistyrose", -6943);
        zzd.put("moccasin", -6987);
        zzd.put("navajowhite", -8531);
        zzd.put("navy", -16777088);
        zzd.put("oldlace", -133658);
        zzd.put("olive", -8355840);
        zzd.put("olivedrab", -9728477);
        zzd.put("orange", -23296);
        zzd.put("orangered", -47872);
        zzd.put("orchid", -2461482);
        zzd.put("palegoldenrod", -1120086);
        zzd.put("palegreen", -6751336);
        zzd.put("paleturquoise", -5247250);
        zzd.put("palevioletred", -2396013);
        zzd.put("papayawhip", -4139);
        zzd.put("peachpuff", -9543);
        zzd.put("peru", -3308225);
        zzd.put("pink", -16181);
        zzd.put("plum", -2252579);
        zzd.put("powderblue", -5185306);
        zzd.put("purple", -8388480);
        zzd.put("rebeccapurple", -10079335);
        zzd.put("red", Integer.valueOf(SupportMenu.CATEGORY_MASK));
        zzd.put("rosybrown", -4419697);
        zzd.put("royalblue", -12490271);
        zzd.put("saddlebrown", -7650029);
        zzd.put("salmon", -360334);
        zzd.put("sandybrown", -744352);
        zzd.put("seagreen", -13726889);
        zzd.put("seashell", -2578);
        zzd.put("sienna", -6270419);
        zzd.put("silver", -4144960);
        zzd.put("skyblue", -7876885);
        zzd.put("slateblue", -9807155);
        zzd.put("slategray", -9404272);
        zzd.put("slategrey", -9404272);
        zzd.put("snow", -1286);
        zzd.put("springgreen", -16711809);
        zzd.put("steelblue", -12156236);
        zzd.put("tan", -2968436);
        zzd.put("teal", -16744320);
        zzd.put("thistle", -2572328);
        zzd.put("tomato", -40121);
        zzd.put("transparent", 0);
        zzd.put("turquoise", -12525360);
        zzd.put("violet", -1146130);
        zzd.put("wheat", -663885);
        zzd.put("white", -1);
        zzd.put("whitesmoke", -657931);
        zzd.put("yellow", Integer.valueOf(InputDeviceCompat.SOURCE_ANY));
        zzd.put("yellowgreen", -6632142);
    }

    public static int zza(String str) {
        return zzc(str, true);
    }

    public static int zzb(String str) {
        return zzc(str, false);
    }

    private static int zzc(String str, boolean z) {
        Pattern pattern;
        int i;
        zzeq.zzd(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return -16777216 | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith("rgba")) {
            if (z) {
                pattern = zzc;
            } else {
                pattern = zzb;
            }
            Matcher matcher = pattern.matcher(replace);
            if (matcher.matches()) {
                if (z) {
                    String group = matcher.group(4);
                    if (group != null) {
                        i = (int) (Float.parseFloat(group) * 255.0f);
                    } else {
                        throw null;
                    }
                } else {
                    String group2 = matcher.group(4);
                    if (group2 != null) {
                        i = Integer.parseInt(group2, 10);
                    } else {
                        throw null;
                    }
                }
                String group3 = matcher.group(1);
                if (group3 != null) {
                    int parseInt = Integer.parseInt(group3, 10);
                    String group4 = matcher.group(2);
                    if (group4 != null) {
                        int parseInt2 = Integer.parseInt(group4, 10);
                        String group5 = matcher.group(3);
                        if (group5 != null) {
                            return Color.argb(i, parseInt, parseInt2, Integer.parseInt(group5, 10));
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
        } else if (replace.startsWith("rgb")) {
            Matcher matcher2 = zza.matcher(replace);
            if (matcher2.matches()) {
                String group6 = matcher2.group(1);
                if (group6 != null) {
                    int parseInt3 = Integer.parseInt(group6, 10);
                    String group7 = matcher2.group(2);
                    if (group7 != null) {
                        int parseInt4 = Integer.parseInt(group7, 10);
                        String group8 = matcher2.group(3);
                        if (group8 != null) {
                            return Color.rgb(parseInt3, parseInt4, Integer.parseInt(group8, 10));
                        }
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
        } else {
            Integer num = (Integer) zzd.get(zzfxm.zza(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
