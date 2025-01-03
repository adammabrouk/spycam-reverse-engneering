package c.c.a.c.w;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R$styleable;

/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes.dex */
public class m {
    public static final c.c.a.c.w.c m = new k(0.5f);

    /* renamed from: a, reason: collision with root package name */
    public d f5673a;

    /* renamed from: b, reason: collision with root package name */
    public d f5674b;

    /* renamed from: c, reason: collision with root package name */
    public d f5675c;

    /* renamed from: d, reason: collision with root package name */
    public d f5676d;

    /* renamed from: e, reason: collision with root package name */
    public c.c.a.c.w.c f5677e;

    /* renamed from: f, reason: collision with root package name */
    public c.c.a.c.w.c f5678f;

    /* renamed from: g, reason: collision with root package name */
    public c.c.a.c.w.c f5679g;

    /* renamed from: h, reason: collision with root package name */
    public c.c.a.c.w.c f5680h;

    /* renamed from: i, reason: collision with root package name */
    public f f5681i;
    public f j;
    public f k;
    public f l;

    /* compiled from: ShapeAppearanceModel.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public d f5682a;

        /* renamed from: b, reason: collision with root package name */
        public d f5683b;

        /* renamed from: c, reason: collision with root package name */
        public d f5684c;

        /* renamed from: d, reason: collision with root package name */
        public d f5685d;

        /* renamed from: e, reason: collision with root package name */
        public c.c.a.c.w.c f5686e;

        /* renamed from: f, reason: collision with root package name */
        public c.c.a.c.w.c f5687f;

        /* renamed from: g, reason: collision with root package name */
        public c.c.a.c.w.c f5688g;

        /* renamed from: h, reason: collision with root package name */
        public c.c.a.c.w.c f5689h;

