package c.e.b.b;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: TranslateAnimator.java */
/* loaded from: classes.dex */
public class h extends c {

    /* renamed from: c, reason: collision with root package name */
    public float f6232c;

    /* renamed from: d, reason: collision with root package name */
    public float f6233d;

    /* renamed from: e, reason: collision with root package name */
    public int f6234e;

    /* renamed from: f, reason: collision with root package name */
    public int f6235f;

    /* renamed from: g, reason: collision with root package name */
    public float f6236g;

    /* renamed from: h, reason: collision with root package name */
    public float f6237h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6238i;

    /* compiled from: TranslateAnimator.java */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6239a;

        static {
            int[] iArr = new int[c.e.b.d.c.values().length];
            f6239a = iArr;
            try {
                iArr[c.e.b.d.c.TranslateFromLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6239a[c.e.b.d.c.TranslateFromTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6239a[c.e.b.d.c.TranslateFromRight.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6239a[c.e.b.d.c.TranslateFromBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public h(View view, c.e.b.d.c cVar) {
        super(view, cVar);
        this.f6238i = false;
    }

    @Override // c.e.b.b.c
    public void a() {
        ViewPropertyAnimator translationX;
        int i2 = a.f6239a[this.f6206b.ordinal()];
        if (i2 == 1) {
            this.f6232c -= this.f6205a.getMeasuredWidth() - this.f6234e;
            translationX = this.f6205a.animate().translationX(this.f6232c);
        } else if (i2 == 2) {
            this.f6233d -= this.f6205a.getMeasuredHeight() - this.f6235f;
            translationX = this.f6205a.animate().translationY(this.f6233d);
        } else if (i2 == 3) {
            this.f6232c += this.f6205a.getMeasuredWidth() - this.f6234e;
            translationX = this.f6205a.animate().translationX(this.f6232c);
        } else if (i2 != 4) {
            translationX = null;
        } else {
            this.f6233d += this.f6205a.getMeasuredHeight() - this.f6235f;
            translationX = this.f6205a.animate().translationY(this.f6233d);
        }
        if (translationX != null) {
            translationX.setInterpolator(new a.l.a.a.b()).setDuration(c.e.b.a.a()).withLayer().start();
        }
    }

    @Override // c.e.b.b.c
    public void b() {
        ViewPropertyAnimator translationX;
        int i2 = a.f6239a[this.f6206b.ordinal()];
        if (i2 == 1) {
            this.f6205a.setTranslationX(-r0.getRight());
            translationX = this.f6205a.animate().translationX(this.f6236g);
        } else if (i2 == 2) {
            this.f6205a.setTranslationY(-r0.getBottom());
            translationX = this.f6205a.animate().translationY(this.f6237h);
        } else if (i2 == 3) {
            this.f6205a.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.f6205a.getLeft());
            translationX = this.f6205a.animate().translationX(this.f6236g);
        } else if (i2 != 4) {
            translationX = null;
        } else {
            this.f6205a.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.f6205a.getTop());
            translationX = this.f6205a.animate().translationY(this.f6237h);
        }
        if (translationX != null) {
            translationX.setInterpolator(new a.l.a.a.b()).setDuration(c.e.b.a.a()).withLayer().start();
        }
    }

    @Override // c.e.b.b.c
    public void c() {
        if (!this.f6238i) {
            this.f6236g = this.f6205a.getTranslationX();
            this.f6237h = this.f6205a.getTranslationY();
            this.f6238i = true;
        }
        d();
        this.f6232c = this.f6205a.getTranslationX();
        this.f6233d = this.f6205a.getTranslationY();
        this.f6234e = this.f6205a.getMeasuredWidth();
        this.f6235f = this.f6205a.getMeasuredHeight();
    }

    public final void d() {
        int i2 = a.f6239a[this.f6206b.ordinal()];
        if (i2 == 1) {
            this.f6205a.setTranslationX(-r0.getRight());
            return;
        }
        if (i2 == 2) {
            this.f6205a.setTranslationY(-r0.getBottom());
        } else if (i2 == 3) {
            this.f6205a.setTranslationX(((View) r0.getParent()).getMeasuredWidth() - this.f6205a.getLeft());
        } else {
            if (i2 != 4) {
                return;
            }
            this.f6205a.setTranslationY(((View) r0.getParent()).getMeasuredHeight() - this.f6205a.getTop());
        }
    }
}
