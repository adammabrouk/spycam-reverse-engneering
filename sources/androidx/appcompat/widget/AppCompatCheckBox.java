package androidx.appcompat.widget;

import a.b.b.a.a;
import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.e;
import a.b.f.n;
import a.h.j.x;
import a.h.k.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements k, x {

    /* renamed from: a, reason: collision with root package name */
    public final e f2240a;

    /* renamed from: b, reason: collision with root package name */
    public final d f2241b;

    /* renamed from: c, reason: collision with root package name */
    public final n f2242c;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2241b;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2242c;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        e eVar = this.f2240a;
        return eVar != null ? eVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2241b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2241b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // a.h.k.k
    public ColorStateList getSupportButtonTintList() {
        e eVar = this.f2240a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        e eVar = this.f2240a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2241b;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2241b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        e eVar = this.f2240a;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2241b;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2241b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // a.h.k.k
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        e eVar = this.f2240a;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    @Override // a.h.k.k
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        e eVar = this.f2240a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        e eVar = new e(this);
        this.f2240a = eVar;
        eVar.a(attributeSet, i2);
        d dVar = new d(this);
        this.f2241b = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2242c = nVar;
        nVar.a(attributeSet, i2);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.c(getContext(), i2));
    }
}
