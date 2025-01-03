package c.c.a.c.b;

import a.h.j.y;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
public abstract class a<V extends View> extends c<V> {

    /* renamed from: d, reason: collision with root package name */
    public Runnable f5331d;

    /* renamed from: e, reason: collision with root package name */
    public OverScroller f5332e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5333f;

    /* renamed from: g, reason: collision with root package name */
    public int f5334g;

    /* renamed from: h, reason: collision with root package name */
    public int f5335h;

    /* renamed from: i, reason: collision with root package name */
    public int f5336i;
    public VelocityTracker j;

    /* compiled from: HeaderBehavior.java */
    /* renamed from: c.c.a.c.b.a$a, reason: collision with other inner class name */
    public class RunnableC0097a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f5337a;

        /* renamed from: b, reason: collision with root package name */
        public final V f5338b;

        public RunnableC0097a(CoordinatorLayout coordinatorLayout, V v) {
            this.f5337a = coordinatorLayout;
            this.f5338b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f5338b == null || (overScroller = a.this.f5332e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.e(this.f5337a, this.f5338b);
                return;
            }
            a aVar = a.this;
            aVar.c(this.f5337a, (CoordinatorLayout) this.f5338b, aVar.f5332e.getCurrY());
            y.a(this.f5338b, this);
        }
    }

    public a() {
        this.f5334g = -1;
        this.f5336i = -1;
    }

    public abstract boolean a(V v);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f5336i < 0) {
            this.f5336i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f5333f) {
            int i2 = this.f5334g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f5335h) > this.f5336i) {
                this.f5335h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f5334g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = a((a<V>) v) && coordinatorLayout.a(v, x, y2);
            this.f5333f = z;
            if (z) {
                this.f5335h = y2;
                this.f5334g = motionEvent.getPointerId(0);
                c();
                OverScroller overScroller = this.f5332e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f5332e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public abstract int b(V v);

    public abstract int b(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4);

    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f5334g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f5335h = r12
            goto L4c
        L2d:
            int r0 = r11.f5334g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f5335h
            int r7 = r1 - r0
            r11.f5335h = r0
            int r8 = r11.b(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.a(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.j
            int r4 = r11.f5334g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f5333f = r3
            r11.f5334g = r1
            android.view.VelocityTracker r13 = r11.j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.j = r13
        L81:
            android.view.VelocityTracker r13 = r11.j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f5333f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.c.b.a.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int c(V v);

    public int c(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return b(coordinatorLayout, (CoordinatorLayout) v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int d();

    public abstract void e(CoordinatorLayout coordinatorLayout, V v);

    public final void c() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5334g = -1;
        this.f5336i = -1;
    }

    public final int a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return b(coordinatorLayout, (CoordinatorLayout) v, d() - i2, i3, i4);
    }

    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, float f2) {
        Runnable runnable = this.f5331d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f5331d = null;
        }
        if (this.f5332e == null) {
            this.f5332e = new OverScroller(v.getContext());
        }
        this.f5332e.fling(0, b(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f5332e.computeScrollOffset()) {
            RunnableC0097a runnableC0097a = new RunnableC0097a(coordinatorLayout, v);
            this.f5331d = runnableC0097a;
            y.a(v, runnableC0097a);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }
}
