package a.u.a.a;

import a.h.c.c;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.FileProvider;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.he.Constant;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends a.u.a.a.h {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public h f1943b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f1944c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f1945d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1946e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1947f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f1948g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f1949h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f1950i;

    /* compiled from: VectorDrawableCompat.java */
    public static class b extends f {
        public b() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (a.h.b.d.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.u.a.a.a.f1921d);
                a(a2, xmlPullParser);
                a2.recycle();
            }
        }

        @Override // a.u.a.a.i.f
        public boolean b() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }

        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f1966b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f1965a = a.h.c.c.a(string2);
            }
            this.f1967c = a.h.b.d.g.b(typedArray, xmlPullParser, "fillType", 2, 0);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f1978a;

        /* renamed from: b, reason: collision with root package name */
        public g f1979b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f1980c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f1981d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f1982e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f1983f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f1984g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f1985h;

        /* renamed from: i, reason: collision with root package name */
        public int f1986i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h(h hVar) {
            this.f1980c = null;
            this.f1981d = i.j;
            if (hVar != null) {
                this.f1978a = hVar.f1978a;
                g gVar = new g(hVar.f1979b);
                this.f1979b = gVar;
                if (hVar.f1979b.f1973e != null) {
                    gVar.f1973e = new Paint(hVar.f1979b.f1973e);
                }
                if (hVar.f1979b.f1972d != null) {
                    this.f1979b.f1972d = new Paint(hVar.f1979b.f1972d);
                }
                this.f1980c = hVar.f1980c;
                this.f1981d = hVar.f1981d;
                this.f1982e = hVar.f1982e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f1983f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f1979b.getRootAlpha() < 255;
        }

        public void c(int i2, int i3) {
            this.f1983f.eraseColor(0);
            this.f1979b.a(new Canvas(this.f1983f), i2, i3, (ColorFilter) null);
        }

        public void d() {
            this.f1984g = this.f1980c;
            this.f1985h = this.f1981d;
            this.f1986i = this.f1979b.getRootAlpha();
            this.j = this.f1982e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1978a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        public void b(int i2, int i3) {
            if (this.f1983f == null || !a(i2, i3)) {
                this.f1983f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (!b() && colorFilter == null) {
                return null;
            }
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setFilterBitmap(true);
            }
            this.l.setAlpha(this.f1979b.getRootAlpha());
            this.l.setColorFilter(colorFilter);
            return this.l;
        }

        public boolean c() {
            return this.f1979b.a();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f1983f.getWidth() && i3 == this.f1983f.getHeight();
        }

        public boolean a() {
            return !this.k && this.f1984g == this.f1980c && this.f1985h == this.f1981d && this.j == this.f1982e && this.f1986i == this.f1979b.getRootAlpha();
        }

        public h() {
            this.f1980c = null;
            this.f1981d = i.j;
            this.f1979b = new g();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f1979b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    public i() {
        this.f1947f = true;
        this.f1948g = new float[9];
        this.f1949h = new Matrix();
        this.f1950i = new Rect();
        this.f1943b = new h();
    }

    public static i createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    public Object a(String str) {
        return this.f1943b.f1979b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f1942a;
        if (drawable == null) {
            return false;
        }
        a.h.c.l.a.a(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1950i);
        if (this.f1950i.width() <= 0 || this.f1950i.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f1945d;
        if (colorFilter == null) {
            colorFilter = this.f1944c;
        }
        canvas.getMatrix(this.f1949h);
        this.f1949h.getValues(this.f1948g);
        float abs = Math.abs(this.f1948g[0]);
        float abs2 = Math.abs(this.f1948g[4]);
        float abs3 = Math.abs(this.f1948g[1]);
        float abs4 = Math.abs(this.f1948g[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f1950i.width() * abs));
        int min2 = Math.min(2048, (int) (this.f1950i.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f1950i;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.f1950i.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f1950i.offsetTo(0, 0);
        this.f1943b.b(min, min2);
        if (!this.f1947f) {
            this.f1943b.c(min, min2);
        } else if (!this.f1943b.a()) {
            this.f1943b.c(min, min2);
            this.f1943b.d();
        }
        this.f1943b.a(canvas, colorFilter, this.f1950i);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.c(drawable) : this.f1943b.f1979b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1943b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.d(drawable) : this.f1945d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f1942a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0057i(this.f1942a.getConstantState());
        }
        this.f1943b.f1978a = getChangingConfigurations();
        return this.f1943b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1943b.f1979b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1943b.f1979b.f1977i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f1942a;
        return drawable != null ? a.h.c.l.a.f(drawable) : this.f1943b.f1982e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f1943b) != null && (hVar.c() || ((colorStateList = this.f1943b.f1980c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f1946e && super.mutate() == this) {
            this.f1943b = new h(this.f1943b);
            this.f1946e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f1943b;
        ColorStateList colorStateList = hVar.f1980c;
        if (colorStateList != null && (mode = hVar.f1981d) != null) {
            this.f1944c = a(this.f1944c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!hVar.c() || !hVar.a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f1943b.f1979b.getRootAlpha() != i2) {
            this.f1943b.f1979b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, z);
        } else {
            this.f1943b.f1982e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1945d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTint(int i2) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.b(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, colorStateList);
            return;
        }
        h hVar = this.f1943b;
        if (hVar.f1980c != colorStateList) {
            hVar.f1980c = colorStateList;
            this.f1944c = a(this.f1944c, colorStateList, hVar.f1981d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.h.c.l.b
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, mode);
            return;
        }
        h hVar = this.f1943b;
        if (hVar.f1981d != mode) {
            hVar.f1981d = mode;
            this.f1944c = a(this.f1944c, hVar.f1980c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f1942a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.u.a.a.i$i, reason: collision with other inner class name */
    public static class C0057i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f1987a;

        public C0057i(Drawable.ConstantState constantState) {
            this.f1987a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f1987a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1987a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f1942a = (VectorDrawable) this.f1987a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f1942a = (VectorDrawable) this.f1987a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f1942a = (VectorDrawable) this.f1987a.newDrawable(resources, theme);
            return iVar;
        }
    }

    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public int[] f1951e;

        /* renamed from: f, reason: collision with root package name */
        public a.h.b.d.b f1952f;

        /* renamed from: g, reason: collision with root package name */
        public float f1953g;

        /* renamed from: h, reason: collision with root package name */
        public a.h.b.d.b f1954h;

        /* renamed from: i, reason: collision with root package name */
        public float f1955i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.f1953g = 0.0f;
            this.f1955i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public final Paint.Cap a(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.f1954h.a();
        }

        public float getStrokeAlpha() {
            return this.f1955i;
        }

        public int getStrokeColor() {
            return this.f1952f.a();
        }

        public float getStrokeWidth() {
            return this.f1953g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.f1954h.a(i2);
        }

        public void setStrokeAlpha(float f2) {
            this.f1955i = f2;
        }

        public void setStrokeColor(int i2) {
            this.f1952f.a(i2);
        }

        public void setStrokeWidth(float f2) {
            this.f1953g = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public final Paint.Join a(int i2, Paint.Join join) {
            if (i2 == 0) {
                return Paint.Join.MITER;
            }
            if (i2 != 1) {
                return i2 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.u.a.a.a.f1920c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f1951e = null;
            if (a.h.b.d.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f1966b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f1965a = a.h.c.c.a(string2);
                }
                this.f1954h = a.h.b.d.g.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = a.h.b.d.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(a.h.b.d.g.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(a.h.b.d.g.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = a.h.b.d.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f1952f = a.h.b.d.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f1955i = a.h.b.d.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f1955i);
                this.f1953g = a.h.b.d.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f1953g);
                this.l = a.h.b.d.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = a.h.b.d.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = a.h.b.d.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.f1967c = a.h.b.d.g.b(typedArray, xmlPullParser, "fillType", 13, this.f1967c);
            }
        }

        public c(c cVar) {
            super(cVar);
            this.f1953g = 0.0f;
            this.f1955i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f1951e = cVar.f1951e;
            this.f1952f = cVar.f1952f;
            this.f1953g = cVar.f1953g;
            this.f1955i = cVar.f1955i;
            this.f1954h = cVar.f1954h;
            this.f1967c = cVar.f1967c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // a.u.a.a.i.e
        public boolean a() {
            return this.f1954h.d() || this.f1952f.d();
        }

        @Override // a.u.a.a.i.e
        public boolean a(int[] iArr) {
            return this.f1952f.a(iArr) | this.f1954h.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f1956a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f1957b;

        /* renamed from: c, reason: collision with root package name */
        public float f1958c;

        /* renamed from: d, reason: collision with root package name */
        public float f1959d;

        /* renamed from: e, reason: collision with root package name */
        public float f1960e;

        /* renamed from: f, reason: collision with root package name */
        public float f1961f;

        /* renamed from: g, reason: collision with root package name */
        public float f1962g;

        /* renamed from: h, reason: collision with root package name */
        public float f1963h;

        /* renamed from: i, reason: collision with root package name */
        public float f1964i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d(d dVar, a.e.a<String, Object> aVar) {
            super();
            f bVar;
            this.f1956a = new Matrix();
            this.f1957b = new ArrayList<>();
            this.f1958c = 0.0f;
            this.f1959d = 0.0f;
            this.f1960e = 0.0f;
            this.f1961f = 1.0f;
            this.f1962g = 1.0f;
            this.f1963h = 0.0f;
            this.f1964i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f1958c = dVar.f1958c;
            this.f1959d = dVar.f1959d;
            this.f1960e = dVar.f1960e;
            this.f1961f = dVar.f1961f;
            this.f1962g = dVar.f1962g;
            this.f1963h = dVar.f1963h;
            this.f1964i = dVar.f1964i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f1957b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f1957b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f1957b.add(bVar);
                    String str2 = bVar.f1966b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.u.a.a.a.f1919b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        public final void b() {
            this.j.reset();
            this.j.postTranslate(-this.f1959d, -this.f1960e);
            this.j.postScale(this.f1961f, this.f1962g);
            this.j.postRotate(this.f1958c, 0.0f, 0.0f);
            this.j.postTranslate(this.f1963h + this.f1959d, this.f1964i + this.f1960e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f1959d;
        }

        public float getPivotY() {
            return this.f1960e;
        }

        public float getRotation() {
            return this.f1958c;
        }

        public float getScaleX() {
            return this.f1961f;
        }

        public float getScaleY() {
            return this.f1962g;
        }

        public float getTranslateX() {
            return this.f1963h;
        }

        public float getTranslateY() {
            return this.f1964i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f1959d) {
                this.f1959d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f1960e) {
                this.f1960e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f1958c) {
                this.f1958c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f1961f) {
                this.f1961f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f1962g) {
                this.f1962g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f1963h) {
                this.f1963h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f1964i) {
                this.f1964i = f2;
                b();
            }
        }

        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f1958c = a.h.b.d.g.a(typedArray, xmlPullParser, "rotation", 5, this.f1958c);
            this.f1959d = typedArray.getFloat(1, this.f1959d);
            this.f1960e = typedArray.getFloat(2, this.f1960e);
            this.f1961f = a.h.b.d.g.a(typedArray, xmlPullParser, "scaleX", 3, this.f1961f);
            this.f1962g = a.h.b.d.g.a(typedArray, xmlPullParser, "scaleY", 4, this.f1962g);
            this.f1963h = a.h.b.d.g.a(typedArray, xmlPullParser, "translateX", 6, this.f1963h);
            this.f1964i = a.h.b.d.g.a(typedArray, xmlPullParser, "translateY", 7, this.f1964i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        @Override // a.u.a.a.i.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f1957b.size(); i2++) {
                if (this.f1957b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.u.a.a.i.e
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f1957b.size(); i2++) {
                z |= this.f1957b.get(i2).a(iArr);
            }
            return z;
        }

        public d() {
            super();
            this.f1956a = new Matrix();
            this.f1957b = new ArrayList<>();
            this.f1958c = 0.0f;
            this.f1959d = 0.0f;
            this.f1960e = 0.0f;
            this.f1961f = 1.0f;
            this.f1962g = 1.0f;
            this.f1963h = 0.0f;
            this.f1964i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        public c.b[] f1965a;

        /* renamed from: b, reason: collision with root package name */
        public String f1966b;

        /* renamed from: c, reason: collision with root package name */
        public int f1967c;

        /* renamed from: d, reason: collision with root package name */
        public int f1968d;

        public f() {
            super();
            this.f1965a = null;
            this.f1967c = 0;
        }

        public void a(Path path) {
            path.reset();
            c.b[] bVarArr = this.f1965a;
            if (bVarArr != null) {
                c.b.a(bVarArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public c.b[] getPathData() {
            return this.f1965a;
        }

        public String getPathName() {
            return this.f1966b;
        }

        public void setPathData(c.b[] bVarArr) {
            if (a.h.c.c.a(this.f1965a, bVarArr)) {
                a.h.c.c.b(this.f1965a, bVarArr);
            } else {
                this.f1965a = a.h.c.c.a(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f1965a = null;
            this.f1967c = 0;
            this.f1966b = fVar.f1966b;
            this.f1968d = fVar.f1968d;
            this.f1965a = a.h.c.c.a(fVar.f1965a);
        }
    }

    public static i a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f1942a = a.h.b.d.f.a(resources, i2, theme);
            new C0057i(iVar.f1942a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1942a;
        if (drawable != null) {
            a.h.c.l.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f1943b;
        hVar.f1979b = new g();
        TypedArray a2 = a.h.b.d.g.a(resources, theme, attributeSet, a.u.a.a.a.f1918a);
        a(a2, xmlPullParser, theme);
        a2.recycle();
        hVar.f1978a = getChangingConfigurations();
        hVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f1944c = a(this.f1944c, hVar.f1980c, hVar.f1981d);
    }

    public i(h hVar) {
        this.f1947f = true;
        this.f1948g = new float[9];
        this.f1949h = new Matrix();
        this.f1950i = new Rect();
        this.f1943b = hVar;
        this.f1944c = a(this.f1944c, hVar.f1980c, hVar.f1981d);
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class g {
        public static final Matrix q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f1969a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f1970b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f1971c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f1972d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f1973e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f1974f;

        /* renamed from: g, reason: collision with root package name */
        public int f1975g;

        /* renamed from: h, reason: collision with root package name */
        public final d f1976h;

        /* renamed from: i, reason: collision with root package name */
        public float f1977i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final a.e.a<String, Object> p;

        public g() {
            this.f1971c = new Matrix();
            this.f1977i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = ViewfinderView.OPAQUE;
            this.n = null;
            this.o = null;
            this.p = new a.e.a<>();
            this.f1976h = new d();
            this.f1969a = new Path();
            this.f1970b = new Path();
        }

        public static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public final void a(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f1956a.set(matrix);
            dVar.f1956a.preConcat(dVar.j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f1957b.size(); i4++) {
                e eVar = dVar.f1957b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.f1956a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    a(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.f1976h, q, canvas, i2, i3, colorFilter);
        }

        public g(g gVar) {
            this.f1971c = new Matrix();
            this.f1977i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = ViewfinderView.OPAQUE;
            this.n = null;
            this.o = null;
            a.e.a<String, Object> aVar = new a.e.a<>();
            this.p = aVar;
            this.f1976h = new d(gVar.f1976h, aVar);
            this.f1969a = new Path(gVar.f1969a);
            this.f1970b = new Path(gVar.f1970b);
            this.f1977i = gVar.f1977i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.f1975g = gVar.f1975g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        public final void a(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.k;
            float f3 = i3 / this.l;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.f1956a;
            this.f1971c.set(matrix);
            this.f1971c.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            fVar.a(this.f1969a);
            Path path = this.f1969a;
            this.f1970b.reset();
            if (fVar.b()) {
                this.f1970b.setFillType(fVar.f1967c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f1970b.addPath(path, this.f1971c);
                canvas.clipPath(this.f1970b);
                return;
            }
            c cVar = (c) fVar;
            if (cVar.k != 0.0f || cVar.l != 1.0f) {
                float f4 = cVar.k;
                float f5 = cVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.l + f5) % 1.0f;
                if (this.f1974f == null) {
                    this.f1974f = new PathMeasure();
                }
                this.f1974f.setPath(this.f1969a, false);
                float length = this.f1974f.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f1974f.getSegment(f8, length, path, true);
                    this.f1974f.getSegment(0.0f, f9, path, true);
                } else {
                    this.f1974f.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f1970b.addPath(path, this.f1971c);
            if (cVar.f1954h.e()) {
                a.h.b.d.b bVar = cVar.f1954h;
                if (this.f1973e == null) {
                    Paint paint = new Paint(1);
                    this.f1973e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f1973e;
                if (bVar.c()) {
                    Shader b2 = bVar.b();
                    b2.setLocalMatrix(this.f1971c);
                    paint2.setShader(b2);
                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(ViewfinderView.OPAQUE);
                    paint2.setColor(i.a(bVar.a(), cVar.j));
                }
                paint2.setColorFilter(colorFilter);
                this.f1970b.setFillType(cVar.f1967c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f1970b, paint2);
            }
            if (cVar.f1952f.e()) {
                a.h.b.d.b bVar2 = cVar.f1952f;
                if (this.f1972d == null) {
                    Paint paint3 = new Paint(1);
                    this.f1972d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f1972d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.p);
                if (bVar2.c()) {
                    Shader b3 = bVar2.b();
                    b3.setLocalMatrix(this.f1971c);
                    paint4.setShader(b3);
                    paint4.setAlpha(Math.round(cVar.f1955i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(ViewfinderView.OPAQUE);
                    paint4.setColor(i.a(bVar2.a(), cVar.f1955i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f1953g * min * a2);
                canvas.drawPath(this.f1970b, paint4);
            }
        }

        public final float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.f1976h.a());
            }
            return this.o.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f1976h.a(iArr);
        }
    }

    public static int a(int i2, float f2) {
        return (i2 & Constant.PPPP_STATUS_UNKNOWN) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 != 9) {
            switch (i2) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_ATOP;
    }

    public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f1943b;
        g gVar = hVar.f1979b;
        hVar.f1981d = a(a.h.b.d.g.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a2 = a.h.b.d.g.a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a2 != null) {
            hVar.f1980c = a2;
        }
        hVar.f1982e = a.h.b.d.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f1982e);
        gVar.k = a.h.b.d.g.a(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        float a3 = a.h.b.d.g.a(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        gVar.l = a3;
        if (gVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (a3 > 0.0f) {
            gVar.f1977i = typedArray.getDimension(3, gVar.f1977i);
            float dimension = typedArray.getDimension(2, gVar.j);
            gVar.j = dimension;
            if (gVar.f1977i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                gVar.setAlpha(a.h.b.d.g.a(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.n = string;
                    gVar.p.put(string, gVar);
                    return;
                }
                return;
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public final void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f1943b;
        g gVar = hVar.f1979b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f1976h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if (FileProvider.ATTR_PATH.equals(name)) {
                    c cVar = new c();
                    cVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f1957b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.f1978a = cVar.f1968d | hVar.f1978a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f1957b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f1978a = bVar.f1968d | hVar.f1978a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f1957b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f1978a = dVar2.k | hVar.f1978a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public void a(boolean z) {
        this.f1947f = z;
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && a.h.c.l.a.e(this) == 1;
    }
}
