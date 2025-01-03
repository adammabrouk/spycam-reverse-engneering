package c.c.a.b.f.e;

import com.google.zxing.view.ViewfinderView;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class q7 {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f4374a = Logger.getLogger(q7.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Unsafe f4375b = c();

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f4376c = h3.b();

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f4377d = d(Long.TYPE);

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f4378e = d(Integer.TYPE);

    /* renamed from: f, reason: collision with root package name */
    public static final d f4379f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f4380g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f4381h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f4382i;
    public static final boolean j;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final byte a(Object obj, long j) {
            return this.f4383a.getByte(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final boolean b(Object obj, long j) {
            return this.f4383a.getBoolean(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final float c(Object obj, long j) {
            return this.f4383a.getFloat(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final double d(Object obj, long j) {
            return this.f4383a.getDouble(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, byte b2) {
            this.f4383a.putByte(obj, j, b2);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, boolean z) {
            this.f4383a.putBoolean(obj, j, z);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, float f2) {
            this.f4383a.putFloat(obj, j, f2);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, double d2) {
            this.f4383a.putDouble(obj, j, d2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        public Unsafe f4383a;

        public d(Unsafe unsafe) {
            this.f4383a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(Object obj, long j, byte b2);

        public abstract void a(Object obj, long j, double d2);

        public abstract void a(Object obj, long j, float f2);

        public final void a(Object obj, long j, int i2) {
            this.f4383a.putInt(obj, j, i2);
        }

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f4383a.getInt(obj, j);
        }

        public final long f(Object obj, long j) {
            return this.f4383a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f4383a.putLong(obj, j, j2);
        }
    }

    static {
        d dVar;
        d dVar2 = null;
        if (f4375b != null) {
            if (!h3.a()) {
                dVar2 = new b(f4375b);
            } else if (f4377d) {
                dVar2 = new c(f4375b);
            } else if (f4378e) {
                dVar2 = new a(f4375b);
            }
        }
        f4379f = dVar2;
        f4380g = e();
        f4381h = d();
        f4382i = b(byte[].class);
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(long[].class);
        c(long[].class);
        b(float[].class);
        c(float[].class);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        Field f2 = f();
        if (f2 != null && (dVar = f4379f) != null) {
            dVar.f4383a.objectFieldOffset(f2);
        }
        j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static boolean a() {
        return f4381h;
    }

    public static boolean b() {
        return f4380g;
    }

    public static int c(Class<?> cls) {
        if (f4381h) {
            return f4379f.f4383a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float d(Object obj, long j2) {
        return f4379f.c(obj, j2);
    }

    public static double e(Object obj, long j2) {
        return f4379f.d(obj, j2);
    }

    public static Object f(Object obj, long j2) {
        return f4379f.f4383a.getObject(obj, j2);
    }

    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3)));
    }

    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f4375b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int b(Class<?> cls) {
        if (f4381h) {
            return f4379f.f4383a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static boolean d() {
        Unsafe unsafe = f4375b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (h3.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f4374a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    public static boolean e() {
        Unsafe unsafe = f4375b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (f() == null) {
                return false;
            }
            if (h3.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = f4374a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final byte a(Object obj, long j) {
            return q7.j ? q7.k(obj, j) : q7.l(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final boolean b(Object obj, long j) {
            return q7.j ? q7.m(obj, j) : q7.n(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, byte b2) {
            if (!q7.j) {
                q7.d(obj, j, b2);
            } else {
                q7.c(obj, j, b2);
            }
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, boolean z) {
            if (q7.j) {
                q7.d(obj, j, z);
            } else {
                q7.e(obj, j, z);
            }
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final byte a(Object obj, long j) {
            return q7.j ? q7.k(obj, j) : q7.l(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final boolean b(Object obj, long j) {
            return q7.j ? q7.m(obj, j) : q7.n(obj, j);
        }

        @Override // c.c.a.b.f.e.q7.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, byte b2) {
            if (!q7.j) {
                q7.d(obj, j, b2);
            } else {
                q7.c(obj, j, b2);
            }
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, boolean z) {
            if (q7.j) {
                q7.d(obj, j, z);
            } else {
                q7.e(obj, j, z);
            }
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, float f2) {
            a(obj, j, Float.floatToIntBits(f2));
        }

        @Override // c.c.a.b.f.e.q7.d
        public final void a(Object obj, long j, double d2) {
            a(obj, j, Double.doubleToLongBits(d2));
        }
    }

    public static boolean c(Object obj, long j2) {
        return f4379f.b(obj, j2);
    }

    public static Field f() {
        Field a2;
        if (h3.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    public static int a(Object obj, long j2) {
        return f4379f.e(obj, j2);
    }

    public static long b(Object obj, long j2) {
        return f4379f.f(obj, j2);
    }

    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new s7());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Object obj, long j2, int i2) {
        f4379f.a(obj, j2, i2);
    }

    public static void a(Object obj, long j2, long j3) {
        f4379f.a(obj, j2, j3);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((ViewfinderView.OPAQUE << i2) ^ (-1))));
    }

    public static void a(Object obj, long j2, boolean z) {
        f4379f.a(obj, j2, z);
    }

    public static void a(Object obj, long j2, float f2) {
        f4379f.a(obj, j2, f2);
    }

    public static void a(Object obj, long j2, double d2) {
        f4379f.a(obj, j2, d2);
    }

    public static void a(Object obj, long j2, Object obj2) {
        f4379f.f4383a.putObject(obj, j2, obj2);
    }

    public static byte a(byte[] bArr, long j2) {
        return f4379f.a(bArr, f4382i + j2);
    }

    public static void a(byte[] bArr, long j2, byte b2) {
        f4379f.a((Object) bArr, f4382i + j2, b2);
    }

    public static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static boolean d(Class<?> cls) {
        if (!h3.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f4376c;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((ViewfinderView.OPAQUE << i2) ^ (-1))));
    }

    public static void d(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : (byte) 0);
    }
}
