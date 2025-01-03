package cn.jiguang.az;

/* loaded from: classes.dex */
public class f extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f8564a;

    public f(int i2, String str) {
        super(str);
        this.f8564a = i2;
    }

    public int a() {
        return this.f8564a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.f8564a + "):" + getLocalizedMessage();
    }
}
