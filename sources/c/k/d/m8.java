package c.k.d;

/* loaded from: classes.dex */
public class m8 {

    /* renamed from: a, reason: collision with root package name */
    public final t8 f7400a;

    /* renamed from: b, reason: collision with root package name */
    public final c9 f7401b;

    public m8(v8 v8Var) {
        c9 c9Var = new c9();
        this.f7401b = c9Var;
        this.f7400a = v8Var.a(c9Var);
    }

    public void a(i8 i8Var, byte[] bArr) {
        try {
            this.f7401b.a(bArr);
            i8Var.a(this.f7400a);
        } finally {
            this.f7400a.k();
        }
    }
}
