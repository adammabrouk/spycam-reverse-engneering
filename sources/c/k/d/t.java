package c.k.d;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.shix.shixipc.utilcode.NetworkUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class t implements s, InvocationHandler {
    public static final String[][] o = {new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    public Context j;

    /* renamed from: a, reason: collision with root package name */
    public Class f7858a = null;

    /* renamed from: b, reason: collision with root package name */
    public Class f7859b = null;

    /* renamed from: c, reason: collision with root package name */
    public Method f7860c = null;

    /* renamed from: d, reason: collision with root package name */
    public Method f7861d = null;

    /* renamed from: e, reason: collision with root package name */
    public Method f7862e = null;

    /* renamed from: f, reason: collision with root package name */
    public Method f7863f = null;

    /* renamed from: g, reason: collision with root package name */
    public Method f7864g = null;

    /* renamed from: h, reason: collision with root package name */
    public Method f7865h = null;

    /* renamed from: i, reason: collision with root package name */
    public Method f7866i = null;
    public final Object k = new Object();
    public volatile int l = 0;
    public volatile long m = 0;
    public volatile a n = null;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public Boolean f7867a;

        /* renamed from: b, reason: collision with root package name */
        public String f7868b;

        /* renamed from: c, reason: collision with root package name */
        public String f7869c;

        /* renamed from: d, reason: collision with root package name */
        public String f7870d;

        /* renamed from: e, reason: collision with root package name */
        public String f7871e;

        public a(t tVar) {
            this.f7867a = null;
            this.f7868b = null;
            this.f7869c = null;
            this.f7870d = null;
            this.f7871e = null;
        }

        public boolean a() {
            if (!TextUtils.isEmpty(this.f7868b) || !TextUtils.isEmpty(this.f7869c) || !TextUtils.isEmpty(this.f7870d) || !TextUtils.isEmpty(this.f7871e)) {
                this.f7867a = true;
            }
            return this.f7867a != null;
        }
    }

    public t(Context context) {
        this.j = context.getApplicationContext();
        a(context);
        b(context);
    }

    public static Class<?> a(Context context, String str) {
        try {
            return q9.a(context, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T> T a(Method method, Object obj, Object... objArr) {
        if (method == null) {
            return null;
        }
        try {
            T t = (T) method.invoke(obj, objArr);
            if (t != null) {
                return t;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(Object obj) {
        return (obj instanceof Boolean) || (obj instanceof Character) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double);
    }

    public static void b(String str) {
        c.k.a.a.a.c.m6a("mdid:" + str);
    }

    @Override // c.k.d.s
    public String a() {
        a("getUDID");
        if (this.n == null) {
            return null;
        }
        return this.n.f7868b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m478a() {
        synchronized (this.k) {
            try {
                this.k.notifyAll();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(Context context) {
        Class<?> a2 = a(context, "com.bun.miitmdid.core.MdidSdk");
        Class<?> cls = null;
        Class<?> cls2 = null;
        int i2 = 0;
        while (true) {
            String[][] strArr = o;
            if (i2 >= strArr.length) {
                break;
            }
            String[] strArr2 = strArr[i2];
            Class<?> a3 = a(context, strArr2[0]);
            Class<?> a4 = a(context, strArr2[1]);
            if (a3 != null && a4 != null) {
                b("found class in index " + i2);
                cls2 = a4;
                cls = a3;
                break;
            }
            i2++;
            cls2 = a4;
            cls = a3;
        }
        this.f7858a = a2;
        this.f7860c = a(a2, "InitSdk", (Class<?>[]) new Class[]{Context.class, cls});
        this.f7859b = cls;
        this.f7861d = a(cls2, "getUDID", (Class<?>[]) new Class[0]);
        this.f7862e = a(cls2, "getOAID", (Class<?>[]) new Class[0]);
        this.f7863f = a(cls2, "getVAID", (Class<?>[]) new Class[0]);
        this.f7864g = a(cls2, "getAAID", (Class<?>[]) new Class[0]);
        this.f7865h = a(cls2, "isSupported", (Class<?>[]) new Class[0]);
        this.f7866i = a(cls2, "shutDown", (Class<?>[]) new Class[0]);
    }

    public final void a(String str) {
        if (this.n != null) {
            return;
        }
        long j = this.m;
        long elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
        int i2 = this.l;
        if (elapsedRealtime > NetworkUtils.SCAN_PERIOD_MILLIS && i2 < 3) {
            synchronized (this.k) {
                if (this.m == j && this.l == i2) {
                    b("retry, current count is " + i2);
                    this.l = this.l + 1;
                    b(this.j);
                    j = this.m;
                    elapsedRealtime = SystemClock.elapsedRealtime() - Math.abs(j);
                }
            }
        }
        if (this.n != null || j < 0 || elapsedRealtime > NetworkUtils.SCAN_PERIOD_MILLIS || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.k) {
            if (this.n == null) {
                try {
                    b(str + " wait...");
                    this.k.wait(NetworkUtils.SCAN_PERIOD_MILLIS);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // c.k.d.s
    /* renamed from: a */
    public boolean mo415a() {
        a("isSupported");
        return this.n != null && Boolean.TRUE.equals(this.n.f7867a);
    }

    @Override // c.k.d.s
    public String b() {
        a("getOAID");
        if (this.n == null) {
            return null;
        }
        return this.n.f7869c;
    }

    public final void b(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = -elapsedRealtime;
        Class cls = this.f7859b;
        if (cls != null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                if (classLoader == null) {
                    classLoader = context.getClassLoader();
                }
                a(this.f7860c, this.f7858a.newInstance(), context, Proxy.newProxyInstance(classLoader, new Class[]{this.f7859b}, this));
            } catch (Throwable th) {
                b("call init sdk error:" + th);
            }
            this.m = elapsedRealtime;
        }
        elapsedRealtime = j;
        this.m = elapsedRealtime;
    }

    @Override // c.k.d.s
    public String c() {
        a("getVAID");
        if (this.n == null) {
            return null;
        }
        return this.n.f7870d;
    }

    @Override // c.k.d.s
    public String d() {
        a("getAAID");
        if (this.n == null) {
            return null;
        }
        return this.n.f7871e;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        this.m = SystemClock.elapsedRealtime();
        if (objArr != null) {
            a aVar = new a();
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Object obj2 = objArr[i2];
                if (obj2 != null && !a(obj2)) {
                    aVar.f7868b = (String) a(this.f7861d, obj2, new Object[0]);
                    aVar.f7869c = (String) a(this.f7862e, obj2, new Object[0]);
                    aVar.f7870d = (String) a(this.f7863f, obj2, new Object[0]);
                    aVar.f7871e = (String) a(this.f7864g, obj2, new Object[0]);
                    aVar.f7867a = (Boolean) a(this.f7865h, obj2, new Object[0]);
                    a(this.f7866i, obj2, new Object[0]);
                    if (aVar.a()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("has get succ, check duplicate:");
                        sb.append(this.n != null);
                        b(sb.toString());
                        synchronized (t.class) {
                            if (this.n == null) {
                                this.n = aVar;
                            }
                        }
                    }
                }
                i2++;
            }
        }
        m478a();
        return null;
    }
}
