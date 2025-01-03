package c.a.a.l.k.h;

import c.a.a.l.j.l;

/* compiled from: GifFrameModelLoader.java */
/* loaded from: classes.dex */
public class g implements l<c.a.a.j.a, c.a.a.j.a> {

    /* compiled from: GifFrameModelLoader.java */
    public static class a implements c.a.a.l.h.c<c.a.a.j.a> {

        /* renamed from: a, reason: collision with root package name */
        public final c.a.a.j.a f3320a;

        public a(c.a.a.j.a aVar) {
            this.f3320a = aVar;
        }

        @Override // c.a.a.l.h.c
        public void a() {
        }

        @Override // c.a.a.l.h.c
        public String c() {
            return String.valueOf(this.f3320a.c());
        }

        @Override // c.a.a.l.h.c
        public void cancel() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.a.l.h.c
        public c.a.a.j.a a(c.a.a.g gVar) {
            return this.f3320a;
        }
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<c.a.a.j.a> a(c.a.a.j.a aVar, int i2, int i3) {
        return new a(aVar);
    }
}
