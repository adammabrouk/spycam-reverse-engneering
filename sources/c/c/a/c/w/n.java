package c.c.a.c.w;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

/* compiled from: ShapeAppearancePathProvider.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final o[] f5691a = new o[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f5692b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f5693c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f5694d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f5695e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f5696f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final o f5697g = new o();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f5698h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f5699i = new float[2];
    public boolean j = true;

    /* compiled from: ShapeAppearancePathProvider.java */
    public interface a {
        void a(o oVar, Matrix matrix, int i2);

        void b(o oVar, Matrix matrix, int i2);
    }

    /* compiled from: ShapeAppearancePathProvider.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final m f5700a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f5701b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f5702c;

        /* renamed from: d, reason: collision with root package name */
        public final a f5703d;

        /* renamed from: e, reason: collision with root package name */
        public final float f5704e;

        public b(m mVar, float f2, RectF rectF, a aVar, Path path) {
            this.f5703d = aVar;
            this.f5700a = mVar;
            this.f5704e = f2;
            this.f5702c = rectF;
            this.f5701b = path;
        }
    }

    public n() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f5691a[i2] = new o();
            this.f5692b[i2] = new Matrix();
            this.f5693c[i2] = new Matrix();
        }
    }

    public final float a(int i2) {
        return (i2 + 1) * 90;
    }

    public void a(m mVar, float f2, RectF rectF, Path path) {
        a(mVar, f2, rectF, null, path);
    }

    public final void b(int i2) {
        this.f5698h[0] = this.f5691a[i2].d();
        this.f5698h[1] = this.f5691a[i2].e();
        this.f5692b[i2].mapPoints(this.f5698h);
        float a2 = a(i2);
        this.f5693c[i2].reset();
        Matrix matrix = this.f5693c[i2];
        float[] fArr = this.f5698h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f5693c[i2].preRotate(a2);
    }

    public final void c(b bVar, int i2) {
        b(i2, bVar.f5700a).a(this.f5691a[i2], 90.0f, bVar.f5704e, bVar.f5702c, a(i2, bVar.f5700a));
        float a2 = a(i2);
        this.f5692b[i2].reset();
        a(i2, bVar.f5702c, this.f5694d);
        Matrix matrix = this.f5692b[i2];
        PointF pointF = this.f5694d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f5692b[i2].preRotate(a2);
    }

    public void a(m mVar, float f2, RectF rectF, a aVar, Path path) {
        path.rewind();
        this.f5695e.rewind();
        this.f5696f.rewind();
        this.f5696f.addRect(rectF, Path.Direction.CW);
        b bVar = new b(mVar, f2, rectF, aVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            c(bVar, i2);
            b(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            a(bVar, i3);
            b(bVar, i3);
        }
        path.close();
        this.f5695e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f5695e.isEmpty()) {
            return;
        }
        path.op(this.f5695e, Path.Op.UNION);
    }

    public final void b(b bVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f5698h[0] = this.f5691a[i2].d();
        this.f5698h[1] = this.f5691a[i2].e();
        this.f5692b[i2].mapPoints(this.f5698h);
        this.f5699i[0] = this.f5691a[i3].f();
        this.f5699i[1] = this.f5691a[i3].g();
        this.f5692b[i3].mapPoints(this.f5699i);
        float f2 = this.f5698h[0];
        float[] fArr = this.f5699i;
        float max = Math.max(((float) Math.hypot(f2 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float a2 = a(bVar.f5702c, i2);
        this.f5697g.b(0.0f, 0.0f);
        f c2 = c(i2, bVar.f5700a);
        c2.a(max, a2, bVar.f5704e, this.f5697g);
        Path path = new Path();
        this.f5697g.a(this.f5693c[i2], path);
        if (this.j && Build.VERSION.SDK_INT >= 19 && (c2.a() || a(path, i2) || a(path, i3))) {
            path.op(path, this.f5696f, Path.Op.DIFFERENCE);
            this.f5698h[0] = this.f5697g.f();
            this.f5698h[1] = this.f5697g.g();
            this.f5693c[i2].mapPoints(this.f5698h);
            Path path2 = this.f5695e;
            float[] fArr2 = this.f5698h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f5697g.a(this.f5693c[i2], this.f5695e);
        } else {
            this.f5697g.a(this.f5693c[i2], bVar.f5701b);
        }
        a aVar = bVar.f5703d;
        if (aVar != null) {
            aVar.a(this.f5697g, this.f5693c[i2], i2);
        }
    }

    public final f c(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.a();
        }
        if (i2 == 2) {
            return mVar.f();
        }
        if (i2 != 3) {
            return mVar.g();
        }
        return mVar.h();
    }

    public final void a(b bVar, int i2) {
        this.f5698h[0] = this.f5691a[i2].f();
        this.f5698h[1] = this.f5691a[i2].g();
        this.f5692b[i2].mapPoints(this.f5698h);
        if (i2 == 0) {
            Path path = bVar.f5701b;
            float[] fArr = this.f5698h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = bVar.f5701b;
            float[] fArr2 = this.f5698h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f5691a[i2].a(this.f5692b[i2], bVar.f5701b);
        a aVar = bVar.f5703d;
        if (aVar != null) {
            aVar.b(this.f5691a[i2], this.f5692b[i2], i2);
        }
    }

    public final boolean a(Path path, int i2) {
        Path path2 = new Path();
        this.f5691a[i2].a(this.f5692b[i2], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    public final float a(RectF rectF, int i2) {
        float[] fArr = this.f5698h;
        o[] oVarArr = this.f5691a;
        fArr[0] = oVarArr[i2].f5707c;
        fArr[1] = oVarArr[i2].f5708d;
        this.f5692b[i2].mapPoints(fArr);
        if (i2 != 1 && i2 != 3) {
            return Math.abs(rectF.centerY() - this.f5698h[1]);
        }
        return Math.abs(rectF.centerX() - this.f5698h[0]);
    }

    public final c a(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.e();
        }
        if (i2 == 2) {
            return mVar.c();
        }
        if (i2 != 3) {
            return mVar.l();
        }
        return mVar.j();
    }

    public final d b(int i2, m mVar) {
        if (i2 == 1) {
            return mVar.d();
        }
        if (i2 == 2) {
            return mVar.b();
        }
        if (i2 != 3) {
            return mVar.k();
        }
        return mVar.i();
    }

    public final void a(int i2, RectF rectF, PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }
}
