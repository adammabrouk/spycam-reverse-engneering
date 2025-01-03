package c.c.a.a.i.b;

import c.c.a.a.i.b.p;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class g extends p {

    /* renamed from: a, reason: collision with root package name */
    public final long f3499a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3500b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3501c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3502d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3503e;

    /* renamed from: f, reason: collision with root package name */
    public final long f3504f;

    /* renamed from: g, reason: collision with root package name */
    public final u f3505g;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
    public static final class b extends p.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f3506a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f3507b;

        /* renamed from: c, reason: collision with root package name */
        public Long f3508c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f3509d;

        /* renamed from: e, reason: collision with root package name */
        public String f3510e;

        /* renamed from: f, reason: collision with root package name */
        public Long f3511f;

        /* renamed from: g, reason: collision with root package name */
        public u f3512g;

        @Override // c.c.a.a.i.b.p.a
        public p.a a(long j) {
            this.f3506a = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a b(long j) {
            this.f3508c = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a c(long j) {
            this.f3511f = Long.valueOf(j);
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a a(int i2) {
            this.f3507b = Integer.valueOf(i2);
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a a(byte[] bArr) {
            this.f3509d = bArr;
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a a(String str) {
            this.f3510e = str;
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p.a a(u uVar) {
            this.f3512g = uVar;
            return this;
        }

        @Override // c.c.a.a.i.b.p.a
        public p a() {
            String str = "";
            if (this.f3506a == null) {
                str = " eventTimeMs";
            }
            if (this.f3507b == null) {
                str = str + " eventCode";
            }
            if (this.f3508c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f3511f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new g(this.f3506a.longValue(), this.f3507b.intValue(), this.f3508c.longValue(), this.f3509d, this.f3510e, this.f3511f.longValue(), this.f3512g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public /* synthetic */ g(long j, int i2, long j2, byte[] bArr, String str, long j3, u uVar, a aVar) {
        this.f3499a = j;
        this.f3500b = i2;
        this.f3501c = j2;
        this.f3502d = bArr;
        this.f3503e = str;
        this.f3504f = j3;
        this.f3505g = uVar;
    }

    @Override // c.c.a.a.i.b.p
    public long a() {
        return this.f3499a;
    }

    @Override // c.c.a.a.i.b.p
    public long b() {
        return this.f3501c;
    }

    @Override // c.c.a.a.i.b.p
    public long c() {
        return this.f3504f;
    }

    public int d() {
        return this.f3500b;
    }

    public u e() {
        return this.f3505g;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f3499a == pVar.a()) {
            g gVar = (g) pVar;
            if (this.f3500b == gVar.f3500b && this.f3501c == pVar.b()) {
                if (Arrays.equals(this.f3502d, pVar instanceof g ? gVar.f3502d : gVar.f3502d) && ((str = this.f3503e) != null ? str.equals(gVar.f3503e) : gVar.f3503e == null) && this.f3504f == pVar.c()) {
                    u uVar = this.f3505g;
                    if (uVar == null) {
                        if (gVar.f3505g == null) {
                            return true;
                        }
                    } else if (uVar.equals(gVar.f3505g)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public byte[] f() {
        return this.f3502d;
    }

    public String g() {
        return this.f3503e;
    }

    public int hashCode() {
        long j = this.f3499a;
        int i2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f3500b) * 1000003;
        long j2 = this.f3501c;
        int hashCode = (((i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f3502d)) * 1000003;
        String str = this.f3503e;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.f3504f;
        int i3 = (((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        u uVar = this.f3505g;
        return i3 ^ (uVar != null ? uVar.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f3499a + ", eventCode=" + this.f3500b + ", eventUptimeMs=" + this.f3501c + ", sourceExtension=" + Arrays.toString(this.f3502d) + ", sourceExtensionJsonProto3=" + this.f3503e + ", timezoneOffsetSeconds=" + this.f3504f + ", networkConnectionInfo=" + this.f3505g + "}";
    }
}
