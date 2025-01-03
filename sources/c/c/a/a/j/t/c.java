package c.c.a.a.j.t;

import android.content.Context;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3614a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3615b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3616c;

    /* renamed from: d, reason: collision with root package name */
    public final String f3617d;

    public c(Context context, c.c.a.a.j.y.a aVar, c.c.a.a.j.y.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f3614a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f3615b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f3616c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f3617d = str;
    }

    @Override // c.c.a.a.j.t.h
    public Context a() {
        return this.f3614a;
    }

    @Override // c.c.a.a.j.t.h
    public String b() {
        return this.f3617d;
    }

    @Override // c.c.a.a.j.t.h
    public c.c.a.a.j.y.a c() {
        return this.f3616c;
    }

    @Override // c.c.a.a.j.t.h
    public c.c.a.a.j.y.a d() {
        return this.f3615b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f3614a.equals(hVar.a()) && this.f3615b.equals(hVar.d()) && this.f3616c.equals(hVar.c()) && this.f3617d.equals(hVar.b());
    }

    public int hashCode() {
        return ((((((this.f3614a.hashCode() ^ 1000003) * 1000003) ^ this.f3615b.hashCode()) * 1000003) ^ this.f3616c.hashCode()) * 1000003) ^ this.f3617d.hashCode();
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f3614a + ", wallClock=" + this.f3615b + ", monotonicClock=" + this.f3616c + ", backendName=" + this.f3617d + "}";
    }
}
