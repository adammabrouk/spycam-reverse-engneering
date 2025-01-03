package a.h.j;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f1204a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f1205b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f1206c;

    public v(View view, Runnable runnable) {
        this.f1204a = view;
        this.f1205b = view.getViewTreeObserver();
        this.f1206c = runnable;
    }

    public static v a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        v vVar = new v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(vVar);
        view.addOnAttachStateChangeListener(vVar);
        return vVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        a();
        this.f1206c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1205b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    public void a() {
        if (this.f1205b.isAlive()) {
            this.f1205b.removeOnPreDrawListener(this);
        } else {
            this.f1204a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1204a.removeOnAttachStateChangeListener(this);
    }
}
