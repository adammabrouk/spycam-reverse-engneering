package androidx.drawerlayout.widget;

import a.h.j.h0.c;
import a.h.j.y;
import a.j.a.c;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import com.google.zxing.decoding.InactivityTimer;
import com.shix.shixipc.he.Constant;
import com.shix.shixipc.utilcode.MemoryConstants;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] L = {R.attr.colorPrimaryDark};
    public static final int[] M = {R.attr.layout_gravity};
    public static final boolean N;
    public static final boolean O;
    public CharSequence A;
    public CharSequence B;
    public Object C;
    public boolean D;
    public Drawable E;
    public Drawable F;
    public Drawable G;
    public Drawable H;
    public final ArrayList<View> I;
    public Rect J;
    public Matrix K;

    /* renamed from: a, reason: collision with root package name */
    public final c f2515a;

    /* renamed from: b, reason: collision with root package name */
    public float f2516b;

    /* renamed from: c, reason: collision with root package name */
    public int f2517c;

    /* renamed from: d, reason: collision with root package name */
    public int f2518d;

    /* renamed from: e, reason: collision with root package name */
    public float f2519e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f2520f;

    /* renamed from: g, reason: collision with root package name */
    public final a.j.a.c f2521g;

    /* renamed from: h, reason: collision with root package name */
    public final a.j.a.c f2522h;

    /* renamed from: i, reason: collision with root package name */
    public final f f2523i;
    public final f j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public d t;
    public List<d> u;
    public float v;
    public float w;
    public Drawable x;
    public Drawable y;
    public Drawable z;

    public class a implements View.OnApplyWindowInsetsListener {
        public a(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public static final class c extends a.h.j.a {
        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            if (DrawerLayout.m(view)) {
                return;
            }
            cVar.e((View) null);
        }
    }

    public interface d {
        void a(int i2);

        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    public class f extends c.AbstractC0037c {

        /* renamed from: a, reason: collision with root package name */
        public final int f2535a;

        /* renamed from: b, reason: collision with root package name */
        public a.j.a.c f2536b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f2537c = new a();

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.b();
            }
        }

        public f(int i2) {
            this.f2535a = i2;
        }

        public void a(a.j.a.c cVar) {
            this.f2536b = cVar;
        }

        public void b() {
            View a2;
            int width;
            int e2 = this.f2536b.e();
            boolean z = this.f2535a == 3;
            if (z) {
                a2 = DrawerLayout.this.a(3);
                width = (a2 != null ? -a2.getWidth() : 0) + e2;
            } else {
                a2 = DrawerLayout.this.a(5);
                width = DrawerLayout.this.getWidth() - e2;
            }
            if (a2 != null) {
                if (((!z || a2.getLeft() >= width) && (z || a2.getLeft() <= width)) || DrawerLayout.this.d(a2) != 0) {
                    return;
                }
                e eVar = (e) a2.getLayoutParams();
                this.f2536b.b(a2, width, a2.getTop());
                eVar.f2533c = true;
                DrawerLayout.this.invalidate();
                a();
                DrawerLayout.this.a();
            }
        }

        public void c() {
            DrawerLayout.this.removeCallbacks(this.f2537c);
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            if (DrawerLayout.this.a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i2, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i2, width));
        }

        @Override // a.j.a.c.AbstractC0037c
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // a.j.a.c.AbstractC0037c
        public int getViewHorizontalDragRange(View view) {
            if (DrawerLayout.this.i(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onEdgeDragStarted(int i2, int i3) {
            View a2 = (i2 & 1) == 1 ? DrawerLayout.this.a(3) : DrawerLayout.this.a(5);
            if (a2 == null || DrawerLayout.this.d(a2) != 0) {
                return;
            }
            this.f2536b.a(a2, i3);
        }

        @Override // a.j.a.c.AbstractC0037c
        public boolean onEdgeLock(int i2) {
            return false;
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onEdgeTouched(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f2537c, 160L);
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewCaptured(View view, int i2) {
            ((e) view.getLayoutParams()).f2533c = false;
            a();
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewDragStateChanged(int i2) {
            DrawerLayout.this.a(this.f2535a, i2, this.f2536b.d());
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            float width = (DrawerLayout.this.a(view, 3) ? i2 + r3 : DrawerLayout.this.getWidth() - i2) / view.getWidth();
            DrawerLayout.this.c(view, width);
            view.setVisibility(width == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // a.j.a.c.AbstractC0037c
        public void onViewReleased(View view, float f2, float f3) {
            int i2;
            float f4 = DrawerLayout.this.f(view);
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                i2 = (f2 > 0.0f || (f2 == 0.0f && f4 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && f4 > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f2536b.e(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // a.j.a.c.AbstractC0037c
        public boolean tryCaptureView(View view, int i2) {
            return DrawerLayout.this.i(view) && DrawerLayout.this.a(view, this.f2535a) && DrawerLayout.this.d(view) == 0;
        }

        public final void a() {
            View a2 = DrawerLayout.this.a(this.f2535a == 3 ? 5 : 3);
            if (a2 != null) {
                DrawerLayout.this.a(a2);
            }
        }
    }

    static {
        N = Build.VERSION.SDK_INT >= 19;
        O = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public static boolean l(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public static boolean m(View view) {
        return (y.o(view) == 4 || y.o(view) == 2) ? false : true;
    }

    public void a(Object obj, boolean z) {
        this.C = obj;
        this.D = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        boolean z = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (!i(childAt)) {
                this.I.add(childAt);
            } else if (h(childAt)) {
                childAt.addFocusables(arrayList, i2, i3);
                z = true;
            }
        }
        if (!z) {
            int size = this.I.size();
            for (int i5 = 0; i5 < size; i5++) {
                View view = this.I.get(i5);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i2, i3);
                }
            }
        }
        this.I.clear();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (c() != null || i(view)) {
            y.h(view, 4);
        } else {
            y.h(view, 1);
        }
        if (N) {
            return;
        }
        y.a(view, this.f2515a);
    }

    public void b(d dVar) {
        List<d> list;
        if (dVar == null || (list = this.u) == null) {
            return;
        }
        list.remove(dVar);
    }

    public CharSequence c(int i2) {
        int a2 = a.h.j.e.a(i2, y.q(this));
        if (a2 == 3) {
            return this.A;
        }
        if (a2 == 5) {
            return this.B;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((e) getChildAt(i2).getLayoutParams()).f2532b);
        }
        this.f2519e = f2;
        boolean a2 = this.f2521g.a(true);
        boolean a3 = this.f2522h.a(true);
        if (a2 || a3) {
            y.N(this);
        }
    }

    public int d(View view) {
        if (i(view)) {
            return b(((e) view.getLayoutParams()).f2531a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2519e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (a(x, y, childAt) && !g(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        int height = getHeight();
        boolean g2 = g(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (g2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view && childAt.getVisibility() == 0 && l(childAt) && i(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f2 = this.f2519e;
        if (f2 > 0.0f && g2) {
            this.f2520f.setColor((this.f2518d & Constant.PPPP_STATUS_UNKNOWN) | (((int) ((((-16777216) & r2) >>> 24) * f2)) << 24));
            canvas.drawRect(i2, 0.0f, width, getHeight(), this.f2520f);
        } else if (this.y != null && a(view, 3)) {
            int intrinsicWidth = this.y.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f2521g.e(), 1.0f));
            this.y.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.y.setAlpha((int) (max * 255.0f));
            this.y.draw(canvas);
        } else if (this.z != null && a(view, 5)) {
            int intrinsicWidth2 = this.z.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2522h.e(), 1.0f));
            this.z.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.z.setAlpha((int) (max2 * 255.0f));
            this.z.draw(canvas);
        }
        return drawChild;
    }

    public int e(View view) {
        return a.h.j.e.a(((e) view.getLayoutParams()).f2531a, y.q(this));
    }

    public float f(View view) {
        return ((e) view.getLayoutParams()).f2532b;
    }

    public final Drawable g() {
        int q = y.q(this);
        if (q == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                a(drawable, q);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.F;
            if (drawable2 != null) {
                a(drawable2, q);
                return this.F;
            }
        }
        return this.G;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f2516b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.x;
    }

    public final Drawable h() {
        int q = y.q(this);
        if (q == 0) {
            Drawable drawable = this.F;
            if (drawable != null) {
                a(drawable, q);
                return this.F;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                a(drawable2, q);
                return this.E;
            }
        }
        return this.H;
    }

    public final void i() {
        if (O) {
            return;
        }
        this.y = g();
        this.z = h();
    }

    public boolean j(View view) {
        if (i(view)) {
            return ((e) view.getLayoutParams()).f2532b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void k(View view) {
        b(view, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (!this.D || this.x == null) {
            return;
        }
        int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.C) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
        if (systemWindowInsetTop > 0) {
            this.x.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.x.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r0 != 3) goto L13;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            a.j.a.c r1 = r6.f2521g
            boolean r1 = r1.c(r7)
            a.j.a.c r2 = r6.f2522h
            boolean r2 = r2.c(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L38
            if (r0 == r2) goto L31
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L1e
            if (r0 == r4) goto L31
            goto L36
        L1e:
            a.j.a.c r7 = r6.f2521g
            boolean r7 = r7.a(r4)
            if (r7 == 0) goto L36
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.f2523i
            r7.c()
            androidx.drawerlayout.widget.DrawerLayout$f r7 = r6.j
            r7.c()
            goto L36
        L31:
            r6.a(r2)
            r6.r = r3
        L36:
            r7 = 0
            goto L60
        L38:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.v = r0
            r6.w = r7
            float r4 = r6.f2519e
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L5d
            a.j.a.c r4 = r6.f2521g
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.b(r0, r7)
            if (r7 == 0) goto L5d
            boolean r7 = r6.g(r7)
            if (r7 == 0) goto L5d
            r7 = 1
            goto L5e
        L5d:
            r7 = 0
        L5e:
            r6.r = r3
        L60:
            if (r1 != 0) goto L70
            if (r7 != 0) goto L70
            boolean r7 = r6.e()
            if (r7 != 0) goto L70
            boolean r7 = r6.r
            if (r7 == 0) goto L6f
            goto L70
        L6f:
            r2 = 0
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !f()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View d2 = d();
        if (d2 != null && d(d2) == 0) {
            b();
        }
        return d2 != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        this.l = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (g(childAt)) {
                    int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                    childAt.layout(i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin, childAt.getMeasuredWidth() + i9, ((ViewGroup.MarginLayoutParams) eVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = measuredWidth;
                        i6 = (-measuredWidth) + ((int) (eVar.f2532b * f3));
                        f2 = (measuredWidth + i6) / f3;
                    } else {
                        float f4 = measuredWidth;
                        f2 = (i7 - r11) / f4;
                        i6 = i7 - ((int) (eVar.f2532b * f4));
                    }
                    boolean z2 = f2 != eVar.f2532b;
                    int i10 = eVar.f2531a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        if (i12 < i13) {
                            i12 = i13;
                        } else {
                            int i14 = i12 + measuredHeight;
                            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                            if (i14 > i11 - i15) {
                                i12 = (i11 - i15) - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                        childAt.layout(i6, i16, measuredWidth + i6, measuredHeight + i16);
                    } else {
                        int i17 = i5 - i3;
                        childAt.layout(i6, (i17 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i17 - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
                    }
                    if (z2) {
                        c(childAt, f2);
                    }
                    int i18 = eVar.f2532b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i18) {
                        childAt.setVisibility(i18);
                    }
                }
            }
        }
        this.l = false;
        this.m = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode != Integer.MIN_VALUE && mode == 0) {
                size = InactivityTimer.INACTIVITY_DELAY_SECONDS;
            }
            if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                size2 = InactivityTimer.INACTIVITY_DELAY_SECONDS;
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z = this.C != null && y.n(this);
        int q = y.q(this);
        int childCount = getChildCount();
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (z) {
                    int a2 = a.h.j.e.a(eVar.f2531a, q);
                    if (y.n(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.C;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.C;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (g(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) eVar).leftMargin) - ((ViewGroup.MarginLayoutParams) eVar).rightMargin, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) eVar).topMargin) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, MemoryConstants.GB));
                } else {
                    if (!i(childAt)) {
                        throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                    }
                    if (O) {
                        float l = y.l(childAt);
                        float f2 = this.f2516b;
                        if (l != f2) {
                            y.a(childAt, f2);
                        }
                    }
                    int e2 = e(childAt) & 7;
                    boolean z4 = e2 == 3;
                    if ((z4 && z2) || (!z4 && z3)) {
                        throw new IllegalStateException("Child drawer has absolute gravity " + d(e2) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                    if (z4) {
                        z2 = true;
                    } else {
                        z3 = true;
                    }
                    childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.f2517c + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin, ((ViewGroup.MarginLayoutParams) eVar).width), ViewGroup.getChildMeasureSpec(i3, ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin, ((ViewGroup.MarginLayoutParams) eVar).height));
                    i5++;
                    i4 = 0;
                }
            }
            i5++;
            i4 = 0;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View a2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i2 = savedState.f2524c;
        if (i2 != 0 && (a2 = a(i2)) != null) {
            k(a2);
        }
        int i3 = savedState.f2525d;
        if (i3 != 3) {
            a(i3, 3);
        }
        int i4 = savedState.f2526e;
        if (i4 != 3) {
            a(i4, 5);
        }
        int i5 = savedState.f2527f;
        if (i5 != 3) {
            a(i5, 8388611);
        }
        int i6 = savedState.f2528g;
        if (i6 != 3) {
            a(i6, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        i();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            e eVar = (e) getChildAt(i2).getLayoutParams();
            boolean z = eVar.f2534d == 1;
            boolean z2 = eVar.f2534d == 2;
            if (z || z2) {
                savedState.f2524c = eVar.f2531a;
                break;
            }
        }
        savedState.f2525d = this.n;
        savedState.f2526e = this.o;
        savedState.f2527f = this.p;
        savedState.f2528g = this.q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        if (d(r7) != 2) goto L20;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            a.j.a.c r0 = r6.f2521g
            r0.a(r7)
            a.j.a.c r0 = r6.f2522h
            r0.a(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L62
            if (r0 == r2) goto L20
            r7 = 3
            if (r0 == r7) goto L1a
            goto L70
        L1a:
            r6.a(r2)
            r6.r = r1
            goto L70
        L20:
            float r0 = r7.getX()
            float r7 = r7.getY()
            a.j.a.c r3 = r6.f2521g
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.b(r4, r5)
            if (r3 == 0) goto L5d
            boolean r3 = r6.g(r3)
            if (r3 == 0) goto L5d
            float r3 = r6.v
            float r0 = r0 - r3
            float r3 = r6.w
            float r7 = r7 - r3
            a.j.a.c r3 = r6.f2521g
            int r3 = r3.f()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L5d
            android.view.View r7 = r6.c()
            if (r7 == 0) goto L5d
            int r7 = r6.d(r7)
            r0 = 2
            if (r7 != r0) goto L5e
        L5d:
            r1 = 1
        L5e:
            r6.a(r1)
            goto L70
        L62:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.v = r0
            r6.w = r7
            r6.r = r1
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            a(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.f2516b = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (i(childAt)) {
                y.a(childAt, this.f2516b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(d dVar) {
        d dVar2 = this.t;
        if (dVar2 != null) {
            b(dVar2);
        }
        if (dVar != null) {
            a(dVar);
        }
        this.t = dVar;
    }

    public void setDrawerLockMode(int i2) {
        a(i2, 3);
        a(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f2518d = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.x = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.x = new ColorDrawable(i2);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final boolean f() {
        return d() != null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2515a = new c();
        this.f2518d = SystemBarTintManager.DEFAULT_TINT_COLOR;
        this.f2520f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f2517c = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        this.f2523i = new f(3);
        this.j = new f(5);
        a.j.a.c a2 = a.j.a.c.a(this, 1.0f, this.f2523i);
        this.f2521g = a2;
        a2.g(1);
        this.f2521g.b(f3);
        this.f2523i.a(this.f2521g);
        a.j.a.c a3 = a.j.a.c.a(this, 1.0f, this.j);
        this.f2522h = a3;
        a3.g(2);
        this.f2522h.b(f3);
        this.j.a(this.f2522h);
        setFocusableInTouchMode(true);
        y.h(this, 1);
        y.a(this, new b());
        setMotionEventSplittingEnabled(false);
        if (y.n(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new a(this));
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(L);
                try {
                    this.x = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.x = null;
            }
        }
        this.f2516b = f2 * 10.0f;
        this.I = new ArrayList<>();
    }

    public int b(int i2) {
        int q = y.q(this);
        if (i2 == 3) {
            int i3 = this.n;
            if (i3 != 3) {
                return i3;
            }
            int i4 = q == 0 ? this.p : this.q;
            if (i4 != 3) {
                return i4;
            }
            return 0;
        }
        if (i2 == 5) {
            int i5 = this.o;
            if (i5 != 3) {
                return i5;
            }
            int i6 = q == 0 ? this.q : this.p;
            if (i6 != 3) {
                return i6;
            }
            return 0;
        }
        if (i2 == 8388611) {
            int i7 = this.p;
            if (i7 != 3) {
                return i7;
            }
            int i8 = q == 0 ? this.n : this.o;
            if (i8 != 3) {
                return i8;
            }
            return 0;
        }
        if (i2 != 8388613) {
            return 0;
        }
        int i9 = this.q;
        if (i9 != 3) {
            return i9;
        }
        int i10 = q == 0 ? this.o : this.n;
        if (i10 != 3) {
            return i10;
        }
        return 0;
    }

    public final boolean e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((e) getChildAt(i2).getLayoutParams()).f2533c) {
                return true;
            }
        }
        return false;
    }

    public void setStatusBarBackground(int i2) {
        this.x = i2 != 0 ? a.h.b.a.c(getContext(), i2) : null;
        invalidate();
    }

    public boolean i(View view) {
        int a2 = a.h.j.e.a(((e) view.getLayoutParams()).f2531a, y.q(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
    }

    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f2531a;

        /* renamed from: b, reason: collision with root package name */
        public float f2532b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2533c;

        /* renamed from: d, reason: collision with root package name */
        public int f2534d;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2531a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f2531a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public e(int i2, int i3) {
            super(i2, i3);
            this.f2531a = 0;
        }

        public e(e eVar) {
            super((ViewGroup.MarginLayoutParams) eVar);
            this.f2531a = 0;
            this.f2531a = eVar.f2531a;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2531a = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2531a = 0;
        }
    }

    public static String d(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.u == null) {
            this.u = new ArrayList();
        }
        this.u.add(dVar);
    }

    public void c(View view) {
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2534d & 1) == 0) {
            eVar.f2534d = 1;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).a(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    public View d() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (i(childAt) && j(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public int f2524c;

        /* renamed from: d, reason: collision with root package name */
        public int f2525d;

        /* renamed from: e, reason: collision with root package name */
        public int f2526e;

        /* renamed from: f, reason: collision with root package name */
        public int f2527f;

        /* renamed from: g, reason: collision with root package name */
        public int f2528g;

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
            this.f2524c = 0;
            this.f2524c = parcel.readInt();
            this.f2525d = parcel.readInt();
            this.f2526e = parcel.readInt();
            this.f2527f = parcel.readInt();
            this.f2528g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f2524c);
            parcel.writeInt(this.f2525d);
            parcel.writeInt(this.f2526e);
            parcel.writeInt(this.f2527f);
            parcel.writeInt(this.f2528g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f2524c = 0;
        }
    }

    public void a(int i2, int i3) {
        View a2;
        int a3 = a.h.j.e.a(i3, y.q(this));
        if (i3 == 3) {
            this.n = i2;
        } else if (i3 == 5) {
            this.o = i2;
        } else if (i3 == 8388611) {
            this.p = i2;
        } else if (i3 == 8388613) {
            this.q = i2;
        }
        if (i2 != 0) {
            (a3 == 3 ? this.f2521g : this.f2522h).b();
        }
        if (i2 != 1) {
            if (i2 == 2 && (a2 = a(a3)) != null) {
                k(a2);
                return;
            }
            return;
        }
        View a4 = a(a3);
        if (a4 != null) {
            a(a4);
        }
    }

    public boolean g(View view) {
        return ((e) view.getLayoutParams()).f2531a == 0;
    }

    public boolean h(View view) {
        if (i(view)) {
            return (((e) view.getLayoutParams()).f2534d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final MotionEvent b(MotionEvent motionEvent, View view) {
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(scrollX, scrollY);
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.K == null) {
                this.K = new Matrix();
            }
            matrix.invert(this.K);
            obtain.transform(this.K);
        }
        return obtain;
    }

    public final void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((!z && !i(childAt)) || (z && childAt == view)) {
                y.h(childAt, 1);
            } else {
                y.h(childAt, 4);
            }
        }
    }

    public class b extends a.h.j.a {

        /* renamed from: d, reason: collision with root package name */
        public final Rect f2529d = new Rect();

        public b() {
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            if (DrawerLayout.N) {
                super.a(view, cVar);
            } else {
                a.h.j.h0.c a2 = a.h.j.h0.c.a(cVar);
                super.a(view, a2);
                cVar.f(view);
                Object x = y.x(view);
                if (x instanceof View) {
                    cVar.e((View) x);
                }
                a(cVar, a2);
                a2.y();
                a(cVar, (ViewGroup) view);
            }
            cVar.a((CharSequence) DrawerLayout.class.getName());
            cVar.g(false);
            cVar.h(false);
            cVar.b(c.a.f1174e);
            cVar.b(c.a.f1175f);
        }

        @Override // a.h.j.a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            super.b(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // a.h.j.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() == 32) {
                List<CharSequence> text = accessibilityEvent.getText();
                View d2 = DrawerLayout.this.d();
                if (d2 == null) {
                    return true;
                }
                CharSequence c2 = DrawerLayout.this.c(DrawerLayout.this.e(d2));
                if (c2 == null) {
                    return true;
                }
                text.add(c2);
                return true;
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // a.h.j.a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.m(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public final void a(a.h.j.h0.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.m(childAt)) {
                    cVar.a(childAt);
                }
            }
        }

        public final void a(a.h.j.h0.c cVar, a.h.j.h0.c cVar2) {
            Rect rect = this.f2529d;
            cVar2.a(rect);
            cVar.c(rect);
            cVar2.b(rect);
            cVar.d(rect);
            cVar.o(cVar2.x());
            cVar.e(cVar2.h());
            cVar.a(cVar2.e());
            cVar.b(cVar2.f());
            cVar.f(cVar2.p());
            cVar.e(cVar2.o());
            cVar.g(cVar2.q());
            cVar.h(cVar2.r());
            cVar.a(cVar2.l());
            cVar.m(cVar2.v());
            cVar.j(cVar2.s());
            cVar.a(cVar2.c());
        }
    }

    public void c(View view, float f2) {
        e eVar = (e) view.getLayoutParams();
        if (f2 == eVar.f2532b) {
            return;
        }
        eVar.f2532b = f2;
        a(view, f2);
    }

    public final boolean a(float f2, float f3, View view) {
        if (this.J == null) {
            this.J = new Rect();
        }
        view.getHitRect(this.J);
        return this.J.contains((int) f2, (int) f3);
    }

    public void b(View view) {
        View rootView;
        e eVar = (e) view.getLayoutParams();
        if ((eVar.f2534d & 1) == 1) {
            eVar.f2534d = 0;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).b(view);
                }
            }
            c(view, false);
            if (!hasWindowFocus() || (rootView = getRootView()) == null) {
                return;
            }
            rootView.sendAccessibilityEvent(32);
        }
    }

    public View c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((e) childAt.getLayoutParams()).f2534d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    public void b(View view, float f2) {
        float f3 = f(view);
        float width = view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (f3 * width));
        if (!a(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        c(view, f2);
    }

    public void a(int i2, int i3, View view) {
        int g2 = this.f2521g.g();
        int g3 = this.f2522h.g();
        int i4 = 2;
        if (g2 == 1 || g3 == 1) {
            i4 = 1;
        } else if (g2 != 2 && g3 != 2) {
            i4 = 0;
        }
        if (view != null && i3 == 0) {
            float f2 = ((e) view.getLayoutParams()).f2532b;
            if (f2 == 0.0f) {
                b(view);
            } else if (f2 == 1.0f) {
                c(view);
            }
        }
        if (i4 != this.k) {
            this.k = i4;
            List<d> list = this.u;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.get(size).a(i4);
                }
            }
        }
    }

    public void b() {
        a(false);
    }

    public void b(View view, boolean z) {
        if (i(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.m) {
                eVar.f2532b = 1.0f;
                eVar.f2534d = 1;
                c(view, true);
            } else if (z) {
                eVar.f2534d |= 2;
                if (a(view, 3)) {
                    this.f2521g.b(view, 0, view.getTop());
                } else {
                    this.f2522h.b(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                b(view, 1.0f);
                a(eVar.f2531a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void a(View view, float f2) {
        List<d> list = this.u;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.u.get(size).a(view, f2);
            }
        }
    }

    public boolean a(View view, int i2) {
        return (e(view) & i2) == i2;
    }

    public View a(int i2) {
        int a2 = a.h.j.e.a(i2, y.q(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean a(Drawable drawable, int i2) {
        if (drawable == null || !a.h.c.l.a.f(drawable)) {
            return false;
        }
        a.h.c.l.a.a(drawable, i2);
        return true;
    }

    public void a(boolean z) {
        boolean b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            e eVar = (e) childAt.getLayoutParams();
            if (i(childAt) && (!z || eVar.f2533c)) {
                int width = childAt.getWidth();
                if (a(childAt, 3)) {
                    b2 = this.f2521g.b(childAt, -width, childAt.getTop());
                } else {
                    b2 = this.f2522h.b(childAt, getWidth(), childAt.getTop());
                }
                z2 |= b2;
                eVar.f2533c = false;
            }
        }
        this.f2523i.c();
        this.j.c();
        if (z2) {
            invalidate();
        }
    }

    public void a(View view) {
        a(view, true);
    }

    public void a(View view, boolean z) {
        if (i(view)) {
            e eVar = (e) view.getLayoutParams();
            if (this.m) {
                eVar.f2532b = 0.0f;
                eVar.f2534d = 0;
            } else if (z) {
                eVar.f2534d |= 4;
                if (a(view, 3)) {
                    this.f2521g.b(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2522h.b(view, getWidth(), view.getTop());
                }
            } else {
                b(view, 0.0f);
                a(eVar.f2531a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void a() {
        if (this.r) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).dispatchTouchEvent(obtain);
        }
        obtain.recycle();
        this.r = true;
    }
}
