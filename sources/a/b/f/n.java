package a.b.f;

import a.h.b.d.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f539a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f540b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f541c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f542d;

    /* renamed from: e, reason: collision with root package name */
    public e0 f543e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f544f;

    /* renamed from: g, reason: collision with root package name */
    public e0 f545g;

    /* renamed from: h, reason: collision with root package name */
    public e0 f546h;

    /* renamed from: i, reason: collision with root package name */
    public final o f547i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* compiled from: AppCompatTextHelper.java */
    public class a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f548a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f549b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f550c;

        public a(int i2, int i3, WeakReference weakReference) {
            this.f548a = i2;
            this.f549b = i3;
            this.f550c = weakReference;
        }

        @Override // a.h.b.d.f.a
        public void a(int i2) {
        }

        @Override // a.h.b.d.f.a
        public void a(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.f548a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f549b & 2) != 0);
            }
            n.this.a(this.f550c, typeface);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f552a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Typeface f553b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f554c;

        public b(n nVar, TextView textView, Typeface typeface, int i2) {
            this.f552a = textView;
            this.f553b = typeface;
            this.f554c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f552a.setTypeface(this.f553b, this.f554c);
        }
    }

    public n(TextView textView) {
        this.f539a = textView;
        this.f547i = new o(this.f539a);
    }

    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        String str;
        boolean z;
        boolean z2;
        ColorStateList colorStateList2;
        String str2;
        ColorStateList colorStateList3;
        boolean z3;
        int i3;
        Context context = this.f539a.getContext();
        f b2 = f.b();
        g0 a2 = g0.a(context, attributeSet, R$styleable.AppCompatTextHelper, i2, 0);
        TextView textView = this.f539a;
        a.h.j.y.a(textView, textView.getContext(), R$styleable.AppCompatTextHelper, attributeSet, a2.a(), i2, 0);
        int g2 = a2.g(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(R$styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f540b = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(R$styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f541c = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(R$styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f542d = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(R$styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f543e = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.g(R$styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f544f = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.g(R$styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.f545g = a(context, b2, a2.g(R$styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.b();
        boolean z4 = this.f539a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g2 != -1) {
            g0 a3 = g0.a(context, g2, R$styleable.TextAppearance);
            if (z4 || !a3.g(R$styleable.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z = a3.a(R$styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList3 = a3.g(R$styleable.TextAppearance_android_textColor) ? a3.a(R$styleable.TextAppearance_android_textColor) : null;
                colorStateList = a3.g(R$styleable.TextAppearance_android_textColorHint) ? a3.a(R$styleable.TextAppearance_android_textColorHint) : null;
                colorStateList2 = a3.g(R$styleable.TextAppearance_android_textColorLink) ? a3.a(R$styleable.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList = null;
                colorStateList2 = null;
                colorStateList3 = null;
            }
            str2 = a3.g(R$styleable.TextAppearance_textLocale) ? a3.d(R$styleable.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !a3.g(R$styleable.TextAppearance_fontVariationSettings)) ? null : a3.d(R$styleable.TextAppearance_fontVariationSettings);
            a3.b();
        } else {
            colorStateList = null;
            str = null;
            z = false;
            z2 = false;
            colorStateList2 = null;
            str2 = null;
            colorStateList3 = null;
        }
        g0 a4 = g0.a(context, attributeSet, R$styleable.TextAppearance, i2, 0);
        if (z4 || !a4.g(R$styleable.TextAppearance_textAllCaps)) {
            z3 = z2;
        } else {
            z = a4.a(R$styleable.TextAppearance_textAllCaps, false);
            z3 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.g(R$styleable.TextAppearance_android_textColor)) {
                colorStateList3 = a4.a(R$styleable.TextAppearance_android_textColor);
            }
            if (a4.g(R$styleable.TextAppearance_android_textColorHint)) {
                colorStateList = a4.a(R$styleable.TextAppearance_android_textColorHint);
            }
            if (a4.g(R$styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a4.a(R$styleable.TextAppearance_android_textColorLink);
            }
        }
        if (a4.g(R$styleable.TextAppearance_textLocale)) {
            str2 = a4.d(R$styleable.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && a4.g(R$styleable.TextAppearance_fontVariationSettings)) {
            str = a4.d(R$styleable.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && a4.g(R$styleable.TextAppearance_android_textSize) && a4.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f539a.setTextSize(0, 0.0f);
        }
        a(context, a4);
        a4.b();
        if (colorStateList3 != null) {
            this.f539a.setTextColor(colorStateList3);
        }
        if (colorStateList != null) {
            this.f539a.setHintTextColor(colorStateList);
        }
        if (colorStateList2 != null) {
            this.f539a.setLinkTextColor(colorStateList2);
        }
        if (!z4 && z3) {
            a(z);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f539a.setTypeface(typeface, this.j);
            } else {
                this.f539a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f539a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                this.f539a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else if (i4 >= 21) {
                this.f539a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        this.f547i.a(attributeSet, i2);
        if (a.h.k.b.s && this.f547i.g() != 0) {
            int[] f2 = this.f547i.f();
            if (f2.length > 0) {
                if (this.f539a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f539a.setAutoSizeTextTypeUniformWithConfiguration(this.f547i.d(), this.f547i.c(), this.f547i.e(), 0);
                } else {
                    this.f539a.setAutoSizeTextTypeUniformWithPresetSizes(f2, 0);
                }
            }
        }
        g0 a5 = g0.a(context, attributeSet, R$styleable.AppCompatTextView);
        int g3 = a5.g(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable a6 = g3 != -1 ? b2.a(context, g3) : null;
        int g4 = a5.g(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable a7 = g4 != -1 ? b2.a(context, g4) : null;
        int g5 = a5.g(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable a8 = g5 != -1 ? b2.a(context, g5) : null;
        int g6 = a5.g(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a9 = g6 != -1 ? b2.a(context, g6) : null;
        int g7 = a5.g(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable a10 = g7 != -1 ? b2.a(context, g7) : null;
        int g8 = a5.g(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        a(a6, a7, a8, a9, a10, g8 != -1 ? b2.a(context, g8) : null);
        if (a5.g(R$styleable.AppCompatTextView_drawableTint)) {
            a.h.k.i.a(this.f539a, a5.a(R$styleable.AppCompatTextView_drawableTint));
        }
        if (a5.g(R$styleable.AppCompatTextView_drawableTintMode)) {
            i3 = -1;
            a.h.k.i.a(this.f539a, r.a(a5.d(R$styleable.AppCompatTextView_drawableTintMode, -1), null));
        } else {
            i3 = -1;
        }
        int c2 = a5.c(R$styleable.AppCompatTextView_firstBaselineToTopHeight, i3);
        int c3 = a5.c(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, i3);
        int c4 = a5.c(R$styleable.AppCompatTextView_lineHeight, i3);
        a5.b();
        if (c2 != i3) {
            a.h.k.i.a(this.f539a, c2);
        }
        if (c3 != i3) {
            a.h.k.i.b(this.f539a, c3);
        }
        if (c4 != i3) {
            a.h.k.i.c(this.f539a, c4);
        }
    }

    public void b() {
        this.f547i.a();
    }

    public int c() {
        return this.f547i.c();
    }

    public int d() {
        return this.f547i.d();
    }

    public int e() {
        return this.f547i.e();
    }

    public int[] f() {
        return this.f547i.f();
    }

    public int g() {
        return this.f547i.g();
    }

    public ColorStateList h() {
        e0 e0Var = this.f546h;
        if (e0Var != null) {
            return e0Var.f469a;
        }
        return null;
    }

    public PorterDuff.Mode i() {
        e0 e0Var = this.f546h;
        if (e0Var != null) {
            return e0Var.f470b;
        }
        return null;
    }

    public boolean j() {
        return this.f547i.h();
    }

    public void k() {
        a();
    }

    public final void l() {
        e0 e0Var = this.f546h;
        this.f540b = e0Var;
        this.f541c = e0Var;
        this.f542d = e0Var;
        this.f543e = e0Var;
        this.f544f = e0Var;
        this.f545g = e0Var;
    }

    public final void b(int i2, float f2) {
        this.f547i.a(i2, f2);
    }

    public final void a(Context context, g0 g0Var) {
        int i2;
        String d2;
        this.j = g0Var.d(R$styleable.TextAppearance_android_textStyle, this.j);
        if (Build.VERSION.SDK_INT >= 28) {
            int d3 = g0Var.d(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.k = d3;
            if (d3 != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (!g0Var.g(R$styleable.TextAppearance_android_fontFamily) && !g0Var.g(R$styleable.TextAppearance_fontFamily)) {
            if (g0Var.g(R$styleable.TextAppearance_android_typeface)) {
                this.m = false;
                int d4 = g0Var.d(R$styleable.TextAppearance_android_typeface, 1);
                if (d4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (d4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (d4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        if (g0Var.g(R$styleable.TextAppearance_fontFamily)) {
            i2 = R$styleable.TextAppearance_fontFamily;
        } else {
            i2 = R$styleable.TextAppearance_android_fontFamily;
        }
        int i3 = this.k;
        int i4 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface a2 = g0Var.a(i2, this.j, new a(i3, i4, new WeakReference(this.f539a)));
                if (a2 != null) {
                    if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                        this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.j & 2) != 0);
                    } else {
                        this.l = a2;
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (d2 = g0Var.d(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
            this.l = Typeface.create(Typeface.create(d2, 0), this.k, (this.j & 2) != 0);
        } else {
            this.l = Typeface.create(d2, this.j);
        }
    }

    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                if (a.h.j.y.I(textView)) {
                    textView.post(new b(this, textView, typeface, this.j));
                } else {
                    textView.setTypeface(typeface, this.j);
                }
            }
        }
    }

    public void a(Context context, int i2) {
        String d2;
        ColorStateList a2;
        ColorStateList a3;
        ColorStateList a4;
        g0 a5 = g0.a(context, i2, R$styleable.TextAppearance);
        if (a5.g(R$styleable.TextAppearance_textAllCaps)) {
            a(a5.a(R$styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a5.g(R$styleable.TextAppearance_android_textColor) && (a4 = a5.a(R$styleable.TextAppearance_android_textColor)) != null) {
                this.f539a.setTextColor(a4);
            }
            if (a5.g(R$styleable.TextAppearance_android_textColorLink) && (a3 = a5.a(R$styleable.TextAppearance_android_textColorLink)) != null) {
                this.f539a.setLinkTextColor(a3);
            }
            if (a5.g(R$styleable.TextAppearance_android_textColorHint) && (a2 = a5.a(R$styleable.TextAppearance_android_textColorHint)) != null) {
                this.f539a.setHintTextColor(a2);
            }
        }
        if (a5.g(R$styleable.TextAppearance_android_textSize) && a5.c(R$styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f539a.setTextSize(0, 0.0f);
        }
        a(context, a5);
        if (Build.VERSION.SDK_INT >= 26 && a5.g(R$styleable.TextAppearance_fontVariationSettings) && (d2 = a5.d(R$styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f539a.setFontVariationSettings(d2);
        }
        a5.b();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f539a.setTypeface(typeface, this.j);
        }
    }

    public void a(boolean z) {
        this.f539a.setAllCaps(z);
    }

    public void a() {
        if (this.f540b != null || this.f541c != null || this.f542d != null || this.f543e != null) {
            Drawable[] compoundDrawables = this.f539a.getCompoundDrawables();
            a(compoundDrawables[0], this.f540b);
            a(compoundDrawables[1], this.f541c);
            a(compoundDrawables[2], this.f542d);
            a(compoundDrawables[3], this.f543e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f544f == null && this.f545g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f539a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f544f);
            a(compoundDrawablesRelative[2], this.f545g);
        }
    }

    public final void a(Drawable drawable, e0 e0Var) {
        if (drawable == null || e0Var == null) {
            return;
        }
        f.a(drawable, e0Var, this.f539a.getDrawableState());
    }

    public static e0 a(Context context, f fVar, int i2) {
        ColorStateList b2 = fVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        e0 e0Var = new e0();
        e0Var.f472d = true;
        e0Var.f469a = b2;
        return e0Var;
    }

    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (a.h.k.b.s) {
            return;
        }
        b();
    }

    public void a(int i2, float f2) {
        if (a.h.k.b.s || j()) {
            return;
        }
        b(i2, f2);
    }

    public void a(int i2) {
        this.f547i.b(i2);
    }

    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f547i.a(i2, i3, i4, i5);
    }

    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        this.f547i.a(iArr, i2);
    }

    public void a(ColorStateList colorStateList) {
        if (this.f546h == null) {
            this.f546h = new e0();
        }
        e0 e0Var = this.f546h;
        e0Var.f469a = colorStateList;
        e0Var.f472d = colorStateList != null;
        l();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f546h == null) {
            this.f546h = new e0();
        }
        e0 e0Var = this.f546h;
        e0Var.f470b = mode;
        e0Var.f471c = mode != null;
        l();
    }

    public final void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f539a.getCompoundDrawablesRelative();
            TextView textView = this.f539a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.f539a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.f539a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.f539a.getCompoundDrawables();
        TextView textView3 = this.f539a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public void a(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        a.h.j.i0.a.a(editorInfo, textView.getText());
    }
}
