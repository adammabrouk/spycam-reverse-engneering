package a.t;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;

/* compiled from: ChangeTransform.java */
/* loaded from: classes.dex */
public class f extends w {
    public static final String[] N = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
    public static final Property<e, float[]> O = new a(float[].class, "nonTranslations");
    public static final Property<e, PointF> P = new b(PointF.class, "translations");
    public static final boolean Q;
    public boolean K = true;
    public boolean L = true;
    public Matrix M = new Matrix();

    /* compiled from: ChangeTransform.java */
    public static class a extends Property<e, float[]> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, float[] fArr) {
            eVar.a(fArr);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(e eVar) {
            return null;
        }
    }

    /* compiled from: ChangeTransform.java */
    public static class b extends Property<e, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(e eVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, PointF pointF) {
            eVar.a(pointF);
        }
    }

    /* compiled from: ChangeTransform.java */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1782a;

        /* renamed from: b, reason: collision with root package name */
        public Matrix f1783b = new Matrix();

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f1784c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f1785d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f1786e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ C0054f f1787f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f1788g;

        public c(boolean z, Matrix matrix, View view, C0054f c0054f, e eVar) {
            this.f1784c = z;
            this.f1785d = matrix;
            this.f1786e = view;
            this.f1787f = c0054f;
            this.f1788g = eVar;
        }

        public final void a(Matrix matrix) {
            this.f1783b.set(matrix);
            this.f1786e.setTag(R$id.transition_transform, this.f1783b);
            this.f1787f.a(this.f1786e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1782a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f1782a) {
                if (this.f1784c && f.this.K) {
                    a(this.f1785d);
                } else {
                    this.f1786e.setTag(R$id.transition_transform, null);
                    this.f1786e.setTag(R$id.parent_matrix, null);
                }
            }
            m0.a(this.f1786e, (Matrix) null);
            this.f1787f.a(this.f1786e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(this.f1788g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            f.f(this.f1786e);
        }
    }

    /* compiled from: ChangeTransform.java */
    public static class d extends x {

        /* renamed from: a, reason: collision with root package name */
        public View f1790a;

        /* renamed from: b, reason: collision with root package name */
        public j f1791b;

        public d(View view, j jVar) {
            this.f1790a = view;
            this.f1791b = jVar;
        }

        @Override // a.t.x, a.t.w.f
        public void c(w wVar) {
            this.f1791b.setVisibility(4);
        }

        @Override // a.t.x, a.t.w.f
        public void d(w wVar) {
            this.f1791b.setVisibility(0);
        }

        @Override // a.t.w.f
        public void e(w wVar) {
            wVar.b(this);
            n.a(this.f1790a);
            this.f1790a.setTag(R$id.transition_transform, null);
            this.f1790a.setTag(R$id.parent_matrix, null);
        }
    }

    /* compiled from: ChangeTransform.java */
    /* renamed from: a.t.f$f, reason: collision with other inner class name */
    public static class C0054f {

        /* renamed from: a, reason: collision with root package name */
        public final float f1797a;

        /* renamed from: b, reason: collision with root package name */
        public final float f1798b;

        /* renamed from: c, reason: collision with root package name */
        public final float f1799c;

        /* renamed from: d, reason: collision with root package name */
        public final float f1800d;

        /* renamed from: e, reason: collision with root package name */
        public final float f1801e;

        /* renamed from: f, reason: collision with root package name */
        public final float f1802f;

        /* renamed from: g, reason: collision with root package name */
        public final float f1803g;

        /* renamed from: h, reason: collision with root package name */
        public final float f1804h;

        public C0054f(View view) {
            this.f1797a = view.getTranslationX();
            this.f1798b = view.getTranslationY();
            this.f1799c = a.h.j.y.B(view);
            this.f1800d = view.getScaleX();
            this.f1801e = view.getScaleY();
            this.f1802f = view.getRotationX();
            this.f1803g = view.getRotationY();
            this.f1804h = view.getRotation();
        }

        public void a(View view) {
            f.a(view, this.f1797a, this.f1798b, this.f1799c, this.f1800d, this.f1801e, this.f1802f, this.f1803g, this.f1804h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0054f)) {
                return false;
            }
            C0054f c0054f = (C0054f) obj;
            return c0054f.f1797a == this.f1797a && c0054f.f1798b == this.f1798b && c0054f.f1799c == this.f1799c && c0054f.f1800d == this.f1800d && c0054f.f1801e == this.f1801e && c0054f.f1802f == this.f1802f && c0054f.f1803g == this.f1803g && c0054f.f1804h == this.f1804h;
        }

        public int hashCode() {
            float f2 = this.f1797a;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f1798b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f1799c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f1800d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f1801e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f1802f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f1803g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f1804h;
            return floatToIntBits7 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0);
        }
    }

    static {
        Q = Build.VERSION.SDK_INT >= 21;
    }

    public static void f(View view) {
        a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // a.t.w
    public void a(c0 c0Var) {
        d(c0Var);
    }

    public final void b(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        View view = c0Var2.f1753b;
        Matrix matrix = new Matrix((Matrix) c0Var2.f1752a.get("android:changeTransform:parentMatrix"));
        m0.c(viewGroup, matrix);
        j a2 = n.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.a((ViewGroup) c0Var.f1752a.get("android:changeTransform:parent"), c0Var.f1753b);
        w wVar = this;
        while (true) {
            w wVar2 = wVar.r;
            if (wVar2 == null) {
                break;
            } else {
                wVar = wVar2;
            }
        }
        wVar.a(new d(view, a2));
        if (Q) {
            View view2 = c0Var.f1753b;
            if (view2 != c0Var2.f1753b) {
                m0.a(view2, 0.0f);
            }
            m0.a(view, 1.0f);
        }
    }

    @Override // a.t.w
    public void c(c0 c0Var) {
        d(c0Var);
        if (Q) {
            return;
        }
        ((ViewGroup) c0Var.f1753b.getParent()).startViewTransition(c0Var.f1753b);
    }

    public final void d(c0 c0Var) {
        View view = c0Var.f1753b;
        if (view.getVisibility() == 8) {
            return;
        }
        c0Var.f1752a.put("android:changeTransform:parent", view.getParent());
        c0Var.f1752a.put("android:changeTransform:transforms", new C0054f(view));
        Matrix matrix = view.getMatrix();
        c0Var.f1752a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.L) {
            Matrix matrix2 = new Matrix();
            m0.b((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            c0Var.f1752a.put("android:changeTransform:parentMatrix", matrix2);
            c0Var.f1752a.put("android:changeTransform:intermediateMatrix", view.getTag(R$id.transition_transform));
            c0Var.f1752a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R$id.parent_matrix));
        }
    }

    @Override // a.t.w
    public String[] m() {
        return N;
    }

    /* compiled from: ChangeTransform.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f1792a = new Matrix();

        /* renamed from: b, reason: collision with root package name */
        public final View f1793b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f1794c;

        /* renamed from: d, reason: collision with root package name */
        public float f1795d;

        /* renamed from: e, reason: collision with root package name */
        public float f1796e;

        public e(View view, float[] fArr) {
            this.f1793b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f1794c = fArr2;
            this.f1795d = fArr2[2];
            this.f1796e = fArr2[5];
            b();
        }

        public void a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f1794c, 0, fArr.length);
            b();
        }

        public final void b() {
            float[] fArr = this.f1794c;
            fArr[2] = this.f1795d;
            fArr[5] = this.f1796e;
            this.f1792a.setValues(fArr);
            m0.a(this.f1793b, this.f1792a);
        }

        public void a(PointF pointF) {
            this.f1795d = pointF.x;
            this.f1796e = pointF.y;
            b();
        }

        public Matrix a() {
            return this.f1792a;
        }
    }

    @Override // a.t.w
    public Animator a(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null || !c0Var.f1752a.containsKey("android:changeTransform:parent") || !c0Var2.f1752a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) c0Var.f1752a.get("android:changeTransform:parent");
        boolean z = this.L && !a(viewGroup2, (ViewGroup) c0Var2.f1752a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) c0Var.f1752a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            c0Var.f1752a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) c0Var.f1752a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            c0Var.f1752a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            b(c0Var, c0Var2);
        }
        ObjectAnimator a2 = a(c0Var, c0Var2, z);
        if (z && a2 != null && this.K) {
            b(viewGroup, c0Var, c0Var2);
        } else if (!Q) {
            viewGroup2.endViewTransition(c0Var.f1753b);
        }
        return a2;
    }

    public final void b(c0 c0Var, c0 c0Var2) {
        Matrix matrix = (Matrix) c0Var2.f1752a.get("android:changeTransform:parentMatrix");
        c0Var2.f1753b.setTag(R$id.parent_matrix, matrix);
        Matrix matrix2 = this.M;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) c0Var.f1752a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            c0Var.f1752a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) c0Var.f1752a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    public final ObjectAnimator a(c0 c0Var, c0 c0Var2, boolean z) {
        Matrix matrix = (Matrix) c0Var.f1752a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) c0Var2.f1752a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = p.f1861a;
        }
        if (matrix2 == null) {
            matrix2 = p.f1861a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        C0054f c0054f = (C0054f) c0Var2.f1752a.get("android:changeTransform:transforms");
        View view = c0Var2.f1753b;
        f(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        e eVar = new e(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(eVar, PropertyValuesHolder.ofObject(O, new h(new float[9]), fArr, fArr2), t.a(P, f().a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        c cVar = new c(z, matrix3, view, c0054f, eVar);
        ofPropertyValuesHolder.addListener(cVar);
        a.t.a.a(ofPropertyValuesHolder, cVar);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r4 == r5) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5 == r4.f1753b) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.b(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r3.b(r5)
            if (r0 != 0) goto Lf
            goto L1a
        Lf:
            a.t.c0 r4 = r3.b(r4, r1)
            if (r4 == 0) goto L1f
            android.view.View r4 = r4.f1753b
            if (r5 != r4) goto L1d
            goto L1e
        L1a:
            if (r4 != r5) goto L1d
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r2 = r1
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.t.f.a(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    public static void a(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        a.h.j.y.b(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }
}
