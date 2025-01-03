package a.t;

import a.t.a;
import a.t.w;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class t0 extends w {
    public static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    public int K = 3;

    /* compiled from: Visibility.java */
    public class a extends x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1873a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1874b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1875c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f1873a = viewGroup;
            this.f1874b = view;
            this.f1875c = view2;
        }

        @Override // a.t.x, a.t.w.f
        public void c(w wVar) {
            h0.a(this.f1873a).b(this.f1874b);
        }

        @Override // a.t.x, a.t.w.f
        public void d(w wVar) {
            if (this.f1874b.getParent() == null) {
                h0.a(this.f1873a).a(this.f1874b);
            } else {
                t0.this.cancel();
            }
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            this.f1875c.setTag(R$id.save_overlay_view, null);
            h0.a(this.f1873a).b(this.f1874b);
            wVar.b(this);
        }
    }

    /* compiled from: Visibility.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1883a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1884b;

        /* renamed from: c, reason: collision with root package name */
        public int f1885c;

        /* renamed from: d, reason: collision with root package name */
        public int f1886d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f1887e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f1888f;
    }

    public abstract Animator a(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    public void a(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.K = i2;
    }

    public final c b(c0 c0Var, c0 c0Var2) {
        c cVar = new c();
        cVar.f1883a = false;
        cVar.f1884b = false;
        if (c0Var == null || !c0Var.f1752a.containsKey("android:visibility:visibility")) {
            cVar.f1885c = -1;
            cVar.f1887e = null;
        } else {
            cVar.f1885c = ((Integer) c0Var.f1752a.get("android:visibility:visibility")).intValue();
            cVar.f1887e = (ViewGroup) c0Var.f1752a.get("android:visibility:parent");
        }
        if (c0Var2 == null || !c0Var2.f1752a.containsKey("android:visibility:visibility")) {
            cVar.f1886d = -1;
            cVar.f1888f = null;
        } else {
            cVar.f1886d = ((Integer) c0Var2.f1752a.get("android:visibility:visibility")).intValue();
            cVar.f1888f = (ViewGroup) c0Var2.f1752a.get("android:visibility:parent");
        }
        if (c0Var == null || c0Var2 == null) {
            if (c0Var == null && cVar.f1886d == 0) {
                cVar.f1884b = true;
                cVar.f1883a = true;
            } else if (c0Var2 == null && cVar.f1885c == 0) {
                cVar.f1884b = false;
                cVar.f1883a = true;
            }
        } else {
            if (cVar.f1885c == cVar.f1886d && cVar.f1887e == cVar.f1888f) {
                return cVar;
            }
            int i2 = cVar.f1885c;
            int i3 = cVar.f1886d;
            if (i2 != i3) {
                if (i2 == 0) {
                    cVar.f1884b = false;
                    cVar.f1883a = true;
                } else if (i3 == 0) {
                    cVar.f1884b = true;
                    cVar.f1883a = true;
                }
            } else if (cVar.f1888f == null) {
                cVar.f1884b = false;
                cVar.f1883a = true;
            } else if (cVar.f1887e == null) {
                cVar.f1884b = true;
                cVar.f1883a = true;
            }
        }
        return cVar;
    }

    public abstract Animator b(ViewGroup viewGroup, View view, c0 c0Var, c0 c0Var2);

    @Override // a.t.w
    public void c(c0 c0Var) {
        d(c0Var);
    }

    public final void d(c0 c0Var) {
        c0Var.f1752a.put("android:visibility:visibility", Integer.valueOf(c0Var.f1753b.getVisibility()));
        c0Var.f1752a.put("android:visibility:parent", c0Var.f1753b.getParent());
        int[] iArr = new int[2];
        c0Var.f1753b.getLocationOnScreen(iArr);
        c0Var.f1752a.put("android:visibility:screenLocation", iArr);
    }

    @Override // a.t.w
    public String[] m() {
        return L;
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        d(c0Var);
    }

    @Override // a.t.w
    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        c b2 = b(c0Var, c0Var2);
        if (!b2.f1883a) {
            return null;
        }
        if (b2.f1887e == null && b2.f1888f == null) {
            return null;
        }
        if (b2.f1884b) {
            return a(viewGroup, c0Var, b2.f1885c, c0Var2, b2.f1886d);
        }
        return b(viewGroup, c0Var, b2.f1885c, c0Var2, b2.f1886d);
    }

    /* compiled from: Visibility.java */
    public static class b extends AnimatorListenerAdapter implements w.f, a.InterfaceC0052a {

        /* renamed from: a, reason: collision with root package name */
        public final View f1877a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1878b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f1879c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1880d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1881e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f1882f = false;

        public b(View view, int i2, boolean z) {
            this.f1877a = view;
            this.f1878b = i2;
            this.f1879c = (ViewGroup) view.getParent();
            this.f1880d = z;
            a(true);
        }

        public final void a() {
            if (!this.f1882f) {
                m0.a(this.f1877a, this.f1878b);
                ViewGroup viewGroup = this.f1879c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        @Override // a.t.w.f
        public void a(w wVar) {
        }

        @Override // a.t.w.f
        public void b(w wVar) {
        }

        @Override // a.t.w.f
        public void c(w wVar) {
            a(false);
        }

        @Override // a.t.w.f
        public void d(w wVar) {
            a(true);
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            a();
            wVar.b(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1882f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.t.a.InterfaceC0052a
        public void onAnimationPause(Animator animator) {
            if (this.f1882f) {
                return;
            }
            m0.a(this.f1877a, this.f1878b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.t.a.InterfaceC0052a
        public void onAnimationResume(Animator animator) {
            if (this.f1882f) {
                return;
            }
            m0.a(this.f1877a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public final void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f1880d || this.f1881e == z || (viewGroup = this.f1879c) == null) {
                return;
            }
            this.f1881e = z;
            h0.b(viewGroup, z);
        }
    }

    public Animator a(ViewGroup viewGroup, c0 c0Var, int i2, c0 c0Var2, int i3) {
        if ((this.K & 1) != 1 || c0Var2 == null) {
            return null;
        }
        if (c0Var == null) {
            View view = (View) c0Var2.f1753b.getParent();
            if (b(b(view, false), c(view, false)).f1883a) {
                return null;
            }
        }
        return a(viewGroup, c0Var2.f1753b, c0Var, c0Var2);
    }

    @Override // a.t.w
    public boolean a(c0 c0Var, c0 c0Var2) {
        if (c0Var == null && c0Var2 == null) {
            return false;
        }
        if (c0Var != null && c0Var2 != null && c0Var2.f1752a.containsKey("android:visibility:visibility") != c0Var.f1752a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c b2 = b(c0Var, c0Var2);
        if (b2.f1883a) {
            return b2.f1885c == 0 || b2.f1886d == 0;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x007f, code lost:
    
        if (r10.w != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator b(android.view.ViewGroup r11, a.t.c0 r12, int r13, a.t.c0 r14, int r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.t0.b(android.view.ViewGroup, a.t.c0, int, a.t.c0, int):android.animation.Animator");
    }
}
