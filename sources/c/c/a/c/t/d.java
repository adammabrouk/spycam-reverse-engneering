package c.c.a.c.t;

import a.h.b.d.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.material.R$styleable;

/* compiled from: TextAppearance.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final float f5608a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f5609b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f5610c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f5611d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5612e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5613f;

    /* renamed from: g, reason: collision with root package name */
    public final String f5614g;

    /* renamed from: h, reason: collision with root package name */
    public final ColorStateList f5615h;

    /* renamed from: i, reason: collision with root package name */
    public final float f5616i;
    public final float j;
    public final float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    public d(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
        this.f5608a = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f5609b = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        this.f5610c = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.f5611d = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f5612e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f5613f = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int a2 = c.a(obtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.l = obtainStyledAttributes.getResourceId(a2, 0);
        this.f5614g = obtainStyledAttributes.getString(a2);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f5615h = c.a(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f5616i = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.j = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.k = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public Typeface b() {
        a();
        return this.n;
    }

    public void c(Context context, TextPaint textPaint, f fVar) {
        if (e.a()) {
            a(textPaint, a(context));
        } else {
            a(context, textPaint, fVar);
        }
    }

    /* compiled from: TextAppearance.java */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextPaint f5619a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f5620b;

        public b(TextPaint textPaint, f fVar) {
            this.f5619a = textPaint;
            this.f5620b = fVar;
        }

        @Override // c.c.a.c.t.f
        public void a(Typeface typeface, boolean z) {
            d.this.a(this.f5619a, typeface);
            this.f5620b.a(typeface, z);
        }

        @Override // c.c.a.c.t.f
        public void a(int i2) {
            this.f5620b.a(i2);
        }
    }

    /* compiled from: TextAppearance.java */
    public class a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f5617a;

        public a(f fVar) {
            this.f5617a = fVar;
        }

        @Override // a.h.b.d.f.a
        public void a(Typeface typeface) {
            d dVar = d.this;
            dVar.n = Typeface.create(typeface, dVar.f5612e);
            d.this.m = true;
            this.f5617a.a(d.this.n, false);
        }

        @Override // a.h.b.d.f.a
        public void a(int i2) {
            d.this.m = true;
            this.f5617a.a(i2);
        }
    }

    public void b(Context context, TextPaint textPaint, f fVar) {
        c(context, textPaint, fVar);
        ColorStateList colorStateList = this.f5609b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.k;
        float f3 = this.f5616i;
        float f4 = this.j;
        ColorStateList colorStateList2 = this.f5615h;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public Typeface a(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a2 = a.h.b.d.f.a(context, this.l);
                this.n = a2;
                if (a2 != null) {
                    this.n = Typeface.create(a2, this.f5612e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f5614g, e2);
            }
        }
        a();
        this.m = true;
        return this.n;
    }

    public void a(Context context, f fVar) {
        if (e.a()) {
            a(context);
        } else {
            a();
        }
        if (this.l == 0) {
            this.m = true;
        }
        if (this.m) {
            fVar.a(this.n, true);
            return;
        }
        try {
            a.h.b.d.f.a(context, this.l, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f5614g, e2);
            this.m = true;
            fVar.a(-3);
        }
    }

    public void a(Context context, TextPaint textPaint, f fVar) {
        a(textPaint, b());
        a(context, new b(textPaint, fVar));
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.f5614g) != null) {
            this.n = Typeface.create(str, this.f5612e);
        }
        if (this.n == null) {
            int i2 = this.f5613f;
            if (i2 == 1) {
                this.n = Typeface.SANS_SERIF;
            } else if (i2 == 2) {
                this.n = Typeface.SERIF;
            } else if (i2 != 3) {
                this.n = Typeface.DEFAULT;
            } else {
                this.n = Typeface.MONOSPACE;
            }
            this.n = Typeface.create(this.n, this.f5612e);
        }
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.f5612e;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f5608a);
    }
}
