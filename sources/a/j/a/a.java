package a.j.a;

import a.e.h;
import a.h.j.b0;
import a.h.j.h0.d;
import a.h.j.h0.e;
import a.h.j.y;
import a.j.a.b;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends a.h.j.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b.a<a.h.j.h0.c> o = new C0035a();
    public static final b.InterfaceC0036b<h<a.h.j.h0.c>, a.h.j.h0.c> p = new b();

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f1281h;

    /* renamed from: i, reason: collision with root package name */
    public final View f1282i;
    public c j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f1277d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f1278e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f1279f = new Rect();

    /* renamed from: g, reason: collision with root package name */
    public final int[] f1280g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: a.j.a.a$a, reason: collision with other inner class name */
    public static class C0035a implements b.a<a.h.j.h0.c> {
        @Override // a.j.a.b.a
        public void a(a.h.j.h0.c cVar, Rect rect) {
            cVar.a(rect);
        }
    }

    public a(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f1282i = view;
        this.f1281h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (y.o(view) == 0) {
            y.h(view, 1);
        }
    }

    public static int j(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 != 21) {
            return i2 != 22 ? 130 : 66;
        }
        return 17;
    }

    public abstract int a(float f2, float f3);

    @Override // a.h.j.a
    public d a(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    public abstract void a(int i2, a.h.j.h0.c cVar);

    public void a(int i2, AccessibilityEvent accessibilityEvent) {
    }

    public void a(int i2, boolean z) {
    }

    public void a(a.h.j.h0.c cVar) {
    }

    public void a(AccessibilityEvent accessibilityEvent) {
    }

    public abstract void a(List<Integer> list);

    public abstract boolean a(int i2, int i3, Bundle bundle);

    public final boolean b(int i2, Rect rect) {
        a.h.j.h0.c cVar;
        h<a.h.j.h0.c> e2 = e();
        int i3 = this.l;
        a.h.j.h0.c a2 = i3 == Integer.MIN_VALUE ? null : e2.a(i3);
        if (i2 == 1 || i2 == 2) {
            cVar = (a.h.j.h0.c) a.j.a.b.a(e2, p, o, a2, i2, y.q(this.f1282i) == 1, false);
        } else {
            if (i2 != 17 && i2 != 33 && i2 != 66 && i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i4 = this.l;
            if (i4 != Integer.MIN_VALUE) {
                a(i4, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.f1282i, i2, rect2);
            }
            cVar = (a.h.j.h0.c) a.j.a.b.a(e2, p, o, a2, rect2, i2);
        }
        return h(cVar != null ? e2.b(e2.a((h<a.h.j.h0.c>) cVar)) : Integer.MIN_VALUE);
    }

    public final void c(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f1281h.isEnabled() || (parent = this.f1282i.getParent()) == null) {
            return;
        }
        AccessibilityEvent a2 = a(i2, 2048);
        a.h.j.h0.b.a(a2, i3);
        b0.a(parent, this.f1282i, a2);
    }

    public final int d() {
        return this.k;
    }

    public final h<a.h.j.h0.c> e() {
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        h<a.h.j.h0.c> hVar = new h<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.c(i2, d(i2));
        }
        return hVar;
    }

    public final int f() {
        return this.l;
    }

    public final boolean g(int i2) {
        int i3;
        if (!this.f1281h.isEnabled() || !this.f1281h.isTouchExplorationEnabled() || (i3 = this.k) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            a(i3);
        }
        this.k = i2;
        this.f1282i.invalidate();
        d(i2, 32768);
        return true;
    }

    public final boolean h(int i2) {
        int i3;
        if ((!this.f1282i.isFocused() && !this.f1282i.requestFocus()) || (i3 = this.l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            b(i3);
        }
        this.l = i2;
        a(i2, true);
        d(i2, 8);
        return true;
    }

    public final void i(int i2) {
        int i3 = this.m;
        if (i3 == i2) {
            return;
        }
        this.m = i2;
        d(i2, RecyclerView.c0.FLAG_IGNORE);
        d(i3, RecyclerView.c0.FLAG_TMP_DETACHED);
    }

    /* compiled from: ExploreByTouchHelper.java */
    public static class b implements b.InterfaceC0036b<h<a.h.j.h0.c>, a.h.j.h0.c> {
        @Override // a.j.a.b.InterfaceC0036b
        public a.h.j.h0.c a(h<a.h.j.h0.c> hVar, int i2) {
            return hVar.c(i2);
        }

        @Override // a.j.a.b.InterfaceC0036b
        public int a(h<a.h.j.h0.c> hVar) {
            return hVar.c();
        }
    }

    public final boolean d(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f1281h.isEnabled() || (parent = this.f1282i.getParent()) == null) {
            return false;
        }
        return b0.a(parent, this.f1282i, a(i2, i3));
    }

    public a.h.j.h0.c f(int i2) {
        return i2 == -1 ? c() : d(i2);
    }

    /* compiled from: ExploreByTouchHelper.java */
    public class c extends d {
        public c() {
        }

        @Override // a.h.j.h0.d
        public a.h.j.h0.c a(int i2) {
            return a.h.j.h0.c.a(a.this.f(i2));
        }

        @Override // a.h.j.h0.d
        public a.h.j.h0.c b(int i2) {
            int i3 = i2 == 2 ? a.this.k : a.this.l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i3);
        }

        @Override // a.h.j.h0.d
        public boolean a(int i2, int i3, Bundle bundle) {
            return a.this.b(i2, i3, bundle);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.f1281h.isEnabled() || !this.f1281h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7 && action != 9) {
            if (action != 10 || this.m == Integer.MIN_VALUE) {
                return false;
            }
            i(Integer.MIN_VALUE);
            return true;
        }
        int a2 = a(motionEvent.getX(), motionEvent.getY());
        i(a2);
        return a2 != Integer.MIN_VALUE;
    }

    public final AccessibilityEvent c(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.f1282i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public final a.h.j.h0.c d(int i2) {
        a.h.j.h0.c A = a.h.j.h0.c.A();
        A.f(true);
        A.g(true);
        A.a("android.view.View");
        A.c(n);
        A.d(n);
        A.e(this.f1282i);
        a(i2, A);
        if (A.i() == null && A.f() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        A.a(this.f1278e);
        if (!this.f1278e.equals(n)) {
            int c2 = A.c();
            if ((c2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            if ((c2 & RecyclerView.c0.FLAG_IGNORE) == 0) {
                A.e(this.f1282i.getContext().getPackageName());
                A.c(this.f1282i, i2);
                if (this.k == i2) {
                    A.a(true);
                    A.a(RecyclerView.c0.FLAG_IGNORE);
                } else {
                    A.a(false);
                    A.a(64);
                }
                boolean z = this.l == i2;
                if (z) {
                    A.a(2);
                } else if (A.q()) {
                    A.a(1);
                }
                A.h(z);
                this.f1282i.getLocationOnScreen(this.f1280g);
                A.b(this.f1277d);
                if (this.f1277d.equals(n)) {
                    A.a(this.f1277d);
                    if (A.f1172b != -1) {
                        a.h.j.h0.c A2 = a.h.j.h0.c.A();
                        for (int i3 = A.f1172b; i3 != -1; i3 = A2.f1172b) {
                            A2.b(this.f1282i, -1);
                            A2.c(n);
                            a(i3, A2);
                            A2.a(this.f1278e);
                            Rect rect = this.f1277d;
                            Rect rect2 = this.f1278e;
                            rect.offset(rect2.left, rect2.top);
                        }
                        A2.y();
                    }
                    this.f1277d.offset(this.f1280g[0] - this.f1282i.getScrollX(), this.f1280g[1] - this.f1282i.getScrollY());
                }
                if (this.f1282i.getLocalVisibleRect(this.f1279f)) {
                    this.f1279f.offset(this.f1280g[0] - this.f1282i.getScrollX(), this.f1280g[1] - this.f1282i.getScrollY());
                    if (this.f1277d.intersect(this.f1279f)) {
                        A.d(this.f1277d);
                        if (a(this.f1277d)) {
                            A.o(true);
                        }
                    }
                }
                return A;
            }
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public final void e(int i2) {
        c(i2, 0);
    }

    public final a.h.j.h0.c c() {
        a.h.j.h0.c g2 = a.h.j.h0.c.g(this.f1282i);
        y.a(this.f1282i, g2);
        ArrayList arrayList = new ArrayList();
        a(arrayList);
        if (g2.d() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            g2.a(this.f1282i, ((Integer) arrayList.get(i2)).intValue());
        }
        return g2;
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int j = j(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && b(j, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            b();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        }
        if (keyEvent.hasModifiers(1)) {
            return b(1, (Rect) null);
        }
        return false;
    }

    public final boolean b() {
        int i2 = this.l;
        return i2 != Integer.MIN_VALUE && a(i2, 16, (Bundle) null);
    }

    public final boolean c(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return h(i2);
        }
        if (i3 == 2) {
            return b(i2);
        }
        if (i3 == 64) {
            return g(i2);
        }
        if (i3 != 128) {
            return a(i2, i3, bundle);
        }
        return a(i2);
    }

    @Override // a.h.j.a
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        super.b(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    public final AccessibilityEvent b(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        a.h.j.h0.c f2 = f(i2);
        obtain.getText().add(f2.i());
        obtain.setContentDescription(f2.f());
        obtain.setScrollable(f2.u());
        obtain.setPassword(f2.t());
        obtain.setEnabled(f2.p());
        obtain.setChecked(f2.n());
        a(i2, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(f2.e());
        e.a(obtain, this.f1282i, i2);
        obtain.setPackageName(this.f1282i.getContext().getPackageName());
        return obtain;
    }

    public final void a(boolean z, int i2, Rect rect) {
        int i3 = this.l;
        if (i3 != Integer.MIN_VALUE) {
            b(i3);
        }
        if (z) {
            b(i2, rect);
        }
    }

    public final void a(int i2, Rect rect) {
        f(i2).a(rect);
    }

    public static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    public boolean b(int i2, int i3, Bundle bundle) {
        if (i2 != -1) {
            return c(i2, i3, bundle);
        }
        return a(i3, bundle);
    }

    public final AccessibilityEvent a(int i2, int i3) {
        if (i2 != -1) {
            return b(i2, i3);
        }
        return c(i3);
    }

    public final boolean b(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        a(i2, false);
        d(i2, 8);
        return true;
    }

    @Override // a.h.j.a
    public void a(View view, a.h.j.h0.c cVar) {
        super.a(view, cVar);
        a(cVar);
    }

    public final boolean a(int i2, Bundle bundle) {
        return y.a(this.f1282i, i2, bundle);
    }

    public final boolean a(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f1282i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f1282i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean a(int i2) {
        if (this.k != i2) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.f1282i.invalidate();
        d(i2, 65536);
        return true;
    }
}
