package c.c.a.c.l;

import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import com.google.android.material.R$styleable;

/* compiled from: CalendarItemStyle.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f5397a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f5398b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f5399c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f5400d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5401e;

    /* renamed from: f, reason: collision with root package name */
    public final c.c.a.c.w.m f5402f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, c.c.a.c.w.m mVar, Rect rect) {
        a.h.i.h.a(rect.left);
        a.h.i.h.a(rect.top);
        a.h.i.h.a(rect.right);
        a.h.i.h.a(rect.bottom);
        this.f5397a = rect;
        this.f5398b = colorStateList2;
        this.f5399c = colorStateList;
        this.f5400d = colorStateList3;
        this.f5401e = i2;
        this.f5402f = mVar;
    }

    public static a a(Context context, int i2) {
        a.h.i.h.a(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList a2 = c.c.a.c.t.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList a3 = c.c.a.c.t.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList a4 = c.c.a.c.t.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        c.c.a.c.w.m a5 = c.c.a.c.w.m.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        obtainStyledAttributes.recycle();
        return new a(a2, a3, a4, dimensionPixelSize, a5, rect);
    }

    public int b() {
        return this.f5397a.top;
    }

    public void a(TextView textView) {
        c.c.a.c.w.h hVar = new c.c.a.c.w.h();
        c.c.a.c.w.h hVar2 = new c.c.a.c.w.h();
        hVar.setShapeAppearanceModel(this.f5402f);
        hVar2.setShapeAppearanceModel(this.f5402f);
        hVar.a(this.f5399c);
        hVar.a(this.f5401e, this.f5400d);
        textView.setTextColor(this.f5398b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f5398b.withAlpha(30), hVar, hVar2) : hVar;
        Rect rect = this.f5397a;
        y.a(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    public int a() {
        return this.f5397a.bottom;
    }
}
