package c.a.a.p.g;

import android.view.View;
import android.view.animation.Animation;
import c.a.a.p.g.c;

/* compiled from: ViewAnimation.java */
/* loaded from: classes.dex */
public class f<R> implements c<R> {

    /* renamed from: a, reason: collision with root package name */
    public final a f3424a;

    /* compiled from: ViewAnimation.java */
    public interface a {
        Animation a();
    }

    public f(a aVar) {
        this.f3424a = aVar;
    }

    @Override // c.a.a.p.g.c
    public boolean a(R r, c.a aVar) {
        View c2 = aVar.c();
        if (c2 == null) {
            return false;
        }
        c2.clearAnimation();
        c2.startAnimation(this.f3424a.a());
        return false;
    }
}
