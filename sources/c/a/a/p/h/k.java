package c.a.a.p.h;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
/* loaded from: classes.dex */
public abstract class k<T extends View, Z> extends c.a.a.p.h.a<Z> {

    /* renamed from: d, reason: collision with root package name */
    public static Integer f3437d;

    /* renamed from: b, reason: collision with root package name */
    public final T f3438b;

    /* renamed from: c, reason: collision with root package name */
    public final a f3439c;

    /* compiled from: ViewTarget.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final View f3440a;

        /* renamed from: b, reason: collision with root package name */
        public final List<h> f3441b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public ViewTreeObserverOnPreDrawListenerC0076a f3442c;

        /* renamed from: d, reason: collision with root package name */
        public Point f3443d;

        /* compiled from: ViewTarget.java */
        /* renamed from: c.a.a.p.h.k$a$a, reason: collision with other inner class name */
        public static class ViewTreeObserverOnPreDrawListenerC0076a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a, reason: collision with root package name */
            public final WeakReference<a> f3444a;

            public ViewTreeObserverOnPreDrawListenerC0076a(a aVar) {
                this.f3444a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                a aVar = this.f3444a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        public a(View view) {
            this.f3440a = view;
        }

        public final boolean a(int i2) {
            return i2 > 0 || i2 == -2;
        }

        @TargetApi(13)
        public final Point b() {
            Point point = this.f3443d;
            if (point != null) {
                return point;
            }
            Display defaultDisplay = ((WindowManager) this.f3440a.getContext().getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point2 = new Point();
                this.f3443d = point2;
                defaultDisplay.getSize(point2);
            } else {
                this.f3443d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f3443d;
        }

        public final int c() {
            ViewGroup.LayoutParams layoutParams = this.f3440a.getLayoutParams();
            if (a(this.f3440a.getHeight())) {
                return this.f3440a.getHeight();
            }
            if (layoutParams != null) {
                return a(layoutParams.height, true);
            }
            return 0;
        }

        public final int d() {
            ViewGroup.LayoutParams layoutParams = this.f3440a.getLayoutParams();
            if (a(this.f3440a.getWidth())) {
                return this.f3440a.getWidth();
            }
            if (layoutParams != null) {
                return a(layoutParams.width, false);
            }
            return 0;
        }

        public final void a(int i2, int i3) {
            Iterator<h> it = this.f3441b.iterator();
            while (it.hasNext()) {
                it.next().a(i2, i3);
            }
            this.f3441b.clear();
        }

        public final void a() {
            if (this.f3441b.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (a(d2) && a(c2)) {
                a(d2, c2);
                ViewTreeObserver viewTreeObserver = this.f3440a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f3442c);
                }
                this.f3442c = null;
            }
        }

        public void a(h hVar) {
            int d2 = d();
            int c2 = c();
            if (a(d2) && a(c2)) {
                hVar.a(d2, c2);
                return;
            }
            if (!this.f3441b.contains(hVar)) {
                this.f3441b.add(hVar);
            }
            if (this.f3442c == null) {
                ViewTreeObserver viewTreeObserver = this.f3440a.getViewTreeObserver();
                ViewTreeObserverOnPreDrawListenerC0076a viewTreeObserverOnPreDrawListenerC0076a = new ViewTreeObserverOnPreDrawListenerC0076a(this);
                this.f3442c = viewTreeObserverOnPreDrawListenerC0076a;
                viewTreeObserver.addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0076a);
            }
        }

        public final int a(int i2, boolean z) {
            if (i2 != -2) {
                return i2;
            }
            Point b2 = b();
            return z ? b2.y : b2.x;
        }
    }

    public k(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f3438b = t;
        this.f3439c = new a(t);
    }

    @Override // c.a.a.p.h.j
    public void a(h hVar) {
        this.f3439c.a(hVar);
    }

    public T c() {
        return this.f3438b;
    }

    @Override // c.a.a.p.h.a, c.a.a.p.h.j
    public c.a.a.p.b e() {
        Object g2 = g();
        if (g2 == null) {
            return null;
        }
        if (g2 instanceof c.a.a.p.b) {
            return (c.a.a.p.b) g2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public final Object g() {
        Integer num = f3437d;
        return num == null ? this.f3438b.getTag() : this.f3438b.getTag(num.intValue());
    }

    public String toString() {
        return "Target for: " + this.f3438b;
    }

    @Override // c.a.a.p.h.a, c.a.a.p.h.j
    public void a(c.a.a.p.b bVar) {
        a((Object) bVar);
    }

    public final void a(Object obj) {
        Integer num = f3437d;
        if (num == null) {
            this.f3438b.setTag(obj);
        } else {
            this.f3438b.setTag(num.intValue(), obj);
        }
    }
}
