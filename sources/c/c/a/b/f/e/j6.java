package c.c.a.b.f.e;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class j6<T> implements t6<T> {

    /* renamed from: a, reason: collision with root package name */
    public final d6 f4242a;

    /* renamed from: b, reason: collision with root package name */
    public final k7<?, ?> f4243b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4244c;

    /* renamed from: d, reason: collision with root package name */
    public final g4<?> f4245d;

    public j6(k7<?, ?> k7Var, g4<?> g4Var, d6 d6Var) {
        this.f4243b = k7Var;
        this.f4244c = g4Var.a(d6Var);
        this.f4245d = g4Var;
        this.f4242a = d6Var;
    }

    public static <T> j6<T> a(k7<?, ?> k7Var, g4<?> g4Var, d6 d6Var) {
        return new j6<>(k7Var, g4Var, d6Var);
    }

    @Override // c.c.a.b.f.e.t6
    public final void b(T t, T t2) {
        u6.a(this.f4243b, t, t2);
        if (this.f4244c) {
            u6.a(this.f4245d, t, t2);
        }
    }

    @Override // c.c.a.b.f.e.t6
    public final void c(T t) {
        this.f4243b.b(t);
        this.f4245d.c(t);
    }

    @Override // c.c.a.b.f.e.t6
    public final int d(T t) {
        k7<?, ?> k7Var = this.f4243b;
        int c2 = k7Var.c(k7Var.a(t)) + 0;
        return this.f4244c ? c2 + this.f4245d.a(t).f() : c2;
    }

    @Override // c.c.a.b.f.e.t6
    public final T zza() {
        return (T) this.f4242a.a().H();
    }

    @Override // c.c.a.b.f.e.t6
    public final boolean a(T t, T t2) {
        if (!this.f4243b.a(t).equals(this.f4243b.a(t2))) {
            return false;
        }
        if (this.f4244c) {
            return this.f4245d.a(t).equals(this.f4245d.a(t2));
        }
        return true;
    }

    @Override // c.c.a.b.f.e.t6
    public final boolean b(T t) {
        return this.f4245d.a(t).e();
    }

    @Override // c.c.a.b.f.e.t6
    public final int a(T t) {
        int hashCode = this.f4243b.a(t).hashCode();
        return this.f4244c ? (hashCode * 53) + this.f4245d.a(t).hashCode() : hashCode;
    }

    @Override // c.c.a.b.f.e.t6
    public final void a(T t, h8 h8Var) throws IOException {
        Iterator<Map.Entry<?, Object>> c2 = this.f4245d.a(t).c();
        while (c2.hasNext()) {
            Map.Entry<?, Object> next = c2.next();
            n4 n4Var = (n4) next.getKey();
            if (n4Var.C() == e8.MESSAGE && !n4Var.D() && !n4Var.E()) {
                if (next instanceof f5) {
                    h8Var.a(n4Var.zza(), (Object) ((f5) next).a().b());
                } else {
                    h8Var.a(n4Var.zza(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        k7<?, ?> k7Var = this.f4243b;
        k7Var.b((k7<?, ?>) k7Var.a(t), h8Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // c.c.a.b.f.e.t6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(T r10, byte[] r11, int r12, int r13, c.c.a.b.f.e.j3 r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            c.c.a.b.f.e.s4 r0 = (c.c.a.b.f.e.s4) r0
            c.c.a.b.f.e.n7 r1 = r0.zzb
            c.c.a.b.f.e.n7 r2 = c.c.a.b.f.e.n7.d()
            if (r1 != r2) goto L11
            c.c.a.b.f.e.n7 r1 = c.c.a.b.f.e.n7.e()
            r0.zzb = r1
        L11:
            c.c.a.b.f.e.s4$d r10 = (c.c.a.b.f.e.s4.d) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = c.c.a.b.f.e.g3.a(r11, r12, r14)
            int r2 = r14.f4238a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            c.c.a.b.f.e.g4<?> r12 = r9.f4245d
            c.c.a.b.f.e.e4 r0 = r14.f4241d
            c.c.a.b.f.e.d6 r3 = r9.f4242a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.a(r0, r3, r5)
            r0 = r12
            c.c.a.b.f.e.s4$f r0 = (c.c.a.b.f.e.s4.f) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = c.c.a.b.f.e.g3.a(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            c.c.a.b.f.e.p6.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = c.c.a.b.f.e.g3.a(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = c.c.a.b.f.e.g3.a(r11, r4, r14)
            int r5 = r14.f4238a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = c.c.a.b.f.e.g3.e(r11, r4, r14)
            java.lang.Object r2 = r14.f4240c
            c.c.a.b.f.e.k3 r2 = (c.c.a.b.f.e.k3) r2
            goto L53
        L72:
            c.c.a.b.f.e.p6.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = c.c.a.b.f.e.g3.a(r11, r4, r14)
            int r12 = r14.f4238a
            c.c.a.b.f.e.g4<?> r0 = r9.f4245d
            c.c.a.b.f.e.e4 r5 = r14.f4241d
            c.c.a.b.f.e.d6 r6 = r9.f4242a
            java.lang.Object r0 = r0.a(r5, r6, r12)
            c.c.a.b.f.e.s4$f r0 = (c.c.a.b.f.e.s4.f) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = c.c.a.b.f.e.g3.a(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.a(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            c.c.a.b.f.e.c5 r10 = c.c.a.b.f.e.c5.zzg()
            goto Lad
        Lac:
            throw r10
        Lad:
            goto Lac
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.f.e.j6.a(java.lang.Object, byte[], int, int, c.c.a.b.f.e.j3):void");
    }
}
