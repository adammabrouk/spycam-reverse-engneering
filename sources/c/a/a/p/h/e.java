package c.a.a.p.h;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import c.a.a.p.g.c;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class e<Z> extends k<ImageView, Z> implements c.a {
    public e(ImageView imageView) {
        super(imageView);
    }

    @Override // c.a.a.p.g.c.a
    public void a(Drawable drawable) {
        ((ImageView) this.f3438b).setImageDrawable(drawable);
    }

    @Override // c.a.a.p.h.a, c.a.a.p.h.j
    public void b(Drawable drawable) {
        ((ImageView) this.f3438b).setImageDrawable(drawable);
    }

    public abstract void b(Z z);

    @Override // c.a.a.p.h.a, c.a.a.p.h.j
    public void c(Drawable drawable) {
        ((ImageView) this.f3438b).setImageDrawable(drawable);
    }

    @Override // c.a.a.p.g.c.a
    public Drawable d() {
        return ((ImageView) this.f3438b).getDrawable();
    }

    @Override // c.a.a.p.h.a, c.a.a.p.h.j
    public void a(Exception exc, Drawable drawable) {
        ((ImageView) this.f3438b).setImageDrawable(drawable);
    }

    @Override // c.a.a.p.h.j
    public void a(Z z, c.a.a.p.g.c<? super Z> cVar) {
        if (cVar == null || !cVar.a(z, this)) {
            b((e<Z>) z);
        }
    }
}
