package cn.jiguang.ao;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f8258a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8259b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8260c = false;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f8261d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8262e = false;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f8263f = false;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f8264g = false;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f8265h = false;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f8266i = false;
    public static volatile c j;
    public static final Object k = new Object();
    public static AtomicInteger l = new AtomicInteger(0);

    public c() {
        f8258a = d();
        f8259b = e();
        f8260c = f();
        f8261d = g();
        f8262e = h();
        f8263f = j();
        f8264g = i();
        f8265h = k();
        f8266i = l();
    }

    public static c a() {
        if (j == null) {
            j = new c();
        }
        return j;
    }

    public static boolean d() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 1) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jpush init");
            return f8258a;
        }
        i2 = l.addAndGet(1);
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJpushSDK:" + e.getMessage());
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJpushSDK:" + z + ", mPluginInitState: " + i2);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJpushSDK:" + z + ", mPluginInitState: " + i2);
        return z;
    }

    public static boolean e() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 2) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jmessage init");
            return f8259b;
        }
        int i3 = l.addAndGet(2);
        try {
            Class.forName("cn.jpush.im.android.api.JMessageClient");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJMessageSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJMessageSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJMessageSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean f() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 4) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p janalytics init");
            return f8260c;
        }
        int i3 = l.addAndGet(4);
        try {
            Class.forName("cn.jiguang.analytics.android.api.JAnalyticsInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJanalyticsSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean g() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 8) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jshare init");
            return f8261d;
        }
        int i3 = l.addAndGet(8);
        try {
            Class.forName("cn.jiguang.share.android.api.JShareInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJshareSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJshareSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJshareSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean h() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 16) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jssp init");
            return f8262e;
        }
        int i3 = l.addAndGet(16);
        try {
            Class.forName("cn.jiguang.adsdk.api.JSSPInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJSspSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJSspSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJSspSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean i() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 32) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jcommon init");
            return f8264g;
        }
        int i3 = l.addAndGet(32);
        try {
            Class.forName("cn.jiguang.h.b");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJCommonSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJCommonSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJCommonSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean j() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & 64) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jverification init");
            return f8263f;
        }
        int i3 = l.addAndGet(64);
        try {
            Class.forName("cn.jiguang.verifysdk.api.JVerificationInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJVerificationSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJVerificationSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJVerificationSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean k() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & RecyclerView.c0.FLAG_IGNORE) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p jmlink init");
            return f8265h;
        }
        int i3 = l.addAndGet(RecyclerView.c0.FLAG_IGNORE);
        try {
            Class.forName("cn.jiguang.jmlinksdk.core.JMlinkInterfaceImpl");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJMLinkSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJMLinkSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJMLinkSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public static boolean l() {
        int i2;
        boolean z = false;
        try {
        } catch (ClassNotFoundException e2) {
            e = e2;
            i2 = 0;
        }
        if ((l.intValue() & RecyclerView.c0.FLAG_TMP_DETACHED) != 0) {
            cn.jiguang.as.d.c("JClientsHelper", "p junion init");
            return f8266i;
        }
        int i3 = l.addAndGet(RecyclerView.c0.FLAG_TMP_DETACHED);
        try {
            Class.forName("cn.jiguang.junion.JUnionInterface");
            z = true;
        } catch (ClassNotFoundException e3) {
            i2 = i3;
            e = e3;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJUnionSDK:" + e.getMessage());
            i3 = i2;
            cn.jiguang.as.d.a("JClientsHelper", "isPluginJUnionSDK:" + z + ", pluginState: " + i3);
            return z;
        }
        cn.jiguang.as.d.a("JClientsHelper", "isPluginJUnionSDK:" + z + ", pluginState: " + i3);
        return z;
    }

    public boolean a(Context context) {
        return f8259b || f8258a;
    }

    public boolean b() {
        return f8259b;
    }

    public boolean c() {
        return f8258a;
    }
}
