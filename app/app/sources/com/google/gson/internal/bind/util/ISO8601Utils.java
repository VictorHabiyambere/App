package com.google.gson.internal.bind.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean millis) {
        return format(date, millis, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean millis, TimeZone tz) {
        Calendar calendar = new GregorianCalendar(tz, Locale.US);
        calendar.setTime(date);
        StringBuilder formatted = new StringBuilder("yyyy-MM-ddThh:mm:ss".length() + (millis ? ".sss".length() : 0) + (tz.getRawOffset() == 0 ? "Z" : "+hh:mm").length());
        padInt(formatted, calendar.get(1), "yyyy".length());
        char c = '-';
        formatted.append('-');
        padInt(formatted, calendar.get(2) + 1, "MM".length());
        formatted.append('-');
        padInt(formatted, calendar.get(5), "dd".length());
        formatted.append('T');
        padInt(formatted, calendar.get(11), "hh".length());
        formatted.append(':');
        padInt(formatted, calendar.get(12), "mm".length());
        formatted.append(':');
        padInt(formatted, calendar.get(13), "ss".length());
        if (millis) {
            formatted.append('.');
            padInt(formatted, calendar.get(14), "sss".length());
        }
        int offset = tz.getOffset(calendar.getTimeInMillis());
        if (offset != 0) {
            int hours = Math.abs((offset / 60000) / 60);
            int minutes = Math.abs((offset / 60000) % 60);
            if (offset >= 0) {
                c = '+';
            }
            formatted.append(c);
            padInt(formatted, hours, "hh".length());
            formatted.append(':');
            padInt(formatted, minutes, "mm".length());
        } else {
            formatted.append('Z');
        }
        return formatted.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x022a  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r22, java.text.ParsePosition r23) throws java.text.ParseException {
        /*
            r1 = r22
            r2 = r23
            r3 = 0
            int r0 = r23.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            int r4 = r0 + 4
            int r0 = parseInt(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            if (r6 == 0) goto L_0x0019
            int r4 = r4 + 1
        L_0x0019:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            if (r7 == 0) goto L_0x0027
            int r6 = r6 + 1
        L_0x0027:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 84
            boolean r12 = checkOffset(r1, r7, r12)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r13 = 0
            if (r12 != 0) goto L_0x0061
            int r14 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r14 > r7) goto L_0x0061
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            int r14 = r4 + -1
            r5.<init>(r0, r14, r6)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r5.setLenient(r13)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            java.util.Date r13 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            return r13
        L_0x0052:
            r0 = move-exception
            r16 = r3
            goto L_0x021c
        L_0x0057:
            r0 = move-exception
            r16 = r3
            goto L_0x0221
        L_0x005c:
            r0 = move-exception
            r16 = r3
            goto L_0x0226
        L_0x0061:
            r14 = 43
            r15 = 90
            if (r12 == 0) goto L_0x00dc
            int r7 = r7 + 1
            int r13 = r7 + 2
            int r7 = parseInt(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r8 = r7
            r7 = 58
            boolean r16 = checkOffset(r1, r13, r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r16 == 0) goto L_0x007a
            int r13 = r13 + 1
        L_0x007a:
            int r5 = r13 + 2
            int r13 = parseInt(r1, r13, r5)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r9 = r13
            boolean r7 = checkOffset(r1, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r7 == 0) goto L_0x008b
            int r5 = r5 + 1
            r7 = r5
            goto L_0x008c
        L_0x008b:
            r7 = r5
        L_0x008c:
            int r5 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r5 <= r7) goto L_0x00dc
            char r5 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r5 == r15) goto L_0x00dc
            if (r5 == r14) goto L_0x00dc
            r13 = 45
            if (r5 == r13) goto L_0x00dc
            int r13 = r7 + 2
            int r7 = parseInt(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r10 = 59
            if (r7 <= r10) goto L_0x00b0
            r10 = 63
            if (r7 >= r10) goto L_0x00b0
            r7 = 59
            r10 = r7
            goto L_0x00b1
        L_0x00b0:
            r10 = r7
        L_0x00b1:
            r7 = 46
            boolean r7 = checkOffset(r1, r13, r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            if (r7 == 0) goto L_0x00db
            int r13 = r13 + 1
            int r7 = r13 + 1
            int r7 = indexOfNonDigit(r1, r7)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            int r14 = r13 + 3
            int r14 = java.lang.Math.min(r7, r14)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            int r17 = parseInt(r1, r13, r14)     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            int r18 = r14 - r13
            switch(r18) {
                case 1: goto L_0x00d6;
                case 2: goto L_0x00d3;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            r11 = r17
            goto L_0x00d9
        L_0x00d3:
            int r11 = r17 * 10
            goto L_0x00d9
        L_0x00d6:
            int r11 = r17 * 100
        L_0x00d9:
            r13 = r7
            goto L_0x00dc
        L_0x00db:
            r7 = r13
        L_0x00dc:
            int r5 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            if (r5 <= r7) goto L_0x0207
            r5 = 0
            char r13 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r14 = 1
            if (r13 != r15) goto L_0x00f4
            java.util.TimeZone r15 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x005c, NumberFormatException -> 0x0057, IllegalArgumentException -> 0x0052 }
            r5 = r15
            int r7 = r7 + r14
            r16 = r3
            r21 = r12
            goto L_0x01d4
        L_0x00f4:
            r15 = 43
            if (r13 == r15) goto L_0x0120
            r15 = 45
            if (r13 != r15) goto L_0x00ff
            r16 = r3
            goto L_0x0122
        L_0x00ff:
            java.lang.IndexOutOfBoundsException r14 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r15.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0223, NumberFormatException -> 0x021e, IllegalArgumentException -> 0x0219 }
            r16 = r3
            java.lang.String r3 = "Invalid time zone indicator '"
            java.lang.StringBuilder r3 = r15.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.StringBuilder r3 = r3.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r15 = "'"
            java.lang.StringBuilder r3 = r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r14.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            throw r14     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
        L_0x0120:
            r16 = r3
        L_0x0122:
            java.lang.String r3 = r1.substring(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            int r15 = r3.length()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r14 = 5
            if (r15 < r14) goto L_0x012f
            r14 = r3
            goto L_0x0142
        L_0x012f:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r14.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.StringBuilder r14 = r14.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r15 = "00"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r14 = r14.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
        L_0x0142:
            r3 = r14
            int r14 = r3.length()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            int r7 = r7 + r14
            java.lang.String r14 = "+0000"
            boolean r14 = r14.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            if (r14 != 0) goto L_0x01c9
            java.lang.String r14 = "+00:00"
            boolean r14 = r14.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            if (r14 == 0) goto L_0x0160
            r18 = r3
            r19 = r7
            r21 = r12
            goto L_0x01cf
        L_0x0160:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r14.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r15 = "GMT"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.StringBuilder r14 = r14.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r14 = r14.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r5 = r15
            java.lang.String r15 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            boolean r18 = r15.equals(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            if (r18 != 0) goto L_0x01c2
            r18 = r3
            java.lang.String r3 = ":"
            r19 = r7
            java.lang.String r7 = ""
            java.lang.String r3 = r15.replace(r3, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            boolean r7 = r3.equals(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            if (r7 == 0) goto L_0x0197
            r21 = r12
            goto L_0x01d2
        L_0x0197:
            java.lang.IndexOutOfBoundsException r7 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r20 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r3.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r21 = r12
            java.lang.String r12 = "Mismatching time zone indicator: "
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.StringBuilder r3 = r3.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r12 = " given, resolves to "
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r12 = r5.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.StringBuilder r3 = r3.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r7.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            throw r7     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
        L_0x01c2:
            r18 = r3
            r19 = r7
            r21 = r12
            goto L_0x01d2
        L_0x01c9:
            r18 = r3
            r19 = r7
            r21 = r12
        L_0x01cf:
            java.util.TimeZone r3 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r5 = r3
        L_0x01d2:
            r7 = r19
        L_0x01d4:
            java.util.GregorianCalendar r3 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r3.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 0
            r3.setLenient(r12)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 1
            r3.set(r12, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            int r12 = r4 + -1
            r14 = 2
            r3.set(r14, r12)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 5
            r3.set(r12, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 11
            r3.set(r12, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 12
            r3.set(r12, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 13
            r3.set(r12, r10)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r12 = 14
            r3.set(r12, r11)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.util.Date r12 = r3.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            return r12
        L_0x0207:
            r16 = r3
            r21 = r12
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            java.lang.String r5 = "No time zone indicator"
            r3.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x0217, NumberFormatException -> 0x0215, IllegalArgumentException -> 0x0213 }
        L_0x0213:
            r0 = move-exception
            goto L_0x021c
        L_0x0215:
            r0 = move-exception
            goto L_0x0221
        L_0x0217:
            r0 = move-exception
            goto L_0x0226
        L_0x0219:
            r0 = move-exception
            r16 = r3
        L_0x021c:
            r3 = r0
            goto L_0x0228
        L_0x021e:
            r0 = move-exception
            r16 = r3
        L_0x0221:
            r3 = r0
            goto L_0x0227
        L_0x0223:
            r0 = move-exception
            r16 = r3
        L_0x0226:
            r3 = r0
        L_0x0227:
        L_0x0228:
            if (r1 != 0) goto L_0x022c
            r0 = 0
            goto L_0x0243
        L_0x022c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r4 = 34
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
        L_0x0243:
            java.lang.String r4 = r3.getMessage()
            if (r4 == 0) goto L_0x024f
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0270
        L_0x024f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "("
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.Class r6 = r3.getClass()
            java.lang.String r6 = r6.getName()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = ")"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r4 = r5.toString()
        L_0x0270:
            java.text.ParseException r5 = new java.text.ParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to parse date ["
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r7 = "]: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            int r7 = r23.getIndex()
            r5.<init>(r6, r7)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String value, int offset, char expected) {
        return offset < value.length() && value.charAt(offset) == expected;
    }

    private static int parseInt(String value, int beginIndex, int endIndex) throws NumberFormatException {
        if (beginIndex < 0 || endIndex > value.length() || beginIndex > endIndex) {
            throw new NumberFormatException(value);
        }
        int digit = beginIndex;
        int result = 0;
        if (digit < endIndex) {
            int i = digit + 1;
            int digit2 = Character.digit(value.charAt(digit), 10);
            if (digit2 >= 0) {
                result = -digit2;
                digit = i;
            } else {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
        }
        while (digit < endIndex) {
            int i2 = digit + 1;
            int digit3 = Character.digit(value.charAt(digit), 10);
            if (digit3 >= 0) {
                result = (result * 10) - digit3;
                digit = i2;
            } else {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
        }
        return -result;
    }

    private static void padInt(StringBuilder buffer, int value, int length) {
        String strValue = Integer.toString(value);
        for (int i = length - strValue.length(); i > 0; i--) {
            buffer.append('0');
        }
        buffer.append(strValue);
    }

    private static int indexOfNonDigit(String string, int offset) {
        for (int i = offset; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return i;
            }
        }
        return string.length();
    }
}
