package c.a.a.l.k.f;

import android.graphics.drawable.Drawable;
import c.a.a.l.i.k;

/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class a<T extends Drawable> implements k<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f3274a;

    public a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f3274a = t;
    }

    @Override // c.a.a.l.i.k
    public final T get() {
        return (T) this.f3274a.getConstantState().newDrawable();
    }
}
