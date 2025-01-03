package c.c.a.c.r;

import a.h.j.g0;
import a.h.j.s;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.google.android.material.R$styleable;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class r {

    /* compiled from: ViewUtils.java */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5594a;

        public a(View view) {
            this.f5594a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.f5594a.getContext().getSystemService("input_method")).showSoftInput(this.f5594a, 1);
        }
    }

    /* compiled from: ViewUtils.java */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5595a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5596b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5597c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f5598d;

        public b(boolean z, boolean z2, boolean z3, e eVar) {
            this.f5595a = z;
            this.f5596b = z2;
            this.f5597c = z3;
            this.f5598d = eVar;
        }

        @Override // c.c.a.c.r.r.e
        public g0 a(View view, g0 g0Var, f fVar) {
            if (this.f5595a) {
                fVar.f5604d += g0Var.e();
            }
            boolean e2 = r.e(view);
            if (this.f5596b) {
                if (e2) {
                    fVar.f5603c += g0Var.f();
                } else {
                    fVar.f5601a += g0Var.f();
                }
            }
            if (this.f5597c) {
                if (e2) {
                    fVar.f5601a += g0Var.g();
                } else {
                    fVar.f5603c += g0Var.g();
                }
            }
            fVar.a(view);
            e eVar = this.f5598d;
            return eVar != null ? eVar.a(view, g0Var, fVar) : g0Var;
        }
    }

    /* compiled from: ViewUtils.java */
    public static class c implements s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f5599a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f5600b;

        public c(e eVar, f fVar) {
            this.f5599a = eVar;
            this.f5600b = fVar;
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            return this.f5599a.a(view, g0Var, new f(this.f5600b));
        }
    }

    /* compiled from: ViewUtils.java */
    public static class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            y.O(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* compiled from: ViewUtils.java */
    public interface e {
        g0 a(View view, g0 g0Var, f fVar);
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static q b(View view) {
        return c(a(view));
    }

    public static q c(View view) {
        if (view == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 18 ? new p(view) : o.a(view);
    }

    public static float d(View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += y.l((View) parent);
        }
        return f2;
    }

    public static boolean e(View view) {
        return y.q(view) == 1;
    }

    public static void f(View view) {
        if (y.I(view)) {
            y.O(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void g(View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* compiled from: ViewUtils.java */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public int f5601a;

        /* renamed from: b, reason: collision with root package name */
        public int f5602b;

        /* renamed from: c, reason: collision with root package name */
        public int f5603c;

        /* renamed from: d, reason: collision with root package name */
        public int f5604d;

        public f(int i2, int i3, int i4, int i5) {
            this.f5601a = i2;
            this.f5602b = i3;
            this.f5603c = i4;
            this.f5604d = i5;
        }

        public void a(View view) {
            y.a(view, this.f5601a, this.f5602b, this.f5603c, this.f5604d);
        }

        public f(f fVar) {
            this.f5601a = fVar.f5601a;
            this.f5602b = fVar.f5602b;
            this.f5603c = fVar.f5603c;
            this.f5604d = fVar.f5604d;
        }
    }

    public static float a(Context context, int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    public static void a(View view, AttributeSet attributeSet, int i2, int i3, e eVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.Insets, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R$styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R$styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R$styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        a(view, new b(z, z2, z3, eVar));
    }

    public static void a(View view, e eVar) {
        y.a(view, new c(eVar, new f(y.w(view), view.getPaddingTop(), y.v(view), view.getPaddingBottom())));
        f(view);
    }

    public static ViewGroup a(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }
}
