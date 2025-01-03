package c.a.a.l.j.t;

import android.content.Context;
import c.a.a.l.j.k;
import c.a.a.l.j.l;
import c.a.a.l.j.m;
import java.io.InputStream;

/* compiled from: HttpUrlGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements l<c.a.a.l.j.d, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final k<c.a.a.l.j.d, c.a.a.l.j.d> f3219a;

    /* compiled from: HttpUrlGlideUrlLoader.java */
    /* renamed from: c.a.a.l.j.t.a$a, reason: collision with other inner class name */
    public static class C0073a implements m<c.a.a.l.j.d, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        public final k<c.a.a.l.j.d, c.a.a.l.j.d> f3220a = new k<>(500);

        @Override // c.a.a.l.j.m
        public l<c.a.a.l.j.d, InputStream> a(Context context, c.a.a.l.j.c cVar) {
            return new a(this.f3220a);
        }

        @Override // c.a.a.l.j.m
        public void a() {
        }
    }

    public a(k<c.a.a.l.j.d, c.a.a.l.j.d> kVar) {
        this.f3219a = kVar;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<InputStream> a(c.a.a.l.j.d dVar, int i2, int i3) {
        k<c.a.a.l.j.d, c.a.a.l.j.d> kVar = this.f3219a;
        if (kVar != null) {
            c.a.a.l.j.d a2 = kVar.a(dVar, 0, 0);
            if (a2 == null) {
                this.f3219a.a(dVar, 0, 0, dVar);
            } else {
                dVar = a2;
            }
        }
        return new c.a.a.l.h.f(dVar);
    }
}
