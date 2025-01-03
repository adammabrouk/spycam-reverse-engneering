package c.c.a.b.g.b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f4914a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4915b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4916c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4917d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4918e;

    /* renamed from: f, reason: collision with root package name */
    public final long f4919f;

    /* renamed from: g, reason: collision with root package name */
    public final long f4920g;

    /* renamed from: h, reason: collision with root package name */
    public final Long f4921h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f4922i;
    public final Long j;
    public final Boolean k;

    public m(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.b(str2);
        c.c.a.b.c.o.r.a(j >= 0);
        c.c.a.b.c.o.r.a(j2 >= 0);
        c.c.a.b.c.o.r.a(j3 >= 0);
        c.c.a.b.c.o.r.a(j5 >= 0);
        this.f4914a = str;
        this.f4915b = str2;
        this.f4916c = j;
        this.f4917d = j2;
        this.f4918e = j3;
        this.f4919f = j4;
        this.f4920g = j5;
        this.f4921h = l;
        this.f4922i = l2;
        this.j = l3;
        this.k = bool;
    }

    public final m a(long j) {
        return new m(this.f4914a, this.f4915b, this.f4916c, this.f4917d, this.f4918e, j, this.f4920g, this.f4921h, this.f4922i, this.j, this.k);
    }

    public final m a(long j, long j2) {
        return new m(this.f4914a, this.f4915b, this.f4916c, this.f4917d, this.f4918e, this.f4919f, j, Long.valueOf(j2), this.f4922i, this.j, this.k);
    }

    public final m a(Long l, Long l2, Boolean bool) {
        return new m(this.f4914a, this.f4915b, this.f4916c, this.f4917d, this.f4918e, this.f4919f, this.f4920g, this.f4921h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public m(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, 0L, 0L, 0L, j3, 0L, null, null, null, null);
    }
}
