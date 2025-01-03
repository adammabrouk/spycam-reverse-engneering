package androidx.appcompat.widget;

import a.b.e.j.m;
import a.b.f.m0;
import a.b.f.p;
import a.h.j.g0;
import a.h.j.o;
import a.h.j.q;
import a.h.j.r;
import a.h.j.y;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.recyclerview.widget.RecyclerView;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements p, q, o, a.h.j.p {
    public static final int[] G = {R$attr.actionBarSize, R.attr.windowContentOverlay};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final r F;

    /* renamed from: a, reason: collision with root package name */
    public int f2190a;

    /* renamed from: b, reason: collision with root package name */
    public int f2191b;

    /* renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f2192c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f2193d;

    /* renamed from: e, reason: collision with root package name */
    public a.b.f.q f2194e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2195f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2196g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2197h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2198i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public final Rect n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect t;
    public final Rect u;
    public g0 v;
    public g0 w;
    public g0 x;
    public g0 y;
    public d z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.k = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f2193d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f2193d.animate().translationY(-ActionBarOverlayLayout.this.f2193d.getHeight()).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
        void a();

        void a(int i2);

        void a(boolean z);

        void b();

        void c();

        void d();
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        this.f2190a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f2195f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f2196g = context.getApplicationInfo().targetSdkVersion < 19;
        this.A = new OverScroller(context);
    }

    @Override // a.h.j.o
    public boolean b(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // a.b.f.p
    public boolean c() {
        m();
        return this.f2194e.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // a.b.f.p
    public boolean d() {
        m();
        return this.f2194e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2195f == null || this.f2196g) {
            return;
        }
        int bottom = this.f2193d.getVisibility() == 0 ? (int) (this.f2193d.getBottom() + this.f2193d.getTranslationY() + 0.5f) : 0;
        this.f2195f.setBounds(0, bottom, getWidth(), this.f2195f.getIntrinsicHeight() + bottom);
        this.f2195f.draw(canvas);
    }

    @Override // a.b.f.p
    public boolean e() {
        m();
        return this.f2194e.e();
    }

    @Override // a.b.f.p
    public boolean f() {
        m();
        return this.f2194e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        m();
        boolean a2 = a((View) this.f2193d, rect, true, true, false, true);
        this.q.set(rect);
        m0.a(this, this.q, this.n);
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a2 = true;
        }
        if (!this.o.equals(this.n)) {
            this.o.set(this.n);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    @Override // a.b.f.p
    public void g() {
        m();
        this.f2194e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2193d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        m();
        return this.f2194e.getTitle();
    }

    public final void h() {
        i();
        this.E.run();
    }

    public void i() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean j() {
        return this.f2197h;
    }

    public final void k() {
        i();
        postDelayed(this.E, 600L);
    }

    public final void l() {
        i();
        postDelayed(this.D, 600L);
    }

    public void m() {
        if (this.f2192c == null) {
            this.f2192c = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f2193d = (ActionBarContainer) findViewById(R$id.action_bar_container);
            this.f2194e = a(findViewById(R$id.action_bar));
        }
    }

    public final void n() {
        i();
        this.D.run();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        m();
        g0 a2 = g0.a(windowInsets, this);
        boolean a3 = a((View) this.f2193d, new Rect(a2.f(), a2.h(), a2.g(), a2.e()), true, true, false, true);
        y.a(this, a2, this.n);
        Rect rect = this.n;
        g0 a4 = a2.a(rect.left, rect.top, rect.right, rect.bottom);
        this.v = a4;
        boolean z = true;
        if (!this.w.equals(a4)) {
            this.w = this.v;
            a3 = true;
        }
        if (this.o.equals(this.n)) {
            z = a3;
        } else {
            this.o.set(this.n);
        }
        if (z) {
            requestLayout();
        }
        return a2.a().c().b().k();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        y.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeight;
        m();
        measureChildWithMargins(this.f2193d, i2, 0, i3, 0);
        e eVar = (e) this.f2193d.getLayoutParams();
        int max = Math.max(0, this.f2193d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f2193d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f2193d.getMeasuredState());
        boolean z = (y.C(this) & RecyclerView.c0.FLAG_TMP_DETACHED) != 0;
        if (z) {
            measuredHeight = this.f2190a;
            if (this.f2198i && this.f2193d.getTabContainer() != null) {
                measuredHeight += this.f2190a;
            }
        } else {
            measuredHeight = this.f2193d.getVisibility() != 8 ? this.f2193d.getMeasuredHeight() : 0;
        }
        this.p.set(this.n);
        if (Build.VERSION.SDK_INT >= 21) {
            this.x = this.v;
        } else {
            this.t.set(this.q);
        }
        if (!this.f2197h && !z) {
            Rect rect = this.p;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.x = this.x.a(0, measuredHeight, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            a.h.c.b a2 = a.h.c.b.a(this.x.f(), this.x.h() + measuredHeight, this.x.g(), this.x.e() + 0);
            g0.b bVar = new g0.b(this.x);
            bVar.b(a2);
            this.x = bVar.a();
        } else {
            Rect rect2 = this.t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        a((View) this.f2192c, this.p, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.y.equals(this.x)) {
            g0 g0Var = this.x;
            this.y = g0Var;
            y.a(this.f2192c, g0Var);
        } else if (Build.VERSION.SDK_INT < 21 && !this.u.equals(this.t)) {
            this.u.set(this.t);
            this.f2192c.a(this.t);
        }
        measureChildWithMargins(this.f2192c, i2, 0, i3, 0);
        e eVar2 = (e) this.f2192c.getLayoutParams();
        int max3 = Math.max(max, this.f2192c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f2192c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f2192c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (!this.j || !z) {
            return false;
        }
        if (a(f3)) {
            h();
        } else {
            n();
        }
        this.k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.l + i3;
        this.l = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.F.a(view, view2, i2);
        this.l = getActionBarHideOffset();
        i();
        d dVar = this.z;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f2193d.getVisibility() != 0) {
            return false;
        }
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onStopNestedScroll(View view) {
        if (this.j && !this.k) {
            if (this.l <= this.f2193d.getHeight()) {
                l();
            } else {
                k();
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        m();
        int i3 = this.m ^ i2;
        this.m = i2;
        boolean z = (i2 & 4) == 0;
        boolean z2 = (i2 & RecyclerView.c0.FLAG_TMP_DETACHED) != 0;
        d dVar = this.z;
        if (dVar != null) {
            dVar.a(!z2);
            if (z || !z2) {
                this.z.a();
            } else {
                this.z.d();
            }
        }
        if ((i3 & RecyclerView.c0.FLAG_TMP_DETACHED) == 0 || this.z == null) {
            return;
        }
        y.O(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f2191b = i2;
        d dVar = this.z;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        i();
        this.f2193d.setTranslationY(-Math.max(0, Math.min(i2, this.f2193d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            this.z.a(this.f2191b);
            int i2 = this.m;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                y.O(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f2198i = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.j) {
            this.j = z;
            if (z) {
                return;
            }
            i();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        m();
        this.f2194e.setIcon(i2);
    }

    public void setLogo(int i2) {
        m();
        this.f2194e.b(i2);
    }

    public void setOverlayMode(boolean z) {
        this.f2197h = z;
        this.f2196g = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // a.b.f.p
    public void setWindowCallback(Window.Callback callback) {
        m();
        this.f2194e.setWindowCallback(callback);
    }

    @Override // a.b.f.p
    public void setWindowTitle(CharSequence charSequence) {
        m();
        this.f2194e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2191b = 0;
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        g0 g0Var = g0.f1142b;
        this.v = g0Var;
        this.w = g0Var;
        this.x = g0Var;
        this.y = g0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        a(context);
        this.F = new r(this);
    }

    @Override // a.b.f.p
    public void b() {
        m();
        this.f2194e.b();
    }

    @Override // android.view.ViewGroup
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        m();
        this.f2194e.setIcon(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.a(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // a.h.j.p
    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(view, i2, i3, i4, i5, i6);
    }

    @Override // a.h.j.o
    public void a(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // a.h.j.o
    public void a(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // a.h.j.o
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // a.h.j.o
    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.b.f.q a(View view) {
        if (view instanceof a.b.f.q) {
            return (a.b.f.q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public final boolean a(float f2) {
        this.A.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.A.getFinalY() > this.f2193d.getHeight();
    }

    @Override // a.b.f.p
    public void a(int i2) {
        m();
        if (i2 == 2) {
            this.f2194e.n();
        } else if (i2 == 5) {
            this.f2194e.o();
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // a.b.f.p
    public boolean a() {
        m();
        return this.f2194e.a();
    }

    @Override // a.b.f.p
    public void a(Menu menu, m.a aVar) {
        m();
        this.f2194e.a(menu, aVar);
    }
}
