package androidx.appcompat.widget;

import a.b.f.b0;
import a.b.f.d;
import a.b.f.d0;
import a.b.f.n;
import a.h.j.x;
import a.h.k.b;
import a.h.k.i;
import a.h.k.l;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatButton extends Button implements x, b, l {

    /* renamed from: a, reason: collision with root package name */
    public final d f2238a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2239b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f2238a;
        if (dVar != null) {
            dVar.a();
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.s) {
            return super.getAutoSizeMaxTextSize();
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            return nVar.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.s) {
            return super.getAutoSizeMinTextSize();
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            return nVar.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.s) {
            return super.getAutoSizeStepGranularity();
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            return nVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.s) {
            return super.getAutoSizeTextAvailableSizes();
        }
        n nVar = this.f2239b;
        return nVar != null ? nVar.f() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.s) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            return nVar.g();
        }
        return 0;
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f2238a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f2238a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f2239b.h();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f2239b.i();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        n nVar = this.f2239b;
        if (nVar == null || b.s || !nVar.j()) {
            return;
        }
        this.f2239b.b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (b.s) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (b.s) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(iArr, i2);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (b.s) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(i2);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f2238a;
        if (dVar != null) {
            dVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f2238a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(z);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f2238a;
        if (dVar != null) {
            dVar.b(colorStateList);
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f2238a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    @Override // a.h.k.l
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f2239b.a(colorStateList);
        this.f2239b.a();
    }

    @Override // a.h.k.l
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f2239b.a(mode);
        this.f2239b.a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        if (b.s) {
            super.setTextSize(i2, f2);
            return;
        }
        n nVar = this.f2239b;
        if (nVar != null) {
            nVar.a(i2, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(d0.b(context), attributeSet, i2);
        b0.a(this, getContext());
        d dVar = new d(this);
        this.f2238a = dVar;
        dVar.a(attributeSet, i2);
        n nVar = new n(this);
        this.f2239b = nVar;
        nVar.a(attributeSet, i2);
        this.f2239b.a();
    }
}
