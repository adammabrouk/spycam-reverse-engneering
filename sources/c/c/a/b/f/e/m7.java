package c.c.a.b.f.e;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class m7 extends k7<n7, n7> {
    /* renamed from: a, reason: avoid collision after fix types in other method */
    public static void a2(Object obj, n7 n7Var) {
        ((s4) obj).zzb = n7Var;
    }

    @Override // c.c.a.b.f.e.k7
    public final void b(Object obj) {
        ((s4) obj).zzb.a();
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ int c(n7 n7Var) {
        return n7Var.b();
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ int d(n7 n7Var) {
        return n7Var.c();
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ void a(n7 n7Var, h8 h8Var) throws IOException {
        n7Var.b(h8Var);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ void b(n7 n7Var, h8 h8Var) throws IOException {
        n7Var.a(h8Var);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ n7 c(n7 n7Var, n7 n7Var2) {
        n7 n7Var3 = n7Var;
        n7 n7Var4 = n7Var2;
        return n7Var4.equals(n7.d()) ? n7Var3 : n7.a(n7Var3, n7Var4);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ n7 a(Object obj) {
        return ((s4) obj).zzb;
    }

    @Override // c.c.a.b.f.e.k7
    public final /* bridge */ /* synthetic */ void a(Object obj, n7 n7Var) {
        a2(obj, n7Var);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ void b(Object obj, n7 n7Var) {
        a2(obj, n7Var);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ n7 a() {
        return n7.e();
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ void a(n7 n7Var, int i2, k3 k3Var) {
        n7Var.a((i2 << 3) | 2, k3Var);
    }

    @Override // c.c.a.b.f.e.k7
    public final /* synthetic */ void a(n7 n7Var, int i2, long j) {
        n7Var.a(i2 << 3, Long.valueOf(j));
    }
}
