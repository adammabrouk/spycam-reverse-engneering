package cn.jiguang.be;

import android.content.Context;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.az.e;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a {
    public static volatile a t;
    public static final Object u = new Object();
    public static String v;

    /* renamed from: a, reason: collision with root package name */
    public String f8679a;

    /* renamed from: b, reason: collision with root package name */
    public String f8680b;

    /* renamed from: c, reason: collision with root package name */
    public String f8681c;

    /* renamed from: d, reason: collision with root package name */
    public String f8682d;

    /* renamed from: e, reason: collision with root package name */
    public String f8683e;

    /* renamed from: f, reason: collision with root package name */
    public String f8684f;

    /* renamed from: g, reason: collision with root package name */
    public int f8685g;

    /* renamed from: h, reason: collision with root package name */
    public String f8686h;

    /* renamed from: i, reason: collision with root package name */
    public String f8687i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public transient AtomicBoolean s = new AtomicBoolean(false);

    public a(Context context) {
        b(context);
    }

    public static a a(Context context) {
        if (t == null) {
            synchronized (u) {
                if (t == null) {
                    t = new a(context);
                }
            }
        }
        return t;
    }

    private String a(String str) {
        if (str != null) {
            return str.trim();
        }
        return null;
    }

    private void b(Context context) {
        if (this.s.get() || context == null) {
            return;
        }
        this.f8680b = a(Build.VERSION.RELEASE) + "," + Build.VERSION.SDK_INT;
        if (cn.jiguang.h.a.a().d(2009)) {
            this.f8681c = a(Build.MODEL);
        }
        if (cn.jiguang.h.a.a().d(2001)) {
            this.f8682d = cn.jiguang.e.a.b(context, "gsm.version.baseband", "baseband");
        }
        if (cn.jiguang.h.a.a().d(2008)) {
            this.l = a(Build.MANUFACTURER);
        }
        if (cn.jiguang.h.a.a().d(2002)) {
            this.n = a(Build.BRAND);
        }
        if (cn.jiguang.h.a.a().d(2012)) {
            this.f8686h = cn.jiguang.e.a.f(context);
        }
        if (cn.jiguang.h.a.a().d(RecyclerView.MAX_SCROLL_DURATION)) {
            this.f8687i = cn.jiguang.e.a.i(context);
        }
        this.j = LogUtils.PLACEHOLDER;
        this.f8683e = a(Build.DEVICE);
        this.k = a(Build.PRODUCT);
        this.m = a(Build.FINGERPRINT);
        this.f8679a = c(context);
        this.f8684f = cn.jiguang.d.a.g(context);
        this.f8685g = cn.jiguang.e.a.e(context) ? 1 : 0;
        this.o = cn.jiguang.e.a.f(context, "");
        Object a2 = e.a(context, "get_imei", null);
        if (a2 instanceof String) {
            this.p = (String) a2;
        }
        this.q = Build.VERSION.SDK_INT + "";
        this.r = context.getApplicationInfo().targetSdkVersion + "";
        this.s.set(true);
    }

    public static String c(Context context) {
        if (v == null) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                byte[] bytes = str.getBytes("UTF-8");
                if (bytes.length > 30) {
                    str = new String(bytes, 0, 30);
                }
                v = str;
            } catch (Throwable unused) {
                cn.jiguang.as.d.d("DeviceInfo", "NO versionName defined in manifest.");
            }
        }
        String str2 = v;
        return str2 == null ? "" : str2;
    }
}
