package c.c.b.q;

import javax.annotation.Nonnull;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final String f6170a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6171b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f6170a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f6171b = str2;
    }

    @Override // c.c.b.q.f
    @Nonnull
    public String a() {
        return this.f6170a;
    }

    @Override // c.c.b.q.f
    @Nonnull
    public String b() {
        return this.f6171b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f6170a.equals(fVar.a()) && this.f6171b.equals(fVar.b());
    }

    public int hashCode() {
        return ((this.f6170a.hashCode() ^ 1000003) * 1000003) ^ this.f6171b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f6170a + ", version=" + this.f6171b + "}";
    }
}
