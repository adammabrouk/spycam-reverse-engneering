package androidx.appcompat.widget;

import a.b.f.b0;
import a.b.f.d;
import a.b.f.n;
import a.h.j.x;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class AppCompatToggleButton extends ToggleButton implements x {

    /* renamed from: a, reason: collision with root package name */
    public final d f2285a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2286b;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2285a;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2286b;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2285a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2285a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2285a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2285a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2285a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2285a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f2285a = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2286b = nVar;
        nVar.a(attributeSet, i2);
    }
}
