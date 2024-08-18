package com.google.android.gms.internal.ads;

import androidx.compose.material3.TextFieldImplKt;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.2.0 */
final class zzagq {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzagm zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.next();
            if (zzge.zzc(newPullParser, "x:xmpmeta")) {
                zzgbc zzm = zzgbc.zzm();
                long j2 = -9223372036854775807L;
                while (true) {
                    newPullParser.next();
                    if (zzge.zzc(newPullParser, "rdf:Description")) {
                        String[] strArr = zza;
                        int i = 0;
                        int i2 = 0;
                        while (i2 < 4) {
                            String zza2 = zzge.zza(newPullParser, strArr[i2]);
                            if (zza2 == null) {
                                i2++;
                            } else if (Integer.parseInt(zza2) != 1) {
                                return null;
                            } else {
                                String[] strArr2 = zzb;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= 4) {
                                        j = -9223372036854775807L;
                                        break;
                                    }
                                    String zza3 = zzge.zza(newPullParser, strArr2[i3]);
                                    if (zza3 != null) {
                                        j = Long.parseLong(zza3);
                                        if (j == -1) {
                                            j = -9223372036854775807L;
                                        }
                                    } else {
                                        i3++;
                                    }
                                }
                                String[] strArr3 = zzc;
                                while (true) {
                                    if (i >= 2) {
                                        zzm = zzgbc.zzm();
                                        break;
                                    }
                                    String zza4 = zzge.zza(newPullParser, strArr3[i]);
                                    if (zza4 != null) {
                                        zzm = zzgbc.zzo(new zzagl("image/jpeg", "Primary", 0, 0), new zzagl("video/mp4", "MotionPhoto", Long.parseLong(zza4), 0));
                                        break;
                                    }
                                    i++;
                                }
                                j2 = j;
                            }
                        }
                        return null;
                    } else if (zzge.zzc(newPullParser, "Container:Directory")) {
                        zzm = zzb(newPullParser, TextFieldImplKt.ContainerId, "Item");
                    } else if (zzge.zzc(newPullParser, "GContainer:Directory")) {
                        zzm = zzb(newPullParser, "GContainer", "GContainerItem");
                    }
                    if (zzge.zzb(newPullParser, "x:xmpmeta")) {
                        if (zzm.isEmpty()) {
                            return null;
                        }
                        return new zzagm(j2, zzm);
                    }
                }
            } else {
                throw zzch.zza("Couldn't find xmp metadata", (Throwable) null);
            }
        } catch (zzch | NumberFormatException | XmlPullParserException e) {
            zzfk.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzgbc zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j;
        long j2;
        zzgaz zzgaz = new zzgaz();
        do {
            String concat = str.concat(":Item");
            xmlPullParser.next();
            if (zzge.zzc(xmlPullParser, concat)) {
                String concat2 = str2.concat(":Mime");
                String concat3 = str2.concat(":Semantic");
                String concat4 = str2.concat(":Length");
                String concat5 = str2.concat(":Padding");
                String zza2 = zzge.zza(xmlPullParser, concat2);
                String zza3 = zzge.zza(xmlPullParser, concat3);
                String zza4 = zzge.zza(xmlPullParser, concat4);
                String zza5 = zzge.zza(xmlPullParser, concat5);
                if (zza2 == null || zza3 == null) {
                    return zzgbc.zzm();
                }
                if (zza4 != null) {
                    j = Long.parseLong(zza4);
                } else {
                    j = 0;
                }
                if (zza5 != null) {
                    j2 = Long.parseLong(zza5);
                } else {
                    j2 = 0;
                }
                zzgaz.zzf(new zzagl(zza2, zza3, j, j2));
            }
        } while (!zzge.zzb(xmlPullParser, str.concat(":Directory")));
        return zzgaz.zzi();
    }
}