        /* renamed from: i, reason: collision with root package name */
        public f f5690i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.f5682a = i.a();
            this.f5683b = i.a();
            this.f5684c = i.a();
            this.f5685d = i.a();
            this.f5686e = new c.c.a.c.w.a(0.0f);
            this.f5687f = new c.c.a.c.w.a(0.0f);
            this.f5688g = new c.c.a.c.w.a(0.0f);
            this.f5689h = new c.c.a.c.w.a(0.0f);
            this.f5690i = i.b();
            this.j = i.b();
            this.k = i.b();
            this.l = i.b();
        }

        public static float f(d dVar) {
            if (dVar instanceof l) {
                return ((l) dVar).f5672a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f5647a;
            }
            return -1.0f;
        }

        public b a(int i2, float f2) {
            a(i.a(i2));
            a(f2);
            return this;
        }

        public b b(c.c.a.c.w.c cVar) {
            this.f5688g = cVar;
            return this;
        }

        public b c(c.c.a.c.w.c cVar) {
            this.f5686e = cVar;
            return this;
        }

        public b d(float f2) {
            this.f5686e = new c.c.a.c.w.a(f2);
            return this;
        }

        public b e(float f2) {
            this.f5687f = new c.c.a.c.w.a(f2);
            return this;
        }

        public b b(float f2) {
            this.f5689h = new c.c.a.c.w.a(f2);
            return this;
        }

        public b c(float f2) {
            this.f5688g = new c.c.a.c.w.a(f2);
            return this;
        }

        public b d(c.c.a.c.w.c cVar) {
            this.f5687f = cVar;
            return this;
        }

        public b e(d dVar) {
            this.f5683b = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                e(f2);
            }
            return this;
        }

        public b a(d dVar) {
            d(dVar);
            e(dVar);
            c(dVar);
            b(dVar);
            return this;
        }

        public b b(int i2, c.c.a.c.w.c cVar) {
            c(i.a(i2));
            b(cVar);
            return this;
        }

        public b c(int i2, c.c.a.c.w.c cVar) {
            d(i.a(i2));
            c(cVar);
            return this;
        }

        public b d(d dVar) {
            this.f5682a = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                d(f2);
            }
            return this;
        }

        public b b(d dVar) {
            this.f5685d = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                b(f2);
            }
            return this;
        }

        public b c(d dVar) {
            this.f5684c = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                c(f2);
            }
            return this;
        }

        public b d(int i2, c.c.a.c.w.c cVar) {
            e(i.a(i2));
            d(cVar);
            return this;
        }

        public b a(float f2) {
            d(f2);
            e(f2);
            c(f2);
            b(f2);
            return this;
        }

        public b b(f fVar) {
            this.f5690i = fVar;
            return this;
        }

        public b a(c.c.a.c.w.c cVar) {
            this.f5689h = cVar;
            return this;
        }

        public b a(int i2, c.c.a.c.w.c cVar) {
            b(i.a(i2));
            a(cVar);
            return this;
        }

        public b(m mVar) {
            this.f5682a = i.a();
            this.f5683b = i.a();
            this.f5684c = i.a();
            this.f5685d = i.a();
            this.f5686e = new c.c.a.c.w.a(0.0f);
            this.f5687f = new c.c.a.c.w.a(0.0f);
            this.f5688g = new c.c.a.c.w.a(0.0f);
            this.f5689h = new c.c.a.c.w.a(0.0f);
            this.f5690i = i.b();
            this.j = i.b();
            this.k = i.b();
            this.l = i.b();
            this.f5682a = mVar.f5673a;
            this.f5683b = mVar.f5674b;
            this.f5684c = mVar.f5675c;
            this.f5685d = mVar.f5676d;
            this.f5686e = mVar.f5677e;
            this.f5687f = mVar.f5678f;
            this.f5688g = mVar.f5679g;
            this.f5689h = mVar.f5680h;
            this.f5690i = mVar.f5681i;
            this.j = mVar.j;
            this.k = mVar.k;
            this.l = mVar.l;
        }

        public b a(f fVar) {
            this.k = fVar;
            return this;
        }

        public m a() {
            return new m(this);
        }
    }

    /* compiled from: ShapeAppearanceModel.java */
    public interface c {
        c.c.a.c.w.c a(c.c.a.c.w.c cVar);
    }

    public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
        return a(context, attributeSet, i2, i3, 0);
    }

    public static b n() {
        return new b();
    }

    public d b() {
        return this.f5676d;
    }

    public c.c.a.c.w.c c() {
        return this.f5680h;
    }

    public d d() {
        return this.f5675c;
    }

    public c.c.a.c.w.c e() {
        return this.f5679g;
    }

    public f f() {
        return this.l;
    }

    public f g() {
        return this.j;
    }

    public f h() {
        return this.f5681i;
    }

    public d i() {
        return this.f5673a;
    }

    public c.c.a.c.w.c j() {
        return this.f5677e;
    }

    public d k() {
        return this.f5674b;
    }

    public c.c.a.c.w.c l() {
        return this.f5678f;
    }

    public b m() {
        return new b(this);
    }

    public m(b bVar) {
        this.f5673a = bVar.f5682a;
        this.f5674b = bVar.f5683b;
        this.f5675c = bVar.f5684c;
        this.f5676d = bVar.f5685d;
        this.f5677e = bVar.f5686e;
        this.f5678f = bVar.f5687f;
        this.f5679g = bVar.f5688g;
        this.f5680h = bVar.f5689h;
        this.f5681i = bVar.f5690i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }

    public static b a(Context context, AttributeSet attributeSet, int i2, int i3, int i4) {
        return a(context, attributeSet, i2, i3, new c.c.a.c.w.a(i4));
    }

    public static b a(Context context, AttributeSet attributeSet, int i2, int i3, c.c.a.c.w.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public static b a(Context context, int i2, int i3) {
        return a(context, i2, i3, 0);
    }

    public static b a(Context context, int i2, int i3, int i4) {
        return a(context, i2, i3, new c.c.a.c.w.a(i4));
    }

    public static b a(Context context, int i2, int i3, c.c.a.c.w.c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R$styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c.c.a.c.w.c a2 = a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSize, cVar);
            c.c.a.c.w.c a3 = a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopLeft, a2);
            c.c.a.c.w.c a4 = a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeTopRight, a2);
            c.c.a.c.w.c a5 = a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomRight, a2);
            c.c.a.c.w.c a6 = a(obtainStyledAttributes, R$styleable.ShapeAppearance_cornerSizeBottomLeft, a2);
            b bVar = new b();
            bVar.c(i5, a3);
            bVar.d(i6, a4);
            bVar.b(i7, a5);
            bVar.a(i8, a6);
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public m() {
        this.f5673a = i.a();
        this.f5674b = i.a();
        this.f5675c = i.a();
        this.f5676d = i.a();
        this.f5677e = new c.c.a.c.w.a(0.0f);
        this.f5678f = new c.c.a.c.w.a(0.0f);
        this.f5679g = new c.c.a.c.w.a(0.0f);
        this.f5680h = new c.c.a.c.w.a(0.0f);
        this.f5681i = i.b();
        this.j = i.b();
        this.k = i.b();
        this.l = i.b();
    }

    public static c.c.a.c.w.c a(TypedArray typedArray, int i2, c.c.a.c.w.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new c.c.a.c.w.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new k(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public f a() {
        return this.k;
    }

    public m a(float f2) {
        b m2 = m();
        m2.a(f2);
        return m2.a();
    }

    public m a(c cVar) {
        b m2 = m();
        m2.c(cVar.a(j()));
        m2.d(cVar.a(l()));
        m2.a(cVar.a(c()));
        m2.b(cVar.a(e()));
        return m2.a();
    }

    public boolean a(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.f5681i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.f5677e.a(rectF);
        return z && ((this.f5678f.a(rectF) > a2 ? 1 : (this.f5678f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f5680h.a(rectF) > a2 ? 1 : (this.f5680h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f5679g.a(rectF) > a2 ? 1 : (this.f5679g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f5674b instanceof l) && (this.f5673a instanceof l) && (this.f5675c instanceof l) && (this.f5676d instanceof l));
    }
}
