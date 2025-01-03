package com.google.gson.internal;

/* loaded from: classes.dex */
public final class JavaVersion {
    public static final int majorJavaVersion = determineMajorJavaVersion();

    public static int determineMajorJavaVersion() {
        return getMajorJavaVersion(System.getProperty("java.version"));
    }

    public static int extractBeginningInt(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion(String str) {
        int parseDotted = parseDotted(str);
        if (parseDotted == -1) {
            parseDotted = extractBeginningInt(str);
        }
        if (parseDotted == -1) {
            return 6;
        }
        return parseDotted;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }

    public static int parseDotted(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            return (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }
}
