package com.shix.shixipc.system;

import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class Rom {
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_VIVO = "VIVO";
    public static final String TAG = "Rom";
    public static String sName;
    public static String sVersion;

    public static boolean check(String str) {
        String str2 = sName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sVersion = prop;
        if (TextUtils.isEmpty(prop)) {
            String prop2 = getProp("ro.build.version.emui");
            sVersion = prop2;
            if (TextUtils.isEmpty(prop2)) {
                String prop3 = getProp("ro.build.version.opporom");
                sVersion = prop3;
                if (TextUtils.isEmpty(prop3)) {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sVersion = prop4;
                    if (TextUtils.isEmpty(prop4)) {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sVersion = prop5;
                        if (TextUtils.isEmpty(prop5)) {
                            String str3 = Build.DISPLAY;
                            sVersion = str3;
                            if (str3.toUpperCase().contains(ROM_FLYME)) {
                                sName = ROM_FLYME;
                            } else {
                                sVersion = "unknown";
                                sName = Build.MANUFACTURER.toUpperCase();
                            }
                        } else {
                            sName = ROM_SMARTISAN;
                        }
                    } else {
                        sName = ROM_VIVO;
                    }
                } else {
                    sName = ROM_OPPO;
                }
            } else {
                sName = ROM_EMUI;
            }
        } else {
            sName = ROM_MIUI;
        }
        return sName.equals(str);
    }

    public static String getName() {
        if (sName == null) {
            check("");
        }
        return sName;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0065: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x0065 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getProp(java.lang.String r6) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r2.<init>()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r2.append(r6)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            if (r1 != 0) goto L1d
            return r0
        L1d:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.InputStream r1 = r1.getInputStream()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.lang.String r1 = r2.readLine()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L64
            r2.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L64
            r2.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r6 = move-exception
            r6.printStackTrace()
        L3c:
            return r1
        L3d:
            r1 = move-exception
            goto L43
        L3f:
            r6 = move-exception
            goto L66
        L41:
            r1 = move-exception
            r2 = r0
        L43:
            java.lang.String r3 = "Rom"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r4.<init>()     // Catch: java.lang.Throwable -> L64
            java.lang.String r5 = "Unable to read prop "
            r4.append(r5)     // Catch: java.lang.Throwable -> L64
            r4.append(r6)     // Catch: java.lang.Throwable -> L64
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L64
            android.util.Log.e(r3, r6, r1)     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L5f
            goto L63
        L5f:
            r6 = move-exception
            r6.printStackTrace()
        L63:
            return r0
        L64:
            r6 = move-exception
            r0 = r2
        L66:
            if (r0 == 0) goto L70
            r0.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.system.Rom.getProp(java.lang.String):java.lang.String");
    }

    public static String getVersion() {
        if (sVersion == null) {
            check("");
        }
        return sVersion;
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }
}
