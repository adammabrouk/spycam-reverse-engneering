package c.a.a.l.i.n;

import c.a.a.l.i.n.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0067a {

    /* renamed from: a, reason: collision with root package name */
    public final int f3159a;

    /* renamed from: b, reason: collision with root package name */
    public final a f3160b;

    /* compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a aVar, int i2) {
        this.f3159a = i2;
        this.f3160b = aVar;
    }

    @Override // c.a.a.l.i.n.a.InterfaceC0067a
    public c.a.a.l.i.n.a a() {
        File a2 = this.f3160b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.a(a2, this.f3159a);
        }
        return null;
    }
}
