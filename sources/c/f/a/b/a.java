package c.f.a.b;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: AnimatorProxy.java */
/* loaded from: classes.dex */
public final class a extends Animation {
    public static final boolean q;
    public static final WeakHashMap<View, a> r;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f6335a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6337c;

    /* renamed from: e, reason: collision with root package name */
    public float f6339e;

    /* renamed from: f, reason: collision with root package name */
    public float f6340f;

    /* renamed from: g, reason: collision with root package name */
    public float f6341g;

    /* renamed from: h, reason: collision with root package name */
    public float f6342h;

    /* renamed from: i, reason: collision with root package name */
    public float f6343i;
    public float l;
    public float m;

    /* renamed from: b, reason: collision with root package name */
    public final Camera f6336b = new Camera();

    /* renamed from: d, reason: collision with root package name */
    public float f6338d = 1.0f;
    public float j = 1.0f;
    public float k = 1.0f;
    public final RectF n = new RectF();
    public final RectF o = new RectF();
    public final Matrix p = new Matrix();

    static {
        q = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        r = new WeakHashMap<>();
    }

    public a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f6335a = new WeakReference<>(view);
    }

    public static a a(View view) {
        a aVar = r.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        a aVar2 = new a(view);
        r.put(view, aVar2);
        return aVar2;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        View view = this.f6335a.get();
        if (view != null) {
            transformation.setAlpha(this.f6338d);
            a(transformation.getMatrix(), view);
        }
    }

    public void b(float f2) {
        if (this.f6337c && this.f6340f == f2) {
            return;
        }
        b();
        this.f6337c = true;
        this.f6340f = f2;
        a();
    }

    public void a(float f2) {
        if (this.f6337c && this.f6339e == f2) {
            return;
        }
        b();
        this.f6337c = true;
        this.f6339e = f2;
        a();
    }

    public final void b() {
        View view = this.f6335a.get();
        if (view != null) {
            a(this.n, view);
        }
    }

    public final void a() {
        View view = this.f6335a.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.o;
        a(rectF, view);
        rectF.union(this.n);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.p;
        matrix.reset();
        a(matrix, view);
        this.p.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f2 = rectF.right;
        float f3 = rectF.left;
        if (f2 < f3) {
            rectF.right = f3;
            rectF.left = f2;
        }
        float f4 = rectF.bottom;
        float f5 = rectF.top;
        if (f4 < f5) {
            rectF.top = f4;
            rectF.bottom = f5;
        }
    }

    public final void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f6337c;
        float f2 = z ? this.f6339e : width / 2.0f;
        float f3 = z ? this.f6340f : height / 2.0f;
        float f4 = this.f6341g;
        float f5 = this.f6342h;
        float f6 = this.f6343i;
        if (f4 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
            Camera camera = this.f6336b;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.j;
        float f8 = this.k;
        if (f7 != 1.0f || f8 != 1.0f) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.l, this.m);
    }
}
