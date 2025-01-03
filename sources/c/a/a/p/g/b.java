package c.a.a.p.g;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import c.a.a.p.g.c;

/* compiled from: DrawableCrossFadeViewAnimation.java */
/* loaded from: classes.dex */
public class b<T extends Drawable> implements c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final c<T> f3420a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3421b;

    public b(c<T> cVar, int i2) {
        this.f3420a = cVar;
        this.f3421b = i2;
    }

    @Override // c.a.a.p.g.c
    public boolean a(T t, c.a aVar) {
        Drawable d2 = aVar.d();
        if (d2 == null) {
            this.f3420a.a(t, aVar);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{d2, t});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.f3421b);
        aVar.a(transitionDrawable);
        return true;
    }
}
