package com.google.android.material.navigation;

import a.b.e.j.g;
import a.b.f.g0;
import a.h.j.y;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import c.c.a.c.r.e;
import c.c.a.c.r.f;
import c.c.a.c.r.l;
import c.c.a.c.w.h;
import c.c.a.c.w.i;
import c.c.a.c.w.m;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.shix.shixipc.utilcode.MemoryConstants;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    public static final int[] m = {R.attr.state_checked};
    public static final int[] n = {-16842910};
    public static final int o = R$style.Widget_Design_NavigationView;

    /* renamed from: f, reason: collision with root package name */
    public final e f10558f;

    /* renamed from: g, reason: collision with root package name */
    public final f f10559g;

    /* renamed from: h, reason: collision with root package name */
    public c f10560h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10561i;
    public final int[] j;
    public MenuInflater k;
    public ViewTreeObserver.OnGlobalLayoutListener l;

    public class a implements g.a {
        public a() {
        }

        @Override // a.b.e.j.g.a
        public void a(g gVar) {
        }

        @Override // a.b.e.j.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            c cVar = NavigationView.this.f10560h;
            return cVar != null && cVar.a(menuItem);
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.j);
            boolean z = NavigationView.this.j[1] == 0;
            NavigationView.this.f10559g.b(z);
            NavigationView.this.setDrawTopInsetForeground(z);
            Activity a2 = c.c.a.c.r.b.a(NavigationView.this.getContext());
            if (a2 == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            NavigationView.this.setDrawBottomInsetForeground((a2.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(a2.getWindow().getNavigationBarColor()) != 0));
        }
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.k == null) {
            this.k = new a.b.e.g(getContext());
        }
        return this.k;
    }

    public void c(int i2) {
        this.f10559g.c(true);
        getMenuInflater().inflate(i2, this.f10558f);
        this.f10559g.c(false);
        this.f10559g.a(false);
    }

    public MenuItem getCheckedItem() {
        return this.f10559g.a();
    }

    public int getHeaderCount() {
        return this.f10559g.b();
    }

    public Drawable getItemBackground() {
        return this.f10559g.d();
    }

    public int getItemHorizontalPadding() {
        return this.f10559g.e();
    }

    public int getItemIconPadding() {
        return this.f10559g.h();
    }

    public ColorStateList getItemIconTintList() {
        return this.f10559g.k();
    }

    public int getItemMaxLines() {
        return this.f10559g.i();
    }

    public ColorStateList getItemTextColor() {
        return this.f10559g.j();
    }

    public Menu getMenu() {
        return this.f10558f;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.l);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.l);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f10561i), MemoryConstants.GB);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f10561i, MemoryConstants.GB);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f10558f.d(savedState.f10562c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f10562c = bundle;
        this.f10558f.f(bundle);
        return savedState;
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f10558f.findItem(i2);
        if (findItem != null) {
            this.f10559g.a((a.b.e.j.i) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.a(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f10559g.a(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(a.h.b.a.c(getContext(), i2));
    }

    public void setItemHorizontalPadding(int i2) {
        this.f10559g.c(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.f10559g.c(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(int i2) {
        this.f10559g.d(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f10559g.d(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(int i2) {
        this.f10559g.e(i2);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f10559g.a(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.f10559g.f(i2);
    }

    public void setItemTextAppearance(int i2) {
        this.f10559g.g(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f10559g.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(c cVar) {
        this.f10560h = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        f fVar = this.f10559g;
        if (fVar != null) {
            fVar.h(i2);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public Bundle f10562c;

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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10562c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f10562c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    public final Drawable a(g0 g0Var) {
        h hVar = new h(m.a(getContext(), g0Var.g(R$styleable.NavigationView_itemShapeAppearance, 0), g0Var.g(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        hVar.a(c.c.a.c.t.c.a(getContext(), g0Var, R$styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) hVar, g0Var.c(R$styleable.NavigationView_itemShapeInsetStart, 0), g0Var.c(R$styleable.NavigationView_itemShapeInsetTop, 0), g0Var.c(R$styleable.NavigationView_itemShapeInsetEnd, 0), g0Var.c(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    public final boolean b(g0 g0Var) {
        return g0Var.g(R$styleable.NavigationView_itemShapeAppearance) || g0Var.g(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(c.c.a.c.a0.a.a.b(context, attributeSet, i2, o), attributeSet, i2);
        ColorStateList a2;
        int i3;
        boolean z;
        this.f10559g = new f();
        this.j = new int[2];
        Context context2 = getContext();
        this.f10558f = new e(context2);
        g0 d2 = l.d(context2, attributeSet, R$styleable.NavigationView, i2, o, new int[0]);
        if (d2.g(R$styleable.NavigationView_android_background)) {
            y.a(this, d2.b(R$styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            h hVar = new h();
            if (background instanceof ColorDrawable) {
                hVar.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            hVar.a(context2);
            y.a(this, hVar);
        }
        if (d2.g(R$styleable.NavigationView_elevation)) {
            setElevation(d2.c(R$styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(d2.a(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.f10561i = d2.c(R$styleable.NavigationView_android_maxWidth, 0);
        if (d2.g(R$styleable.NavigationView_itemIconTint)) {
            a2 = d2.a(R$styleable.NavigationView_itemIconTint);
        } else {
            a2 = a(R.attr.textColorSecondary);
        }
        if (d2.g(R$styleable.NavigationView_itemTextAppearance)) {
            i3 = d2.g(R$styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            i3 = 0;
            z = false;
        }
        if (d2.g(R$styleable.NavigationView_itemIconSize)) {
            setItemIconSize(d2.c(R$styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList a3 = d2.g(R$styleable.NavigationView_itemTextColor) ? d2.a(R$styleable.NavigationView_itemTextColor) : null;
        if (!z && a3 == null) {
            a3 = a(R.attr.textColorPrimary);
        }
        Drawable b2 = d2.b(R$styleable.NavigationView_itemBackground);
        if (b2 == null && b(d2)) {
            b2 = a(d2);
        }
        if (d2.g(R$styleable.NavigationView_itemHorizontalPadding)) {
            this.f10559g.c(d2.c(R$styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int c2 = d2.c(R$styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(d2.d(R$styleable.NavigationView_itemMaxLines, 1));
        this.f10558f.a(new a());
        this.f10559g.b(1);
        this.f10559g.a(context2, this.f10558f);
        this.f10559g.a(a2);
        this.f10559g.h(getOverScrollMode());
        if (z) {
            this.f10559g.g(i3);
        }
        this.f10559g.b(a3);
        this.f10559g.a(b2);
        this.f10559g.d(c2);
        this.f10558f.a(this.f10559g);
        addView((View) this.f10559g.a((ViewGroup) this));
        if (d2.g(R$styleable.NavigationView_menu)) {
            c(d2.g(R$styleable.NavigationView_menu, 0));
        }
        if (d2.g(R$styleable.NavigationView_headerLayout)) {
            b(d2.g(R$styleable.NavigationView_headerLayout, 0));
        }
        d2.b();
        a();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f10558f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f10559g.a((a.b.e.j.i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public View b(int i2) {
        return this.f10559g.a(i2);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void a(a.h.j.g0 g0Var) {
        this.f10559g.a(g0Var);
    }

    public final ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList b2 = a.b.b.a.a.b(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = b2.getDefaultColor();
        return new ColorStateList(new int[][]{n, m, FrameLayout.EMPTY_STATE_SET}, new int[]{b2.getColorForState(n, defaultColor), i3, defaultColor});
    }

    public final void a() {
        this.l = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
    }
}
