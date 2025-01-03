package cn.jiguang.az;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.android.BuildConfig;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class c {
    public static boolean a(Context context) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.E());
        String e2 = cn.jiguang.d.a.e(context);
        cn.jiguang.as.d.c("InitHelper", "appkey=" + e2 + " last=" + str);
        if (!cn.jiguang.e.f.a(str) && !LogUtils.NULL.equals(str) && str.equalsIgnoreCase(e2)) {
            return false;
        }
        cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.E().a((cn.jiguang.f.a<String>) e2)});
        cn.jiguang.as.d.d("InitHelper", "We found the appKey is changed or register appkey is empty. Will re-register.");
        cn.jiguang.av.b.a(context);
        return true;
    }

    public static void b(Context context) {
        String str = (String) cn.jiguang.f.b.a(context, cn.jiguang.f.a.y());
        if (!TextUtils.isEmpty(str)) {
            str.startsWith("1.");
        }
        if (TextUtils.isEmpty(str) || !BuildConfig.VERSION_NAME.equals(str)) {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.y().a((cn.jiguang.f.a<String>) BuildConfig.VERSION_NAME)});
        }
    }
}
