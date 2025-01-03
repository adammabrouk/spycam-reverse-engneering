package com.google.android.material.button;

import a.h.j.y;
import a.h.k.i;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.t.c;
import c.c.a.c.w.m;
import c.c.a.c.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, p {
    public static final int[] o = {R.attr.state_checkable};
    public static final int[] p = {R.attr.state_checked};
    public static final int q = R$style.Widget_MaterialComponents_Button;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.c.f.a f10407c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<a> f10408d;

    /* renamed from: e, reason: collision with root package name */
    public b f10409e;

    /* renamed from: f, reason: collision with root package name */
    public PorterDuff.Mode f10410f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f10411g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f10412h;

    /* renamed from: i, reason: collision with root package name */
    public int f10413i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public boolean f10414c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void a(Parcel parcel) {
            this.f10414c = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f10414c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            a(parcel);
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    public final void a(boolean z) {
        if (z) {
            i.a(this, this.f10412h, null, null, null);
        } else {
            i.a(this, null, null, this.f10412h, null);
        }
    }

    public void addOnCheckedChangeListener(a aVar) {
        this.f10408d.add(aVar);
    }

    public final boolean b() {
        return y.q(this) == 1;
    }

    public final boolean c() {
        c.c.a.c.f.a aVar = this.f10407c;
        return (aVar == null || aVar.l()) ? false : true;
    }

    public final void d() {
        if (this.f10412h == null || getLayout() == null) {
            return;
        }
        int i2 = this.n;
        if (i2 == 1 || i2 == 3) {
            this.j = 0;
            b(false);
            return;
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
        int i3 = this.f10413i;
        if (i3 == 0) {
            i3 = this.f10412h.getIntrinsicWidth();
        }
        int measuredWidth = (((((getMeasuredWidth() - min) - y.v(this)) - i3) - this.k) - y.w(this)) / 2;
        if (b() != (this.n == 4)) {
            measuredWidth = -measuredWidth;
        }
        if (this.j != measuredWidth) {
            this.j = measuredWidth;
            b(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (c()) {
            return this.f10407c.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f10412h;
    }

    public int getIconGravity() {
        return this.n;
    }

    public int getIconPadding() {
        return this.k;
    }

    public int getIconSize() {
        return this.f10413i;
    }

    public ColorStateList getIconTint() {
        return this.f10411g;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f10410f;
    }

    public ColorStateList getRippleColor() {
        if (c()) {
            return this.f10407c.e();
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        if (c()) {
            return this.f10407c.f();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (c()) {
            return this.f10407c.g();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (c()) {
            return this.f10407c.h();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        return c() ? this.f10407c.i() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return c() ? this.f10407c.j() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (c()) {
            c.c.a.c.w.i.a(this, this.f10407c.d());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, o);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, p);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        c.c.a.c.f.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f10407c) == null) {
            return;
        }
        aVar.a(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        d();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f10414c);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10414c = this.l;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        d();
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void removeOnCheckedChangeListener(a aVar) {
        this.f10408d.remove(aVar);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (c()) {
            this.f10407c.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!c()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "Do not set the background; MaterialButton manages its own background drawable.");
            this.f10407c.n();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (c()) {
            this.f10407c.b(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (a() && isEnabled() && this.l != z) {
            this.l = z;
            refreshDrawableState();
            if (this.m) {
                return;
            }
            this.m = true;
            Iterator<a> it = this.f10408d.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.l);
            }
            this.m = false;
        }
    }

    public void setCornerRadius(int i2) {
        if (c()) {
            this.f10407c.b(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (c()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (c()) {
            this.f10407c.d().b(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f10412h != drawable) {
            this.f10412h = drawable;
            b(true);
        }
    }

    public void setIconGravity(int i2) {
        if (this.n != i2) {
            this.n = i2;
            d();
        }
    }

    public void setIconPadding(int i2) {
        if (this.k != i2) {
            this.k = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? a.b.b.a.a.c(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f10413i != i2) {
            this.f10413i = i2;
            b(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f10411g != colorStateList) {
            this.f10411g = colorStateList;
            b(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f10410f != mode) {
            this.f10410f = mode;
            b(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(a.b.b.a.a.b(getContext(), i2));
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f10409e = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f10409e;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (c()) {
            this.f10407c.a(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (c()) {
            setRippleColor(a.b.b.a.a.b(getContext(), i2));
        }
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        if (!c()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f10407c.a(mVar);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (c()) {
            this.f10407c.c(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (c()) {
            this.f10407c.b(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (c()) {
            setStrokeColor(a.b.b.a.a.b(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (c()) {
            this.f10407c.c(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (c()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (c()) {
            this.f10407c.c(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (c()) {
            this.f10407c.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.l);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public final void b(boolean z) {
        Drawable drawable = this.f10412h;
        boolean z2 = false;
        if (drawable != null) {
            Drawable mutate = a.h.c.l.a.i(drawable).mutate();
            this.f10412h = mutate;
            a.h.c.l.a.a(mutate, this.f10411g);
            PorterDuff.Mode mode = this.f10410f;
            if (mode != null) {
                a.h.c.l.a.a(this.f10412h, mode);
            }
            int i2 = this.f10413i;
            if (i2 == 0) {
                i2 = this.f10412h.getIntrinsicWidth();
            }
            int i3 = this.f10413i;
            if (i3 == 0) {
                i3 = this.f10412h.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f10412h;
            int i4 = this.j;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        int i5 = this.n;
        boolean z3 = i5 == 1 || i5 == 2;
        if (z) {
            a(z3);
            return;
        }
        Drawable[] a2 = i.a(this);
        Drawable drawable3 = a2[0];
        Drawable drawable4 = a2[2];
        if ((z3 && drawable3 != this.f10412h) || (!z3 && drawable4 != this.f10412h)) {
            z2 = true;
        }
        if (z2) {
            a(z3);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, q), attributeSet, i2);
        this.f10408d = new LinkedHashSet<>();
        this.l = false;
        this.m = false;
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.MaterialButton, i2, q, new int[0]);
        this.k = c2.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f10410f = r.a(c2.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f10411g = c.a(getContext(), c2, R$styleable.MaterialButton_iconTint);
        this.f10412h = c.b(getContext(), c2, R$styleable.MaterialButton_icon);
        this.n = c2.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f10413i = c2.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        c.c.a.c.f.a aVar = new c.c.a.c.f.a(this, m.a(context2, attributeSet, i2, q).a());
        this.f10407c = aVar;
        aVar.a(c2);
        c2.recycle();
        setCompoundDrawablePadding(this.k);
        b(this.f10412h != null);
    }

    public boolean a() {
        c.c.a.c.f.a aVar = this.f10407c;
        return aVar != null && aVar.m();
    }
}
