package cn.jpush.android.l;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.at.a;

/* loaded from: classes.dex */
public class b {
    static {
        cn.jpush.android.p.a.a();
    }

    public static String a() {
        return a.C0146a.b();
    }

    public static void a(Context context) {
        cn.jpush.android.n.b.a().a(context);
    }

    public static void a(Context context, Intent intent, Object obj) {
        a.c(context, "JUnionAdHelper", new cn.jpush.android.n.c(context, intent, obj));
    }

    public static void a(Context context, String str) {
        cn.jpush.android.p.a.a().a(context, str);
    }

    public static void a(Context context, String str, Object obj) {
        a.c(context, "JUnionAdHelper", new cn.jpush.android.n.a(context, str, obj));
    }

    public static void a(Context context, boolean z) {
        cn.jpush.android.n.b.a().a(context, z);
    }
}
