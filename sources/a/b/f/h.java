package a.b.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f486a;

    /* renamed from: b, reason: collision with root package name */
    public e0 f487b;

    /* renamed from: c, reason: collision with root package name */
    public e0 f488c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f489d;

    public h(ImageView imageView) {
        this.f486a = imageView;
    }

    public void a(AttributeSet attributeSet, int i2) {
        int g2;
        g0 a2 = g0.a(this.f486a.getContext(), attributeSet, R$styleable.AppCompatImageView, i2, 0);
        ImageView imageView = this.f486a;
        a.h.j.y.a(imageView, imageView.getContext(), R$styleable.AppCompatImageView, attributeSet, a2.a(), i2, 0);
        try {
            Drawable drawable = this.f486a.getDrawable();
            if (drawable == null && (g2 = a2.g(R$styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = a.b.b.a.a.c(this.f486a.getContext(), g2)) != null) {
                this.f486a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                r.b(drawable);
            }
            if (a2.g(R$styleable.AppCompatImageView_tint)) {
                a.h.k.e.a(this.f486a, a2.a(R$styleable.AppCompatImageView_tint));
            }
            if (a2.g(R$styleable.AppCompatImageView_tintMode)) {
                a.h.k.e.a(this.f486a, r.a(a2.d(R$styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            a2.b();
        }
    }

    public ColorStateList b() {
        e0 e0Var = this.f488c;
        if (e0Var != null) {
            return e0Var.f469a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        e0 e0Var = this.f488c;
        if (e0Var != null) {
            return e0Var.f470b;
        }
        return null;
    }

    public boolean d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f486a.getBackground() instanceof RippleDrawable);
    }

    public final boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f487b != null : i2 == 21;
    }

    public void a(int i2) {
        if (i2 != 0) {
            Drawable c2 = a.b.b.a.a.c(this.f486a.getContext(), i2);
            if (c2 != null) {
                r.b(c2);
            }
            this.f486a.setImageDrawable(c2);
        } else {
            this.f486a.setImageDrawable(null);
        }
        a();
    }

    public void a(ColorStateList colorStateList) {
        if (this.f488c == null) {
            this.f488c = new e0();
        }
        e0 e0Var = this.f488c;
        e0Var.f469a = colorStateList;
        e0Var.f472d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f488c == null) {
            this.f488c = new e0();
        }
        e0 e0Var = this.f488c;
        e0Var.f470b = mode;
        e0Var.f471c = true;
        a();
    }

    public void a() {
        Drawable drawable = this.f486a.getDrawable();
        if (drawable != null) {
            r.b(drawable);
        }
        if (drawable != null) {
            if (e() && a(drawable)) {
                return;
            }
            e0 e0Var = this.f488c;
            if (e0Var != null) {
                f.a(drawable, e0Var, this.f486a.getDrawableState());
                return;
            }
            e0 e0Var2 = this.f487b;
            if (e0Var2 != null) {
                f.a(drawable, e0Var2, this.f486a.getDrawableState());
            }
        }
    }

    public final boolean a(Drawable drawable) {
        if (this.f489d == null) {
            this.f489d = new e0();
        }
        e0 e0Var = this.f489d;
        e0Var.a();
        ColorStateList a2 = a.h.k.e.a(this.f486a);
        if (a2 != null) {
            e0Var.f472d = true;
            e0Var.f469a = a2;
        }
        PorterDuff.Mode b2 = a.h.k.e.b(this.f486a);
        if (b2 != null) {
            e0Var.f471c = true;
            e0Var.f470b = b2;
        }
        if (!e0Var.f472d && !e0Var.f471c) {
            return false;
        }
        f.a(drawable, e0Var, this.f486a.getDrawableState());
        return true;
    }
}
