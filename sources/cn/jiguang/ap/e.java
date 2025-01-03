package cn.jiguang.ap;

import android.content.Context;
import android.os.Bundle;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class e {
    public static Object a(Context context, String str, Bundle bundle) {
        return b.a(context, str, bundle);
    }

    public static void a(Context context) {
        b.a(context, "exit_app", null);
    }

    public static void a(Context context, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt(ContentCommon.TYPE, i2);
        b.a(context, "start_app", bundle);
    }

    public static void a(Context context, long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putString("rid", str);
        b.a(context, "jcore_login", bundle);
    }

    public static void b(Context context) {
        cn.jiguang.as.d.c("JOperateJCoreChannel", "initinit");
        b.a(context, "init", null);
    }

    public static void b(Context context, long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putString("rid", str);
        b.a(context, "jcore_register", bundle);
    }

    public static void c(Context context) {
        b.a(context, "period_task", null);
    }
}
