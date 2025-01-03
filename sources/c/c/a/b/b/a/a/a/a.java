package c.c.a.b.b.a.a.a;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static int f3796b = 31;

    /* renamed from: a, reason: collision with root package name */
    public int f3797a = 1;

    public a a(Object obj) {
        this.f3797a = (f3796b * this.f3797a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public final a a(boolean z) {
        this.f3797a = (f3796b * this.f3797a) + (z ? 1 : 0);
        return this;
    }

    public int a() {
        return this.f3797a;
    }
}
