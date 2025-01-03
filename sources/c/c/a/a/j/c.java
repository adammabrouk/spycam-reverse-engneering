package c.c.a.a.j;

import c.c.a.a.j.l;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class c extends l {

    /* renamed from: a, reason: collision with root package name */
    public final String f3570a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3571b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.d f3572c;

    @Override // c.c.a.a.j.l
    public String a() {
        return this.f3570a;
    }

    @Override // c.c.a.a.j.l
    public byte[] b() {
        return this.f3571b;
    }

    @Override // c.c.a.a.j.l
    public c.c.a.a.d c() {
        return this.f3572c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f3570a.equals(lVar.a())) {
            if (Arrays.equals(this.f3571b, lVar instanceof c ? ((c) lVar).f3571b : lVar.b()) && this.f3572c.equals(lVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f3570a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3571b)) * 1000003) ^ this.f3572c.hashCode();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b extends l.a {

        /* renamed from: a, reason: collision with root package name */
        public String f3573a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f3574b;

        /* renamed from: c, reason: collision with root package name */
        public c.c.a.a.d f3575c;

        @Override // c.c.a.a.j.l.a
        public l.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f3573a = str;
            return this;
        }

        @Override // c.c.a.a.j.l.a
        public l.a a(byte[] bArr) {
            this.f3574b = bArr;
            return this;
        }

        @Override // c.c.a.a.j.l.a
        public l.a a(c.c.a.a.d dVar) {
            if (dVar != null) {
                this.f3575c = dVar;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        @Override // c.c.a.a.j.l.a
        public l a() {
            String str = "";
            if (this.f3573a == null) {
                str = " backendName";
            }
            if (this.f3575c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.f3573a, this.f3574b, this.f3575c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public c(String str, byte[] bArr, c.c.a.a.d dVar) {
        this.f3570a = str;
        this.f3571b = bArr;
        this.f3572c = dVar;
    }
}
