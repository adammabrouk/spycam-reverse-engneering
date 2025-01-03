package cn.jiguang.ab;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.shix.shixipc.system.ContentCommon;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f8114a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f8115b = false;

    /* renamed from: c, reason: collision with root package name */
    public static b f8116c;

    /* renamed from: d, reason: collision with root package name */
    public static a f8117d;

    /* renamed from: e, reason: collision with root package name */
    public static Object f8118e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static HandlerThread f8119f;

    /* renamed from: g, reason: collision with root package name */
    public static Handler f8120g;

    /* renamed from: h, reason: collision with root package name */
    public static String f8121h;

    /* renamed from: i, reason: collision with root package name */
    public static String f8122i;
    public static String j;
    public static String k;

    public static b a(Context context) {
        if (f8116c == null) {
            f8116c = new b();
            f8114a = context;
            f();
            f8117d = new a(f8114a);
            a();
        }
        return f8116c;
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a() {
        f8115b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private void b(int i2, String str) {
        Message obtainMessage = f8120g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt(ContentCommon.TYPE, i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f8120g.sendMessage(obtainMessage);
    }

    public static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_vvdb_thread");
        f8119f = handlerThread;
        handlerThread.start();
        f8120g = new Handler(f8119f.getLooper()) { // from class: cn.jiguang.ab.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.ai.a.a("VivoIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f8121h = b.f8117d.a(message.getData().getInt(ContentCommon.TYPE), message.getData().getString("appid"));
                } catch (Throwable th) {
                    String unused2 = b.f8121h = "";
                    cn.jiguang.ai.a.d("VivoIdManager", "vv getIds, exception" + th.getMessage());
                }
                synchronized (b.f8118e) {
                    b.f8118e.notify();
                }
            }
        };
    }

    public String a(String str) {
        if (!b()) {
            return null;
        }
        String str2 = j;
        if (str2 != null) {
            return str2;
        }
        a(1, str);
        return j;
    }

    public void a(int i2, String str) {
        String str2;
        String str3;
        synchronized (f8118e) {
            b(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f8118e.wait(2000L);
            } catch (InterruptedException e2) {
                cn.jiguang.ai.a.d("VivoIdManager", "lock wait error: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 == 0) {
                    f8122i = f8121h;
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        if (f8121h == null) {
                            str2 = "VivoIdManager";
                            str3 = "get aaid failed";
                        } else {
                            k = f8121h;
                        }
                    }
                } else if (f8121h == null) {
                    str2 = "VivoIdManager";
                    str3 = "get vaid failed";
                } else {
                    j = f8121h;
                }
                f8121h = null;
            } else {
                str2 = "VivoIdManager";
                str3 = "query timeout";
            }
            cn.jiguang.ai.a.a(str2, str3);
        }
    }

    public String b(String str) {
        if (!b()) {
            return null;
        }
        String str2 = k;
        if (str2 != null) {
            return str2;
        }
        a(2, str);
        return k;
    }

    public boolean b() {
        return f8115b;
    }

    public String c() {
        if (!b()) {
            return null;
        }
        String str = f8122i;
        if (str != null) {
            return str;
        }
        a(0, (String) null);
        return f8122i;
    }
}
