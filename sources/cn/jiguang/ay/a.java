package cn.jiguang.ay;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public C0136a[] f8488a = new C0136a[17];

    /* renamed from: cn.jiguang.ay.a$a, reason: collision with other inner class name */
    public static class C0136a {

        /* renamed from: a, reason: collision with root package name */
        public g f8489a;

        /* renamed from: b, reason: collision with root package name */
        public int f8490b;

        /* renamed from: c, reason: collision with root package name */
        public C0136a f8491c;

        public C0136a() {
        }
    }

    public int a(g gVar) {
        int i2 = -1;
        for (C0136a c0136a = this.f8488a[(gVar.hashCode() & Integer.MAX_VALUE) % 17]; c0136a != null; c0136a = c0136a.f8491c) {
            if (c0136a.f8489a.equals(gVar)) {
                i2 = c0136a.f8490b;
            }
        }
        return i2;
    }

    public void a(int i2, g gVar) {
        if (i2 > 16383) {
            return;
        }
        int hashCode = (gVar.hashCode() & Integer.MAX_VALUE) % 17;
        C0136a c0136a = new C0136a();
        c0136a.f8489a = gVar;
        c0136a.f8490b = i2;
        C0136a[] c0136aArr = this.f8488a;
        c0136a.f8491c = c0136aArr[hashCode];
        c0136aArr[hashCode] = c0136a;
    }
}
