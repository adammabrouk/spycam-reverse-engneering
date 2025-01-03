package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class s5 implements a6 {

    /* renamed from: a, reason: collision with root package name */
    public a6[] f4428a;

    public s5(a6... a6VarArr) {
        this.f4428a = a6VarArr;
    }

    @Override // c.c.a.b.f.e.a6
    public final boolean a(Class<?> cls) {
        for (a6 a6Var : this.f4428a) {
            if (a6Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // c.c.a.b.f.e.a6
    public final b6 b(Class<?> cls) {
        for (a6 a6Var : this.f4428a) {
            if (a6Var.a(cls)) {
                return a6Var.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
