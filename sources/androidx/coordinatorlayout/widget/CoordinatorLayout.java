package androidx.coordinatorlayout.widget;

import a.h.j.g0;
import a.h.j.o;
import a.h.j.p;
import a.h.j.r;
import a.h.j.s;
import a.h.j.y;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.customview.view.AbsSavedState;
import com.google.zxing.view.ViewfinderView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements o, p {
    public static final String v;
    public static final Class<?>[] w;
    public static final ThreadLocal<Map<String, Constructor<c>>> x;
    public static final Comparator<View> y;
    public static final a.h.i.e<Rect> z;

    /* renamed from: a, reason: collision with root package name */
    public final List<View> f2431a;

    /* renamed from: b, reason: collision with root package name */
    public final a.g.a.a<View> f2432b;

    /* renamed from: c, reason: collision with root package name */
    public final List<View> f2433c;

    /* renamed from: d, reason: collision with root package name */
    public final List<View> f2434d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f2435e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f2436f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f2437g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2438h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2439i;
    public int[] j;
    public View k;
    public View l;
    public g m;
    public boolean n;
    public g0 o;
    public boolean p;
    public Drawable q;
    public ViewGroup.OnHierarchyChangeListener r;
    public s t;
    public final r u;

    public class a implements s {
        public a() {
        }

        @Override // a.h.j.s
        public g0 a(View view, g0 g0Var) {
            CoordinatorLayout.this.b(g0Var);
            return g0Var;
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public g0 a(CoordinatorLayout coordinatorLayout, V v, g0 g0Var) {
            return g0Var;
        }

        public void a() {
        }

        public void a(f fVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > 0.0f;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return b(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, view2, i2);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2) {
            if (i2 == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i2, i3, i4, i5);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            a(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                a(coordinatorLayout, (CoordinatorLayout) v, view, i2, i3, iArr);
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.b(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.r;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.b(0);
            return true;
        }
    }

    public static class h implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float D = y.D(view);
            float D2 = y.D(view2);
            if (D > D2) {
                return -1;
            }
            return D < D2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            y = new h();
        } else {
            y = null;
        }
        w = new Class[]{Context.class, AttributeSet.class};
        x = new ThreadLocal<>();
        z = new a.h.i.g(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void a(Rect rect) {
        rect.setEmpty();
        z.a(rect);
    }

    public static int c(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    public static int d(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    public static int e(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    public static Rect i() {
        Rect a2 = z.a();
        return a2 == null ? new Rect() : a2;
    }

    public final g0 b(g0 g0Var) {
        if (!a.h.i.c.a(this.o, g0Var)) {
            this.o = g0Var;
            boolean z2 = g0Var != null && g0Var.h() > 0;
            this.p = z2;
            setWillNotDraw(!z2 && getBackground() == null);
            a(g0Var);
            requestLayout();
        }
        return g0Var;
    }

    public void c(View view, Rect rect) {
        ((f) view.getLayoutParams()).a(rect);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f d(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f2444b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.a(behavior);
                fVar.f2444b = true;
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        fVar.a(dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                fVar.f2444b = true;
            }
        }
        return fVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.f2443a;
        if (cVar != null) {
            float c2 = cVar.c(this, view);
            if (c2 > 0.0f) {
                if (this.f2435e == null) {
                    this.f2435e = new Paint();
                }
                this.f2435e.setColor(fVar.f2443a.b(this, view));
                this.f2435e.setAlpha(a(Math.round(c2 * 255.0f), 0, ViewfinderView.OPAQUE));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f2435e);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public final void e(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.f2451i;
        if (i3 != i2) {
            y.d(view, i2 - i3);
            fVar.f2451i = i2;
        }
    }

    public final void f() {
        this.f2431a.clear();
        this.f2432b.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            f d2 = d(childAt);
            d2.a(this, childAt);
            this.f2432b.a((a.g.a.a<View>) childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (d2.a(this, childAt, childAt2)) {
                        if (!this.f2432b.b(childAt2)) {
                            this.f2432b.a((a.g.a.a<View>) childAt2);
                        }
                        this.f2432b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2431a.addAll(this.f2432b.c());
        Collections.reverse(this.f2431a);
    }

    public void g() {
        if (this.f2439i && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        this.n = false;
    }

    public final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.f2431a);
    }

    public final g0 getLastWindowInsets() {
        return this.o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public final void h() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!y.n(this)) {
            y.a(this, (s) null);
            return;
        }
        if (this.t == null) {
            this.t = new a();
        }
        y.a(this, this.t);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.n) {
            if (this.m == null) {
                this.m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        if (this.o == null && y.n(this)) {
            y.O(this);
        }
        this.f2439i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.n && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        View view = this.l;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2439i = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.p || this.q == null) {
            return;
        }
        g0 g0Var = this.o;
        int h2 = g0Var != null ? g0Var.h() : 0;
        if (h2 > 0) {
            this.q.setBounds(0, 0, getWidth(), h2);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c d2;
        int q = y.q(this);
        int size = this.f2431a.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f2431a.get(i6);
            if (view.getVisibility() != 8 && ((d2 = ((f) view.getLayoutParams()).d()) == null || !d2.a(this, (CoordinatorLayout) view, q))) {
                d(view, q);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x011a, code lost:
    
        if (r0.a(r30, (androidx.coordinatorlayout.widget.CoordinatorLayout) r20, r11, r21, r23, 0) == false) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c d2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (d2 = fVar.d()) != null) {
                    z3 |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3, z2);
                }
            }
        }
        if (z3) {
            b(1);
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c d2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (d2 = fVar.d()) != null) {
                    z2 |= d2.a(this, (CoordinatorLayout) childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f2440c;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c d2 = d(childAt).d();
            if (id != -1 && d2 != null && (parcelable2 = sparseArray.get(id)) != null) {
                d2.a(this, (CoordinatorLayout) childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable d2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c d3 = ((f) childAt.getLayoutParams()).d();
            if (id != -1 && d3 != null && (d2 = d3.d(this, childAt)) != null) {
                sparseArray.append(id, d2);
            }
        }
        savedState.f2440c = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return b(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.h.j.q
    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.a(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.k
            boolean r6 = r6.b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.k
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.a(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c d2 = ((f) view.getLayoutParams()).d();
        if (d2 == null || !d2.a(this, (CoordinatorLayout) view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.f2438h) {
            return;
        }
        a(false);
        this.f2438h = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        h();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                a.h.c.l.a.a(this.q, y.q(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            y.N(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? a.h.b.a.c(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.q;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.q.setVisible(z2, false);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c f2443a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2444b;

        /* renamed from: c, reason: collision with root package name */
        public int f2445c;

        /* renamed from: d, reason: collision with root package name */
        public int f2446d;

        /* renamed from: e, reason: collision with root package name */
        public int f2447e;

        /* renamed from: f, reason: collision with root package name */
        public int f2448f;

        /* renamed from: g, reason: collision with root package name */
        public int f2449g;

        /* renamed from: h, reason: collision with root package name */
        public int f2450h;

        /* renamed from: i, reason: collision with root package name */
        public int f2451i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public f(int i2, int i3) {
            super(i2, i3);
            this.f2444b = false;
            this.f2445c = 0;
            this.f2446d = 0;
            this.f2447e = -1;
            this.f2448f = -1;
            this.f2449g = 0;
            this.f2450h = 0;
            this.q = new Rect();
        }

        public void a(c cVar) {
            c cVar2 = this.f2443a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.a();
                }
                this.f2443a = cVar;
                this.f2444b = true;
                if (cVar != null) {
                    cVar.a(this);
                }
            }
        }

        public boolean b() {
            if (this.f2443a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f2448f;
        }

        public c d() {
            return this.f2443a;
        }

        public boolean e() {
            return this.p;
        }

        public Rect f() {
            return this.q;
        }

        public void g() {
            this.p = false;
        }

        public void h() {
            this.m = false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            c cVar = this.f2443a;
            boolean a2 = (cVar != null ? cVar.a(coordinatorLayout, view) : false) | z;
            this.m = a2;
            return a2;
        }

        public void a(Rect rect) {
            this.q.set(rect);
        }

        public boolean a() {
            return this.k == null && this.f2448f != -1;
        }

        public void b(int i2) {
            a(i2, false);
        }

        public void a(int i2, boolean z) {
            if (i2 == 0) {
                this.n = z;
            } else {
                if (i2 != 1) {
                    return;
                }
                this.o = z;
            }
        }

        public final boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f2448f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view2;
            return true;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2444b = false;
            this.f2445c = 0;
            this.f2446d = 0;
            this.f2447e = -1;
            this.f2448f = -1;
            this.f2449g = 0;
            this.f2450h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f2445c = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2448f = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2446d = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2447e = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2449g = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2450h = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f2444b = hasValue;
            if (hasValue) {
                this.f2443a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            c cVar = this.f2443a;
            if (cVar != null) {
                cVar.a(this);
            }
        }

        public boolean a(int i2) {
            if (i2 == 0) {
                return this.n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        public void a(boolean z) {
            this.p = z;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            c cVar;
            return view2 == this.l || a(view2, y.q(coordinatorLayout)) || ((cVar = this.f2443a) != null && cVar.a(coordinatorLayout, (CoordinatorLayout) view, view2));
        }

        public View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2448f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        public final void a(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f2448f);
            this.k = findViewById;
            if (findViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2448f) + " to anchor view " + view);
            }
            if (findViewById == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                if (parent instanceof View) {
                    findViewById = parent;
                }
            }
            this.l = findViewById;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f2444b = false;
            this.f2445c = 0;
            this.f2446d = 0;
            this.f2447e = -1;
            this.f2448f = -1;
            this.f2449g = 0;
            this.f2450h = 0;
            this.q = new Rect();
        }

        public final boolean a(View view, int i2) {
            int a2 = a.h.j.e.a(((f) view.getLayoutParams()).f2449g, i2);
            return a2 != 0 && (a.h.j.e.a(this.f2450h, i2) & a2) == a2;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2444b = false;
            this.f2445c = 0;
            this.f2446d = 0;
            this.f2447e = -1;
            this.f2448f = -1;
            this.f2449g = 0;
            this.f2450h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2444b = false;
            this.f2445c = 0;
            this.f2446d = 0;
            this.f2447e = -1;
            this.f2448f = -1;
            this.f2449g = 0;
            this.f2450h = 0;
            this.q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.f2431a = new ArrayList();
        this.f2432b = new a.g.a.a<>();
        this.f2433c = new ArrayList();
        this.f2434d = new ArrayList();
        this.f2436f = new int[2];
        this.f2437g = new int[2];
        this.u = new r(this);
        if (i2 == 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i2, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R$styleable.CoordinatorLayout, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.j = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.j.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.j[i3] = (int) (r12[i3] * f2);
            }
        }
        this.q = obtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        h();
        super.setOnHierarchyChangeListener(new e());
        if (y.o(this) == 0) {
            y.h(this, 1);
        }
    }

    public final void a(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c d2 = ((f) childAt.getLayoutParams()).d();
            if (d2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    d2.a(this, (CoordinatorLayout) childAt, obtain);
                } else {
                    d2.b(this, (CoordinatorLayout) childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).h();
        }
        this.k = null;
        this.f2438h = false;
    }

    public List<View> c(View view) {
        List c2 = this.f2432b.c(view);
        this.f2434d.clear();
        if (c2 != null) {
            this.f2434d.addAll(c2);
        }
        return this.f2434d;
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public void e() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            if (e(getChildAt(i2))) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z2 != this.n) {
            if (z2) {
                d();
            } else {
                g();
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public SparseArray<Parcelable> f2440c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2440c = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f2440c.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f2440c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2440c.keyAt(i3);
                parcelableArr[i3] = this.f2440c.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void b(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).f());
    }

    public void c(View view, int i2) {
        c d2;
        f fVar = (f) view.getLayoutParams();
        if (fVar.k != null) {
            Rect i3 = i();
            Rect i4 = i();
            Rect i5 = i();
            a(fVar.k, i3);
            a(view, false, i4);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i2, i3, i5, fVar, measuredWidth, measuredHeight);
            boolean z2 = (i5.left == i4.left && i5.top == i4.top) ? false : true;
            a(fVar, i5, measuredWidth, measuredHeight);
            int i6 = i5.left - i4.left;
            int i7 = i5.top - i4.top;
            if (i6 != 0) {
                y.d(view, i6);
            }
            if (i7 != 0) {
                y.e(view, i7);
            }
            if (z2 && (d2 = fVar.d()) != null) {
                d2.b(this, (CoordinatorLayout) view, fVar.k);
            }
            a(i3);
            a(i4);
            a(i5);
        }
    }

    public final void b(View view, int i2, int i3) {
        f fVar = (f) view.getLayoutParams();
        int a2 = a.h.j.e.a(e(fVar.f2445c), i3);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int a3 = a(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            a3 += measuredWidth / 2;
        } else if (i4 == 5) {
            a3 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(a3, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    public final boolean e(View view) {
        return this.f2432b.e(view);
    }

    public final void f(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            y.e(view, i2 - i3);
            fVar.j = i2;
        }
    }

    public void d(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.a()) {
            View view2 = fVar.k;
            if (view2 != null) {
                a(view, view2, i2);
                return;
            }
            int i3 = fVar.f2447e;
            if (i3 >= 0) {
                b(view, i3, i2);
                return;
            } else {
                b(view, i2);
                return;
            }
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    public final void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public void d() {
        if (this.f2439i) {
            if (this.m == null) {
                this.m = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        this.n = true;
    }

    public final boolean a(MotionEvent motionEvent, int i2) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2433c;
        a(list);
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            f fVar = (f) view.getLayoutParams();
            c d2 = fVar.d();
            if (!(z2 || z3) || actionMasked == 0) {
                if (!z2 && d2 != null) {
                    if (i2 == 0) {
                        z2 = d2.a(this, (CoordinatorLayout) view, motionEvent);
                    } else if (i2 == 1) {
                        z2 = d2.b(this, (CoordinatorLayout) view, motionEvent);
                    }
                    if (z2) {
                        this.k = view;
                    }
                }
                boolean b2 = fVar.b();
                boolean b3 = fVar.b(this, view);
                z3 = b3 && !b2;
                if (b3 && !z3) {
                    break;
                }
            } else if (d2 != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    d2.a(this, (CoordinatorLayout) view, motionEvent2);
                } else if (i2 == 1) {
                    d2.b(this, (CoordinatorLayout) view, motionEvent2);
                }
            }
        }
        list.clear();
        return z2;
    }

    public final void b(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        Rect i3 = i();
        i3.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.o != null && y.n(this) && !y.n(view)) {
            i3.left += this.o.f();
            i3.top += this.o.h();
            i3.right -= this.o.g();
            i3.bottom -= this.o.e();
        }
        Rect i4 = i();
        a.h.j.e.a(d(fVar.f2445c), view.getMeasuredWidth(), view.getMeasuredHeight(), i3, i4, i2);
        view.layout(i4.left, i4.top, i4.right, i4.bottom);
        a(i3);
        a(i4);
    }

    public final int a(int i2) {
        int[] iArr = this.j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i2);
            return 0;
        }
        if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i2 + " out of range for " + this);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(v)) {
            str = v + '.' + str;
        }
        try {
            Map<String, Constructor<c>> map = x.get();
            if (map == null) {
                map = new HashMap<>();
                x.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(w);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    public final void b(int i2) {
        boolean z2;
        int q = y.q(this);
        int size = this.f2431a.size();
        Rect i3 = i();
        Rect i4 = i();
        Rect i5 = i();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f2431a.get(i6);
            f fVar = (f) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                for (int i7 = 0; i7 < i6; i7++) {
                    if (fVar.l == this.f2431a.get(i7)) {
                        c(view, q);
                    }
                }
                a(view, true, i4);
                if (fVar.f2449g != 0 && !i4.isEmpty()) {
                    int a2 = a.h.j.e.a(fVar.f2449g, q);
                    int i8 = a2 & 112;
                    if (i8 == 48) {
                        i3.top = Math.max(i3.top, i4.bottom);
                    } else if (i8 == 80) {
                        i3.bottom = Math.max(i3.bottom, getHeight() - i4.top);
                    }
                    int i9 = a2 & 7;
                    if (i9 == 3) {
                        i3.left = Math.max(i3.left, i4.right);
                    } else if (i9 == 5) {
                        i3.right = Math.max(i3.right, getWidth() - i4.left);
                    }
                }
                if (fVar.f2450h != 0 && view.getVisibility() == 0) {
                    a(view, i3, q);
                }
                if (i2 != 2) {
                    b(view, i5);
                    if (!i5.equals(i4)) {
                        c(view, i4);
                    }
                }
                for (int i10 = i6 + 1; i10 < size; i10++) {
                    View view2 = this.f2431a.get(i10);
                    f fVar2 = (f) view2.getLayoutParams();
                    c d2 = fVar2.d();
                    if (d2 != null && d2.a(this, (CoordinatorLayout) view2, view)) {
                        if (i2 == 0 && fVar2.e()) {
                            fVar2.g();
                        } else {
                            if (i2 != 2) {
                                z2 = d2.b(this, (CoordinatorLayout) view2, view);
                            } else {
                                d2.c(this, view2, view);
                                z2 = true;
                            }
                            if (i2 == 1) {
                                fVar2.a(z2);
                            }
                        }
                    }
                }
            }
        }
        a(i3);
        a(i4);
        a(i5);
    }

    public void a(View view, Rect rect) {
        a.g.a.b.a(this, view, rect);
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public final g0 a(g0 g0Var) {
        c d2;
        if (g0Var.j()) {
            return g0Var;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (y.n(childAt) && (d2 = ((f) childAt.getLayoutParams()).d()) != null) {
                d2.a(this, (CoordinatorLayout) childAt, g0Var);
                if (g0Var.j()) {
                    break;
                }
            }
        }
        return g0Var;
    }

    public void a(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final void a(View view, int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int width;
        int height;
        int a2 = a.h.j.e.a(c(fVar.f2445c), i2);
        int a3 = a.h.j.e.a(d(fVar.f2446d), i2);
        int i5 = a2 & 7;
        int i6 = a2 & 112;
        int i7 = a3 & 7;
        int i8 = a3 & 112;
        if (i7 == 1) {
            width = rect.left + (rect.width() / 2);
        } else if (i7 != 5) {
            width = rect.left;
        } else {
            width = rect.right;
        }
        if (i8 == 16) {
            height = rect.top + (rect.height() / 2);
        } else if (i8 != 80) {
            height = rect.top;
        } else {
            height = rect.bottom;
        }
        if (i5 == 1) {
            width -= i3 / 2;
        } else if (i5 != 5) {
            width -= i3;
        }
        if (i6 == 16) {
            height -= i4 / 2;
        } else if (i6 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    public List<View> b(View view) {
        List<View> d2 = this.f2432b.d(view);
        this.f2434d.clear();
        if (d2 != null) {
            this.f2434d.addAll(d2);
        }
        return this.f2434d;
    }

    @Override // a.h.j.o
    public boolean b(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c d2 = fVar.d();
                if (d2 != null) {
                    boolean b2 = d2.b(this, childAt, view, view2, i2, i3);
                    z2 |= b2;
                    fVar.a(i3, b2);
                } else {
                    fVar.a(i3, false);
                }
            }
        }
        return z2;
    }

    public final void a(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    public void a(View view, int i2, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, fVar, measuredWidth, measuredHeight);
        a(fVar, rect2, measuredWidth, measuredHeight);
    }

    public final void a(View view, View view2, int i2) {
        Rect i3 = i();
        Rect i4 = i();
        try {
            a(view2, i3);
            a(view, i2, i3, i4);
            view.layout(i4.left, i4.top, i4.right, i4.bottom);
        } finally {
            a(i3);
            a(i4);
        }
    }

    public final void a(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int i4;
        int i5;
        int height;
        int i6;
        int i7;
        int i8;
        if (y.J(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c d2 = fVar.d();
            Rect i9 = i();
            Rect i10 = i();
            i10.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (d2 != null && d2.a(this, (CoordinatorLayout) view, i9)) {
                if (!i10.contains(i9)) {
                    throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + i9.toShortString() + " | Bounds:" + i10.toShortString());
                }
            } else {
                i9.set(i10);
            }
            a(i10);
            if (i9.isEmpty()) {
                a(i9);
                return;
            }
            int a2 = a.h.j.e.a(fVar.f2450h, i2);
            boolean z4 = true;
            if ((a2 & 48) != 48 || (i7 = (i9.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.j) >= (i8 = rect.top)) {
                z2 = false;
            } else {
                f(view, i8 - i7);
                z2 = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - i9.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.j) < (i6 = rect.bottom)) {
                f(view, height - i6);
                z2 = true;
            }
            if (!z2) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i4 = (i9.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f2451i) >= (i5 = rect.left)) {
                z3 = false;
            } else {
                e(view, i5 - i4);
                z3 = true;
            }
            if ((a2 & 5) != 5 || (width = ((getWidth() - i9.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f2451i) >= (i3 = rect.right)) {
                z4 = z3;
            } else {
                e(view, width - i3);
            }
            if (!z4) {
                e(view, 0);
            }
            a(i9);
        }
    }

    public void a(View view) {
        List c2 = this.f2432b.c(view);
        if (c2 == null || c2.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < c2.size(); i2++) {
            View view2 = (View) c2.get(i2);
            c d2 = ((f) view2.getLayoutParams()).d();
            if (d2 != null) {
                d2.b(this, (CoordinatorLayout) view2, view);
            }
        }
    }

    public boolean a(View view, int i2, int i3) {
        Rect i4 = i();
        a(view, i4);
        try {
            return i4.contains(i2, i3);
        } finally {
            a(i4);
        }
    }

    @Override // a.h.j.o
    public void a(View view, View view2, int i2, int i3) {
        c d2;
        this.u.a(view, view2, i2, i3);
        this.l = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i3) && (d2 = fVar.d()) != null) {
                d2.a(this, (CoordinatorLayout) childAt, view, view2, i2, i3);
            }
        }
    }

    @Override // a.h.j.o
    public void a(View view, int i2) {
        this.u.a(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c d2 = fVar.d();
                if (d2 != null) {
                    d2.a(this, (CoordinatorLayout) childAt, view, i2);
                }
                fVar.b(i2);
                fVar.g();
            }
        }
        this.l = null;
    }

    @Override // a.h.j.o
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(view, i2, i3, i4, i5, 0, this.f2437g);
    }

    @Override // a.h.j.p
    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c d2;
        int min;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (d2 = fVar.d()) != null) {
                    int[] iArr2 = this.f2436f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    d2.a(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f2436f;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    if (i5 > 0) {
                        min = Math.max(i8, this.f2436f[1]);
                    } else {
                        min = Math.min(i8, this.f2436f[1]);
                    }
                    i8 = min;
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (z2) {
            b(1);
        }
    }

    @Override // a.h.j.o
    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        c d2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (d2 = fVar.d()) != null) {
                    int[] iArr2 = this.f2436f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    d2.a(this, (CoordinatorLayout) childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f2436f;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f2436f;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            b(1);
        }
    }
}
