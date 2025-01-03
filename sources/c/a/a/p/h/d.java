package c.a.a.p.h;

import android.widget.ImageView;

/* compiled from: GlideDrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class d extends e<c.a.a.l.k.f.b> {

    /* renamed from: e, reason: collision with root package name */
    public int f3428e;

    /* renamed from: f, reason: collision with root package name */
    public c.a.a.l.k.f.b f3429f;

    public d(ImageView imageView) {
        this(imageView, -1);
    }

    @Override // c.a.a.p.h.e, c.a.a.p.h.j
    public /* bridge */ /* synthetic */ void a(Object obj, c.a.a.p.g.c cVar) {
        a((c.a.a.l.k.f.b) obj, (c.a.a.p.g.c<? super c.a.a.l.k.f.b>) cVar);
    }

    public d(ImageView imageView, int i2) {
        super(imageView);
        this.f3428e = i2;
    }

    public void a(c.a.a.l.k.f.b bVar, c.a.a.p.g.c<? super c.a.a.l.k.f.b> cVar) {
        if (!bVar.a()) {
            float intrinsicWidth = bVar.getIntrinsicWidth() / bVar.getIntrinsicHeight();
            if (Math.abs((((ImageView) this.f3438b).getWidth() / ((ImageView) this.f3438b).getHeight()) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                bVar = new i(bVar, ((ImageView) this.f3438b).getWidth());
            }
        }
        super.a((d) bVar, (c.a.a.p.g.c<? super d>) cVar);
        this.f3429f = bVar;
        bVar.b(this.f3428e);
        bVar.start();
    }

    @Override // c.a.a.p.h.a, c.a.a.m.h
    public void b() {
        c.a.a.l.k.f.b bVar = this.f3429f;
        if (bVar != null) {
            bVar.stop();
        }
    }

    @Override // c.a.a.p.h.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(c.a.a.l.k.f.b bVar) {
        ((ImageView) this.f3438b).setImageDrawable(bVar);
    }

    @Override // c.a.a.p.h.a, c.a.a.m.h
    public void a() {
        c.a.a.l.k.f.b bVar = this.f3429f;
        if (bVar != null) {
            bVar.start();
        }
    }
}
