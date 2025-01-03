package com.google.android.material.floatingactionbutton;

import a.b.f.f;
import a.b.f.h;
import a.h.j.x;
import a.h.j.y;
import a.h.k.m;
import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.c.a.k;
import c.c.a.c.q.d;
import c.c.a.c.q.e;
import c.c.a.c.r.l;
import c.c.a.c.r.r;
import c.c.a.c.w.p;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements x, m, c.c.a.c.p.a, p, CoordinatorLayout.b {
    public static final int r = R$style.Widget_Design_FloatingActionButton;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f10512b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f10513c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10514d;

    /* renamed from: e, reason: collision with root package name */
    public PorterDuff.Mode f10515e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f10516f;

    /* renamed from: g, reason: collision with root package name */
    public int f10517g;

    /* renamed from: h, reason: collision with root package name */
    public int f10518h;

    /* renamed from: i, reason: collision with root package name */
    public int f10519i;
    public int j;
    public int k;
    public boolean l;
    public final Rect m;
    public final Rect n;
    public final h o;
    public final c.c.a.c.p.c p;
    public c.c.a.c.q.d q;

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a, reason: collision with root package name */
        public Rect f10520a;

        /* renamed from: b, reason: collision with root package name */
        public b f10521b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10522c;

        public BaseBehavior() {
            this.f10522c = true;
        }

        public void setInternalAutoHideListener(b bVar) {
            this.f10521b = bVar;
        }

        public final boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.a(this.f10521b, false);
                return true;
            }
            floatingActionButton.b(this.f10521b, false);
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f10522c = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void a(CoordinatorLayout.f fVar) {
            if (fVar.f2450h == 0) {
                fVar.f2450h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        public static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).d() instanceof BottomSheetBehavior;
            }
            return false;
        }

        public final boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f10522c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).c() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f10520a == null) {
                this.f10520a = new Rect();
            }
            Rect rect = this.f10520a;
            c.c.a.c.r.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.a(this.f10521b, false);
                return true;
            }
            floatingActionButton.b(this.f10521b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> b2 = coordinatorLayout.b(floatingActionButton);
            int size = b2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = b2.get(i3);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.d(floatingActionButton, i2);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public final void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                y.e(floatingActionButton, i3);
            }
            if (i2 != 0) {
                y.d(floatingActionButton, i2);
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(b bVar) {
            super.setInternalAutoHideListener(bVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class a implements d.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f10523a;

        public a(b bVar) {
            this.f10523a = bVar;
        }

        @Override // c.c.a.c.q.d.j
        public void a() {
            this.f10523a.b(FloatingActionButton.this);
        }

        @Override // c.c.a.c.q.d.j
        public void b() {
            this.f10523a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class d<T extends FloatingActionButton> implements d.i {

        /* renamed from: a, reason: collision with root package name */
        public final k<T> f10526a;

        public d(k<T> kVar) {
            this.f10526a = kVar;
        }

        @Override // c.c.a.c.q.d.i
        public void a() {
            this.f10526a.a(FloatingActionButton.this);
        }

        @Override // c.c.a.c.q.d.i
        public void b() {
            this.f10526a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f10526a.equals(this.f10526a);
        }

        public int hashCode() {
            return this.f10526a.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private c.c.a.c.q.d getImpl() {
        if (this.q == null) {
            this.q = b();
        }
        return this.q;
    }

    public void b(b bVar, boolean z) {
        getImpl().b(a(bVar), z);
    }

    public boolean c() {
        return getImpl().m();
    }

    public boolean d() {
        return getImpl().n();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f10514d;
        if (colorStateList == null) {
            a.h.c.l.a.b(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f10515e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(f.a(colorForState, mode));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f10512b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f10513c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().h();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().j();
    }

    public Drawable getContentBackground() {
        return getImpl().b();
    }

    public int getCustomSize() {
        return this.f10519i;
    }

    public int getExpandedComponentIdHint() {
        return this.p.b();
    }

    public c.c.a.c.a.h getHideMotionSpec() {
        return getImpl().g();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f10516f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f10516f;
    }

    public c.c.a.c.w.m getShapeAppearanceModel() {
        c.c.a.c.w.m k = getImpl().k();
        a.h.i.h.a(k);
        return k;
    }

    public c.c.a.c.a.h getShowMotionSpec() {
        return getImpl().l();
    }

    public int getSize() {
        return this.f10518h;
    }

    public int getSizeDimension() {
        return a(this.f10518h);
    }

    @Override // a.h.j.x
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // a.h.j.x
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // a.h.k.m
    public ColorStateList getSupportImageTintList() {
        return this.f10514d;
    }

    @Override // a.h.k.m
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f10515e;
    }

    public boolean getUseCompatPadding() {
        return this.l;
    }

    public void hide(b bVar) {
        a(bVar, true);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().o();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().p();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.j = (sizeDimension - this.k) / 2;
        getImpl().B();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        Rect rect = this.m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        c.c.a.c.p.c cVar = this.p;
        Bundle bundle = extendableSavedState.f10600c.get("expandableWidgetHelper");
        a.h.i.h.a(bundle);
        cVar.a(bundle);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f10600c.put("expandableWidgetHelper", this.p.d());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.n) && !this.n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f10512b != colorStateList) {
            this.f10512b = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f10513c != mode) {
            this.f10513c = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i2 != this.f10519i) {
            this.f10519i = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().e(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f()) {
            getImpl().a(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        this.p.a(i2);
    }

    public void setHideMotionSpec(c.c.a.c.a.h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().A();
            if (this.f10514d != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.o.a(i2);
        e();
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().t();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().t();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().b(z);
    }

    @Override // c.c.a.c.w.p
    public void setShapeAppearanceModel(c.c.a.c.w.m mVar) {
        getImpl().a(mVar);
    }

    public void setShowMotionSpec(c.c.a.c.a.h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(c.c.a.c.a.h.a(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f10519i = 0;
        if (i2 != this.f10518h) {
            this.f10518h = i2;
            requestLayout();
        }
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // a.h.j.x
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // a.h.k.m
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f10514d != colorStateList) {
            this.f10514d = colorStateList;
            e();
        }
    }

    @Override // a.h.k.m
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f10515e != mode) {
            this.f10515e = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().u();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().u();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().u();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.l != z) {
            this.l = z;
            getImpl().q();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public void show(b bVar) {
        b(bVar, true);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public final void c(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.m;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f10516f != colorStateList) {
            this.f10516f = colorStateList;
            getImpl().b(this.f10516f);
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, r), attributeSet, i2);
        this.m = new Rect();
        this.n = new Rect();
        Context context2 = getContext();
        TypedArray c2 = l.c(context2, attributeSet, R$styleable.FloatingActionButton, i2, r, new int[0]);
        this.f10512b = c.c.a.c.t.c.a(context2, c2, R$styleable.FloatingActionButton_backgroundTint);
        this.f10513c = r.a(c2.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.f10516f = c.c.a.c.t.c.a(context2, c2, R$styleable.FloatingActionButton_rippleColor);
        this.f10518h = c2.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.f10519i = c2.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f10517g = c2.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = c2.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = c2.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = c2.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.l = c2.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.k = c2.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        c.c.a.c.a.h a2 = c.c.a.c.a.h.a(context2, c2, R$styleable.FloatingActionButton_showMotionSpec);
        c.c.a.c.a.h a3 = c.c.a.c.a.h.a(context2, c2, R$styleable.FloatingActionButton_hideMotionSpec);
        c.c.a.c.w.m a4 = c.c.a.c.w.m.a(context2, attributeSet, i2, r, c.c.a.c.w.m.m).a();
        boolean z = c2.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(c2.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        c2.recycle();
        h hVar = new h(this);
        this.o = hVar;
        hVar.a(attributeSet, i2);
        this.p = new c.c.a.c.p.c(this);
        getImpl().a(a4);
        getImpl().a(this.f10512b, this.f10513c, this.f10516f, this.f10517g);
        getImpl().b(dimensionPixelSize);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.k);
        getImpl().b(a2);
        getImpl().a(a3);
        getImpl().a(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void a(b bVar, boolean z) {
        getImpl().a(a(bVar), z);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    public class c implements c.c.a.c.v.b {
        public c() {
        }

        @Override // c.c.a.c.v.b
        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.m.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.j, i3 + FloatingActionButton.this.j, i4 + FloatingActionButton.this.j, i5 + FloatingActionButton.this.j);
        }

        @Override // c.c.a.c.v.b
        public void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // c.c.a.c.v.b
        public boolean a() {
            return FloatingActionButton.this.l;
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    @Override // c.c.a.c.p.b
    public boolean a() {
        return this.p.c();
    }

    public final c.c.a.c.q.d b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new e(this, new c());
        }
        return new c.c.a.c.q.d(this, new c());
    }

    public final d.j a(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    public final int a(int i2) {
        int i3 = this.f10519i;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!y.J(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public void a(k<? extends FloatingActionButton> kVar) {
        getImpl().a(new d(kVar));
    }
}
