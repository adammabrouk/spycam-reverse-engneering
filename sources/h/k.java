package h;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    public static final h[] f11702e = {h.k, h.m, h.l, h.n, h.p, h.o};

    /* renamed from: f, reason: collision with root package name */
    public static final h[] f11703f = {h.k, h.m, h.l, h.n, h.p, h.o, h.f11692i, h.j, h.f11690g, h.f11691h, h.f11688e, h.f11689f, h.f11687d};

    /* renamed from: g, reason: collision with root package name */
    public static final k f11704g;

    /* renamed from: h, reason: collision with root package name */
    public static final k f11705h;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11706a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11707b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String[] f11708c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String[] f11709d;

    static {
        a aVar = new a(true);
        aVar.a(f11702e);
        aVar.a(d0.TLS_1_2);
        aVar.a(true);
        aVar.a();
        a aVar2 = new a(true);
        aVar2.a(f11703f);
        aVar2.a(d0.TLS_1_2, d0.TLS_1_1, d0.TLS_1_0);
        aVar2.a(true);
        k a2 = aVar2.a();
        f11704g = a2;
        a aVar3 = new a(a2);
        aVar3.a(d0.TLS_1_0);
        aVar3.a(true);
        aVar3.a();
        f11705h = new a(false).a();
    }

    public k(a aVar) {
        this.f11706a = aVar.f11710a;
        this.f11708c = aVar.f11711b;
        this.f11709d = aVar.f11712c;
        this.f11707b = aVar.f11713d;
    }

    @Nullable
    public List<h> a() {
        String[] strArr = this.f11708c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f11706a;
    }

    public boolean c() {
        return this.f11707b;
    }

    @Nullable
    public List<d0> d() {
        String[] strArr = this.f11709d;
        if (strArr != null) {
            return d0.forJavaNames(strArr);
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z = this.f11706a;
        if (z != kVar.f11706a) {
            return false;
        }
        return !z || (Arrays.equals(this.f11708c, kVar.f11708c) && Arrays.equals(this.f11709d, kVar.f11709d) && this.f11707b == kVar.f11707b);
    }

    public int hashCode() {
        if (this.f11706a) {
            return ((((527 + Arrays.hashCode(this.f11708c)) * 31) + Arrays.hashCode(this.f11709d)) * 31) + (!this.f11707b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f11706a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f11708c != null ? a().toString() : "[all enabled]") + ", tlsVersions=" + (this.f11709d != null ? d().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f11707b + ")";
    }

    /* compiled from: ConnectionSpec.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11710a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public String[] f11711b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String[] f11712c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11713d;

        public a(boolean z) {
            this.f11710a = z;
        }

        public a a(h... hVarArr) {
            if (!this.f11710a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[hVarArr.length];
            for (int i2 = 0; i2 < hVarArr.length; i2++) {
                strArr[i2] = hVarArr[i2].f11693a;
            }
            a(strArr);
            return this;
        }

        public a b(String... strArr) {
            if (!this.f11710a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f11712c = (String[]) strArr.clone();
            return this;
        }

        public a(k kVar) {
            this.f11710a = kVar.f11706a;
            this.f11711b = kVar.f11708c;
            this.f11712c = kVar.f11709d;
            this.f11713d = kVar.f11707b;
        }

        public a a(String... strArr) {
            if (this.f11710a) {
                if (strArr.length != 0) {
                    this.f11711b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(d0... d0VarArr) {
            if (this.f11710a) {
                String[] strArr = new String[d0VarArr.length];
                for (int i2 = 0; i2 < d0VarArr.length; i2++) {
                    strArr[i2] = d0VarArr[i2].javaName;
                }
                b(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z) {
            if (this.f11710a) {
                this.f11713d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        k b2 = b(sSLSocket, z);
        String[] strArr = b2.f11709d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f11708c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public final k b(SSLSocket sSLSocket, boolean z) {
        String[] a2 = this.f11708c != null ? h.e0.c.a(h.f11685b, sSLSocket.getEnabledCipherSuites(), this.f11708c) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.f11709d != null ? h.e0.c.a(h.e0.c.p, sSLSocket.getEnabledProtocols(), this.f11709d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = h.e0.c.a(h.f11685b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a4 != -1) {
            a2 = h.e0.c.a(a2, supportedCipherSuites[a4]);
        }
        a aVar = new a(this);
        aVar.a(a2);
        aVar.b(a3);
        return aVar.a();
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f11706a) {
            return false;
        }
        String[] strArr = this.f11709d;
        if (strArr != null && !h.e0.c.b(h.e0.c.p, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f11708c;
        return strArr2 == null || h.e0.c.b(h.f11685b, strArr2, sSLSocket.getEnabledCipherSuites());
    }
}
