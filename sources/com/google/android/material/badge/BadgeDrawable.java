package com.google.android.material.badge;

import a.h.j.y;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import c.c.a.c.c.a;
import c.c.a.c.r.j;
import c.c.a.c.r.l;
import c.c.a.c.t.c;
import c.c.a.c.t.d;
import c.c.a.c.w.h;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.zxing.view.ViewfinderView;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements j.b {
    public static final int q = R$style.Widget_MaterialComponents_Badge;
    public static final int r = R$attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f10285a;

    /* renamed from: b, reason: collision with root package name */
    public final h f10286b;

    /* renamed from: c, reason: collision with root package name */
    public final j f10287c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f10288d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10289e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10290f;

    /* renamed from: g, reason: collision with root package name */
    public final float f10291g;

    /* renamed from: h, reason: collision with root package name */
    public final SavedState f10292h;

    /* renamed from: i, reason: collision with root package name */
    public float f10293i;
    public float j;
    public int k;
    public float l;
    public float m;
    public float n;
    public WeakReference<View> o;
    public WeakReference<ViewGroup> p;

    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f10294a;

        /* renamed from: b, reason: collision with root package name */
        public int f10295b;

        /* renamed from: c, reason: collision with root package name */
        public int f10296c;

        /* renamed from: d, reason: collision with root package name */
        public int f10297d;

        /* renamed from: e, reason: collision with root package name */
        public int f10298e;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f10299f;

        /* renamed from: g, reason: collision with root package name */
        public int f10300g;

        /* renamed from: h, reason: collision with root package name */
        public int f10301h;

        /* renamed from: i, reason: collision with root package name */
        public int f10302i;
        public int j;
        public int k;

        public static class a implements Parcelable.Creator<SavedState> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Context context) {
            this.f10296c = ViewfinderView.OPAQUE;
            this.f10297d = -1;
            this.f10295b = new d(context, R$style.TextAppearance_MaterialComponents_Badge).f5609b.getDefaultColor();
            this.f10299f = context.getString(R$string.mtrl_badge_numberless_content_description);
            this.f10300g = R$plurals.mtrl_badge_content_description;
            this.f10301h = R$string.mtrl_exceed_max_badge_number_content_description;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f10294a);
            parcel.writeInt(this.f10295b);
            parcel.writeInt(this.f10296c);
            parcel.writeInt(this.f10297d);
            parcel.writeInt(this.f10298e);
            parcel.writeString(this.f10299f.toString());
            parcel.writeInt(this.f10300g);
            parcel.writeInt(this.f10302i);
            parcel.writeInt(this.j);
            parcel.writeInt(this.k);
        }

        public SavedState(Parcel parcel) {
            this.f10296c = ViewfinderView.OPAQUE;
            this.f10297d = -1;
            this.f10294a = parcel.readInt();
            this.f10295b = parcel.readInt();
            this.f10296c = parcel.readInt();
            this.f10297d = parcel.readInt();
            this.f10298e = parcel.readInt();
            this.f10299f = parcel.readString();
            this.f10300g = parcel.readInt();
            this.f10302i = parcel.readInt();
            this.j = parcel.readInt();
            this.k = parcel.readInt();
        }
    }

    public BadgeDrawable(Context context) {
        this.f10285a = new WeakReference<>(context);
        l.b(context);
        Resources resources = context.getResources();
        this.f10288d = new Rect();
        this.f10286b = new h();
        this.f10289e = resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius);
        this.f10291g = resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding);
        this.f10290f = resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius);
        j jVar = new j(this);
        this.f10287c = jVar;
        jVar.b().setTextAlign(Paint.Align.CENTER);
        this.f10292h = new SavedState(context);
        g(R$style.TextAppearance_MaterialComponents_Badge);
    }

    public static BadgeDrawable a(Context context, SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.a(savedState);
        return badgeDrawable;
    }

    public static BadgeDrawable b(Context context, AttributeSet attributeSet, int i2, int i3) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.a(context, attributeSet, i2, i3);
        return badgeDrawable;
    }

    public void c(int i2) {
        this.f10292h.f10295b = i2;
        if (this.f10287c.b().getColor() != i2) {
            this.f10287c.b().setColor(i2);
            invalidateSelf();
        }
    }

    public int d() {
        return this.f10292h.f10298e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f10286b.draw(canvas);
        if (g()) {
            a(canvas);
        }
    }

    public int e() {
        if (g()) {
            return this.f10292h.f10297d;
        }
        return 0;
    }

    public SavedState f() {
        return this.f10292h;
    }

    public boolean g() {
        return this.f10292h.f10297d != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10292h.f10296c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10288d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10288d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i2) {
        this.f10292h.k = i2;
        h();
    }

    public final void i() {
        Double.isNaN(d());
        this.k = ((int) Math.pow(10.0d, r0 - 1.0d)) - 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, c.c.a.c.r.j.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f10292h.f10296c = i2;
        this.f10287c.b().setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void d(int i2) {
        this.f10292h.j = i2;
        h();
    }

    public void f(int i2) {
        int max = Math.max(0, i2);
        if (this.f10292h.f10297d != max) {
            this.f10292h.f10297d = max;
            this.f10287c.a(true);
            h();
            invalidateSelf();
        }
    }

    public final void g(int i2) {
        Context context = this.f10285a.get();
        if (context == null) {
            return;
        }
        a(new d(context, i2));
    }

    public static BadgeDrawable a(Context context) {
        return b(context, null, r, q);
    }

    public void b(int i2) {
        if (this.f10292h.f10302i != i2) {
            this.f10292h.f10302i = i2;
            WeakReference<View> weakReference = this.o;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.o.get();
            WeakReference<ViewGroup> weakReference2 = this.p;
            a(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void e(int i2) {
        if (this.f10292h.f10298e != i2) {
            this.f10292h.f10298e = i2;
            i();
            this.f10287c.a(true);
            h();
            invalidateSelf();
        }
    }

    public final void h() {
        Context context = this.f10285a.get();
        WeakReference<View> weakReference = this.o;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f10288d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<ViewGroup> weakReference2 = this.p;
        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || a.f5356a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        a(context, rect2, view);
        a.a(this.f10288d, this.f10293i, this.j, this.m, this.n);
        this.f10286b.a(this.l);
        if (rect.equals(this.f10288d)) {
            return;
        }
        this.f10286b.setBounds(this.f10288d);
    }

    public final void a(SavedState savedState) {
        e(savedState.f10298e);
        if (savedState.f10297d != -1) {
            f(savedState.f10297d);
        }
        a(savedState.f10294a);
        c(savedState.f10295b);
        b(savedState.f10302i);
        d(savedState.j);
        h(savedState.k);
    }

    public CharSequence c() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (g()) {
            if (this.f10292h.f10300g <= 0 || (context = this.f10285a.get()) == null) {
                return null;
            }
            if (e() <= this.k) {
                return context.getResources().getQuantityString(this.f10292h.f10300g, e(), Integer.valueOf(e()));
            }
            return context.getString(this.f10292h.f10301h, Integer.valueOf(this.k));
        }
        return this.f10292h.f10299f;
    }

    public final String b() {
        if (e() <= this.k) {
            return Integer.toString(e());
        }
        Context context = this.f10285a.get();
        return context == null ? "" : context.getString(R$string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.k), "+");
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray c2 = l.c(context, attributeSet, R$styleable.Badge, i2, i3, new int[0]);
        e(c2.getInt(R$styleable.Badge_maxCharacterCount, 4));
        if (c2.hasValue(R$styleable.Badge_number)) {
            f(c2.getInt(R$styleable.Badge_number, 0));
        }
        a(a(context, c2, R$styleable.Badge_backgroundColor));
        if (c2.hasValue(R$styleable.Badge_badgeTextColor)) {
            c(a(context, c2, R$styleable.Badge_badgeTextColor));
        }
        b(c2.getInt(R$styleable.Badge_badgeGravity, 8388661));
        d(c2.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0));
        h(c2.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0));
        c2.recycle();
    }

    public static int a(Context context, TypedArray typedArray, int i2) {
        return c.a(context, typedArray, i2).getDefaultColor();
    }

    public void a(View view, ViewGroup viewGroup) {
        this.o = new WeakReference<>(view);
        this.p = new WeakReference<>(viewGroup);
        h();
        invalidateSelf();
    }

    public void a(int i2) {
        this.f10292h.f10294a = i2;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        if (this.f10286b.h() != valueOf) {
            this.f10286b.a(valueOf);
            invalidateSelf();
        }
    }

    @Override // c.c.a.c.r.j.b
    public void a() {
        invalidateSelf();
    }

    public final void a(d dVar) {
        Context context;
        if (this.f10287c.a() == dVar || (context = this.f10285a.get()) == null) {
            return;
        }
        this.f10287c.a(dVar, context);
        h();
    }

    public final void a(Context context, Rect rect, View view) {
        int i2 = this.f10292h.f10302i;
        if (i2 == 8388691 || i2 == 8388693) {
            this.j = rect.bottom - this.f10292h.k;
        } else {
            this.j = rect.top + this.f10292h.k;
        }
        if (e() <= 9) {
            float f2 = !g() ? this.f10289e : this.f10290f;
            this.l = f2;
            this.n = f2;
            this.m = f2;
        } else {
            float f3 = this.f10290f;
            this.l = f3;
            this.n = f3;
            this.m = (this.f10287c.a(b()) / 2.0f) + this.f10291g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(g() ? R$dimen.mtrl_badge_text_horizontal_edge_offset : R$dimen.mtrl_badge_horizontal_edge_offset);
        int i3 = this.f10292h.f10302i;
        if (i3 != 8388659 && i3 != 8388691) {
            this.f10293i = y.q(view) == 0 ? ((rect.right + this.m) - dimensionPixelSize) - this.f10292h.j : (rect.left - this.m) + dimensionPixelSize + this.f10292h.j;
        } else {
            this.f10293i = y.q(view) == 0 ? (rect.left - this.m) + dimensionPixelSize + this.f10292h.j : ((rect.right + this.m) - dimensionPixelSize) - this.f10292h.j;
        }
    }

    public final void a(Canvas canvas) {
        Rect rect = new Rect();
        String b2 = b();
        this.f10287c.b().getTextBounds(b2, 0, b2.length(), rect);
        canvas.drawText(b2, this.f10293i, this.j + (rect.height() / 2), this.f10287c.b());
    }
}
