package a.b.f;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final View f453a;

    /* renamed from: d, reason: collision with root package name */
    public e0 f456d;

    /* renamed from: e, reason: collision with root package name */
    public e0 f457e;

    /* renamed from: f, reason: collision with root package name */
    public e0 f458f;

    /* renamed from: c, reason: collision with root package name */
    public int f455c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final f f454b = f.b();

    public d(View view) {
        this.f453a = view;
    }

    public void a(AttributeSet attributeSet, int i2) {
        g0 a2 = g0.a(this.f453a.getContext(), attributeSet, R$styleable.ViewBackgroundHelper, i2, 0);
        View view = this.f453a;
        a.h.j.y.a(view, view.getContext(), R$styleable.ViewBackgroundHelper, attributeSet, a2.a(), i2, 0);
        try {
            if (a2.g(R$styleable.ViewBackgroundHelper_android_background)) {
                this.f455c = a2.g(R$styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f454b.b(this.f453a.getContext(), this.f455c);
                if (b2 != null) {
                    a(b2);
                }
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTint)) {
                a.h.j.y.a(this.f453a, a2.a(R$styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R$styleable.ViewBackgroundHelper_backgroundTintMode)) {
                a.h.j.y.a(this.f453a, r.a(a2.d(R$styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            a2.b();
        }
    }

    public void b(Drawable drawable) {
        this.f455c = -1;
        a((ColorStateList) null);
        a();
    }

    public PorterDuff.Mode c() {
        e0 e0Var = this.f457e;
        if (e0Var != null) {
            return e0Var.f470b;
        }
        return null;
    }

    public final boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f456d != null : i2 == 21;
    }

    public void b(ColorStateList colorStateList) {
        if (this.f457e == null) {
            this.f457e = new e0();
        }
        e0 e0Var = this.f457e;
        e0Var.f469a = colorStateList;
        e0Var.f472d = true;
        a();
    }

    public ColorStateList b() {
        e0 e0Var = this.f457e;
        if (e0Var != null) {
            return e0Var.f469a;
        }
        return null;
    }

    public void a(int i2) {
        this.f455c = i2;
        f fVar = this.f454b;
        a(fVar != null ? fVar.b(this.f453a.getContext(), i2) : null);
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.f457e == null) {
            this.f457e = new e0();
        }
        e0 e0Var = this.f457e;
        e0Var.f470b = mode;
        e0Var.f471c = true;
        a();
    }

    public void a() {
        Drawable background = this.f453a.getBackground();
        if (background != null) {
            if (d() && a(background)) {
                return;
            }
            e0 e0Var = this.f457e;
            if (e0Var != null) {
                f.a(background, e0Var, this.f453a.getDrawableState());
                return;
            }
            e0 e0Var2 = this.f456d;
            if (e0Var2 != null) {
                f.a(background, e0Var2, this.f453a.getDrawableState());
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f456d == null) {
                this.f456d = new e0();
            }
            e0 e0Var = this.f456d;
            e0Var.f469a = colorStateList;
            e0Var.f472d = true;
        } else {
            this.f456d = null;
        }
        a();
    }

    public final boolean a(Drawable drawable) {
        if (this.f458f == null) {
            this.f458f = new e0();
        }
        e0 e0Var = this.f458f;
        e0Var.a();
        ColorStateList h2 = a.h.j.y.h(this.f453a);
        if (h2 != null) {
            e0Var.f472d = true;
            e0Var.f469a = h2;
        }
        PorterDuff.Mode i2 = a.h.j.y.i(this.f453a);
        if (i2 != null) {
            e0Var.f471c = true;
            e0Var.f470b = i2;
        }
        if (!e0Var.f472d && !e0Var.f471c) {
            return false;
        }
        f.a(drawable, e0Var, this.f453a.getDrawableState());
        return true;
    }
}
