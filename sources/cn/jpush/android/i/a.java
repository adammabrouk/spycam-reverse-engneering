package cn.jpush.android.i;

import android.util.Log;
import cn.jpush.android.f.c;

/* loaded from: classes.dex */
public final class a {
    public static void a(String str, String str2, int i2, String str3) {
        try {
            if (c.f9724d || i2 >= 5) {
                if (i2 >= 3) {
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
                }
            }
        } catch (Throwable unused) {
        }
    }
}
