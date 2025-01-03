package com.google.gson.internal;

import com.shix.shixipc.utilcode.LogUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class PreJava9DateFormatProvider {
    public static String getDateFormatPattern(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i2 == 1) {
            return "MMMM d, y";
        }
        if (i2 == 2) {
            return "MMM d, y";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static String getDatePartOfDateTimePattern(int i2) {
        if (i2 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i2 == 1) {
            return "MMMM d, yyyy";
        }
        if (i2 == 2) {
            return "MMM d, yyyy";
        }
        if (i2 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static String getTimePartOfDateTimePattern(int i2) {
        if (i2 == 0 || i2 == 1) {
            return "h:mm:ss a z";
        }
        if (i2 == 2) {
            return "h:mm:ss a";
        }
        if (i2 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i2);
    }

    public static DateFormat getUSDateFormat(int i2) {
        return new SimpleDateFormat(getDateFormatPattern(i2), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i2, int i3) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i2) + LogUtils.PLACEHOLDER + getTimePartOfDateTimePattern(i3), Locale.US);
    }
}
