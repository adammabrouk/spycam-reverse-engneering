package cn.jpush.android.u;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.internal.JConstants;
import cn.jiguang.union.ads.core.config.JUnionAdConfig;
import cn.jpush.android.n.b;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9866a = JConstants.SDK_VERSION_INT;

    /* renamed from: b, reason: collision with root package name */
    public static Context f9867b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f9868c;

    /* renamed from: d, reason: collision with root package name */
    public static Bundle f9869d;

    /* renamed from: e, reason: collision with root package name */
    public static JUnionAdConfig f9870e;

    public static Context a() {
        return f9867b;
    }

    public static void a(Context context) {
        f9867b = context;
    }

    public static void a(Bundle bundle) {
        f9869d = bundle;
    }

    public static void a(JUnionAdConfig jUnionAdConfig) {
        f9870e = jUnionAdConfig;
        b.a().a(f9867b, jUnionAdConfig.getExtra());
    }

    public static void a(boolean z) {
        f9868c = z;
    }

    public static Bundle b() {
        return f9869d;
    }

    public static JUnionAdConfig c() {
        if (f9870e == null) {
            f9870e = new JUnionAdConfig.Builder().build();
        }
        return f9870e;
    }
}
