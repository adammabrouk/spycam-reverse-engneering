package androidx.cardview.widget;

import a.d.a.b;
import a.d.a.c;
import a.d.a.d;
import a.d.a.e;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f2388h = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    public static final e f2389i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2390a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2391b;

    /* renamed from: c, reason: collision with root package name */
    public int f2392c;

    /* renamed from: d, reason: collision with root package name */
    public int f2393d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f2394e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f2395f;

    /* renamed from: g, reason: collision with root package name */
    public final d f2396g;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f2389i = new b();
        } else if (i2 >= 17) {
            f2389i = new a.d.a.a();
        } else {
            f2389i = new c();
        }
        f2389i.a();
    }

    public CardView(Context context) {
        this(context, null);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2389i.b(this.f2396g);
    }

    public float getCardElevation() {
        return f2389i.c(this.f2396g);
    }

    public int getContentPaddingBottom() {
        return this.f2394e.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2394e.left;
    }

    public int getContentPaddingRight() {
        return this.f2394e.right;
    }

    public int getContentPaddingTop() {
        return this.f2394e.top;
    }

    public float getMaxCardElevation() {
        return f2389i.a(this.f2396g);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2391b;
    }

    public float getRadius() {
        return f2389i.e(this.f2396g);
    }

    public boolean getUseCompatPadding() {
        return this.f2390a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (f2389i instanceof b) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2389i.g(this.f2396g)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(f2389i.f(this.f2396g)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(int i2) {
        f2389i.a(this.f2396g, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f2389i.b(this.f2396g, f2);
    }

    public void setMaxCardElevation(float f2) {
        f2389i.c(this.f2396g, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f2393d = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f2392c = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f2391b) {
            this.f2391b = z;
            f2389i.i(this.f2396g);
        }
    }

    public void setRadius(float f2) {
        f2389i.a(this.f2396g, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2390a != z) {
            this.f2390a = z;
            f2389i.h(this.f2396g);
        }
    }

    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public Drawable f2397a;

        public a() {
        }

        @Override // a.d.a.d
        public void a(Drawable drawable) {
            this.f2397a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // a.d.a.d
        public boolean b() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // a.d.a.d
        public boolean c() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // a.d.a.d
        public Drawable d() {
            return this.f2397a;
        }

        @Override // a.d.a.d
        public void a(int i2, int i3, int i4, int i5) {
            CardView.this.f2395f.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.f2394e;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }

        @Override // a.d.a.d
        public void a(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f2392c) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f2393d) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // a.d.a.d
        public View a() {
            return CardView.this;
        }
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.cardViewStyle);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2389i.a(this.f2396g, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        this.f2394e = new Rect();
        this.f2395f = new Rect();
        this.f2396g = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CardView, i2, R$style.CardView);
        if (obtainStyledAttributes.hasValue(R$styleable.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(R$styleable.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f2388h);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(R$color.cardview_light_background);
            } else {
                color = getResources().getColor(R$color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.f2390a = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.f2391b = obtainStyledAttributes.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        this.f2394e.left = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        this.f2394e.top = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, dimensionPixelSize);
        this.f2394e.right = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, dimensionPixelSize);
        this.f2394e.bottom = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2392c = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.f2393d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f2389i.a(this.f2396g, context, colorStateList, dimension, dimension2, f2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f2394e.set(i2, i3, i4, i5);
        f2389i.d(this.f2396g);
    }
}
