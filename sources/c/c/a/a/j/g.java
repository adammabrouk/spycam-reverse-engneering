package c.c.a.a.j;

import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.a.b f3586a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3587b;

    public g(c.c.a.a.b bVar, byte[] bArr) {
        if (bVar == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.f3586a = bVar;
        this.f3587b = bArr;
    }

    public byte[] a() {
        return this.f3587b;
    }

    public c.c.a.a.b b() {
        return this.f3586a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f3586a.equals(gVar.f3586a)) {
            return Arrays.equals(this.f3587b, gVar.f3587b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f3586a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f3587b);
    }

    public String toString() {
        return "EncodedPayload{encoding=" + this.f3586a + ", bytes=[...]}";
    }
}
