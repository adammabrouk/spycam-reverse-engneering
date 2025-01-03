package c.a.a.l.j;

import java.util.Queue;

/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class k<A, B> {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.r.e<b<A>, B> f3208a;

    /* compiled from: ModelCache.java */
    public class a extends c.a.a.r.e<b<A>, B> {
        public a(k kVar, int i2) {
            super(i2);
        }

        @Override // c.a.a.r.e
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2) {
            a((b) obj, (b<A>) obj2);
        }

        public void a(b<A> bVar, B b2) {
            bVar.a();
        }
    }

    public k(int i2) {
        this.f3208a = new a(this, i2);
    }

    public B a(A a2, int i2, int i3) {
        b<A> b2 = b.b(a2, i2, i3);
        B a3 = this.f3208a.a(b2);
        b2.a();
        return a3;
    }

    /* compiled from: ModelCache.java */
    public static final class b<A> {

        /* renamed from: d, reason: collision with root package name */
        public static final Queue<b<?>> f3209d = c.a.a.r.h.a(0);

        /* renamed from: a, reason: collision with root package name */
        public int f3210a;

        /* renamed from: b, reason: collision with root package name */
        public int f3211b;

        /* renamed from: c, reason: collision with root package name */
        public A f3212c;

        public static <A> b<A> b(A a2, int i2, int i3) {
            b<A> bVar = (b) f3209d.poll();
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.a(a2, i2, i3);
            return bVar;
        }

        public final void a(A a2, int i2, int i3) {
            this.f3212c = a2;
            this.f3211b = i2;
            this.f3210a = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f3211b == bVar.f3211b && this.f3210a == bVar.f3210a && this.f3212c.equals(bVar.f3212c);
        }

        public int hashCode() {
            return (((this.f3210a * 31) + this.f3211b) * 31) + this.f3212c.hashCode();
        }

        public void a() {
            f3209d.offer(this);
        }
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f3208a.b(b.b(a2, i2, i3), b2);
    }
}
