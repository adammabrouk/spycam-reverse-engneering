package c.k.d;

/* loaded from: classes.dex */
public class a0 implements d0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f6947a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6948b;

    public a0(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f6947a = str;
        this.f6948b = str2;
    }

    @Override // c.k.d.d0
    public String a() {
        return this.f6947a;
    }

    @Override // c.k.d.d0
    public String b() {
        return this.f6948b;
    }
}
