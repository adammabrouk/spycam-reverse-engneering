package c.k.d;

/* loaded from: classes.dex */
public class l2 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile l2 f7335b;

    /* renamed from: a, reason: collision with root package name */
    public k2 f7336a;

    public static l2 a() {
        if (f7335b == null) {
            synchronized (l2.class) {
                if (f7335b == null) {
                    f7335b = new l2();
                }
            }
        }
        return f7335b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public k2 m271a() {
        return this.f7336a;
    }

    public void a(k2 k2Var) {
        this.f7336a = k2Var;
    }
}
