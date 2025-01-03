package cn.jiguang.as;

import android.util.Log;
import cn.jiguang.internal.JConstants;

/* loaded from: classes.dex */
public class b {
    public static void a(String str, String str2, boolean z, int i2, String str3, Throwable th) {
        String str4;
        StringBuilder sb;
        try {
            if (cn.jiguang.a.a.f8103g) {
                if (i2 == 2) {
                    str4 = "T";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i2 == 3) {
                    str4 = "D";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i2 == 4) {
                    str4 = "I";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i2 == 5) {
                    str4 = "W";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                } else if (i2 == 6) {
                    str4 = "E";
                    sb = new StringBuilder();
                    sb.append("JIGUANG-");
                    sb.append(str);
                }
                c.a(str4, sb.toString(), str2, str3, null);
            }
            boolean z2 = false;
            try {
                z2 = JConstants.CMD_TO_PRINT_ALL_LOG;
            } catch (Throwable unused) {
            }
            if (!z2) {
                if (!JConstants.DEBUG_MODE && i2 < 5) {
                    return;
                }
                if ((z && i2 < 6) || !a(i2)) {
                    return;
                }
            }
            if (i2 == 2) {
                Log.v("JIGUANG-" + str, "[" + str2 + "] " + str3);
                return;
            }
            if (i2 == 3) {
                Log.d("JIGUANG-" + str, "[" + str2 + "] " + str3);
                return;
            }
            if (i2 == 4) {
                Log.i("JIGUANG-" + str, "[" + str2 + "] " + str3);
                return;
            }
            if (i2 == 5) {
                Log.w("JIGUANG-" + str, "[" + str2 + "] " + str3);
                return;
            }
            if (i2 != 6) {
                return;
            }
            Log.e("JIGUANG-" + str, "[" + str2 + "] " + str3);
        } catch (Throwable unused2) {
        }
    }

    public static boolean a(int i2) {
        return i2 >= 2;
    }
}
