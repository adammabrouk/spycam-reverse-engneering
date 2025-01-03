package c.e.b.b;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ScrollScaleAnimator.java */
/* loaded from: classes.dex */
public class e extends c.e.b.b.c {

    /* renamed from: c, reason: collision with root package name */
    public IntEvaluator f6211c;

    /* renamed from: d, reason: collision with root package name */
    public int f6212d;

    /* renamed from: e, reason: collision with root package name */
    public int f6213e;

    /* renamed from: f, reason: collision with root package name */
    public float f6214f;

    /* renamed from: g, reason: collision with root package name */
    public float f6215g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6216h;

    /* compiled from: ScrollScaleAnimator.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.d();
            e eVar = e.this;
            eVar.f6205a.scrollTo(eVar.f6212d, e.this.f6213e);
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    public class b implements Runnable {

        /* compiled from: ScrollScaleAnimator.java */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                e.this.f6205a.setAlpha(animatedFraction);
                e eVar = e.this;
                eVar.f6205a.scrollTo(eVar.f6211c.evaluate(animatedFraction, Integer.valueOf(e.this.f6212d), (Integer) 0).intValue(), e.this.f6211c.evaluate(animatedFraction, Integer.valueOf(e.this.f6213e), (Integer) 0).intValue());
                e.this.f6205a.setScaleX(animatedFraction);
                e eVar2 = e.this;
                if (eVar2.f6216h) {
                    return;
                }
                eVar2.f6205a.setScaleY(animatedFraction);
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new a());
            ofFloat.setDuration(c.e.b.a.a()).setInterpolator(new a.l.a.a.b());
            ofFloat.start();
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            float f2 = 1.0f - animatedFraction;
            e.this.f6205a.setAlpha(f2);
            e eVar = e.this;
            eVar.f6205a.scrollTo(eVar.f6211c.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(e.this.f6212d)).intValue(), e.this.f6211c.evaluate(animatedFraction, (Integer) 0, Integer.valueOf(e.this.f6213e)).intValue());
            e.this.f6205a.setScaleX(f2);
            e eVar2 = e.this;
            if (eVar2.f6216h) {
                return;
            }
            eVar2.f6205a.setScaleY(f2);
        }
    }

    /* compiled from: ScrollScaleAnimator.java */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6221a;

        static {
            int[] iArr = new int[c.e.b.d.c.values().length];
            f6221a = iArr;
            try {
                iArr[c.e.b.d.c.ScrollAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromLeftTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromTop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromRightTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromRight.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromRightBottom.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6221a[c.e.b.d.c.ScrollAlphaFromLeftBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public e(View view, c.e.b.d.c cVar) {
        super(view, cVar);
        this.f6211c = new IntEvaluator();
        this.f6214f = 0.0f;
        this.f6215g = 0.0f;
        this.f6216h = false;
    }

    @Override // c.e.b.b.c
    public void a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new c());
        ofFloat.setDuration(c.e.b.a.a()).setInterpolator(new a.l.a.a.b());
        ofFloat.start();
    }

    @Override // c.e.b.b.c
    public void b() {
        this.f6205a.post(new b());
    }

    @Override // c.e.b.b.c
    public void c() {
        this.f6205a.setAlpha(this.f6214f);
        this.f6205a.setScaleX(this.f6215g);
        if (!this.f6216h) {
            this.f6205a.setScaleY(this.f6215g);
        }
        this.f6205a.post(new a());
    }

    public final void d() {
        switch (d.f6221a[this.f6206b.ordinal()]) {
            case 1:
                this.f6205a.setPivotX(0.0f);
                this.f6205a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f6212d = this.f6205a.getMeasuredWidth();
                this.f6213e = 0;
                break;
            case 2:
                this.f6205a.setPivotX(0.0f);
                this.f6205a.setPivotY(0.0f);
                this.f6212d = this.f6205a.getMeasuredWidth();
                this.f6213e = this.f6205a.getMeasuredHeight();
                break;
            case 3:
                this.f6205a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f6205a.setPivotY(0.0f);
                this.f6213e = this.f6205a.getMeasuredHeight();
                break;
            case 4:
                this.f6205a.setPivotX(r0.getMeasuredWidth());
                this.f6205a.setPivotY(0.0f);
                this.f6212d = -this.f6205a.getMeasuredWidth();
                this.f6213e = this.f6205a.getMeasuredHeight();
                break;
            case 5:
                this.f6205a.setPivotX(r0.getMeasuredWidth());
                this.f6205a.setPivotY(r0.getMeasuredHeight() / 2);
                this.f6212d = -this.f6205a.getMeasuredWidth();
                break;
            case 6:
                this.f6205a.setPivotX(r0.getMeasuredWidth());
                this.f6205a.setPivotY(r0.getMeasuredHeight());
                this.f6212d = -this.f6205a.getMeasuredWidth();
                this.f6213e = -this.f6205a.getMeasuredHeight();
                break;
            case 7:
                this.f6205a.setPivotX(r0.getMeasuredWidth() / 2);
                this.f6205a.setPivotY(r0.getMeasuredHeight());
                this.f6213e = -this.f6205a.getMeasuredHeight();
                break;
            case 8:
                this.f6205a.setPivotX(0.0f);
                this.f6205a.setPivotY(r0.getMeasuredHeight());
                this.f6212d = this.f6205a.getMeasuredWidth();
                this.f6213e = -this.f6205a.getMeasuredHeight();
                break;
        }
    }
}
