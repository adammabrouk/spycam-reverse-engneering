package c.k.c.a;

import c.k.d.a7;
import java.util.HashMap;

/* loaded from: classes.dex */
public class z0 {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<s0, a> f6941a = new HashMap<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f6942a;

        /* renamed from: b, reason: collision with root package name */
        public String f6943b;

        public a(String str, String str2) {
            this.f6942a = str;
            this.f6943b = str2;
        }
    }

    static {
        a(s0.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(s0.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(s0.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(s0.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static n0 a(s0 s0Var) {
        int i2 = a1.f6806a[s0Var.ordinal()];
        if (i2 == 1) {
            return n0.UPLOAD_HUAWEI_TOKEN;
        }
        if (i2 == 2) {
            return n0.UPLOAD_FCM_TOKEN;
        }
        if (i2 == 3) {
            return n0.UPLOAD_COS_TOKEN;
        }
        if (i2 != 4) {
            return null;
        }
        return n0.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static a m64a(s0 s0Var) {
        return f6941a.get(s0Var);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static a7 m65a(s0 s0Var) {
        return a7.AggregatePushSwitch;
    }

    public static void a(s0 s0Var, a aVar) {
        if (aVar != null) {
            f6941a.put(s0Var, aVar);
        }
    }
}
