package c.c.a.a.j;

import c.c.a.a.j.h;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class a extends h {

    /* renamed from: a, reason: collision with root package name */
    public final String f3548a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f3549b;

    /* renamed from: c, reason: collision with root package name */
    public final g f3550c;

    /* renamed from: d, reason: collision with root package name */
    public final long f3551d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3552e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f3553f;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b extends h.a {

        /* renamed from: a, reason: collision with root package name */
        public String f3554a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f3555b;

        /* renamed from: c, reason: collision with root package name */
        public g f3556c;

        /* renamed from: d, reason: collision with root package name */
        public Long f3557d;

        /* renamed from: e, reason: collision with root package name */
        public Long f3558e;

        /* renamed from: f, reason: collision with root package name */
        public Map<String, String> f3559f;

        @Override // c.c.a.a.j.h.a
        public h.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f3554a = str;
            return this;
        }

        @Override // c.c.a.a.j.h.a
        public h.a b(long j) {
            this.f3558e = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.h.a
        public Map<String, String> b() {
            Map<String, String> map = this.f3559f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // c.c.a.a.j.h.a
        public h.a a(Integer num) {
            this.f3555b = num;
            return this;
        }

        @Override // c.c.a.a.j.h.a
        public h.a a(g gVar) {
            if (gVar != null) {
                this.f3556c = gVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // c.c.a.a.j.h.a
        public h.a a(long j) {
            this.f3557d = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.j.h.a
        public h.a a(Map<String, String> map) {
            if (map != null) {
                this.f3559f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // c.c.a.a.j.h.a
        public h a() {
            String str = "";
            if (this.f3554a == null) {
                str = " transportName";
            }
            if (this.f3556c == null) {
                str = str + " encodedPayload";
            }
            if (this.f3557d == null) {
                str = str + " eventMillis";
            }
            if (this.f3558e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f3559f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new a(this.f3554a, this.f3555b, this.f3556c, this.f3557d.longValue(), this.f3558e.longValue(), this.f3559f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // c.c.a.a.j.h
    public Map<String, String> a() {
        return this.f3553f;
    }

    @Override // c.c.a.a.j.h
    public Integer b() {
        return this.f3549b;
    }

    @Override // c.c.a.a.j.h
    public g c() {
        return this.f3550c;
    }

    @Override // c.c.a.a.j.h
    public long d() {
        return this.f3551d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f3548a.equals(hVar.f()) && ((num = this.f3549b) != null ? num.equals(hVar.b()) : hVar.b() == null) && this.f3550c.equals(hVar.c()) && this.f3551d == hVar.d() && this.f3552e == hVar.g() && this.f3553f.equals(hVar.a());
    }

    @Override // c.c.a.a.j.h
    public String f() {
        return this.f3548a;
    }

    @Override // c.c.a.a.j.h
    public long g() {
        return this.f3552e;
    }

    public int hashCode() {
        int hashCode = (this.f3548a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f3549b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f3550c.hashCode()) * 1000003;
        long j = this.f3551d;
        int i2 = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f3552e;
        return ((i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f3553f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f3548a + ", code=" + this.f3549b + ", encodedPayload=" + this.f3550c + ", eventMillis=" + this.f3551d + ", uptimeMillis=" + this.f3552e + ", autoMetadata=" + this.f3553f + "}";
    }

    public a(String str, Integer num, g gVar, long j, long j2, Map<String, String> map) {
        this.f3548a = str;
        this.f3549b = num;
        this.f3550c = gVar;
        this.f3551d = j;
        this.f3552e = j2;
        this.f3553f = map;
    }
}
