package c.c.a.a.j.w.j;

import c.c.a.a.j.w.j.g;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: a, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3661a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<c.c.a.a.d, g.b> f3662b;

    public c(c.c.a.a.j.y.a aVar, Map<c.c.a.a.d, g.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f3661a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f3662b = map;
    }

    @Override // c.c.a.a.j.w.j.g
    public c.c.a.a.j.y.a a() {
        return this.f3661a;
    }

    @Override // c.c.a.a.j.w.j.g
    public Map<c.c.a.a.d, g.b> b() {
        return this.f3662b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f3661a.equals(gVar.a()) && this.f3662b.equals(gVar.b());
    }

    public int hashCode() {
        return ((this.f3661a.hashCode() ^ 1000003) * 1000003) ^ this.f3662b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f3661a + ", values=" + this.f3662b + "}";
    }
}
