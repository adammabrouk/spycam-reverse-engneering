package c.j.a.z;

import cn.jiguang.internal.JConstants;

/* compiled from: OperateUtil.java */
/* loaded from: classes.dex */
public final class y {
    public static int a(c.j.a.f.b bVar) {
        c0 b2 = c0.b();
        int b3 = bVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int a2 = b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT");
        long b4 = currentTimeMillis - b2.b("com.vivo.push_preferences.operate." + b3 + "START_TIME", 0L);
        if (b4 <= JConstants.DAY && b4 >= 0) {
            if (a2 >= bVar.d()) {
                return 1001;
            }
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", a2 + 1);
            return 0;
        }
        b2.a("com.vivo.push_preferences.operate." + b3 + "START_TIME", System.currentTimeMillis());
        b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", 1);
        return 0;
    }
}
