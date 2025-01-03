package cn.jpush.android.bm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.recyclerview.widget.RecyclerView;
import cn.jpush.android.helper.Logger;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    public static String f9669b;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f9670c = {84, 85, 108, 72, 90, 107, 49, 66, 77, 69, 100, 68, 85, 51, 70, 72, 85, 48, 108, 105, 77, 48, 82, 82, 82, 85, 74, 66, 85, 86, 86, 66, 81, 84, 82, 72, 84, 107, 70, 69, 81, 48, 74, 112, 85, 85, 116, 67, 90, 49, 70, 68, 99, 108, 108, 108, 81, 122, 78, 81, 90, 69, 120, 122, 89, 88, 90, 77, 90, 106, 104, 69, 90, 84, 108, 71, 89, 122, 81, 51, 78, 50, 104, 78, 83, 119, 112, 110, 100, 108, 90, 68, 78, 72, 104, 85, 99, 50, 53, 89, 87, 71, 86, 78, 99, 85, 104, 111, 87, 85, 120, 68, 98, 88, 108, 77, 82, 72, 85, 51, 81, 122, 90, 82, 78, 70, 107, 120, 77, 71, 82, 49, 100, 106, 100, 76, 98, 108, 112, 105, 99, 105, 116, 110, 98, 51, 100, 90, 82, 87, 81, 53, 85, 122, 82, 78, 77, 48, 108, 72, 98, 122, 100, 110, 90, 106, 66, 118, 99, 85, 112, 117, 67, 107, 120, 77, 100, 107, 90, 54, 83, 69, 116, 54, 90, 70, 74, 106, 99, 87, 115, 49, 99, 88, 112, 117, 89, 87, 57, 118, 90, 50, 120, 68, 81, 122, 65, 48, 82, 109, 104, 74, 97, 108, 74, 80, 87, 72, 104, 50, 81, 108, 90, 54, 79, 71, 100, 66, 98, 51, 90, 104, 90, 107, 53, 90, 99, 109, 120, 76, 78, 109, 104, 105, 90, 85, 82, 79, 84, 107, 49, 78, 84, 50, 57, 73, 83, 108, 65, 75, 82, 50, 100, 112, 85, 71, 82, 87, 97, 50, 70, 109, 89, 108, 82, 107, 81, 108, 78, 89, 97, 110, 112, 51, 83, 85, 82, 66, 85, 85, 70, 67};

    /* renamed from: d, reason: collision with root package name */
    public static final String f9671d = d.b(new byte[]{68, 66, 113, 15, 87, 103, 120, 116, 31, 112, 82, 75, 69, 32, 96, 65, 125, 108, Byte.MAX_VALUE, Byte.MAX_VALUE, 87});

    /* renamed from: a, reason: collision with root package name */
    public Context f9672a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f9673a = new f();
    }

    public f() {
    }

    public static f a() {
        return a.f9673a;
    }

    public static String b() {
        return new String(Base64.decode(f9670c, 2));
    }

    private String b(String str) {
        try {
            Intent a2 = Build.VERSION.SDK_INT >= 22 ? cn.jpush.android.bm.a.a(str, 4) : cn.jpush.android.bm.a.a(str, 0);
            a2.setPackage(this.f9672a.getPackageName());
            return this.f9672a.getPackageManager().resolveActivity(a2, 0).activityInfo.name;
        } catch (Throwable unused) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.c0.FLAG_IGNORE);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                f9669b = bundle.getString("JPUSH_JUMP");
                Logger.d("JumpManager", "getJumpConfig config =" + f9669b);
            }
        } catch (Throwable th) {
            Logger.d("JumpManager", "getJumpConfig =" + th.getMessage());
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return j.b(str, b(), f9671d);
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkJumpConfig rsa=" + th);
            return "";
        }
    }

    public void a(Context context) {
        Logger.d("JumpManager", " init config");
        this.f9672a = context;
        b(context);
    }

    public boolean a(Context context, String str, String str2, int i2) {
        String d2;
        String a2;
        String str3;
        if (this.f9672a == null) {
            this.f9672a = context;
        }
        Logger.d("JumpManager", "checkJumpConfig url=" + str + " ssl=" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("checkJumpConfig user jump Config=");
        sb.append(f9669b);
        Logger.d("JumpManager", sb.toString());
        try {
            d2 = cn.jpush.android.bm.a.d(str);
            Logger.d("JumpManager", "checkJumpConfig urlMd5=" + d2);
            a2 = a(str2);
            Logger.d("JumpManager", "checkJumpConfig decodeData=" + a2);
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkJumpConfig Throwable=" + th);
        }
        if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(d2) && a2.equalsIgnoreCase(d2)) {
            if (i2 == 2) {
                return true;
            }
            if (f9669b == null) {
                Logger.dd("JumpManager", "jumpConfig is null goto get config");
                b(this.f9672a);
            }
            if (f9669b == null) {
                Logger.dd("JumpManager", "jumpConfig is null,return true");
                return true;
            }
            try {
                String[] split = f9669b.split("/");
                String b2 = b(new String(Base64.decode(str.getBytes(), 2)));
                Logger.d("JumpManager", "jumpConfig =" + Arrays.toString(split));
                Logger.d("JumpManager", " origin className=" + b2);
                for (String str4 : split) {
                    if (!TextUtils.isEmpty(b2) && str4.equals(b2)) {
                        Logger.d("JumpManager", " match user config className");
                        return true;
                    }
                }
            } catch (Throwable th2) {
                str3 = "jumpConfig Throwable=" + th2;
            }
            return false;
        }
        str3 = "checkJumpConfig fail, so return";
        Logger.dd("JumpManager", str3);
        return false;
    }
}
