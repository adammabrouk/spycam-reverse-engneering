package cn.jiguang.ba;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.e.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f8631a;

    /* renamed from: b, reason: collision with root package name */
    public static c f8632b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, Integer> f8633c = new HashMap();

    public static c a() {
        if (f8632b == null) {
            synchronized (c.class) {
                if (f8632b == null) {
                    f8632b = new c();
                }
            }
        }
        return f8632b;
    }

    public static void a(int i2) {
        if (i2 > 3 || i2 < 0) {
            return;
        }
        f8631a = i2;
    }

    public void a(Context context, int i2) {
        String c2 = g.c(context);
        boolean equals = "wifi".equals(c2);
        String m = (equals && cn.jiguang.d.a.l(context)) ? cn.jiguang.e.a.m(context) : "";
        boolean z = !TextUtils.isEmpty(m);
        if (!equals || z) {
            this.f8633c.put(c2 + m, Integer.valueOf(i2));
        }
        if (z) {
            cn.jiguang.f.b.a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{cn.jiguang.f.a.h(m).a((cn.jiguang.f.a<Integer>) Integer.valueOf(i2))});
        }
    }

    public int b(int i2) {
        int i3 = f8631a;
        if (i3 == 2 || i3 == 1) {
            return f8631a;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return i3;
        }
        return 2;
    }
}
