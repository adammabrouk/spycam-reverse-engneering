package com.google.android.material.chip;

import a.h.j.h0.c;
import a.h.j.y;
import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import c.c.a.c.a.h;
import c.c.a.c.i.a;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.t.d;
import c.c.a.c.t.f;
import c.c.a.c.w.i;
import c.c.a.c.w.m;
import c.c.a.c.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0100a, p {
    public static final int u = R$style.Widget_MaterialComponents_Chip_Action;
    public static final Rect v = new Rect();
    public static final int[] w = {R.attr.state_selected};
    public static final int[] x = {R.attr.state_checkable};

    /* renamed from: d, reason: collision with root package name */
    public c.c.a.c.i.a f10437d;

    /* renamed from: e, reason: collision with root package name */
    public InsetDrawable f10438e;

    /* renamed from: f, reason: collision with root package name */
    public RippleDrawable f10439f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f10440g;

    /* renamed from: h, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f10441h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10442i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public final c p;
    public final Rect q;
    public final RectF r;
    public final f t;

    public class a extends f {
        public a() {
        }

        @Override // c.c.a.c.t.f
        public void a(int i2) {
        }

        @Override // c.c.a.c.t.f
        public void a(Typeface typeface, boolean z) {
            Chip chip = Chip.this;
            chip.setText(chip.f10437d.q0() ? Chip.this.f10437d.g0() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f10437d != null) {
                Chip.this.f10437d.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    public class c extends a.j.a.a {
        public c(Chip chip) {
            super(chip);
        }

        @Override // a.j.a.a
        public int a(float f2, float f3) {
            return (Chip.this.d() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // a.j.a.a
        public void a(List<Integer> list) {
            list.add(0);
            if (Chip.this.d() && Chip.this.g() && Chip.this.f10440g != null) {
                list.add(1);
            }
        }

        @Override // a.j.a.a
        public void a(int i2, boolean z) {
            if (i2 == 1) {
                Chip.this.l = z;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // a.j.a.a
        public void a(int i2, a.h.j.h0.c cVar) {
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.b(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R$string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    objArr[0] = TextUtils.isEmpty(text) ? "" : text;
                    cVar.b((CharSequence) context.getString(i3, objArr).trim());
                }
                cVar.c(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.f1176g);
                cVar.f(Chip.this.isEnabled());
                return;
            }
            cVar.b("");
            cVar.c(Chip.v);
        }

        @Override // a.j.a.a
        public void a(a.h.j.h0.c cVar) {
            cVar.c(Chip.this.f());
            cVar.e(Chip.this.isClickable());
            if (!Chip.this.f() && !Chip.this.isClickable()) {
                cVar.a("android.view.View");
            } else {
                cVar.a((CharSequence) (Chip.this.f() ? "android.widget.CompoundButton" : "android.widget.Button"));
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.i(text);
            } else {
                cVar.b(text);
            }
        }

        @Override // a.j.a.a
        public boolean a(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.h();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.r.setEmpty();
        if (d()) {
            this.f10437d.a(this.r);
        }
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.q.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.q;
    }

    private d getTextAppearance() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.h0();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.j != z) {
            this.j = z;
            refreshDrawableState();
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.p.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.p.a(keyEvent) || this.p.f() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c.c.a.c.i.a aVar = this.f10437d;
        if ((aVar == null || !aVar.n0()) ? false : this.f10437d.b(b())) {
            invalidate();
        }
    }

    public boolean f() {
        c.c.a.c.i.a aVar = this.f10437d;
        return aVar != null && aVar.m0();
    }

    public boolean g() {
        c.c.a.c.i.a aVar = this.f10437d;
        return aVar != null && aVar.o0();
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f10438e;
        return insetDrawable == null ? this.f10437d : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.H();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.I();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.J();
        }
        return null;
    }

    public float getChipCornerRadius() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return Math.max(0.0f, aVar.K());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f10437d;
    }

    public float getChipEndPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.L();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.M();
        }
        return null;
    }

    public float getChipIconSize() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.N();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.O();
        }
        return null;
    }

    public float getChipMinHeight() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.P();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.Q();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.R();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.S();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.T();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.U();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.V();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.W();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.X();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.Z();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.a0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.p.f() == 1 || this.p.d() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.b0();
        }
        return null;
    }

    public float getIconEndPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.c0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.d0();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.e0();
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        return this.f10437d.n();
    }

    public h getShowMotionSpec() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.f0();
        }
        return null;
    }

    public float getTextEndPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.i0();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            return aVar.j0();
        }
        return 0.0f;
    }

    public boolean h() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f10440g;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.p.d(1, 1);
        return z;
    }

    public final void i() {
        if (this.f10438e != null) {
            this.f10438e = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            l();
        }
    }

    public boolean j() {
        return this.m;
    }

    public final void k() {
        if (d() && g() && this.f10440g != null) {
            y.a(this, this.p);
        } else {
            y.a(this, (a.h.j.a) null);
        }
    }

    public final void l() {
        if (c.c.a.c.u.b.f5626a) {
            m();
            return;
        }
        this.f10437d.g(true);
        y.a(this, getBackgroundDrawable());
        n();
        c();
    }

    public final void m() {
        this.f10439f = new RippleDrawable(c.c.a.c.u.b.b(this.f10437d.e0()), getBackgroundDrawable(), null);
        this.f10437d.g(false);
        y.a(this, this.f10439f);
        n();
    }

    public final void n() {
        c.c.a.c.i.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f10437d) == null) {
            return;
        }
        int L = (int) (aVar.L() + this.f10437d.i0() + this.f10437d.E());
        int Q = (int) (this.f10437d.Q() + this.f10437d.j0() + this.f10437d.D());
        if (this.f10438e != null) {
            Rect rect = new Rect();
            this.f10438e.getPadding(rect);
            Q += rect.left;
            L += rect.right;
        }
        y.a(this, Q, getPaddingTop(), L, getPaddingBottom());
    }

    public final void o() {
        TextPaint paint = getPaint();
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this, this.f10437d);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, x);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.p.a(z, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (f() || isClickable()) {
            accessibilityNodeInfo.setClassName(f() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            a.h.j.h0.c.a(accessibilityNodeInfo).b(c.C0028c.a(chipGroup.a(this), 1, chipGroup.a() ? chipGroup.b(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.n != i2) {
            this.n = i2;
            n();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.j
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.j
            if (r0 == 0) goto L34
            r5.h()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10439f) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10439f) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    public void setCheckableResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.e(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar == null) {
            this.f10442i = z;
            return;
        }
        if (aVar.m0()) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || (onCheckedChangeListener = this.f10441h) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.b(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.f(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.g(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.h(i2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.d(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.f(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void setChipDrawable(c.c.a.c.i.a aVar) {
        c.c.a.c.i.a aVar2 = this.f10437d;
        if (aVar2 != aVar) {
            b(aVar2);
            this.f10437d = aVar;
            aVar.f(false);
            a(this.f10437d);
            a(this.o);
        }
    }

    public void setChipEndPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.g(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.k(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.c(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    public void setChipIconSize(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.h(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.e(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.n(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.o(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.i(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.p(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.j(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.q(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.f(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.r(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.k(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.s(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.d(drawable);
        }
        k();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.l(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.t(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.u(i2);
        }
        k();
    }

    public void setCloseIconSize(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.m(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.v(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.n(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.w(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.h(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.x(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.b(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f10437d == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.a(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.m = z;
        a(this.o);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(h hVar) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.y(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.o(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.z(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.p(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.A(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f10437d != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.B(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f10441h = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f10440g = onClickListener;
        k();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.i(colorStateList);
        }
        if (this.f10437d.l0()) {
            return;
        }
        m();
    }

    public void setRippleColorResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.C(i2);
            if (this.f10437d.l0()) {
                return;
            }
            m();
        }
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        this.f10437d.setShapeAppearanceModel(mVar);
    }

    public void setShowMotionSpec(h hVar) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.D(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f10437d == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.f10437d.q0() ? null : charSequence, bufferType);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.b(charSequence);
        }
    }

    public void setTextAppearance(d dVar) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.a(dVar);
        }
        o();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.q(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.F(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.r(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.G(i2);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    public final void b(c.c.a.c.i.a aVar) {
        if (aVar != null) {
            aVar.a((a.InterfaceC0100a) null);
        }
    }

    public final void c() {
        if (getBackgroundDrawable() == this.f10438e && this.f10437d.getCallback() == null) {
            this.f10437d.setCallback(this.f10438e);
        }
    }

    public final boolean d() {
        c.c.a.c.i.a aVar = this.f10437d;
        return (aVar == null || aVar.T() == null) ? false : true;
    }

    public final void e() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    public void setCloseIconVisible(boolean z) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.e(z);
        }
        k();
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, u), attributeSet, i2);
        this.q = new Rect();
        this.r = new RectF();
        this.t = new a();
        Context context2 = getContext();
        a(attributeSet);
        c.c.a.c.i.a a2 = c.c.a.c.i.a.a(context2, attributeSet, i2, u);
        a(context2, attributeSet, i2);
        setChipDrawable(a2);
        a2.b(y.l(this));
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.Chip, i2, u, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(c.c.a.c.t.c.a(context2, c2, R$styleable.Chip_android_textColor));
        }
        boolean hasValue = c2.hasValue(R$styleable.Chip_shapeAppearance);
        c2.recycle();
        this.p = new c(this);
        k();
        if (!hasValue) {
            e();
        }
        setChecked(this.f10442i);
        setText(a2.g0());
        setEllipsize(a2.a0());
        o();
        if (!this.f10437d.q0()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        n();
        if (j()) {
            setMinHeight(this.o);
        }
        this.n = y.q(this);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray c2 = l.c(context, attributeSet, R$styleable.Chip, i2, u, new int[0]);
        this.m = c2.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.o = (int) Math.ceil(c2.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(r.a(getContext(), 48))));
        c2.recycle();
    }

    public final int[] b() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.l) {
            i3++;
        }
        if (this.k) {
            i3++;
        }
        if (this.j) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.l) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.k) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.j) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    public void setCheckedIconVisible(boolean z) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.E(i2);
        }
        o();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        c.c.a.c.i.a aVar = this.f10437d;
        if (aVar != null) {
            aVar.E(i2);
        }
        o();
    }

    public final void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                                Log.w("Chip", "Chip text must be vertically center and start aligned");
                                return;
                            }
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public final void a(c.c.a.c.i.a aVar) {
        aVar.a(this);
    }

    @Override // c.c.a.c.i.a.InterfaceC0100a
    public void a() {
        a(this.o);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = a.j.a.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.p)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = a.j.a.a.class.getDeclaredMethod("i", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.p, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchFieldException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            } catch (InvocationTargetException e5) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e5);
            }
        }
        return false;
    }

    public boolean a(int i2) {
        this.o = i2;
        if (!j()) {
            if (this.f10438e != null) {
                i();
            } else {
                l();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.f10437d.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.f10437d.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f10438e != null) {
                i();
            } else {
                l();
            }
            return false;
        }
        int i3 = max2 > 0 ? max2 / 2 : 0;
        int i4 = max > 0 ? max / 2 : 0;
        if (this.f10438e != null) {
            Rect rect = new Rect();
            this.f10438e.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                l();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        a(i3, i4, i3, i4);
        l();
        return true;
    }

    public final void a(int i2, int i3, int i4, int i5) {
        this.f10438e = new InsetDrawable((Drawable) this.f10437d, i2, i3, i4, i5);
    }
}
