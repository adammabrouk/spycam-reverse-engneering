package c.c.a.a.j.w.k;

import c.c.a.a.j.w.k.d;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: b, reason: collision with root package name */
    public final long f3716b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3717c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3718d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3719e;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b extends d.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f3720a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f3721b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f3722c;

        /* renamed from: d, reason: collision with root package name */
        public Long f3723d;

        @Override // c.c.a.a.j.w.k.d.a
        public d.a a(int i2) {
            this.f3722c = Integer.valueOf(i2);
            return this;
        }

        @Override // c.c.a.a.j.w.k.d.a
        public d.a b(long j) {
            this.f3720a = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.w.k.d.a
        public d.a a(long j) {
            this.f3723d = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.w.k.d.a
        public d.a b(int i2) {
            this.f3721b = Integer.valueOf(i2);
            return this;
        }

        @Override // c.c.a.a.j.w.k.d.a
        public d a() {
            String str = "";
            if (this.f3720a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f3721b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f3722c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f3723d == null) {
                str = str + " eventCleanUpAge";
            }
            if (str.isEmpty()) {
                return new a(this.f3720a.longValue(), this.f3721b.intValue(), this.f3722c.intValue(), this.f3723d.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // c.c.a.a.j.w.k.d
    public int a() {
        return this.f3718d;
    }

    @Override // c.c.a.a.j.w.k.d
    public long b() {
        return this.f3719e;
    }

    @Override // c.c.a.a.j.w.k.d
    public int c() {
        return this.f3717c;
    }

    @Override // c.c.a.a.j.w.k.d
    public long d() {
        return this.f3716b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3716b == dVar.d() && this.f3717c == dVar.c() && this.f3718d == dVar.a() && this.f3719e == dVar.b();
    }

    public int hashCode() {
        long j = this.f3716b;
        int i2 = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f3717c) * 1000003) ^ this.f3718d) * 1000003;
        long j2 = this.f3719e;
        return ((int) (j2 ^ (j2 >>> 32))) ^ i2;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f3716b + ", loadBatchSize=" + this.f3717c + ", criticalSectionEnterTimeoutMs=" + this.f3718d + ", eventCleanUpAge=" + this.f3719e + "}";
    }

    public a(long j, int i2, int i3, long j2) {
        this.f3716b = j;
        this.f3717c = i2;
        this.f3718d = i3;
        this.f3719e = j2;
    }
}
