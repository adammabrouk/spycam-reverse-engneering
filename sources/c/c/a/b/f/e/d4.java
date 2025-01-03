package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class d4 implements h8 {

    /* renamed from: a, reason: collision with root package name */
    public final b4 f4131a;

    public d4(b4 b4Var) {
        u4.a(b4Var, "output");
        b4 b4Var2 = b4Var;
        this.f4131a = b4Var2;
        b4Var2.f4084a = this;
    }

    public static d4 a(b4 b4Var) {
        d4 d4Var = b4Var.f4084a;
        return d4Var != null ? d4Var : new d4(b4Var);
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, int i3) throws IOException {
        this.f4131a.b(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void c(int i2, int i3) throws IOException {
        this.f4131a.b(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void d(int i2, int i3) throws IOException {
        this.f4131a.e(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void e(int i2, long j) throws IOException {
        this.f4131a.a(i2, j);
    }

    @Override // c.c.a.b.f.e.h8
    public final void f(int i2, int i3) throws IOException {
        this.f4131a.e(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void g(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.d(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.h(list.get(i5).intValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.c(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void h(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.a(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.d(list.get(i5).longValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.a(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void i(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.a(i2, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.b(list.get(i5).doubleValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.a(list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void j(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.c(i2, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.h(list.get(i5).longValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.c(list.get(i3).longValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void k(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.e(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.i(list.get(i5).intValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.d(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void l(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.a(i2, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.b(list.get(i5).floatValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.a(list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void m(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.c(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.g(list.get(i5).intValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.b(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void n(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                this.f4131a.e(i2, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        this.f4131a.a(i2, 2);
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            i4 += b4.j(list.get(i5).intValue());
        }
        this.f4131a.b(i4);
        while (i3 < list.size()) {
            this.f4131a.d(list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final int zza() {
        return s4.e.k;
    }

    @Override // c.c.a.b.f.e.h8
    public final void zzb(int i2) throws IOException {
        this.f4131a.a(i2, 4);
    }

    @Override // c.c.a.b.f.e.h8
    public final void c(int i2, long j) throws IOException {
        this.f4131a.c(i2, j);
    }

    @Override // c.c.a.b.f.e.h8
    public final void d(int i2, long j) throws IOException {
        this.f4131a.b(i2, j);
    }

    @Override // c.c.a.b.f.e.h8
    public final void zza(int i2) throws IOException {
        this.f4131a.a(i2, 3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, long j) throws IOException {
        this.f4131a.c(i2, j);
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, long j) throws IOException {
        this.f4131a.a(i2, j);
    }

    @Override // c.c.a.b.f.e.h8
    public final void c(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.f(list.get(i5).longValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.b(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.b(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void d(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.f(list.get(i5).intValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void e(int i2, int i3) throws IOException {
        this.f4131a.c(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void f(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.k(list.get(i5).intValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.a(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.b(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, Object obj, t6 t6Var) throws IOException {
        b4 b4Var = this.f4131a;
        b4Var.a(i2, 3);
        t6Var.a((t6) obj, (h8) b4Var.f4084a);
        b4Var.a(i2, 4);
    }

    @Override // c.c.a.b.f.e.h8
    public final void e(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.e(list.get(i5).longValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.a(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.a(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, float f2) throws IOException {
        this.f4131a.a(i2, f2);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, double d2) throws IOException {
        this.f4131a.a(i2, d2);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, boolean z) throws IOException {
        this.f4131a.a(i2, z);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, String str) throws IOException {
        this.f4131a.a(i2, str);
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.b(list.get(i5).booleanValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.a(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.a(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, k3 k3Var) throws IOException {
        this.f4131a.a(i2, k3Var);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, int i3) throws IOException {
        this.f4131a.d(i2, i3);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, Object obj, t6 t6Var) throws IOException {
        this.f4131a.a(i2, (d6) obj, t6Var);
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, Object obj) throws IOException {
        if (obj instanceof k3) {
            this.f4131a.b(i2, (k3) obj);
        } else {
            this.f4131a.a(i2, (d6) obj);
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.f4131a.a(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += b4.g(list.get(i5).longValue());
            }
            this.f4131a.b(i4);
            while (i3 < list.size()) {
                this.f4131a.c(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.c(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof k5) {
            k5 k5Var = (k5) list;
            while (i3 < list.size()) {
                Object zzb = k5Var.zzb(i3);
                if (zzb instanceof String) {
                    this.f4131a.a(i2, (String) zzb);
                } else {
                    this.f4131a.a(i2, (k3) zzb);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.f4131a.a(i2, list.get(i3));
            i3++;
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, List<k3> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f4131a.a(i2, list.get(i3));
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void a(int i2, List<?> list, t6 t6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(i2, list.get(i3), t6Var);
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final void b(int i2, List<?> list, t6 t6Var) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            b(i2, list.get(i3), t6Var);
        }
    }

    @Override // c.c.a.b.f.e.h8
    public final <K, V> void a(int i2, u5<K, V> u5Var, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f4131a.a(i2, 2);
            this.f4131a.b(v5.a(u5Var, entry.getKey(), entry.getValue()));
            v5.a(this.f4131a, u5Var, entry.getKey(), entry.getValue());
        }
    }
}
