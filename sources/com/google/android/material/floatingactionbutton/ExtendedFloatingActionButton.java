package com.google.android.material.floatingactionbutton;

import a.h.j.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.r.l;
import c.c.a.c.w.m;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final int A = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> B = new d(Float.class, "width");
    public static final Property<View, Float> C = new e(Float.class, "height");
    public int r;
    public final c.c.a.c.q.a t;
    public final c.c.a.c.q.f u;
    public final c.c.a.c.q.f v;
    public final c.c.a.c.q.f w;
    public final c.c.a.c.q.f x;
    public final CoordinatorLayout.c<ExtendedFloatingActionButton> y;
    public boolean z;

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f10496a;

        /* renamed from: b, reason: collision with root package name */
        public h f10497b;

        /* renamed from: c, reason: collision with root package name */
        public h f10498c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f10499d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10500e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f10499d = false;
            this.f10500e = true;
        }

        public final boolean b(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f10499d = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f10500e = obtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout.f fVar) {
            if (fVar.f2450h == 0) {
                fVar.f2450h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, extendedFloatingActionButton);
            return false;
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.a(this.f10500e ? extendedFloatingActionButton.u : extendedFloatingActionButton.x, this.f10500e ? this.f10498c : this.f10497b);
        }

        public static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f10499d || this.f10500e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).c() == view.getId();
        }

        public final boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f10496a == null) {
                this.f10496a = new Rect();
            }
            Rect rect = this.f10496a;
            c.c.a.c.r.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.a(this.f10500e ? extendedFloatingActionButton.v : extendedFloatingActionButton.w, this.f10500e ? this.f10498c : this.f10497b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> b2 = coordinatorLayout.b(extendedFloatingActionButton);
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = b2.get(i3);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.d(extendedFloatingActionButton, i2);
            return true;
        }
    }

    public class a implements j {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int a() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int b() {
            return ExtendedFloatingActionButton.this.getMeasuredWidth();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(-2, -2);
        }
    }

    public class b implements j {
        public b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public int b() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.j
        public ViewGroup.LayoutParams c() {
            return new ViewGroup.LayoutParams(b(), a());
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10503a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.q.f f10504b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f10505c;

        public c(ExtendedFloatingActionButton extendedFloatingActionButton, c.c.a.c.q.f fVar, h hVar) {
            this.f10504b = fVar;
            this.f10505c = hVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10503a = true;
            this.f10504b.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10504b.a();
            if (this.f10503a) {
                return;
            }
            this.f10504b.a(this.f10505c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f10504b.onAnimationStart(animator);
            this.f10503a = false;
        }
    }

    public class g extends c.c.a.c.q.b {

        /* renamed from: g, reason: collision with root package name */
        public boolean f10509g;

        public g(c.c.a.c.q.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // c.c.a.c.q.f
        public void a(h hVar) {
            if (hVar != null) {
                hVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void b() {
            super.b();
            this.f10509g = true;
        }

        @Override // c.c.a.c.q.f
        public int c() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // c.c.a.c.q.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // c.c.a.c.q.f
        public boolean h() {
            return ExtendedFloatingActionButton.this.e();
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f10509g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.r = 1;
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.r = 0;
            if (this.f10509g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }
    }

    public static abstract class h {
        public abstract void a(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void b(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void c(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void d(ExtendedFloatingActionButton extendedFloatingActionButton);
    }

    public class i extends c.c.a.c.q.b {
        public i(c.c.a.c.q.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // c.c.a.c.q.f
        public void a(h hVar) {
            if (hVar != null) {
                hVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // c.c.a.c.q.f
        public int c() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // c.c.a.c.q.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // c.c.a.c.q.f
        public boolean h() {
            return ExtendedFloatingActionButton.this.f();
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.r = 2;
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.r = 0;
        }
    }

    public interface j {
        int a();

        int b();

        ViewGroup.LayoutParams c();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.y;
    }

    public int getCollapsedSize() {
        return (Math.min(y.w(this), y.v(this)) * 2) + getIconSize();
    }

    public c.c.a.c.a.h getExtendMotionSpec() {
        return this.v.e();
    }

    public c.c.a.c.a.h getHideMotionSpec() {
        return this.x.e();
    }

    public c.c.a.c.a.h getShowMotionSpec() {
        return this.w.e();
    }

    public c.c.a.c.a.h getShrinkMotionSpec() {
        return this.u.e();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.z && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.z = false;
            this.u.d();
        }
    }

    public void setExtendMotionSpec(c.c.a.c.a.h hVar) {
        this.v.a(hVar);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.z == z) {
            return;
        }
        c.c.a.c.q.f fVar = z ? this.v : this.u;
        if (fVar.h()) {
            return;
        }
        fVar.d();
    }

    public void setHideMotionSpec(c.c.a.c.a.h hVar) {
        this.x.a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    public void setShowMotionSpec(c.c.a.c.a.h hVar) {
        this.w.a(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    public void setShrinkMotionSpec(c.c.a.c.a.h hVar) {
        this.u.a(hVar);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }
    }

    public static class e extends Property<View, Float> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public final boolean e() {
        return getVisibility() == 0 ? this.r == 1 : this.r != 2;
    }

    public final boolean f() {
        return getVisibility() != 0 ? this.r == 2 : this.r != 1;
    }

    public final boolean g() {
        return y.J(this) && !isInEditMode();
    }

    public class f extends c.c.a.c.q.b {

        /* renamed from: g, reason: collision with root package name */
        public final j f10506g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f10507h;

        public f(c.c.a.c.q.a aVar, j jVar, boolean z) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f10506g = jVar;
            this.f10507h = z;
        }

        @Override // c.c.a.c.q.f
        public void a(h hVar) {
            if (hVar == null) {
                return;
            }
            if (this.f10507h) {
                hVar.a(ExtendedFloatingActionButton.this);
            } else {
                hVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // c.c.a.c.q.f
        public int c() {
            return R$animator.mtrl_extended_fab_change_size_motion_spec;
        }

        @Override // c.c.a.c.q.f
        public void d() {
            ExtendedFloatingActionButton.this.z = this.f10507h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f10506g.c().width;
            layoutParams.height = this.f10506g.c().height;
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public AnimatorSet f() {
            c.c.a.c.a.h i2 = i();
            if (i2.c("width")) {
                PropertyValuesHolder[] a2 = i2.a("width");
                a2[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f10506g.b());
                i2.a("width", a2);
            }
            if (i2.c("height")) {
                PropertyValuesHolder[] a3 = i2.a("height");
                a3[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f10506g.a());
                i2.a("height", a3);
            }
            return super.b(i2);
        }

        @Override // c.c.a.c.q.f
        public boolean h() {
            return this.f10507h == ExtendedFloatingActionButton.this.z || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.z = this.f10507h;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // c.c.a.c.q.b, c.c.a.c.q.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f10506g.c().width;
            layoutParams.height = this.f10506g.c().height;
        }
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, A), attributeSet, i2);
        this.r = 0;
        c.c.a.c.q.a aVar = new c.c.a.c.q.a();
        this.t = aVar;
        this.w = new i(aVar);
        this.x = new g(this.t);
        this.z = true;
        Context context2 = getContext();
        this.y = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i2, A, new int[0]);
        c.c.a.c.a.h a2 = c.c.a.c.a.h.a(context2, c2, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        c.c.a.c.a.h a3 = c.c.a.c.a.h.a(context2, c2, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        c.c.a.c.a.h a4 = c.c.a.c.a.h.a(context2, c2, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        c.c.a.c.a.h a5 = c.c.a.c.a.h.a(context2, c2, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        c.c.a.c.q.a aVar2 = new c.c.a.c.q.a();
        this.v = new f(aVar2, new a(), true);
        this.u = new f(aVar2, new b(), false);
        this.w.a(a2);
        this.x.a(a3);
        this.v.a(a4);
        this.u.a(a5);
        c2.recycle();
        setShapeAppearanceModel(m.a(context2, attributeSet, i2, A, m.m).a());
    }

    public final void a(c.c.a.c.q.f fVar, h hVar) {
        if (fVar.h()) {
            return;
        }
        if (!g()) {
            fVar.d();
            fVar.a(hVar);
            return;
        }
        measure(0, 0);
        AnimatorSet f2 = fVar.f();
        f2.addListener(new c(this, fVar, hVar));
        Iterator<Animator.AnimatorListener> it = fVar.g().iterator();
        while (it.hasNext()) {
            f2.addListener(it.next());
        }
        f2.start();
    }
}
