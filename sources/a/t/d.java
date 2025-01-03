package a.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class d extends w {
    public static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> P = new c(PointF.class, "topLeft");
    public static final Property<k, PointF> Q = new C0053d(PointF.class, "bottomRight");
    public static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    public static final Property<View, PointF> T = new g(PointF.class, "position");
    public static u U = new u();
    public int[] K = new int[2];
    public boolean L = false;
    public boolean M = false;

    /* compiled from: ChangeBounds.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1755a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f1756b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f1757c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f1758d;

        public a(d dVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f1755a = viewGroup;
            this.f1756b = bitmapDrawable;
            this.f1757c = view;
            this.f1758d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m0.b(this.f1755a).b(this.f1756b);
            m0.a(this.f1757c, this.f1758d);
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class c extends Property<k, PointF> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.b(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.t.d$d, reason: collision with other inner class name */
    public static class C0053d extends Property<k, PointF> {
        public C0053d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            m0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            m0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            m0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f1760a;
        public k mViewBounds;

        public h(d dVar, k kVar) {
            this.f1760a = kVar;
            this.mViewBounds = this.f1760a;
        }
    }

    /* compiled from: ChangeBounds.java */
    public class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1761a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1762b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f1763c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f1764d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f1765e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f1766f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f1767g;

        public i(d dVar, View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f1762b = view;
            this.f1763c = rect;
            this.f1764d = i2;
            this.f1765e = i3;
            this.f1766f = i4;
            this.f1767g = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1761a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1761a) {
                return;
            }
            a.h.j.y.a(this.f1762b, this.f1763c);
            m0.a(this.f1762b, this.f1764d, this.f1765e, this.f1766f, this.f1767g);
        }
    }

    /* compiled from: ChangeBounds.java */
    public class j extends x {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1768a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f1769b;

        public j(d dVar, ViewGroup viewGroup) {
            this.f1769b = viewGroup;
        }

        @Override // a.t.x, a.t.w.f
        public void b(w wVar) {
            h0.b(this.f1769b, false);
            this.f1768a = true;
        }

        @Override // a.t.x, a.t.w.f
        public void c(w wVar) {
            h0.b(this.f1769b, false);
        }

        @Override // a.t.x, a.t.w.f
        public void d(w wVar) {
            h0.b(this.f1769b, true);
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            if (!this.f1768a) {
                h0.b(this.f1769b, false);
            }
            wVar.b(this);
        }
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        d(c0Var);
    }

    @Override // a.t.w
    public void c(c0 c0Var) {
        d(c0Var);
    }

    public final void d(c0 c0Var) {
        View view = c0Var.f1753b;
        if (!a.h.j.y.J(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c0Var.f1752a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c0Var.f1752a.put("android:changeBounds:parent", c0Var.f1753b.getParent());
        if (this.M) {
            c0Var.f1753b.getLocationInWindow(this.K);
            c0Var.f1752a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
            c0Var.f1752a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
        }
        if (this.L) {
            c0Var.f1752a.put("android:changeBounds:clip", a.h.j.y.j(view));
        }
    }

    @Override // a.t.w
    public String[] m() {
        return N;
    }

    public final boolean a(View view, View view2) {
        if (!this.M) {
            return true;
        }
        c0 b2 = b(view, true);
        if (b2 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == b2.f1753b) {
            return true;
        }
        return false;
    }

    /* compiled from: ChangeBounds.java */
    public static class b extends Property<Drawable, PointF> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f1759a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f1759a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f1759a);
            this.f1759a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f1759a);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f1759a);
            Rect rect = this.f1759a;
            return new PointF(rect.left, rect.top);
        }
    }

    /* compiled from: ChangeBounds.java */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public int f1770a;

        /* renamed from: b, reason: collision with root package name */
        public int f1771b;

        /* renamed from: c, reason: collision with root package name */
        public int f1772c;

        /* renamed from: d, reason: collision with root package name */
        public int f1773d;

        /* renamed from: e, reason: collision with root package name */
        public View f1774e;

        /* renamed from: f, reason: collision with root package name */
        public int f1775f;

        /* renamed from: g, reason: collision with root package name */
        public int f1776g;

        public k(View view) {
            this.f1774e = view;
        }

        public void a(PointF pointF) {
            this.f1772c = Math.round(pointF.x);
            this.f1773d = Math.round(pointF.y);
            int i2 = this.f1776g + 1;
            this.f1776g = i2;
            if (this.f1775f == i2) {
                a();
            }
        }

        public void b(PointF pointF) {
            this.f1770a = Math.round(pointF.x);
            this.f1771b = Math.round(pointF.y);
            int i2 = this.f1775f + 1;
            this.f1775f = i2;
            if (i2 == this.f1776g) {
                a();
            }
        }

        public final void a() {
            m0.a(this.f1774e, this.f1770a, this.f1771b, this.f1772c, this.f1773d);
            this.f1775f = 0;
            this.f1776g = 0;
        }
    }

    @Override // a.t.w
    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (c0Var == null || c0Var2 == null) {
            return null;
        }
        Map<String, Object> map = c0Var.f1752a;
        Map<String, Object> map2 = c0Var2.f1752a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c0Var2.f1753b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) c0Var.f1752a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) c0Var2.f1752a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) c0Var.f1752a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) c0Var2.f1752a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            if (!this.L) {
                view = view2;
                m0.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        a2 = q.a(view, T, f().a(i4, i6, i5, i7));
                    } else {
                        k kVar = new k(view);
                        ObjectAnimator a3 = q.a(kVar, P, f().a(i4, i6, i5, i7));
                        ObjectAnimator a4 = q.a(kVar, Q, f().a(i8, i10, i9, i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(a3, a4);
                        animatorSet.addListener(new h(this, kVar));
                        a2 = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    a2 = q.a(view, R, f().a(i8, i10, i9, i11));
                } else {
                    a2 = q.a(view, S, f().a(i4, i6, i5, i7));
                }
            } else {
                view = view2;
                m0.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                ObjectAnimator a5 = (i4 == i5 && i6 == i7) ? null : q.a(view, T, f().a(i4, i6, i5, i7));
                if (rect4 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimator = null;
                } else {
                    a.h.j.y.a(view, rect);
                    u uVar = U;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", uVar, objArr);
                    ofObject.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                    objectAnimator = ofObject;
                }
                a2 = b0.a(a5, objectAnimator);
            }
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                h0.b(viewGroup4, true);
                a(new j(this, viewGroup4));
            }
            return a2;
        }
        int intValue = ((Integer) c0Var.f1752a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) c0Var.f1752a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) c0Var2.f1752a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) c0Var2.f1752a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.K);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = m0.c(view2);
        m0.a(view2, 0.0f);
        m0.b(viewGroup).a(bitmapDrawable);
        r f2 = f();
        int[] iArr = this.K;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, t.a(O, f2.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }
}
