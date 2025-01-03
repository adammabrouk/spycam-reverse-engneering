package a.f.a.j;

import a.f.a.j.e;
import java.util.ArrayList;

/* compiled from: Snapshot.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public int f822a;

    /* renamed from: b, reason: collision with root package name */
    public int f823b;

    /* renamed from: c, reason: collision with root package name */
    public int f824c;

    /* renamed from: d, reason: collision with root package name */
    public int f825d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<a> f826e = new ArrayList<>();

    /* compiled from: Snapshot.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public e f827a;

        /* renamed from: b, reason: collision with root package name */
        public e f828b;

        /* renamed from: c, reason: collision with root package name */
        public int f829c;

        /* renamed from: d, reason: collision with root package name */
        public e.c f830d;

        /* renamed from: e, reason: collision with root package name */
        public int f831e;

        public a(e eVar) {
            this.f827a = eVar;
            this.f828b = eVar.g();
            this.f829c = eVar.b();
            this.f830d = eVar.f();
            this.f831e = eVar.a();
        }

        public void a(f fVar) {
            fVar.a(this.f827a.h()).a(this.f828b, this.f829c, this.f830d, this.f831e);
        }

        public void b(f fVar) {
            e a2 = fVar.a(this.f827a.h());
            this.f827a = a2;
            if (a2 != null) {
                this.f828b = a2.g();
                this.f829c = this.f827a.b();
                this.f830d = this.f827a.f();
                this.f831e = this.f827a.a();
                return;
            }
            this.f828b = null;
            this.f829c = 0;
            this.f830d = e.c.STRONG;
            this.f831e = 0;
        }
    }

    public p(f fVar) {
        this.f822a = fVar.w();
        this.f823b = fVar.x();
        this.f824c = fVar.t();
        this.f825d = fVar.j();
        ArrayList<e> c2 = fVar.c();
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f826e.add(new a(c2.get(i2)));
        }
    }

    public void a(f fVar) {
        fVar.s(this.f822a);
        fVar.t(this.f823b);
        fVar.p(this.f824c);
        fVar.h(this.f825d);
        int size = this.f826e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f826e.get(i2).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f822a = fVar.w();
        this.f823b = fVar.x();
        this.f824c = fVar.t();
        this.f825d = fVar.j();
        int size = this.f826e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f826e.get(i2).b(fVar);
        }
    }
}
