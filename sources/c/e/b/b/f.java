package c.e.b.b;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;

/* compiled from: ShadowBgAnimator.java */
/* loaded from: classes.dex */
public class f extends c {

    /* renamed from: c, reason: collision with root package name */
    public ArgbEvaluator f6222c;

    /* renamed from: d, reason: collision with root package name */
    public int f6223d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6224e;

    /* compiled from: ShadowBgAnimator.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.f6205a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* compiled from: ShadowBgAnimator.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.f6205a.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public f(View view) {
        super(view);
        this.f6222c = new ArgbEvaluator();
        this.f6223d = 0;
        this.f6224e = false;
    }

    @Override // c.e.b.b.c
    public void a() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f6222c, Integer.valueOf(c.e.b.a.c()), Integer.valueOf(this.f6223d));
        ofObject.addUpdateListener(new b());
        ofObject.setInterpolator(new a.l.a.a.b());
        ofObject.setDuration(this.f6224e ? 0L : c.e.b.a.a()).start();
    }

    @Override // c.e.b.b.c
    public void b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f6222c, Integer.valueOf(this.f6223d), Integer.valueOf(c.e.b.a.c()));
        ofObject.addUpdateListener(new a());
        ofObject.setInterpolator(new a.l.a.a.b());
        ofObject.setDuration(this.f6224e ? 0L : c.e.b.a.a()).start();
    }

    @Override // c.e.b.b.c
    public void c() {
        this.f6205a.setBackgroundColor(this.f6223d);
    }

    public f() {
        this.f6222c = new ArgbEvaluator();
        this.f6223d = 0;
        this.f6224e = false;
    }

    public int a(float f2) {
        return ((Integer) this.f6222c.evaluate(f2, Integer.valueOf(this.f6223d), Integer.valueOf(c.e.b.a.c()))).intValue();
    }
}
