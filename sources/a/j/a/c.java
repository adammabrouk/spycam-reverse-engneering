package a.j.a;

import a.h.j.y;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.viewpager.widget.ViewPager;
import java.util.Arrays;

/* compiled from: ViewDragHelper.java */
/* loaded from: classes.dex */
public class c {
    public static final Interpolator w = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f1288a;

    /* renamed from: b, reason: collision with root package name */
    public int f1289b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f1291d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f1292e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f1293f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f1294g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f1295h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f1296i;
    public int[] j;
    public int k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public OverScroller q;
    public final AbstractC0037c r;
    public View s;
    public boolean t;
    public final ViewGroup u;

    /* renamed from: c, reason: collision with root package name */
    public int f1290c = -1;
    public final Runnable v = new b();

    /* compiled from: ViewDragHelper.java */
    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* compiled from: ViewDragHelper.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f(0);
        }
    }

    /* compiled from: ViewDragHelper.java */
    /* renamed from: a.j.a.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0037c {
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i2, int i3) {
            return 0;
        }

        public int getOrderedChildIndex(int i2) {
            return i2;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i2, int i3) {
        }

        public boolean onEdgeLock(int i2) {
            return false;
        }

        public void onEdgeTouched(int i2, int i3) {
        }

        public void onViewCaptured(View view, int i2) {
        }

        public void onViewDragStateChanged(int i2) {
        }

        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
        }

        public void onViewReleased(View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(View view, int i2);
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0037c abstractC0037c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0037c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.u = viewGroup;
        this.r = abstractC0037c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1289b = viewConfiguration.getScaledTouchSlop();
        this.m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.q = new OverScroller(context, w);
    }

    public static c a(ViewGroup viewGroup, AbstractC0037c abstractC0037c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0037c);
    }

    public void b(float f2) {
        this.n = f2;
    }

    public final void c() {
        float[] fArr = this.f1291d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1292e, 0.0f);
        Arrays.fill(this.f1293f, 0.0f);
        Arrays.fill(this.f1294g, 0.0f);
        Arrays.fill(this.f1295h, 0);
        Arrays.fill(this.f1296i, 0);
        Arrays.fill(this.j, 0);
        this.k = 0;
    }

    public View d() {
        return this.s;
    }

    public int e() {
        return this.o;
    }

    public int f() {
        return this.f1289b;
    }

    public int g() {
        return this.f1288a;
    }

    public final void h() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(a(this.l.getXVelocity(this.f1290c), this.n, this.m), a(this.l.getYVelocity(this.f1290c), this.n, this.m));
    }

    public static c a(ViewGroup viewGroup, float f2, AbstractC0037c abstractC0037c) {
        c a2 = a(viewGroup, abstractC0037c);
        a2.f1289b = (int) (a2.f1289b * (1.0f / f2));
        return a2;
    }

    public void b() {
        this.f1290c = -1;
        c();
        VelocityTracker velocityTracker = this.l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.l = null;
        }
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.k) != 0;
    }

    public boolean e(int i2, int i3) {
        if (this.t) {
            return b(i2, i3, (int) this.l.getXVelocity(this.f1290c), (int) this.l.getYVelocity(this.f1290c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    public void f(int i2) {
        this.u.removeCallbacks(this.v);
        if (this.f1288a != i2) {
            this.f1288a = i2;
            this.r.onViewDragStateChanged(i2);
            if (this.f1288a == 0) {
                this.s = null;
            }
        }
    }

    public void g(int i2) {
        this.p = i2;
    }

    public boolean d(int i2, int i3) {
        return a(this.s, i2, i3);
    }

    public void a(View view, int i2) {
        if (view.getParent() == this.u) {
            this.s = view;
            this.f1290c = i2;
            this.r.onViewCaptured(view, i2);
            f(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
    }

    public boolean b(View view, int i2, int i3) {
        this.s = view;
        this.f1290c = -1;
        boolean b2 = b(i2, i3, 0, 0);
        if (!b2 && this.f1288a == 0 && this.s != null) {
            this.s = null;
        }
        return b2;
    }

    public final boolean e(int i2) {
        if (d(i2)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public void a() {
        b();
        if (this.f1288a == 2) {
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            this.q.abortAnimation();
            int currX2 = this.q.getCurrX();
            int currY2 = this.q.getCurrY();
            this.r.onViewPositionChanged(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        f(0);
    }

    public final void c(int i2) {
        float[] fArr = this.f1291d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            float[] fArr6 = this.f1291d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1292e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f1293f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f1294g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f1295h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1296i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1291d = fArr2;
            this.f1292e = fArr3;
            this.f1293f = fArr4;
            this.f1294g = fArr5;
            this.f1295h = iArr;
            this.f1296i = iArr2;
            this.j = iArr3;
        }
    }

    public final boolean b(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.abortAnimation();
            f(0);
            return false;
        }
        this.q.startScroll(left, top, i6, i7, a(this.s, i6, i7, i4, i5));
        f(2);
        return true;
    }

    public final int a(View view, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int a2 = a(i4, (int) this.n, (int) this.m);
        int a3 = a(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i2);
        int abs2 = Math.abs(i3);
        int abs3 = Math.abs(a2);
        int abs4 = Math.abs(a3);
        int i6 = abs3 + abs4;
        int i7 = abs + abs2;
        if (a2 != 0) {
            f2 = abs3;
            f3 = i6;
        } else {
            f2 = abs;
            f3 = i7;
        }
        float f6 = f2 / f3;
        if (a3 != 0) {
            f4 = abs4;
            f5 = i6;
        } else {
            f4 = abs2;
            f5 = i7;
        }
        return (int) ((b(i2, a2, this.r.getViewHorizontalDragRange(view)) * f6) + (b(i3, a3, this.r.getViewVerticalDragRange(view)) * (f4 / f5)));
    }

    public final int b(int i2, int i3, int i4) {
        int abs;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = width / 2;
        float a2 = f2 + (a(Math.min(1.0f, Math.abs(i2) / width)) * f2);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f);
        }
        return Math.min(abs, ViewPager.MAX_SETTLE_DURATION);
    }

    public final int a(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
    }

    public final void b(int i2) {
        if (this.f1291d == null || !d(i2)) {
            return;
        }
        this.f1291d[i2] = 0.0f;
        this.f1292e[i2] = 0.0f;
        this.f1293f[i2] = 0.0f;
        this.f1294g[i2] = 0.0f;
        this.f1295h[i2] = 0;
        this.f1296i[i2] = 0;
        this.j[i2] = 0;
        this.k = ((1 << i2) ^ (-1)) & this.k;
    }

    public final float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    public final float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    public boolean a(boolean z) {
        if (this.f1288a == 2) {
            boolean computeScrollOffset = this.q.computeScrollOffset();
            int currX = this.q.getCurrX();
            int currY = this.q.getCurrY();
            int left = currX - this.s.getLeft();
            int top = currY - this.s.getTop();
            if (left != 0) {
                y.d(this.s, left);
            }
            if (top != 0) {
                y.e(this.s, top);
            }
            if (left != 0 || top != 0) {
                this.r.onViewPositionChanged(this.s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                this.q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.u.post(this.v);
                } else {
                    f(0);
                }
            }
        }
        return this.f1288a == 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j.a.c.c(android.view.MotionEvent):boolean");
    }

    public final void b(float f2, float f3, int i2) {
        c(i2);
        float[] fArr = this.f1291d;
        this.f1293f[i2] = f2;
        fArr[i2] = f2;
        float[] fArr2 = this.f1292e;
        this.f1294g[i2] = f3;
        fArr2[i2] = f3;
        this.f1295h[i2] = c((int) f2, (int) f3);
        this.k |= 1 << i2;
    }

    public final void b(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (e(pointerId)) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f1293f[pointerId] = x;
                this.f1294g[pointerId] = y;
            }
        }
    }

    public final void a(float f2, float f3) {
        this.t = true;
        this.r.onViewReleased(this.s, f2, f3);
        this.t = false;
        if (this.f1288a == 1) {
            f(0);
        }
    }

    public boolean b(View view, int i2) {
        if (view == this.s && this.f1290c == i2) {
            return true;
        }
        if (view == null || !this.r.tryCaptureView(view, i2)) {
            return false;
        }
        this.f1290c = i2;
        a(view, i2);
        return true;
    }

    public void a(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View b2 = b((int) x, (int) y);
            b(x, y, pointerId);
            b(b2, pointerId);
            int i4 = this.f1295h[pointerId];
            int i5 = this.p;
            if ((i4 & i5) != 0) {
                this.r.onEdgeTouched(i4 & i5, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f1288a == 1) {
                h();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.f1288a == 1) {
                if (e(this.f1290c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1290c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f1293f;
                    int i6 = this.f1290c;
                    int i7 = (int) (x2 - fArr[i6]);
                    int i8 = (int) (y2 - this.f1294g[i6]);
                    a(this.s.getLeft() + i7, this.s.getTop() + i8, i7, i8);
                    b(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i3 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i3);
                if (e(pointerId2)) {
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.f1291d[pointerId2];
                    float f3 = y3 - this.f1292e[pointerId2];
                    a(f2, f3, pointerId2);
                    if (this.f1288a != 1) {
                        View b3 = b((int) x3, (int) y3);
                        if (a(b3, f2, f3) && b(b3, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i3++;
            }
            b(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f1288a == 1) {
                a(0.0f, 0.0f);
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            b(x4, y4, pointerId3);
            if (this.f1288a == 0) {
                b(b((int) x4, (int) y4), pointerId3);
                int i9 = this.f1295h[pointerId3];
                int i10 = this.p;
                if ((i9 & i10) != 0) {
                    this.r.onEdgeTouched(i9 & i10, pointerId3);
                    return;
                }
                return;
            }
            if (d((int) x4, (int) y4)) {
                b(this.s, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f1288a == 1 && pointerId4 == this.f1290c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.f1290c) {
                    View b4 = b((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view = this.s;
                    if (b4 == view && b(view, pointerId5)) {
                        i2 = this.f1290c;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                h();
            }
        }
        b(pointerId4);
    }

    public View b(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.u.getChildAt(this.r.getOrderedChildIndex(childCount));
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final int c(int i2, int i3) {
        int i4 = i2 < this.u.getLeft() + this.o ? 1 : 0;
        if (i3 < this.u.getTop() + this.o) {
            i4 |= 4;
        }
        if (i2 > this.u.getRight() - this.o) {
            i4 |= 2;
        }
        return i3 > this.u.getBottom() - this.o ? i4 | 8 : i4;
    }

    public final void a(float f2, float f3, int i2) {
        int i3 = a(f2, f3, i2, 1) ? 1 : 0;
        if (a(f3, f2, i2, 4)) {
            i3 |= 4;
        }
        if (a(f2, f3, i2, 2)) {
            i3 |= 2;
        }
        if (a(f3, f2, i2, 8)) {
            i3 |= 8;
        }
        if (i3 != 0) {
            int[] iArr = this.f1296i;
            iArr[i2] = iArr[i2] | i3;
            this.r.onEdgeDragStarted(i3, i2);
        }
    }

    public final boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.f1295h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.j[i2] & i3) == i3 || (this.f1296i[i2] & i3) == i3) {
            return false;
        }
        int i4 = this.f1289b;
        if (abs <= i4 && abs2 <= i4) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.r.onEdgeLock(i3)) {
            return (this.f1296i[i2] & i3) == 0 && abs > ((float) this.f1289b);
        }
        int[] iArr = this.j;
        iArr[i2] = iArr[i2] | i3;
        return false;
    }

    public final boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.r.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f1289b) : z2 && Math.abs(f3) > ((float) this.f1289b);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i2 = this.f1289b;
        return f4 > ((float) (i2 * i2));
    }

    public boolean a(int i2) {
        int length = this.f1291d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (a(i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3) {
        if (!d(i3)) {
            return false;
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        float f2 = this.f1293f[i3] - this.f1291d[i3];
        float f3 = this.f1294g[i3] - this.f1292e[i3];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f1289b) : z2 && Math.abs(f3) > ((float) this.f1289b);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i4 = this.f1289b;
        return f4 > ((float) (i4 * i4));
    }

    public final void a(int i2, int i3, int i4, int i5) {
        int left = this.s.getLeft();
        int top = this.s.getTop();
        if (i4 != 0) {
            i2 = this.r.clampViewPositionHorizontal(this.s, i2, i4);
            y.d(this.s, i2 - left);
        }
        int i6 = i2;
        if (i5 != 0) {
            i3 = this.r.clampViewPositionVertical(this.s, i3, i5);
            y.e(this.s, i3 - top);
        }
        int i7 = i3;
        if (i4 == 0 && i5 == 0) {
            return;
        }
        this.r.onViewPositionChanged(this.s, i6, i7, i6 - left, i7 - top);
    }

    public boolean a(View view, int i2, int i3) {
        return view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom();
    }
}
