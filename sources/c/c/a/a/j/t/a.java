package c.c.a.a.j.t;

import c.c.a.a.j.t.f;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Iterable<c.c.a.a.j.h> f3608a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3609b;

    @Override // c.c.a.a.j.t.f
    public Iterable<c.c.a.a.j.h> a() {
        return this.f3608a;
    }

    @Override // c.c.a.a.j.t.f
    public byte[] b() {
        return this.f3609b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f3608a.equals(fVar.a())) {
            if (Arrays.equals(this.f3609b, fVar instanceof a ? ((a) fVar).f3609b : fVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3608a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3609b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f3608a + ", extras=" + Arrays.toString(this.f3609b) + "}";
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static final class b extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public Iterable<c.c.a.a.j.h> f3610a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f3611b;

        @Override // c.c.a.a.j.t.f.a
        public f.a a(Iterable<c.c.a.a.j.h> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f3610a = iterable;
            return this;
        }

        @Override // c.c.a.a.j.t.f.a
        public f.a a(byte[] bArr) {
            this.f3611b = bArr;
            return this;
        }

        @Override // c.c.a.a.j.t.f.a
        public f a() {
            String str = "";
            if (this.f3610a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new a(this.f3610a, this.f3611b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    public a(Iterable<c.c.a.a.j.h> iterable, byte[] bArr) {
        this.f3608a = iterable;
        this.f3609b = bArr;
    }
}
