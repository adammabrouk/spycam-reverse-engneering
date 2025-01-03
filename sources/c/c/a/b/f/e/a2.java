package c.c.a.b.f.e;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class a2<T> {

    /* renamed from: g, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Context f4066g;

    /* renamed from: h, reason: collision with root package name */
    public static p2<o2<w1>> f4067h;

    /* renamed from: a, reason: collision with root package name */
    public final g2 f4069a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4070b;

    /* renamed from: c, reason: collision with root package name */
    public final T f4071c;

    /* renamed from: d, reason: collision with root package name */
    public volatile int f4072d;

    /* renamed from: e, reason: collision with root package name */
    public volatile T f4073e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f4065f = new Object();

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f4068i = new AtomicInteger();

    public a2(g2 g2Var, String str, T t, boolean z) {
        this.f4072d = -1;
        if (g2Var.f4184a == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.f4069a = g2Var;
        this.f4070b = str;
        this.f4071c = t;
    }

    public static void a(Context context) {
        synchronized (f4065f) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (f4066g != context) {
                m1.e();
                j2.a();
                v1.a();
                f4068i.incrementAndGet();
                f4066g = context;
                f4067h = s2.a(d2.f4130a);
            }
        }
    }

    public static void c() {
        f4068i.incrementAndGet();
    }

    public static final /* synthetic */ o2 d() {
        new z1();
        return z1.a(f4066g);
    }

    public abstract T a(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[Catch: all -> 0x00f5, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0023, B:16:0x0035, B:18:0x003b, B:20:0x0047, B:22:0x0060, B:24:0x006a, B:27:0x00bb, B:29:0x00c9, B:31:0x00df, B:32:0x00e2, B:33:0x00e6, B:34:0x009c, B:36:0x00b0, B:39:0x00b9, B:43:0x0058, B:44:0x006f, B:46:0x0078, B:48:0x008a, B:49:0x0095, B:50:0x008f, B:52:0x00eb, B:53:0x00f2, B:55:0x00f3), top: B:4:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[Catch: all -> 0x00f5, TryCatch #0 {, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0013, B:11:0x0023, B:16:0x0035, B:18:0x003b, B:20:0x0047, B:22:0x0060, B:24:0x006a, B:27:0x00bb, B:29:0x00c9, B:31:0x00df, B:32:0x00e2, B:33:0x00e6, B:34:0x009c, B:36:0x00b0, B:39:0x00b9, B:43:0x0058, B:44:0x006f, B:46:0x0078, B:48:0x008a, B:49:0x0095, B:50:0x008f, B:52:0x00eb, B:53:0x00f2, B:55:0x00f3), top: B:4:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final T b() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.a2.b():java.lang.Object");
    }

    public /* synthetic */ a2(g2 g2Var, String str, Object obj, boolean z, c2 c2Var) {
        this(g2Var, str, obj, z);
    }

    public final String a(String str) {
        if (str != null && str.isEmpty()) {
            return this.f4070b;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf(this.f4070b);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final String a() {
        return a(this.f4069a.f4186c);
    }

    public static a2<Long> b(g2 g2Var, String str, long j, boolean z) {
        return new c2(g2Var, str, Long.valueOf(j), false);
    }

    public static a2<Boolean> b(g2 g2Var, String str, boolean z, boolean z2) {
        return new f2(g2Var, str, Boolean.valueOf(z), false);
    }

    public static a2<Double> b(g2 g2Var, String str, double d2, boolean z) {
        return new e2(g2Var, str, Double.valueOf(d2), false);
    }

    public static a2<String> b(g2 g2Var, String str, String str2, boolean z) {
        return new h2(g2Var, str, str2, false);
    }
}
