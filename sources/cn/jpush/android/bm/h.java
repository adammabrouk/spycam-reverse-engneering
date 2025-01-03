package cn.jpush.android.bm;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.helper.Logger;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static String f9680a;

    public static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f9680a)) {
            return f9680a;
        }
        String a2 = a();
        f9680a = a2;
        if (!TextUtils.isEmpty(a2)) {
            return f9680a;
        }
        String b2 = b();
        f9680a = b2;
        if (!TextUtils.isEmpty(b2)) {
            return f9680a;
        }
        String c2 = c();
        f9680a = c2;
        String str = !TextUtils.isEmpty(c2) ? f9680a : "";
        f9680a = str;
        return str;
    }

    public static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            Logger.w("ProcessUtil", "getCurrentProcessNameByActivityThread failed, " + th.getMessage());
            return null;
        }
    }

    public static String c() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i2;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable unused) {
            }
            try {
                bArr = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
                i2 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i2 >= 256) {
                        break;
                    }
                    bArr[i2] = (byte) read;
                    i2++;
                }
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    return "";
                }
                fileInputStream2.close();
                return "";
            }
            if (i2 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i2, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }
}
