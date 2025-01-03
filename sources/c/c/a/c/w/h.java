package c.c.a.c.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import c.c.a.c.w.m;
import c.c.a.c.w.n;
import c.c.a.c.w.o;
import com.google.android.material.R$attr;
import com.google.zxing.view.ViewfinderView;
import java.util.BitSet;

/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes.dex */
public class h extends Drawable implements a.h.c.l.b, p {
    public static final String x = h.class.getSimpleName();
    public static final Paint y = new Paint(1);

    /* renamed from: a, reason: collision with root package name */
    public c f5649a;

    /* renamed from: b, reason: collision with root package name */
    public final o.g[] f5650b;

    /* renamed from: c, reason: collision with root package name */
    public final o.g[] f5651c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f5652d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5653e;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f5654f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f5655g;

    /* renamed from: h, reason: collision with root package name */
    public final Path f5656h;

    /* renamed from: i, reason: collision with root package name */
    public final RectF f5657i;
    public final RectF j;
    public final Region k;
    public final Region l;
    public m m;
    public final Paint n;
    public final Paint o;
    public final c.c.a.c.v.a p;
    public final n.a q;
    public final n r;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public final RectF v;
    public boolean w;

    /* compiled from: MaterialShapeDrawable.java */
    public class a implements n.a {
        public a() {
        }

        @Override // c.c.a.c.w.n.a
        public void a(o oVar, Matrix matrix, int i2) {
            h.this.f5652d.set(i2 + 4, oVar.a());
            h.this.f5651c[i2] = oVar.a(matrix);
        }

        @Override // c.c.a.c.w.n.a
        public void b(o oVar, Matrix matrix, int i2) {
            h.this.f5652d.set(i2, oVar.a());
            h.this.f5650b[i2] = oVar.a(matrix);
        }
    }

    /* compiled from: MaterialShapeDrawable.java */
    public class b implements m.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f5659a;

        public b(h hVar, float f2) {
            this.f5659a = f2;
        }

