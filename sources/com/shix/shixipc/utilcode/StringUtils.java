package com.shix.shixipc.utilcode;

import android.content.res.Resources;
import java.util.IllegalFormatException;

/* loaded from: classes.dex */
public final class StringUtils {
    public StringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static String format(String str, Object... objArr) {
        if (str == null || objArr == null || objArr.length <= 0) {
            return str;
        }
        try {
            return String.format(str, objArr);
        } catch (IllegalFormatException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getString(int i2) {
        return getString(i2, null);
    }

    public static String[] getStringArray(int i2) {
        try {
            return Utils.getApp().getResources().getStringArray(i2);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return new String[]{String.valueOf(i2)};
        }
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTrimEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerFirstLetter(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (!Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        return String.valueOf((char) (str.charAt(0) + ' ')) + str.substring(1);
    }

    public static String null2Length0(String str) {
        return str == null ? "" : str;
    }

    public static String reverse(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (length <= 1) {
            return str;
        }
        int i2 = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = charArray[i3];
            int i4 = (length - i3) - 1;
            charArray[i3] = charArray[i4];
            charArray[i4] = c2;
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (charArray[i2] == 12288) {
                charArray[i2] = ' ';
            } else if (65281 > charArray[i2] || charArray[i2] > 65374) {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] - 65248);
            }
        }
        return new String(charArray);
    }

    public static String toSBC(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (charArray[i2] == ' ') {
                charArray[i2] = 12288;
            } else if ('!' > charArray[i2] || charArray[i2] > '~') {
                charArray[i2] = charArray[i2];
            } else {
                charArray[i2] = (char) (charArray[i2] + 65248);
            }
        }
        return new String(charArray);
    }

    public static String upperFirstLetter(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (!Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return ((char) (str.charAt(0) - ' ')) + str.substring(1);
    }

    public static String getString(int i2, Object... objArr) {
        try {
            return format(Utils.getApp().getString(i2), objArr);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return String.valueOf(i2);
        }
    }
}
