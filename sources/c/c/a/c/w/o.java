package c.c.a.c.w;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f5705a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f5706b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f5707c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f5708d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f5709e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f5710f;

    /* renamed from: g, reason: collision with root package name */
    public final List<f> f5711g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<g> f5712h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f5713i;

    /* compiled from: ShapePath.java */
    public class a extends g {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f5714b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Matrix f5715c;

        public a(o oVar, List list, Matrix matrix) {
            this.f5714b = list;
            this.f5715c = matrix;
        }

        @Override // c.c.a.c.w.o.g
        public void a(Matrix matrix, c.c.a.c.v.a aVar, int i2, Canvas canvas) {
            Iterator it = this.f5714b.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f5715c, aVar, i2, canvas);
            }
        }
    }

    /* compiled from: ShapePath.java */
    public static class b extends g {

        /* renamed from: b, reason: collision with root package name */
        public final d f5716b;

        public b(d dVar) {
            this.f5716b = dVar;
        }

        @Override // c.c.a.c.w.o.g
        public void a(Matrix matrix, c.c.a.c.v.a aVar, int i2, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f5716b.b(), this.f5716b.f(), this.f5716b.c(), this.f5716b.a()), i2, this.f5716b.d(), this.f5716b.e());
        }
    }

    /* compiled from: ShapePath.java */
    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f5720h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f5721b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f5722c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f5723d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f5724e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f5725f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f5726g;

        public d(float f2, float f3, float f4, float f5) {
            b(f2);
            f(f3);
            c(f4);
            a(f5);
        }

        public final float c() {
            return this.f5723d;
        }

        public final float d() {
            return this.f5725f;
        }

        public final float e() {
            return this.f5726g;
        }

        public final float f() {
            return this.f5722c;
        }

        @Override // c.c.a.c.w.o.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5729a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            f5720h.set(b(), f(), c(), a());
            path.arcTo(f5720h, d(), e(), false);
            path.transform(matrix);
        }

        public final float b() {
            return this.f5721b;
        }

        public final void c(float f2) {
            this.f5723d = f2;
        }

        public final void d(float f2) {
            this.f5725f = f2;
        }

        public final void e(float f2) {
            this.f5726g = f2;
        }

        public final void f(float f2) {
            this.f5722c = f2;
        }

        public final void b(float f2) {
            this.f5721b = f2;
        }

        public final float a() {
            return this.f5724e;
        }

        public final void a(float f2) {
            this.f5724e = f2;
        }
    }

    /* compiled from: ShapePath.java */
    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public float f5727b;

        /* renamed from: c, reason: collision with root package name */
        public float f5728c;

        @Override // c.c.a.c.w.o.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f5729a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f5727b, this.f5728c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f5729a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* compiled from: ShapePath.java */
    public static abstract class g {

        /* renamed from: a, reason: collision with root package name */
        public static final Matrix f5730a = new Matrix();

        public abstract void a(Matrix matrix, c.c.a.c.v.a aVar, int i2, Canvas canvas);

        public final void a(c.c.a.c.v.a aVar, int i2, Canvas canvas) {
            a(f5730a, aVar, i2, canvas);
        }
    }

    public o() {
        b(0.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        f(f2);
        g(f3);
        d(f2);
        e(f3);
        b(f4);
        c((f4 + f5) % 360.0f);
        this.f5711g.clear();
        this.f5712h.clear();
        this.f5713i = false;
    }

    public void b(float f2, float f3) {
        a(f2, f3, 270.0f, 0.0f);
    }

    public final float c() {
        return this.f5710f;
    }

    public float d() {
        return this.f5707c;
    }

    public float e() {
        return this.f5708d;
    }

    public float f() {
        return this.f5705a;
    }

    public float g() {
        return this.f5706b;
    }

    public final float b() {
        return this.f5709e;
    }

    public final void c(float f2) {
        this.f5710f = f2;
    }

    public final void d(float f2) {
        this.f5707c = f2;
    }

    public final void e(float f2) {
        this.f5708d = f2;
    }

    public final void f(float f2) {
        this.f5705a = f2;
    }

    public final void g(float f2) {
        this.f5706b = f2;
    }

    public final void b(float f2) {
        this.f5709e = f2;
    }

    /* compiled from: ShapePath.java */
    public static class c extends g {

        /* renamed from: b, reason: collision with root package name */
        public final e f5717b;

        /* renamed from: c, reason: collision with root package name */
        public final float f5718c;

        /* renamed from: d, reason: collision with root package name */
        public final float f5719d;

        public c(e eVar, float f2, float f3) {
            this.f5717b = eVar;
            this.f5718c = f2;
            this.f5719d = f3;
        }

        @Override // c.c.a.c.w.o.g
        public void a(Matrix matrix, c.c.a.c.v.a aVar, int i2, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f5717b.f5728c - this.f5719d, this.f5717b.f5727b - this.f5718c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f5718c, this.f5719d);
            matrix2.preRotate(a());
            aVar.a(canvas, matrix2, rectF, i2);
        }

        public float a() {
            return (float) Math.toDegrees(Math.atan((this.f5717b.f5728c - this.f5719d) / (this.f5717b.f5727b - this.f5718c)));
        }
    }

    public void a(float f2, float f3) {
        e eVar = new e();
        eVar.f5727b = f2;
        eVar.f5728c = f3;
        this.f5711g.add(eVar);
        c cVar = new c(eVar, d(), e());
        a(cVar, cVar.a() + 270.0f, cVar.a() + 270.0f);
        d(f2);
        e(f3);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.d(f6);
        dVar.e(f7);
        this.f5711g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        d(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        e(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.f5711g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f5711g.get(i2).a(matrix, path);
        }
    }

    public g a(Matrix matrix) {
        a(c());
        return new a(this, new ArrayList(this.f5712h), matrix);
    }

    public final void a(g gVar, float f2, float f3) {
        a(f2);
        this.f5712h.add(gVar);
        b(f3);
    }

    public boolean a() {
        return this.f5713i;
    }

    public final void a(float f2) {
        if (b() == f2) {
            return;
        }
        float b2 = ((f2 - b()) + 360.0f) % 360.0f;
        if (b2 > 180.0f) {
            return;
        }
        d dVar = new d(d(), e(), d(), e());
        dVar.d(b());
        dVar.e(b2);
        this.f5712h.add(new b(dVar));
        b(f2);
    }
}