        @Override // c.c.a.c.w.m.c
        public c.c.a.c.w.c a(c.c.a.c.w.c cVar) {
            return cVar instanceof k ? cVar : new c.c.a.c.w.b(this.f5659a, cVar);
        }
    }

    public /* synthetic */ h(c cVar, a aVar) {
        this(cVar);
    }

    public static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    public boolean A() {
        return Build.VERSION.SDK_INT < 21 || !(z() || this.f5655g.isConvex() || Build.VERSION.SDK_INT >= 29);
    }

    public final boolean B() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        c cVar = this.f5649a;
        this.t = a(cVar.f5666g, cVar.f5667h, this.n, true);
        c cVar2 = this.f5649a;
        this.u = a(cVar2.f5665f, cVar2.f5667h, this.o, false);
        c cVar3 = this.f5649a;
        if (cVar3.u) {
            this.p.a(cVar3.f5666g.getColorForState(getState(), 0));
        }
        return (a.h.i.c.a(porterDuffColorFilter, this.t) && a.h.i.c.a(porterDuffColorFilter2, this.u)) ? false : true;
    }

    public final void C() {
        float t = t();
        this.f5649a.r = (int) Math.ceil(0.75f * t);
        this.f5649a.s = (int) Math.ceil(t * 0.25f);
        B();
        x();
    }

    public void d(int i2) {
        c cVar = this.f5649a;
        if (cVar.q != i2) {
            cVar.q = i2;
            x();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.n.setColorFilter(this.t);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(a(alpha, this.f5649a.m));
        this.o.setColorFilter(this.u);
        this.o.setStrokeWidth(this.f5649a.l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(a(alpha2, this.f5649a.m));
        if (this.f5653e) {
            b();
            a(e(), this.f5655g);
            this.f5653e = false;
        }
        d(canvas);
        if (v()) {
            b(canvas);
        }
        if (w()) {
            c(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    public void e(float f2) {
        this.f5649a.l = f2;
        invalidateSelf();
    }

    public final RectF f() {
        this.j.set(e());
        float o = o();
        this.j.inset(o, o);
        return this.j;
    }

    public float g() {
        return this.f5649a.o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5649a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f5649a.q == 2) {
            return;
        }
        if (z()) {
            outline.setRoundRect(getBounds(), q() * this.f5649a.k);
            return;
        }
        a(e(), this.f5655g);
        if (this.f5655g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f5655g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f5649a.f5668i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.k.set(getBounds());
        a(e(), this.f5655g);
        this.l.setPath(this.f5655g, this.k);
        this.k.op(this.l, Region.Op.DIFFERENCE);
        return this.k;
    }

    public ColorStateList h() {
        return this.f5649a.f5663d;
    }

    public float i() {
        return this.f5649a.k;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f5653e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f5649a.f5666g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f5649a.f5665f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f5649a.f5664e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f5649a.f5663d) != null && colorStateList4.isStateful())));
    }

    public float j() {
        return this.f5649a.n;
    }

    public int k() {
        double d2 = this.f5649a.s;
        double sin = Math.sin(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * sin);
    }

    public int l() {
        double d2 = this.f5649a.s;
        double cos = Math.cos(Math.toRadians(r0.t));
        Double.isNaN(d2);
        return (int) (d2 * cos);
    }

    public int m() {
        return this.f5649a.r;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5649a = new c(this.f5649a);
        return this;
    }

    public m n() {
        return this.f5649a.f5660a;
    }

    public final float o() {
        if (w()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f5653e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, c.c.a.c.r.j.b
    public boolean onStateChange(int[] iArr) {
        boolean z = a(iArr) || B();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public ColorStateList p() {
        return this.f5649a.f5666g;
    }

    public float q() {
        return this.f5649a.f5660a.j().a(e());
    }

    public float r() {
        return this.f5649a.f5660a.l().a(e());
    }

    public float s() {
        return this.f5649a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        c cVar = this.f5649a;
        if (cVar.m != i2) {
            cVar.m = i2;
            x();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5649a.f5662c = colorFilter;
        x();
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        this.f5649a.f5660a = mVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        this.f5649a.f5666g = colorStateList;
        B();
        x();
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f5649a;
        if (cVar.f5667h != mode) {
            cVar.f5667h = mode;
            B();
            x();
        }
    }

    public float t() {
        return g() + s();
    }

    public final boolean u() {
        c cVar = this.f5649a;
        int i2 = cVar.q;
        return i2 != 1 && cVar.r > 0 && (i2 == 2 || A());
    }

    public final boolean v() {
        Paint.Style style = this.f5649a.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean w() {
        Paint.Style style = this.f5649a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    public final void x() {
        super.invalidateSelf();
    }

    public boolean y() {
        c.c.a.c.o.a aVar = this.f5649a.f5661b;
        return aVar != null && aVar.a();
    }

    public boolean z() {
        return this.f5649a.f5660a.a(e());
    }

    public h() {
        this(new m());
    }

    public void b(ColorStateList colorStateList) {
        c cVar = this.f5649a;
        if (cVar.f5664e != colorStateList) {
            cVar.f5664e = colorStateList;
            onStateChange(getState());
        }
    }

    public void c(float f2) {
        c cVar = this.f5649a;
        if (cVar.k != f2) {
            cVar.k = f2;
            this.f5653e = true;
            invalidateSelf();
        }
    }

    public h(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(m.a(context, attributeSet, i2, i3).a());
    }

    public static h a(Context context, float f2) {
        int a2 = c.c.a.c.k.a.a(context, R$attr.colorSurface, h.class.getSimpleName());
        h hVar = new h();
        hVar.a(context);
        hVar.a(ColorStateList.valueOf(a2));
        hVar.b(f2);
        return hVar;
    }

    public RectF e() {
        this.f5657i.set(getBounds());
        return this.f5657i;
    }

    public h(m mVar) {
        this(new c(mVar, null));
    }

    public void d(float f2) {
        c cVar = this.f5649a;
        if (cVar.n != f2) {
            cVar.n = f2;
            C();
        }
    }

    public h(c cVar) {
        this.f5650b = new o.g[4];
        this.f5651c = new o.g[4];
        this.f5652d = new BitSet(8);
        this.f5654f = new Matrix();
        this.f5655g = new Path();
        this.f5656h = new Path();
        this.f5657i = new RectF();
        this.j = new RectF();
        this.k = new Region();
        this.l = new Region();
        this.n = new Paint(1);
        this.o = new Paint(1);
        this.p = new c.c.a.c.v.a();
        this.r = new n();
        this.v = new RectF();
        this.w = true;
        this.f5649a = cVar;
        this.o.setStyle(Paint.Style.STROKE);
        this.n.setStyle(Paint.Style.FILL);
        y.setColor(-1);
        y.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        B();
        a(getState());
        this.q = new a();
    }

    public void b(float f2) {
        c cVar = this.f5649a;
        if (cVar.o != f2) {
            cVar.o = f2;
            C();
        }
    }

    public final void e(Canvas canvas) {
        int k = k();
        int l = l();
        if (Build.VERSION.SDK_INT < 21 && this.w) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.f5649a.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(k, l);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(k, l);
    }

    public void c(int i2) {
        c cVar = this.f5649a;
        if (cVar.t != i2) {
            cVar.t = i2;
            x();
        }
    }

    public final void d(Canvas canvas) {
        if (u()) {
            canvas.save();
            e(canvas);
            if (!this.w) {
                a(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.v.width() - getBounds().width());
            int height = (int) (this.v.height() - getBounds().height());
            if (width >= 0 && height >= 0) {
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.v.width()) + (this.f5649a.r * 2) + width, ((int) this.v.height()) + (this.f5649a.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (getBounds().left - this.f5649a.r) - width;
                float f3 = (getBounds().top - this.f5649a.r) - height;
                canvas2.translate(-f2, -f3);
                a(canvas2);
                canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
    }

    public void b(int i2) {
        this.p.a(i2);
        this.f5649a.u = false;
        x();
    }

    public final void c(Canvas canvas) {
        a(canvas, this.o, this.f5656h, this.m, f());
    }

    public void a(ColorStateList colorStateList) {
        c cVar = this.f5649a;
        if (cVar.f5663d != colorStateList) {
            cVar.f5663d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void b(Canvas canvas) {
        a(canvas, this.n, this.f5655g, this.f5649a.f5660a, e());
    }

    public final void b(RectF rectF, Path path) {
        n nVar = this.r;
        c cVar = this.f5649a;
        nVar.a(cVar.f5660a, cVar.k, rectF, this.q, path);
    }

    public float c() {
        return this.f5649a.f5660a.c().a(e());
    }

    public void a(float f2, int i2) {
        e(f2);
        b(ColorStateList.valueOf(i2));
    }

    public final void b() {
        m a2 = n().a(new b(this, -o()));
        this.m = a2;
        this.r.a(a2, this.f5649a.k, f(), this.f5656h);
    }

    public void a(float f2, ColorStateList colorStateList) {
        e(f2);
        b(colorStateList);
    }

    public void a(float f2) {
        setShapeAppearanceModel(this.f5649a.f5660a.a(f2));
    }

    public void a(int i2, int i3, int i4, int i5) {
        c cVar = this.f5649a;
        if (cVar.f5668i == null) {
            cVar.f5668i = new Rect();
        }
        this.f5649a.f5668i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    /* compiled from: MaterialShapeDrawable.java */
    public static final class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public m f5660a;

        /* renamed from: b, reason: collision with root package name */
        public c.c.a.c.o.a f5661b;

        /* renamed from: c, reason: collision with root package name */
        public ColorFilter f5662c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f5663d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f5664e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f5665f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f5666g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f5667h;

        /* renamed from: i, reason: collision with root package name */
        public Rect f5668i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public c(m mVar, c.c.a.c.o.a aVar) {
            this.f5663d = null;
            this.f5664e = null;
            this.f5665f = null;
            this.f5666g = null;
            this.f5667h = PorterDuff.Mode.SRC_IN;
            this.f5668i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = ViewfinderView.OPAQUE;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f5660a = mVar;
            this.f5661b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h(this, null);
            hVar.f5653e = true;
            return hVar;
        }

        public c(c cVar) {
            this.f5663d = null;
            this.f5664e = null;
            this.f5665f = null;
            this.f5666g = null;
            this.f5667h = PorterDuff.Mode.SRC_IN;
            this.f5668i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = ViewfinderView.OPAQUE;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.f5660a = cVar.f5660a;
            this.f5661b = cVar.f5661b;
            this.l = cVar.l;
            this.f5662c = cVar.f5662c;
            this.f5663d = cVar.f5663d;
            this.f5664e = cVar.f5664e;
            this.f5667h = cVar.f5667h;
            this.f5666g = cVar.f5666g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f5665f = cVar.f5665f;
            this.v = cVar.v;
            if (cVar.f5668i != null) {
                this.f5668i = new Rect(cVar.f5668i);
            }
        }
    }

    public void a(Context context) {
        this.f5649a.f5661b = new c.c.a.c.o.a(context);
        C();
    }

    public final int a(int i2) {
        float t = t() + j();
        c.c.a.c.o.a aVar = this.f5649a.f5661b;
        return aVar != null ? aVar.b(i2, t) : i2;
    }

    public void a(boolean z) {
        this.w = z;
    }

    public void a(Paint.Style style) {
        this.f5649a.v = style;
        x();
    }

    public float d() {
        return this.f5649a.f5660a.e().a(e());
    }

    public void a(Canvas canvas, Paint paint, Path path, RectF rectF) {
        a(canvas, paint, path, this.f5649a.f5660a, rectF);
    }

    public final void a(Canvas canvas, Paint paint, Path path, m mVar, RectF rectF) {
        if (mVar.a(rectF)) {
            float a2 = mVar.l().a(rectF) * this.f5649a.k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
        } else {
            canvas.drawPath(path, paint);
        }
    }

    public final void a(Canvas canvas) {
        if (this.f5652d.cardinality() > 0) {
            Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f5649a.s != 0) {
            canvas.drawPath(this.f5655g, this.p.a());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f5650b[i2].a(this.p, this.f5649a.r, canvas);
            this.f5651c[i2].a(this.p, this.f5649a.r, canvas);
        }
        if (this.w) {
            int k = k();
            int l = l();
            canvas.translate(-k, -l);
            canvas.drawPath(this.f5655g, y);
            canvas.translate(k, l);
        }
    }

    public final void a(RectF rectF, Path path) {
        b(rectF, path);
        if (this.f5649a.j != 1.0f) {
            this.f5654f.reset();
            Matrix matrix = this.f5654f;
            float f2 = this.f5649a.j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f5654f);
        }
        path.computeBounds(this.v, true);
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        if (colorStateList != null && mode != null) {
            return a(colorStateList, mode, z);
        }
        return a(paint, z);
    }

    public final PorterDuffColorFilter a(Paint paint, boolean z) {
        int color;
        int a2;
        if (!z || (a2 = a((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(a2, PorterDuff.Mode.SRC_IN);
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = a(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final boolean a(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f5649a.f5663d == null || color2 == (colorForState2 = this.f5649a.f5663d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z = false;
        } else {
            this.n.setColor(colorForState2);
            z = true;
        }
        if (this.f5649a.f5664e == null || color == (colorForState = this.f5649a.f5664e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z;
        }
        this.o.setColor(colorForState);
        return true;
    }
}
