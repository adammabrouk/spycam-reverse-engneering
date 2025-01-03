package c.k.a.a.a;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f6745a = 2;

    /* renamed from: b, reason: collision with root package name */
    public static a f6746b = new b();

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, Long> f6747c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<Integer, String> f6748d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static final Integer f6749e = -1;

    /* renamed from: f, reason: collision with root package name */
    public static AtomicInteger f6750f = new AtomicInteger(1);

    public static int a() {
        return f6745a;
    }

    public static Integer a(String str) {
        if (f6745a > 1) {
            return f6749e;
        }
        Integer valueOf = Integer.valueOf(f6750f.incrementAndGet());
        f6747c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f6748d.put(valueOf, str);
        f6746b.a(str + " starts");
        return valueOf;
    }

    public static void a(int i2) {
        if (i2 < 0 || i2 > 5) {
            a(2, "set log level as " + i2);
        }
        f6745a = i2;
    }

    public static void a(int i2, String str) {
        if (i2 >= f6745a) {
            f6746b.a(str);
        }
    }

    public static void a(int i2, String str, Throwable th) {
        if (i2 >= f6745a) {
            f6746b.a(str, th);
        }
    }

    public static void a(int i2, Throwable th) {
        if (i2 >= f6745a) {
            f6746b.a("", th);
        }
    }

    public static void a(a aVar) {
        f6746b = aVar;
    }

    public static void a(Integer num) {
        if (f6745a > 1 || !f6747c.containsKey(num)) {
            return;
        }
        long longValue = f6747c.remove(num).longValue();
        String remove = f6748d.remove(num);
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        f6746b.a(remove + " ends in " + currentTimeMillis + " ms");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m6a(String str) {
        a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void a(String str, Throwable th) {
        a(4, str, th);
    }

    public static void a(Throwable th) {
        a(4, th);
    }

    public static void b(String str) {
        a(0, str);
    }

    public static void c(String str) {
        a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    public static void d(String str) {
        a(4, str);
    }
}
