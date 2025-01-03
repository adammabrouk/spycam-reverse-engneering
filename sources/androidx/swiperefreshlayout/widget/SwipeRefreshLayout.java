package androidx.swiperefreshlayout.widget;

import a.h.j.m;
import a.h.j.n;
import a.h.j.q;
import a.h.j.r;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements q, m {
    public static final String P = SwipeRefreshLayout.class.getSimpleName();
    public static final int[] Q = {R.attr.enabled};
    public int A;
    public int B;
    public a.r.a.b C;
    public Animation D;
    public Animation E;
    public Animation F;
    public Animation G;
    public Animation H;
    public boolean I;
    public int J;
    public boolean K;
    public i L;
    public Animation.AnimationListener M;
    public final Animation N;
    public final Animation O;

    /* renamed from: a, reason: collision with root package name */
    public View f2815a;

    /* renamed from: b, reason: collision with root package name */
    public j f2816b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2817c;

    /* renamed from: d, reason: collision with root package name */
    public int f2818d;

    /* renamed from: e, reason: collision with root package name */
    public float f2819e;

    /* renamed from: f, reason: collision with root package name */
    public float f2820f;

    /* renamed from: g, reason: collision with root package name */
    public final r f2821g;

    /* renamed from: h, reason: collision with root package name */
    public final n f2822h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f2823i;
    public final int[] j;
    public boolean k;
    public int l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean t;
    public final DecelerateInterpolator u;
    public a.r.a.a v;
    public int w;
    public int x;
    public float y;
    public int z;

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f2817c) {
                swipeRefreshLayout.e();
                return;
            }
            swipeRefreshLayout.C.setAlpha(ViewfinderView.OPAQUE);
            SwipeRefreshLayout.this.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.I && (jVar = swipeRefreshLayout2.f2816b) != null) {
                jVar.onRefresh();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.m = swipeRefreshLayout3.v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f2);
        }
    }

    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
        }
    }

    public class d extends Animation {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2827a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2828b;

        public d(int i2, int i3) {
            this.f2827a = i2;
            this.f2828b = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.C.setAlpha((int) (this.f2827a + ((this.f2828b - r0) * f2)));
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.r) {
                return;
            }
            swipeRefreshLayout.a((Animation.AnimationListener) null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int abs = !swipeRefreshLayout.K ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.z) : swipeRefreshLayout.A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.x + ((int) ((abs - r1) * f2))) - swipeRefreshLayout2.v.getTop());
            SwipeRefreshLayout.this.C.a(1.0f - f2);
        }
    }

    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout.this.c(f2);
        }
    }

    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f3 = swipeRefreshLayout.y;
            swipeRefreshLayout.setAnimationProgress(f3 + ((-f3) * f2));
            SwipeRefreshLayout.this.c(f2);
        }
    }

    public interface i {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface j {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i2) {
        this.v.getBackground().setAlpha(i2);
        this.C.setAlpha(i2);
    }

    public final void a(boolean z, boolean z2) {
        if (this.f2817c != z) {
            this.I = z2;
            c();
            this.f2817c = z;
            if (z) {
                a(this.m, this.M);
            } else {
                a(this.M);
            }
        }
    }

    public final void b() {
        this.v = new a.r.a.a(getContext(), -328966);
        a.r.a.b bVar = new a.r.a.b(getContext());
        this.C = bVar;
        bVar.a(1);
        this.v.setImageDrawable(this.C);
        this.v.setVisibility(8);
        addView(this.v);
    }

    public final void c() {
        if (this.f2815a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.v)) {
                    this.f2815a = childAt;
                    return;
                }
            }
        }
    }

    public boolean d() {
        return this.f2817c;
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f2822h.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2822h.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f2822h.a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2822h.a(i2, i3, i4, i5, iArr);
    }

    public void e() {
        this.v.clearAnimation();
        this.C.stop();
        this.v.setVisibility(8);
        setColorViewAlpha(ViewfinderView.OPAQUE);
        if (this.r) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.z - this.m);
        }
        this.m = this.v.getTop();
    }

    public final void f() {
        this.G = a(this.C.getAlpha(), ViewfinderView.OPAQUE);
    }

    public final void g() {
        this.F = a(this.C.getAlpha(), 76);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.w;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2821g.a();
    }

    public int getProgressCircleDiameter() {
        return this.J;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.z;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f2822h.b();
    }

    @Override // android.view.View, a.h.j.m
    public boolean isNestedScrollingEnabled() {
        return this.f2822h.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        c();
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.f2817c || this.k) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.q;
                    if (i2 == -1) {
                        Log.e(P, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.p = false;
            this.q = -1;
        } else {
            setTargetOffsetTopAndBottom(this.z - this.v.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.q = pointerId;
            this.p = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.o = motionEvent.getY(findPointerIndex2);
        }
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f2815a == null) {
            c();
        }
        View view = this.f2815a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.v.getMeasuredWidth();
        int measuredHeight2 = this.v.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.m;
        this.v.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2815a == null) {
            c();
        }
        View view = this.f2815a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), MemoryConstants.GB));
        this.v.measure(View.MeasureSpec.makeMeasureSpec(this.J, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.J, MemoryConstants.GB));
        this.w = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.v) {
                this.w = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f2820f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f2820f = 0.0f;
                } else {
                    this.f2820f = f2 - f3;
                    iArr[1] = i3;
                }
                b(this.f2820f);
            }
        }
        if (this.K && i3 > 0 && this.f2820f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.v.setVisibility(8);
        }
        int[] iArr2 = this.f2823i;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.j);
        if (i5 + this.j[1] >= 0 || a()) {
            return;
        }
        float abs = this.f2820f + Math.abs(r11);
        this.f2820f = abs;
        b(abs);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2821g.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f2820f = 0.0f;
        this.k = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.t || this.f2817c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onStopNestedScroll(View view) {
        this.f2821g.a(view);
        this.k = false;
        float f2 = this.f2820f;
        if (f2 > 0.0f) {
            a(f2);
            this.f2820f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.t && actionMasked == 0) {
            this.t = false;
        }
        if (!isEnabled() || this.t || a() || this.f2817c || this.k) {
            return false;
        }
        if (actionMasked == 0) {
            this.q = motionEvent.getPointerId(0);
            this.p = false;
        } else {
            if (actionMasked == 1) {
                int findPointerIndex = motionEvent.findPointerIndex(this.q);
                if (findPointerIndex < 0) {
                    Log.e(P, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.p) {
                    float y = (motionEvent.getY(findPointerIndex) - this.n) * 0.5f;
                    this.p = false;
                    a(y);
                }
                this.q = -1;
                return false;
            }
            if (actionMasked == 2) {
                int findPointerIndex2 = motionEvent.findPointerIndex(this.q);
                if (findPointerIndex2 < 0) {
                    Log.e(P, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(findPointerIndex2);
                d(y2);
                if (this.p) {
                    float f2 = (y2 - this.n) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    b(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(P, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.q = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    a(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2815a instanceof AbsListView)) {
            View view = this.f2815a;
            if (view == null || y.K(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    public void setAnimationProgress(float f2) {
        this.v.setScaleX(f2);
        this.v.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        c();
        this.C.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = a.h.b.a.a(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f2819e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        e();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f2822h.a(z);
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.L = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f2816b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.v.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(a.h.b.a.a(getContext(), i2));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f2817c == z) {
            a(z, false);
            return;
        }
        this.f2817c = z;
        setTargetOffsetTopAndBottom((!this.K ? this.A + this.z : this.A) - this.m);
        this.I = false;
        b(this.M);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.J = (int) (displayMetrics.density * 56.0f);
            } else {
                this.J = (int) (displayMetrics.density * 40.0f);
            }
            this.v.setImageDrawable(null);
            this.C.a(i2);
            this.v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.B = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.v.bringToFront();
        y.e(this.v, i2);
        this.m = this.v.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return this.f2822h.c(i2);
    }

    @Override // android.view.View, a.h.j.m
    public void stopNestedScroll() {
        this.f2822h.d();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2817c = false;
        this.f2819e = -1.0f;
        this.f2823i = new int[2];
        this.j = new int[2];
        this.q = -1;
        this.w = -1;
        this.M = new a();
        this.N = new f();
        this.O = new g();
        this.f2818d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.l = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.J = (int) (displayMetrics.density * 40.0f);
        b();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.A = i2;
        this.f2819e = i2;
        this.f2821g = new r(this);
        this.f2822h = new n(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.J;
        this.m = i3;
        this.z = i3;
        c(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Q);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public final void d(float f2) {
        float f3 = this.o;
        float f4 = f2 - f3;
        int i2 = this.f2818d;
        if (f4 <= i2 || this.p) {
            return;
        }
        this.n = f3 + i2;
        this.p = true;
        this.C.setAlpha(76);
    }

    public void c(float f2) {
        setTargetOffsetTopAndBottom((this.x + ((int) ((this.z - r0) * f2))) - this.v.getTop());
    }

    public void a(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.E = cVar;
        cVar.setDuration(150L);
        this.v.a(animationListener);
        this.v.clearAnimation();
        this.v.startAnimation(this.E);
    }

    public final void b(Animation.AnimationListener animationListener) {
        this.v.setVisibility(0);
        this.C.setAlpha(ViewfinderView.OPAQUE);
        b bVar = new b();
        this.D = bVar;
        bVar.setDuration(this.l);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.D);
    }

    public final void c(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.y = this.v.getScaleX();
        h hVar = new h();
        this.H = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.H);
    }

    public final Animation a(int i2, int i3) {
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.v.a(null);
        this.v.clearAnimation();
        this.v.startAnimation(dVar);
        return dVar;
    }

    public final void b(float f2) {
        this.C.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f2819e));
        double d2 = min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f2819e;
        int i2 = this.B;
        if (i2 <= 0) {
            i2 = this.K ? this.A - this.z : this.A;
        }
        float f3 = i2;
        double max2 = Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f;
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i3 = this.z + ((int) ((f3 * min) + (f3 * f4 * 2.0f)));
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (!this.r) {
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        if (this.r) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f2819e));
        }
        if (f2 < this.f2819e) {
            if (this.C.getAlpha() > 76 && !a(this.F)) {
                g();
            }
        } else if (this.C.getAlpha() < 255 && !a(this.G)) {
            f();
        }
        this.C.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.C.a(Math.min(1.0f, max));
        this.C.b((((max * 0.4f) - 0.25f) + (f4 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.m);
    }

    public boolean a() {
        i iVar = this.L;
        if (iVar != null) {
            return iVar.a(this, this.f2815a);
        }
        View view = this.f2815a;
        if (view instanceof ListView) {
            return a.h.k.g.a((ListView) view, -1);
        }
        return view.canScrollVertically(-1);
    }

    public final boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public final void a(float f2) {
        if (f2 > this.f2819e) {
            a(true, true);
            return;
        }
        this.f2817c = false;
        this.C.a(0.0f, 0.0f);
        b(this.m, this.r ? null : new e());
        this.C.a(false);
    }

    public final void a(int i2, Animation.AnimationListener animationListener) {
        this.x = i2;
        this.N.reset();
        this.N.setDuration(200L);
        this.N.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.N);
    }

    public final void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.q) {
            this.q = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public final void b(int i2, Animation.AnimationListener animationListener) {
        if (this.r) {
            c(i2, animationListener);
            return;
        }
        this.x = i2;
        this.O.reset();
        this.O.setDuration(200L);
        this.O.setInterpolator(this.u);
        if (animationListener != null) {
            this.v.a(animationListener);
        }
        this.v.clearAnimation();
        this.v.startAnimation(this.O);
    }
}
