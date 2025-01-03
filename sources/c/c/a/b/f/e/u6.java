package c.c.a.b.f.e;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class u6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f4464a = d();

    /* renamed from: b, reason: collision with root package name */
    public static final k7<?, ?> f4465b = a(false);

    /* renamed from: c, reason: collision with root package name */
    public static final k7<?, ?> f4466c = a(true);

    /* renamed from: d, reason: collision with root package name */
    public static final k7<?, ?> f4467d = new m7();

    public static void a(Class<?> cls) {
        Class<?> cls2;
        if (!s4.class.isAssignableFrom(cls) && (cls2 = f4464a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void b(int i2, List<Float> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.l(i2, list, z);
    }

    public static void c(int i2, List<Long> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.h(i2, list, z);
    }

    public static void d(int i2, List<Long> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.e(i2, list, z);
    }

    public static void e(int i2, List<Long> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.c(i2, list, z);
    }

    public static void f(int i2, List<Long> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.a(i2, list, z);
    }

    public static void g(int i2, List<Long> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.j(i2, list, z);
    }

    public static void h(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.d(i2, list, z);
    }

    public static void i(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.m(i2, list, z);
    }

    public static void j(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.g(i2, list, z);
    }

    public static void k(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.k(i2, list, z);
    }

    public static void l(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.n(i2, list, z);
    }

    public static void m(int i2, List<Integer> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.f(i2, list, z);
    }

    public static void n(int i2, List<Boolean> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.b(i2, list, z);
    }

    public static void b(int i2, List<k3> list, h8 h8Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.a(i2, list);
    }

    public static int c(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.f(r5Var.zzb(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.f(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v4) {
            v4 v4Var = (v4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.k(v4Var.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.k(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int e(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v4) {
            v4 v4Var = (v4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.f(v4Var.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.f(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int f(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v4) {
            v4 v4Var = (v4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.g(v4Var.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.g(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int g(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v4) {
            v4 v4Var = (v4) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.h(v4Var.zzc(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.h(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int h(List<?> list) {
        return list.size() << 2;
    }

    public static int i(List<?> list) {
        return list.size() << 3;
    }

    public static int j(List<?> list) {
        return list.size();
    }

    public static void a(int i2, List<Double> list, h8 h8Var, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.i(i2, list, z);
    }

    public static int h(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * b4.i(i2, 0);
    }

    public static int i(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * b4.g(i2, 0L);
    }

    public static int j(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * b4.b(i2, true);
    }

    public static void b(int i2, List<?> list, h8 h8Var, t6 t6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.b(i2, list, t6Var);
    }

    public static void a(int i2, List<String> list, h8 h8Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.b(i2, list);
    }

    public static int b(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.e(r5Var.zzb(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.e(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static void a(int i2, List<?> list, h8 h8Var, t6 t6Var) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        h8Var.a(i2, list, t6Var);
    }

    public static int c(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * b4.e(i2));
    }

    public static int d(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return d(list) + (size * b4.e(i2));
    }

    public static int e(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return e(list) + (size * b4.e(i2));
    }

    public static int f(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return f(list) + (size * b4.e(i2));
    }

    public static int g(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * b4.e(i2));
    }

    public static int a(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof r5) {
            r5 r5Var = (r5) list;
            i2 = 0;
            while (i3 < size) {
                i2 += b4.d(r5Var.zzb(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += b4.d(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static k7<?, ?> c() {
        return f4467d;
    }

    public static Class<?> d() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> e() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int b(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b(list) + (size * b4.e(i2));
    }

    public static int a(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return a(list) + (list.size() * b4.e(i2));
    }

    public static int b(int i2, List<k3> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = size * b4.e(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            e2 += b4.b(list.get(i3));
        }
        return e2;
    }

    public static int a(int i2, List<?> list) {
        int b2;
        int b3;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int e2 = b4.e(i2) * size;
        if (list instanceof k5) {
            k5 k5Var = (k5) list;
            while (i3 < size) {
                Object zzb = k5Var.zzb(i3);
                if (zzb instanceof k3) {
                    b3 = b4.b((k3) zzb);
                } else {
                    b3 = b4.b((String) zzb);
                }
                e2 += b3;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                if (obj instanceof k3) {
                    b2 = b4.b((k3) obj);
                } else {
                    b2 = b4.b((String) obj);
                }
                e2 += b2;
                i3++;
            }
        }
        return e2;
    }

    public static int b(int i2, List<d6> list, t6 t6Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += b4.c(i2, list.get(i4), t6Var);
        }
        return i3;
    }

    public static k7<?, ?> b() {
        return f4466c;
    }

    public static int a(int i2, Object obj, t6 t6Var) {
        if (obj instanceof h5) {
            return b4.a(i2, (h5) obj);
        }
        return b4.b(i2, (d6) obj, t6Var);
    }

    public static int a(int i2, List<?> list, t6 t6Var) {
        int a2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = b4.e(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof h5) {
                a2 = b4.a((h5) obj);
            } else {
                a2 = b4.a((d6) obj, t6Var);
            }
            e2 += a2;
        }
        return e2;
    }

    public static k7<?, ?> a() {
        return f4465b;
    }

    public static k7<?, ?> a(boolean z) {
        try {
            Class<?> e2 = e();
            if (e2 == null) {
                return null;
            }
            return (k7) e2.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> void a(w5 w5Var, T t, T t2, long j) {
        q7.a(t, j, w5Var.a(q7.f(t, j), q7.f(t2, j)));
    }

    public static <T, FT extends n4<FT>> void a(g4<FT> g4Var, T t, T t2) {
        l4<FT> a2 = g4Var.a(t2);
        if (a2.f4277a.isEmpty()) {
            return;
        }
        g4Var.b(t).a(a2);
    }

    public static <T, UT, UB> void a(k7<UT, UB> k7Var, T t, T t2) {
        k7Var.a(t, k7Var.c(k7Var.a(t), k7Var.a(t2)));
    }

    public static <UT, UB> UB a(int i2, List<Integer> list, y4 y4Var, UB ub, k7<UT, UB> k7Var) {
        if (y4Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (y4Var.zza(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    ub = (UB) a(i2, intValue, ub, k7Var);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!y4Var.zza(intValue2)) {
                    ub = (UB) a(i2, intValue2, ub, k7Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB a(int i2, int i3, UB ub, k7<UT, UB> k7Var) {
        if (ub == null) {
            ub = k7Var.a();
        }
        k7Var.a((k7<UT, UB>) ub, i2, i3);
        return ub;
    }
}
