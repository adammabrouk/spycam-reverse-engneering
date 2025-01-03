package c.e.b.f;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.google.zxing.view.ViewfinderView;

/* compiled from: CustomGestureDetector.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f6256a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f6257b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f6258c;

    /* renamed from: d, reason: collision with root package name */
    public VelocityTracker f6259d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6260e;

    /* renamed from: f, reason: collision with root package name */
    public float f6261f;

    /* renamed from: g, reason: collision with root package name */
    public float f6262g;

    /* renamed from: h, reason: collision with root package name */
    public final float f6263h;

    /* renamed from: i, reason: collision with root package name */
    public final float f6264i;
    public c j;

    /* compiled from: CustomGestureDetector.java */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            b.this.j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public b(Context context, c cVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f6264i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6263h = viewConfiguration.getScaledTouchSlop();
        this.j = cVar;
        this.f6258c = new ScaleGestureDetector(context, new a());
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f6257b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        try {
            if (motionEvent.getPointerCount() > 1) {
                this.f6258c.onTouchEvent(motionEvent);
            }
            return d(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean d(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & ViewfinderView.OPAQUE;
        if (action == 0) {
            this.f6256a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f6259d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f6261f = a(motionEvent);
            this.f6262g = b(motionEvent);
            this.f6260e = false;
        } else if (action == 1) {
            this.f6256a = -1;
            if (this.f6260e && this.f6259d != null) {
                this.f6261f = a(motionEvent);
                this.f6262g = b(motionEvent);
                this.f6259d.addMovement(motionEvent);
                this.f6259d.computeCurrentVelocity(1000);
                float xVelocity = this.f6259d.getXVelocity();
                float yVelocity = this.f6259d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f6264i) {
                    this.j.onFling(this.f6261f, this.f6262g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f6259d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f6259d = null;
            }
        } else if (action == 2) {
            float a2 = a(motionEvent);
            float b2 = b(motionEvent);
            float f2 = a2 - this.f6261f;
            float f3 = b2 - this.f6262g;
            if (!this.f6260e) {
                this.f6260e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f6263h);
            }
            if (this.f6260e) {
                this.j.onDrag(f2, f3);
                this.f6261f = a2;
                this.f6262g = b2;
                VelocityTracker velocityTracker2 = this.f6259d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f6256a = -1;
            VelocityTracker velocityTracker3 = this.f6259d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f6259d = null;
            }
        } else if (action == 6) {
            int a3 = l.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a3) == this.f6256a) {
                int i2 = a3 == 0 ? 1 : 0;
                this.f6256a = motionEvent.getPointerId(i2);
                this.f6261f = motionEvent.getX(i2);
                this.f6262g = motionEvent.getY(i2);
            }
        }
        int i3 = this.f6256a;
        this.f6257b = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        return true;
    }

    public final float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f6257b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public boolean b() {
        return this.f6258c.isInProgress();
    }

    public boolean a() {
        return this.f6260e;
    }
}
