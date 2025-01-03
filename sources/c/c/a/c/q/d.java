package c.c.a.c.q;

import a.h.j.y;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import c.c.a.c.w.m;
import c.c.a.c.w.p;
import com.google.android.material.R$animator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public class d {
    public static final TimeInterpolator F = c.c.a.c.a.a.f5308c;
    public static final int[] G = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] I = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] J = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] K = {R.attr.state_enabled};
    public static final int[] L = new int[0];
    public ViewTreeObserver.OnPreDrawListener E;

    /* renamed from: a, reason: collision with root package name */
    public m f5503a;

    /* renamed from: b, reason: collision with root package name */
    public c.c.a.c.w.h f5504b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f5505c;

    /* renamed from: d, reason: collision with root package name */
    public c.c.a.c.q.c f5506d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f5507e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5508f;

    /* renamed from: h, reason: collision with root package name */
    public float f5510h;

    /* renamed from: i, reason: collision with root package name */
    public float f5511i;
    public float j;
    public int k;
    public final c.c.a.c.r.h l;
    public c.c.a.c.a.h m;
    public c.c.a.c.a.h n;
    public Animator o;
    public c.c.a.c.a.h p;
    public c.c.a.c.a.h q;
    public float r;
    public int t;
    public ArrayList<Animator.AnimatorListener> v;
    public ArrayList<Animator.AnimatorListener> w;
    public ArrayList<i> x;
    public final FloatingActionButton y;
    public final c.c.a.c.v.b z;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5509g = true;
    public float s = 1.0f;
    public int u = 0;
    public final Rect A = new Rect();
    public final RectF B = new RectF();
    public final RectF C = new RectF();
    public final Matrix D = new Matrix();

    /* compiled from: FloatingActionButtonImpl.java */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5512a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5513b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f5514c;

        public a(boolean z, j jVar) {
            this.f5513b = z;
            this.f5514c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5512a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            if (this.f5512a) {
                return;
            }
            d.this.y.a(this.f5513b ? 8 : 4, this.f5513b);
            j jVar = this.f5514c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.a(0, this.f5513b);
            d.this.u = 1;
            d.this.o = animator;
            this.f5512a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5516a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j f5517b;

        public b(boolean z, j jVar) {
            this.f5516a = z;
            this.f5517b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            j jVar = this.f5517b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.a(0, this.f5516a);
            d.this.u = 2;
            d.this.o = animator;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class c extends c.c.a.c.a.g {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            d.this.s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: c.c.a.c.q.d$d, reason: collision with other inner class name */
    public class C0104d implements TypeEvaluator<Float> {

        /* renamed from: a, reason: collision with root package name */
        public FloatEvaluator f5520a = new FloatEvaluator();

        public C0104d(d dVar) {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f2, Float f3, Float f4) {
            float floatValue = this.f5520a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.s();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class f extends l {
        public f(d dVar) {
            super(dVar, null);
        }

        @Override // c.c.a.c.q.d.l
        public float a() {
            return 0.0f;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class g extends l {
        public g() {
            super(d.this, null);
        }

        @Override // c.c.a.c.q.d.l
        public float a() {
            d dVar = d.this;
            return dVar.f5510h + dVar.f5511i;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class h extends l {
        public h() {
            super(d.this, null);
        }

        @Override // c.c.a.c.q.d.l
        public float a() {
            d dVar = d.this;
            return dVar.f5510h + dVar.j;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public interface i {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public interface j {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public class k extends l {
        public k() {
            super(d.this, null);
        }

        @Override // c.c.a.c.q.d.l
        public float a() {
            return d.this.f5510h;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    public abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f5525a;

        /* renamed from: b, reason: collision with root package name */
        public float f5526b;

        /* renamed from: c, reason: collision with root package name */
        public float f5527c;

        public l() {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.e((int) this.f5527c);
            this.f5525a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f5525a) {
                c.c.a.c.w.h hVar = d.this.f5504b;
                this.f5526b = hVar == null ? 0.0f : hVar.g();
                this.f5527c = a();
                this.f5525a = true;
            }
            d dVar = d.this;
            float f2 = this.f5526b;
            dVar.e((int) (f2 + ((this.f5527c - f2) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    public d(FloatingActionButton floatingActionButton, c.c.a.c.v.b bVar) {
        this.y = floatingActionButton;
        this.z = bVar;
        c.c.a.c.r.h hVar = new c.c.a.c.r.h();
        this.l = hVar;
        hVar.a(G, a((l) new h()));
        this.l.a(H, a((l) new g()));
        this.l.a(I, a((l) new g()));
        this.l.a(J, a((l) new g()));
        this.l.a(K, a((l) new k()));
        this.l.a(L, a((l) new f(this)));
        this.r = this.y.getRotation();
    }

    public final void A() {
        c(this.s);
    }

    public final void B() {
        Rect rect = this.A;
        a(rect);
        b(rect);
        this.z.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void b(int i2) {
        this.k = i2;
    }

    public final void c(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        a(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    public final void d(float f2) {
        if (this.j != f2) {
            this.j = f2;
            a(this.f5510h, this.f5511i, f2);
        }
    }

    public float e() {
        return this.f5510h;
    }

    public boolean f() {
        return this.f5508f;
    }

    public final c.c.a.c.a.h g() {
        return this.q;
    }

    public float h() {
        return this.f5511i;
    }

    public final ViewTreeObserver.OnPreDrawListener i() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    public float j() {
        return this.j;
    }

    public final m k() {
        return this.f5503a;
    }

    public final c.c.a.c.a.h l() {
        return this.p;
    }

    public boolean m() {
        return this.y.getVisibility() == 0 ? this.u == 1 : this.u != 2;
    }

    public boolean n() {
        return this.y.getVisibility() != 0 ? this.u == 2 : this.u != 1;
    }

    public void o() {
        this.l.b();
    }

    public void p() {
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            c.c.a.c.w.i.a(this.y, hVar);
        }
        if (v()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(i());
        }
    }

    public void q() {
    }

    public void r() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    public void s() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            z();
        }
    }

    public void t() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void u() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return true;
    }

    public final boolean x() {
        return y.J(this.y) && !this.y.isInEditMode();
    }

    public final boolean y() {
        return !this.f5508f || this.y.getSizeDimension() >= this.k;
    }

    public void z() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != 0.0f) {
                if (this.y.getLayerType() != 1) {
                    this.y.setLayerType(1, null);
                }
            } else if (this.y.getLayerType() != 0) {
                this.y.setLayerType(0, null);
            }
        }
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            hVar.c((int) this.r);
        }
    }

    public void b(ColorStateList colorStateList) {
        Drawable drawable = this.f5505c;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, c.c.a.c.u.b.b(colorStateList));
        }
    }

    public void e(float f2) {
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            hVar.b(f2);
        }
    }

    public void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        c.c.a.c.w.h a2 = a();
        this.f5504b = a2;
        a2.setTintList(colorStateList);
        if (mode != null) {
            this.f5504b.setTintMode(mode);
        }
        this.f5504b.b(-12303292);
        this.f5504b.a(this.y.getContext());
        c.c.a.c.u.a aVar = new c.c.a.c.u.a(this.f5504b.n());
        aVar.setTintList(c.c.a.c.u.b.b(colorStateList2));
        this.f5505c = aVar;
        c.c.a.c.w.h hVar = this.f5504b;
        a.h.i.h.a(hVar);
        this.f5507e = new LayerDrawable(new Drawable[]{hVar, aVar});
    }

    public final c.c.a.c.a.h d() {
        if (this.m == null) {
            this.m = c.c.a.c.a.h.a(this.y.getContext(), R$animator.design_fab_show_motion_spec);
        }
        c.c.a.c.a.h hVar = this.m;
        a.h.i.h.a(hVar);
        return hVar;
    }

    public final void b(float f2) {
        if (this.f5511i != f2) {
            this.f5511i = f2;
            a(this.f5510h, f2, this.j);
        }
    }

    public final c.c.a.c.a.h c() {
        if (this.n == null) {
            this.n = c.c.a.c.a.h.a(this.y.getContext(), R$animator.design_fab_hide_motion_spec);
        }
        c.c.a.c.a.h hVar = this.n;
        a.h.i.h.a(hVar);
        return hVar;
    }

    public final void b(c.c.a.c.a.h hVar) {
        this.p = hVar;
    }

    public void b(boolean z) {
        this.f5509g = z;
        B();
    }

    public void b(Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    public void b(j jVar, boolean z) {
        if (n()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (x()) {
            if (this.y.getVisibility() != 0) {
                this.y.setAlpha(0.0f);
                this.y.setScaleY(0.0f);
                this.y.setScaleX(0.0f);
                c(0.0f);
            }
            c.c.a.c.a.h hVar = this.p;
            if (hVar == null) {
                hVar = d();
            }
            AnimatorSet a2 = a(hVar, 1.0f, 1.0f, 1.0f);
            a2.addListener(new b(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.v;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.y.a(0, z);
        this.y.setAlpha(1.0f);
        this.y.setScaleY(1.0f);
        this.y.setScaleX(1.0f);
        c(1.0f);
        if (jVar != null) {
            jVar.a();
        }
    }

    public void a(ColorStateList colorStateList) {
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            hVar.setTintList(colorStateList);
        }
        c.c.a.c.q.c cVar = this.f5506d;
        if (cVar != null) {
            cVar.a(colorStateList);
        }
    }

    public void a(PorterDuff.Mode mode) {
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            hVar.setTintMode(mode);
        }
    }

    public final void a(float f2) {
        if (this.f5510h != f2) {
            this.f5510h = f2;
            a(f2, this.f5511i, this.j);
        }
    }

    public final void a(int i2) {
        if (this.t != i2) {
            this.t = i2;
            A();
        }
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.y.getDrawable() == null || this.t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    public final void a(m mVar) {
        this.f5503a = mVar;
        c.c.a.c.w.h hVar = this.f5504b;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        Object obj = this.f5505c;
        if (obj instanceof p) {
            ((p) obj).setShapeAppearanceModel(mVar);
        }
        c.c.a.c.q.c cVar = this.f5506d;
        if (cVar != null) {
            cVar.a(mVar);
        }
    }

    public final Drawable b() {
        return this.f5507e;
    }

    public void b(Rect rect) {
        a.h.i.h.a(this.f5507e, "Didn't initialize content background");
        if (w()) {
            this.z.a(new InsetDrawable(this.f5507e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.z.a(this.f5507e);
        }
    }

    public final void a(c.c.a.c.a.h hVar) {
        this.q = hVar;
    }

    public void a(boolean z) {
        this.f5508f = z;
    }

    public void a(float f2, float f3, float f4) {
        B();
        e(f2);
    }

    public void a(int[] iArr) {
        this.l.a(iArr);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    public void a(j jVar, boolean z) {
        if (m()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (x()) {
            c.c.a.c.a.h hVar = this.q;
            if (hVar == null) {
                hVar = c();
            }
            AnimatorSet a2 = a(hVar, 0.0f, 0.0f, 0.0f);
            a2.addListener(new a(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.w;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    a2.addListener(it.next());
                }
            }
            a2.start();
            return;
        }
        this.y.a(z ? 8 : 4, z);
        if (jVar != null) {
            jVar.b();
        }
    }

    public final AnimatorSet a(c.c.a.c.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) ofFloat2);
        a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) ofFloat3);
        a(ofFloat3);
        arrayList.add(ofFloat3);
        a(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new c.c.a.c.a.f(), new c(), new Matrix(this.D));
        hVar.b("iconScale").a((Animator) ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c.c.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final void a(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0104d(this));
    }

    public void a(i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    public void a(Rect rect) {
        int sizeDimension = this.f5508f ? (this.k - this.y.getSizeDimension()) / 2 : 0;
        int max = Math.max(sizeDimension, (int) Math.ceil(this.f5509g ? e() + this.j : 0.0f));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public c.c.a.c.w.h a() {
        m mVar = this.f5503a;
        a.h.i.h.a(mVar);
        return new c.c.a.c.w.h(mVar);
    }

    public final ValueAnimator a(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }
}
