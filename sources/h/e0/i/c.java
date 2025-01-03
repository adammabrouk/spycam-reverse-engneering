package h.e0.i;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final i.f f11506d = i.f.encodeUtf8(":");

    /* renamed from: e, reason: collision with root package name */
    public static final i.f f11507e = i.f.encodeUtf8(":status");

    /* renamed from: f, reason: collision with root package name */
    public static final i.f f11508f = i.f.encodeUtf8(":method");

    /* renamed from: g, reason: collision with root package name */
    public static final i.f f11509g = i.f.encodeUtf8(":path");

    /* renamed from: h, reason: collision with root package name */
    public static final i.f f11510h = i.f.encodeUtf8(":scheme");

    /* renamed from: i, reason: collision with root package name */
    public static final i.f f11511i = i.f.encodeUtf8(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final i.f f11512a;

    /* renamed from: b, reason: collision with root package name */
    public final i.f f11513b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11514c;

    public c(String str, String str2) {
        this(i.f.encodeUtf8(str), i.f.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11512a.equals(cVar.f11512a) && this.f11513b.equals(cVar.f11513b);
    }

    public int hashCode() {
        return ((527 + this.f11512a.hashCode()) * 31) + this.f11513b.hashCode();
    }

    public String toString() {
        return h.e0.c.a("%s: %s", this.f11512a.utf8(), this.f11513b.utf8());
    }

    public c(i.f fVar, String str) {
        this(fVar, i.f.encodeUtf8(str));
    }

    public c(i.f fVar, i.f fVar2) {
        this.f11512a = fVar;
        this.f11513b = fVar2;
        this.f11514c = fVar.size() + 32 + fVar2.size();
    }
}
