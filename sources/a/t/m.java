package a.t;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.R$id;

/* compiled from: GhostViewPort.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class m extends ViewGroup implements j {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f1845a;

    /* renamed from: b, reason: collision with root package name */
    public View f1846b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1847c;

    /* renamed from: d, reason: collision with root package name */
    public int f1848d;

    /* renamed from: e, reason: collision with root package name */
    public Matrix f1849e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f1850f;

    /* compiled from: GhostViewPort.java */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            a.h.j.y.N(m.this);
            m mVar = m.this;
            ViewGroup viewGroup = mVar.f1845a;
            if (viewGroup == null || (view = mVar.f1846b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            a.h.j.y.N(m.this.f1845a);
            m mVar2 = m.this;
            mVar2.f1845a = null;
            mVar2.f1846b = null;
            return true;
        }
    }

    public m(View view) {
        super(view.getContext());
        this.f1850f = new a();
        this.f1847c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static void b(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        m0.b(viewGroup2, matrix);
        matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
        m0.c(viewGroup, matrix);
    }

    public void a(Matrix matrix) {
        this.f1849e = matrix;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f1847c, this);
        this.f1847c.getViewTreeObserver().addOnPreDrawListener(this.f1850f);
        m0.a(this.f1847c, 4);
        if (this.f1847c.getParent() != null) {
            ((View) this.f1847c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1847c.getViewTreeObserver().removeOnPreDrawListener(this.f1850f);
        m0.a(this.f1847c, 0);
        a(this.f1847c, (m) null);
        if (this.f1847c.getParent() != null) {
            ((View) this.f1847c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        c.a(canvas, true);
        canvas.setMatrix(this.f1849e);
        m0.a(this.f1847c, 0);
        this.f1847c.invalidate();
        m0.a(this.f1847c, 4);
        drawChild(canvas, this.f1847c, getDrawingTime());
        c.a(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View, a.t.j
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (a(this.f1847c) == this) {
            m0.a(this.f1847c, i2 == 0 ? 4 : 0);
        }
    }

    @Override // a.t.j
    public void a(ViewGroup viewGroup, View view) {
        this.f1845a = viewGroup;
        this.f1846b = view;
    }

    public static void a(View view, View view2) {
        m0.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    public static void b(View view) {
        m a2 = a(view);
        if (a2 != null) {
            int i2 = a2.f1848d - 1;
            a2.f1848d = i2;
            if (i2 <= 0) {
                ((k) a2.getParent()).removeView(a2);
            }
        }
    }

    public static m a(View view) {
        return (m) view.getTag(R$id.ghost_view);
    }

    public static void a(View view, m mVar) {
        view.setTag(R$id.ghost_view, mVar);
    }

    public static m a(View view, ViewGroup viewGroup, Matrix matrix) {
        k kVar;
        if (view.getParent() instanceof ViewGroup) {
            k a2 = k.a(viewGroup);
            m a3 = a(view);
            int i2 = 0;
            if (a3 != null && (kVar = (k) a3.getParent()) != a2) {
                i2 = a3.f1848d;
                kVar.removeView(a3);
                a3 = null;
            }
            if (a3 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    b(view, viewGroup, matrix);
                }
                a3 = new m(view);
                a3.a(matrix);
                if (a2 == null) {
                    a2 = new k(viewGroup);
                } else {
                    a2.a();
                }
                a((View) viewGroup, (View) a2);
                a((View) viewGroup, (View) a3);
                a2.a(a3);
                a3.f1848d = i2;
            } else if (matrix != null) {
                a3.a(matrix);
            }
            a3.f1848d++;
            return a3;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }
}
