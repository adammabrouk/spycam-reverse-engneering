package a.b.f;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class u implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f579a;

    /* renamed from: b, reason: collision with root package name */
    public final int f580b;

    /* renamed from: c, reason: collision with root package name */
    public final int f581c;

    /* renamed from: d, reason: collision with root package name */
    public final View f582d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f583e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f584f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f585g;

    /* renamed from: h, reason: collision with root package name */
    public int f586h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f587i = new int[2];

    /* compiled from: ForwardingListener.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = u.this.f582d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u.this.e();
        }
    }

    public u(View view) {
        this.f582d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f579a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f580b = tapTimeout;
        this.f581c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public final void a() {
        Runnable runnable = this.f584f;
        if (runnable != null) {
            this.f582d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f583e;
        if (runnable2 != null) {
            this.f582d.removeCallbacks(runnable2);
        }
    }

    public abstract a.b.e.j.p b();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
    
        if (r1 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f582d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f586h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f579a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f586h = r6
            java.lang.Runnable r6 = r5.f583e
            if (r6 != 0) goto L52
            a.b.f.u$a r6 = new a.b.f.u$a
            r6.<init>()
            r5.f583e = r6
        L52:
            java.lang.Runnable r6 = r5.f583e
            int r1 = r5.f580b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f584f
            if (r6 != 0) goto L65
            a.b.f.u$b r6 = new a.b.f.u$b
            r6.<init>()
            r5.f584f = r6
        L65:
            java.lang.Runnable r6 = r5.f584f
            int r1 = r5.f581c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.f.u.b(android.view.MotionEvent):boolean");
    }

    public abstract boolean c();

    public boolean d() {
        a.b.e.j.p b2 = b();
        if (b2 == null || !b2.a()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f582d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f585g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f585g;
        if (z2) {
            z = a(motionEvent) || !d();
        } else {
            z = b(motionEvent) && c();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f582d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f585g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f585g = false;
        this.f586h = -1;
        Runnable runnable = this.f583e;
        if (runnable != null) {
            this.f582d.removeCallbacks(runnable);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        s sVar;
        View view = this.f582d;
        a.b.e.j.p b2 = b();
        if (b2 == null || !b2.a() || (sVar = (s) b2.e()) == null || !sVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a(view, obtainNoHistory);
        b(sVar, obtainNoHistory);
        boolean a2 = sVar.a(obtainNoHistory, this.f586h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a2 && (actionMasked != 1 && actionMasked != 3);
    }

    public static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f587i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f587i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }
}
