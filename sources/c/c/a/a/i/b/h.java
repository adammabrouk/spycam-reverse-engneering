package c.c.a.a.i.b;

import c.c.a.a.i.b.r;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class h extends r {

    /* renamed from: a, reason: collision with root package name */
    public final long f3513a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3514b;

    /* renamed from: c, reason: collision with root package name */
    public final m f3515c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3516d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3517e;

    /* renamed from: f, reason: collision with root package name */
    public final List<p> f3518f;

    /* renamed from: g, reason: collision with root package name */
    public final c.c.a.a.i.b.b f3519g;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b extends r.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f3520a;

        /* renamed from: b, reason: collision with root package name */
        public Long f3521b;

        /* renamed from: c, reason: collision with root package name */
        public m f3522c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f3523d;

        /* renamed from: e, reason: collision with root package name */
        public String f3524e;

        /* renamed from: f, reason: collision with root package name */
        public List<p> f3525f;

        /* renamed from: g, reason: collision with root package name */
        public c.c.a.a.i.b.b f3526g;

        @Override // c.c.a.a.i.b.r.a
        public r.a a(long j) {
            this.f3520a = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a b(long j) {
            this.f3521b = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a a(m mVar) {
            this.f3522c = mVar;
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a a(int i2) {
            this.f3523d = Integer.valueOf(i2);
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a a(String str) {
            this.f3524e = str;
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a a(List<p> list) {
            this.f3525f = list;
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r.a a(c.c.a.a.i.b.b bVar) {
            this.f3526g = bVar;
            return this;
        }

        @Override // c.c.a.a.i.b.r.a
        public r a() {
            String str = "";
            if (this.f3520a == null) {
                str = " requestTimeMs";
            }
            if (this.f3521b == null) {
                str = str + " requestUptimeMs";
            }
            if (this.f3523d == null) {
                str = str + " logSource";
            }
            if (str.isEmpty()) {
                return new h(this.f3520a.longValue(), this.f3521b.longValue(), this.f3522c, this.f3523d.intValue(), this.f3524e, this.f3525f, this.f3526g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public /* synthetic */ h(long j, long j2, m mVar, int i2, String str, List list, c.c.a.a.i.b.b bVar, a aVar) {
        this.f3513a = j;
        this.f3514b = j2;
        this.f3515c = mVar;
        this.f3516d = i2;
        this.f3517e = str;
        this.f3518f = list;
        this.f3519g = bVar;
    }

    public m b() {
        return this.f3515c;
    }

    public List<p> c() {
        return this.f3518f;
    }

    public int d() {
        return this.f3516d;
    }

    public String e() {
        return this.f3517e;
    }

    public boolean equals(Object obj) {
        m mVar;
        String str;
        List<p> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        h hVar = (h) ((r) obj);
        if (this.f3513a == hVar.f3513a && this.f3514b == hVar.f3514b && ((mVar = this.f3515c) != null ? mVar.equals(hVar.f3515c) : hVar.f3515c == null) && this.f3516d == hVar.f3516d && ((str = this.f3517e) != null ? str.equals(hVar.f3517e) : hVar.f3517e == null) && ((list = this.f3518f) != null ? list.equals(hVar.f3518f) : hVar.f3518f == null)) {
            c.c.a.a.i.b.b bVar = this.f3519g;
            if (bVar == null) {
                if (hVar.f3519g == null) {
                    return true;
                }
            } else if (bVar.equals(hVar.f3519g)) {
                return true;
            }
        }
        return false;
    }

    public long f() {
        return this.f3513a;
    }

    public long g() {
        return this.f3514b;
    }

    public int hashCode() {
        long j = this.f3513a;
        long j2 = this.f3514b;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        m mVar = this.f3515c;
        int hashCode = (((i2 ^ (mVar == null ? 0 : mVar.hashCode())) * 1000003) ^ this.f3516d) * 1000003;
        String str = this.f3517e;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<p> list = this.f3518f;
        int hashCode3 = (hashCode2 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        c.c.a.a.i.b.b bVar = this.f3519g;
        return hashCode3 ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f3513a + ", requestUptimeMs=" + this.f3514b + ", clientInfo=" + this.f3515c + ", logSource=" + this.f3516d + ", logSourceName=" + this.f3517e + ", logEvents=" + this.f3518f + ", qosTier=" + this.f3519g + "}";
    }
}
