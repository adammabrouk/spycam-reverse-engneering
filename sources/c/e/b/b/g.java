package c.e.b.b;

import android.view.View;

/* compiled from: TranslateAlphaAnimator.java */
/* loaded from: classes.dex */
public class g extends c {

    /* renamed from: c, reason: collision with root package name */
    public float f6227c;

    /* renamed from: d, reason: collision with root package name */
    public float f6228d;

    /* renamed from: e, reason: collision with root package name */
    public float f6229e;

    /* renamed from: f, reason: collision with root package name */
    public float f6230f;

    /* compiled from: TranslateAlphaAnimator.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6231a;

        static {
            int[] iArr = new int[c.e.b.d.c.values().length];
            f6231a = iArr;
            try {
                iArr[c.e.b.d.c.TranslateAlphaFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6231a[c.e.b.d.c.TranslateAlphaFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6231a[c.e.b.d.c.TranslateAlphaFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6231a[c.e.b.d.c.TranslateAlphaFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(View view, c.e.b.d.c cVar) {
        super(view, cVar);
    }

    @Override // c.e.b.b.c
    public void a() {
        this.f6205a.animate().translationX(this.f6227c).translationY(this.f6228d).alpha(0.0f).setInterpolator(new a.l.a.a.b()).setDuration(c.e.b.a.a()).withLayer().start();
    }

    @Override // c.e.b.b.c
    public void b() {
        this.f6205a.animate().translationX(this.f6229e).translationY(this.f6230f).alpha(1.0f).setInterpolator(new a.l.a.a.b()).setDuration(c.e.b.a.a()).withLayer().start();
    }

    @Override // c.e.b.b.c
    public void c() {
        this.f6229e = this.f6205a.getTranslationX();
        this.f6230f = this.f6205a.getTranslationY();
        this.f6205a.setAlpha(0.0f);
        d();
        this.f6227c = this.f6205a.getTranslationX();
        this.f6228d = this.f6205a.getTranslationY();
    }

    public final void d() {
        int i2 = a.f6231a[this.f6206b.ordinal()];
        if (i2 == 1) {
            this.f6205a.setTranslationX(-r0.getMeasuredWidth());
            return;
        }
        if (i2 == 2) {
            this.f6205a.setTranslationY(-r0.getMeasuredHeight());
        } else if (i2 == 3) {
            this.f6205a.setTranslationX(r0.getMeasuredWidth());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f6205a.setTranslationY(r0.getMeasuredHeight());
        }
    }
}
