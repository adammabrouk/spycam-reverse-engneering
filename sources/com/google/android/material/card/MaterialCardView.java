package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import c.c.a.c.r.l;
import c.c.a.c.w.i;
import c.c.a.c.w.m;
import c.c.a.c.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;

/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, p {
    public static final int[] o = {R.attr.state_checkable};
    public static final int[] p = {R.attr.state_checked};
    public static final int[] q = {R$attr.state_dragged};
    public static final int r = R$style.Widget_MaterialComponents_CardView;
    public final c.c.a.c.h.a j;
    public boolean k;
    public boolean l;
    public boolean m;
    public a n;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.j.j().getBounds());
        return rectF;
    }

    public void b(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
    }

    public final void d() {
        if (Build.VERSION.SDK_INT > 26) {
            this.j.i();
        }
    }

    public boolean e() {
        c.c.a.c.h.a aVar = this.j;
        return aVar != null && aVar.z();
    }

    public boolean f() {
        return this.m;
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.j.k();
    }

    public ColorStateList getCardForegroundColor() {
        return this.j.l();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.j.m();
    }

    public ColorStateList getCheckedIconTint() {
        return this.j.n();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.j.x().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.j.x().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.j.x().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.j.x().top;
    }

    public float getProgress() {
        return this.j.r();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.j.p();
    }

    public ColorStateList getRippleColor() {
        return this.j.s();
    }

    public m getShapeAppearanceModel() {
        return this.j.t();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.j.u();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.j.v();
    }

    public int getStrokeWidth() {
        return this.j.w();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.l;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this, this.j.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, o);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.j.a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.k) {
            if (!this.j.y()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.j.a(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i2) {
        this.j.a(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.j.E();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.j.b(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.j.b(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.l != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.j.b(drawable);
    }

    public void setCheckedIconResource(int i2) {
        this.j.b(a.b.b.a.a.c(getContext(), i2));
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.j.c(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        c.c.a.c.h.a aVar = this.j;
        if (aVar != null) {
            aVar.C();
        }
    }

    public void setDragged(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.j.F();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.n = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.j.F();
        this.j.D();
    }

    public void setProgress(float f2) {
        this.j.b(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.j.a(f2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.j.d(colorStateList);
    }

    public void setRippleColorResource(int i2) {
        this.j.d(a.b.b.a.a.b(getContext(), i2));
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(mVar.a(getBoundsAsRectF()));
        }
        this.j.a(mVar);
    }

    public void setStrokeColor(int i2) {
        this.j.e(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(int i2) {
        this.j.a(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.j.F();
        this.j.D();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.l = !this.l;
            refreshDrawableState();
            d();
            a aVar = this.n;
            if (aVar != null) {
                aVar.a(this, this.l);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.j.a(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.j.e(colorStateList);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, r), attributeSet, i2);
        this.l = false;
        this.m = false;
        this.k = true;
        TypedArray c2 = l.c(getContext(), attributeSet, R$styleable.MaterialCardView, i2, r, new int[0]);
        c.c.a.c.h.a aVar = new c.c.a.c.h.a(this, attributeSet, i2, r);
        this.j = aVar;
        aVar.a(super.getCardBackgroundColor());
        this.j.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.j.a(c2);
        c2.recycle();
    }
}
