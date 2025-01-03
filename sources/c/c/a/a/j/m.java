package c.c.a.a.j;

import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public final class m implements c.c.a.a.g {

    /* renamed from: a, reason: collision with root package name */
    public final Set<c.c.a.a.b> f3589a;

    /* renamed from: b, reason: collision with root package name */
    public final l f3590b;

    /* renamed from: c, reason: collision with root package name */
    public final p f3591c;

    public m(Set<c.c.a.a.b> set, l lVar, p pVar) {
        this.f3589a = set;
        this.f3590b = lVar;
        this.f3591c = pVar;
    }

    @Override // c.c.a.a.g
    public <T> c.c.a.a.f<T> a(String str, Class<T> cls, c.c.a.a.b bVar, c.c.a.a.e<T, byte[]> eVar) {
        if (this.f3589a.contains(bVar)) {
            return new o(this.f3590b, str, bVar, eVar, this.f3591c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f3589a));
    }
}
