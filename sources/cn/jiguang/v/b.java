package cn.jiguang.v;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.l.d;
import com.shix.shixipc.system.ContentCommon;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f9058a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f9059b = false;

    /* renamed from: c, reason: collision with root package name */
    public static b f9060c;

    /* renamed from: d, reason: collision with root package name */
    public static a f9061d;

    /* renamed from: e, reason: collision with root package name */
    public static Object f9062e = new Object();

    /* renamed from: f, reason: collision with root package name */
    public static HandlerThread f9063f;

    /* renamed from: g, reason: collision with root package name */
    public static Handler f9064g;

    /* renamed from: h, reason: collision with root package name */
    public static String f9065h;

    /* renamed from: i, reason: collision with root package name */
    public static String f9066i;
    public static String j;
    public static String k;

    public static b a(Context context) {
        if (f9060c == null) {
            f9060c = new b();
            f9058a = context;
            f();
            f9061d = new a(f9058a);
            a();
        }
        return f9060c;
    }

    public static void a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            cn.jiguang.ai.a.d("MeizuIdManager", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            String g2 = d.g("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=");
            if (packageManager != null && packageManager.resolveContentProvider(g2, 0) != null) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse(d.g("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO")), null, null, new String[]{"supported"}, null);
                    if (query != null) {
                        query.moveToFirst();
                        int columnIndex = query.getColumnIndex("value");
                        if (columnIndex >= 0) {
                            f9059b = "0".equals(query.getString(columnIndex));
                        } else {
                            f9059b = false;
                        }
                        query.close();
                    }
                } catch (Throwable unused) {
                    cn.jiguang.ai.a.a("MeizuIdManager", "mz not support");
                }
                cn.jiguang.ai.a.a("MeizuIdManager", "check meizu supported:" + f9059b);
            }
        }
        f9059b = false;
        cn.jiguang.ai.a.a("MeizuIdManager", "check meizu supported:" + f9059b);
    }

    private void b(int i2) {
        String str;
        Message obtainMessage = f9064g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        if (i2 == 0) {
            str = "ggTIEepvzybHoO4C7/s5eQ==";
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    str = "bRmfYSLDPlLJ9XQro1+/dQ==";
                }
                obtainMessage.setData(bundle);
                f9064g.sendMessage(obtainMessage);
            }
            str = "QlAKJNz4iTmDadRoCSAs4A==";
        }
        bundle.putString(ContentCommon.TYPE, d.g(str));
        obtainMessage.setData(bundle);
        f9064g.sendMessage(obtainMessage);
    }

    public static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_mzdb_thread");
        f9063f = handlerThread;
        handlerThread.start();
        f9064g = new Handler(f9063f.getLooper()) { // from class: cn.jiguang.v.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.ai.a.a("MeizuIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f9065h = b.f9061d.a(message.getData().getString(ContentCommon.TYPE));
                } catch (Throwable th) {
                    String unused2 = b.f9065h = "";
                    cn.jiguang.ai.a.a("MeizuIdManager", "getID exception, " + th.getMessage());
                }
                synchronized (b.f9062e) {
                    b.f9062e.notify();
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
        a(1);
        return j;
    }

    public void a(int i2) {
        String str;
        String str2;
        synchronized (f9062e) {
            b(i2);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f9062e.wait(2000L);
            } catch (InterruptedException e2) {
                cn.jiguang.ai.a.d("MeizuIdManager", "lock wait err: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                str = "MeizuIdManager";
                str2 = "query timeout";
            } else if (i2 == 0) {
                f9066i = f9065h;
                f9065h = null;
                str = "MeizuIdManager";
                str2 = "query aaid: " + f9066i;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    if (f9065h == null) {
                        str = "MeizuIdManager";
                        str2 = "get ids-aa failed";
                    } else {
                        k = f9065h;
                        f9065h = null;
                        str = "MeizuIdManager";
                        str2 = "query aaid: " + k;
                    }
                }
            } else if (f9065h == null) {
                str = "MeizuIdManager";
                str2 = "get ids-va failed";
            } else {
                j = f9065h;
                f9065h = null;
                str = "MeizuIdManager";
                str2 = "query aaid: " + j;
            }
            cn.jiguang.ai.a.a(str, str2);
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
        a(2);
        return k;
    }

    public boolean b() {
        return f9059b;
    }

    public String c() {
        if (!b()) {
            return null;
        }
        String str = f9066i;
        if (str != null) {
            return str;
        }
        a(0);
        return f9066i;
    }
}
