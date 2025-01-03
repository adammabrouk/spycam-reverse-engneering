package f;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes.dex */
public final class b implements Comparable<b> {

    /* renamed from: e, reason: collision with root package name */
    public static final b f11314e;

    /* renamed from: a, reason: collision with root package name */
    public final int f11315a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11316b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11317c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11318d;

    /* compiled from: KotlinVersion.kt */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f.j.b.d dVar) {
            this();
        }
    }

    static {
        new a(null);
        f11314e = c.a();
    }

    public b(int i2, int i3, int i4) {
        this.f11316b = i2;
        this.f11317c = i3;
        this.f11318d = i4;
        this.f11315a = a(i2, i3, i4);
    }

    public final int a(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            obj = null;
        }
        b bVar = (b) obj;
        return bVar != null && this.f11315a == bVar.f11315a;
    }

    public int hashCode() {
        return this.f11315a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11316b);
        sb.append('.');
        sb.append(this.f11317c);
        sb.append('.');
        sb.append(this.f11318d);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        f.j.b.f.c(bVar, "other");
        return this.f11315a - bVar.f11315a;
    }
}
