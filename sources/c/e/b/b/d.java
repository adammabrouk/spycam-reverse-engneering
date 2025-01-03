package c.e.b.b;

import android.view.View;
import android.view.animation.OvershootInterpolator;

/* compiled from: ScaleAlphaAnimator.java */
/* loaded from: classes.dex */
public class d extends c.e.b.b.c {

    /* renamed from: c, reason: collision with root package name */
    public float f6207c;

    /* compiled from: ScaleAlphaAnimator.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.d();
        }
    }

    /* compiled from: ScaleAlphaAnimator.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f6205a.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(c.e.b.a.a()).setInterpolator(new OvershootInterpolator(1.0f)).start();
        }
    }

    /* compiled from: ScaleAlphaAnimator.java */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6210a;

        static {
            int[] iArr = new int[c.e.b.d.c.values().length];
            f6210a = iArr;
            try {
                iArr[c.e.b.d.c.ScaleAlphaFromCenter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6210a[c.e.b.d.c.ScaleAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6210a[c.e.b.d.c.ScaleAlphaFromRightTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6210a[c.e.b.d.c.ScaleAlphaFromLeftBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6210a[c.e.b.d.c.ScaleAlphaFromRightBottom.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public d(View view, c.e.b.d.c cVar) {
        super(view, cVar);
        this.f6207c = 0.75f;
    }

    @Override // c.e.b.b.c
    public void b() {
        this.f6205a.post(new b());
    }

    @Override // c.e.b.b.c
    public void c() {
        this.f6205a.setScaleX(this.f6207c);
        this.f6205a.setScaleY(this.f6207c);
        this.f6205a.setAlpha(0.0f);
        this.f6205a.post(new a());
    }

    public final void d() {
        int i2 = c.f6210a[this.f6206b.ordinal()];
        if (i2 == 1) {
            this.f6205a.setPivotX(r0.getMeasuredWidth() / 2);
            this.f6205a.setPivotY(r0.getMeasuredHeight() / 2);
            return;
        }
        if (i2 == 2) {
            this.f6205a.setPivotX(0.0f);
            this.f6205a.setPivotY(0.0f);
            return;
        }
        if (i2 == 3) {
            this.f6205a.setPivotX(r0.getMeasuredWidth());
            this.f6205a.setPivotY(0.0f);
        } else if (i2 == 4) {
            this.f6205a.setPivotX(0.0f);
            this.f6205a.setPivotY(r0.getMeasuredHeight());
        } else {
            if (i2 != 5) {
                return;
            }
            this.f6205a.setPivotX(r0.getMeasuredWidth());
            this.f6205a.setPivotY(r0.getMeasuredHeight());
        }
    }

    @Override // c.e.b.b.c
    public void a() {
        this.f6205a.animate().scaleX(this.f6207c).scaleY(this.f6207c).alpha(0.0f).setDuration(c.e.b.a.a()).setInterpolator(new a.l.a.a.b()).start();
    }
}
