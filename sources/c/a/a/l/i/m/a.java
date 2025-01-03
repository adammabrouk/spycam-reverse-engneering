package c.a.a.l.i.m;

import android.graphics.Bitmap;

/* compiled from: AttributeStrategy.java */
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public final b f3121a = new b();

    /* renamed from: b, reason: collision with root package name */
    public final e<C0066a, Bitmap> f3122b = new e<>();

    /* compiled from: AttributeStrategy.java */
    public static class b extends c.a.a.l.i.m.b<C0066a> {
        public C0066a a(int i2, int i3, Bitmap.Config config) {
            C0066a b2 = b();
            b2.a(i2, i3, config);
            return b2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.a.l.i.m.b
        public C0066a a() {
            return new C0066a(this);
        }
    }

    public static String d(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // c.a.a.l.i.m.g
    public void a(Bitmap bitmap) {
        this.f3122b.a(this.f3121a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // c.a.a.l.i.m.g
    public String b(int i2, int i3, Bitmap.Config config) {
        return d(i2, i3, config);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f3122b;
    }

    public static String d(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    @Override // c.a.a.l.i.m.g
    public int b(Bitmap bitmap) {
        return c.a.a.r.h.a(bitmap);
    }

    @Override // c.a.a.l.i.m.g
    public String c(Bitmap bitmap) {
        return d(bitmap);
    }

    /* compiled from: AttributeStrategy.java */
    /* renamed from: c.a.a.l.i.m.a$a, reason: collision with other inner class name */
    public static class C0066a implements h {

        /* renamed from: a, reason: collision with root package name */
        public final b f3123a;

        /* renamed from: b, reason: collision with root package name */
        public int f3124b;

        /* renamed from: c, reason: collision with root package name */
        public int f3125c;

        /* renamed from: d, reason: collision with root package name */
        public Bitmap.Config f3126d;

        public C0066a(b bVar) {
            this.f3123a = bVar;
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.f3124b = i2;
            this.f3125c = i3;
            this.f3126d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0066a)) {
                return false;
            }
            C0066a c0066a = (C0066a) obj;
            return this.f3124b == c0066a.f3124b && this.f3125c == c0066a.f3125c && this.f3126d == c0066a.f3126d;
        }

        public int hashCode() {
            int i2 = ((this.f3124b * 31) + this.f3125c) * 31;
            Bitmap.Config config = this.f3126d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return a.d(this.f3124b, this.f3125c, this.f3126d);
        }

        @Override // c.a.a.l.i.m.h
        public void a() {
            this.f3123a.a(this);
        }
    }

    @Override // c.a.a.l.i.m.g
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f3122b.a((e<C0066a, Bitmap>) this.f3121a.a(i2, i3, config));
    }

    @Override // c.a.a.l.i.m.g
    public Bitmap a() {
        return this.f3122b.a();
    }
}
